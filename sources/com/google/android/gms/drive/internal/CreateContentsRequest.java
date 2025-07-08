package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public class CreateContentsRequest implements SafeParcelable {
    public static final Parcelable.Creator<CreateContentsRequest> CREATOR = new zzk();
    final int mVersionCode;
    final int zzaoy;

    public CreateContentsRequest(int i) {
        this(1, i);
    }

    CreateContentsRequest(int i, int i2) {
        this.mVersionCode = i;
        zzx.zzb(i2 == 536870912 || i2 == 805306368, (Object) "Cannot create a new read-only contents!");
        this.zzaoy = i2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzk.zza(this, parcel, i);
    }
}
