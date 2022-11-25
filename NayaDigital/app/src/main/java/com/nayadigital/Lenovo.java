package com.nayadigital;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

public class Lenovo extends AppCompatActivity {

    private TabLayout tablayout;
    private AppBarLayout appBarLayout;
    private androidx.viewpager.widget.ViewPager ViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lenovo);
        tablayout = (TabLayout) findViewById(R.id.tablayout_id);
        appBarLayout = (AppBarLayout) findViewById(R.id.appbar_id);
        ViewPager = (androidx.viewpager.widget.ViewPager) findViewById(R.id.viewpagger_id);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.AddFragment(new SpecLenovo(), "Spec");
        adapter.AddFragment(new HargaLenovo(), "Harga");

        ViewPager.setAdapter(adapter);
        tablayout.setupWithViewPager(ViewPager);
    }
}