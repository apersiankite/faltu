package com.zoomcar.prateek.faltu.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.Tab;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.zoomcar.prateek.faltu.R;

/**
 * Created by Prateek on 25/09/15.
 */
public class ZoomMainActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoom_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        setTitle("Kaggadasapura");
        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mTabLayout.addTab(mTabLayout.newTab().setText("Zoom Now"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Zoom Later"));

    }
}
