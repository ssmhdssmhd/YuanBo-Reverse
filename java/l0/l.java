package l0;

import java.util.ArrayDeque;
import l0.h;
import l0.i;
import l0.j;

/* loaded from: classes.dex */
public abstract class l<I extends i, O extends j, E extends h> implements f<I, O, E> {

    /* renamed from: a, reason: collision with root package name */
    private final Thread f7177a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f7178b = new Object();

    /* renamed from: c, reason: collision with root package name */
    private final ArrayDeque<I> f7179c = new ArrayDeque<>();

    /* renamed from: d, reason: collision with root package name */
    private final ArrayDeque<O> f7180d = new ArrayDeque<>();

    /* renamed from: e, reason: collision with root package name */
    private final I[] f7181e;

    /* renamed from: f, reason: collision with root package name */
    private final O[] f7182f;

    /* renamed from: g, reason: collision with root package name */
    private int f7183g;

    /* renamed from: h, reason: collision with root package name */
    private int f7184h;

    /* renamed from: i, reason: collision with root package name */
    private I f7185i;

    /* renamed from: j, reason: collision with root package name */
    private E f7186j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f7187k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f7188l;

    /* renamed from: m, reason: collision with root package name */
    private int f7189m;

    class a extends Thread {
        a(String str) {
            super(str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            l.this.u();
        }
    }

    protected l(I[] iArr, O[] oArr) {
        this.f7181e = iArr;
        this.f7183g = iArr.length;
        for (int i6 = 0; i6 < this.f7183g; i6++) {
            this.f7181e[i6] = h();
        }
        this.f7182f = oArr;
        this.f7184h = oArr.length;
        for (int i7 = 0; i7 < this.f7184h; i7++) {
            this.f7182f[i7] = i();
        }
        a aVar = new a("ExoPlayer:SimpleDecoder");
        this.f7177a = aVar;
        aVar.start();
    }

    private boolean g() {
        return !this.f7179c.isEmpty() && this.f7184h > 0;
    }

    private boolean l() {
        E j6;
        synchronized (this.f7178b) {
            while (!this.f7188l && !g()) {
                this.f7178b.wait();
            }
            if (this.f7188l) {
                return false;
            }
            I removeFirst = this.f7179c.removeFirst();
            O[] oArr = this.f7182f;
            int i6 = this.f7184h - 1;
            this.f7184h = i6;
            O o6 = oArr[i6];
            boolean z5 = this.f7187k;
            this.f7187k = false;
            if (removeFirst.k()) {
                o6.e(4);
            } else {
                if (removeFirst.j()) {
                    o6.e(Integer.MIN_VALUE);
                }
                if (removeFirst.l()) {
                    o6.e(134217728);
                }
                try {
                    j6 = k(removeFirst, o6, z5);
                } catch (OutOfMemoryError | RuntimeException e6) {
                    j6 = j(e6);
                }
                if (j6 != null) {
                    synchronized (this.f7178b) {
                        this.f7186j = j6;
                    }
                    return false;
                }
            }
            synchronized (this.f7178b) {
                if (!this.f7187k) {
                    if (o6.j()) {
                        this.f7189m++;
                    } else {
                        o6.f7171c = this.f7189m;
                        this.f7189m = 0;
                        this.f7180d.addLast(o6);
                        r(removeFirst);
                    }
                }
                o6.o();
                r(removeFirst);
            }
            return true;
        }
    }

    private void o() {
        if (g()) {
            this.f7178b.notify();
        }
    }

    private void p() {
        E e6 = this.f7186j;
        if (e6 != null) {
            throw e6;
        }
    }

    private void r(I i6) {
        i6.f();
        I[] iArr = this.f7181e;
        int i7 = this.f7183g;
        this.f7183g = i7 + 1;
        iArr[i7] = i6;
    }

    private void t(O o6) {
        o6.f();
        O[] oArr = this.f7182f;
        int i6 = this.f7184h;
        this.f7184h = i6 + 1;
        oArr[i6] = o6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        do {
            try {
            } catch (InterruptedException e6) {
                throw new IllegalStateException(e6);
            }
        } while (l());
    }

    @Override // l0.f
    public void a() {
        synchronized (this.f7178b) {
            this.f7188l = true;
            this.f7178b.notify();
        }
        try {
            this.f7177a.join();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    @Override // l0.f
    public final void flush() {
        synchronized (this.f7178b) {
            this.f7187k = true;
            this.f7189m = 0;
            I i6 = this.f7185i;
            if (i6 != null) {
                r(i6);
                this.f7185i = null;
            }
            while (!this.f7179c.isEmpty()) {
                r(this.f7179c.removeFirst());
            }
            while (!this.f7180d.isEmpty()) {
                this.f7180d.removeFirst().o();
            }
        }
    }

    protected abstract I h();

    protected abstract O i();

    protected abstract E j(Throwable th);

    protected abstract E k(I i6, O o6, boolean z5);

    @Override // l0.f
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public final I e() {
        I i6;
        synchronized (this.f7178b) {
            p();
            i2.a.g(this.f7185i == null);
            int i7 = this.f7183g;
            if (i7 == 0) {
                i6 = null;
            } else {
                I[] iArr = this.f7181e;
                int i8 = i7 - 1;
                this.f7183g = i8;
                i6 = iArr[i8];
            }
            this.f7185i = i6;
        }
        return i6;
    }

    @Override // l0.f
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public final O d() {
        synchronized (this.f7178b) {
            p();
            if (this.f7180d.isEmpty()) {
                return null;
            }
            return this.f7180d.removeFirst();
        }
    }

    @Override // l0.f
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public final void c(I i6) {
        synchronized (this.f7178b) {
            p();
            i2.a.a(i6 == this.f7185i);
            this.f7179c.addLast(i6);
            o();
            this.f7185i = null;
        }
    }

    protected void s(O o6) {
        synchronized (this.f7178b) {
            t(o6);
            o();
        }
    }

    protected final void v(int i6) {
        i2.a.g(this.f7183g == this.f7181e.length);
        for (I i7 : this.f7181e) {
            i7.p(i6);
        }
    }
}
