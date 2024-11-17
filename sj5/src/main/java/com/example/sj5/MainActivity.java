package com.example.sj5;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {
    private TextView title_bar;
    private RadioGroup tab_bar;
    private RadioButton bar1;
    private RadioButton bar2;
    private RadioButton bar3;
    private ViewPager vapger;
    private MyFragmentPagerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        initViews();
    }
    private void initViews() {
        title_bar = (TextView) findViewById(R.id.title_bar);
        tab_bar = (RadioGroup) findViewById(R.id.tab_bar);
        bar1 = (RadioButton) findViewById(R.id.bar1);
        bar2 = (RadioButton) findViewById(R.id.bar2);
        bar3 = (RadioButton) findViewById(R.id.bar3);
        tab_bar.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.bar1:
                        vapger.setCurrentItem(0);
                        title_bar.setText("登录");
                        break;
                    case R.id.bar2:
                        vapger.setCurrentItem(1);
                        title_bar.setText("注册");
                        break;
                    case R.id.bar3:
                        vapger.setCurrentItem(2);
                        title_bar.setText("我的");
                        break;
                }
            }
        });
        vapger = (ViewPager) findViewById(R.id.vpager);
        adapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        vapger.setAdapter(adapter);
        vapger.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            @Override
            public void onPageSelected(int position) {

            }
            @Override
            public void onPageScrollStateChanged(int state) {
                if(state ==2){
                    switch(vapger.getCurrentItem()){
                        case 0:
                            bar1.setChecked(true);
                            break;
                        case 1:
                            bar2.setChecked(true);
                            break;
                        case 2:
                            bar3.setChecked(true);
                            break;
                    }
                }
            }
        });
        bar1.setChecked(true);
    }
}
