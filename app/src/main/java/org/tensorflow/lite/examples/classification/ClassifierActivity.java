/*
 * Copyright 2019 The TensorFlow Authors. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.tensorflow.lite.examples.classification;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.media.ImageReader.OnImageAvailableListener;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Size;
import android.util.TypedValue;
import android.widget.ImageView;
import android.widget.Toast;

import org.tensorflow.lite.examples.classification.customdialog.CustomDialog;
import org.tensorflow.lite.examples.classification.customview.OverlayView;
import org.tensorflow.lite.examples.classification.env.BorderedText;
import org.tensorflow.lite.examples.classification.env.ImageUtils;
import org.tensorflow.lite.examples.classification.env.Logger;
import org.tensorflow.lite.examples.classification.tflite.Classifier;
import org.tensorflow.lite.examples.classification.tflite.Classifier.Device;
import org.tensorflow.lite.examples.classification.tflite.Detector;
import org.tensorflow.lite.examples.classification.tflite.DetectorFactory;
import org.tensorflow.lite.examples.classification.tflite.YoloV5Detector;
import org.tensorflow.lite.examples.classification.tracking.MultiBoxTracker;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class ClassifierActivity extends CameraActivity implements OnImageAvailableListener {
  private static final Logger LOGGER = new Logger();

  private static final DetectorMode MODE = DetectorMode.TF_OD_API;
  private static final boolean MAINTAIN_ASPECT = true;
  private static final Size DESIRED_PREVIEW_SIZE = new Size(640, 480);
  private static final float TEXT_SIZE_DIP = 10;
  private static final boolean SAVE_PREVIEW_BITMAP = false;
  private static final float MINIMUM_CONFIDENCE_TF_OD_API = 0.3f;
  OverlayView trackingOverlay;


  private Bitmap rgbFrameBitmap = null;
  private Bitmap croppedBitmap = null;
  private Bitmap cropCopyBitmap = null;

  private long lastProcessingTimeMs;
  private Integer sensorOrientation;
  private Classifier classifier;
  private BorderedText borderedText;
  /** Input image size of the model along x axis. */
  private int imageSizeX;
  /** Input image size of the model along y axis. */
  private int imageSizeY;

  private Matrix frameToCropTransform;
  private Matrix cropToFrameTransform;

  private MultiBoxTracker tracker;

  private YoloV5Detector detector;
  private long timestamp = 0;
  private boolean computingDetection = false;

  @Override
  protected int getLayoutId() {
    return R.layout.camera_connection_fragment;
  }

  @Override
  protected Size getDesiredPreviewFrameSize() {
    return DESIRED_PREVIEW_SIZE;
  }

  @Override
  public void onPreviewSizeChosen(final Size size, final int rotation) {
    final float textSizePx =
            TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP, TEXT_SIZE_DIP, getResources().getDisplayMetrics());
    borderedText = new BorderedText(textSizePx);
    borderedText.setTypeface(Typeface.MONOSPACE);

    recreateClassifier(getDevice(), getNumThreads());
    if (classifier == null) {
      LOGGER.e("No classifier on preview!");
      return;
    }

    previewWidth = size.getWidth();
    previewHeight = size.getHeight();

    sensorOrientation = rotation - getScreenOrientation();
    LOGGER.i("Camera orientation relative to screen canvas: %d", sensorOrientation);

    LOGGER.i("Initializing at size %dx%d", previewWidth, previewHeight);
    rgbFrameBitmap = Bitmap.createBitmap(previewWidth, previewHeight, Config.ARGB_8888);
  }

  @Override
  protected void processImage() {
    rgbFrameBitmap.setPixels(getRgbBytes(), 0, previewWidth, 0, 0, previewWidth, previewHeight);
    final int cropSize = Math.min(previewWidth, previewHeight);

    runInBackground(
            new Runnable() {
              @Override
              public void run() {
                if (classifier != null) {
                  final long startTime = SystemClock.uptimeMillis();
                  final List<Classifier.Recognition> results =
                          classifier.recognizeImage(rgbFrameBitmap, sensorOrientation);
                  lastProcessingTimeMs = SystemClock.uptimeMillis() - startTime;
                  LOGGER.v("Detect: %s", results);


                  runOnUiThread(
                          new Runnable() {
                            @Override
                            public void run() {
                              showResultsInBottomSheet(results);
                              showFrameInfo(previewWidth + "x" + previewHeight);
                              showCropInfo(imageSizeX + "x" + imageSizeY);
                              showCameraResolution(cropSize + "x" + cropSize);
                              showRotationInfo(String.valueOf(sensorOrientation));
                              showInference(lastProcessingTimeMs + "ms");
                            }
                          });
                }
                readyForNextImage();
              }
            });
  }

  @Override
  protected void onInferenceConfigurationChanged() {
    if (rgbFrameBitmap == null) {
      // Defer creation until we're getting camera frames.
      return;
    }
    final Device device = getDevice();
    final int numThreads = getNumThreads();
    runInBackground(() -> recreateClassifier(device, numThreads));
  }

  @Override
  protected void runYolov5(Intent intent,Activity activity) {

    rgbFrameBitmap.setPixels(getRgbBytes(), 0, previewWidth, 0, 0, previewWidth, previewHeight);

    readyForNextImage();

    final Canvas canvas = new Canvas(croppedBitmap);
    canvas.drawBitmap(rgbFrameBitmap, frameToCropTransform, null);
    // For examining the actual TF input.
    if (SAVE_PREVIEW_BITMAP) {
      ImageUtils.saveBitmap(croppedBitmap);
    }
    BackgroundTask backgroundTask=new BackgroundTask(intent,activity);
    backgroundTask.execute();
  }

  @Override
  protected void initYolov5() {
    final String modelString = "yolov5s-fp16.tflite";

    try {
      detector = DetectorFactory.getDetector(getAssets(), modelString);
    } catch (IOException e) {
      e.printStackTrace();
      LOGGER.e(e, "Exception initializing classifier!");
      Toast toast =
              Toast.makeText(
                      getApplicationContext(), "Classifier could not be initialized", Toast.LENGTH_SHORT);
      toast.show();
      finish();
    }

    int cropSize = detector.getInputSize();

    croppedBitmap = Bitmap.createBitmap(cropSize, cropSize, Config.ARGB_8888);

    frameToCropTransform =
            ImageUtils.getTransformationMatrix(
                    previewWidth, previewHeight,
                    cropSize, cropSize,
                    sensorOrientation, MAINTAIN_ASPECT);

    cropToFrameTransform = new Matrix();
    frameToCropTransform.invert(cropToFrameTransform);
  }

  private void recreateClassifier(Device device, int numThreads) {
    if (classifier != null) {
      LOGGER.d("Closing classifier.");
      classifier.close();
      classifier = null;
    }
    try {
      LOGGER.d(
          "Creating classifier (device=%s, numThreads=%d)", device, numThreads);
      classifier = Classifier.create(this, device, numThreads);
    } catch (IOException e) {
      LOGGER.e(e, "Failed to create classifier.");
    }

    // Updates the input image size.
    imageSizeX = classifier.getImageSizeX();
    imageSizeY = classifier.getImageSizeY();
  }

  private enum DetectorMode {
    TF_OD_API;
  }

  class BackgroundTask extends AsyncTask<Long, Bitmap, Bitmap> {
    private Activity activity;
    private Intent intent;

    public BackgroundTask(Intent intent,Activity activity) {
      super();
      this.activity=activity;
      this.intent=intent;
    }

    @Override
    protected Bitmap doInBackground(Long... longs) {
      final long startTime = SystemClock.uptimeMillis();
      final List<Detector.Recognition> results = detector.recognizeImage(croppedBitmap);
      lastProcessingTimeMs = SystemClock.uptimeMillis() - startTime;

      cropCopyBitmap = Bitmap.createBitmap(croppedBitmap);
      final Canvas canvas = new Canvas(cropCopyBitmap);
      final Paint paint = new Paint();
      paint.setColor(Color.RED);
      paint.setStyle(Paint.Style.STROKE);
      paint.setStrokeWidth(10.0f);
      paint.setStrokeCap(Paint.Cap.ROUND);
      paint.setStrokeJoin(Paint.Join.ROUND);
      paint.setStrokeMiter(100);


      final float textSizePx =
              TypedValue.applyDimension(
                      TypedValue.COMPLEX_UNIT_DIP, TEXT_SIZE_DIP, getResources().getDisplayMetrics());
      Paint interiorPaint = new Paint();
      interiorPaint.setTextSize(textSizePx);
      interiorPaint.setColor(Color.WHITE);
      interiorPaint.setStyle(Paint.Style.FILL);
      interiorPaint.setAntiAlias(false);
      interiorPaint.setAlpha(255);

      float minimumConfidence = MINIMUM_CONFIDENCE_TF_OD_API;
      switch (MODE) {
        case TF_OD_API:
          minimumConfidence = MINIMUM_CONFIDENCE_TF_OD_API;
          break;
      }

      for (final Detector.Recognition result : results) {
        final RectF location = result.getLocation();
        float cornerSize = Math.min(location.width(), location.height()) / 8.0f;

        final String labelString =
                !TextUtils.isEmpty(result.getTitle())
                        ? String.format("%s ", result.getTitle())
                        : String.format("%.2f", (100 * result.getConfidence()));
        if (location != null && result.getConfidence() >= minimumConfidence) {
          canvas.drawRoundRect(location, cornerSize, cornerSize, paint);
          canvas.drawText(labelString, location.left+cornerSize, (location.top+textSizePx), interiorPaint);
        }
      }
      LOGGER.d("doInBackground 실행");
      return cropCopyBitmap;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
      super.onPostExecute(bitmap);
      ByteArrayOutputStream stream = new ByteArrayOutputStream();
      bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
      byte[] byteArray = stream.toByteArray();
      intent.putExtra("yolov5Bitmap", byteArray);

      activity.startActivity(intent);
      LOGGER.d("onPostExecute 실행");
    }
  }
}
