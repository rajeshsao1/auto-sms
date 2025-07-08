package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ConnectionEvent extends zzf implements SafeParcelable {
    public static final Parcelable.Creator<ConnectionEvent> CREATOR = new zza();
    final int mVersionCode;
    private final long zzane;
    private int zzanf;
    private final String zzang;
    private final String zzanh;
    private final String zzani;
    private final String zzanj;
    private final String zzank;
    private final String zzanl;
    private final long zzanm;
    private final long zzann;
    private long zzano;

    ConnectionEvent(int i, long j, int i2, String str, String str2, String str3, String str4, String str5, String str6, long j2, long j3) {
        this.mVersionCode = i;
        this.zzane = j;
        this.zzanf = i2;
        this.zzang = str;
        this.zzanh = str2;
        this.zzani = str3;
        this.zzanj = str4;
        this.zzano = -1;
        this.zzank = str5;
        this.zzanl = str6;
        this.zzanm = j2;
        this.zzann = j3;
    }

    public ConnectionEvent(long j, int i, String str, String str2, String str3, String str4, String str5, String str6, long j2, long j3) {
        this(1, j, i, str, str2, str3, str4, str5, str6, j2, j3);
    }

    public int describeContents() {
        return 0;
    }

    public int getEventType() {
        return this.zzanf;
    }

    public long getTimeMillis() {
        return this.zzane;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    public String zzrF() {
        return this.zzang;
    }

    public String zzrG() {
        return this.zzanh;
    }

    public String zzrH() {
        return this.zzani;
    }

    public String zzrI() {
        return this.zzanj;
    }

    public String zzrJ() {
        return this.zzank;
    }

    public String zzrK() {
        return this.zzanl;
    }

    public long zzrL() {
        return this.zzano;
    }

    public long zzrM() {
        return this.zzann;
    }

    public long zzrN() {
        return this.zzanm;
    }

    public String zzrO() {
        StringBuilder sb = new StringBuilder();
        sb.append("\t");
        sb.append(zzrF());
        sb.append("/");
        sb.append(zzrG());
        sb.append("\t");
        sb.append(zzrH());
        sb.append("/");
        sb.append(zzrI());
        sb.append("\t");
        String str = this.zzank;
        if (str == null) {
            str = "";
        }
        sb.append(str);
        sb.append("\t");
        sb.append(zzrM());
        return sb.toString();
    }
}
