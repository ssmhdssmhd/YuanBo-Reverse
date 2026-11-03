package q2;

import java.math.BigInteger;
import java.util.Objects;

/* loaded from: classes.dex */
public final class p extends k {

    /* renamed from: a, reason: collision with root package name */
    private final Object f8914a;

    public p(Boolean bool) {
        Objects.requireNonNull(bool);
        this.f8914a = bool;
    }

    public p(Number number) {
        Objects.requireNonNull(number);
        this.f8914a = number;
    }

    public p(String str) {
        Objects.requireNonNull(str);
        this.f8914a = str;
    }

    private static boolean p(p pVar) {
        Object obj = pVar.f8914a;
        if (!(obj instanceof Number)) {
            return false;
        }
        Number number = (Number) obj;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    @Override // q2.k
    public String e() {
        Object obj = this.f8914a;
        if (obj instanceof String) {
            return (String) obj;
        }
        if (q()) {
            return n().toString();
        }
        if (o()) {
            return ((Boolean) this.f8914a).toString();
        }
        throw new AssertionError("Unexpected value type: " + this.f8914a.getClass());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || p.class != obj.getClass()) {
            return false;
        }
        p pVar = (p) obj;
        if (this.f8914a == null) {
            return pVar.f8914a == null;
        }
        if (p(this) && p(pVar)) {
            return n().longValue() == pVar.n().longValue();
        }
        Object obj2 = this.f8914a;
        if (!(obj2 instanceof Number) || !(pVar.f8914a instanceof Number)) {
            return obj2.equals(pVar.f8914a);
        }
        double doubleValue = n().doubleValue();
        double doubleValue2 = pVar.n().doubleValue();
        if (doubleValue != doubleValue2) {
            return Double.isNaN(doubleValue) && Double.isNaN(doubleValue2);
        }
        return true;
    }

    public int hashCode() {
        long doubleToLongBits;
        if (this.f8914a == null) {
            return 31;
        }
        if (p(this)) {
            doubleToLongBits = n().longValue();
        } else {
            Object obj = this.f8914a;
            if (!(obj instanceof Number)) {
                return obj.hashCode();
            }
            doubleToLongBits = Double.doubleToLongBits(n().doubleValue());
        }
        return (int) ((doubleToLongBits >>> 32) ^ doubleToLongBits);
    }

    public boolean j() {
        return o() ? ((Boolean) this.f8914a).booleanValue() : Boolean.parseBoolean(e());
    }

    public double k() {
        return q() ? n().doubleValue() : Double.parseDouble(e());
    }

    public int l() {
        return q() ? n().intValue() : Integer.parseInt(e());
    }

    public long m() {
        return q() ? n().longValue() : Long.parseLong(e());
    }

    public Number n() {
        Object obj = this.f8914a;
        if (obj instanceof Number) {
            return (Number) obj;
        }
        if (obj instanceof String) {
            return new s2.g((String) obj);
        }
        throw new UnsupportedOperationException("Primitive is neither a number nor a string");
    }

    public boolean o() {
        return this.f8914a instanceof Boolean;
    }

    public boolean q() {
        return this.f8914a instanceof Number;
    }

    public boolean r() {
        return this.f8914a instanceof String;
    }
}
