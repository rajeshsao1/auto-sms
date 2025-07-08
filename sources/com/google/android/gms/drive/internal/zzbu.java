package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;

public class zzbu extends zzd {
    private final zza.zzb<Status> zzamC;

    public zzbu(zza.zzb<Status> zzb) {
        this.zzamC = zzb;
    }

    public void onError(Status status) throws RemoteException {
        this.zzamC.zzs(status);
    }

    public void onSuccess() throws RemoteException {
        this.zzamC.zzs(Status.zzagC);
    }
}
