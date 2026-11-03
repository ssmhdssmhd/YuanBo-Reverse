package d5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    private final String f3173a;

    /* renamed from: b, reason: collision with root package name */
    private final String f3174b;

    /* renamed from: c, reason: collision with root package name */
    private final long f3175c;

    /* renamed from: d, reason: collision with root package name */
    private final String f3176d;

    /* renamed from: e, reason: collision with root package name */
    private final String f3177e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f3178f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f3179g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f3180h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f3181i;

    /* renamed from: n, reason: collision with root package name */
    public static final a f3172n = new a(null);

    /* renamed from: j, reason: collision with root package name */
    private static final Pattern f3168j = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* renamed from: k, reason: collision with root package name */
    private static final Pattern f3169k = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* renamed from: l, reason: collision with root package name */
    private static final Pattern f3170l = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* renamed from: m, reason: collision with root package name */
    private static final Pattern f3171m = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        private final int a(String str, int i6, int i7, boolean z5) {
            while (i6 < i7) {
                char charAt = str.charAt(i6);
                if (((charAt < ' ' && charAt != '\t') || charAt >= 127 || ('0' <= charAt && '9' >= charAt) || (('a' <= charAt && 'z' >= charAt) || (('A' <= charAt && 'Z' >= charAt) || charAt == ':'))) == (!z5)) {
                    return i6;
                }
                i6++;
            }
            return i7;
        }

        private final boolean b(String str, String str2) {
            if (kotlin.jvm.internal.k.a(str, str2)) {
                return true;
            }
            return v4.p.n(str, str2, false, 2, null) && str.charAt((str.length() - str2.length()) - 1) == '.' && !e5.b.f(str);
        }

        private final String f(String str) {
            String e02;
            if (!(!v4.p.n(str, ".", false, 2, null))) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            e02 = v4.q.e0(str, ".");
            String e6 = e5.a.e(e02);
            if (e6 != null) {
                return e6;
            }
            throw new IllegalArgumentException();
        }

        private final long g(String str, int i6, int i7) {
            int a6 = a(str, i6, i7, false);
            Matcher matcher = m.f3171m.matcher(str);
            int i8 = -1;
            int i9 = -1;
            int i10 = -1;
            int i11 = -1;
            int i12 = -1;
            int i13 = -1;
            while (a6 < i7) {
                int a7 = a(str, a6 + 1, i7, true);
                matcher.region(a6, a7);
                if (i9 == -1 && matcher.usePattern(m.f3171m).matches()) {
                    String group = matcher.group(1);
                    kotlin.jvm.internal.k.d(group, "matcher.group(1)");
                    i9 = Integer.parseInt(group);
                    String group2 = matcher.group(2);
                    kotlin.jvm.internal.k.d(group2, "matcher.group(2)");
                    i12 = Integer.parseInt(group2);
                    String group3 = matcher.group(3);
                    kotlin.jvm.internal.k.d(group3, "matcher.group(3)");
                    i13 = Integer.parseInt(group3);
                } else if (i10 == -1 && matcher.usePattern(m.f3170l).matches()) {
                    String group4 = matcher.group(1);
                    kotlin.jvm.internal.k.d(group4, "matcher.group(1)");
                    i10 = Integer.parseInt(group4);
                } else if (i11 == -1 && matcher.usePattern(m.f3169k).matches()) {
                    String group5 = matcher.group(1);
                    kotlin.jvm.internal.k.d(group5, "matcher.group(1)");
                    Locale locale = Locale.US;
                    kotlin.jvm.internal.k.d(locale, "Locale.US");
                    if (group5 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    String lowerCase = group5.toLowerCase(locale);
                    kotlin.jvm.internal.k.d(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                    String pattern = m.f3169k.pattern();
                    kotlin.jvm.internal.k.d(pattern, "MONTH_PATTERN.pattern()");
                    i11 = v4.q.Q(pattern, lowerCase, 0, false, 6, null) / 4;
                } else if (i8 == -1 && matcher.usePattern(m.f3168j).matches()) {
                    String group6 = matcher.group(1);
                    kotlin.jvm.internal.k.d(group6, "matcher.group(1)");
                    i8 = Integer.parseInt(group6);
                }
                a6 = a(str, a7 + 1, i7, false);
            }
            if (70 <= i8 && 99 >= i8) {
                i8 += 1900;
            }
            if (i8 >= 0 && 69 >= i8) {
                i8 += 2000;
            }
            if (!(i8 >= 1601)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(i11 != -1)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(1 <= i10 && 31 >= i10)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(i9 >= 0 && 23 >= i9)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(i12 >= 0 && 59 >= i12)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(i13 >= 0 && 59 >= i13)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar(e5.b.f3716f);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, i8);
            gregorianCalendar.set(2, i11 - 1);
            gregorianCalendar.set(5, i10);
            gregorianCalendar.set(11, i9);
            gregorianCalendar.set(12, i12);
            gregorianCalendar.set(13, i13);
            gregorianCalendar.set(14, 0);
            return gregorianCalendar.getTimeInMillis();
        }

        private final long h(String str) {
            try {
                long parseLong = Long.parseLong(str);
                if (parseLong <= 0) {
                    return Long.MIN_VALUE;
                }
                return parseLong;
            } catch (NumberFormatException e6) {
                if (new v4.f("-?\\d+").a(str)) {
                    return v4.p.A(str, "-", false, 2, null) ? Long.MIN_VALUE : Long.MAX_VALUE;
                }
                throw e6;
            }
        }

        public final m c(u url, String setCookie) {
            kotlin.jvm.internal.k.e(url, "url");
            kotlin.jvm.internal.k.e(setCookie, "setCookie");
            return d(System.currentTimeMillis(), url, setCookie);
        }

        /* JADX WARN: Code restructure failed: missing block: B:88:0x0103, code lost:
        
            if (r1 > 253402300799999L) goto L59;
         */
        /* JADX WARN: Removed duplicated region for block: B:56:0x0115  */
        /* JADX WARN: Removed duplicated region for block: B:71:0x015b  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x0118  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final d5.m d(long r26, d5.u r28, java.lang.String r29) {
            /*
                Method dump skipped, instructions count: 380
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: d5.m.a.d(long, d5.u, java.lang.String):d5.m");
        }

        public final List<m> e(u url, t headers) {
            kotlin.jvm.internal.k.e(url, "url");
            kotlin.jvm.internal.k.e(headers, "headers");
            List<String> f6 = headers.f("Set-Cookie");
            int size = f6.size();
            ArrayList arrayList = null;
            for (int i6 = 0; i6 < size; i6++) {
                m c6 = c(url, f6.get(i6));
                if (c6 != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(c6);
                }
            }
            if (arrayList == null) {
                return f4.l.f();
            }
            List<m> unmodifiableList = Collections.unmodifiableList(arrayList);
            kotlin.jvm.internal.k.d(unmodifiableList, "Collections.unmodifiableList(cookies)");
            return unmodifiableList;
        }
    }

    private m(String str, String str2, long j6, String str3, String str4, boolean z5, boolean z6, boolean z7, boolean z8) {
        this.f3173a = str;
        this.f3174b = str2;
        this.f3175c = j6;
        this.f3176d = str3;
        this.f3177e = str4;
        this.f3178f = z5;
        this.f3179g = z6;
        this.f3180h = z7;
        this.f3181i = z8;
    }

    public /* synthetic */ m(String str, String str2, long j6, String str3, String str4, boolean z5, boolean z6, boolean z7, boolean z8, kotlin.jvm.internal.g gVar) {
        this(str, str2, j6, str3, str4, z5, z6, z7, z8);
    }

    public final String e() {
        return this.f3173a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof m) {
            m mVar = (m) obj;
            if (kotlin.jvm.internal.k.a(mVar.f3173a, this.f3173a) && kotlin.jvm.internal.k.a(mVar.f3174b, this.f3174b) && mVar.f3175c == this.f3175c && kotlin.jvm.internal.k.a(mVar.f3176d, this.f3176d) && kotlin.jvm.internal.k.a(mVar.f3177e, this.f3177e) && mVar.f3178f == this.f3178f && mVar.f3179g == this.f3179g && mVar.f3180h == this.f3180h && mVar.f3181i == this.f3181i) {
                return true;
            }
        }
        return false;
    }

    public final String f(boolean z5) {
        String b6;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f3173a);
        sb.append('=');
        sb.append(this.f3174b);
        if (this.f3180h) {
            if (this.f3175c == Long.MIN_VALUE) {
                b6 = "; max-age=0";
            } else {
                sb.append("; expires=");
                b6 = j5.c.b(new Date(this.f3175c));
            }
            sb.append(b6);
        }
        if (!this.f3181i) {
            sb.append("; domain=");
            if (z5) {
                sb.append(".");
            }
            sb.append(this.f3176d);
        }
        sb.append("; path=");
        sb.append(this.f3177e);
        if (this.f3178f) {
            sb.append("; secure");
        }
        if (this.f3179g) {
            sb.append("; httponly");
        }
        String sb2 = sb.toString();
        kotlin.jvm.internal.k.d(sb2, "toString()");
        return sb2;
    }

    public final String g() {
        return this.f3174b;
    }

    public int hashCode() {
        return ((((((((((((((((527 + this.f3173a.hashCode()) * 31) + this.f3174b.hashCode()) * 31) + l.a(this.f3175c)) * 31) + this.f3176d.hashCode()) * 31) + this.f3177e.hashCode()) * 31) + androidx.window.embedding.a.a(this.f3178f)) * 31) + androidx.window.embedding.a.a(this.f3179g)) * 31) + androidx.window.embedding.a.a(this.f3180h)) * 31) + androidx.window.embedding.a.a(this.f3181i);
    }

    public String toString() {
        return f(false);
    }
}
