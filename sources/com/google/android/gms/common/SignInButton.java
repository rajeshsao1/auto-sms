package com.google.android.gms.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.R;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.dynamic.zzg;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class SignInButton extends FrameLayout implements View.OnClickListener {
    public static final int COLOR_AUTO = 2;
    public static final int COLOR_DARK = 0;
    public static final int COLOR_LIGHT = 1;
    public static final int SIZE_ICON_ONLY = 2;
    public static final int SIZE_STANDARD = 0;
    public static final int SIZE_WIDE = 1;
    private int mColor;
    private int mSize;
    private Scope[] zzafT;
    private View zzafU;
    private View.OnClickListener zzafV;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ButtonSize {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ColorScheme {
    }

    public SignInButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public SignInButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SignInButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zzafV = null;
        zza(context, attributeSet);
        setStyle(this.mSize, this.mColor, this.zzafT);
    }

    private static Button zza(Context context, int i, int i2, Scope[] scopeArr) {
        zzac zzac = new zzac(context);
        zzac.zza(context.getResources(), i, i2, scopeArr);
        return zzac;
    }

    private void zza(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SignInButton, 0, 0);
        try {
            this.mSize = obtainStyledAttributes.getInt(R.styleable.SignInButton_buttonSize, 0);
            this.mColor = obtainStyledAttributes.getInt(R.styleable.SignInButton_colorScheme, 2);
            String string = obtainStyledAttributes.getString(R.styleable.SignInButton_scopeUris);
            if (string == null) {
                this.zzafT = null;
            } else {
                String[] split = string.trim().split("\\s+");
                this.zzafT = new Scope[split.length];
                for (int i = 0; i < split.length; i++) {
                    this.zzafT[i] = new Scope(split[i].toString());
                }
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void zzar(Context context) {
        View view = this.zzafU;
        if (view != null) {
            removeView(view);
        }
        try {
            this.zzafU = zzab.zzb(context, this.mSize, this.mColor, this.zzafT);
        } catch (zzg.zza e) {
            Log.w("SignInButton", "Sign in button not found, using placeholder instead");
            this.zzafU = zza(context, this.mSize, this.mColor, this.zzafT);
        }
        addView(this.zzafU);
        this.zzafU.setEnabled(isEnabled());
        this.zzafU.setOnClickListener(this);
    }

    public void onClick(View view) {
        View.OnClickListener onClickListener = this.zzafV;
        if (onClickListener != null && view == this.zzafU) {
            onClickListener.onClick(this);
        }
    }

    public void setColorScheme(int i) {
        setStyle(this.mSize, i, this.zzafT);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.zzafU.setEnabled(z);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.zzafV = onClickListener;
        View view = this.zzafU;
        if (view != null) {
            view.setOnClickListener(this);
        }
    }

    public void setScopes(Scope[] scopeArr) {
        setStyle(this.mSize, this.mColor, scopeArr);
    }

    public void setSize(int i) {
        setStyle(i, this.mColor, this.zzafT);
    }

    public void setStyle(int i, int i2) {
        setStyle(i, i2, this.zzafT);
    }

    public void setStyle(int i, int i2, Scope[] scopeArr) {
        this.mSize = i;
        this.mColor = i2;
        this.zzafT = scopeArr;
        zzar(getContext());
    }
}
