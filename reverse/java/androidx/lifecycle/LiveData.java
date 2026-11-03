package androidx.lifecycle;

import androidx.lifecycle.d;

/* loaded from: classes.dex */
public abstract class LiveData<T> {

    /* renamed from: j, reason: collision with root package name */
    static final Object f820j = new Object();

    /* renamed from: a, reason: collision with root package name */
    final Object f821a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private d.b<q<? super T>, LiveData<T>.c> f822b = new d.b<>();

    /* renamed from: c, reason: collision with root package name */
    int f823c = 0;

    /* renamed from: d, reason: collision with root package name */
    private volatile Object f824d;

    /* renamed from: e, reason: collision with root package name */
    volatile Object f825e;

    /* renamed from: f, reason: collision with root package name */
    private int f826f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f827g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f828h;

    /* renamed from: i, reason: collision with root package name */
    private final Runnable f829i;

    class LifecycleBoundObserver extends LiveData<T>.c implements g {

        /* renamed from: e, reason: collision with root package name */
        final i f830e;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ LiveData f831j;

        @Override // androidx.lifecycle.g
        public void d(i iVar, d.b bVar) {
            if (this.f830e.a().b() == d.c.DESTROYED) {
                this.f831j.j(this.f834a);
            } else {
                e(j());
            }
        }

        @Override // androidx.lifecycle.LiveData.c
        void i() {
            this.f830e.a().c(this);
        }

        @Override // androidx.lifecycle.LiveData.c
        boolean j() {
            return this.f830e.a().b().a(d.c.STARTED);
        }
    }

    class a implements Runnable {
        a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            synchronized (LiveData.this.f821a) {
                obj = LiveData.this.f825e;
                LiveData.this.f825e = LiveData.f820j;
            }
            LiveData.this.k(obj);
        }
    }

    private class b extends LiveData<T>.c {
        b(q<? super T> qVar) {
            super(qVar);
        }

        @Override // androidx.lifecycle.LiveData.c
        boolean j() {
            return true;
        }
    }

    private abstract class c {

        /* renamed from: a, reason: collision with root package name */
        final q<? super T> f834a;

        /* renamed from: b, reason: collision with root package name */
        boolean f835b;

        /* renamed from: c, reason: collision with root package name */
        int f836c = -1;

        c(q<? super T> qVar) {
            this.f834a = qVar;
        }

        void e(boolean z5) {
            if (z5 == this.f835b) {
                return;
            }
            this.f835b = z5;
            LiveData liveData = LiveData.this;
            int i6 = liveData.f823c;
            boolean z6 = i6 == 0;
            liveData.f823c = i6 + (z5 ? 1 : -1);
            if (z6 && z5) {
                liveData.g();
            }
            LiveData liveData2 = LiveData.this;
            if (liveData2.f823c == 0 && !this.f835b) {
                liveData2.h();
            }
            if (this.f835b) {
                LiveData.this.c(this);
            }
        }

        void i() {
        }

        abstract boolean j();
    }

    public LiveData() {
        Object obj = f820j;
        this.f825e = obj;
        this.f829i = new a();
        this.f824d = obj;
        this.f826f = -1;
    }

    static void a(String str) {
        if (c.a.f().c()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
    }

    private void b(LiveData<T>.c cVar) {
        if (cVar.f835b) {
            if (!cVar.j()) {
                cVar.e(false);
                return;
            }
            int i6 = cVar.f836c;
            int i7 = this.f826f;
            if (i6 >= i7) {
                return;
            }
            cVar.f836c = i7;
            cVar.f834a.a((Object) this.f824d);
        }
    }

    void c(LiveData<T>.c cVar) {
        if (this.f827g) {
            this.f828h = true;
            return;
        }
        this.f827g = true;
        do {
            this.f828h = false;
            if (cVar != null) {
                b(cVar);
                cVar = null;
            } else {
                d.b<q<? super T>, LiveData<T>.c>.d d6 = this.f822b.d();
                while (d6.hasNext()) {
                    b((c) d6.next().getValue());
                    if (this.f828h) {
                        break;
                    }
                }
            }
        } while (this.f828h);
        this.f827g = false;
    }

    int d() {
        return this.f826f;
    }

    public boolean e() {
        return this.f823c > 0;
    }

    public void f(q<? super T> qVar) {
        a("observeForever");
        b bVar = new b(qVar);
        LiveData<T>.c g6 = this.f822b.g(qVar, bVar);
        if (g6 instanceof LifecycleBoundObserver) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (g6 != null) {
            return;
        }
        bVar.e(true);
    }

    protected void g() {
    }

    protected void h() {
    }

    protected void i(T t5) {
        boolean z5;
        synchronized (this.f821a) {
            z5 = this.f825e == f820j;
            this.f825e = t5;
        }
        if (z5) {
            c.a.f().d(this.f829i);
        }
    }

    public void j(q<? super T> qVar) {
        a("removeObserver");
        LiveData<T>.c h6 = this.f822b.h(qVar);
        if (h6 == null) {
            return;
        }
        h6.i();
        h6.e(false);
    }

    protected void k(T t5) {
        a("setValue");
        this.f826f++;
        this.f824d = t5;
        c(null);
    }
}
