package org.tensorflow.lite.examples.classification.data;

import android.app.Activity;
import android.graphics.Point;
import android.view.Display;

public class Data {
    private final String classification;
    private final String discharge_day;
    private final String[] explanation;
    private final String additionalExplanation;
    private final Integer image;
    private final String[] lineProduct;
    private final Integer[] lineImage;
    private final String[] lineExplanation;
    private final String warningText;
    private final String[] warningContent;
    private final Integer[][] warningImage;
    private final String[][] warningMessage;

    public static Integer viewPage = 3;

    public Data(String classification,
                String discharge_day,
                String[] explanation,
                String additionalExplanation,
                Integer image,
                String[] lineProduct,
                Integer[] lineImage,
                String[] lineExplanation,
                String warningText,
                String[] warningContent,
                Integer[][] warningImage,
                String[][] warningMessage) {
        this.classification = classification;
        this.discharge_day = discharge_day;
        this.explanation = explanation;
        this.additionalExplanation = additionalExplanation;
        this.image = image;
        this.lineProduct = lineProduct;
        this.lineImage = lineImage;
        this.lineExplanation = lineExplanation;
        this.warningText = warningText;
        this.warningContent = warningContent;
        this.warningImage = warningImage;
        this.warningMessage = warningMessage;
    }

    public static Data getInstance(String text){
        switch (text){
            case "고철":
                return new Can();
            case "비닐":
                return new PlasticBag();
            case "스티로폼":
                return new Styrofoam();
            case "유리병":
                return new Glass();
            case "종이":
                return new Paper();
            case "캔류":
                return new Can();
            case "폐전지":
                return new Battery();
            case "플라스틱류":
                return new Plastic();
            case "형광등":
                return new Lamp();
        }
        return null;
    }


    public String getClassification() {
        return classification;
    }

    public String getDischarge_day() {
        return discharge_day;
    }

    public String[] getExplanation() {
        return explanation;
    }

    public String getAdditionalExplanation() {
        return additionalExplanation;
    }

    public Integer getImage() {
        return image;
    }

    public String[] getLineProduct() {
        return lineProduct;
    }

    public Integer[] getLineImage() {
        return lineImage;
    }

    public String[] getLineExplanation() {
        return lineExplanation;
    }

    public String getWarningText() {
        return warningText;
    }

    public String[] getWarningContent() {
        return warningContent;
    }

    public Integer[][] getWarningImage() {
        return warningImage;
    }

    public String[][] getWarningMessage() {
        return warningMessage;
    }

    public static int getScreenSize(Activity activity, int divisor){
        Display display = activity.getWindowManager().getDefaultDisplay();
        Point screenSize = new Point();
        display.getSize(screenSize);
        int mul = screenSize.x * screenSize.y;
        return (int)(mul/ divisor);
    }
}
