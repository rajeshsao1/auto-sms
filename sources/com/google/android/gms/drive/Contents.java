package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Contents implements SafeParcelable {
    public static final Parcelable.Creator<Contents> CREATOR = new zzb();
    final int mVersionCode;
    final ParcelFileDescriptor zzajL;
    final boolean zzaoA;
    final int zzaox;
    final int zzaoy;
    final DriveId zzaoz;
    final String zzsU;

    Contents(int i, ParcelFileDescriptor parcelFileDescriptor, int i2, int i3, DriveId driveId, boolean z, String str) {
        this.mVersionCode = i;
        this.zzajL = parcelFileDescriptor;
        this.zzaox = i2;
        this.zzaoy = i3;
        this.zzaoz = driveId;
        this.zzaoA = z;
        this.zzsU = str;
    }

    public int describeContents() {
        return 0;
    }

    public DriveId getDriveId() {
        return this.zzaoz;
    }

    public InputStream getInputStream() {
        return new FileInputStream(this.zzajL.getFileDescriptor());
    }

    public int getMode() {
        return this.zzaoy;
    }

    public OutputStream getOutputStream() {
        return new FileOutputStream(this.zzajL.getFileDescriptor());
    }

    public ParcelFileDescriptor getParcelFileDescriptor() {
        return this.zzajL;
    }

    public int getRequestId() {
        return this.zzaox;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }

    public boolean zzsv() {
        return this.zzaoA;
    }
}
