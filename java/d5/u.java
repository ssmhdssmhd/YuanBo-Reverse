package d5;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f3208a;

    /* renamed from: b, reason: collision with root package name */
    private final String f3209b;

    /* renamed from: c, reason: collision with root package name */
    private final String f3210c;

    /* renamed from: d, reason: collision with root package name */
    private final String f3211d;

    /* renamed from: e, reason: collision with root package name */
    private final String f3212e;

    /* renamed from: f, reason: collision with root package name */
    private final int f3213f;

    /* renamed from: g, reason: collision with root package name */
    private final List<String> f3214g;

    /* renamed from: h, reason: collision with root package name */
    private final List<String> f3215h;

    /* renamed from: i, reason: collision with root package name */
    private final String f3216i;

    /* renamed from: j, reason: collision with root package name */
    private final String f3217j;

    /* renamed from: l, reason: collision with root package name */
    public static final b f3207l = new b(null);

    /* renamed from: k, reason: collision with root package name */
    private static final char[] f3206k = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static final class a {

        /* renamed from: i, reason: collision with root package name */
        public static final C0063a f3218i = new C0063a(null);

        /* renamed from: a, reason: collision with root package name */
        private String f3219a;

        /* renamed from: d, reason: collision with root package name */
        private String f3222d;

        /* renamed from: f, reason: collision with root package name */
        private final List<String> f3224f;

        /* renamed from: g, reason: collision with root package name */
        private List<String> f3225g;

        /* renamed from: h, reason: collision with root package name */
        private String f3226h;

        /* renamed from: b, reason: collision with root package name */
        private String f3220b = "";

        /* renamed from: c, reason: collision with root package name */
        private String f3221c = "";

        /* renamed from: e, reason: collision with root package name */
        private int f3223e = -1;

        /* renamed from: d5.u$a$a, reason: collision with other inner class name */
        public static final class C0063a {
            private C0063a() {
            }

            public /* synthetic */ C0063a(kotlin.jvm.internal.g gVar) {
                this();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int e(String str, int i6, int i7) {
                try {
                    int parseInt = Integer.parseInt(b.b(u.f3207l, str, i6, i7, "", false, false, false, false, null, 248, null));
                    if (1 <= parseInt && 65535 >= parseInt) {
                        return parseInt;
                    }
                    return -1;
                } catch (NumberFormatException unused) {
                    return -1;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int f(String str, int i6, int i7) {
                while (i6 < i7) {
                    char charAt = str.charAt(i6);
                    if (charAt == ':') {
                        return i6;
                    }
                    if (charAt == '[') {
                        do {
                            i6++;
                            if (i6 < i7) {
                            }
                        } while (str.charAt(i6) != ']');
                    }
                    i6++;
                }
                return i7;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int g(String str, int i6, int i7) {
                if (i7 - i6 < 2) {
                    return -1;
                }
                char charAt = str.charAt(i6);
                if ((kotlin.jvm.internal.k.f(charAt, 97) < 0 || kotlin.jvm.internal.k.f(charAt, 122) > 0) && (kotlin.jvm.internal.k.f(charAt, 65) < 0 || kotlin.jvm.internal.k.f(charAt, 90) > 0)) {
                    return -1;
                }
                while (true) {
                    i6++;
                    if (i6 >= i7) {
                        return -1;
                    }
                    char charAt2 = str.charAt(i6);
                    if ('a' > charAt2 || 'z' < charAt2) {
                        if ('A' > charAt2 || 'Z' < charAt2) {
                            if ('0' > charAt2 || '9' < charAt2) {
                                if (charAt2 != '+' && charAt2 != '-' && charAt2 != '.') {
                                    if (charAt2 == ':') {
                                        return i6;
                                    }
                                    return -1;
                                }
                            }
                        }
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int h(String str, int i6, int i7) {
                int i8 = 0;
                while (i6 < i7) {
                    char charAt = str.charAt(i6);
                    if (charAt != '\\' && charAt != '/') {
                        break;
                    }
                    i8++;
                    i6++;
                }
                return i8;
            }
        }

        public a() {
            ArrayList arrayList = new ArrayList();
            this.f3224f = arrayList;
            arrayList.add("");
        }

        private final int b() {
            int i6 = this.f3223e;
            if (i6 != -1) {
                return i6;
            }
            b bVar = u.f3207l;
            String str = this.f3219a;
            kotlin.jvm.internal.k.b(str);
            return bVar.c(str);
        }

        private final boolean f(String str) {
            boolean o6;
            if (kotlin.jvm.internal.k.a(str, ".")) {
                return true;
            }
            o6 = v4.p.o(str, "%2e", true);
            return o6;
        }

        private final boolean g(String str) {
            boolean o6;
            boolean o7;
            boolean o8;
            if (kotlin.jvm.internal.k.a(str, "..")) {
                return true;
            }
            o6 = v4.p.o(str, "%2e.", true);
            if (o6) {
                return true;
            }
            o7 = v4.p.o(str, ".%2e", true);
            if (o7) {
                return true;
            }
            o8 = v4.p.o(str, "%2e%2e", true);
            return o8;
        }

        private final void j() {
            List<String> list = this.f3224f;
            if (!(list.remove(list.size() - 1).length() == 0) || !(!this.f3224f.isEmpty())) {
                this.f3224f.add("");
            } else {
                List<String> list2 = this.f3224f;
                list2.set(list2.size() - 1, "");
            }
        }

        private final void l(String str, int i6, int i7, boolean z5, boolean z6) {
            String b6 = b.b(u.f3207l, str, i6, i7, " \"<>^`{}|/\\?#", z6, false, false, false, null, 240, null);
            if (f(b6)) {
                return;
            }
            if (g(b6)) {
                j();
                return;
            }
            List<String> list = this.f3224f;
            if (list.get(list.size() - 1).length() == 0) {
                List<String> list2 = this.f3224f;
                list2.set(list2.size() - 1, b6);
            } else {
                this.f3224f.add(b6);
            }
            if (z5) {
                this.f3224f.add("");
            }
        }

        private final void n(String str, int i6, int i7) {
            if (i6 == i7) {
                return;
            }
            char charAt = str.charAt(i6);
            if (charAt == '/' || charAt == '\\') {
                this.f3224f.clear();
                this.f3224f.add("");
                i6++;
            } else {
                List<String> list = this.f3224f;
                list.set(list.size() - 1, "");
            }
            while (true) {
                int i8 = i6;
                if (i8 >= i7) {
                    return;
                }
                i6 = e5.b.m(str, "/\\", i8, i7);
                boolean z5 = i6 < i7;
                l(str, i8, i6, z5, true);
                if (z5) {
                    i6++;
                }
            }
        }

        public final u a() {
            int n6;
            ArrayList arrayList;
            int n7;
            String str = this.f3219a;
            if (str == null) {
                throw new IllegalStateException("scheme == null");
            }
            b bVar = u.f3207l;
            String g6 = b.g(bVar, this.f3220b, 0, 0, false, 7, null);
            String g7 = b.g(bVar, this.f3221c, 0, 0, false, 7, null);
            String str2 = this.f3222d;
            if (str2 == null) {
                throw new IllegalStateException("host == null");
            }
            int b6 = b();
            List<String> list = this.f3224f;
            n6 = f4.m.n(list, 10);
            ArrayList arrayList2 = new ArrayList(n6);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(b.g(u.f3207l, (String) it.next(), 0, 0, false, 7, null));
            }
            List<String> list2 = this.f3225g;
            if (list2 != null) {
                n7 = f4.m.n(list2, 10);
                arrayList = new ArrayList(n7);
                for (String str3 : list2) {
                    arrayList.add(str3 != null ? b.g(u.f3207l, str3, 0, 0, true, 3, null) : null);
                }
            } else {
                arrayList = null;
            }
            String str4 = this.f3226h;
            return new u(str, g6, g7, str2, b6, arrayList2, arrayList, str4 != null ? b.g(u.f3207l, str4, 0, 0, false, 7, null) : null, toString());
        }

        public final a c(String str) {
            List<String> list;
            if (str != null) {
                b bVar = u.f3207l;
                String b6 = b.b(bVar, str, 0, 0, " \"'<>#", true, false, true, false, null, 211, null);
                if (b6 != null) {
                    list = bVar.i(b6);
                    this.f3225g = list;
                    return this;
                }
            }
            list = null;
            this.f3225g = list;
            return this;
        }

        public final List<String> d() {
            return this.f3224f;
        }

        public final a e(String host) {
            kotlin.jvm.internal.k.e(host, "host");
            String e6 = e5.a.e(b.g(u.f3207l, host, 0, 0, false, 7, null));
            if (e6 != null) {
                this.f3222d = e6;
                return this;
            }
            throw new IllegalArgumentException("unexpected host: " + host);
        }

        public final a h(u uVar, String input) {
            int m6;
            int i6;
            int i7;
            String str;
            int i8;
            String str2;
            int i9;
            boolean z5;
            boolean z6;
            kotlin.jvm.internal.k.e(input, "input");
            int w5 = e5.b.w(input, 0, 0, 3, null);
            int y5 = e5.b.y(input, w5, 0, 2, null);
            C0063a c0063a = f3218i;
            int g6 = c0063a.g(input, w5, y5);
            String str3 = "(this as java.lang.Strin…ing(startIndex, endIndex)";
            char c6 = 65535;
            if (g6 != -1) {
                if (v4.p.x(input, "https:", w5, true)) {
                    this.f3219a = "https";
                    w5 += 6;
                } else {
                    if (!v4.p.x(input, "http:", w5, true)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Expected URL scheme 'http' or 'https' but was '");
                        String substring = input.substring(0, g6);
                        kotlin.jvm.internal.k.d(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        sb.append(substring);
                        sb.append("'");
                        throw new IllegalArgumentException(sb.toString());
                    }
                    this.f3219a = "http";
                    w5 += 5;
                }
            } else {
                if (uVar == null) {
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
                }
                this.f3219a = uVar.p();
            }
            int h6 = c0063a.h(input, w5, y5);
            char c7 = '?';
            char c8 = '#';
            if (h6 >= 2 || uVar == null || (!kotlin.jvm.internal.k.a(uVar.p(), this.f3219a))) {
                int i10 = w5 + h6;
                boolean z7 = false;
                boolean z8 = false;
                while (true) {
                    m6 = e5.b.m(input, "@/\\?#", i10, y5);
                    char charAt = m6 != y5 ? input.charAt(m6) : (char) 65535;
                    if (charAt == c6 || charAt == c8 || charAt == '/' || charAt == '\\' || charAt == c7) {
                        break;
                    }
                    if (charAt != '@') {
                        str2 = str3;
                        i8 = y5;
                    } else {
                        if (z7) {
                            i8 = y5;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(this.f3221c);
                            sb2.append("%40");
                            str2 = str3;
                            i9 = m6;
                            sb2.append(b.b(u.f3207l, input, i10, m6, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null));
                            this.f3221c = sb2.toString();
                            z5 = z8;
                        } else {
                            int l6 = e5.b.l(input, ':', i10, m6);
                            b bVar = u.f3207l;
                            i8 = y5;
                            String str4 = str3;
                            String b6 = b.b(bVar, input, i10, l6, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
                            if (z8) {
                                b6 = this.f3220b + "%40" + b6;
                            }
                            this.f3220b = b6;
                            if (l6 != m6) {
                                this.f3221c = b.b(bVar, input, l6 + 1, m6, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
                                z6 = true;
                            } else {
                                z6 = z7;
                            }
                            z7 = z6;
                            str2 = str4;
                            z5 = true;
                            i9 = m6;
                        }
                        i10 = i9 + 1;
                        z8 = z5;
                    }
                    str3 = str2;
                    y5 = i8;
                    c8 = '#';
                    c7 = '?';
                    c6 = 65535;
                }
                String str5 = str3;
                i6 = y5;
                C0063a c0063a2 = f3218i;
                int f6 = c0063a2.f(input, i10, m6);
                int i11 = f6 + 1;
                if (i11 < m6) {
                    i7 = i10;
                    this.f3222d = e5.a.e(b.g(u.f3207l, input, i10, f6, false, 4, null));
                    int e6 = c0063a2.e(input, i11, m6);
                    this.f3223e = e6;
                    if (!(e6 != -1)) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Invalid URL port: \"");
                        String substring2 = input.substring(i11, m6);
                        kotlin.jvm.internal.k.d(substring2, str5);
                        sb3.append(substring2);
                        sb3.append('\"');
                        throw new IllegalArgumentException(sb3.toString().toString());
                    }
                    str = str5;
                } else {
                    i7 = i10;
                    str = str5;
                    b bVar2 = u.f3207l;
                    this.f3222d = e5.a.e(b.g(bVar2, input, i7, f6, false, 4, null));
                    String str6 = this.f3219a;
                    kotlin.jvm.internal.k.b(str6);
                    this.f3223e = bVar2.c(str6);
                }
                if (!(this.f3222d != null)) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("Invalid URL host: \"");
                    String substring3 = input.substring(i7, f6);
                    kotlin.jvm.internal.k.d(substring3, str);
                    sb4.append(substring3);
                    sb4.append('\"');
                    throw new IllegalArgumentException(sb4.toString().toString());
                }
                w5 = m6;
            } else {
                this.f3220b = uVar.g();
                this.f3221c = uVar.c();
                this.f3222d = uVar.h();
                this.f3223e = uVar.l();
                this.f3224f.clear();
                this.f3224f.addAll(uVar.e());
                if (w5 == y5 || input.charAt(w5) == '#') {
                    c(uVar.f());
                }
                i6 = y5;
            }
            int i12 = i6;
            int m7 = e5.b.m(input, "?#", w5, i12);
            n(input, w5, m7);
            if (m7 < i12 && input.charAt(m7) == '?') {
                int l7 = e5.b.l(input, '#', m7, i12);
                b bVar3 = u.f3207l;
                this.f3225g = bVar3.i(b.b(bVar3, input, m7 + 1, l7, " \"'<>#", true, false, true, false, null, 208, null));
                m7 = l7;
            }
            if (m7 < i12 && input.charAt(m7) == '#') {
                this.f3226h = b.b(u.f3207l, input, m7 + 1, i12, "", true, false, false, true, null, 176, null);
            }
            return this;
        }

        public final a i(String password) {
            kotlin.jvm.internal.k.e(password, "password");
            this.f3221c = b.b(u.f3207l, password, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null);
            return this;
        }

        public final a k(int i6) {
            if (1 <= i6 && 65535 >= i6) {
                this.f3223e = i6;
                return this;
            }
            throw new IllegalArgumentException(("unexpected port: " + i6).toString());
        }

        public final a m() {
            String str = this.f3222d;
            this.f3222d = str != null ? new v4.f("[\"<>^`{|}]").b(str, "") : null;
            int size = this.f3224f.size();
            for (int i6 = 0; i6 < size; i6++) {
                List<String> list = this.f3224f;
                list.set(i6, b.b(u.f3207l, list.get(i6), 0, 0, "[]", true, true, false, false, null, 227, null));
            }
            List<String> list2 = this.f3225g;
            if (list2 != null) {
                int size2 = list2.size();
                for (int i7 = 0; i7 < size2; i7++) {
                    String str2 = list2.get(i7);
                    list2.set(i7, str2 != null ? b.b(u.f3207l, str2, 0, 0, "\\^`{|}", true, true, true, false, null, 195, null) : null);
                }
            }
            String str3 = this.f3226h;
            this.f3226h = str3 != null ? b.b(u.f3207l, str3, 0, 0, " \"#<>\\^`{|}", true, true, false, true, null, 163, null) : null;
            return this;
        }

        public final a o(String scheme) {
            boolean o6;
            boolean o7;
            kotlin.jvm.internal.k.e(scheme, "scheme");
            String str = "http";
            o6 = v4.p.o(scheme, "http", true);
            if (!o6) {
                str = "https";
                o7 = v4.p.o(scheme, "https", true);
                if (!o7) {
                    throw new IllegalArgumentException("unexpected scheme: " + scheme);
                }
            }
            this.f3219a = str;
            return this;
        }

        public final void p(String str) {
            this.f3226h = str;
        }

        public final void q(String str) {
            kotlin.jvm.internal.k.e(str, "<set-?>");
            this.f3221c = str;
        }

        public final void r(String str) {
            kotlin.jvm.internal.k.e(str, "<set-?>");
            this.f3220b = str;
        }

        public final void s(String str) {
            this.f3222d = str;
        }

        public final void t(int i6) {
            this.f3223e = i6;
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0030, code lost:
        
            if ((r6.f3221c.length() > 0) != false) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x008e, code lost:
        
            if (r1 != r3.c(r2)) goto L38;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.String toString() {
            /*
                r6 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = r6.f3219a
                if (r1 == 0) goto Lf
                r0.append(r1)
                java.lang.String r1 = "://"
                goto L11
            Lf:
                java.lang.String r1 = "//"
            L11:
                r0.append(r1)
                java.lang.String r1 = r6.f3220b
                int r1 = r1.length()
                r2 = 1
                r3 = 0
                if (r1 <= 0) goto L20
                r1 = 1
                goto L21
            L20:
                r1 = 0
            L21:
                r4 = 58
                if (r1 != 0) goto L32
                java.lang.String r1 = r6.f3221c
                int r1 = r1.length()
                if (r1 <= 0) goto L2f
                r1 = 1
                goto L30
            L2f:
                r1 = 0
            L30:
                if (r1 == 0) goto L50
            L32:
                java.lang.String r1 = r6.f3220b
                r0.append(r1)
                java.lang.String r1 = r6.f3221c
                int r1 = r1.length()
                if (r1 <= 0) goto L40
                goto L41
            L40:
                r2 = 0
            L41:
                if (r2 == 0) goto L4b
                r0.append(r4)
                java.lang.String r1 = r6.f3221c
                r0.append(r1)
            L4b:
                r1 = 64
                r0.append(r1)
            L50:
                java.lang.String r1 = r6.f3222d
                if (r1 == 0) goto L74
                kotlin.jvm.internal.k.b(r1)
                r2 = 2
                r5 = 0
                boolean r1 = v4.g.E(r1, r4, r3, r2, r5)
                if (r1 == 0) goto L6f
                r1 = 91
                r0.append(r1)
                java.lang.String r1 = r6.f3222d
                r0.append(r1)
                r1 = 93
                r0.append(r1)
                goto L74
            L6f:
                java.lang.String r1 = r6.f3222d
                r0.append(r1)
            L74:
                int r1 = r6.f3223e
                r2 = -1
                if (r1 != r2) goto L7d
                java.lang.String r1 = r6.f3219a
                if (r1 == 0) goto L96
            L7d:
                int r1 = r6.b()
                java.lang.String r2 = r6.f3219a
                if (r2 == 0) goto L90
                d5.u$b r3 = d5.u.f3207l
                kotlin.jvm.internal.k.b(r2)
                int r2 = r3.c(r2)
                if (r1 == r2) goto L96
            L90:
                r0.append(r4)
                r0.append(r1)
            L96:
                d5.u$b r1 = d5.u.f3207l
                java.util.List<java.lang.String> r2 = r6.f3224f
                r1.h(r2, r0)
                java.util.List<java.lang.String> r2 = r6.f3225g
                if (r2 == 0) goto Lae
                r2 = 63
                r0.append(r2)
                java.util.List<java.lang.String> r2 = r6.f3225g
                kotlin.jvm.internal.k.b(r2)
                r1.j(r2, r0)
            Lae:
                java.lang.String r1 = r6.f3226h
                if (r1 == 0) goto Lbc
                r1 = 35
                r0.append(r1)
                java.lang.String r1 = r6.f3226h
                r0.append(r1)
            Lbc:
                java.lang.String r0 = r0.toString()
                java.lang.String r1 = "StringBuilder().apply(builderAction).toString()"
                kotlin.jvm.internal.k.d(r0, r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: d5.u.a.toString():java.lang.String");
        }

        public final void u(String str) {
            this.f3219a = str;
        }

        public final a v(String username) {
            kotlin.jvm.internal.k.e(username, "username");
            this.f3220b = b.b(u.f3207l, username, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null);
            return this;
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.g gVar) {
            this();
        }

        public static /* synthetic */ String b(b bVar, String str, int i6, int i7, String str2, boolean z5, boolean z6, boolean z7, boolean z8, Charset charset, int i8, Object obj) {
            return bVar.a(str, (i8 & 1) != 0 ? 0 : i6, (i8 & 2) != 0 ? str.length() : i7, str2, (i8 & 8) != 0 ? false : z5, (i8 & 16) != 0 ? false : z6, (i8 & 32) != 0 ? false : z7, (i8 & 64) != 0 ? false : z8, (i8 & 128) != 0 ? null : charset);
        }

        private final boolean e(String str, int i6, int i7) {
            int i8 = i6 + 2;
            return i8 < i7 && str.charAt(i6) == '%' && e5.b.C(str.charAt(i6 + 1)) != -1 && e5.b.C(str.charAt(i8)) != -1;
        }

        public static /* synthetic */ String g(b bVar, String str, int i6, int i7, boolean z5, int i8, Object obj) {
            if ((i8 & 1) != 0) {
                i6 = 0;
            }
            if ((i8 & 2) != 0) {
                i7 = str.length();
            }
            if ((i8 & 4) != 0) {
                z5 = false;
            }
            return bVar.f(str, i6, i7, z5);
        }

        /* JADX WARN: Code restructure failed: missing block: B:37:0x0062, code lost:
        
            if (e(r16, r5, r18) == false) goto L43;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private final void k(q5.e r15, java.lang.String r16, int r17, int r18, java.lang.String r19, boolean r20, boolean r21, boolean r22, boolean r23, java.nio.charset.Charset r24) {
            /*
                r14 = this;
                r0 = r15
                r1 = r16
                r2 = r18
                r3 = r24
                r4 = 0
                r5 = r17
                r6 = r4
            Lb:
                if (r5 >= r2) goto Lc5
                if (r1 == 0) goto Lbc
                int r7 = r1.codePointAt(r5)
                if (r20 == 0) goto L2b
                r8 = 9
                if (r7 == r8) goto L26
                r8 = 10
                if (r7 == r8) goto L26
                r8 = 12
                if (r7 == r8) goto L26
                r8 = 13
                if (r7 == r8) goto L26
                goto L2b
            L26:
                r8 = r14
                r12 = r19
                goto Lb5
            L2b:
                r8 = 43
                if (r7 != r8) goto L3c
                if (r22 == 0) goto L3c
                if (r20 == 0) goto L36
                java.lang.String r8 = "+"
                goto L38
            L36:
                java.lang.String r8 = "%2B"
            L38:
                r15.Q(r8)
                goto L26
            L3c:
                r8 = 32
                r9 = 37
                if (r7 < r8) goto L6c
                r8 = 127(0x7f, float:1.78E-43)
                if (r7 == r8) goto L6c
                r8 = 128(0x80, float:1.8E-43)
                if (r7 < r8) goto L4c
                if (r23 == 0) goto L6c
            L4c:
                char r8 = (char) r7
                r10 = 0
                r11 = 2
                r12 = r19
                boolean r8 = v4.g.E(r12, r8, r10, r11, r4)
                if (r8 != 0) goto L6a
                if (r7 != r9) goto L65
                if (r20 == 0) goto L6a
                if (r21 == 0) goto L65
                r8 = r14
                boolean r10 = r14.e(r1, r5, r2)
                if (r10 != 0) goto L66
                goto L6f
            L65:
                r8 = r14
            L66:
                r15.o0(r7)
                goto Lb5
            L6a:
                r8 = r14
                goto L6f
            L6c:
                r8 = r14
                r12 = r19
            L6f:
                if (r6 != 0) goto L76
                q5.e r6 = new q5.e
                r6.<init>()
            L76:
                if (r3 == 0) goto L8a
                java.nio.charset.Charset r10 = java.nio.charset.StandardCharsets.UTF_8
                boolean r10 = kotlin.jvm.internal.k.a(r3, r10)
                if (r10 == 0) goto L81
                goto L8a
            L81:
                int r10 = java.lang.Character.charCount(r7)
                int r10 = r10 + r5
                r6.l0(r1, r5, r10, r3)
                goto L8d
            L8a:
                r6.o0(r7)
            L8d:
                boolean r10 = r6.y()
                if (r10 != 0) goto Lb5
                byte r10 = r6.readByte()
                r10 = r10 & 255(0xff, float:3.57E-43)
                r15.writeByte(r9)
                char[] r11 = d5.u.a()
                int r13 = r10 >> 4
                r13 = r13 & 15
                char r11 = r11[r13]
                r15.writeByte(r11)
                char[] r11 = d5.u.a()
                r10 = r10 & 15
                char r10 = r11[r10]
                r15.writeByte(r10)
                goto L8d
            Lb5:
                int r7 = java.lang.Character.charCount(r7)
                int r5 = r5 + r7
                goto Lb
            Lbc:
                r8 = r14
                java.lang.NullPointerException r0 = new java.lang.NullPointerException
                java.lang.String r1 = "null cannot be cast to non-null type java.lang.String"
                r0.<init>(r1)
                throw r0
            Lc5:
                r8 = r14
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: d5.u.b.k(q5.e, java.lang.String, int, int, java.lang.String, boolean, boolean, boolean, boolean, java.nio.charset.Charset):void");
        }

        private final void l(q5.e eVar, String str, int i6, int i7, boolean z5) {
            int i8;
            while (i6 < i7) {
                if (str == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                int codePointAt = str.codePointAt(i6);
                if (codePointAt != 37 || (i8 = i6 + 2) >= i7) {
                    if (codePointAt == 43 && z5) {
                        eVar.writeByte(32);
                        i6++;
                    }
                    eVar.o0(codePointAt);
                    i6 += Character.charCount(codePointAt);
                } else {
                    int C = e5.b.C(str.charAt(i6 + 1));
                    int C2 = e5.b.C(str.charAt(i8));
                    if (C != -1 && C2 != -1) {
                        eVar.writeByte((C << 4) + C2);
                        i6 = Character.charCount(codePointAt) + i8;
                    }
                    eVar.o0(codePointAt);
                    i6 += Character.charCount(codePointAt);
                }
            }
        }

        public final String a(String canonicalize, int i6, int i7, String encodeSet, boolean z5, boolean z6, boolean z7, boolean z8, Charset charset) {
            boolean E;
            kotlin.jvm.internal.k.e(canonicalize, "$this$canonicalize");
            kotlin.jvm.internal.k.e(encodeSet, "encodeSet");
            int i8 = i6;
            while (i8 < i7) {
                int codePointAt = canonicalize.codePointAt(i8);
                if (codePointAt >= 32 && codePointAt != 127 && (codePointAt < 128 || z8)) {
                    E = v4.q.E(encodeSet, (char) codePointAt, false, 2, null);
                    if (!E) {
                        if (codePointAt == 37) {
                            if (z5) {
                                if (z6) {
                                    if (!e(canonicalize, i8, i7)) {
                                        q5.e eVar = new q5.e();
                                        eVar.n0(canonicalize, i6, i8);
                                        k(eVar, canonicalize, i8, i7, encodeSet, z5, z6, z7, z8, charset);
                                        return eVar.X();
                                    }
                                    if (codePointAt != 43 && z7) {
                                        q5.e eVar2 = new q5.e();
                                        eVar2.n0(canonicalize, i6, i8);
                                        k(eVar2, canonicalize, i8, i7, encodeSet, z5, z6, z7, z8, charset);
                                        return eVar2.X();
                                    }
                                    i8 += Character.charCount(codePointAt);
                                }
                            }
                        }
                        if (codePointAt != 43) {
                        }
                        i8 += Character.charCount(codePointAt);
                    }
                }
                q5.e eVar22 = new q5.e();
                eVar22.n0(canonicalize, i6, i8);
                k(eVar22, canonicalize, i8, i7, encodeSet, z5, z6, z7, z8, charset);
                return eVar22.X();
            }
            String substring = canonicalize.substring(i6, i7);
            kotlin.jvm.internal.k.d(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }

        public final int c(String scheme) {
            kotlin.jvm.internal.k.e(scheme, "scheme");
            int hashCode = scheme.hashCode();
            if (hashCode != 3213448) {
                if (hashCode == 99617003 && scheme.equals("https")) {
                    return 443;
                }
            } else if (scheme.equals("http")) {
                return 80;
            }
            return -1;
        }

        public final u d(String toHttpUrl) {
            kotlin.jvm.internal.k.e(toHttpUrl, "$this$toHttpUrl");
            return new a().h(null, toHttpUrl).a();
        }

        public final String f(String percentDecode, int i6, int i7, boolean z5) {
            kotlin.jvm.internal.k.e(percentDecode, "$this$percentDecode");
            for (int i8 = i6; i8 < i7; i8++) {
                char charAt = percentDecode.charAt(i8);
                if (charAt == '%' || (charAt == '+' && z5)) {
                    q5.e eVar = new q5.e();
                    eVar.n0(percentDecode, i6, i8);
                    l(eVar, percentDecode, i8, i7, z5);
                    return eVar.X();
                }
            }
            String substring = percentDecode.substring(i6, i7);
            kotlin.jvm.internal.k.d(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }

        public final void h(List<String> toPathString, StringBuilder out) {
            kotlin.jvm.internal.k.e(toPathString, "$this$toPathString");
            kotlin.jvm.internal.k.e(out, "out");
            int size = toPathString.size();
            for (int i6 = 0; i6 < size; i6++) {
                out.append('/');
                out.append(toPathString.get(i6));
            }
        }

        public final List<String> i(String toQueryNamesAndValues) {
            String str;
            kotlin.jvm.internal.k.e(toQueryNamesAndValues, "$this$toQueryNamesAndValues");
            ArrayList arrayList = new ArrayList();
            int i6 = 0;
            while (i6 <= toQueryNamesAndValues.length()) {
                int P = v4.q.P(toQueryNamesAndValues, '&', i6, false, 4, null);
                if (P == -1) {
                    P = toQueryNamesAndValues.length();
                }
                int i7 = P;
                int P2 = v4.q.P(toQueryNamesAndValues, '=', i6, false, 4, null);
                if (P2 == -1 || P2 > i7) {
                    String substring = toQueryNamesAndValues.substring(i6, i7);
                    kotlin.jvm.internal.k.d(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    arrayList.add(substring);
                    str = null;
                } else {
                    String substring2 = toQueryNamesAndValues.substring(i6, P2);
                    kotlin.jvm.internal.k.d(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    arrayList.add(substring2);
                    str = toQueryNamesAndValues.substring(P2 + 1, i7);
                    kotlin.jvm.internal.k.d(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                }
                arrayList.add(str);
                i6 = i7 + 1;
            }
            return arrayList;
        }

        public final void j(List<String> toQueryString, StringBuilder out) {
            s4.c i6;
            s4.a h6;
            kotlin.jvm.internal.k.e(toQueryString, "$this$toQueryString");
            kotlin.jvm.internal.k.e(out, "out");
            i6 = s4.f.i(0, toQueryString.size());
            h6 = s4.f.h(i6, 2);
            int b6 = h6.b();
            int c6 = h6.c();
            int d6 = h6.d();
            if (d6 >= 0) {
                if (b6 > c6) {
                    return;
                }
            } else if (b6 < c6) {
                return;
            }
            while (true) {
                String str = toQueryString.get(b6);
                String str2 = toQueryString.get(b6 + 1);
                if (b6 > 0) {
                    out.append('&');
                }
                out.append(str);
                if (str2 != null) {
                    out.append('=');
                    out.append(str2);
                }
                if (b6 == c6) {
                    return;
                } else {
                    b6 += d6;
                }
            }
        }
    }

    public u(String scheme, String username, String password, String host, int i6, List<String> pathSegments, List<String> list, String str, String url) {
        kotlin.jvm.internal.k.e(scheme, "scheme");
        kotlin.jvm.internal.k.e(username, "username");
        kotlin.jvm.internal.k.e(password, "password");
        kotlin.jvm.internal.k.e(host, "host");
        kotlin.jvm.internal.k.e(pathSegments, "pathSegments");
        kotlin.jvm.internal.k.e(url, "url");
        this.f3209b = scheme;
        this.f3210c = username;
        this.f3211d = password;
        this.f3212e = host;
        this.f3213f = i6;
        this.f3214g = pathSegments;
        this.f3215h = list;
        this.f3216i = str;
        this.f3217j = url;
        this.f3208a = kotlin.jvm.internal.k.a(scheme, "https");
    }

    public final String b() {
        if (this.f3216i == null) {
            return null;
        }
        int P = v4.q.P(this.f3217j, '#', 0, false, 6, null) + 1;
        String str = this.f3217j;
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String substring = str.substring(P);
        kotlin.jvm.internal.k.d(substring, "(this as java.lang.String).substring(startIndex)");
        return substring;
    }

    public final String c() {
        if (this.f3211d.length() == 0) {
            return "";
        }
        int P = v4.q.P(this.f3217j, ':', this.f3209b.length() + 3, false, 4, null) + 1;
        int P2 = v4.q.P(this.f3217j, '@', 0, false, 6, null);
        String str = this.f3217j;
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String substring = str.substring(P, P2);
        kotlin.jvm.internal.k.d(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public final String d() {
        int P = v4.q.P(this.f3217j, '/', this.f3209b.length() + 3, false, 4, null);
        String str = this.f3217j;
        int m6 = e5.b.m(str, "?#", P, str.length());
        String str2 = this.f3217j;
        if (str2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String substring = str2.substring(P, m6);
        kotlin.jvm.internal.k.d(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public final List<String> e() {
        int P = v4.q.P(this.f3217j, '/', this.f3209b.length() + 3, false, 4, null);
        String str = this.f3217j;
        int m6 = e5.b.m(str, "?#", P, str.length());
        ArrayList arrayList = new ArrayList();
        while (P < m6) {
            int i6 = P + 1;
            int l6 = e5.b.l(this.f3217j, '/', i6, m6);
            String str2 = this.f3217j;
            if (str2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String substring = str2.substring(i6, l6);
            kotlin.jvm.internal.k.d(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            arrayList.add(substring);
            P = l6;
        }
        return arrayList;
    }

    public boolean equals(Object obj) {
        return (obj instanceof u) && kotlin.jvm.internal.k.a(((u) obj).f3217j, this.f3217j);
    }

    public final String f() {
        if (this.f3215h == null) {
            return null;
        }
        int P = v4.q.P(this.f3217j, '?', 0, false, 6, null) + 1;
        String str = this.f3217j;
        int l6 = e5.b.l(str, '#', P, str.length());
        String str2 = this.f3217j;
        if (str2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String substring = str2.substring(P, l6);
        kotlin.jvm.internal.k.d(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public final String g() {
        if (this.f3210c.length() == 0) {
            return "";
        }
        int length = this.f3209b.length() + 3;
        String str = this.f3217j;
        int m6 = e5.b.m(str, ":@", length, str.length());
        String str2 = this.f3217j;
        if (str2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String substring = str2.substring(length, m6);
        kotlin.jvm.internal.k.d(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public final String h() {
        return this.f3212e;
    }

    public int hashCode() {
        return this.f3217j.hashCode();
    }

    public final boolean i() {
        return this.f3208a;
    }

    public final a j() {
        a aVar = new a();
        aVar.u(this.f3209b);
        aVar.r(g());
        aVar.q(c());
        aVar.s(this.f3212e);
        aVar.t(this.f3213f != f3207l.c(this.f3209b) ? this.f3213f : -1);
        aVar.d().clear();
        aVar.d().addAll(e());
        aVar.c(f());
        aVar.p(b());
        return aVar;
    }

    public final a k(String link) {
        kotlin.jvm.internal.k.e(link, "link");
        try {
            return new a().h(this, link);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public final int l() {
        return this.f3213f;
    }

    public final String m() {
        if (this.f3215h == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        f3207l.j(this.f3215h, sb);
        return sb.toString();
    }

    public final String n() {
        a k6 = k("/...");
        kotlin.jvm.internal.k.b(k6);
        return k6.v("").i("").a().toString();
    }

    public final u o(String link) {
        kotlin.jvm.internal.k.e(link, "link");
        a k6 = k(link);
        if (k6 != null) {
            return k6.a();
        }
        return null;
    }

    public final String p() {
        return this.f3209b;
    }

    public final URI q() {
        String aVar = j().m().toString();
        try {
            return new URI(aVar);
        } catch (URISyntaxException e6) {
            try {
                URI create = URI.create(new v4.f("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]").b(aVar, ""));
                kotlin.jvm.internal.k.d(create, "try {\n        val stripp…e) // Unexpected!\n      }");
                return create;
            } catch (Exception unused) {
                throw new RuntimeException(e6);
            }
        }
    }

    public final URL r() {
        try {
            return new URL(this.f3217j);
        } catch (MalformedURLException e6) {
            throw new RuntimeException(e6);
        }
    }

    public String toString() {
        return this.f3217j;
    }
}
