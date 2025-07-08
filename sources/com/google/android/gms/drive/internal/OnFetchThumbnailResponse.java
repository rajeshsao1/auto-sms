package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnFetchThumbnailResponse implements SafeParcelable {
    public static final Parcelable.Creator<OnFetchThumbnailResponse> CREATOR = new zzbb();
    final int mVersionCode;
    final ParcelFileDescriptor zzasr;

    OnFetchThumbnailResponse(int i, ParcelFileDescriptor parcelFileDescriptor) {
        this.mVersionCode = i;
        this.zzasr = parcelFileDescriptor;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzbb.zza(this, parcel, i | 1);
    }
}
