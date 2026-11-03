package m2;

import javax.annotation.CheckForNull;

/* loaded from: classes.dex */
final class n {
    static int a(int i6) {
        return (int) (Integer.rotateLeft((int) (i6 * (-862048943)), 15) * 461845907);
    }

    static int b(@CheckForNull Object obj) {
        return a(obj == null ? 0 : obj.hashCode());
    }
}
