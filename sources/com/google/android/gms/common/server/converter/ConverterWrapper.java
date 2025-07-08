package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;

public class ConverterWrapper implements SafeParcelable {
    public static final zza CREATOR = new zza();
    private final int mVersionCode;
    private final StringToIntConverter zzamF;

    ConverterWrapper(int i, StringToIntConverter stringToIntConverter) {
        this.mVersionCode = i;
        this.zzamF = stringToIntConverter;
    }

    private ConverterWrapper(StringToIntConverter stringToIntConverter) {
        this.mVersionCode = 1;
        this.zzamF = stringToIntConverter;
    }

    public static ConverterWrapper zza(FastJsonResponse.zza<?, ?> zza) {
        if (zza instanceof StringToIntConverter) {
            return new ConverterWrapper((StringToIntConverter) zza);
        }
        throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
    }

    public int describeContents() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    /* access modifiers changed from: package-private */
    public StringToIntConverter zzrg() {
        return this.zzamF;
    }

    public FastJsonResponse.zza<?, ?> zzrh() {
        StringToIntConverter stringToIntConverter = this.zzamF;
        if (stringToIntConverter != null) {
            return stringToIntConverter;
        }
        throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
    }
}
