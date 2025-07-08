package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class ComparisonFilter<T> extends AbstractFilter {
    public static final zza CREATOR = new zza();
    final int mVersionCode;
    final Operator zzaug;
    final MetadataBundle zzauh;
    final MetadataField<T> zzaui;

    ComparisonFilter(int i, Operator operator, MetadataBundle metadataBundle) {
        this.mVersionCode = i;
        this.zzaug = operator;
        this.zzauh = metadataBundle;
        this.zzaui = zze.zza(metadataBundle);
    }

    public ComparisonFilter(Operator operator, SearchableMetadataField<T> searchableMetadataField, T t) {
        this(1, operator, MetadataBundle.zzb(searchableMetadataField, t));
    }

    public int describeContents() {
        return 0;
    }

    public T getValue() {
        return this.zzauh.zza(this.zzaui);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    public <F> F zza(zzf<F> zzf) {
        return zzf.zzb(this.zzaug, this.zzaui, getValue());
    }
}
