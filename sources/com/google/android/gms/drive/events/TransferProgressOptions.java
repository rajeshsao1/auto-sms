package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Locale;

public final class TransferProgressOptions implements SafeParcelable {
    public static final Parcelable.Creator<TransferProgressOptions> CREATOR = new zzo();
    final int mVersionCode;
    final int zzapT;

    TransferProgressOptions(int i, int i2) {
        this.mVersionCode = i;
        this.zzapT = i2;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return zzw.equal(Integer.valueOf(this.zzapT), Integer.valueOf(((TransferProgressOptions) obj).zzapT));
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.zzapT));
    }

    public String toString() {
        return String.format(Locale.US, "TransferProgressOptions[type=%d]", new Object[]{Integer.valueOf(this.zzapT)});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzo.zza(this, parcel, i);
    }
}
