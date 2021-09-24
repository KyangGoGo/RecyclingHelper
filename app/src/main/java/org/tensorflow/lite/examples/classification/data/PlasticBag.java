package org.tensorflow.lite.examples.classification.data;

import org.tensorflow.lite.examples.classification.R;

public class PlasticBag extends Data {
    public static final String classification = "비닐류";
    public static final String discharge_day = "목, 일";
    public static final String[] explanation = {
            "투명 비닐 봉투에 넣어 재활용품으로 배출",
            "이물질이 묻은 경우 깨끗이 씻어서 배출"
    };
    public static final String additionalExplanation = "";
    public static final Integer image = R.drawable.logo_plastic_bag;
    public static final String[] lineProduct = {
            "과자, 라면, 빵 봉지, 1회용 비닐 봉투 등 모든 비닐"
    };
    public static final Integer[] lineImage = {
            R.drawable.detail_plastic_bag
    };
    public static final String[] lineExplanation = {
            "투명 비닐봉투에 넣어 재활용품으로 배출\n" +
                    "음식물 등 이물질이 묻은 경우 깨끗이 씻어서 배출\n" +
                    "이물질 제거가 어려운 경우는 가연성 흰색 종량제 봉투에 배출"
    };
    public static final String warningText = "재활용되지 않습니다.";
    public static final String[] warningContent = {
            "얼음팩",
            "홉합재질봉투"
    };
    public static final Integer[][] warningImage = {
            //비닐류
            {R.drawable.warning_ice_pack},
            {R.drawable.warning_mixed_plastic_bag}
    };
    public static final String[][] warningMessage = {
            //비닐류
            {"얼음팩"},
            {"혼합재질봉투"}
    };

    public PlasticBag() {
        super(classification, discharge_day, explanation, additionalExplanation, image, lineProduct, lineImage, lineExplanation, warningText, warningContent, warningImage, warningMessage);
    }
}
