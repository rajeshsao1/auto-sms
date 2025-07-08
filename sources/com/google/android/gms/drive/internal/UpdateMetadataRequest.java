package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class UpdateMetadataRequest implements SafeParcelable {
    public static final Parcelable.Creator<UpdateMetadataRequest> CREATOR = new zzca();
    final int mVersionCode;
    final DriveId zzaqj;
    final MetadataBundle zzaqk;

    UpdateMetadataRequest(int i, DriveId driveId, MetadataBundle metadataBundle) {
        this.mVersionCode = i;
        this.zzaqj = driveId;
        this.zzaqk = metadataBundle;
    }

    public UpdateMetadataRequest(DriveId driveId, MetadataBundle metadataBundle) {
        this(1, driveId, metadataBundle);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzca.zza(this, parcel, i);
    }
}
