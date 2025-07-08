package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzc implements Parcelable.Creator<ParcelableEvent> {
    static void zza(ParcelableEvent parcelableEvent, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, parcelableEvent.mVersionCode);
        zzb.zza(parcel, 2, parcelableEvent.zzLq, false);
        zzb.zza(parcel, 3, parcelableEvent.zzrG, false);
        zzb.zzb(parcel, 4, parcelableEvent.zzauR, false);
        zzb.zza(parcel, 5, parcelableEvent.zzauS);
        zzb.zza(parcel, 6, parcelableEvent.zzauL, false);
        zzb.zza(parcel, 7, parcelableEvent.zzauV, false);
        zzb.zza(parcel, 8, (Parcelable) parcelableEvent.zzauW, i, false);
        zzb.zza(parcel, 9, (Parcelable) parcelableEvent.zzauX, i, false);
        zzb.zza(parcel, 10, (Parcelable) parcelableEvent.zzauY, i, false);
        zzb.zza(parcel, 11, (Parcelable) parcelableEvent.zzauZ, i, false);
        zzb.zza(parcel, 12, (Parcelable) parcelableEvent.zzava, i, false);
        zzb.zza(parcel, 13, (Parcelable) parcelableEvent.zzavb, i, false);
        zzb.zza(parcel, 14, (Parcelable) parcelableEvent.zzavc, i, false);
        zzb.zza(parcel, 15, (Parcelable) parcelableEvent.zzavd, i, false);
        zzb.zza(parcel, 17, parcelableEvent.zzauU);
        zzb.zza(parcel, 16, parcelableEvent.zzauT);
        zzb.zza(parcel, 18, (Parcelable) parcelableEvent.zzave, i, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzcE */
    public ParcelableEvent createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int zzau = zza.zzau(parcel);
        String str = null;
        String str2 = null;
        ArrayList<String> arrayList = null;
        String str3 = null;
        String str4 = null;
        TextInsertedDetails textInsertedDetails = null;
        TextDeletedDetails textDeletedDetails = null;
        ValuesAddedDetails valuesAddedDetails = null;
        ValuesRemovedDetails valuesRemovedDetails = null;
        ValuesSetDetails valuesSetDetails = null;
        ValueChangedDetails valueChangedDetails = null;
        ReferenceShiftedDetails referenceShiftedDetails = null;
        ObjectChangedDetails objectChangedDetails = null;
        FieldChangedDetails fieldChangedDetails = null;
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel2, zzat);
                    break;
                case 2:
                    str = zza.zzp(parcel2, zzat);
                    break;
                case 3:
                    str2 = zza.zzp(parcel2, zzat);
                    break;
                case 4:
                    arrayList = zza.zzD(parcel2, zzat);
                    break;
                case 5:
                    z = zza.zzc(parcel2, zzat);
                    break;
                case 6:
                    str3 = zza.zzp(parcel2, zzat);
                    break;
                case 7:
                    str4 = zza.zzp(parcel2, zzat);
                    break;
                case 8:
                    textInsertedDetails = (TextInsertedDetails) zza.zza(parcel2, zzat, TextInsertedDetails.CREATOR);
                    break;
                case 9:
                    textDeletedDetails = (TextDeletedDetails) zza.zza(parcel2, zzat, TextDeletedDetails.CREATOR);
                    break;
                case 10:
                    valuesAddedDetails = (ValuesAddedDetails) zza.zza(parcel2, zzat, ValuesAddedDetails.CREATOR);
                    break;
                case 11:
                    valuesRemovedDetails = (ValuesRemovedDetails) zza.zza(parcel2, zzat, ValuesRemovedDetails.CREATOR);
                    break;
                case 12:
                    valuesSetDetails = (ValuesSetDetails) zza.zza(parcel2, zzat, ValuesSetDetails.CREATOR);
                    break;
                case 13:
                    valueChangedDetails = (ValueChangedDetails) zza.zza(parcel2, zzat, ValueChangedDetails.CREATOR);
                    break;
                case 14:
                    referenceShiftedDetails = (ReferenceShiftedDetails) zza.zza(parcel2, zzat, ReferenceShiftedDetails.CREATOR);
                    break;
                case 15:
                    objectChangedDetails = (ObjectChangedDetails) zza.zza(parcel2, zzat, ObjectChangedDetails.CREATOR);
                    break;
                case 16:
                    z2 = zza.zzc(parcel2, zzat);
                    break;
                case 17:
                    z3 = zza.zzc(parcel2, zzat);
                    break;
                case 18:
                    fieldChangedDetails = (FieldChangedDetails) zza.zza(parcel2, zzat, FieldChangedDetails.CREATOR);
                    break;
                default:
                    zza.zzb(parcel2, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new ParcelableEvent(i, str, str2, arrayList, z, z2, z3, str3, str4, textInsertedDetails, textDeletedDetails, valuesAddedDetails, valuesRemovedDetails, valuesSetDetails, valueChangedDetails, referenceShiftedDetails, objectChangedDetails, fieldChangedDetails);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel2);
    }

    /* renamed from: zzeA */
    public ParcelableEvent[] newArray(int i) {
        return new ParcelableEvent[i];
    }
}
