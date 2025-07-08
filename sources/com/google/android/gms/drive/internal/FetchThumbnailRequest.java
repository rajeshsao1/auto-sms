package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class FetchThumbnailRequest implements SafeParcelable {
    public static final Parcelable.Creator<FetchThumbnailRequest> CREATOR = new zzaf();
    final int mVersionCode;
    final DriveId zzaqj;

    FetchThumbnailRequest(int i, DriveId driveId) {
        this.mVersionCode = i;
        this.zzaqj = driveId;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzaf.zza(this, parcel, i);
    }
}
