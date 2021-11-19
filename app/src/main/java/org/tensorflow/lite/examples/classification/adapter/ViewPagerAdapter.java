package org.tensorflow.lite.examples.classification.adapter;

import android.graphics.Bitmap;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import org.tensorflow.lite.examples.classification.DetailLineFragment;
import org.tensorflow.lite.examples.classification.DetailWarningFragment;
import org.tensorflow.lite.examples.classification.DetailFnQFragment;
import org.tensorflow.lite.examples.classification.DetailYoloFragment;
import org.tensorflow.lite.examples.classification.data.Data;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public int count;
    private Data data;
    private Bitmap bitmap;

    public ViewPagerAdapter(FragmentActivity fa, int count, Data data, Bitmap bitmap) {
        super(fa);
        this.count = count;
        this.data = data;
        this.bitmap = bitmap;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        int index = getRealPosition(position);

        //프래그먼트에 위치에 맞게 인덱싱
        if (count == 4) {
            if (index == 0) return new DetailYoloFragment(data, bitmap);
            else if (index == 1) return new DetailLineFragment(data);
            else if (index == 2) return new DetailWarningFragment(data);
            else return new DetailFnQFragment(data);

        } else {
            if (index == 0) return new DetailLineFragment(data);
            else if (index == 1) return new DetailWarningFragment(data);
            else return new DetailFnQFragment(data);
        }
    }

    @Override
    public int getItemCount() {
        return count;
    }

    public int getRealPosition(int position) {
        return position % count;
    }

}