package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.drive.DriveSpace;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public final class ChangesAvailableOptions implements SafeParcelable {
    public static final Parcelable.Creator<ChangesAvailableOptions> CREATOR = new zzd();
    final int mVersionCode;
    final boolean zzapA;
    final List<DriveSpace> zzapB;
    private final Set<DriveSpace> zzapC;
    final int zzapz;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    ChangesAvailableOptions(int i, int i2, boolean z, List<DriveSpace> list) {
        this(i, i2, z, list, list == null ? null : new HashSet(list));
    }

    private ChangesAvailableOptions(int i, int i2, boolean z, List<DriveSpace> list, Set<DriveSpace> set) {
        this.mVersionCode = i;
        this.zzapz = i2;
        this.zzapA = z;
        this.zzapB = list;
        this.zzapC = set;
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
        ChangesAvailableOptions changesAvailableOptions = (ChangesAvailableOptions) obj;
        return zzw.equal(this.zzapC, changesAvailableOptions.zzapC) && this.zzapz == changesAvailableOptions.zzapz && this.zzapA == changesAvailableOptions.zzapA;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzapC, Integer.valueOf(this.zzapz), Boolean.valueOf(this.zzapA));
    }

    public String toString() {
        return String.format(Locale.US, "ChangesAvailableOptions[ChangesSizeLimit=%d, Repeats=%s, Spaces=%s]", new Object[]{Integer.valueOf(this.zzapz), Boolean.valueOf(this.zzapA), this.zzapB});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzd.zza(this, parcel, i);
    }
}
