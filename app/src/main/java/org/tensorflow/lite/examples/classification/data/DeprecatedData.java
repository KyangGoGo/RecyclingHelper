package org.tensorflow.lite.examples.classification.data;

import android.app.Activity;
import android.graphics.Point;
import android.view.Display;

import org.tensorflow.lite.examples.classification.R;

public class DeprecatedData {

    public static Integer viewPage = 3;

    public static String[] items = {
            "paper",
            "can",
            "glass",
            "plastic",
            "plastic_bag",
            "battery",
            "styrofoam"
    };
    public static String[] classification = {
            "종이류",
            "캔류",
            "유리류",
            "플라스틱류",
            "비닐류",
            "폐전지",
            "폐스티로폼"
    };
    public static String[] discharge_day = {
            "화, 목, 토",
            "매일",
            "화, 토",
            "월, 수, 금, 일",
            "목, 일",
            "매일",
            "매일"
    };
    public static String[] explanation = {
            "물기에 젖지 않게 묶거나 박스류에 담아서 배출",
            "내용물을 비우고 배출",
            "내용물을 비우고 배출",
            "음식물 등 내용물을 깨끗이 비우고, 다른 재질 제거 후 압착하여 배출",
            "이물질을 씻어서 배출",
            "전용 수거함에 배출",
            "이물질을 제거하여 배출"
    };
    public static String[] additional_explanation = {
            "종이류와 종이컵(우유팩)은 분리해서 버려야합니다.",
            "부탄가스 용기는 바닥에 구멍을 뚫어 가스를 빼서 배출해야합니다.",
            "크리스탈 유리제품은 다른 성분을 포함하고있기 때문에 불연성 쓰레기로 버려야합니다.",
            "CD는 재활용이 안되므로 흰색 종량제 봉투로 배출해주세요",
            "ae5",
            "전지류는 니켈, 카드뮴, 수은 등 중금속이 포함되어 있어 토양오염이나 대기오염을 유발하며 먹이사슬을 통하여 사람에게 위해를 가할 수 있으므로 분리배출이 필요합니다. ",
            "ae7"
    };
    public static Integer[] images = {
            R.drawable.logo_paper,
            R.drawable.logo_can,
            R.drawable.logo_glass,
            R.drawable.logo_plastic,
            R.drawable.logo_plastic_bag,
            R.drawable.logo_battery,
            R.drawable.logo_styrofoam
    };
    public static String[][] lineProduct = {
            {"신문지", "책자, 노트, 전단지, 쇼핑백", "상자류(종이박스, 기타 골판지)"},
            {"철캔, 알루미늄캔", "기타 캔류(부탄가스 용기, 살충제 용기 등"},
            {"음료수 병, 기타 병류"},
            {"페트병, 플라스틱 용기류"},
            {"과자, 라면, 빵 봉지, 1회용 비닐 봉투 등 모든 비닐"},
            {"건전지, 충전용 전지"},
            {"폐스티로폼"}
    };
    public static Integer[][] lineImage = {
            {R.drawable.detail_newspaper, R.drawable.detail_note, R.drawable.detail_box},
            {R.drawable.detail_can, R.drawable.detail_extra_can},
            {R.drawable.detail_glass},
            {R.drawable.detail_plastic_bottle},
            {R.drawable.detail_plastic_bag},
            {R.drawable.detail_battery},
            {R.drawable.detail_styrofaom}
    };
    public static String[][] lineExplanation = {
            {
                    "물기에 젖지 않도록하고, 반듯하게 펴서 차곡차곡 쌓아 끈으로 묶어 배출",
                    "끈으로 묶어서 배출, 비닐 코팅된 표지의 비닐류 스프링 제본된 책자류의 스프링은 제거 후 배출",
                    "상자에 붙어 있는 테이프나 철핀을 제거한 후 끈으로 묶어 배출"
            },
            {
                    "캔에 부착된 플라스틱 뚜껑 등 제거 후 내용물을 비우고 배출\n" +
                            "담배꽁초 등 이물질을 넣지 말아야함",
                    "구멍을 뚫어 남은 가스를 제거 후 배출\n" +
                            "배출하지 않을 시 수거나 재활용 과정에서 폭발의 위험이 있음"
            },
            {
                    "플라스틱이나 알루미늄 뚜껑 제거 후 내용물을 깨끗이 비운 후 배출\n" +
                            "담배꽁초 등 이물질을 넣지 말 것\n" +
                            "맥주병, 소주병, 청량음료병은 편의점, 마트나 매장 등에 되돌려 주고\n" +
                            "빈용기보증금을 환불 받을 수 있음\n" +
                            "맥주병·소주병을 클린하우스에 배출시 깨지지 않도록 배출\n" +
                            "기타 잡병(음료수병, 드링크류, 술병류 등)류는 클린하우스에 비치된 유리병 수거함에 배출"
            },
            {
                    "용기에 남아 있는 내용물을 깨끗이 비우고, 다른 재질로 된 부분(뚜껑과 부착상표 등)은 제거하여 압착하여 배출합니다.\n" +
                            "생수, 음료수 등 투명 페트병은 재활용도움센터 전용수거함에 라벨 제거 후 별도배출"
            },
            {
                    "투명 비닐봉투에 넣어 재활용품으로 배출\n" +
                            "음식물 등 이물질이 묻은 경우 깨끗이 씻어서 배출\n" +
                            "이물질 제거가 어려운 경우는 가연성 흰색 종량제 봉투에 배출"
            },
            {
                    "전지는 제품에서 분리하여 배출\n" +
                            "주요 거점(읍·면·동·아파트 공동주택 등의 폐형광등·폐전지 일체함 또는 클린하우스·재활용도움센터 등)의 전용수거함에 배출"
            },
            {
                    "스티로폼 상자의 내용물을 깨끗이 비우고 이물질 제거 후 배출\n" +
                            "음식물 등 이물질이 묻은 스티로폼은 가연성 흰색 종량제 봉투로 배출\n" +
                            "※ 단, 건축용 자재로 쓰인 내연재, 공작용 우드락 재질로 된 것은 가연성 쓰레기로 배출하여 주시기 바랍니다."
            }
    };
    public static String[] warningText = {
            "흰색 종량제 봉투에 버려주세요",
            "재활용 되지 않습니다.",
            "불연성 전용 PP마대로 배출해주세요",
            "흰색 종량제 봉투에 버려주세요",
            "재활용 되지 않습니다.",
            "w6",
            "w7",
    };
    public static String[][] waringContent = {
            {"다른 재질과 혼합된 종이", "종이가 아닌것", "이물질 등으로 오염된 종이"},
            {"유해물 포장통"},
            {"유리가 아닌 것"},
            {"비닐 붙은 플라스틱", "소형 플라스틱", "PVC원료 제품", "유색 플라스틱", "원료가 섞인 플라스틱(OTHER)"},
            {"얼음팩", "홉합재질봉투"},
            {"wc6", "wc6", "wc6", "wc6"},
            {"wc7"}
    };
    public static Integer[][][] warningImage = {
            {
                    {R.drawable.warning_mixed_paper, R.drawable.warning_gold_foil, R.drawable.warning_wall_paper},
                    {R.drawable.warning_non_woven},
                    {R.drawable.warning_oily_paper, R.drawable.warning_contaminated_paper},
            },
            {
                    //캔류
                    {R.drawable.warning_paint_bucket}
            },
            {
                    //유리류
                    {R.drawable.warning_mirror},
                    {R.drawable.warning_bulb},
                    {R.drawable.warning_broken_glass},
                    {R.drawable.warning_ceramic},
                    {R.drawable.warning_heat_resistance},
                    {R.drawable.warning_glass_lib},
                    {R.drawable.warning_crystal_glass},
                    {R.drawable.warning_pesticide}
            },
            {
                    //플라스틱류
                    {R.drawable.warning_vinyl_plastic, R.drawable.warning_label_bottle},
                    {R.drawable.warning_tooth_brush, R.drawable.warning_disposable_spoon},
                    {R.drawable.warning_tube, R.drawable.warning_pvc_mat},
                    {R.drawable.warning_color_bottle},
                    {R.drawable.warning_disposable_cup}
            },
            {
                    //비닐류
                    {R.drawable.warning_ice_pack}
            },
            {
                    //폐전지
            },
            {
                    //폐스티로폼
            }
    };
    public static String[][][] warningMessage = {
            {
                    {"영수증", "금박지,은박지", "다른 재질이 혼합된 벽지"},
                    {"부직포"},
                    {"기름 오염", "음식물 오염"},
            },
            {
                    //캔류
                    {"페인트통"}
            },
            {
                    //유리류
                    {"거울"},
                    {"전구"},
                    {"깨진유리"},
                    {"도자기류"},
                    {"내열식기류"},
                    {"유리 뚜껑"},
                    {"크리스탈 유리제품"},
                    {"유독물 병"}
            },
            {
                    //플라스틱류
                    {"배달용 진공포장 용기", "상표가 붙은 페트병"},
                    {"칫솔", "일회용 숫가락"},
                    {"튜브", "유아용 매트"},
                    {"유색 페트병"},
                    {"일회용 컵"}
            },
            {
                    //비닐류
                    {"얼음팩"}
            },
            {
                    //폐전지
            },
            {
                    //폐스티로폼폼
            }
    };


    public static int findItem(String item) {
        for (int i = 0; i < DeprecatedData.items.length; i++) {
            if (item.equals(DeprecatedData.items[i])) return i;
        }
        return -1;
    }

    public static String changeWorld(String title) {
        String word = "";
        switch (title) {
            case "paper":
                word = "종이";
                break;
            case "can":
                word = "캔";
                break;
            case "glass":
                word = "유리";
                break;
            case "plastic_bag":
                word = "비닐";
                break;
            case "battery":
                word = "건전지";
                break;
            case "styrofoam":
                word = "스티로폼";
                break;
        }
        return word;
    }

    public static int getScreenSize(Activity activity, int divisor){
        Display display = activity.getWindowManager().getDefaultDisplay();
        Point screenSize = new Point();
        display.getSize(screenSize);
        int mul = screenSize.x * screenSize.y;
        return (int)(mul/ divisor);
    }
}