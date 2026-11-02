package io.flutter.embedding.engine;

import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import io.flutter.embedding.engine.plugins.lifecycle.HiddenLifecycleReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import q3.a;
import r3.c;
import y3.m;
import y3.n;
import y3.o;
import y3.p;

/* loaded from: classes.dex */
class c implements q3.b, r3.b {

    /* renamed from: b, reason: collision with root package name */
    private final io.flutter.embedding.engine.a f6015b;

    /* renamed from: c, reason: collision with root package name */
    private final a.b f6016c;

    /* renamed from: e, reason: collision with root package name */
    private io.flutter.embedding.android.c<Activity> f6018e;

    /* renamed from: f, reason: collision with root package name */
    private C0091c f6019f;

    /* renamed from: i, reason: collision with root package name */
    private Service f6022i;

    /* renamed from: k, reason: collision with root package name */
    private BroadcastReceiver f6024k;

    /* renamed from: m, reason: collision with root package name */
    private ContentProvider f6026m;

    /* renamed from: a, reason: collision with root package name */
    private final Map<Class<? extends q3.a>, q3.a> f6014a = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private final Map<Class<? extends q3.a>, r3.a> f6017d = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    private boolean f6020g = false;

    /* renamed from: h, reason: collision with root package name */
    private final Map<Class<? extends q3.a>, u3.a> f6021h = new HashMap();

    /* renamed from: j, reason: collision with root package name */
    private final Map<Class<? extends q3.a>, s3.a> f6023j = new HashMap();

    /* renamed from: l, reason: collision with root package name */
    private final Map<Class<? extends q3.a>, t3.a> f6025l = new HashMap();

    private static class b implements a.InterfaceC0133a {

        /* renamed from: a, reason: collision with root package name */
        final o3.d f6027a;

        private b(o3.d dVar) {
            this.f6027a = dVar;
        }
    }

    /* renamed from: io.flutter.embedding.engine.c$c, reason: collision with other inner class name */
    private static class C0091c implements r3.c {

        /* renamed from: a, reason: collision with root package name */
        private final Activity f6028a;

        /* renamed from: b, reason: collision with root package name */
        private final HiddenLifecycleReference f6029b;

        /* renamed from: c, reason: collision with root package name */
        private final Set<o> f6030c = new HashSet();

        /* renamed from: d, reason: collision with root package name */
        private final Set<m> f6031d = new HashSet();

        /* renamed from: e, reason: collision with root package name */
        private final Set<n> f6032e = new HashSet();

        /* renamed from: f, reason: collision with root package name */
        private final Set<p> f6033f = new HashSet();

        /* renamed from: g, reason: collision with root package name */
        private final Set<c.a> f6034g = new HashSet();

        public C0091c(Activity activity, androidx.lifecycle.d dVar) {
            this.f6028a = activity;
            this.f6029b = new HiddenLifecycleReference(dVar);
        }

        @Override // r3.c
        public void a(m mVar) {
            this.f6031d.add(mVar);
        }

        @Override // r3.c
        public void b(o oVar) {
            this.f6030c.remove(oVar);
        }

        @Override // r3.c
        public void c(o oVar) {
            this.f6030c.add(oVar);
        }

        @Override // r3.c
        public Activity d() {
            return this.f6028a;
        }

        @Override // r3.c
        public void e(m mVar) {
            this.f6031d.remove(mVar);
        }

        boolean f(int i6, int i7, Intent intent) {
            boolean z5;
            Iterator it = new HashSet(this.f6031d).iterator();
            while (true) {
                while (it.hasNext()) {
                    z5 = ((m) it.next()).a(i6, i7, intent) || z5;
                }
                return z5;
            }
        }

        void g(Intent intent) {
            Iterator<n> it = this.f6032e.iterator();
            while (it.hasNext()) {
                it.next().b(intent);
            }
        }

        boolean h(int i6, String[] strArr, int[] iArr) {
            boolean z5;
            Iterator<o> it = this.f6030c.iterator();
            while (true) {
                while (it.hasNext()) {
                    z5 = it.next().onRequestPermissionsResult(i6, strArr, iArr) || z5;
                }
                return z5;
            }
        }

        void i(Bundle bundle) {
            Iterator<c.a> it = this.f6034g.iterator();
            while (it.hasNext()) {
                it.next().c(bundle);
            }
        }

        void j(Bundle bundle) {
            Iterator<c.a> it = this.f6034g.iterator();
            while (it.hasNext()) {
                it.next().d(bundle);
            }
        }

        void k() {
            Iterator<p> it = this.f6033f.iterator();
            while (it.hasNext()) {
                it.next().e();
            }
        }
    }

    c(Context context, io.flutter.embedding.engine.a aVar, o3.d dVar) {
        this.f6015b = aVar;
        this.f6016c = new a.b(context, aVar, aVar.h(), aVar.p(), aVar.n().P(), new b(dVar));
    }

    private void j(Activity activity, androidx.lifecycle.d dVar) {
        this.f6019f = new C0091c(activity, dVar);
        this.f6015b.n().h0(activity.getIntent() != null ? activity.getIntent().getBooleanExtra("enable-software-rendering", false) : false);
        this.f6015b.n().B(activity, this.f6015b.p(), this.f6015b.h());
        for (r3.a aVar : this.f6017d.values()) {
            if (this.f6020g) {
                aVar.a(this.f6019f);
            } else {
                aVar.d(this.f6019f);
            }
        }
        this.f6020g = false;
    }

    private void l() {
        this.f6015b.n().J();
        this.f6018e = null;
        this.f6019f = null;
    }

    private void m() {
        if (r()) {
            i();
            return;
        }
        if (u()) {
            p();
        } else if (s()) {
            n();
        } else if (t()) {
            o();
        }
    }

    private boolean r() {
        return this.f6018e != null;
    }

    private boolean s() {
        return this.f6024k != null;
    }

    private boolean t() {
        return this.f6026m != null;
    }

    private boolean u() {
        return this.f6022i != null;
    }

    @Override // r3.b
    public boolean a(int i6, int i7, Intent intent) {
        if (!r()) {
            k3.b.b("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onActivityResult, but no Activity was attached.");
            return false;
        }
        d4.f.a("FlutterEngineConnectionRegistry#onActivityResult");
        try {
            return this.f6019f.f(i6, i7, intent);
        } finally {
            d4.f.d();
        }
    }

    @Override // r3.b
    public void b(Intent intent) {
        if (!r()) {
            k3.b.b("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onNewIntent, but no Activity was attached.");
            return;
        }
        d4.f.a("FlutterEngineConnectionRegistry#onNewIntent");
        try {
            this.f6019f.g(intent);
        } finally {
            d4.f.d();
        }
    }

    @Override // r3.b
    public void c(Bundle bundle) {
        if (!r()) {
            k3.b.b("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onRestoreInstanceState, but no Activity was attached.");
            return;
        }
        d4.f.a("FlutterEngineConnectionRegistry#onRestoreInstanceState");
        try {
            this.f6019f.i(bundle);
        } finally {
            d4.f.d();
        }
    }

    @Override // r3.b
    public void d(Bundle bundle) {
        if (!r()) {
            k3.b.b("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onSaveInstanceState, but no Activity was attached.");
            return;
        }
        d4.f.a("FlutterEngineConnectionRegistry#onSaveInstanceState");
        try {
            this.f6019f.j(bundle);
        } finally {
            d4.f.d();
        }
    }

    @Override // r3.b
    public void e() {
        if (!r()) {
            k3.b.b("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onUserLeaveHint, but no Activity was attached.");
            return;
        }
        d4.f.a("FlutterEngineConnectionRegistry#onUserLeaveHint");
        try {
            this.f6019f.k();
        } finally {
            d4.f.d();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // q3.b
    public void f(q3.a aVar) {
        d4.f.a("FlutterEngineConnectionRegistry#add " + aVar.getClass().getSimpleName());
        try {
            if (q(aVar.getClass())) {
                k3.b.g("FlutterEngineCxnRegstry", "Attempted to register plugin (" + aVar + ") but it was already registered with this FlutterEngine (" + this.f6015b + ").");
                return;
            }
            k3.b.f("FlutterEngineCxnRegstry", "Adding plugin: " + aVar);
            this.f6014a.put(aVar.getClass(), aVar);
            aVar.b(this.f6016c);
            if (aVar instanceof r3.a) {
                r3.a aVar2 = (r3.a) aVar;
                this.f6017d.put(aVar.getClass(), aVar2);
                if (r()) {
                    aVar2.d(this.f6019f);
                }
            }
            if (aVar instanceof u3.a) {
                u3.a aVar3 = (u3.a) aVar;
                this.f6021h.put(aVar.getClass(), aVar3);
                if (u()) {
                    aVar3.a(null);
                }
            }
            if (aVar instanceof s3.a) {
                s3.a aVar4 = (s3.a) aVar;
                this.f6023j.put(aVar.getClass(), aVar4);
                if (s()) {
                    aVar4.a(null);
                }
            }
            if (aVar instanceof t3.a) {
                t3.a aVar5 = (t3.a) aVar;
                this.f6025l.put(aVar.getClass(), aVar5);
                if (t()) {
                    aVar5.b(null);
                }
            }
        } finally {
            d4.f.d();
        }
    }

    @Override // r3.b
    public void g(io.flutter.embedding.android.c<Activity> cVar, androidx.lifecycle.d dVar) {
        d4.f.a("FlutterEngineConnectionRegistry#attachToActivity");
        try {
            io.flutter.embedding.android.c<Activity> cVar2 = this.f6018e;
            if (cVar2 != null) {
                cVar2.e();
            }
            m();
            this.f6018e = cVar;
            j(cVar.f(), dVar);
        } finally {
            d4.f.d();
        }
    }

    @Override // r3.b
    public void h() {
        if (!r()) {
            k3.b.b("FlutterEngineCxnRegstry", "Attempted to detach plugins from an Activity when no Activity was attached.");
            return;
        }
        d4.f.a("FlutterEngineConnectionRegistry#detachFromActivityForConfigChanges");
        try {
            this.f6020g = true;
            Iterator<r3.a> it = this.f6017d.values().iterator();
            while (it.hasNext()) {
                it.next().f();
            }
            l();
        } finally {
            d4.f.d();
        }
    }

    @Override // r3.b
    public void i() {
        if (!r()) {
            k3.b.b("FlutterEngineCxnRegstry", "Attempted to detach plugins from an Activity when no Activity was attached.");
            return;
        }
        d4.f.a("FlutterEngineConnectionRegistry#detachFromActivity");
        try {
            Iterator<r3.a> it = this.f6017d.values().iterator();
            while (it.hasNext()) {
                it.next().c();
            }
            l();
        } finally {
            d4.f.d();
        }
    }

    public void k() {
        k3.b.f("FlutterEngineCxnRegstry", "Destroying.");
        m();
        x();
    }

    public void n() {
        if (!s()) {
            k3.b.b("FlutterEngineCxnRegstry", "Attempted to detach plugins from a BroadcastReceiver when no BroadcastReceiver was attached.");
            return;
        }
        d4.f.a("FlutterEngineConnectionRegistry#detachFromBroadcastReceiver");
        try {
            Iterator<s3.a> it = this.f6023j.values().iterator();
            while (it.hasNext()) {
                it.next().b();
            }
        } finally {
            d4.f.d();
        }
    }

    public void o() {
        if (!t()) {
            k3.b.b("FlutterEngineCxnRegstry", "Attempted to detach plugins from a ContentProvider when no ContentProvider was attached.");
            return;
        }
        d4.f.a("FlutterEngineConnectionRegistry#detachFromContentProvider");
        try {
            Iterator<t3.a> it = this.f6025l.values().iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        } finally {
            d4.f.d();
        }
    }

    @Override // r3.b
    public boolean onRequestPermissionsResult(int i6, String[] strArr, int[] iArr) {
        if (!r()) {
            k3.b.b("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onRequestPermissionsResult, but no Activity was attached.");
            return false;
        }
        d4.f.a("FlutterEngineConnectionRegistry#onRequestPermissionsResult");
        try {
            return this.f6019f.h(i6, strArr, iArr);
        } finally {
            d4.f.d();
        }
    }

    public void p() {
        if (!u()) {
            k3.b.b("FlutterEngineCxnRegstry", "Attempted to detach plugins from a Service when no Service was attached.");
            return;
        }
        d4.f.a("FlutterEngineConnectionRegistry#detachFromService");
        try {
            Iterator<u3.a> it = this.f6021h.values().iterator();
            while (it.hasNext()) {
                it.next().b();
            }
            this.f6022i = null;
        } finally {
            d4.f.d();
        }
    }

    public boolean q(Class<? extends q3.a> cls) {
        return this.f6014a.containsKey(cls);
    }

    public void v(Class<? extends q3.a> cls) {
        q3.a aVar = this.f6014a.get(cls);
        if (aVar == null) {
            return;
        }
        d4.f.a("FlutterEngineConnectionRegistry#remove " + cls.getSimpleName());
        try {
            if (aVar instanceof r3.a) {
                if (r()) {
                    ((r3.a) aVar).c();
                }
                this.f6017d.remove(cls);
            }
            if (aVar instanceof u3.a) {
                if (u()) {
                    ((u3.a) aVar).b();
                }
                this.f6021h.remove(cls);
            }
            if (aVar instanceof s3.a) {
                if (s()) {
                    ((s3.a) aVar).b();
                }
                this.f6023j.remove(cls);
            }
            if (aVar instanceof t3.a) {
                if (t()) {
                    ((t3.a) aVar).a();
                }
                this.f6025l.remove(cls);
            }
            aVar.j(this.f6016c);
            this.f6014a.remove(cls);
        } finally {
            d4.f.d();
        }
    }

    public void w(Set<Class<? extends q3.a>> set) {
        Iterator<Class<? extends q3.a>> it = set.iterator();
        while (it.hasNext()) {
            v(it.next());
        }
    }

    public void x() {
        w(new HashSet(this.f6014a.keySet()));
        this.f6014a.clear();
    }
}
