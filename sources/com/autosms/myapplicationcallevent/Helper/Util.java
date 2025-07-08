package com.autosms.myapplicationcallevent.Helper;

import android.content.Context;
import android.widget.Toast;

public class Util {
    public void showToast(Context c, String msg) {
        Toast.makeText(c, "" + msg, 0).show();
    }
}
