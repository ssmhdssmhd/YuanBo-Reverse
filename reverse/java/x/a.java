package x;

import d0.p;
import java.util.HashMap;
import java.util.Map;
import v.j;
import v.q;

/* loaded from: classes.dex */
public class a {

    /* renamed from: d, reason: collision with root package name */
    static final String f10376d = j.f("DelayedWorkTracker");

    /* renamed from: a, reason: collision with root package name */
    final b f10377a;

    /* renamed from: b, reason: collision with root package name */
    private final q f10378b;

    /* renamed from: c, reason: collision with root package name */
    private final Map<String, Runnable> f10379c = new HashMap();

    /* renamed from: x.a$a, reason: collision with other inner class name */
    class RunnableC0162a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ p f10380a;

        RunnableC0162a(p pVar) {
            this.f10380a = pVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            j.c().a(a.f10376d, String.format("Scheduling work %s", this.f10380a.f2858a), new Throwable[0]);
            a.this.f10377a.d(this.f10380a);
        }
    }

    public a(b bVar, q qVar) {
        this.f10377a = bVar;
        this.f10378b = qVar;
    }

    public void a(p pVar) {
        Runnable remove = this.f10379c.remove(pVar.f2858a);
        if (remove != null) {
            this.f10378b.b(remove);
        }
        RunnableC0162a runnableC0162a = new RunnableC0162a(pVar);
        this.f10379c.put(pVar.f2858a, runnableC0162a);
        this.f10378b.a(pVar.a() - System.currentTimeMillis(), runnableC0162a);
    }

    public void b(String str) {
        Runnable remove = this.f10379c.remove(str);
        if (remove != null) {
            this.f10378b.b(remove);
        }
    }
}
