package w;

import android.content.Context;
import android.os.Build;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import androidx.work.impl.background.systemjob.SystemJobService;
import d0.p;
import d0.q;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static final String f9923a = v.j.f("Schedulers");

    static e a(Context context, j jVar) {
        if (Build.VERSION.SDK_INT >= 23) {
            y.k kVar = new y.k(context, jVar);
            e0.g.a(context, SystemJobService.class, true);
            v.j.c().a(f9923a, "Created SystemJobScheduler and enabled SystemJobService", new Throwable[0]);
            return kVar;
        }
        e c6 = c(context);
        if (c6 != null) {
            return c6;
        }
        androidx.work.impl.background.systemalarm.f fVar = new androidx.work.impl.background.systemalarm.f(context);
        e0.g.a(context, SystemAlarmService.class, true);
        v.j.c().a(f9923a, "Created SystemAlarmScheduler", new Throwable[0]);
        return fVar;
    }

    public static void b(androidx.work.a aVar, WorkDatabase workDatabase, List<e> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        q D = workDatabase.D();
        workDatabase.c();
        try {
            List<p> k6 = D.k(aVar.h());
            List<p> t5 = D.t(200);
            if (k6 != null && k6.size() > 0) {
                long currentTimeMillis = System.currentTimeMillis();
                Iterator<p> it = k6.iterator();
                while (it.hasNext()) {
                    D.e(it.next().f2858a, currentTimeMillis);
                }
            }
            workDatabase.t();
            if (k6 != null && k6.size() > 0) {
                p[] pVarArr = (p[]) k6.toArray(new p[k6.size()]);
                for (e eVar : list) {
                    if (eVar.f()) {
                        eVar.d(pVarArr);
                    }
                }
            }
            if (t5 == null || t5.size() <= 0) {
                return;
            }
            p[] pVarArr2 = (p[]) t5.toArray(new p[t5.size()]);
            for (e eVar2 : list) {
                if (!eVar2.f()) {
                    eVar2.d(pVarArr2);
                }
            }
        } finally {
            workDatabase.g();
        }
    }

    private static e c(Context context) {
        try {
            e eVar = (e) Class.forName("androidx.work.impl.background.gcm.GcmScheduler").getConstructor(Context.class).newInstance(context);
            v.j.c().a(f9923a, String.format("Created %s", "androidx.work.impl.background.gcm.GcmScheduler"), new Throwable[0]);
            return eVar;
        } catch (Throwable th) {
            v.j.c().a(f9923a, "Unable to create GCM Scheduler", th);
            return null;
        }
    }
}
