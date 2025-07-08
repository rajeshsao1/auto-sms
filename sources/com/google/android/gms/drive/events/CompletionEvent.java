package com.google.android.gms.drive.events;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.internal.zzap;
import com.google.android.gms.drive.internal.zzz;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.zzna;
import com.google.android.gms.internal.zznm;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class CompletionEvent implements SafeParcelable, ResourceEvent {
    public static final Parcelable.Creator<CompletionEvent> CREATOR = new zze();
    public static final int STATUS_CANCELED = 3;
    public static final int STATUS_CONFLICT = 2;
    public static final int STATUS_FAILURE = 1;
    public static final int STATUS_SUCCESS = 0;
    final int mVersionCode;
    final int zzBc;
    final String zzVa;
    final DriveId zzaoz;
    final ParcelFileDescriptor zzapD;
    final ParcelFileDescriptor zzapE;
    final MetadataBundle zzapF;
    final List<String> zzapG;
    final IBinder zzapH;
    private boolean zzapI = false;
    private boolean zzapJ = false;
    private boolean zzapK = false;

    CompletionEvent(int i, DriveId driveId, String str, ParcelFileDescriptor parcelFileDescriptor, ParcelFileDescriptor parcelFileDescriptor2, MetadataBundle metadataBundle, List<String> list, int i2, IBinder iBinder) {
        this.mVersionCode = i;
        this.zzaoz = driveId;
        this.zzVa = str;
        this.zzapD = parcelFileDescriptor;
        this.zzapE = parcelFileDescriptor2;
        this.zzapF = metadataBundle;
        this.zzapG = list;
        this.zzBc = i2;
        this.zzapH = iBinder;
    }

    private void zzsU() {
        if (this.zzapK) {
            throw new IllegalStateException("Event has already been dismissed or snoozed.");
        }
    }

    private void zzv(boolean z) {
        zzsU();
        this.zzapK = true;
        zzna.zza(this.zzapD);
        zzna.zza(this.zzapE);
        MetadataBundle metadataBundle = this.zzapF;
        if (metadataBundle != null && metadataBundle.zzc(zznm.zzatz)) {
            ((BitmapTeleporter) this.zzapF.zza(zznm.zzatz)).release();
        }
        IBinder iBinder = this.zzapH;
        String str = "snooze";
        if (iBinder == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("No callback on ");
            if (!z) {
                str = "dismiss";
            }
            sb.append(str);
            zzz.zzA("CompletionEvent", sb.toString());
            return;
        }
        try {
            zzap.zza.zzbd(iBinder).zzv(z);
        } catch (RemoteException e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("RemoteException on ");
            if (!z) {
                str = "dismiss";
            }
            sb2.append(str);
            sb2.append(": ");
            sb2.append(e);
            zzz.zzA("CompletionEvent", sb2.toString());
        }
    }

    public int describeContents() {
        return 0;
    }

    public void dismiss() {
        zzv(false);
    }

    public String getAccountName() {
        zzsU();
        return this.zzVa;
    }

    public InputStream getBaseContentsInputStream() {
        zzsU();
        if (this.zzapD == null) {
            return null;
        }
        if (!this.zzapI) {
            this.zzapI = true;
            return new FileInputStream(this.zzapD.getFileDescriptor());
        }
        throw new IllegalStateException("getBaseInputStream() can only be called once per CompletionEvent instance.");
    }

    public DriveId getDriveId() {
        zzsU();
        return this.zzaoz;
    }

    public InputStream getModifiedContentsInputStream() {
        zzsU();
        if (this.zzapE == null) {
            return null;
        }
        if (!this.zzapJ) {
            this.zzapJ = true;
            return new FileInputStream(this.zzapE.getFileDescriptor());
        }
        throw new IllegalStateException("getModifiedInputStream() can only be called once per CompletionEvent instance.");
    }

    public MetadataChangeSet getModifiedMetadataChangeSet() {
        zzsU();
        if (this.zzapF != null) {
            return new MetadataChangeSet(this.zzapF);
        }
        return null;
    }

    public int getStatus() {
        zzsU();
        return this.zzBc;
    }

    public List<String> getTrackingTags() {
        zzsU();
        return new ArrayList(this.zzapG);
    }

    public int getType() {
        return 2;
    }

    public void snooze() {
        zzv(true);
    }

    public String toString() {
        String str;
        if (this.zzapG == null) {
            str = "<null>";
        } else {
            str = "'" + TextUtils.join("','", this.zzapG) + "'";
        }
        return String.format(Locale.US, "CompletionEvent [id=%s, status=%s, trackingTag=%s]", new Object[]{this.zzaoz, Integer.valueOf(this.zzBc), str});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zze.zza(this, parcel, i | 1);
    }
}
