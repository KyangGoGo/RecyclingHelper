package org.tensorflow.lite.examples.classification;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import org.tensorflow.lite.examples.classification.data.Data;

public class FragmentFirst extends Fragment {

    private ViewGroup rootView;
    private LinearLayout productLine;
    private int size = 350;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_1p, container, false);

        //최고 layout
        productLine = rootView.findViewById(R.id.product_line);

        int len = Data.paperProduct.length;

        for(int i=0; i<len; i++){
            addLine(Data.paperProduct[i], Data.paperImage[i], Data.paperExplanation[i]);
        }

        return rootView;
    }

    private void addLine(String lineName, Integer lineImage, String lineExplanation){

//        ViewGroup.LayoutParams productNameParam =
//                new ViewGroup.LayoutParams(
//                        ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        ViewGroup.LayoutParams productExplanationParam =
                new ViewGroup.LayoutParams(
                        size, size);

        LinearLayout productWrap = new LinearLayout(getContext());
        productWrap.setOrientation(LinearLayout.VERTICAL);

        LinearLayout productExplanationAndImage = new LinearLayout(getContext());
        productExplanationAndImage.setOrientation(LinearLayout.HORIZONTAL);
        
        //실제 값 셋팅
        TextView productName = new TextView(getContext());
        productName.setText(lineName);
        Typeface bold = Typeface.defaultFromStyle(Typeface.BOLD);
        productName.setTypeface(bold);
        productName.setTextSize(20);
        //productName.setLayoutParams(productNameParam);

        ImageView productImage = new ImageView(getContext());
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), lineImage);
        bitmap = Bitmap.createScaledBitmap(bitmap, size, size, true);
        productImage.setImageBitmap(bitmap);

        TextView productExplanation = new TextView(getContext());
        productExplanation.setText(lineExplanation);
        productExplanation.setBackgroundResource(R.drawable.table_border);
        productExplanation.setLayoutParams(productExplanationParam);

        //레이아웃에 추가
        productWrap.addView(productName);
        productExplanationAndImage.addView(productExplanation);
        productExplanationAndImage.addView(productImage);
        productWrap.addView(productExplanationAndImage);

        productLine.addView(productWrap);

    }
}