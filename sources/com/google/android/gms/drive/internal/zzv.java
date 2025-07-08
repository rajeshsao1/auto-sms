package com.google.android.gms.drive.internal;

import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.internal.zzs;
import com.google.android.gms.drive.internal.zzt;
import com.google.android.gms.drive.zzi;
import com.google.android.gms.internal.zzna;
import java.io.InputStream;
import java.io.OutputStream;

public class zzv implements DriveContents {
    private boolean mClosed = false;
    /* access modifiers changed from: private */
    public final Contents zzara;
    private boolean zzarb = false;
    private boolean zzarc = false;

    public zzv(Contents contents) {
        this.zzara = (Contents) zzx.zzz(contents);
    }

    public PendingResult<Status> commit(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet) {
        return zza(googleApiClient, metadataChangeSet, (zzi) null);
    }

    public PendingResult<Status> commit(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, ExecutionOptions executionOptions) {
        return zza(googleApiClient, metadataChangeSet, executionOptions == null ? null : zzi.zzb(executionOptions));
    }

    public void discard(GoogleApiClient googleApiClient) {
        if (!zzsz()) {
            zzsy();
            ((AnonymousClass4) googleApiClient.zzb(new zzt.zza(googleApiClient) {
                /* access modifiers changed from: protected */
                public void zza(zzu zzu) throws RemoteException {
                    zzu.zzte().zza(new CloseContentsRequest(zzv.this.zzara.getRequestId(), false), (zzan) new zzbu(this));
                }
            })).setResultCallback(new ResultCallback<Status>() {
                /* renamed from: zzp */
                public void onResult(Status status) {
                    if (!status.isSuccess()) {
                        zzz.zzA("DriveContentsImpl", "Error discarding contents");
                    } else {
                        zzz.zzy("DriveContentsImpl", "Contents discarded");
                    }
                }
            });
            return;
        }
        throw new IllegalStateException("DriveContents already closed.");
    }

    public DriveId getDriveId() {
        return this.zzara.getDriveId();
    }

    public InputStream getInputStream() {
        if (zzsz()) {
            throw new IllegalStateException("Contents have been closed, cannot access the input stream.");
        } else if (this.zzara.getMode() != 268435456) {
            throw new IllegalStateException("getInputStream() can only be used with contents opened with MODE_READ_ONLY.");
        } else if (!this.zzarb) {
            this.zzarb = true;
            return this.zzara.getInputStream();
        } else {
            throw new IllegalStateException("getInputStream() can only be called once per Contents instance.");
        }
    }

    public int getMode() {
        return this.zzara.getMode();
    }

    public OutputStream getOutputStream() {
        if (zzsz()) {
            throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
        } else if (this.zzara.getMode() != 536870912) {
            throw new IllegalStateException("getOutputStream() can only be used with contents opened with MODE_WRITE_ONLY.");
        } else if (!this.zzarc) {
            this.zzarc = true;
            return this.zzara.getOutputStream();
        } else {
            throw new IllegalStateException("getOutputStream() can only be called once per Contents instance.");
        }
    }

    public ParcelFileDescriptor getParcelFileDescriptor() {
        if (!zzsz()) {
            return this.zzara.getParcelFileDescriptor();
        }
        throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
    }

    public PendingResult<DriveApi.DriveContentsResult> reopenForWrite(GoogleApiClient googleApiClient) {
        if (zzsz()) {
            throw new IllegalStateException("DriveContents already closed.");
        } else if (this.zzara.getMode() == 268435456) {
            zzsy();
            return googleApiClient.zza(new zzs.zzc(googleApiClient) {
                /* access modifiers changed from: protected */
                public void zza(zzu zzu) throws RemoteException {
                    zzu.zzte().zza(new OpenContentsRequest(zzv.this.getDriveId(), DriveFile.MODE_WRITE_ONLY, zzv.this.zzara.getRequestId()), (zzan) new zzbl(this, (DriveFile.DownloadProgressListener) null));
                }
            });
        } else {
            throw new IllegalStateException("reopenForWrite can only be used with DriveContents opened with MODE_READ_ONLY.");
        }
    }

    public PendingResult<Status> zza(GoogleApiClient googleApiClient, final MetadataChangeSet metadataChangeSet, final zzi zzi) {
        if (zzi == null) {
            zzi = new zzi.zza().build();
        }
        if (this.zzara.getMode() == 268435456) {
            throw new IllegalStateException("Cannot commit contents opened with MODE_READ_ONLY");
        } else if (!ExecutionOptions.zzcv(zzi.zzsD()) || this.zzara.zzsv()) {
            zzi.zzg(googleApiClient);
            if (zzsz()) {
                throw new IllegalStateException("DriveContents already closed.");
            } else if (getDriveId() != null) {
                if (metadataChangeSet == null) {
                    metadataChangeSet = MetadataChangeSet.zzapd;
                }
                zzsy();
                return googleApiClient.zzb(new zzt.zza(googleApiClient) {
                    /* access modifiers changed from: protected */
                    public void zza(zzu zzu) throws RemoteException {
                        metadataChangeSet.zzsL().setContext(zzu.getContext());
                        zzu.zzte().zza(new CloseContentsAndUpdateMetadataRequest(zzv.this.zzara.getDriveId(), metadataChangeSet.zzsL(), zzv.this.zzara.getRequestId(), zzv.this.zzara.zzsv(), zzi), (zzan) new zzbu(this));
                    }
                });
            } else {
                throw new IllegalStateException("Only DriveContents obtained through DriveFile.open can be committed.");
            }
        } else {
            throw new IllegalStateException("DriveContents must be valid for conflict detection.");
        }
    }

    public Contents zzsx() {
        return this.zzara;
    }

    public void zzsy() {
        zzna.zza(this.zzara.getParcelFileDescriptor());
        this.mClosed = true;
    }

    public boolean zzsz() {
        return this.mClosed;
    }
}
