package androidx.work.impl.workers;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import d0.g;
import d0.h;
import d0.k;
import d0.p;
import d0.q;
import d0.t;
import java.util.List;
import java.util.concurrent.TimeUnit;
import v.j;

/* loaded from: classes.dex */
public class DiagnosticsWorker extends Worker {

    /* renamed from: g, reason: collision with root package name */
    private static final String f1660g = j.f("DiagnosticsWrkr");

    public DiagnosticsWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    private static String r(p pVar, String str, Integer num, String str2) {
        return String.format("\n%s\t %s\t %s\t %s\t %s\t %s\t", pVar.f2858a, pVar.f2860c, num, pVar.f2859b.name(), str, str2);
    }

    private static String s(k kVar, t tVar, h hVar, List<p> list) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("\n Id \t Class Name\t %s\t State\t Unique Name\t Tags\t", Build.VERSION.SDK_INT >= 23 ? "Job Id" : "Alarm Id"));
        for (p pVar : list) {
            g b6 = hVar.b(pVar.f2858a);
            sb.append(r(pVar, TextUtils.join(",", kVar.b(pVar.f2858a)), b6 != null ? Integer.valueOf(b6.f2836b) : null, TextUtils.join(",", tVar.b(pVar.f2858a))));
        }
        return sb.toString();
    }

    @Override // androidx.work.Worker
    public ListenableWorker.a q() {
        WorkDatabase p6 = w.j.l(a()).p();
        q D = p6.D();
        k B = p6.B();
        t E = p6.E();
        h A = p6.A();
        List<p> h6 = D.h(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(1L));
        List<p> b6 = D.b();
        List<p> t5 = D.t(200);
        if (h6 != null && !h6.isEmpty()) {
            j c6 = j.c();
            String str = f1660g;
            c6.d(str, "Recently completed work:\n\n", new Throwable[0]);
            j.c().d(str, s(B, E, A, h6), new Throwable[0]);
        }
        if (b6 != null && !b6.isEmpty()) {
            j c7 = j.c();
            String str2 = f1660g;
            c7.d(str2, "Running work:\n\n", new Throwable[0]);
            j.c().d(str2, s(B, E, A, b6), new Throwable[0]);
        }
        if (t5 != null && !t5.isEmpty()) {
            j c8 = j.c();
            String str3 = f1660g;
            c8.d(str3, "Enqueued work:\n\n", new Throwable[0]);
            j.c().d(str3, s(B, E, A, t5), new Throwable[0]);
        }
        return ListenableWorker.a.c();
    }
}
