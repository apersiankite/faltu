package com.zoomcar.prateek.faltu.network;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Prateek on 25/09/15.
 */
public class SampleVO implements Parcelable{

    public String name;
    public String age;

    protected SampleVO(Parcel in) {
        name = in.readString();
        age = in.readString();
    }

    public static final Creator<SampleVO> CREATOR = new Creator<SampleVO>() {
        @Override
        public SampleVO createFromParcel(Parcel in) {
            return new SampleVO(in);
        }

        @Override
        public SampleVO[] newArray(int size) {
            return new SampleVO[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(age);
    }
}
