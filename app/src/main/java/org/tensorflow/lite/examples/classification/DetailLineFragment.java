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

public class DetailLineFragment extends Fragment {

    private ViewGroup rootView;
    private LinearLayout productLine;
    private TextView lineText;
    private int size = 400; //default 값
    private Data data;
    private int divisor = 5760;

    public DetailLineFragment(Data data){
        this.data = data;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = (ViewGroup) inflater.inflate(
                R.layout.detail_line_fragment, container, false);

        //최고 layout
        productLine = rootView.findViewById(R.id.product_line);

        lineText = rootView.findViewById(R.id.line_text);
        lineText.setText("품목별 분리배출 방법");

        //화면 비율에 맞춰 size 크기 조정
        size = Data.getScreenSize(getActivity(), divisor);

        if(data != null){
            int len = data.getLineProduct().length;
            for(int i=0; i<len; i++) {
                addLine(data.getLineProduct()[i],
                        data.getLineImage()[i],
                        data.getLineExplanation()[i]);
            }
        }
        return rootView;
    }

    // 종류별 관련 아이템들 셋팅
    private void addLine(String lineName, Integer lineImage, String lineExplanation){
        LinearLayout.LayoutParams productWrapParam =
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        ViewGroup.LayoutParams productExplanationAndImageParam =
                new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams productExplanationParam =
                new LinearLayout.LayoutParams(
                        size, size);
        LinearLayout.LayoutParams blankParam =
                new LinearLayout.LayoutParams(0,0, 1.0f);

        //margin 셋팅
        productWrapParam.setMargins(0,10,0,20);
        productExplanationParam.setMargins(0,0,0,10);

        //가로세로 정렬 및 param 셋팅
        LinearLayout productWrap = new LinearLayout(getContext());
        productWrap.setOrientation(LinearLayout.VERTICAL);
        productWrap.setLayoutParams(productWrapParam);

        LinearLayout productExplanationAndImage = new LinearLayout(getContext());
        productExplanationAndImage.setOrientation(LinearLayout.HORIZONTAL);
        productExplanationAndImage.setLayoutParams(productExplanationAndImageParam);

        //설명과 이미지 사이 공백을 위한 것
        LinearLayout blankLayout = new LinearLayout(getContext());
        blankLayout.setLayoutParams(blankParam);

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
        productExplanation.setTextSize(15);
        productExplanation.setTextColor(Color.BLACK);
        productExplanation.setBackgroundResource(R.drawable.table_border);
        productExplanation.setLayoutParams(productExplanationParam);
        productExplanation.setPadding(10,10,10,10);

        //레이아웃에 추가
        productWrap.addView(productName);
        productExplanationAndImage.addView(productExplanation);
        productExplanationAndImage.addView(blankLayout);
        productExplanationAndImage.addView(productImage);
        productWrap.addView(productExplanationAndImage);

        productLine.addView(productWrap);
    }
}