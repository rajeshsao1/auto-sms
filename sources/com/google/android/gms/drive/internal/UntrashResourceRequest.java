package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class UntrashResourceRequest implements SafeParcelable {
    public static final Parcelable.Creator<UntrashResourceRequest> CREATOR = new zzbz();
    final int mVersionCode;
    final DriveId zzaqj;

    UntrashResourceRequest(int i, DriveId driveId) {
        this.mVersionCode = i;
        this.zzaqj = driveId;
    }

    public UntrashResourceRequest(DriveId driveId) {
        this(1, driveId);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzbz.zza(this, parcel, i);
    }
}
