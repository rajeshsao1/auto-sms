package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class ParcelableEvent implements SafeParcelable {
    public static final Parcelable.Creator<ParcelableEvent> CREATOR = new zzc();
    final int mVersionCode;
    final String zzLq;
    final String zzauL;
    final List<String> zzauR;
    final boolean zzauS;
    final boolean zzauT;
    final boolean zzauU;
    final String zzauV;
    final TextInsertedDetails zzauW;
    final TextDeletedDetails zzauX;
    final ValuesAddedDetails zzauY;
    final ValuesRemovedDetails zzauZ;
    final ValuesSetDetails zzava;
    final ValueChangedDetails zzavb;
    final ReferenceShiftedDetails zzavc;
    final ObjectChangedDetails zzavd;
    final FieldChangedDetails zzave;
    final String zzrG;

    ParcelableEvent(int i, String str, String str2, List<String> list, boolean z, boolean z2, boolean z3, String str3, String str4, TextInsertedDetails textInsertedDetails, TextDeletedDetails textDeletedDetails, ValuesAddedDetails valuesAddedDetails, ValuesRemovedDetails valuesRemovedDetails, ValuesSetDetails valuesSetDetails, ValueChangedDetails valueChangedDetails, ReferenceShiftedDetails referenceShiftedDetails, ObjectChangedDetails objectChangedDetails, FieldChangedDetails fieldChangedDetails) {
        this.mVersionCode = i;
        this.zzLq = str;
        this.zzrG = str2;
        this.zzauR = list;
        this.zzauS = z;
        this.zzauT = z2;
        this.zzauU = z3;
        this.zzauL = str3;
        this.zzauV = str4;
        this.zzauW = textInsertedDetails;
        this.zzauX = textDeletedDetails;
        this.zzauY = valuesAddedDetails;
        this.zzauZ = valuesRemovedDetails;
        this.zzava = valuesSetDetails;
        this.zzavb = valueChangedDetails;
        this.zzavc = referenceShiftedDetails;
        this.zzavd = objectChangedDetails;
        this.zzave = fieldChangedDetails;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }
}
