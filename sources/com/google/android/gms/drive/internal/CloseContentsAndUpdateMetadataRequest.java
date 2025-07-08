package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.zzi;

public class CloseContentsAndUpdateMetadataRequest implements SafeParcelable {
    public static final Parcelable.Creator<CloseContentsAndUpdateMetadataRequest> CREATOR = new zzh();
    final int mVersionCode;
    final String zzaoV;
    final boolean zzaoW;
    final boolean zzapa;
    final DriveId zzaqj;
    final MetadataBundle zzaqk;
    final Contents zzaql;
    final int zzaqm;
    final int zzaqn;
    final boolean zzaqo;

    CloseContentsAndUpdateMetadataRequest(int i, DriveId driveId, MetadataBundle metadataBundle, Contents contents, boolean z, String str, int i2, int i3, boolean z2, boolean z3) {
        this.mVersionCode = i;
        this.zzaqj = driveId;
        this.zzaqk = metadataBundle;
        this.zzaql = contents;
        this.zzaoW = z;
        this.zzaoV = str;
        this.zzaqm = i2;
        this.zzaqn = i3;
        this.zzaqo = z2;
        this.zzapa = z3;
    }

    public CloseContentsAndUpdateMetadataRequest(DriveId driveId, MetadataBundle metadataBundle, int i, boolean z, zzi zzi) {
        this(1, driveId, metadataBundle, (Contents) null, zzi.zzsC(), zzi.zzsB(), zzi.zzsD(), i, z, zzi.zzsI());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzh.zza(this, parcel, i);
    }
}
