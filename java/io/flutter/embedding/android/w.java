package io.flutter.embedding.android;

import a4.b;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.DisplayCutout;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewStructure;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textservice.SpellCheckerInfo;
import android.view.textservice.TextServicesManager;
import android.widget.FrameLayout;
import androidx.window.java.layout.WindowInfoTrackerCallbackAdapter;
import androidx.window.layout.WindowInfoTracker;
import androidx.window.layout.WindowLayoutInfo;
import io.flutter.embedding.android.e0;
import io.flutter.embedding.android.m;
import io.flutter.view.h;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import w3.a;

/* loaded from: classes.dex */
public class w extends FrameLayout implements b.c, e0.e {

    /* renamed from: a, reason: collision with root package name */
    private n f5942a;

    /* renamed from: b, reason: collision with root package name */
    private o f5943b;

    /* renamed from: c, reason: collision with root package name */
    private m f5944c;

    /* renamed from: d, reason: collision with root package name */
    w3.c f5945d;

    /* renamed from: e, reason: collision with root package name */
    private w3.c f5946e;

    /* renamed from: f, reason: collision with root package name */
    private final Set<w3.b> f5947f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f5948g;

    /* renamed from: h, reason: collision with root package name */
    private io.flutter.embedding.engine.a f5949h;

    /* renamed from: i, reason: collision with root package name */
    private final Set<f> f5950i;

    /* renamed from: j, reason: collision with root package name */
    private a4.b f5951j;

    /* renamed from: k, reason: collision with root package name */
    private io.flutter.plugin.editing.d0 f5952k;

    /* renamed from: l, reason: collision with root package name */
    private io.flutter.plugin.editing.k f5953l;

    /* renamed from: m, reason: collision with root package name */
    private z3.d f5954m;

    /* renamed from: n, reason: collision with root package name */
    private e0 f5955n;

    /* renamed from: o, reason: collision with root package name */
    private io.flutter.embedding.android.a f5956o;

    /* renamed from: p, reason: collision with root package name */
    private io.flutter.view.h f5957p;

    /* renamed from: q, reason: collision with root package name */
    private TextServicesManager f5958q;

    /* renamed from: r, reason: collision with root package name */
    private l0 f5959r;

    /* renamed from: s, reason: collision with root package name */
    private final a.g f5960s;

    /* renamed from: t, reason: collision with root package name */
    private final h.k f5961t;

    /* renamed from: u, reason: collision with root package name */
    private final ContentObserver f5962u;

    /* renamed from: v, reason: collision with root package name */
    private final w3.b f5963v;

    /* renamed from: w, reason: collision with root package name */
    private final androidx.core.util.a<WindowLayoutInfo> f5964w;

    class a implements h.k {
        a() {
        }

        @Override // io.flutter.view.h.k
        public void a(boolean z5, boolean z6) {
            w.this.A(z5, z6);
        }
    }

    class b extends ContentObserver {
        b(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z5) {
            super.onChange(z5);
            if (w.this.f5949h == null) {
                return;
            }
            k3.b.f("FlutterView", "System settings changed. Sending user settings to Flutter.");
            w.this.C();
        }
    }

    class c implements w3.b {
        c() {
        }

        @Override // w3.b
        public void c() {
            w.this.f5948g = false;
            Iterator it = w.this.f5947f.iterator();
            while (it.hasNext()) {
                ((w3.b) it.next()).c();
            }
        }

        @Override // w3.b
        public void f() {
            w.this.f5948g = true;
            Iterator it = w.this.f5947f.iterator();
            while (it.hasNext()) {
                ((w3.b) it.next()).f();
            }
        }
    }

    class d implements androidx.core.util.a<WindowLayoutInfo> {
        d() {
        }

        @Override // androidx.core.util.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(WindowLayoutInfo windowLayoutInfo) {
            w.this.setWindowInfoListenerDisplayFeatures(windowLayoutInfo);
        }
    }

    class e implements w3.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ w3.a f5969a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Runnable f5970b;

        e(w3.a aVar, Runnable runnable) {
            this.f5969a = aVar;
            this.f5970b = runnable;
        }

        @Override // w3.b
        public void c() {
        }

        @Override // w3.b
        public void f() {
            this.f5969a.q(this);
            this.f5970b.run();
            w wVar = w.this;
            if ((wVar.f5945d instanceof m) || wVar.f5944c == null) {
                return;
            }
            w.this.f5944c.b();
        }
    }

    public interface f {
        void a();

        void b(io.flutter.embedding.engine.a aVar);
    }

    private enum g {
        NONE,
        LEFT,
        RIGHT,
        BOTH
    }

    private w(Context context, AttributeSet attributeSet, n nVar) {
        super(context, attributeSet);
        this.f5947f = new HashSet();
        this.f5950i = new HashSet();
        this.f5960s = new a.g();
        this.f5961t = new a();
        this.f5962u = new b(new Handler(Looper.getMainLooper()));
        this.f5963v = new c();
        this.f5964w = new d();
        this.f5942a = nVar;
        this.f5945d = nVar;
        v();
    }

    private w(Context context, AttributeSet attributeSet, o oVar) {
        super(context, attributeSet);
        this.f5947f = new HashSet();
        this.f5950i = new HashSet();
        this.f5960s = new a.g();
        this.f5961t = new a();
        this.f5962u = new b(new Handler(Looper.getMainLooper()));
        this.f5963v = new c();
        this.f5964w = new d();
        this.f5943b = oVar;
        this.f5945d = oVar;
        v();
    }

    public w(Context context, n nVar) {
        this(context, (AttributeSet) null, nVar);
    }

    public w(Context context, o oVar) {
        this(context, (AttributeSet) null, oVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(boolean z5, boolean z6) {
        boolean z7 = false;
        if (!this.f5949h.p().l() && !z5 && !z6) {
            z7 = true;
        }
        setWillNotDraw(z7);
    }

    private void D() {
        if (!w()) {
            k3.b.g("FlutterView", "Tried to send viewport metrics from Android to Flutter but this FlutterView was not attached to a FlutterEngine.");
            return;
        }
        this.f5960s.f10260a = getResources().getDisplayMetrics().density;
        this.f5960s.f10275p = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.f5949h.p().t(this.f5960s);
    }

    private g o() {
        Context context = getContext();
        int i6 = context.getResources().getConfiguration().orientation;
        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        if (i6 == 2) {
            if (rotation == 1) {
                return g.RIGHT;
            }
            if (rotation == 3) {
                return Build.VERSION.SDK_INT >= 23 ? g.LEFT : g.RIGHT;
            }
            if (rotation == 0 || rotation == 2) {
                return g.BOTH;
            }
        }
        return g.NONE;
    }

    private int t(WindowInsets windowInsets) {
        if (windowInsets.getSystemWindowInsetBottom() < getRootView().getHeight() * 0.18d) {
            return 0;
        }
        return windowInsets.getSystemWindowInsetBottom();
    }

    private void v() {
        View view;
        k3.b.f("FlutterView", "Initializing FlutterView");
        if (this.f5942a != null) {
            k3.b.f("FlutterView", "Internally using a FlutterSurfaceView.");
            view = this.f5942a;
        } else if (this.f5943b != null) {
            k3.b.f("FlutterView", "Internally using a FlutterTextureView.");
            view = this.f5943b;
        } else {
            k3.b.f("FlutterView", "Internally using a FlutterImageView.");
            view = this.f5944c;
        }
        addView(view);
        setFocusable(true);
        setFocusableInTouchMode(true);
        if (Build.VERSION.SDK_INT >= 26) {
            setImportantForAutofill(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean x(SpellCheckerInfo spellCheckerInfo) {
        return spellCheckerInfo.getPackageName().equals("com.google.android.inputmethod.latin");
    }

    public void B(Runnable runnable) {
        m mVar = this.f5944c;
        if (mVar == null) {
            k3.b.f("FlutterView", "Tried to revert the image view, but no image view is used.");
            return;
        }
        w3.c cVar = this.f5946e;
        if (cVar == null) {
            k3.b.f("FlutterView", "Tried to revert the image view, but no previous surface was used.");
            return;
        }
        this.f5945d = cVar;
        this.f5946e = null;
        io.flutter.embedding.engine.a aVar = this.f5949h;
        if (aVar == null) {
            mVar.b();
            runnable.run();
            return;
        }
        w3.a p6 = aVar.p();
        if (p6 == null) {
            this.f5944c.b();
            runnable.run();
        } else {
            this.f5945d.a(p6);
            p6.g(new e(p6, runnable));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003f, code lost:
    
        if (r1 != false) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void C() {
        /*
            r6 = this;
            android.content.res.Resources r0 = r6.getResources()
            android.content.res.Configuration r0 = r0.getConfiguration()
            int r0 = r0.uiMode
            r0 = r0 & 48
            r1 = 32
            r2 = 0
            r3 = 1
            if (r0 != r1) goto L14
            r0 = 1
            goto L15
        L14:
            r0 = 0
        L15:
            if (r0 == 0) goto L1a
            x3.m$b r0 = x3.m.b.dark
            goto L1c
        L1a:
            x3.m$b r0 = x3.m.b.light
        L1c:
            android.view.textservice.TextServicesManager r1 = r6.f5958q
            if (r1 == 0) goto L43
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 31
            if (r4 < r5) goto L41
            java.util.List r1 = io.flutter.embedding.android.q.a(r1)
            java.util.stream.Stream r1 = io.flutter.embedding.android.r.a(r1)
            io.flutter.embedding.android.v r4 = new io.flutter.embedding.android.v
            r4.<init>()
            boolean r1 = io.flutter.embedding.android.s.a(r1, r4)
            android.view.textservice.TextServicesManager r4 = r6.f5958q
            boolean r4 = io.flutter.embedding.android.t.a(r4)
            if (r4 == 0) goto L43
            if (r1 == 0) goto L43
        L41:
            r1 = 1
            goto L44
        L43:
            r1 = 0
        L44:
            io.flutter.embedding.engine.a r4 = r6.f5949h
            x3.m r4 = r4.r()
            x3.m$a r4 = r4.a()
            android.content.res.Resources r5 = r6.getResources()
            android.content.res.Configuration r5 = r5.getConfiguration()
            float r5 = r5.fontScale
            x3.m$a r4 = r4.e(r5)
            x3.m$a r1 = r4.c(r1)
            android.content.Context r4 = r6.getContext()
            android.content.ContentResolver r4 = r4.getContentResolver()
            java.lang.String r5 = "show_password"
            int r4 = android.provider.Settings.System.getInt(r4, r5, r3)
            if (r4 != r3) goto L71
            r2 = 1
        L71:
            x3.m$a r1 = r1.b(r2)
            android.content.Context r2 = r6.getContext()
            boolean r2 = android.text.format.DateFormat.is24HourFormat(r2)
            x3.m$a r1 = r1.f(r2)
            x3.m$a r0 = r1.d(r0)
            r0.a()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.android.w.C():void");
    }

    @Override // io.flutter.embedding.android.e0.e
    public void a(KeyEvent keyEvent) {
        getRootView().dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.View
    public void autofill(SparseArray<AutofillValue> sparseArray) {
        this.f5952k.j(sparseArray);
    }

    @Override // a4.b.c
    public PointerIcon b(int i6) {
        PointerIcon systemIcon;
        systemIcon = PointerIcon.getSystemIcon(getContext(), i6);
        return systemIcon;
    }

    @Override // io.flutter.embedding.android.e0.e
    public boolean c(KeyEvent keyEvent) {
        return this.f5952k.r(keyEvent);
    }

    @Override // android.view.View
    public boolean checkInputConnectionProxy(View view) {
        io.flutter.embedding.engine.a aVar = this.f5949h;
        return aVar != null ? aVar.n().F(view) : super.checkInputConnectionProxy(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
            getKeyDispatcherState().startTracking(keyEvent, this);
        } else if (keyEvent.getAction() == 1) {
            getKeyDispatcherState().handleUpEvent(keyEvent);
        }
        return (w() && this.f5955n.a(keyEvent)) || super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    @Override // android.view.View
    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        io.flutter.view.h hVar = this.f5957p;
        if (hVar == null || !hVar.D()) {
            return null;
        }
        return this.f5957p;
    }

    public io.flutter.embedding.engine.a getAttachedFlutterEngine() {
        return this.f5949h;
    }

    @Override // io.flutter.embedding.android.e0.e
    public y3.c getBinaryMessenger() {
        return this.f5949h.h();
    }

    public m getCurrentImageSurface() {
        return this.f5944c;
    }

    public boolean j() {
        m mVar = this.f5944c;
        if (mVar != null) {
            return mVar.c();
        }
        return false;
    }

    public void k(f fVar) {
        this.f5950i.add(fVar);
    }

    public void l(w3.b bVar) {
        this.f5947f.add(bVar);
    }

    public void m(m mVar) {
        io.flutter.embedding.engine.a aVar = this.f5949h;
        if (aVar != null) {
            mVar.a(aVar.p());
        }
    }

    public void n(io.flutter.embedding.engine.a aVar) {
        k3.b.f("FlutterView", "Attaching to a FlutterEngine: " + aVar);
        if (w()) {
            if (aVar == this.f5949h) {
                k3.b.f("FlutterView", "Already attached to this engine. Doing nothing.");
                return;
            } else {
                k3.b.f("FlutterView", "Currently attached to a different engine. Detaching and then attaching to new engine.");
                s();
            }
        }
        this.f5949h = aVar;
        w3.a p6 = aVar.p();
        this.f5948g = p6.k();
        this.f5945d.a(p6);
        p6.g(this.f5963v);
        if (Build.VERSION.SDK_INT >= 24) {
            this.f5951j = new a4.b(this, this.f5949h.k());
        }
        this.f5952k = new io.flutter.plugin.editing.d0(this, this.f5949h.u(), this.f5949h.n());
        try {
            TextServicesManager textServicesManager = (TextServicesManager) getContext().getSystemService("textservices");
            this.f5958q = textServicesManager;
            this.f5953l = new io.flutter.plugin.editing.k(textServicesManager, this.f5949h.s());
        } catch (Exception unused) {
            k3.b.b("FlutterView", "TextServicesManager not supported by device, spell check disabled.");
        }
        this.f5954m = this.f5949h.j();
        this.f5955n = new e0(this);
        this.f5956o = new io.flutter.embedding.android.a(this.f5949h.p(), false);
        io.flutter.view.h hVar = new io.flutter.view.h(this, aVar.f(), (AccessibilityManager) getContext().getSystemService("accessibility"), getContext().getContentResolver(), this.f5949h.n());
        this.f5957p = hVar;
        hVar.Y(this.f5961t);
        A(this.f5957p.D(), this.f5957p.E());
        this.f5949h.n().a(this.f5957p);
        this.f5949h.n().D(this.f5949h.p());
        this.f5952k.q().restartInput(this);
        C();
        getContext().getContentResolver().registerContentObserver(Settings.System.getUriFor("show_password"), false, this.f5962u);
        D();
        aVar.n().E(this);
        Iterator<f> it = this.f5950i.iterator();
        while (it.hasNext()) {
            it.next().b(aVar);
        }
        if (this.f5948g) {
            this.f5963v.f();
        }
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        Insets insets;
        int i6;
        int i7;
        int i8;
        int i9;
        int ime;
        Insets insets2;
        int i10;
        int i11;
        int i12;
        int i13;
        int systemGestures;
        Insets insets3;
        int i14;
        int i15;
        int i16;
        int i17;
        DisplayCutout displayCutout;
        Insets waterfallInsets;
        int i18;
        int safeInsetTop;
        int i19;
        int safeInsetRight;
        int i20;
        int safeInsetBottom;
        int i21;
        int safeInsetLeft;
        int statusBars;
        int navigationBars;
        Insets systemGestureInsets;
        int i22;
        int i23;
        int i24;
        int i25;
        WindowInsets onApplyWindowInsets = super.onApplyWindowInsets(windowInsets);
        int i26 = Build.VERSION.SDK_INT;
        if (i26 == 29) {
            systemGestureInsets = windowInsets.getSystemGestureInsets();
            a.g gVar = this.f5960s;
            i22 = systemGestureInsets.top;
            gVar.f10271l = i22;
            a.g gVar2 = this.f5960s;
            i23 = systemGestureInsets.right;
            gVar2.f10272m = i23;
            a.g gVar3 = this.f5960s;
            i24 = systemGestureInsets.bottom;
            gVar3.f10273n = i24;
            a.g gVar4 = this.f5960s;
            i25 = systemGestureInsets.left;
            gVar4.f10274o = i25;
        }
        int i27 = 0;
        boolean z5 = (getWindowSystemUiVisibility() & 4) == 0;
        boolean z6 = (getWindowSystemUiVisibility() & 2) == 0;
        if (i26 >= 30) {
            if (z6) {
                navigationBars = WindowInsets.Type.navigationBars();
                i27 = 0 | navigationBars;
            }
            if (z5) {
                statusBars = WindowInsets.Type.statusBars();
                i27 |= statusBars;
            }
            insets = windowInsets.getInsets(i27);
            a.g gVar5 = this.f5960s;
            i6 = insets.top;
            gVar5.f10263d = i6;
            a.g gVar6 = this.f5960s;
            i7 = insets.right;
            gVar6.f10264e = i7;
            a.g gVar7 = this.f5960s;
            i8 = insets.bottom;
            gVar7.f10265f = i8;
            a.g gVar8 = this.f5960s;
            i9 = insets.left;
            gVar8.f10266g = i9;
            ime = WindowInsets.Type.ime();
            insets2 = windowInsets.getInsets(ime);
            a.g gVar9 = this.f5960s;
            i10 = insets2.top;
            gVar9.f10267h = i10;
            a.g gVar10 = this.f5960s;
            i11 = insets2.right;
            gVar10.f10268i = i11;
            a.g gVar11 = this.f5960s;
            i12 = insets2.bottom;
            gVar11.f10269j = i12;
            a.g gVar12 = this.f5960s;
            i13 = insets2.left;
            gVar12.f10270k = i13;
            systemGestures = WindowInsets.Type.systemGestures();
            insets3 = windowInsets.getInsets(systemGestures);
            a.g gVar13 = this.f5960s;
            i14 = insets3.top;
            gVar13.f10271l = i14;
            a.g gVar14 = this.f5960s;
            i15 = insets3.right;
            gVar14.f10272m = i15;
            a.g gVar15 = this.f5960s;
            i16 = insets3.bottom;
            gVar15.f10273n = i16;
            a.g gVar16 = this.f5960s;
            i17 = insets3.left;
            gVar16.f10274o = i17;
            displayCutout = windowInsets.getDisplayCutout();
            if (displayCutout != null) {
                waterfallInsets = displayCutout.getWaterfallInsets();
                a.g gVar17 = this.f5960s;
                int i28 = gVar17.f10263d;
                i18 = waterfallInsets.top;
                int max = Math.max(i28, i18);
                safeInsetTop = displayCutout.getSafeInsetTop();
                gVar17.f10263d = Math.max(max, safeInsetTop);
                a.g gVar18 = this.f5960s;
                int i29 = gVar18.f10264e;
                i19 = waterfallInsets.right;
                int max2 = Math.max(i29, i19);
                safeInsetRight = displayCutout.getSafeInsetRight();
                gVar18.f10264e = Math.max(max2, safeInsetRight);
                a.g gVar19 = this.f5960s;
                int i30 = gVar19.f10265f;
                i20 = waterfallInsets.bottom;
                int max3 = Math.max(i30, i20);
                safeInsetBottom = displayCutout.getSafeInsetBottom();
                gVar19.f10265f = Math.max(max3, safeInsetBottom);
                a.g gVar20 = this.f5960s;
                int i31 = gVar20.f10266g;
                i21 = waterfallInsets.left;
                int max4 = Math.max(i31, i21);
                safeInsetLeft = displayCutout.getSafeInsetLeft();
                gVar20.f10266g = Math.max(max4, safeInsetLeft);
            }
        } else {
            g gVar21 = g.NONE;
            if (!z6) {
                gVar21 = o();
            }
            this.f5960s.f10263d = z5 ? windowInsets.getSystemWindowInsetTop() : 0;
            this.f5960s.f10264e = (gVar21 == g.RIGHT || gVar21 == g.BOTH) ? 0 : windowInsets.getSystemWindowInsetRight();
            this.f5960s.f10265f = (z6 && t(windowInsets) == 0) ? windowInsets.getSystemWindowInsetBottom() : 0;
            this.f5960s.f10266g = (gVar21 == g.LEFT || gVar21 == g.BOTH) ? 0 : windowInsets.getSystemWindowInsetLeft();
            a.g gVar22 = this.f5960s;
            gVar22.f10267h = 0;
            gVar22.f10268i = 0;
            gVar22.f10269j = t(windowInsets);
            this.f5960s.f10270k = 0;
        }
        k3.b.f("FlutterView", "Updating window insets (onApplyWindowInsets()):\nStatus bar insets: Top: " + this.f5960s.f10263d + ", Left: " + this.f5960s.f10266g + ", Right: " + this.f5960s.f10264e + "\nKeyboard insets: Bottom: " + this.f5960s.f10269j + ", Left: " + this.f5960s.f10270k + ", Right: " + this.f5960s.f10268i + "System Gesture Insets - Left: " + this.f5960s.f10274o + ", Top: " + this.f5960s.f10271l + ", Right: " + this.f5960s.f10272m + ", Bottom: " + this.f5960s.f10269j);
        D();
        return onApplyWindowInsets;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f5959r = r();
        Activity e6 = d4.i.e(getContext());
        l0 l0Var = this.f5959r;
        if (l0Var == null || e6 == null) {
            return;
        }
        l0Var.a(e6, androidx.core.content.a.d(getContext()), this.f5964w);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f5949h != null) {
            k3.b.f("FlutterView", "Configuration changed. Sending locales and user settings to Flutter.");
            this.f5954m.d(configuration);
            C();
        }
    }

    @Override // android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return !w() ? super.onCreateInputConnection(editorInfo) : this.f5952k.o(this, this.f5955n, editorInfo);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        l0 l0Var = this.f5959r;
        if (l0Var != null) {
            l0Var.b(this.f5964w);
        }
        this.f5959r = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (w() && this.f5956o.e(motionEvent)) {
            return true;
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        return !w() ? super.onHoverEvent(motionEvent) : this.f5957p.J(motionEvent);
    }

    @Override // android.view.View
    public void onProvideAutofillVirtualStructure(ViewStructure viewStructure, int i6) {
        super.onProvideAutofillVirtualStructure(viewStructure, i6);
        this.f5952k.z(viewStructure, i6);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i6, int i7, int i8, int i9) {
        super.onSizeChanged(i6, i7, i8, i9);
        k3.b.f("FlutterView", "Size changed. Sending Flutter new viewport metrics. FlutterView was " + i8 + " x " + i9 + ", it is now " + i6 + " x " + i7);
        a.g gVar = this.f5960s;
        gVar.f10261b = i6;
        gVar.f10262c = i7;
        D();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!w()) {
            return super.onTouchEvent(motionEvent);
        }
        requestUnbufferedDispatch(motionEvent);
        return this.f5956o.f(motionEvent);
    }

    public void p() {
        this.f5945d.d();
        m mVar = this.f5944c;
        if (mVar == null) {
            m q6 = q();
            this.f5944c = q6;
            addView(q6);
        } else {
            mVar.j(getWidth(), getHeight());
        }
        this.f5946e = this.f5945d;
        m mVar2 = this.f5944c;
        this.f5945d = mVar2;
        io.flutter.embedding.engine.a aVar = this.f5949h;
        if (aVar != null) {
            mVar2.a(aVar.p());
        }
    }

    public m q() {
        return new m(getContext(), getWidth(), getHeight(), m.b.background);
    }

    protected l0 r() {
        try {
            return new l0(new WindowInfoTrackerCallbackAdapter(WindowInfoTracker.Companion.getOrCreate(getContext())));
        } catch (NoClassDefFoundError unused) {
            return null;
        }
    }

    public void s() {
        k3.b.f("FlutterView", "Detaching from a FlutterEngine: " + this.f5949h);
        if (!w()) {
            k3.b.f("FlutterView", "FlutterView not attached to an engine. Not detaching.");
            return;
        }
        Iterator<f> it = this.f5950i.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        getContext().getContentResolver().unregisterContentObserver(this.f5962u);
        this.f5949h.n().K();
        this.f5949h.n().d();
        this.f5957p.Q();
        this.f5957p = null;
        this.f5952k.q().restartInput(this);
        this.f5952k.p();
        this.f5955n.c();
        io.flutter.plugin.editing.k kVar = this.f5953l;
        if (kVar != null) {
            kVar.b();
        }
        a4.b bVar = this.f5951j;
        if (bVar != null) {
            bVar.c();
        }
        w3.a p6 = this.f5949h.p();
        this.f5948g = false;
        p6.q(this.f5963v);
        p6.v();
        p6.s(false);
        w3.c cVar = this.f5946e;
        if (cVar != null && this.f5945d == this.f5944c) {
            this.f5945d = cVar;
        }
        this.f5945d.b();
        m mVar = this.f5944c;
        if (mVar != null) {
            mVar.f();
            removeView(this.f5944c);
            this.f5944c = null;
        }
        this.f5946e = null;
        this.f5949h = null;
    }

    @Override // android.view.View
    public void setVisibility(int i6) {
        super.setVisibility(i6);
        w3.c cVar = this.f5945d;
        if (cVar instanceof n) {
            ((n) cVar).setVisibility(i6);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x009e, code lost:
    
        r7 = r7.getDisplayCutout();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void setWindowInfoListenerDisplayFeatures(androidx.window.layout.WindowLayoutInfo r7) {
        /*
            r6 = this;
            java.util.List r7 = r7.getDisplayFeatures()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r7 = r7.iterator()
        Ld:
            boolean r1 = r7.hasNext()
            java.lang.String r2 = "FlutterView"
            if (r1 == 0) goto L92
            java.lang.Object r1 = r7.next()
            androidx.window.layout.DisplayFeature r1 = (androidx.window.layout.DisplayFeature) r1
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "WindowInfoTracker Display Feature reported with bounds = "
            r3.append(r4)
            android.graphics.Rect r4 = r1.getBounds()
            java.lang.String r4 = r4.toString()
            r3.append(r4)
            java.lang.String r4 = " and type = "
            r3.append(r4)
            java.lang.Class r4 = r1.getClass()
            java.lang.String r4 = r4.getSimpleName()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            k3.b.f(r2, r3)
            boolean r2 = r1 instanceof androidx.window.layout.FoldingFeature
            if (r2 == 0) goto L80
            r2 = r1
            androidx.window.layout.FoldingFeature r2 = (androidx.window.layout.FoldingFeature) r2
            androidx.window.layout.FoldingFeature$OcclusionType r3 = r2.getOcclusionType()
            androidx.window.layout.FoldingFeature$OcclusionType r4 = androidx.window.layout.FoldingFeature.OcclusionType.FULL
            if (r3 != r4) goto L59
            w3.a$d r3 = w3.a.d.HINGE
            goto L5b
        L59:
            w3.a$d r3 = w3.a.d.FOLD
        L5b:
            androidx.window.layout.FoldingFeature$State r4 = r2.getState()
            androidx.window.layout.FoldingFeature$State r5 = androidx.window.layout.FoldingFeature.State.FLAT
            if (r4 != r5) goto L66
            w3.a$c r2 = w3.a.c.POSTURE_FLAT
            goto L73
        L66:
            androidx.window.layout.FoldingFeature$State r2 = r2.getState()
            androidx.window.layout.FoldingFeature$State r4 = androidx.window.layout.FoldingFeature.State.HALF_OPENED
            if (r2 != r4) goto L71
            w3.a$c r2 = w3.a.c.POSTURE_HALF_OPENED
            goto L73
        L71:
            w3.a$c r2 = w3.a.c.UNKNOWN
        L73:
            w3.a$b r4 = new w3.a$b
            android.graphics.Rect r1 = r1.getBounds()
            r4.<init>(r1, r3, r2)
            r0.add(r4)
            goto Ld
        L80:
            w3.a$b r2 = new w3.a$b
            android.graphics.Rect r1 = r1.getBounds()
            w3.a$d r3 = w3.a.d.UNKNOWN
            w3.a$c r4 = w3.a.c.UNKNOWN
            r2.<init>(r1, r3, r4)
            r0.add(r2)
            goto Ld
        L92:
            int r7 = android.os.Build.VERSION.SDK_INT
            r1 = 28
            if (r7 < r1) goto Ldb
            android.view.WindowInsets r7 = r6.getRootWindowInsets()
            if (r7 == 0) goto Ldb
            android.view.DisplayCutout r7 = androidx.core.view.o1.a(r7)
            if (r7 == 0) goto Ldb
            java.util.List r7 = androidx.core.view.c.a(r7)
            java.util.Iterator r7 = r7.iterator()
        Lac:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto Ldb
            java.lang.Object r1 = r7.next()
            android.graphics.Rect r1 = (android.graphics.Rect) r1
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "DisplayCutout area reported with bounds = "
            r3.append(r4)
            java.lang.String r4 = r1.toString()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            k3.b.f(r2, r3)
            w3.a$b r3 = new w3.a$b
            w3.a$d r4 = w3.a.d.CUTOUT
            r3.<init>(r1, r4)
            r0.add(r3)
            goto Lac
        Ldb:
            w3.a$g r7 = r6.f5960s
            r7.f10276q = r0
            r6.D()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.android.w.setWindowInfoListenerDisplayFeatures(androidx.window.layout.WindowLayoutInfo):void");
    }

    public boolean u() {
        return this.f5948g;
    }

    public boolean w() {
        io.flutter.embedding.engine.a aVar = this.f5949h;
        return aVar != null && aVar.p() == this.f5945d.getAttachedRenderer();
    }

    public void y(f fVar) {
        this.f5950i.remove(fVar);
    }

    public void z(w3.b bVar) {
        this.f5947f.remove(bVar);
    }
}
