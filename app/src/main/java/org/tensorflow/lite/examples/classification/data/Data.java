package org.tensorflow.lite.examples.classification.data;

import org.tensorflow.lite.examples.classification.R;

public class Data {

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
            "ae1",
            "ae2",
            "ae3",
            "ae4",
            "ae5",
            "ae6",
            "ae7"
    };
    public static Integer[] images = {
            R.drawable.paper,
            R.drawable.can,
            R.drawable.glass,
            R.drawable.plastic,
            R.drawable.plastic_bag,
            R.drawable.battery,
            R.drawable.styrofoam
    };
    public static String[][] lineProduct = {
        { "신문지", "책자, 노트, 전단지, 쇼핑백", "상자류(종이박스, 기타 골판지)"},
        {},
        {},
        {},
        {},
        {},
        {}
    };
    public static Integer[][] lineImage = {
            {R.drawable.newspaper, R.drawable.note, R.drawable.box},
            {},
            {},
            {},
            {},
            {},
            {}
    };
    public static String[][] lineExplanation = {
            {"뉴스 설명", "책자, 노트, 전단지, 쇼핑백 설명", "상자류 설명"},
            {},
            {},
            {},
            {},
            {},
            {}
    };
    public static String[][] productLine = {
            {"신문지", "책자, 노트, 전단지, 쇼핑백", "상자류"},
            {"c1","c2","c3"},
            {"g1", "g2"},
            {"p1"},
            {"pb1"},
            {"b1"},
            {"s1", "s2", "s3", "s4"}
    };
    public static String[] warningText = {
            "흰색 종량제 봉투에 버려주세요",
            "w2",
            "w3",
            "w4",
            "w5",
            "w6",
            "w7",
    };
    public static String[][] waringContent = {
            {"다른 재질과 혼합된 종이", "종이가 아닌것", "이물질 등으로 오염된 종이"},
            {"wc2", "wc2"},
            {"wc3"},
            {"wc4", "wc4", "wc4"},
            {"wc5", "wc5"},
            {"wc6", "wc6", "wc6", "wc6"},
            {"wc7"}
    };
    public static Integer[][][] warningImage = {
            {
                    {R.drawable.mixed_paper, R.drawable.gold_foil, R.drawable.wall_paper},
                    {R.drawable.non_woven},
                    {R.drawable.oily_paper, R.drawable.contaminated_paper},
            },
            {
              //캔류
            },
            {
              //유리류
            },
            {
              //플라스틱류
            },
            {
              //비닐류
            },
            {
              //폐전지
            },
            {
              //폐스티로폼폼
           }
    };
    public static String[][][] warningMessage = {
            {
                    {"다른재질과혼합된종이", "금박지,은박지", "다른 재질이 혼합된 벽지"},
                    {"부직포"},
                    {"기름 오염", "음식물 오염"},
            },
            {
                    //캔류
            },
            {
                    //유리류
            },
            {
                    //플라스틱류
            },
            {
                    //비닐류
            },
            {
                    //폐전지
            },
            {
                    //폐스티로폼폼
            }
    };



    public static int findItem(String item){
        for(int i = 0; i< Data.items.length; i++){
            if(item.equals(Data.items[i])) return i;
        }
        return -1;
    }

    public static String changeWorld(String title){
        String word = "";
        switch (title){
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
}