package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.metadata.CustomPropertyKey;

public class CustomProperty implements SafeParcelable {
    public static final Parcelable.Creator<CustomProperty> CREATOR = new zzc();
    final String mValue;
    final int mVersionCode;
    final CustomPropertyKey zzasN;

    CustomProperty(int i, CustomPropertyKey customPropertyKey, String str) {
        this.mVersionCode = i;
        zzx.zzb(customPropertyKey, (Object) "key");
        this.zzasN = customPropertyKey;
        this.mValue = str;
    }

    public CustomProperty(CustomPropertyKey customPropertyKey, String str) {
        this(1, customPropertyKey, str);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        CustomProperty customProperty = (CustomProperty) obj;
        return zzw.equal(this.zzasN, customProperty.zzasN) && zzw.equal(this.mValue, customProperty.mValue);
    }

    public String getValue() {
        return this.mValue;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzasN, this.mValue);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }

    public CustomPropertyKey zztB() {
        return this.zzasN;
    }
}
