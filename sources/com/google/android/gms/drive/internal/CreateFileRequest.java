package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.zzh;

public class CreateFileRequest implements SafeParcelable {
    public static final Parcelable.Creator<CreateFileRequest> CREATOR = new zzn();
    final int mVersionCode;
    final String zzaoV;
    final String zzaoY;
    final int zzaqA;
    final boolean zzaqd;
    final Contents zzaql;
    final MetadataBundle zzaqw;
    final Integer zzaqx;
    final DriveId zzaqy;
    final int zzaqz;

    CreateFileRequest(int i, DriveId driveId, MetadataBundle metadataBundle, Contents contents, Integer num, boolean z, String str, int i2, int i3, String str2) {
        if (!(contents == null || i3 == 0)) {
            zzx.zzb(contents.getRequestId() == i3, (Object) "inconsistent contents reference");
        }
        if ((num == null || num.intValue() == 0) && contents == null && i3 == 0) {
            throw new IllegalArgumentException("Need a valid contents");
        }
        this.mVersionCode = i;
        this.zzaqy = (DriveId) zzx.zzz(driveId);
        this.zzaqw = (MetadataBundle) zzx.zzz(metadataBundle);
        this.zzaql = contents;
        this.zzaqx = num;
        this.zzaoV = str;
        this.zzaqz = i2;
        this.zzaqd = z;
        this.zzaqA = i3;
        this.zzaoY = str2;
    }

    public CreateFileRequest(DriveId driveId, MetadataBundle metadataBundle, int i, int i2, zzh zzh) {
        this(2, driveId, metadataBundle, (Contents) null, Integer.valueOf(i2), zzh.zzsC(), zzh.zzsB(), zzh.zzsD(), i, zzh.zzsF());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzn.zza(this, parcel, i);
    }
}
