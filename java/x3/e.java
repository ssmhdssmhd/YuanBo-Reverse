package x3;

import y3.s;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public final y3.a<String> f10488a;

    public e(m3.a aVar) {
        this.f10488a = new y3.a<>(aVar, "flutter/lifecycle", s.f11118b);
    }

    public void a() {
        k3.b.f("LifecycleChannel", "Sending AppLifecycleState.detached message.");
        this.f10488a.c("AppLifecycleState.detached");
    }

    public void b() {
        k3.b.f("LifecycleChannel", "Sending AppLifecycleState.inactive message.");
        this.f10488a.c("AppLifecycleState.inactive");
    }

    public void c() {
        k3.b.f("LifecycleChannel", "Sending AppLifecycleState.paused message.");
        this.f10488a.c("AppLifecycleState.paused");
    }

    public void d() {
        k3.b.f("LifecycleChannel", "Sending AppLifecycleState.resumed message.");
        this.f10488a.c("AppLifecycleState.resumed");
    }
}
