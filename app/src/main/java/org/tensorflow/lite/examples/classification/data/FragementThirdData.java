package org.tensorflow.lite.examples.classification.data;

public class FragementThirdData {

    private String questions;

    public FragementThirdData(String questions, String answer) {
        this.questions = questions;
        this.answer = answer;
    }

    private String answer;

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
