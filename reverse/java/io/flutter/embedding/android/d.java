package io.flutter.embedding.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.window.OnBackInvokedCallback;
import androidx.lifecycle.d;
import io.flutter.embedding.android.e;
import java.util.List;

/* loaded from: classes.dex */
public class d extends Activity implements e.c, androidx.lifecycle.i {

    /* renamed from: d, reason: collision with root package name */
    public static final int f5855d = d4.i.d(61938);

    /* renamed from: a, reason: collision with root package name */
    protected e f5856a;

    /* renamed from: b, reason: collision with root package name */
    private androidx.lifecycle.j f5857b;

    /* renamed from: c, reason: collision with root package name */
    private final OnBackInvokedCallback f5858c;

    class a implements OnBackInvokedCallback {
        a() {
        }

        @Override // android.window.OnBackInvokedCallback
        public void onBackInvoked() {
            d.this.onBackPressed();
        }
    }

    public d() {
        this.f5858c = Build.VERSION.SDK_INT >= 33 ? new a() : null;
        this.f5857b = new androidx.lifecycle.j(this);
    }

    private void D() {
        Window window = getWindow();
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(1073741824);
        window.getDecorView().setSystemUiVisibility(1280);
    }

    private void E() {
        if (G() == f.transparent) {
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
    }

    private View F() {
        return this.f5856a.r(null, null, null, f5855d, x() == h0.surface);
    }

    private Drawable J() {
        try {
            Bundle I = I();
            int i6 = I != null ? I.getInt("io.flutter.embedding.android.SplashScreenDrawable") : 0;
            if (i6 != 0) {
                return androidx.core.content.res.a.a(getResources(), i6, getTheme());
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        } catch (Resources.NotFoundException e6) {
            k3.b.b("FlutterActivity", "Splash screen not found. Ensure the drawable exists and that it's valid.");
            throw e6;
        }
    }

    private boolean K() {
        return (getApplicationInfo().flags & 2) != 0;
    }

    private boolean N(String str) {
        StringBuilder sb;
        String str2;
        e eVar = this.f5856a;
        if (eVar == null) {
            sb = new StringBuilder();
            sb.append("FlutterActivity ");
            sb.append(hashCode());
            sb.append(" ");
            sb.append(str);
            str2 = " called after release.";
        } else {
            if (eVar.l()) {
                return true;
            }
            sb = new StringBuilder();
            sb.append("FlutterActivity ");
            sb.append(hashCode());
            sb.append(" ");
            sb.append(str);
            str2 = " called after detach.";
        }
        sb.append(str2);
        k3.b.g("FlutterActivity", sb.toString());
        return false;
    }

    private void O() {
        try {
            Bundle I = I();
            if (I != null) {
                int i6 = I.getInt("io.flutter.embedding.android.NormalTheme", -1);
                if (i6 != -1) {
                    setTheme(i6);
                }
            } else {
                k3.b.f("FlutterActivity", "Using the launch theme as normal theme.");
            }
        } catch (PackageManager.NameNotFoundException unused) {
            k3.b.b("FlutterActivity", "Could not read meta-data for FlutterActivity. Using the launch theme as normal theme.");
        }
    }

    @Override // io.flutter.embedding.android.e.c
    public k0 A() {
        return G() == f.opaque ? k0.opaque : k0.transparent;
    }

    @Override // io.flutter.embedding.android.e.c
    public void B(o oVar) {
    }

    public void C(io.flutter.embedding.engine.a aVar) {
        if (this.f5856a.m()) {
            return;
        }
        v3.a.a(aVar);
    }

    protected f G() {
        return getIntent().hasExtra("background_mode") ? f.valueOf(getIntent().getStringExtra("background_mode")) : f.opaque;
    }

    protected io.flutter.embedding.engine.a H() {
        return this.f5856a.k();
    }

    protected Bundle I() {
        return getPackageManager().getActivityInfo(getComponentName(), 128).metaData;
    }

    public void L() {
        if (Build.VERSION.SDK_INT >= 33) {
            getOnBackInvokedDispatcher().registerOnBackInvokedCallback(0, this.f5858c);
        }
    }

    public void M() {
        P();
        e eVar = this.f5856a;
        if (eVar != null) {
            eVar.F();
            this.f5856a = null;
        }
    }

    public void P() {
        if (Build.VERSION.SDK_INT >= 33) {
            getOnBackInvokedDispatcher().unregisterOnBackInvokedCallback(this.f5858c);
        }
    }

    @Override // io.flutter.embedding.android.e.c, androidx.lifecycle.i
    public androidx.lifecycle.d a() {
        return this.f5857b;
    }

    @Override // io.flutter.plugin.platform.f.d
    public boolean b() {
        return false;
    }

    @Override // io.flutter.embedding.android.e.c
    public void c() {
    }

    @Override // io.flutter.embedding.android.e.c
    public Activity d() {
        return this;
    }

    @Override // io.flutter.embedding.android.e.c
    public void e() {
        k3.b.g("FlutterActivity", "FlutterActivity " + this + " connection to the engine " + H() + " evicted by another attaching activity");
        e eVar = this.f5856a;
        if (eVar != null) {
            eVar.s();
            this.f5856a.t();
        }
    }

    @Override // io.flutter.embedding.android.e.c
    public void f() {
        if (Build.VERSION.SDK_INT >= 29) {
            reportFullyDrawn();
        }
    }

    @Override // io.flutter.embedding.android.e.c
    public String g() {
        if (getIntent().hasExtra("route")) {
            return getIntent().getStringExtra("route");
        }
        try {
            Bundle I = I();
            if (I != null) {
                return I.getString("io.flutter.InitialRoute");
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @Override // io.flutter.embedding.android.e.c
    public Context getContext() {
        return this;
    }

    @Override // io.flutter.embedding.android.e.c
    public List<String> j() {
        return (List) getIntent().getSerializableExtra("dart_entrypoint_args");
    }

    @Override // io.flutter.embedding.android.e.c
    public boolean k() {
        return true;
    }

    @Override // io.flutter.embedding.android.e.c
    public boolean l() {
        boolean booleanExtra = getIntent().getBooleanExtra("destroy_engine_with_activity", false);
        return (n() != null || this.f5856a.m()) ? booleanExtra : getIntent().getBooleanExtra("destroy_engine_with_activity", true);
    }

    @Override // io.flutter.embedding.android.e.c
    public boolean m() {
        return true;
    }

    @Override // io.flutter.embedding.android.e.c
    public String n() {
        return getIntent().getStringExtra("cached_engine_id");
    }

    @Override // io.flutter.embedding.android.e.c
    public boolean o() {
        return getIntent().hasExtra("enable_state_restoration") ? getIntent().getBooleanExtra("enable_state_restoration", false) : n() == null;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i6, int i7, Intent intent) {
        if (N("onActivityResult")) {
            this.f5856a.o(i6, i7, intent);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (N("onBackPressed")) {
            this.f5856a.q();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        O();
        super.onCreate(bundle);
        e eVar = new e(this);
        this.f5856a = eVar;
        eVar.p(this);
        this.f5856a.y(bundle);
        this.f5857b.h(d.b.ON_CREATE);
        L();
        E();
        setContentView(F());
        D();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (N("onDestroy")) {
            this.f5856a.s();
            this.f5856a.t();
        }
        M();
        this.f5857b.h(d.b.ON_DESTROY);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (N("onNewIntent")) {
            this.f5856a.u(intent);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        if (N("onPause")) {
            this.f5856a.v();
        }
        this.f5857b.h(d.b.ON_PAUSE);
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        if (N("onPostResume")) {
            this.f5856a.w();
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i6, String[] strArr, int[] iArr) {
        if (N("onRequestPermissionsResult")) {
            this.f5856a.x(i6, strArr, iArr);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.f5857b.h(d.b.ON_RESUME);
        if (N("onResume")) {
            this.f5856a.z();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (N("onSaveInstanceState")) {
            this.f5856a.A(bundle);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.f5857b.h(d.b.ON_START);
        if (N("onStart")) {
            this.f5856a.B();
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        if (N("onStop")) {
            this.f5856a.C();
        }
        this.f5857b.h(d.b.ON_STOP);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i6) {
        super.onTrimMemory(i6);
        if (N("onTrimMemory")) {
            this.f5856a.D(i6);
        }
    }

    @Override // android.app.Activity
    public void onUserLeaveHint() {
        if (N("onUserLeaveHint")) {
            this.f5856a.E();
        }
    }

    @Override // io.flutter.embedding.android.e.c
    public String p() {
        try {
            Bundle I = I();
            String string = I != null ? I.getString("io.flutter.Entrypoint") : null;
            return string != null ? string : "main";
        } catch (PackageManager.NameNotFoundException unused) {
            return "main";
        }
    }

    @Override // io.flutter.embedding.android.e.c
    public void q(io.flutter.embedding.engine.a aVar) {
    }

    @Override // io.flutter.embedding.android.e.c
    public String r() {
        try {
            Bundle I = I();
            if (I != null) {
                return I.getString("io.flutter.EntrypointUri");
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @Override // io.flutter.embedding.android.e.c
    public io.flutter.plugin.platform.f s(Activity activity, io.flutter.embedding.engine.a aVar) {
        return new io.flutter.plugin.platform.f(d(), aVar.m(), this);
    }

    @Override // io.flutter.embedding.android.e.c
    public void t(n nVar) {
    }

    @Override // io.flutter.embedding.android.e.c
    public String u() {
        String dataString;
        if (K() && "android.intent.action.RUN".equals(getIntent().getAction()) && (dataString = getIntent().getDataString()) != null) {
            return dataString;
        }
        return null;
    }

    @Override // io.flutter.embedding.android.e.c
    public boolean v() {
        try {
            Bundle I = I();
            if (I != null) {
                return I.getBoolean("flutter_deeplinking_enabled");
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    @Override // io.flutter.embedding.android.e.c
    public io.flutter.embedding.engine.j w() {
        return io.flutter.embedding.engine.j.a(getIntent());
    }

    @Override // io.flutter.embedding.android.e.c
    public h0 x() {
        return G() == f.opaque ? h0.surface : h0.texture;
    }

    @Override // io.flutter.embedding.android.e.c
    public j0 y() {
        Drawable J = J();
        if (J != null) {
            return new b(J);
        }
        return null;
    }

    @Override // io.flutter.embedding.android.e.c
    public io.flutter.embedding.engine.a z(Context context) {
        return null;
    }
}
