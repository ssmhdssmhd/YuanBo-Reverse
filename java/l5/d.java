package l5;

import f4.t;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import q5.a0;
import q5.o;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private static final c[] f7536a;

    /* renamed from: b, reason: collision with root package name */
    private static final Map<q5.h, Integer> f7537b;

    /* renamed from: c, reason: collision with root package name */
    public static final d f7538c;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final List<c> f7539a;

        /* renamed from: b, reason: collision with root package name */
        private final q5.g f7540b;

        /* renamed from: c, reason: collision with root package name */
        public c[] f7541c;

        /* renamed from: d, reason: collision with root package name */
        private int f7542d;

        /* renamed from: e, reason: collision with root package name */
        public int f7543e;

        /* renamed from: f, reason: collision with root package name */
        public int f7544f;

        /* renamed from: g, reason: collision with root package name */
        private final int f7545g;

        /* renamed from: h, reason: collision with root package name */
        private int f7546h;

        public a(a0 source, int i6, int i7) {
            kotlin.jvm.internal.k.e(source, "source");
            this.f7545g = i6;
            this.f7546h = i7;
            this.f7539a = new ArrayList();
            this.f7540b = o.b(source);
            this.f7541c = new c[8];
            this.f7542d = r2.length - 1;
        }

        public /* synthetic */ a(a0 a0Var, int i6, int i7, int i8, kotlin.jvm.internal.g gVar) {
            this(a0Var, i6, (i8 & 4) != 0 ? i6 : i7);
        }

        private final void a() {
            int i6 = this.f7546h;
            int i7 = this.f7544f;
            if (i6 < i7) {
                if (i6 == 0) {
                    b();
                } else {
                    d(i7 - i6);
                }
            }
        }

        private final void b() {
            f4.g.i(this.f7541c, null, 0, 0, 6, null);
            this.f7542d = this.f7541c.length - 1;
            this.f7543e = 0;
            this.f7544f = 0;
        }

        private final int c(int i6) {
            return this.f7542d + 1 + i6;
        }

        private final int d(int i6) {
            int i7;
            int i8 = 0;
            if (i6 > 0) {
                int length = this.f7541c.length;
                while (true) {
                    length--;
                    i7 = this.f7542d;
                    if (length < i7 || i6 <= 0) {
                        break;
                    }
                    c cVar = this.f7541c[length];
                    kotlin.jvm.internal.k.b(cVar);
                    int i9 = cVar.f7533a;
                    i6 -= i9;
                    this.f7544f -= i9;
                    this.f7543e--;
                    i8++;
                }
                c[] cVarArr = this.f7541c;
                System.arraycopy(cVarArr, i7 + 1, cVarArr, i7 + 1 + i8, this.f7543e);
                this.f7542d += i8;
            }
            return i8;
        }

        private final q5.h f(int i6) {
            c cVar;
            if (!h(i6)) {
                int c6 = c(i6 - d.f7538c.c().length);
                if (c6 >= 0) {
                    c[] cVarArr = this.f7541c;
                    if (c6 < cVarArr.length) {
                        cVar = cVarArr[c6];
                        kotlin.jvm.internal.k.b(cVar);
                    }
                }
                throw new IOException("Header index too large " + (i6 + 1));
            }
            cVar = d.f7538c.c()[i6];
            return cVar.f7534b;
        }

        private final void g(int i6, c cVar) {
            this.f7539a.add(cVar);
            int i7 = cVar.f7533a;
            if (i6 != -1) {
                c cVar2 = this.f7541c[c(i6)];
                kotlin.jvm.internal.k.b(cVar2);
                i7 -= cVar2.f7533a;
            }
            int i8 = this.f7546h;
            if (i7 > i8) {
                b();
                return;
            }
            int d6 = d((this.f7544f + i7) - i8);
            if (i6 == -1) {
                int i9 = this.f7543e + 1;
                c[] cVarArr = this.f7541c;
                if (i9 > cVarArr.length) {
                    c[] cVarArr2 = new c[cVarArr.length * 2];
                    System.arraycopy(cVarArr, 0, cVarArr2, cVarArr.length, cVarArr.length);
                    this.f7542d = this.f7541c.length - 1;
                    this.f7541c = cVarArr2;
                }
                int i10 = this.f7542d;
                this.f7542d = i10 - 1;
                this.f7541c[i10] = cVar;
                this.f7543e++;
            } else {
                this.f7541c[i6 + c(i6) + d6] = cVar;
            }
            this.f7544f += i7;
        }

        private final boolean h(int i6) {
            return i6 >= 0 && i6 <= d.f7538c.c().length - 1;
        }

        private final int i() {
            return e5.b.b(this.f7540b.readByte(), 255);
        }

        private final void l(int i6) {
            if (h(i6)) {
                this.f7539a.add(d.f7538c.c()[i6]);
                return;
            }
            int c6 = c(i6 - d.f7538c.c().length);
            if (c6 >= 0) {
                c[] cVarArr = this.f7541c;
                if (c6 < cVarArr.length) {
                    List<c> list = this.f7539a;
                    c cVar = cVarArr[c6];
                    kotlin.jvm.internal.k.b(cVar);
                    list.add(cVar);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i6 + 1));
        }

        private final void n(int i6) {
            g(-1, new c(f(i6), j()));
        }

        private final void o() {
            g(-1, new c(d.f7538c.a(j()), j()));
        }

        private final void p(int i6) {
            this.f7539a.add(new c(f(i6), j()));
        }

        private final void q() {
            this.f7539a.add(new c(d.f7538c.a(j()), j()));
        }

        public final List<c> e() {
            List<c> H = t.H(this.f7539a);
            this.f7539a.clear();
            return H;
        }

        public final q5.h j() {
            int i6 = i();
            boolean z5 = (i6 & 128) == 128;
            long m6 = m(i6, 127);
            if (!z5) {
                return this.f7540b.i(m6);
            }
            q5.e eVar = new q5.e();
            k.f7722d.b(this.f7540b, m6, eVar);
            return eVar.K();
        }

        public final void k() {
            while (!this.f7540b.y()) {
                int b6 = e5.b.b(this.f7540b.readByte(), 255);
                if (b6 == 128) {
                    throw new IOException("index == 0");
                }
                if ((b6 & 128) == 128) {
                    l(m(b6, 127) - 1);
                } else if (b6 == 64) {
                    o();
                } else if ((b6 & 64) == 64) {
                    n(m(b6, 63) - 1);
                } else if ((b6 & 32) == 32) {
                    int m6 = m(b6, 31);
                    this.f7546h = m6;
                    if (m6 < 0 || m6 > this.f7545g) {
                        throw new IOException("Invalid dynamic table size update " + this.f7546h);
                    }
                    a();
                } else if (b6 == 16 || b6 == 0) {
                    q();
                } else {
                    p(m(b6, 15) - 1);
                }
            }
        }

        public final int m(int i6, int i7) {
            int i8 = i6 & i7;
            if (i8 < i7) {
                return i8;
            }
            int i9 = 0;
            while (true) {
                int i10 = i();
                if ((i10 & 128) == 0) {
                    return i7 + (i10 << i9);
                }
                i7 += (i10 & 127) << i9;
                i9 += 7;
            }
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private int f7547a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f7548b;

        /* renamed from: c, reason: collision with root package name */
        public int f7549c;

        /* renamed from: d, reason: collision with root package name */
        public c[] f7550d;

        /* renamed from: e, reason: collision with root package name */
        private int f7551e;

        /* renamed from: f, reason: collision with root package name */
        public int f7552f;

        /* renamed from: g, reason: collision with root package name */
        public int f7553g;

        /* renamed from: h, reason: collision with root package name */
        public int f7554h;

        /* renamed from: i, reason: collision with root package name */
        private final boolean f7555i;

        /* renamed from: j, reason: collision with root package name */
        private final q5.e f7556j;

        public b(int i6, boolean z5, q5.e out) {
            kotlin.jvm.internal.k.e(out, "out");
            this.f7554h = i6;
            this.f7555i = z5;
            this.f7556j = out;
            this.f7547a = Integer.MAX_VALUE;
            this.f7549c = i6;
            this.f7550d = new c[8];
            this.f7551e = r2.length - 1;
        }

        public /* synthetic */ b(int i6, boolean z5, q5.e eVar, int i7, kotlin.jvm.internal.g gVar) {
            this((i7 & 1) != 0 ? 4096 : i6, (i7 & 2) != 0 ? true : z5, eVar);
        }

        private final void a() {
            int i6 = this.f7549c;
            int i7 = this.f7553g;
            if (i6 < i7) {
                if (i6 == 0) {
                    b();
                } else {
                    c(i7 - i6);
                }
            }
        }

        private final void b() {
            f4.g.i(this.f7550d, null, 0, 0, 6, null);
            this.f7551e = this.f7550d.length - 1;
            this.f7552f = 0;
            this.f7553g = 0;
        }

        private final int c(int i6) {
            int i7;
            int i8 = 0;
            if (i6 > 0) {
                int length = this.f7550d.length;
                while (true) {
                    length--;
                    i7 = this.f7551e;
                    if (length < i7 || i6 <= 0) {
                        break;
                    }
                    c cVar = this.f7550d[length];
                    kotlin.jvm.internal.k.b(cVar);
                    i6 -= cVar.f7533a;
                    int i9 = this.f7553g;
                    c cVar2 = this.f7550d[length];
                    kotlin.jvm.internal.k.b(cVar2);
                    this.f7553g = i9 - cVar2.f7533a;
                    this.f7552f--;
                    i8++;
                }
                c[] cVarArr = this.f7550d;
                System.arraycopy(cVarArr, i7 + 1, cVarArr, i7 + 1 + i8, this.f7552f);
                c[] cVarArr2 = this.f7550d;
                int i10 = this.f7551e;
                Arrays.fill(cVarArr2, i10 + 1, i10 + 1 + i8, (Object) null);
                this.f7551e += i8;
            }
            return i8;
        }

        private final void d(c cVar) {
            int i6 = cVar.f7533a;
            int i7 = this.f7549c;
            if (i6 > i7) {
                b();
                return;
            }
            c((this.f7553g + i6) - i7);
            int i8 = this.f7552f + 1;
            c[] cVarArr = this.f7550d;
            if (i8 > cVarArr.length) {
                c[] cVarArr2 = new c[cVarArr.length * 2];
                System.arraycopy(cVarArr, 0, cVarArr2, cVarArr.length, cVarArr.length);
                this.f7551e = this.f7550d.length - 1;
                this.f7550d = cVarArr2;
            }
            int i9 = this.f7551e;
            this.f7551e = i9 - 1;
            this.f7550d[i9] = cVar;
            this.f7552f++;
            this.f7553g += i6;
        }

        public final void e(int i6) {
            this.f7554h = i6;
            int min = Math.min(i6, 16384);
            int i7 = this.f7549c;
            if (i7 == min) {
                return;
            }
            if (min < i7) {
                this.f7547a = Math.min(this.f7547a, min);
            }
            this.f7548b = true;
            this.f7549c = min;
            a();
        }

        public final void f(q5.h data) {
            int r6;
            int i6;
            kotlin.jvm.internal.k.e(data, "data");
            if (this.f7555i) {
                k kVar = k.f7722d;
                if (kVar.d(data) < data.r()) {
                    q5.e eVar = new q5.e();
                    kVar.c(data, eVar);
                    data = eVar.K();
                    r6 = data.r();
                    i6 = 128;
                    h(r6, 127, i6);
                    this.f7556j.E(data);
                }
            }
            r6 = data.r();
            i6 = 0;
            h(r6, 127, i6);
            this.f7556j.E(data);
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0080  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00c6  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00ce  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void g(java.util.List<l5.c> r14) {
            /*
                Method dump skipped, instructions count: 263
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: l5.d.b.g(java.util.List):void");
        }

        public final void h(int i6, int i7, int i8) {
            int i9;
            q5.e eVar;
            if (i6 < i7) {
                eVar = this.f7556j;
                i9 = i6 | i8;
            } else {
                this.f7556j.writeByte(i8 | i7);
                i9 = i6 - i7;
                while (i9 >= 128) {
                    this.f7556j.writeByte(128 | (i9 & 127));
                    i9 >>>= 7;
                }
                eVar = this.f7556j;
            }
            eVar.writeByte(i9);
        }
    }

    static {
        d dVar = new d();
        f7538c = dVar;
        q5.h hVar = c.f7528f;
        q5.h hVar2 = c.f7529g;
        q5.h hVar3 = c.f7530h;
        q5.h hVar4 = c.f7527e;
        f7536a = new c[]{new c(c.f7531i, ""), new c(hVar, "GET"), new c(hVar, "POST"), new c(hVar2, "/"), new c(hVar2, "/index.html"), new c(hVar3, "http"), new c(hVar3, "https"), new c(hVar4, "200"), new c(hVar4, "204"), new c(hVar4, "206"), new c(hVar4, "304"), new c(hVar4, "400"), new c(hVar4, "404"), new c(hVar4, "500"), new c("accept-charset", ""), new c("accept-encoding", "gzip, deflate"), new c("accept-language", ""), new c("accept-ranges", ""), new c("accept", ""), new c("access-control-allow-origin", ""), new c("age", ""), new c("allow", ""), new c("authorization", ""), new c("cache-control", ""), new c("content-disposition", ""), new c("content-encoding", ""), new c("content-language", ""), new c("content-length", ""), new c("content-location", ""), new c("content-range", ""), new c("content-type", ""), new c("cookie", ""), new c("date", ""), new c("etag", ""), new c("expect", ""), new c("expires", ""), new c("from", ""), new c("host", ""), new c("if-match", ""), new c("if-modified-since", ""), new c("if-none-match", ""), new c("if-range", ""), new c("if-unmodified-since", ""), new c("last-modified", ""), new c("link", ""), new c("location", ""), new c("max-forwards", ""), new c("proxy-authenticate", ""), new c("proxy-authorization", ""), new c("range", ""), new c("referer", ""), new c("refresh", ""), new c("retry-after", ""), new c("server", ""), new c("set-cookie", ""), new c("strict-transport-security", ""), new c("transfer-encoding", ""), new c("user-agent", ""), new c("vary", ""), new c("via", ""), new c("www-authenticate", "")};
        f7537b = dVar.d();
    }

    private d() {
    }

    private final Map<q5.h, Integer> d() {
        c[] cVarArr = f7536a;
        LinkedHashMap linkedHashMap = new LinkedHashMap(cVarArr.length);
        int length = cVarArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            c[] cVarArr2 = f7536a;
            if (!linkedHashMap.containsKey(cVarArr2[i6].f7534b)) {
                linkedHashMap.put(cVarArr2[i6].f7534b, Integer.valueOf(i6));
            }
        }
        Map<q5.h, Integer> unmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        kotlin.jvm.internal.k.d(unmodifiableMap, "Collections.unmodifiableMap(result)");
        return unmodifiableMap;
    }

    public final q5.h a(q5.h name) {
        kotlin.jvm.internal.k.e(name, "name");
        int r6 = name.r();
        for (int i6 = 0; i6 < r6; i6++) {
            byte b6 = (byte) 65;
            byte b7 = (byte) 90;
            byte d6 = name.d(i6);
            if (b6 <= d6 && b7 >= d6) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + name.u());
            }
        }
        return name;
    }

    public final Map<q5.h, Integer> b() {
        return f7537b;
    }

    public final c[] c() {
        return f7536a;
    }
}
