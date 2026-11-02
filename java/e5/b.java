package e5;

import d5.a0;
import d5.c0;
import d5.e;
import d5.r;
import d5.t;
import d5.u;
import d5.x;
import f4.l;
import f4.m;
import f4.y;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.k;
import l5.c;
import q5.b0;
import q5.g;
import q5.h;
import q5.r;
import v4.f;
import v4.q;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f3711a;

    /* renamed from: b, reason: collision with root package name */
    public static final t f3712b = t.f3203b.g(new String[0]);

    /* renamed from: c, reason: collision with root package name */
    public static final c0 f3713c;

    /* renamed from: d, reason: collision with root package name */
    public static final a0 f3714d;

    /* renamed from: e, reason: collision with root package name */
    private static final r f3715e;

    /* renamed from: f, reason: collision with root package name */
    public static final TimeZone f3716f;

    /* renamed from: g, reason: collision with root package name */
    private static final f f3717g;

    /* renamed from: h, reason: collision with root package name */
    public static final boolean f3718h;

    /* renamed from: i, reason: collision with root package name */
    public static final String f3719i;

    static final class a implements r.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d5.r f3720a;

        a(d5.r rVar) {
            this.f3720a = rVar;
        }

        @Override // d5.r.c
        public final d5.r a(e it) {
            k.e(it, "it");
            return this.f3720a;
        }
    }

    /* renamed from: e5.b$b, reason: collision with other inner class name */
    static final class ThreadFactoryC0069b implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f3721a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f3722b;

        ThreadFactoryC0069b(String str, boolean z5) {
            this.f3721a = str;
            this.f3722b = z5;
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.f3721a);
            thread.setDaemon(this.f3722b);
            return thread;
        }
    }

    static {
        String e02;
        String f02;
        byte[] bArr = new byte[0];
        f3711a = bArr;
        f3713c = c0.a.c(c0.f3029a, bArr, null, 1, null);
        f3714d = a0.a.d(a0.f2994a, bArr, null, 0, 0, 7, null);
        r.a aVar = q5.r.f8978d;
        h.a aVar2 = h.f8959e;
        f3715e = aVar.d(aVar2.a("efbbbf"), aVar2.a("feff"), aVar2.a("fffe"), aVar2.a("0000ffff"), aVar2.a("ffff0000"));
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        k.b(timeZone);
        f3716f = timeZone;
        f3717g = new f("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
        f3718h = false;
        String name = x.class.getName();
        k.d(name, "OkHttpClient::class.java.name");
        e02 = q.e0(name, "okhttp3.");
        f02 = q.f0(e02, "Client");
        f3719i = f02;
    }

    public static final String[] A(String[] intersect, String[] other, Comparator<? super String> comparator) {
        k.e(intersect, "$this$intersect");
        k.e(other, "other");
        k.e(comparator, "comparator");
        ArrayList arrayList = new ArrayList();
        for (String str : intersect) {
            int length = other.length;
            int i6 = 0;
            while (true) {
                if (i6 >= length) {
                    break;
                }
                if (comparator.compare(str, other[i6]) == 0) {
                    arrayList.add(str);
                    break;
                }
                i6++;
            }
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public static final boolean B(Socket isHealthy, g source) {
        k.e(isHealthy, "$this$isHealthy");
        k.e(source, "source");
        try {
            int soTimeout = isHealthy.getSoTimeout();
            try {
                isHealthy.setSoTimeout(1);
                boolean z5 = !source.y();
                isHealthy.setSoTimeout(soTimeout);
                return z5;
            } catch (Throwable th) {
                isHealthy.setSoTimeout(soTimeout);
                throw th;
            }
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        }
    }

    public static final int C(char c6) {
        if ('0' <= c6 && '9' >= c6) {
            return c6 - '0';
        }
        char c7 = 'a';
        if ('a' > c6 || 'f' < c6) {
            c7 = 'A';
            if ('A' > c6 || 'F' < c6) {
                return -1;
            }
        }
        return (c6 - c7) + 10;
    }

    public static final int D(g readMedium) {
        k.e(readMedium, "$this$readMedium");
        return b(readMedium.readByte(), 255) | (b(readMedium.readByte(), 255) << 16) | (b(readMedium.readByte(), 255) << 8);
    }

    public static final int E(q5.e skipAll, byte b6) {
        k.e(skipAll, "$this$skipAll");
        int i6 = 0;
        while (!skipAll.y() && skipAll.v(0L) == b6) {
            i6++;
            skipAll.readByte();
        }
        return i6;
    }

    public static final boolean F(q5.a0 skipAll, int i6, TimeUnit timeUnit) {
        k.e(skipAll, "$this$skipAll");
        k.e(timeUnit, "timeUnit");
        long nanoTime = System.nanoTime();
        long c6 = skipAll.c().e() ? skipAll.c().c() - nanoTime : Long.MAX_VALUE;
        skipAll.c().d(Math.min(c6, timeUnit.toNanos(i6)) + nanoTime);
        try {
            q5.e eVar = new q5.e();
            while (skipAll.C(eVar, 8192L) != -1) {
                eVar.a();
            }
            b0 c7 = skipAll.c();
            if (c6 == Long.MAX_VALUE) {
                c7.a();
            } else {
                c7.d(nanoTime + c6);
            }
            return true;
        } catch (InterruptedIOException unused) {
            b0 c8 = skipAll.c();
            if (c6 == Long.MAX_VALUE) {
                c8.a();
            } else {
                c8.d(nanoTime + c6);
            }
            return false;
        } catch (Throwable th) {
            b0 c9 = skipAll.c();
            if (c6 == Long.MAX_VALUE) {
                c9.a();
            } else {
                c9.d(nanoTime + c6);
            }
            throw th;
        }
    }

    public static final ThreadFactory G(String name, boolean z5) {
        k.e(name, "name");
        return new ThreadFactoryC0069b(name, z5);
    }

    public static final List<c> H(t toHeaderList) {
        s4.c i6;
        int n6;
        k.e(toHeaderList, "$this$toHeaderList");
        i6 = s4.f.i(0, toHeaderList.size());
        n6 = m.n(i6, 10);
        ArrayList arrayList = new ArrayList(n6);
        Iterator<Integer> it = i6.iterator();
        while (it.hasNext()) {
            int nextInt = ((y) it).nextInt();
            arrayList.add(new c(toHeaderList.c(nextInt), toHeaderList.e(nextInt)));
        }
        return arrayList;
    }

    public static final t I(List<c> toHeaders) {
        k.e(toHeaders, "$this$toHeaders");
        t.a aVar = new t.a();
        for (c cVar : toHeaders) {
            aVar.c(cVar.a().u(), cVar.b().u());
        }
        return aVar.d();
    }

    public static final String J(u toHostHeader, boolean z5) {
        boolean F;
        String h6;
        k.e(toHostHeader, "$this$toHostHeader");
        F = q.F(toHostHeader.h(), ":", false, 2, null);
        if (F) {
            h6 = '[' + toHostHeader.h() + ']';
        } else {
            h6 = toHostHeader.h();
        }
        if (!z5 && toHostHeader.l() == u.f3207l.c(toHostHeader.p())) {
            return h6;
        }
        return h6 + ':' + toHostHeader.l();
    }

    public static /* synthetic */ String K(u uVar, boolean z5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            z5 = false;
        }
        return J(uVar, z5);
    }

    public static final <T> List<T> L(List<? extends T> toImmutableList) {
        k.e(toImmutableList, "$this$toImmutableList");
        List<T> unmodifiableList = Collections.unmodifiableList(f4.t.J(toImmutableList));
        k.d(unmodifiableList, "Collections.unmodifiableList(toMutableList())");
        return unmodifiableList;
    }

    public static final <K, V> Map<K, V> M(Map<K, ? extends V> toImmutableMap) {
        Map<K, V> d6;
        k.e(toImmutableMap, "$this$toImmutableMap");
        if (toImmutableMap.isEmpty()) {
            d6 = f4.c0.d();
            return d6;
        }
        Map<K, V> unmodifiableMap = Collections.unmodifiableMap(new LinkedHashMap(toImmutableMap));
        k.d(unmodifiableMap, "Collections.unmodifiableMap(LinkedHashMap(this))");
        return unmodifiableMap;
    }

    public static final long N(String toLongOrDefault, long j6) {
        k.e(toLongOrDefault, "$this$toLongOrDefault");
        try {
            return Long.parseLong(toLongOrDefault);
        } catch (NumberFormatException unused) {
            return j6;
        }
    }

    public static final int O(String str, int i6) {
        if (str != null) {
            try {
                long parseLong = Long.parseLong(str);
                if (parseLong > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if (parseLong < 0) {
                    return 0;
                }
                return (int) parseLong;
            } catch (NumberFormatException unused) {
            }
        }
        return i6;
    }

    public static final String P(String trimSubstring, int i6, int i7) {
        k.e(trimSubstring, "$this$trimSubstring");
        int v5 = v(trimSubstring, i6, i7);
        String substring = trimSubstring.substring(v5, x(trimSubstring, v5, i7));
        k.d(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String Q(String str, int i6, int i7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i6 = 0;
        }
        if ((i8 & 2) != 0) {
            i7 = str.length();
        }
        return P(str, i6, i7);
    }

    public static final Throwable R(Exception withSuppressed, List<? extends Exception> suppressed) {
        k.e(withSuppressed, "$this$withSuppressed");
        k.e(suppressed, "suppressed");
        if (suppressed.size() > 1) {
            System.out.println(suppressed);
        }
        Iterator<? extends Exception> it = suppressed.iterator();
        while (it.hasNext()) {
            e4.b.a(withSuppressed, it.next());
        }
        return withSuppressed;
    }

    public static final void S(q5.f writeMedium, int i6) {
        k.e(writeMedium, "$this$writeMedium");
        writeMedium.writeByte((i6 >>> 16) & 255);
        writeMedium.writeByte((i6 >>> 8) & 255);
        writeMedium.writeByte(i6 & 255);
    }

    public static final <E> void a(List<E> addIfAbsent, E e6) {
        k.e(addIfAbsent, "$this$addIfAbsent");
        if (addIfAbsent.contains(e6)) {
            return;
        }
        addIfAbsent.add(e6);
    }

    public static final int b(byte b6, int i6) {
        return b6 & i6;
    }

    public static final int c(short s5, int i6) {
        return s5 & i6;
    }

    public static final long d(int i6, long j6) {
        return i6 & j6;
    }

    public static final r.c e(d5.r asFactory) {
        k.e(asFactory, "$this$asFactory");
        return new a(asFactory);
    }

    public static final boolean f(String canParseAsIpAddress) {
        k.e(canParseAsIpAddress, "$this$canParseAsIpAddress");
        return f3717g.a(canParseAsIpAddress);
    }

    public static final boolean g(u canReuseConnectionFor, u other) {
        k.e(canReuseConnectionFor, "$this$canReuseConnectionFor");
        k.e(other, "other");
        return k.a(canReuseConnectionFor.h(), other.h()) && canReuseConnectionFor.l() == other.l() && k.a(canReuseConnectionFor.p(), other.p());
    }

    public static final void h(long j6, long j7, long j8) {
        if ((j7 | j8) < 0 || j7 > j6 || j6 - j7 < j8) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static final void i(Closeable closeQuietly) {
        k.e(closeQuietly, "$this$closeQuietly");
        try {
            closeQuietly.close();
        } catch (RuntimeException e6) {
            throw e6;
        } catch (Exception unused) {
        }
    }

    public static final void j(Socket closeQuietly) {
        k.e(closeQuietly, "$this$closeQuietly");
        try {
            closeQuietly.close();
        } catch (AssertionError e6) {
            throw e6;
        } catch (RuntimeException e7) {
            throw e7;
        } catch (Exception unused) {
        }
    }

    public static final String[] k(String[] concat, String value) {
        int n6;
        k.e(concat, "$this$concat");
        k.e(value, "value");
        Object[] copyOf = Arrays.copyOf(concat, concat.length + 1);
        k.d(copyOf, "java.util.Arrays.copyOf(this, newSize)");
        String[] strArr = (String[]) copyOf;
        n6 = f4.h.n(strArr);
        strArr[n6] = value;
        return strArr;
    }

    public static final int l(String delimiterOffset, char c6, int i6, int i7) {
        k.e(delimiterOffset, "$this$delimiterOffset");
        while (i6 < i7) {
            if (delimiterOffset.charAt(i6) == c6) {
                return i6;
            }
            i6++;
        }
        return i7;
    }

    public static final int m(String delimiterOffset, String delimiters, int i6, int i7) {
        boolean E;
        k.e(delimiterOffset, "$this$delimiterOffset");
        k.e(delimiters, "delimiters");
        while (i6 < i7) {
            E = q.E(delimiters, delimiterOffset.charAt(i6), false, 2, null);
            if (E) {
                return i6;
            }
            i6++;
        }
        return i7;
    }

    public static /* synthetic */ int n(String str, char c6, int i6, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i6 = 0;
        }
        if ((i8 & 4) != 0) {
            i7 = str.length();
        }
        return l(str, c6, i6, i7);
    }

    public static final boolean o(q5.a0 discard, int i6, TimeUnit timeUnit) {
        k.e(discard, "$this$discard");
        k.e(timeUnit, "timeUnit");
        try {
            return F(discard, i6, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static final String p(String format, Object... args) {
        k.e(format, "format");
        k.e(args, "args");
        kotlin.jvm.internal.u uVar = kotlin.jvm.internal.u.f7016a;
        Locale locale = Locale.US;
        Object[] copyOf = Arrays.copyOf(args, args.length);
        String format2 = String.format(locale, format, Arrays.copyOf(copyOf, copyOf.length));
        k.d(format2, "java.lang.String.format(locale, format, *args)");
        return format2;
    }

    public static final boolean q(String[] hasIntersection, String[] strArr, Comparator<? super String> comparator) {
        k.e(hasIntersection, "$this$hasIntersection");
        k.e(comparator, "comparator");
        if (!(hasIntersection.length == 0) && strArr != null) {
            if (!(strArr.length == 0)) {
                for (String str : hasIntersection) {
                    for (String str2 : strArr) {
                        if (comparator.compare(str, str2) == 0) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static final long r(d5.b0 headersContentLength) {
        k.e(headersContentLength, "$this$headersContentLength");
        String b6 = headersContentLength.I().b("Content-Length");
        if (b6 != null) {
            return N(b6, -1L);
        }
        return -1L;
    }

    @SafeVarargs
    public static final <T> List<T> s(T... elements) {
        List h6;
        k.e(elements, "elements");
        Object[] objArr = (Object[]) elements.clone();
        h6 = l.h(Arrays.copyOf(objArr, objArr.length));
        List<T> unmodifiableList = Collections.unmodifiableList(h6);
        k.d(unmodifiableList, "Collections.unmodifiable…istOf(*elements.clone()))");
        return unmodifiableList;
    }

    public static final int t(String[] indexOf, String value, Comparator<String> comparator) {
        k.e(indexOf, "$this$indexOf");
        k.e(value, "value");
        k.e(comparator, "comparator");
        int length = indexOf.length;
        for (int i6 = 0; i6 < length; i6++) {
            if (comparator.compare(indexOf[i6], value) == 0) {
                return i6;
            }
        }
        return -1;
    }

    public static final int u(String indexOfControlOrNonAscii) {
        k.e(indexOfControlOrNonAscii, "$this$indexOfControlOrNonAscii");
        int length = indexOfControlOrNonAscii.length();
        for (int i6 = 0; i6 < length; i6++) {
            char charAt = indexOfControlOrNonAscii.charAt(i6);
            if (k.f(charAt, 31) <= 0 || k.f(charAt, 127) >= 0) {
                return i6;
            }
        }
        return -1;
    }

    public static final int v(String indexOfFirstNonAsciiWhitespace, int i6, int i7) {
        k.e(indexOfFirstNonAsciiWhitespace, "$this$indexOfFirstNonAsciiWhitespace");
        while (i6 < i7) {
            char charAt = indexOfFirstNonAsciiWhitespace.charAt(i6);
            if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                return i6;
            }
            i6++;
        }
        return i7;
    }

    public static /* synthetic */ int w(String str, int i6, int i7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i6 = 0;
        }
        if ((i8 & 2) != 0) {
            i7 = str.length();
        }
        return v(str, i6, i7);
    }

    public static final int x(String indexOfLastNonAsciiWhitespace, int i6, int i7) {
        k.e(indexOfLastNonAsciiWhitespace, "$this$indexOfLastNonAsciiWhitespace");
        int i8 = i7 - 1;
        if (i8 >= i6) {
            while (true) {
                char charAt = indexOfLastNonAsciiWhitespace.charAt(i8);
                if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                    return i8 + 1;
                }
                if (i8 == i6) {
                    break;
                }
                i8--;
            }
        }
        return i6;
    }

    public static /* synthetic */ int y(String str, int i6, int i7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i6 = 0;
        }
        if ((i8 & 2) != 0) {
            i7 = str.length();
        }
        return x(str, i6, i7);
    }

    public static final int z(String indexOfNonWhitespace, int i6) {
        k.e(indexOfNonWhitespace, "$this$indexOfNonWhitespace");
        int length = indexOfNonWhitespace.length();
        while (i6 < length) {
            char charAt = indexOfNonWhitespace.charAt(i6);
            if (charAt != ' ' && charAt != '\t') {
                return i6;
            }
            i6++;
        }
        return indexOfNonWhitespace.length();
    }
}
