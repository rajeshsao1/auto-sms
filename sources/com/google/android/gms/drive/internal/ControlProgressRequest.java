package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class ControlProgressRequest implements SafeParcelable {
    public static final Parcelable.Creator<ControlProgressRequest> CREATOR = new zzj();
    final int mVersionCode;
    final DriveId zzaoz;
    final int zzaqq;
    final int zzaqr;
    final ParcelableTransferPreferences zzaqs;

    ControlProgressRequest(int i, int i2, int i3, DriveId driveId, ParcelableTransferPreferences parcelableTransferPreferences) {
        this.mVersionCode = i;
        this.zzaqq = i2;
        this.zzaqr = i3;
        this.zzaoz = driveId;
        this.zzaqs = parcelableTransferPreferences;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzj.zza(this, parcel, i);
    }
}
