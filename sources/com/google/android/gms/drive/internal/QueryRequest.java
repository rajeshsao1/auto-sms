package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.Query;

public class QueryRequest implements SafeParcelable {
    public static final Parcelable.Creator<QueryRequest> CREATOR = new zzbo();
    final int mVersionCode;
    final Query zzasB;

    QueryRequest(int i, Query query) {
        this.mVersionCode = i;
        this.zzasB = query;
    }

    public QueryRequest(Query query) {
        this(1, query);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzbo.zza(this, parcel, i);
    }
}
