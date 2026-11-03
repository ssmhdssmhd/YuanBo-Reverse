package androidx.room;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.room.b;
import androidx.room.c;
import androidx.room.e;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
class f {

    /* renamed from: a, reason: collision with root package name */
    final Context f1339a;

    /* renamed from: b, reason: collision with root package name */
    final String f1340b;

    /* renamed from: c, reason: collision with root package name */
    int f1341c;

    /* renamed from: d, reason: collision with root package name */
    final androidx.room.e f1342d;

    /* renamed from: e, reason: collision with root package name */
    final e.c f1343e;

    /* renamed from: f, reason: collision with root package name */
    androidx.room.c f1344f;

    /* renamed from: g, reason: collision with root package name */
    final Executor f1345g;

    /* renamed from: h, reason: collision with root package name */
    final androidx.room.b f1346h = new a();

    /* renamed from: i, reason: collision with root package name */
    final AtomicBoolean f1347i = new AtomicBoolean(false);

    /* renamed from: j, reason: collision with root package name */
    final ServiceConnection f1348j;

    /* renamed from: k, reason: collision with root package name */
    final Runnable f1349k;

    /* renamed from: l, reason: collision with root package name */
    final Runnable f1350l;

    /* renamed from: m, reason: collision with root package name */
    private final Runnable f1351m;

    class a extends b.a {

        /* renamed from: androidx.room.f$a$a, reason: collision with other inner class name */
        class RunnableC0026a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String[] f1353a;

            RunnableC0026a(String[] strArr) {
                this.f1353a = strArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                f.this.f1342d.g(this.f1353a);
            }
        }

        a() {
        }

        @Override // androidx.room.b
        public void a(String[] strArr) {
            f.this.f1345g.execute(new RunnableC0026a(strArr));
        }
    }

    class b implements ServiceConnection {
        b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            f.this.f1344f = c.a.p0(iBinder);
            f fVar = f.this;
            fVar.f1345g.execute(fVar.f1349k);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            f fVar = f.this;
            fVar.f1345g.execute(fVar.f1350l);
            f.this.f1344f = null;
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                f fVar = f.this;
                androidx.room.c cVar = fVar.f1344f;
                if (cVar != null) {
                    fVar.f1341c = cVar.Q(fVar.f1346h, fVar.f1340b);
                    f fVar2 = f.this;
                    fVar2.f1342d.a(fVar2.f1343e);
                }
            } catch (RemoteException e6) {
                Log.w("ROOM", "Cannot register multi-instance invalidation callback", e6);
            }
        }
    }

    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f fVar = f.this;
            fVar.f1342d.i(fVar.f1343e);
        }
    }

    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f fVar = f.this;
            fVar.f1342d.i(fVar.f1343e);
            try {
                f fVar2 = f.this;
                androidx.room.c cVar = fVar2.f1344f;
                if (cVar != null) {
                    cVar.i0(fVar2.f1346h, fVar2.f1341c);
                }
            } catch (RemoteException e6) {
                Log.w("ROOM", "Cannot unregister multi-instance invalidation callback", e6);
            }
            f fVar3 = f.this;
            fVar3.f1339a.unbindService(fVar3.f1348j);
        }
    }

    /* renamed from: androidx.room.f$f, reason: collision with other inner class name */
    class C0027f extends e.c {
        C0027f(String[] strArr) {
            super(strArr);
        }

        @Override // androidx.room.e.c
        boolean a() {
            return true;
        }

        @Override // androidx.room.e.c
        public void b(Set<String> set) {
            if (f.this.f1347i.get()) {
                return;
            }
            try {
                f fVar = f.this;
                androidx.room.c cVar = fVar.f1344f;
                if (cVar != null) {
                    cVar.e0(fVar.f1341c, (String[]) set.toArray(new String[0]));
                }
            } catch (RemoteException e6) {
                Log.w("ROOM", "Cannot broadcast invalidation", e6);
            }
        }
    }

    f(Context context, String str, androidx.room.e eVar, Executor executor) {
        b bVar = new b();
        this.f1348j = bVar;
        this.f1349k = new c();
        this.f1350l = new d();
        this.f1351m = new e();
        Context applicationContext = context.getApplicationContext();
        this.f1339a = applicationContext;
        this.f1340b = str;
        this.f1342d = eVar;
        this.f1345g = executor;
        this.f1343e = new C0027f((String[]) eVar.f1314a.keySet().toArray(new String[0]));
        applicationContext.bindService(new Intent(applicationContext, (Class<?>) MultiInstanceInvalidationService.class), bVar, 1);
    }
}
