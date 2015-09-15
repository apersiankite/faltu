package com.zoomcar.prateek.faltu.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;

import com.zoomcar.prateek.faltu.R;

/**
 * Created by Prateek on 15/09/15.
 */
public class TestingActionBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing_actionbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_testing_actionbar, menu);
        return true;
    }
}
