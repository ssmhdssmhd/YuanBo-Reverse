package kotlinx.coroutines.internal;

/* loaded from: classes.dex */
public final class l {
    public static final void a(int i6) {
        if (!(i6 >= 1)) {
            throw new IllegalArgumentException(kotlin.jvm.internal.k.j("Expected positive parallelism level, but got ", Integer.valueOf(i6)).toString());
        }
    }
}
