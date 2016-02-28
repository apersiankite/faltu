package com.zoomcar.prateek.faltu.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;
import com.zoomcar.prateek.faltu.R;

import java.util.Calendar;

/**
 * Created by Prateek on 18/09/15.
 */
public class CalendarActivity extends AppCompatActivity implements OnDateSelectedListener {

    private MaterialCalendarView mPickupCalendarView;
    private MaterialCalendarView mDropCalendarView;
    private TextView mTextSelectedDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        mPickupCalendarView = (MaterialCalendarView) findViewById(R.id.pickup_calendar);
        mDropCalendarView = (MaterialCalendarView) findViewById(R.id.drop_calendar);
        Calendar cal = Calendar.getInstance();
        mPickupCalendarView.setCurrentDate(cal);
        mPickupCalendarView.setMinimumDate(cal);
        cal.add(Calendar.DAY_OF_YEAR, 60);
        mPickupCalendarView.setOnDateChangedListener(this);
    }

    @Override
    public void onDateSelected(MaterialCalendarView widget, CalendarDay date, boolean selected) {
        Toast.makeText(CalendarActivity.this, date.toString(),Toast.LENGTH_SHORT).show();;
    }
}
