package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.api.internal.zzp;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.zzc;
import com.google.android.gms.internal.zzrn;
import com.google.android.gms.internal.zzro;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class zzd implements zzp {
    private final Context mContext;
    /* access modifiers changed from: private */
    public final Lock zzXG;
    private final zzj zzagW;
    /* access modifiers changed from: private */
    public final zzl zzagX;
    /* access modifiers changed from: private */
    public final zzl zzagY;
    private final Map<Api.zzc<?>, zzl> zzagZ = new ArrayMap();
    private final Looper zzagr;
    private final Set<zzu> zzaha = Collections.newSetFromMap(new WeakHashMap());
    private final Api.zzb zzahb;
    private Bundle zzahc;
    /* access modifiers changed from: private */
    public ConnectionResult zzahd;
    /* access modifiers changed from: private */
    public ConnectionResult zzahe;
    /* access modifiers changed from: private */
    public boolean zzahf;
    private int zzahg;

    public zzd(Context context, zzj zzj, Lock lock, Looper looper, zzc zzc, Map<Api.zzc<?>, Api.zzb> map, zzf zzf, Map<Api<?>, Integer> map2, Api.zza<? extends zzrn, zzro> zza, ArrayList<zzc> arrayList) {
        Map<Api<?>, Integer> map3 = map2;
        Api.zzb zzb = null;
        this.zzahd = null;
        this.zzahe = null;
        this.zzahf = false;
        this.zzahg = 0;
        this.mContext = context;
        this.zzagW = zzj;
        this.zzXG = lock;
        this.zzagr = looper;
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        for (Api.zzc next : map.keySet()) {
            Api.zzb zzb2 = map.get(next);
            zzb = zzb2.zznb() ? zzb2 : zzb;
            if (zzb2.zzmE()) {
                arrayMap.put(next, zzb2);
            } else {
                arrayMap2.put(next, zzb2);
            }
        }
        this.zzahb = zzb;
        if (!arrayMap.isEmpty()) {
            ArrayMap arrayMap3 = new ArrayMap();
            ArrayMap arrayMap4 = new ArrayMap();
            for (Api next2 : map2.keySet()) {
                Api.zzc<?> zzoR = next2.zzoR();
                if (arrayMap.containsKey(zzoR)) {
                    arrayMap3.put(next2, map3.get(next2));
                } else if (arrayMap2.containsKey(zzoR)) {
                    arrayMap4.put(next2, map3.get(next2));
                } else {
                    throw new IllegalStateException("Each API in the apiTypeMap must have a corresponding client in the clients map.");
                }
            }
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            Iterator<zzc> it = arrayList.iterator();
            while (it.hasNext()) {
                zzc next3 = it.next();
                if (arrayMap3.containsKey(next3.zzagT)) {
                    arrayList2.add(next3);
                } else if (arrayMap4.containsKey(next3.zzagT)) {
                    arrayList3.add(next3);
                } else {
                    throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the apiTypeMap");
                }
            }
            Context context2 = context;
            Lock lock2 = lock;
            zzl zzl = r4;
            Looper looper2 = looper;
            zzc zzc2 = zzc;
            ArrayList arrayList4 = arrayList3;
            ArrayMap arrayMap5 = arrayMap;
            zzl zzl2 = new zzl(context2, this.zzagW, lock2, looper2, zzc2, arrayMap2, (zzf) null, arrayMap4, (Api.zza<? extends zzrn, zzro>) null, arrayList4, new zzp.zza() {
                public void zzc(int i, boolean z) {
                    zzd.this.zzXG.lock();
                    try {
                        if (!zzd.this.zzahf && zzd.this.zzahe != null) {
                            if (zzd.this.zzahe.isSuccess()) {
                                boolean unused = zzd.this.zzahf = true;
                                zzd.this.zzagY.onConnectionSuspended(i);
                                zzd.this.zzXG.unlock();
                                return;
                            }
                        }
                        boolean unused2 = zzd.this.zzahf = false;
                        zzd.this.zzb(i, z);
                    } finally {
                        zzd.this.zzXG.unlock();
                    }
                }

                public void zzd(ConnectionResult connectionResult) {
                    zzd.this.zzXG.lock();
                    try {
                        ConnectionResult unused = zzd.this.zzahd = connectionResult;
                        zzd.this.zzpm();
                    } finally {
                        zzd.this.zzXG.unlock();
                    }
                }

                public void zzi(Bundle bundle) {
                    zzd.this.zzXG.lock();
                    try {
                        zzd.this.zzh(bundle);
                        ConnectionResult unused = zzd.this.zzahd = ConnectionResult.zzafB;
                        zzd.this.zzpm();
                    } finally {
                        zzd.this.zzXG.unlock();
                    }
                }
            });
            this.zzagX = zzl;
            zzl zzl3 = r4;
            zzl zzl4 = new zzl(context2, this.zzagW, lock2, looper2, zzc2, arrayMap5, zzf, arrayMap3, zza, arrayList2, new zzp.zza() {
                public void zzc(int i, boolean z) {
                    zzd.this.zzXG.lock();
                    try {
                        if (zzd.this.zzahf) {
                            boolean unused = zzd.this.zzahf = false;
                            zzd.this.zzb(i, z);
                            return;
                        }
                        boolean unused2 = zzd.this.zzahf = true;
                        zzd.this.zzagX.onConnectionSuspended(i);
                        zzd.this.zzXG.unlock();
                    } finally {
                        zzd.this.zzXG.unlock();
                    }
                }

                public void zzd(ConnectionResult connectionResult) {
                    zzd.this.zzXG.lock();
                    try {
                        ConnectionResult unused = zzd.this.zzahe = connectionResult;
                        zzd.this.zzpm();
                    } finally {
                        zzd.this.zzXG.unlock();
                    }
                }

                public void zzi(Bundle bundle) {
                    zzd.this.zzXG.lock();
                    try {
                        ConnectionResult unused = zzd.this.zzahe = ConnectionResult.zzafB;
                        zzd.this.zzpm();
                    } finally {
                        zzd.this.zzXG.unlock();
                    }
                }
            });
            this.zzagY = zzl3;
            for (Api.zzc put : arrayMap2.keySet()) {
                this.zzagZ.put(put, this.zzagX);
            }
            for (Api.zzc put2 : arrayMap5.keySet()) {
                this.zzagZ.put(put2, this.zzagY);
            }
            return;
        }
        throw new IllegalStateException("CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
    }

    /* access modifiers changed from: private */
    public void zzb(int i, boolean z) {
        this.zzagW.zzc(i, z);
        this.zzahe = null;
        this.zzahd = null;
    }

    private void zzb(ConnectionResult connectionResult) {
        int i = this.zzahg;
        if (i != 1) {
            if (i != 2) {
                Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                this.zzahg = 0;
            }
            this.zzagW.zzd(connectionResult);
        }
        zzpo();
        this.zzahg = 0;
    }

    private static boolean zzc(ConnectionResult connectionResult) {
        return connectionResult != null && connectionResult.isSuccess();
    }

    private boolean zzc(zza.C0001zza<? extends Result, ? extends Api.zzb> zza) {
        Api.zzc<? extends Api.zzb> zzoR = zza.zzoR();
        zzx.zzb(this.zzagZ.containsKey(zzoR), (Object) "GoogleApiClient is not configured to use the API required for this call.");
        return this.zzagZ.get(zzoR).equals(this.zzagY);
    }

    /* access modifiers changed from: private */
    public void zzh(Bundle bundle) {
        Bundle bundle2 = this.zzahc;
        if (bundle2 == null) {
            this.zzahc = bundle;
        } else if (bundle != null) {
            bundle2.putAll(bundle);
        }
    }

    private void zzpl() {
        this.zzahe = null;
        this.zzahd = null;
        this.zzagX.connect();
        this.zzagY.connect();
    }

    /* access modifiers changed from: private */
    public void zzpm() {
        ConnectionResult connectionResult;
        if (!zzc(this.zzahd)) {
            if (this.zzahd == null || !zzc(this.zzahe)) {
                connectionResult = this.zzahd;
                if (connectionResult != null && this.zzahe != null) {
                    if (this.zzagY.zzair < this.zzagX.zzair) {
                        connectionResult = this.zzahe;
                    }
                } else {
                    return;
                }
            } else {
                this.zzagY.disconnect();
                connectionResult = this.zzahd;
            }
            zzb(connectionResult);
        } else if (zzc(this.zzahe) || zzpp()) {
            zzpn();
        } else {
            ConnectionResult connectionResult2 = this.zzahe;
            if (connectionResult2 == null) {
                return;
            }
            if (this.zzahg == 1) {
                zzpo();
                return;
            }
            zzb(connectionResult2);
            this.zzagX.disconnect();
        }
    }

    private void zzpn() {
        int i = this.zzahg;
        if (i != 1) {
            if (i != 2) {
                Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                this.zzahg = 0;
            }
            this.zzagW.zzi(this.zzahc);
        }
        zzpo();
        this.zzahg = 0;
    }

    private void zzpo() {
        for (zzu zzna : this.zzaha) {
            zzna.zzna();
        }
        this.zzaha.clear();
    }

    private boolean zzpp() {
        ConnectionResult connectionResult = this.zzahe;
        return connectionResult != null && connectionResult.getErrorCode() == 4;
    }

    private PendingIntent zzpq() {
        if (this.zzahb == null) {
            return null;
        }
        return PendingIntent.getActivity(this.mContext, this.zzagW.getSessionId(), this.zzahb.zznc(), 134217728);
    }

    public ConnectionResult blockingConnect() {
        throw new UnsupportedOperationException();
    }

    public ConnectionResult blockingConnect(long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public void connect() {
        this.zzahg = 2;
        this.zzahf = false;
        zzpl();
    }

    public boolean disconnect() {
        this.zzahe = null;
        this.zzahd = null;
        this.zzahg = 0;
        boolean disconnect = this.zzagX.disconnect();
        boolean disconnect2 = this.zzagY.disconnect();
        zzpo();
        return disconnect && disconnect2;
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("authClient").println(":");
        zzl zzl = this.zzagY;
        zzl.dump(str + "  ", fileDescriptor, printWriter, strArr);
        printWriter.append(str).append("anonClient").println(":");
        zzl zzl2 = this.zzagX;
        zzl2.dump(str + "  ", fileDescriptor, printWriter, strArr);
    }

    public ConnectionResult getConnectionResult(Api<?> api) {
        return this.zzagZ.get(api.zzoR()).equals(this.zzagY) ? zzpp() ? new ConnectionResult(4, zzpq()) : this.zzagY.getConnectionResult(api) : this.zzagX.getConnectionResult(api);
    }

    public boolean isConnected() {
        this.zzXG.lock();
        try {
            boolean z = true;
            if (!this.zzagX.isConnected() || (!zzpk() && !zzpp() && this.zzahg != 1)) {
                z = false;
            }
            return z;
        } finally {
            this.zzXG.unlock();
        }
    }

    public boolean isConnecting() {
        this.zzXG.lock();
        try {
            return this.zzahg == 2;
        } finally {
            this.zzXG.unlock();
        }
    }

    public <A extends Api.zzb, R extends Result, T extends zza.C0001zza<R, A>> T zza(T t) {
        if (!zzc((zza.C0001zza<? extends Result, ? extends Api.zzb>) t)) {
            return this.zzagX.zza(t);
        }
        if (!zzpp()) {
            return this.zzagY.zza(t);
        }
        t.zzw(new Status(4, (String) null, zzpq()));
        return t;
    }

    public boolean zza(zzu zzu) {
        this.zzXG.lock();
        try {
            if ((isConnecting() || isConnected()) && !zzpk()) {
                this.zzaha.add(zzu);
                if (this.zzahg == 0) {
                    this.zzahg = 1;
                }
                this.zzahe = null;
                this.zzagY.connect();
                return true;
            }
            this.zzXG.unlock();
            return false;
        } finally {
            this.zzXG.unlock();
        }
    }

    public <A extends Api.zzb, T extends zza.C0001zza<? extends Result, A>> T zzb(T t) {
        if (!zzc((zza.C0001zza<? extends Result, ? extends Api.zzb>) t)) {
            return this.zzagX.zzb(t);
        }
        if (!zzpp()) {
            return this.zzagY.zzb(t);
        }
        t.zzw(new Status(4, (String) null, zzpq()));
        return t;
    }

    public void zzoW() {
        this.zzXG.lock();
        try {
            boolean isConnecting = isConnecting();
            this.zzagY.disconnect();
            this.zzahe = new ConnectionResult(4);
            if (isConnecting) {
                new Handler(this.zzagr).post(new Runnable() {
                    public void run() {
                        zzd.this.zzXG.lock();
                        try {
                            zzd.this.zzpm();
                        } finally {
                            zzd.this.zzXG.unlock();
                        }
                    }
                });
            } else {
                zzpo();
            }
        } finally {
            this.zzXG.unlock();
        }
    }

    public void zzpj() {
        this.zzagX.zzpj();
        this.zzagY.zzpj();
    }

    public boolean zzpk() {
        return this.zzagY.isConnected();
    }
}
