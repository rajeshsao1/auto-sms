package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.internal.zzab;
import com.google.android.gms.drive.internal.zzat;
import com.google.android.gms.drive.internal.zzau;
import com.google.android.gms.drive.internal.zzw;
import com.google.android.gms.drive.internal.zzy;
import com.google.android.gms.drive.internal.zzz;
import com.google.android.gms.internal.zzst;
import com.google.android.gms.internal.zzsu;

public class DriveId implements SafeParcelable {
    public static final Parcelable.Creator<DriveId> CREATOR = new zze();
    public static final int RESOURCE_TYPE_FILE = 0;
    public static final int RESOURCE_TYPE_FOLDER = 1;
    public static final int RESOURCE_TYPE_UNKNOWN = -1;
    final int mVersionCode;
    final String zzaoL;
    final long zzaoM;
    final int zzaoN;
    private volatile String zzaoO;
    final long zzaou;
    private volatile String zzaow;

    DriveId(int i, String str, long j, long j2, int i2) {
        this.zzaow = null;
        this.zzaoO = null;
        this.mVersionCode = i;
        this.zzaoL = str;
        boolean z = true;
        zzx.zzac(!"".equals(str));
        if (str == null && j == -1) {
            z = false;
        }
        zzx.zzac(z);
        this.zzaoM = j;
        this.zzaou = j2;
        this.zzaoN = i2;
    }

    public DriveId(String str, long j, long j2, int i) {
        this(1, str, j, j2, i);
    }

    public static DriveId decodeFromString(String str) {
        boolean startsWith = str.startsWith("DriveId:");
        zzx.zzb(startsWith, (Object) "Invalid DriveId: " + str);
        return zzl(Base64.decode(str.substring("DriveId:".length()), 10));
    }

    public static DriveId zzcW(String str) {
        zzx.zzz(str);
        return new DriveId(str, -1, -1, -1);
    }

    static DriveId zzl(byte[] bArr) {
        try {
            zzat zzm = zzat.zzm(bArr);
            return new DriveId(zzm.versionCode, "".equals(zzm.zzarY) ? null : zzm.zzarY, zzm.zzarZ, zzm.zzarW, zzm.zzasa);
        } catch (zzst e) {
            throw new IllegalArgumentException();
        }
    }

    private byte[] zzsA() {
        zzau zzau = new zzau();
        zzau.zzarZ = this.zzaoM;
        zzau.zzarW = this.zzaou;
        return zzsu.toByteArray(zzau);
    }

    public DriveFile asDriveFile() {
        if (this.zzaoN != 1) {
            return new zzw(this);
        }
        throw new IllegalStateException("This DriveId corresponds to a folder. Call asDriveFolder instead.");
    }

    public DriveFolder asDriveFolder() {
        if (this.zzaoN != 0) {
            return new zzy(this);
        }
        throw new IllegalStateException("This DriveId corresponds to a file. Call asDriveFile instead.");
    }

    public DriveResource asDriveResource() {
        int i = this.zzaoN;
        return i == 1 ? asDriveFolder() : i == 0 ? asDriveFile() : new zzab(this);
    }

    public int describeContents() {
        return 0;
    }

    public final String encodeToString() {
        if (this.zzaow == null) {
            String encodeToString = Base64.encodeToString(zzsu(), 10);
            this.zzaow = "DriveId:" + encodeToString;
        }
        return this.zzaow;
    }

    public boolean equals(Object obj) {
        String str;
        if (!(obj instanceof DriveId)) {
            return false;
        }
        DriveId driveId = (DriveId) obj;
        if (driveId.zzaou != this.zzaou) {
            return false;
        }
        long j = driveId.zzaoM;
        if (j == -1 && this.zzaoM == -1) {
            return driveId.zzaoL.equals(this.zzaoL);
        }
        String str2 = this.zzaoL;
        if (str2 == null || (str = driveId.zzaoL) == null) {
            return j == this.zzaoM;
        }
        if (j == this.zzaoM) {
            if (str.equals(str2)) {
                return true;
            }
            zzz.zzz("DriveId", "Unexpected unequal resourceId for same DriveId object.");
        }
        return false;
    }

    public String getResourceId() {
        return this.zzaoL;
    }

    public int getResourceType() {
        return this.zzaoN;
    }

    public int hashCode() {
        String str;
        if (this.zzaoM == -1) {
            str = this.zzaoL;
        } else {
            str = String.valueOf(this.zzaou) + String.valueOf(this.zzaoM);
        }
        return str.hashCode();
    }

    public final String toInvariantString() {
        if (this.zzaoO == null) {
            this.zzaoO = Base64.encodeToString(zzsA(), 10);
        }
        return this.zzaoO;
    }

    public String toString() {
        return encodeToString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zze.zza(this, parcel, i);
    }

    /* access modifiers changed from: package-private */
    public final byte[] zzsu() {
        zzat zzat = new zzat();
        zzat.versionCode = this.mVersionCode;
        String str = this.zzaoL;
        if (str == null) {
            str = "";
        }
        zzat.zzarY = str;
        zzat.zzarZ = this.zzaoM;
        zzat.zzarW = this.zzaou;
        zzat.zzasa = this.zzaoN;
        return zzsu.toByteArray(zzat);
    }
}
