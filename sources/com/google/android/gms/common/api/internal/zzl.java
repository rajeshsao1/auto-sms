package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.api.internal.zzp;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.zzc;
import com.google.android.gms.internal.zzrn;
import com.google.android.gms.internal.zzro;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class zzl implements zzp {
    private final Context mContext;
    /* access modifiers changed from: private */
    public final Lock zzXG;
    final zzj zzagW;
    private final zzc zzags;
    final Api.zza<? extends zzrn, zzro> zzagt;
    final Map<Api<?>, Integer> zzahA;
    final Map<Api.zzc<?>, Api.zzb> zzahT;
    final zzf zzahz;
    private final Condition zzaim;
    private final zzb zzain;
    final Map<Api.zzc<?>, ConnectionResult> zzaio = new HashMap();
    /* access modifiers changed from: private */
    public volatile zzk zzaip;
    private ConnectionResult zzaiq = null;
    int zzair;
    final zzp.zza zzais;

    static abstract class zza {
        private final zzk zzait;

        protected zza(zzk zzk) {
            this.zzait = zzk;
        }

        public final void zzd(zzl zzl) {
            zzl.zzXG.lock();
            try {
                if (zzl.zzaip == this.zzait) {
                    zzpt();
                    zzl.zzXG.unlock();
                }
            } finally {
                zzl.zzXG.unlock();
            }
        }

        /* access modifiers changed from: protected */
        public abstract void zzpt();
    }

    final class zzb extends Handler {
        zzb(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                ((zza) message.obj).zzd(zzl.this);
            } else if (i != 2) {
                Log.w("GACStateManager", "Unknown message id: " + message.what);
            } else {
                throw ((RuntimeException) message.obj);
            }
        }
    }

    public zzl(Context context, zzj zzj, Lock lock, Looper looper, zzc zzc, Map<Api.zzc<?>, Api.zzb> map, zzf zzf, Map<Api<?>, Integer> map2, Api.zza<? extends zzrn, zzro> zza2, ArrayList<zzc> arrayList, zzp.zza zza3) {
        this.mContext = context;
        this.zzXG = lock;
        this.zzags = zzc;
        this.zzahT = map;
        this.zzahz = zzf;
        this.zzahA = map2;
        this.zzagt = zza2;
        this.zzagW = zzj;
        this.zzais = zza3;
        Iterator<zzc> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().zza(this);
        }
        this.zzain = new zzb(looper);
        this.zzaim = lock.newCondition();
        this.zzaip = new zzi(this);
    }

    public ConnectionResult blockingConnect() {
        connect();
        while (isConnecting()) {
            try {
                this.zzaim.await();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, (PendingIntent) null);
            }
        }
        if (isConnected()) {
            return ConnectionResult.zzafB;
        }
        ConnectionResult connectionResult = this.zzaiq;
        return connectionResult != null ? connectionResult : new ConnectionResult(13, (PendingIntent) null);
    }

    public ConnectionResult blockingConnect(long j, TimeUnit timeUnit) {
        connect();
        long nanos = timeUnit.toNanos(j);
        while (isConnecting()) {
            if (nanos <= 0) {
                try {
                    disconnect();
                    return new ConnectionResult(14, (PendingIntent) null);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return new ConnectionResult(15, (PendingIntent) null);
                }
            } else {
                nanos = this.zzaim.awaitNanos(nanos);
            }
        }
        if (isConnected()) {
            return ConnectionResult.zzafB;
        }
        ConnectionResult connectionResult = this.zzaiq;
        return connectionResult != null ? connectionResult : new ConnectionResult(13, (PendingIntent) null);
    }

    public void connect() {
        this.zzaip.connect();
    }

    public boolean disconnect() {
        boolean disconnect = this.zzaip.disconnect();
        if (disconnect) {
            this.zzaio.clear();
        }
        return disconnect;
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2 = str + "  ";
        for (Api next : this.zzahA.keySet()) {
            printWriter.append(str).append(next.getName()).println(":");
            this.zzahT.get(next.zzoR()).dump(str2, fileDescriptor, printWriter, strArr);
        }
    }

    public ConnectionResult getConnectionResult(Api<?> api) {
        Api.zzc<?> zzoR = api.zzoR();
        if (!this.zzahT.containsKey(zzoR)) {
            return null;
        }
        if (this.zzahT.get(zzoR).isConnected()) {
            return ConnectionResult.zzafB;
        }
        if (this.zzaio.containsKey(zzoR)) {
            return this.zzaio.get(zzoR);
        }
        return null;
    }

    public boolean isConnected() {
        return this.zzaip instanceof zzg;
    }

    public boolean isConnecting() {
        return this.zzaip instanceof zzh;
    }

    public void onConnected(Bundle bundle) {
        this.zzXG.lock();
        try {
            this.zzaip.onConnected(bundle);
        } finally {
            this.zzXG.unlock();
        }
    }

    public void onConnectionSuspended(int i) {
        this.zzXG.lock();
        try {
            this.zzaip.onConnectionSuspended(i);
        } finally {
            this.zzXG.unlock();
        }
    }

    public <A extends Api.zzb, R extends Result, T extends zza.C0001zza<R, A>> T zza(T t) {
        return this.zzaip.zza(t);
    }

    public void zza(ConnectionResult connectionResult, Api<?> api, int i) {
        this.zzXG.lock();
        try {
            this.zzaip.zza(connectionResult, api, i);
        } finally {
            this.zzXG.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public void zza(zza zza2) {
        this.zzain.sendMessage(this.zzain.obtainMessage(1, zza2));
    }

    /* access modifiers changed from: package-private */
    public void zza(RuntimeException runtimeException) {
        this.zzain.sendMessage(this.zzain.obtainMessage(2, runtimeException));
    }

    public boolean zza(zzu zzu) {
        return false;
    }

    public <A extends Api.zzb, T extends zza.C0001zza<? extends Result, A>> T zzb(T t) {
        return this.zzaip.zzb(t);
    }

    /* access modifiers changed from: package-private */
    public void zzh(ConnectionResult connectionResult) {
        this.zzXG.lock();
        try {
            this.zzaiq = connectionResult;
            this.zzaip = new zzi(this);
            this.zzaip.begin();
            this.zzaim.signalAll();
        } finally {
            this.zzXG.unlock();
        }
    }

    public void zzoW() {
    }

    /* access modifiers changed from: package-private */
    public void zzpK() {
        this.zzXG.lock();
        try {
            this.zzaip = new zzh(this, this.zzahz, this.zzahA, this.zzags, this.zzagt, this.zzXG, this.mContext);
            this.zzaip.begin();
            this.zzaim.signalAll();
        } finally {
            this.zzXG.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public void zzpL() {
        this.zzXG.lock();
        try {
            this.zzagW.zzpF();
            this.zzaip = new zzg(this);
            this.zzaip.begin();
            this.zzaim.signalAll();
        } finally {
            this.zzXG.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public void zzpM() {
        for (Api.zzb disconnect : this.zzahT.values()) {
            disconnect.disconnect();
        }
    }

    public void zzpj() {
        if (isConnected()) {
            ((zzg) this.zzaip).zzps();
        }
    }
}
