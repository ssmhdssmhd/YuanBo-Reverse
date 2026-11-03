package s4;

import kotlin.jvm.internal.k;

/* loaded from: classes.dex */
class e {
    public static final void a(boolean z5, Number step) {
        k.e(step, "step");
        if (z5) {
            return;
        }
        throw new IllegalArgumentException("Step must be positive, was: " + step + '.');
    }
}
