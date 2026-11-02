package l2;

/* loaded from: classes.dex */
public abstract class c implements l<Character> {

    static abstract class a extends c {
        a() {
        }

        @Override // l2.l
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.b(ch);
        }
    }

    private static final class b extends a {

        /* renamed from: a, reason: collision with root package name */
        private final char f7484a;

        b(char c6) {
            this.f7484a = c6;
        }

        @Override // l2.c
        public boolean e(char c6) {
            return c6 == this.f7484a;
        }

        public String toString() {
            String g6 = c.g(this.f7484a);
            StringBuilder sb = new StringBuilder(String.valueOf(g6).length() + 18);
            sb.append("CharMatcher.is('");
            sb.append(g6);
            sb.append("')");
            return sb.toString();
        }
    }

    /* renamed from: l2.c$c, reason: collision with other inner class name */
    static abstract class AbstractC0108c extends a {

        /* renamed from: a, reason: collision with root package name */
        private final String f7485a;

        AbstractC0108c(String str) {
            this.f7485a = (String) k.i(str);
        }

        public final String toString() {
            return this.f7485a;
        }
    }

    private static final class d extends AbstractC0108c {

        /* renamed from: b, reason: collision with root package name */
        static final d f7486b = new d();

        private d() {
            super("CharMatcher.none()");
        }

        @Override // l2.c
        public int c(CharSequence charSequence, int i6) {
            k.k(i6, charSequence.length());
            return -1;
        }

        @Override // l2.c
        public boolean e(char c6) {
            return false;
        }
    }

    protected c() {
    }

    public static c d(char c6) {
        return new b(c6);
    }

    public static c f() {
        return d.f7486b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String g(char c6) {
        char[] cArr = {'\\', 'u', 0, 0, 0, 0};
        for (int i6 = 0; i6 < 4; i6++) {
            cArr[5 - i6] = "0123456789ABCDEF".charAt(c6 & 15);
            c6 = (char) (c6 >> 4);
        }
        return String.copyValueOf(cArr);
    }

    @Deprecated
    public boolean b(Character ch) {
        return e(ch.charValue());
    }

    public int c(CharSequence charSequence, int i6) {
        int length = charSequence.length();
        k.k(i6, length);
        while (i6 < length) {
            if (e(charSequence.charAt(i6))) {
                return i6;
            }
            i6++;
        }
        return -1;
    }

    public abstract boolean e(char c6);
}
