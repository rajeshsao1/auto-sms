package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class GetPermissionsRequest implements SafeParcelable {
    public static final Parcelable.Creator<GetPermissionsRequest> CREATOR = new zzak();
    final int mVersionCode;
    final DriveId zzaoz;

    GetPermissionsRequest(int i, DriveId driveId) {
        this.mVersionCode = i;
        this.zzaoz = driveId;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzak.zza(this, parcel, i);
    }
}
