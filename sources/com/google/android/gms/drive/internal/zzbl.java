package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.internal.zzs;

class zzbl extends zzd {
    private final zza.zzb<DriveApi.DriveContentsResult> zzamC;
    private final DriveFile.DownloadProgressListener zzasy;

    zzbl(zza.zzb<DriveApi.DriveContentsResult> zzb, DriveFile.DownloadProgressListener downloadProgressListener) {
        this.zzamC = zzb;
        this.zzasy = downloadProgressListener;
    }

    public void onError(Status status) throws RemoteException {
        this.zzamC.zzs(new zzs.zzb(status, (DriveContents) null));
    }

    public void zza(OnContentsResponse onContentsResponse) throws RemoteException {
        this.zzamC.zzs(new zzs.zzb(onContentsResponse.zzto() ? new Status(-1) : Status.zzagC, new zzv(onContentsResponse.zztn())));
    }

    public void zza(OnDownloadProgressResponse onDownloadProgressResponse) throws RemoteException {
        DriveFile.DownloadProgressListener downloadProgressListener = this.zzasy;
        if (downloadProgressListener != null) {
            downloadProgressListener.onProgress(onDownloadProgressResponse.zztq(), onDownloadProgressResponse.zztr());
        }
    }
}
