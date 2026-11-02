package z2;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.util.Log;
import g2.u;
import g2.v;
import h0.y1;
import i2.c1;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import m0.d0;
import m0.g0;
import m0.h;
import m0.o0;
import m0.u0;
import m0.v0;
import m0.w;

/* loaded from: classes.dex */
public final class s {

    /* renamed from: e, reason: collision with root package name */
    public static final a f11325e = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private Context f11326a;

    /* renamed from: b, reason: collision with root package name */
    private SharedPreferences f11327b;

    /* renamed from: c, reason: collision with root package name */
    private final v.b f11328c;

    /* renamed from: d, reason: collision with root package name */
    private final q2.e f11329d;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public s(Context context) {
        kotlin.jvm.internal.k.e(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences("BETTER_PLAYER_OFFLINE", 0);
        kotlin.jvm.internal.k.d(sharedPreferences, "context.getSharedPrefere…E\", Context.MODE_PRIVATE)");
        this.f11327b = sharedPreferences;
        this.f11328c = new v.b();
        this.f11329d = new q2.f().d("yyyy-MM-dd HH:mm:ss").c(byte[].class, new a3.a()).b();
        this.f11326a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final g0 c(UUID uuid) {
        try {
            kotlin.jvm.internal.k.b(uuid);
            o0 D = o0.D(uuid);
            kotlin.jvm.internal.k.d(D, "newInstance(uuid!!)");
            D.E("securityLevel", "L3");
            return D;
        } catch (v0 unused) {
            return new d0();
        }
    }

    public final byte[] b(String licenseUrl, Map<String, String> map, String path, String licenseId) {
        String w5;
        kotlin.jvm.internal.k.e(licenseUrl, "licenseUrl");
        kotlin.jvm.internal.k.e(path, "path");
        kotlin.jvm.internal.k.e(licenseId, "licenseId");
        byte[] bArr = null;
        if (c1.f5548a < 18) {
            Log.e("OfflineLicenseManager", "Protected content not supported on API levels below 18");
            return null;
        }
        u a6 = new u.a(this.f11326a).a();
        kotlin.jvm.internal.k.d(a6, "dataSourceFactory.createDataSource()");
        w5 = v4.p.w(String.valueOf(path), "file://", "", false, 4, null);
        Uri fromFile = Uri.fromFile(new File(w5));
        kotlin.jvm.internal.k.d(fromFile, "fromFile(manifestFile)");
        p1.c f6 = o1.g.f(a6, fromFile);
        kotlin.jvm.internal.k.d(f6, "loadManifest(\n          …manifestUri\n            )");
        y1 c6 = o1.g.c(a6, f6.d(0));
        UUID V = c1.V("widevine");
        p pVar = new p(licenseUrl, map);
        h.b bVar = new h.b();
        kotlin.jvm.internal.k.b(V);
        m0.h a7 = bVar.f(V, new g0.c() { // from class: z2.r
            @Override // m0.g0.c
            public final g0 a(UUID uuid) {
                g0 c7;
                c7 = s.c(uuid);
                return c7;
            }
        }).c(true).a(pVar);
        kotlin.jvm.internal.k.d(a7, "Builder()\n              … .build(mediaDrmCallback)");
        u0 u0Var = new u0(a7, new w.a());
        if (this.f11327b.contains(licenseId)) {
            b3.a d6 = d(licenseId);
            Log.i("OfflineLicenseManager", ">>> licenseData defined in: " + d6);
            if (d6 != null) {
                bArr = d6.a();
            }
        } else if (c6 != null) {
            bArr = u0Var.c(c6);
            b3.a aVar = new b3.a(licenseId, new Date(), licenseUrl, bArr);
            SharedPreferences.Editor edit = this.f11327b.edit();
            edit.putString(licenseId, this.f11329d.q(aVar));
            edit.apply();
            Log.i("OfflineLicenseManager", ">>> licenseData downloaded to: " + aVar);
        }
        if (bArr != null) {
            a7.G(1, bArr);
            u0Var.j(bArr);
            u0Var.i();
            Log.i("OfflineLicenseManager", ">>> drmSessionManager updated with " + bArr + ", and licenseHelper released");
        }
        return bArr;
    }

    public final b3.a d(String licenseId) {
        kotlin.jvm.internal.k.e(licenseId, "licenseId");
        if (!this.f11327b.contains(licenseId)) {
            return null;
        }
        try {
            return (b3.a) this.f11329d.h(this.f11327b.getString(licenseId, ""), b3.a.class);
        } catch (q2.o unused) {
            return null;
        }
    }

    public final List<b3.a> e(int i6) {
        ArrayList arrayList = new ArrayList();
        SharedPreferences.Editor edit = this.f11327b.edit();
        Map<String, ?> all = this.f11327b.getAll();
        kotlin.jvm.internal.k.d(all, "preferences.all");
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            try {
                b3.a aVar = (b3.a) this.f11329d.h(this.f11327b.getString(entry.getKey(), ""), b3.a.class);
                if (aVar.c() != null) {
                    Date c6 = aVar.c();
                    kotlin.jvm.internal.k.b(c6);
                    if (c6.getTime() + (86400 * i6 * 1000) < System.currentTimeMillis()) {
                        arrayList.add(aVar);
                    }
                }
            } catch (q2.o unused) {
                edit.remove(entry.getKey());
                edit.apply();
            }
        }
        return arrayList;
    }

    public final Long f(String licenseId) {
        kotlin.jvm.internal.k.e(licenseId, "licenseId");
        b3.a d6 = d(licenseId);
        if (d6 == null) {
            return null;
        }
        String b6 = d6.b();
        kotlin.jvm.internal.k.b(b6);
        u0 e6 = u0.e(b6, this.f11328c, new w.a());
        kotlin.jvm.internal.k.d(e6, "newWidevineInstance(\n   …ispatcher()\n            )");
        byte[] a6 = d6.a();
        kotlin.jvm.internal.k.b(a6);
        Long l6 = (Long) e6.d(a6).first;
        e6.i();
        return l6;
    }

    public final boolean g(String licenseId) {
        kotlin.jvm.internal.k.e(licenseId, "licenseId");
        if (!this.f11327b.contains(licenseId)) {
            return false;
        }
        SharedPreferences.Editor edit = this.f11327b.edit();
        edit.remove(licenseId);
        edit.apply();
        return true;
    }
}
