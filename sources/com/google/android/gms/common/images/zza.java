package com.google.android.gms.common.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzma;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzmc;
import com.google.android.gms.internal.zzmd;
import java.lang.ref.WeakReference;

public abstract class zza {
    final C0003zza zzajO;
    protected int zzajP = 0;
    protected int zzajQ = 0;
    protected boolean zzajR = false;
    protected ImageManager.OnImageLoadedListener zzajS;
    private boolean zzajT = true;
    private boolean zzajU = false;
    private boolean zzajV = true;
    protected int zzajW;

    /* renamed from: com.google.android.gms.common.images.zza$zza  reason: collision with other inner class name */
    static final class C0003zza {
        public final Uri uri;

        public C0003zza(Uri uri2) {
            this.uri = uri2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0003zza)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            return zzw.equal(((C0003zza) obj).uri, this.uri);
        }

        public int hashCode() {
            return zzw.hashCode(this.uri);
        }
    }

    public static final class zzb extends zza {
        private WeakReference<ImageView> zzajX;

        public zzb(ImageView imageView, int i) {
            super((Uri) null, i);
            com.google.android.gms.common.internal.zzb.zzv(imageView);
            this.zzajX = new WeakReference<>(imageView);
        }

        public zzb(ImageView imageView, Uri uri) {
            super(uri, 0);
            com.google.android.gms.common.internal.zzb.zzv(imageView);
            this.zzajX = new WeakReference<>(imageView);
        }

        private void zza(ImageView imageView, Drawable drawable, boolean z, boolean z2, boolean z3) {
            int i = 0;
            boolean z4 = !z2 && !z3;
            if (z4 && (imageView instanceof zzmc)) {
                int zzqp = ((zzmc) imageView).zzqp();
                if (this.zzajQ != 0 && zzqp == this.zzajQ) {
                    return;
                }
            }
            boolean zzb = zzb(z, z2);
            if (this.zzajR && drawable != null) {
                drawable = drawable.getConstantState().newDrawable();
            }
            if (zzb) {
                drawable = zza(imageView.getDrawable(), drawable);
            }
            imageView.setImageDrawable(drawable);
            if (imageView instanceof zzmc) {
                zzmc zzmc = (zzmc) imageView;
                zzmc.zzm(z3 ? this.zzajO.uri : null);
                if (z4) {
                    i = this.zzajQ;
                }
                zzmc.zzbO(i);
            }
            if (zzb) {
                ((zzma) drawable).startTransition(250);
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof zzb)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            ImageView imageView = (ImageView) this.zzajX.get();
            ImageView imageView2 = (ImageView) ((zzb) obj).zzajX.get();
            return (imageView2 == null || imageView == null || !zzw.equal(imageView2, imageView)) ? false : true;
        }

        public int hashCode() {
            return 0;
        }

        /* access modifiers changed from: protected */
        public void zza(Drawable drawable, boolean z, boolean z2, boolean z3) {
            ImageView imageView = (ImageView) this.zzajX.get();
            if (imageView != null) {
                zza(imageView, drawable, z, z2, z3);
            }
        }
    }

    public static final class zzc extends zza {
        private WeakReference<ImageManager.OnImageLoadedListener> zzajY;

        public zzc(ImageManager.OnImageLoadedListener onImageLoadedListener, Uri uri) {
            super(uri, 0);
            com.google.android.gms.common.internal.zzb.zzv(onImageLoadedListener);
            this.zzajY = new WeakReference<>(onImageLoadedListener);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof zzc)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            zzc zzc = (zzc) obj;
            ImageManager.OnImageLoadedListener onImageLoadedListener = (ImageManager.OnImageLoadedListener) this.zzajY.get();
            ImageManager.OnImageLoadedListener onImageLoadedListener2 = (ImageManager.OnImageLoadedListener) zzc.zzajY.get();
            return onImageLoadedListener2 != null && onImageLoadedListener != null && zzw.equal(onImageLoadedListener2, onImageLoadedListener) && zzw.equal(zzc.zzajO, this.zzajO);
        }

        public int hashCode() {
            return zzw.hashCode(this.zzajO);
        }

        /* access modifiers changed from: protected */
        public void zza(Drawable drawable, boolean z, boolean z2, boolean z3) {
            ImageManager.OnImageLoadedListener onImageLoadedListener;
            if (!z2 && (onImageLoadedListener = (ImageManager.OnImageLoadedListener) this.zzajY.get()) != null) {
                onImageLoadedListener.onImageLoaded(this.zzajO.uri, drawable, z3);
            }
        }
    }

    public zza(Uri uri, int i) {
        this.zzajO = new C0003zza(uri);
        this.zzajQ = i;
    }

    private Drawable zza(Context context, zzmd zzmd, int i) {
        Resources resources = context.getResources();
        int i2 = this.zzajW;
        if (i2 <= 0) {
            return resources.getDrawable(i);
        }
        zzmd.zza zza = new zzmd.zza(i, i2);
        Drawable drawable = (Drawable) zzmd.get(zza);
        if (drawable == null) {
            Drawable drawable2 = resources.getDrawable(i);
            drawable = (this.zzajW & 1) != 0 ? zza(resources, drawable2) : drawable2;
            zzmd.put(zza, drawable);
        }
        return drawable;
    }

    /* access modifiers changed from: protected */
    public Drawable zza(Resources resources, Drawable drawable) {
        return zzmb.zza(resources, drawable);
    }

    /* access modifiers changed from: protected */
    public zzma zza(Drawable drawable, Drawable drawable2) {
        if (drawable == null) {
            drawable = null;
        } else if (drawable instanceof zzma) {
            drawable = ((zzma) drawable).zzqn();
        }
        return new zzma(drawable, drawable2);
    }

    /* access modifiers changed from: package-private */
    public void zza(Context context, Bitmap bitmap, boolean z) {
        com.google.android.gms.common.internal.zzb.zzv(bitmap);
        if ((this.zzajW & 1) != 0) {
            bitmap = zzmb.zzb(bitmap);
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), bitmap);
        ImageManager.OnImageLoadedListener onImageLoadedListener = this.zzajS;
        if (onImageLoadedListener != null) {
            onImageLoadedListener.onImageLoaded(this.zzajO.uri, bitmapDrawable, true);
        }
        zza(bitmapDrawable, z, false, true);
    }

    /* access modifiers changed from: package-private */
    public void zza(Context context, zzmd zzmd) {
        if (this.zzajV) {
            Drawable drawable = null;
            int i = this.zzajP;
            if (i != 0) {
                drawable = zza(context, zzmd, i);
            }
            zza(drawable, false, true, false);
        }
    }

    /* access modifiers changed from: package-private */
    public void zza(Context context, zzmd zzmd, boolean z) {
        int i = this.zzajQ;
        Drawable zza = i != 0 ? zza(context, zzmd, i) : null;
        ImageManager.OnImageLoadedListener onImageLoadedListener = this.zzajS;
        if (onImageLoadedListener != null) {
            onImageLoadedListener.onImageLoaded(this.zzajO.uri, zza, false);
        }
        zza(zza, z, false, false);
    }

    /* access modifiers changed from: protected */
    public abstract void zza(Drawable drawable, boolean z, boolean z2, boolean z3);

    /* access modifiers changed from: protected */
    public boolean zzb(boolean z, boolean z2) {
        return this.zzajT && !z2 && (!z || this.zzajU);
    }

    public void zzbM(int i) {
        this.zzajQ = i;
    }
}
