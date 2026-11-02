package androidx.work.impl;

import android.content.Context;
import androidx.room.g;
import androidx.room.h;
import androidx.work.impl.a;
import d0.e;
import d0.k;
import d0.n;
import d0.q;
import d0.t;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import q.c;

/* loaded from: classes.dex */
public abstract class WorkDatabase extends h {

    /* renamed from: l, reason: collision with root package name */
    private static final long f1516l = TimeUnit.DAYS.toMillis(1);

    class a implements c.InterfaceC0129c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f1517a;

        a(Context context) {
            this.f1517a = context;
        }

        @Override // q.c.InterfaceC0129c
        public c a(c.b bVar) {
            c.b.a a6 = c.b.a(this.f1517a);
            a6.c(bVar.f8657b).b(bVar.f8658c).d(true);
            return new r.c().a(a6.a());
        }
    }

    class b extends h.b {
        b() {
        }

        @Override // androidx.room.h.b
        public void c(q.b bVar) {
            super.c(bVar);
            bVar.f();
            try {
                bVar.l(WorkDatabase.y());
                bVar.J();
            } finally {
                bVar.e();
            }
        }
    }

    public static WorkDatabase u(Context context, Executor executor, boolean z5) {
        h.a a6;
        if (z5) {
            a6 = g.c(context, WorkDatabase.class).c();
        } else {
            a6 = g.a(context, WorkDatabase.class, w.h.d());
            a6.f(new a(context));
        }
        return (WorkDatabase) a6.g(executor).a(w()).b(androidx.work.impl.a.f1526a).b(new a.h(context, 2, 3)).b(androidx.work.impl.a.f1527b).b(androidx.work.impl.a.f1528c).b(new a.h(context, 5, 6)).b(androidx.work.impl.a.f1529d).b(androidx.work.impl.a.f1530e).b(androidx.work.impl.a.f1531f).b(new a.i(context)).b(new a.h(context, 10, 11)).b(androidx.work.impl.a.f1532g).e().d();
    }

    static h.b w() {
        return new b();
    }

    static long x() {
        return System.currentTimeMillis() - f1516l;
    }

    static String y() {
        return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (period_start_time + minimum_retention_duration) < " + x() + " AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
    }

    public abstract d0.h A();

    public abstract k B();

    public abstract n C();

    public abstract q D();

    public abstract t E();

    public abstract d0.b v();

    public abstract e z();
}
