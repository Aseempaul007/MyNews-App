package com.example.mynewsapp.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.mynewsapp.Fragment.EntertainmentFragment;
import com.example.mynewsapp.Fragment.HealthFragment;
import com.example.mynewsapp.Fragment.HomeFragment;
import com.example.mynewsapp.Fragment.SceinceFragment;
import com.example.mynewsapp.Fragment.SportsFragment;
import com.example.mynewsapp.Fragment.TechnologyFragment;

public class MyPagerAdapter extends FragmentPagerAdapter {

    int tabcount;

    public MyPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabcount=behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0 :
                return new HomeFragment();
            case 1 :
                return new SportsFragment();
            case 2 :
                return new HealthFragment();
            case 3 :
                return new SceinceFragment();
            case 4 :
                return new EntertainmentFragment();
            case 5 :
                return new TechnologyFragment();

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabcount ;
    }
}
