package org.tensorflow.lite.examples.classification.data;

import org.tensorflow.lite.examples.classification.R;

public class Plastic extends Data {
    public static final String classification = "플라스틱류";
    public static final String discharge_day_text = "월, 수, 금, 일";
    public static final Integer[] discharge_day_images = {
            R.drawable.detail_icon_mon,
            R.drawable.detail_icon_wen,
            R.drawable.detail_icon_fri,
            R.drawable.detail_icon_sun
    };
    public static final String[] explanation = {
            "용기에 남아 있는 내용물을 깨끗이 비우고, 다른 재질로 된 부분 (뚜껑과 부착상표 등)은 제거하여 압착하여 배출",
            "생수, 음료수 등 투명 페트병은 재활용도움센터 전용수거함에 라벨 제거 후 별도배출"
    };
    public static final String additionalExplanation = "CD는 재활용이 안되므로 흰색 종량제 봉투로 배출해주세요";
    public static final Integer image = R.drawable.logo_plastic;
    public static final String[] lineProduct = {
            "페트병, 플라스틱 용기류"
    };
    public static final Integer[] lineImage = {
            R.drawable.detail_plastic_bottle
    };
    public static final String[] lineExplanation = {
            "용기에 남아 있는 내용물을 깨끗이 비우고, 다른 재질로 된 부분(뚜껑과 부착상표 등)은 제거하여 압착하여 배출합니다.\n" +
                    "생수, 음료수 등 투명 페트병은 재활용도움센터 전용수거함에 라벨 제거 후 별도배출"
    };
    public static final String warningText = "흰색 종량제 봉투에 버려주세요";
    public static final String[] warningContent = {
            "비닐 붙은 플라스틱",
            "소형 플라스틱",
            "PVC원료 제품",
            "유색 플라스틱",
            "원료가 섞인 플라스틱(OTHER)"
    };
    public static final Integer[][] warningImage = {
            //플라스틱류
            {R.drawable.warning_vinyl_plastic, R.drawable.warning_label_bottle},
            {R.drawable.warning_tooth_brush, R.drawable.warning_disposable_spoon},
            {R.drawable.warning_tube, R.drawable.warning_pvc_mat},
            {R.drawable.warning_color_bottle},
            {R.drawable.warning_disposable_cup}
    };
    public static final String[][] warningMessage = {
            //플라스틱류
            {"배달용 진공포장 용기", "상표가 붙은 페트병"},
            {"칫솔", "일회용 숫가락"},
            {"튜브", "유아용 매트"},
            {"유색 페트병"},
            {"일회용 컵"}
    };

    public static final String[] numberOfCases = {};

    public Plastic() {
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
                warningMessage,
                numberOfCases);
    }
}
