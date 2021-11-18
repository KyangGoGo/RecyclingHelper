package org.tensorflow.lite.examples.classification.tflite;

import android.content.res.AssetManager;

import java.io.IOException;

public class DetectorFactory {
    public static YoloV5Detector getDetector(
            final AssetManager assetManager,
            final String modelFilename)
            throws IOException {
        String labelFilename = "file:///android_asset/coco.txt";
        boolean isQuantized = false;
        int inputSize = 640;

        return YoloV5Detector.create(assetManager, modelFilename, labelFilename, isQuantized,
                inputSize);
    }

}
