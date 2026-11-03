package z;

import a0.c;
import a0.e;
import a0.f;
import a0.g;
import a0.h;
import android.content.Context;
import d0.p;
import java.util.ArrayList;
import java.util.List;
import v.j;

/* loaded from: classes.dex */
public class d implements c.a {

    /* renamed from: d, reason: collision with root package name */
    private static final String f11160d = j.f("WorkConstraintsTracker");

    /* renamed from: a, reason: collision with root package name */
    private final c f11161a;

    /* renamed from: b, reason: collision with root package name */
    private final a0.c<?>[] f11162b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f11163c;

    public d(Context context, f0.a aVar, c cVar) {
        Context applicationContext = context.getApplicationContext();
        this.f11161a = cVar;
        this.f11162b = new a0.c[]{new a0.a(applicationContext, aVar), new a0.b(applicationContext, aVar), new h(applicationContext, aVar), new a0.d(applicationContext, aVar), new g(applicationContext, aVar), new f(applicationContext, aVar), new e(applicationContext, aVar)};
        this.f11163c = new Object();
    }

    @Override // a0.c.a
    public void a(List<String> list) {
        synchronized (this.f11163c) {
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                if (c(str)) {
                    j.c().a(f11160d, String.format("Constraints met for %s", str), new Throwable[0]);
                    arrayList.add(str);
                }
            }
            c cVar = this.f11161a;
            if (cVar != null) {
                cVar.e(arrayList);
            }
        }
    }

    @Override // a0.c.a
    public void b(List<String> list) {
        synchronized (this.f11163c) {
            c cVar = this.f11161a;
            if (cVar != null) {
                cVar.c(list);
            }
        }
    }

    public boolean c(String str) {
        synchronized (this.f11163c) {
            for (a0.c<?> cVar : this.f11162b) {
                if (cVar.d(str)) {
                    j.c().a(f11160d, String.format("Work %s constrained by %s", str, cVar.getClass().getSimpleName()), new Throwable[0]);
                    return false;
                }
            }
            return true;
        }
    }

    public void d(Iterable<p> iterable) {
        synchronized (this.f11163c) {
            for (a0.c<?> cVar : this.f11162b) {
                cVar.g(null);
            }
            for (a0.c<?> cVar2 : this.f11162b) {
                cVar2.e(iterable);
            }
            for (a0.c<?> cVar3 : this.f11162b) {
                cVar3.g(this);
            }
        }
    }

    public void e() {
        synchronized (this.f11163c) {
            for (a0.c<?> cVar : this.f11162b) {
                cVar.f();
            }
        }
    }
}
