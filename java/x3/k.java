package x3;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import x3.k;
import y3.k;
import y3.r;

/* loaded from: classes.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private final y3.k f10551a;

    /* renamed from: b, reason: collision with root package name */
    private g f10552b;

    /* renamed from: c, reason: collision with root package name */
    private final k.c f10553c;

    class a implements k.c {
        a() {
        }

        private void b(y3.j jVar, k.d dVar) {
            try {
                k.this.f10552b.f(((Integer) jVar.b()).intValue());
                dVar.b(null);
            } catch (IllegalStateException e6) {
                dVar.a("error", k.c(e6), null);
            }
        }

        private void c(y3.j jVar, k.d dVar) {
            Map map = (Map) jVar.b();
            boolean z5 = true;
            boolean z6 = map.containsKey("hybrid") && ((Boolean) map.get("hybrid")).booleanValue();
            ByteBuffer wrap = map.containsKey("params") ? ByteBuffer.wrap((byte[]) map.get("params")) : null;
            try {
                if (z6) {
                    k.this.f10552b.g(new d(((Integer) map.get("id")).intValue(), (String) map.get("viewType"), 0.0d, 0.0d, 0.0d, 0.0d, ((Integer) map.get("direction")).intValue(), d.a.HYBRID_ONLY, wrap));
                } else {
                    if (!map.containsKey("hybridFallback") || !((Boolean) map.get("hybridFallback")).booleanValue()) {
                        z5 = false;
                    }
                    long e6 = k.this.f10552b.e(new d(((Integer) map.get("id")).intValue(), (String) map.get("viewType"), map.containsKey("top") ? ((Double) map.get("top")).doubleValue() : 0.0d, map.containsKey("left") ? ((Double) map.get("left")).doubleValue() : 0.0d, ((Double) map.get("width")).doubleValue(), ((Double) map.get("height")).doubleValue(), ((Integer) map.get("direction")).intValue(), z5 ? d.a.TEXTURE_WITH_HYBRID_FALLBACK : d.a.TEXTURE_WITH_VIRTUAL_FALLBACK, wrap));
                    if (e6 != -2) {
                        dVar.b(Long.valueOf(e6));
                        return;
                    } else if (!z5) {
                        throw new AssertionError("Platform view attempted to fall back to hybrid mode when not requested.");
                    }
                }
                dVar.b(null);
            } catch (IllegalStateException e7) {
                dVar.a("error", k.c(e7), null);
            }
        }

        private void d(y3.j jVar, k.d dVar) {
            try {
                k.this.f10552b.i(((Integer) ((Map) jVar.b()).get("id")).intValue());
                dVar.b(null);
            } catch (IllegalStateException e6) {
                dVar.a("error", k.c(e6), null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void f(k.d dVar, c cVar) {
            if (cVar == null) {
                dVar.a("error", "Failed to resize the platform view", null);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("width", Double.valueOf(cVar.f10555a));
            hashMap.put("height", Double.valueOf(cVar.f10556b));
            dVar.b(hashMap);
        }

        private void g(y3.j jVar, k.d dVar) {
            Map map = (Map) jVar.b();
            try {
                k.this.f10552b.b(((Integer) map.get("id")).intValue(), ((Double) map.get("top")).doubleValue(), ((Double) map.get("left")).doubleValue());
                dVar.b(null);
            } catch (IllegalStateException e6) {
                dVar.a("error", k.c(e6), null);
            }
        }

        private void h(y3.j jVar, final k.d dVar) {
            Map map = (Map) jVar.b();
            try {
                k.this.f10552b.h(new e(((Integer) map.get("id")).intValue(), ((Double) map.get("width")).doubleValue(), ((Double) map.get("height")).doubleValue()), new b() { // from class: x3.j
                    @Override // x3.k.b
                    public final void a(k.c cVar) {
                        k.a.f(k.d.this, cVar);
                    }
                });
            } catch (IllegalStateException e6) {
                dVar.a("error", k.c(e6), null);
            }
        }

        private void i(y3.j jVar, k.d dVar) {
            Map map = (Map) jVar.b();
            try {
                k.this.f10552b.c(((Integer) map.get("id")).intValue(), ((Integer) map.get("direction")).intValue());
                dVar.b(null);
            } catch (IllegalStateException e6) {
                dVar.a("error", k.c(e6), null);
            }
        }

        private void j(y3.j jVar, k.d dVar) {
            try {
                k.this.f10552b.a(((Boolean) jVar.b()).booleanValue());
                dVar.b(null);
            } catch (IllegalStateException e6) {
                dVar.a("error", k.c(e6), null);
            }
        }

        private void k(y3.j jVar, k.d dVar) {
            k.d dVar2;
            List list = (List) jVar.b();
            try {
                k.this.f10552b.d(new f(((Integer) list.get(0)).intValue(), (Number) list.get(1), (Number) list.get(2), ((Integer) list.get(3)).intValue(), ((Integer) list.get(4)).intValue(), list.get(5), list.get(6), ((Integer) list.get(7)).intValue(), ((Integer) list.get(8)).intValue(), (float) ((Double) list.get(9)).doubleValue(), (float) ((Double) list.get(10)).doubleValue(), ((Integer) list.get(11)).intValue(), ((Integer) list.get(12)).intValue(), ((Integer) list.get(13)).intValue(), ((Integer) list.get(14)).intValue(), ((Number) list.get(15)).longValue()));
                dVar2 = dVar;
            } catch (IllegalStateException e6) {
                e = e6;
                dVar2 = dVar;
            }
            try {
                dVar2.b(null);
            } catch (IllegalStateException e7) {
                e = e7;
                dVar2.a("error", k.c(e), null);
            }
        }

        @Override // y3.k.c
        public void e(y3.j jVar, k.d dVar) {
            if (k.this.f10552b == null) {
            }
            k3.b.f("PlatformViewsChannel", "Received '" + jVar.f11100a + "' message.");
            String str = jVar.f11100a;
            str.hashCode();
            switch (str) {
                case "create":
                    c(jVar, dVar);
                    break;
                case "offset":
                    g(jVar, dVar);
                    break;
                case "resize":
                    h(jVar, dVar);
                    break;
                case "clearFocus":
                    b(jVar, dVar);
                    break;
                case "synchronizeToNativeViewHierarchy":
                    j(jVar, dVar);
                    break;
                case "touch":
                    k(jVar, dVar);
                    break;
                case "setDirection":
                    i(jVar, dVar);
                    break;
                case "dispose":
                    d(jVar, dVar);
                    break;
                default:
                    dVar.c();
                    break;
            }
        }
    }

    public interface b {
        void a(c cVar);
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final int f10555a;

        /* renamed from: b, reason: collision with root package name */
        public final int f10556b;

        public c(int i6, int i7) {
            this.f10555a = i6;
            this.f10556b = i7;
        }
    }

    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final int f10557a;

        /* renamed from: b, reason: collision with root package name */
        public final String f10558b;

        /* renamed from: c, reason: collision with root package name */
        public final double f10559c;

        /* renamed from: d, reason: collision with root package name */
        public final double f10560d;

        /* renamed from: e, reason: collision with root package name */
        public final double f10561e;

        /* renamed from: f, reason: collision with root package name */
        public final double f10562f;

        /* renamed from: g, reason: collision with root package name */
        public final int f10563g;

        /* renamed from: h, reason: collision with root package name */
        public final a f10564h;

        /* renamed from: i, reason: collision with root package name */
        public final ByteBuffer f10565i;

        public enum a {
            TEXTURE_WITH_VIRTUAL_FALLBACK,
            TEXTURE_WITH_HYBRID_FALLBACK,
            HYBRID_ONLY
        }

        public d(int i6, String str, double d6, double d7, double d8, double d9, int i7, a aVar, ByteBuffer byteBuffer) {
            this.f10557a = i6;
            this.f10558b = str;
            this.f10561e = d6;
            this.f10562f = d7;
            this.f10559c = d8;
            this.f10560d = d9;
            this.f10563g = i7;
            this.f10564h = aVar;
            this.f10565i = byteBuffer;
        }
    }

    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public final int f10570a;

        /* renamed from: b, reason: collision with root package name */
        public final double f10571b;

        /* renamed from: c, reason: collision with root package name */
        public final double f10572c;

        public e(int i6, double d6, double d7) {
            this.f10570a = i6;
            this.f10571b = d6;
            this.f10572c = d7;
        }
    }

    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public final int f10573a;

        /* renamed from: b, reason: collision with root package name */
        public final Number f10574b;

        /* renamed from: c, reason: collision with root package name */
        public final Number f10575c;

        /* renamed from: d, reason: collision with root package name */
        public final int f10576d;

        /* renamed from: e, reason: collision with root package name */
        public final int f10577e;

        /* renamed from: f, reason: collision with root package name */
        public final Object f10578f;

        /* renamed from: g, reason: collision with root package name */
        public final Object f10579g;

        /* renamed from: h, reason: collision with root package name */
        public final int f10580h;

        /* renamed from: i, reason: collision with root package name */
        public final int f10581i;

        /* renamed from: j, reason: collision with root package name */
        public final float f10582j;

        /* renamed from: k, reason: collision with root package name */
        public final float f10583k;

        /* renamed from: l, reason: collision with root package name */
        public final int f10584l;

        /* renamed from: m, reason: collision with root package name */
        public final int f10585m;

        /* renamed from: n, reason: collision with root package name */
        public final int f10586n;

        /* renamed from: o, reason: collision with root package name */
        public final int f10587o;

        /* renamed from: p, reason: collision with root package name */
        public final long f10588p;

        public f(int i6, Number number, Number number2, int i7, int i8, Object obj, Object obj2, int i9, int i10, float f6, float f7, int i11, int i12, int i13, int i14, long j6) {
            this.f10573a = i6;
            this.f10574b = number;
            this.f10575c = number2;
            this.f10576d = i7;
            this.f10577e = i8;
            this.f10578f = obj;
            this.f10579g = obj2;
            this.f10580h = i9;
            this.f10581i = i10;
            this.f10582j = f6;
            this.f10583k = f7;
            this.f10584l = i11;
            this.f10585m = i12;
            this.f10586n = i13;
            this.f10587o = i14;
            this.f10588p = j6;
        }
    }

    public interface g {
        void a(boolean z5);

        void b(int i6, double d6, double d7);

        void c(int i6, int i7);

        void d(f fVar);

        long e(d dVar);

        void f(int i6);

        void g(d dVar);

        void h(e eVar, b bVar);

        void i(int i6);
    }

    public k(m3.a aVar) {
        a aVar2 = new a();
        this.f10553c = aVar2;
        y3.k kVar = new y3.k(aVar, "flutter/platform_views", r.f11115b);
        this.f10551a = kVar;
        kVar.e(aVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String c(Exception exc) {
        return k3.b.d(exc);
    }

    public void d(int i6) {
        y3.k kVar = this.f10551a;
        if (kVar == null) {
            return;
        }
        kVar.c("viewFocused", Integer.valueOf(i6));
    }

    public void e(g gVar) {
        this.f10552b = gVar;
    }
}
