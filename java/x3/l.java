package x3;

import com.tendcloud.tenddata.cs;
import java.util.HashMap;
import java.util.Map;
import y3.k;
import y3.r;

/* loaded from: classes.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f10589a;

    /* renamed from: b, reason: collision with root package name */
    private byte[] f10590b;

    /* renamed from: c, reason: collision with root package name */
    private y3.k f10591c;

    /* renamed from: d, reason: collision with root package name */
    private k.d f10592d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f10593e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f10594f;

    /* renamed from: g, reason: collision with root package name */
    private final k.c f10595g;

    class a implements k.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ byte[] f10596a;

        a(byte[] bArr) {
            this.f10596a = bArr;
        }

        @Override // y3.k.d
        public void a(String str, String str2, Object obj) {
            k3.b.b("RestorationChannel", "Error " + str + " while sending restoration data to framework: " + str2);
        }

        @Override // y3.k.d
        public void b(Object obj) {
            l.this.f10590b = this.f10596a;
        }

        @Override // y3.k.d
        public void c() {
        }
    }

    class b implements k.c {
        b() {
        }

        @Override // y3.k.c
        public void e(y3.j jVar, k.d dVar) {
            Map i6;
            String str = jVar.f11100a;
            Object obj = jVar.f11101b;
            str.hashCode();
            if (str.equals("get")) {
                l.this.f10594f = true;
                if (!l.this.f10593e) {
                    l lVar = l.this;
                    if (lVar.f10589a) {
                        lVar.f10592d = dVar;
                        return;
                    }
                }
                l lVar2 = l.this;
                i6 = lVar2.i(lVar2.f10590b);
            } else if (!str.equals("put")) {
                dVar.c();
                return;
            } else {
                l.this.f10590b = (byte[]) obj;
                i6 = null;
            }
            dVar.b(i6);
        }
    }

    public l(m3.a aVar, boolean z5) {
        this(new y3.k(aVar, "flutter/restoration", r.f11115b), z5);
    }

    l(y3.k kVar, boolean z5) {
        this.f10593e = false;
        this.f10594f = false;
        b bVar = new b();
        this.f10595g = bVar;
        this.f10591c = kVar;
        this.f10589a = z5;
        kVar.e(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> i(byte[] bArr) {
        HashMap hashMap = new HashMap();
        hashMap.put("enabled", Boolean.TRUE);
        hashMap.put(cs.a.DATA, bArr);
        return hashMap;
    }

    public void g() {
        this.f10590b = null;
    }

    public byte[] h() {
        return this.f10590b;
    }

    public void j(byte[] bArr) {
        this.f10593e = true;
        k.d dVar = this.f10592d;
        if (dVar != null) {
            dVar.b(i(bArr));
            this.f10592d = null;
        } else if (this.f10594f) {
            this.f10591c.d("push", i(bArr), new a(bArr));
            return;
        }
        this.f10590b = bArr;
    }
}
