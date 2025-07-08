package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class StringListResponse implements SafeParcelable {
    public static final Parcelable.Creator<StringListResponse> CREATOR = new zzbw();
    private final int mVersionCode;
    private final List<String> zzasD;

    StringListResponse(int i, List<String> list) {
        this.mVersionCode = i;
        this.zzasD = list;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzbw.zza(this, parcel, i);
    }

    public List<String> zztx() {
        return this.zzasD;
    }
}
