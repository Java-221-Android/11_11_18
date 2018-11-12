package com.sheygam.java221_11_11_18_part2;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ViewPager pager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pager = findViewById(R.id.viewPager);
        MyAdapter adapter = new MyAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        pager.setOffscreenPageLimit(4);
//        pager.setCurrentItem(5);

        findViewById(R.id.nextBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pager.getCurrentItem() < 10) {
                    pager.setCurrentItem(pager.getCurrentItem()+1);
                }
            }
        });

        findViewById(R.id.prevBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                pager.setCurrentItem(0,false);
                if(pager.getCurrentItem() > 0){
                    pager.setCurrentItem(pager.getCurrentItem()-1);
                }
            }
        });
        int pos = pager.getCurrentItem();
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    class MyAdapter extends FragmentStatePagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Log.d("MY_TAG", "getItem: " + position);
            Random rnd = new Random();
            int color = Color.rgb(rnd.nextInt(256),
                    rnd.nextInt(256),
                    rnd.nextInt(256));
            return MyPage.newInstance(color,"Page " + position);
        }

        @Override
        public int getCount() {
            return 10;
        }
    }
}
