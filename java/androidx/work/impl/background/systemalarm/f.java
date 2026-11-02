package androidx.work.impl.background.systemalarm;

import android.content.Context;
import d0.p;
import v.j;

/* loaded from: classes.dex */
public class f implements w.e {

    /* renamed from: b, reason: collision with root package name */
    private static final String f1581b = j.f("SystemAlarmScheduler");

    /* renamed from: a, reason: collision with root package name */
    private final Context f1582a;

    public f(Context context) {
        this.f1582a = context.getApplicationContext();
    }

    private void a(p pVar) {
        j.c().a(f1581b, String.format("Scheduling work with workSpecId %s", pVar.f2858a), new Throwable[0]);
        this.f1582a.startService(b.f(this.f1582a, pVar.f2858a));
    }

    @Override // w.e
    public void b(String str) {
        this.f1582a.startService(b.g(this.f1582a, str));
    }

    @Override // w.e
    public void d(p... pVarArr) {
        for (p pVar : pVarArr) {
            a(pVar);
        }
    }

    @Override // w.e
    public boolean f() {
        return true;
    }
}
