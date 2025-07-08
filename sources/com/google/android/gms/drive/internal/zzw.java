package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.internal.zzq;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.zzs;

public class zzw extends zzab implements DriveFile {

    private static class zza implements DriveFile.DownloadProgressListener {
        private final zzq<DriveFile.DownloadProgressListener> zzari;

        public zza(zzq<DriveFile.DownloadProgressListener> zzq) {
            this.zzari = zzq;
        }

        public void onProgress(long j, long j2) {
            final long j3 = j;
            final long j4 = j2;
            this.zzari.zza(new zzq.zzb<DriveFile.DownloadProgressListener>() {
                /* renamed from: zza */
                public void zzt(DriveFile.DownloadProgressListener downloadProgressListener) {
                    downloadProgressListener.onProgress(j3, j4);
                }

                public void zzpr() {
                }
            });
        }
    }

    public zzw(DriveId driveId) {
        super(driveId);
    }

    private static DriveFile.DownloadProgressListener zza(GoogleApiClient googleApiClient, DriveFile.DownloadProgressListener downloadProgressListener) {
        if (downloadProgressListener == null) {
            return null;
        }
        return new zza(googleApiClient.zzr(downloadProgressListener));
    }

    public PendingResult<DriveApi.DriveContentsResult> open(GoogleApiClient googleApiClient, final int i, DriveFile.DownloadProgressListener downloadProgressListener) {
        if (i == 268435456 || i == 536870912 || i == 805306368) {
            final DriveFile.DownloadProgressListener zza2 = zza(googleApiClient, downloadProgressListener);
            return googleApiClient.zza(new zzs.zzc(googleApiClient) {
                /* access modifiers changed from: protected */
                public void zza(zzu zzu) throws RemoteException {
                    zza(zzu.zzte().zza(new OpenContentsRequest(zzw.this.getDriveId(), i, 0), (zzan) new zzbl(this, zza2)).zztj());
                }
            });
        }
        throw new IllegalArgumentException("Invalid mode provided.");
    }
}
