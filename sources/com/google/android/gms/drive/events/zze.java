package com.google.android.gms.drive.events;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.ArrayList;

public class zze implements Parcelable.Creator<CompletionEvent> {
    static void zza(CompletionEvent completionEvent, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, completionEvent.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) completionEvent.zzaoz, i, false);
        zzb.zza(parcel, 3, completionEvent.zzVa, false);
        zzb.zza(parcel, 4, (Parcelable) completionEvent.zzapD, i, false);
        zzb.zza(parcel, 5, (Parcelable) completionEvent.zzapE, i, false);
        zzb.zza(parcel, 6, (Parcelable) completionEvent.zzapF, i, false);
        zzb.zzb(parcel, 7, completionEvent.zzapG, false);
        zzb.zzc(parcel, 8, completionEvent.zzBc);
        zzb.zza(parcel, 9, completionEvent.zzapH, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzaS */
    public CompletionEvent createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        DriveId driveId = null;
        String str = null;
        ParcelFileDescriptor parcelFileDescriptor = null;
        ParcelFileDescriptor parcelFileDescriptor2 = null;
        MetadataBundle metadataBundle = null;
        ArrayList<String> arrayList = null;
        IBinder iBinder = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    driveId = (DriveId) zza.zza(parcel, zzat, DriveId.CREATOR);
                    break;
                case 3:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 4:
                    parcelFileDescriptor = (ParcelFileDescriptor) zza.zza(parcel, zzat, ParcelFileDescriptor.CREATOR);
                    break;
                case 5:
                    parcelFileDescriptor2 = (ParcelFileDescriptor) zza.zza(parcel, zzat, ParcelFileDescriptor.CREATOR);
                    break;
                case 6:
                    metadataBundle = (MetadataBundle) zza.zza(parcel, zzat, MetadataBundle.CREATOR);
                    break;
                case 7:
                    arrayList = zza.zzD(parcel, zzat);
                    break;
                case 8:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 9:
                    iBinder = zza.zzq(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new CompletionEvent(i, driveId, str, parcelFileDescriptor, parcelFileDescriptor2, metadataBundle, arrayList, i2, iBinder);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzcH */
    public CompletionEvent[] newArray(int i) {
        return new CompletionEvent[i];
    }
}
