package androidx.lifecycle;

import android.os.Handler;
import androidx.lifecycle.d;

/* loaded from: classes.dex */
public class u {

    /* renamed from: a, reason: collision with root package name */
    private final j f894a;

    /* renamed from: b, reason: collision with root package name */
    private final Handler f895b = new Handler();

    /* renamed from: c, reason: collision with root package name */
    private a f896c;

    static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final j f897a;

        /* renamed from: b, reason: collision with root package name */
        final d.b f898b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f899c = false;

        a(j jVar, d.b bVar) {
            this.f897a = jVar;
            this.f898b = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f899c) {
                return;
            }
            this.f897a.h(this.f898b);
            this.f899c = true;
        }
    }

    public u(i iVar) {
        this.f894a = new j(iVar);
    }

    private void f(d.b bVar) {
        a aVar = this.f896c;
        if (aVar != null) {
            aVar.run();
        }
        a aVar2 = new a(this.f894a, bVar);
        this.f896c = aVar2;
        this.f895b.postAtFrontOfQueue(aVar2);
    }

    public d a() {
        return this.f894a;
    }

    public void b() {
        f(d.b.ON_START);
    }

    public void c() {
        f(d.b.ON_CREATE);
    }

    public void d() {
        f(d.b.ON_STOP);
        f(d.b.ON_DESTROY);
    }

    public void e() {
        f(d.b.ON_START);
    }
}
