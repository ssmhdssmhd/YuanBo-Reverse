package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.accessibility.CaptioningManager;
import android.widget.FrameLayout;
import i2.c1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import u1.b;

/* loaded from: classes.dex */
public final class SubtitleView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private List<u1.b> f2087a;

    /* renamed from: b, reason: collision with root package name */
    private f2.a f2088b;

    /* renamed from: c, reason: collision with root package name */
    private int f2089c;

    /* renamed from: d, reason: collision with root package name */
    private float f2090d;

    /* renamed from: e, reason: collision with root package name */
    private float f2091e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f2092f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f2093g;

    /* renamed from: h, reason: collision with root package name */
    private int f2094h;

    /* renamed from: i, reason: collision with root package name */
    private a f2095i;

    /* renamed from: j, reason: collision with root package name */
    private View f2096j;

    interface a {
        void a(List<u1.b> list, f2.a aVar, float f6, int i6, float f7);
    }

    public SubtitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2087a = Collections.emptyList();
        this.f2088b = f2.a.f3787g;
        this.f2089c = 0;
        this.f2090d = 0.0533f;
        this.f2091e = 0.08f;
        this.f2092f = true;
        this.f2093g = true;
        com.google.android.exoplayer2.ui.a aVar = new com.google.android.exoplayer2.ui.a(context);
        this.f2095i = aVar;
        this.f2096j = aVar;
        addView(aVar);
        this.f2094h = 1;
    }

    private u1.b a(u1.b bVar) {
        b.C0148b b6 = bVar.b();
        if (!this.f2092f) {
            i.e(b6);
        } else if (!this.f2093g) {
            i.f(b6);
        }
        return b6.a();
    }

    private void c(int i6, float f6) {
        this.f2089c = i6;
        this.f2090d = f6;
        d();
    }

    private void d() {
        this.f2095i.a(getCuesWithStylingPreferencesApplied(), this.f2088b, this.f2090d, this.f2089c, this.f2091e);
    }

    private List<u1.b> getCuesWithStylingPreferencesApplied() {
        if (this.f2092f && this.f2093g) {
            return this.f2087a;
        }
        ArrayList arrayList = new ArrayList(this.f2087a.size());
        for (int i6 = 0; i6 < this.f2087a.size(); i6++) {
            arrayList.add(a(this.f2087a.get(i6)));
        }
        return arrayList;
    }

    private float getUserCaptionFontScale() {
        CaptioningManager captioningManager;
        if (c1.f5548a < 19 || isInEditMode() || (captioningManager = (CaptioningManager) getContext().getSystemService("captioning")) == null || !captioningManager.isEnabled()) {
            return 1.0f;
        }
        return captioningManager.getFontScale();
    }

    private f2.a getUserCaptionStyle() {
        if (c1.f5548a < 19 || isInEditMode()) {
            return f2.a.f3787g;
        }
        CaptioningManager captioningManager = (CaptioningManager) getContext().getSystemService("captioning");
        return (captioningManager == null || !captioningManager.isEnabled()) ? f2.a.f3787g : f2.a.a(captioningManager.getUserStyle());
    }

    private <T extends View & a> void setView(T t5) {
        removeView(this.f2096j);
        View view = this.f2096j;
        if (view instanceof j) {
            ((j) view).g();
        }
        this.f2096j = t5;
        this.f2095i = t5;
        addView(t5);
    }

    public void b(float f6, boolean z5) {
        c(z5 ? 1 : 0, f6);
    }

    public void setApplyEmbeddedFontSizes(boolean z5) {
        this.f2093g = z5;
        d();
    }

    public void setApplyEmbeddedStyles(boolean z5) {
        this.f2092f = z5;
        d();
    }

    public void setBottomPaddingFraction(float f6) {
        this.f2091e = f6;
        d();
    }

    public void setCues(List<u1.b> list) {
        if (list == null) {
            list = Collections.emptyList();
        }
        this.f2087a = list;
        d();
    }

    public void setFractionalTextSize(float f6) {
        b(f6, false);
    }

    public void setStyle(f2.a aVar) {
        this.f2088b = aVar;
        d();
    }

    public void setViewType(int i6) {
        KeyEvent.Callback aVar;
        if (this.f2094h == i6) {
            return;
        }
        if (i6 == 1) {
            aVar = new com.google.android.exoplayer2.ui.a(getContext());
        } else {
            if (i6 != 2) {
                throw new IllegalArgumentException();
            }
            aVar = new j(getContext());
        }
        setView(aVar);
        this.f2094h = i6;
    }
}
