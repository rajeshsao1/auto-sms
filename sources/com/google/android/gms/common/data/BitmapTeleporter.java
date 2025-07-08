package com.google.android.gms.common.data;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

public class BitmapTeleporter implements SafeParcelable {
    public static final Parcelable.Creator<BitmapTeleporter> CREATOR = new zza();
    final int mVersionCode;
    ParcelFileDescriptor zzIq;
    final int zzabB;
    private Bitmap zzaiY;
    private boolean zzaiZ;
    private File zzaja;

    BitmapTeleporter(int i, ParcelFileDescriptor parcelFileDescriptor, int i2) {
        this.mVersionCode = i;
        this.zzIq = parcelFileDescriptor;
        this.zzabB = i2;
        this.zzaiY = null;
        this.zzaiZ = false;
    }

    public BitmapTeleporter(Bitmap bitmap) {
        this.mVersionCode = 1;
        this.zzIq = null;
        this.zzabB = 0;
        this.zzaiY = bitmap;
        this.zzaiZ = true;
    }

    private void zza(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e) {
            Log.w("BitmapTeleporter", "Could not close stream", e);
        }
    }

    private FileOutputStream zzqb() {
        File file = this.zzaja;
        if (file != null) {
            try {
                File createTempFile = File.createTempFile("teleporter", ".tmp", file);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
                    this.zzIq = ParcelFileDescriptor.open(createTempFile, 268435456);
                    createTempFile.delete();
                    return fileOutputStream;
                } catch (FileNotFoundException e) {
                    throw new IllegalStateException("Temporary file is somehow already deleted");
                }
            } catch (IOException e2) {
                throw new IllegalStateException("Could not create temporary file", e2);
            }
        } else {
            throw new IllegalStateException("setTempDir() must be called before writing this object to a parcel");
        }
    }

    public int describeContents() {
        return 0;
    }

    public void release() {
        if (!this.zzaiZ) {
            try {
                this.zzIq.close();
            } catch (IOException e) {
                Log.w("BitmapTeleporter", "Could not close PFD", e);
            }
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (this.zzIq == null) {
            Bitmap bitmap = this.zzaiY;
            ByteBuffer allocate = ByteBuffer.allocate(bitmap.getRowBytes() * bitmap.getHeight());
            bitmap.copyPixelsToBuffer(allocate);
            byte[] array = allocate.array();
            DataOutputStream dataOutputStream = new DataOutputStream(zzqb());
            try {
                dataOutputStream.writeInt(array.length);
                dataOutputStream.writeInt(bitmap.getWidth());
                dataOutputStream.writeInt(bitmap.getHeight());
                dataOutputStream.writeUTF(bitmap.getConfig().toString());
                dataOutputStream.write(array);
                zza(dataOutputStream);
            } catch (IOException e) {
                throw new IllegalStateException("Could not write into unlinked file", e);
            } catch (Throwable th) {
                zza(dataOutputStream);
                throw th;
            }
        }
        zza.zza(this, parcel, i | 1);
        this.zzIq = null;
    }

    public void zzc(File file) {
        if (file != null) {
            this.zzaja = file;
            return;
        }
        throw new NullPointerException("Cannot set null temp directory");
    }

    public Bitmap zzqa() {
        if (!this.zzaiZ) {
            DataInputStream dataInputStream = new DataInputStream(new ParcelFileDescriptor.AutoCloseInputStream(this.zzIq));
            try {
                byte[] bArr = new byte[dataInputStream.readInt()];
                int readInt = dataInputStream.readInt();
                int readInt2 = dataInputStream.readInt();
                Bitmap.Config valueOf = Bitmap.Config.valueOf(dataInputStream.readUTF());
                dataInputStream.read(bArr);
                zza(dataInputStream);
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                Bitmap createBitmap = Bitmap.createBitmap(readInt, readInt2, valueOf);
                createBitmap.copyPixelsFromBuffer(wrap);
                this.zzaiY = createBitmap;
                this.zzaiZ = true;
            } catch (IOException e) {
                throw new IllegalStateException("Could not read from parcel file descriptor", e);
            } catch (Throwable th) {
                zza(dataInputStream);
                throw th;
            }
        }
        return this.zzaiY;
    }
}
