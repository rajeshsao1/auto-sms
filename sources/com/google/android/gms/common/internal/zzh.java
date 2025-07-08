package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import androidx.fragment.app.Fragment;

public class zzh implements DialogInterface.OnClickListener {
    private final Activity mActivity;
    private final Intent mIntent;
    private final int zzagz;
    private final Fragment zzalg;

    public zzh(Activity activity, Intent intent, int i) {
        this.mActivity = activity;
        this.zzalg = null;
        this.mIntent = intent;
        this.zzagz = i;
    }

    public zzh(Fragment fragment, Intent intent, int i) {
        this.mActivity = null;
        this.zzalg = fragment;
        this.mIntent = intent;
        this.zzagz = i;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        Fragment fragment;
        try {
            Intent intent = this.mIntent;
            if (intent != null && (fragment = this.zzalg) != null) {
                fragment.startActivityForResult(intent, this.zzagz);
            } else if (intent != null) {
                this.mActivity.startActivityForResult(intent, this.zzagz);
            }
            dialogInterface.dismiss();
        } catch (ActivityNotFoundException e) {
            Log.e("SettingsRedirect", "Can't redirect to app settings for Google Play services");
        }
    }
}
