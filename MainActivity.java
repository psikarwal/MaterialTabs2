package main.traveldiaries.com.materialtabs;

import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.TransitionInflater;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import moe.codeest.enviews.ENPlayView;

public class MainActivity extends AppCompatActivity {

    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int[] tabIcons = {
            R.drawable.tab1,
            R.drawable.tab2,
            R.drawable.tab3,
            R.drawable.tab4
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(Build.VERSION.SDK_INT>=21) {
            getWindow().setSharedElementExitTransition(TransitionInflater.from(this).inflateTransition(R.transition.shared_element_transition));
        }
        setContentView(R.layout.activity_main);

        ImageView smallThumb = (ImageView) findViewById(R.id.song_thmb);
        TextView songNameSmall = (TextView) findViewById(R.id.songname1);
        TextView songAuthorSmall = (TextView) findViewById(R.id.author);
        ENPlayView playSmall = (ENPlayView) findViewById(R.id.ib_play);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.tab1);
        tabLayout.getTabAt(1).setText(mFragmentTitleList.get(1));
        tabLayout.getTabAt(2).setText(mFragmentTitleList.get(2));
        tabLayout.getTabAt(3).setText(mFragmentTitleList.get(3));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.setIcon(tabIcons[tab.getPosition()]);
                tab.setText("");
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.setText(mFragmentTitleList.get(tab.getPosition()));
                tab.setIcon(null);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                tab.setIcon(tabIcons[tab.getPosition()]);
                tab.setText("");
            }
        });
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new OneFragment(), "Player");
        adapter.addFragment(new TwoFragment(), "Feeds");
        adapter.addFragment(new ThreeFragment(), "Chat Room");
        adapter.addFragment(new FourFragment(), "Options");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter{

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentTitleList.add(title);
            mFragmentList.add(fragment);
        }

        @Override
        public CharSequence getPageTitle(int position) {
//            return mFragmentTitleList.get(position);
            return null;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void bottomClick(View v) {
        //Shared Element transition
    }
}