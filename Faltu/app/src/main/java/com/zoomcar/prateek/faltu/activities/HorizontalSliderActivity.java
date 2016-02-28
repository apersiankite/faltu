package com.zoomcar.prateek.faltu.activities;

import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zoomcar.prateek.faltu.R;

public class HorizontalSliderActivity extends AppCompatActivity implements ViewTreeObserver.OnScrollChangedListener, View.OnTouchListener {

    private RelativeLayout mLinearLayout;
    private int mPrevParamsLeftMargin;
    private ImageView mImageSlider;
    private HorizontalScrollView mHorizontalScrollView;
    private TextView mTextViewForHours;
    private Display mDisplay;
    private Point mSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDisplay = getWindowManager().getDefaultDisplay();
        mSize = new Point();
        mDisplay.getSize(mSize);
        Log.d("prateek","size point is : "+mSize);
        setContentView(R.layout.activity_horizontal_slider);
        mTextViewForHours = (TextView) findViewById(R.id.text_view_hours);
        mImageSlider = (ImageView) findViewById(R.id.image_slider);
        mLinearLayout = (RelativeLayout) findViewById(R.id.root_horizontal_scroll);
        mHorizontalScrollView = (HorizontalScrollView) findViewById(R.id.horizontal_scroll_view);
        mHorizontalScrollView.setOnTouchListener(this);
        mHorizontalScrollView.getViewTreeObserver().addOnScrollChangedListener(this);
        for (int i = 0; i < 25; i++) {
            if ((i % 2) == 0) {
                View view = new View(this);
                TextView numberOfHours = new TextView(this);
                numberOfHours.setId(i + 100);
                view.setId(i);
                view.setBackgroundColor(Color.GRAY);
                RelativeLayout.LayoutParams imageSliderParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                RelativeLayout.LayoutParams standViewParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                RelativeLayout.LayoutParams textViewParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                standViewParams.topMargin = getResources().getDimensionPixelSize(R.dimen.slider_top_margin);
                standViewParams.width = getResources().getDimensionPixelSize(R.dimen.slider_width);
                standViewParams.height = getResources().getDimensionPixelSize(R.dimen.slider_large_stand);
                imageSliderParams.leftMargin = (mSize.x) / 2;
                imageSliderParams.topMargin = getResources().getDimensionPixelSize(R.dimen.pointer_top_margin);
                if (i == 0) {
                    standViewParams.leftMargin = (mSize.x) / 2;
                    textViewParams.leftMargin = (mSize.x) / 2 - 20;
                    textViewParams.topMargin = standViewParams.topMargin + getResources().getDimensionPixelSize(R.dimen.slider_large_stand);
                    ;
                } else if (i == 24) {
                    standViewParams.rightMargin = (mSize.x) / 2 - getResources().getDimensionPixelSize(R.dimen.width_slider_between_large_small_stand);
                    standViewParams.leftMargin = mPrevParamsLeftMargin + getResources().getDimensionPixelSize(R.dimen.width_slider_between_large_small_stand);
                    textViewParams.leftMargin = standViewParams.leftMargin - 20;
                } else {
                    standViewParams.leftMargin = mPrevParamsLeftMargin + getResources().getDimensionPixelSize(R.dimen.width_slider_between_large_small_stand);
                    textViewParams.leftMargin = standViewParams.leftMargin - 20;
                }
                numberOfHours.setText(String.format("%02d", (i + 1) / 2));
                numberOfHours.setLayoutParams(textViewParams);
                mImageSlider.setLayoutParams(imageSliderParams);
                numberOfHours.setTextColor(Color.GRAY);
                view.setLayoutParams(standViewParams);
                textViewParams.addRule(RelativeLayout.BELOW, view.getId());
                numberOfHours.setGravity(Gravity.CENTER);
                mLinearLayout.addView(view, standViewParams);
                mLinearLayout.addView(numberOfHours, textViewParams);
                mPrevParamsLeftMargin = standViewParams.leftMargin;
            } else {
                View view = new View(this);
                view.setId(i);
                view.setBackgroundColor(Color.GRAY);
                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                params.leftMargin = mPrevParamsLeftMargin + getResources().getDimensionPixelSize(R.dimen.width_slider_between_large_small_stand);
                ;
                params.topMargin = (int) getResources().getDimension(R.dimen.slider_top_margin);
                params.width = (int) getResources().getDimension(R.dimen.slider_width);
                params.height = (int) getResources().getDimension(R.dimen.slider_small_stand);
                view.setLayoutParams(params);
                mPrevParamsLeftMargin = params.leftMargin;
                mLinearLayout.addView(view, params);
            }


        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_horizontal_slider, menu);

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
    public void onScrollChanged() {
        setTime(false);
    }

    private void setTime(boolean afterMove) {
        int x = mHorizontalScrollView.getScrollX();
        int width = getResources().getDimensionPixelSize(R.dimen.width_slider_between_large_small_stand);
        System.out.println(x + "  " + width);


        if (x % (width) == 0) {
            double time = (0.5 * (x / (width)));
            if (time <= 12.0) {
                mTextViewForHours.setText(Double.toString(time) + " Hours");
                if (afterMove && time <= 12.0)
                    mHorizontalScrollView.scrollTo(x, 0);
            }

        } else {
            double time = (0.5 * ((x / (width)) + 1));
            if (time <= 12.0) {
                mTextViewForHours.setText(Double.toString(time) + " Hours");
                if (afterMove) {
                    mHorizontalScrollView.scrollTo(((x / (width)) + 1) * (width), 0);
                }
            }
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        switch (event.getAction()) {

            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                setTime(true);
                break;
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_CANCEL:
                break;

        }

        return false;

    }
}

