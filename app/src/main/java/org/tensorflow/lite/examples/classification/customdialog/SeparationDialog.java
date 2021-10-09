package org.tensorflow.lite.examples.classification.customdialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;

import org.tensorflow.lite.examples.classification.R;

public class SeparationDialog extends Dialog {


    public SeparationDialog(@NonNull Context context){
        super(context);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.serparation_dialog);

    }
}
