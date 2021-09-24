package org.tensorflow.lite.examples.classification.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import org.tensorflow.lite.examples.classification.DetailLineFragment;
import org.tensorflow.lite.examples.classification.DetailWarningFragment;
import org.tensorflow.lite.examples.classification.DetailFnQFragment;
import org.tensorflow.lite.examples.classification.data.Data;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public int count;
    private Data data;

    public ViewPagerAdapter(FragmentActivity fa, int count, Data data) {
        super(fa);
        this.count = count;
        this.data = data;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        int index = getRealPosition(position);

        if(index==0) return new DetailLineFragment(data);
        else if (index==1) return new DetailWarningFragment(data);
        else return new DetailFnQFragment(data);
    }

    @Override
    public int getItemCount() {
        return Data.viewPage;
    }

    public int getRealPosition(int position) { return position % count; }

}