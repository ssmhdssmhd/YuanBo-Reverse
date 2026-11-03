package s4;

import kotlin.jvm.internal.k;
import s4.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends e {
    public static int b(int i6, int i7) {
        return i6 < i7 ? i7 : i6;
    }

    public static long c(long j6, long j7) {
        return j6 < j7 ? j7 : j6;
    }

    public static int d(int i6, int i7) {
        return i6 > i7 ? i7 : i6;
    }

    public static long e(long j6, long j7) {
        return j6 > j7 ? j7 : j6;
    }

    public static int f(int i6, int i7, int i8) {
        if (i7 <= i8) {
            return i6 < i7 ? i7 : i6 > i8 ? i8 : i6;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i8 + " is less than minimum " + i7 + '.');
    }

    public static a g(int i6, int i7) {
        return a.f9294d.a(i6, i7, -1);
    }

    public static a h(a aVar, int i6) {
        k.e(aVar, "<this>");
        e.a(i6 > 0, Integer.valueOf(i6));
        a.C0142a c0142a = a.f9294d;
        int b6 = aVar.b();
        int c6 = aVar.c();
        if (aVar.d() <= 0) {
            i6 = -i6;
        }
        return c0142a.a(b6, c6, i6);
    }

    public static c i(int i6, int i7) {
        return i7 <= Integer.MIN_VALUE ? c.f9302e.a() : new c(i6, i7 - 1);
    }
}
