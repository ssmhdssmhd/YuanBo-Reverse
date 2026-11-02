package j2;

import android.os.Bundle;
import h0.o;
import i2.c1;
import java.util.Arrays;
import org.checkerframework.dataflow.qual.Pure;

/* loaded from: classes.dex */
public final class c implements h0.o {

    /* renamed from: j, reason: collision with root package name */
    public static final c f6675j = new c(1, 2, 3, null);

    /* renamed from: k, reason: collision with root package name */
    private static final String f6676k = c1.s0(0);

    /* renamed from: l, reason: collision with root package name */
    private static final String f6677l = c1.s0(1);

    /* renamed from: m, reason: collision with root package name */
    private static final String f6678m = c1.s0(2);

    /* renamed from: n, reason: collision with root package name */
    private static final String f6679n = c1.s0(3);

    /* renamed from: o, reason: collision with root package name */
    public static final o.a<c> f6680o = new o.a() { // from class: j2.b
        @Override // h0.o.a
        public final h0.o a(Bundle bundle) {
            c d6;
            d6 = c.d(bundle);
            return d6;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final int f6681a;

    /* renamed from: b, reason: collision with root package name */
    public final int f6682b;

    /* renamed from: c, reason: collision with root package name */
    public final int f6683c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f6684d;

    /* renamed from: e, reason: collision with root package name */
    private int f6685e;

    public c(int i6, int i7, int i8, byte[] bArr) {
        this.f6681a = i6;
        this.f6682b = i7;
        this.f6683c = i8;
        this.f6684d = bArr;
    }

    @Pure
    public static int b(int i6) {
        if (i6 == 1) {
            return 1;
        }
        if (i6 != 9) {
            return (i6 == 4 || i6 == 5 || i6 == 6 || i6 == 7) ? 2 : -1;
        }
        return 6;
    }

    @Pure
    public static int c(int i6) {
        if (i6 == 1) {
            return 3;
        }
        if (i6 == 16) {
            return 6;
        }
        if (i6 != 18) {
            return (i6 == 6 || i6 == 7) ? 3 : -1;
        }
        return 7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ c d(Bundle bundle) {
        return new c(bundle.getInt(f6676k, -1), bundle.getInt(f6677l, -1), bundle.getInt(f6678m, -1), bundle.getByteArray(f6679n));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        return this.f6681a == cVar.f6681a && this.f6682b == cVar.f6682b && this.f6683c == cVar.f6683c && Arrays.equals(this.f6684d, cVar.f6684d);
    }

    public int hashCode() {
        if (this.f6685e == 0) {
            this.f6685e = ((((((527 + this.f6681a) * 31) + this.f6682b) * 31) + this.f6683c) * 31) + Arrays.hashCode(this.f6684d);
        }
        return this.f6685e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ColorInfo(");
        sb.append(this.f6681a);
        sb.append(", ");
        sb.append(this.f6682b);
        sb.append(", ");
        sb.append(this.f6683c);
        sb.append(", ");
        sb.append(this.f6684d != null);
        sb.append(")");
        return sb.toString();
    }
}
