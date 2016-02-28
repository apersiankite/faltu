package com.zoomcar.prateek.faltu.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zoomcar.prateek.faltu.R;

/**
 * Created by Prateek on 08/01/16.
 */
public class TimeSelectorActivity extends AppCompatActivity {

    RecyclerView mTimeSelectionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_selector);
        mTimeSelectionList = (RecyclerView) findViewById(R.id.time_selection_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        mTimeSelectionList.setLayoutManager(layoutManager);
        mTimeSelectionList.setAdapter(new TimeSelectionAdapter());
    }
}
