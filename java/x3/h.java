package x3;

import y3.k;

/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public final y3.k f10497a;

    /* renamed from: b, reason: collision with root package name */
    private final k.c f10498b;

    class a implements k.c {
        a() {
        }

        @Override // y3.k.c
        public void e(y3.j jVar, k.d dVar) {
            dVar.b(null);
        }
    }

    public h(m3.a aVar) {
        a aVar2 = new a();
        this.f10498b = aVar2;
        y3.k kVar = new y3.k(aVar, "flutter/navigation", y3.g.f11099a);
        this.f10497a = kVar;
        kVar.e(aVar2);
    }

    public void a() {
        k3.b.f("NavigationChannel", "Sending message to pop route.");
        this.f10497a.c("popRoute", null);
    }

    public void b(String str) {
        k3.b.f("NavigationChannel", "Sending message to push route '" + str + "'");
        this.f10497a.c("pushRoute", str);
    }

    public void c(String str) {
        k3.b.f("NavigationChannel", "Sending message to set initial route to '" + str + "'");
        this.f10497a.c("setInitialRoute", str);
    }
}
