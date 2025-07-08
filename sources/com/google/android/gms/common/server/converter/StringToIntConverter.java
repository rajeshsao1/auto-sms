package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class StringToIntConverter implements SafeParcelable, FastJsonResponse.zza<String, Integer> {
    public static final zzb CREATOR = new zzb();
    private final int mVersionCode;
    private final HashMap<String, Integer> zzamG;
    private final HashMap<Integer, String> zzamH;
    private final ArrayList<Entry> zzamI;

    public static final class Entry implements SafeParcelable {
        public static final zzc CREATOR = new zzc();
        final int versionCode;
        final String zzamJ;
        final int zzamK;

        Entry(int i, String str, int i2) {
            this.versionCode = i;
            this.zzamJ = str;
            this.zzamK = i2;
        }

        Entry(String str, int i) {
            this.versionCode = 1;
            this.zzamJ = str;
            this.zzamK = i;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzc.zza(this, parcel, i);
        }
    }

    public StringToIntConverter() {
        this.mVersionCode = 1;
        this.zzamG = new HashMap<>();
        this.zzamH = new HashMap<>();
        this.zzamI = null;
    }

    StringToIntConverter(int i, ArrayList<Entry> arrayList) {
        this.mVersionCode = i;
        this.zzamG = new HashMap<>();
        this.zzamH = new HashMap<>();
        this.zzamI = null;
        zzd(arrayList);
    }

    private void zzd(ArrayList<Entry> arrayList) {
        Iterator<Entry> it = arrayList.iterator();
        while (it.hasNext()) {
            Entry next = it.next();
            zzh(next.zzamJ, next.zzamK);
        }
    }

    public int describeContents() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }

    /* renamed from: zzb */
    public String convertBack(Integer num) {
        String str = this.zzamH.get(num);
        return (str != null || !this.zzamG.containsKey("gms_unknown")) ? str : "gms_unknown";
    }

    public StringToIntConverter zzh(String str, int i) {
        this.zzamG.put(str, Integer.valueOf(i));
        this.zzamH.put(Integer.valueOf(i), str);
        return this;
    }

    /* access modifiers changed from: package-private */
    public ArrayList<Entry> zzri() {
        ArrayList<Entry> arrayList = new ArrayList<>();
        for (String next : this.zzamG.keySet()) {
            arrayList.add(new Entry(next, this.zzamG.get(next).intValue()));
        }
        return arrayList;
    }

    public int zzrj() {
        return 7;
    }

    public int zzrk() {
        return 0;
    }
}
