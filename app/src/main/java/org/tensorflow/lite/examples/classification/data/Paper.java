package org.tensorflow.lite.examples.classification.data;

import org.tensorflow.lite.examples.classification.R;

public class Paper {
    public static final String classification = "종이류";
    public static final String discharge_day = "화, 목, 토";
    public static final String[] explanation = {
            "끈으로 잘 묶거나, 흰색 또는 투명봉투를 사용하여 배출",
            "물기에 젖지 않게 묶거나 박스류에 담아서 배출",
            "종이컵, 우유팩은 씻어 말린 후 펼치거나 압착하여 배출",
            "우천시 배출하지 말고 다음 재활용품 배출요일에 배출"
    };
    public static final String additionalExplanation = "종이류와 종이컵(우유팩)은 분리해서 버려야합니다.";
    public static final Integer image = R.drawable.logo_paper;
}
