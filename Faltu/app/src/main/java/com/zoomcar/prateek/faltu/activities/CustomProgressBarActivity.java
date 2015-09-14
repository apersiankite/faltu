package com.zoomcar.prateek.faltu.activities;

import android.app.ProgressDialog;
import android.graphics.drawable.Drawable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.zoomcar.prateek.faltu.R;

import java.util.Timer;
import java.util.TimerTask;

public class CustomProgressBarActivity extends AppCompatActivity implements View.OnClickListener{

    private ProgressDialog progressDialog;
    private  final int MAX_PROGRESS=100;
    private final int MIN_PROGRESS=0;
    private final int CURRENT_PROGRESS=50;
    private Drawable mProgressBarDrawable;
    private Toolbar mToolbar;
    private Button mShowSnackbar;
    private Snackbar snackbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_progress_bar);
        mToolbar= (Toolbar) findViewById(R.id.app_toolbar);
        setSupportActionBar(mToolbar);
        mShowSnackbar= (Button) findViewById(R.id.button_show_snackbar);
        progressDialog=new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setMax(MAX_PROGRESS);
        progressDialog.setProgress(MIN_PROGRESS);
        progressDialog.setSecondaryProgress(CURRENT_PROGRESS);
        mProgressBarDrawable=getResources().getDrawable(R.drawable.custom_progress_bar);
        progressDialog.setProgressDrawable(mProgressBarDrawable);
        progressDialog.show();
        progressDialog.setCancelable(true);
        mShowSnackbar.setOnClickListener(this);
        final Timer t = new Timer();
        t.schedule(new TimerTask() {
            public void run() {
                progressDialog.dismiss(); // when the task active then close the dialog
                t.cancel(); // also just top the timer thread, otherwise, you may receive a crash report
            }
        }, 3000);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_custom_progress_bar, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        Snackbar.make(v, getString(R.string.snackbarMessage), Snackbar.LENGTH_LONG).setAction(R.string.show_action_finishActivity, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        }).show();

        v.setBackgroundColor(getResources().getColor(R.color.snackbar_background_color));


    }
}
