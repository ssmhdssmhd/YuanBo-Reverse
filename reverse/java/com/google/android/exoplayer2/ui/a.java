package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.exoplayer2.ui.SubtitleView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import u1.b;

/* loaded from: classes.dex */
final class a extends View implements SubtitleView.a {

    /* renamed from: a, reason: collision with root package name */
    private final List<f> f2113a;

    /* renamed from: b, reason: collision with root package name */
    private List<u1.b> f2114b;

    /* renamed from: c, reason: collision with root package name */
    private int f2115c;

    /* renamed from: d, reason: collision with root package name */
    private float f2116d;

    /* renamed from: e, reason: collision with root package name */
    private f2.a f2117e;

    /* renamed from: f, reason: collision with root package name */
    private float f2118f;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2113a = new ArrayList();
        this.f2114b = Collections.emptyList();
        this.f2115c = 0;
        this.f2116d = 0.0533f;
        this.f2117e = f2.a.f3787g;
        this.f2118f = 0.08f;
    }

    private static u1.b b(u1.b bVar) {
        b.C0148b p6 = bVar.b().k(-3.4028235E38f).l(Integer.MIN_VALUE).p(null);
        if (bVar.f9609j == 0) {
            p6.h(1.0f - bVar.f9608e, 0);
        } else {
            p6.h((-bVar.f9608e) - 1.0f, 1);
        }
        int i6 = bVar.f9610k;
        if (i6 == 0) {
            p6.i(2);
        } else if (i6 == 2) {
            p6.i(0);
        }
        return p6.a();
    }

    @Override // com.google.android.exoplayer2.ui.SubtitleView.a
    public void a(List<u1.b> list, f2.a aVar, float f6, int i6, float f7) {
        this.f2114b = list;
        this.f2117e = aVar;
        this.f2116d = f6;
        this.f2115c = i6;
        this.f2118f = f7;
        while (this.f2113a.size() < list.size()) {
            this.f2113a.add(new f(getContext()));
        }
        invalidate();
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
        List<u1.b> list = this.f2114b;
        if (list.isEmpty()) {
            return;
        }
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int paddingBottom = height - getPaddingBottom();
        if (paddingBottom <= paddingTop || width <= paddingLeft) {
            return;
        }
        int i6 = paddingBottom - paddingTop;
        float h6 = i.h(this.f2115c, this.f2116d, height, i6);
        if (h6 <= 0.0f) {
            return;
        }
        int size = list.size();
        int i7 = 0;
        while (i7 < size) {
            u1.b bVar = list.get(i7);
            if (bVar.f9619t != Integer.MIN_VALUE) {
                bVar = b(bVar);
            }
            u1.b bVar2 = bVar;
            int i8 = paddingBottom;
            this.f2113a.get(i7).b(bVar2, this.f2117e, h6, i.h(bVar2.f9617r, bVar2.f9618s, height, i6), this.f2118f, canvas, paddingLeft, paddingTop, width, i8);
            i7++;
            size = size;
            i6 = i6;
            paddingBottom = i8;
            width = width;
        }
    }
}
