package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class CheckResourceIdsExistRequest implements SafeParcelable {
    public static final Parcelable.Creator<CheckResourceIdsExistRequest> CREATOR = new zzg();
    private final int mVersionCode;
    private final List<String> zzaqi;

    CheckResourceIdsExistRequest(int i, List<String> list) {
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
        zzg.zza(this, parcel, i);
    }

    public List<String> zztc() {
        return this.zzaqi;
    }
}
