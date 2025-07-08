package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.collection.ArrayMap;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.api.internal.zzj;
import com.google.android.gms.common.api.internal.zzq;
import com.google.android.gms.common.api.internal.zzu;
import com.google.android.gms.common.api.internal.zzw;
import com.google.android.gms.common.internal.zzad;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.zzc;
import com.google.android.gms.internal.zzrl;
import com.google.android.gms.internal.zzrn;
import com.google.android.gms.internal.zzro;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public abstract class GoogleApiClient {
    public static final int SIGN_IN_MODE_OPTIONAL = 2;
    public static final int SIGN_IN_MODE_REQUIRED = 1;
    /* access modifiers changed from: private */
    public static final Set<GoogleApiClient> zzagg = Collections.newSetFromMap(new WeakHashMap());

    public static final class Builder {
        private final Context mContext;
        private Account zzTI;
        private String zzUW;
        private final Set<Scope> zzagh;
        private final Set<Scope> zzagi;
        private int zzagj;
        private View zzagk;
        private String zzagl;
        private final Map<Api<?>, zzf.zza> zzagm;
        private final Map<Api<?>, Api.ApiOptions> zzagn;
        /* access modifiers changed from: private */
        public FragmentActivity zzago;
        private int zzagp;
        private OnConnectionFailedListener zzagq;
        private Looper zzagr;
        private zzc zzags;
        private Api.zza<? extends zzrn, zzro> zzagt;
        private final ArrayList<ConnectionCallbacks> zzagu;
        private final ArrayList<OnConnectionFailedListener> zzagv;

        public Builder(Context context) {
            this.zzagh = new HashSet();
            this.zzagi = new HashSet();
            this.zzagm = new ArrayMap();
            this.zzagn = new ArrayMap();
            this.zzagp = -1;
            this.zzags = zzc.zzoK();
            this.zzagt = zzrl.zzUJ;
            this.zzagu = new ArrayList<>();
            this.zzagv = new ArrayList<>();
            this.mContext = context;
            this.zzagr = context.getMainLooper();
            this.zzUW = context.getPackageName();
            this.zzagl = context.getClass().getName();
        }

        public Builder(Context context, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            this(context);
            zzx.zzb(connectionCallbacks, (Object) "Must provide a connected listener");
            this.zzagu.add(connectionCallbacks);
            zzx.zzb(onConnectionFailedListener, (Object) "Must provide a connection failed listener");
            this.zzagv.add(onConnectionFailedListener);
        }

        private static <C extends Api.zzb, O> C zza(Api.zza<C, O> zza, Object obj, Context context, Looper looper, zzf zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zza.zza(context, looper, zzf, obj, connectionCallbacks, onConnectionFailedListener);
        }

        private static <C extends Api.zzd, O> zzad zza(Api.zze<C, O> zze, Object obj, Context context, Looper looper, zzf zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzad(context, looper, zze.zzoU(), connectionCallbacks, onConnectionFailedListener, zzf, zze.zzq(obj));
        }

        private <O extends Api.ApiOptions> void zza(Api<O> api, O o, int i, Scope... scopeArr) {
            boolean z = true;
            if (i != 1) {
                if (i == 2) {
                    z = false;
                } else {
                    throw new IllegalArgumentException("Invalid resolution mode: '" + i + "', use a constant from GoogleApiClient.ResolutionMode");
                }
            }
            HashSet hashSet = new HashSet(api.zzoP().zzo(o));
            for (Scope add : scopeArr) {
                hashSet.add(add);
            }
            this.zzagm.put(api, new zzf.zza(hashSet, z));
        }

        /* access modifiers changed from: private */
        public void zza(zzw zzw, GoogleApiClient googleApiClient) {
            zzw.zza(this.zzagp, googleApiClient, this.zzagq);
        }

        private void zze(final GoogleApiClient googleApiClient) {
            zzw zza = zzw.zza(this.zzago);
            if (zza == null) {
                new Handler(this.mContext.getMainLooper()).post(new Runnable() {
                    public void run() {
                        if (!Builder.this.zzago.isFinishing() && !Builder.this.zzago.getSupportFragmentManager().isDestroyed()) {
                            Builder builder = Builder.this;
                            builder.zza(zzw.zzb(builder.zzago), googleApiClient);
                        }
                    }
                });
            } else {
                zza(zza, googleApiClient);
            }
        }

        private GoogleApiClient zzoZ() {
            Api api;
            Api api2;
            Api.zzb zzb;
            zzf zzoY = zzoY();
            Map<Api<?>, zzf.zza> zzqu = zzoY.zzqu();
            ArrayMap arrayMap = new ArrayMap();
            ArrayMap arrayMap2 = new ArrayMap();
            ArrayList arrayList = new ArrayList();
            Iterator<Api<?>> it = this.zzagn.keySet().iterator();
            Api api3 = null;
            Api api4 = null;
            while (true) {
                int i = 0;
                if (it.hasNext()) {
                    Api next = it.next();
                    Api.ApiOptions apiOptions = this.zzagn.get(next);
                    if (zzqu.get(next) != null) {
                        i = zzqu.get(next).zzalf ? 1 : 2;
                    }
                    arrayMap.put(next, Integer.valueOf(i));
                    com.google.android.gms.common.api.internal.zzc zzc = new com.google.android.gms.common.api.internal.zzc(next, i);
                    arrayList.add(zzc);
                    if (next.zzoS()) {
                        Api.zze zzoQ = next.zzoQ();
                        api2 = zzoQ.getPriority() == 1 ? next : api3;
                        api = next;
                        zzb = zza(zzoQ, (Object) apiOptions, this.mContext, this.zzagr, zzoY, (ConnectionCallbacks) zzc, (OnConnectionFailedListener) zzc);
                    } else {
                        com.google.android.gms.common.api.internal.zzc zzc2 = zzc;
                        api = next;
                        Api.zza zzoP = api.zzoP();
                        api2 = zzoP.getPriority() == 1 ? api : api3;
                        zzb = zza(zzoP, (Object) apiOptions, this.mContext, this.zzagr, zzoY, (ConnectionCallbacks) zzc2, (OnConnectionFailedListener) zzc2);
                    }
                    arrayMap2.put(api.zzoR(), zzb);
                    if (zzb.zznb()) {
                        if (api4 == null) {
                            api4 = api;
                        } else {
                            throw new IllegalStateException(api.getName() + " cannot be used with " + api4.getName());
                        }
                    }
                    api3 = api2;
                } else {
                    if (api4 != null) {
                        if (api3 == null) {
                            zzx.zza(this.zzTI == null, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", api4.getName());
                            zzx.zza(this.zzagh.equals(this.zzagi), "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", api4.getName());
                        } else {
                            throw new IllegalStateException(api4.getName() + " cannot be used with " + api3.getName());
                        }
                    }
                    return new zzj(this.mContext, new ReentrantLock(), this.zzagr, zzoY, this.zzags, this.zzagt, arrayMap, this.zzagu, this.zzagv, arrayMap2, this.zzagp, zzj.zza(arrayMap2.values(), true), arrayList);
                }
            }
        }

        public Builder addApi(Api<? extends Api.ApiOptions.NotRequiredOptions> api) {
            zzx.zzb(api, (Object) "Api must not be null");
            this.zzagn.put(api, (Object) null);
            List<Scope> zzo = api.zzoP().zzo(null);
            this.zzagi.addAll(zzo);
            this.zzagh.addAll(zzo);
            return this;
        }

        public <O extends Api.ApiOptions.HasOptions> Builder addApi(Api<O> api, O o) {
            zzx.zzb(api, (Object) "Api must not be null");
            zzx.zzb(o, (Object) "Null options are not permitted for this Api");
            this.zzagn.put(api, o);
            List<Scope> zzo = api.zzoP().zzo(o);
            this.zzagi.addAll(zzo);
            this.zzagh.addAll(zzo);
            return this;
        }

        public <O extends Api.ApiOptions.HasOptions> Builder addApiIfAvailable(Api<O> api, O o, Scope... scopeArr) {
            zzx.zzb(api, (Object) "Api must not be null");
            zzx.zzb(o, (Object) "Null options are not permitted for this Api");
            this.zzagn.put(api, o);
            zza(api, o, 1, scopeArr);
            return this;
        }

        public Builder addApiIfAvailable(Api<? extends Api.ApiOptions.NotRequiredOptions> api, Scope... scopeArr) {
            zzx.zzb(api, (Object) "Api must not be null");
            this.zzagn.put(api, (Object) null);
            zza(api, (Api.ApiOptions) null, 1, scopeArr);
            return this;
        }

        public Builder addConnectionCallbacks(ConnectionCallbacks connectionCallbacks) {
            zzx.zzb(connectionCallbacks, (Object) "Listener must not be null");
            this.zzagu.add(connectionCallbacks);
            return this;
        }

        public Builder addOnConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener) {
            zzx.zzb(onConnectionFailedListener, (Object) "Listener must not be null");
            this.zzagv.add(onConnectionFailedListener);
            return this;
        }

        public Builder addScope(Scope scope) {
            zzx.zzb(scope, (Object) "Scope must not be null");
            this.zzagh.add(scope);
            return this;
        }

        public GoogleApiClient build() {
            zzx.zzb(!this.zzagn.isEmpty(), (Object) "must call addApi() to add at least one API");
            GoogleApiClient zzoZ = zzoZ();
            synchronized (GoogleApiClient.zzagg) {
                GoogleApiClient.zzagg.add(zzoZ);
            }
            if (this.zzagp >= 0) {
                zze(zzoZ);
            }
            return zzoZ;
        }

        public Builder enableAutoManage(FragmentActivity fragmentActivity, int i, OnConnectionFailedListener onConnectionFailedListener) {
            zzx.zzb(i >= 0, (Object) "clientId must be non-negative");
            this.zzagp = i;
            this.zzago = (FragmentActivity) zzx.zzb(fragmentActivity, (Object) "Null activity is not permitted.");
            this.zzagq = onConnectionFailedListener;
            return this;
        }

        public Builder enableAutoManage(FragmentActivity fragmentActivity, OnConnectionFailedListener onConnectionFailedListener) {
            return enableAutoManage(fragmentActivity, 0, onConnectionFailedListener);
        }

        public Builder setAccountName(String str) {
            this.zzTI = str == null ? null : new Account(str, "com.google");
            return this;
        }

        public Builder setGravityForPopups(int i) {
            this.zzagj = i;
            return this;
        }

        public Builder setHandler(Handler handler) {
            zzx.zzb(handler, (Object) "Handler must not be null");
            this.zzagr = handler.getLooper();
            return this;
        }

        public Builder setViewForPopups(View view) {
            zzx.zzb(view, (Object) "View must not be null");
            this.zzagk = view;
            return this;
        }

        public Builder useDefaultAccount() {
            return setAccountName("<<default account>>");
        }

        public zzf zzoY() {
            zzro zzro = zzro.zzbgV;
            if (this.zzagn.containsKey(zzrl.API)) {
                zzro = (zzro) this.zzagn.get(zzrl.API);
            }
            return new zzf(this.zzTI, this.zzagh, this.zzagm, this.zzagj, this.zzagk, this.zzUW, this.zzagl, zzro);
        }
    }

    public interface ConnectionCallbacks {
        public static final int CAUSE_NETWORK_LOST = 2;
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;

        void onConnected(Bundle bundle);

        void onConnectionSuspended(int i);
    }

    public interface OnConnectionFailedListener {
        void onConnectionFailed(ConnectionResult connectionResult);
    }

    public interface zza {
        void zza(ConnectionResult connectionResult);
    }

    public static void dumpAll(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        Set<GoogleApiClient> set = zzagg;
        synchronized (set) {
            int i = 0;
            String str2 = str + "  ";
            for (GoogleApiClient dump : set) {
                printWriter.append(str).append("GoogleApiClient#").println(i);
                dump.dump(str2, fileDescriptor, printWriter, strArr);
                i++;
            }
        }
    }

    public static Set<GoogleApiClient> zzoV() {
        return zzagg;
    }

    public abstract ConnectionResult blockingConnect();

    public abstract ConnectionResult blockingConnect(long j, TimeUnit timeUnit);

    public abstract PendingResult<Status> clearDefaultAccountAndReconnect();

    public abstract void connect();

    public void connect(int i) {
        throw new UnsupportedOperationException();
    }

    public abstract void disconnect();

    public abstract void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract ConnectionResult getConnectionResult(Api<?> api);

    public Context getContext() {
        throw new UnsupportedOperationException();
    }

    public Looper getLooper() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean hasConnectedApi(Api<?> api);

    public abstract boolean isConnected();

    public abstract boolean isConnecting();

    public abstract boolean isConnectionCallbacksRegistered(ConnectionCallbacks connectionCallbacks);

    public abstract boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener onConnectionFailedListener);

    public abstract void reconnect();

    public abstract void registerConnectionCallbacks(ConnectionCallbacks connectionCallbacks);

    public abstract void registerConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener);

    public abstract void stopAutoManage(FragmentActivity fragmentActivity);

    public abstract void unregisterConnectionCallbacks(ConnectionCallbacks connectionCallbacks);

    public abstract void unregisterConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener);

    public <C extends Api.zzb> C zza(Api.zzc<C> zzc) {
        throw new UnsupportedOperationException();
    }

    public <A extends Api.zzb, R extends Result, T extends zza.C0001zza<R, A>> T zza(T t) {
        throw new UnsupportedOperationException();
    }

    public void zza(com.google.android.gms.common.api.internal.zzx zzx) {
        throw new UnsupportedOperationException();
    }

    public boolean zza(Api<?> api) {
        throw new UnsupportedOperationException();
    }

    public boolean zza(zzu zzu) {
        throw new UnsupportedOperationException();
    }

    public <A extends Api.zzb, T extends zza.C0001zza<? extends Result, A>> T zzb(T t) {
        throw new UnsupportedOperationException();
    }

    public void zzb(com.google.android.gms.common.api.internal.zzx zzx) {
        throw new UnsupportedOperationException();
    }

    public void zzoW() {
        throw new UnsupportedOperationException();
    }

    public <L> zzq<L> zzr(L l) {
        throw new UnsupportedOperationException();
    }
}
