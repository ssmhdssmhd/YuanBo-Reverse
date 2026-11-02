package kotlinx.coroutines.scheduling;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes.dex */
public final /* synthetic */ class n {
    public static /* synthetic */ boolean a(AtomicReferenceArray atomicReferenceArray, int i6, Object obj, Object obj2) {
        while (!atomicReferenceArray.compareAndSet(i6, obj, obj2)) {
            if (atomicReferenceArray.get(i6) != obj) {
                return false;
            }
        }
        return true;
    }
}
