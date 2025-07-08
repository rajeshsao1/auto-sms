package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.os.SystemClock;

public final class zzmv {
    private static IntentFilter zzaob = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    private static long zzaoc;
    private static float zzaod = Float.NaN;

    public static int zzax(Context context) {
        if (context == null || context.getApplicationContext() == null) {
            return -1;
        }
        Intent registerReceiver = context.getApplicationContext().registerReceiver((BroadcastReceiver) null, zzaob);
        int i = 0;
        if (((registerReceiver == null ? 0 : registerReceiver.getIntExtra("plugged", 0)) & 7) != 0) {
            i = 1;
        }
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            return -1;
        }
        return ((zzne.zzsl() ? powerManager.isInteractive() : powerManager.isScreenOn() ? 1 : 0) << true) | i;
    }

    public static synchronized float zzay(Context context) {
        synchronized (zzmv.class) {
            if (SystemClock.elapsedRealtime() - zzaoc < 60000) {
                float f = zzaod;
                if (f != Float.NaN) {
                    return f;
                }
            }
            Intent registerReceiver = context.getApplicationContext().registerReceiver((BroadcastReceiver) null, zzaob);
            if (registerReceiver != null) {
                zzaod = ((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1));
            }
            zzaoc = SystemClock.elapsedRealtime();
            float f2 = zzaod;
            return f2;
        }
    }
}
