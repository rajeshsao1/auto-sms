package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ChangesAvailableEvent;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.QueryResultEventParcelable;
import com.google.android.gms.drive.events.TransferProgressEvent;
import com.google.android.gms.drive.events.TransferStateEvent;

public class zzba implements Parcelable.Creator<OnEventResponse> {
    static void zza(OnEventResponse onEventResponse, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, onEventResponse.mVersionCode);
        zzb.zzc(parcel, 2, onEventResponse.zzanf);
        zzb.zza(parcel, 3, (Parcelable) onEventResponse.zzasl, i, false);
        zzb.zza(parcel, 5, (Parcelable) onEventResponse.zzasm, i, false);
        zzb.zza(parcel, 6, (Parcelable) onEventResponse.zzasn, i, false);
        zzb.zza(parcel, 7, (Parcelable) onEventResponse.zzaso, i, false);
        zzb.zza(parcel, 9, (Parcelable) onEventResponse.zzasp, i, false);
        zzb.zza(parcel, 10, (Parcelable) onEventResponse.zzasq, i, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzbD */
    public OnEventResponse createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        ChangeEvent changeEvent = null;
        CompletionEvent completionEvent = null;
        QueryResultEventParcelable queryResultEventParcelable = null;
        ChangesAvailableEvent changesAvailableEvent = null;
        TransferStateEvent transferStateEvent = null;
        TransferProgressEvent transferProgressEvent = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 3:
                    changeEvent = (ChangeEvent) zza.zza(parcel, zzat, ChangeEvent.CREATOR);
                    break;
                case 5:
                    completionEvent = (CompletionEvent) zza.zza(parcel, zzat, CompletionEvent.CREATOR);
                    break;
                case 6:
                    queryResultEventParcelable = (QueryResultEventParcelable) zza.zza(parcel, zzat, QueryResultEventParcelable.CREATOR);
                    break;
                case 7:
                    changesAvailableEvent = (ChangesAvailableEvent) zza.zza(parcel, zzat, ChangesAvailableEvent.CREATOR);
                    break;
                case 9:
                    transferStateEvent = (TransferStateEvent) zza.zza(parcel, zzat, TransferStateEvent.CREATOR);
                    break;
                case 10:
                    transferProgressEvent = (TransferProgressEvent) zza.zza(parcel, zzat, TransferProgressEvent.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new OnEventResponse(i, i2, changeEvent, completionEvent, queryResultEventParcelable, changesAvailableEvent, transferStateEvent, transferProgressEvent);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzdy */
    public OnEventResponse[] newArray(int i) {
        return new OnEventResponse[i];
    }
}
