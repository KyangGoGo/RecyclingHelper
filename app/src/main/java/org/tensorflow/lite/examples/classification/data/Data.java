package org.tensorflow.lite.examples.classification.data;

import org.tensorflow.lite.examples.classification.R;

public class Data {

    public static Integer viewPage = 3;

    public static String[] items = {"paper", "can", "glass",
            "plastic", "plastic_bag", "battery", "styrofoam"};
    public static String[] classification = {"종이류", "캔류", "유리류", "플라스틱류", "비닐류", "폐전지", "폐스티로폼"};
    public static String[] discharge_day = {"화, 목, 토", "매일", "화, 토", "월, 수, 금, 일", "목, 일", "매일", "매일"};
    public static String[] explanation = {"물기에 젖지 않게 묶거나 박스류에 담아서 배출", "내용물을 비우고 배출", "내용물을 비우고 배출", "음식물 등 내용물을 깨끗이 비우고, 다른 재질 제거 후 압착하여 배출", "이물질을 씻어서 배출", "전용 수거함에 배출", "이물질을 제거하여 배출"};
    public static String[] additional_explanation = {"ae1", "ae2", "ae3", "ae4", "ae5", "ae6", "ae7"};
    public static Integer[] images = {R.drawable.paper, R.drawable.can, R.drawable.glass,
            R.drawable.plastic, R.drawable.plastic_bag, R.drawable.battery, R.drawable.styrofoam};

    public static int findItem(String item){
        for(int i = 0; i< Data.items.length; i++){
            if(item.equals(Data.items[i])) return i;
        }
        return -1;
    }
}
