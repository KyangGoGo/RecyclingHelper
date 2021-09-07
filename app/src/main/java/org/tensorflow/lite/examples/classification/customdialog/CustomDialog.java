package org.tensorflow.lite.examples.classification.customdialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;

import org.tensorflow.lite.examples.classification.R;

public class CustomDialog extends Dialog {

    private String text;

    public CustomDialog(@NonNull Context context, String text){
        super(context);
        this.text = text;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.dialog01);

        TextView dialogText = findViewById(R.id.dialogText);
        dialogText.setText(text);
    }
}
