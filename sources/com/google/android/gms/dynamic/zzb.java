package com.google.android.gms.dynamic;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.dynamic.zzc;

public final class zzb extends zzc.zza {
    private Fragment zzavH;

    private zzb(Fragment fragment) {
        this.zzavH = fragment;
    }

    public static zzb zza(Fragment fragment) {
        if (fragment != null) {
            return new zzb(fragment);
        }
        return null;
    }

    public Bundle getArguments() {
        return this.zzavH.getArguments();
    }

    public int getId() {
        return this.zzavH.getId();
    }

    public boolean getRetainInstance() {
        return this.zzavH.getRetainInstance();
    }

    public String getTag() {
        return this.zzavH.getTag();
    }

    public int getTargetRequestCode() {
        return this.zzavH.getTargetRequestCode();
    }

    public boolean getUserVisibleHint() {
        return this.zzavH.getUserVisibleHint();
    }

    public zzd getView() {
        return zze.zzC(this.zzavH.getView());
    }

    public boolean isAdded() {
        return this.zzavH.isAdded();
    }

    public boolean isDetached() {
        return this.zzavH.isDetached();
    }

    public boolean isHidden() {
        return this.zzavH.isHidden();
    }

    public boolean isInLayout() {
        return this.zzavH.isInLayout();
    }

    public boolean isRemoving() {
        return this.zzavH.isRemoving();
    }

    public boolean isResumed() {
        return this.zzavH.isResumed();
    }

    public boolean isVisible() {
        return this.zzavH.isVisible();
    }

    public void setHasOptionsMenu(boolean z) {
        this.zzavH.setHasOptionsMenu(z);
    }

    public void setMenuVisibility(boolean z) {
        this.zzavH.setMenuVisibility(z);
    }

    public void setRetainInstance(boolean z) {
        this.zzavH.setRetainInstance(z);
    }

    public void setUserVisibleHint(boolean z) {
        this.zzavH.setUserVisibleHint(z);
    }

    public void startActivity(Intent intent) {
        this.zzavH.startActivity(intent);
    }

    public void startActivityForResult(Intent intent, int i) {
        this.zzavH.startActivityForResult(intent, i);
    }

    public void zzn(zzd zzd) {
        this.zzavH.registerForContextMenu((View) zze.zzp(zzd));
    }

    public void zzo(zzd zzd) {
        this.zzavH.unregisterForContextMenu((View) zze.zzp(zzd));
    }

    public zzd zztV() {
        return zze.zzC(this.zzavH.getActivity());
    }

    public zzc zztW() {
        return zza(this.zzavH.getParentFragment());
    }

    public zzd zztX() {
        return zze.zzC(this.zzavH.getResources());
    }

    public zzc zztY() {
        return zza(this.zzavH.getTargetFragment());
    }
}
