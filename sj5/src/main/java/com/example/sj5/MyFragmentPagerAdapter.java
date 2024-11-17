package com.example.sj5;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    private MyFragment1 fragment1 = null;
    private MyFragment2 fragment2 = null;
    private MyFragment3 fragment3 = null;
    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        fragment1 = new MyFragment1();
        fragment2 = new MyFragment2();
        fragment3 = new MyFragment3();
    }

    @Override
    public int getCount() {
        return 3;
    }
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = fragment1;
                break;
            case 1:
                fragment = fragment2;
                break;
            case 2:
                fragment = fragment3;
                break;
        }
        return fragment;
    }
}
