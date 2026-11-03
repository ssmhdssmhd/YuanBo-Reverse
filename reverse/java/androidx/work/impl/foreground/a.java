package androidx.work.impl.foreground;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.impl.WorkDatabase;
import d0.p;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import v.e;
import v.j;
import z.c;
import z.d;

/* loaded from: classes.dex */
public class a implements c, w.b {

    /* renamed from: k, reason: collision with root package name */
    static final String f1602k = j.f("SystemFgDispatcher");

    /* renamed from: a, reason: collision with root package name */
    private Context f1603a;

    /* renamed from: b, reason: collision with root package name */
    private w.j f1604b;

    /* renamed from: c, reason: collision with root package name */
    private final f0.a f1605c;

    /* renamed from: d, reason: collision with root package name */
    final Object f1606d = new Object();

    /* renamed from: e, reason: collision with root package name */
    String f1607e;

    /* renamed from: f, reason: collision with root package name */
    final Map<String, e> f1608f;

    /* renamed from: g, reason: collision with root package name */
    final Map<String, p> f1609g;

    /* renamed from: h, reason: collision with root package name */
    final Set<p> f1610h;

    /* renamed from: i, reason: collision with root package name */
    final d f1611i;

    /* renamed from: j, reason: collision with root package name */
    private b f1612j;

    /* renamed from: androidx.work.impl.foreground.a$a, reason: collision with other inner class name */
    class RunnableC0031a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WorkDatabase f1613a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f1614b;

        RunnableC0031a(WorkDatabase workDatabase, String str) {
            this.f1613a = workDatabase;
            this.f1614b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            p l6 = this.f1613a.D().l(this.f1614b);
            if (l6 == null || !l6.b()) {
                return;
            }
            synchronized (a.this.f1606d) {
                a.this.f1609g.put(this.f1614b, l6);
                a.this.f1610h.add(l6);
                a aVar = a.this;
                aVar.f1611i.d(aVar.f1610h);
            }
        }
    }

    interface b {
        void b();

        void d(int i6);

        void e(int i6, int i7, Notification notification);

        void f(int i6, Notification notification);
    }

    a(Context context) {
        this.f1603a = context;
        w.j l6 = w.j.l(context);
        this.f1604b = l6;
        f0.a q6 = l6.q();
        this.f1605c = q6;
        this.f1607e = null;
        this.f1608f = new LinkedHashMap();
        this.f1610h = new HashSet();
        this.f1609g = new HashMap();
        this.f1611i = new d(this.f1603a, q6, this);
        this.f1604b.n().d(this);
    }

    public static Intent b(Context context, String str, e eVar) {
        Intent intent = new Intent(context, (Class<?>) SystemForegroundService.class);
        intent.setAction("ACTION_NOTIFY");
        intent.putExtra("KEY_NOTIFICATION_ID", eVar.c());
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", eVar.a());
        intent.putExtra("KEY_NOTIFICATION", eVar.b());
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    public static Intent d(Context context, String str, e eVar) {
        Intent intent = new Intent(context, (Class<?>) SystemForegroundService.class);
        intent.setAction("ACTION_START_FOREGROUND");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        intent.putExtra("KEY_NOTIFICATION_ID", eVar.c());
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", eVar.a());
        intent.putExtra("KEY_NOTIFICATION", eVar.b());
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    public static Intent f(Context context) {
        Intent intent = new Intent(context, (Class<?>) SystemForegroundService.class);
        intent.setAction("ACTION_STOP_FOREGROUND");
        return intent;
    }

    private void g(Intent intent) {
        j.c().d(f1602k, String.format("Stopping foreground work for %s", intent), new Throwable[0]);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        if (stringExtra == null || TextUtils.isEmpty(stringExtra)) {
            return;
        }
        this.f1604b.g(UUID.fromString(stringExtra));
    }

    private void h(Intent intent) {
        int i6 = 0;
        int intExtra = intent.getIntExtra("KEY_NOTIFICATION_ID", 0);
        int intExtra2 = intent.getIntExtra("KEY_FOREGROUND_SERVICE_TYPE", 0);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        Notification notification = (Notification) intent.getParcelableExtra("KEY_NOTIFICATION");
        j.c().a(f1602k, String.format("Notifying with (id: %s, workSpecId: %s, notificationType: %s)", Integer.valueOf(intExtra), stringExtra, Integer.valueOf(intExtra2)), new Throwable[0]);
        if (notification == null || this.f1612j == null) {
            return;
        }
        this.f1608f.put(stringExtra, new e(intExtra, notification, intExtra2));
        if (TextUtils.isEmpty(this.f1607e)) {
            this.f1607e = stringExtra;
            this.f1612j.e(intExtra, intExtra2, notification);
            return;
        }
        this.f1612j.f(intExtra, notification);
        if (intExtra2 == 0 || Build.VERSION.SDK_INT < 29) {
            return;
        }
        Iterator<Map.Entry<String, e>> it = this.f1608f.entrySet().iterator();
        while (it.hasNext()) {
            i6 |= it.next().getValue().a();
        }
        e eVar = this.f1608f.get(this.f1607e);
        if (eVar != null) {
            this.f1612j.e(eVar.c(), i6, eVar.b());
        }
    }

    private void i(Intent intent) {
        j.c().d(f1602k, String.format("Started foreground service %s", intent), new Throwable[0]);
        this.f1605c.b(new RunnableC0031a(this.f1604b.p(), intent.getStringExtra("KEY_WORKSPEC_ID")));
    }

    @Override // w.b
    public void a(String str, boolean z5) {
        Map.Entry<String, e> next;
        synchronized (this.f1606d) {
            p remove = this.f1609g.remove(str);
            if (remove != null ? this.f1610h.remove(remove) : false) {
                this.f1611i.d(this.f1610h);
            }
        }
        e remove2 = this.f1608f.remove(str);
        if (str.equals(this.f1607e) && this.f1608f.size() > 0) {
            Iterator<Map.Entry<String, e>> it = this.f1608f.entrySet().iterator();
            do {
                next = it.next();
            } while (it.hasNext());
            this.f1607e = next.getKey();
            if (this.f1612j != null) {
                e value = next.getValue();
                this.f1612j.e(value.c(), value.a(), value.b());
                this.f1612j.d(value.c());
            }
        }
        b bVar = this.f1612j;
        if (remove2 == null || bVar == null) {
            return;
        }
        j.c().a(f1602k, String.format("Removing Notification (id: %s, workSpecId: %s ,notificationType: %s)", Integer.valueOf(remove2.c()), str, Integer.valueOf(remove2.a())), new Throwable[0]);
        bVar.d(remove2.c());
    }

    @Override // z.c
    public void c(List<String> list) {
        if (list.isEmpty()) {
            return;
        }
        for (String str : list) {
            j.c().a(f1602k, String.format("Constraints unmet for WorkSpec %s", str), new Throwable[0]);
            this.f1604b.x(str);
        }
    }

    @Override // z.c
    public void e(List<String> list) {
    }

    void j(Intent intent) {
        j.c().d(f1602k, "Stopping foreground service", new Throwable[0]);
        b bVar = this.f1612j;
        if (bVar != null) {
            bVar.b();
        }
    }

    void k() {
        this.f1612j = null;
        synchronized (this.f1606d) {
            this.f1611i.e();
        }
        this.f1604b.n().i(this);
    }

    void l(Intent intent) {
        String action = intent.getAction();
        if ("ACTION_START_FOREGROUND".equals(action)) {
            i(intent);
        } else if (!"ACTION_NOTIFY".equals(action)) {
            if ("ACTION_CANCEL_WORK".equals(action)) {
                g(intent);
                return;
            } else {
                if ("ACTION_STOP_FOREGROUND".equals(action)) {
                    j(intent);
                    return;
                }
                return;
            }
        }
        h(intent);
    }

    void m(b bVar) {
        if (this.f1612j != null) {
            j.c().b(f1602k, "A callback already exists.", new Throwable[0]);
        } else {
            this.f1612j = bVar;
        }
    }
}
