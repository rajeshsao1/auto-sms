package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class OnResourceIdSetResponse implements SafeParcelable {
    public static final Parcelable.Creator<OnResourceIdSetResponse> CREATOR = new zzbh();
    private final int mVersionCode;
    private final List<String> zzaqi;

    OnResourceIdSetResponse(int i, List<String> list) {
        this.mVersionCode = i;
        this.zzaqi = list;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzbh.zza(this, parcel, i);
    }

    public List<String> zztc() {
        return this.zzaqi;
    }
}
