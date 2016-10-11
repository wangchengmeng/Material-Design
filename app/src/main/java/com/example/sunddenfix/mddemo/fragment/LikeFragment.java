package com.example.sunddenfix.mddemo.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sunddenfix.mddemo.R;
import com.example.sunddenfix.mddemo.adapter.CityRecyclerAdapter;
import com.example.sunddenfix.mddemo.decoretion.CityModel;
import com.example.sunddenfix.mddemo.decoretion.DividerItemDecoration;
import com.example.sunddenfix.mddemo.decoretion.RecylerItemDecoration;
import com.example.sunddenfix.mddemo.decoretion.TitleItemDecoration2;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class LikeFragment extends Fragment {

    private CityRecyclerAdapter   mCityRecyclerAdapter;
    private RecylerItemDecoration mDecoration;
    private DividerItemDecoration mDividerItemDecoration;
    private TitleItemDecoration2  mTitleItemDecoration2;

    public static LikeFragment newInstance() {
        return new LikeFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initVariables();
    }

    private void initVariables() {
        List<CityModel> cityModelList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            CityModel cityModel = new CityModel();
            cityModel.setTag("A");
            cityModel.setName("ali-" + i);
            cityModelList.add(cityModel);
        }
        for (int i = 0; i < 10; i++) {
            CityModel cityModel = new CityModel();
            cityModel.setTag("B");
            cityModel.setName("bli-" + i);
            cityModelList.add(cityModel);
        }
        for (int i = 0; i < 10; i++) {
            CityModel cityModel = new CityModel();
            cityModel.setTag("C");
            cityModel.setName("cli-" + i);
            cityModelList.add(cityModel);
        }
        for (int i = 0; i < 10; i++) {
            CityModel cityModel = new CityModel();
            cityModel.setTag("D");
            cityModel.setName("dli-" + i);
            cityModelList.add(cityModel);
        }
        for (int i = 0; i < 10; i++) {
            CityModel cityModel = new CityModel();
            cityModel.setTag("D");
            cityModel.setName("dli-" + i);
            cityModelList.add(cityModel);
        }
        for (int i = 0; i < 10; i++) {
            CityModel cityModel = new CityModel();
            cityModel.setTag("E");
            cityModel.setName("eli-" + i);
            cityModelList.add(cityModel);
        }
        for (int i = 0; i < 10; i++) {
            CityModel cityModel = new CityModel();
            cityModel.setTag("F");
            cityModel.setName("fli-" + i);
            cityModelList.add(cityModel);
        }
        for (int i = 0; i < 10; i++) {
            CityModel cityModel = new CityModel();
            cityModel.setTag("G");
            cityModel.setName("gli-" + i);
            cityModelList.add(cityModel);
        }
        for (int i = 0; i < 10; i++) {
            CityModel cityModel = new CityModel();
            cityModel.setTag("H");
            cityModel.setName("hli-" + i);
            cityModelList.add(cityModel);
        }
        mCityRecyclerAdapter = new CityRecyclerAdapter(cityModelList);
        mDecoration = new RecylerItemDecoration(getActivity(), cityModelList);
        mDividerItemDecoration = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST);
        mTitleItemDecoration2 = new TitleItemDecoration2(getActivity(), cityModelList);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_like, container, false);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recylerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(mCityRecyclerAdapter);
        recyclerView.addItemDecoration(mDecoration);
//        recyclerView.addItemDecoration(mTitleItemDecoration2);
        recyclerView.addItemDecoration(mDividerItemDecoration);
        return rootView;
    }

}
