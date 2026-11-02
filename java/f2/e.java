package f2;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.core.app.k0;
import androidx.core.app.n;
import h0.h2;
import h0.k3;
import h0.m2;
import h0.m4;
import h0.n3;
import h0.o3;
import h0.q3;
import h0.r4;
import h0.v;
import i2.c1;
import i2.g0;
import j2.d0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class e {
    private static int M;
    private boolean A;
    private boolean B;
    private boolean C;
    private int D;
    private boolean E;
    private int F;
    private int G;
    private int H;
    private int I;
    private int J;
    private boolean K;
    private String L;

    /* renamed from: a, reason: collision with root package name */
    private final Context f3797a;

    /* renamed from: b, reason: collision with root package name */
    private final String f3798b;

    /* renamed from: c, reason: collision with root package name */
    private final int f3799c;

    /* renamed from: d, reason: collision with root package name */
    private final InterfaceC0072e f3800d;

    /* renamed from: e, reason: collision with root package name */
    private final Handler f3801e;

    /* renamed from: f, reason: collision with root package name */
    private final k0 f3802f;

    /* renamed from: g, reason: collision with root package name */
    private final IntentFilter f3803g;

    /* renamed from: h, reason: collision with root package name */
    private final o3.d f3804h;

    /* renamed from: i, reason: collision with root package name */
    private final f f3805i;

    /* renamed from: j, reason: collision with root package name */
    private final Map<String, n.a> f3806j;

    /* renamed from: k, reason: collision with root package name */
    private final Map<String, n.a> f3807k;

    /* renamed from: l, reason: collision with root package name */
    private final PendingIntent f3808l;

    /* renamed from: m, reason: collision with root package name */
    private final int f3809m;

    /* renamed from: n, reason: collision with root package name */
    private n.c f3810n;

    /* renamed from: o, reason: collision with root package name */
    private List<n.a> f3811o;

    /* renamed from: p, reason: collision with root package name */
    private o3 f3812p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f3813q;

    /* renamed from: r, reason: collision with root package name */
    private int f3814r;

    /* renamed from: s, reason: collision with root package name */
    private MediaSessionCompat.Token f3815s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f3816t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f3817u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f3818v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f3819w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f3820x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f3821y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f3822z;

    public final class b {

        /* renamed from: a, reason: collision with root package name */
        private final int f3823a;

        private b(int i6) {
            this.f3823a = i6;
        }

        public void a(Bitmap bitmap) {
            if (bitmap != null) {
                e.this.r(bitmap, this.f3823a);
            }
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        protected final Context f3825a;

        /* renamed from: b, reason: collision with root package name */
        protected final int f3826b;

        /* renamed from: c, reason: collision with root package name */
        protected final String f3827c;

        /* renamed from: d, reason: collision with root package name */
        protected InterfaceC0072e f3828d;

        /* renamed from: e, reason: collision with root package name */
        protected int f3829e;

        /* renamed from: f, reason: collision with root package name */
        protected int f3830f;

        /* renamed from: g, reason: collision with root package name */
        protected int f3831g;

        /* renamed from: h, reason: collision with root package name */
        protected int f3832h;

        /* renamed from: i, reason: collision with root package name */
        protected int f3833i;

        /* renamed from: j, reason: collision with root package name */
        protected int f3834j;

        /* renamed from: k, reason: collision with root package name */
        protected int f3835k;

        /* renamed from: l, reason: collision with root package name */
        protected int f3836l;

        /* renamed from: m, reason: collision with root package name */
        protected int f3837m;

        /* renamed from: n, reason: collision with root package name */
        protected int f3838n;

        /* renamed from: o, reason: collision with root package name */
        protected int f3839o;

        /* renamed from: p, reason: collision with root package name */
        protected String f3840p;

        public c(Context context, int i6, String str) {
            i2.a.a(i6 > 0);
            this.f3825a = context;
            this.f3826b = i6;
            this.f3827c = str;
            this.f3831g = 2;
            this.f3828d = new f2.b(null);
            this.f3832h = f2.g.f3849g;
            this.f3834j = f2.g.f3846d;
            this.f3835k = f2.g.f3845c;
            this.f3836l = f2.g.f3850h;
            this.f3833i = f2.g.f3848f;
            this.f3837m = f2.g.f3843a;
            this.f3838n = f2.g.f3847e;
            this.f3839o = f2.g.f3844b;
        }

        public e a() {
            int i6 = this.f3829e;
            if (i6 != 0) {
                g0.a(this.f3825a, this.f3827c, i6, this.f3830f, this.f3831g);
            }
            return new e(this.f3825a, this.f3827c, this.f3826b, this.f3828d, null, null, this.f3832h, this.f3834j, this.f3835k, this.f3836l, this.f3833i, this.f3837m, this.f3838n, this.f3839o, this.f3840p);
        }

        public c b(InterfaceC0072e interfaceC0072e) {
            this.f3828d = interfaceC0072e;
            return this;
        }
    }

    public interface d {
        Map<String, n.a> a(Context context, int i6);
    }

    /* renamed from: f2.e$e, reason: collision with other inner class name */
    public interface InterfaceC0072e {
        CharSequence a(o3 o3Var);

        CharSequence b(o3 o3Var);

        PendingIntent c(o3 o3Var);

        CharSequence d(o3 o3Var);

        Bitmap e(o3 o3Var, b bVar);
    }

    private class f extends BroadcastReceiver {
        private f() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            o3 o3Var = e.this.f3812p;
            if (o3Var != null && e.this.f3813q && intent.getIntExtra("INSTANCE_ID", e.this.f3809m) == e.this.f3809m) {
                String action = intent.getAction();
                if ("com.google.android.exoplayer.play".equals(action)) {
                    if (o3Var.c() == 1) {
                        o3Var.e();
                    } else if (o3Var.c() == 4) {
                        o3Var.r(o3Var.L());
                    }
                    o3Var.f();
                    return;
                }
                if ("com.google.android.exoplayer.pause".equals(action)) {
                    o3Var.d();
                    return;
                }
                if ("com.google.android.exoplayer.prev".equals(action)) {
                    o3Var.d0();
                    return;
                }
                if ("com.google.android.exoplayer.rewind".equals(action)) {
                    o3Var.a0();
                    return;
                }
                if ("com.google.android.exoplayer.ffwd".equals(action)) {
                    o3Var.Z();
                    return;
                }
                if ("com.google.android.exoplayer.next".equals(action)) {
                    o3Var.Y();
                    return;
                }
                if ("com.google.android.exoplayer.stop".equals(action)) {
                    o3Var.D(true);
                } else if ("com.google.android.exoplayer.dismiss".equals(action)) {
                    e.this.A(true);
                } else if (action != null) {
                    e.h(e.this);
                }
            }
        }
    }

    public interface g {
    }

    private class h implements o3.d {
        private h() {
        }

        @Override // h0.o3.d
        public /* synthetic */ void A(int i6) {
            q3.q(this, i6);
        }

        @Override // h0.o3.d
        public /* synthetic */ void B(boolean z5, int i6) {
            q3.t(this, z5, i6);
        }

        @Override // h0.o3.d
        public /* synthetic */ void C(boolean z5) {
            q3.j(this, z5);
        }

        @Override // h0.o3.d
        public /* synthetic */ void D(int i6) {
            q3.u(this, i6);
        }

        @Override // h0.o3.d
        public /* synthetic */ void G(k3 k3Var) {
            q3.s(this, k3Var);
        }

        @Override // h0.o3.d
        public /* synthetic */ void I(boolean z5) {
            q3.h(this, z5);
        }

        @Override // h0.o3.d
        public /* synthetic */ void J(o3.e eVar, o3.e eVar2, int i6) {
            q3.v(this, eVar, eVar2, i6);
        }

        @Override // h0.o3.d
        public /* synthetic */ void K(m4 m4Var, int i6) {
            q3.C(this, m4Var, i6);
        }

        @Override // h0.o3.d
        public /* synthetic */ void L() {
            q3.w(this);
        }

        @Override // h0.o3.d
        public /* synthetic */ void M() {
            q3.y(this);
        }

        @Override // h0.o3.d
        public /* synthetic */ void O(v vVar) {
            q3.e(this, vVar);
        }

        @Override // h0.o3.d
        public /* synthetic */ void R(h2 h2Var, int i6) {
            q3.k(this, h2Var, i6);
        }

        @Override // h0.o3.d
        public /* synthetic */ void S(float f6) {
            q3.F(this, f6);
        }

        @Override // h0.o3.d
        public /* synthetic */ void T(k3 k3Var) {
            q3.r(this, k3Var);
        }

        @Override // h0.o3.d
        public /* synthetic */ void U(int i6) {
            q3.p(this, i6);
        }

        @Override // h0.o3.d
        public /* synthetic */ void V(boolean z5, int i6) {
            q3.n(this, z5, i6);
        }

        @Override // h0.o3.d
        public /* synthetic */ void W(j0.e eVar) {
            q3.a(this, eVar);
        }

        @Override // h0.o3.d
        public /* synthetic */ void b(boolean z5) {
            q3.A(this, z5);
        }

        @Override // h0.o3.d
        public /* synthetic */ void e0(boolean z5) {
            q3.z(this, z5);
        }

        @Override // h0.o3.d
        public /* synthetic */ void f0(o3.b bVar) {
            q3.b(this, bVar);
        }

        @Override // h0.o3.d
        public /* synthetic */ void h(n3 n3Var) {
            q3.o(this, n3Var);
        }

        @Override // h0.o3.d
        public /* synthetic */ void i(int i6) {
            q3.x(this, i6);
        }

        @Override // h0.o3.d
        public /* synthetic */ void i0(int i6, int i7) {
            q3.B(this, i6, i7);
        }

        @Override // h0.o3.d
        public /* synthetic */ void j(b1.a aVar) {
            q3.m(this, aVar);
        }

        @Override // h0.o3.d
        public /* synthetic */ void k0(m2 m2Var) {
            q3.l(this, m2Var);
        }

        @Override // h0.o3.d
        public /* synthetic */ void l(u1.e eVar) {
            q3.d(this, eVar);
        }

        @Override // h0.o3.d
        public /* synthetic */ void m(List list) {
            q3.c(this, list);
        }

        @Override // h0.o3.d
        public /* synthetic */ void m0(r4 r4Var) {
            q3.D(this, r4Var);
        }

        @Override // h0.o3.d
        public void o0(o3 o3Var, o3.c cVar) {
            if (cVar.b(4, 5, 7, 0, 12, 11, 8, 9, 14)) {
                e.this.q();
            }
        }

        @Override // h0.o3.d
        public /* synthetic */ void p(d0 d0Var) {
            q3.E(this, d0Var);
        }

        @Override // h0.o3.d
        public /* synthetic */ void p0(int i6, boolean z5) {
            q3.f(this, i6, z5);
        }

        @Override // h0.o3.d
        public /* synthetic */ void q0(boolean z5) {
            q3.i(this, z5);
        }
    }

    protected e(Context context, String str, int i6, InterfaceC0072e interfaceC0072e, g gVar, d dVar, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, String str2) {
        Context applicationContext = context.getApplicationContext();
        this.f3797a = applicationContext;
        this.f3798b = str;
        this.f3799c = i6;
        this.f3800d = interfaceC0072e;
        this.H = i7;
        this.L = str2;
        int i15 = M;
        M = i15 + 1;
        this.f3809m = i15;
        this.f3801e = c1.v(Looper.getMainLooper(), new Handler.Callback() { // from class: f2.d
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                boolean o6;
                o6 = e.this.o(message);
                return o6;
            }
        });
        this.f3802f = k0.d(applicationContext);
        this.f3804h = new h();
        this.f3805i = new f();
        this.f3803g = new IntentFilter();
        this.f3816t = true;
        this.f3817u = true;
        this.B = true;
        this.f3820x = true;
        this.f3821y = true;
        this.E = true;
        this.K = true;
        this.G = 0;
        this.F = 0;
        this.J = -1;
        this.D = 1;
        this.I = 1;
        Map<String, n.a> k6 = k(applicationContext, i15, i8, i9, i10, i11, i12, i13, i14);
        this.f3806j = k6;
        Iterator<String> it = k6.keySet().iterator();
        while (it.hasNext()) {
            this.f3803g.addAction(it.next());
        }
        Map<String, n.a> a6 = dVar != null ? dVar.a(applicationContext, this.f3809m) : Collections.emptyMap();
        this.f3807k = a6;
        Iterator<String> it2 = a6.keySet().iterator();
        while (it2.hasNext()) {
            this.f3803g.addAction(it2.next());
        }
        this.f3808l = i("com.google.android.exoplayer.dismiss", applicationContext, this.f3809m);
        this.f3803g.addAction("com.google.android.exoplayer.dismiss");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(boolean z5) {
        if (this.f3813q) {
            this.f3813q = false;
            this.f3801e.removeMessages(0);
            this.f3802f.b(this.f3799c);
            this.f3797a.unregisterReceiver(this.f3805i);
        }
    }

    static /* synthetic */ d h(e eVar) {
        eVar.getClass();
        return null;
    }

    private static PendingIntent i(String str, Context context, int i6) {
        Intent intent = new Intent(str).setPackage(context.getPackageName());
        intent.putExtra("INSTANCE_ID", i6);
        return PendingIntent.getBroadcast(context, i6, intent, c1.f5548a >= 23 ? 201326592 : 134217728);
    }

    private static Map<String, n.a> k(Context context, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13) {
        HashMap hashMap = new HashMap();
        hashMap.put("com.google.android.exoplayer.play", new n.a(i7, context.getString(i.f3855d), i("com.google.android.exoplayer.play", context, i6)));
        hashMap.put("com.google.android.exoplayer.pause", new n.a(i8, context.getString(i.f3854c), i("com.google.android.exoplayer.pause", context, i6)));
        hashMap.put("com.google.android.exoplayer.stop", new n.a(i9, context.getString(i.f3858g), i("com.google.android.exoplayer.stop", context, i6)));
        hashMap.put("com.google.android.exoplayer.rewind", new n.a(i10, context.getString(i.f3857f), i("com.google.android.exoplayer.rewind", context, i6)));
        hashMap.put("com.google.android.exoplayer.ffwd", new n.a(i11, context.getString(i.f3852a), i("com.google.android.exoplayer.ffwd", context, i6)));
        hashMap.put("com.google.android.exoplayer.prev", new n.a(i12, context.getString(i.f3856e), i("com.google.android.exoplayer.prev", context, i6)));
        hashMap.put("com.google.android.exoplayer.next", new n.a(i13, context.getString(i.f3853b), i("com.google.android.exoplayer.next", context, i6)));
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean o(Message message) {
        int i6 = message.what;
        if (i6 == 0) {
            o3 o3Var = this.f3812p;
            if (o3Var != null) {
                z(o3Var, null);
            }
        } else {
            if (i6 != 1) {
                return false;
            }
            o3 o3Var2 = this.f3812p;
            if (o3Var2 != null && this.f3813q && this.f3814r == message.arg1) {
                z(o3Var2, (Bitmap) message.obj);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (this.f3801e.hasMessages(0)) {
            return;
        }
        this.f3801e.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(Bitmap bitmap, int i6) {
        this.f3801e.obtainMessage(1, i6, -1, bitmap).sendToTarget();
    }

    private static void s(n.c cVar, Bitmap bitmap) {
        cVar.p(bitmap);
    }

    private boolean y(o3 o3Var) {
        return (o3Var.c() == 4 || o3Var.c() == 1 || !o3Var.y()) ? false : true;
    }

    private void z(o3 o3Var, Bitmap bitmap) {
        n.c j6 = j(o3Var, this.f3810n, n(o3Var), bitmap);
        this.f3810n = j6;
        if (j6 == null) {
            A(false);
            return;
        }
        this.f3802f.f(this.f3799c, j6.b());
        if (!this.f3813q) {
            this.f3797a.registerReceiver(this.f3805i, this.f3803g);
        }
        this.f3813q = true;
    }

    protected n.c j(o3 o3Var, n.c cVar, boolean z5, Bitmap bitmap) {
        if (o3Var.c() == 1 && o3Var.T().u()) {
            this.f3811o = null;
            return null;
        }
        List<String> m6 = m(o3Var);
        ArrayList arrayList = new ArrayList(m6.size());
        for (int i6 = 0; i6 < m6.size(); i6++) {
            String str = m6.get(i6);
            n.a aVar = (this.f3806j.containsKey(str) ? this.f3806j : this.f3807k).get(str);
            if (aVar != null) {
                arrayList.add(aVar);
            }
        }
        if (cVar == null || !arrayList.equals(this.f3811o)) {
            cVar = new n.c(this.f3797a, this.f3798b);
            this.f3811o = arrayList;
            for (int i7 = 0; i7 < arrayList.size(); i7++) {
                cVar.a((n.a) arrayList.get(i7));
            }
        }
        androidx.media.app.b bVar = new androidx.media.app.b();
        MediaSessionCompat.Token token = this.f3815s;
        if (token != null) {
            bVar.i(token);
        }
        bVar.j(l(m6, o3Var));
        bVar.k(!z5);
        bVar.h(this.f3808l);
        cVar.v(bVar);
        cVar.m(this.f3808l);
        cVar.f(this.D).q(z5).g(this.G).h(this.E).u(this.H).y(this.I).s(this.J).l(this.F);
        if (c1.f5548a < 21 || !this.K || !o3Var.I() || o3Var.q() || o3Var.R() || o3Var.h().f4732a != 1.0f) {
            cVar.t(false).x(false);
        } else {
            cVar.z(System.currentTimeMillis() - o3Var.t()).t(true).x(true);
        }
        cVar.k(this.f3800d.a(o3Var));
        cVar.j(this.f3800d.b(o3Var));
        cVar.w(this.f3800d.d(o3Var));
        if (bitmap == null) {
            InterfaceC0072e interfaceC0072e = this.f3800d;
            int i8 = this.f3814r + 1;
            this.f3814r = i8;
            bitmap = interfaceC0072e.e(o3Var, new b(i8));
        }
        s(cVar, bitmap);
        cVar.i(this.f3800d.c(o3Var));
        String str2 = this.L;
        if (str2 != null) {
            cVar.o(str2);
        }
        cVar.r(true);
        return cVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0042 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected int[] l(java.util.List<java.lang.String> r7, h0.o3 r8) {
        /*
            r6 = this;
            java.lang.String r0 = "com.google.android.exoplayer.pause"
            int r0 = r7.indexOf(r0)
            java.lang.String r1 = "com.google.android.exoplayer.play"
            int r1 = r7.indexOf(r1)
            boolean r2 = r6.f3818v
            r3 = -1
            if (r2 == 0) goto L18
            java.lang.String r2 = "com.google.android.exoplayer.prev"
        L13:
            int r2 = r7.indexOf(r2)
            goto L20
        L18:
            boolean r2 = r6.f3822z
            if (r2 == 0) goto L1f
            java.lang.String r2 = "com.google.android.exoplayer.rewind"
            goto L13
        L1f:
            r2 = -1
        L20:
            boolean r4 = r6.f3819w
            if (r4 == 0) goto L2b
            java.lang.String r4 = "com.google.android.exoplayer.next"
        L26:
            int r7 = r7.indexOf(r4)
            goto L33
        L2b:
            boolean r4 = r6.A
            if (r4 == 0) goto L32
            java.lang.String r4 = "com.google.android.exoplayer.ffwd"
            goto L26
        L32:
            r7 = -1
        L33:
            r4 = 3
            int[] r4 = new int[r4]
            r5 = 0
            if (r2 == r3) goto L3c
            r4[r5] = r2
            r5 = 1
        L3c:
            boolean r8 = r6.y(r8)
            if (r0 == r3) goto L4a
            if (r8 == 0) goto L4a
            int r8 = r5 + 1
            r4[r5] = r0
        L48:
            r5 = r8
            goto L53
        L4a:
            if (r1 == r3) goto L53
            if (r8 != 0) goto L53
            int r8 = r5 + 1
            r4[r5] = r1
            goto L48
        L53:
            if (r7 == r3) goto L5a
            int r8 = r5 + 1
            r4[r5] = r7
            r5 = r8
        L5a:
            int[] r7 = java.util.Arrays.copyOf(r4, r5)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: f2.e.l(java.util.List, h0.o3):int[]");
    }

    protected List<String> m(o3 o3Var) {
        boolean M2 = o3Var.M(7);
        boolean M3 = o3Var.M(11);
        boolean M4 = o3Var.M(12);
        boolean M5 = o3Var.M(9);
        ArrayList arrayList = new ArrayList();
        if (this.f3816t && M2) {
            arrayList.add("com.google.android.exoplayer.prev");
        }
        if (this.f3820x && M3) {
            arrayList.add("com.google.android.exoplayer.rewind");
        }
        if (this.B) {
            arrayList.add(y(o3Var) ? "com.google.android.exoplayer.pause" : "com.google.android.exoplayer.play");
        }
        if (this.f3821y && M4) {
            arrayList.add("com.google.android.exoplayer.ffwd");
        }
        if (this.f3817u && M5) {
            arrayList.add("com.google.android.exoplayer.next");
        }
        if (this.C) {
            arrayList.add("com.google.android.exoplayer.stop");
        }
        return arrayList;
    }

    protected boolean n(o3 o3Var) {
        int c6 = o3Var.c();
        return (c6 == 2 || c6 == 3) && o3Var.y();
    }

    public final void p() {
        if (this.f3813q) {
            q();
        }
    }

    public final void t(MediaSessionCompat.Token token) {
        if (c1.c(this.f3815s, token)) {
            return;
        }
        this.f3815s = token;
        p();
    }

    public final void u(o3 o3Var) {
        boolean z5 = true;
        i2.a.g(Looper.myLooper() == Looper.getMainLooper());
        if (o3Var != null && o3Var.U() != Looper.getMainLooper()) {
            z5 = false;
        }
        i2.a.a(z5);
        o3 o3Var2 = this.f3812p;
        if (o3Var2 == o3Var) {
            return;
        }
        if (o3Var2 != null) {
            o3Var2.W(this.f3804h);
            if (o3Var == null) {
                A(false);
            }
        }
        this.f3812p = o3Var;
        if (o3Var != null) {
            o3Var.N(this.f3804h);
            q();
        }
    }

    public final void v(boolean z5) {
        if (this.f3817u != z5) {
            this.f3817u = z5;
            p();
        }
    }

    public final void w(boolean z5) {
        if (this.f3816t != z5) {
            this.f3816t = z5;
            p();
        }
    }

    public final void x(boolean z5) {
        if (this.C == z5) {
            return;
        }
        this.C = z5;
        p();
    }
}
