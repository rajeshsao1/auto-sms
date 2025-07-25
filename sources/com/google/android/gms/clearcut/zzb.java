package com.google.android.gms.clearcut;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlv;
import com.google.android.gms.internal.zzlw;
import com.google.android.gms.internal.zzmq;
import com.google.android.gms.internal.zzmt;
import com.google.android.gms.internal.zzsz;
import com.google.android.gms.playlog.internal.PlayLoggerContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public final class zzb {
    public static final Api<Api.ApiOptions.NoOptions> API;
    public static final Api.zzc<zzlw> zzUI;
    public static final Api.zza<zzlw, Api.ApiOptions.NoOptions> zzUJ;
    public static final zzc zzaeQ = new zzlv();
    /* access modifiers changed from: private */
    public final Context mContext;
    /* access modifiers changed from: private */
    public final String zzTJ;
    /* access modifiers changed from: private */
    public final int zzaeR;
    /* access modifiers changed from: private */
    public String zzaeS;
    /* access modifiers changed from: private */
    public int zzaeT;
    /* access modifiers changed from: private */
    public String zzaeU;
    /* access modifiers changed from: private */
    public String zzaeV;
    /* access modifiers changed from: private */
    public final boolean zzaeW;
    /* access modifiers changed from: private */
    public int zzaeX;
    /* access modifiers changed from: private */
    public final zzc zzaeY;
    /* access modifiers changed from: private */
    public final zza zzaeZ;
    /* access modifiers changed from: private */
    public zzc zzafa;
    /* access modifiers changed from: private */
    public final zzmq zzqW;

    public class zza {
        private String zzaeS;
        private int zzaeT;
        private String zzaeU;
        private String zzaeV;
        private int zzaeX;
        private final C0000zzb zzafb;
        private C0000zzb zzafc;
        private ArrayList<Integer> zzafd;
        private final zzsz.zzd zzafe;
        private boolean zzaff;

        private zza(zzb zzb, byte[] bArr) {
            this(bArr, (C0000zzb) null);
        }

        private zza(byte[] bArr, C0000zzb zzb) {
            this.zzaeT = zzb.this.zzaeT;
            this.zzaeS = zzb.this.zzaeS;
            this.zzaeU = zzb.this.zzaeU;
            this.zzaeV = zzb.this.zzaeV;
            this.zzaeX = zzb.this.zzaeX;
            this.zzafd = null;
            zzsz.zzd zzd = new zzsz.zzd();
            this.zzafe = zzd;
            this.zzaff = false;
            this.zzaeU = zzb.this.zzaeU;
            this.zzaeV = zzb.this.zzaeV;
            zzd.zzbuR = zzb.this.zzqW.currentTimeMillis();
            zzd.zzbuS = zzb.this.zzqW.elapsedRealtime();
            zzd.zzbvi = (long) zzb.this.zzaeZ.zzah(zzb.this.mContext);
            zzd.zzbvd = zzb.this.zzafa.zzC(zzd.zzbuR);
            if (bArr != null) {
                zzd.zzbuY = bArr;
            }
            this.zzafb = zzb;
        }

        public zza zzbq(int i) {
            this.zzafe.zzbuU = i;
            return this;
        }

        public zza zzbr(int i) {
            this.zzafe.zzob = i;
            return this;
        }

        public PendingResult<Status> zzd(GoogleApiClient googleApiClient) {
            if (!this.zzaff) {
                this.zzaff = true;
                return zzb.this.zzaeY.zza(googleApiClient, zzoE());
            }
            throw new IllegalStateException("do not reuse LogEventBuilder");
        }

        public LogEventParcelable zzoE() {
            return new LogEventParcelable(new PlayLoggerContext(zzb.this.zzTJ, zzb.this.zzaeR, this.zzaeT, this.zzaeS, this.zzaeU, this.zzaeV, zzb.this.zzaeW, this.zzaeX), this.zzafe, this.zzafb, this.zzafc, zzb.zzb(this.zzafd));
        }
    }

    /* renamed from: com.google.android.gms.clearcut.zzb$zzb  reason: collision with other inner class name */
    public interface C0000zzb {
        byte[] zzoF();
    }

    public static class zzc {
        public long zzC(long j) {
            return (long) (TimeZone.getDefault().getOffset(j) / 1000);
        }
    }

    static {
        Api.zzc<zzlw> zzc2 = new Api.zzc<>();
        zzUI = zzc2;
        AnonymousClass1 r1 = new Api.zza<zzlw, Api.ApiOptions.NoOptions>() {
            /* renamed from: zze */
            public zzlw zza(Context context, Looper looper, zzf zzf, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
                return new zzlw(context, looper, zzf, connectionCallbacks, onConnectionFailedListener);
            }
        };
        zzUJ = r1;
        API = new Api<>("ClearcutLogger.API", r1, zzc2);
    }

    public zzb(Context context, int i, String str, String str2, String str3, boolean z, zzc zzc2, zzmq zzmq, zzc zzc3, zza zza2) {
        this.zzaeT = -1;
        boolean z2 = false;
        this.zzaeX = 0;
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext == null ? context : applicationContext;
        this.zzTJ = context.getPackageName();
        this.zzaeR = zzai(context);
        this.zzaeT = i;
        this.zzaeS = str;
        this.zzaeU = str2;
        this.zzaeV = str3;
        this.zzaeW = z;
        this.zzaeY = zzc2;
        this.zzqW = zzmq;
        this.zzafa = zzc3 == null ? new zzc() : zzc3;
        this.zzaeZ = zza2;
        this.zzaeX = 0;
        if (z) {
            zzx.zzb(this.zzaeU == null ? true : z2, (Object) "can't be anonymous with an upload account");
        }
    }

    @Deprecated
    public zzb(Context context, String str, String str2, String str3) {
        this(context, -1, str, str2, str3, false, zzaeQ, zzmt.zzsc(), (zzc) null, zza.zzaeP);
    }

    private int zzai(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            Log.wtf("ClearcutLogger", "This can't happen.");
            return 0;
        }
    }

    /* access modifiers changed from: private */
    public static int[] zzb(ArrayList<Integer> arrayList) {
        if (arrayList == null) {
            return null;
        }
        int[] iArr = new int[arrayList.size()];
        int i = 0;
        Iterator<Integer> it = arrayList.iterator();
        while (it.hasNext()) {
            iArr[i] = it.next().intValue();
            i++;
        }
        return iArr;
    }

    public boolean zza(GoogleApiClient googleApiClient, long j, TimeUnit timeUnit) {
        return this.zzaeY.zza(googleApiClient, j, timeUnit);
    }

    public zza zzi(byte[] bArr) {
        return new zza(bArr);
    }
}
