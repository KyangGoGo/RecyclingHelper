package org.tensorflow.lite.examples.classification.customdialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import org.tensorflow.lite.examples.classification.R;
import org.tensorflow.lite.examples.classification.data.Data;
import org.tensorflow.lite.examples.classification.data.Data2;

public class CustomDialog extends Dialog {

    private String text;
    private ImageView item_image;
    private TextView dialogText,
        item_classification, item_discharge_day,
        item_explanation;

    private StringBuffer explanation = new StringBuffer();

    public CustomDialog(@NonNull Context context, String text){
        super(context);
        this.text = text;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.custom_dialog);

        item_image = findViewById(R.id.dialog_image);
        dialogText = findViewById(R.id.dialog_text);
        item_classification = findViewById(R.id.select_classification);
        item_discharge_day = findViewById(R.id.select_discharge_day);
        item_explanation = findViewById(R.id.select_explanation);

        dialogText.setText(text);

        Data2 data2 = Data2.getInstance(text);
        if(data2 != null) {
            item_image.setImageResource(data2.getImage());
            item_classification.setText(data2.getClassification());
            item_discharge_day.setText(data2.getDischarge_day());
            for(String tmp : data2.getExplanation()) explanation.append(tmp).append("\n");
            item_explanation.setText(explanation);
        }
        else{
            item_image.setImageResource(R.drawable.recycle);
            item_classification.setText("결과x");
            item_discharge_day.setText("결과x");
            item_explanation.setText("결과x");
        }

//        int getItemLocation = Data.findItem(text);
//
//        if(getItemLocation != -1){
//            item_image.setImageResource(Data.images[getItemLocation]);
//            item_classification.setText(Data.classification[getItemLocation]);
//            item_discharge_day.setText(Data.discharge_day[getItemLocation]);
//            item_explanation.setText(Data.explanation[getItemLocation]);
//        }else{
//            item_image.setImageResource(R.drawable.recycle);
//            item_classification.setText("결과x");
//            item_discharge_day.setText("결과x");
//            item_explanation.setText("결과x");
//        }
    }
}
