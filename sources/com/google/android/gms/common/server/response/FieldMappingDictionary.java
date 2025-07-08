package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FieldMappingDictionary implements SafeParcelable {
    public static final zzc CREATOR = new zzc();
    private final int mVersionCode;
    private final HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> zzamV;
    private final ArrayList<Entry> zzamW;
    private final String zzamX;

    public static class Entry implements SafeParcelable {
        public static final zzd CREATOR = new zzd();
        final String className;
        final int versionCode;
        final ArrayList<FieldMapPair> zzamY;

        Entry(int i, String str, ArrayList<FieldMapPair> arrayList) {
            this.versionCode = i;
            this.className = str;
            this.zzamY = arrayList;
        }

        Entry(String str, Map<String, FastJsonResponse.Field<?, ?>> map) {
            this.versionCode = 1;
            this.className = str;
            this.zzamY = zzM(map);
        }

        private static ArrayList<FieldMapPair> zzM(Map<String, FastJsonResponse.Field<?, ?>> map) {
            if (map == null) {
                return null;
            }
            ArrayList<FieldMapPair> arrayList = new ArrayList<>();
            for (String next : map.keySet()) {
                arrayList.add(new FieldMapPair(next, map.get(next)));
            }
            return arrayList;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzd.zza(this, parcel, i);
        }

        /* access modifiers changed from: package-private */
        public HashMap<String, FastJsonResponse.Field<?, ?>> zzrC() {
            HashMap<String, FastJsonResponse.Field<?, ?>> hashMap = new HashMap<>();
            int size = this.zzamY.size();
            for (int i = 0; i < size; i++) {
                FieldMapPair fieldMapPair = this.zzamY.get(i);
                hashMap.put(fieldMapPair.key, fieldMapPair.zzamZ);
            }
            return hashMap;
        }
    }

    public static class FieldMapPair implements SafeParcelable {
        public static final zzb CREATOR = new zzb();
        final String key;
        final int versionCode;
        final FastJsonResponse.Field<?, ?> zzamZ;

        FieldMapPair(int i, String str, FastJsonResponse.Field<?, ?> field) {
            this.versionCode = i;
            this.key = str;
            this.zzamZ = field;
        }

        FieldMapPair(String str, FastJsonResponse.Field<?, ?> field) {
            this.versionCode = 1;
            this.key = str;
            this.zzamZ = field;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzb.zza(this, parcel, i);
        }
    }

    FieldMappingDictionary(int i, ArrayList<Entry> arrayList, String str) {
        this.mVersionCode = i;
        this.zzamW = null;
        this.zzamV = zze(arrayList);
        this.zzamX = (String) zzx.zzz(str);
        zzry();
    }

    public FieldMappingDictionary(Class<? extends FastJsonResponse> cls) {
        this.mVersionCode = 1;
        this.zzamW = null;
        this.zzamV = new HashMap<>();
        this.zzamX = cls.getCanonicalName();
    }

    private static HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> zze(ArrayList<Entry> arrayList) {
        HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> hashMap = new HashMap<>();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Entry entry = arrayList.get(i);
            hashMap.put(entry.className, entry.zzrC());
        }
        return hashMap;
    }

    public int describeContents() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String next : this.zzamV.keySet()) {
            sb.append(next);
            sb.append(":\n");
            Map map = this.zzamV.get(next);
            for (String str : map.keySet()) {
                sb.append("  ");
                sb.append(str);
                sb.append(": ");
                sb.append(map.get(str));
            }
        }
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }

    public void zza(Class<? extends FastJsonResponse> cls, Map<String, FastJsonResponse.Field<?, ?>> map) {
        this.zzamV.put(cls.getCanonicalName(), map);
    }

    public boolean zzb(Class<? extends FastJsonResponse> cls) {
        return this.zzamV.containsKey(cls.getCanonicalName());
    }

    public Map<String, FastJsonResponse.Field<?, ?>> zzcR(String str) {
        return this.zzamV.get(str);
    }

    /* access modifiers changed from: package-private */
    public ArrayList<Entry> zzrA() {
        ArrayList<Entry> arrayList = new ArrayList<>();
        for (String next : this.zzamV.keySet()) {
            arrayList.add(new Entry(next, this.zzamV.get(next)));
        }
        return arrayList;
    }

    public String zzrB() {
        return this.zzamX;
    }

    public void zzry() {
        for (String str : this.zzamV.keySet()) {
            Map map = this.zzamV.get(str);
            for (String str2 : map.keySet()) {
                ((FastJsonResponse.Field) map.get(str2)).zza(this);
            }
        }
    }

    public void zzrz() {
        for (String next : this.zzamV.keySet()) {
            Map map = this.zzamV.get(next);
            HashMap hashMap = new HashMap();
            for (String str : map.keySet()) {
                hashMap.put(str, ((FastJsonResponse.Field) map.get(str)).zzro());
            }
            this.zzamV.put(next, hashMap);
        }
    }
}
