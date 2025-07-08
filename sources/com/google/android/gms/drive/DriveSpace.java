package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmr;
import java.util.Set;
import java.util.regex.Pattern;

public class DriveSpace implements SafeParcelable {
    public static final Parcelable.Creator<DriveSpace> CREATOR = new zzg();
    public static final DriveSpace zzaoP;
    public static final DriveSpace zzaoQ;
    public static final DriveSpace zzaoR;
    public static final Set<DriveSpace> zzaoS;
    public static final String zzaoT;
    private static final Pattern zzaoU = Pattern.compile("[A-Z0-9_]*");
    private final String mName;
    final int mVersionCode;

    static {
        DriveSpace driveSpace = new DriveSpace("DRIVE");
        zzaoP = driveSpace;
        DriveSpace driveSpace2 = new DriveSpace("APP_DATA_FOLDER");
        zzaoQ = driveSpace2;
        DriveSpace driveSpace3 = new DriveSpace("PHOTOS");
        zzaoR = driveSpace3;
        Set<DriveSpace> zza = zzmr.zza(driveSpace, driveSpace2, driveSpace3);
        zzaoS = zza;
        zzaoT = TextUtils.join(",", zza.toArray());
    }

    DriveSpace(int i, String str) {
        this.mVersionCode = i;
        this.mName = (String) zzx.zzz(str);
    }

    private DriveSpace(String str) {
        this(1, str);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != DriveSpace.class) {
            return false;
        }
        return this.mName.equals(((DriveSpace) obj).mName);
    }

    public String getName() {
        return this.mName;
    }

    public int hashCode() {
        return this.mName.hashCode() ^ 1247068382;
    }

    public String toString() {
        return this.mName;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzg.zza(this, parcel, i);
    }
}
