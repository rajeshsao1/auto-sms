package com.google.android.gms.common.images;

import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.util.Log;
import android.widget.ImageView;
import androidx.collection.LruCache;
import com.google.android.gms.common.images.zza;
import com.google.android.gms.internal.zzmd;
import com.google.android.gms.internal.zzne;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ImageManager {
    /* access modifiers changed from: private */
    public static HashSet<Uri> zzajA = new HashSet<>();
    private static ImageManager zzajB;
    private static ImageManager zzajC;
    /* access modifiers changed from: private */
    public static final Object zzajz = new Object();
    /* access modifiers changed from: private */
    public final Context mContext;
    /* access modifiers changed from: private */
    public final Handler mHandler = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public final ExecutorService zzajD = Executors.newFixedThreadPool(4);
    /* access modifiers changed from: private */
    public final zzb zzajE;
    /* access modifiers changed from: private */
    public final zzmd zzajF;
    /* access modifiers changed from: private */
    public final Map<zza, ImageReceiver> zzajG;
    /* access modifiers changed from: private */
    public final Map<Uri, ImageReceiver> zzajH;
    /* access modifiers changed from: private */
    public final Map<Uri, Long> zzajI;

    private final class ImageReceiver extends ResultReceiver {
        private final Uri mUri;
        /* access modifiers changed from: private */
        public final ArrayList<zza> zzajJ = new ArrayList<>();

        ImageReceiver(Uri uri) {
            super(new Handler(Looper.getMainLooper()));
            this.mUri = uri;
        }

        public void onReceiveResult(int i, Bundle bundle) {
            ImageManager.this.zzajD.execute(new zzc(this.mUri, (ParcelFileDescriptor) bundle.getParcelable("com.google.android.gms.extra.fileDescriptor")));
        }

        public void zzb(zza zza) {
            com.google.android.gms.common.internal.zzb.zzcD("ImageReceiver.addImageRequest() must be called in the main thread");
            this.zzajJ.add(zza);
        }

        public void zzc(zza zza) {
            com.google.android.gms.common.internal.zzb.zzcD("ImageReceiver.removeImageRequest() must be called in the main thread");
            this.zzajJ.remove(zza);
        }

        public void zzqm() {
            Intent intent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
            intent.putExtra("com.google.android.gms.extras.uri", this.mUri);
            intent.putExtra("com.google.android.gms.extras.resultReceiver", this);
            intent.putExtra("com.google.android.gms.extras.priority", 3);
            ImageManager.this.mContext.sendBroadcast(intent);
        }
    }

    public interface OnImageLoadedListener {
        void onImageLoaded(Uri uri, Drawable drawable, boolean z);
    }

    private static final class zza {
        static int zza(ActivityManager activityManager) {
            return activityManager.getLargeMemoryClass();
        }
    }

    private static final class zzb extends LruCache<zza.C0003zza, Bitmap> {
        public zzb(Context context) {
            super(zzas(context));
        }

        private static int zzas(Context context) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            return (int) (((float) (((!((context.getApplicationInfo().flags & 1048576) != 0) || !zzne.zzsd()) ? activityManager.getMemoryClass() : zza.zza(activityManager)) * 1048576)) * 0.33f);
        }

        /* access modifiers changed from: protected */
        /* renamed from: zza */
        public int sizeOf(zza.C0003zza zza, Bitmap bitmap) {
            return bitmap.getHeight() * bitmap.getRowBytes();
        }

        /* access modifiers changed from: protected */
        /* renamed from: zza */
        public void entryRemoved(boolean z, zza.C0003zza zza, Bitmap bitmap, Bitmap bitmap2) {
            super.entryRemoved(z, zza, bitmap, bitmap2);
        }
    }

    private final class zzc implements Runnable {
        private final Uri mUri;
        private final ParcelFileDescriptor zzajL;

        public zzc(Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
            this.mUri = uri;
            this.zzajL = parcelFileDescriptor;
        }

        public void run() {
            boolean z;
            Bitmap bitmap;
            com.google.android.gms.common.internal.zzb.zzcE("LoadBitmapFromDiskRunnable can't be executed in the main thread");
            ParcelFileDescriptor parcelFileDescriptor = this.zzajL;
            boolean z2 = false;
            Bitmap bitmap2 = null;
            if (parcelFileDescriptor != null) {
                try {
                    bitmap2 = BitmapFactory.decodeFileDescriptor(parcelFileDescriptor.getFileDescriptor());
                } catch (OutOfMemoryError e) {
                    Log.e("ImageManager", "OOM while loading bitmap for uri: " + this.mUri, e);
                    z2 = true;
                }
                try {
                    this.zzajL.close();
                } catch (IOException e2) {
                    Log.e("ImageManager", "closed failed", e2);
                }
                z = z2;
                bitmap = bitmap2;
            } else {
                bitmap = null;
                z = false;
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            ImageManager.this.mHandler.post(new zzf(this.mUri, bitmap, z, countDownLatch));
            try {
                countDownLatch.await();
            } catch (InterruptedException e3) {
                Log.w("ImageManager", "Latch interrupted while posting " + this.mUri);
            }
        }
    }

    private final class zzd implements Runnable {
        private final zza zzajM;

        public zzd(zza zza) {
            this.zzajM = zza;
        }

        public void run() {
            com.google.android.gms.common.internal.zzb.zzcD("LoadImageRunnable must be executed on the main thread");
            ImageReceiver imageReceiver = (ImageReceiver) ImageManager.this.zzajG.get(this.zzajM);
            if (imageReceiver != null) {
                ImageManager.this.zzajG.remove(this.zzajM);
                imageReceiver.zzc(this.zzajM);
            }
            zza.C0003zza zza = this.zzajM.zzajO;
            if (zza.uri == null) {
                this.zzajM.zza(ImageManager.this.mContext, ImageManager.this.zzajF, true);
                return;
            }
            Bitmap zza2 = ImageManager.this.zza(zza);
            if (zza2 != null) {
                this.zzajM.zza(ImageManager.this.mContext, zza2, true);
                return;
            }
            Long l = (Long) ImageManager.this.zzajI.get(zza.uri);
            if (l != null) {
                if (SystemClock.elapsedRealtime() - l.longValue() < 3600000) {
                    this.zzajM.zza(ImageManager.this.mContext, ImageManager.this.zzajF, true);
                    return;
                }
                ImageManager.this.zzajI.remove(zza.uri);
            }
            this.zzajM.zza(ImageManager.this.mContext, ImageManager.this.zzajF);
            ImageReceiver imageReceiver2 = (ImageReceiver) ImageManager.this.zzajH.get(zza.uri);
            if (imageReceiver2 == null) {
                imageReceiver2 = new ImageReceiver(zza.uri);
                ImageManager.this.zzajH.put(zza.uri, imageReceiver2);
            }
            imageReceiver2.zzb(this.zzajM);
            if (!(this.zzajM instanceof zza.zzc)) {
                ImageManager.this.zzajG.put(this.zzajM, imageReceiver2);
            }
            synchronized (ImageManager.zzajz) {
                if (!ImageManager.zzajA.contains(zza.uri)) {
                    ImageManager.zzajA.add(zza.uri);
                    imageReceiver2.zzqm();
                }
            }
        }
    }

    private static final class zze implements ComponentCallbacks2 {
        private final zzb zzajE;

        public zze(zzb zzb) {
            this.zzajE = zzb;
        }

        public void onConfigurationChanged(Configuration configuration) {
        }

        public void onLowMemory() {
            this.zzajE.evictAll();
        }

        public void onTrimMemory(int i) {
            if (i >= 60) {
                this.zzajE.evictAll();
            } else if (i >= 20) {
                zzb zzb = this.zzajE;
                zzb.trimToSize(zzb.size() / 2);
            }
        }
    }

    private final class zzf implements Runnable {
        private final Bitmap mBitmap;
        private final Uri mUri;
        private boolean zzajN;
        private final CountDownLatch zzpJ;

        public zzf(Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
            this.mUri = uri;
            this.mBitmap = bitmap;
            this.zzajN = z;
            this.zzpJ = countDownLatch;
        }

        private void zza(ImageReceiver imageReceiver, boolean z) {
            ArrayList zza = imageReceiver.zzajJ;
            int size = zza.size();
            for (int i = 0; i < size; i++) {
                zza zza2 = (zza) zza.get(i);
                ImageManager imageManager = ImageManager.this;
                if (z) {
                    zza2.zza(imageManager.mContext, this.mBitmap, false);
                } else {
                    imageManager.zzajI.put(this.mUri, Long.valueOf(SystemClock.elapsedRealtime()));
                    zza2.zza(ImageManager.this.mContext, ImageManager.this.zzajF, false);
                }
                if (!(zza2 instanceof zza.zzc)) {
                    ImageManager.this.zzajG.remove(zza2);
                }
            }
        }

        public void run() {
            com.google.android.gms.common.internal.zzb.zzcD("OnBitmapLoadedRunnable must be executed in the main thread");
            boolean z = this.mBitmap != null;
            if (ImageManager.this.zzajE != null) {
                if (this.zzajN) {
                    ImageManager.this.zzajE.evictAll();
                    System.gc();
                    this.zzajN = false;
                    ImageManager.this.mHandler.post(this);
                    return;
                } else if (z) {
                    ImageManager.this.zzajE.put(new zza.C0003zza(this.mUri), this.mBitmap);
                }
            }
            ImageReceiver imageReceiver = (ImageReceiver) ImageManager.this.zzajH.remove(this.mUri);
            if (imageReceiver != null) {
                zza(imageReceiver, z);
            }
            this.zzpJ.countDown();
            synchronized (ImageManager.zzajz) {
                ImageManager.zzajA.remove(this.mUri);
            }
        }
    }

    private ImageManager(Context context, boolean z) {
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        if (z) {
            this.zzajE = new zzb(applicationContext);
            if (zzne.zzsg()) {
                zzqj();
            }
        } else {
            this.zzajE = null;
        }
        this.zzajF = new zzmd();
        this.zzajG = new HashMap();
        this.zzajH = new HashMap();
        this.zzajI = new HashMap();
    }

    public static ImageManager create(Context context) {
        return zzc(context, false);
    }

    /* access modifiers changed from: private */
    public Bitmap zza(zza.C0003zza zza2) {
        zzb zzb2 = this.zzajE;
        if (zzb2 == null) {
            return null;
        }
        return (Bitmap) zzb2.get(zza2);
    }

    public static ImageManager zzc(Context context, boolean z) {
        if (z) {
            if (zzajC == null) {
                zzajC = new ImageManager(context, true);
            }
            return zzajC;
        }
        if (zzajB == null) {
            zzajB = new ImageManager(context, false);
        }
        return zzajB;
    }

    private void zzqj() {
        this.mContext.registerComponentCallbacks(new zze(this.zzajE));
    }

    public void loadImage(ImageView imageView, int i) {
        zza((zza) new zza.zzb(imageView, i));
    }

    public void loadImage(ImageView imageView, Uri uri) {
        zza((zza) new zza.zzb(imageView, uri));
    }

    public void loadImage(ImageView imageView, Uri uri, int i) {
        zza.zzb zzb2 = new zza.zzb(imageView, uri);
        zzb2.zzbM(i);
        zza((zza) zzb2);
    }

    public void loadImage(OnImageLoadedListener onImageLoadedListener, Uri uri) {
        zza((zza) new zza.zzc(onImageLoadedListener, uri));
    }

    public void loadImage(OnImageLoadedListener onImageLoadedListener, Uri uri, int i) {
        zza.zzc zzc2 = new zza.zzc(onImageLoadedListener, uri);
        zzc2.zzbM(i);
        zza((zza) zzc2);
    }

    public void zza(zza zza2) {
        com.google.android.gms.common.internal.zzb.zzcD("ImageManager.loadImage() must be called in the main thread");
        new zzd(zza2).run();
    }
}
