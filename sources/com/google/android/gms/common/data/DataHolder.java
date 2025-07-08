package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class DataHolder implements SafeParcelable {
    public static final zze CREATOR = new zze();
    private static final zza zzajq = new zza(new String[0], (String) null) {
    };
    boolean mClosed;
    private final int mVersionCode;
    private final int zzade;
    private final String[] zzaji;
    Bundle zzajj;
    private final CursorWindow[] zzajk;
    private final Bundle zzajl;
    int[] zzajm;
    int zzajn;
    private Object zzajo;
    private boolean zzajp;

    public static class zza {
        /* access modifiers changed from: private */
        public final String[] zzaji;
        /* access modifiers changed from: private */
        public final ArrayList<HashMap<String, Object>> zzajr;
        private final String zzajs;
        private final HashMap<Object, Integer> zzajt;
        private boolean zzaju;
        private String zzajv;

        private zza(String[] strArr, String str) {
            this.zzaji = (String[]) zzx.zzz(strArr);
            this.zzajr = new ArrayList<>();
            this.zzajs = str;
            this.zzajt = new HashMap<>();
            this.zzaju = false;
            this.zzajv = null;
        }
    }

    public static class zzb extends RuntimeException {
        public zzb(String str) {
            super(str);
        }
    }

    DataHolder(int i, String[] strArr, CursorWindow[] cursorWindowArr, int i2, Bundle bundle) {
        this.mClosed = false;
        this.zzajp = true;
        this.mVersionCode = i;
        this.zzaji = strArr;
        this.zzajk = cursorWindowArr;
        this.zzade = i2;
        this.zzajl = bundle;
    }

    private DataHolder(zza zza2, int i, Bundle bundle) {
        this(zza2.zzaji, zza(zza2, -1), i, bundle);
    }

    public DataHolder(String[] strArr, CursorWindow[] cursorWindowArr, int i, Bundle bundle) {
        this.mClosed = false;
        this.zzajp = true;
        this.mVersionCode = 1;
        this.zzaji = (String[]) zzx.zzz(strArr);
        this.zzajk = (CursorWindow[]) zzx.zzz(cursorWindowArr);
        this.zzade = i;
        this.zzajl = bundle;
        zzqd();
    }

    public static DataHolder zza(int i, Bundle bundle) {
        return new DataHolder(zzajq, i, bundle);
    }

    private static CursorWindow[] zza(zza zza2, int i) {
        long j;
        if (zza2.zzaji.length == 0) {
            return new CursorWindow[0];
        }
        List zzb2 = (i < 0 || i >= zza2.zzajr.size()) ? zza2.zzajr : zza2.zzajr.subList(0, i);
        int size = zzb2.size();
        CursorWindow cursorWindow = new CursorWindow(false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(cursorWindow);
        cursorWindow.setNumColumns(zza2.zzaji.length);
        int i2 = 0;
        boolean z = false;
        while (i2 < size) {
            try {
                if (!cursorWindow.allocRow()) {
                    Log.d("DataHolder", "Allocating additional cursor window for large data set (row " + i2 + ")");
                    cursorWindow = new CursorWindow(false);
                    cursorWindow.setStartPosition(i2);
                    cursorWindow.setNumColumns(zza2.zzaji.length);
                    arrayList.add(cursorWindow);
                    if (!cursorWindow.allocRow()) {
                        Log.e("DataHolder", "Unable to allocate row to hold data.");
                        arrayList.remove(cursorWindow);
                        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
                    }
                }
                Map map = (Map) zzb2.get(i2);
                boolean z2 = true;
                for (int i3 = 0; i3 < zza2.zzaji.length && z2; i3++) {
                    String str = zza2.zzaji[i3];
                    Object obj = map.get(str);
                    if (obj == null) {
                        z2 = cursorWindow.putNull(i2, i3);
                    } else if (obj instanceof String) {
                        z2 = cursorWindow.putString((String) obj, i2, i3);
                    } else {
                        if (obj instanceof Long) {
                            j = ((Long) obj).longValue();
                        } else if (obj instanceof Integer) {
                            z2 = cursorWindow.putLong((long) ((Integer) obj).intValue(), i2, i3);
                        } else if (obj instanceof Boolean) {
                            j = ((Boolean) obj).booleanValue() ? 1 : 0;
                        } else if (obj instanceof byte[]) {
                            z2 = cursorWindow.putBlob((byte[]) obj, i2, i3);
                        } else if (obj instanceof Double) {
                            z2 = cursorWindow.putDouble(((Double) obj).doubleValue(), i2, i3);
                        } else if (obj instanceof Float) {
                            z2 = cursorWindow.putDouble((double) ((Float) obj).floatValue(), i2, i3);
                        } else {
                            throw new IllegalArgumentException("Unsupported object for column " + str + ": " + obj);
                        }
                        z2 = cursorWindow.putLong(j, i2, i3);
                    }
                }
                if (z2) {
                    z = false;
                } else if (!z) {
                    Log.d("DataHolder", "Couldn't populate window data for row " + i2 + " - allocating new window.");
                    cursorWindow.freeLastRow();
                    cursorWindow = new CursorWindow(false);
                    cursorWindow.setStartPosition(i2);
                    cursorWindow.setNumColumns(zza2.zzaji.length);
                    arrayList.add(cursorWindow);
                    i2--;
                    z = true;
                } else {
                    throw new zzb("Could not add the value to a new CursorWindow. The size of value may be larger than what a CursorWindow can handle.");
                }
                i2++;
            } catch (RuntimeException e) {
                int size2 = arrayList.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    ((CursorWindow) arrayList.get(i4)).close();
                }
                throw e;
            }
        }
        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
    }

    public static DataHolder zzbI(int i) {
        return zza(i, (Bundle) null);
    }

    private void zzg(String str, int i) {
        Bundle bundle = this.zzajj;
        if (bundle == null || !bundle.containsKey(str)) {
            throw new IllegalArgumentException("No such column: " + str);
        } else if (isClosed()) {
            throw new IllegalArgumentException("Buffer is closed.");
        } else if (i < 0 || i >= this.zzajn) {
            throw new CursorIndexOutOfBoundsException(i, this.zzajn);
        }
    }

    public void close() {
        synchronized (this) {
            if (!this.mClosed) {
                this.mClosed = true;
                int i = 0;
                while (true) {
                    CursorWindow[] cursorWindowArr = this.zzajk;
                    if (i >= cursorWindowArr.length) {
                        break;
                    }
                    cursorWindowArr[i].close();
                    i++;
                }
            }
        }
    }

    public int describeContents() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        String str;
        try {
            if (this.zzajp && this.zzajk.length > 0 && !isClosed()) {
                Object obj = this.zzajo;
                if (obj == null) {
                    str = "internal object: " + toString();
                } else {
                    str = obj.toString();
                }
                Log.e("DataBuffer", "Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (" + str + ")");
                close();
            }
        } finally {
            super.finalize();
        }
    }

    public int getCount() {
        return this.zzajn;
    }

    public int getStatusCode() {
        return this.zzade;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean isClosed() {
        boolean z;
        synchronized (this) {
            z = this.mClosed;
        }
        return z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zze.zza(this, parcel, i);
    }

    public void zza(String str, int i, int i2, CharArrayBuffer charArrayBuffer) {
        zzg(str, i);
        this.zzajk[i2].copyStringToBuffer(i, this.zzajj.getInt(str), charArrayBuffer);
    }

    public long zzb(String str, int i, int i2) {
        zzg(str, i);
        return this.zzajk[i2].getLong(i, this.zzajj.getInt(str));
    }

    public int zzbH(int i) {
        int[] iArr;
        int i2 = 0;
        zzx.zzab(i >= 0 && i < this.zzajn);
        while (true) {
            iArr = this.zzajm;
            if (i2 >= iArr.length) {
                break;
            } else if (i < iArr[i2]) {
                i2--;
                break;
            } else {
                i2++;
            }
        }
        return i2 == iArr.length ? i2 - 1 : i2;
    }

    public int zzc(String str, int i, int i2) {
        zzg(str, i);
        return this.zzajk[i2].getInt(i, this.zzajj.getInt(str));
    }

    public boolean zzcz(String str) {
        return this.zzajj.containsKey(str);
    }

    public String zzd(String str, int i, int i2) {
        zzg(str, i);
        return this.zzajk[i2].getString(i, this.zzajj.getInt(str));
    }

    public boolean zze(String str, int i, int i2) {
        zzg(str, i);
        return Long.valueOf(this.zzajk[i2].getLong(i, this.zzajj.getInt(str))).longValue() == 1;
    }

    public float zzf(String str, int i, int i2) {
        zzg(str, i);
        return this.zzajk[i2].getFloat(i, this.zzajj.getInt(str));
    }

    public byte[] zzg(String str, int i, int i2) {
        zzg(str, i);
        return this.zzajk[i2].getBlob(i, this.zzajj.getInt(str));
    }

    public Uri zzh(String str, int i, int i2) {
        String zzd = zzd(str, i, i2);
        if (zzd == null) {
            return null;
        }
        return Uri.parse(zzd);
    }

    public boolean zzi(String str, int i, int i2) {
        zzg(str, i);
        return this.zzajk[i2].isNull(i, this.zzajj.getInt(str));
    }

    public Bundle zzpZ() {
        return this.zzajl;
    }

    public void zzqd() {
        this.zzajj = new Bundle();
        int i = 0;
        int i2 = 0;
        while (true) {
            String[] strArr = this.zzaji;
            if (i2 >= strArr.length) {
                break;
            }
            this.zzajj.putInt(strArr[i2], i2);
            i2++;
        }
        this.zzajm = new int[this.zzajk.length];
        int i3 = 0;
        while (true) {
            CursorWindow[] cursorWindowArr = this.zzajk;
            if (i < cursorWindowArr.length) {
                this.zzajm[i] = i3;
                i3 += this.zzajk[i].getNumRows() - (i3 - cursorWindowArr[i].getStartPosition());
                i++;
            } else {
                this.zzajn = i3;
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public String[] zzqe() {
        return this.zzaji;
    }

    /* access modifiers changed from: package-private */
    public CursorWindow[] zzqf() {
        return this.zzajk;
    }

    public void zzu(Object obj) {
        this.zzajo = obj;
    }
}
