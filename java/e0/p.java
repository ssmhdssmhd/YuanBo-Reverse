package e0;

import android.content.Context;
import androidx.work.impl.WorkDatabase;
import java.util.UUID;
import v.s;

/* loaded from: classes.dex */
public class p implements v.f {

    /* renamed from: d, reason: collision with root package name */
    private static final String f3356d = v.j.f("WMFgUpdater");

    /* renamed from: a, reason: collision with root package name */
    private final f0.a f3357a;

    /* renamed from: b, reason: collision with root package name */
    final c0.a f3358b;

    /* renamed from: c, reason: collision with root package name */
    final d0.q f3359c;

    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ androidx.work.impl.utils.futures.d f3360a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ UUID f3361b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ v.e f3362c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f3363d;

        a(androidx.work.impl.utils.futures.d dVar, UUID uuid, v.e eVar, Context context) {
            this.f3360a = dVar;
            this.f3361b = uuid;
            this.f3362c = eVar;
            this.f3363d = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (!this.f3360a.isCancelled()) {
                    String uuid = this.f3361b.toString();
                    s.a j6 = p.this.f3359c.j(uuid);
                    if (j6 == null || j6.a()) {
                        throw new IllegalStateException("Calls to setForegroundAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
                    }
                    p.this.f3358b.c(uuid, this.f3362c);
                    this.f3363d.startService(androidx.work.impl.foreground.a.b(this.f3363d, uuid, this.f3362c));
                }
                this.f3360a.p(null);
            } catch (Throwable th) {
                this.f3360a.q(th);
            }
        }
    }

    public p(WorkDatabase workDatabase, c0.a aVar, f0.a aVar2) {
        this.f3358b = aVar;
        this.f3357a = aVar2;
        this.f3359c = workDatabase.D();
    }

    @Override // v.f
    public p2.a<Void> a(Context context, UUID uuid, v.e eVar) {
        androidx.work.impl.utils.futures.d t5 = androidx.work.impl.utils.futures.d.t();
        this.f3357a.b(new a(t5, uuid, eVar, context));
        return t5;
    }
}
