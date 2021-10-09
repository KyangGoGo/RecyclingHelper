package org.tensorflow.lite.examples.classification.customdialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;

import org.tensorflow.lite.examples.classification.R;

public class SeparationDialog extends Dialog {

    private String topPercentItem;

    public SeparationDialog(@NonNull Context context, String topPercentItem){
        super(context);
        this.topPercentItem = topPercentItem;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.serparation_dialog);

    }
}
