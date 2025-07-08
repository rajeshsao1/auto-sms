package com.google.android.gms.playlog.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class LogEvent implements SafeParcelable {
    public static final zzc CREATOR = new zzc();
    public final String tag;
    public final int versionCode;
    public final long zzbdA;
    public final long zzbdB;
    public final byte[] zzbdC;
    public final Bundle zzbdD;

    LogEvent(int i, long j, long j2, String str, byte[] bArr, Bundle bundle) {
        this.versionCode = i;
        this.zzbdA = j;
        this.zzbdB = j2;
        this.tag = str;
        this.zzbdC = bArr;
        this.zzbdD = bundle;
    }

    public LogEvent(long j, long j2, String str, byte[] bArr, String... strArr) {
        this.versionCode = 1;
        this.zzbdA = j;
        this.zzbdB = j2;
        this.tag = str;
        this.zzbdC = bArr;
        this.zzbdD = zzd(strArr);
    }

    private static Bundle zzd(String... strArr) {
        if (strArr == null) {
            return null;
        }
        if (strArr.length % 2 == 0) {
            int length = strArr.length / 2;
            if (length == 0) {
                return null;
            }
            Bundle bundle = new Bundle(length);
            for (int i = 0; i < length; i++) {
                int i2 = i * 2;
                bundle.putString(strArr[i2], strArr[i2 + 1]);
            }
            return bundle;
        }
        throw new IllegalArgumentException("extras must have an even number of elements");
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("tag=");
        sb.append(this.tag);
        sb.append(",");
        sb.append("eventTime=");
        sb.append(this.zzbdA);
        sb.append(",");
        sb.append("eventUptime=");
        sb.append(this.zzbdB);
        sb.append(",");
        Bundle bundle = this.zzbdD;
        if (bundle != null && !bundle.isEmpty()) {
            sb.append("keyValues=");
            for (String str : this.zzbdD.keySet()) {
                sb.append("(");
                sb.append(str);
                sb.append(",");
                sb.append(this.zzbdD.getString(str));
                sb.append(")");
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }
}
