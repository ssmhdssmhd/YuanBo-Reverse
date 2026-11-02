package c4;

import java.util.ArrayList;
import java.util.Iterator;
import y3.d;

/* loaded from: classes.dex */
final class n implements d.b {

    /* renamed from: a, reason: collision with root package name */
    private d.b f1857a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<Object> f1858b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private boolean f1859c = false;

    private static class b {
        private b() {
        }
    }

    private static class c {

        /* renamed from: a, reason: collision with root package name */
        String f1860a;

        /* renamed from: b, reason: collision with root package name */
        String f1861b;

        /* renamed from: c, reason: collision with root package name */
        Object f1862c;

        c(String str, String str2, Object obj) {
            this.f1860a = str;
            this.f1861b = str2;
            this.f1862c = obj;
        }
    }

    n() {
    }

    private void d(Object obj) {
        if (this.f1859c) {
            return;
        }
        this.f1858b.add(obj);
    }

    private void e() {
        if (this.f1857a == null) {
            return;
        }
        Iterator<Object> it = this.f1858b.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof b) {
                this.f1857a.c();
            } else if (next instanceof c) {
                c cVar = (c) next;
                this.f1857a.a(cVar.f1860a, cVar.f1861b, cVar.f1862c);
            } else {
                this.f1857a.b(next);
            }
        }
        this.f1858b.clear();
    }

    @Override // y3.d.b
    public void a(String str, String str2, Object obj) {
        d(new c(str, str2, obj));
        e();
    }

    @Override // y3.d.b
    public void b(Object obj) {
        d(obj);
        e();
    }

    @Override // y3.d.b
    public void c() {
        d(new b());
        e();
        this.f1859c = true;
    }

    public void f(d.b bVar) {
        this.f1857a = bVar;
        e();
    }
}
