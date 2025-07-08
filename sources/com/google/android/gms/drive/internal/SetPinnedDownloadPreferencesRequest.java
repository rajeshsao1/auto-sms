package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class SetPinnedDownloadPreferencesRequest implements SafeParcelable {
    public static final Parcelable.Creator<SetPinnedDownloadPreferencesRequest> CREATOR = new zzbs();
    final int mVersionCode;
    final ParcelableTransferPreferences zzasu;

    SetPinnedDownloadPreferencesRequest(int i, ParcelableTransferPreferences parcelableTransferPreferences) {
        this.mVersionCode = i;
        this.zzasu = parcelableTransferPreferences;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzbs.zza(this, parcel, i);
    }
}
