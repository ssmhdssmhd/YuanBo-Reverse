package v4;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
final class e implements u4.d<s4.c> {

    /* renamed from: a, reason: collision with root package name */
    private final CharSequence f9886a;

    /* renamed from: b, reason: collision with root package name */
    private final int f9887b;

    /* renamed from: c, reason: collision with root package name */
    private final int f9888c;

    /* renamed from: d, reason: collision with root package name */
    private final o4.p<CharSequence, Integer, e4.j<Integer, Integer>> f9889d;

    public static final class a implements Iterator<s4.c>, p4.a {

        /* renamed from: a, reason: collision with root package name */
        private int f9890a = -1;

        /* renamed from: b, reason: collision with root package name */
        private int f9891b;

        /* renamed from: c, reason: collision with root package name */
        private int f9892c;

        /* renamed from: d, reason: collision with root package name */
        private s4.c f9893d;

        /* renamed from: e, reason: collision with root package name */
        private int f9894e;

        a() {
            int f6;
            f6 = s4.f.f(e.this.f9887b, 0, e.this.f9886a.length());
            this.f9891b = f6;
            this.f9892c = f6;
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0021, code lost:
        
            if (r0 < r6.f9895j.f9888c) goto L9;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private final void a() {
            /*
                r6 = this;
                int r0 = r6.f9892c
                r1 = 0
                if (r0 >= 0) goto Lc
                r6.f9890a = r1
                r0 = 0
                r6.f9893d = r0
                goto L99
            Lc:
                v4.e r0 = v4.e.this
                int r0 = v4.e.d(r0)
                r2 = -1
                r3 = 1
                if (r0 <= 0) goto L23
                int r0 = r6.f9894e
                int r0 = r0 + r3
                r6.f9894e = r0
                v4.e r4 = v4.e.this
                int r4 = v4.e.d(r4)
                if (r0 >= r4) goto L31
            L23:
                int r0 = r6.f9892c
                v4.e r4 = v4.e.this
                java.lang.CharSequence r4 = v4.e.c(r4)
                int r4 = r4.length()
                if (r0 <= r4) goto L47
            L31:
                s4.c r0 = new s4.c
                int r1 = r6.f9891b
                v4.e r4 = v4.e.this
                java.lang.CharSequence r4 = v4.e.c(r4)
                int r4 = v4.q.K(r4)
                r0.<init>(r1, r4)
            L42:
                r6.f9893d = r0
            L44:
                r6.f9892c = r2
                goto L97
            L47:
                v4.e r0 = v4.e.this
                o4.p r0 = v4.e.b(r0)
                v4.e r4 = v4.e.this
                java.lang.CharSequence r4 = v4.e.c(r4)
                int r5 = r6.f9892c
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r0 = r0.invoke(r4, r5)
                e4.j r0 = (e4.j) r0
                if (r0 != 0) goto L73
                s4.c r0 = new s4.c
                int r1 = r6.f9891b
                v4.e r4 = v4.e.this
                java.lang.CharSequence r4 = v4.e.c(r4)
                int r4 = v4.q.K(r4)
                r0.<init>(r1, r4)
                goto L42
            L73:
                java.lang.Object r2 = r0.a()
                java.lang.Number r2 = (java.lang.Number) r2
                int r2 = r2.intValue()
                java.lang.Object r0 = r0.b()
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                int r4 = r6.f9891b
                s4.c r4 = s4.d.i(r4, r2)
                r6.f9893d = r4
                int r2 = r2 + r0
                r6.f9891b = r2
                if (r0 != 0) goto L95
                r1 = 1
            L95:
                int r2 = r2 + r1
                goto L44
            L97:
                r6.f9890a = r3
            L99:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: v4.e.a.a():void");
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public s4.c next() {
            if (this.f9890a == -1) {
                a();
            }
            if (this.f9890a == 0) {
                throw new NoSuchElementException();
            }
            s4.c cVar = this.f9893d;
            kotlin.jvm.internal.k.c(cVar, "null cannot be cast to non-null type kotlin.ranges.IntRange");
            this.f9893d = null;
            this.f9890a = -1;
            return cVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f9890a == -1) {
                a();
            }
            return this.f9890a == 1;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(CharSequence input, int i6, int i7, o4.p<? super CharSequence, ? super Integer, e4.j<Integer, Integer>> getNextMatch) {
        kotlin.jvm.internal.k.e(input, "input");
        kotlin.jvm.internal.k.e(getNextMatch, "getNextMatch");
        this.f9886a = input;
        this.f9887b = i6;
        this.f9888c = i7;
        this.f9889d = getNextMatch;
    }

    @Override // u4.d
    public Iterator<s4.c> iterator() {
        return new a();
    }
}
