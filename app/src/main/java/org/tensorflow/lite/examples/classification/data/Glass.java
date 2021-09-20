package org.tensorflow.lite.examples.classification.data;

import org.tensorflow.lite.examples.classification.R;

public class Glass {
    public static final String classification = "유리병류";
    public static final String discharge_day = "화, 토";
    public static final String[] explanation = {
            "뚜껑 제거 후 내용물을 깨끗이 비운 후 배출",
            "일반병(소주, 맥주, 음료)은 소매정 등에서 보증금을 환불받을 수 있음",
            "겉 또는 속의 플라스틱 뚜겅은 불에 타는 쓰레기로 분류"
    };
    public static final String additionalExplanation = "";
    public static final Integer image = R.drawable.glass;
}
