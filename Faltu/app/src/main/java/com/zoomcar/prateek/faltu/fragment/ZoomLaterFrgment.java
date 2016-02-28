package com.zoomcar.prateek.faltu.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zoomcar.prateek.faltu.R;

/**
 * Created by Prateek on 14/01/16.
 */
public class ZoomLaterFrgment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootLayout = inflater.inflate(R.layout.fragment_zoom_later,container,false);
        return rootLayout;
    }
}
