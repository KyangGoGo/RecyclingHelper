package org.tensorflow.lite.examples.classification;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import org.tensorflow.lite.examples.classification.data.Data;
import org.tensorflow.lite.examples.classification.viewpager2.MyAdapter;

import me.relex.circleindicator.CircleIndicator3;

public class DetailActivity extends FragmentActivity {

    //Viewpager
    private ViewPager2 mPager;
    private FragmentStateAdapter pagerAdapter;
    private CircleIndicator3 mIndicator;

    private TextView displayTitle,
        displayDay;
    private ImageView displayImage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String title = bundle.getString("title");
        if(title != null){
            Log.d("뜨냐/",title);
            upperBarSetting(title);
        }

        //ViewPager2
        mPager = findViewById(R.id.viewpager);
        //Adapter
        pagerAdapter = new MyAdapter(this, Data.viewPage, title);
        mPager.setAdapter(pagerAdapter);
        //Indicator
        mIndicator = findViewById(R.id.indicator);
        mIndicator.setViewPager(mPager);
        mIndicator.createIndicators(Data.viewPage,0);
        //ViewPager Setting
        mPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        mPager.setCurrentItem(1000);
        mPager.setOffscreenPageLimit(3);

        mPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                if (positionOffsetPixels == 0) {
                    mPager.setCurrentItem(position);
                }
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                mIndicator.animatePageSelected(position%Data.viewPage);
            }

        });


        final float pageMargin= getResources().getDimensionPixelOffset(R.dimen.pageMargin);
        final float pageOffset = getResources().getDimensionPixelOffset(R.dimen.offset);

        mPager.setPageTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float myOffset = position * -(2 * pageOffset + pageMargin);
                if (mPager.getOrientation() == ViewPager2.ORIENTATION_HORIZONTAL) {
                    if (ViewCompat.getLayoutDirection(mPager) == ViewCompat.LAYOUT_DIRECTION_RTL) {
                        page.setTranslationX(-myOffset);
                    } else {
                        page.setTranslationX(myOffset);
                    }
                } else {
                    page.setTranslationY(myOffset);
                }
            }
        });
    }
    private void upperBarSetting(String text){
        int isExistItem = Data.findItem(text);
        displayImage = findViewById(R.id.display_image);
        displayTitle = findViewById(R.id.display_title);
        displayDay = findViewById(R.id.display_day);
        if (isExistItem!=-1){ // 해당 아이템이 있을 경우
            displayImage.setImageResource(Data.images[isExistItem]);
            displayTitle.setText(text);
            displayDay.setText(Data.discharge_day[isExistItem]);
        }else{
            displayImage.setImageResource(R.drawable.recycle);
            displayTitle.setText("값 없음");
            displayDay.setText("값 없음");
        }
    }
}
