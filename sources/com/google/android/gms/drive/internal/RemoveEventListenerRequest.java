package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.TransferProgressOptions;

public class RemoveEventListenerRequest implements SafeParcelable {
    public static final Parcelable.Creator<RemoveEventListenerRequest> CREATOR = new zzbp();
    final int mVersionCode;
    final int zzanf;
    final DriveId zzaoz;
    final TransferProgressOptions zzapZ;

    RemoveEventListenerRequest(int i, DriveId driveId, int i2, TransferProgressOptions transferProgressOptions) {
        this.mVersionCode = i;
        this.zzaoz = driveId;
        this.zzanf = i2;
        this.zzapZ = transferProgressOptions;
    }

    public RemoveEventListenerRequest(DriveId driveId, int i) {
        this(driveId, i, (TransferProgressOptions) null);
    }

    RemoveEventListenerRequest(DriveId driveId, int i, TransferProgressOptions transferProgressOptions) {
        this(1, driveId, i, transferProgressOptions);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzbp.zza(this, parcel, i);
    }
}
