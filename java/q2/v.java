package q2;

import java.math.BigDecimal;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public abstract class v implements w {

    /* renamed from: a, reason: collision with root package name */
    public static final v f8923a = new a("DOUBLE", 0);

    /* renamed from: b, reason: collision with root package name */
    public static final v f8924b = new v("LAZILY_PARSED_NUMBER", 1) { // from class: q2.v.b
        {
            a aVar = null;
        }

        @Override // q2.w
        public Number a(y2.a aVar) {
            return new s2.g(aVar.e0());
        }
    };

    /* renamed from: c, reason: collision with root package name */
    public static final v f8925c = new v("LONG_OR_DOUBLE", 2) { // from class: q2.v.c
        {
            a aVar = null;
        }

        @Override // q2.w
        public Number a(y2.a aVar) {
            String e02 = aVar.e0();
            try {
                try {
                    return Long.valueOf(Long.parseLong(e02));
                } catch (NumberFormatException e6) {
                    throw new o("Cannot parse " + e02 + "; at path " + aVar.I(), e6);
                }
            } catch (NumberFormatException unused) {
                Double valueOf = Double.valueOf(e02);
                if ((!valueOf.isInfinite() && !valueOf.isNaN()) || aVar.M()) {
                    return valueOf;
                }
                throw new y2.d("JSON forbids NaN and infinities: " + valueOf + "; at path " + aVar.I());
            }
        }
    };

    /* renamed from: d, reason: collision with root package name */
    public static final v f8926d = new v("BIG_DECIMAL", 3) { // from class: q2.v.d
        {
            a aVar = null;
        }

        @Override // q2.w
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public BigDecimal a(y2.a aVar) {
            String e02 = aVar.e0();
            try {
                return new BigDecimal(e02);
            } catch (NumberFormatException e6) {
                throw new o("Cannot parse " + e02 + "; at path " + aVar.I(), e6);
            }
        }
    };

    /* renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ v[] f8927e = b();

    enum a extends v {
        a(String str, int i6) {
            super(str, i6, null);
        }

        @Override // q2.w
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Double a(y2.a aVar) {
            return Double.valueOf(aVar.X());
        }
    }

    private v(String str, int i6) {
    }

    /* synthetic */ v(String str, int i6, a aVar) {
        this(str, i6);
    }

    private static /* synthetic */ v[] b() {
        return new v[]{f8923a, f8924b, f8925c, f8926d};
    }

    public static v valueOf(String str) {
        return (v) Enum.valueOf(v.class, str);
    }

    public static v[] values() {
        return (v[]) f8927e.clone();
    }
}
