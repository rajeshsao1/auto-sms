package com.google.android.gms.common.stats;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.stats.zzc;
import com.google.android.gms.internal.zzmp;
import com.google.android.gms.internal.zzmv;
import java.util.List;

public class zzi {
    private static String TAG = "WakeLockTracker";
    private static zzi zzanY = new zzi();
    private static Integer zzanv;

    private static int getLogLevel() {
        try {
            return zzmp.zzkr() ? zzc.zzb.zzanz.get().intValue() : zzd.LOG_LEVEL_OFF;
        } catch (SecurityException e) {
            return zzd.LOG_LEVEL_OFF;
        }
    }

    private static boolean zzav(Context context) {
        if (zzanv == null) {
            zzanv = Integer.valueOf(getLogLevel());
        }
        return zzanv.intValue() != zzd.LOG_LEVEL_OFF;
    }

    public static zzi zzrZ() {
        return zzanY;
    }

    public void zza(Context context, String str, int i, String str2, String str3, int i2, List<String> list) {
        zza(context, str, i, str2, str3, i2, list, 0);
    }

    public void zza(Context context, String str, int i, String str2, String str3, int i2, List<String> list, long j) {
        int i3 = i;
        if (zzav(context)) {
            if (TextUtils.isEmpty(str)) {
                String str4 = TAG;
                Log.e(str4, "missing wakeLock key. " + str);
                return;
            }
            String str5 = str;
            long currentTimeMillis = System.currentTimeMillis();
            if (7 == i3 || 8 == i3 || 10 == i3 || 11 == i3) {
                WakeLockEvent wakeLockEvent = r1;
                WakeLockEvent wakeLockEvent2 = new WakeLockEvent(currentTimeMillis, i, str2, i2, list, str, SystemClock.elapsedRealtime(), zzmv.zzax(context), str3, context.getPackageName(), zzmv.zzay(context), j);
                try {
                    context.startService(new Intent().setComponent(zzd.zzanF).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", wakeLockEvent));
                } catch (Exception e) {
                    Log.wtf(TAG, e);
                }
            }
        }
    }
}
