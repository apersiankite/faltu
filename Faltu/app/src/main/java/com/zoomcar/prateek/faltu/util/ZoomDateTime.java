package com.zoomcar.prateek.faltu.util;

import android.os.Parcel;
import android.os.Parcelable;

import com.prolificinteractive.materialcalendarview.CalendarDay;

/**
 * Created by Prateek on 20/01/16.
 */
public class ZoomDateTime implements Parcelable {

    private CalendarDay day;
    private int hour;
    private int minute;

    protected ZoomDateTime(Parcel in) {
       // day = in.read
    }

    public static final Creator<ZoomDateTime> CREATOR = new Creator<ZoomDateTime>() {
        @Override
        public ZoomDateTime createFromParcel(Parcel in) {
            return new ZoomDateTime(in);
        }

        @Override
        public ZoomDateTime[] newArray(int size) {
            return new ZoomDateTime[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
