package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class AuthorizeAccessRequest implements SafeParcelable {
    public static final Parcelable.Creator<AuthorizeAccessRequest> CREATOR = new zzc();
    final int mVersionCode;
    final DriveId zzaoz;
    final long zzaqe;

    AuthorizeAccessRequest(int i, long j, DriveId driveId) {
        this.mVersionCode = i;
        this.zzaqe = j;
        this.zzaoz = driveId;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }
}
