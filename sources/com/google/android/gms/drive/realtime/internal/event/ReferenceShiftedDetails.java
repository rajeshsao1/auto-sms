package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ReferenceShiftedDetails implements SafeParcelable {
    public static final Parcelable.Creator<ReferenceShiftedDetails> CREATOR = new zze();
    final int mVersionCode;
    final String zzavj;
    final String zzavk;
    final int zzavl;
    final int zzavm;

    ReferenceShiftedDetails(int i, String str, String str2, int i2, int i3) {
        this.mVersionCode = i;
        this.zzavj = str;
        this.zzavk = str2;
        this.zzavl = i2;
        this.zzavm = i3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zze.zza(this, parcel, i);
    }
}
