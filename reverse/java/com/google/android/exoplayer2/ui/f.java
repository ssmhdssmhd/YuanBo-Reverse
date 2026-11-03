package com.google.android.exoplayer2.ui;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import i2.c1;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* loaded from: classes.dex */
final class f {
    private int A;
    private int B;
    private int C;
    private int D;
    private StaticLayout E;
    private StaticLayout F;
    private int G;
    private int H;
    private int I;
    private Rect J;

    /* renamed from: a, reason: collision with root package name */
    private final float f2130a;

    /* renamed from: b, reason: collision with root package name */
    private final float f2131b;

    /* renamed from: c, reason: collision with root package name */
    private final float f2132c;

    /* renamed from: d, reason: collision with root package name */
    private final float f2133d;

    /* renamed from: e, reason: collision with root package name */
    private final float f2134e;

    /* renamed from: f, reason: collision with root package name */
    private final TextPaint f2135f;

    /* renamed from: g, reason: collision with root package name */
    private final Paint f2136g;

    /* renamed from: h, reason: collision with root package name */
    private final Paint f2137h;

    /* renamed from: i, reason: collision with root package name */
    private CharSequence f2138i;

    /* renamed from: j, reason: collision with root package name */
    private Layout.Alignment f2139j;

    /* renamed from: k, reason: collision with root package name */
    private Bitmap f2140k;

    /* renamed from: l, reason: collision with root package name */
    private float f2141l;

    /* renamed from: m, reason: collision with root package name */
    private int f2142m;

    /* renamed from: n, reason: collision with root package name */
    private int f2143n;

    /* renamed from: o, reason: collision with root package name */
    private float f2144o;

    /* renamed from: p, reason: collision with root package name */
    private int f2145p;

    /* renamed from: q, reason: collision with root package name */
    private float f2146q;

    /* renamed from: r, reason: collision with root package name */
    private float f2147r;

    /* renamed from: s, reason: collision with root package name */
    private int f2148s;

    /* renamed from: t, reason: collision with root package name */
    private int f2149t;

    /* renamed from: u, reason: collision with root package name */
    private int f2150u;

    /* renamed from: v, reason: collision with root package name */
    private int f2151v;

    /* renamed from: w, reason: collision with root package name */
    private int f2152w;

    /* renamed from: x, reason: collision with root package name */
    private float f2153x;

    /* renamed from: y, reason: collision with root package name */
    private float f2154y;

    /* renamed from: z, reason: collision with root package name */
    private float f2155z;

    public f(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, new int[]{R.attr.lineSpacingExtra, R.attr.lineSpacingMultiplier}, 0, 0);
        this.f2134e = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f2133d = obtainStyledAttributes.getFloat(1, 1.0f);
        obtainStyledAttributes.recycle();
        float round = Math.round((context.getResources().getDisplayMetrics().densityDpi * 2.0f) / 160.0f);
        this.f2130a = round;
        this.f2131b = round;
        this.f2132c = round;
        TextPaint textPaint = new TextPaint();
        this.f2135f = textPaint;
        textPaint.setAntiAlias(true);
        textPaint.setSubpixelText(true);
        Paint paint = new Paint();
        this.f2136g = paint;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.f2137h = paint2;
        paint2.setAntiAlias(true);
        paint2.setFilterBitmap(true);
    }

    private static boolean a(CharSequence charSequence, CharSequence charSequence2) {
        return charSequence == charSequence2 || (charSequence != null && charSequence.equals(charSequence2));
    }

    @RequiresNonNull({"cueBitmap", "bitmapRect"})
    private void c(Canvas canvas) {
        canvas.drawBitmap(this.f2140k, (Rect) null, this.J, this.f2137h);
    }

    private void d(Canvas canvas, boolean z5) {
        if (z5) {
            e(canvas);
            return;
        }
        i2.a.e(this.J);
        i2.a.e(this.f2140k);
        c(canvas);
    }

    private void e(Canvas canvas) {
        StaticLayout staticLayout = this.E;
        StaticLayout staticLayout2 = this.F;
        if (staticLayout == null || staticLayout2 == null) {
            return;
        }
        int save = canvas.save();
        canvas.translate(this.G, this.H);
        if (Color.alpha(this.f2150u) > 0) {
            this.f2136g.setColor(this.f2150u);
            canvas.drawRect(-this.I, 0.0f, staticLayout.getWidth() + this.I, staticLayout.getHeight(), this.f2136g);
        }
        int i6 = this.f2152w;
        if (i6 == 1) {
            this.f2135f.setStrokeJoin(Paint.Join.ROUND);
            this.f2135f.setStrokeWidth(this.f2130a);
            this.f2135f.setColor(this.f2151v);
            this.f2135f.setStyle(Paint.Style.FILL_AND_STROKE);
            staticLayout2.draw(canvas);
        } else if (i6 == 2) {
            TextPaint textPaint = this.f2135f;
            float f6 = this.f2131b;
            float f7 = this.f2132c;
            textPaint.setShadowLayer(f6, f7, f7, this.f2151v);
        } else if (i6 == 3 || i6 == 4) {
            boolean z5 = i6 == 3;
            int i7 = z5 ? -1 : this.f2151v;
            int i8 = z5 ? this.f2151v : -1;
            float f8 = this.f2131b / 2.0f;
            this.f2135f.setColor(this.f2148s);
            this.f2135f.setStyle(Paint.Style.FILL);
            float f9 = -f8;
            this.f2135f.setShadowLayer(this.f2131b, f9, f9, i7);
            staticLayout2.draw(canvas);
            this.f2135f.setShadowLayer(this.f2131b, f8, f8, i8);
        }
        this.f2135f.setColor(this.f2148s);
        this.f2135f.setStyle(Paint.Style.FILL);
        staticLayout.draw(canvas);
        this.f2135f.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        canvas.restoreToCount(save);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0058  */
    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"cueBitmap"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void f() {
        /*
            r7 = this;
            android.graphics.Bitmap r0 = r7.f2140k
            int r1 = r7.C
            int r2 = r7.A
            int r1 = r1 - r2
            int r3 = r7.D
            int r4 = r7.B
            int r3 = r3 - r4
            float r2 = (float) r2
            float r1 = (float) r1
            float r5 = r7.f2144o
            float r5 = r5 * r1
            float r2 = r2 + r5
            float r4 = (float) r4
            float r3 = (float) r3
            float r5 = r7.f2141l
            float r5 = r5 * r3
            float r4 = r4 + r5
            float r5 = r7.f2146q
            float r1 = r1 * r5
            int r1 = java.lang.Math.round(r1)
            float r5 = r7.f2147r
            r6 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            int r6 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r6 == 0) goto L2c
            goto L38
        L2c:
            float r3 = (float) r1
            int r5 = r0.getHeight()
            float r5 = (float) r5
            int r0 = r0.getWidth()
            float r0 = (float) r0
            float r5 = r5 / r0
        L38:
            float r3 = r3 * r5
            int r0 = java.lang.Math.round(r3)
            int r3 = r7.f2145p
            r5 = 1
            r6 = 2
            if (r3 != r6) goto L47
            float r3 = (float) r1
        L45:
            float r2 = r2 - r3
            goto L4d
        L47:
            if (r3 != r5) goto L4d
            int r3 = r1 / 2
            float r3 = (float) r3
            goto L45
        L4d:
            int r2 = java.lang.Math.round(r2)
            int r3 = r7.f2143n
            if (r3 != r6) goto L58
            float r3 = (float) r0
        L56:
            float r4 = r4 - r3
            goto L5e
        L58:
            if (r3 != r5) goto L5e
            int r3 = r0 / 2
            float r3 = (float) r3
            goto L56
        L5e:
            int r3 = java.lang.Math.round(r4)
            android.graphics.Rect r4 = new android.graphics.Rect
            int r1 = r1 + r2
            int r0 = r0 + r3
            r4.<init>(r2, r3, r1, r0)
            r7.J = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.f.f():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01a7  */
    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"cueText"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void g() {
        /*
            Method dump skipped, instructions count: 494
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.f.g():void");
    }

    public void b(u1.b bVar, f2.a aVar, float f6, float f7, float f8, Canvas canvas, int i6, int i7, int i8, int i9) {
        int i10;
        boolean z5 = bVar.f9607d == null;
        if (!z5) {
            i10 = -16777216;
        } else if (TextUtils.isEmpty(bVar.f9604a)) {
            return;
        } else {
            i10 = bVar.f9615p ? bVar.f9616q : aVar.f3790c;
        }
        if (a(this.f2138i, bVar.f9604a) && c1.c(this.f2139j, bVar.f9605b) && this.f2140k == bVar.f9607d && this.f2141l == bVar.f9608e && this.f2142m == bVar.f9609j && c1.c(Integer.valueOf(this.f2143n), Integer.valueOf(bVar.f9610k)) && this.f2144o == bVar.f9611l && c1.c(Integer.valueOf(this.f2145p), Integer.valueOf(bVar.f9612m)) && this.f2146q == bVar.f9613n && this.f2147r == bVar.f9614o && this.f2148s == aVar.f3788a && this.f2149t == aVar.f3789b && this.f2150u == i10 && this.f2152w == aVar.f3791d && this.f2151v == aVar.f3792e && c1.c(this.f2135f.getTypeface(), aVar.f3793f) && this.f2153x == f6 && this.f2154y == f7 && this.f2155z == f8 && this.A == i6 && this.B == i7 && this.C == i8 && this.D == i9) {
            d(canvas, z5);
            return;
        }
        this.f2138i = bVar.f9604a;
        this.f2139j = bVar.f9605b;
        this.f2140k = bVar.f9607d;
        this.f2141l = bVar.f9608e;
        this.f2142m = bVar.f9609j;
        this.f2143n = bVar.f9610k;
        this.f2144o = bVar.f9611l;
        this.f2145p = bVar.f9612m;
        this.f2146q = bVar.f9613n;
        this.f2147r = bVar.f9614o;
        this.f2148s = aVar.f3788a;
        this.f2149t = aVar.f3789b;
        this.f2150u = i10;
        this.f2152w = aVar.f3791d;
        this.f2151v = aVar.f3792e;
        this.f2135f.setTypeface(aVar.f3793f);
        this.f2153x = f6;
        this.f2154y = f7;
        this.f2155z = f8;
        this.A = i6;
        this.B = i7;
        this.C = i8;
        this.D = i9;
        if (z5) {
            i2.a.e(this.f2138i);
            g();
        } else {
            i2.a.e(this.f2140k);
            f();
        }
        d(canvas, z5);
    }
}
