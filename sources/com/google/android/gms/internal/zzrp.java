package com.google.android.gms.internal;

import android.content.Context;
import android.os.PowerManager;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.common.internal.zzx;

public class zzrp {
    private static boolean DEBUG = false;
    private static String TAG = "WakeLock";
    private static String zzbhl = "*gcore*:";
    private final Context mContext;
    private final String zzanQ;
    private final PowerManager.WakeLock zzbhm;
    private WorkSource zzbhn;
    private final int zzbho;
    private final String zzbhp;
    private boolean zzbhq;
    private int zzbhr;
    private int zzbhs;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public zzrp(Context context, int i, String str) {
        this(context, i, str, (String) null, context == null ? null : context.getPackageName());
    }

    public zzrp(Context context, int i, String str, String str2, String str3) {
        this.zzbhq = true;
        zzx.zzh(str, "Wake lock name can NOT be empty");
        this.zzbho = i;
        this.zzbhp = str2;
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        if (zzni.zzcV(str3) || "com.google.android.gms" == str3) {
            this.zzanQ = str;
        } else {
            this.zzanQ = zzbhl + str;
        }
        this.zzbhm = ((PowerManager) context.getSystemService("power")).newWakeLock(i, str);
        if (zznj.zzaA(applicationContext)) {
            if (zzni.zzcV(str3)) {
                if (!zzd.zzakE || !zzlz.isInitialized()) {
                    str3 = context.getPackageName();
                } else {
                    String str4 = TAG;
                    Log.e(str4, "callingPackage is not supposed to be empty for wakelock " + this.zzanQ + "!", new IllegalArgumentException());
                    str3 = "com.google.android.gms";
                }
            }
            WorkSource zzl = zznj.zzl(context, str3);
            this.zzbhn = zzl;
            zzc(zzl);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x006d, code lost:
        if (r10.zzbhs == 1) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0067, code lost:
        if (r0 == false) goto L_0x0069;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void zzfJ(java.lang.String r11) {
        /*
            r10 = this;
            boolean r0 = r10.zzfK(r11)
            java.lang.String r6 = r10.zzn(r11, r0)
            boolean r1 = DEBUG
            if (r1 == 0) goto L_0x005a
            java.lang.String r1 = TAG
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Release:\n mWakeLockName: "
            r2.append(r3)
            java.lang.String r3 = r10.zzanQ
            r2.append(r3)
            java.lang.String r3 = "\n mSecondaryName: "
            r2.append(r3)
            java.lang.String r3 = r10.zzbhp
            r2.append(r3)
            java.lang.String r3 = "\nmReferenceCounted: "
            r2.append(r3)
            boolean r3 = r10.zzbhq
            r2.append(r3)
            java.lang.String r3 = "\nreason: "
            r2.append(r3)
            r2.append(r11)
            java.lang.String r11 = "\n mOpenEventCount"
            r2.append(r11)
            int r11 = r10.zzbhs
            r2.append(r11)
            java.lang.String r11 = "\nuseWithReason: "
            r2.append(r11)
            r2.append(r0)
            java.lang.String r11 = "\ntrackingName: "
            r2.append(r11)
            r2.append(r6)
            java.lang.String r11 = r2.toString()
            android.util.Log.d(r1, r11)
        L_0x005a:
            monitor-enter(r10)
            boolean r11 = r10.zzbhq     // Catch:{ all -> 0x0091 }
            r9 = 1
            if (r11 == 0) goto L_0x0069
            int r1 = r10.zzbhr     // Catch:{ all -> 0x0091 }
            int r1 = r1 - r9
            r10.zzbhr = r1     // Catch:{ all -> 0x0091 }
            if (r1 == 0) goto L_0x006f
            if (r0 != 0) goto L_0x006f
        L_0x0069:
            if (r11 != 0) goto L_0x008f
            int r11 = r10.zzbhs     // Catch:{ all -> 0x0091 }
            if (r11 != r9) goto L_0x008f
        L_0x006f:
            com.google.android.gms.common.stats.zzi r1 = com.google.android.gms.common.stats.zzi.zzrZ()     // Catch:{ all -> 0x0091 }
            android.content.Context r2 = r10.mContext     // Catch:{ all -> 0x0091 }
            android.os.PowerManager$WakeLock r11 = r10.zzbhm     // Catch:{ all -> 0x0091 }
            java.lang.String r3 = com.google.android.gms.common.stats.zzg.zza(r11, r6)     // Catch:{ all -> 0x0091 }
            r4 = 8
            java.lang.String r5 = r10.zzanQ     // Catch:{ all -> 0x0091 }
            int r7 = r10.zzbho     // Catch:{ all -> 0x0091 }
            android.os.WorkSource r11 = r10.zzbhn     // Catch:{ all -> 0x0091 }
            java.util.List r8 = com.google.android.gms.internal.zznj.zzb(r11)     // Catch:{ all -> 0x0091 }
            r1.zza(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0091 }
            int r11 = r10.zzbhs     // Catch:{ all -> 0x0091 }
            int r11 = r11 - r9
            r10.zzbhs = r11     // Catch:{ all -> 0x0091 }
        L_0x008f:
            monitor-exit(r10)     // Catch:{ all -> 0x0091 }
            return
        L_0x0091:
            r11 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x0091 }
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzrp.zzfJ(java.lang.String):void");
    }

    private boolean zzfK(String str) {
        return !TextUtils.isEmpty(str) && !str.equals(this.zzbhp);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0075, code lost:
        if (r11.zzbhs == 0) goto L_0x0077;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x006f, code lost:
        if (r0 == false) goto L_0x0071;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void zzj(java.lang.String r12, long r13) {
        /*
            r11 = this;
            boolean r0 = r11.zzfK(r12)
            java.lang.String r6 = r11.zzn(r12, r0)
            boolean r1 = DEBUG
            if (r1 == 0) goto L_0x0062
            java.lang.String r1 = TAG
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Acquire:\n mWakeLockName: "
            r2.append(r3)
            java.lang.String r3 = r11.zzanQ
            r2.append(r3)
            java.lang.String r3 = "\n mSecondaryName: "
            r2.append(r3)
            java.lang.String r3 = r11.zzbhp
            r2.append(r3)
            java.lang.String r3 = "\nmReferenceCounted: "
            r2.append(r3)
            boolean r3 = r11.zzbhq
            r2.append(r3)
            java.lang.String r3 = "\nreason: "
            r2.append(r3)
            r2.append(r12)
            java.lang.String r12 = "\nmOpenEventCount"
            r2.append(r12)
            int r12 = r11.zzbhs
            r2.append(r12)
            java.lang.String r12 = "\nuseWithReason: "
            r2.append(r12)
            r2.append(r0)
            java.lang.String r12 = "\ntrackingName: "
            r2.append(r12)
            r2.append(r6)
            java.lang.String r12 = "\ntimeout: "
            r2.append(r12)
            r2.append(r13)
            java.lang.String r12 = r2.toString()
            android.util.Log.d(r1, r12)
        L_0x0062:
            monitor-enter(r11)
            boolean r12 = r11.zzbhq     // Catch:{ all -> 0x009a }
            if (r12 == 0) goto L_0x0071
            int r1 = r11.zzbhr     // Catch:{ all -> 0x009a }
            int r2 = r1 + 1
            r11.zzbhr = r2     // Catch:{ all -> 0x009a }
            if (r1 == 0) goto L_0x0077
            if (r0 != 0) goto L_0x0077
        L_0x0071:
            if (r12 != 0) goto L_0x0098
            int r12 = r11.zzbhs     // Catch:{ all -> 0x009a }
            if (r12 != 0) goto L_0x0098
        L_0x0077:
            com.google.android.gms.common.stats.zzi r1 = com.google.android.gms.common.stats.zzi.zzrZ()     // Catch:{ all -> 0x009a }
            android.content.Context r2 = r11.mContext     // Catch:{ all -> 0x009a }
            android.os.PowerManager$WakeLock r12 = r11.zzbhm     // Catch:{ all -> 0x009a }
            java.lang.String r3 = com.google.android.gms.common.stats.zzg.zza(r12, r6)     // Catch:{ all -> 0x009a }
            r4 = 7
            java.lang.String r5 = r11.zzanQ     // Catch:{ all -> 0x009a }
            int r7 = r11.zzbho     // Catch:{ all -> 0x009a }
            android.os.WorkSource r12 = r11.zzbhn     // Catch:{ all -> 0x009a }
            java.util.List r8 = com.google.android.gms.internal.zznj.zzb(r12)     // Catch:{ all -> 0x009a }
            r9 = r13
            r1.zza(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x009a }
            int r12 = r11.zzbhs     // Catch:{ all -> 0x009a }
            int r12 = r12 + 1
            r11.zzbhs = r12     // Catch:{ all -> 0x009a }
        L_0x0098:
            monitor-exit(r11)     // Catch:{ all -> 0x009a }
            return
        L_0x009a:
            r12 = move-exception
            monitor-exit(r11)     // Catch:{ all -> 0x009a }
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzrp.zzj(java.lang.String, long):void");
    }

    private String zzn(String str, boolean z) {
        return (!this.zzbhq || !z) ? this.zzbhp : str;
    }

    public void acquire(long j) {
        if (!zzne.zzsg() && this.zzbhq) {
            String str = TAG;
            Log.wtf(str, "Do not acquire with timeout on reference counted WakeLocks before ICS. wakelock: " + this.zzanQ);
        }
        zzj((String) null, j);
        this.zzbhm.acquire(j);
    }

    public boolean isHeld() {
        return this.zzbhm.isHeld();
    }

    public void release() {
        zzfJ((String) null);
        this.zzbhm.release();
    }

    public void setReferenceCounted(boolean z) {
        this.zzbhm.setReferenceCounted(z);
        this.zzbhq = z;
    }

    public void zzc(WorkSource workSource) {
        if (zznj.zzaA(this.mContext) && workSource != null) {
            WorkSource workSource2 = this.zzbhn;
            if (workSource2 != null) {
                workSource2.add(workSource);
            } else {
                this.zzbhn = workSource;
            }
            this.zzbhm.setWorkSource(this.zzbhn);
        }
    }
}
