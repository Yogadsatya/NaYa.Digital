package com.nayadigital;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter implements ViewAdapter {

    private final List<Fragment> fragmentsList = new ArrayList<>();
    private final List<String> FragmentListTitle = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return FragmentListTitle.size();
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentsList.get(position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return FragmentListTitle.get(position);
    }

    @Override
    public void AddFragment(Fragment fragment, String Title) {
        fragmentsList.add(fragment);
        FragmentListTitle.add(Title);
    }
}
