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
    public static final String[] lineProduct = {
            "신문지",
            "책자, 노트, 전단지, 쇼핑백",
            "상자류(종이박스, 기타 골판지)"
    };
    public static final Integer[] lineImage = {
            R.drawable.detail_newspaper,
            R.drawable.detail_note,
            R.drawable.detail_box
    };
    public static final String[] lineExplanation = {
            "물기에 젖지 않도록하고, 반듯하게 펴서 차곡차곡 쌓아 끈으로 묶어 배출",
            "끈으로 묶어서 배출, 비닐 코팅된 표지의 비닐류 스프링 제본된 책자류의 스프링은 제거 후 배출",
            "상자에 붙어 있는 테이프나 철핀을 제거한 후 끈으로 묶어 배출"
    };
    public static final String warningText = "흰색 종량제 봉투에 버려주세요";
    public static final String[] warningContent = {
            "다른 재질과 혼합된 종이",
            "종이가 아닌것",
            "이물질 등으로 오염된 종이"
    };
    public static final Integer[][] warningImage = {
            {R.drawable.warning_mixed_paper, R.drawable.warning_gold_foil, R.drawable.warning_wall_paper},
            {R.drawable.warning_non_woven},
            {R.drawable.warning_oily_paper, R.drawable.warning_contaminated_paper},
    };
    public static final String[][] warningMessage = {
            {"영수증", "금박지,은박지", "다른 재질이 혼합된 벽지"},
            {"부직포"},
            {"기름 오염", "음식물 오염"},
    };
}
