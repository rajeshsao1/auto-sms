package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzk implements Handler.Callback {
    private final Handler mHandler;
    private final zza zzalQ;
    private final ArrayList<GoogleApiClient.ConnectionCallbacks> zzalR = new ArrayList<>();
    final ArrayList<GoogleApiClient.ConnectionCallbacks> zzalS = new ArrayList<>();
    private final ArrayList<GoogleApiClient.OnConnectionFailedListener> zzalT = new ArrayList<>();
    private volatile boolean zzalU = false;
    private final AtomicInteger zzalV = new AtomicInteger(0);
    private boolean zzalW = false;
    private final Object zzpV = new Object();

    public interface zza {
        boolean isConnected();

        Bundle zzoi();
    }

    public zzk(Looper looper, zza zza2) {
        this.zzalQ = zza2;
        this.mHandler = new Handler(looper, this);
    }

    public boolean handleMessage(Message message) {
        if (message.what == 1) {
            GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) message.obj;
            synchronized (this.zzpV) {
                if (this.zzalU && this.zzalQ.isConnected() && this.zzalR.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnected(this.zzalQ.zzoi());
                }
            }
            return true;
        }
        Log.wtf("GmsClientEvents", "Don't know how to handle message: " + message.what, new Exception());
        return false;
    }

    public boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        boolean contains;
        zzx.zzz(connectionCallbacks);
        synchronized (this.zzpV) {
            contains = this.zzalR.contains(connectionCallbacks);
        }
        return contains;
    }

    public boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        boolean contains;
        zzx.zzz(onConnectionFailedListener);
        synchronized (this.zzpV) {
            contains = this.zzalT.contains(onConnectionFailedListener);
        }
        return contains;
    }

    public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        zzx.zzz(connectionCallbacks);
        synchronized (this.zzpV) {
            if (this.zzalR.contains(connectionCallbacks)) {
                Log.w("GmsClientEvents", "registerConnectionCallbacks(): listener " + connectionCallbacks + " is already registered");
            } else {
                this.zzalR.add(connectionCallbacks);
            }
        }
        if (this.zzalQ.isConnected()) {
            Handler handler = this.mHandler;
            handler.sendMessage(handler.obtainMessage(1, connectionCallbacks));
        }
    }

    public void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        zzx.zzz(onConnectionFailedListener);
        synchronized (this.zzpV) {
            if (this.zzalT.contains(onConnectionFailedListener)) {
                Log.w("GmsClientEvents", "registerConnectionFailedListener(): listener " + onConnectionFailedListener + " is already registered");
            } else {
                this.zzalT.add(onConnectionFailedListener);
            }
        }
    }

    public void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        zzx.zzz(connectionCallbacks);
        synchronized (this.zzpV) {
            if (!this.zzalR.remove(connectionCallbacks)) {
                Log.w("GmsClientEvents", "unregisterConnectionCallbacks(): listener " + connectionCallbacks + " not found");
            } else if (this.zzalW) {
                this.zzalS.add(connectionCallbacks);
            }
        }
    }

    public void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        zzx.zzz(onConnectionFailedListener);
        synchronized (this.zzpV) {
            if (!this.zzalT.remove(onConnectionFailedListener)) {
                Log.w("GmsClientEvents", "unregisterConnectionFailedListener(): listener " + onConnectionFailedListener + " not found");
            }
        }
    }

    public void zzbT(int i) {
        zzx.zza(Looper.myLooper() == this.mHandler.getLooper(), (Object) "onUnintentionalDisconnection must only be called on the Handler thread");
        this.mHandler.removeMessages(1);
        synchronized (this.zzpV) {
            this.zzalW = true;
            ArrayList arrayList = new ArrayList(this.zzalR);
            int i2 = this.zzalV.get();
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) it.next();
                if (!this.zzalU) {
                    break;
                } else if (this.zzalV.get() != i2) {
                    break;
                } else if (this.zzalR.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnectionSuspended(i);
                }
            }
            this.zzalS.clear();
            this.zzalW = false;
        }
    }

    public void zzk(Bundle bundle) {
        boolean z = true;
        zzx.zza(Looper.myLooper() == this.mHandler.getLooper(), (Object) "onConnectionSuccess must only be called on the Handler thread");
        synchronized (this.zzpV) {
            zzx.zzab(!this.zzalW);
            this.mHandler.removeMessages(1);
            this.zzalW = true;
            if (this.zzalS.size() != 0) {
                z = false;
            }
            zzx.zzab(z);
            ArrayList arrayList = new ArrayList(this.zzalR);
            int i = this.zzalV.get();
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) it.next();
                if (!this.zzalU || !this.zzalQ.isConnected()) {
                    break;
                } else if (this.zzalV.get() != i) {
                    break;
                } else if (!this.zzalS.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnected(bundle);
                }
            }
            this.zzalS.clear();
            this.zzalW = false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0054, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zzk(com.google.android.gms.common.ConnectionResult r6) {
        /*
            r5 = this;
            android.os.Looper r0 = android.os.Looper.myLooper()
            android.os.Handler r1 = r5.mHandler
            android.os.Looper r1 = r1.getLooper()
            r2 = 1
            if (r0 != r1) goto L_0x000f
            r0 = 1
            goto L_0x0010
        L_0x000f:
            r0 = 0
        L_0x0010:
            java.lang.String r1 = "onConnectionFailure must only be called on the Handler thread"
            com.google.android.gms.common.internal.zzx.zza((boolean) r0, (java.lang.Object) r1)
            android.os.Handler r0 = r5.mHandler
            r0.removeMessages(r2)
            java.lang.Object r0 = r5.zzpV
            monitor-enter(r0)
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0057 }
            java.util.ArrayList<com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener> r2 = r5.zzalT     // Catch:{ all -> 0x0057 }
            r1.<init>(r2)     // Catch:{ all -> 0x0057 }
            java.util.concurrent.atomic.AtomicInteger r2 = r5.zzalV     // Catch:{ all -> 0x0057 }
            int r2 = r2.get()     // Catch:{ all -> 0x0057 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0057 }
        L_0x002e:
            boolean r3 = r1.hasNext()     // Catch:{ all -> 0x0057 }
            if (r3 == 0) goto L_0x0055
            java.lang.Object r3 = r1.next()     // Catch:{ all -> 0x0057 }
            com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener r3 = (com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener) r3     // Catch:{ all -> 0x0057 }
            boolean r4 = r5.zzalU     // Catch:{ all -> 0x0057 }
            if (r4 == 0) goto L_0x0053
            java.util.concurrent.atomic.AtomicInteger r4 = r5.zzalV     // Catch:{ all -> 0x0057 }
            int r4 = r4.get()     // Catch:{ all -> 0x0057 }
            if (r4 == r2) goto L_0x0047
            goto L_0x0053
        L_0x0047:
            java.util.ArrayList<com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener> r4 = r5.zzalT     // Catch:{ all -> 0x0057 }
            boolean r4 = r4.contains(r3)     // Catch:{ all -> 0x0057 }
            if (r4 == 0) goto L_0x002e
            r3.onConnectionFailed(r6)     // Catch:{ all -> 0x0057 }
            goto L_0x002e
        L_0x0053:
            monitor-exit(r0)     // Catch:{ all -> 0x0057 }
            return
        L_0x0055:
            monitor-exit(r0)     // Catch:{ all -> 0x0057 }
            return
        L_0x0057:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0057 }
            goto L_0x005b
        L_0x005a:
            throw r6
        L_0x005b:
            goto L_0x005a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.zzk.zzk(com.google.android.gms.common.ConnectionResult):void");
    }

    public void zzqQ() {
        this.zzalU = false;
        this.zzalV.incrementAndGet();
    }

    public void zzqR() {
        this.zzalU = true;
    }
}
