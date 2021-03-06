package org.tensorflow.lite.examples.classification;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import org.checkerframework.checker.units.qual.C;
import org.tensorflow.lite.examples.classification.data.Data;
import org.tensorflow.lite.examples.classification.adapter.ViewPagerAdapter;

import me.relex.circleindicator.CircleIndicator3;

public class DetailActivity extends FragmentActivity {

    //Viewpager
    private ViewPager2 mPager;
    private FragmentStateAdapter pagerAdapter;
    private CircleIndicator3 mIndicator;

    private TextView displayTitle;
    private ImageView displayImage;
    private LinearLayout displayDay;

    private Data data;
    private Bitmap bitmap;

    private int count = Data.viewPage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String title = bundle.getString("title");
        byte[] arr = intent.getByteArrayExtra("yolov5Bitmap");

        if (title != null) {
            upperBarSetting(title);
            bitmap = BitmapFactory.decodeByteArray(arr, 0, arr.length);
            if (data.getClassification().equals("플라스틱류")) count = 4;
        }

        //ViewPager2
        mPager = findViewById(R.id.viewpager);
        //Adapter
        pagerAdapter = new ViewPagerAdapter(this, count, data, bitmap);
        mPager.setAdapter(pagerAdapter);
        //Indicator
        mIndicator = findViewById(R.id.indicator);
        mIndicator.setViewPager(mPager);
        mIndicator.createIndicators(count, 0);
        //ViewPager Setting
        mPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        mPager.setCurrentItem(1000);
        mPager.setOffscreenPageLimit(count);

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
                mIndicator.animatePageSelected(position % count);
            }

        });


        final float pageMargin = getResources().getDimensionPixelOffset(R.dimen.pageMargin);
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

    private void upperBarSetting(String text) {
        //int isExistItem = Data.findItem(text);
        data = Data.getInstance(text);

        displayImage = findViewById(R.id.display_image);
        displayTitle = findViewById(R.id.display_title);
        displayDay = findViewById(R.id.display_day);

        if (data != null) {
            displayImage.setImageResource(data.getImage());
            displayTitle.setText(data.getClassification());
            //displayDay.setImageBitmap(data.getDischarge_day_images());
            Integer[] images = data.getDischarge_day_images();
            for (int i = 0; i < images.length; i++) {
                ImageView discharge_day_image = new ImageView(getApplicationContext());
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), images[i]); //이미지 비트맵 변환
                bitmap = Bitmap.createScaledBitmap(bitmap, 100, 100, true);
                discharge_day_image.setImageBitmap(bitmap);
                displayDay.addView(discharge_day_image);
            }
        } else {
            displayImage.setImageResource(R.drawable.recycle);
            displayTitle.setText("값 없음");
            //displayDay.setText("값 없음");
        }
    }
}
