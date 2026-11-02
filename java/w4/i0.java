package w4;

/* loaded from: classes.dex */
public enum i0 {
    DEFAULT,
    LAZY,
    ATOMIC,
    UNDISPATCHED;

    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10308a;

        static {
            int[] iArr = new int[i0.values().length];
            iArr[i0.DEFAULT.ordinal()] = 1;
            iArr[i0.ATOMIC.ordinal()] = 2;
            iArr[i0.UNDISPATCHED.ordinal()] = 3;
            iArr[i0.LAZY.ordinal()] = 4;
            f10308a = iArr;
        }
    }

    public final <R, T> void b(o4.p<? super R, ? super h4.d<? super T>, ? extends Object> pVar, R r6, h4.d<? super T> dVar) {
        int i6 = a.f10308a[ordinal()];
        if (i6 == 1) {
            b5.a.d(pVar, r6, dVar, null, 4, null);
            return;
        }
        if (i6 == 2) {
            h4.f.a(pVar, r6, dVar);
        } else if (i6 == 3) {
            b5.b.a(pVar, r6, dVar);
        } else if (i6 != 4) {
            throw new e4.i();
        }
    }

    public final boolean c() {
        return this == LAZY;
    }
}
