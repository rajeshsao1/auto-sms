package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.drive.Drive;

public abstract class zzt<R extends Result> extends zza.C0001zza<R, zzu> {

    public static abstract class zza extends zzt<Status> {
        public zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* access modifiers changed from: protected */
        /* renamed from: zzb */
        public Status zzc(Status status) {
            return status;
        }
    }

    public zzt(GoogleApiClient googleApiClient) {
        super(Drive.zzUI, googleApiClient);
    }
}
