package t2;

import q2.s;
import q2.v;
import q2.w;
import q2.x;
import q2.y;

/* loaded from: classes.dex */
public final class i extends x<Number> {

    /* renamed from: b, reason: collision with root package name */
    private static final y f9422b = f(v.f8924b);

    /* renamed from: a, reason: collision with root package name */
    private final w f9423a;

    class a implements y {
        a() {
        }

        @Override // q2.y
        public <T> x<T> a(q2.e eVar, x2.a<T> aVar) {
            if (aVar.c() == Number.class) {
                return i.this;
            }
            return null;
        }
    }

    static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f9425a;

        static {
            int[] iArr = new int[y2.b.values().length];
            f9425a = iArr;
            try {
                iArr[y2.b.NULL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9425a[y2.b.NUMBER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9425a[y2.b.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private i(w wVar) {
        this.f9423a = wVar;
    }

    public static y e(w wVar) {
        return wVar == v.f8924b ? f9422b : f(wVar);
    }

    private static y f(w wVar) {
        return new i(wVar).new a();
    }

    @Override // q2.x
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public Number b(y2.a aVar) {
        y2.b g02 = aVar.g0();
        int i6 = b.f9425a[g02.ordinal()];
        if (i6 == 1) {
            aVar.c0();
            return null;
        }
        if (i6 == 2 || i6 == 3) {
            return this.f9423a.a(aVar);
        }
        throw new s("Expecting number, got: " + g02 + "; at path " + aVar.z());
    }

    @Override // q2.x
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void d(y2.c cVar, Number number) {
        cVar.i0(number);
    }
}
