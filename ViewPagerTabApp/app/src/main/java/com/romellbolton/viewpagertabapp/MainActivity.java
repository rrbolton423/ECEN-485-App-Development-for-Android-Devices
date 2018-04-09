package com.romellbolton.viewpagertabapp;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Define ViewPager
        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);

        // Instantiate ViewPagerAdapter
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        // Add Fragments to adapter one by one
        adapter.addFragment(new FragmentOne(), "FRAG1");
        adapter.addFragment(new FragmentTwo(), "FRAG2");
        adapter.addFragment(new FragmentThree(), "FRAG3");

        // Set the adapter on the ViewPager
        viewPager.setAdapter(adapter);

        // Inflate the TabLayout
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        // Set up the TabLayout with the ViewPager
        tabLayout.setupWithViewPager(viewPager);
    }

    // Adapter for the ViewPager using FragmentPagerAdapter
    class ViewPagerAdapter extends FragmentPagerAdapter {

        // Create a list to hold the multiple fragments themselves...
        private final List<Fragment> mFragmentList = new ArrayList<>();

        // Create a list to hold the multiple titles of the fragments...
        private final List<String> mFragmentTitleList = new ArrayList<>();

        // Create Constructor for ViewPagerAdapter
        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        // getItem() returns the fragment at the specified position
        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        // getCount() returns the number of fragments available
        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        // addFragment() adds the Fragments and the Fragment titles to their own lists
        public void addFragment(Fragment fragment, String title) {

            // Add the Fragment to the list of Fragments
            mFragmentList.add(fragment);

            // Add the Fragment Title to the list of Fragments Titles
            mFragmentTitleList.add(title);
        }

        // getPageTitle() returns the fragment title at the specified position
        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
