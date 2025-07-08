package com.google.android.gms.dynamic;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.dynamic.LifecycleDelegate;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class zza<T extends LifecycleDelegate> {
    private final zzf<T> zzavA = new zzf<T>() {
        public void zza(T t) {
            LifecycleDelegate unused = zza.this.zzavx = t;
            Iterator it = zza.this.zzavz.iterator();
            while (it.hasNext()) {
                ((C0029zza) it.next()).zzb(zza.this.zzavx);
            }
            zza.this.zzavz.clear();
            Bundle unused2 = zza.this.zzavy = null;
        }
    };
    /* access modifiers changed from: private */
    public T zzavx;
    /* access modifiers changed from: private */
    public Bundle zzavy;
    /* access modifiers changed from: private */
    public LinkedList<C0029zza> zzavz;

    /* renamed from: com.google.android.gms.dynamic.zza$zza  reason: collision with other inner class name */
    private interface C0029zza {
        int getState();

        void zzb(LifecycleDelegate lifecycleDelegate);
    }

    private void zza(Bundle bundle, C0029zza zza) {
        T t = this.zzavx;
        if (t != null) {
            zza.zzb(t);
            return;
        }
        if (this.zzavz == null) {
            this.zzavz = new LinkedList<>();
        }
        this.zzavz.add(zza);
        if (bundle != null) {
            Bundle bundle2 = this.zzavy;
            if (bundle2 == null) {
                this.zzavy = (Bundle) bundle.clone();
            } else {
                bundle2.putAll(bundle);
            }
        }
        zza(this.zzavA);
    }

    public static void zzb(FrameLayout frameLayout) {
        final Context context = frameLayout.getContext();
        final int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        String zzc = zzg.zzc(context, isGooglePlayServicesAvailable, GooglePlayServicesUtil.zzao(context));
        String zzh = zzg.zzh(context, isGooglePlayServicesAvailable);
        LinearLayout linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        frameLayout.addView(linearLayout);
        TextView textView = new TextView(frameLayout.getContext());
        textView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        textView.setText(zzc);
        linearLayout.addView(textView);
        if (zzh != null) {
            Button button = new Button(context);
            button.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            button.setText(zzh);
            linearLayout.addView(button);
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    context.startActivity(GooglePlayServicesUtil.zzbv(isGooglePlayServicesAvailable));
                }
            });
        }
    }

    private void zzeJ(int i) {
        while (!this.zzavz.isEmpty() && this.zzavz.getLast().getState() >= i) {
            this.zzavz.removeLast();
        }
    }

    public void onCreate(final Bundle bundle) {
        zza(bundle, (C0029zza) new C0029zza() {
            public int getState() {
                return 1;
            }

            public void zzb(LifecycleDelegate lifecycleDelegate) {
                zza.this.zzavx.onCreate(bundle);
            }
        });
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FrameLayout frameLayout = new FrameLayout(layoutInflater.getContext());
        final FrameLayout frameLayout2 = frameLayout;
        final LayoutInflater layoutInflater2 = layoutInflater;
        final ViewGroup viewGroup2 = viewGroup;
        final Bundle bundle2 = bundle;
        zza(bundle, (C0029zza) new C0029zza() {
            public int getState() {
                return 2;
            }

            public void zzb(LifecycleDelegate lifecycleDelegate) {
                frameLayout2.removeAllViews();
                frameLayout2.addView(zza.this.zzavx.onCreateView(layoutInflater2, viewGroup2, bundle2));
            }
        });
        if (this.zzavx == null) {
            zza(frameLayout);
        }
        return frameLayout;
    }

    public void onDestroy() {
        T t = this.zzavx;
        if (t != null) {
            t.onDestroy();
        } else {
            zzeJ(1);
        }
    }

    public void onDestroyView() {
        T t = this.zzavx;
        if (t != null) {
            t.onDestroyView();
        } else {
            zzeJ(2);
        }
    }

    public void onInflate(final Activity activity, final Bundle bundle, final Bundle bundle2) {
        zza(bundle2, (C0029zza) new C0029zza() {
            public int getState() {
                return 0;
            }

            public void zzb(LifecycleDelegate lifecycleDelegate) {
                zza.this.zzavx.onInflate(activity, bundle, bundle2);
            }
        });
    }

    public void onLowMemory() {
        T t = this.zzavx;
        if (t != null) {
            t.onLowMemory();
        }
    }

    public void onPause() {
        T t = this.zzavx;
        if (t != null) {
            t.onPause();
        } else {
            zzeJ(5);
        }
    }

    public void onResume() {
        zza((Bundle) null, (C0029zza) new C0029zza() {
            public int getState() {
                return 5;
            }

            public void zzb(LifecycleDelegate lifecycleDelegate) {
                zza.this.zzavx.onResume();
            }
        });
    }

    public void onSaveInstanceState(Bundle bundle) {
        T t = this.zzavx;
        if (t != null) {
            t.onSaveInstanceState(bundle);
            return;
        }
        Bundle bundle2 = this.zzavy;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
    }

    public void onStart() {
        zza((Bundle) null, (C0029zza) new C0029zza() {
            public int getState() {
                return 4;
            }

            public void zzb(LifecycleDelegate lifecycleDelegate) {
                zza.this.zzavx.onStart();
            }
        });
    }

    public void onStop() {
        T t = this.zzavx;
        if (t != null) {
            t.onStop();
        } else {
            zzeJ(4);
        }
    }

    /* access modifiers changed from: protected */
    public void zza(FrameLayout frameLayout) {
        zzb(frameLayout);
    }

    /* access modifiers changed from: protected */
    public abstract void zza(zzf<T> zzf);

    public T zztU() {
        return this.zzavx;
    }
}
