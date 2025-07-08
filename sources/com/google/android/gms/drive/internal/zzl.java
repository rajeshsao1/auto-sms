package com.google.android.gms.drive.internal;

import android.content.IntentSender;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;

public class zzl {
    private String zzapg;
    private DriveId zzapj;
    protected MetadataChangeSet zzaqt;
    private Integer zzaqu;
    private final int zzaqv;

    public zzl(int i) {
        this.zzaqv = i;
    }

    public IntentSender build(GoogleApiClient googleApiClient) {
        zzx.zzb(this.zzaqt, (Object) "Must provide initial metadata to CreateFileActivityBuilder.");
        zzx.zza(googleApiClient.isConnected(), (Object) "Client must be connected");
        zzu zzu = (zzu) googleApiClient.zza(Drive.zzUI);
        this.zzaqt.zzsL().setContext(zzu.getContext());
        Integer num = this.zzaqu;
        try {
            return zzu.zzte().zza(new CreateFileIntentSenderRequest(this.zzaqt.zzsL(), num == null ? 0 : num.intValue(), this.zzapg, this.zzapj, this.zzaqv));
        } catch (RemoteException e) {
            throw new RuntimeException("Unable to connect Drive Play Service", e);
        }
    }

    public void zza(DriveId driveId) {
        this.zzapj = (DriveId) zzx.zzz(driveId);
    }

    public void zza(MetadataChangeSet metadataChangeSet) {
        this.zzaqt = (MetadataChangeSet) zzx.zzz(metadataChangeSet);
    }

    public void zzcZ(int i) {
        this.zzaqu = Integer.valueOf(i);
    }

    public void zzdb(String str) {
        this.zzapg = (String) zzx.zzz(str);
    }
}
