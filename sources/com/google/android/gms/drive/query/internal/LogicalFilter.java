package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.drive.query.Filter;
import java.util.ArrayList;
import java.util.List;

public class LogicalFilter extends AbstractFilter {
    public static final Parcelable.Creator<LogicalFilter> CREATOR = new zzk();
    final int mVersionCode;
    private List<Filter> zzaua;
    final Operator zzaug;
    final List<FilterHolder> zzauv;

    LogicalFilter(int i, Operator operator, List<FilterHolder> list) {
        this.mVersionCode = i;
        this.zzaug = operator;
        this.zzauv = list;
    }

    public LogicalFilter(Operator operator, Filter filter, Filter... filterArr) {
        this.mVersionCode = 1;
        this.zzaug = operator;
        ArrayList arrayList = new ArrayList(filterArr.length + 1);
        this.zzauv = arrayList;
        arrayList.add(new FilterHolder(filter));
        ArrayList arrayList2 = new ArrayList(filterArr.length + 1);
        this.zzaua = arrayList2;
        arrayList2.add(filter);
        for (Filter filter2 : filterArr) {
            this.zzauv.add(new FilterHolder(filter2));
            this.zzaua.add(filter2);
        }
    }

    public LogicalFilter(Operator operator, Iterable<Filter> iterable) {
        this.mVersionCode = 1;
        this.zzaug = operator;
        this.zzaua = new ArrayList();
        this.zzauv = new ArrayList();
        for (Filter next : iterable) {
            this.zzaua.add(next);
            this.zzauv.add(new FilterHolder(next));
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzk.zza(this, parcel, i);
    }

    public <T> T zza(zzf<T> zzf) {
        ArrayList arrayList = new ArrayList();
        for (FilterHolder filter : this.zzauv) {
            arrayList.add(filter.getFilter().zza(zzf));
        }
        return zzf.zzb(this.zzaug, (List<T>) arrayList);
    }
}
