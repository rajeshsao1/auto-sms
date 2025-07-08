package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class UpdatePermissionRequest implements SafeParcelable {
    public static final Parcelable.Creator<UpdatePermissionRequest> CREATOR = new zzcb();
    final int mVersionCode;
    final String zzaoV;
    final DriveId zzaoz;
    final String zzapk;
    final boolean zzaqd;
    final int zzasE;

    UpdatePermissionRequest(int i, DriveId driveId, String str, int i2, boolean z, String str2) {
        this.mVersionCode = i;
        this.zzaoz = driveId;
        this.zzapk = str;
        this.zzasE = i2;
        this.zzaqd = z;
        this.zzaoV = str2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzcb.zza(this, parcel, i);
    }
}
