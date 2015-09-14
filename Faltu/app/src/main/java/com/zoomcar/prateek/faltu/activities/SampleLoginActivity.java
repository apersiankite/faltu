package com.zoomcar.prateek.faltu.activities;

import android.os.Bundle;
import android.view.MenuItem;

import com.zoomcar.prateek.faltu.R;

/**
 * Created by Prateek on 11/09/15.
 */
public class SampleLoginActivity extends TransparentActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_login);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onHomeIcon() {
        finish();
    }
}
