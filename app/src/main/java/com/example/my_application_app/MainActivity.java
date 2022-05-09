package com.example.my_application_app;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import me.relex.circleindicator.CircleIndicator;


public class MainActivity extends AppCompatActivity {

    FragmentPagerAdapter adapterViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);

        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(vpPager);

        Intent intent1 = new Intent(getApplicationContext(), menu_first.class);
    }

    public static class MyPagerAdapter extends FragmentPagerAdapter{
        private static int NUM_ITEMS = 3;

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public int getCount(){
            return NUM_ITEMS;
        }

        @Override
        public Fragment getItem(int position){
            switch (position) {
                case 0:
                    return FirstFragment.newInstance(0, "Pager # 1");
                case 1:
                    return SecondFragmnet.newInstance(1, "Pager # 2");
                case 2:
                    return ThirdFragment.newInstance(2, "Pager # 3");
                default:
                    return null;
            }
        }

        @Override
        public CharSequence getPageTitle(int position){
            return "Page " + position;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.menu1:
                Intent intent1 = new Intent(this, menu_first.class);
                startActivity(intent1);
                return true;
            case R.id.menu2:
                Intent intent2 = new Intent(this, menu_second.class);
                startActivity(intent2);
                return true;
            case R.id.menu3:
                Intent intent3 = new Intent(this, menu_third.class);
                startActivity(intent3);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }
}