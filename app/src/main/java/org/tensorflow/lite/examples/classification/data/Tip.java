package org.tensorflow.lite.examples.classification.data;

import java.util.Random;

public class Tip {
    private static final String[] tips = {
            "부탄가스 용기는 바닥에 구멍을 뚫어 가스를 빼서 배출해야합니다.",
            "종이류와 종이컵(우유팩)은 분리해서 배출해야합니다.",
            "CD는 재활용이 안되므로 흰색 종량제 봉투로 배출해야합니다.",
            "택배 상자의 경우 송장 스티커, 테이프를 제거하여 배출해야합니다.",
            "깨진 유리는 재활용 되지 않으므로 신문지에 감싸 일반쓰레기로 배출해야합니다.",
            "빈 용기 보증금: 대형마트/편의점/슈퍼마켓 에서 보증금을 환불받고 빈 용기를 반환할 수 있습니다.",
            "분리배출의 핵십 4가지 비운다-행군다-분리한다-섞지않는다",
            "소형 플라스틱(일회용 수저, 칫솔)은 일반쓰레기로 배출해야합니다.",
            "쓰레기를 줄이는 가장 좋은 방법은 쓰레기 \'재활용\'이 아니라 \'줄이기\'입니다."
    };

    public static String getRandomTip() {
        return tips[new Random().nextInt(tips.length)];
    }
}
