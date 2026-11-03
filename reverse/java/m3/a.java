package m3;

import android.content.res.AssetManager;
import io.flutter.embedding.engine.FlutterJNI;
import java.nio.ByteBuffer;
import java.util.List;
import y3.c;
import y3.s;

/* loaded from: classes.dex */
public class a implements y3.c {

    /* renamed from: a, reason: collision with root package name */
    private final FlutterJNI f8058a;

    /* renamed from: b, reason: collision with root package name */
    private final AssetManager f8059b;

    /* renamed from: c, reason: collision with root package name */
    private final m3.c f8060c;

    /* renamed from: d, reason: collision with root package name */
    private final y3.c f8061d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f8062e;

    /* renamed from: f, reason: collision with root package name */
    private String f8063f;

    /* renamed from: g, reason: collision with root package name */
    private final c.a f8064g;

    /* renamed from: m3.a$a, reason: collision with other inner class name */
    class C0121a implements c.a {
        C0121a() {
        }

        @Override // y3.c.a
        public void a(ByteBuffer byteBuffer, c.b bVar) {
            a.this.f8063f = s.f11118b.b(byteBuffer);
            a.h(a.this);
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f8066a;

        /* renamed from: b, reason: collision with root package name */
        public final String f8067b;

        /* renamed from: c, reason: collision with root package name */
        public final String f8068c;

        public b(String str, String str2) {
            this.f8066a = str;
            this.f8067b = null;
            this.f8068c = str2;
        }

        public b(String str, String str2, String str3) {
            this.f8066a = str;
            this.f8067b = str2;
            this.f8068c = str3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f8066a.equals(bVar.f8066a)) {
                return this.f8068c.equals(bVar.f8068c);
            }
            return false;
        }

        public int hashCode() {
            return (this.f8066a.hashCode() * 31) + this.f8068c.hashCode();
        }

        public String toString() {
            return "DartEntrypoint( bundle path: " + this.f8066a + ", function: " + this.f8068c + " )";
        }
    }

    private static class c implements y3.c {

        /* renamed from: a, reason: collision with root package name */
        private final m3.c f8069a;

        private c(m3.c cVar) {
            this.f8069a = cVar;
        }

        /* synthetic */ c(m3.c cVar, C0121a c0121a) {
            this(cVar);
        }

        @Override // y3.c
        public c.InterfaceC0170c a(c.d dVar) {
            return this.f8069a.a(dVar);
        }

        @Override // y3.c
        public void b(String str, c.a aVar) {
            this.f8069a.b(str, aVar);
        }

        @Override // y3.c
        public void c(String str, c.a aVar, c.InterfaceC0170c interfaceC0170c) {
            this.f8069a.c(str, aVar, interfaceC0170c);
        }

        @Override // y3.c
        public /* synthetic */ c.InterfaceC0170c d() {
            return y3.b.a(this);
        }

        @Override // y3.c
        public void e(String str, ByteBuffer byteBuffer, c.b bVar) {
            this.f8069a.e(str, byteBuffer, bVar);
        }

        @Override // y3.c
        public void f(String str, ByteBuffer byteBuffer) {
            this.f8069a.e(str, byteBuffer, null);
        }
    }

    public interface d {
    }

    public a(FlutterJNI flutterJNI, AssetManager assetManager) {
        this.f8062e = false;
        C0121a c0121a = new C0121a();
        this.f8064g = c0121a;
        this.f8058a = flutterJNI;
        this.f8059b = assetManager;
        m3.c cVar = new m3.c(flutterJNI);
        this.f8060c = cVar;
        cVar.b("flutter/isolate", c0121a);
        this.f8061d = new c(cVar, null);
        if (flutterJNI.isAttached()) {
            this.f8062e = true;
        }
    }

    static /* synthetic */ d h(a aVar) {
        aVar.getClass();
        return null;
    }

    @Override // y3.c
    @Deprecated
    public c.InterfaceC0170c a(c.d dVar) {
        return this.f8061d.a(dVar);
    }

    @Override // y3.c
    @Deprecated
    public void b(String str, c.a aVar) {
        this.f8061d.b(str, aVar);
    }

    @Override // y3.c
    @Deprecated
    public void c(String str, c.a aVar, c.InterfaceC0170c interfaceC0170c) {
        this.f8061d.c(str, aVar, interfaceC0170c);
    }

    @Override // y3.c
    public /* synthetic */ c.InterfaceC0170c d() {
        return y3.b.a(this);
    }

    @Override // y3.c
    @Deprecated
    public void e(String str, ByteBuffer byteBuffer, c.b bVar) {
        this.f8061d.e(str, byteBuffer, bVar);
    }

    @Override // y3.c
    @Deprecated
    public void f(String str, ByteBuffer byteBuffer) {
        this.f8061d.f(str, byteBuffer);
    }

    public void i(b bVar, List<String> list) {
        if (this.f8062e) {
            k3.b.g("DartExecutor", "Attempted to run a DartExecutor that is already running.");
            return;
        }
        d4.f.a("DartExecutor#executeDartEntrypoint");
        try {
            k3.b.f("DartExecutor", "Executing Dart entrypoint: " + bVar);
            this.f8058a.runBundleAndSnapshotFromLibrary(bVar.f8066a, bVar.f8068c, bVar.f8067b, this.f8059b, list);
            this.f8062e = true;
        } finally {
            d4.f.d();
        }
    }

    public y3.c j() {
        return this.f8061d;
    }

    public String k() {
        return this.f8063f;
    }

    public boolean l() {
        return this.f8062e;
    }

    public void m() {
        if (this.f8058a.isAttached()) {
            this.f8058a.notifyLowMemoryWarning();
        }
    }

    public void n() {
        k3.b.f("DartExecutor", "Attached to JNI. Registering the platform message handler for this Dart execution context.");
        this.f8058a.setPlatformMessageHandler(this.f8060c);
    }

    public void o() {
        k3.b.f("DartExecutor", "Detached from JNI. De-registering the platform message handler for this Dart execution context.");
        this.f8058a.setPlatformMessageHandler(null);
    }
}
