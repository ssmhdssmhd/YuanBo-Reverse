package m0;

import android.net.Uri;
import android.text.TextUtils;
import g2.m;
import g2.q;
import i2.c1;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import m0.g0;

/* loaded from: classes.dex */
public final class p0 implements s0 {

    /* renamed from: a, reason: collision with root package name */
    private final m.a f7864a;

    /* renamed from: b, reason: collision with root package name */
    private final String f7865b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f7866c;

    /* renamed from: d, reason: collision with root package name */
    private final Map<String, String> f7867d;

    public p0(String str, m.a aVar) {
        this(str, false, aVar);
    }

    public p0(String str, boolean z5, m.a aVar) {
        i2.a.a((z5 && TextUtils.isEmpty(str)) ? false : true);
        this.f7864a = aVar;
        this.f7865b = str;
        this.f7866c = z5;
        this.f7867d = new HashMap();
    }

    private static byte[] c(m.a aVar, String str, byte[] bArr, Map<String, String> map) {
        g2.s0 s0Var = new g2.s0(aVar.a());
        g2.q a6 = new q.b().j(str).e(map).d(2).c(bArr).b(1).a();
        int i6 = 0;
        g2.q qVar = a6;
        while (true) {
            try {
                g2.o oVar = new g2.o(s0Var, qVar);
                try {
                    return c1.Z0(oVar);
                } catch (g2.d0 e6) {
                    String d6 = d(e6, i6);
                    if (d6 == null) {
                        throw e6;
                    }
                    i6++;
                    qVar = qVar.a().j(d6).a();
                } finally {
                    c1.n(oVar);
                }
            } catch (Exception e7) {
                throw new t0(a6, (Uri) i2.a.e(s0Var.p()), s0Var.f(), s0Var.o(), e7);
            }
        }
    }

    private static String d(g2.d0 d0Var, int i6) {
        Map<String, List<String>> map;
        List<String> list;
        int i7 = d0Var.f4012d;
        if (!((i7 == 307 || i7 == 308) && i6 < 5) || (map = d0Var.f4014j) == null || (list = map.get("Location")) == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override // m0.s0
    public byte[] a(UUID uuid, g0.a aVar) {
        String b6 = aVar.b();
        if (this.f7866c || TextUtils.isEmpty(b6)) {
            b6 = this.f7865b;
        }
        if (TextUtils.isEmpty(b6)) {
            throw new t0(new q.b().i(Uri.EMPTY).a(), Uri.EMPTY, m2.r.j(), 0L, new IllegalStateException("No license URL"));
        }
        HashMap hashMap = new HashMap();
        UUID uuid2 = h0.p.f4775e;
        hashMap.put("Content-Type", uuid2.equals(uuid) ? "text/xml" : h0.p.f4773c.equals(uuid) ? "application/json" : "application/octet-stream");
        if (uuid2.equals(uuid)) {
            hashMap.put("SOAPAction", "http://schemas.microsoft.com/DRM/2007/03/protocols/AcquireLicense");
        }
        synchronized (this.f7867d) {
            hashMap.putAll(this.f7867d);
        }
        return c(this.f7864a, b6, aVar.a(), hashMap);
    }

    @Override // m0.s0
    public byte[] b(UUID uuid, g0.d dVar) {
        return c(this.f7864a, dVar.b() + "&signedRequest=" + c1.D(dVar.a()), null, Collections.emptyMap());
    }

    public void e(String str, String str2) {
        i2.a.e(str);
        i2.a.e(str2);
        synchronized (this.f7867d) {
            this.f7867d.put(str, str2);
        }
    }
}
