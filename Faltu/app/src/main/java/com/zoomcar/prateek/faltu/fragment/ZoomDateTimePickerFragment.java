package com.zoomcar.prateek.faltu.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;
import com.zoomcar.prateek.faltu.R;
import com.zoomcar.prateek.faltu.activities.TimeSelectionAdapter;

import java.util.Calendar;

/**
 * Created by Prateek on 20/01/16.
 */
public class ZoomDateTimePickerFragment extends Fragment implements OnDateSelectedListener {

    private MaterialCalendarView mCalendarView;
    private RecyclerView mTimeSelectionList;
    public static final String MIN_DATE = "min_date";
    private CalendarDay mMinDay;
    private CalendarDay selectedDate;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if(getArguments() != null ) {
            mMinDay = getArguments().getParcelable(MIN_DATE);
        }

        View rootLayout = inflater.inflate(R.layout.fragment_zoom_date_time_picker, container, false);
        mCalendarView = (MaterialCalendarView) rootLayout.findViewById(R.id.calendar_view);

        if(mMinDay != null){
            mCalendarView.setMinimumDate(mMinDay);
        }else{
            mCalendarView.setMinimumDate(Calendar.getInstance());
        }
        mCalendarView.setOnDateChangedListener(this);

        mTimeSelectionList = (RecyclerView) rootLayout.findViewById(R.id.time_selection_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(container.getContext(), LinearLayoutManager.HORIZONTAL, false);
        mTimeSelectionList.setLayoutManager(layoutManager);
        mTimeSelectionList.setAdapter(new TimeSelectionAdapter());
        return rootLayout;
    }

    @Override
    public void onDateSelected(MaterialCalendarView widget, CalendarDay date, boolean selected) {

    }
}
