package com.autosms.myapplicationcallevent.Helper;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.pixplicity.easyprefs.library.Prefs;
import java.util.ArrayList;

public class MyController extends Application {
    public static final String TAG = MyController.class.getSimpleName();
    public static ArrayList<String> arrayList = new ArrayList<>();
    private static MyController mInstance;
    private ImageLoader mImageLoader;
    private RequestQueue mRequestQueue;

    public void onCreate() {
        super.onCreate();
        mInstance = this;
        new Prefs.Builder().setContext(this).setMode(0).setPrefsName(getPackageName()).setUseDefaultSharedPreference(true).build();
    }

    public static synchronized MyController getInstance() {
        MyController myController;
        synchronized (MyController.class) {
            myController = mInstance;
        }
        return myController;
    }

    public RequestQueue getRequestQueue() {
        if (this.mRequestQueue == null) {
            this.mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        return this.mRequestQueue;
    }

    public static String getDeviceID(Context context) {
        return "d645ab8723ae27c4";
    }

    public <T> void addToRequestQueue(Request<T> req, String tag) {
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag) {
        RequestQueue requestQueue = this.mRequestQueue;
        if (requestQueue != null) {
            requestQueue.cancelAll(tag);
        }
    }
}
