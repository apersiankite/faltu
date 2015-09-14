package com.zoomcar.prateek.faltu.activities;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;

import com.zoomcar.prateek.faltu.R;

/**
 * Created by Prateek on 11/09/15.
 */
public abstract class TransparentActionBarActivity extends AppCompatActivity implements View.OnClickListener {

    protected Toolbar toolbar;

    @Override
    public void setContentView(int layoutResID) {
        View rootLayout = getLayoutInflater().inflate(R.layout.activity_transparent_actionbar, null);
        ViewGroup activityContentLayout = (ViewGroup) rootLayout.findViewById(R.id.activity_content_layout);
        getLayoutInflater().inflate(layoutResID, activityContentLayout, true);
        toolbar = (Toolbar) rootLayout.findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(getResources().getColor(R.color.transparent));
        setSupportActionBar(toolbar);
        super.setContentView(rootLayout);
    }

    protected void setHomeAsUpEnabled(){
        if(toolbar != null){
            toolbar.setNavigationIcon(R.mipmap.ic_launcher);
            toolbar.setNavigationOnClickListener(this);
        }else{
            throw new IllegalStateException("Toolbar is not set");
        }
    }

    @Override
    public void onClick(View v) {

    }

    protected abstract void onHomeIcon();
}
