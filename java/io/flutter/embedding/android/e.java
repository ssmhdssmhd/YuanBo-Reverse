package io.flutter.embedding.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import io.flutter.plugin.platform.f;
import java.util.Arrays;
import java.util.List;
import m3.a;

/* loaded from: classes.dex */
class e implements io.flutter.embedding.android.c<Activity> {

    /* renamed from: a, reason: collision with root package name */
    private c f5865a;

    /* renamed from: b, reason: collision with root package name */
    private io.flutter.embedding.engine.a f5866b;

    /* renamed from: c, reason: collision with root package name */
    w f5867c;

    /* renamed from: d, reason: collision with root package name */
    private io.flutter.plugin.platform.f f5868d;

    /* renamed from: e, reason: collision with root package name */
    ViewTreeObserver.OnPreDrawListener f5869e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f5870f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f5871g;

    /* renamed from: i, reason: collision with root package name */
    private boolean f5873i;

    /* renamed from: j, reason: collision with root package name */
    private Integer f5874j;

    /* renamed from: k, reason: collision with root package name */
    private final w3.b f5875k = new a();

    /* renamed from: h, reason: collision with root package name */
    private boolean f5872h = false;

    class a implements w3.b {
        a() {
        }

        @Override // w3.b
        public void c() {
            e.this.f5865a.c();
            e.this.f5871g = false;
        }

        @Override // w3.b
        public void f() {
            e.this.f5865a.f();
            e.this.f5871g = true;
            e.this.f5872h = true;
        }
    }

    class b implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ w f5877a;

        b(w wVar) {
            this.f5877a = wVar;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (e.this.f5871g && e.this.f5869e != null) {
                this.f5877a.getViewTreeObserver().removeOnPreDrawListener(this);
                e.this.f5869e = null;
            }
            return e.this.f5871g;
        }
    }

    interface c extends f.d {
        k0 A();

        void B(o oVar);

        void C(io.flutter.embedding.engine.a aVar);

        androidx.lifecycle.d a();

        void c();

        Activity d();

        void e();

        void f();

        String g();

        Context getContext();

        List<String> j();

        boolean k();

        boolean l();

        boolean m();

        String n();

        boolean o();

        String p();

        void q(io.flutter.embedding.engine.a aVar);

        String r();

        io.flutter.plugin.platform.f s(Activity activity, io.flutter.embedding.engine.a aVar);

        void t(n nVar);

        String u();

        boolean v();

        io.flutter.embedding.engine.j w();

        h0 x();

        j0 y();

        io.flutter.embedding.engine.a z(Context context);
    }

    e(c cVar) {
        this.f5865a = cVar;
    }

    private void g(w wVar) {
        if (this.f5865a.x() != h0.surface) {
            throw new IllegalArgumentException("Cannot delay the first Android view draw when the render mode is not set to `RenderMode.surface`.");
        }
        if (this.f5869e != null) {
            wVar.getViewTreeObserver().removeOnPreDrawListener(this.f5869e);
        }
        this.f5869e = new b(wVar);
        wVar.getViewTreeObserver().addOnPreDrawListener(this.f5869e);
    }

    private void h() {
        String str;
        if (this.f5865a.n() == null && !this.f5866b.h().l()) {
            String g6 = this.f5865a.g();
            if (g6 == null && (g6 = n(this.f5865a.d().getIntent())) == null) {
                g6 = "/";
            }
            String r6 = this.f5865a.r();
            if (("Executing Dart entrypoint: " + this.f5865a.p() + ", library uri: " + r6) == null) {
                str = "\"\"";
            } else {
                str = r6 + ", and sending initial route: " + g6;
            }
            k3.b.f("FlutterActivityAndFragmentDelegate", str);
            this.f5866b.l().c(g6);
            String u5 = this.f5865a.u();
            if (u5 == null || u5.isEmpty()) {
                u5 = k3.a.e().c().f();
            }
            this.f5866b.h().i(r6 == null ? new a.b(u5, this.f5865a.p()) : new a.b(u5, r6, this.f5865a.p()), this.f5865a.j());
        }
    }

    private void i() {
        if (this.f5865a == null) {
            throw new IllegalStateException("Cannot execute method on a destroyed FlutterActivityAndFragmentDelegate.");
        }
    }

    private String n(Intent intent) {
        Uri data;
        String path;
        if (!this.f5865a.v() || (data = intent.getData()) == null || (path = data.getPath()) == null || path.isEmpty()) {
            return null;
        }
        if (data.getQuery() != null && !data.getQuery().isEmpty()) {
            path = path + "?" + data.getQuery();
        }
        if (data.getFragment() == null || data.getFragment().isEmpty()) {
            return path;
        }
        return path + "#" + data.getFragment();
    }

    void A(Bundle bundle) {
        k3.b.f("FlutterActivityAndFragmentDelegate", "onSaveInstanceState. Giving framework and plugins an opportunity to save state.");
        i();
        if (this.f5865a.o()) {
            bundle.putByteArray("framework", this.f5866b.q().h());
        }
        if (this.f5865a.k()) {
            Bundle bundle2 = new Bundle();
            this.f5866b.g().d(bundle2);
            bundle.putBundle("plugins", bundle2);
        }
    }

    void B() {
        k3.b.f("FlutterActivityAndFragmentDelegate", "onStart()");
        i();
        h();
        Integer num = this.f5874j;
        if (num != null) {
            this.f5867c.setVisibility(num.intValue());
        }
    }

    void C() {
        k3.b.f("FlutterActivityAndFragmentDelegate", "onStop()");
        i();
        if (this.f5865a.m()) {
            this.f5866b.i().c();
        }
        this.f5874j = Integer.valueOf(this.f5867c.getVisibility());
        this.f5867c.setVisibility(8);
    }

    void D(int i6) {
        i();
        io.flutter.embedding.engine.a aVar = this.f5866b;
        if (aVar != null) {
            if (this.f5872h && i6 >= 10) {
                aVar.h().m();
                this.f5866b.t().a();
            }
            this.f5866b.p().n(i6);
        }
    }

    void E() {
        i();
        if (this.f5866b == null) {
            k3.b.g("FlutterActivityAndFragmentDelegate", "onUserLeaveHint() invoked before FlutterFragment was attached to an Activity.");
        } else {
            k3.b.f("FlutterActivityAndFragmentDelegate", "Forwarding onUserLeaveHint() to FlutterEngine.");
            this.f5866b.g().e();
        }
    }

    void F() {
        this.f5865a = null;
        this.f5866b = null;
        this.f5867c = null;
        this.f5868d = null;
    }

    void G() {
        k3.b.f("FlutterActivityAndFragmentDelegate", "Setting up FlutterEngine.");
        String n6 = this.f5865a.n();
        if (n6 != null) {
            io.flutter.embedding.engine.a a6 = io.flutter.embedding.engine.b.b().a(n6);
            this.f5866b = a6;
            this.f5870f = true;
            if (a6 != null) {
                return;
            }
            throw new IllegalStateException("The requested cached FlutterEngine did not exist in the FlutterEngineCache: '" + n6 + "'");
        }
        c cVar = this.f5865a;
        io.flutter.embedding.engine.a z5 = cVar.z(cVar.getContext());
        this.f5866b = z5;
        if (z5 != null) {
            this.f5870f = true;
            return;
        }
        k3.b.f("FlutterActivityAndFragmentDelegate", "No preferred FlutterEngine was provided. Creating a new FlutterEngine for this FlutterFragment.");
        this.f5866b = new io.flutter.embedding.engine.a(this.f5865a.getContext(), this.f5865a.w().b(), false, this.f5865a.o());
        this.f5870f = false;
    }

    void H() {
        io.flutter.plugin.platform.f fVar = this.f5868d;
        if (fVar != null) {
            fVar.A();
        }
    }

    @Override // io.flutter.embedding.android.c
    public void e() {
        if (!this.f5865a.l()) {
            this.f5865a.e();
            return;
        }
        throw new AssertionError("The internal FlutterEngine created by " + this.f5865a + " has been attached to by another activity. To persist a FlutterEngine beyond the ownership of this activity, explicitly create a FlutterEngine");
    }

    @Override // io.flutter.embedding.android.c
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Activity f() {
        Activity d6 = this.f5865a.d();
        if (d6 != null) {
            return d6;
        }
        throw new AssertionError("FlutterActivityAndFragmentDelegate's getAppComponent should only be queried after onAttach, when the host's activity should always be non-null");
    }

    io.flutter.embedding.engine.a k() {
        return this.f5866b;
    }

    boolean l() {
        return this.f5873i;
    }

    boolean m() {
        return this.f5870f;
    }

    void o(int i6, int i7, Intent intent) {
        i();
        if (this.f5866b == null) {
            k3.b.g("FlutterActivityAndFragmentDelegate", "onActivityResult() invoked before FlutterFragment was attached to an Activity.");
            return;
        }
        k3.b.f("FlutterActivityAndFragmentDelegate", "Forwarding onActivityResult() to FlutterEngine:\nrequestCode: " + i6 + "\nresultCode: " + i7 + "\ndata: " + intent);
        this.f5866b.g().a(i6, i7, intent);
    }

    void p(Context context) {
        i();
        if (this.f5866b == null) {
            G();
        }
        if (this.f5865a.k()) {
            k3.b.f("FlutterActivityAndFragmentDelegate", "Attaching FlutterEngine to the Activity that owns this delegate.");
            this.f5866b.g().g(this, this.f5865a.a());
        }
        c cVar = this.f5865a;
        this.f5868d = cVar.s(cVar.d(), this.f5866b);
        this.f5865a.C(this.f5866b);
        this.f5873i = true;
    }

    void q() {
        i();
        if (this.f5866b == null) {
            k3.b.g("FlutterActivityAndFragmentDelegate", "Invoked onBackPressed() before FlutterFragment was attached to an Activity.");
        } else {
            k3.b.f("FlutterActivityAndFragmentDelegate", "Forwarding onBackPressed() to FlutterEngine.");
            this.f5866b.l().a();
        }
    }

    View r(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle, int i6, boolean z5) {
        w wVar;
        k3.b.f("FlutterActivityAndFragmentDelegate", "Creating FlutterView.");
        i();
        if (this.f5865a.x() == h0.surface) {
            n nVar = new n(this.f5865a.getContext(), this.f5865a.A() == k0.transparent);
            this.f5865a.t(nVar);
            wVar = new w(this.f5865a.getContext(), nVar);
        } else {
            o oVar = new o(this.f5865a.getContext());
            oVar.setOpaque(this.f5865a.A() == k0.opaque);
            this.f5865a.B(oVar);
            wVar = new w(this.f5865a.getContext(), oVar);
        }
        this.f5867c = wVar;
        this.f5867c.l(this.f5875k);
        k3.b.f("FlutterActivityAndFragmentDelegate", "Attaching FlutterEngine to FlutterView.");
        this.f5867c.n(this.f5866b);
        this.f5867c.setId(i6);
        j0 y5 = this.f5865a.y();
        if (y5 == null) {
            if (z5) {
                g(this.f5867c);
            }
            return this.f5867c;
        }
        k3.b.g("FlutterActivityAndFragmentDelegate", "A splash screen was provided to Flutter, but this is deprecated. See flutter.dev/go/android-splash-migration for migration steps.");
        FlutterSplashView flutterSplashView = new FlutterSplashView(this.f5865a.getContext());
        flutterSplashView.setId(d4.i.d(486947586));
        flutterSplashView.g(this.f5867c, y5);
        return flutterSplashView;
    }

    void s() {
        k3.b.f("FlutterActivityAndFragmentDelegate", "onDestroyView()");
        i();
        if (this.f5869e != null) {
            this.f5867c.getViewTreeObserver().removeOnPreDrawListener(this.f5869e);
            this.f5869e = null;
        }
        this.f5867c.s();
        this.f5867c.z(this.f5875k);
    }

    void t() {
        k3.b.f("FlutterActivityAndFragmentDelegate", "onDetach()");
        i();
        this.f5865a.q(this.f5866b);
        if (this.f5865a.k()) {
            k3.b.f("FlutterActivityAndFragmentDelegate", "Detaching FlutterEngine from the Activity that owns this Fragment.");
            if (this.f5865a.d().isChangingConfigurations()) {
                this.f5866b.g().h();
            } else {
                this.f5866b.g().i();
            }
        }
        io.flutter.plugin.platform.f fVar = this.f5868d;
        if (fVar != null) {
            fVar.o();
            this.f5868d = null;
        }
        if (this.f5865a.m()) {
            this.f5866b.i().a();
        }
        if (this.f5865a.l()) {
            this.f5866b.e();
            if (this.f5865a.n() != null) {
                io.flutter.embedding.engine.b.b().d(this.f5865a.n());
            }
            this.f5866b = null;
        }
        this.f5873i = false;
    }

    void u(Intent intent) {
        i();
        if (this.f5866b == null) {
            k3.b.g("FlutterActivityAndFragmentDelegate", "onNewIntent() invoked before FlutterFragment was attached to an Activity.");
            return;
        }
        k3.b.f("FlutterActivityAndFragmentDelegate", "Forwarding onNewIntent() to FlutterEngine and sending pushRoute message.");
        this.f5866b.g().b(intent);
        String n6 = n(intent);
        if (n6 == null || n6.isEmpty()) {
            return;
        }
        this.f5866b.l().b(n6);
    }

    void v() {
        k3.b.f("FlutterActivityAndFragmentDelegate", "onPause()");
        i();
        if (this.f5865a.m()) {
            this.f5866b.i().b();
        }
    }

    void w() {
        k3.b.f("FlutterActivityAndFragmentDelegate", "onPostResume()");
        i();
        if (this.f5866b != null) {
            H();
        } else {
            k3.b.g("FlutterActivityAndFragmentDelegate", "onPostResume() invoked before FlutterFragment was attached to an Activity.");
        }
    }

    void x(int i6, String[] strArr, int[] iArr) {
        i();
        if (this.f5866b == null) {
            k3.b.g("FlutterActivityAndFragmentDelegate", "onRequestPermissionResult() invoked before FlutterFragment was attached to an Activity.");
            return;
        }
        k3.b.f("FlutterActivityAndFragmentDelegate", "Forwarding onRequestPermissionsResult() to FlutterEngine:\nrequestCode: " + i6 + "\npermissions: " + Arrays.toString(strArr) + "\ngrantResults: " + Arrays.toString(iArr));
        this.f5866b.g().onRequestPermissionsResult(i6, strArr, iArr);
    }

    void y(Bundle bundle) {
        Bundle bundle2;
        byte[] bArr;
        k3.b.f("FlutterActivityAndFragmentDelegate", "onRestoreInstanceState. Giving framework and plugins an opportunity to restore state.");
        i();
        if (bundle != null) {
            bundle2 = bundle.getBundle("plugins");
            bArr = bundle.getByteArray("framework");
        } else {
            bundle2 = null;
            bArr = null;
        }
        if (this.f5865a.o()) {
            this.f5866b.q().j(bArr);
        }
        if (this.f5865a.k()) {
            this.f5866b.g().c(bundle2);
        }
    }

    void z() {
        k3.b.f("FlutterActivityAndFragmentDelegate", "onResume()");
        i();
        if (this.f5865a.m()) {
            this.f5866b.i().d();
        }
    }
}
