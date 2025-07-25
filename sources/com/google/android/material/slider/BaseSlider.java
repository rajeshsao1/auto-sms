package com.google.android.material.slider;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.SeekBar;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.google.android.material.R;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewOverlayImpl;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.slider.BaseOnChangeListener;
import com.google.android.material.slider.BaseOnSliderTouchListener;
import com.google.android.material.slider.BaseSlider;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import com.google.android.material.tooltip.TooltipDrawable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

abstract class BaseSlider<S extends BaseSlider<S, L, T>, L extends BaseOnChangeListener<S>, T extends BaseOnSliderTouchListener<S>> extends View {
    /* access modifiers changed from: private */
    public static final int DEF_STYLE_RES = R.style.Widget_MaterialComponents_Slider;
    private static final String EXCEPTION_ILLEGAL_DISCRETE_VALUE = "Value(%s) must be equal to valueFrom(%s) plus a multiple of stepSize(%s) when using stepSize(%s)";
    private static final String EXCEPTION_ILLEGAL_STEP_SIZE = "The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range";
    private static final String EXCEPTION_ILLEGAL_VALUE = "Slider value(%s) must be greater or equal to valueFrom(%s), and lower or equal to valueTo(%s)";
    private static final String EXCEPTION_ILLEGAL_VALUE_FROM = "valueFrom(%s) must be smaller than valueTo(%s)";
    private static final String EXCEPTION_ILLEGAL_VALUE_TO = "valueTo(%s) must be greater than valueFrom(%s)";
    private static final int HALO_ALPHA = 63;
    private static final String TAG = BaseSlider.class.getSimpleName();
    private static final double THRESHOLD = 1.0E-4d;
    private static final int TIMEOUT_SEND_ACCESSIBILITY_EVENT = 200;
    private static final String WARNING_FLOATING_POINT_ERRROR = "Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the  value correctly.";
    private BaseSlider<S, L, T>.AccessibilityEventSender accessibilityEventSender;
    /* access modifiers changed from: private */
    public final AccessibilityHelper accessibilityHelper;
    private final AccessibilityManager accessibilityManager;
    private int activeThumbIdx;
    private final Paint activeTicksPaint;
    private final Paint activeTrackPaint;
    private final List<L> changeListeners;
    private boolean dirtyConfig;
    private int focusedThumbIdx;
    private boolean forceDrawCompatHalo;
    private LabelFormatter formatter;
    private ColorStateList haloColor;
    private final Paint haloPaint;
    private int haloRadius;
    private final Paint inactiveTicksPaint;
    private final Paint inactiveTrackPaint;
    private boolean isLongPress;
    private int labelBehavior;
    private final TooltipDrawableFactory labelMaker;
    private int labelPadding;
    private final List<TooltipDrawable> labels;
    private MotionEvent lastEvent;
    private final int scaledTouchSlop;
    private float stepSize;
    private final MaterialShapeDrawable thumbDrawable;
    private boolean thumbIsPressed;
    private final Paint thumbPaint;
    private int thumbRadius;
    private ColorStateList tickColorActive;
    private ColorStateList tickColorInactive;
    private float[] ticksCoordinates;
    private float touchDownX;
    private final List<T> touchListeners;
    private float touchPosition;
    private ColorStateList trackColorActive;
    private ColorStateList trackColorInactive;
    private int trackHeight;
    private int trackSidePadding;
    private int trackTop;
    private int trackWidth;
    private float valueFrom;
    private float valueTo;
    private ArrayList<Float> values;
    private int widgetHeight;

    private interface TooltipDrawableFactory {
        TooltipDrawable createTooltipDrawable();
    }

    public BaseSlider(Context context) {
        this(context, (AttributeSet) null);
    }

    public BaseSlider(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.sliderStyle);
    }

    public BaseSlider(Context context, final AttributeSet attrs, final int defStyleAttr) {
        super(MaterialThemeOverlay.wrap(context, attrs, defStyleAttr, DEF_STYLE_RES), attrs, defStyleAttr);
        this.labels = new ArrayList();
        this.changeListeners = new ArrayList();
        this.touchListeners = new ArrayList();
        this.thumbIsPressed = false;
        this.values = new ArrayList<>();
        this.activeThumbIdx = -1;
        this.focusedThumbIdx = -1;
        this.stepSize = 0.0f;
        this.isLongPress = false;
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        this.thumbDrawable = materialShapeDrawable;
        Context context2 = getContext();
        Paint paint = new Paint();
        this.inactiveTrackPaint = paint;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        Paint paint2 = new Paint();
        this.activeTrackPaint = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeCap(Paint.Cap.ROUND);
        Paint paint3 = new Paint(1);
        this.thumbPaint = paint3;
        paint3.setStyle(Paint.Style.FILL);
        paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        Paint paint4 = new Paint(1);
        this.haloPaint = paint4;
        paint4.setStyle(Paint.Style.FILL);
        Paint paint5 = new Paint();
        this.inactiveTicksPaint = paint5;
        paint5.setStyle(Paint.Style.STROKE);
        paint5.setStrokeCap(Paint.Cap.ROUND);
        Paint paint6 = new Paint();
        this.activeTicksPaint = paint6;
        paint6.setStyle(Paint.Style.STROKE);
        paint6.setStrokeCap(Paint.Cap.ROUND);
        loadResources(context2.getResources());
        this.labelMaker = new TooltipDrawableFactory() {
            public TooltipDrawable createTooltipDrawable() {
                TypedArray a = ThemeEnforcement.obtainStyledAttributes(BaseSlider.this.getContext(), attrs, R.styleable.Slider, defStyleAttr, BaseSlider.DEF_STYLE_RES, new int[0]);
                TooltipDrawable d = BaseSlider.parseLabelDrawable(BaseSlider.this.getContext(), a);
                a.recycle();
                return d;
            }
        };
        processAttributes(context2, attrs, defStyleAttr);
        setFocusable(true);
        setClickable(true);
        materialShapeDrawable.setShadowCompatibilityMode(2);
        this.scaledTouchSlop = ViewConfiguration.get(context2).getScaledTouchSlop();
        AccessibilityHelper accessibilityHelper2 = new AccessibilityHelper(this);
        this.accessibilityHelper = accessibilityHelper2;
        ViewCompat.setAccessibilityDelegate(this, accessibilityHelper2);
        this.accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
    }

    private void loadResources(Resources resources) {
        this.widgetHeight = resources.getDimensionPixelSize(R.dimen.mtrl_slider_widget_height);
        this.trackSidePadding = resources.getDimensionPixelOffset(R.dimen.mtrl_slider_track_side_padding);
        this.trackTop = resources.getDimensionPixelOffset(R.dimen.mtrl_slider_track_top);
        this.labelPadding = resources.getDimensionPixelSize(R.dimen.mtrl_slider_label_padding);
    }

    private void processAttributes(Context context, AttributeSet attrs, int defStyleAttr) {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        ColorStateList colorStateList5;
        Context context2 = context;
        TypedArray a = ThemeEnforcement.obtainStyledAttributes(context, attrs, R.styleable.Slider, defStyleAttr, DEF_STYLE_RES, new int[0]);
        this.valueFrom = a.getFloat(R.styleable.Slider_android_valueFrom, 0.0f);
        this.valueTo = a.getFloat(R.styleable.Slider_android_valueTo, 1.0f);
        setValues(Float.valueOf(this.valueFrom));
        this.stepSize = a.getFloat(R.styleable.Slider_android_stepSize, 0.0f);
        boolean hasTrackColor = a.hasValue(R.styleable.Slider_trackColor);
        int trackColorInactiveRes = hasTrackColor ? R.styleable.Slider_trackColor : R.styleable.Slider_trackColorInactive;
        int trackColorActiveRes = hasTrackColor ? R.styleable.Slider_trackColor : R.styleable.Slider_trackColorActive;
        ColorStateList trackColorInactive2 = MaterialResources.getColorStateList(context2, a, trackColorInactiveRes);
        if (trackColorInactive2 != null) {
            colorStateList = trackColorInactive2;
        } else {
            colorStateList = AppCompatResources.getColorStateList(context2, R.color.material_slider_inactive_track_color);
        }
        setTrackInactiveTintList(colorStateList);
        ColorStateList trackColorActive2 = MaterialResources.getColorStateList(context2, a, trackColorActiveRes);
        if (trackColorActive2 != null) {
            colorStateList2 = trackColorActive2;
        } else {
            colorStateList2 = AppCompatResources.getColorStateList(context2, R.color.material_slider_active_track_color);
        }
        setTrackActiveTintList(colorStateList2);
        this.thumbDrawable.setFillColor(MaterialResources.getColorStateList(context2, a, R.styleable.Slider_thumbColor));
        ColorStateList haloColor2 = MaterialResources.getColorStateList(context2, a, R.styleable.Slider_haloColor);
        if (haloColor2 != null) {
            colorStateList3 = haloColor2;
        } else {
            colorStateList3 = AppCompatResources.getColorStateList(context2, R.color.material_slider_halo_color);
        }
        setHaloTintList(colorStateList3);
        boolean hasTickColor = a.hasValue(R.styleable.Slider_tickColor);
        int tickColorInactiveRes = hasTickColor ? R.styleable.Slider_tickColor : R.styleable.Slider_tickColorInactive;
        int tickColorActiveRes = hasTickColor ? R.styleable.Slider_tickColor : R.styleable.Slider_tickColorActive;
        ColorStateList tickColorInactive2 = MaterialResources.getColorStateList(context2, a, tickColorInactiveRes);
        if (tickColorInactive2 != null) {
            colorStateList4 = tickColorInactive2;
        } else {
            colorStateList4 = AppCompatResources.getColorStateList(context2, R.color.material_slider_inactive_tick_marks_color);
        }
        setTickInactiveTintList(colorStateList4);
        ColorStateList tickColorActive2 = MaterialResources.getColorStateList(context2, a, tickColorActiveRes);
        if (tickColorActive2 != null) {
            colorStateList5 = tickColorActive2;
        } else {
            colorStateList5 = AppCompatResources.getColorStateList(context2, R.color.material_slider_active_tick_marks_color);
        }
        setTickActiveTintList(colorStateList5);
        setThumbRadius(a.getDimensionPixelSize(R.styleable.Slider_thumbRadius, 0));
        setHaloRadius(a.getDimensionPixelSize(R.styleable.Slider_haloRadius, 0));
        setThumbElevation(a.getDimension(R.styleable.Slider_thumbElevation, 0.0f));
        setTrackHeight(a.getDimensionPixelSize(R.styleable.Slider_trackHeight, 0));
        this.labelBehavior = a.getInt(R.styleable.Slider_labelBehavior, 0);
        if (!a.getBoolean(R.styleable.Slider_android_enabled, true)) {
            setEnabled(false);
        }
        a.recycle();
    }

    /* access modifiers changed from: private */
    public static TooltipDrawable parseLabelDrawable(Context context, TypedArray a) {
        return TooltipDrawable.createFromAttributes(context, (AttributeSet) null, 0, a.getResourceId(R.styleable.Slider_labelStyle, R.style.Widget_MaterialComponents_Tooltip));
    }

    private void validateValueFrom() {
        if (this.valueFrom >= this.valueTo) {
            throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_VALUE_FROM, new Object[]{Float.toString(this.valueFrom), Float.toString(this.valueTo)}));
        }
    }

    private void validateValueTo() {
        if (this.valueTo <= this.valueFrom) {
            throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_VALUE_TO, new Object[]{Float.toString(this.valueTo), Float.toString(this.valueFrom)}));
        }
    }

    private boolean valueLandsOnTick(float value) {
        double potentialTickValue = new BigDecimal(Float.toString(value)).subtract(new BigDecimal(Float.toString(this.valueFrom))).divide(new BigDecimal(Float.toString(this.stepSize)), MathContext.DECIMAL64).doubleValue();
        double round = (double) Math.round(potentialTickValue);
        Double.isNaN(round);
        return Math.abs(round - potentialTickValue) < THRESHOLD;
    }

    private void validateStepSize() {
        if (this.stepSize > 0.0f && !valueLandsOnTick(this.valueTo)) {
            throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_STEP_SIZE, new Object[]{Float.toString(this.stepSize), Float.toString(this.valueFrom), Float.toString(this.valueTo)}));
        }
    }

    private void validateValues() {
        Iterator<Float> it = this.values.iterator();
        while (it.hasNext()) {
            Float value = it.next();
            if (value.floatValue() < this.valueFrom || value.floatValue() > this.valueTo) {
                throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_VALUE, new Object[]{Float.toString(value.floatValue()), Float.toString(this.valueFrom), Float.toString(this.valueTo)}));
            } else if (this.stepSize > 0.0f && !valueLandsOnTick(value.floatValue())) {
                throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_DISCRETE_VALUE, new Object[]{Float.toString(value.floatValue()), Float.toString(this.valueFrom), Float.toString(this.stepSize), Float.toString(this.stepSize)}));
            }
        }
    }

    private void warnAboutFloatingPointError() {
        float f = this.stepSize;
        if (f != 0.0f) {
            if (((float) ((int) f)) != f) {
                Log.w(TAG, String.format(WARNING_FLOATING_POINT_ERRROR, new Object[]{"stepSize", Float.valueOf(f)}));
            }
            float f2 = this.valueFrom;
            if (((float) ((int) f2)) != f2) {
                Log.w(TAG, String.format(WARNING_FLOATING_POINT_ERRROR, new Object[]{"valueFrom", Float.valueOf(f2)}));
            }
            float f3 = this.valueTo;
            if (((float) ((int) f3)) != f3) {
                Log.w(TAG, String.format(WARNING_FLOATING_POINT_ERRROR, new Object[]{"valueTo", Float.valueOf(f3)}));
            }
        }
    }

    private void validateConfigurationIfDirty() {
        if (this.dirtyConfig) {
            validateValueFrom();
            validateValueTo();
            validateStepSize();
            validateValues();
            warnAboutFloatingPointError();
            this.dirtyConfig = false;
        }
    }

    public float getValueFrom() {
        return this.valueFrom;
    }

    public void setValueFrom(float valueFrom2) {
        this.valueFrom = valueFrom2;
        this.dirtyConfig = true;
        postInvalidate();
    }

    public float getValueTo() {
        return this.valueTo;
    }

    public void setValueTo(float valueTo2) {
        this.valueTo = valueTo2;
        this.dirtyConfig = true;
        postInvalidate();
    }

    /* access modifiers changed from: package-private */
    public List<Float> getValues() {
        return new ArrayList(this.values);
    }

    /* access modifiers changed from: package-private */
    public void setValues(Float... values2) {
        ArrayList<Float> list = new ArrayList<>();
        Collections.addAll(list, values2);
        setValuesInternal(list);
    }

    /* access modifiers changed from: package-private */
    public void setValues(List<Float> values2) {
        setValuesInternal(new ArrayList(values2));
    }

    private void setValuesInternal(ArrayList<Float> values2) {
        if (!values2.isEmpty()) {
            Collections.sort(values2);
            if (this.values.size() != values2.size() || !this.values.equals(values2)) {
                this.values = values2;
                this.dirtyConfig = true;
                this.focusedThumbIdx = 0;
                updateHaloHotspot();
                createLabelPool();
                dispatchOnChangedProgramatically();
                postInvalidate();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("At least one value must be set");
    }

    private void createLabelPool() {
        if (this.labels.size() > this.values.size()) {
            List<TooltipDrawable> tooltipDrawables = this.labels.subList(this.values.size(), this.labels.size());
            for (TooltipDrawable label : tooltipDrawables) {
                if (ViewCompat.isAttachedToWindow(this)) {
                    detachLabelFromContentView(label);
                }
            }
            tooltipDrawables.clear();
        }
        while (this.labels.size() < this.values.size()) {
            TooltipDrawable tooltipDrawable = this.labelMaker.createTooltipDrawable();
            this.labels.add(tooltipDrawable);
            if (ViewCompat.isAttachedToWindow(this)) {
                attachLabelToContentView(tooltipDrawable);
            }
        }
        int i = 1;
        if (this.labels.size() == 1) {
            i = 0;
        }
        int strokeWidth = i;
        for (TooltipDrawable label2 : this.labels) {
            label2.setStrokeWidth((float) strokeWidth);
        }
    }

    public float getStepSize() {
        return this.stepSize;
    }

    public void setStepSize(float stepSize2) {
        if (stepSize2 < 0.0f) {
            throw new IllegalArgumentException(String.format(EXCEPTION_ILLEGAL_STEP_SIZE, new Object[]{Float.toString(stepSize2), Float.toString(this.valueFrom), Float.toString(this.valueTo)}));
        } else if (this.stepSize != stepSize2) {
            this.stepSize = stepSize2;
            this.dirtyConfig = true;
            postInvalidate();
        }
    }

    public int getFocusedThumbIndex() {
        return this.focusedThumbIdx;
    }

    public void setFocusedThumbIndex(int index) {
        if (index < 0 || index >= this.values.size()) {
            throw new IllegalArgumentException("index out of range");
        }
        this.focusedThumbIdx = index;
        this.accessibilityHelper.requestKeyboardFocusForVirtualView(index);
        postInvalidate();
    }

    /* access modifiers changed from: protected */
    public void setActiveThumbIndex(int index) {
        this.activeThumbIdx = index;
    }

    public int getActiveThumbIndex() {
        return this.activeThumbIdx;
    }

    public void addOnChangeListener(L listener) {
        this.changeListeners.add(listener);
    }

    public void removeOnChangeListener(L listener) {
        this.changeListeners.remove(listener);
    }

    public void clearOnChangeListeners() {
        this.changeListeners.clear();
    }

    public void addOnSliderTouchListener(T listener) {
        this.touchListeners.add(listener);
    }

    public void removeOnSliderTouchListener(T listener) {
        this.touchListeners.remove(listener);
    }

    public void clearOnSliderTouchListeners() {
        this.touchListeners.clear();
    }

    public boolean hasLabelFormatter() {
        return this.formatter != null;
    }

    public void setLabelFormatter(LabelFormatter formatter2) {
        this.formatter = formatter2;
    }

    public float getThumbElevation() {
        return this.thumbDrawable.getElevation();
    }

    public void setThumbElevation(float elevation) {
        this.thumbDrawable.setElevation(elevation);
    }

    public void setThumbElevationResource(int elevation) {
        setThumbElevation(getResources().getDimension(elevation));
    }

    public int getThumbRadius() {
        return this.thumbRadius;
    }

    public void setThumbRadius(int radius) {
        if (radius != this.thumbRadius) {
            this.thumbRadius = radius;
            this.thumbDrawable.setShapeAppearanceModel(ShapeAppearanceModel.builder().setAllCorners(0, (float) this.thumbRadius).build());
            MaterialShapeDrawable materialShapeDrawable = this.thumbDrawable;
            int i = this.thumbRadius;
            materialShapeDrawable.setBounds(0, 0, i * 2, i * 2);
            postInvalidate();
        }
    }

    public void setThumbRadiusResource(int radius) {
        setThumbRadius(getResources().getDimensionPixelSize(radius));
    }

    public int getHaloRadius() {
        return this.haloRadius;
    }

    public void setHaloRadius(int radius) {
        if (radius != this.haloRadius) {
            this.haloRadius = radius;
            Drawable background = getBackground();
            if (shouldDrawCompatHalo() || !(background instanceof RippleDrawable)) {
                postInvalidate();
            } else {
                DrawableUtils.setRippleDrawableRadius((RippleDrawable) background, this.haloRadius);
            }
        }
    }

    public void setHaloRadiusResource(int radius) {
        setHaloRadius(getResources().getDimensionPixelSize(radius));
    }

    public int getLabelBehavior() {
        return this.labelBehavior;
    }

    public void setLabelBehavior(int labelBehavior2) {
        if (this.labelBehavior != labelBehavior2) {
            this.labelBehavior = labelBehavior2;
            requestLayout();
        }
    }

    public int getTrackSidePadding() {
        return this.trackSidePadding;
    }

    public int getTrackWidth() {
        return this.trackWidth;
    }

    public int getTrackHeight() {
        return this.trackHeight;
    }

    public void setTrackHeight(int trackHeight2) {
        if (this.trackHeight != trackHeight2) {
            this.trackHeight = trackHeight2;
            invalidateTrack();
            postInvalidate();
        }
    }

    public ColorStateList getHaloTintList() {
        return this.haloColor;
    }

    public void setHaloTintList(ColorStateList haloColor2) {
        if (!haloColor2.equals(this.haloColor)) {
            this.haloColor = haloColor2;
            Drawable background = getBackground();
            if (shouldDrawCompatHalo() || !(background instanceof RippleDrawable)) {
                this.haloPaint.setColor(getColorForState(haloColor2));
                this.haloPaint.setAlpha(63);
                invalidate();
                return;
            }
            ((RippleDrawable) background).setColor(haloColor2);
        }
    }

    public ColorStateList getThumbTintList() {
        return this.thumbDrawable.getFillColor();
    }

    public void setThumbTintList(ColorStateList thumbColor) {
        this.thumbDrawable.setFillColor(thumbColor);
    }

    public ColorStateList getTickTintList() {
        if (this.tickColorInactive.equals(this.tickColorActive)) {
            return this.tickColorActive;
        }
        throw new IllegalStateException("The inactive and active ticks are different colors. Use the getTickColorInactive() and getTickColorActive() methods instead.");
    }

    public void setTickTintList(ColorStateList tickColor) {
        setTickInactiveTintList(tickColor);
        setTickActiveTintList(tickColor);
    }

    public ColorStateList getTickActiveTintList() {
        return this.tickColorActive;
    }

    public void setTickActiveTintList(ColorStateList tickColor) {
        if (!tickColor.equals(this.tickColorActive)) {
            this.tickColorActive = tickColor;
            this.activeTicksPaint.setColor(getColorForState(tickColor));
            invalidate();
        }
    }

    public ColorStateList getTickInactiveTintList() {
        return this.tickColorInactive;
    }

    public void setTickInactiveTintList(ColorStateList tickColor) {
        if (!tickColor.equals(this.tickColorInactive)) {
            this.tickColorInactive = tickColor;
            this.inactiveTicksPaint.setColor(getColorForState(tickColor));
            invalidate();
        }
    }

    public ColorStateList getTrackTintList() {
        if (this.trackColorInactive.equals(this.trackColorActive)) {
            return this.trackColorActive;
        }
        throw new IllegalStateException("The inactive and active parts of the track are different colors. Use the getInactiveTrackColor() and getActiveTrackColor() methods instead.");
    }

    public void setTrackTintList(ColorStateList trackColor) {
        setTrackInactiveTintList(trackColor);
        setTrackActiveTintList(trackColor);
    }

    public ColorStateList getTrackActiveTintList() {
        return this.trackColorActive;
    }

    public void setTrackActiveTintList(ColorStateList trackColor) {
        if (!trackColor.equals(this.trackColorActive)) {
            this.trackColorActive = trackColor;
            this.activeTrackPaint.setColor(getColorForState(trackColor));
            invalidate();
        }
    }

    public ColorStateList getTrackInactiveTintList() {
        return this.trackColorInactive;
    }

    public void setTrackInactiveTintList(ColorStateList trackColor) {
        if (!trackColor.equals(this.trackColorInactive)) {
            this.trackColorInactive = trackColor;
            this.inactiveTrackPaint.setColor(getColorForState(trackColor));
            invalidate();
        }
    }

    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        setLayerType(enabled ? 0 : 2, (Paint) null);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        for (TooltipDrawable label : this.labels) {
            attachLabelToContentView(label);
        }
    }

    private void attachLabelToContentView(TooltipDrawable label) {
        label.setRelativeToView(ViewUtils.getContentView(this));
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        BaseSlider<S, L, T>.AccessibilityEventSender accessibilityEventSender2 = this.accessibilityEventSender;
        if (accessibilityEventSender2 != null) {
            removeCallbacks(accessibilityEventSender2);
        }
        for (TooltipDrawable label : this.labels) {
            detachLabelFromContentView(label);
        }
        super.onDetachedFromWindow();
    }

    private void detachLabelFromContentView(TooltipDrawable label) {
        ViewOverlayImpl contentViewOverlay = ViewUtils.getContentViewOverlay(this);
        if (contentViewOverlay != null) {
            contentViewOverlay.remove(label);
            label.detachView(ViewUtils.getContentView(this));
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i = this.widgetHeight;
        int i2 = 0;
        if (this.labelBehavior == 1) {
            i2 = this.labels.get(0).getIntrinsicHeight();
        }
        super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(i + i2, BasicMeasure.EXACTLY));
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        this.trackWidth = Math.max(w - (this.trackSidePadding * 2), 0);
        if (this.stepSize > 0.0f) {
            calculateTicksCoordinates();
        }
        updateHaloHotspot();
    }

    private void calculateTicksCoordinates() {
        validateConfigurationIfDirty();
        int tickCount = Math.min((int) (((this.valueTo - this.valueFrom) / this.stepSize) + 1.0f), (this.trackWidth / (this.trackHeight * 2)) + 1);
        float[] fArr = this.ticksCoordinates;
        if (fArr == null || fArr.length != tickCount * 2) {
            this.ticksCoordinates = new float[(tickCount * 2)];
        }
        float interval = ((float) this.trackWidth) / ((float) (tickCount - 1));
        for (int i = 0; i < tickCount * 2; i += 2) {
            float[] fArr2 = this.ticksCoordinates;
            fArr2[i] = ((float) this.trackSidePadding) + (((float) (i / 2)) * interval);
            fArr2[i + 1] = (float) calculateTop();
        }
    }

    /* access modifiers changed from: private */
    public void updateHaloHotspot() {
        if (!shouldDrawCompatHalo() && getMeasuredWidth() > 0) {
            Drawable background = getBackground();
            if (background instanceof RippleDrawable) {
                int x = (int) ((normalizeValue(this.values.get(this.focusedThumbIdx).floatValue()) * ((float) this.trackWidth)) + ((float) this.trackSidePadding));
                int y = calculateTop();
                int i = this.haloRadius;
                DrawableCompat.setHotspotBounds(background, x - i, y - i, x + i, i + y);
            }
        }
    }

    private int calculateTop() {
        int i = this.trackTop;
        int i2 = 0;
        if (this.labelBehavior == 1) {
            i2 = this.labels.get(0).getIntrinsicHeight();
        }
        return i + i2;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.dirtyConfig) {
            validateConfigurationIfDirty();
            if (this.stepSize > 0.0f) {
                calculateTicksCoordinates();
            }
        }
        super.onDraw(canvas);
        int top = calculateTop();
        drawInactiveTrack(canvas, this.trackWidth, top);
        if (((Float) Collections.max(getValues())).floatValue() > this.valueFrom) {
            drawActiveTrack(canvas, this.trackWidth, top);
        }
        if (this.stepSize > 0.0f) {
            drawTicks(canvas);
        }
        if ((this.thumbIsPressed || isFocused()) && isEnabled()) {
            maybeDrawHalo(canvas, this.trackWidth, top);
            if (this.activeThumbIdx != -1) {
                ensureLabels();
            }
        }
        drawThumbs(canvas, this.trackWidth, top);
    }

    private float[] getActiveRange() {
        float max = ((Float) Collections.max(getValues())).floatValue();
        float left = normalizeValue(this.values.size() == 1 ? this.valueFrom : ((Float) Collections.min(getValues())).floatValue());
        float right = normalizeValue(max);
        if (isRtl()) {
            return new float[]{right, left};
        }
        return new float[]{left, right};
    }

    private void drawInactiveTrack(Canvas canvas, int width, int top) {
        float[] activeRange = getActiveRange();
        int i = this.trackSidePadding;
        float right = ((float) i) + (activeRange[1] * ((float) width));
        if (right < ((float) (i + width))) {
            canvas.drawLine(right, (float) top, (float) (i + width), (float) top, this.inactiveTrackPaint);
        }
        int i2 = this.trackSidePadding;
        float left = ((float) i2) + (activeRange[0] * ((float) width));
        if (left > ((float) i2)) {
            canvas.drawLine((float) i2, (float) top, left, (float) top, this.inactiveTrackPaint);
        }
    }

    private float normalizeValue(float value) {
        float f = this.valueFrom;
        float normalized = (value - f) / (this.valueTo - f);
        if (isRtl()) {
            return 1.0f - normalized;
        }
        return normalized;
    }

    private void drawActiveTrack(Canvas canvas, int width, int top) {
        float[] activeRange = getActiveRange();
        int i = this.trackSidePadding;
        float right = ((float) i) + (activeRange[1] * ((float) width));
        canvas.drawLine(((float) i) + (activeRange[0] * ((float) width)), (float) top, right, (float) top, this.activeTrackPaint);
    }

    private void drawTicks(Canvas canvas) {
        float[] activeRange = getActiveRange();
        int leftPivotIndex = pivotIndex(this.ticksCoordinates, activeRange[0]);
        int rightPivotIndex = pivotIndex(this.ticksCoordinates, activeRange[1]);
        canvas.drawPoints(this.ticksCoordinates, 0, leftPivotIndex * 2, this.inactiveTicksPaint);
        canvas.drawPoints(this.ticksCoordinates, leftPivotIndex * 2, (rightPivotIndex * 2) - (leftPivotIndex * 2), this.activeTicksPaint);
        float[] fArr = this.ticksCoordinates;
        canvas.drawPoints(fArr, rightPivotIndex * 2, fArr.length - (rightPivotIndex * 2), this.inactiveTicksPaint);
    }

    private void drawThumbs(Canvas canvas, int width, int top) {
        if (!isEnabled()) {
            Iterator<Float> it = this.values.iterator();
            while (it.hasNext()) {
                canvas.drawCircle(((float) this.trackSidePadding) + (normalizeValue(it.next().floatValue()) * ((float) width)), (float) top, (float) this.thumbRadius, this.thumbPaint);
            }
        }
        Iterator<Float> it2 = this.values.iterator();
        while (it2.hasNext()) {
            canvas.save();
            int normalizeValue = this.trackSidePadding + ((int) (normalizeValue(it2.next().floatValue()) * ((float) width)));
            int i = this.thumbRadius;
            canvas.translate((float) (normalizeValue - i), (float) (top - i));
            this.thumbDrawable.draw(canvas);
            canvas.restore();
        }
    }

    private void maybeDrawHalo(Canvas canvas, int width, int top) {
        if (shouldDrawCompatHalo()) {
            int centerX = (int) (((float) this.trackSidePadding) + (normalizeValue(this.values.get(this.focusedThumbIdx).floatValue()) * ((float) width)));
            if (Build.VERSION.SDK_INT < 28) {
                int i = this.haloRadius;
                canvas.clipRect((float) (centerX - i), (float) (top - i), (float) (centerX + i), (float) (i + top), Region.Op.UNION);
            }
            canvas.drawCircle((float) centerX, (float) top, (float) this.haloRadius, this.haloPaint);
        }
    }

    private boolean shouldDrawCompatHalo() {
        return this.forceDrawCompatHalo || Build.VERSION.SDK_INT < 21 || !(getBackground() instanceof RippleDrawable);
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (!isEnabled()) {
            return false;
        }
        float x = event.getX();
        float f = (x - ((float) this.trackSidePadding)) / ((float) this.trackWidth);
        this.touchPosition = f;
        float max = Math.max(0.0f, f);
        this.touchPosition = max;
        this.touchPosition = Math.min(1.0f, max);
        int actionMasked = event.getActionMasked();
        if (actionMasked == 0) {
            this.touchDownX = x;
            if (!isInScrollingContainer()) {
                getParent().requestDisallowInterceptTouchEvent(true);
                if (pickActiveThumb()) {
                    requestFocus();
                    this.thumbIsPressed = true;
                    snapTouchPosition();
                    updateHaloHotspot();
                    invalidate();
                    onStartTrackingTouch();
                }
            }
        } else if (actionMasked == 1) {
            this.thumbIsPressed = false;
            MotionEvent motionEvent = this.lastEvent;
            if (motionEvent != null && motionEvent.getActionMasked() == 0 && Math.abs(this.lastEvent.getX() - event.getX()) <= ((float) this.scaledTouchSlop) && Math.abs(this.lastEvent.getY() - event.getY()) <= ((float) this.scaledTouchSlop)) {
                pickActiveThumb();
            }
            if (this.activeThumbIdx != -1) {
                snapTouchPosition();
                this.activeThumbIdx = -1;
            }
            for (TooltipDrawable label : this.labels) {
                ViewUtils.getContentViewOverlay(this).remove(label);
            }
            onStopTrackingTouch();
            invalidate();
        } else if (actionMasked == 2) {
            if (!this.thumbIsPressed) {
                if (Math.abs(x - this.touchDownX) < ((float) this.scaledTouchSlop)) {
                    return false;
                }
                getParent().requestDisallowInterceptTouchEvent(true);
                onStartTrackingTouch();
            }
            if (pickActiveThumb()) {
                this.thumbIsPressed = true;
                snapTouchPosition();
                updateHaloHotspot();
                invalidate();
            }
        }
        setPressed(this.thumbIsPressed);
        this.lastEvent = MotionEvent.obtain(event);
        return true;
    }

    private static int pivotIndex(float[] coordinates, float position) {
        return Math.round(((float) ((coordinates.length / 2) - 1)) * position);
    }

    private double snapPosition(float position) {
        float f = this.stepSize;
        if (f <= 0.0f) {
            return (double) position;
        }
        int stepCount = (int) ((this.valueTo - this.valueFrom) / f);
        double round = (double) Math.round(((float) stepCount) * position);
        double d = (double) stepCount;
        Double.isNaN(round);
        Double.isNaN(d);
        return round / d;
    }

    /* access modifiers changed from: protected */
    public boolean pickActiveThumb() {
        if (this.activeThumbIdx != -1) {
            return true;
        }
        float touchValue = getValueOfTouchPositionAbsolute();
        float touchX = valueToX(touchValue);
        this.activeThumbIdx = 0;
        float activeThumbDiff = Math.abs(this.values.get(0).floatValue() - touchValue);
        for (int i = 1; i < this.values.size(); i++) {
            float valueDiff = Math.abs(this.values.get(i).floatValue() - touchValue);
            float valueX = valueToX(this.values.get(i).floatValue());
            if (Float.compare(valueDiff, activeThumbDiff) > 1) {
                break;
            }
            boolean movingForward = !isRtl() ? valueX - touchX < 0.0f : valueX - touchX > 0.0f;
            if (Float.compare(valueDiff, activeThumbDiff) < 0) {
                activeThumbDiff = valueDiff;
                this.activeThumbIdx = i;
            } else if (Float.compare(valueDiff, activeThumbDiff) != 0) {
                continue;
            } else if (Math.abs(valueX - touchX) < ((float) this.scaledTouchSlop)) {
                this.activeThumbIdx = -1;
                return false;
            } else if (movingForward) {
                activeThumbDiff = valueDiff;
                this.activeThumbIdx = i;
            }
        }
        if (this.activeThumbIdx != -1) {
            return true;
        }
        return false;
    }

    private float getValueOfTouchPositionAbsolute() {
        float position = this.touchPosition;
        if (isRtl()) {
            position = 1.0f - position;
        }
        float f = this.valueTo;
        float f2 = this.valueFrom;
        return ((f - f2) * position) + f2;
    }

    private boolean snapTouchPosition() {
        return snapActiveThumbToValue(getValueOfTouchPosition());
    }

    private boolean snapActiveThumbToValue(float value) {
        return snapThumbToValue(this.activeThumbIdx, value);
    }

    /* access modifiers changed from: private */
    public boolean snapThumbToValue(int idx, float value) {
        if (((double) Math.abs(value - this.values.get(idx).floatValue())) < THRESHOLD) {
            return false;
        }
        this.values.set(idx, Float.valueOf(getClampedValue(idx, value)));
        this.focusedThumbIdx = idx;
        dispatchOnChangedFromUser(idx);
        return true;
    }

    private float getClampedValue(int idx, float value) {
        return MathUtils.clamp(value, idx + -1 < 0 ? this.valueFrom : this.values.get(idx - 1).floatValue(), idx + 1 >= this.values.size() ? this.valueTo : this.values.get(idx + 1).floatValue());
    }

    private float getValueOfTouchPosition() {
        double position = snapPosition(this.touchPosition);
        if (isRtl()) {
            position = 1.0d - position;
        }
        float f = this.valueTo;
        float f2 = this.valueFrom;
        double d = (double) (f - f2);
        Double.isNaN(d);
        double d2 = (double) f2;
        Double.isNaN(d2);
        return (float) ((d * position) + d2);
    }

    private float valueToX(float value) {
        return (normalizeValue(value) * ((float) this.trackWidth)) + ((float) this.trackSidePadding);
    }

    private void ensureLabels() {
        if (this.labelBehavior != 2) {
            Iterator<TooltipDrawable> labelItr = this.labels.iterator();
            for (int i = 0; i < this.values.size() && labelItr.hasNext(); i++) {
                if (i != this.focusedThumbIdx) {
                    setValueForLabel(labelItr.next(), this.values.get(i).floatValue());
                }
            }
            if (labelItr.hasNext() != 0) {
                setValueForLabel(labelItr.next(), this.values.get(this.focusedThumbIdx).floatValue());
            } else {
                throw new IllegalStateException(String.format("Not enough labels(%d) to display all the values(%d)", new Object[]{Integer.valueOf(this.labels.size()), Integer.valueOf(this.values.size())}));
            }
        }
    }

    /* access modifiers changed from: private */
    public String formatValue(float value) {
        if (hasLabelFormatter()) {
            return this.formatter.getFormattedValue(value);
        }
        return String.format(((float) ((int) value)) == value ? "%.0f" : "%.2f", new Object[]{Float.valueOf(value)});
    }

    private void setValueForLabel(TooltipDrawable label, float value) {
        label.setText(formatValue(value));
        int left = (this.trackSidePadding + ((int) (normalizeValue(value) * ((float) this.trackWidth)))) - (label.getIntrinsicWidth() / 2);
        int top = calculateTop() - (this.labelPadding + this.thumbRadius);
        label.setBounds(left, top - label.getIntrinsicHeight(), label.getIntrinsicWidth() + left, top);
        Rect rect = new Rect(label.getBounds());
        DescendantOffsetUtils.offsetDescendantRect(ViewUtils.getContentView(this), this, rect);
        label.setBounds(rect);
        ViewUtils.getContentViewOverlay(this).add(label);
    }

    private void invalidateTrack() {
        this.inactiveTrackPaint.setStrokeWidth((float) this.trackHeight);
        this.activeTrackPaint.setStrokeWidth((float) this.trackHeight);
        this.inactiveTicksPaint.setStrokeWidth(((float) this.trackHeight) / 2.0f);
        this.activeTicksPaint.setStrokeWidth(((float) this.trackHeight) / 2.0f);
    }

    private boolean isInScrollingContainer() {
        for (ViewParent p = getParent(); p instanceof ViewGroup; p = p.getParent()) {
            if (((ViewGroup) p).shouldDelayChildPressedState()) {
                return true;
            }
        }
        return false;
    }

    private void dispatchOnChangedProgramatically() {
        for (L listener : this.changeListeners) {
            Iterator<Float> it = this.values.iterator();
            while (it.hasNext()) {
                listener.onValueChange(this, it.next().floatValue(), false);
            }
        }
    }

    private void dispatchOnChangedFromUser(int idx) {
        for (L listener : this.changeListeners) {
            listener.onValueChange(this, this.values.get(idx).floatValue(), true);
        }
        AccessibilityManager accessibilityManager2 = this.accessibilityManager;
        if (accessibilityManager2 != null && accessibilityManager2.isEnabled()) {
            scheduleAccessibilityEventSender(idx);
        }
    }

    private void onStartTrackingTouch() {
        for (T listener : this.touchListeners) {
            listener.onStartTrackingTouch(this);
        }
    }

    private void onStopTrackingTouch() {
        for (T listener : this.touchListeners) {
            listener.onStopTrackingTouch(this);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        this.inactiveTrackPaint.setColor(getColorForState(this.trackColorInactive));
        this.activeTrackPaint.setColor(getColorForState(this.trackColorActive));
        this.inactiveTicksPaint.setColor(getColorForState(this.tickColorInactive));
        this.activeTicksPaint.setColor(getColorForState(this.tickColorActive));
        for (TooltipDrawable label : this.labels) {
            if (label.isStateful()) {
                label.setState(getDrawableState());
            }
        }
        if (this.thumbDrawable.isStateful()) {
            this.thumbDrawable.setState(getDrawableState());
        }
        this.haloPaint.setColor(getColorForState(this.haloColor));
        this.haloPaint.setAlpha(63);
    }

    private int getColorForState(ColorStateList colorStateList) {
        return colorStateList.getColorForState(getDrawableState(), colorStateList.getDefaultColor());
    }

    /* access modifiers changed from: package-private */
    public void forceDrawCompatHalo(boolean force) {
        this.forceDrawCompatHalo = force;
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (!isEnabled()) {
            return super.onKeyDown(keyCode, event);
        }
        if (this.values.size() == 1) {
            this.activeThumbIdx = 0;
        }
        if (this.activeThumbIdx == -1) {
            Boolean handled = onKeyDownNoActiveThumb(keyCode, event);
            return handled != null ? handled.booleanValue() : super.onKeyDown(keyCode, event);
        }
        this.isLongPress |= event.isLongPress();
        Float increment = calculateIncrementForKey(keyCode);
        if (increment != null) {
            if (snapActiveThumbToValue(this.values.get(this.activeThumbIdx).floatValue() + increment.floatValue())) {
                updateHaloHotspot();
                postInvalidate();
            }
            return true;
        }
        if (keyCode != 23) {
            if (keyCode != 61) {
                if (keyCode != 66) {
                    return super.onKeyDown(keyCode, event);
                }
            } else if (event.hasNoModifiers()) {
                return moveFocus(1);
            } else {
                if (event.isShiftPressed()) {
                    return moveFocus(-1);
                }
                return false;
            }
        }
        this.activeThumbIdx = -1;
        for (TooltipDrawable label : this.labels) {
            ViewUtils.getContentViewOverlay(this).remove(label);
        }
        postInvalidate();
        return true;
    }

    private Boolean onKeyDownNoActiveThumb(int keyCode, KeyEvent event) {
        if (keyCode != 61) {
            if (keyCode != 66) {
                if (keyCode != 81) {
                    if (keyCode == 69) {
                        moveFocus(-1);
                        return true;
                    } else if (keyCode != 70) {
                        switch (keyCode) {
                            case 21:
                                moveFocusInAbsoluteDirection(-1);
                                return true;
                            case 22:
                                moveFocusInAbsoluteDirection(1);
                                return true;
                            case 23:
                                break;
                            default:
                                return null;
                        }
                    }
                }
                moveFocus(1);
                return true;
            }
            this.activeThumbIdx = this.focusedThumbIdx;
            postInvalidate();
            return true;
        } else if (event.hasNoModifiers()) {
            return Boolean.valueOf(moveFocus(1));
        } else {
            if (event.isShiftPressed()) {
                return Boolean.valueOf(moveFocus(-1));
            }
            return false;
        }
    }

    public boolean onKeyUp(int keyCode, KeyEvent event) {
        this.isLongPress = false;
        return super.onKeyUp(keyCode, event);
    }

    /* access modifiers changed from: package-private */
    public final boolean isRtl() {
        return ViewCompat.getLayoutDirection(this) == 1;
    }

    private boolean moveFocus(int direction) {
        int oldFocusedThumbIdx = this.focusedThumbIdx;
        int clamp = (int) MathUtils.clamp(((long) oldFocusedThumbIdx) + ((long) direction), 0, (long) (this.values.size() - 1));
        this.focusedThumbIdx = clamp;
        if (clamp == oldFocusedThumbIdx) {
            return false;
        }
        if (this.activeThumbIdx != -1) {
            this.activeThumbIdx = clamp;
        }
        updateHaloHotspot();
        postInvalidate();
        return true;
    }

    private boolean moveFocusInAbsoluteDirection(int direction) {
        if (isRtl()) {
            direction = direction == Integer.MIN_VALUE ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : -direction;
        }
        return moveFocus(direction);
    }

    private Float calculateIncrementForKey(int keyCode) {
        float increment = this.isLongPress ? calculateStepIncrement(20) : calculateStepIncrement();
        if (keyCode == 21) {
            return Float.valueOf(isRtl() ? increment : -increment);
        } else if (keyCode == 22) {
            return Float.valueOf(isRtl() ? -increment : increment);
        } else if (keyCode == 69) {
            return Float.valueOf(-increment);
        } else {
            if (keyCode == 70 || keyCode == 81) {
                return Float.valueOf(increment);
            }
            return null;
        }
    }

    private float calculateStepIncrement() {
        float f = this.stepSize;
        if (f == 0.0f) {
            return 1.0f;
        }
        return f;
    }

    /* access modifiers changed from: private */
    public float calculateStepIncrement(int stepFactor) {
        float increment = calculateStepIncrement();
        float numSteps = (this.valueTo - this.valueFrom) / increment;
        if (numSteps <= ((float) stepFactor)) {
            return increment;
        }
        return ((float) Math.round(numSteps / ((float) stepFactor))) * increment;
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        if (!gainFocus) {
            this.activeThumbIdx = -1;
            for (TooltipDrawable label : this.labels) {
                ViewUtils.getContentViewOverlay(this).remove(label);
            }
            this.accessibilityHelper.clearKeyboardFocusForVirtualView(this.focusedThumbIdx);
            return;
        }
        focusThumbOnFocusGained(direction);
        this.accessibilityHelper.requestKeyboardFocusForVirtualView(this.focusedThumbIdx);
    }

    private void focusThumbOnFocusGained(int direction) {
        if (direction == 1) {
            moveFocus(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        } else if (direction == 2) {
            moveFocus(Integer.MIN_VALUE);
        } else if (direction == 17) {
            moveFocusInAbsoluteDirection(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        } else if (direction == 66) {
            moveFocusInAbsoluteDirection(Integer.MIN_VALUE);
        }
    }

    /* access modifiers changed from: package-private */
    public final int getAccessibilityFocusedVirtualViewId() {
        return this.accessibilityHelper.getAccessibilityFocusedVirtualViewId();
    }

    public CharSequence getAccessibilityClassName() {
        return SeekBar.class.getName();
    }

    public boolean dispatchHoverEvent(MotionEvent event) {
        return this.accessibilityHelper.dispatchHoverEvent(event) || super.dispatchHoverEvent(event);
    }

    public boolean dispatchKeyEvent(KeyEvent event) {
        return super.dispatchKeyEvent(event);
    }

    private void scheduleAccessibilityEventSender(int idx) {
        BaseSlider<S, L, T>.AccessibilityEventSender accessibilityEventSender2 = this.accessibilityEventSender;
        if (accessibilityEventSender2 == null) {
            this.accessibilityEventSender = new AccessibilityEventSender();
        } else {
            removeCallbacks(accessibilityEventSender2);
        }
        this.accessibilityEventSender.setVirtualViewId(idx);
        postDelayed(this.accessibilityEventSender, 200);
    }

    private class AccessibilityEventSender implements Runnable {
        int virtualViewId;

        private AccessibilityEventSender() {
            this.virtualViewId = -1;
        }

        /* access modifiers changed from: package-private */
        public void setVirtualViewId(int virtualViewId2) {
            this.virtualViewId = virtualViewId2;
        }

        public void run() {
            BaseSlider.this.accessibilityHelper.sendEventForVirtualView(this.virtualViewId, 4);
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SliderState sliderState = new SliderState(super.onSaveInstanceState());
        sliderState.valueFrom = this.valueFrom;
        sliderState.valueTo = this.valueTo;
        sliderState.values = new ArrayList<>(this.values);
        sliderState.stepSize = this.stepSize;
        sliderState.hasFocus = hasFocus();
        return sliderState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable state) {
        SliderState sliderState = (SliderState) state;
        super.onRestoreInstanceState(sliderState.getSuperState());
        this.valueFrom = sliderState.valueFrom;
        this.valueTo = sliderState.valueTo;
        setValuesInternal(sliderState.values);
        this.stepSize = sliderState.stepSize;
        if (sliderState.hasFocus) {
            requestFocus();
        }
        dispatchOnChangedProgramatically();
    }

    static class SliderState extends View.BaseSavedState {
        public static final Parcelable.Creator<SliderState> CREATOR = new Parcelable.Creator<SliderState>() {
            public SliderState createFromParcel(Parcel source) {
                return new SliderState(source);
            }

            public SliderState[] newArray(int size) {
                return new SliderState[size];
            }
        };
        boolean hasFocus;
        float stepSize;
        float valueFrom;
        float valueTo;
        ArrayList<Float> values;

        SliderState(Parcelable superState) {
            super(superState);
        }

        private SliderState(Parcel source) {
            super(source);
            this.valueFrom = source.readFloat();
            this.valueTo = source.readFloat();
            ArrayList<Float> arrayList = new ArrayList<>();
            this.values = arrayList;
            source.readList(arrayList, Float.class.getClassLoader());
            this.stepSize = source.readFloat();
            this.hasFocus = source.createBooleanArray()[0];
        }

        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeFloat(this.valueFrom);
            dest.writeFloat(this.valueTo);
            dest.writeList(this.values);
            dest.writeFloat(this.stepSize);
            dest.writeBooleanArray(new boolean[]{this.hasFocus});
        }
    }

    /* access modifiers changed from: package-private */
    public void updateBoundsForVirturalViewId(int virtualViewId, Rect virtualViewBounds) {
        int x = this.trackSidePadding + ((int) (normalizeValue(getValues().get(virtualViewId).floatValue()) * ((float) this.trackWidth)));
        int y = calculateTop();
        int i = this.thumbRadius;
        virtualViewBounds.set(x - i, y - i, x + i, i + y);
    }

    private static class AccessibilityHelper extends ExploreByTouchHelper {
        private final BaseSlider<?, ?, ?> slider;
        Rect virtualViewBounds = new Rect();

        AccessibilityHelper(BaseSlider<?, ?, ?> slider2) {
            super(slider2);
            this.slider = slider2;
        }

        /* access modifiers changed from: protected */
        public int getVirtualViewAt(float x, float y) {
            for (int i = 0; i < this.slider.getValues().size(); i++) {
                this.slider.updateBoundsForVirturalViewId(i, this.virtualViewBounds);
                if (this.virtualViewBounds.contains((int) x, (int) y)) {
                    return i;
                }
            }
            return -1;
        }

        /* access modifiers changed from: protected */
        public void getVisibleVirtualViews(List<Integer> virtualViewIds) {
            for (int i = 0; i < this.slider.getValues().size(); i++) {
                virtualViewIds.add(Integer.valueOf(i));
            }
        }

        /* access modifiers changed from: protected */
        public void onPopulateNodeForVirtualView(int virtualViewId, AccessibilityNodeInfoCompat info) {
            info.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SET_PROGRESS);
            List<Float> values = this.slider.getValues();
            float value = values.get(virtualViewId).floatValue();
            float valueFrom = this.slider.getValueFrom();
            float valueTo = this.slider.getValueTo();
            if (this.slider.isEnabled()) {
                if (value > valueFrom) {
                    info.addAction(8192);
                }
                if (value < valueTo) {
                    info.addAction(4096);
                }
            }
            info.setRangeInfo(AccessibilityNodeInfoCompat.RangeInfoCompat.obtain(1, valueFrom, valueTo, value));
            info.setClassName(SeekBar.class.getName());
            StringBuilder contentDescription = new StringBuilder();
            if (this.slider.getContentDescription() != null) {
                contentDescription.append(this.slider.getContentDescription());
                contentDescription.append(",");
            }
            if (values.size() > 1) {
                contentDescription.append(startOrEndDescription(virtualViewId));
                contentDescription.append(this.slider.formatValue(value));
            }
            info.setContentDescription(contentDescription.toString());
            this.slider.updateBoundsForVirturalViewId(virtualViewId, this.virtualViewBounds);
            info.setBoundsInParent(this.virtualViewBounds);
        }

        private String startOrEndDescription(int virtualViewId) {
            if (virtualViewId == this.slider.getValues().size() - 1) {
                return this.slider.getContext().getString(R.string.material_slider_range_end);
            }
            if (virtualViewId == 0) {
                return this.slider.getContext().getString(R.string.material_slider_range_start);
            }
            return "";
        }

        /* access modifiers changed from: protected */
        public boolean onPerformActionForVirtualView(int virtualViewId, int action, Bundle arguments) {
            if (!this.slider.isEnabled()) {
                return false;
            }
            if (action == 4096 || action == 8192) {
                float increment = this.slider.calculateStepIncrement(20);
                if (action == 8192) {
                    increment = -increment;
                }
                if (this.slider.isRtl()) {
                    increment = -increment;
                }
                if (!this.slider.snapThumbToValue(virtualViewId, MathUtils.clamp(this.slider.getValues().get(virtualViewId).floatValue() + increment, this.slider.getValueFrom(), this.slider.getValueTo()))) {
                    return false;
                }
                this.slider.updateHaloHotspot();
                this.slider.postInvalidate();
                invalidateVirtualView(virtualViewId);
                return true;
            } else if (action != 16908349 || arguments == null || !arguments.containsKey(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE)) {
                return false;
            } else {
                if (!this.slider.snapThumbToValue(virtualViewId, arguments.getFloat(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE))) {
                    return false;
                }
                this.slider.updateHaloHotspot();
                this.slider.postInvalidate();
                invalidateVirtualView(virtualViewId);
                return true;
            }
        }
    }
}
