package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import androidx.work.impl.background.systemalarm.e;
import d0.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import v.j;

/* loaded from: classes.dex */
class c {

    /* renamed from: e, reason: collision with root package name */
    private static final String f1550e = j.f("ConstraintsCmdHandler");

    /* renamed from: a, reason: collision with root package name */
    private final Context f1551a;

    /* renamed from: b, reason: collision with root package name */
    private final int f1552b;

    /* renamed from: c, reason: collision with root package name */
    private final e f1553c;

    /* renamed from: d, reason: collision with root package name */
    private final z.d f1554d;

    c(Context context, int i6, e eVar) {
        this.f1551a = context;
        this.f1552b = i6;
        this.f1553c = eVar;
        this.f1554d = new z.d(context, eVar.f(), null);
    }

    void a() {
        List<p> s5 = this.f1553c.g().p().D().s();
        ConstraintProxy.a(this.f1551a, s5);
        this.f1554d.d(s5);
        ArrayList arrayList = new ArrayList(s5.size());
        long currentTimeMillis = System.currentTimeMillis();
        for (p pVar : s5) {
            String str = pVar.f2858a;
            if (currentTimeMillis >= pVar.a() && (!pVar.b() || this.f1554d.c(str))) {
                arrayList.add(pVar);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str2 = ((p) it.next()).f2858a;
            Intent c6 = b.c(this.f1551a, str2);
            j.c().a(f1550e, String.format("Creating a delay_met command for workSpec with id (%s)", str2), new Throwable[0]);
            e eVar = this.f1553c;
            eVar.k(new e.b(eVar, c6, this.f1552b));
        }
        this.f1554d.e();
    }
}
