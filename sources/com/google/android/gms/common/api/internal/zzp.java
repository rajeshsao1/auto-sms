package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.zza;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public interface zzp {

    public interface zza {
        void zzc(int i, boolean z);

        void zzd(ConnectionResult connectionResult);

        void zzi(Bundle bundle);
    }

    ConnectionResult blockingConnect();

    ConnectionResult blockingConnect(long j, TimeUnit timeUnit);

    void connect();

    boolean disconnect();

    void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    ConnectionResult getConnectionResult(Api<?> api);

    boolean isConnected();

    boolean isConnecting();

    <A extends Api.zzb, R extends Result, T extends zza.C0001zza<R, A>> T zza(T t);

    boolean zza(zzu zzu);

    <A extends Api.zzb, T extends zza.C0001zza<? extends Result, A>> T zzb(T t);

    void zzoW();

    void zzpj();
}
