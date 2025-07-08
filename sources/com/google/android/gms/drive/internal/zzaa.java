package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.drive.DrivePreferencesApi;
import com.google.android.gms.drive.FileUploadPreferences;
import com.google.android.gms.drive.internal.zzt;

public class zzaa implements DrivePreferencesApi {

    private class zza extends zzd {
        private final zza.zzb<DrivePreferencesApi.FileUploadPreferencesResult> zzamC;

        private zza(zza.zzb<DrivePreferencesApi.FileUploadPreferencesResult> zzb) {
            this.zzamC = zzb;
        }

        public void onError(Status status) throws RemoteException {
            this.zzamC.zzs(new zzb(status, (FileUploadPreferences) null));
        }

        public void zza(OnDeviceUsagePreferenceResponse onDeviceUsagePreferenceResponse) throws RemoteException {
            this.zzamC.zzs(new zzb(Status.zzagC, onDeviceUsagePreferenceResponse.zztp()));
        }
    }

    private class zzb implements DrivePreferencesApi.FileUploadPreferencesResult {
        private final Status zzUX;
        private final FileUploadPreferences zzarw;

        private zzb(Status status, FileUploadPreferences fileUploadPreferences) {
            this.zzUX = status;
            this.zzarw = fileUploadPreferences;
        }

        public FileUploadPreferences getFileUploadPreferences() {
            return this.zzarw;
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    private abstract class zzc extends zzt<DrivePreferencesApi.FileUploadPreferencesResult> {
        public zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* access modifiers changed from: protected */
        /* renamed from: zzG */
        public DrivePreferencesApi.FileUploadPreferencesResult zzc(Status status) {
            return new zzb(status, (FileUploadPreferences) null);
        }
    }

    public PendingResult<DrivePreferencesApi.FileUploadPreferencesResult> getFileUploadPreferences(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new zzc(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzu zzu) throws RemoteException {
                zzu.zzte().zzd(new zza(this));
            }
        });
    }

    public PendingResult<Status> setFileUploadPreferences(GoogleApiClient googleApiClient, FileUploadPreferences fileUploadPreferences) {
        if (fileUploadPreferences instanceof FileUploadPreferencesImpl) {
            final FileUploadPreferencesImpl fileUploadPreferencesImpl = (FileUploadPreferencesImpl) fileUploadPreferences;
            return googleApiClient.zzb(new zzt.zza(googleApiClient) {
                /* access modifiers changed from: protected */
                public void zza(zzu zzu) throws RemoteException {
                    zzu.zzte().zza(new SetFileUploadPreferencesRequest(fileUploadPreferencesImpl), (zzan) new zzbu(this));
                }
            });
        }
        throw new IllegalArgumentException("Invalid preference value");
    }
}
