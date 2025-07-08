package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnPinnedDownloadPreferencesResponse implements SafeParcelable {
    public static final Parcelable.Creator<OnPinnedDownloadPreferencesResponse> CREATOR = new zzbf();
    final int mVersionCode;
    final ParcelableTransferPreferences zzasu;

    OnPinnedDownloadPreferencesResponse(int i, ParcelableTransferPreferences parcelableTransferPreferences) {
        this.mVersionCode = i;
        this.zzasu = parcelableTransferPreferences;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzbf.zza(this, parcel, i);
    }
}
