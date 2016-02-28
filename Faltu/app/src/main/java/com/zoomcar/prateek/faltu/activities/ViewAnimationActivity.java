package com.zoomcar.prateek.faltu.activities;

import android.animation.Animator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.zoomcar.prateek.faltu.R;

/**
 * Created by Prateek on 29/01/16.
 */
public class ViewAnimationActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout mView;
    Button mButton;
    boolean isExpanded = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_animation);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setTitle("View Animation");
        mView = (LinearLayout) findViewById(R.id.view);
        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(isExpanded){
            mView.animate().setDuration(1000).scaleYBy(0.5F).setListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {
                    Log.d("prateek","onAnimationStart, height : "+mView.getHeight());
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    Log.d("prateek","onAnimationEnd, height : "+mView.getHeight());
                    isExpanded = !isExpanded;
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
        }else{
            mView.animate().setDuration(1000).scaleY(1).setListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {
                    Log.d("prateek","onAnimationStart, height : "+mView.getHeight());
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    Log.d("prateek","onAnimationEnd, height : "+mView.getHeight());
                    isExpanded = !isExpanded;
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
        }
    }
}
