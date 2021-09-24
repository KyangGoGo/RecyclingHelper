package org.tensorflow.lite.examples.classification.data;

import org.tensorflow.lite.examples.classification.R;

public class Styrofoam extends Data {
    public static final String classification = "폐스티로폼";
    public static final String discharge_day = "매일";
    public static final String[] explanation = {
            "스티로폼 상자의 내용물을 깨끗이 비우고 이물질 제거 후 배출",
            "음식물 등 이물질이 묻은 스티로폼은 흰색 종량제 봉투로 배출"
    };
    public static final String additionalExplanation = "";
    public static final Integer image = R.drawable.logo_styrofoam;
    public static final String[] lineProduct = {
            "폐스티로폼"
    };
    public static final Integer[] lineImage = {
            R.drawable.detail_styrofaom
    };
    public static final String[] lineExplanation = {
            "스티로폼 상자의 내용물을 깨끗이 비우고 이물질 제거 후 배출\n" +
                    "음식물 등 이물질이 묻은 스티로폼은 가연성 흰색 종량제 봉투로 배출\n" +
                    "※ 단, 건축용 자재로 쓰인 내연재, 공작용 우드락 재질로 된 것은 가연성 쓰레기로 배출하여 주시기 바랍니다."
    };
    public static final String warningText = "";
    public static final String[] warningContent = {};
    public static final Integer[][] warningImage = {{}};
    public static final String[][] warningMessage = {{}};

    public Styrofoam() {
        super(classification, discharge_day, explanation, additionalExplanation, image, lineProduct, lineImage, lineExplanation, warningText, warningContent, warningImage, warningMessage);
    }
}
