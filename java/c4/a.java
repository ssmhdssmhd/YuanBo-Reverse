package c4;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class a {

    public interface b {
        void a();

        h c(i iVar);

        void d(f fVar);

        void e(i iVar);

        void f(h hVar);

        void g(j jVar);

        void h(i iVar);

        void i(i iVar);

        void k(g gVar);

        i l(d dVar);

        void m(e eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class c extends y3.q {

        /* renamed from: d, reason: collision with root package name */
        public static final c f1827d = new c();

        private c() {
        }

        @Override // y3.q
        protected Object g(byte b6, ByteBuffer byteBuffer) {
            switch (b6) {
                case Byte.MIN_VALUE:
                    return d.a((Map) f(byteBuffer));
                case -127:
                    return e.a((Map) f(byteBuffer));
                case -126:
                    return f.a((Map) f(byteBuffer));
                case -125:
                    return g.a((Map) f(byteBuffer));
                case -124:
                    return h.a((Map) f(byteBuffer));
                case -123:
                    return i.a((Map) f(byteBuffer));
                case -122:
                    return j.a((Map) f(byteBuffer));
                default:
                    return super.g(b6, byteBuffer);
            }
        }

        @Override // y3.q
        protected void p(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            Map<String, Object> d6;
            if (obj instanceof d) {
                byteArrayOutputStream.write(128);
                d6 = ((d) obj).l();
            } else if (obj instanceof e) {
                byteArrayOutputStream.write(129);
                d6 = ((e) obj).f();
            } else if (obj instanceof f) {
                byteArrayOutputStream.write(130);
                d6 = ((f) obj).d();
            } else if (obj instanceof g) {
                byteArrayOutputStream.write(131);
                d6 = ((g) obj).f();
            } else if (obj instanceof h) {
                byteArrayOutputStream.write(132);
                d6 = ((h) obj).f();
            } else {
                if (!(obj instanceof i)) {
                    if (!(obj instanceof j)) {
                        super.p(byteArrayOutputStream, obj);
                        return;
                    } else {
                        byteArrayOutputStream.write(134);
                        p(byteArrayOutputStream, ((j) obj).f());
                        return;
                    }
                }
                byteArrayOutputStream.write(133);
                d6 = ((i) obj).d();
            }
            p(byteArrayOutputStream, d6);
        }
    }

    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private String f1828a;

        /* renamed from: b, reason: collision with root package name */
        private String f1829b;

        /* renamed from: c, reason: collision with root package name */
        private String f1830c;

        /* renamed from: d, reason: collision with root package name */
        private String f1831d;

        /* renamed from: e, reason: collision with root package name */
        private Map<String, String> f1832e;

        private d() {
        }

        static d a(Map<String, Object> map) {
            d dVar = new d();
            dVar.g((String) map.get("asset"));
            dVar.k((String) map.get("uri"));
            dVar.j((String) map.get("packageName"));
            dVar.h((String) map.get("formatHint"));
            dVar.i((Map) map.get("httpHeaders"));
            return dVar;
        }

        public String b() {
            return this.f1828a;
        }

        public String c() {
            return this.f1831d;
        }

        public Map<String, String> d() {
            return this.f1832e;
        }

        public String e() {
            return this.f1830c;
        }

        public String f() {
            return this.f1829b;
        }

        public void g(String str) {
            this.f1828a = str;
        }

        public void h(String str) {
            this.f1831d = str;
        }

        public void i(Map<String, String> map) {
            if (map == null) {
                throw new IllegalStateException("Nonnull field \"httpHeaders\" is null.");
            }
            this.f1832e = map;
        }

        public void j(String str) {
            this.f1830c = str;
        }

        public void k(String str) {
            this.f1829b = str;
        }

        Map<String, Object> l() {
            HashMap hashMap = new HashMap();
            hashMap.put("asset", this.f1828a);
            hashMap.put("uri", this.f1829b);
            hashMap.put("packageName", this.f1830c);
            hashMap.put("formatHint", this.f1831d);
            hashMap.put("httpHeaders", this.f1832e);
            return hashMap;
        }
    }

    public static class e {

        /* renamed from: a, reason: collision with root package name */
        private Long f1833a;

        /* renamed from: b, reason: collision with root package name */
        private Boolean f1834b;

        private e() {
        }

        static e a(Map<String, Object> map) {
            Long valueOf;
            e eVar = new e();
            Object obj = map.get("textureId");
            if (obj == null) {
                valueOf = null;
            } else {
                valueOf = Long.valueOf(obj instanceof Integer ? ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            eVar.e(valueOf);
            eVar.d((Boolean) map.get("isLooping"));
            return eVar;
        }

        public Boolean b() {
            return this.f1834b;
        }

        public Long c() {
            return this.f1833a;
        }

        public void d(Boolean bool) {
            if (bool == null) {
                throw new IllegalStateException("Nonnull field \"isLooping\" is null.");
            }
            this.f1834b = bool;
        }

        public void e(Long l6) {
            if (l6 == null) {
                throw new IllegalStateException("Nonnull field \"textureId\" is null.");
            }
            this.f1833a = l6;
        }

        Map<String, Object> f() {
            HashMap hashMap = new HashMap();
            hashMap.put("textureId", this.f1833a);
            hashMap.put("isLooping", this.f1834b);
            return hashMap;
        }
    }

    public static class f {

        /* renamed from: a, reason: collision with root package name */
        private Boolean f1835a;

        private f() {
        }

        static f a(Map<String, Object> map) {
            f fVar = new f();
            fVar.c((Boolean) map.get("mixWithOthers"));
            return fVar;
        }

        public Boolean b() {
            return this.f1835a;
        }

        public void c(Boolean bool) {
            if (bool == null) {
                throw new IllegalStateException("Nonnull field \"mixWithOthers\" is null.");
            }
            this.f1835a = bool;
        }

        Map<String, Object> d() {
            HashMap hashMap = new HashMap();
            hashMap.put("mixWithOthers", this.f1835a);
            return hashMap;
        }
    }

    public static class g {

        /* renamed from: a, reason: collision with root package name */
        private Long f1836a;

        /* renamed from: b, reason: collision with root package name */
        private Double f1837b;

        private g() {
        }

        static g a(Map<String, Object> map) {
            Long valueOf;
            g gVar = new g();
            Object obj = map.get("textureId");
            if (obj == null) {
                valueOf = null;
            } else {
                valueOf = Long.valueOf(obj instanceof Integer ? ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            gVar.e(valueOf);
            gVar.d((Double) map.get("speed"));
            return gVar;
        }

        public Double b() {
            return this.f1837b;
        }

        public Long c() {
            return this.f1836a;
        }

        public void d(Double d6) {
            if (d6 == null) {
                throw new IllegalStateException("Nonnull field \"speed\" is null.");
            }
            this.f1837b = d6;
        }

        public void e(Long l6) {
            if (l6 == null) {
                throw new IllegalStateException("Nonnull field \"textureId\" is null.");
            }
            this.f1836a = l6;
        }

        Map<String, Object> f() {
            HashMap hashMap = new HashMap();
            hashMap.put("textureId", this.f1836a);
            hashMap.put("speed", this.f1837b);
            return hashMap;
        }
    }

    public static class h {

        /* renamed from: a, reason: collision with root package name */
        private Long f1838a;

        /* renamed from: b, reason: collision with root package name */
        private Long f1839b;

        /* renamed from: c4.a$h$a, reason: collision with other inner class name */
        public static class C0042a {

            /* renamed from: a, reason: collision with root package name */
            private Long f1840a;

            /* renamed from: b, reason: collision with root package name */
            private Long f1841b;

            public h a() {
                h hVar = new h();
                hVar.e(this.f1840a);
                hVar.d(this.f1841b);
                return hVar;
            }

            public C0042a b(Long l6) {
                this.f1841b = l6;
                return this;
            }

            public C0042a c(Long l6) {
                this.f1840a = l6;
                return this;
            }
        }

        private h() {
        }

        static h a(Map<String, Object> map) {
            Long valueOf;
            h hVar = new h();
            Object obj = map.get("textureId");
            Long l6 = null;
            if (obj == null) {
                valueOf = null;
            } else {
                valueOf = Long.valueOf(obj instanceof Integer ? ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            hVar.e(valueOf);
            Object obj2 = map.get("position");
            if (obj2 != null) {
                l6 = Long.valueOf(obj2 instanceof Integer ? ((Integer) obj2).intValue() : ((Long) obj2).longValue());
            }
            hVar.d(l6);
            return hVar;
        }

        public Long b() {
            return this.f1839b;
        }

        public Long c() {
            return this.f1838a;
        }

        public void d(Long l6) {
            if (l6 == null) {
                throw new IllegalStateException("Nonnull field \"position\" is null.");
            }
            this.f1839b = l6;
        }

        public void e(Long l6) {
            if (l6 == null) {
                throw new IllegalStateException("Nonnull field \"textureId\" is null.");
            }
            this.f1838a = l6;
        }

        Map<String, Object> f() {
            HashMap hashMap = new HashMap();
            hashMap.put("textureId", this.f1838a);
            hashMap.put("position", this.f1839b);
            return hashMap;
        }
    }

    public static class i {

        /* renamed from: a, reason: collision with root package name */
        private Long f1842a;

        /* renamed from: c4.a$i$a, reason: collision with other inner class name */
        public static class C0043a {

            /* renamed from: a, reason: collision with root package name */
            private Long f1843a;

            public i a() {
                i iVar = new i();
                iVar.c(this.f1843a);
                return iVar;
            }

            public C0043a b(Long l6) {
                this.f1843a = l6;
                return this;
            }
        }

        private i() {
        }

        static i a(Map<String, Object> map) {
            Long valueOf;
            i iVar = new i();
            Object obj = map.get("textureId");
            if (obj == null) {
                valueOf = null;
            } else {
                valueOf = Long.valueOf(obj instanceof Integer ? ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            iVar.c(valueOf);
            return iVar;
        }

        public Long b() {
            return this.f1842a;
        }

        public void c(Long l6) {
            if (l6 == null) {
                throw new IllegalStateException("Nonnull field \"textureId\" is null.");
            }
            this.f1842a = l6;
        }

        Map<String, Object> d() {
            HashMap hashMap = new HashMap();
            hashMap.put("textureId", this.f1842a);
            return hashMap;
        }
    }

    public static class j {

        /* renamed from: a, reason: collision with root package name */
        private Long f1844a;

        /* renamed from: b, reason: collision with root package name */
        private Double f1845b;

        private j() {
        }

        static j a(Map<String, Object> map) {
            Long valueOf;
            j jVar = new j();
            Object obj = map.get("textureId");
            if (obj == null) {
                valueOf = null;
            } else {
                valueOf = Long.valueOf(obj instanceof Integer ? ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            jVar.d(valueOf);
            jVar.e((Double) map.get("volume"));
            return jVar;
        }

        public Long b() {
            return this.f1844a;
        }

        public Double c() {
            return this.f1845b;
        }

        public void d(Long l6) {
            if (l6 == null) {
                throw new IllegalStateException("Nonnull field \"textureId\" is null.");
            }
            this.f1844a = l6;
        }

        public void e(Double d6) {
            if (d6 == null) {
                throw new IllegalStateException("Nonnull field \"volume\" is null.");
            }
            this.f1845b = d6;
        }

        Map<String, Object> f() {
            HashMap hashMap = new HashMap();
            hashMap.put("textureId", this.f1844a);
            hashMap.put("volume", this.f1845b);
            return hashMap;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<String, Object> b(Throwable th) {
        HashMap hashMap = new HashMap();
        hashMap.put("message", th.toString());
        hashMap.put("code", th.getClass().getSimpleName());
        hashMap.put("details", "Cause: " + th.getCause() + ", Stacktrace: " + Log.getStackTraceString(th));
        return hashMap;
    }
}
