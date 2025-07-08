package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class StreamContentsRequest implements SafeParcelable {
    public static final Parcelable.Creator<StreamContentsRequest> CREATOR = new zzbv();
    final int mVersionCode;
    final DriveId zzaqj;

    StreamContentsRequest(int i, DriveId driveId) {
        this.mVersionCode = i;
        this.zzaqj = driveId;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzbv.zza(this, parcel, i);
    }
}
