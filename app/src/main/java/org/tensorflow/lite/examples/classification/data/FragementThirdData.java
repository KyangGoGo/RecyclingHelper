package org.tensorflow.lite.examples.classification.data;

import android.os.Environment;
import android.util.Log;

import java.io.File;

public class FragementThirdData {

    private String questions;
    private String answer;


    public FragementThirdData(String questions, String answer) {
        this.questions = questions;
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }
}
