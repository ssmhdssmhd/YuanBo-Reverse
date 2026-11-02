package io.flutter.plugin.platform;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Build;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import io.flutter.embedding.android.g0;
import io.flutter.embedding.android.w;
import io.flutter.embedding.engine.FlutterOverlaySurface;
import io.flutter.embedding.engine.mutatorsstack.FlutterMutatorsStack;
import io.flutter.plugin.editing.d0;
import io.flutter.plugin.platform.u;
import io.flutter.view.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import x3.k;

/* loaded from: classes.dex */
public class u implements o {

    /* renamed from: w, reason: collision with root package name */
    private static Class[] f6177w = {SurfaceView.class};

    /* renamed from: b, reason: collision with root package name */
    private io.flutter.embedding.android.a f6179b;

    /* renamed from: c, reason: collision with root package name */
    private Context f6180c;

    /* renamed from: d, reason: collision with root package name */
    private w f6181d;

    /* renamed from: e, reason: collision with root package name */
    private io.flutter.view.t f6182e;

    /* renamed from: f, reason: collision with root package name */
    private d0 f6183f;

    /* renamed from: g, reason: collision with root package name */
    private x3.k f6184g;

    /* renamed from: o, reason: collision with root package name */
    private int f6192o = 0;

    /* renamed from: p, reason: collision with root package name */
    private boolean f6193p = false;

    /* renamed from: q, reason: collision with root package name */
    private boolean f6194q = true;

    /* renamed from: u, reason: collision with root package name */
    private boolean f6198u = false;

    /* renamed from: v, reason: collision with root package name */
    private final k.g f6199v = new a();

    /* renamed from: a, reason: collision with root package name */
    private final k f6178a = new k();

    /* renamed from: i, reason: collision with root package name */
    final HashMap<Integer, v> f6186i = new HashMap<>();

    /* renamed from: h, reason: collision with root package name */
    private final io.flutter.plugin.platform.a f6185h = new io.flutter.plugin.platform.a();

    /* renamed from: j, reason: collision with root package name */
    final HashMap<Context, View> f6187j = new HashMap<>();

    /* renamed from: m, reason: collision with root package name */
    private final SparseArray<b> f6190m = new SparseArray<>();

    /* renamed from: r, reason: collision with root package name */
    private final HashSet<Integer> f6195r = new HashSet<>();

    /* renamed from: s, reason: collision with root package name */
    private final HashSet<Integer> f6196s = new HashSet<>();

    /* renamed from: n, reason: collision with root package name */
    private final SparseArray<n> f6191n = new SparseArray<>();

    /* renamed from: k, reason: collision with root package name */
    private final SparseArray<h> f6188k = new SparseArray<>();

    /* renamed from: l, reason: collision with root package name */
    private final SparseArray<p3.a> f6189l = new SparseArray<>();

    /* renamed from: t, reason: collision with root package name */
    private final g0 f6197t = g0.a();

    class a implements k.g {
        a() {
        }

        private void m(h hVar, k.d dVar) {
            k3.b.e("PlatformViewsController", "Using hybrid composition for platform view: " + dVar.f10557a);
        }

        private long n(h hVar, final k.d dVar) {
            n nVar;
            long j6;
            q(23);
            k3.b.e("PlatformViewsController", "Hosting view in view hierarchy for platform view: " + dVar.f10557a);
            int l02 = u.this.l0(dVar.f10559c);
            int l03 = u.this.l0(dVar.f10560d);
            if (u.this.f6198u) {
                nVar = new n(u.this.f6180c);
                j6 = -1;
            } else {
                t.c a6 = u.this.f6182e.a();
                n nVar2 = new n(u.this.f6180c, a6);
                long e6 = a6.e();
                nVar = nVar2;
                j6 = e6;
            }
            nVar.m(u.this.f6179b);
            nVar.i(l02, l03);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l02, l03);
            int l04 = u.this.l0(dVar.f10561e);
            int l05 = u.this.l0(dVar.f10562f);
            layoutParams.topMargin = l04;
            layoutParams.leftMargin = l05;
            nVar.j(layoutParams);
            View d6 = hVar.d();
            d6.setLayoutParams(new FrameLayout.LayoutParams(l02, l03));
            d6.setImportantForAccessibility(4);
            nVar.addView(d6);
            nVar.k(new View.OnFocusChangeListener() { // from class: io.flutter.plugin.platform.r
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z5) {
                    u.a.this.s(dVar, view, z5);
                }
            });
            u.this.f6181d.addView(nVar);
            u.this.f6191n.append(dVar.f10557a, nVar);
            return j6;
        }

        private long o(h hVar, final k.d dVar) {
            q(20);
            k3.b.e("PlatformViewsController", "Hosting view in a virtual display for platform view: " + dVar.f10557a);
            t.c a6 = u.this.f6182e.a();
            v a7 = v.a(u.this.f6180c, u.this.f6185h, hVar, a6, u.this.l0(dVar.f10559c), u.this.l0(dVar.f10560d), dVar.f10557a, null, new View.OnFocusChangeListener() { // from class: io.flutter.plugin.platform.s
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z5) {
                    u.a.this.t(dVar, view, z5);
                }
            });
            if (a7 != null) {
                if (u.this.f6181d != null) {
                    a7.f(u.this.f6181d);
                }
                u.this.f6186i.put(Integer.valueOf(dVar.f10557a), a7);
                View d6 = hVar.d();
                u.this.f6187j.put(d6.getContext(), d6);
                return a6.e();
            }
            throw new IllegalStateException("Failed creating virtual display for a " + dVar.f10558b + " with id: " + dVar.f10557a);
        }

        private h p(k.d dVar, boolean z5) {
            i a6 = u.this.f6178a.a(dVar.f10558b);
            if (a6 == null) {
                throw new IllegalStateException("Trying to create a platform view of unregistered type: " + dVar.f10558b);
            }
            h a7 = a6.a(z5 ? new MutableContextWrapper(u.this.f6180c) : u.this.f6180c, dVar.f10557a, dVar.f10565i != null ? a6.b().b(dVar.f10565i) : null);
            View d6 = a7.d();
            if (d6 == null) {
                throw new IllegalStateException("PlatformView#getView() returned null, but an Android view reference was expected.");
            }
            d6.setLayoutDirection(dVar.f10563g);
            u.this.f6188k.put(dVar.f10557a, a7);
            return a7;
        }

        private void q(int i6) {
            int i7 = Build.VERSION.SDK_INT;
            if (i7 >= i6) {
                return;
            }
            throw new IllegalStateException("Trying to use platform views with API " + i7 + ", required API level is: " + i6);
        }

        private void r(k.d dVar) {
            if (u.n0(dVar.f10563g)) {
                return;
            }
            throw new IllegalStateException("Trying to create a view with unknown direction value: " + dVar.f10563g + "(view id: " + dVar.f10557a + ")");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void s(k.d dVar, View view, boolean z5) {
            u uVar = u.this;
            if (z5) {
                uVar.f6184g.d(dVar.f10557a);
            } else if (uVar.f6183f != null) {
                u.this.f6183f.l(dVar.f10557a);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void t(k.d dVar, View view, boolean z5) {
            if (z5) {
                u.this.f6184g.d(dVar.f10557a);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void u(v vVar, float f6, k.b bVar) {
            u.this.m0(vVar);
            if (u.this.f6180c != null) {
                f6 = u.this.O();
            }
            bVar.a(new k.c(u.this.j0(vVar.d(), f6), u.this.j0(vVar.c(), f6)));
        }

        @Override // x3.k.g
        public void a(boolean z5) {
            u.this.f6194q = z5;
        }

        @Override // x3.k.g
        public void b(int i6, double d6, double d7) {
            if (u.this.b(i6)) {
                return;
            }
            n nVar = (n) u.this.f6191n.get(i6);
            if (nVar == null) {
                k3.b.b("PlatformViewsController", "Setting offset for unknown platform view with id: " + i6);
                return;
            }
            int l02 = u.this.l0(d6);
            int l03 = u.this.l0(d7);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) nVar.getLayoutParams();
            layoutParams.topMargin = l02;
            layoutParams.leftMargin = l03;
            nVar.j(layoutParams);
        }

        @Override // x3.k.g
        public void c(int i6, int i7) {
            View d6;
            StringBuilder sb;
            String str;
            if (!u.n0(i7)) {
                throw new IllegalStateException("Trying to set unknown direction value: " + i7 + "(view id: " + i6 + ")");
            }
            if (u.this.b(i6)) {
                d6 = u.this.f6186i.get(Integer.valueOf(i6)).e();
            } else {
                h hVar = (h) u.this.f6188k.get(i6);
                if (hVar == null) {
                    sb = new StringBuilder();
                    str = "Setting direction to an unknown view with id: ";
                    sb.append(str);
                    sb.append(i6);
                    k3.b.b("PlatformViewsController", sb.toString());
                }
                d6 = hVar.d();
            }
            if (d6 != null) {
                d6.setLayoutDirection(i7);
                return;
            }
            sb = new StringBuilder();
            str = "Setting direction to a null view with id: ";
            sb.append(str);
            sb.append(i6);
            k3.b.b("PlatformViewsController", sb.toString());
        }

        @Override // x3.k.g
        public void d(k.f fVar) {
            int i6 = fVar.f10573a;
            float f6 = u.this.f6180c.getResources().getDisplayMetrics().density;
            if (u.this.b(i6)) {
                u.this.f6186i.get(Integer.valueOf(i6)).b(u.this.k0(f6, fVar, true));
                return;
            }
            h hVar = (h) u.this.f6188k.get(i6);
            if (hVar == null) {
                k3.b.b("PlatformViewsController", "Sending touch to an unknown view with id: " + i6);
                return;
            }
            View d6 = hVar.d();
            if (d6 != null) {
                d6.dispatchTouchEvent(u.this.k0(f6, fVar, false));
                return;
            }
            k3.b.b("PlatformViewsController", "Sending touch to a null view with id: " + i6);
        }

        @Override // x3.k.g
        public long e(k.d dVar) {
            r(dVar);
            int i6 = dVar.f10557a;
            if (u.this.f6191n.get(i6) != null) {
                throw new IllegalStateException("Trying to create an already created platform view, view id: " + i6);
            }
            if (u.this.f6182e == null) {
                throw new IllegalStateException("Texture registry is null. This means that platform views controller was detached, view id: " + i6);
            }
            if (u.this.f6181d == null) {
                throw new IllegalStateException("Flutter view is null. This means the platform views controller doesn't have an attached view, view id: " + i6);
            }
            h p6 = p(dVar, true);
            View d6 = p6.d();
            if (d6.getParent() != null) {
                throw new IllegalStateException("The Android view returned from PlatformView#getView() was already added to a parent view.");
            }
            if (!(Build.VERSION.SDK_INT >= 23 && !d4.i.f(d6, u.f6177w))) {
                if (dVar.f10564h == k.d.a.TEXTURE_WITH_HYBRID_FALLBACK) {
                    m(p6, dVar);
                    return -2L;
                }
                if (!u.this.f6198u) {
                    return o(p6, dVar);
                }
            }
            return n(p6, dVar);
        }

        @Override // x3.k.g
        public void f(int i6) {
            View d6;
            StringBuilder sb;
            String str;
            if (u.this.b(i6)) {
                d6 = u.this.f6186i.get(Integer.valueOf(i6)).e();
            } else {
                h hVar = (h) u.this.f6188k.get(i6);
                if (hVar == null) {
                    sb = new StringBuilder();
                    str = "Clearing focus on an unknown view with id: ";
                    sb.append(str);
                    sb.append(i6);
                    k3.b.b("PlatformViewsController", sb.toString());
                }
                d6 = hVar.d();
            }
            if (d6 != null) {
                d6.clearFocus();
                return;
            }
            sb = new StringBuilder();
            str = "Clearing focus on a null view with id: ";
            sb.append(str);
            sb.append(i6);
            k3.b.b("PlatformViewsController", sb.toString());
        }

        @Override // x3.k.g
        public void g(k.d dVar) {
            q(19);
            r(dVar);
            m(p(dVar, false), dVar);
        }

        @Override // x3.k.g
        public void h(k.e eVar, final k.b bVar) {
            int l02 = u.this.l0(eVar.f10571b);
            int l03 = u.this.l0(eVar.f10572c);
            int i6 = eVar.f10570a;
            if (u.this.b(i6)) {
                final float O = u.this.O();
                final v vVar = u.this.f6186i.get(Integer.valueOf(i6));
                u.this.U(vVar);
                vVar.i(l02, l03, new Runnable() { // from class: io.flutter.plugin.platform.t
                    @Override // java.lang.Runnable
                    public final void run() {
                        u.a.this.u(vVar, O, bVar);
                    }
                });
                return;
            }
            h hVar = (h) u.this.f6188k.get(i6);
            n nVar = (n) u.this.f6191n.get(i6);
            if (hVar == null || nVar == null) {
                k3.b.b("PlatformViewsController", "Resizing unknown platform view with id: " + i6);
                return;
            }
            if (l02 > nVar.e() || l03 > nVar.d()) {
                nVar.i(l02, l03);
            }
            ViewGroup.LayoutParams layoutParams = nVar.getLayoutParams();
            layoutParams.width = l02;
            layoutParams.height = l03;
            nVar.setLayoutParams(layoutParams);
            View d6 = hVar.d();
            if (d6 != null) {
                ViewGroup.LayoutParams layoutParams2 = d6.getLayoutParams();
                layoutParams2.width = l02;
                layoutParams2.height = l03;
                d6.setLayoutParams(layoutParams2);
            }
            bVar.a(new k.c(u.this.i0(nVar.e()), u.this.i0(nVar.d())));
        }

        @Override // x3.k.g
        public void i(int i6) {
            h hVar = (h) u.this.f6188k.get(i6);
            if (hVar == null) {
                k3.b.b("PlatformViewsController", "Disposing unknown platform view with id: " + i6);
                return;
            }
            u.this.f6188k.remove(i6);
            try {
                hVar.b();
            } catch (RuntimeException e6) {
                k3.b.c("PlatformViewsController", "Disposing platform view threw an exception", e6);
            }
            if (u.this.b(i6)) {
                View e7 = u.this.f6186i.get(Integer.valueOf(i6)).e();
                if (e7 != null) {
                    u.this.f6187j.remove(e7.getContext());
                }
                u.this.f6186i.remove(Integer.valueOf(i6));
                return;
            }
            n nVar = (n) u.this.f6191n.get(i6);
            if (nVar != null) {
                nVar.removeAllViews();
                nVar.h();
                nVar.o();
                ViewGroup viewGroup = (ViewGroup) nVar.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(nVar);
                }
                u.this.f6191n.remove(i6);
                return;
            }
            p3.a aVar = (p3.a) u.this.f6189l.get(i6);
            if (aVar != null) {
                aVar.removeAllViews();
                aVar.b();
                ViewGroup viewGroup2 = (ViewGroup) aVar.getParent();
                if (viewGroup2 != null) {
                    viewGroup2.removeView(aVar);
                }
                u.this.f6189l.remove(i6);
            }
        }
    }

    private void M() {
        while (this.f6188k.size() > 0) {
            this.f6199v.i(this.f6188k.keyAt(0));
        }
    }

    private void N(boolean z5) {
        for (int i6 = 0; i6 < this.f6190m.size(); i6++) {
            int keyAt = this.f6190m.keyAt(i6);
            b valueAt = this.f6190m.valueAt(i6);
            if (this.f6195r.contains(Integer.valueOf(keyAt))) {
                this.f6181d.m(valueAt);
                z5 &= valueAt.c();
            } else {
                if (!this.f6193p) {
                    valueAt.b();
                }
                valueAt.setVisibility(8);
            }
        }
        for (int i7 = 0; i7 < this.f6189l.size(); i7++) {
            int keyAt2 = this.f6189l.keyAt(i7);
            p3.a aVar = this.f6189l.get(keyAt2);
            if (!this.f6196s.contains(Integer.valueOf(keyAt2)) || (!z5 && this.f6194q)) {
                aVar.setVisibility(8);
            } else {
                aVar.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float O() {
        return this.f6180c.getResources().getDisplayMetrics().density;
    }

    private void R() {
        if (!this.f6194q || this.f6193p) {
            return;
        }
        this.f6181d.p();
        this.f6193p = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(int i6, View view, boolean z5) {
        if (z5) {
            this.f6184g.d(i6);
            return;
        }
        d0 d0Var = this.f6183f;
        if (d0Var != null) {
            d0Var.l(i6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T() {
        N(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(v vVar) {
        d0 d0Var = this.f6183f;
        if (d0Var == null) {
            return;
        }
        d0Var.u();
        vVar.g();
    }

    private static MotionEvent.PointerCoords c0(Object obj, float f6) {
        List list = (List) obj;
        MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
        pointerCoords.orientation = (float) ((Double) list.get(0)).doubleValue();
        pointerCoords.pressure = (float) ((Double) list.get(1)).doubleValue();
        pointerCoords.size = (float) ((Double) list.get(2)).doubleValue();
        pointerCoords.toolMajor = ((float) ((Double) list.get(3)).doubleValue()) * f6;
        pointerCoords.toolMinor = ((float) ((Double) list.get(4)).doubleValue()) * f6;
        pointerCoords.touchMajor = ((float) ((Double) list.get(5)).doubleValue()) * f6;
        pointerCoords.touchMinor = ((float) ((Double) list.get(6)).doubleValue()) * f6;
        pointerCoords.x = ((float) ((Double) list.get(7)).doubleValue()) * f6;
        pointerCoords.y = ((float) ((Double) list.get(8)).doubleValue()) * f6;
        return pointerCoords;
    }

    private static List<MotionEvent.PointerCoords> d0(Object obj, float f6) {
        ArrayList arrayList = new ArrayList();
        Iterator it = ((List) obj).iterator();
        while (it.hasNext()) {
            arrayList.add(c0(it.next(), f6));
        }
        return arrayList;
    }

    private static MotionEvent.PointerProperties e0(Object obj) {
        List list = (List) obj;
        MotionEvent.PointerProperties pointerProperties = new MotionEvent.PointerProperties();
        pointerProperties.id = ((Integer) list.get(0)).intValue();
        pointerProperties.toolType = ((Integer) list.get(1)).intValue();
        return pointerProperties;
    }

    private static List<MotionEvent.PointerProperties> f0(Object obj) {
        ArrayList arrayList = new ArrayList();
        Iterator it = ((List) obj).iterator();
        while (it.hasNext()) {
            arrayList.add(e0(it.next()));
        }
        return arrayList;
    }

    private void g0() {
        if (this.f6181d == null) {
            k3.b.b("PlatformViewsController", "removeOverlaySurfaces called while flutter view is null");
            return;
        }
        for (int i6 = 0; i6 < this.f6190m.size(); i6++) {
            this.f6181d.removeView(this.f6190m.valueAt(i6));
        }
        this.f6190m.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int i0(double d6) {
        return j0(d6, O());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int j0(double d6, float f6) {
        return (int) Math.round(d6 / f6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int l0(double d6) {
        return (int) Math.round(d6 * O());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0(v vVar) {
        d0 d0Var = this.f6183f;
        if (d0Var == null) {
            return;
        }
        d0Var.G();
        vVar.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean n0(int i6) {
        return i6 == 0 || i6 == 1;
    }

    public void B(Context context, io.flutter.view.t tVar, m3.a aVar) {
        if (this.f6180c != null) {
            throw new AssertionError("A PlatformViewsController can only be attached to a single output target.\nattach was called while the PlatformViewsController was already attached.");
        }
        this.f6180c = context;
        this.f6182e = tVar;
        x3.k kVar = new x3.k(aVar);
        this.f6184g = kVar;
        kVar.e(this.f6199v);
    }

    public void C(d0 d0Var) {
        this.f6183f = d0Var;
    }

    public void D(w3.a aVar) {
        this.f6179b = new io.flutter.embedding.android.a(aVar, true);
    }

    public void E(w wVar) {
        this.f6181d = wVar;
        for (int i6 = 0; i6 < this.f6191n.size(); i6++) {
            this.f6181d.addView(this.f6191n.valueAt(i6));
        }
        for (int i7 = 0; i7 < this.f6189l.size(); i7++) {
            this.f6181d.addView(this.f6189l.valueAt(i7));
        }
        for (int i8 = 0; i8 < this.f6188k.size(); i8++) {
            this.f6188k.valueAt(i8).e(this.f6181d);
        }
    }

    public boolean F(View view) {
        if (view == null || !this.f6187j.containsKey(view.getContext())) {
            return false;
        }
        View view2 = this.f6187j.get(view.getContext());
        if (view2 == view) {
            return true;
        }
        return view2.checkInputConnectionProxy(view);
    }

    public FlutterOverlaySurface G() {
        return H(new b(this.f6181d.getContext(), this.f6181d.getWidth(), this.f6181d.getHeight(), this.f6185h));
    }

    public FlutterOverlaySurface H(b bVar) {
        int i6 = this.f6192o;
        this.f6192o = i6 + 1;
        this.f6190m.put(i6, bVar);
        return new FlutterOverlaySurface(i6, bVar.getSurface());
    }

    public void I() {
        for (int i6 = 0; i6 < this.f6190m.size(); i6++) {
            b valueAt = this.f6190m.valueAt(i6);
            valueAt.b();
            valueAt.f();
        }
    }

    public void J() {
        x3.k kVar = this.f6184g;
        if (kVar != null) {
            kVar.e(null);
        }
        I();
        this.f6184g = null;
        this.f6180c = null;
        this.f6182e = null;
    }

    public void K() {
        for (int i6 = 0; i6 < this.f6191n.size(); i6++) {
            this.f6181d.removeView(this.f6191n.valueAt(i6));
        }
        for (int i7 = 0; i7 < this.f6189l.size(); i7++) {
            this.f6181d.removeView(this.f6189l.valueAt(i7));
        }
        I();
        g0();
        this.f6181d = null;
        this.f6193p = false;
        for (int i8 = 0; i8 < this.f6188k.size(); i8++) {
            this.f6188k.valueAt(i8).f();
        }
    }

    public void L() {
        this.f6183f = null;
    }

    public j P() {
        return this.f6178a;
    }

    void Q(final int i6) {
        h hVar = this.f6188k.get(i6);
        if (hVar == null) {
            throw new IllegalStateException("Platform view hasn't been initialized from the platform view channel.");
        }
        if (this.f6189l.get(i6) != null) {
            return;
        }
        View d6 = hVar.d();
        if (d6 == null) {
            throw new IllegalStateException("PlatformView#getView() returned null, but an Android view reference was expected.");
        }
        if (d6.getParent() != null) {
            throw new IllegalStateException("The Android view returned from PlatformView#getView() was already added to a parent view.");
        }
        Context context = this.f6180c;
        p3.a aVar = new p3.a(context, context.getResources().getDisplayMetrics().density, this.f6179b);
        aVar.setOnDescendantFocusChangeListener(new View.OnFocusChangeListener() { // from class: io.flutter.plugin.platform.p
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z5) {
                u.this.S(i6, view, z5);
            }
        });
        this.f6189l.put(i6, aVar);
        d6.setImportantForAccessibility(4);
        aVar.addView(d6);
        this.f6181d.addView(aVar);
    }

    public void V() {
    }

    public void W() {
        this.f6195r.clear();
        this.f6196s.clear();
    }

    public void X() {
        M();
    }

    public void Y(int i6, int i7, int i8, int i9, int i10) {
        if (this.f6190m.get(i6) == null) {
            throw new IllegalStateException("The overlay surface (id:" + i6 + ") doesn't exist");
        }
        R();
        b bVar = this.f6190m.get(i6);
        if (bVar.getParent() == null) {
            this.f6181d.addView(bVar);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i9, i10);
        layoutParams.leftMargin = i7;
        layoutParams.topMargin = i8;
        bVar.setLayoutParams(layoutParams);
        bVar.setVisibility(0);
        bVar.bringToFront();
        this.f6195r.add(Integer.valueOf(i6));
    }

    public void Z(int i6, int i7, int i8, int i9, int i10, int i11, int i12, FlutterMutatorsStack flutterMutatorsStack) {
        R();
        Q(i6);
        p3.a aVar = this.f6189l.get(i6);
        aVar.a(flutterMutatorsStack, i7, i8, i9, i10);
        aVar.setVisibility(0);
        aVar.bringToFront();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i11, i12);
        View d6 = this.f6188k.get(i6).d();
        if (d6 != null) {
            d6.setLayoutParams(layoutParams);
            d6.bringToFront();
        }
        this.f6196s.add(Integer.valueOf(i6));
    }

    @Override // io.flutter.plugin.platform.o
    public void a(io.flutter.view.h hVar) {
        this.f6185h.c(hVar);
    }

    public void a0() {
        boolean z5 = false;
        if (this.f6193p && this.f6196s.isEmpty()) {
            this.f6193p = false;
            this.f6181d.B(new Runnable() { // from class: io.flutter.plugin.platform.q
                @Override // java.lang.Runnable
                public final void run() {
                    u.this.T();
                }
            });
        } else {
            if (this.f6193p && this.f6181d.j()) {
                z5 = true;
            }
            N(z5);
        }
    }

    @Override // io.flutter.plugin.platform.o
    public boolean b(int i6) {
        return this.f6186i.containsKey(Integer.valueOf(i6));
    }

    public void b0() {
        M();
    }

    @Override // io.flutter.plugin.platform.o
    public View c(int i6) {
        if (b(i6)) {
            return this.f6186i.get(Integer.valueOf(i6)).e();
        }
        h hVar = this.f6188k.get(i6);
        if (hVar == null) {
            return null;
        }
        return hVar.d();
    }

    @Override // io.flutter.plugin.platform.o
    public void d() {
        this.f6185h.c(null);
    }

    public void h0(boolean z5) {
        this.f6198u = z5;
    }

    public MotionEvent k0(float f6, k.f fVar, boolean z5) {
        MotionEvent b6 = this.f6197t.b(g0.a.c(fVar.f10588p));
        MotionEvent.PointerProperties[] pointerPropertiesArr = (MotionEvent.PointerProperties[]) f0(fVar.f10578f).toArray(new MotionEvent.PointerProperties[fVar.f10577e]);
        MotionEvent.PointerCoords[] pointerCoordsArr = (MotionEvent.PointerCoords[]) d0(fVar.f10579g, f6).toArray(new MotionEvent.PointerCoords[fVar.f10577e]);
        return (z5 || b6 == null) ? MotionEvent.obtain(fVar.f10574b.longValue(), fVar.f10575c.longValue(), fVar.f10576d, fVar.f10577e, pointerPropertiesArr, pointerCoordsArr, fVar.f10580h, fVar.f10581i, fVar.f10582j, fVar.f10583k, fVar.f10584l, fVar.f10585m, fVar.f10586n, fVar.f10587o) : MotionEvent.obtain(b6.getDownTime(), b6.getEventTime(), fVar.f10576d, fVar.f10577e, pointerPropertiesArr, pointerCoordsArr, b6.getMetaState(), b6.getButtonState(), b6.getXPrecision(), b6.getYPrecision(), b6.getDeviceId(), b6.getEdgeFlags(), b6.getSource(), b6.getFlags());
    }
}
