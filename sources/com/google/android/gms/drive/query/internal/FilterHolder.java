package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.query.Filter;

public class FilterHolder implements SafeParcelable {
    public static final Parcelable.Creator<FilterHolder> CREATOR = new zzd();
    final int mVersionCode;
    private final Filter zzapi;
    final ComparisonFilter<?> zzauk;
    final FieldOnlyFilter zzaul;
    final LogicalFilter zzaum;
    final NotFilter zzaun;
    final InFilter<?> zzauo;
    final MatchAllFilter zzaup;
    final HasFilter zzauq;
    final FullTextSearchFilter zzaur;
    final OwnedByMeFilter zzaus;

    FilterHolder(int i, ComparisonFilter<?> comparisonFilter, FieldOnlyFilter fieldOnlyFilter, LogicalFilter logicalFilter, NotFilter notFilter, InFilter<?> inFilter, MatchAllFilter matchAllFilter, HasFilter<?> hasFilter, FullTextSearchFilter fullTextSearchFilter, OwnedByMeFilter ownedByMeFilter) {
        this.mVersionCode = i;
        this.zzauk = comparisonFilter;
        this.zzaul = fieldOnlyFilter;
        this.zzaum = logicalFilter;
        this.zzaun = notFilter;
        this.zzauo = inFilter;
        this.zzaup = matchAllFilter;
        this.zzauq = hasFilter;
        this.zzaur = fullTextSearchFilter;
        this.zzaus = ownedByMeFilter;
        if (comparisonFilter != null) {
            this.zzapi = comparisonFilter;
        } else if (fieldOnlyFilter != null) {
            this.zzapi = fieldOnlyFilter;
        } else if (logicalFilter != null) {
            this.zzapi = logicalFilter;
        } else if (notFilter != null) {
            this.zzapi = notFilter;
        } else if (inFilter != null) {
            this.zzapi = inFilter;
        } else if (matchAllFilter != null) {
            this.zzapi = matchAllFilter;
        } else if (hasFilter != null) {
            this.zzapi = hasFilter;
        } else if (fullTextSearchFilter != null) {
            this.zzapi = fullTextSearchFilter;
        } else if (ownedByMeFilter != null) {
            this.zzapi = ownedByMeFilter;
        } else {
            throw new IllegalArgumentException("At least one filter must be set.");
        }
    }

    public FilterHolder(Filter filter) {
        zzx.zzb(filter, (Object) "Null filter.");
        this.mVersionCode = 2;
        OwnedByMeFilter ownedByMeFilter = null;
        ComparisonFilter<?> comparisonFilter = filter instanceof ComparisonFilter ? (ComparisonFilter) filter : null;
        this.zzauk = comparisonFilter;
        FieldOnlyFilter fieldOnlyFilter = filter instanceof FieldOnlyFilter ? (FieldOnlyFilter) filter : null;
        this.zzaul = fieldOnlyFilter;
        LogicalFilter logicalFilter = filter instanceof LogicalFilter ? (LogicalFilter) filter : null;
        this.zzaum = logicalFilter;
        NotFilter notFilter = filter instanceof NotFilter ? (NotFilter) filter : null;
        this.zzaun = notFilter;
        InFilter<?> inFilter = filter instanceof InFilter ? (InFilter) filter : null;
        this.zzauo = inFilter;
        MatchAllFilter matchAllFilter = filter instanceof MatchAllFilter ? (MatchAllFilter) filter : null;
        this.zzaup = matchAllFilter;
        HasFilter hasFilter = filter instanceof HasFilter ? (HasFilter) filter : null;
        this.zzauq = hasFilter;
        FullTextSearchFilter fullTextSearchFilter = filter instanceof FullTextSearchFilter ? (FullTextSearchFilter) filter : null;
        this.zzaur = fullTextSearchFilter;
        ownedByMeFilter = filter instanceof OwnedByMeFilter ? (OwnedByMeFilter) filter : ownedByMeFilter;
        this.zzaus = ownedByMeFilter;
        if (comparisonFilter == null && fieldOnlyFilter == null && logicalFilter == null && notFilter == null && inFilter == null && matchAllFilter == null && hasFilter == null && fullTextSearchFilter == null && ownedByMeFilter == null) {
            throw new IllegalArgumentException("Invalid filter type.");
        }
        this.zzapi = filter;
    }

    public int describeContents() {
        return 0;
    }

    public Filter getFilter() {
        return this.zzapi;
    }

    public String toString() {
        return String.format("FilterHolder[%s]", new Object[]{this.zzapi});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzd.zza(this, parcel, i);
    }
}
