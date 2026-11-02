package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;

/* loaded from: classes.dex */
public final class d2 {

    /* renamed from: a, reason: collision with root package name */
    private final e f488a;

    private static class a extends e {

        /* renamed from: a, reason: collision with root package name */
        protected final Window f489a;

        /* renamed from: b, reason: collision with root package name */
        private final View f490b;

        a(Window window, View view) {
            this.f489a = window;
            this.f490b = view;
        }

        protected void c(int i6) {
            View decorView = this.f489a.getDecorView();
            decorView.setSystemUiVisibility(i6 | decorView.getSystemUiVisibility());
        }

        protected void d(int i6) {
            this.f489a.addFlags(i6);
        }

        protected void e(int i6) {
            View decorView = this.f489a.getDecorView();
            decorView.setSystemUiVisibility((~i6) & decorView.getSystemUiVisibility());
        }

        protected void f(int i6) {
            this.f489a.clearFlags(i6);
        }
    }

    private static class b extends a {
        b(Window window, View view) {
            super(window, view);
        }

        @Override // androidx.core.view.d2.e
        public void b(boolean z5) {
            if (!z5) {
                e(8192);
                return;
            }
            f(67108864);
            d(Integer.MIN_VALUE);
            c(8192);
        }
    }

    private static class c extends b {
        c(Window window, View view) {
            super(window, view);
        }

        @Override // androidx.core.view.d2.e
        public void a(boolean z5) {
            if (!z5) {
                e(16);
                return;
            }
            f(134217728);
            d(Integer.MIN_VALUE);
            c(16);
        }
    }

    private static class d extends e {

        /* renamed from: a, reason: collision with root package name */
        final d2 f491a;

        /* renamed from: b, reason: collision with root package name */
        final WindowInsetsController f492b;

        /* renamed from: c, reason: collision with root package name */
        private final f.f<Object, WindowInsetsController.OnControllableInsetsChangedListener> f493c;

        /* renamed from: d, reason: collision with root package name */
        protected Window f494d;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        d(android.view.Window r2, androidx.core.view.d2 r3) {
            /*
                r1 = this;
                android.view.WindowInsetsController r0 = androidx.core.view.f2.a(r2)
                r1.<init>(r0, r3)
                r1.f494d = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.d2.d.<init>(android.view.Window, androidx.core.view.d2):void");
        }

        d(WindowInsetsController windowInsetsController, d2 d2Var) {
            this.f493c = new f.f<>();
            this.f492b = windowInsetsController;
            this.f491a = d2Var;
        }

        @Override // androidx.core.view.d2.e
        public void a(boolean z5) {
            if (z5) {
                if (this.f494d != null) {
                    c(16);
                }
                this.f492b.setSystemBarsAppearance(16, 16);
            } else {
                if (this.f494d != null) {
                    d(16);
                }
                this.f492b.setSystemBarsAppearance(0, 16);
            }
        }

        @Override // androidx.core.view.d2.e
        public void b(boolean z5) {
            if (z5) {
                if (this.f494d != null) {
                    c(8192);
                }
                this.f492b.setSystemBarsAppearance(8, 8);
            } else {
                if (this.f494d != null) {
                    d(8192);
                }
                this.f492b.setSystemBarsAppearance(0, 8);
            }
        }

        protected void c(int i6) {
            View decorView = this.f494d.getDecorView();
            decorView.setSystemUiVisibility(i6 | decorView.getSystemUiVisibility());
        }

        protected void d(int i6) {
            View decorView = this.f494d.getDecorView();
            decorView.setSystemUiVisibility((~i6) & decorView.getSystemUiVisibility());
        }
    }

    private static class e {
        e() {
        }

        public void a(boolean z5) {
        }

        public void b(boolean z5) {
        }
    }

    public d2(Window window, View view) {
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 30) {
            this.f488a = new d(window, this);
        } else {
            this.f488a = i6 >= 26 ? new c(window, view) : i6 >= 23 ? new b(window, view) : new a(window, view);
        }
    }

    public void a(boolean z5) {
        this.f488a.a(z5);
    }

    public void b(boolean z5) {
        this.f488a.b(z5);
    }
}
