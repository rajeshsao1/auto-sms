package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.drive.query.internal.FieldWithSortOrder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SortOrder implements SafeParcelable {
    public static final Parcelable.Creator<SortOrder> CREATOR = new zzb();
    final int mVersionCode;
    final List<FieldWithSortOrder> zzaud;
    final boolean zzaue;

    public static class Builder {
        private final List<FieldWithSortOrder> zzaud = new ArrayList();
        private boolean zzaue = false;

        public Builder addSortAscending(SortableMetadataField sortableMetadataField) {
            this.zzaud.add(new FieldWithSortOrder(sortableMetadataField.getName(), true));
            return this;
        }

        public Builder addSortDescending(SortableMetadataField sortableMetadataField) {
            this.zzaud.add(new FieldWithSortOrder(sortableMetadataField.getName(), false));
            return this;
        }

        public SortOrder build() {
            return new SortOrder((List) this.zzaud, this.zzaue);
        }
    }

    SortOrder(int i, List<FieldWithSortOrder> list, boolean z) {
        this.mVersionCode = i;
        this.zzaud = list;
        this.zzaue = z;
    }

    private SortOrder(List<FieldWithSortOrder> list, boolean z) {
        this(1, list, z);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format(Locale.US, "SortOrder[%s, %s]", new Object[]{TextUtils.join(",", this.zzaud), Boolean.valueOf(this.zzaue)});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
