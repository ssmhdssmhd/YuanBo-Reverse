package o3;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import d4.f;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.view.u;
import java.io.File;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import o3.d;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private boolean f8463a;

    /* renamed from: b, reason: collision with root package name */
    private c f8464b;

    /* renamed from: c, reason: collision with root package name */
    private long f8465c;

    /* renamed from: d, reason: collision with root package name */
    private o3.b f8466d;

    /* renamed from: e, reason: collision with root package name */
    private FlutterJNI f8467e;

    /* renamed from: f, reason: collision with root package name */
    private ExecutorService f8468f;

    /* renamed from: g, reason: collision with root package name */
    Future<b> f8469g;

    class a implements Callable<b> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f8470a;

        a(Context context) {
            this.f8470a = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c() {
            d.this.f8467e.prefetchDefaultFontManager();
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public b call() {
            f.a("FlutterLoader initTask");
            try {
                d.a(d.this, this.f8470a);
                d.this.f8467e.loadLibrary();
                d.this.f8467e.updateRefreshRate();
                d.this.f8468f.execute(new Runnable() { // from class: o3.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        d.a.this.c();
                    }
                });
                return new b(d4.c.d(this.f8470a), d4.c.a(this.f8470a), d4.c.c(this.f8470a), null);
            } finally {
                f.d();
            }
        }
    }

    private static class b {

        /* renamed from: a, reason: collision with root package name */
        final String f8472a;

        /* renamed from: b, reason: collision with root package name */
        final String f8473b;

        /* renamed from: c, reason: collision with root package name */
        final String f8474c;

        private b(String str, String str2, String str3) {
            this.f8472a = str;
            this.f8473b = str2;
            this.f8474c = str3;
        }

        /* synthetic */ b(String str, String str2, String str3, a aVar) {
            this(str, str2, str3);
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private String f8475a;

        public String a() {
            return this.f8475a;
        }
    }

    public d() {
        this(k3.a.e().d().a());
    }

    public d(FlutterJNI flutterJNI) {
        this(flutterJNI, k3.a.e().b());
    }

    public d(FlutterJNI flutterJNI, ExecutorService executorService) {
        this.f8463a = false;
        this.f8467e = flutterJNI;
        this.f8468f = executorService;
    }

    static /* synthetic */ e a(d dVar, Context context) {
        dVar.j(context);
        return null;
    }

    private String g(String str) {
        return this.f8466d.f8458d + File.separator + str;
    }

    private e j(Context context) {
        return null;
    }

    private static boolean k(Bundle bundle) {
        if (bundle == null) {
            return true;
        }
        return bundle.getBoolean("io.flutter.embedding.android.LeakVM", true);
    }

    public boolean d() {
        return this.f8466d.f8461g;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0194  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void e(android.content.Context r10, java.lang.String[] r11) {
        /*
            Method dump skipped, instructions count: 496
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o3.d.e(android.content.Context, java.lang.String[]):void");
    }

    public String f() {
        return this.f8466d.f8458d;
    }

    public String h(String str) {
        return g(str);
    }

    public String i(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("packages");
        String str3 = File.separator;
        sb.append(str3);
        sb.append(str2);
        sb.append(str3);
        sb.append(str);
        return h(sb.toString());
    }

    public void l(Context context) {
        m(context, new c());
    }

    public void m(Context context, c cVar) {
        if (this.f8464b != null) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("startInitialization must be called on the main thread");
        }
        f.a("FlutterLoader#startInitialization");
        try {
            Context applicationContext = context.getApplicationContext();
            this.f8464b = cVar;
            this.f8465c = SystemClock.uptimeMillis();
            this.f8466d = o3.a.e(applicationContext);
            u.f((DisplayManager) applicationContext.getSystemService("display"), this.f8467e).g();
            this.f8469g = this.f8468f.submit(new a(applicationContext));
        } finally {
            f.d();
        }
    }
}
