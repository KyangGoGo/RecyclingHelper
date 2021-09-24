package org.tensorflow.lite.examples.classification.data;

import org.tensorflow.lite.examples.classification.R;

public class Glass extends Data {
    public static final String classification = "유리병류";
    public static final String discharge_day = "화, 토";
    public static final String[] explanation = {
            "뚜껑 제거 후 내용물을 깨끗이 비운 후 배출",
            "일반병(소주, 맥주, 음료)은 소매정 등에서 보증금을 환불받을 수 있음",
            "겉 또는 속의 플라스틱 뚜겅은 불에 타는 쓰레기로 분류"
    };
    public static final String additionalExplanation = "";
    public static final Integer image = R.drawable.logo_glass;
    public static final String[] lineProduct = {
            "음료수 병, 기타 병류"
    };
    public static final Integer[] lineImage = {
            R.drawable.detail_glass
    };
    public static final String[] lineExplanation = {
            "플라스틱이나 알루미늄 뚜껑 제거 후 내용물을 깨끗이 비운 후 배출\n" +
                    "담배꽁초 등 이물질을 넣지 말 것\n" +
                    "맥주병, 소주병, 청량음료병은 편의점, 마트나 매장 등에 되돌려 주고\n" +
                    "빈용기보증금을 환불 받을 수 있음\n" +
                    "맥주병·소주병을 클린하우스에 배출시 깨지지 않도록 배출\n" +
                    "기타 잡병(음료수병, 드링크류, 술병류 등)류는 클린하우스에 비치된 유리병 수거함에 배출"
    };
    public static final String warningText = "불연성 전용 PP마대로 배출해주세요";
    public static final String[] warningContent = {
            "유리가 아닌 것"
    };
    public static final Integer[][] warningImage = {
            //유리류
            {R.drawable.warning_mirror},
            {R.drawable.warning_bulb},
            {R.drawable.warning_broken_glass},
            {R.drawable.warning_ceramic},
            {R.drawable.warning_heat_resistance},
            {R.drawable.warning_glass_lib},
            {R.drawable.warning_crystal_glass},
            {R.drawable.warning_pesticide}
    };
    public static final String[][] warningMessage = {
            //유리류
            {"거울"},
            {"전구"},
            {"깨진유리"},
            {"도자기류"},
            {"내열식기류"},
            {"유리 뚜껑"},
            {"크리스탈 유리제품"},
            {"유독물 병"}
    };

    public Glass() {
        super(classification, discharge_day, explanation, additionalExplanation, image, lineProduct, lineImage, lineExplanation, warningText, warningContent, warningImage, warningMessage);
    }
}
