package com.google.android.gms.common.stats;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Debug;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.common.stats.zzc;
import com.google.android.gms.internal.zzmp;
import com.google.android.gms.internal.zznf;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class zzb {
    private static final Object zzalX = new Object();
    private static zzb zzanp;
    private static Integer zzanv;
    private final List<String> zzanq;
    private final List<String> zzanr;
    private final List<String> zzans;
    private final List<String> zzant;
    private zze zzanu;
    private zze zzanw;

    private zzb() {
        if (getLogLevel() == zzd.LOG_LEVEL_OFF) {
            this.zzanq = Collections.EMPTY_LIST;
            this.zzanr = Collections.EMPTY_LIST;
            this.zzans = Collections.EMPTY_LIST;
            this.zzant = Collections.EMPTY_LIST;
            return;
        }
        String str = zzc.zza.zzanA.get();
        this.zzanq = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(","));
        String str2 = zzc.zza.zzanB.get();
        this.zzanr = str2 == null ? Collections.EMPTY_LIST : Arrays.asList(str2.split(","));
        String str3 = zzc.zza.zzanC.get();
        this.zzans = str3 == null ? Collections.EMPTY_LIST : Arrays.asList(str3.split(","));
        String str4 = zzc.zza.zzanD.get();
        this.zzant = str4 == null ? Collections.EMPTY_LIST : Arrays.asList(str4.split(","));
        this.zzanu = new zze(1024, zzc.zza.zzanE.get().longValue());
        this.zzanw = new zze(1024, zzc.zza.zzanE.get().longValue());
    }

    private static int getLogLevel() {
        if (zzanv == null) {
            try {
                zzanv = Integer.valueOf(zzmp.zzkr() ? zzc.zza.zzanz.get().intValue() : zzd.LOG_LEVEL_OFF);
            } catch (SecurityException e) {
                zzanv = Integer.valueOf(zzd.LOG_LEVEL_OFF);
            }
        }
        return zzanv.intValue();
    }

    private void zza(Context context, String str, int i, String str2, String str3, String str4, String str5) {
        int i2 = i;
        long currentTimeMillis = System.currentTimeMillis();
        String zzn = ((getLogLevel() & zzd.zzanJ) == 0 || i2 == 13) ? null : zznf.zzn(3, 5);
        long j = 0;
        if ((getLogLevel() & zzd.zzanL) != 0) {
            j = Debug.getNativeHeapAllocatedSize();
        }
        long j2 = j;
        context.startService(new Intent().setComponent(zzd.zzanF).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", (i2 == 1 || i2 == 4 || i2 == 14) ? new ConnectionEvent(currentTimeMillis, i, (String) null, (String) null, (String) null, (String) null, zzn, str, SystemClock.elapsedRealtime(), j2) : new ConnectionEvent(currentTimeMillis, i, str2, str3, str4, str5, zzn, str, SystemClock.elapsedRealtime(), j2)));
    }

    private void zza(Context context, String str, String str2, Intent intent, int i) {
        zze zze;
        String str3;
        String str4;
        if (zzrQ() && (zze = this.zzanu) != null) {
            String str5 = null;
            if (i != 4 && i != 1) {
                ServiceInfo zzd = zzd(context, intent);
                if (zzd == null) {
                    Log.w("ConnectionTracker", String.format("Client %s made an invalid request %s", new Object[]{str2, intent.toUri(0)}));
                    return;
                }
                String str6 = zzd.processName;
                String str7 = zzd.name;
                str4 = zznf.zzaz(context);
                if (zzb(str4, str2, str6, str7)) {
                    this.zzanu.zzcS(str);
                    str5 = str6;
                    str3 = str7;
                } else {
                    return;
                }
            } else if (zze.zzcT(str)) {
                str4 = null;
                str3 = null;
            } else {
                return;
            }
            zza(context, str, i, str4, str2, str5, str3);
        }
    }

    private String zzb(ServiceConnection serviceConnection) {
        return String.valueOf((((long) Process.myPid()) << 32) | ((long) System.identityHashCode(serviceConnection)));
    }

    private boolean zzb(String str, String str2, String str3, String str4) {
        int logLevel = getLogLevel();
        if (this.zzanq.contains(str) || this.zzanr.contains(str2) || this.zzans.contains(str3) || this.zzant.contains(str4)) {
            return false;
        }
        return !str3.equals(str) || (zzd.zzanK & logLevel) == 0;
    }

    private boolean zzc(Context context, Intent intent) {
        ComponentName component = intent.getComponent();
        if (component == null) {
            return false;
        }
        if (!zzd.zzakE || !"com.google.android.gms".equals(component.getPackageName())) {
            return zzmp.zzk(context, component.getPackageName());
        }
        return false;
    }

    private static ServiceInfo zzd(Context context, Intent intent) {
        String format;
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 128);
        if (queryIntentServices == null || queryIntentServices.size() == 0) {
            format = String.format("There are no handler of this intent: %s\n Stack trace: %s", new Object[]{intent.toUri(0), zznf.zzn(3, 20)});
        } else {
            if (queryIntentServices.size() > 1) {
                Log.w("ConnectionTracker", String.format("Multiple handlers found for this intent: %s\n Stack trace: %s", new Object[]{intent.toUri(0), zznf.zzn(3, 20)}));
                Iterator<ResolveInfo> it = queryIntentServices.iterator();
                if (it.hasNext()) {
                    format = it.next().serviceInfo.name;
                }
            }
            return queryIntentServices.get(0).serviceInfo;
        }
        Log.w("ConnectionTracker", format);
        return null;
    }

    public static zzb zzrP() {
        synchronized (zzalX) {
            if (zzanp == null) {
                zzanp = new zzb();
            }
        }
        return zzanp;
    }

    private boolean zzrQ() {
        return zzd.zzakE && getLogLevel() != zzd.LOG_LEVEL_OFF;
    }

    public void zza(Context context, ServiceConnection serviceConnection) {
        context.unbindService(serviceConnection);
        zza(context, zzb(serviceConnection), (String) null, (Intent) null, 1);
    }

    public void zza(Context context, ServiceConnection serviceConnection, String str, Intent intent) {
        zza(context, zzb(serviceConnection), str, intent, 3);
    }

    public boolean zza(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
        return zza(context, context.getClass().getName(), intent, serviceConnection, i);
    }

    public boolean zza(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i) {
        if (zzc(context, intent)) {
            Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
            return false;
        }
        boolean bindService = context.bindService(intent, serviceConnection, i);
        if (bindService) {
            zza(context, zzb(serviceConnection), str, intent, 2);
        }
        return bindService;
    }

    public void zzb(Context context, ServiceConnection serviceConnection) {
        zza(context, zzb(serviceConnection), (String) null, (Intent) null, 4);
    }
}
