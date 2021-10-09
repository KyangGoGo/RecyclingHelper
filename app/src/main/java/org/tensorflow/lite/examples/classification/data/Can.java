package org.tensorflow.lite.examples.classification.data;

import org.tensorflow.lite.examples.classification.R;

public class Can extends Data {
    public static final String classification = "캔류";
    public static final String discharge_day_text = "매일";
    public static final Integer[] discharge_day_images = {
            R.drawable.detail_icon_every_day
    };
    public static final String[] explanation = {
            "내용물은 비우고 물로 씻은 후 가능하면 압착",
            "캔에 부착된 플라스틱 뚜껑 등 제거",
            "부탄가스(살충제) 용기는 구멍을 뚫어 남은 가스 제거"
    };
    public static final String additionalExplanation = "부탄가스 용기는 바닥에 구멍을 뚫어 가스를 빼서 배출해야합니다.";
    public static final Integer image = R.drawable.logo_can;
    public static final String[] lineProduct = {
            "철캔, 알루미늄캔",
            "기타 캔류(부탄가스 용기, 살충제 용기 등"
    };
    public static final Integer[] lineImage = {
            R.drawable.detail_can,
            R.drawable.detail_extra_can
    };
    public static final String[] lineExplanation = {
            "캔에 부착된 플라스틱 뚜껑 등 제거 후 내용물을 비우고 배출\n" +
                    "담배꽁초 등 이물질을 넣지 말아야함",
            "구멍을 뚫어 남은 가스를 제거 후 배출\n" +
                    "배출하지 않을 시 수거나 재활용 과정에서 폭발의 위험이 있음"
    };
    public static final String warningText = "재활용이 되지 않습니다.";
    public static final String[] warningContent = {
            "유해물 포장통"
    };
    public static final Integer[][] warningImage = {
            {R.drawable.warning_paint_bucket}
    };
    public static final String[][] warningMessage = {
            {"폐인트통"}
    };

    public static final String[] numberOfCases = {};


    public Can() {
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
