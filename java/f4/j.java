package f4;

/* loaded from: classes.dex */
public final class j extends t {
    public static /* bridge */ /* synthetic */ Appendable w(Iterable iterable, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i6, CharSequence charSequence4, o4.l lVar, int i7, Object obj) {
        Appendable v5;
        v5 = t.v(iterable, appendable, (r14 & 2) != 0 ? ", " : charSequence, (r14 & 4) != 0 ? "" : charSequence2, (r14 & 8) == 0 ? charSequence3 : "", (r14 & 16) != 0 ? -1 : i6, (r14 & 32) != 0 ? "..." : charSequence4, (r14 & 64) != 0 ? null : lVar);
        return v5;
    }
}
