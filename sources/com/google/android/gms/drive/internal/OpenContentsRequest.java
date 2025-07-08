package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class OpenContentsRequest implements SafeParcelable {
    public static final Parcelable.Creator<OpenContentsRequest> CREATOR = new zzbk();
    final int mVersionCode;
    final int zzaoy;
    final DriveId zzaqj;
    final int zzasx;

    OpenContentsRequest(int i, DriveId driveId, int i2, int i3) {
        this.mVersionCode = i;
        this.zzaqj = driveId;
        this.zzaoy = i2;
        this.zzasx = i3;
    }

    public OpenContentsRequest(DriveId driveId, int i, int i2) {
        this(1, driveId, i, i2);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzbk.zza(this, parcel, i);
    }
}
