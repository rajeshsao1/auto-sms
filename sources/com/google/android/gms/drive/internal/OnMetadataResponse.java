package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class OnMetadataResponse implements SafeParcelable {
    public static final Parcelable.Creator<OnMetadataResponse> CREATOR = new zzbe();
    final int mVersionCode;
    final MetadataBundle zzaqw;

    OnMetadataResponse(int i, MetadataBundle metadataBundle) {
        this.mVersionCode = i;
        this.zzaqw = metadataBundle;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzbe.zza(this, parcel, i);
    }

    public MetadataBundle zztw() {
        return this.zzaqw;
    }
}
