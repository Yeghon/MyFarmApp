package com.yeghon.myfarmapp.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.yeghon.myfarmapp.R;

/**
 * Created on Thursday, 10/8/20
 * By YeghonHaron.
 * Copyright 2020 Yjungle Inc.
 */
public class NewsActivity extends Fragment {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragments_recycler_view, null);
        /*ViewGroup viewGroup = (ViewGroup) view.findViewById(android.R.id.content);

        MyAdapter myAdapter = new MyAdapter(getActivity(), mButtonList);

        mRecyclerView = view.findViewById(R.id.recyclerview);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);

        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2) {
            @Override
            public boolean checkLayoutParams(RecyclerView.LayoutParams lp) {
                // force height of viewHolder here, this will override layout_height from xml
                lp.height = getHeight() / mButtonList.size() * 2;
                return true;
            }
        });

        mRecyclerView.setAdapter(myAdapter);
         */
        return view;
    }
}
