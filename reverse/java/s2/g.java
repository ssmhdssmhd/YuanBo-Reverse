package s2;

import java.math.BigDecimal;

/* loaded from: classes.dex */
public final class g extends Number {

    /* renamed from: a, reason: collision with root package name */
    private final String f9255a;

    public g(String str) {
        this.f9255a = str;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return Double.parseDouble(this.f9255a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        String str = this.f9255a;
        String str2 = ((g) obj).f9255a;
        return str == str2 || str.equals(str2);
    }

    @Override // java.lang.Number
    public float floatValue() {
        return Float.parseFloat(this.f9255a);
    }

    public int hashCode() {
        return this.f9255a.hashCode();
    }

    @Override // java.lang.Number
    public int intValue() {
        try {
            try {
                return Integer.parseInt(this.f9255a);
            } catch (NumberFormatException unused) {
                return (int) Long.parseLong(this.f9255a);
            }
        } catch (NumberFormatException unused2) {
            return new BigDecimal(this.f9255a).intValue();
        }
    }

    @Override // java.lang.Number
    public long longValue() {
        try {
            return Long.parseLong(this.f9255a);
        } catch (NumberFormatException unused) {
            return new BigDecimal(this.f9255a).longValue();
        }
    }

    public String toString() {
        return this.f9255a;
    }
}
