package com.zoomcar.prateek.faltu.network;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.HttpClientStack;
import com.android.volley.toolbox.HttpStack;
import com.android.volley.toolbox.Volley;

/**
 * Created by Prateek on 22/09/15.
 */
public class RequestManager {

    private static RequestQueue mRequestQueue;

    public static synchronized RequestQueue getRequestQueue(Context context){
        if(mRequestQueue == null){
            mRequestQueue = Volley.newRequestQueue(context);
        }
        return mRequestQueue;
    }
}
