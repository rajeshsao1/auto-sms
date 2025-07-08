package com.google.android.gms.internal;

import com.google.android.gms.internal.zzso;
import java.io.IOException;

public abstract class zzso<M extends zzso<M>> extends zzsu {
    protected zzsq zzbuj;

    public void writeTo(zzsn zzsn) throws IOException {
        if (this.zzbuj != null) {
            for (int i = 0; i < this.zzbuj.size(); i++) {
                this.zzbuj.zzmG(i).writeTo(zzsn);
            }
        }
    }

    /* renamed from: zzJp */
    public M clone() throws CloneNotSupportedException {
        M m = (zzso) super.clone();
        zzss.zza(this, (zzso) m);
        return m;
    }

    public final <T> T zza(zzsp<M, T> zzsp) {
        zzsr zzmF;
        zzsq zzsq = this.zzbuj;
        if (zzsq == null || (zzmF = zzsq.zzmF(zzsx.zzmJ(zzsp.tag))) == null) {
            return null;
        }
        return zzmF.zzb(zzsp);
    }

    /* access modifiers changed from: protected */
    public final boolean zza(zzsm zzsm, int i) throws IOException {
        int position = zzsm.getPosition();
        if (!zzsm.zzmo(i)) {
            return false;
        }
        int zzmJ = zzsx.zzmJ(i);
        zzsw zzsw = new zzsw(i, zzsm.zzz(position, zzsm.getPosition() - position));
        zzsr zzsr = null;
        zzsq zzsq = this.zzbuj;
        if (zzsq == null) {
            this.zzbuj = new zzsq();
        } else {
            zzsr = zzsq.zzmF(zzmJ);
        }
        if (zzsr == null) {
            zzsr = new zzsr();
            this.zzbuj.zza(zzmJ, zzsr);
        }
        zzsr.zza(zzsw);
        return true;
    }

    /* access modifiers changed from: protected */
    public int zzz() {
        if (this.zzbuj == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.zzbuj.size(); i2++) {
            i += this.zzbuj.zzmG(i2).zzz();
        }
        return i;
    }
}
