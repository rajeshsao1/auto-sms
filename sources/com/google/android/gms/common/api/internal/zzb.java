package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.common.internal.zzx;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public abstract class zzb<R extends Result> extends PendingResult<R> {
    private boolean zzL;
    private final Object zzagI = new Object();
    protected final zza<R> zzagJ;
    private final WeakReference<GoogleApiClient> zzagK;
    private final ArrayList<PendingResult.zza> zzagL = new ArrayList<>();
    private ResultCallback<? super R> zzagM;
    private volatile boolean zzagN;
    private boolean zzagO;
    private boolean zzagP;
    private zzq zzagQ;
    private Integer zzagR;
    private volatile zzx<R> zzagS;
    private volatile R zzagy;
    private final CountDownLatch zzpJ = new CountDownLatch(1);

    public static class zza<R extends Result> extends Handler {
        public zza() {
            this(Looper.getMainLooper());
        }

        public zza(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                Pair pair = (Pair) message.obj;
                zzb((ResultCallback) pair.first, (Result) pair.second);
            } else if (i != 2) {
                Log.wtf("BasePendingResult", "Don't know how to handle message: " + message.what, new Exception());
            } else {
                ((zzb) message.obj).zzx(Status.zzagF);
            }
        }

        public void zza(ResultCallback<? super R> resultCallback, R r) {
            sendMessage(obtainMessage(1, new Pair(resultCallback, r)));
        }

        public void zza(zzb<R> zzb, long j) {
            sendMessageDelayed(obtainMessage(2, zzb), j);
        }

        /* access modifiers changed from: protected */
        public void zzb(ResultCallback<? super R> resultCallback, R r) {
            try {
                resultCallback.onResult(r);
            } catch (RuntimeException e) {
                zzb.zzc((Result) r);
                throw e;
            }
        }

        public void zzph() {
            removeMessages(2);
        }
    }

    @Deprecated
    protected zzb(Looper looper) {
        this.zzagJ = new zza<>(looper);
        this.zzagK = new WeakReference<>((Object) null);
    }

    protected zzb(GoogleApiClient googleApiClient) {
        this.zzagJ = new zza<>(googleApiClient != null ? googleApiClient.getLooper() : Looper.getMainLooper());
        this.zzagK = new WeakReference<>(googleApiClient);
    }

    private R get() {
        R r;
        synchronized (this.zzagI) {
            zzx.zza(!this.zzagN, (Object) "Result has already been consumed.");
            zzx.zza(isReady(), (Object) "Result is not ready.");
            r = this.zzagy;
            this.zzagy = null;
            this.zzagM = null;
            this.zzagN = true;
        }
        zzpf();
        return r;
    }

    private void zzb(R r) {
        this.zzagy = r;
        this.zzagQ = null;
        this.zzpJ.countDown();
        Status status = this.zzagy.getStatus();
        if (this.zzagM != null) {
            this.zzagJ.zzph();
            if (!this.zzL) {
                this.zzagJ.zza(this.zzagM, get());
            }
        }
        Iterator<PendingResult.zza> it = this.zzagL.iterator();
        while (it.hasNext()) {
            it.next().zzu(status);
        }
        this.zzagL.clear();
    }

    public static void zzc(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (RuntimeException e) {
                Log.w("BasePendingResult", "Unable to release " + result, e);
            }
        }
    }

    public final R await() {
        boolean z = false;
        zzx.zza(Looper.myLooper() != Looper.getMainLooper(), (Object) "await must not be called on the UI thread");
        zzx.zza(!this.zzagN, (Object) "Result has already been consumed");
        if (this.zzagS == null) {
            z = true;
        }
        zzx.zza(z, (Object) "Cannot await if then() has been called.");
        try {
            this.zzpJ.await();
        } catch (InterruptedException e) {
            zzx(Status.zzagD);
        }
        zzx.zza(isReady(), (Object) "Result is not ready.");
        return get();
    }

    public final R await(long j, TimeUnit timeUnit) {
        boolean z = false;
        zzx.zza(j <= 0 || Looper.myLooper() != Looper.getMainLooper(), (Object) "await must not be called on the UI thread when time is greater than zero.");
        zzx.zza(!this.zzagN, (Object) "Result has already been consumed.");
        if (this.zzagS == null) {
            z = true;
        }
        zzx.zza(z, (Object) "Cannot await if then() has been called.");
        try {
            if (!this.zzpJ.await(j, timeUnit)) {
                zzx(Status.zzagF);
            }
        } catch (InterruptedException e) {
            zzx(Status.zzagD);
        }
        zzx.zza(isReady(), (Object) "Result is not ready.");
        return get();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void cancel() {
        /*
            r2 = this;
            java.lang.Object r0 = r2.zzagI
            monitor-enter(r0)
            boolean r1 = r2.zzL     // Catch:{ all -> 0x002d }
            if (r1 != 0) goto L_0x002b
            boolean r1 = r2.zzagN     // Catch:{ all -> 0x002d }
            if (r1 == 0) goto L_0x000c
            goto L_0x002b
        L_0x000c:
            com.google.android.gms.common.internal.zzq r1 = r2.zzagQ     // Catch:{ all -> 0x002d }
            if (r1 == 0) goto L_0x0015
            r1.cancel()     // Catch:{ RemoteException -> 0x0014 }
            goto L_0x0015
        L_0x0014:
            r1 = move-exception
        L_0x0015:
            R r1 = r2.zzagy     // Catch:{ all -> 0x002d }
            zzc((com.google.android.gms.common.api.Result) r1)     // Catch:{ all -> 0x002d }
            r1 = 0
            r2.zzagM = r1     // Catch:{ all -> 0x002d }
            r1 = 1
            r2.zzL = r1     // Catch:{ all -> 0x002d }
            com.google.android.gms.common.api.Status r1 = com.google.android.gms.common.api.Status.zzagG     // Catch:{ all -> 0x002d }
            com.google.android.gms.common.api.Result r1 = r2.zzc((com.google.android.gms.common.api.Status) r1)     // Catch:{ all -> 0x002d }
            r2.zzb(r1)     // Catch:{ all -> 0x002d }
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            return
        L_0x002b:
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            return
        L_0x002d:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzb.cancel():void");
    }

    public boolean isCanceled() {
        boolean z;
        synchronized (this.zzagI) {
            z = this.zzL;
        }
        return z;
    }

    public final boolean isReady() {
        return this.zzpJ.getCount() == 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0049, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setResultCallback(com.google.android.gms.common.api.ResultCallback<? super R> r4) {
        /*
            r3 = this;
            boolean r0 = r3.zzagN
            r1 = 1
            r0 = r0 ^ r1
            java.lang.String r2 = "Result has already been consumed."
            com.google.android.gms.common.internal.zzx.zza((boolean) r0, (java.lang.Object) r2)
            java.lang.Object r0 = r3.zzagI
            monitor-enter(r0)
            com.google.android.gms.common.api.internal.zzx<R> r2 = r3.zzagS     // Catch:{ all -> 0x004a }
            if (r2 != 0) goto L_0x0011
            goto L_0x0012
        L_0x0011:
            r1 = 0
        L_0x0012:
            java.lang.String r2 = "Cannot set callbacks if then() has been called."
            com.google.android.gms.common.internal.zzx.zza((boolean) r1, (java.lang.Object) r2)     // Catch:{ all -> 0x004a }
            boolean r1 = r3.isCanceled()     // Catch:{ all -> 0x004a }
            if (r1 == 0) goto L_0x001f
            monitor-exit(r0)     // Catch:{ all -> 0x004a }
            return
        L_0x001f:
            boolean r1 = r3.zzagP     // Catch:{ all -> 0x004a }
            if (r1 == 0) goto L_0x0036
            java.lang.ref.WeakReference<com.google.android.gms.common.api.GoogleApiClient> r1 = r3.zzagK     // Catch:{ all -> 0x004a }
            java.lang.Object r1 = r1.get()     // Catch:{ all -> 0x004a }
            com.google.android.gms.common.api.GoogleApiClient r1 = (com.google.android.gms.common.api.GoogleApiClient) r1     // Catch:{ all -> 0x004a }
            if (r1 == 0) goto L_0x0031
            boolean r1 = r4 instanceof com.google.android.gms.common.api.internal.zzx     // Catch:{ all -> 0x004a }
            if (r1 != 0) goto L_0x0036
        L_0x0031:
            r3.cancel()     // Catch:{ all -> 0x004a }
            monitor-exit(r0)     // Catch:{ all -> 0x004a }
            return
        L_0x0036:
            boolean r1 = r3.isReady()     // Catch:{ all -> 0x004a }
            if (r1 == 0) goto L_0x0046
            com.google.android.gms.common.api.internal.zzb$zza<R> r1 = r3.zzagJ     // Catch:{ all -> 0x004a }
            com.google.android.gms.common.api.Result r2 = r3.get()     // Catch:{ all -> 0x004a }
            r1.zza(r4, r2)     // Catch:{ all -> 0x004a }
            goto L_0x0048
        L_0x0046:
            r3.zzagM = r4     // Catch:{ all -> 0x004a }
        L_0x0048:
            monitor-exit(r0)     // Catch:{ all -> 0x004a }
            return
        L_0x004a:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x004a }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzb.setResultCallback(com.google.android.gms.common.api.ResultCallback):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0052, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setResultCallback(com.google.android.gms.common.api.ResultCallback<? super R> r5, long r6, java.util.concurrent.TimeUnit r8) {
        /*
            r4 = this;
            boolean r0 = r4.zzagN
            r1 = 1
            r0 = r0 ^ r1
            java.lang.String r2 = "Result has already been consumed."
            com.google.android.gms.common.internal.zzx.zza((boolean) r0, (java.lang.Object) r2)
            java.lang.Object r0 = r4.zzagI
            monitor-enter(r0)
            com.google.android.gms.common.api.internal.zzx<R> r2 = r4.zzagS     // Catch:{ all -> 0x0053 }
            if (r2 != 0) goto L_0x0011
            goto L_0x0012
        L_0x0011:
            r1 = 0
        L_0x0012:
            java.lang.String r2 = "Cannot set callbacks if then() has been called."
            com.google.android.gms.common.internal.zzx.zza((boolean) r1, (java.lang.Object) r2)     // Catch:{ all -> 0x0053 }
            boolean r1 = r4.isCanceled()     // Catch:{ all -> 0x0053 }
            if (r1 == 0) goto L_0x001f
            monitor-exit(r0)     // Catch:{ all -> 0x0053 }
            return
        L_0x001f:
            boolean r1 = r4.zzagP     // Catch:{ all -> 0x0053 }
            if (r1 == 0) goto L_0x0036
            java.lang.ref.WeakReference<com.google.android.gms.common.api.GoogleApiClient> r1 = r4.zzagK     // Catch:{ all -> 0x0053 }
            java.lang.Object r1 = r1.get()     // Catch:{ all -> 0x0053 }
            com.google.android.gms.common.api.GoogleApiClient r1 = (com.google.android.gms.common.api.GoogleApiClient) r1     // Catch:{ all -> 0x0053 }
            if (r1 == 0) goto L_0x0031
            boolean r1 = r5 instanceof com.google.android.gms.common.api.internal.zzx     // Catch:{ all -> 0x0053 }
            if (r1 != 0) goto L_0x0036
        L_0x0031:
            r4.cancel()     // Catch:{ all -> 0x0053 }
            monitor-exit(r0)     // Catch:{ all -> 0x0053 }
            return
        L_0x0036:
            boolean r1 = r4.isReady()     // Catch:{ all -> 0x0053 }
            if (r1 == 0) goto L_0x0046
            com.google.android.gms.common.api.internal.zzb$zza<R> r1 = r4.zzagJ     // Catch:{ all -> 0x0053 }
            com.google.android.gms.common.api.Result r2 = r4.get()     // Catch:{ all -> 0x0053 }
            r1.zza(r5, r2)     // Catch:{ all -> 0x0053 }
            goto L_0x0051
        L_0x0046:
            r4.zzagM = r5     // Catch:{ all -> 0x0053 }
            com.google.android.gms.common.api.internal.zzb$zza<R> r1 = r4.zzagJ     // Catch:{ all -> 0x0053 }
            long r2 = r8.toMillis(r6)     // Catch:{ all -> 0x0053 }
            r1.zza(r4, (long) r2)     // Catch:{ all -> 0x0053 }
        L_0x0051:
            monitor-exit(r0)     // Catch:{ all -> 0x0053 }
            return
        L_0x0053:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0053 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzb.setResultCallback(com.google.android.gms.common.api.ResultCallback, long, java.util.concurrent.TimeUnit):void");
    }

    public <S extends Result> TransformedResult<S> then(ResultTransform<? super R, ? extends S> resultTransform) {
        TransformedResult<S> then;
        boolean z = true;
        zzx.zza(!this.zzagN, (Object) "Result has already been consumed.");
        synchronized (this.zzagI) {
            zzx.zza(this.zzagS == null, (Object) "Cannot call then() twice.");
            if (this.zzagM != null) {
                z = false;
            }
            zzx.zza(z, (Object) "Cannot call then() if callbacks are set.");
            this.zzagS = new zzx<>(this.zzagK);
            then = this.zzagS.then(resultTransform);
            if (isReady()) {
                this.zzagJ.zza(this.zzagS, get());
            } else {
                this.zzagM = this.zzagS;
            }
        }
        return then;
    }

    public final void zza(PendingResult.zza zza2) {
        boolean z = true;
        zzx.zza(!this.zzagN, (Object) "Result has already been consumed.");
        if (zza2 == null) {
            z = false;
        }
        zzx.zzb(z, (Object) "Callback cannot be null.");
        synchronized (this.zzagI) {
            if (isReady()) {
                zza2.zzu(this.zzagy.getStatus());
            } else {
                this.zzagL.add(zza2);
            }
        }
    }

    public final void zza(R r) {
        synchronized (this.zzagI) {
            if (!this.zzagO) {
                if (!this.zzL) {
                    boolean z = true;
                    zzx.zza(!isReady(), (Object) "Results have already been set");
                    if (this.zzagN) {
                        z = false;
                    }
                    zzx.zza(z, (Object) "Result has already been consumed");
                    zzb(r);
                    return;
                }
            }
            zzc((Result) r);
        }
    }

    /* access modifiers changed from: protected */
    public final void zza(zzq zzq) {
        synchronized (this.zzagI) {
            this.zzagQ = zzq;
        }
    }

    /* access modifiers changed from: protected */
    public abstract R zzc(Status status);

    public Integer zzpa() {
        return this.zzagR;
    }

    /* access modifiers changed from: protected */
    public void zzpf() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0023, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zzpg() {
        /*
            r2 = this;
            java.lang.Object r0 = r2.zzagI
            monitor-enter(r0)
            java.lang.ref.WeakReference<com.google.android.gms.common.api.GoogleApiClient> r1 = r2.zzagK     // Catch:{ all -> 0x0024 }
            java.lang.Object r1 = r1.get()     // Catch:{ all -> 0x0024 }
            com.google.android.gms.common.api.GoogleApiClient r1 = (com.google.android.gms.common.api.GoogleApiClient) r1     // Catch:{ all -> 0x0024 }
            if (r1 != 0) goto L_0x0012
            r2.cancel()     // Catch:{ all -> 0x0024 }
            monitor-exit(r0)     // Catch:{ all -> 0x0024 }
            return
        L_0x0012:
            com.google.android.gms.common.api.ResultCallback<? super R> r1 = r2.zzagM     // Catch:{ all -> 0x0024 }
            if (r1 == 0) goto L_0x001f
            boolean r1 = r1 instanceof com.google.android.gms.common.api.internal.zzx     // Catch:{ all -> 0x0024 }
            if (r1 == 0) goto L_0x001b
            goto L_0x001f
        L_0x001b:
            r2.cancel()     // Catch:{ all -> 0x0024 }
            goto L_0x0022
        L_0x001f:
            r1 = 1
            r2.zzagP = r1     // Catch:{ all -> 0x0024 }
        L_0x0022:
            monitor-exit(r0)     // Catch:{ all -> 0x0024 }
            return
        L_0x0024:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0024 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzb.zzpg():void");
    }

    public final void zzx(Status status) {
        synchronized (this.zzagI) {
            if (!isReady()) {
                zza(zzc(status));
                this.zzagO = true;
            }
        }
    }
}
