package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.e;
import d0.p;
import java.util.HashMap;
import java.util.Map;
import v.j;

/* loaded from: classes.dex */
public class b implements w.b {

    /* renamed from: d, reason: collision with root package name */
    private static final String f1546d = j.f("CommandHandler");

    /* renamed from: a, reason: collision with root package name */
    private final Context f1547a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, w.b> f1548b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private final Object f1549c = new Object();

    b(Context context) {
        this.f1547a = context;
    }

    static Intent b(Context context) {
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_CONSTRAINTS_CHANGED");
        return intent;
    }

    static Intent c(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_DELAY_MET");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    static Intent d(Context context, String str, boolean z5) {
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_EXECUTION_COMPLETED");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        intent.putExtra("KEY_NEEDS_RESCHEDULE", z5);
        return intent;
    }

    static Intent e(Context context) {
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_RESCHEDULE");
        return intent;
    }

    static Intent f(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_SCHEDULE_WORK");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    static Intent g(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_STOP_WORK");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    private void h(Intent intent, int i6, e eVar) {
        j.c().a(f1546d, String.format("Handling constraints changed %s", intent), new Throwable[0]);
        new c(this.f1547a, i6, eVar).a();
    }

    private void i(Intent intent, int i6, e eVar) {
        Bundle extras = intent.getExtras();
        synchronized (this.f1549c) {
            String string = extras.getString("KEY_WORKSPEC_ID");
            j c6 = j.c();
            String str = f1546d;
            c6.a(str, String.format("Handing delay met for %s", string), new Throwable[0]);
            if (this.f1548b.containsKey(string)) {
                j.c().a(str, String.format("WorkSpec %s is already being handled for ACTION_DELAY_MET", string), new Throwable[0]);
            } else {
                d dVar = new d(this.f1547a, i6, string, eVar);
                this.f1548b.put(string, dVar);
                dVar.f();
            }
        }
    }

    private void j(Intent intent, int i6) {
        Bundle extras = intent.getExtras();
        String string = extras.getString("KEY_WORKSPEC_ID");
        boolean z5 = extras.getBoolean("KEY_NEEDS_RESCHEDULE");
        j.c().a(f1546d, String.format("Handling onExecutionCompleted %s, %s", intent, Integer.valueOf(i6)), new Throwable[0]);
        a(string, z5);
    }

    private void k(Intent intent, int i6, e eVar) {
        j.c().a(f1546d, String.format("Handling reschedule %s, %s", intent, Integer.valueOf(i6)), new Throwable[0]);
        eVar.g().t();
    }

    private void l(Intent intent, int i6, e eVar) {
        String string = intent.getExtras().getString("KEY_WORKSPEC_ID");
        j c6 = j.c();
        String str = f1546d;
        c6.a(str, String.format("Handling schedule work for %s", string), new Throwable[0]);
        WorkDatabase p6 = eVar.g().p();
        p6.c();
        try {
            p l6 = p6.D().l(string);
            if (l6 == null) {
                j.c().h(str, "Skipping scheduling " + string + " because it's no longer in the DB", new Throwable[0]);
                return;
            }
            if (l6.f2859b.a()) {
                j.c().h(str, "Skipping scheduling " + string + "because it is finished.", new Throwable[0]);
                return;
            }
            long a6 = l6.a();
            if (l6.b()) {
                j.c().a(str, String.format("Opportunistically setting an alarm for %s at %s", string, Long.valueOf(a6)), new Throwable[0]);
                a.c(this.f1547a, eVar.g(), string, a6);
                eVar.k(new e.b(eVar, b(this.f1547a), i6));
            } else {
                j.c().a(str, String.format("Setting up Alarms for %s at %s", string, Long.valueOf(a6)), new Throwable[0]);
                a.c(this.f1547a, eVar.g(), string, a6);
            }
            p6.t();
        } finally {
            p6.g();
        }
    }

    private void m(Intent intent, e eVar) {
        String string = intent.getExtras().getString("KEY_WORKSPEC_ID");
        j.c().a(f1546d, String.format("Handing stopWork work for %s", string), new Throwable[0]);
        eVar.g().y(string);
        a.a(this.f1547a, eVar.g(), string);
        eVar.a(string, false);
    }

    private static boolean n(Bundle bundle, String... strArr) {
        if (bundle == null || bundle.isEmpty()) {
            return false;
        }
        for (String str : strArr) {
            if (bundle.get(str) == null) {
                return false;
            }
        }
        return true;
    }

    @Override // w.b
    public void a(String str, boolean z5) {
        synchronized (this.f1549c) {
            w.b remove = this.f1548b.remove(str);
            if (remove != null) {
                remove.a(str, z5);
            }
        }
    }

    boolean o() {
        boolean z5;
        synchronized (this.f1549c) {
            z5 = !this.f1548b.isEmpty();
        }
        return z5;
    }

    void p(Intent intent, int i6, e eVar) {
        String action = intent.getAction();
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action)) {
            h(intent, i6, eVar);
            return;
        }
        if ("ACTION_RESCHEDULE".equals(action)) {
            k(intent, i6, eVar);
            return;
        }
        if (!n(intent.getExtras(), "KEY_WORKSPEC_ID")) {
            j.c().b(f1546d, String.format("Invalid request for %s, requires %s.", action, "KEY_WORKSPEC_ID"), new Throwable[0]);
            return;
        }
        if ("ACTION_SCHEDULE_WORK".equals(action)) {
            l(intent, i6, eVar);
            return;
        }
        if ("ACTION_DELAY_MET".equals(action)) {
            i(intent, i6, eVar);
            return;
        }
        if ("ACTION_STOP_WORK".equals(action)) {
            m(intent, eVar);
        } else if ("ACTION_EXECUTION_COMPLETED".equals(action)) {
            j(intent, i6);
        } else {
            j.c().h(f1546d, String.format("Ignoring intent %s", intent), new Throwable[0]);
        }
    }
}
