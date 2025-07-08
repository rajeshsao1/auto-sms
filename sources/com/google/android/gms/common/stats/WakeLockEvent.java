package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public final class WakeLockEvent extends zzf implements SafeParcelable {
    public static final Parcelable.Creator<WakeLockEvent> CREATOR = new zzh();
    private final long mTimeout;
    final int mVersionCode;
    private final String zzanQ;
    private final int zzanR;
    private final List<String> zzanS;
    private final String zzanT;
    private int zzanU;
    private final String zzanV;
    private final String zzanW;
    private final float zzanX;
    private final long zzane;
    private int zzanf;
    private final long zzanm;
    private long zzano;

    WakeLockEvent(int i, long j, int i2, String str, int i3, List<String> list, String str2, long j2, int i4, String str3, String str4, float f, long j3) {
        this.mVersionCode = i;
        this.zzane = j;
        this.zzanf = i2;
        this.zzanQ = str;
        this.zzanV = str3;
        this.zzanR = i3;
        this.zzano = -1;
        this.zzanS = list;
        this.zzanT = str2;
        this.zzanm = j2;
        this.zzanU = i4;
        this.zzanW = str4;
        this.zzanX = f;
        this.mTimeout = j3;
    }

    public WakeLockEvent(long j, int i, String str, int i2, List<String> list, String str2, long j2, int i3, String str3, String str4, float f, long j3) {
        this(1, j, i, str, i2, list, str2, j2, i3, str3, str4, f, j3);
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
        zzh.zza(this, parcel, i);
    }

    public String zzrK() {
        return this.zzanT;
    }

    public long zzrL() {
        return this.zzano;
    }

    public long zzrN() {
        return this.zzanm;
    }

    public String zzrO() {
        StringBuilder sb = new StringBuilder();
        sb.append("\t");
        sb.append(zzrR());
        sb.append("\t");
        sb.append(zzrT());
        sb.append("\t");
        String str = "";
        sb.append(zzrU() == null ? str : TextUtils.join(",", zzrU()));
        sb.append("\t");
        sb.append(zzrV());
        sb.append("\t");
        sb.append(zzrS() == null ? str : zzrS());
        sb.append("\t");
        if (zzrW() != null) {
            str = zzrW();
        }
        sb.append(str);
        sb.append("\t");
        sb.append(zzrX());
        return sb.toString();
    }

    public String zzrR() {
        return this.zzanQ;
    }

    public String zzrS() {
        return this.zzanV;
    }

    public int zzrT() {
        return this.zzanR;
    }

    public List<String> zzrU() {
        return this.zzanS;
    }

    public int zzrV() {
        return this.zzanU;
    }

    public String zzrW() {
        return this.zzanW;
    }

    public float zzrX() {
        return this.zzanX;
    }

    public long zzrY() {
        return this.mTimeout;
    }
}
