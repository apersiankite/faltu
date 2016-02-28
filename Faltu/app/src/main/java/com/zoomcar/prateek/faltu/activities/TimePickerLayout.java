package com.zoomcar.prateek.faltu.activities;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.RelativeLayout;

/**
 * Created by Prateek on 04/02/16.
 */
public class TimePickerLayout extends FrameLayout {

    private RelativeLayout mLinearLayout;
    private HorizontalScrollView mHorizontalScrollView;

    public TimePickerLayout(Context context) {
        this(context, null);
    }

    public TimePickerLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TimePickerLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

    }
}
