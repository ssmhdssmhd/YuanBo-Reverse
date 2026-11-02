package z2;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import android.view.Surface;
import android.view.Window;
import androidx.work.b;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.exoplayer2.source.dash.c;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource;
import com.google.android.exoplayer2.source.smoothstreaming.a;
import com.jhomlala.better_player.CacheWorker;
import com.jhomlala.better_player.ImageWorker;
import e2.m;
import e2.u;
import f2.e;
import g2.m;
import g2.u;
import g2.v;
import h0.a2;
import h0.f2;
import h0.h2;
import h0.k3;
import h0.m2;
import h0.m4;
import h0.n3;
import h0.o3;
import h0.q3;
import h0.r;
import h0.r4;
import h0.y;
import h0.y1;
import i2.c1;
import io.flutter.view.t;
import j0.e;
import j2.d0;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import l1.j0;
import l1.w0;
import m0.b0;
import m0.g0;
import m0.h;
import m0.o0;
import m0.p0;
import m0.u0;
import m0.v0;
import m0.w;
import v.l;
import v.s;
import y3.d;
import y3.k;
import z2.e;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: x, reason: collision with root package name */
    public static final a f11250x = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final y3.d f11251a;

    /* renamed from: b, reason: collision with root package name */
    private final t.c f11252b;

    /* renamed from: c, reason: collision with root package name */
    private final y f11253c;

    /* renamed from: d, reason: collision with root package name */
    private final t f11254d;

    /* renamed from: e, reason: collision with root package name */
    private final e2.m f11255e;

    /* renamed from: f, reason: collision with root package name */
    private final f2 f11256f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f11257g;

    /* renamed from: h, reason: collision with root package name */
    private Surface f11258h;

    /* renamed from: i, reason: collision with root package name */
    private String f11259i;

    /* renamed from: j, reason: collision with root package name */
    private f2.e f11260j;

    /* renamed from: k, reason: collision with root package name */
    private Handler f11261k;

    /* renamed from: l, reason: collision with root package name */
    private Runnable f11262l;

    /* renamed from: m, reason: collision with root package name */
    private o3.d f11263m;

    /* renamed from: n, reason: collision with root package name */
    private Bitmap f11264n;

    /* renamed from: o, reason: collision with root package name */
    private MediaSessionCompat f11265o;

    /* renamed from: p, reason: collision with root package name */
    private v.b f11266p;

    /* renamed from: q, reason: collision with root package name */
    private m0.h f11267q;

    /* renamed from: r, reason: collision with root package name */
    private final v.t f11268r;

    /* renamed from: s, reason: collision with root package name */
    private final HashMap<UUID, androidx.lifecycle.q<v.s>> f11269s;

    /* renamed from: t, reason: collision with root package name */
    private final o f11270t;

    /* renamed from: u, reason: collision with root package name */
    private long f11271u;

    /* renamed from: v, reason: collision with root package name */
    private Activity f11272v;

    /* renamed from: w, reason: collision with root package name */
    private final SharedPreferences f11273w;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        private final void b(File file) {
            File[] listFiles;
            if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File entry : listFiles) {
                    kotlin.jvm.internal.k.d(entry, "entry");
                    b(entry);
                }
            }
            if (file.delete()) {
                return;
            }
            Log.e("BetterPlayerEx", "Failed to delete cache dir.");
        }

        public final void a(Context context, k.d result) {
            kotlin.jvm.internal.k.e(result, "result");
            if (context != null) {
                try {
                    e.f11250x.b(new File(context.getCacheDir(), "betterPlayerCache"));
                } catch (Exception e6) {
                    Log.e("BetterPlayerEx", e6.toString());
                    result.a("", "", "");
                    return;
                }
            }
            result.b(null);
        }

        public final void c(Context context, String str, long j6, long j7, long j8, Map<String, String> headers, String str2, k.d result) {
            kotlin.jvm.internal.k.e(headers, "headers");
            kotlin.jvm.internal.k.e(result, "result");
            b.a e6 = new b.a().f("url", str).e("preCacheSize", j6).e("maxCacheSize", j7).e("maxCacheFileSize", j8);
            kotlin.jvm.internal.k.d(e6, "Builder().putString(Bett…AMETER, maxCacheFileSize)");
            if (str2 != null) {
                e6.f("cacheKey", str2);
            }
            for (String str3 : headers.keySet()) {
                e6.f("header_" + str3, headers.get(str3));
            }
            if (str != null && context != null) {
                v.l b6 = new l.a(CacheWorker.class).a(str).e(e6.a()).b();
                kotlin.jvm.internal.k.d(b6, "Builder(CacheWorker::cla…aBuilder.build()).build()");
                v.t.d(context).c(b6);
            }
            result.b(null);
        }

        public final void d(Context context, String str, k.d result) {
            kotlin.jvm.internal.k.e(result, "result");
            if (str != null && context != null) {
                v.t.d(context).a(str);
            }
            result.b(null);
        }
    }

    public static final class b extends MediaSessionCompat.b {
        b() {
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void v0(long j6) {
            e.this.I(j6);
            super.v0(j6);
        }
    }

    public static final class c implements o3.d {
        c() {
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
        public /* synthetic */ void O(h0.v vVar) {
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
        public void U(int i6) {
            MediaSessionCompat mediaSessionCompat = e.this.f11265o;
            if (mediaSessionCompat != null) {
                mediaSessionCompat.j(new MediaMetadataCompat.b().c("android.media.metadata.DURATION", e.this.A()).a());
            }
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
        public /* synthetic */ void o0(o3 o3Var, o3.c cVar) {
            q3.g(this, o3Var, cVar);
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

    public static final class d implements e.InterfaceC0072e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f11276a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f11277b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f11278c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f11279d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f11280e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ e f11281f;

        d(String str, Context context, String str2, String str3, String str4, e eVar) {
            this.f11276a = str;
            this.f11277b = context;
            this.f11278c = str2;
            this.f11279d = str3;
            this.f11280e = str4;
            this.f11281f = eVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void i(e this$0, v.l imageWorkRequest, e.b callback, v.s sVar) {
            kotlin.jvm.internal.k.e(this$0, "this$0");
            kotlin.jvm.internal.k.e(imageWorkRequest, "$imageWorkRequest");
            kotlin.jvm.internal.k.e(callback, "$callback");
            if (sVar != null) {
                try {
                    s.a b6 = sVar.b();
                    kotlin.jvm.internal.k.d(b6, "workInfo.state");
                    s.a aVar = s.a.SUCCEEDED;
                    if (b6 == aVar) {
                        androidx.work.b a6 = sVar.a();
                        kotlin.jvm.internal.k.d(a6, "workInfo.outputData");
                        this$0.f11264n = BitmapFactory.decodeFile(a6.j("filePath"));
                        Bitmap bitmap = this$0.f11264n;
                        if (bitmap != null) {
                            callback.a(bitmap);
                        }
                    }
                    if (b6 == aVar || b6 == s.a.CANCELLED || b6 == s.a.FAILED) {
                        UUID a7 = imageWorkRequest.a();
                        kotlin.jvm.internal.k.d(a7, "imageWorkRequest.id");
                        androidx.lifecycle.q<? super v.s> qVar = (androidx.lifecycle.q) this$0.f11269s.remove(a7);
                        if (qVar != null) {
                            this$0.f11268r.e(a7).j(qVar);
                        }
                    }
                } catch (Exception e6) {
                    Log.e("BetterPlayerEx", "Image select error: " + e6);
                }
            }
        }

        @Override // f2.e.InterfaceC0072e
        public PendingIntent c(o3 player) {
            kotlin.jvm.internal.k.e(player, "player");
            String packageName = this.f11277b.getApplicationContext().getPackageName();
            Intent intent = new Intent();
            intent.setClassName(packageName, packageName + '.' + this.f11278c);
            intent.setFlags(603979776);
            return PendingIntent.getActivity(this.f11277b, 0, intent, 67108864);
        }

        @Override // f2.e.InterfaceC0072e
        public /* synthetic */ CharSequence d(o3 o3Var) {
            return f2.f.a(this, o3Var);
        }

        @Override // f2.e.InterfaceC0072e
        public Bitmap e(o3 player, final e.b callback) {
            kotlin.jvm.internal.k.e(player, "player");
            kotlin.jvm.internal.k.e(callback, "callback");
            if (this.f11280e == null) {
                return null;
            }
            if (this.f11281f.f11264n != null) {
                return this.f11281f.f11264n;
            }
            v.l b6 = new l.a(ImageWorker.class).a(this.f11280e).e(new b.a().f("url", this.f11280e).a()).b();
            kotlin.jvm.internal.k.d(b6, "Builder(ImageWorker::cla…                ).build()");
            final v.l lVar = b6;
            this.f11281f.f11268r.c(lVar);
            final e eVar = this.f11281f;
            androidx.lifecycle.q<? super v.s> qVar = new androidx.lifecycle.q() { // from class: z2.f
                @Override // androidx.lifecycle.q
                public final void a(Object obj) {
                    e.d.i(e.this, lVar, callback, (v.s) obj);
                }
            };
            UUID a6 = lVar.a();
            kotlin.jvm.internal.k.d(a6, "imageWorkRequest.id");
            this.f11281f.f11268r.e(a6).f(qVar);
            this.f11281f.f11269s.put(a6, qVar);
            return null;
        }

        @Override // f2.e.InterfaceC0072e
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public String b(o3 player) {
            kotlin.jvm.internal.k.e(player, "player");
            return this.f11279d;
        }

        @Override // f2.e.InterfaceC0072e
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public String a(o3 player) {
            kotlin.jvm.internal.k.e(player, "player");
            return this.f11276a;
        }
    }

    /* renamed from: z2.e$e, reason: collision with other inner class name */
    public static final class C0175e implements d.InterfaceC0171d {
        C0175e() {
        }

        @Override // y3.d.InterfaceC0171d
        public void a(Object obj) {
            e.this.f11254d.f(null);
        }

        @Override // y3.d.InterfaceC0171d
        public void b(Object obj, d.b sink) {
            kotlin.jvm.internal.k.e(sink, "sink");
            e.this.f11254d.f(sink);
        }
    }

    public static final class f implements o3.d {
        f() {
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
        public /* synthetic */ void O(h0.v vVar) {
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
        public void T(k3 error) {
            kotlin.jvm.internal.k.e(error, "error");
            e.this.f11254d.a("VideoError", "Video player had error " + error, "");
        }

        @Override // h0.o3.d
        public void U(int i6) {
            HashMap hashMap;
            String str;
            if (i6 == 2) {
                e.this.G(true);
                hashMap = new HashMap();
                str = "bufferingStart";
            } else {
                if (i6 != 3) {
                    if (i6 != 4) {
                        return;
                    }
                    hashMap = new HashMap();
                    hashMap.put("event", "completed");
                    hashMap.put("key", e.this.f11259i);
                    e.this.f11254d.b(hashMap);
                }
                if (!e.this.f11257g) {
                    e.this.f11257g = true;
                    e.this.H();
                }
                hashMap = new HashMap();
                str = "bufferingEnd";
            }
            hashMap.put("event", str);
            e.this.f11254d.b(hashMap);
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
        public /* synthetic */ void o0(o3 o3Var, o3.c cVar) {
            q3.g(this, o3Var, cVar);
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

    public e(Context context, y3.d eventChannel, t.c textureEntry, o oVar, k.d result) {
        kotlin.jvm.internal.k.e(context, "context");
        kotlin.jvm.internal.k.e(eventChannel, "eventChannel");
        kotlin.jvm.internal.k.e(textureEntry, "textureEntry");
        kotlin.jvm.internal.k.e(result, "result");
        this.f11251a = eventChannel;
        this.f11252b = textureEntry;
        this.f11254d = new t();
        e2.m mVar = new e2.m(context);
        this.f11255e = mVar;
        this.f11266p = new v.b();
        oVar = oVar == null ? new o() : oVar;
        this.f11270t = oVar;
        this.f11273w = context.getSharedPreferences("BETTER_PLAYER_OFFLINE", 0);
        this.f11266p.g("BetterPlayer");
        r.a aVar = new r.a();
        aVar.b(oVar.f11316a, oVar.f11317b, oVar.f11318c, oVar.f11319d);
        h0.r a6 = aVar.a();
        kotlin.jvm.internal.k.d(a6, "loadBuilder.build()");
        this.f11256f = a6;
        this.f11253c = new y.c(context).o(mVar).n(a6).g();
        v.t d6 = v.t.d(context);
        kotlin.jvm.internal.k.d(d6, "getInstance(context)");
        this.f11268r = d6;
        this.f11269s = new HashMap<>();
        V(eventChannel, textureEntry, result);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long A() {
        y yVar = this.f11253c;
        if (yVar != null) {
            return yVar.getDuration();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H() {
        if (this.f11257g) {
            HashMap hashMap = new HashMap();
            hashMap.put("event", "initialized");
            hashMap.put("key", this.f11259i);
            hashMap.put("duration", Long.valueOf(A()));
            y yVar = this.f11253c;
            if ((yVar != null ? yVar.E() : null) != null) {
                y1 E = this.f11253c.E();
                Integer valueOf = E != null ? Integer.valueOf(E.f5071u) : null;
                Integer valueOf2 = E != null ? Integer.valueOf(E.f5072v) : null;
                Integer valueOf3 = E != null ? Integer.valueOf(E.f5074x) : null;
                if ((valueOf3 != null && valueOf3.intValue() == 90) || (valueOf3 != null && valueOf3.intValue() == 270)) {
                    y1 E2 = this.f11253c.E();
                    valueOf = E2 != null ? Integer.valueOf(E2.f5072v) : null;
                    y1 E3 = this.f11253c.E();
                    valueOf2 = E3 != null ? Integer.valueOf(E3.f5071u) : null;
                }
                hashMap.put("width", valueOf);
                hashMap.put("height", valueOf2);
            }
            this.f11254d.b(hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I(long j6) {
        y yVar = this.f11253c;
        if (yVar != null) {
            yVar.l(j6);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("event", "seek");
        hashMap.put("position", Long.valueOf(j6));
        this.f11254d.b(hashMap);
    }

    private final void J(y yVar, boolean z5) {
        y.a b02;
        if (yVar == null || (b02 = yVar.b0()) == null) {
            return;
        }
        b02.j(new e.C0096e().c(3).a(), !z5);
    }

    private final void K(int i6, int i7, int i8) {
        u.a j6 = this.f11255e.j();
        if (j6 != null) {
            m.d.a w02 = this.f11255e.G().H().v0(i6, false).w0(i6, j6.f(i6), new m.e(i7, i8));
            kotlin.jvm.internal.k.d(w02, "trackSelector.parameters…tIndex)\n                )");
            this.f11255e.b0(w02);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(e this$0) {
        PlaybackStateCompat.d c6;
        int i6;
        kotlin.jvm.internal.k.e(this$0, "this$0");
        y yVar = this$0.f11253c;
        boolean z5 = false;
        if (yVar != null && yVar.I()) {
            z5 = true;
        }
        if (z5) {
            c6 = new PlaybackStateCompat.d().c(256L);
            i6 = 3;
        } else {
            c6 = new PlaybackStateCompat.d().c(256L);
            i6 = 2;
        }
        PlaybackStateCompat b6 = c6.h(i6, this$0.B(), 1.0f).b();
        kotlin.jvm.internal.k.d(b6, "{\n                    Pl…build()\n                }");
        MediaSessionCompat mediaSessionCompat = this$0.f11265o;
        if (mediaSessionCompat != null) {
            mediaSessionCompat.k(b6);
        }
        Handler handler = this$0.f11261k;
        if (handler != null) {
            Runnable runnable = this$0.f11262l;
            kotlin.jvm.internal.k.b(runnable);
            handler.postDelayed(runnable, 1000L);
        }
    }

    private final void V(y3.d dVar, t.c cVar, k.d dVar2) {
        dVar.d(new C0175e());
        Surface surface = new Surface(cVar.d());
        this.f11258h = surface;
        y yVar = this.f11253c;
        if (yVar != null) {
            yVar.p(surface);
        }
        J(this.f11253c, true);
        y yVar2 = this.f11253c;
        if (yVar2 != null) {
            yVar2.N(new f());
        }
        HashMap hashMap = new HashMap();
        hashMap.put("textureId", Long.valueOf(cVar.e()));
        dVar2.b(hashMap);
    }

    private final void W(boolean z5) {
        Window window;
        Window window2;
        try {
            if (z5) {
                Activity activity = this.f11272v;
                if (activity != null && (window2 = activity.getWindow()) != null) {
                    window2.setFlags(8192, 8192);
                }
            } else {
                Activity activity2 = this.f11272v;
                if (activity2 != null && (window = activity2.getWindow()) != null) {
                    window.clearFlags(8192);
                }
            }
        } catch (Exception e6) {
            Log.e("BetterPlayerEx", "LayoutParams can't be updated, error: " + e6);
        }
    }

    private final m0.h q(String str, Map<String, String> map, p0 p0Var) {
        if (c1.f5548a < 18) {
            Log.e("BetterPlayerEx", "Protected content not supported on API levels below 18");
            return null;
        }
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                p0Var.e(entry.getKey(), entry.getValue());
            }
        }
        UUID V = c1.V("widevine");
        if (V == null) {
            return null;
        }
        m0.h a6 = new h.b().f(V, new g0.c() { // from class: z2.c
            @Override // m0.g0.c
            public final g0 a(UUID uuid) {
                g0 r6;
                r6 = e.r(uuid);
                return r6;
            }
        }).c(true).a(p0Var);
        kotlin.jvm.internal.k.d(a6, "Builder()\n              …(true).build(drmCallback)");
        Log.i("BetterPlayerEx", ">>> drmSchemeUuid is defined, return DefaultDrmSessionManager: " + a6);
        return a6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final g0 r(UUID uuid) {
        try {
            kotlin.jvm.internal.k.b(uuid);
            o0 D = o0.D(uuid);
            kotlin.jvm.internal.k.d(D, "newInstance(uuid!!)");
            D.E("securityLevel", "L3");
            return D;
        } catch (v0 unused) {
            return new m0.d0();
        }
    }

    private final l1.v s(Uri uri, m.a aVar, String str, String str2, Context context) {
        int i6;
        l1.v a6;
        if (str == null) {
            String lastPathSegment = uri.getLastPathSegment();
            if (lastPathSegment == null) {
                lastPathSegment = "";
            }
            i6 = c1.o0(Uri.parse(lastPathSegment));
        } else {
            int hashCode = str.hashCode();
            if (hashCode == 3680) {
                if (str.equals("ss")) {
                    i6 = 1;
                }
                i6 = -1;
            } else if (hashCode == 103407) {
                if (str.equals("hls")) {
                    i6 = 2;
                }
                i6 = -1;
            } else if (hashCode != 3075986) {
                if (hashCode == 106069776 && str.equals("other")) {
                    i6 = 4;
                }
                i6 = -1;
            } else {
                if (str.equals("dash")) {
                    i6 = 0;
                }
                i6 = -1;
            }
        }
        h2.c cVar = new h2.c();
        cVar.e(uri);
        if (str2 != null) {
            if (str2.length() > 0) {
                cVar.b(str2);
            }
        }
        h2 a7 = cVar.a();
        kotlin.jvm.internal.k.d(a7, "mediaItemBuilder.build()");
        b0 lVar = new m0.l();
        final m0.h hVar = this.f11267q;
        if (hVar != null) {
            lVar = new b0() { // from class: z2.a
                @Override // m0.b0
                public final m0.y a(h2 h2Var) {
                    m0.y t5;
                    t5 = e.t(m0.h.this, h2Var);
                    return t5;
                }
            };
        }
        if (i6 == 0) {
            a6 = new DashMediaSource.Factory(new c.a(aVar), new u.a(context, aVar)).b(lVar).a(a7);
        } else if (i6 == 1) {
            a6 = new SsMediaSource.Factory(new a.C0046a(aVar), new u.a(context, aVar)).b(lVar).a(a7);
        } else {
            if (i6 == 2) {
                HlsMediaSource a8 = new HlsMediaSource.Factory(aVar).b(lVar).a(a7);
                kotlin.jvm.internal.k.d(a8, "Factory(mediaDataSourceF…ateMediaSource(mediaItem)");
                return a8;
            }
            if (i6 != 4) {
                throw new IllegalStateException("Unsupported type: " + i6);
            }
            a6 = new j0.b(aVar, new o0.i()).d(lVar).b(a7);
        }
        kotlin.jvm.internal.k.d(a6, "Factory(\n               …ateMediaSource(mediaItem)");
        return a6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final m0.y t(m0.h drmSessionManager, h2 it) {
        kotlin.jvm.internal.k.e(drmSessionManager, "$drmSessionManager");
        kotlin.jvm.internal.k.e(it, "it");
        return drmSessionManager;
    }

    private final m0.h u(Context context, String str, Map<String, String> map, y1 y1Var, String str2) {
        if (c1.f5548a < 18) {
            Log.e("BetterPlayerEx", "Protected content not supported on API levels below 18");
            return null;
        }
        b3.a d6 = new s(context).d(str2);
        byte[] a6 = d6 != null ? d6.a() : null;
        UUID V = c1.V("widevine");
        p pVar = new p(str, map);
        h.b bVar = new h.b();
        kotlin.jvm.internal.k.b(V);
        m0.h a7 = bVar.f(V, new g0.c() { // from class: z2.b
            @Override // m0.g0.c
            public final g0 a(UUID uuid) {
                g0 v5;
                v5 = e.v(uuid);
                return v5;
            }
        }).c(true).a(pVar);
        kotlin.jvm.internal.k.d(a7, "Builder()\n              … .build(mediaDrmCallback)");
        u0 u0Var = new u0(a7, new w.a());
        if (a6 != null) {
            a7.G(1, a6);
            u0Var.i();
        }
        return a7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final g0 v(UUID uuid) {
        try {
            kotlin.jvm.internal.k.b(uuid);
            o0 D = o0.D(uuid);
            kotlin.jvm.internal.k.d(D, "newInstance(uuid!!)");
            D.E("securityLevel", "L3");
            return D;
        } catch (v0 unused) {
            return new m0.d0();
        }
    }

    public final long B() {
        y yVar = this.f11253c;
        if (yVar != null) {
            return yVar.e0();
        }
        return 0L;
    }

    public final void C(boolean z5) {
        HashMap hashMap = new HashMap();
        hashMap.put("event", z5 ? "pipStart" : "pipStop");
        this.f11254d.b(hashMap);
    }

    public final void D() {
        y yVar = this.f11253c;
        if (yVar == null) {
            return;
        }
        yVar.o(false);
    }

    public final void E() {
        y yVar = this.f11253c;
        if (yVar == null) {
            return;
        }
        yVar.o(true);
    }

    public final void F(int i6) {
        y yVar = this.f11253c;
        if (yVar != null) {
            yVar.l(i6);
        }
    }

    public final void G(boolean z5) {
        List h6;
        y yVar = this.f11253c;
        long x5 = yVar != null ? yVar.x() : 0L;
        if (z5 || x5 != this.f11271u) {
            HashMap hashMap = new HashMap();
            hashMap.put("event", "bufferingUpdate");
            h6 = f4.l.h(0L, Long.valueOf(x5));
            hashMap.put("values", f4.k.b(h6));
            this.f11254d.b(hashMap);
            this.f11271u = x5;
        }
    }

    public final void L(String name, int i6) {
        kotlin.jvm.internal.k.e(name, "name");
        try {
            u.a j6 = this.f11255e.j();
            if (j6 != null) {
                int d6 = j6.d();
                for (int i7 = 0; i7 < d6; i7++) {
                    if (j6.e(i7) == 1) {
                        w0 f6 = j6.f(i7);
                        kotlin.jvm.internal.k.d(f6, "mappedTrackInfo.getTrackGroups(rendererIndex)");
                        int i8 = f6.f7457a;
                        boolean z5 = false;
                        boolean z6 = false;
                        for (int i9 = 0; i9 < i8; i9++) {
                            l1.u0 b6 = f6.b(i9);
                            kotlin.jvm.internal.k.d(b6, "trackGroupArray[groupIndex]");
                            int i10 = b6.f7445a;
                            for (int i11 = 0; i11 < i10; i11++) {
                                y1 b7 = b6.b(i11);
                                kotlin.jvm.internal.k.d(b7, "group.getFormat(groupElementIndex)");
                                if (b7.f5056b == null) {
                                    z5 = true;
                                }
                                String str = b7.f5055a;
                                if (str != null && kotlin.jvm.internal.k.a(str, "1/15")) {
                                    z6 = true;
                                }
                            }
                        }
                        int i12 = f6.f7457a;
                        for (int i13 = 0; i13 < i12; i13++) {
                            l1.u0 b8 = f6.b(i13);
                            kotlin.jvm.internal.k.d(b8, "trackGroupArray[groupIndex]");
                            int i14 = b8.f7445a;
                            for (int i15 = 0; i15 < i14; i15++) {
                                String str2 = b8.b(i15).f5056b;
                                if (kotlin.jvm.internal.k.a(name, str2) && i6 == i13) {
                                    K(i7, i13, i15);
                                    return;
                                }
                                if (!z6 && z5 && i6 == i13) {
                                    K(i7, i13, i15);
                                    return;
                                } else {
                                    if (z6 && kotlin.jvm.internal.k.a(name, str2)) {
                                        K(i7, i13, i15);
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e6) {
            Log.e("BetterPlayerEx", "setAudioTrack failed" + e6);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0135  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void M(android.content.Context r23, android.app.Activity r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, y3.k.d r28, java.util.Map<java.lang.String, java.lang.String> r29, boolean r30, long r31, long r33, long r35, java.lang.String r37, java.util.Map<java.lang.String, java.lang.String> r38, java.lang.String r39, java.lang.String r40, boolean r41, java.lang.String r42) {
        /*
            Method dump skipped, instructions count: 387
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z2.e.M(android.content.Context, android.app.Activity, java.lang.String, java.lang.String, java.lang.String, y3.k$d, java.util.Map, boolean, long, long, long, java.lang.String, java.util.Map, java.lang.String, java.lang.String, boolean, java.lang.String):void");
    }

    public final void N(boolean z5) {
        y yVar = this.f11253c;
        if (yVar == null) {
            return;
        }
        yVar.g(z5 ? 2 : 0);
    }

    public final void O(boolean z5) {
        J(this.f11253c, z5);
    }

    public final void P(double d6) {
        n3 n3Var = new n3((float) d6);
        y yVar = this.f11253c;
        if (yVar == null) {
            return;
        }
        yVar.i(n3Var);
    }

    public final void Q(int i6, int i7, int i8) {
        m.d.a B = this.f11255e.B();
        kotlin.jvm.internal.k.d(B, "trackSelector.buildUponParameters()");
        if (i6 != 0 && i7 != 0) {
            B.G(i6, i7);
        }
        if (i8 != 0) {
            B.s0(i8);
        }
        if (i6 == 0 && i7 == 0 && i8 == 0) {
            B.b0();
            B.s0(Integer.MAX_VALUE);
        }
        this.f11255e.b0(B);
    }

    public final void R(double d6) {
        float max = (float) Math.max(0.0d, Math.min(1.0d, d6));
        y yVar = this.f11253c;
        if (yVar == null) {
            return;
        }
        yVar.m(max);
    }

    public final MediaSessionCompat S(Context context) {
        MediaSessionCompat mediaSessionCompat = this.f11265o;
        if (mediaSessionCompat != null) {
            mediaSessionCompat.e();
        }
        if (context == null) {
            return null;
        }
        MediaSessionCompat mediaSessionCompat2 = new MediaSessionCompat(context, "BetterPlayerEx", null, PendingIntent.getBroadcast(context, 0, new Intent("android.intent.action.MEDIA_BUTTON"), 67108864));
        mediaSessionCompat2.g(new b());
        mediaSessionCompat2.f(true);
        new n0.a(mediaSessionCompat2).I(this.f11253c);
        this.f11265o = mediaSessionCompat2;
        return mediaSessionCompat2;
    }

    public final void T(Context context, String title, String str, String str2, String str3, String activityName) {
        Object systemService;
        kotlin.jvm.internal.k.e(context, "context");
        kotlin.jvm.internal.k.e(title, "title");
        kotlin.jvm.internal.k.e(activityName, "activityName");
        d dVar = new d(title, context, activityName, str, str2, this);
        if (str3 == null && Build.VERSION.SDK_INT >= 26) {
            str3 = "BETTER_PLAYER_NOTIFICATION";
            NotificationChannel notificationChannel = new NotificationChannel("BETTER_PLAYER_NOTIFICATION", "BETTER_PLAYER_NOTIFICATION", 2);
            notificationChannel.setDescription("BETTER_PLAYER_NOTIFICATION");
            systemService = context.getSystemService((Class<Object>) NotificationManager.class);
            ((NotificationManager) systemService).createNotificationChannel(notificationChannel);
        }
        kotlin.jvm.internal.k.b(str3);
        f2.e a6 = new e.c(context, 20772077, str3).b(dVar).a();
        this.f11260j = a6;
        if (a6 != null) {
            y yVar = this.f11253c;
            if (yVar != null) {
                a6.u(new a2(yVar));
                a6.v(false);
                a6.w(false);
                a6.x(false);
            }
            MediaSessionCompat S = S(context);
            if (S != null) {
                a6.t(S.c());
            }
        }
        this.f11261k = new Handler(Looper.getMainLooper());
        Runnable runnable = new Runnable() { // from class: z2.d
            @Override // java.lang.Runnable
            public final void run() {
                e.U(e.this);
            }
        };
        this.f11262l = runnable;
        Handler handler = this.f11261k;
        if (handler != null) {
            kotlin.jvm.internal.k.b(runnable);
            handler.postDelayed(runnable, 0L);
        }
        c cVar = new c();
        this.f11263m = cVar;
        y yVar2 = this.f11253c;
        if (yVar2 != null) {
            yVar2.N(cVar);
        }
        y yVar3 = this.f11253c;
        if (yVar3 != null) {
            yVar3.l(0L);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !kotlin.jvm.internal.k.a(e.class, obj.getClass())) {
            return false;
        }
        e eVar = (e) obj;
        y yVar = this.f11253c;
        if (yVar == null ? eVar.f11253c != null : !kotlin.jvm.internal.k.a(yVar, eVar.f11253c)) {
            return false;
        }
        Surface surface = this.f11258h;
        Surface surface2 = eVar.f11258h;
        return surface != null ? kotlin.jvm.internal.k.a(surface, surface2) : surface2 == null;
    }

    public int hashCode() {
        y yVar = this.f11253c;
        int i6 = 0;
        int hashCode = (yVar != null ? yVar.hashCode() : 0) * 31;
        Surface surface = this.f11258h;
        if (surface != null && surface != null) {
            i6 = surface.hashCode();
        }
        return hashCode + i6;
    }

    public final void w() {
        y yVar;
        x();
        y();
        if (this.f11257g && (yVar = this.f11253c) != null) {
            yVar.b();
        }
        this.f11252b.a();
        this.f11251a.d(null);
        Surface surface = this.f11258h;
        if (surface != null) {
            surface.release();
        }
        y yVar2 = this.f11253c;
        if (yVar2 != null) {
            yVar2.a();
        }
        W(false);
    }

    public final void x() {
        MediaSessionCompat mediaSessionCompat = this.f11265o;
        if (mediaSessionCompat != null && mediaSessionCompat != null) {
            mediaSessionCompat.e();
        }
        this.f11265o = null;
    }

    public final void y() {
        y yVar;
        o3.d dVar = this.f11263m;
        if (dVar != null && (yVar = this.f11253c) != null) {
            yVar.W(dVar);
        }
        Handler handler = this.f11261k;
        if (handler != null) {
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            this.f11261k = null;
            this.f11262l = null;
        }
        f2.e eVar = this.f11260j;
        if (eVar != null && eVar != null) {
            eVar.u(null);
        }
        this.f11264n = null;
    }

    public final long z() {
        y yVar = this.f11253c;
        m4 T = yVar != null ? yVar.T() : null;
        if (T != null && !T.u()) {
            long j6 = T.r(0, new m4.d()).f4696j;
            y yVar2 = this.f11253c;
            return j6 + (yVar2 != null ? yVar2.e0() : 0L);
        }
        y yVar3 = this.f11253c;
        if (yVar3 != null) {
            return yVar3.e0();
        }
        return 0L;
    }
}
