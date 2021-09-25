package org.tensorflow.lite.examples.classification.customdialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import org.tensorflow.lite.examples.classification.R;
import org.tensorflow.lite.examples.classification.data.Data;

public class CustomDialog extends Dialog {

    private String text;
    private ImageView itemImage;
    private TextView itemClassification,
        itemDischargeDay,
        itemExplanation;

    private StringBuffer explanation = new StringBuffer("\n");

    public CustomDialog(@NonNull Context context, String text){
        super(context);
        this.text = text;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.custom_dialog);

        itemImage = findViewById(R.id.dialog_image);
        itemClassification = findViewById(R.id.select_classification);
        itemDischargeDay = findViewById(R.id.select_discharge_day);
        itemExplanation = findViewById(R.id.select_explanation);

        Data data = Data.getInstance(text);

        if(data != null) {
            itemImage.setImageResource(data.getImage());
            itemClassification.setText(data.getClassification());
            itemDischargeDay.setText(data.getDischarge_day_text());
            for(String tmp : data.getExplanation()) explanation.append("  ").append(tmp).append("\n");
            itemExplanation.setText(explanation);
        }
        else{
            itemImage.setImageResource(R.drawable.recycle);
            itemClassification.setText("결과x");
            itemDischargeDay.setText("결과x");
            itemExplanation.setText("결과x");
        }
    }
}
