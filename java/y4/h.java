package y4;

/* loaded from: classes.dex */
public final class h {
    public static final <E> f<E> a(int i6, e eVar, o4.l<? super E, e4.q> lVar) {
        if (i6 == -2) {
            return new d(eVar == e.SUSPEND ? f.f11147a.a() : 1, eVar, lVar);
        }
        if (i6 != -1) {
            return i6 != 0 ? i6 != Integer.MAX_VALUE ? (i6 == 1 && eVar == e.DROP_OLDEST) ? new m(lVar) : new d(i6, eVar, lVar) : new n(lVar) : eVar == e.SUSPEND ? new r(lVar) : new d(1, eVar, lVar);
        }
        if ((eVar != e.SUSPEND ? 0 : 1) != 0) {
            return new m(lVar);
        }
        throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
    }

    public static /* synthetic */ f b(int i6, e eVar, o4.l lVar, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i6 = 0;
        }
        if ((i7 & 2) != 0) {
            eVar = e.SUSPEND;
        }
        if ((i7 & 4) != 0) {
            lVar = null;
        }
        return a(i6, eVar, lVar);
    }
}
