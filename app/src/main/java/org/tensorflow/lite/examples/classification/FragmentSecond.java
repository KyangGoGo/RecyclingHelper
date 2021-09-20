package org.tensorflow.lite.examples.classification;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import org.tensorflow.lite.examples.classification.data.Data;

public class FragmentSecond extends Fragment {

    private String title;
    private String waring = "주의!\n";
    private TextView warningText;
    private LinearLayout warningBody;
    private int size = 300;
    int divisor = 5707; //제수

    public FragmentSecond(String title) {
        this.title = title;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_2p, container, false);

        warningText = rootView.findViewById(R.id.warning_text);
        warningBody = rootView.findViewById(R.id.warning_body);

        warningBody.setPadding(10,20,20,10);

        size = Data.getScreenSize(getActivity(), divisor);

        int findItem = Data.findItem(title);

        if (findItem != -1) {
            warningText.setText(waring + Data.warningText[findItem]);
            addWarningLine(findItem);
        } else {
            warningText.setText("데이터 없음");
        }


        return rootView;
    }


    private void addWarningLine(Integer findItem) {
        LinearLayout.LayoutParams warnItemParam =
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams addItemParam =
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams lineWrapParam =
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams sortParam =
                new LinearLayout.LayoutParams(0,0, 1.0f);


        for (int i = 0; i < Data.warningImage[findItem].length; i++) {
            //경고창 내부 layout 설정
            LinearLayout lineWrap = new LinearLayout(getContext());
            lineWrap.setOrientation(LinearLayout.VERTICAL);
            lineWrapParam.setMargins(0,0,0,20);
            lineWrap.setLayoutParams(lineWrapParam);

            //경고 title 셋팅
            TextView wrapContent = new TextView(getContext());
            Typeface bold = Typeface.defaultFromStyle(Typeface.BOLD);
            wrapContent.setTypeface(bold);
            wrapContent.setTextSize(15);
            wrapContent.setText((i+1)+". "+Data.waringContent[findItem][i]);
            lineWrap.addView(wrapContent);

            GridLayout warnItem = new GridLayout(getContext());
            warnItem.setColumnCount(2);
            warnItem.setOrientation(GridLayout.HORIZONTAL);
            warnItem.setLayoutParams(warnItemParam);

            //경고에 포함되는 이미지 및 텍스트 셋팅
            for (int j = 0; j < Data.warningImage[findItem][i].length; j++) {
                //박스 생성
                LinearLayout addItem = new LinearLayout(getContext());
                addItem.setOrientation(LinearLayout.VERTICAL);
                addItem.setLayoutParams(addItemParam);
                //이미지 생성
                ImageView warnImage = new ImageView(getContext());
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), Data.warningImage[findItem][i][j]);
                bitmap = Bitmap.createScaledBitmap(bitmap, size, size, true);
                warnImage.setImageBitmap(bitmap);
                //텍스트 생성
                TextView warnText = new TextView(getContext());
                warnText.setText(Data.warningMessage[findItem][i][j]);
                //박스에 이미지 및 텍스트 추가
                addItem.addView(warnImage);
                addItem.addView(warnText);
                warnItem.addView(addItem);
                // 경고 라인에 추가
            }
            lineWrap.addView(warnItem);
            warningBody.addView(lineWrap);
        }
    }
}