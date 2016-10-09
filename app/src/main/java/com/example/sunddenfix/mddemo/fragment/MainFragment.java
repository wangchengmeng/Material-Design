package com.example.sunddenfix.mddemo.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.sunddenfix.mddemo.R;
import com.example.sunddenfix.mddemo.adapter.TabAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private List<Fragment> mFragmentList;
    private List<String>   mTabTitleList;
    private TabAdapter     mTabAdapter;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initVariables();
    }

    private void initVariables() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        mTabLayout = (TabLayout) rootView.findViewById(R.id.tab_FindFragment_title);
        mViewPager = (ViewPager) rootView.findViewById(R.id.vp_FindFragment_pager);

        initContent();
        return rootView;
    }

    private void initContent() {
        PerimeterFragment perimeterFragment = PerimeterFragment.newInstance();
        InCountryFragment inCountryFragment = InCountryFragment.newInstance();
        AirplanFragment airplanFragment = AirplanFragment.newInstance();
        TourFragment tourFragment = TourFragment.newInstance();
        TrainFragment trainFragment = TrainFragment.newInstance();
        InternationalFragment internationalFragment = InternationalFragment.newInstance();
        ShakeFragment shakeFragment = ShakeFragment.newInstance();
        NearbyFragment nearbyFragment = NearbyFragment.newInstance();
        if (null == mFragmentList) {
            mFragmentList = new ArrayList<>();
        }

        if (null == mTabTitleList) {
            mTabTitleList = new ArrayList<>();
        }

        mFragmentList.add(perimeterFragment);
        mFragmentList.add(inCountryFragment);
        mFragmentList.add(airplanFragment);
        mFragmentList.add(tourFragment);
        mFragmentList.add(trainFragment);
        mFragmentList.add(internationalFragment);
        mFragmentList.add(shakeFragment);
        mFragmentList.add(nearbyFragment);

        mTabTitleList.add("周边");
        mTabTitleList.add("国内");
        mTabTitleList.add("机票");
        mTabTitleList.add("旅游");
        mTabTitleList.add("火车票");
        mTabTitleList.add("国际");
        mTabTitleList.add("摇一摇");
        mTabTitleList.add("附近");

        //设置TabLayout的模式
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        //设置标题
        for (String title : mTabTitleList) {
            mTabLayout.addTab(mTabLayout.newTab().setText(title));
        }
        mTabAdapter = new TabAdapter(getActivity().getSupportFragmentManager(), mFragmentList, mTabTitleList);
        mViewPager.setAdapter(mTabAdapter);
        mTabLayout.setupWithViewPager(mViewPager);


        //给tab添加Listener
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //当页面选中的时候调用  tab.getPosition()是tab对应的位置，0开始
                Toast.makeText(getActivity(), "onTabSelected" + tab.getPosition(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                Toast.makeText(getActivity(), "onTabUnselected" + tab.getPosition(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                Toast.makeText(getActivity(), "onTabReselected" + tab.getPosition(), Toast.LENGTH_SHORT).show();

            }
        });
    }


}
