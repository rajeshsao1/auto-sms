package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.Path;
import android.net.Uri;
import android.widget.ImageView;

public final class zzmc extends ImageView {
    private Uri zzakr;
    private int zzaks;
    private int zzakt;
    private zza zzaku;
    private int zzakv;
    private float zzakw;

    public interface zza {
        Path zzl(int i, int i2);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        zza zza2 = this.zzaku;
        if (zza2 != null) {
            canvas.clipPath(zza2.zzl(getWidth(), getHeight()));
        }
        super.onDraw(canvas);
        int i = this.zzakt;
        if (i != 0) {
            canvas.drawColor(i);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        super.onMeasure(i, i2);
        int i5 = this.zzakv;
        if (i5 == 1) {
            i3 = getMeasuredHeight();
            i4 = (int) (((float) i3) * this.zzakw);
        } else if (i5 == 2) {
            i4 = getMeasuredWidth();
            i3 = (int) (((float) i4) / this.zzakw);
        } else {
            return;
        }
        setMeasuredDimension(i4, i3);
    }

    public void zzbO(int i) {
        this.zzaks = i;
    }

    public void zzm(Uri uri) {
        this.zzakr = uri;
    }

    public int zzqp() {
        return this.zzaks;
    }
}
