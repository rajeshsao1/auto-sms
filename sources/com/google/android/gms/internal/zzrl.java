package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.signin.internal.zzg;
import com.google.android.gms.signin.internal.zzh;

public final class zzrl {
    public static final Api<zzro> API;
    public static final Api.zzc<zzh> zzUI;
    public static final Api.zza<zzh, zzro> zzUJ;
    public static final Scope zzWW = new Scope(Scopes.PROFILE);
    public static final Scope zzWX = new Scope("email");
    public static final Api<zza> zzaoG;
    public static final Api.zzc<zzh> zzavN;
    static final Api.zza<zzh, zza> zzbgS;
    public static final zzrm zzbgT = new zzg();

    public static class zza implements Api.ApiOptions.HasOptions {
        private final Bundle zzbgU;

        public Bundle zzFF() {
            return this.zzbgU;
        }
    }

    static {
        Api.zzc<zzh> zzc = new Api.zzc<>();
        zzUI = zzc;
        Api.zzc<zzh> zzc2 = new Api.zzc<>();
        zzavN = zzc2;
        AnonymousClass1 r2 = new Api.zza<zzh, zzro>() {
            public zzh zza(Context context, Looper looper, zzf zzf, zzro zzro, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
                if (zzro == null) {
                    zzro = zzro.zzbgV;
                }
                return new zzh(context, looper, true, zzf, zzro, connectionCallbacks, onConnectionFailedListener);
            }
        };
        zzUJ = r2;
        AnonymousClass2 r3 = new Api.zza<zzh, zza>() {
            public zzh zza(Context context, Looper looper, zzf zzf, zza zza, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
                return new zzh(context, looper, false, zzf, zza.zzFF(), connectionCallbacks, onConnectionFailedListener);
            }
        };
        zzbgS = r3;
        API = new Api<>("SignIn.API", r2, zzc);
        zzaoG = new Api<>("SignIn.INTERNAL_API", r3, zzc2);
    }
}
