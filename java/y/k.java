package y;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemjob.SystemJobService;
import d0.p;
import d0.q;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import v.s;

/* loaded from: classes.dex */
public class k implements w.e {

    /* renamed from: e, reason: collision with root package name */
    private static final String f10666e = v.j.f("SystemJobScheduler");

    /* renamed from: a, reason: collision with root package name */
    private final Context f10667a;

    /* renamed from: b, reason: collision with root package name */
    private final JobScheduler f10668b;

    /* renamed from: c, reason: collision with root package name */
    private final w.j f10669c;

    /* renamed from: d, reason: collision with root package name */
    private final j f10670d;

    public k(Context context, w.j jVar) {
        this(context, jVar, (JobScheduler) context.getSystemService("jobscheduler"), new j(context));
    }

    public k(Context context, w.j jVar, JobScheduler jobScheduler, j jVar2) {
        this.f10667a = context;
        this.f10669c = jVar;
        this.f10668b = jobScheduler;
        this.f10670d = jVar2;
    }

    public static void a(Context context) {
        List<JobInfo> g6;
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler == null || (g6 = g(context, jobScheduler)) == null || g6.isEmpty()) {
            return;
        }
        Iterator<JobInfo> it = g6.iterator();
        while (it.hasNext()) {
            c(jobScheduler, it.next().getId());
        }
    }

    private static void c(JobScheduler jobScheduler, int i6) {
        try {
            jobScheduler.cancel(i6);
        } catch (Throwable th) {
            v.j.c().b(f10666e, String.format(Locale.getDefault(), "Exception while trying to cancel job (%d)", Integer.valueOf(i6)), th);
        }
    }

    private static List<Integer> e(Context context, JobScheduler jobScheduler, String str) {
        List<JobInfo> g6 = g(context, jobScheduler);
        if (g6 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(2);
        for (JobInfo jobInfo : g6) {
            if (str.equals(h(jobInfo))) {
                arrayList.add(Integer.valueOf(jobInfo.getId()));
            }
        }
        return arrayList;
    }

    private static List<JobInfo> g(Context context, JobScheduler jobScheduler) {
        List<JobInfo> list;
        try {
            list = jobScheduler.getAllPendingJobs();
        } catch (Throwable th) {
            v.j.c().b(f10666e, "getAllPendingJobs() is not reliable on this device.", th);
            list = null;
        }
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        ComponentName componentName = new ComponentName(context, (Class<?>) SystemJobService.class);
        for (JobInfo jobInfo : list) {
            if (componentName.equals(jobInfo.getService())) {
                arrayList.add(jobInfo);
            }
        }
        return arrayList;
    }

    private static String h(JobInfo jobInfo) {
        PersistableBundle extras = jobInfo.getExtras();
        if (extras == null) {
            return null;
        }
        try {
            if (extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return extras.getString("EXTRA_WORK_SPEC_ID");
            }
            return null;
        } catch (NullPointerException unused) {
            return null;
        }
    }

    public static boolean i(Context context, w.j jVar) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        List<JobInfo> g6 = g(context, jobScheduler);
        List<String> a6 = jVar.p().A().a();
        boolean z5 = false;
        HashSet hashSet = new HashSet(g6 != null ? g6.size() : 0);
        if (g6 != null && !g6.isEmpty()) {
            for (JobInfo jobInfo : g6) {
                String h6 = h(jobInfo);
                if (TextUtils.isEmpty(h6)) {
                    c(jobScheduler, jobInfo.getId());
                } else {
                    hashSet.add(h6);
                }
            }
        }
        Iterator<String> it = a6.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            if (!hashSet.contains(it.next())) {
                v.j.c().a(f10666e, "Reconciling jobs", new Throwable[0]);
                z5 = true;
                break;
            }
        }
        if (z5) {
            WorkDatabase p6 = jVar.p();
            p6.c();
            try {
                q D = p6.D();
                Iterator<String> it2 = a6.iterator();
                while (it2.hasNext()) {
                    D.e(it2.next(), -1L);
                }
                p6.t();
            } finally {
                p6.g();
            }
        }
        return z5;
    }

    @Override // w.e
    public void b(String str) {
        List<Integer> e6 = e(this.f10667a, this.f10668b, str);
        if (e6 == null || e6.isEmpty()) {
            return;
        }
        Iterator<Integer> it = e6.iterator();
        while (it.hasNext()) {
            c(this.f10668b, it.next().intValue());
        }
        this.f10669c.p().A().d(str);
    }

    @Override // w.e
    public void d(p... pVarArr) {
        List<Integer> e6;
        WorkDatabase p6 = this.f10669c.p();
        e0.e eVar = new e0.e(p6);
        for (p pVar : pVarArr) {
            p6.c();
            try {
                p l6 = p6.D().l(pVar.f2858a);
                if (l6 == null) {
                    v.j.c().h(f10666e, "Skipping scheduling " + pVar.f2858a + " because it's no longer in the DB", new Throwable[0]);
                } else if (l6.f2859b != s.a.ENQUEUED) {
                    v.j.c().h(f10666e, "Skipping scheduling " + pVar.f2858a + " because it is no longer enqueued", new Throwable[0]);
                } else {
                    d0.g b6 = p6.A().b(pVar.f2858a);
                    int d6 = b6 != null ? b6.f2836b : eVar.d(this.f10669c.j().i(), this.f10669c.j().g());
                    if (b6 == null) {
                        this.f10669c.p().A().c(new d0.g(pVar.f2858a, d6));
                    }
                    j(pVar, d6);
                    if (Build.VERSION.SDK_INT == 23 && (e6 = e(this.f10667a, this.f10668b, pVar.f2858a)) != null) {
                        int indexOf = e6.indexOf(Integer.valueOf(d6));
                        if (indexOf >= 0) {
                            e6.remove(indexOf);
                        }
                        j(pVar, !e6.isEmpty() ? e6.get(0).intValue() : eVar.d(this.f10669c.j().i(), this.f10669c.j().g()));
                    }
                }
                p6.t();
                p6.g();
            } catch (Throwable th) {
                p6.g();
                throw th;
            }
        }
    }

    @Override // w.e
    public boolean f() {
        return true;
    }

    public void j(p pVar, int i6) {
        JobInfo a6 = this.f10670d.a(pVar, i6);
        v.j c6 = v.j.c();
        String str = f10666e;
        c6.a(str, String.format("Scheduling work ID %s Job ID %s", pVar.f2858a, Integer.valueOf(i6)), new Throwable[0]);
        try {
            if (this.f10668b.schedule(a6) == 0) {
                v.j.c().h(str, String.format("Unable to schedule work ID %s", pVar.f2858a), new Throwable[0]);
                if (pVar.f2874q && pVar.f2875r == v.n.RUN_AS_NON_EXPEDITED_WORK_REQUEST) {
                    pVar.f2874q = false;
                    v.j.c().a(str, String.format("Scheduling a non-expedited job (work ID %s)", pVar.f2858a), new Throwable[0]);
                    j(pVar, i6);
                }
            }
        } catch (IllegalStateException e6) {
            List<JobInfo> g6 = g(this.f10667a, this.f10668b);
            String format = String.format(Locale.getDefault(), "JobScheduler 100 job limit exceeded.  We count %d WorkManager jobs in JobScheduler; we have %d tracked jobs in our DB; our Configuration limit is %d.", Integer.valueOf(g6 != null ? g6.size() : 0), Integer.valueOf(this.f10669c.p().D().s().size()), Integer.valueOf(this.f10669c.j().h()));
            v.j.c().b(f10666e, format, new Throwable[0]);
            throw new IllegalStateException(format, e6);
        } catch (Throwable th) {
            v.j.c().b(f10666e, String.format("Unable to schedule %s", pVar), th);
        }
    }
}
