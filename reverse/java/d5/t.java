package d5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class t implements Iterable<e4.j<? extends String, ? extends String>>, p4.a {

    /* renamed from: b, reason: collision with root package name */
    public static final b f3203b = new b(null);

    /* renamed from: a, reason: collision with root package name */
    private final String[] f3204a;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final List<String> f3205a = new ArrayList(20);

        public final a a(String name, String value) {
            kotlin.jvm.internal.k.e(name, "name");
            kotlin.jvm.internal.k.e(value, "value");
            b bVar = t.f3203b;
            bVar.d(name);
            bVar.e(value, name);
            c(name, value);
            return this;
        }

        public final a b(String line) {
            kotlin.jvm.internal.k.e(line, "line");
            int P = v4.q.P(line, ':', 1, false, 4, null);
            if (P != -1) {
                String substring = line.substring(0, P);
                kotlin.jvm.internal.k.d(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                String substring2 = line.substring(P + 1);
                kotlin.jvm.internal.k.d(substring2, "(this as java.lang.String).substring(startIndex)");
                c(substring, substring2);
            } else {
                if (line.charAt(0) == ':') {
                    line = line.substring(1);
                    kotlin.jvm.internal.k.d(line, "(this as java.lang.String).substring(startIndex)");
                }
                c("", line);
            }
            return this;
        }

        public final a c(String name, String value) {
            CharSequence z02;
            kotlin.jvm.internal.k.e(name, "name");
            kotlin.jvm.internal.k.e(value, "value");
            this.f3205a.add(name);
            List<String> list = this.f3205a;
            z02 = v4.q.z0(value);
            list.add(z02.toString());
            return this;
        }

        public final t d() {
            Object[] array = this.f3205a.toArray(new String[0]);
            if (array != null) {
                return new t((String[]) array, null);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }

        public final List<String> e() {
            return this.f3205a;
        }

        public final a f(String name) {
            boolean o6;
            kotlin.jvm.internal.k.e(name, "name");
            int i6 = 0;
            while (i6 < this.f3205a.size()) {
                o6 = v4.p.o(name, this.f3205a.get(i6), true);
                if (o6) {
                    this.f3205a.remove(i6);
                    this.f3205a.remove(i6);
                    i6 -= 2;
                }
                i6 += 2;
            }
            return this;
        }

        public final a g(String name, String value) {
            kotlin.jvm.internal.k.e(name, "name");
            kotlin.jvm.internal.k.e(value, "value");
            b bVar = t.f3203b;
            bVar.d(name);
            bVar.e(value, name);
            f(name);
            c(name, value);
            return this;
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void d(String str) {
            if (!(str.length() > 0)) {
                throw new IllegalArgumentException("name is empty".toString());
            }
            int length = str.length();
            for (int i6 = 0; i6 < length; i6++) {
                char charAt = str.charAt(i6);
                if (!('!' <= charAt && '~' >= charAt)) {
                    throw new IllegalArgumentException(e5.b.p("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i6), str).toString());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void e(String str, String str2) {
            int length = str.length();
            for (int i6 = 0; i6 < length; i6++) {
                char charAt = str.charAt(i6);
                if (!(charAt == '\t' || (' ' <= charAt && '~' >= charAt))) {
                    throw new IllegalArgumentException(e5.b.p("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt), Integer.valueOf(i6), str2, str).toString());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Incorrect condition in loop: B:8:0x0026 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.String f(java.lang.String[] r6, java.lang.String r7) {
            /*
                r5 = this;
                int r0 = r6.length
                r1 = 2
                int r0 = r0 - r1
                r2 = 0
                s4.a r0 = s4.d.g(r0, r2)
                s4.a r0 = s4.d.h(r0, r1)
                int r1 = r0.b()
                int r2 = r0.c()
                int r0 = r0.d()
                if (r0 < 0) goto L1d
                if (r1 > r2) goto L30
                goto L1f
            L1d:
                if (r1 < r2) goto L30
            L1f:
                r3 = r6[r1]
                r4 = 1
                boolean r3 = v4.g.o(r7, r3, r4)
                if (r3 == 0) goto L2c
                int r1 = r1 + r4
                r6 = r6[r1]
                return r6
            L2c:
                if (r1 == r2) goto L30
                int r1 = r1 + r0
                goto L1f
            L30:
                r6 = 0
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: d5.t.b.f(java.lang.String[], java.lang.String):java.lang.String");
        }

        public final t g(String... namesAndValues) {
            s4.c i6;
            s4.a h6;
            CharSequence z02;
            kotlin.jvm.internal.k.e(namesAndValues, "namesAndValues");
            if (!(namesAndValues.length % 2 == 0)) {
                throw new IllegalArgumentException("Expected alternating header names and values".toString());
            }
            Object clone = namesAndValues.clone();
            if (clone == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
            }
            String[] strArr = (String[]) clone;
            int length = strArr.length;
            for (int i7 = 0; i7 < length; i7++) {
                String str = strArr[i7];
                if (!(str != null)) {
                    throw new IllegalArgumentException("Headers cannot be null".toString());
                }
                if (str == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                }
                z02 = v4.q.z0(str);
                strArr[i7] = z02.toString();
            }
            i6 = s4.f.i(0, strArr.length);
            h6 = s4.f.h(i6, 2);
            int b6 = h6.b();
            int c6 = h6.c();
            int d6 = h6.d();
            if (d6 < 0 ? b6 >= c6 : b6 <= c6) {
                while (true) {
                    String str2 = strArr[b6];
                    String str3 = strArr[b6 + 1];
                    d(str2);
                    e(str3, str2);
                    if (b6 == c6) {
                        break;
                    }
                    b6 += d6;
                }
            }
            return new t(strArr, null);
        }
    }

    private t(String[] strArr) {
        this.f3204a = strArr;
    }

    public /* synthetic */ t(String[] strArr, kotlin.jvm.internal.g gVar) {
        this(strArr);
    }

    public final String b(String name) {
        kotlin.jvm.internal.k.e(name, "name");
        return f3203b.f(this.f3204a, name);
    }

    public final String c(int i6) {
        return this.f3204a[i6 * 2];
    }

    public final a d() {
        a aVar = new a();
        f4.q.q(aVar.e(), this.f3204a);
        return aVar;
    }

    public final String e(int i6) {
        return this.f3204a[(i6 * 2) + 1];
    }

    public boolean equals(Object obj) {
        return (obj instanceof t) && Arrays.equals(this.f3204a, ((t) obj).f3204a);
    }

    public final List<String> f(String name) {
        boolean o6;
        kotlin.jvm.internal.k.e(name, "name");
        int size = size();
        ArrayList arrayList = null;
        for (int i6 = 0; i6 < size; i6++) {
            o6 = v4.p.o(name, c(i6), true);
            if (o6) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(e(i6));
            }
        }
        if (arrayList == null) {
            return f4.l.f();
        }
        List<String> unmodifiableList = Collections.unmodifiableList(arrayList);
        kotlin.jvm.internal.k.d(unmodifiableList, "Collections.unmodifiableList(result)");
        return unmodifiableList;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f3204a);
    }

    @Override // java.lang.Iterable
    public Iterator<e4.j<? extends String, ? extends String>> iterator() {
        int size = size();
        e4.j[] jVarArr = new e4.j[size];
        for (int i6 = 0; i6 < size; i6++) {
            jVarArr[i6] = e4.n.a(c(i6), e(i6));
        }
        return kotlin.jvm.internal.b.a(jVarArr);
    }

    public final int size() {
        return this.f3204a.length / 2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int size = size();
        for (int i6 = 0; i6 < size; i6++) {
            sb.append(c(i6));
            sb.append(": ");
            sb.append(e(i6));
            sb.append("\n");
        }
        String sb2 = sb.toString();
        kotlin.jvm.internal.k.d(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
