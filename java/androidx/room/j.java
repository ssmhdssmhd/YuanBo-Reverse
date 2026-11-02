package androidx.room;

import androidx.lifecycle.LiveData;
import androidx.room.e;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
class j<T> extends LiveData<T> {

    /* renamed from: k, reason: collision with root package name */
    final h f1400k;

    /* renamed from: l, reason: collision with root package name */
    final boolean f1401l;

    /* renamed from: m, reason: collision with root package name */
    final Callable<T> f1402m;

    /* renamed from: n, reason: collision with root package name */
    private final d f1403n;

    /* renamed from: o, reason: collision with root package name */
    final e.c f1404o;

    /* renamed from: p, reason: collision with root package name */
    final AtomicBoolean f1405p = new AtomicBoolean(true);

    /* renamed from: q, reason: collision with root package name */
    final AtomicBoolean f1406q = new AtomicBoolean(false);

    /* renamed from: r, reason: collision with root package name */
    final AtomicBoolean f1407r = new AtomicBoolean(false);

    /* renamed from: s, reason: collision with root package name */
    final Runnable f1408s = new a();

    /* renamed from: t, reason: collision with root package name */
    final Runnable f1409t = new b();

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z5;
            if (j.this.f1407r.compareAndSet(false, true)) {
                j.this.f1400k.i().b(j.this.f1404o);
            }
            do {
                if (j.this.f1406q.compareAndSet(false, true)) {
                    T t5 = null;
                    z5 = false;
                    while (j.this.f1405p.compareAndSet(true, false)) {
                        try {
                            try {
                                t5 = j.this.f1402m.call();
                                z5 = true;
                            } catch (Exception e6) {
                                throw new RuntimeException("Exception while computing database live data.", e6);
                            }
                        } finally {
                            j.this.f1406q.set(false);
                        }
                    }
                    if (z5) {
                        j.this.i(t5);
                    }
                } else {
                    z5 = false;
                }
                if (!z5) {
                    return;
                }
            } while (j.this.f1405p.get());
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean e6 = j.this.e();
            if (j.this.f1405p.compareAndSet(false, true) && e6) {
                j.this.m().execute(j.this.f1408s);
            }
        }
    }

    class c extends e.c {
        c(String[] strArr) {
            super(strArr);
        }

        @Override // androidx.room.e.c
        public void b(Set<String> set) {
            c.a.f().b(j.this.f1409t);
        }
    }

    j(h hVar, d dVar, boolean z5, Callable<T> callable, String[] strArr) {
        this.f1400k = hVar;
        this.f1401l = z5;
        this.f1402m = callable;
        this.f1403n = dVar;
        this.f1404o = new c(strArr);
    }

    @Override // androidx.lifecycle.LiveData
    protected void g() {
        super.g();
        this.f1403n.b(this);
        m().execute(this.f1408s);
    }

    @Override // androidx.lifecycle.LiveData
    protected void h() {
        super.h();
        this.f1403n.c(this);
    }

    Executor m() {
        return this.f1401l ? this.f1400k.l() : this.f1400k.k();
    }
}
