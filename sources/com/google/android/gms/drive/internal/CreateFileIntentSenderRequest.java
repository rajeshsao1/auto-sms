package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class CreateFileIntentSenderRequest implements SafeParcelable {
    public static final Parcelable.Creator<CreateFileIntentSenderRequest> CREATOR = new zzm();
    final int mVersionCode;
    final int zzaox;
    final String zzapg;
    final DriveId zzapj;
    final MetadataBundle zzaqw;
    final Integer zzaqx;

    CreateFileIntentSenderRequest(int i, MetadataBundle metadataBundle, int i2, String str, DriveId driveId, Integer num) {
        this.mVersionCode = i;
        this.zzaqw = metadataBundle;
        this.zzaox = i2;
        this.zzapg = str;
        this.zzapj = driveId;
        this.zzaqx = num;
    }

    public CreateFileIntentSenderRequest(MetadataBundle metadataBundle, int i, String str, DriveId driveId, int i2) {
        this(1, metadataBundle, i, str, driveId, Integer.valueOf(i2));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzm.zza(this, parcel, i);
    }
}
