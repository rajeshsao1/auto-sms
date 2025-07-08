package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class HasFilter<T> extends AbstractFilter {
    public static final zzi CREATOR = new zzi();
    final int mVersionCode;
    final MetadataBundle zzauh;
    final MetadataField<T> zzaui;

    HasFilter(int i, MetadataBundle metadataBundle) {
        this.mVersionCode = i;
        this.zzauh = metadataBundle;
        this.zzaui = zze.zza(metadataBundle);
    }

    public HasFilter(SearchableMetadataField<T> searchableMetadataField, T t) {
        this(1, MetadataBundle.zzb(searchableMetadataField, t));
    }

    public int describeContents() {
        return 0;
    }

    public T getValue() {
        return this.zzauh.zza(this.zzaui);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzi.zza(this, parcel, i);
    }

    public <F> F zza(zzf<F> zzf) {
        return zzf.zze(this.zzaui, getValue());
    }
}
