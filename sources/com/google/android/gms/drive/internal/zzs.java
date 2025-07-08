package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BooleanResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.drive.CreateFileActivityBuilder;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.OpenFileActivityBuilder;
import com.google.android.gms.drive.internal.zzt;
import com.google.android.gms.drive.query.Query;
import java.util.List;

public class zzs implements DriveApi {

    private static class zza extends zzd {
        private final zza.zzb<DriveApi.DriveContentsResult> zzamC;

        public zza(zza.zzb<DriveApi.DriveContentsResult> zzb) {
            this.zzamC = zzb;
        }

        public void onError(Status status) throws RemoteException {
            this.zzamC.zzs(new zzb(status, (DriveContents) null));
        }

        public void zza(OnContentsResponse onContentsResponse) throws RemoteException {
            this.zzamC.zzs(new zzb(Status.zzagC, new zzv(onContentsResponse.zztn())));
        }
    }

    static class zzb implements Releasable, DriveApi.DriveContentsResult {
        private final Status zzUX;
        private final DriveContents zzaoC;

        public zzb(Status status, DriveContents driveContents) {
            this.zzUX = status;
            this.zzaoC = driveContents;
        }

        public DriveContents getDriveContents() {
            return this.zzaoC;
        }

        public Status getStatus() {
            return this.zzUX;
        }

        public void release() {
            DriveContents driveContents = this.zzaoC;
            if (driveContents != null) {
                driveContents.zzsy();
            }
        }
    }

    static abstract class zzc extends zzt<DriveApi.DriveContentsResult> {
        zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzB */
        public DriveApi.DriveContentsResult zzc(Status status) {
            return new zzb(status, (DriveContents) null);
        }
    }

    static class zzd extends zzd {
        private final zza.zzb<DriveApi.DriveIdResult> zzamC;

        public zzd(zza.zzb<DriveApi.DriveIdResult> zzb) {
            this.zzamC = zzb;
        }

        public void onError(Status status) throws RemoteException {
            this.zzamC.zzs(new zze(status, (DriveId) null));
        }

        public void zza(OnDriveIdResponse onDriveIdResponse) throws RemoteException {
            this.zzamC.zzs(new zze(Status.zzagC, onDriveIdResponse.getDriveId()));
        }

        public void zza(OnMetadataResponse onMetadataResponse) throws RemoteException {
            this.zzamC.zzs(new zze(Status.zzagC, new zzp(onMetadataResponse.zztw()).getDriveId()));
        }
    }

    private static class zze implements DriveApi.DriveIdResult {
        private final Status zzUX;
        private final DriveId zzaoz;

        public zze(Status status, DriveId driveId) {
            this.zzUX = status;
            this.zzaoz = driveId;
        }

        public DriveId getDriveId() {
            return this.zzaoz;
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    static abstract class zzf extends zzt<DriveApi.DriveIdResult> {
        zzf(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzC */
        public DriveApi.DriveIdResult zzc(Status status) {
            return new zze(status, (DriveId) null);
        }
    }

    static class zzg implements DriveApi.MetadataBufferResult {
        private final Status zzUX;
        private final MetadataBuffer zzaqI;
        private final boolean zzaqJ;

        public zzg(Status status, MetadataBuffer metadataBuffer, boolean z) {
            this.zzUX = status;
            this.zzaqI = metadataBuffer;
            this.zzaqJ = z;
        }

        public MetadataBuffer getMetadataBuffer() {
            return this.zzaqI;
        }

        public Status getStatus() {
            return this.zzUX;
        }

        public void release() {
            MetadataBuffer metadataBuffer = this.zzaqI;
            if (metadataBuffer != null) {
                metadataBuffer.release();
            }
        }
    }

    static abstract class zzh extends zzt<DriveApi.MetadataBufferResult> {
        zzh(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzD */
        public DriveApi.MetadataBufferResult zzc(Status status) {
            return new zzg(status, (MetadataBuffer) null, false);
        }
    }

    private static class zzi extends zzd {
        private final zza.zzb<DriveApi.MetadataBufferResult> zzamC;

        public zzi(zza.zzb<DriveApi.MetadataBufferResult> zzb) {
            this.zzamC = zzb;
        }

        public void onError(Status status) throws RemoteException {
            this.zzamC.zzs(new zzg(status, (MetadataBuffer) null, false));
        }

        public void zza(OnListEntriesResponse onListEntriesResponse) throws RemoteException {
            this.zzamC.zzs(new zzg(Status.zzagC, new MetadataBuffer(onListEntriesResponse.zztt()), onListEntriesResponse.zztu()));
        }
    }

    static class zzj extends zzt.zza {
        zzj(GoogleApiClient googleApiClient, Status status) {
            super(googleApiClient);
            zza(status);
        }

        /* access modifiers changed from: protected */
        public void zza(zzu zzu) {
        }
    }

    public PendingResult<Status> cancelPendingActions(GoogleApiClient googleApiClient, List<String> list) {
        return ((zzu) googleApiClient.zza(Drive.zzUI)).cancelPendingActions(googleApiClient, list);
    }

    public PendingResult<DriveApi.DriveIdResult> fetchDriveId(GoogleApiClient googleApiClient, final String str) {
        return googleApiClient.zza(new zzf(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzu zzu) throws RemoteException {
                zzu.zzte().zza(new GetMetadataRequest(DriveId.zzcW(str), false), (zzan) new zzd(this));
            }
        });
    }

    public DriveFolder getAppFolder(GoogleApiClient googleApiClient) {
        zzu zzu = (zzu) googleApiClient.zza(Drive.zzUI);
        if (zzu.zzth()) {
            DriveId zztg = zzu.zztg();
            if (zztg != null) {
                return new zzy(zztg);
            }
            return null;
        }
        throw new IllegalStateException("Client is not yet connected");
    }

    public DriveFile getFile(GoogleApiClient googleApiClient, DriveId driveId) {
        if (driveId == null) {
            throw new IllegalArgumentException("Id must be provided.");
        } else if (googleApiClient.isConnected()) {
            return new zzw(driveId);
        } else {
            throw new IllegalStateException("Client must be connected");
        }
    }

    public DriveFolder getFolder(GoogleApiClient googleApiClient, DriveId driveId) {
        if (driveId == null) {
            throw new IllegalArgumentException("Id must be provided.");
        } else if (googleApiClient.isConnected()) {
            return new zzy(driveId);
        } else {
            throw new IllegalStateException("Client must be connected");
        }
    }

    public DriveFolder getRootFolder(GoogleApiClient googleApiClient) {
        zzu zzu = (zzu) googleApiClient.zza(Drive.zzUI);
        if (zzu.zzth()) {
            DriveId zztf = zzu.zztf();
            if (zztf != null) {
                return new zzy(zztf);
            }
            return null;
        }
        throw new IllegalStateException("Client is not yet connected");
    }

    public PendingResult<BooleanResult> isAutobackupEnabled(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new zzt<BooleanResult>(googleApiClient) {
            /* access modifiers changed from: protected */
            /* renamed from: zzA */
            public BooleanResult zzc(Status status) {
                return new BooleanResult(status, false);
            }

            /* access modifiers changed from: protected */
            public void zza(zzu zzu) throws RemoteException {
                zzu.zzte().zze(new zzd() {
                    public void zzaf(boolean z) {
                        this.zza(new BooleanResult(Status.zzagC, z));
                    }
                });
            }
        });
    }

    public CreateFileActivityBuilder newCreateFileActivityBuilder() {
        return new CreateFileActivityBuilder();
    }

    public PendingResult<DriveApi.DriveContentsResult> newDriveContents(GoogleApiClient googleApiClient) {
        return zza(googleApiClient, DriveFile.MODE_WRITE_ONLY);
    }

    public OpenFileActivityBuilder newOpenFileActivityBuilder() {
        return new OpenFileActivityBuilder();
    }

    public PendingResult<DriveApi.MetadataBufferResult> query(GoogleApiClient googleApiClient, final Query query) {
        if (query != null) {
            return googleApiClient.zza(new zzh(googleApiClient) {
                /* access modifiers changed from: protected */
                public void zza(zzu zzu) throws RemoteException {
                    zzu.zzte().zza(new QueryRequest(query), (zzan) new zzi(this));
                }
            });
        }
        throw new IllegalArgumentException("Query must be provided.");
    }

    public PendingResult<Status> requestSync(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new zzt.zza(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzu zzu) throws RemoteException {
                zzu.zzte().zza((zzan) new zzbu(this));
            }
        });
    }

    public PendingResult<DriveApi.DriveContentsResult> zza(GoogleApiClient googleApiClient, final int i) {
        return googleApiClient.zza(new zzc(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzu zzu) throws RemoteException {
                zzu.zzte().zza(new CreateContentsRequest(i), (zzan) new zza(this));
            }
        });
    }
}
