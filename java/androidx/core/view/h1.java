package androidx.core.view;

import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

/* loaded from: classes.dex */
public class h1 {

    /* renamed from: b, reason: collision with root package name */
    public static final h1 f497b;

    /* renamed from: a, reason: collision with root package name */
    private final l f498a;

    static class a {

        /* renamed from: a, reason: collision with root package name */
        private static Field f499a;

        /* renamed from: b, reason: collision with root package name */
        private static Field f500b;

        /* renamed from: c, reason: collision with root package name */
        private static Field f501c;

        /* renamed from: d, reason: collision with root package name */
        private static boolean f502d;

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mAttachInfo");
                f499a = declaredField;
                declaredField.setAccessible(true);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                Field declaredField2 = cls.getDeclaredField("mStableInsets");
                f500b = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("mContentInsets");
                f501c = declaredField3;
                declaredField3.setAccessible(true);
                f502d = true;
            } catch (ReflectiveOperationException e6) {
                Log.w("WindowInsetsCompat", "Failed to get visible insets from AttachInfo " + e6.getMessage(), e6);
            }
        }

        public static h1 a(View view) {
            if (f502d && view.isAttachedToWindow()) {
                try {
                    Object obj = f499a.get(view.getRootView());
                    if (obj != null) {
                        Rect rect = (Rect) f500b.get(obj);
                        Rect rect2 = (Rect) f501c.get(obj);
                        if (rect != null && rect2 != null) {
                            h1 a6 = new b().b(androidx.core.graphics.f.c(rect)).c(androidx.core.graphics.f.c(rect2)).a();
                            a6.j(a6);
                            a6.d(view.getRootView());
                            return a6;
                        }
                    }
                } catch (IllegalAccessException e6) {
                    Log.w("WindowInsetsCompat", "Failed to get insets from AttachInfo. " + e6.getMessage(), e6);
                }
            }
            return null;
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final f f503a;

        public b() {
            int i6 = Build.VERSION.SDK_INT;
            this.f503a = i6 >= 30 ? new e() : i6 >= 29 ? new d() : new c();
        }

        public h1 a() {
            return this.f503a.b();
        }

        @Deprecated
        public b b(androidx.core.graphics.f fVar) {
            this.f503a.d(fVar);
            return this;
        }

        @Deprecated
        public b c(androidx.core.graphics.f fVar) {
            this.f503a.f(fVar);
            return this;
        }
    }

    private static class c extends f {

        /* renamed from: e, reason: collision with root package name */
        private static Field f504e = null;

        /* renamed from: f, reason: collision with root package name */
        private static boolean f505f = false;

        /* renamed from: g, reason: collision with root package name */
        private static Constructor<WindowInsets> f506g = null;

        /* renamed from: h, reason: collision with root package name */
        private static boolean f507h = false;

        /* renamed from: c, reason: collision with root package name */
        private WindowInsets f508c = h();

        /* renamed from: d, reason: collision with root package name */
        private androidx.core.graphics.f f509d;

        c() {
        }

        private static WindowInsets h() {
            if (!f505f) {
                try {
                    f504e = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException e6) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e6);
                }
                f505f = true;
            }
            Field field = f504e;
            if (field != null) {
                try {
                    WindowInsets windowInsets = (WindowInsets) field.get(null);
                    if (windowInsets != null) {
                        return new WindowInsets(windowInsets);
                    }
                } catch (ReflectiveOperationException e7) {
                    Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e7);
                }
            }
            if (!f507h) {
                try {
                    f506g = WindowInsets.class.getConstructor(Rect.class);
                } catch (ReflectiveOperationException e8) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e8);
                }
                f507h = true;
            }
            Constructor<WindowInsets> constructor = f506g;
            if (constructor != null) {
                try {
                    return constructor.newInstance(new Rect());
                } catch (ReflectiveOperationException e9) {
                    Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e9);
                }
            }
            return null;
        }

        @Override // androidx.core.view.h1.f
        h1 b() {
            a();
            h1 m6 = h1.m(this.f508c);
            m6.h(this.f512b);
            m6.k(this.f509d);
            return m6;
        }

        @Override // androidx.core.view.h1.f
        void d(androidx.core.graphics.f fVar) {
            this.f509d = fVar;
        }

        @Override // androidx.core.view.h1.f
        void f(androidx.core.graphics.f fVar) {
            WindowInsets windowInsets = this.f508c;
            if (windowInsets != null) {
                this.f508c = windowInsets.replaceSystemWindowInsets(fVar.f434a, fVar.f435b, fVar.f436c, fVar.f437d);
            }
        }
    }

    private static class d extends f {

        /* renamed from: c, reason: collision with root package name */
        final WindowInsets.Builder f510c = new WindowInsets.Builder();

        d() {
        }

        @Override // androidx.core.view.h1.f
        h1 b() {
            WindowInsets build;
            a();
            build = this.f510c.build();
            h1 m6 = h1.m(build);
            m6.h(this.f512b);
            return m6;
        }

        @Override // androidx.core.view.h1.f
        void c(androidx.core.graphics.f fVar) {
            this.f510c.setMandatorySystemGestureInsets(fVar.e());
        }

        @Override // androidx.core.view.h1.f
        void d(androidx.core.graphics.f fVar) {
            this.f510c.setStableInsets(fVar.e());
        }

        @Override // androidx.core.view.h1.f
        void e(androidx.core.graphics.f fVar) {
            this.f510c.setSystemGestureInsets(fVar.e());
        }

        @Override // androidx.core.view.h1.f
        void f(androidx.core.graphics.f fVar) {
            this.f510c.setSystemWindowInsets(fVar.e());
        }

        @Override // androidx.core.view.h1.f
        void g(androidx.core.graphics.f fVar) {
            this.f510c.setTappableElementInsets(fVar.e());
        }
    }

    private static class e extends d {
        e() {
        }
    }

    private static class f {

        /* renamed from: a, reason: collision with root package name */
        private final h1 f511a;

        /* renamed from: b, reason: collision with root package name */
        androidx.core.graphics.f[] f512b;

        f() {
            this(new h1((h1) null));
        }

        f(h1 h1Var) {
            this.f511a = h1Var;
        }

        protected final void a() {
            androidx.core.graphics.f[] fVarArr = this.f512b;
            if (fVarArr != null) {
                androidx.core.graphics.f fVar = fVarArr[m.a(1)];
                androidx.core.graphics.f fVar2 = this.f512b[m.a(2)];
                if (fVar2 == null) {
                    fVar2 = this.f511a.f(2);
                }
                if (fVar == null) {
                    fVar = this.f511a.f(1);
                }
                f(androidx.core.graphics.f.a(fVar, fVar2));
                androidx.core.graphics.f fVar3 = this.f512b[m.a(16)];
                if (fVar3 != null) {
                    e(fVar3);
                }
                androidx.core.graphics.f fVar4 = this.f512b[m.a(32)];
                if (fVar4 != null) {
                    c(fVar4);
                }
                androidx.core.graphics.f fVar5 = this.f512b[m.a(64)];
                if (fVar5 != null) {
                    g(fVar5);
                }
            }
        }

        h1 b() {
            throw null;
        }

        void c(androidx.core.graphics.f fVar) {
        }

        void d(androidx.core.graphics.f fVar) {
            throw null;
        }

        void e(androidx.core.graphics.f fVar) {
        }

        void f(androidx.core.graphics.f fVar) {
            throw null;
        }

        void g(androidx.core.graphics.f fVar) {
        }
    }

    private static class g extends l {

        /* renamed from: h, reason: collision with root package name */
        private static boolean f513h = false;

        /* renamed from: i, reason: collision with root package name */
        private static Method f514i;

        /* renamed from: j, reason: collision with root package name */
        private static Class<?> f515j;

        /* renamed from: k, reason: collision with root package name */
        private static Field f516k;

        /* renamed from: l, reason: collision with root package name */
        private static Field f517l;

        /* renamed from: c, reason: collision with root package name */
        final WindowInsets f518c;

        /* renamed from: d, reason: collision with root package name */
        private androidx.core.graphics.f[] f519d;

        /* renamed from: e, reason: collision with root package name */
        private androidx.core.graphics.f f520e;

        /* renamed from: f, reason: collision with root package name */
        private h1 f521f;

        /* renamed from: g, reason: collision with root package name */
        androidx.core.graphics.f f522g;

        g(h1 h1Var, WindowInsets windowInsets) {
            super(h1Var);
            this.f520e = null;
            this.f518c = windowInsets;
        }

        g(h1 h1Var, g gVar) {
            this(h1Var, new WindowInsets(gVar.f518c));
        }

        private androidx.core.graphics.f s(int i6, boolean z5) {
            androidx.core.graphics.f fVar = androidx.core.graphics.f.f433e;
            for (int i7 = 1; i7 <= 256; i7 <<= 1) {
                if ((i6 & i7) != 0) {
                    fVar = androidx.core.graphics.f.a(fVar, t(i7, z5));
                }
            }
            return fVar;
        }

        private androidx.core.graphics.f u() {
            h1 h1Var = this.f521f;
            return h1Var != null ? h1Var.g() : androidx.core.graphics.f.f433e;
        }

        private androidx.core.graphics.f v(View view) {
            if (Build.VERSION.SDK_INT >= 30) {
                throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
            }
            if (!f513h) {
                w();
            }
            Method method = f514i;
            if (method != null && f515j != null && f516k != null) {
                try {
                    Object invoke = method.invoke(view, new Object[0]);
                    if (invoke == null) {
                        Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                        return null;
                    }
                    Rect rect = (Rect) f516k.get(f517l.get(invoke));
                    if (rect != null) {
                        return androidx.core.graphics.f.c(rect);
                    }
                    return null;
                } catch (ReflectiveOperationException e6) {
                    Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e6.getMessage(), e6);
                }
            }
            return null;
        }

        private static void w() {
            try {
                f514i = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                f515j = cls;
                f516k = cls.getDeclaredField("mVisibleInsets");
                f517l = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
                f516k.setAccessible(true);
                f517l.setAccessible(true);
            } catch (ReflectiveOperationException e6) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e6.getMessage(), e6);
            }
            f513h = true;
        }

        @Override // androidx.core.view.h1.l
        void d(View view) {
            androidx.core.graphics.f v5 = v(view);
            if (v5 == null) {
                v5 = androidx.core.graphics.f.f433e;
            }
            p(v5);
        }

        @Override // androidx.core.view.h1.l
        void e(h1 h1Var) {
            h1Var.j(this.f521f);
            h1Var.i(this.f522g);
        }

        @Override // androidx.core.view.h1.l
        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return Objects.equals(this.f522g, ((g) obj).f522g);
            }
            return false;
        }

        @Override // androidx.core.view.h1.l
        public androidx.core.graphics.f g(int i6) {
            return s(i6, false);
        }

        @Override // androidx.core.view.h1.l
        final androidx.core.graphics.f k() {
            if (this.f520e == null) {
                this.f520e = androidx.core.graphics.f.b(this.f518c.getSystemWindowInsetLeft(), this.f518c.getSystemWindowInsetTop(), this.f518c.getSystemWindowInsetRight(), this.f518c.getSystemWindowInsetBottom());
            }
            return this.f520e;
        }

        @Override // androidx.core.view.h1.l
        boolean n() {
            return this.f518c.isRound();
        }

        @Override // androidx.core.view.h1.l
        public void o(androidx.core.graphics.f[] fVarArr) {
            this.f519d = fVarArr;
        }

        @Override // androidx.core.view.h1.l
        void p(androidx.core.graphics.f fVar) {
            this.f522g = fVar;
        }

        @Override // androidx.core.view.h1.l
        void q(h1 h1Var) {
            this.f521f = h1Var;
        }

        protected androidx.core.graphics.f t(int i6, boolean z5) {
            androidx.core.graphics.f g6;
            int i7;
            if (i6 == 1) {
                return z5 ? androidx.core.graphics.f.b(0, Math.max(u().f435b, k().f435b), 0, 0) : androidx.core.graphics.f.b(0, k().f435b, 0, 0);
            }
            if (i6 == 2) {
                if (z5) {
                    androidx.core.graphics.f u5 = u();
                    androidx.core.graphics.f i8 = i();
                    return androidx.core.graphics.f.b(Math.max(u5.f434a, i8.f434a), 0, Math.max(u5.f436c, i8.f436c), Math.max(u5.f437d, i8.f437d));
                }
                androidx.core.graphics.f k6 = k();
                h1 h1Var = this.f521f;
                g6 = h1Var != null ? h1Var.g() : null;
                int i9 = k6.f437d;
                if (g6 != null) {
                    i9 = Math.min(i9, g6.f437d);
                }
                return androidx.core.graphics.f.b(k6.f434a, 0, k6.f436c, i9);
            }
            if (i6 != 8) {
                if (i6 == 16) {
                    return j();
                }
                if (i6 == 32) {
                    return h();
                }
                if (i6 == 64) {
                    return l();
                }
                if (i6 != 128) {
                    return androidx.core.graphics.f.f433e;
                }
                h1 h1Var2 = this.f521f;
                androidx.core.view.h e6 = h1Var2 != null ? h1Var2.e() : f();
                return e6 != null ? androidx.core.graphics.f.b(e6.b(), e6.d(), e6.c(), e6.a()) : androidx.core.graphics.f.f433e;
            }
            androidx.core.graphics.f[] fVarArr = this.f519d;
            g6 = fVarArr != null ? fVarArr[m.a(8)] : null;
            if (g6 != null) {
                return g6;
            }
            androidx.core.graphics.f k7 = k();
            androidx.core.graphics.f u6 = u();
            int i10 = k7.f437d;
            if (i10 > u6.f437d) {
                return androidx.core.graphics.f.b(0, 0, 0, i10);
            }
            androidx.core.graphics.f fVar = this.f522g;
            return (fVar == null || fVar.equals(androidx.core.graphics.f.f433e) || (i7 = this.f522g.f437d) <= u6.f437d) ? androidx.core.graphics.f.f433e : androidx.core.graphics.f.b(0, 0, 0, i7);
        }
    }

    private static class h extends g {

        /* renamed from: m, reason: collision with root package name */
        private androidx.core.graphics.f f523m;

        h(h1 h1Var, WindowInsets windowInsets) {
            super(h1Var, windowInsets);
            this.f523m = null;
        }

        h(h1 h1Var, h hVar) {
            super(h1Var, hVar);
            this.f523m = null;
            this.f523m = hVar.f523m;
        }

        @Override // androidx.core.view.h1.l
        h1 b() {
            return h1.m(this.f518c.consumeStableInsets());
        }

        @Override // androidx.core.view.h1.l
        h1 c() {
            return h1.m(this.f518c.consumeSystemWindowInsets());
        }

        @Override // androidx.core.view.h1.l
        final androidx.core.graphics.f i() {
            if (this.f523m == null) {
                this.f523m = androidx.core.graphics.f.b(this.f518c.getStableInsetLeft(), this.f518c.getStableInsetTop(), this.f518c.getStableInsetRight(), this.f518c.getStableInsetBottom());
            }
            return this.f523m;
        }

        @Override // androidx.core.view.h1.l
        boolean m() {
            return this.f518c.isConsumed();
        }

        @Override // androidx.core.view.h1.l
        public void r(androidx.core.graphics.f fVar) {
            this.f523m = fVar;
        }
    }

    private static class i extends h {
        i(h1 h1Var, WindowInsets windowInsets) {
            super(h1Var, windowInsets);
        }

        i(h1 h1Var, i iVar) {
            super(h1Var, iVar);
        }

        @Override // androidx.core.view.h1.l
        h1 a() {
            WindowInsets consumeDisplayCutout;
            consumeDisplayCutout = this.f518c.consumeDisplayCutout();
            return h1.m(consumeDisplayCutout);
        }

        @Override // androidx.core.view.h1.g, androidx.core.view.h1.l
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof i)) {
                return false;
            }
            i iVar = (i) obj;
            return Objects.equals(this.f518c, iVar.f518c) && Objects.equals(this.f522g, iVar.f522g);
        }

        @Override // androidx.core.view.h1.l
        androidx.core.view.h f() {
            DisplayCutout displayCutout;
            displayCutout = this.f518c.getDisplayCutout();
            return androidx.core.view.h.e(displayCutout);
        }

        @Override // androidx.core.view.h1.l
        public int hashCode() {
            return this.f518c.hashCode();
        }
    }

    private static class j extends i {

        /* renamed from: n, reason: collision with root package name */
        private androidx.core.graphics.f f524n;

        /* renamed from: o, reason: collision with root package name */
        private androidx.core.graphics.f f525o;

        /* renamed from: p, reason: collision with root package name */
        private androidx.core.graphics.f f526p;

        j(h1 h1Var, WindowInsets windowInsets) {
            super(h1Var, windowInsets);
            this.f524n = null;
            this.f525o = null;
            this.f526p = null;
        }

        j(h1 h1Var, j jVar) {
            super(h1Var, jVar);
            this.f524n = null;
            this.f525o = null;
            this.f526p = null;
        }

        @Override // androidx.core.view.h1.l
        androidx.core.graphics.f h() {
            Insets mandatorySystemGestureInsets;
            if (this.f525o == null) {
                mandatorySystemGestureInsets = this.f518c.getMandatorySystemGestureInsets();
                this.f525o = androidx.core.graphics.f.d(mandatorySystemGestureInsets);
            }
            return this.f525o;
        }

        @Override // androidx.core.view.h1.l
        androidx.core.graphics.f j() {
            Insets systemGestureInsets;
            if (this.f524n == null) {
                systemGestureInsets = this.f518c.getSystemGestureInsets();
                this.f524n = androidx.core.graphics.f.d(systemGestureInsets);
            }
            return this.f524n;
        }

        @Override // androidx.core.view.h1.l
        androidx.core.graphics.f l() {
            Insets tappableElementInsets;
            if (this.f526p == null) {
                tappableElementInsets = this.f518c.getTappableElementInsets();
                this.f526p = androidx.core.graphics.f.d(tappableElementInsets);
            }
            return this.f526p;
        }

        @Override // androidx.core.view.h1.h, androidx.core.view.h1.l
        public void r(androidx.core.graphics.f fVar) {
        }
    }

    private static class k extends j {

        /* renamed from: q, reason: collision with root package name */
        static final h1 f527q;

        static {
            WindowInsets windowInsets;
            windowInsets = WindowInsets.CONSUMED;
            f527q = h1.m(windowInsets);
        }

        k(h1 h1Var, WindowInsets windowInsets) {
            super(h1Var, windowInsets);
        }

        k(h1 h1Var, k kVar) {
            super(h1Var, kVar);
        }

        @Override // androidx.core.view.h1.g, androidx.core.view.h1.l
        final void d(View view) {
        }

        @Override // androidx.core.view.h1.g, androidx.core.view.h1.l
        public androidx.core.graphics.f g(int i6) {
            Insets insets;
            insets = this.f518c.getInsets(n.a(i6));
            return androidx.core.graphics.f.d(insets);
        }
    }

    private static class l {

        /* renamed from: b, reason: collision with root package name */
        static final h1 f528b = new b().a().a().b().c();

        /* renamed from: a, reason: collision with root package name */
        final h1 f529a;

        l(h1 h1Var) {
            this.f529a = h1Var;
        }

        h1 a() {
            return this.f529a;
        }

        h1 b() {
            return this.f529a;
        }

        h1 c() {
            return this.f529a;
        }

        void d(View view) {
        }

        void e(h1 h1Var) {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof l)) {
                return false;
            }
            l lVar = (l) obj;
            return n() == lVar.n() && m() == lVar.m() && androidx.core.util.d.a(k(), lVar.k()) && androidx.core.util.d.a(i(), lVar.i()) && androidx.core.util.d.a(f(), lVar.f());
        }

        androidx.core.view.h f() {
            return null;
        }

        androidx.core.graphics.f g(int i6) {
            return androidx.core.graphics.f.f433e;
        }

        androidx.core.graphics.f h() {
            return k();
        }

        public int hashCode() {
            return androidx.core.util.d.b(Boolean.valueOf(n()), Boolean.valueOf(m()), k(), i(), f());
        }

        androidx.core.graphics.f i() {
            return androidx.core.graphics.f.f433e;
        }

        androidx.core.graphics.f j() {
            return k();
        }

        androidx.core.graphics.f k() {
            return androidx.core.graphics.f.f433e;
        }

        androidx.core.graphics.f l() {
            return k();
        }

        boolean m() {
            return false;
        }

        boolean n() {
            return false;
        }

        public void o(androidx.core.graphics.f[] fVarArr) {
        }

        void p(androidx.core.graphics.f fVar) {
        }

        void q(h1 h1Var) {
        }

        public void r(androidx.core.graphics.f fVar) {
        }
    }

    public static final class m {
        static int a(int i6) {
            if (i6 == 1) {
                return 0;
            }
            if (i6 == 2) {
                return 1;
            }
            if (i6 == 4) {
                return 2;
            }
            if (i6 == 8) {
                return 3;
            }
            if (i6 == 16) {
                return 4;
            }
            if (i6 == 32) {
                return 5;
            }
            if (i6 == 64) {
                return 6;
            }
            if (i6 == 128) {
                return 7;
            }
            if (i6 == 256) {
                return 8;
            }
            throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + i6);
        }
    }

    private static final class n {
        static int a(int i6) {
            int statusBars;
            int i7 = 0;
            for (int i8 = 1; i8 <= 256; i8 <<= 1) {
                if ((i6 & i8) != 0) {
                    if (i8 == 1) {
                        statusBars = WindowInsets.Type.statusBars();
                    } else if (i8 == 2) {
                        statusBars = WindowInsets.Type.navigationBars();
                    } else if (i8 == 4) {
                        statusBars = WindowInsets.Type.captionBar();
                    } else if (i8 == 8) {
                        statusBars = WindowInsets.Type.ime();
                    } else if (i8 == 16) {
                        statusBars = WindowInsets.Type.systemGestures();
                    } else if (i8 == 32) {
                        statusBars = WindowInsets.Type.mandatorySystemGestures();
                    } else if (i8 == 64) {
                        statusBars = WindowInsets.Type.tappableElement();
                    } else if (i8 == 128) {
                        statusBars = WindowInsets.Type.displayCutout();
                    }
                    i7 |= statusBars;
                }
            }
            return i7;
        }
    }

    static {
        f497b = Build.VERSION.SDK_INT >= 30 ? k.f527q : l.f528b;
    }

    private h1(WindowInsets windowInsets) {
        int i6 = Build.VERSION.SDK_INT;
        this.f498a = i6 >= 30 ? new k(this, windowInsets) : i6 >= 29 ? new j(this, windowInsets) : i6 >= 28 ? new i(this, windowInsets) : new h(this, windowInsets);
    }

    public h1(h1 h1Var) {
        if (h1Var == null) {
            this.f498a = new l(this);
            return;
        }
        l lVar = h1Var.f498a;
        int i6 = Build.VERSION.SDK_INT;
        this.f498a = (i6 < 30 || !(lVar instanceof k)) ? (i6 < 29 || !(lVar instanceof j)) ? (i6 < 28 || !(lVar instanceof i)) ? lVar instanceof h ? new h(this, (h) lVar) : lVar instanceof g ? new g(this, (g) lVar) : new l(this) : new i(this, (i) lVar) : new j(this, (j) lVar) : new k(this, (k) lVar);
        lVar.e(this);
    }

    public static h1 m(WindowInsets windowInsets) {
        return n(windowInsets, null);
    }

    public static h1 n(WindowInsets windowInsets, View view) {
        h1 h1Var = new h1((WindowInsets) androidx.core.util.g.a(windowInsets));
        if (view != null && s.s(view)) {
            h1Var.j(s.n(view));
            h1Var.d(view.getRootView());
        }
        return h1Var;
    }

    @Deprecated
    public h1 a() {
        return this.f498a.a();
    }

    @Deprecated
    public h1 b() {
        return this.f498a.b();
    }

    @Deprecated
    public h1 c() {
        return this.f498a.c();
    }

    void d(View view) {
        this.f498a.d(view);
    }

    public androidx.core.view.h e() {
        return this.f498a.f();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof h1) {
            return androidx.core.util.d.a(this.f498a, ((h1) obj).f498a);
        }
        return false;
    }

    public androidx.core.graphics.f f(int i6) {
        return this.f498a.g(i6);
    }

    @Deprecated
    public androidx.core.graphics.f g() {
        return this.f498a.i();
    }

    void h(androidx.core.graphics.f[] fVarArr) {
        this.f498a.o(fVarArr);
    }

    public int hashCode() {
        l lVar = this.f498a;
        if (lVar == null) {
            return 0;
        }
        return lVar.hashCode();
    }

    void i(androidx.core.graphics.f fVar) {
        this.f498a.p(fVar);
    }

    void j(h1 h1Var) {
        this.f498a.q(h1Var);
    }

    void k(androidx.core.graphics.f fVar) {
        this.f498a.r(fVar);
    }

    public WindowInsets l() {
        l lVar = this.f498a;
        if (lVar instanceof g) {
            return ((g) lVar).f518c;
        }
        return null;
    }
}
