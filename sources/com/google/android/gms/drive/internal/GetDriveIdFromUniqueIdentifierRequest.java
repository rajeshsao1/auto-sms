package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetDriveIdFromUniqueIdentifierRequest implements SafeParcelable {
    public static final Parcelable.Creator<GetDriveIdFromUniqueIdentifierRequest> CREATOR = new zzai();
    final int mVersionCode;
    final String zzaoZ;
    final boolean zzarM;

    GetDriveIdFromUniqueIdentifierRequest(int i, String str, boolean z) {
        this.mVersionCode = i;
        this.zzaoZ = str;
        this.zzarM = z;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzai.zza(this, parcel, i);
    }
}
