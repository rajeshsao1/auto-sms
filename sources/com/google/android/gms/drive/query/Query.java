package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveSpace;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import com.google.android.gms.drive.query.internal.MatchAllFilter;
import com.google.android.gms.drive.query.internal.Operator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class Query implements SafeParcelable {
    public static final Parcelable.Creator<Query> CREATOR = new zza();
    final int mVersionCode;
    final List<DriveSpace> zzapB;
    private final Set<DriveSpace> zzapC;
    final boolean zzarL;
    final LogicalFilter zzatV;
    final String zzatW;
    final SortOrder zzatX;
    final List<String> zzatY;
    final boolean zzatZ;

    public static class Builder {
        private Set<DriveSpace> zzapC;
        private boolean zzarL;
        private String zzatW;
        private SortOrder zzatX;
        private List<String> zzatY;
        private boolean zzatZ;
        private final List<Filter> zzaua;

        public Builder() {
            this.zzaua = new ArrayList();
        }

        public Builder(Query query) {
            ArrayList arrayList = new ArrayList();
            this.zzaua = arrayList;
            arrayList.add(query.getFilter());
            this.zzatW = query.getPageToken();
            this.zzatX = query.getSortOrder();
            this.zzatY = query.zztJ();
            this.zzatZ = query.zztK();
            this.zzapC = query.zztL();
            this.zzarL = query.zztM();
        }

        public Builder addFilter(Filter filter) {
            if (!(filter instanceof MatchAllFilter)) {
                this.zzaua.add(filter);
            }
            return this;
        }

        public Query build() {
            return new Query(new LogicalFilter(Operator.zzauC, this.zzaua), this.zzatW, this.zzatX, (List) this.zzatY, this.zzatZ, (Set) this.zzapC, this.zzarL);
        }

        @Deprecated
        public Builder setPageToken(String str) {
            this.zzatW = str;
            return this;
        }

        public Builder setSortOrder(SortOrder sortOrder) {
            this.zzatX = sortOrder;
            return this;
        }
    }

    private Query(int i, LogicalFilter logicalFilter, String str, SortOrder sortOrder, List<String> list, boolean z, List<DriveSpace> list2, Set<DriveSpace> set, boolean z2) {
        this.mVersionCode = i;
        this.zzatV = logicalFilter;
        this.zzatW = str;
        this.zzatX = sortOrder;
        this.zzatY = list;
        this.zzatZ = z;
        this.zzapB = list2;
        this.zzapC = set;
        this.zzarL = z2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    Query(int r12, com.google.android.gms.drive.query.internal.LogicalFilter r13, java.lang.String r14, com.google.android.gms.drive.query.SortOrder r15, java.util.List<java.lang.String> r16, boolean r17, java.util.List<com.google.android.gms.drive.DriveSpace> r18, boolean r19) {
        /*
            r11 = this;
            r10 = r18
            if (r10 != 0) goto L_0x0006
            r0 = 0
            goto L_0x000b
        L_0x0006:
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>(r10)
        L_0x000b:
            r8 = r0
            r0 = r11
            r1 = r12
            r2 = r13
            r3 = r14
            r4 = r15
            r5 = r16
            r6 = r17
            r7 = r18
            r9 = r19
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.drive.query.Query.<init>(int, com.google.android.gms.drive.query.internal.LogicalFilter, java.lang.String, com.google.android.gms.drive.query.SortOrder, java.util.List, boolean, java.util.List, boolean):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private Query(com.google.android.gms.drive.query.internal.LogicalFilter r12, java.lang.String r13, com.google.android.gms.drive.query.SortOrder r14, java.util.List<java.lang.String> r15, boolean r16, java.util.Set<com.google.android.gms.drive.DriveSpace> r17, boolean r18) {
        /*
            r11 = this;
            r10 = r17
            if (r10 != 0) goto L_0x0006
            r0 = 0
            goto L_0x000b
        L_0x0006:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r10)
        L_0x000b:
            r7 = r0
            r1 = 1
            r0 = r11
            r2 = r12
            r3 = r13
            r4 = r14
            r5 = r15
            r6 = r16
            r8 = r17
            r9 = r18
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.drive.query.Query.<init>(com.google.android.gms.drive.query.internal.LogicalFilter, java.lang.String, com.google.android.gms.drive.query.SortOrder, java.util.List, boolean, java.util.Set, boolean):void");
    }

    public int describeContents() {
        return 0;
    }

    public Filter getFilter() {
        return this.zzatV;
    }

    @Deprecated
    public String getPageToken() {
        return this.zzatW;
    }

    public SortOrder getSortOrder() {
        return this.zzatX;
    }

    public String toString() {
        return String.format(Locale.US, "Query[%s,%s,PageToken=%s,Spaces=%s]", new Object[]{this.zzatV, this.zzatX, this.zzatW, this.zzapB});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    public List<String> zztJ() {
        return this.zzatY;
    }

    public boolean zztK() {
        return this.zzatZ;
    }

    public Set<DriveSpace> zztL() {
        return this.zzapC;
    }

    public boolean zztM() {
        return this.zzarL;
    }
}
