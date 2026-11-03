package b0;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import v.j;

/* loaded from: classes.dex */
public abstract class d<T> {

    /* renamed from: f, reason: collision with root package name */
    private static final String f1674f = j.f("ConstraintTracker");

    /* renamed from: a, reason: collision with root package name */
    protected final f0.a f1675a;

    /* renamed from: b, reason: collision with root package name */
    protected final Context f1676b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f1677c = new Object();

    /* renamed from: d, reason: collision with root package name */
    private final Set<z.a<T>> f1678d = new LinkedHashSet();

    /* renamed from: e, reason: collision with root package name */
    T f1679e;

    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f1680a;

        a(List list) {
            this.f1680a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f1680a.iterator();
            while (it.hasNext()) {
                ((z.a) it.next()).a(d.this.f1679e);
            }
        }
    }

    d(Context context, f0.a aVar) {
        this.f1676b = context.getApplicationContext();
        this.f1675a = aVar;
    }

    public void a(z.a<T> aVar) {
        synchronized (this.f1677c) {
            if (this.f1678d.add(aVar)) {
                if (this.f1678d.size() == 1) {
                    this.f1679e = b();
                    j.c().a(f1674f, String.format("%s: initial state = %s", getClass().getSimpleName(), this.f1679e), new Throwable[0]);
                    e();
                }
                aVar.a(this.f1679e);
            }
        }
    }

    public abstract T b();

    public void c(z.a<T> aVar) {
        synchronized (this.f1677c) {
            if (this.f1678d.remove(aVar) && this.f1678d.isEmpty()) {
                f();
            }
        }
    }

    public void d(T t5) {
        synchronized (this.f1677c) {
            T t6 = this.f1679e;
            if (t6 != t5 && (t6 == null || !t6.equals(t5))) {
                this.f1679e = t5;
                this.f1675a.a().execute(new a(new ArrayList(this.f1678d)));
            }
        }
    }

    public abstract void e();

    public abstract void f();
}
