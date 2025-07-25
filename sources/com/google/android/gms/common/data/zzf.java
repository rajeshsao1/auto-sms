package com.google.android.gms.common.data;

import java.util.ArrayList;

public abstract class zzf<T> extends AbstractDataBuffer<T> {
    private boolean zzajw = false;
    private ArrayList<Integer> zzajx;

    protected zzf(DataHolder dataHolder) {
        super(dataHolder);
    }

    private void zzqh() {
        synchronized (this) {
            if (!this.zzajw) {
                int count = this.zzahi.getCount();
                ArrayList<Integer> arrayList = new ArrayList<>();
                this.zzajx = arrayList;
                if (count > 0) {
                    arrayList.add(0);
                    String zzqg = zzqg();
                    String zzd = this.zzahi.zzd(zzqg, 0, this.zzahi.zzbH(0));
                    int i = 1;
                    while (i < count) {
                        int zzbH = this.zzahi.zzbH(i);
                        String zzd2 = this.zzahi.zzd(zzqg, i, zzbH);
                        if (zzd2 != null) {
                            if (!zzd2.equals(zzd)) {
                                this.zzajx.add(Integer.valueOf(i));
                                zzd = zzd2;
                            }
                            i++;
                        } else {
                            throw new NullPointerException("Missing value for markerColumn: " + zzqg + ", at row: " + i + ", for window: " + zzbH);
                        }
                    }
                }
                this.zzajw = true;
            }
        }
    }

    public final T get(int i) {
        zzqh();
        return zzk(zzbK(i), zzbL(i));
    }

    public int getCount() {
        zzqh();
        return this.zzajx.size();
    }

    /* access modifiers changed from: package-private */
    public int zzbK(int i) {
        if (i >= 0 && i < this.zzajx.size()) {
            return this.zzajx.get(i).intValue();
        }
        throw new IllegalArgumentException("Position " + i + " is out of bounds for this buffer");
    }

    /* access modifiers changed from: protected */
    public int zzbL(int i) {
        if (i < 0 || i == this.zzajx.size()) {
            return 0;
        }
        int count = (i == this.zzajx.size() - 1 ? this.zzahi.getCount() : this.zzajx.get(i + 1).intValue()) - this.zzajx.get(i).intValue();
        if (count == 1) {
            int zzbK = zzbK(i);
            int zzbH = this.zzahi.zzbH(zzbK);
            String zzqi = zzqi();
            if (zzqi == null || this.zzahi.zzd(zzqi, zzbK, zzbH) != null) {
                return count;
            }
            return 0;
        }
        return count;
    }

    /* access modifiers changed from: protected */
    public abstract T zzk(int i, int i2);

    /* access modifiers changed from: protected */
    public abstract String zzqg();

    /* access modifiers changed from: protected */
    public String zzqi() {
        return null;
    }
}
