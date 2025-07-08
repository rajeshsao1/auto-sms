package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class FieldOnlyFilter extends AbstractFilter {
    public static final Parcelable.Creator<FieldOnlyFilter> CREATOR = new zzb();
    final int mVersionCode;
    final MetadataBundle zzauh;
    private final MetadataField<?> zzaui;

    FieldOnlyFilter(int i, MetadataBundle metadataBundle) {
        this.mVersionCode = i;
        this.zzauh = metadataBundle;
        this.zzaui = zze.zza(metadataBundle);
    }

    public FieldOnlyFilter(SearchableMetadataField<?> searchableMetadataField) {
        this(1, MetadataBundle.zzb(searchableMetadataField, null));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }

    public <T> T zza(zzf<T> zzf) {
        return zzf.zze(this.zzaui);
    }
}
