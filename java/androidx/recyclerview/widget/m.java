package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
class m {

    /* renamed from: a, reason: collision with root package name */
    final f.f<RecyclerView.b0, a> f1282a = new f.f<>();

    /* renamed from: b, reason: collision with root package name */
    final f.d<RecyclerView.b0> f1283b = new f.d<>();

    static class a {

        /* renamed from: d, reason: collision with root package name */
        static androidx.core.util.e<a> f1284d = new androidx.core.util.f(20);

        /* renamed from: a, reason: collision with root package name */
        int f1285a;

        /* renamed from: b, reason: collision with root package name */
        RecyclerView.k.c f1286b;

        /* renamed from: c, reason: collision with root package name */
        RecyclerView.k.c f1287c;

        private a() {
        }

        static void a() {
            while (f1284d.b() != null) {
            }
        }

        static a b() {
            a b6 = f1284d.b();
            return b6 == null ? new a() : b6;
        }

        static void c(a aVar) {
            aVar.f1285a = 0;
            aVar.f1286b = null;
            aVar.f1287c = null;
            f1284d.a(aVar);
        }
    }

    interface b {
    }

    m() {
    }

    void a(long j6, RecyclerView.b0 b0Var) {
        this.f1283b.d(j6, b0Var);
    }

    void b(RecyclerView.b0 b0Var, RecyclerView.k.c cVar) {
        a aVar = this.f1282a.get(b0Var);
        if (aVar == null) {
            aVar = a.b();
            this.f1282a.put(b0Var, aVar);
        }
        aVar.f1286b = cVar;
        aVar.f1285a |= 4;
    }

    void c() {
        a.a();
    }

    void d(RecyclerView.b0 b0Var) {
        int f6 = this.f1283b.f() - 1;
        while (true) {
            if (f6 < 0) {
                break;
            }
            if (b0Var == this.f1283b.g(f6)) {
                this.f1283b.e(f6);
                break;
            }
            f6--;
        }
        a remove = this.f1282a.remove(b0Var);
        if (remove != null) {
            a.c(remove);
        }
    }
}
