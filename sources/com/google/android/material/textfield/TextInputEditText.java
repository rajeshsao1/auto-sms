package com.google.android.material.textfield;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.appcompat.widget.AppCompatEditText;
import com.google.android.material.R;
import com.google.android.material.internal.ManufacturerUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

public class TextInputEditText extends AppCompatEditText {
    private final Rect parentRect;
    private boolean textInputLayoutFocusedRectEnabled;

    public TextInputEditText(Context context) {
        this(context, (AttributeSet) null);
    }

    public TextInputEditText(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.editTextStyle);
    }

    public TextInputEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(MaterialThemeOverlay.wrap(context, attrs, defStyleAttr, 0), attrs, defStyleAttr);
        this.parentRect = new Rect();
        TypedArray attributes = ThemeEnforcement.obtainStyledAttributes(context, attrs, R.styleable.TextInputEditText, defStyleAttr, R.style.Widget_Design_TextInputEditText, new int[0]);
        setTextInputLayoutFocusedRectEnabled(attributes.getBoolean(R.styleable.TextInputEditText_textInputLayoutFocusedRectEnabled, false));
        attributes.recycle();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout layout = getTextInputLayout();
        if (layout != null && layout.isProvidingHint() && super.getHint() == null && ManufacturerUtils.isMeizuDevice()) {
            setHint("");
        }
    }

    public CharSequence getHint() {
        TextInputLayout layout = getTextInputLayout();
        if (layout == null || !layout.isProvidingHint()) {
            return super.getHint();
        }
        return layout.getHint();
    }

    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        InputConnection ic = super.onCreateInputConnection(outAttrs);
        if (ic != null && outAttrs.hintText == null) {
            outAttrs.hintText = getHintFromLayout();
        }
        return ic;
    }

    private TextInputLayout getTextInputLayout() {
        for (ViewParent parent = getParent(); parent instanceof View; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    private CharSequence getHintFromLayout() {
        TextInputLayout layout = getTextInputLayout();
        if (layout != null) {
            return layout.getHint();
        }
        return null;
    }

    public void setTextInputLayoutFocusedRectEnabled(boolean textInputLayoutFocusedRectEnabled2) {
        this.textInputLayoutFocusedRectEnabled = textInputLayoutFocusedRectEnabled2;
    }

    public boolean isTextInputLayoutFocusedRectEnabled() {
        return this.textInputLayoutFocusedRectEnabled;
    }

    public void getFocusedRect(Rect r) {
        super.getFocusedRect(r);
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null && this.textInputLayoutFocusedRectEnabled && r != null) {
            textInputLayout.getFocusedRect(this.parentRect);
            r.bottom = this.parentRect.bottom;
        }
    }

    public boolean getGlobalVisibleRect(Rect r, Point globalOffset) {
        boolean result = super.getGlobalVisibleRect(r, globalOffset);
        TextInputLayout textInputLayout = getTextInputLayout();
        if (!(textInputLayout == null || !this.textInputLayoutFocusedRectEnabled || r == null)) {
            textInputLayout.getGlobalVisibleRect(this.parentRect, globalOffset);
            r.bottom = this.parentRect.bottom;
        }
        return result;
    }

    public boolean requestRectangleOnScreen(Rect rectangle) {
        boolean result = super.requestRectangleOnScreen(rectangle);
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null && this.textInputLayoutFocusedRectEnabled) {
            this.parentRect.set(0, textInputLayout.getHeight() - getResources().getDimensionPixelOffset(R.dimen.mtrl_edittext_rectangle_top_offset), textInputLayout.getWidth(), textInputLayout.getHeight());
            textInputLayout.requestRectangleOnScreen(this.parentRect, true);
        }
        return result;
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        TextInputLayout layout = getTextInputLayout();
        if (Build.VERSION.SDK_INT < 23 && layout != null) {
            info.setText(getAccessibilityNodeInfoText(layout));
        }
    }

    private String getAccessibilityNodeInfoText(TextInputLayout layout) {
        CharSequence inputText = getText();
        CharSequence hintText = layout.getHint();
        CharSequence helperText = layout.getHelperText();
        CharSequence errorText = layout.getError();
        boolean showingText = !TextUtils.isEmpty(inputText);
        boolean hasHint = !TextUtils.isEmpty(hintText);
        boolean hasHelperText = !TextUtils.isEmpty(helperText);
        boolean showingError = !TextUtils.isEmpty(errorText);
        String str = "";
        String hint = hasHint ? hintText.toString() : str;
        StringBuilder sb = new StringBuilder();
        sb.append(hint);
        sb.append(((showingError || hasHelperText) && !TextUtils.isEmpty(hint)) ? ", " : str);
        String hint2 = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(hint2);
        sb2.append(showingError ? errorText : hasHelperText ? helperText : str);
        String hint3 = sb2.toString();
        if (showingText) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(inputText);
            if (!TextUtils.isEmpty(hint3)) {
                str = ", " + hint3;
            }
            sb3.append(str);
            return sb3.toString();
        } else if (!TextUtils.isEmpty(hint3)) {
            return hint3;
        } else {
            return str;
        }
    }
}
