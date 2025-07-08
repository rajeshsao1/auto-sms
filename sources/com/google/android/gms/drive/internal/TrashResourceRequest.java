package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class TrashResourceRequest implements SafeParcelable {
    public static final Parcelable.Creator<TrashResourceRequest> CREATOR = new zzbx();
    final int mVersionCode;
    final DriveId zzaqj;

    TrashResourceRequest(int i, DriveId driveId) {
        this.mVersionCode = i;
        this.zzaqj = driveId;
    }

    public TrashResourceRequest(DriveId driveId) {
        this(1, driveId);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzbx.zza(this, parcel, i);
    }
}
