package g4;

import java.util.Comparator;
import kotlin.jvm.internal.k;

/* loaded from: classes.dex */
final class f implements Comparator<Comparable<? super Object>> {

    /* renamed from: a, reason: collision with root package name */
    public static final f f4240a = new f();

    private f() {
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(Comparable<Object> a6, Comparable<Object> b6) {
        k.e(a6, "a");
        k.e(b6, "b");
        return b6.compareTo(a6);
    }

    @Override // java.util.Comparator
    public final Comparator<Comparable<? super Object>> reversed() {
        return e.f4239a;
    }
}
