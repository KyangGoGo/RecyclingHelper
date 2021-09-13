package org.tensorflow.lite.examples.classification.data;

import org.tensorflow.lite.examples.classification.R;

public class Data {

    public static String[] items = {"paper", "can", "glass",
            "plastic", "plastic_bag", "battery", "styrofoam"};
    public static String[] classification = {"c1", "c2", "c3", "c4", "c5", "c6", "c7"};
    public static String[] discharge_day = {"d1", "d2", "d3", "d4", "d5", "d6", "d7"};
    public static String[] explanation = {"e1", "e2", "e3", "e4", "e5", "e6", "e7"};
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
