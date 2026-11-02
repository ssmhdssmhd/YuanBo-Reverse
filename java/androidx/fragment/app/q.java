package androidx.fragment.app;

import androidx.lifecycle.d;

/* loaded from: classes.dex */
class q implements androidx.lifecycle.i {

    /* renamed from: a, reason: collision with root package name */
    private androidx.lifecycle.j f812a = null;

    q() {
    }

    @Override // androidx.lifecycle.i
    public androidx.lifecycle.d a() {
        c();
        return this.f812a;
    }

    void b(d.b bVar) {
        this.f812a.h(bVar);
    }

    void c() {
        if (this.f812a == null) {
            this.f812a = new androidx.lifecycle.j(this);
        }
    }

    boolean d() {
        return this.f812a != null;
    }
}
