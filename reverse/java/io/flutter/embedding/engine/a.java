package io.flutter.embedding.engine;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import io.flutter.plugin.platform.u;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import x3.l;
import x3.m;
import x3.n;
import x3.o;
import x3.p;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final FlutterJNI f5991a;

    /* renamed from: b, reason: collision with root package name */
    private final w3.a f5992b;

    /* renamed from: c, reason: collision with root package name */
    private final m3.a f5993c;

    /* renamed from: d, reason: collision with root package name */
    private final c f5994d;

    /* renamed from: e, reason: collision with root package name */
    private final z3.d f5995e;

    /* renamed from: f, reason: collision with root package name */
    private final x3.a f5996f;

    /* renamed from: g, reason: collision with root package name */
    private final x3.b f5997g;

    /* renamed from: h, reason: collision with root package name */
    private final x3.e f5998h;

    /* renamed from: i, reason: collision with root package name */
    private final x3.f f5999i;

    /* renamed from: j, reason: collision with root package name */
    private final x3.g f6000j;

    /* renamed from: k, reason: collision with root package name */
    private final x3.h f6001k;

    /* renamed from: l, reason: collision with root package name */
    private final l f6002l;

    /* renamed from: m, reason: collision with root package name */
    private final x3.i f6003m;

    /* renamed from: n, reason: collision with root package name */
    private final m f6004n;

    /* renamed from: o, reason: collision with root package name */
    private final n f6005o;

    /* renamed from: p, reason: collision with root package name */
    private final o f6006p;

    /* renamed from: q, reason: collision with root package name */
    private final p f6007q;

    /* renamed from: r, reason: collision with root package name */
    private final u f6008r;

    /* renamed from: s, reason: collision with root package name */
    private final Set<b> f6009s;

    /* renamed from: t, reason: collision with root package name */
    private final b f6010t;

    /* renamed from: io.flutter.embedding.engine.a$a, reason: collision with other inner class name */
    class C0090a implements b {
        C0090a() {
        }

        @Override // io.flutter.embedding.engine.a.b
        public void a() {
        }

        @Override // io.flutter.embedding.engine.a.b
        public void b() {
            k3.b.f("FlutterEngine", "onPreEngineRestart()");
            Iterator it = a.this.f6009s.iterator();
            while (it.hasNext()) {
                ((b) it.next()).b();
            }
            a.this.f6008r.b0();
            a.this.f6002l.g();
        }
    }

    public interface b {
        void a();

        void b();
    }

    public a(Context context, o3.d dVar, FlutterJNI flutterJNI, u uVar, String[] strArr, boolean z5, boolean z6) {
        AssetManager assets;
        this.f6009s = new HashSet();
        this.f6010t = new C0090a();
        try {
            assets = context.createPackageContext(context.getPackageName(), 0).getAssets();
        } catch (PackageManager.NameNotFoundException unused) {
            assets = context.getAssets();
        }
        k3.a e6 = k3.a.e();
        flutterJNI = flutterJNI == null ? e6.d().a() : flutterJNI;
        this.f5991a = flutterJNI;
        m3.a aVar = new m3.a(flutterJNI, assets);
        this.f5993c = aVar;
        aVar.n();
        k3.a.e().a();
        this.f5996f = new x3.a(aVar, flutterJNI);
        this.f5997g = new x3.b(aVar);
        this.f5998h = new x3.e(aVar);
        x3.f fVar = new x3.f(aVar);
        this.f5999i = fVar;
        this.f6000j = new x3.g(aVar);
        this.f6001k = new x3.h(aVar);
        this.f6003m = new x3.i(aVar);
        this.f6002l = new l(aVar, z6);
        this.f6004n = new m(aVar);
        this.f6005o = new n(aVar);
        this.f6006p = new o(aVar);
        this.f6007q = new p(aVar);
        z3.d dVar2 = new z3.d(context, fVar);
        this.f5995e = dVar2;
        dVar = dVar == null ? e6.c() : dVar;
        if (!flutterJNI.isAttached()) {
            dVar.l(context.getApplicationContext());
            dVar.e(context, strArr);
        }
        flutterJNI.addEngineLifecycleListener(this.f6010t);
        flutterJNI.setPlatformViewsController(uVar);
        flutterJNI.setLocalizationPlugin(dVar2);
        e6.a();
        flutterJNI.setDeferredComponentManager(null);
        if (!flutterJNI.isAttached()) {
            d();
        }
        this.f5992b = new w3.a(flutterJNI);
        this.f6008r = uVar;
        uVar.V();
        this.f5994d = new c(context.getApplicationContext(), this, dVar);
        dVar2.d(context.getResources().getConfiguration());
        if (z5 && dVar.d()) {
            v3.a.a(this);
        }
    }

    public a(Context context, String[] strArr, boolean z5, boolean z6) {
        this(context, null, null, new u(), strArr, z5, z6);
    }

    private void d() {
        k3.b.f("FlutterEngine", "Attaching to JNI.");
        this.f5991a.attachToNative();
        if (!v()) {
            throw new RuntimeException("FlutterEngine failed to attach to its native Object reference.");
        }
    }

    private boolean v() {
        return this.f5991a.isAttached();
    }

    public void e() {
        k3.b.f("FlutterEngine", "Destroying.");
        Iterator<b> it = this.f6009s.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.f5994d.k();
        this.f6008r.X();
        this.f5993c.o();
        this.f5991a.removeEngineLifecycleListener(this.f6010t);
        this.f5991a.setDeferredComponentManager(null);
        this.f5991a.detachFromNativeAndReleaseResources();
        k3.a.e().a();
    }

    public x3.a f() {
        return this.f5996f;
    }

    public r3.b g() {
        return this.f5994d;
    }

    public m3.a h() {
        return this.f5993c;
    }

    public x3.e i() {
        return this.f5998h;
    }

    public z3.d j() {
        return this.f5995e;
    }

    public x3.g k() {
        return this.f6000j;
    }

    public x3.h l() {
        return this.f6001k;
    }

    public x3.i m() {
        return this.f6003m;
    }

    public u n() {
        return this.f6008r;
    }

    public q3.b o() {
        return this.f5994d;
    }

    public w3.a p() {
        return this.f5992b;
    }

    public l q() {
        return this.f6002l;
    }

    public m r() {
        return this.f6004n;
    }

    public n s() {
        return this.f6005o;
    }

    public o t() {
        return this.f6006p;
    }

    public p u() {
        return this.f6007q;
    }
}
