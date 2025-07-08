package com.google.android.gms.drive;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.drive.internal.zzaa;
import com.google.android.gms.drive.internal.zzac;
import com.google.android.gms.drive.internal.zzs;
import com.google.android.gms.drive.internal.zzu;
import com.google.android.gms.drive.internal.zzx;

public final class Drive {
    public static final Api<Api.ApiOptions.NoOptions> API;
    public static final DriveApi DriveApi = new zzs();
    public static final DrivePreferencesApi DrivePreferencesApi = new zzaa();
    public static final Scope SCOPE_APPFOLDER = new Scope(Scopes.DRIVE_APPFOLDER);
    public static final Scope SCOPE_FILE = new Scope(Scopes.DRIVE_FILE);
    public static final Api.zzc<zzu> zzUI;
    public static final Scope zzaoE = new Scope("https://www.googleapis.com/auth/drive");
    public static final Scope zzaoF = new Scope("https://www.googleapis.com/auth/drive.apps");
    public static final Api<zzb> zzaoG;
    public static final zzd zzaoH = new zzx();
    public static final zzf zzaoI = new zzac();

    public static abstract class zza<O extends Api.ApiOptions> extends Api.zza<zzu, O> {
        /* access modifiers changed from: protected */
        public abstract Bundle zza(O o);

        public zzu zza(Context context, Looper looper, zzf zzf, O o, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzu(context, looper, zzf, connectionCallbacks, onConnectionFailedListener, zza(o));
        }
    }

    public static class zzb implements Api.ApiOptions.Optional {
        private final Bundle zzUH;

        public Bundle zzsw() {
            return this.zzUH;
        }
    }

    static {
        Api.zzc<zzu> zzc = new Api.zzc<>();
        zzUI = zzc;
        API = new Api<>("Drive.API", new zza<Api.ApiOptions.NoOptions>() {
            /* access modifiers changed from: protected */
            public Bundle zza(Api.ApiOptions.NoOptions noOptions) {
                return new Bundle();
            }
        }, zzc);
        zzaoG = new Api<>("Drive.INTERNAL_API", new zza<zzb>() {
            /* access modifiers changed from: protected */
            public Bundle zza(zzb zzb) {
                return zzb == null ? new Bundle() : zzb.zzsw();
            }
        }, zzc);
    }

    private Drive() {
    }
}
