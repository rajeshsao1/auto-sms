package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd implements Parcelable.Creator<FilterHolder> {
    static void zza(FilterHolder filterHolder, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, (Parcelable) filterHolder.zzauk, i, false);
        zzb.zzc(parcel, 1000, filterHolder.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) filterHolder.zzaul, i, false);
        zzb.zza(parcel, 3, (Parcelable) filterHolder.zzaum, i, false);
        zzb.zza(parcel, 4, (Parcelable) filterHolder.zzaun, i, false);
        zzb.zza(parcel, 5, (Parcelable) filterHolder.zzauo, i, false);
        zzb.zza(parcel, 6, (Parcelable) filterHolder.zzaup, i, false);
        zzb.zza(parcel, 7, (Parcelable) filterHolder.zzauq, i, false);
        zzb.zza(parcel, 8, (Parcelable) filterHolder.zzaur, i, false);
        zzb.zza(parcel, 9, (Parcelable) filterHolder.zzaus, i, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzco */
    public FilterHolder createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        ComparisonFilter comparisonFilter = null;
        FieldOnlyFilter fieldOnlyFilter = null;
        LogicalFilter logicalFilter = null;
        NotFilter notFilter = null;
        InFilter inFilter = null;
        MatchAllFilter matchAllFilter = null;
        HasFilter hasFilter = null;
        FullTextSearchFilter fullTextSearchFilter = null;
        OwnedByMeFilter ownedByMeFilter = null;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            int zzca = zza.zzca(zzat);
            if (zzca != 1000) {
                switch (zzca) {
                    case 1:
                        comparisonFilter = (ComparisonFilter) zza.zza(parcel, zzat, ComparisonFilter.CREATOR);
                        break;
                    case 2:
                        fieldOnlyFilter = (FieldOnlyFilter) zza.zza(parcel, zzat, FieldOnlyFilter.CREATOR);
                        break;
                    case 3:
                        logicalFilter = (LogicalFilter) zza.zza(parcel, zzat, LogicalFilter.CREATOR);
                        break;
                    case 4:
                        notFilter = (NotFilter) zza.zza(parcel, zzat, NotFilter.CREATOR);
                        break;
                    case 5:
                        inFilter = (InFilter) zza.zza(parcel, zzat, InFilter.CREATOR);
                        break;
                    case 6:
                        matchAllFilter = (MatchAllFilter) zza.zza(parcel, zzat, MatchAllFilter.CREATOR);
                        break;
                    case 7:
                        hasFilter = (HasFilter) zza.zza(parcel, zzat, HasFilter.CREATOR);
                        break;
                    case 8:
                        fullTextSearchFilter = (FullTextSearchFilter) zza.zza(parcel, zzat, FullTextSearchFilter.CREATOR);
                        break;
                    case 9:
                        ownedByMeFilter = (OwnedByMeFilter) zza.zza(parcel, zzat, OwnedByMeFilter.CREATOR);
                        break;
                    default:
                        zza.zzb(parcel, zzat);
                        break;
                }
            } else {
                i = zza.zzg(parcel, zzat);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new FilterHolder(i, comparisonFilter, fieldOnlyFilter, logicalFilter, notFilter, inFilter, matchAllFilter, hasFilter, fullTextSearchFilter, ownedByMeFilter);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzej */
    public FilterHolder[] newArray(int i) {
        return new FilterHolder[i];
    }
}
