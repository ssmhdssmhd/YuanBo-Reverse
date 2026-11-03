package androidx.loader.app;

import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.i;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import androidx.lifecycle.v;
import androidx.lifecycle.w;
import androidx.lifecycle.x;
import f.g;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
class b extends androidx.loader.app.a {

    /* renamed from: c, reason: collision with root package name */
    static boolean f905c = false;

    /* renamed from: a, reason: collision with root package name */
    private final i f906a;

    /* renamed from: b, reason: collision with root package name */
    private final C0017b f907b;

    public static class a<D> extends p<D> {

        /* renamed from: k, reason: collision with root package name */
        private final int f908k;

        /* renamed from: l, reason: collision with root package name */
        private final Bundle f909l;

        /* renamed from: m, reason: collision with root package name */
        private i f910m;

        @Override // androidx.lifecycle.LiveData
        protected void g() {
            if (b.f905c) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            throw null;
        }

        @Override // androidx.lifecycle.LiveData
        protected void h() {
            if (b.f905c) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            throw null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.LiveData
        public void j(q<? super D> qVar) {
            super.j(qVar);
            this.f910m = null;
        }

        @Override // androidx.lifecycle.p, androidx.lifecycle.LiveData
        public void k(D d6) {
            super.k(d6);
        }

        j.a<D> l(boolean z5) {
            if (b.f905c) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            throw null;
        }

        public void m(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f908k);
            printWriter.print(" mArgs=");
            printWriter.println(this.f909l);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println((Object) null);
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("  ");
            throw null;
        }

        void n() {
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.f908k);
            sb.append(" : ");
            androidx.core.util.b.a(null, sb);
            sb.append("}}");
            return sb.toString();
        }
    }

    /* renamed from: androidx.loader.app.b$b, reason: collision with other inner class name */
    static class C0017b extends v {

        /* renamed from: e, reason: collision with root package name */
        private static final w.a f911e = new a();

        /* renamed from: c, reason: collision with root package name */
        private g<a> f912c = new g<>();

        /* renamed from: d, reason: collision with root package name */
        private boolean f913d = false;

        /* renamed from: androidx.loader.app.b$b$a */
        static class a implements w.a {
            a() {
            }

            @Override // androidx.lifecycle.w.a
            public <T extends v> T a(Class<T> cls) {
                return new C0017b();
            }
        }

        C0017b() {
        }

        static C0017b e(x xVar) {
            return (C0017b) new w(xVar, f911e).a(C0017b.class);
        }

        @Override // androidx.lifecycle.v
        protected void c() {
            super.c();
            int i6 = this.f912c.i();
            for (int i7 = 0; i7 < i6; i7++) {
                this.f912c.k(i7).l(true);
            }
            this.f912c.a();
        }

        public void d(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f912c.i() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i6 = 0; i6 < this.f912c.i(); i6++) {
                    a k6 = this.f912c.k(i6);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f912c.f(i6));
                    printWriter.print(": ");
                    printWriter.println(k6.toString());
                    k6.m(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }

        void f() {
            int i6 = this.f912c.i();
            for (int i7 = 0; i7 < i6; i7++) {
                this.f912c.k(i7).n();
            }
        }
    }

    b(i iVar, x xVar) {
        this.f906a = iVar;
        this.f907b = C0017b.e(xVar);
    }

    @Override // androidx.loader.app.a
    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f907b.d(str, fileDescriptor, printWriter, strArr);
    }

    @Override // androidx.loader.app.a
    public void c() {
        this.f907b.f();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        androidx.core.util.b.a(this.f906a, sb);
        sb.append("}}");
        return sb.toString();
    }
}
