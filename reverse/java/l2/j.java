package l2;

import java.util.Arrays;
import javax.annotation.CheckForNull;

/* loaded from: classes.dex */
public final class j extends e {
    public static boolean a(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int b(@CheckForNull Object... objArr) {
        return Arrays.hashCode(objArr);
    }
}
