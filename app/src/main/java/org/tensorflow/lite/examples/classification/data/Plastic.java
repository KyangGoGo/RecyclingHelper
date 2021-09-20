package org.tensorflow.lite.examples.classification.data;

import org.tensorflow.lite.examples.classification.R;

public class Plastic {
    public static final String classification = "플라스틱류";
    public static final String discharge_day = "월, 수, 금, 일";
    public static final String[] explanation = {
            "용기에 남아 있는 내용물을 깨끗이 비우고, 다른 재질로 된 부분 (뚜껑과 부착상표 등)은 제거하여 압착하여 배출",
            "생수, 음료수 등 투명 페트병은 재활용도움센터 전용수거함에 라벨 제거 후 별도배출"
    };
    public static final String additionalExplanation = "CD는 재활용이 안되므로 흰색 종량제 봉투로 배출해주세요";
    public static final Integer image = R.drawable.plastic;
}
