package com.google.android.gms.playlog.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzsu;
import com.google.android.gms.playlog.internal.zza;
import com.google.android.gms.playlog.internal.zzb;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class zzf extends zzj<zza> {
    private final String zzTJ;
    private final zzd zzbdT;
    private final zzb zzbdU = new zzb();
    private boolean zzbdV = true;
    private final Object zzpV = new Object();

    public zzf(Context context, Looper looper, zzd zzd, com.google.android.gms.common.internal.zzf zzf) {
        super(context, looper, 24, zzf, zzd, zzd);
        this.zzTJ = context.getPackageName();
        zzd zzd2 = (zzd) zzx.zzz(zzd);
        this.zzbdT = zzd2;
        zzd2.zza(this);
    }

    private void zzEW() {
        LogEvent logEvent;
        zzb.zzab(!this.zzbdV);
        if (!this.zzbdU.isEmpty()) {
            PlayLoggerContext playLoggerContext = null;
            try {
                ArrayList arrayList = new ArrayList();
                Iterator<zzb.zza> it = this.zzbdU.zzEU().iterator();
                while (it.hasNext()) {
                    zzb.zza next = it.next();
                    if (next.zzbdI != null) {
                        ((zza) zzqJ()).zza(this.zzTJ, next.zzbdG, zzsu.toByteArray(next.zzbdI));
                    } else {
                        if (next.zzbdG.equals(playLoggerContext)) {
                            logEvent = next.zzbdH;
                        } else {
                            if (!arrayList.isEmpty()) {
                                ((zza) zzqJ()).zza(this.zzTJ, playLoggerContext, (List<LogEvent>) arrayList);
                                arrayList.clear();
                            }
                            playLoggerContext = next.zzbdG;
                            logEvent = next.zzbdH;
                        }
                        arrayList.add(logEvent);
                    }
                }
                if (!arrayList.isEmpty()) {
                    ((zza) zzqJ()).zza(this.zzTJ, playLoggerContext, (List<LogEvent>) arrayList);
                }
                this.zzbdU.clear();
            } catch (RemoteException e) {
                Log.e("PlayLoggerImpl", "Couldn't send cached log events to AndroidLog service.  Retaining in memory cache.");
            }
        }
    }

    private void zzc(PlayLoggerContext playLoggerContext, LogEvent logEvent) {
        this.zzbdU.zza(playLoggerContext, logEvent);
    }

    private void zzd(PlayLoggerContext playLoggerContext, LogEvent logEvent) {
        String str;
        try {
            zzEW();
            ((zza) zzqJ()).zza(this.zzTJ, playLoggerContext, logEvent);
            return;
        } catch (RemoteException e) {
            str = "Couldn't send log event.  Will try caching.";
        } catch (IllegalStateException e2) {
            str = "Service was disconnected.  Will try caching.";
        }
        Log.e("PlayLoggerImpl", str);
        zzc(playLoggerContext, logEvent);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void start() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.zzpV
            monitor-enter(r0)
            boolean r1 = r3.isConnecting()     // Catch:{ all -> 0x001d }
            if (r1 != 0) goto L_0x001b
            boolean r1 = r3.isConnected()     // Catch:{ all -> 0x001d }
            if (r1 == 0) goto L_0x0010
            goto L_0x001b
        L_0x0010:
            com.google.android.gms.playlog.internal.zzd r1 = r3.zzbdT     // Catch:{ all -> 0x001d }
            r2 = 1
            r1.zzat(r2)     // Catch:{ all -> 0x001d }
            r3.zzqG()     // Catch:{ all -> 0x001d }
            monitor-exit(r0)     // Catch:{ all -> 0x001d }
            return
        L_0x001b:
            monitor-exit(r0)     // Catch:{ all -> 0x001d }
            return
        L_0x001d:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001d }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.playlog.internal.zzf.start():void");
    }

    public void stop() {
        synchronized (this.zzpV) {
            this.zzbdT.zzat(false);
            disconnect();
        }
    }

    /* access modifiers changed from: package-private */
    public void zzau(boolean z) {
        synchronized (this.zzpV) {
            boolean z2 = this.zzbdV;
            this.zzbdV = z;
            if (z2 && !z) {
                zzEW();
            }
        }
    }

    public void zzb(PlayLoggerContext playLoggerContext, LogEvent logEvent) {
        synchronized (this.zzpV) {
            if (this.zzbdV) {
                zzc(playLoggerContext, logEvent);
            } else {
                zzd(playLoggerContext, logEvent);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzdO */
    public zza zzW(IBinder iBinder) {
        return zza.C0041zza.zzdN(iBinder);
    }

    /* access modifiers changed from: protected */
    public String zzgu() {
        return "com.google.android.gms.playlog.service.START";
    }

    /* access modifiers changed from: protected */
    public String zzgv() {
        return "com.google.android.gms.playlog.internal.IPlayLogService";
    }
}
