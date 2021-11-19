package org.tensorflow.lite.examples.classification;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import org.tensorflow.lite.examples.classification.data.Data;

public class DetailYoloFragment extends Fragment {

    private Data data;
    private ViewGroup rootView;
    private TextView yoloText;
    private Bitmap bitmap;
    private ImageView yoloImage;

    public DetailYoloFragment(Data data, Bitmap bitmap){
        this.data = data;
        this.bitmap = bitmap;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = (ViewGroup) inflater.inflate(
                R.layout.detail_yolo_fragment, container, false);

        yoloText = rootView.findViewById(R.id.yolo_text);
        yoloText.setText("플라스틱 이물질 제거 안내");

        yoloImage = rootView.findViewById(R.id.yolo_image);
        yoloImage.setImageBitmap(bitmap);

        return rootView;
    }

}