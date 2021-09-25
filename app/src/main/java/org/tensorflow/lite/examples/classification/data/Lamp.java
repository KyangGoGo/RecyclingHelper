package org.tensorflow.lite.examples.classification.data;

import org.tensorflow.lite.examples.classification.R;

public class Lamp extends Data {
    public static final String classification = "형광등";
    public static final String discharge_day_text = "매일";
    public static final Integer[] discharge_day_images = {
            R.drawable.detail_icon_sun
    };
    public static final String[] explanation = {
            "폐형광등 전용수거함 또는 구매업체에 배출",
            "깨지지 않도록 주의하여 배출"
    };
    public static final String additionalExplanation = "";
    public static final Integer image = R.drawable.logo_battery;
    public static final String[] lineProduct = {
            "형광등"
    };
    public static final Integer[] lineImage = {
            R.drawable.detail_lamp
    };
    public static final String[] lineExplanation = {
            "폐형광등 전용수거함 또는 구매업체에 배출\n" +
                    "깨지지 않도록 주의하여 배출"
    };
    public static final String warningText = "불연성 전용 PP마대로 배출해주세요";
    public static final String[] warningContent = {
            "재활용이 되지 않는 전구",
            "깨진 형광등"
    };
    public static final Integer[][] warningImage = {
            {R.drawable.warning_incandescent_lamp, R.drawable.warning_led_lamp},
            {R.drawable.warning_broken_lamp}
    };
    public static final String[][] warningMessage = {
            {"백열전구", "LED전구"},
            {"깨진 형광등"}
    };

    public Lamp() {
        super(classification,
                discharge_day_text,
                discharge_day_images,
                explanation,
                additionalExplanation,
                image,
                lineProduct,
                lineImage,
                lineExplanation,
                warningText,
                warningContent,
                warningImage,
                warningMessage);
    }
}
