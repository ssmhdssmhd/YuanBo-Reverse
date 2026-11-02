package l2;

import java.io.IOException;
import java.util.Iterator;
import java.util.Objects;
import javax.annotation.CheckForNull;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private final String f7493a;

    private g(String str) {
        this.f7493a = (String) k.i(str);
    }

    public static g d(char c6) {
        return new g(String.valueOf(c6));
    }

    public <A extends Appendable> A a(A a6, Iterator<? extends Object> it) {
        k.i(a6);
        if (it.hasNext()) {
            while (true) {
                a6.append(e(it.next()));
                if (!it.hasNext()) {
                    break;
                }
                a6.append(this.f7493a);
            }
        }
        return a6;
    }

    public final StringBuilder b(StringBuilder sb, Iterable<? extends Object> iterable) {
        return c(sb, iterable.iterator());
    }

    public final StringBuilder c(StringBuilder sb, Iterator<? extends Object> it) {
        try {
            a(sb, it);
            return sb;
        } catch (IOException e6) {
            throw new AssertionError(e6);
        }
    }

    CharSequence e(@CheckForNull Object obj) {
        Objects.requireNonNull(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }
}
