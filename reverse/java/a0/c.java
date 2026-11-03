package a0;

import d0.p;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class c<T> implements z.a<T> {

    /* renamed from: a, reason: collision with root package name */
    private final List<String> f1a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private T f2b;

    /* renamed from: c, reason: collision with root package name */
    private b0.d<T> f3c;

    /* renamed from: d, reason: collision with root package name */
    private a f4d;

    public interface a {
        void a(List<String> list);

        void b(List<String> list);
    }

    c(b0.d<T> dVar) {
        this.f3c = dVar;
    }

    private void h(a aVar, T t5) {
        if (this.f1a.isEmpty() || aVar == null) {
            return;
        }
        if (t5 == null || c(t5)) {
            aVar.b(this.f1a);
        } else {
            aVar.a(this.f1a);
        }
    }

    @Override // z.a
    public void a(T t5) {
        this.f2b = t5;
        h(this.f4d, t5);
    }

    abstract boolean b(p pVar);

    abstract boolean c(T t5);

    public boolean d(String str) {
        T t5 = this.f2b;
        return t5 != null && c(t5) && this.f1a.contains(str);
    }

    public void e(Iterable<p> iterable) {
        this.f1a.clear();
        for (p pVar : iterable) {
            if (b(pVar)) {
                this.f1a.add(pVar.f2858a);
            }
        }
        if (this.f1a.isEmpty()) {
            this.f3c.c(this);
        } else {
            this.f3c.a(this);
        }
        h(this.f4d, this.f2b);
    }

    public void f() {
        if (this.f1a.isEmpty()) {
            return;
        }
        this.f1a.clear();
        this.f3c.c(this);
    }

    public void g(a aVar) {
        if (this.f4d != aVar) {
            this.f4d = aVar;
            h(aVar, this.f2b);
        }
    }
}
