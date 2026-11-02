package androidx.recyclerview.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.core.view.s;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
class d extends RecyclerView.m implements RecyclerView.r {
    private static final int[] D = {R.attr.state_pressed};
    private static final int[] E = new int[0];
    int A;
    private final Runnable B;
    private final RecyclerView.s C;

    /* renamed from: a, reason: collision with root package name */
    private final int f1213a;

    /* renamed from: b, reason: collision with root package name */
    private final int f1214b;

    /* renamed from: c, reason: collision with root package name */
    final StateListDrawable f1215c;

    /* renamed from: d, reason: collision with root package name */
    final Drawable f1216d;

    /* renamed from: e, reason: collision with root package name */
    private final int f1217e;

    /* renamed from: f, reason: collision with root package name */
    private final int f1218f;

    /* renamed from: g, reason: collision with root package name */
    private final StateListDrawable f1219g;

    /* renamed from: h, reason: collision with root package name */
    private final Drawable f1220h;

    /* renamed from: i, reason: collision with root package name */
    private final int f1221i;

    /* renamed from: j, reason: collision with root package name */
    private final int f1222j;

    /* renamed from: k, reason: collision with root package name */
    int f1223k;

    /* renamed from: l, reason: collision with root package name */
    int f1224l;

    /* renamed from: m, reason: collision with root package name */
    float f1225m;

    /* renamed from: n, reason: collision with root package name */
    int f1226n;

    /* renamed from: o, reason: collision with root package name */
    int f1227o;

    /* renamed from: p, reason: collision with root package name */
    float f1228p;

    /* renamed from: s, reason: collision with root package name */
    private RecyclerView f1231s;

    /* renamed from: z, reason: collision with root package name */
    final ValueAnimator f1238z;

    /* renamed from: q, reason: collision with root package name */
    private int f1229q = 0;

    /* renamed from: r, reason: collision with root package name */
    private int f1230r = 0;

    /* renamed from: t, reason: collision with root package name */
    private boolean f1232t = false;

    /* renamed from: u, reason: collision with root package name */
    private boolean f1233u = false;

    /* renamed from: v, reason: collision with root package name */
    private int f1234v = 0;

    /* renamed from: w, reason: collision with root package name */
    private int f1235w = 0;

    /* renamed from: x, reason: collision with root package name */
    private final int[] f1236x = new int[2];

    /* renamed from: y, reason: collision with root package name */
    private final int[] f1237y = new int[2];

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.o(500);
        }
    }

    class b extends RecyclerView.s {
        b() {
        }
    }

    private class c extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        private boolean f1241a = false;

        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f1241a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f1241a) {
                this.f1241a = false;
                return;
            }
            if (((Float) d.this.f1238z.getAnimatedValue()).floatValue() == 0.0f) {
                d dVar = d.this;
                dVar.A = 0;
                dVar.w(0);
            } else {
                d dVar2 = d.this;
                dVar2.A = 2;
                dVar2.t();
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.d$d, reason: collision with other inner class name */
    private class C0022d implements ValueAnimator.AnimatorUpdateListener {
        C0022d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            d.this.f1215c.setAlpha(floatValue);
            d.this.f1216d.setAlpha(floatValue);
            d.this.t();
        }
    }

    d(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i6, int i7, int i8) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f1238z = ofFloat;
        this.A = 0;
        this.B = new a();
        this.C = new b();
        this.f1215c = stateListDrawable;
        this.f1216d = drawable;
        this.f1219g = stateListDrawable2;
        this.f1220h = drawable2;
        this.f1217e = Math.max(i6, stateListDrawable.getIntrinsicWidth());
        this.f1218f = Math.max(i6, drawable.getIntrinsicWidth());
        this.f1221i = Math.max(i6, stateListDrawable2.getIntrinsicWidth());
        this.f1222j = Math.max(i6, drawable2.getIntrinsicWidth());
        this.f1213a = i7;
        this.f1214b = i8;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        ofFloat.addListener(new c());
        ofFloat.addUpdateListener(new C0022d());
        h(recyclerView);
    }

    private void i() {
        this.f1231s.removeCallbacks(this.B);
    }

    private void j() {
        this.f1231s.p0(this);
        this.f1231s.q0(this);
        this.f1231s.r0(this.C);
        i();
    }

    private void k(Canvas canvas) {
        int i6 = this.f1230r;
        int i7 = this.f1221i;
        int i8 = this.f1227o;
        int i9 = this.f1226n;
        this.f1219g.setBounds(0, 0, i9, i7);
        this.f1220h.setBounds(0, 0, this.f1229q, this.f1222j);
        canvas.translate(0.0f, i6 - i7);
        this.f1220h.draw(canvas);
        canvas.translate(i8 - (i9 / 2), 0.0f);
        this.f1219g.draw(canvas);
        canvas.translate(-r2, -r0);
    }

    private void l(Canvas canvas) {
        int i6 = this.f1229q;
        int i7 = this.f1217e;
        int i8 = i6 - i7;
        int i9 = this.f1224l;
        int i10 = this.f1223k;
        int i11 = i9 - (i10 / 2);
        this.f1215c.setBounds(0, 0, i7, i10);
        this.f1216d.setBounds(0, 0, this.f1218f, this.f1230r);
        if (q()) {
            this.f1216d.draw(canvas);
            canvas.translate(this.f1217e, i11);
            canvas.scale(-1.0f, 1.0f);
            this.f1215c.draw(canvas);
            canvas.scale(-1.0f, 1.0f);
            i8 = this.f1217e;
        } else {
            canvas.translate(i8, 0.0f);
            this.f1216d.draw(canvas);
            canvas.translate(0.0f, i11);
            this.f1215c.draw(canvas);
        }
        canvas.translate(-i8, -i11);
    }

    private int[] m() {
        int[] iArr = this.f1237y;
        int i6 = this.f1214b;
        iArr[0] = i6;
        iArr[1] = this.f1229q - i6;
        return iArr;
    }

    private int[] n() {
        int[] iArr = this.f1236x;
        int i6 = this.f1214b;
        iArr[0] = i6;
        iArr[1] = this.f1230r - i6;
        return iArr;
    }

    private void p(float f6) {
        int[] m6 = m();
        float max = Math.max(m6[0], Math.min(m6[1], f6));
        if (Math.abs(this.f1227o - max) < 2.0f) {
            return;
        }
        int v5 = v(this.f1228p, max, m6, this.f1231s.computeHorizontalScrollRange(), this.f1231s.computeHorizontalScrollOffset(), this.f1229q);
        if (v5 != 0) {
            this.f1231s.scrollBy(v5, 0);
        }
        this.f1228p = max;
    }

    private boolean q() {
        return s.k(this.f1231s) == 1;
    }

    private void u(int i6) {
        i();
        this.f1231s.postDelayed(this.B, i6);
    }

    private int v(float f6, float f7, int[] iArr, int i6, int i7, int i8) {
        int i9 = iArr[1] - iArr[0];
        if (i9 == 0) {
            return 0;
        }
        int i10 = i6 - i8;
        int i11 = (int) (((f7 - f6) / i9) * i10);
        int i12 = i7 + i11;
        if (i12 >= i10 || i12 < 0) {
            return 0;
        }
        return i11;
    }

    private void x() {
        this.f1231s.d(this);
        this.f1231s.f(this);
        this.f1231s.g(this.C);
    }

    private void z(float f6) {
        int[] n6 = n();
        float max = Math.max(n6[0], Math.min(n6[1], f6));
        if (Math.abs(this.f1224l - max) < 2.0f) {
            return;
        }
        int v5 = v(this.f1225m, max, n6, this.f1231s.computeVerticalScrollRange(), this.f1231s.computeVerticalScrollOffset(), this.f1230r);
        if (v5 != 0) {
            this.f1231s.scrollBy(0, v5);
        }
        this.f1225m = max;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public boolean a(RecyclerView recyclerView, MotionEvent motionEvent) {
        int i6 = this.f1234v;
        if (i6 == 1) {
            boolean s5 = s(motionEvent.getX(), motionEvent.getY());
            boolean r6 = r(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (!s5 && !r6) {
                return false;
            }
            if (r6) {
                this.f1235w = 1;
                this.f1228p = (int) motionEvent.getX();
            } else if (s5) {
                this.f1235w = 2;
                this.f1225m = (int) motionEvent.getY();
            }
            w(2);
        } else if (i6 != 2) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public void b(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.f1234v == 0) {
            return;
        }
        if (motionEvent.getAction() == 0) {
            boolean s5 = s(motionEvent.getX(), motionEvent.getY());
            boolean r6 = r(motionEvent.getX(), motionEvent.getY());
            if (s5 || r6) {
                if (r6) {
                    this.f1235w = 1;
                    this.f1228p = (int) motionEvent.getX();
                } else if (s5) {
                    this.f1235w = 2;
                    this.f1225m = (int) motionEvent.getY();
                }
                w(2);
                return;
            }
            return;
        }
        if (motionEvent.getAction() == 1 && this.f1234v == 2) {
            this.f1225m = 0.0f;
            this.f1228p = 0.0f;
            w(1);
            this.f1235w = 0;
            return;
        }
        if (motionEvent.getAction() == 2 && this.f1234v == 2) {
            y();
            if (this.f1235w == 1) {
                p(motionEvent.getX());
            }
            if (this.f1235w == 2) {
                z(motionEvent.getY());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public void c(boolean z5) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void g(Canvas canvas, RecyclerView recyclerView, RecyclerView.y yVar) {
        if (this.f1229q != this.f1231s.getWidth() || this.f1230r != this.f1231s.getHeight()) {
            this.f1229q = this.f1231s.getWidth();
            this.f1230r = this.f1231s.getHeight();
            w(0);
        } else if (this.A != 0) {
            if (this.f1232t) {
                l(canvas);
            }
            if (this.f1233u) {
                k(canvas);
            }
        }
    }

    public void h(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f1231s;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            j();
        }
        this.f1231s = recyclerView;
        if (recyclerView != null) {
            x();
        }
    }

    void o(int i6) {
        int i7 = this.A;
        if (i7 == 1) {
            this.f1238z.cancel();
        } else if (i7 != 2) {
            return;
        }
        this.A = 3;
        ValueAnimator valueAnimator = this.f1238z;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
        this.f1238z.setDuration(i6);
        this.f1238z.start();
    }

    boolean r(float f6, float f7) {
        if (f7 >= this.f1230r - this.f1221i) {
            int i6 = this.f1227o;
            int i7 = this.f1226n;
            if (f6 >= i6 - (i7 / 2) && f6 <= i6 + (i7 / 2)) {
                return true;
            }
        }
        return false;
    }

    boolean s(float f6, float f7) {
        if (!q() ? f6 >= this.f1229q - this.f1217e : f6 <= this.f1217e) {
            int i6 = this.f1224l;
            int i7 = this.f1223k;
            if (f7 >= i6 - (i7 / 2) && f7 <= i6 + (i7 / 2)) {
                return true;
            }
        }
        return false;
    }

    void t() {
        this.f1231s.invalidate();
    }

    void w(int i6) {
        int i7;
        if (i6 == 2 && this.f1234v != 2) {
            this.f1215c.setState(D);
            i();
        }
        if (i6 == 0) {
            t();
        } else {
            y();
        }
        if (this.f1234v != 2 || i6 == 2) {
            i7 = i6 == 1 ? 1500 : 1200;
            this.f1234v = i6;
        }
        this.f1215c.setState(E);
        u(i7);
        this.f1234v = i6;
    }

    public void y() {
        int i6 = this.A;
        if (i6 != 0) {
            if (i6 != 3) {
                return;
            } else {
                this.f1238z.cancel();
            }
        }
        this.A = 1;
        ValueAnimator valueAnimator = this.f1238z;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        this.f1238z.setDuration(500L);
        this.f1238z.setStartDelay(0L);
        this.f1238z.start();
    }
}
