package org.tensorflow.lite.examples.classification.data;

import org.tensorflow.lite.examples.classification.R;

public class Battery extends Data2 {
    public static final String classification = "폐전지";
    public static final String discharge_day = "매일";
    public static final String[] explanation = {
            "전용수거함에 배출",
            "전지는 제품에서 분리하여 배출"
    };
    public static final String additionalExplanation = "";
    public static final Integer image = R.drawable.logo_battery;
    public static final String[] lineProduct = {
            "건전지, 충전용 전지"
    };
    public static final Integer[] lineImage = {
            R.drawable.detail_battery
    };
    public static final String[] lineExplanation = {
            "전지는 제품에서 분리하여 배출\n" +
                    "주요 거점(읍·면·동·아파트 공동주택 등의 폐형광등·폐전지 일체함 또는 클린하우스·재활용도움센터 등)의 전용수거함에 배출"
    };
    public static final String warningText = "";
    public static final String[] warningContent = {};
    public static final Integer[][] warningImage = {{}};
    public static final String[][] warningMessage = {{}};

    public Battery() {
        super(classification, discharge_day, explanation, additionalExplanation, image, lineProduct, lineImage, lineExplanation, warningText, warningContent, warningImage, warningMessage);
    }
}
