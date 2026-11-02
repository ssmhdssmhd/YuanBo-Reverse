package e0;

import android.text.TextUtils;
import androidx.work.b;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import java.util.Iterator;
import java.util.List;
import v.m;

/* loaded from: classes.dex */
public class b implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    private static final String f3316c = v.j.f("EnqueueRunnable");

    /* renamed from: a, reason: collision with root package name */
    private final w.g f3317a;

    /* renamed from: b, reason: collision with root package name */
    private final w.c f3318b = new w.c();

    public b(w.g gVar) {
        this.f3317a = gVar;
    }

    private static boolean b(w.g gVar) {
        boolean c6 = c(gVar.g(), gVar.f(), (String[]) w.g.l(gVar).toArray(new String[0]), gVar.d(), gVar.b());
        gVar.k();
        return c6;
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01db A[LOOP:5: B:87:0x01d5->B:89:0x01db, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0204 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean c(w.j r19, java.util.List<? extends v.u> r20, java.lang.String[] r21, java.lang.String r22, v.d r23) {
        /*
            Method dump skipped, instructions count: 523
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e0.b.c(w.j, java.util.List, java.lang.String[], java.lang.String, v.d):boolean");
    }

    private static boolean e(w.g gVar) {
        List<w.g> e6 = gVar.e();
        boolean z5 = false;
        if (e6 != null) {
            boolean z6 = false;
            for (w.g gVar2 : e6) {
                if (gVar2.j()) {
                    v.j.c().h(f3316c, String.format("Already enqueued work ids (%s).", TextUtils.join(", ", gVar2.c())), new Throwable[0]);
                } else {
                    z6 |= e(gVar2);
                }
            }
            z5 = z6;
        }
        return b(gVar) | z5;
    }

    private static void g(d0.p pVar) {
        v.b bVar = pVar.f2867j;
        String str = pVar.f2860c;
        if (str.equals(ConstraintTrackingWorker.class.getName())) {
            return;
        }
        if (bVar.f() || bVar.i()) {
            b.a aVar = new b.a();
            aVar.c(pVar.f2862e).f("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME", str);
            pVar.f2860c = ConstraintTrackingWorker.class.getName();
            pVar.f2862e = aVar.a();
        }
    }

    private static boolean h(w.j jVar, String str) {
        try {
            Class<?> cls = Class.forName(str);
            Iterator<w.e> it = jVar.o().iterator();
            while (it.hasNext()) {
                if (cls.isAssignableFrom(it.next().getClass())) {
                    return true;
                }
            }
        } catch (ClassNotFoundException unused) {
        }
        return false;
    }

    public boolean a() {
        WorkDatabase p6 = this.f3317a.g().p();
        p6.c();
        try {
            boolean e6 = e(this.f3317a);
            p6.t();
            return e6;
        } finally {
            p6.g();
        }
    }

    public v.m d() {
        return this.f3318b;
    }

    public void f() {
        w.j g6 = this.f3317a.g();
        w.f.b(g6.j(), g6.p(), g6.o());
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.f3317a.h()) {
                throw new IllegalStateException(String.format("WorkContinuation has cycles (%s)", this.f3317a));
            }
            if (a()) {
                g.a(this.f3317a.g().i(), RescheduleReceiver.class, true);
                f();
            }
            this.f3318b.a(v.m.f9721a);
        } catch (Throwable th) {
            this.f3318b.a(new m.b.a(th));
        }
    }
}
