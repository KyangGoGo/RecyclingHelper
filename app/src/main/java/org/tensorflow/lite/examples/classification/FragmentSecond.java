package org.tensorflow.lite.examples.classification;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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


        for (int i = 0; i < Data.warningImage[findItem].length; i++) {
            LinearLayout lineWrap = new LinearLayout(getContext());
            lineWrap.setOrientation(LinearLayout.VERTICAL);
            lineWrap.setBackgroundColor(Color.GRAY);
            TextView wrapContent = new TextView(getContext());
            wrapContent.setText(Data.waringContent[findItem][i]);
            lineWrap.addView(wrapContent);
            for (int j = 0; j < Data.warningImage[findItem][i].length; j++) {
                // 박스 생성
                LinearLayout warnItem = new LinearLayout(getContext());
                warnItem.setOrientation(LinearLayout.VERTICAL);
                // 이미지 생성
                ImageView warnImage = new ImageView(getContext());
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), Data.warningImage[findItem][i][j]);
                bitmap = Bitmap.createScaledBitmap(bitmap, 250, 250, true);
                warnImage.setImageBitmap(bitmap);
                // 텍스트 생성
                TextView warnText = new TextView(getContext());
                warnText.setText(Data.warningMessage[findItem][i][j]);

                //박스에 이미지 및 텍스트 추가
                warnItem.addView(warnImage);
                warnItem.addView(warnText);

                // 경고 라인에 추가
                lineWrap.addView(warnItem);
            }
            warningBody.addView(lineWrap);
        }
    }
}