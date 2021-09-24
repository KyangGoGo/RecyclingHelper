package org.tensorflow.lite.examples.classification.viewpager2;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import org.tensorflow.lite.examples.classification.FragmentFirst;
import org.tensorflow.lite.examples.classification.FragmentSecond;
import org.tensorflow.lite.examples.classification.FragmentThird;
import org.tensorflow.lite.examples.classification.data.Data;

public class MyAdapter extends FragmentStateAdapter {

    public int count;
    private Data data;

    public MyAdapter(FragmentActivity fa, int count, Data data) {
        super(fa);
        this.count = count;
        this.data = data;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        int index = getRealPosition(position);

        if(index==0) return new FragmentFirst(data);
        else if (index==1) return new FragmentSecond(data);
        else return new FragmentThird(data);
    }

    @Override
    public int getItemCount() {
        return Data.viewPage;
    }

    public int getRealPosition(int position) { return position % count; }

}