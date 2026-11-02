package s4;

import f4.y;
import kotlin.jvm.internal.g;

/* loaded from: classes.dex */
public class a implements Iterable<Integer>, p4.a {

    /* renamed from: d, reason: collision with root package name */
    public static final C0142a f9294d = new C0142a(null);

    /* renamed from: a, reason: collision with root package name */
    private final int f9295a;

    /* renamed from: b, reason: collision with root package name */
    private final int f9296b;

    /* renamed from: c, reason: collision with root package name */
    private final int f9297c;

    /* renamed from: s4.a$a, reason: collision with other inner class name */
    public static final class C0142a {
        private C0142a() {
        }

        public /* synthetic */ C0142a(g gVar) {
            this();
        }

        public final a a(int i6, int i7, int i8) {
            return new a(i6, i7, i8);
        }
    }

    public a(int i6, int i7, int i8) {
        if (i8 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i8 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f9295a = i6;
        this.f9296b = j4.c.b(i6, i7, i8);
        this.f9297c = i8;
    }

    public final int b() {
        return this.f9295a;
    }

    public final int c() {
        return this.f9296b;
    }

    public final int d() {
        return this.f9297c;
    }

    @Override // java.lang.Iterable
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public y iterator() {
        return new b(this.f9295a, this.f9296b, this.f9297c);
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            if (!isEmpty() || !((a) obj).isEmpty()) {
                a aVar = (a) obj;
                if (this.f9295a != aVar.f9295a || this.f9296b != aVar.f9296b || this.f9297c != aVar.f9297c) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f9295a * 31) + this.f9296b) * 31) + this.f9297c;
    }

    public boolean isEmpty() {
        if (this.f9297c > 0) {
            if (this.f9295a > this.f9296b) {
                return true;
            }
        } else if (this.f9295a < this.f9296b) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb;
        int i6;
        if (this.f9297c > 0) {
            sb = new StringBuilder();
            sb.append(this.f9295a);
            sb.append("..");
            sb.append(this.f9296b);
            sb.append(" step ");
            i6 = this.f9297c;
        } else {
            sb = new StringBuilder();
            sb.append(this.f9295a);
            sb.append(" downTo ");
            sb.append(this.f9296b);
            sb.append(" step ");
            i6 = -this.f9297c;
        }
        sb.append(i6);
        return sb.toString();
    }
}
