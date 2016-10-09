package com.example.sunddenfix.mddemo.fragment;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.sunddenfix.mddemo.R;
import com.example.sunddenfix.mddemo.adapter.AlbumAdapter;
import com.example.sunddenfix.mddemo.help.SpacesItemDecoration;
import com.example.sunddenfix.mddemo.utils.DensityUtils;
import com.example.sunddenfix.mddemo.utils.FastBlur;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * A simple {@link Fragment} subclass.
 */
public class AlbumFragment extends Fragment {

    private CoordinatorLayout       mCoordinatorLayout;
    private RecyclerView            mRecyclerView;
    private AppBarLayout            mAppBarLayout;
    private Toolbar                 mToolbar;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private FloatingActionButton    mFloatingActionButton;
    private ImageView               mIvBgView;

    public static AlbumFragment newInstance() {
        return new AlbumFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_album, container, false);
        mCoordinatorLayout = (CoordinatorLayout) rootView.findViewById(R.id.coordinator_root);
        mCollapsingToolbarLayout = (CollapsingToolbarLayout) rootView.findViewById(R.id.collapsingToolbarLayout);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recylerview);
        mAppBarLayout = (AppBarLayout) rootView.findViewById(R.id.abl_bar);
        mFloatingActionButton = (FloatingActionButton) rootView.findViewById(R.id.fab);
        mToolbar = (Toolbar) rootView.findViewById(R.id.toolbar);
        mIvBgView = (ImageView) rootView.findViewById(R.id.iv_bg);

        initVariables();
        initViews();

        return rootView;
    }

    private void initVariables() {

        List<String> albumListName = new ArrayList<>();
        for (int i = 0; i < 21; i++) {
            albumListName.add("相册" + i);
        }

        //设置RecyclerView
        AlbumAdapter albumAdapter = new AlbumAdapter(getActivity(), albumListName);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        //设置item之间的间隔
        SpacesItemDecoration decoration = new SpacesItemDecoration(16);
        mRecyclerView.addItemDecoration(decoration);

        mRecyclerView.setAdapter(albumAdapter);
    }

    private void initViews() {

        //        mToolbar.setTitle("wangchengmeng");// 标题的文字需在setSupportActionBar之前，不然会无效
        ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);


        //设置mCollapsingToolbarLayout的标题 以及标题颜色 折叠前后
        mCollapsingToolbarLayout.setTitle("wangchengmeng");
        mCollapsingToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(R.color.black));//设置折叠之后标题的颜色
        mCollapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(R.color.colorAccent));//设置展开之后标题的颜色


        final Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.bg);
        ExecutorService executors = Executors.newFixedThreadPool(1);
        executors.execute(new Runnable() {
            @Override
            public void run() {
                Bitmap blurBitmap = FastBlur.blur(bitmap, DensityUtils.getScreenW(), DensityUtils.getMeasureValue(622));
                mIvBgView.setImageBitmap(blurBitmap);
            }
        });

    }

}
