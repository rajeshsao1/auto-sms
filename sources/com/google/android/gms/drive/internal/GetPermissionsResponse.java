package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Permission;
import java.util.List;

public class GetPermissionsResponse implements SafeParcelable {
    public static final Parcelable.Creator<GetPermissionsResponse> CREATOR = new zzal();
    final int mVersionCode;
    final List<Permission> zzarO;
    final int zzzw;

    GetPermissionsResponse(int i, List<Permission> list, int i2) {
        this.mVersionCode = i;
        this.zzarO = list;
        this.zzzw = i2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzal.zza(this, parcel, i);
    }
}
