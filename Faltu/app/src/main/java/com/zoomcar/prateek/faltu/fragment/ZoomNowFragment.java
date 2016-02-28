package com.zoomcar.prateek.faltu.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zoomcar.prateek.faltu.R;
import com.zoomcar.prateek.faltu.adapter.ZoomNowListAdapter;

/**
 * Created by Prateek on 14/01/16.
 */
public class ZoomNowFragment extends Fragment {

    private RecyclerView mListZoomNow;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootLayout = inflater.inflate(R.layout.fragment_zoom_now,container,false);
        mListZoomNow = (RecyclerView) rootLayout.findViewById(R.id.list_zoom_now);
        mListZoomNow.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        mListZoomNow.setAdapter(new ZoomNowListAdapter());
        return rootLayout;
    }
}
