package l2;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.annotation.CheckForNull;

/* loaded from: classes.dex */
public final class m {

    private static class b<T> implements l<T>, Serializable {

        /* renamed from: a, reason: collision with root package name */
        private final List<? extends l<? super T>> f7494a;

        private b(List<? extends l<? super T>> list) {
            this.f7494a = list;
        }

        @Override // l2.l
        public boolean apply(T t5) {
            for (int i6 = 0; i6 < this.f7494a.size(); i6++) {
                if (!this.f7494a.get(i6).apply(t5)) {
                    return false;
                }
            }
            return true;
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof b) {
                return this.f7494a.equals(((b) obj).f7494a);
            }
            return false;
        }

        public int hashCode() {
            return this.f7494a.hashCode() + 306654252;
        }

        public String toString() {
            return m.d("and", this.f7494a);
        }
    }

    public static <T> l<T> b(l<? super T> lVar, l<? super T> lVar2) {
        return new b(c((l) k.i(lVar), (l) k.i(lVar2)));
    }

    private static <T> List<l<? super T>> c(l<? super T> lVar, l<? super T> lVar2) {
        return Arrays.asList(lVar, lVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String d(String str, Iterable<?> iterable) {
        StringBuilder sb = new StringBuilder("Predicates.");
        sb.append(str);
        sb.append('(');
        boolean z5 = true;
        for (Object obj : iterable) {
            if (!z5) {
                sb.append(',');
            }
            sb.append(obj);
            z5 = false;
        }
        sb.append(')');
        return sb.toString();
    }
}
