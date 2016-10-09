package com.example.sunddenfix.mddemo.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sunddenfix.mddemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LikeFragment extends Fragment {

    public static LikeFragment newInstance() {
        return new LikeFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_like, container, false);
    }

}
