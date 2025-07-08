package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;

public class OnContentsResponse implements SafeParcelable {
    public static final Parcelable.Creator<OnContentsResponse> CREATOR = new zzaw();
    final int mVersionCode;
    final Contents zzara;
    final boolean zzasf;

    OnContentsResponse(int i, Contents contents, boolean z) {
        this.mVersionCode = i;
        this.zzara = contents;
        this.zzasf = z;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzaw.zza(this, parcel, i);
    }

    public Contents zztn() {
        return this.zzara;
    }

    public boolean zzto() {
        return this.zzasf;
    }
}
