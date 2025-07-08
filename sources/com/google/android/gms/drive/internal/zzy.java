package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.metadata.internal.zzi;
import com.google.android.gms.drive.query.Filters;
import com.google.android.gms.drive.query.Query;
import com.google.android.gms.drive.query.SearchableField;
import com.google.android.gms.drive.zzh;
import com.google.android.gms.internal.zznm;

public class zzy extends zzab implements DriveFolder {

    private static class zza extends zzd {
        private final zza.zzb<DriveFolder.DriveFileResult> zzamC;

        public zza(zza.zzb<DriveFolder.DriveFileResult> zzb) {
            this.zzamC = zzb;
        }

        public void onError(Status status) throws RemoteException {
            this.zzamC.zzs(new zzc(status, (DriveFile) null));
        }

        public void zza(OnDriveIdResponse onDriveIdResponse) throws RemoteException {
            this.zzamC.zzs(new zzc(Status.zzagC, new zzw(onDriveIdResponse.getDriveId())));
        }
    }

    private static class zzb extends zzd {
        private final zza.zzb<DriveFolder.DriveFolderResult> zzamC;

        public zzb(zza.zzb<DriveFolder.DriveFolderResult> zzb) {
            this.zzamC = zzb;
        }

        public void onError(Status status) throws RemoteException {
            this.zzamC.zzs(new zze(status, (DriveFolder) null));
        }

        public void zza(OnDriveIdResponse onDriveIdResponse) throws RemoteException {
            this.zzamC.zzs(new zze(Status.zzagC, new zzy(onDriveIdResponse.getDriveId())));
        }
    }

    private static class zzc implements DriveFolder.DriveFileResult {
        private final Status zzUX;
        private final DriveFile zzarr;

        public zzc(Status status, DriveFile driveFile) {
            this.zzUX = status;
            this.zzarr = driveFile;
        }

        public DriveFile getDriveFile() {
            return this.zzarr;
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    static abstract class zzd extends zzt<DriveFolder.DriveFileResult> {
        zzd(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzE */
        public DriveFolder.DriveFileResult zzc(Status status) {
            return new zzc(status, (DriveFile) null);
        }
    }

    private static class zze implements DriveFolder.DriveFolderResult {
        private final Status zzUX;
        private final DriveFolder zzars;

        public zze(Status status, DriveFolder driveFolder) {
            this.zzUX = status;
            this.zzars = driveFolder;
        }

        public DriveFolder getDriveFolder() {
            return this.zzars;
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    static abstract class zzf extends zzt<DriveFolder.DriveFolderResult> {
        zzf(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzF */
        public DriveFolder.DriveFolderResult zzc(Status status) {
            return new zze(status, (DriveFolder) null);
        }
    }

    public zzy(DriveId driveId) {
        super(driveId);
    }

    private int zza(DriveContents driveContents, zzi zzi) {
        if (driveContents == null) {
            return (zzi == null || !zzi.zztI()) ? 1 : 0;
        }
        int requestId = driveContents.zzsx().getRequestId();
        driveContents.zzsy();
        return requestId;
    }

    private PendingResult<DriveFolder.DriveFileResult> zza(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, int i, zzh zzh) {
        zzi zzdd = zzi.zzdd(metadataChangeSet.getMimeType());
        final int i2 = (zzdd == null || !zzdd.zztI()) ? 0 : 1;
        final MetadataChangeSet metadataChangeSet2 = metadataChangeSet;
        final int i3 = i;
        final zzh zzh2 = zzh;
        return googleApiClient.zzb(new zzd(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzu zzu) throws RemoteException {
                metadataChangeSet2.zzsL().setContext(zzu.getContext());
                zzu.zzte().zza(new CreateFileRequest(zzy.this.getDriveId(), metadataChangeSet2.zzsL(), i3, i2, zzh2), (zzan) new zza(this));
            }
        });
    }

    private MetadataChangeSet zza(MetadataChangeSet metadataChangeSet, String str) {
        return metadataChangeSet.zza(zznm.zzatE, str);
    }

    private Query zza(Query query) {
        Query.Builder addFilter = new Query.Builder().addFilter(Filters.in(SearchableField.PARENTS, getDriveId()));
        if (query != null) {
            if (query.getFilter() != null) {
                addFilter.addFilter(query.getFilter());
            }
            addFilter.setPageToken(query.getPageToken());
            addFilter.setSortOrder(query.getSortOrder());
        }
        return addFilter.build();
    }

    private void zzb(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, DriveContents driveContents, zzh zzh) {
        if (metadataChangeSet != null) {
            zzi zzdd = zzi.zzdd(metadataChangeSet.getMimeType());
            if (zzdd == null || !zzdd.isFolder()) {
                zzh.zzg(googleApiClient);
                if (driveContents != null) {
                    if (!(driveContents instanceof zzv)) {
                        throw new IllegalArgumentException("Only DriveContents obtained from the Drive API are accepted.");
                    } else if (driveContents.getDriveId() != null) {
                        throw new IllegalArgumentException("Only DriveContents obtained through DriveApi.newDriveContents are accepted for file creation.");
                    } else if (driveContents.zzsz()) {
                        throw new IllegalArgumentException("DriveContents are already closed.");
                    }
                }
            } else {
                throw new IllegalArgumentException("May not create folders using this method. Use DriveFolder.createFolder() instead of mime type application/vnd.google-apps.folder");
            }
        } else {
            throw new IllegalArgumentException("MetadataChangeSet must be provided.");
        }
    }

    private void zzb(MetadataChangeSet metadataChangeSet) {
        if (metadataChangeSet != null) {
            zzi zzdd = zzi.zzdd(metadataChangeSet.getMimeType());
            if (zzdd != null && !zzdd.zztH()) {
                throw new IllegalArgumentException("May not create shortcut files using this method. Use DriveFolder.createShortcutFile() instead.");
            }
            return;
        }
        throw new IllegalArgumentException("MetadataChangeSet must be provided.");
    }

    public PendingResult<DriveFolder.DriveFileResult> createFile(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, DriveContents driveContents) {
        zzb(metadataChangeSet);
        return zza(googleApiClient, metadataChangeSet, driveContents, (zzh) null);
    }

    public PendingResult<DriveFolder.DriveFileResult> createFile(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, DriveContents driveContents, ExecutionOptions executionOptions) {
        zzb(metadataChangeSet);
        return zza(googleApiClient, metadataChangeSet, driveContents, zzh.zza(executionOptions));
    }

    public PendingResult<DriveFolder.DriveFolderResult> createFolder(GoogleApiClient googleApiClient, final MetadataChangeSet metadataChangeSet) {
        if (metadataChangeSet == null) {
            throw new IllegalArgumentException("MetadataChangeSet must be provided.");
        } else if (metadataChangeSet.getMimeType() == null || metadataChangeSet.getMimeType().equals(DriveFolder.MIME_TYPE)) {
            return googleApiClient.zzb(new zzf(googleApiClient) {
                /* access modifiers changed from: protected */
                public void zza(zzu zzu) throws RemoteException {
                    metadataChangeSet.zzsL().setContext(zzu.getContext());
                    zzu.zzte().zza(new CreateFolderRequest(zzy.this.getDriveId(), metadataChangeSet.zzsL()), (zzan) new zzb(this));
                }
            });
        } else {
            throw new IllegalArgumentException("The mimetype must be of type application/vnd.google-apps.folder");
        }
    }

    public PendingResult<DriveApi.MetadataBufferResult> listChildren(GoogleApiClient googleApiClient) {
        return queryChildren(googleApiClient, (Query) null);
    }

    public PendingResult<DriveApi.MetadataBufferResult> queryChildren(GoogleApiClient googleApiClient, Query query) {
        return new zzs().query(googleApiClient, zza(query));
    }

    public PendingResult<DriveFolder.DriveFileResult> zza(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, DriveContents driveContents, zzh zzh) {
        if (zzh == null) {
            zzh = new zzh.zza().build();
        }
        zzb(googleApiClient, metadataChangeSet, driveContents, zzh);
        int zza2 = zza(driveContents, zzi.zzdd(metadataChangeSet.getMimeType()));
        String zzsG = zzh.zzsG();
        if (zzsG != null) {
            metadataChangeSet = zza(metadataChangeSet, zzsG);
        }
        return zza(googleApiClient, metadataChangeSet, zza2, zzh);
    }
}
