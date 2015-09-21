package com.zoomcar.prateek.faltu.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateChangedListener;
import com.zoomcar.prateek.faltu.R;

import java.util.Calendar;

/**
 * Created by Prateek on 18/09/15.
 */
public class CalendarActivity extends AppCompatActivity implements OnDateChangedListener {

    private MaterialCalendarView mCalendarView;
    private TextView mTextSelectedDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        mCalendarView = (MaterialCalendarView) findViewById(R.id.calendarView);
        mTextSelectedDate = (TextView) findViewById(R.id.text_selected_date);
        Calendar cal = Calendar.getInstance();
        mCalendarView.setCurrentDate(cal);
        mCalendarView.setMinimumDate(cal);
        cal.add(Calendar.DAY_OF_YEAR, 60);
        mCalendarView.setMaximumDate(cal);
        mCalendarView.setOnDateChangedListener(this);
    }

    @Override
    public void onDateChanged(MaterialCalendarView materialCalendarView, CalendarDay calendarDay) {
        mTextSelectedDate.setText(calendarDay.toString());
    }
}
