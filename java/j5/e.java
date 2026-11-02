package j5;

import d5.b0;
import d5.n;
import d5.t;
import d5.u;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;
import m5.m;
import q5.h;
import v4.p;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private static final q5.h f6830a;

    /* renamed from: b, reason: collision with root package name */
    private static final q5.h f6831b;

    static {
        h.a aVar = q5.h.f8959e;
        f6830a = aVar.c("\"\\");
        f6831b = aVar.c("\t ,=");
    }

    public static final List<d5.g> a(t parseChallenges, String headerName) {
        boolean o6;
        kotlin.jvm.internal.k.e(parseChallenges, "$this$parseChallenges");
        kotlin.jvm.internal.k.e(headerName, "headerName");
        ArrayList arrayList = new ArrayList();
        int size = parseChallenges.size();
        for (int i6 = 0; i6 < size; i6++) {
            o6 = p.o(headerName, parseChallenges.c(i6), true);
            if (o6) {
                try {
                    c(new q5.e().Q(parseChallenges.e(i6)), arrayList);
                } catch (EOFException e6) {
                    m.f8137c.g().j("Unable to parse challenge", 5, e6);
                }
            }
        }
        return arrayList;
    }

    public static final boolean b(b0 promisesBody) {
        boolean o6;
        kotlin.jvm.internal.k.e(promisesBody, "$this$promisesBody");
        if (kotlin.jvm.internal.k.a(promisesBody.Y().g(), "HEAD")) {
            return false;
        }
        int s5 = promisesBody.s();
        if (((s5 >= 100 && s5 < 200) || s5 == 204 || s5 == 304) && e5.b.r(promisesBody) == -1) {
            o6 = p.o("chunked", b0.F(promisesBody, "Transfer-Encoding", null, 2, null), true);
            if (!o6) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0085, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0085, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void c(q5.e r7, java.util.List<d5.g> r8) {
        /*
            r0 = 0
        L1:
            r1 = r0
        L2:
            if (r1 != 0) goto Le
            g(r7)
            java.lang.String r1 = e(r7)
            if (r1 != 0) goto Le
            return
        Le:
            boolean r2 = g(r7)
            java.lang.String r3 = e(r7)
            if (r3 != 0) goto L2c
            boolean r7 = r7.y()
            if (r7 != 0) goto L1f
            return
        L1f:
            d5.g r7 = new d5.g
            java.util.Map r0 = f4.z.d()
            r7.<init>(r1, r0)
            r8.add(r7)
            return
        L2c:
            r4 = 61
            byte r4 = (byte) r4
            int r5 = e5.b.E(r7, r4)
            boolean r6 = g(r7)
            if (r2 != 0) goto L68
            if (r6 != 0) goto L41
            boolean r2 = r7.y()
            if (r2 == 0) goto L68
        L41:
            d5.g r2 = new d5.g
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r3)
            java.lang.String r3 = "="
            java.lang.String r3 = v4.g.s(r3, r5)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            java.util.Map r3 = java.util.Collections.singletonMap(r0, r3)
            java.lang.String r4 = "Collections.singletonMap…ek + \"=\".repeat(eqCount))"
            kotlin.jvm.internal.k.d(r3, r4)
            r2.<init>(r1, r3)
            r8.add(r2)
            goto L1
        L68:
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
            r2.<init>()
            int r6 = e5.b.E(r7, r4)
            int r5 = r5 + r6
        L72:
            if (r3 != 0) goto L83
            java.lang.String r3 = e(r7)
            boolean r5 = g(r7)
            if (r5 == 0) goto L7f
            goto L85
        L7f:
            int r5 = e5.b.E(r7, r4)
        L83:
            if (r5 != 0) goto L90
        L85:
            d5.g r4 = new d5.g
            r4.<init>(r1, r2)
            r8.add(r4)
            r1 = r3
            goto L2
        L90:
            r6 = 1
            if (r5 <= r6) goto L94
            return
        L94:
            boolean r6 = g(r7)
            if (r6 == 0) goto L9b
            return
        L9b:
            r6 = 34
            byte r6 = (byte) r6
            boolean r6 = h(r7, r6)
            if (r6 == 0) goto La9
            java.lang.String r6 = d(r7)
            goto Lad
        La9:
            java.lang.String r6 = e(r7)
        Lad:
            if (r6 == 0) goto Lc7
            java.lang.Object r3 = r2.put(r3, r6)
            java.lang.String r3 = (java.lang.String) r3
            if (r3 == 0) goto Lb8
            return
        Lb8:
            boolean r3 = g(r7)
            if (r3 != 0) goto Lc5
            boolean r3 = r7.y()
            if (r3 != 0) goto Lc5
            return
        Lc5:
            r3 = r0
            goto L72
        Lc7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j5.e.c(q5.e, java.util.List):void");
    }

    private static final String d(q5.e eVar) {
        byte b6 = (byte) 34;
        if (!(eVar.readByte() == b6)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        q5.e eVar2 = new q5.e();
        while (true) {
            long F = eVar.F(f6830a);
            if (F == -1) {
                return null;
            }
            if (eVar.v(F) == b6) {
                eVar2.d(eVar, F);
                eVar.readByte();
                return eVar2.X();
            }
            if (eVar.size() == F + 1) {
                return null;
            }
            eVar2.d(eVar, F);
            eVar.readByte();
            eVar2.d(eVar, 1L);
        }
    }

    private static final String e(q5.e eVar) {
        long F = eVar.F(f6831b);
        if (F == -1) {
            F = eVar.size();
        }
        if (F != 0) {
            return eVar.Y(F);
        }
        return null;
    }

    public static final void f(n receiveHeaders, u url, t headers) {
        kotlin.jvm.internal.k.e(receiveHeaders, "$this$receiveHeaders");
        kotlin.jvm.internal.k.e(url, "url");
        kotlin.jvm.internal.k.e(headers, "headers");
        if (receiveHeaders == n.f3182a) {
            return;
        }
        List<d5.m> e6 = d5.m.f3172n.e(url, headers);
        if (e6.isEmpty()) {
            return;
        }
        receiveHeaders.a(url, e6);
    }

    private static final boolean g(q5.e eVar) {
        boolean z5 = false;
        while (!eVar.y()) {
            byte v5 = eVar.v(0L);
            if (v5 == 9 || v5 == 32) {
                eVar.readByte();
            } else {
                if (v5 != 44) {
                    break;
                }
                eVar.readByte();
                z5 = true;
            }
        }
        return z5;
    }

    private static final boolean h(q5.e eVar, byte b6) {
        return !eVar.y() && eVar.v(0L) == b6;
    }
}
