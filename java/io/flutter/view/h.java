package io.flutter.view;

import android.R;
import android.app.Activity;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.graphics.Rect;
import android.net.Uri;
import android.opengl.Matrix;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.LocaleSpan;
import android.text.style.TtsSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import io.flutter.view.h;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import x3.a;

/* loaded from: classes.dex */
public class h extends AccessibilityNodeProvider {

    /* renamed from: a, reason: collision with root package name */
    private final View f6228a;

    /* renamed from: b, reason: collision with root package name */
    private final x3.a f6229b;

    /* renamed from: c, reason: collision with root package name */
    private final AccessibilityManager f6230c;

    /* renamed from: d, reason: collision with root package name */
    private final AccessibilityViewEmbedder f6231d;

    /* renamed from: e, reason: collision with root package name */
    private final io.flutter.plugin.platform.o f6232e;

    /* renamed from: f, reason: collision with root package name */
    private final ContentResolver f6233f;

    /* renamed from: g, reason: collision with root package name */
    private final Map<Integer, l> f6234g;

    /* renamed from: h, reason: collision with root package name */
    private final Map<Integer, C0093h> f6235h;

    /* renamed from: i, reason: collision with root package name */
    private l f6236i;

    /* renamed from: j, reason: collision with root package name */
    private Integer f6237j;

    /* renamed from: k, reason: collision with root package name */
    private Integer f6238k;

    /* renamed from: l, reason: collision with root package name */
    private int f6239l;

    /* renamed from: m, reason: collision with root package name */
    private l f6240m;

    /* renamed from: n, reason: collision with root package name */
    private l f6241n;

    /* renamed from: o, reason: collision with root package name */
    private l f6242o;

    /* renamed from: p, reason: collision with root package name */
    private final List<Integer> f6243p;

    /* renamed from: q, reason: collision with root package name */
    private int f6244q;

    /* renamed from: r, reason: collision with root package name */
    private Integer f6245r;

    /* renamed from: s, reason: collision with root package name */
    private k f6246s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f6247t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f6248u;

    /* renamed from: v, reason: collision with root package name */
    private final a.b f6249v;

    /* renamed from: w, reason: collision with root package name */
    private final AccessibilityManager.AccessibilityStateChangeListener f6250w;

    /* renamed from: x, reason: collision with root package name */
    private final AccessibilityManager.TouchExplorationStateChangeListener f6251x;

    /* renamed from: y, reason: collision with root package name */
    private final ContentObserver f6252y;

    /* renamed from: z, reason: collision with root package name */
    private static final int f6227z = ((g.SCROLL_RIGHT.f6289a | g.SCROLL_LEFT.f6289a) | g.SCROLL_UP.f6289a) | g.SCROLL_DOWN.f6289a;
    private static final int A = ((((((((((i.HAS_CHECKED_STATE.f6316a | i.IS_CHECKED.f6316a) | i.IS_SELECTED.f6316a) | i.IS_TEXT_FIELD.f6316a) | i.IS_FOCUSED.f6316a) | i.HAS_ENABLED_STATE.f6316a) | i.IS_ENABLED.f6316a) | i.IS_IN_MUTUALLY_EXCLUSIVE_GROUP.f6316a) | i.HAS_TOGGLED_STATE.f6316a) | i.IS_TOGGLED.f6316a) | i.IS_FOCUSABLE.f6316a) | i.IS_SLIDER.f6316a;
    private static int B = 267386881;

    class a implements a.b {
        a() {
        }

        @Override // x3.a.b
        public void a(String str) {
            h.this.f6228a.announceForAccessibility(str);
        }

        @Override // io.flutter.embedding.engine.FlutterJNI.a
        public void b(ByteBuffer byteBuffer, String[] strArr, ByteBuffer[] byteBufferArr) {
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            for (ByteBuffer byteBuffer2 : byteBufferArr) {
                byteBuffer2.order(ByteOrder.LITTLE_ENDIAN);
            }
            h.this.b0(byteBuffer, strArr, byteBufferArr);
        }

        @Override // io.flutter.embedding.engine.FlutterJNI.a
        public void c(ByteBuffer byteBuffer, String[] strArr) {
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            h.this.a0(byteBuffer, strArr);
        }

        @Override // x3.a.b
        public void d(String str) {
            if (Build.VERSION.SDK_INT >= 28) {
                return;
            }
            AccessibilityEvent H = h.this.H(0, 32);
            H.getText().add(str);
            h.this.S(H);
        }

        @Override // x3.a.b
        public void e(int i6) {
            h.this.R(i6, 2);
        }

        @Override // x3.a.b
        public void f(int i6) {
            h.this.R(i6, 1);
        }
    }

    class b implements AccessibilityManager.AccessibilityStateChangeListener {
        b() {
        }

        @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
        public void onAccessibilityStateChanged(boolean z5) {
            if (h.this.f6248u) {
                return;
            }
            h hVar = h.this;
            if (z5) {
                hVar.f6229b.g(h.this.f6249v);
                h.this.f6229b.e();
            } else {
                hVar.W(false);
                h.this.f6229b.g(null);
                h.this.f6229b.d();
            }
            if (h.this.f6246s != null) {
                h.this.f6246s.a(z5, h.this.f6230c.isTouchExplorationEnabled());
            }
        }
    }

    class c extends ContentObserver {
        c(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z5) {
            onChange(z5, null);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z5, Uri uri) {
            if (h.this.f6248u) {
                return;
            }
            String string = Settings.Global.getString(h.this.f6233f, "transition_animation_scale");
            if (string != null && string.equals("0")) {
                h.g(h.this, f.DISABLE_ANIMATIONS.f6267a);
            } else {
                h.f(h.this, ~f.DISABLE_ANIMATIONS.f6267a);
            }
            h.this.T();
        }
    }

    class d implements AccessibilityManager.TouchExplorationStateChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AccessibilityManager f6256a;

        d(AccessibilityManager accessibilityManager) {
            this.f6256a = accessibilityManager;
        }

        @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
        public void onTouchExplorationStateChanged(boolean z5) {
            if (h.this.f6248u) {
                return;
            }
            if (!z5) {
                h.this.W(false);
                h.this.L();
            }
            if (h.this.f6246s != null) {
                h.this.f6246s.a(this.f6256a.isEnabled(), z5);
            }
        }
    }

    static /* synthetic */ class e {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f6258a;

        static {
            int[] iArr = new int[o.values().length];
            f6258a = iArr;
            try {
                iArr[o.SPELLOUT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6258a[o.LOCALE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private enum f {
        ACCESSIBLE_NAVIGATION(1),
        INVERT_COLORS(2),
        DISABLE_ANIMATIONS(4),
        BOLD_TEXT(8),
        REDUCE_MOTION(16),
        HIGH_CONTRAST(32),
        ON_OFF_SWITCH_LABELS(64);


        /* renamed from: a, reason: collision with root package name */
        final int f6267a;

        f(int i6) {
            this.f6267a = i6;
        }
    }

    public enum g {
        TAP(1),
        LONG_PRESS(2),
        SCROLL_LEFT(4),
        SCROLL_RIGHT(8),
        SCROLL_UP(16),
        SCROLL_DOWN(32),
        INCREASE(64),
        DECREASE(128),
        SHOW_ON_SCREEN(256),
        MOVE_CURSOR_FORWARD_BY_CHARACTER(512),
        MOVE_CURSOR_BACKWARD_BY_CHARACTER(1024),
        SET_SELECTION(2048),
        COPY(4096),
        CUT(8192),
        PASTE(16384),
        DID_GAIN_ACCESSIBILITY_FOCUS(32768),
        DID_LOSE_ACCESSIBILITY_FOCUS(65536),
        CUSTOM_ACTION(131072),
        DISMISS(262144),
        MOVE_CURSOR_FORWARD_BY_WORD(524288),
        MOVE_CURSOR_BACKWARD_BY_WORD(1048576),
        SET_TEXT(2097152);


        /* renamed from: a, reason: collision with root package name */
        public final int f6289a;

        g(int i6) {
            this.f6289a = i6;
        }
    }

    /* renamed from: io.flutter.view.h$h, reason: collision with other inner class name */
    private static class C0093h {

        /* renamed from: a, reason: collision with root package name */
        private int f6290a = -1;

        /* renamed from: b, reason: collision with root package name */
        private int f6291b = -1;

        /* renamed from: c, reason: collision with root package name */
        private int f6292c = -1;

        /* renamed from: d, reason: collision with root package name */
        private String f6293d;

        /* renamed from: e, reason: collision with root package name */
        private String f6294e;

        C0093h() {
        }
    }

    enum i {
        HAS_CHECKED_STATE(1),
        IS_CHECKED(2),
        IS_SELECTED(4),
        IS_BUTTON(8),
        IS_TEXT_FIELD(16),
        IS_FOCUSED(32),
        HAS_ENABLED_STATE(64),
        IS_ENABLED(128),
        IS_IN_MUTUALLY_EXCLUSIVE_GROUP(256),
        IS_HEADER(512),
        IS_OBSCURED(1024),
        SCOPES_ROUTE(2048),
        NAMES_ROUTE(4096),
        IS_HIDDEN(8192),
        IS_IMAGE(16384),
        IS_LIVE_REGION(32768),
        HAS_TOGGLED_STATE(65536),
        IS_TOGGLED(131072),
        HAS_IMPLICIT_SCROLLING(262144),
        IS_MULTILINE(524288),
        IS_READ_ONLY(1048576),
        IS_FOCUSABLE(2097152),
        IS_LINK(4194304),
        IS_SLIDER(8388608),
        IS_KEYBOARD_KEY(16777216),
        IS_CHECK_STATE_MIXED(33554432);


        /* renamed from: a, reason: collision with root package name */
        final int f6316a;

        i(int i6) {
            this.f6316a = i6;
        }
    }

    private static class j extends n {

        /* renamed from: d, reason: collision with root package name */
        String f6317d;

        private j() {
            super(null);
        }

        /* synthetic */ j(a aVar) {
            this();
        }
    }

    public interface k {
        void a(boolean z5, boolean z6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class l {
        private p A;
        private int C;
        private int D;
        private int E;
        private int F;
        private float G;
        private float H;
        private float I;
        private String J;
        private String K;
        private float L;
        private float M;
        private float N;
        private float O;
        private float[] P;
        private l Q;
        private List<C0093h> T;
        private C0093h U;
        private C0093h V;
        private float[] X;
        private float[] Z;

        /* renamed from: a, reason: collision with root package name */
        final h f6318a;

        /* renamed from: a0, reason: collision with root package name */
        private Rect f6319a0;

        /* renamed from: c, reason: collision with root package name */
        private int f6321c;

        /* renamed from: d, reason: collision with root package name */
        private int f6322d;

        /* renamed from: e, reason: collision with root package name */
        private int f6323e;

        /* renamed from: f, reason: collision with root package name */
        private int f6324f;

        /* renamed from: g, reason: collision with root package name */
        private int f6325g;

        /* renamed from: h, reason: collision with root package name */
        private int f6326h;

        /* renamed from: i, reason: collision with root package name */
        private int f6327i;

        /* renamed from: j, reason: collision with root package name */
        private int f6328j;

        /* renamed from: k, reason: collision with root package name */
        private int f6329k;

        /* renamed from: l, reason: collision with root package name */
        private float f6330l;

        /* renamed from: m, reason: collision with root package name */
        private float f6331m;

        /* renamed from: n, reason: collision with root package name */
        private float f6332n;

        /* renamed from: o, reason: collision with root package name */
        private String f6333o;

        /* renamed from: p, reason: collision with root package name */
        private List<n> f6334p;

        /* renamed from: q, reason: collision with root package name */
        private String f6335q;

        /* renamed from: r, reason: collision with root package name */
        private List<n> f6336r;

        /* renamed from: s, reason: collision with root package name */
        private String f6337s;

        /* renamed from: t, reason: collision with root package name */
        private List<n> f6338t;

        /* renamed from: u, reason: collision with root package name */
        private String f6339u;

        /* renamed from: v, reason: collision with root package name */
        private List<n> f6340v;

        /* renamed from: w, reason: collision with root package name */
        private String f6341w;

        /* renamed from: x, reason: collision with root package name */
        private List<n> f6342x;

        /* renamed from: y, reason: collision with root package name */
        private String f6343y;

        /* renamed from: b, reason: collision with root package name */
        private int f6320b = -1;

        /* renamed from: z, reason: collision with root package name */
        private int f6344z = -1;
        private boolean B = false;
        private List<l> R = new ArrayList();
        private List<l> S = new ArrayList();
        private boolean W = true;
        private boolean Y = true;

        l(h hVar) {
            this.f6318a = hVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean A0(l lVar, d4.e<l> eVar) {
            return (lVar == null || lVar.j0(eVar) == null) ? false : true;
        }

        private void B0(float[] fArr, float[] fArr2, float[] fArr3) {
            Matrix.multiplyMV(fArr, 0, fArr2, 0, fArr3, 0);
            float f6 = fArr[3];
            fArr[0] = fArr[0] / f6;
            fArr[1] = fArr[1] / f6;
            fArr[2] = fArr[2] / f6;
            fArr[3] = 0.0f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void C0(float[] fArr, Set<l> set, boolean z5) {
            set.add(this);
            if (this.Y) {
                z5 = true;
            }
            if (z5) {
                if (this.Z == null) {
                    this.Z = new float[16];
                }
                if (this.P == null) {
                    this.P = new float[16];
                }
                Matrix.multiplyMM(this.Z, 0, fArr, 0, this.P, 0);
                float[] fArr2 = {this.L, this.M, 0.0f, 1.0f};
                float[] fArr3 = new float[4];
                float[] fArr4 = new float[4];
                float[] fArr5 = new float[4];
                float[] fArr6 = new float[4];
                B0(fArr3, this.Z, fArr2);
                fArr2[0] = this.N;
                fArr2[1] = this.M;
                B0(fArr4, this.Z, fArr2);
                fArr2[0] = this.N;
                fArr2[1] = this.O;
                B0(fArr5, this.Z, fArr2);
                fArr2[0] = this.L;
                fArr2[1] = this.O;
                B0(fArr6, this.Z, fArr2);
                if (this.f6319a0 == null) {
                    this.f6319a0 = new Rect();
                }
                this.f6319a0.set(Math.round(z0(fArr3[0], fArr4[0], fArr5[0], fArr6[0])), Math.round(z0(fArr3[1], fArr4[1], fArr5[1], fArr6[1])), Math.round(y0(fArr3[0], fArr4[0], fArr5[0], fArr6[0])), Math.round(y0(fArr3[1], fArr4[1], fArr5[1], fArr6[1])));
                this.Y = false;
            }
            int i6 = -1;
            for (l lVar : this.R) {
                lVar.f6344z = i6;
                i6 = lVar.f6320b;
                lVar.C0(this.Z, set, z5);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void D0(ByteBuffer byteBuffer, String[] strArr, ByteBuffer[] byteBufferArr) {
            this.B = true;
            this.J = this.f6335q;
            this.K = this.f6333o;
            this.C = this.f6321c;
            this.D = this.f6322d;
            this.E = this.f6325g;
            this.F = this.f6326h;
            this.G = this.f6330l;
            this.H = this.f6331m;
            this.I = this.f6332n;
            this.f6321c = byteBuffer.getInt();
            this.f6322d = byteBuffer.getInt();
            this.f6323e = byteBuffer.getInt();
            this.f6324f = byteBuffer.getInt();
            this.f6325g = byteBuffer.getInt();
            this.f6326h = byteBuffer.getInt();
            this.f6327i = byteBuffer.getInt();
            this.f6328j = byteBuffer.getInt();
            this.f6329k = byteBuffer.getInt();
            this.f6330l = byteBuffer.getFloat();
            this.f6331m = byteBuffer.getFloat();
            this.f6332n = byteBuffer.getFloat();
            int i6 = byteBuffer.getInt();
            this.f6333o = i6 == -1 ? null : strArr[i6];
            this.f6334p = o0(byteBuffer, byteBufferArr);
            int i7 = byteBuffer.getInt();
            this.f6335q = i7 == -1 ? null : strArr[i7];
            this.f6336r = o0(byteBuffer, byteBufferArr);
            int i8 = byteBuffer.getInt();
            this.f6337s = i8 == -1 ? null : strArr[i8];
            this.f6338t = o0(byteBuffer, byteBufferArr);
            int i9 = byteBuffer.getInt();
            this.f6339u = i9 == -1 ? null : strArr[i9];
            this.f6340v = o0(byteBuffer, byteBufferArr);
            int i10 = byteBuffer.getInt();
            this.f6341w = i10 == -1 ? null : strArr[i10];
            this.f6342x = o0(byteBuffer, byteBufferArr);
            int i11 = byteBuffer.getInt();
            this.f6343y = i11 == -1 ? null : strArr[i11];
            this.A = p.a(byteBuffer.getInt());
            this.L = byteBuffer.getFloat();
            this.M = byteBuffer.getFloat();
            this.N = byteBuffer.getFloat();
            this.O = byteBuffer.getFloat();
            if (this.P == null) {
                this.P = new float[16];
            }
            for (int i12 = 0; i12 < 16; i12++) {
                this.P[i12] = byteBuffer.getFloat();
            }
            this.W = true;
            this.Y = true;
            int i13 = byteBuffer.getInt();
            this.R.clear();
            this.S.clear();
            for (int i14 = 0; i14 < i13; i14++) {
                l A = this.f6318a.A(byteBuffer.getInt());
                A.Q = this;
                this.R.add(A);
            }
            for (int i15 = 0; i15 < i13; i15++) {
                l A2 = this.f6318a.A(byteBuffer.getInt());
                A2.Q = this;
                this.S.add(A2);
            }
            int i16 = byteBuffer.getInt();
            if (i16 == 0) {
                this.T = null;
                return;
            }
            List<C0093h> list = this.T;
            if (list == null) {
                this.T = new ArrayList(i16);
            } else {
                list.clear();
            }
            for (int i17 = 0; i17 < i16; i17++) {
                C0093h z5 = this.f6318a.z(byteBuffer.getInt());
                if (z5.f6292c == g.TAP.f6289a) {
                    this.U = z5;
                } else if (z5.f6292c == g.LONG_PRESS.f6289a) {
                    this.V = z5;
                } else {
                    this.T.add(z5);
                }
                this.T.add(z5);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e0(List<l> list) {
            if (v0(i.SCOPES_ROUTE)) {
                list.add(this);
            }
            Iterator<l> it = this.R.iterator();
            while (it.hasNext()) {
                it.next().e0(list);
            }
        }

        private SpannableString f0(String str, List<n> list) {
            if (str == null) {
                return null;
            }
            SpannableString spannableString = new SpannableString(str);
            if (list != null) {
                for (n nVar : list) {
                    int i6 = e.f6258a[nVar.f6347c.ordinal()];
                    if (i6 == 1) {
                        spannableString.setSpan(new TtsSpan.Builder("android.type.verbatim").build(), nVar.f6345a, nVar.f6346b, 0);
                    } else if (i6 == 2) {
                        spannableString.setSpan(new LocaleSpan(Locale.forLanguageTag(((j) nVar).f6317d)), nVar.f6345a, nVar.f6346b, 0);
                    }
                }
            }
            return spannableString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean g0() {
            String str;
            String str2 = this.f6333o;
            if (str2 == null && this.K == null) {
                return false;
            }
            return str2 == null || (str = this.K) == null || !str2.equals(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean h0() {
            return (Float.isNaN(this.f6330l) || Float.isNaN(this.G) || this.G == this.f6330l) ? false : true;
        }

        private void i0() {
            if (this.W) {
                this.W = false;
                if (this.X == null) {
                    this.X = new float[16];
                }
                if (Matrix.invertM(this.X, 0, this.P, 0)) {
                    return;
                }
                Arrays.fill(this.X, 0.0f);
            }
        }

        private l j0(d4.e<l> eVar) {
            for (l lVar = this.Q; lVar != null; lVar = lVar.Q) {
                if (eVar.test(lVar)) {
                    return lVar;
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Rect k0() {
            return this.f6319a0;
        }

        private CharSequence l0() {
            return f0(this.f6341w, this.f6342x);
        }

        static /* synthetic */ int m(l lVar, int i6) {
            int i7 = lVar.f6326h + i6;
            lVar.f6326h = i7;
            return i7;
        }

        private CharSequence m0() {
            return f0(this.f6333o, this.f6334p);
        }

        static /* synthetic */ int n(l lVar, int i6) {
            int i7 = lVar.f6326h - i6;
            lVar.f6326h = i7;
            return i7;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String n0() {
            String str;
            if (v0(i.NAMES_ROUTE) && (str = this.f6333o) != null && !str.isEmpty()) {
                return this.f6333o;
            }
            Iterator<l> it = this.R.iterator();
            while (it.hasNext()) {
                String n02 = it.next().n0();
                if (n02 != null && !n02.isEmpty()) {
                    return n02;
                }
            }
            return null;
        }

        private List<n> o0(ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr) {
            int i6 = byteBuffer.getInt();
            a aVar = null;
            if (i6 == -1) {
                return null;
            }
            ArrayList arrayList = new ArrayList(i6);
            for (int i7 = 0; i7 < i6; i7++) {
                int i8 = byteBuffer.getInt();
                int i9 = byteBuffer.getInt();
                o oVar = o.values()[byteBuffer.getInt()];
                int i10 = e.f6258a[oVar.ordinal()];
                if (i10 == 1) {
                    byteBuffer.getInt();
                    m mVar = new m(aVar);
                    mVar.f6345a = i8;
                    mVar.f6346b = i9;
                    mVar.f6347c = oVar;
                    arrayList.add(mVar);
                } else if (i10 == 2) {
                    ByteBuffer byteBuffer2 = byteBufferArr[byteBuffer.getInt()];
                    j jVar = new j(aVar);
                    jVar.f6345a = i8;
                    jVar.f6346b = i9;
                    jVar.f6347c = oVar;
                    jVar.f6317d = Charset.forName("UTF-8").decode(byteBuffer2).toString();
                    arrayList.add(jVar);
                }
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public CharSequence p0() {
            CharSequence[] charSequenceArr = {m0(), l0()};
            CharSequence charSequence = null;
            for (int i6 = 0; i6 < 2; i6++) {
                CharSequence charSequence2 = charSequenceArr[i6];
                if (charSequence2 != null && charSequence2.length() > 0) {
                    charSequence = (charSequence == null || charSequence.length() == 0) ? charSequence2 : TextUtils.concat(charSequence, ", ", charSequence2);
                }
            }
            return charSequence;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public CharSequence q0() {
            return f0(this.f6335q, this.f6336r);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public CharSequence r0() {
            CharSequence[] charSequenceArr = {q0(), m0(), l0()};
            CharSequence charSequence = null;
            for (int i6 = 0; i6 < 3; i6++) {
                CharSequence charSequence2 = charSequenceArr[i6];
                if (charSequence2 != null && charSequence2.length() > 0) {
                    charSequence = (charSequence == null || charSequence.length() == 0) ? charSequence2 : TextUtils.concat(charSequence, ", ", charSequence2);
                }
            }
            return charSequence;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean s0(g gVar) {
            return (gVar.f6289a & this.D) != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean t0(i iVar) {
            return (iVar.f6316a & this.C) != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean u0(g gVar) {
            return (gVar.f6289a & this.f6322d) != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean v0(i iVar) {
            return (iVar.f6316a & this.f6321c) != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public l w0(float[] fArr, boolean z5) {
            float f6 = fArr[3];
            boolean z6 = false;
            float f7 = fArr[0] / f6;
            float f8 = fArr[1] / f6;
            if (f7 < this.L || f7 >= this.N || f8 < this.M || f8 >= this.O) {
                return null;
            }
            float[] fArr2 = new float[4];
            for (l lVar : this.S) {
                if (!lVar.v0(i.IS_HIDDEN)) {
                    lVar.i0();
                    Matrix.multiplyMV(fArr2, 0, lVar.X, 0, fArr, 0);
                    l w02 = lVar.w0(fArr2, z5);
                    if (w02 != null) {
                        return w02;
                    }
                }
            }
            if (z5 && this.f6327i != -1) {
                z6 = true;
            }
            if (x0() || z6) {
                return this;
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean x0() {
            String str;
            String str2;
            String str3;
            if (v0(i.SCOPES_ROUTE)) {
                return false;
            }
            return (!v0(i.IS_FOCUSABLE) && (this.f6322d & (~h.f6227z)) == 0 && (this.f6321c & h.A) == 0 && ((str = this.f6333o) == null || str.isEmpty()) && (((str2 = this.f6335q) == null || str2.isEmpty()) && ((str3 = this.f6341w) == null || str3.isEmpty()))) ? false : true;
        }

        private float y0(float f6, float f7, float f8, float f9) {
            return Math.max(f6, Math.max(f7, Math.max(f8, f9)));
        }

        private float z0(float f6, float f7, float f8, float f9) {
            return Math.min(f6, Math.min(f7, Math.min(f8, f9)));
        }
    }

    private static class m extends n {
        private m() {
            super(null);
        }

        /* synthetic */ m(a aVar) {
            this();
        }
    }

    private static class n {

        /* renamed from: a, reason: collision with root package name */
        int f6345a;

        /* renamed from: b, reason: collision with root package name */
        int f6346b;

        /* renamed from: c, reason: collision with root package name */
        o f6347c;

        private n() {
        }

        /* synthetic */ n(a aVar) {
            this();
        }
    }

    private enum o {
        SPELLOUT,
        LOCALE
    }

    private enum p {
        UNKNOWN,
        LTR,
        RTL;

        public static p a(int i6) {
            return i6 != 1 ? i6 != 2 ? UNKNOWN : LTR : RTL;
        }
    }

    public h(View view, x3.a aVar, AccessibilityManager accessibilityManager, ContentResolver contentResolver, io.flutter.plugin.platform.o oVar) {
        this(view, aVar, accessibilityManager, contentResolver, new AccessibilityViewEmbedder(view, 65536), oVar);
    }

    public h(View view, x3.a aVar, AccessibilityManager accessibilityManager, ContentResolver contentResolver, AccessibilityViewEmbedder accessibilityViewEmbedder, io.flutter.plugin.platform.o oVar) {
        this.f6234g = new HashMap();
        this.f6235h = new HashMap();
        this.f6239l = 0;
        this.f6243p = new ArrayList();
        this.f6244q = 0;
        this.f6245r = 0;
        this.f6247t = false;
        this.f6248u = false;
        this.f6249v = new a();
        b bVar = new b();
        this.f6250w = bVar;
        c cVar = new c(new Handler());
        this.f6252y = cVar;
        this.f6228a = view;
        this.f6229b = aVar;
        this.f6230c = accessibilityManager;
        this.f6233f = contentResolver;
        this.f6231d = accessibilityViewEmbedder;
        this.f6232e = oVar;
        bVar.onAccessibilityStateChanged(accessibilityManager.isEnabled());
        accessibilityManager.addAccessibilityStateChangeListener(bVar);
        int i6 = Build.VERSION.SDK_INT;
        d dVar = new d(accessibilityManager);
        this.f6251x = dVar;
        dVar.onTouchExplorationStateChanged(accessibilityManager.isTouchExplorationEnabled());
        accessibilityManager.addTouchExplorationStateChangeListener(dVar);
        cVar.onChange(false);
        contentResolver.registerContentObserver(Settings.Global.getUriFor("transition_animation_scale"), false, cVar);
        if (i6 >= 31) {
            X();
        }
        oVar.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public l A(int i6) {
        l lVar = this.f6234g.get(Integer.valueOf(i6));
        if (lVar != null) {
            return lVar;
        }
        l lVar2 = new l(this);
        lVar2.f6320b = i6;
        this.f6234g.put(Integer.valueOf(i6), lVar2);
        return lVar2;
    }

    private l B() {
        return this.f6234g.get(0);
    }

    private void C(float f6, float f7, boolean z5) {
        l w02;
        if (this.f6234g.isEmpty() || (w02 = B().w0(new float[]{f6, f7, 0.0f, 1.0f}, z5)) == this.f6242o) {
            return;
        }
        if (w02 != null) {
            R(w02.f6320b, 128);
        }
        l lVar = this.f6242o;
        if (lVar != null) {
            R(lVar.f6320b, 256);
        }
        this.f6242o = w02;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean F(l lVar, l lVar2) {
        return lVar2 == lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean G(l lVar) {
        return lVar.v0(i.HAS_IMPLICIT_SCROLLING);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AccessibilityEvent H(int i6, int i7) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i7);
        obtain.setPackageName(this.f6228a.getContext().getPackageName());
        obtain.setSource(this.f6228a, i6);
        return obtain;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        l lVar = this.f6242o;
        if (lVar != null) {
            R(lVar.f6320b, 256);
            this.f6242o = null;
        }
    }

    private void M(l lVar) {
        String n02 = lVar.n0();
        if (n02 == null) {
            n02 = " ";
        }
        if (Build.VERSION.SDK_INT >= 28) {
            V(n02);
            return;
        }
        AccessibilityEvent H = H(lVar.f6320b, 32);
        H.getText().add(n02);
        S(H);
    }

    private boolean N(l lVar, int i6, Bundle bundle, boolean z5) {
        int i7 = bundle.getInt("ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT");
        boolean z6 = bundle.getBoolean("ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN");
        int i8 = lVar.f6325g;
        int i9 = lVar.f6326h;
        P(lVar, i7, z5, z6);
        if (i8 != lVar.f6325g || i9 != lVar.f6326h) {
            String str = lVar.f6335q != null ? lVar.f6335q : "";
            AccessibilityEvent H = H(lVar.f6320b, 8192);
            H.getText().add(str);
            H.setFromIndex(lVar.f6325g);
            H.setToIndex(lVar.f6326h);
            H.setItemCount(str.length());
            S(H);
        }
        if (i7 == 1) {
            if (z5) {
                g gVar = g.MOVE_CURSOR_FORWARD_BY_CHARACTER;
                if (lVar.u0(gVar)) {
                    this.f6229b.c(i6, gVar, Boolean.valueOf(z6));
                    return true;
                }
            }
            if (z5) {
                return false;
            }
            g gVar2 = g.MOVE_CURSOR_BACKWARD_BY_CHARACTER;
            if (!lVar.u0(gVar2)) {
                return false;
            }
            this.f6229b.c(i6, gVar2, Boolean.valueOf(z6));
            return true;
        }
        if (i7 != 2) {
            return i7 == 4 || i7 == 8 || i7 == 16;
        }
        if (z5) {
            g gVar3 = g.MOVE_CURSOR_FORWARD_BY_WORD;
            if (lVar.u0(gVar3)) {
                this.f6229b.c(i6, gVar3, Boolean.valueOf(z6));
                return true;
            }
        }
        if (z5) {
            return false;
        }
        g gVar4 = g.MOVE_CURSOR_BACKWARD_BY_WORD;
        if (!lVar.u0(gVar4)) {
            return false;
        }
        this.f6229b.c(i6, gVar4, Boolean.valueOf(z6));
        return true;
    }

    private boolean O(l lVar, int i6, Bundle bundle) {
        String string = (bundle == null || !bundle.containsKey("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE")) ? "" : bundle.getString("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE");
        this.f6229b.c(i6, g.SET_TEXT, string);
        lVar.f6335q = string;
        lVar.f6336r = null;
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0022, code lost:
    
        if (r6 != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0024, code lost:
    
        r5 = r4.f6335q.length();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x002c, code lost:
    
        r4.f6326h = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0031, code lost:
    
        r4.f6326h = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0060, code lost:
    
        if (r5.find() != false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0062, code lost:
    
        io.flutter.view.h.l.m(r4, r5.start(1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x008d, code lost:
    
        if (r5.find() != false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x008f, code lost:
    
        r5 = r5.start(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00c1, code lost:
    
        if (r5.find() != false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00e6, code lost:
    
        if (r5.find() != false) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void P(io.flutter.view.h.l r4, int r5, boolean r6, boolean r7) {
        /*
            r3 = this;
            int r0 = io.flutter.view.h.l.k(r4)
            if (r0 < 0) goto L111
            int r0 = io.flutter.view.h.l.i(r4)
            if (r0 >= 0) goto Le
            goto L111
        Le:
            r0 = 1
            if (r5 == r0) goto Le9
            r1 = 2
            r2 = 0
            if (r5 == r1) goto L94
            r1 = 4
            if (r5 == r1) goto L36
            r0 = 8
            if (r5 == r0) goto L22
            r0 = 16
            if (r5 == r0) goto L22
            goto L108
        L22:
            if (r6 == 0) goto L31
        L24:
            java.lang.String r5 = io.flutter.view.h.l.q(r4)
            int r5 = r5.length()
        L2c:
            io.flutter.view.h.l.l(r4, r5)
            goto L108
        L31:
            io.flutter.view.h.l.l(r4, r2)
            goto L108
        L36:
            if (r6 == 0) goto L6b
            int r5 = io.flutter.view.h.l.k(r4)
            java.lang.String r1 = io.flutter.view.h.l.q(r4)
            int r1 = r1.length()
            if (r5 >= r1) goto L6b
            java.lang.String r5 = "(?!^)(\\n)"
            java.util.regex.Pattern r5 = java.util.regex.Pattern.compile(r5)
            java.lang.String r6 = io.flutter.view.h.l.q(r4)
            int r1 = io.flutter.view.h.l.k(r4)
            java.lang.String r6 = r6.substring(r1)
            java.util.regex.Matcher r5 = r5.matcher(r6)
            boolean r6 = r5.find()
            if (r6 == 0) goto L24
        L62:
            int r5 = r5.start(r0)
            io.flutter.view.h.l.m(r4, r5)
            goto L108
        L6b:
            if (r6 != 0) goto L108
            int r5 = io.flutter.view.h.l.k(r4)
            if (r5 <= 0) goto L108
            java.lang.String r5 = "(?s:.*)(\\n)"
            java.util.regex.Pattern r5 = java.util.regex.Pattern.compile(r5)
            java.lang.String r6 = io.flutter.view.h.l.q(r4)
            int r1 = io.flutter.view.h.l.k(r4)
            java.lang.String r6 = r6.substring(r2, r1)
            java.util.regex.Matcher r5 = r5.matcher(r6)
            boolean r6 = r5.find()
            if (r6 == 0) goto L31
        L8f:
            int r5 = r5.start(r0)
            goto L2c
        L94:
            if (r6 == 0) goto Lc4
            int r5 = io.flutter.view.h.l.k(r4)
            java.lang.String r1 = io.flutter.view.h.l.q(r4)
            int r1 = r1.length()
            if (r5 >= r1) goto Lc4
            java.lang.String r5 = "\\p{L}(\\b)"
            java.util.regex.Pattern r5 = java.util.regex.Pattern.compile(r5)
            java.lang.String r6 = io.flutter.view.h.l.q(r4)
            int r1 = io.flutter.view.h.l.k(r4)
            java.lang.String r6 = r6.substring(r1)
            java.util.regex.Matcher r5 = r5.matcher(r6)
            r5.find()
            boolean r6 = r5.find()
            if (r6 == 0) goto L24
            goto L62
        Lc4:
            if (r6 != 0) goto L108
            int r5 = io.flutter.view.h.l.k(r4)
            if (r5 <= 0) goto L108
            java.lang.String r5 = "(?s:.*)(\\b)\\p{L}"
            java.util.regex.Pattern r5 = java.util.regex.Pattern.compile(r5)
            java.lang.String r6 = io.flutter.view.h.l.q(r4)
            int r1 = io.flutter.view.h.l.k(r4)
            java.lang.String r6 = r6.substring(r2, r1)
            java.util.regex.Matcher r5 = r5.matcher(r6)
            boolean r6 = r5.find()
            if (r6 == 0) goto L108
            goto L8f
        Le9:
            if (r6 == 0) goto Lfd
            int r5 = io.flutter.view.h.l.k(r4)
            java.lang.String r1 = io.flutter.view.h.l.q(r4)
            int r1 = r1.length()
            if (r5 >= r1) goto Lfd
            io.flutter.view.h.l.m(r4, r0)
            goto L108
        Lfd:
            if (r6 != 0) goto L108
            int r5 = io.flutter.view.h.l.k(r4)
            if (r5 <= 0) goto L108
            io.flutter.view.h.l.n(r4, r0)
        L108:
            if (r7 != 0) goto L111
            int r5 = io.flutter.view.h.l.k(r4)
            io.flutter.view.h.l.j(r4, r5)
        L111:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.view.h.P(io.flutter.view.h$l, int, boolean, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(int i6, int i7) {
        if (this.f6230c.isEnabled()) {
            S(H(i6, i7));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(AccessibilityEvent accessibilityEvent) {
        if (this.f6230c.isEnabled()) {
            this.f6228a.getParent().requestSendAccessibilityEvent(this.f6228a, accessibilityEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        this.f6229b.f(this.f6239l);
    }

    private void U(int i6) {
        AccessibilityEvent H = H(i6, 2048);
        H.setContentChangeTypes(1);
        S(H);
    }

    private void V(String str) {
        this.f6228a.setAccessibilityPaneTitle(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(boolean z5) {
        if (this.f6247t == z5) {
            return;
        }
        this.f6247t = z5;
        this.f6239l = z5 ? this.f6239l | f.ACCESSIBLE_NAVIGATION.f6267a : this.f6239l & (~f.ACCESSIBLE_NAVIGATION.f6267a);
        T();
    }

    private void X() {
        int i6;
        View view = this.f6228a;
        if (view == null || view.getResources() == null) {
            return;
        }
        i6 = this.f6228a.getResources().getConfiguration().fontWeightAdjustment;
        this.f6239l = i6 != Integer.MAX_VALUE && i6 >= 300 ? this.f6239l | f.BOLD_TEXT.f6267a : this.f6239l & f.BOLD_TEXT.f6267a;
        T();
    }

    private boolean Z(final l lVar) {
        return lVar.f6328j > 0 && (l.A0(this.f6236i, new d4.e() { // from class: io.flutter.view.f
            @Override // d4.e
            public final boolean test(Object obj) {
                boolean F;
                F = h.F(h.l.this, (h.l) obj);
                return F;
            }
        }) || !l.A0(this.f6236i, new d4.e() { // from class: io.flutter.view.g
            @Override // d4.e
            public final boolean test(Object obj) {
                boolean G;
                G = h.G((h.l) obj);
                return G;
            }
        }));
    }

    private void c0(l lVar) {
        View c6;
        Integer num;
        lVar.Q = null;
        if (lVar.f6327i != -1 && (num = this.f6237j) != null && this.f6231d.platformViewOfNode(num.intValue()) == this.f6232e.c(lVar.f6327i)) {
            R(this.f6237j.intValue(), 65536);
            this.f6237j = null;
        }
        if (lVar.f6327i != -1 && (c6 = this.f6232e.c(lVar.f6327i)) != null) {
            c6.setImportantForAccessibility(4);
        }
        l lVar2 = this.f6236i;
        if (lVar2 == lVar) {
            R(lVar2.f6320b, 65536);
            this.f6236i = null;
        }
        if (this.f6240m == lVar) {
            this.f6240m = null;
        }
        if (this.f6242o == lVar) {
            this.f6242o = null;
        }
    }

    static /* synthetic */ int f(h hVar, int i6) {
        int i7 = i6 & hVar.f6239l;
        hVar.f6239l = i7;
        return i7;
    }

    static /* synthetic */ int g(h hVar, int i6) {
        int i7 = i6 | hVar.f6239l;
        hVar.f6239l = i7;
        return i7;
    }

    private AccessibilityEvent v(int i6, String str, String str2) {
        AccessibilityEvent H = H(i6, 16);
        H.setBeforeText(str);
        H.getText().add(str2);
        int i7 = 0;
        while (i7 < str.length() && i7 < str2.length() && str.charAt(i7) == str2.charAt(i7)) {
            i7++;
        }
        if (i7 >= str.length() && i7 >= str2.length()) {
            return null;
        }
        H.setFromIndex(i7);
        int length = str.length() - 1;
        int length2 = str2.length() - 1;
        while (length >= i7 && length2 >= i7 && str.charAt(length) == str2.charAt(length2)) {
            length--;
            length2--;
        }
        H.setRemovedCount((length - i7) + 1);
        H.setAddedCount((length2 - i7) + 1);
        return H;
    }

    private boolean w() {
        int i6;
        Activity e6 = d4.i.e(this.f6228a.getContext());
        if (e6 == null || e6.getWindow() == null) {
            return false;
        }
        i6 = e6.getWindow().getAttributes().layoutInDisplayCutoutMode;
        return i6 == 2 || i6 == 0;
    }

    private Rect y(Rect rect) {
        Rect rect2 = new Rect(rect);
        int[] iArr = new int[2];
        this.f6228a.getLocationOnScreen(iArr);
        rect2.offset(iArr[0], iArr[1]);
        return rect2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C0093h z(int i6) {
        C0093h c0093h = this.f6235h.get(Integer.valueOf(i6));
        if (c0093h != null) {
            return c0093h;
        }
        C0093h c0093h2 = new C0093h();
        c0093h2.f6291b = i6;
        c0093h2.f6290a = B + i6;
        this.f6235h.put(Integer.valueOf(i6), c0093h2);
        return c0093h2;
    }

    public boolean D() {
        return this.f6230c.isEnabled();
    }

    public boolean E() {
        return this.f6230c.isTouchExplorationEnabled();
    }

    public AccessibilityNodeInfo I(View view, int i6) {
        return AccessibilityNodeInfo.obtain(view, i6);
    }

    public boolean J(MotionEvent motionEvent) {
        return K(motionEvent, false);
    }

    public boolean K(MotionEvent motionEvent, boolean z5) {
        if (!this.f6230c.isTouchExplorationEnabled() || this.f6234g.isEmpty()) {
            return false;
        }
        l w02 = B().w0(new float[]{motionEvent.getX(), motionEvent.getY(), 0.0f, 1.0f}, z5);
        if (w02 != null && w02.f6327i != -1) {
            if (z5) {
                return false;
            }
            return this.f6231d.onAccessibilityHoverEvent(w02.f6320b, motionEvent);
        }
        if (motionEvent.getAction() == 9 || motionEvent.getAction() == 7) {
            C(motionEvent.getX(), motionEvent.getY(), z5);
        } else {
            if (motionEvent.getAction() != 10) {
                k3.b.a("flutter", "unexpected accessibility hover event: " + motionEvent);
                return false;
            }
            L();
        }
        return true;
    }

    public void Q() {
        this.f6248u = true;
        this.f6232e.d();
        Y(null);
        this.f6230c.removeAccessibilityStateChangeListener(this.f6250w);
        this.f6230c.removeTouchExplorationStateChangeListener(this.f6251x);
        this.f6233f.unregisterContentObserver(this.f6252y);
        this.f6229b.g(null);
    }

    public void Y(k kVar) {
        this.f6246s = kVar;
    }

    void a0(ByteBuffer byteBuffer, String[] strArr) {
        while (byteBuffer.hasRemaining()) {
            C0093h z5 = z(byteBuffer.getInt());
            z5.f6292c = byteBuffer.getInt();
            int i6 = byteBuffer.getInt();
            String str = null;
            z5.f6293d = i6 == -1 ? null : strArr[i6];
            int i7 = byteBuffer.getInt();
            if (i7 != -1) {
                str = strArr[i7];
            }
            z5.f6294e = str;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0080, code lost:
    
        r4 = r8.f6228a.getRootWindowInsets();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void b0(java.nio.ByteBuffer r9, java.lang.String[] r10, java.nio.ByteBuffer[] r11) {
        /*
            Method dump skipped, instructions count: 833
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.view.h.b0(java.nio.ByteBuffer, java.lang.String[], java.nio.ByteBuffer[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:164:0x0400  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0421  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0454  */
    @Override // android.view.accessibility.AccessibilityNodeProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.accessibility.AccessibilityNodeInfo createAccessibilityNodeInfo(int r14) {
        /*
            Method dump skipped, instructions count: 1166
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.view.h.createAccessibilityNodeInfo(int):android.view.accessibility.AccessibilityNodeInfo");
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0016, code lost:
    
        if (r2 != null) goto L14;
     */
    @Override // android.view.accessibility.AccessibilityNodeProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.accessibility.AccessibilityNodeInfo findFocus(int r2) {
        /*
            r1 = this;
            r0 = 1
            if (r2 == r0) goto L7
            r0 = 2
            if (r2 == r0) goto L1d
            goto L27
        L7:
            io.flutter.view.h$l r2 = r1.f6240m
            if (r2 == 0) goto L14
        Lb:
            int r2 = io.flutter.view.h.l.a(r2)
        Lf:
            android.view.accessibility.AccessibilityNodeInfo r2 = r1.createAccessibilityNodeInfo(r2)
            return r2
        L14:
            java.lang.Integer r2 = r1.f6238k
            if (r2 == 0) goto L1d
        L18:
            int r2 = r2.intValue()
            goto Lf
        L1d:
            io.flutter.view.h$l r2 = r1.f6236i
            if (r2 == 0) goto L22
            goto Lb
        L22:
            java.lang.Integer r2 = r1.f6237j
            if (r2 == 0) goto L27
            goto L18
        L27:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.view.h.findFocus(int):android.view.accessibility.AccessibilityNodeInfo");
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public boolean performAction(int i6, int i7, Bundle bundle) {
        int i8;
        if (i6 >= 65536) {
            boolean performAction = this.f6231d.performAction(i6, i7, bundle);
            if (performAction && i7 == 128) {
                this.f6237j = null;
            }
            return performAction;
        }
        l lVar = this.f6234g.get(Integer.valueOf(i6));
        boolean z5 = false;
        if (lVar == null) {
            return false;
        }
        switch (i7) {
            case 16:
                this.f6229b.b(i6, g.TAP);
                return true;
            case 32:
                this.f6229b.b(i6, g.LONG_PRESS);
                return true;
            case 64:
                if (this.f6236i == null) {
                    this.f6228a.invalidate();
                }
                this.f6236i = lVar;
                this.f6229b.b(i6, g.DID_GAIN_ACCESSIBILITY_FOCUS);
                R(i6, 32768);
                if (lVar.u0(g.INCREASE) || lVar.u0(g.DECREASE)) {
                    R(i6, 4);
                }
                return true;
            case 128:
                l lVar2 = this.f6236i;
                if (lVar2 != null && lVar2.f6320b == i6) {
                    this.f6236i = null;
                }
                Integer num = this.f6237j;
                if (num != null && num.intValue() == i6) {
                    this.f6237j = null;
                }
                this.f6229b.b(i6, g.DID_LOSE_ACCESSIBILITY_FOCUS);
                R(i6, 65536);
                return true;
            case 256:
                return N(lVar, i6, bundle, true);
            case 512:
                return N(lVar, i6, bundle, false);
            case 4096:
                g gVar = g.SCROLL_UP;
                if (!lVar.u0(gVar)) {
                    gVar = g.SCROLL_LEFT;
                    if (!lVar.u0(gVar)) {
                        gVar = g.INCREASE;
                        if (!lVar.u0(gVar)) {
                            return false;
                        }
                        lVar.f6335q = lVar.f6337s;
                        lVar.f6336r = lVar.f6338t;
                        R(i6, 4);
                    }
                }
                this.f6229b.b(i6, gVar);
                return true;
            case 8192:
                g gVar2 = g.SCROLL_DOWN;
                if (!lVar.u0(gVar2)) {
                    gVar2 = g.SCROLL_RIGHT;
                    if (!lVar.u0(gVar2)) {
                        gVar2 = g.DECREASE;
                        if (!lVar.u0(gVar2)) {
                            return false;
                        }
                        lVar.f6335q = lVar.f6339u;
                        lVar.f6336r = lVar.f6340v;
                        R(i6, 4);
                    }
                }
                this.f6229b.b(i6, gVar2);
                return true;
            case 16384:
                this.f6229b.b(i6, g.COPY);
                return true;
            case 32768:
                this.f6229b.b(i6, g.PASTE);
                return true;
            case 65536:
                this.f6229b.b(i6, g.CUT);
                return true;
            case 131072:
                HashMap hashMap = new HashMap();
                if (bundle != null && bundle.containsKey("ACTION_ARGUMENT_SELECTION_START_INT") && bundle.containsKey("ACTION_ARGUMENT_SELECTION_END_INT")) {
                    z5 = true;
                }
                if (z5) {
                    hashMap.put("base", Integer.valueOf(bundle.getInt("ACTION_ARGUMENT_SELECTION_START_INT")));
                    i8 = bundle.getInt("ACTION_ARGUMENT_SELECTION_END_INT");
                } else {
                    hashMap.put("base", Integer.valueOf(lVar.f6326h));
                    i8 = lVar.f6326h;
                }
                hashMap.put("extent", Integer.valueOf(i8));
                this.f6229b.c(i6, g.SET_SELECTION, hashMap);
                l lVar3 = this.f6234g.get(Integer.valueOf(i6));
                lVar3.f6325g = ((Integer) hashMap.get("base")).intValue();
                lVar3.f6326h = ((Integer) hashMap.get("extent")).intValue();
                return true;
            case 1048576:
                this.f6229b.b(i6, g.DISMISS);
                return true;
            case 2097152:
                return O(lVar, i6, bundle);
            case R.id.accessibilityActionShowOnScreen:
                this.f6229b.b(i6, g.SHOW_ON_SCREEN);
                return true;
            default:
                C0093h c0093h = this.f6235h.get(Integer.valueOf(i7 - B));
                if (c0093h == null) {
                    return false;
                }
                this.f6229b.c(i6, g.CUSTOM_ACTION, Integer.valueOf(c0093h.f6291b));
                return true;
        }
    }

    public boolean x(View view, View view2, AccessibilityEvent accessibilityEvent) {
        Integer recordFlutterId;
        if (!this.f6231d.requestSendAccessibilityEvent(view, view2, accessibilityEvent) || (recordFlutterId = this.f6231d.getRecordFlutterId(view, accessibilityEvent)) == null) {
            return false;
        }
        int eventType = accessibilityEvent.getEventType();
        if (eventType == 8) {
            this.f6238k = recordFlutterId;
            this.f6240m = null;
            return true;
        }
        if (eventType == 128) {
            this.f6242o = null;
            return true;
        }
        if (eventType == 32768) {
            this.f6237j = recordFlutterId;
            this.f6236i = null;
            return true;
        }
        if (eventType != 65536) {
            return true;
        }
        this.f6238k = null;
        this.f6237j = null;
        return true;
    }
}
