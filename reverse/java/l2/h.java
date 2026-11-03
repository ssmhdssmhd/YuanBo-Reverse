package l2;

import javax.annotation.CheckForNull;

/* loaded from: classes.dex */
public final class h {
    public static <T> T a(@CheckForNull T t5, T t6) {
        if (t5 != null) {
            return t5;
        }
        if (t6 != null) {
            return t6;
        }
        throw new NullPointerException("Both parameters are null");
    }
}
