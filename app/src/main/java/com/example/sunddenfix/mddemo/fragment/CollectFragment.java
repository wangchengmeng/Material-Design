package com.example.sunddenfix.mddemo.fragment;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.sunddenfix.mddemo.R;

/**
 * FloatingActionButton 的使用.
 */
public class CollectFragment extends Fragment {

    private FloatingActionButton mFloatingActionButton;
    private RelativeLayout       mRlCollect;

    public static CollectFragment newInstance() {
        return new CollectFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_collet, container, false);
        mFloatingActionButton = (FloatingActionButton) rootView.findViewById(R.id.fab_button);
        mRlCollect = (RelativeLayout) rootView.findViewById(R.id.rl_collect);
        initEvents();
        return rootView;

    }

    private void initEvents() {
        mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mRlCollect  设置成 FAB 的位置参照view  当snackbar出现时 FAB就可以上下移动
                Snackbar.make(mRlCollect, "点击了=FAB", Snackbar.LENGTH_SHORT).show();
            }
        });
    }

}
