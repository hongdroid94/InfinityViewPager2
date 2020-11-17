package com.innodep.infinityviewpager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.innodep.infinityviewpager.adapter.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private TextView tv_title;
    private ArrayList<String> mSetUpList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setInit();
    }

    private void setInit() {

        /* findViewById */
        tv_title     = findViewById(R.id.tv_title);
        /* setup infinity scroll viewpager */
        ViewPager2 viewPageSetUp = findViewById(R.id.SetupFrg_ViewPage_Info);
        mSetUpList = new ArrayList<>(Arrays.asList("홍드로이드","구독","좋아요","알림설정"));
        ViewPagerAdapter SetupPagerAdapter = new ViewPagerAdapter(this, mSetUpList);
        viewPageSetUp.setAdapter(SetupPagerAdapter);
        viewPageSetUp.setOrientation(ViewPager2.ORIENTATION_VERTICAL);
        viewPageSetUp.setOffscreenPageLimit(3);
        // 무제한 스크롤 처럼 보이기 위해서는 0페이지 부터가 아니라 1000페이지 부터 시작해서 좌측으로 이동할 경우 999페이지로 이동하여 무제한 처럼 스크롤 되는 것 처럼 표현하기 위함.
        viewPageSetUp.setCurrentItem(1000);

        final float pageMargin = (float) getResources().getDimensionPixelOffset(R.dimen.pageMargin);
        final float pageOffset = (float) getResources().getDimensionPixelOffset(R.dimen.offset);

        viewPageSetUp.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                int index = position % mSetUpList.size();
                String item = mSetUpList.get(index);
                tv_title.setText(item);
            }
        });
        viewPageSetUp.setPageTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float offset = position * - (2 * pageOffset + pageMargin);
                if(-1 > position) {
                    page.setTranslationY(-offset);
                } else if(1 >= position) {
                    float scaleFactor = Math.max(0.7f, 1 - Math.abs(position - 0.14285715f));
                    page.setTranslationY(offset);
                    page.setScaleX(scaleFactor);
                    page.setAlpha(scaleFactor);
                } else {
                    page.setAlpha(0f);
                    page.setTranslationY(offset);
                }
            }
        });
        /* setup infinity scroll viewpager. end */



    }
}