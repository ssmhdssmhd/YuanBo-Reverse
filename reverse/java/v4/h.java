package v4;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.Object] */
    public static <T> void a(Appendable appendable, T t5, o4.l<? super T, ? extends CharSequence> lVar) {
        CharSequence valueOf;
        kotlin.jvm.internal.k.e(appendable, "<this>");
        if (lVar != null) {
            t5 = (T) lVar.invoke(t5);
        } else {
            if (!(t5 == 0 ? true : t5 instanceof CharSequence)) {
                if (t5 instanceof Character) {
                    appendable.append(((Character) t5).charValue());
                    return;
                } else {
                    valueOf = String.valueOf((Object) t5);
                    appendable.append(valueOf);
                }
            }
        }
        valueOf = (CharSequence) t5;
        appendable.append(valueOf);
    }
}
