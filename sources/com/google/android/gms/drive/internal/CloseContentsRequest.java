package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;

public class CloseContentsRequest implements SafeParcelable {
    public static final Parcelable.Creator<CloseContentsRequest> CREATOR = new zzi();
    final int mVersionCode;
    final Contents zzaql;
    final int zzaqn;
    final Boolean zzaqp;

    CloseContentsRequest(int i, Contents contents, Boolean bool, int i2) {
        this.mVersionCode = i;
        this.zzaql = contents;
        this.zzaqp = bool;
        this.zzaqn = i2;
    }

    public CloseContentsRequest(int i, boolean z) {
        this(1, (Contents) null, Boolean.valueOf(z), i);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzi.zza(this, parcel, i);
    }
}
