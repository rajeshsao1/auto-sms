package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class OnDriveIdResponse implements SafeParcelable {
    public static final Parcelable.Creator<OnDriveIdResponse> CREATOR = new zzaz();
    final int mVersionCode;
    DriveId zzaqj;

    OnDriveIdResponse(int i, DriveId driveId) {
        this.mVersionCode = i;
        this.zzaqj = driveId;
    }

    public int describeContents() {
        return 0;
    }

    public DriveId getDriveId() {
        return this.zzaqj;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzaz.zza(this, parcel, i);
    }
}
