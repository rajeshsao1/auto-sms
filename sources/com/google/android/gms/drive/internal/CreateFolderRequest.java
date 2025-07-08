package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class CreateFolderRequest implements SafeParcelable {
    public static final Parcelable.Creator<CreateFolderRequest> CREATOR = new zzo();
    final int mVersionCode;
    final MetadataBundle zzaqw;
    final DriveId zzaqy;

    CreateFolderRequest(int i, DriveId driveId, MetadataBundle metadataBundle) {
        this.mVersionCode = i;
        this.zzaqy = (DriveId) zzx.zzz(driveId);
        this.zzaqw = (MetadataBundle) zzx.zzz(metadataBundle);
    }

    public CreateFolderRequest(DriveId driveId, MetadataBundle metadataBundle) {
        this(1, driveId, metadataBundle);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzo.zza(this, parcel, i);
    }
}
