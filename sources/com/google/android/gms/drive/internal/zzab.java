package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.events.ChangeListener;
import com.google.android.gms.drive.internal.zzs;
import com.google.android.gms.drive.internal.zzt;
import java.util.ArrayList;
import java.util.Set;

public class zzab implements DriveResource {
    protected final DriveId zzaoz;

    private static class zza extends zzd {
        private final zza.zzb<DriveApi.MetadataBufferResult> zzamC;

        public zza(zza.zzb<DriveApi.MetadataBufferResult> zzb) {
            this.zzamC = zzb;
        }

        public void onError(Status status) throws RemoteException {
            this.zzamC.zzs(new zzs.zzg(status, (MetadataBuffer) null, false));
        }

        public void zza(OnListParentsResponse onListParentsResponse) throws RemoteException {
            this.zzamC.zzs(new zzs.zzg(Status.zzagC, new MetadataBuffer(onListParentsResponse.zztv()), false));
        }
    }

    private static class zzb extends zzd {
        private final zza.zzb<DriveResource.MetadataResult> zzamC;

        public zzb(zza.zzb<DriveResource.MetadataResult> zzb) {
            this.zzamC = zzb;
        }

        public void onError(Status status) throws RemoteException {
            this.zzamC.zzs(new zzc(status, (Metadata) null));
        }

        public void zza(OnMetadataResponse onMetadataResponse) throws RemoteException {
            this.zzamC.zzs(new zzc(Status.zzagC, new zzp(onMetadataResponse.zztw())));
        }
    }

    private static class zzc implements DriveResource.MetadataResult {
        private final Status zzUX;
        private final Metadata zzarA;

        public zzc(Status status, Metadata metadata) {
            this.zzUX = status;
            this.zzarA = metadata;
        }

        public Metadata getMetadata() {
            return this.zzarA;
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    private abstract class zzd extends zzt<DriveResource.MetadataResult> {
        private zzd(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzH */
        public DriveResource.MetadataResult zzc(Status status) {
            return new zzc(status, (Metadata) null);
        }
    }

    public zzab(DriveId driveId) {
        this.zzaoz = driveId;
    }

    private PendingResult<DriveResource.MetadataResult> zza(GoogleApiClient googleApiClient, final boolean z) {
        return googleApiClient.zza(new zzd(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzu zzu) throws RemoteException {
                zzu.zzte().zza(new GetMetadataRequest(zzab.this.zzaoz, z), (zzan) new zzb(this));
            }
        });
    }

    public PendingResult<Status> addChangeListener(GoogleApiClient googleApiClient, ChangeListener changeListener) {
        return ((zzu) googleApiClient.zza(Drive.zzUI)).zza(googleApiClient, this.zzaoz, changeListener);
    }

    public PendingResult<Status> addChangeSubscription(GoogleApiClient googleApiClient) {
        return ((zzu) googleApiClient.zza(Drive.zzUI)).zza(googleApiClient, this.zzaoz);
    }

    public PendingResult<Status> delete(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new zzt.zza(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzu zzu) throws RemoteException {
                zzu.zzte().zza(new DeleteResourceRequest(zzab.this.zzaoz), (zzan) new zzbu(this));
            }
        });
    }

    public DriveId getDriveId() {
        return this.zzaoz;
    }

    public PendingResult<DriveResource.MetadataResult> getMetadata(GoogleApiClient googleApiClient) {
        return zza(googleApiClient, false);
    }

    public PendingResult<DriveApi.MetadataBufferResult> listParents(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new zzs.zzh(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzu zzu) throws RemoteException {
                zzu.zzte().zza(new ListParentsRequest(zzab.this.zzaoz), (zzan) new zza(this));
            }
        });
    }

    public PendingResult<Status> removeChangeListener(GoogleApiClient googleApiClient, ChangeListener changeListener) {
        return ((zzu) googleApiClient.zza(Drive.zzUI)).zzb(googleApiClient, this.zzaoz, changeListener);
    }

    public PendingResult<Status> removeChangeSubscription(GoogleApiClient googleApiClient) {
        return ((zzu) googleApiClient.zza(Drive.zzUI)).zzb(googleApiClient, this.zzaoz);
    }

    public PendingResult<Status> setParents(GoogleApiClient googleApiClient, Set<DriveId> set) {
        if (set != null) {
            final ArrayList arrayList = new ArrayList(set);
            return googleApiClient.zzb(new zzt.zza(googleApiClient) {
                /* access modifiers changed from: protected */
                public void zza(zzu zzu) throws RemoteException {
                    zzu.zzte().zza(new SetResourceParentsRequest(zzab.this.zzaoz, arrayList), (zzan) new zzbu(this));
                }
            });
        }
        throw new IllegalArgumentException("ParentIds must be provided.");
    }

    public PendingResult<Status> trash(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new zzt.zza(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzu zzu) throws RemoteException {
                zzu.zzte().zza(new TrashResourceRequest(zzab.this.zzaoz), (zzan) new zzbu(this));
            }
        });
    }

    public PendingResult<Status> untrash(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new zzt.zza(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzu zzu) throws RemoteException {
                zzu.zzte().zza(new UntrashResourceRequest(zzab.this.zzaoz), (zzan) new zzbu(this));
            }
        });
    }

    public PendingResult<DriveResource.MetadataResult> updateMetadata(GoogleApiClient googleApiClient, final MetadataChangeSet metadataChangeSet) {
        if (metadataChangeSet != null) {
            return googleApiClient.zzb(new zzd(googleApiClient) {
                /* access modifiers changed from: protected */
                public void zza(zzu zzu) throws RemoteException {
                    metadataChangeSet.zzsL().setContext(zzu.getContext());
                    zzu.zzte().zza(new UpdateMetadataRequest(zzab.this.zzaoz, metadataChangeSet.zzsL()), (zzan) new zzb(this));
                }
            });
        }
        throw new IllegalArgumentException("ChangeSet must be provided.");
    }
}
