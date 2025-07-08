package com.google.android.gms.drive.query;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.SearchableOrderedMetadataField;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.query.internal.ComparisonFilter;
import com.google.android.gms.drive.query.internal.FieldOnlyFilter;
import com.google.android.gms.drive.query.internal.HasFilter;
import com.google.android.gms.drive.query.internal.InFilter;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import com.google.android.gms.drive.query.internal.NotFilter;
import com.google.android.gms.drive.query.internal.Operator;
import com.google.android.gms.drive.query.internal.OwnedByMeFilter;

public class Filters {
    public static Filter and(Filter filter, Filter... filterArr) {
        return new LogicalFilter(Operator.zzauC, filter, filterArr);
    }

    public static Filter and(Iterable<Filter> iterable) {
        return new LogicalFilter(Operator.zzauC, iterable);
    }

    public static Filter contains(SearchableMetadataField<String> searchableMetadataField, String str) {
        return new ComparisonFilter(Operator.zzauF, searchableMetadataField, str);
    }

    public static Filter eq(CustomPropertyKey customPropertyKey, String str) {
        zzx.zzb(str != null, (Object) "Custom property value may not be null.");
        return new HasFilter(SearchableField.zzauc, new AppVisibleCustomProperties.zza().zza(customPropertyKey, str).zztA());
    }

    public static <T> Filter eq(SearchableMetadataField<T> searchableMetadataField, T t) {
        return new ComparisonFilter(Operator.zzaux, searchableMetadataField, t);
    }

    public static <T extends Comparable<T>> Filter greaterThan(SearchableOrderedMetadataField<T> searchableOrderedMetadataField, T t) {
        return new ComparisonFilter(Operator.zzauA, searchableOrderedMetadataField, t);
    }

    public static <T extends Comparable<T>> Filter greaterThanEquals(SearchableOrderedMetadataField<T> searchableOrderedMetadataField, T t) {
        return new ComparisonFilter(Operator.zzauB, searchableOrderedMetadataField, t);
    }

    public static <T> Filter in(SearchableCollectionMetadataField<T> searchableCollectionMetadataField, T t) {
        return new InFilter(searchableCollectionMetadataField, t);
    }

    public static <T extends Comparable<T>> Filter lessThan(SearchableOrderedMetadataField<T> searchableOrderedMetadataField, T t) {
        return new ComparisonFilter(Operator.zzauy, searchableOrderedMetadataField, t);
    }

    public static <T extends Comparable<T>> Filter lessThanEquals(SearchableOrderedMetadataField<T> searchableOrderedMetadataField, T t) {
        return new ComparisonFilter(Operator.zzauz, searchableOrderedMetadataField, t);
    }

    public static Filter not(Filter filter) {
        return new NotFilter(filter);
    }

    public static Filter openedByMe() {
        return new FieldOnlyFilter(SearchableField.LAST_VIEWED_BY_ME);
    }

    public static Filter or(Filter filter, Filter... filterArr) {
        return new LogicalFilter(Operator.zzauD, filter, filterArr);
    }

    public static Filter or(Iterable<Filter> iterable) {
        return new LogicalFilter(Operator.zzauD, iterable);
    }

    public static Filter ownedByMe() {
        return new OwnedByMeFilter();
    }

    public static Filter sharedWithMe() {
        return new FieldOnlyFilter(SearchableField.zzaub);
    }
}
