package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.DriveFolder;

public class zzi {
    private String zzasR;

    private zzi(String str) {
        this.zzasR = str.toLowerCase();
    }

    public static zzi zzdd(String str) {
        zzx.zzac(str == null || !str.isEmpty());
        if (str == null) {
            return null;
        }
        return new zzi(str);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        return this.zzasR.equals(((zzi) obj).zzasR);
    }

    public int hashCode() {
        return this.zzasR.hashCode();
    }

    public boolean isFolder() {
        return this.zzasR.equals(DriveFolder.MIME_TYPE);
    }

    public String toString() {
        return this.zzasR;
    }

    public boolean zztH() {
        return !zztI() && !isFolder();
    }

    public boolean zztI() {
        return this.zzasR.startsWith("application/vnd.google-apps");
    }
}
