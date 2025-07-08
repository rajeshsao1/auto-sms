package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Locale;

public class FieldWithSortOrder implements SafeParcelable {
    public static final zzc CREATOR = new zzc();
    final int mVersionCode;
    final String zzasF;
    final boolean zzauj;

    FieldWithSortOrder(int i, String str, boolean z) {
        this.mVersionCode = i;
        this.zzasF = str;
        this.zzauj = z;
    }

    public FieldWithSortOrder(String str, boolean z) {
        this(1, str, z);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        Locale locale = Locale.US;
        Object[] objArr = new Object[2];
        objArr[0] = this.zzasF;
        objArr[1] = this.zzauj ? "ASC" : "DESC";
        return String.format(locale, "FieldWithSortOrder[%s %s]", objArr);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }
}
