package l2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    private final l2.c f7495a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f7496b;

    /* renamed from: c, reason: collision with root package name */
    private final c f7497c;

    /* renamed from: d, reason: collision with root package name */
    private final int f7498d;

    class a implements c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ l2.c f7499a;

        /* renamed from: l2.n$a$a, reason: collision with other inner class name */
        class C0109a extends b {
            C0109a(n nVar, CharSequence charSequence) {
                super(nVar, charSequence);
            }

            @Override // l2.n.b
            int e(int i6) {
                return i6 + 1;
            }

            @Override // l2.n.b
            int f(int i6) {
                return a.this.f7499a.c(this.f7501c, i6);
            }
        }

        a(l2.c cVar) {
            this.f7499a = cVar;
        }

        @Override // l2.n.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public b a(n nVar, CharSequence charSequence) {
            return new C0109a(nVar, charSequence);
        }
    }

    private static abstract class b extends l2.a<String> {

        /* renamed from: c, reason: collision with root package name */
        final CharSequence f7501c;

        /* renamed from: d, reason: collision with root package name */
        final l2.c f7502d;

        /* renamed from: e, reason: collision with root package name */
        final boolean f7503e;

        /* renamed from: j, reason: collision with root package name */
        int f7504j = 0;

        /* renamed from: k, reason: collision with root package name */
        int f7505k;

        protected b(n nVar, CharSequence charSequence) {
            this.f7502d = nVar.f7495a;
            this.f7503e = nVar.f7496b;
            this.f7505k = nVar.f7498d;
            this.f7501c = charSequence;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x002f, code lost:
        
            if (r0 >= r1) goto L48;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x003d, code lost:
        
            if (r6.f7502d.e(r6.f7501c.charAt(r0)) == false) goto L47;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x003f, code lost:
        
            r0 = r0 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0042, code lost:
        
            if (r1 <= r0) goto L49;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0052, code lost:
        
            if (r6.f7502d.e(r6.f7501c.charAt(r1 - 1)) == false) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0054, code lost:
        
            r1 = r1 - 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0059, code lost:
        
            if (r6.f7503e == false) goto L39;
         */
        @Override // l2.a
        @javax.annotation.CheckForNull
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.String a() {
            /*
                r6 = this;
            L0:
                int r0 = r6.f7504j
            L2:
                int r1 = r6.f7504j
                r2 = -1
                if (r1 == r2) goto L8e
                int r1 = r6.f(r1)
                if (r1 != r2) goto L16
                java.lang.CharSequence r1 = r6.f7501c
                int r1 = r1.length()
                r6.f7504j = r2
                goto L1c
            L16:
                int r3 = r6.e(r1)
                r6.f7504j = r3
            L1c:
                int r3 = r6.f7504j
                if (r3 != r0) goto L2f
                int r3 = r3 + 1
                r6.f7504j = r3
                java.lang.CharSequence r1 = r6.f7501c
                int r1 = r1.length()
                if (r3 <= r1) goto L2
                r6.f7504j = r2
                goto L2
            L2f:
                if (r0 >= r1) goto L42
                l2.c r3 = r6.f7502d
                java.lang.CharSequence r4 = r6.f7501c
                char r4 = r4.charAt(r0)
                boolean r3 = r3.e(r4)
                if (r3 == 0) goto L42
                int r0 = r0 + 1
                goto L2f
            L42:
                if (r1 <= r0) goto L57
                l2.c r3 = r6.f7502d
                java.lang.CharSequence r4 = r6.f7501c
                int r5 = r1 + (-1)
                char r4 = r4.charAt(r5)
                boolean r3 = r3.e(r4)
                if (r3 == 0) goto L57
                int r1 = r1 + (-1)
                goto L42
            L57:
                boolean r3 = r6.f7503e
                if (r3 == 0) goto L5e
                if (r0 != r1) goto L5e
                goto L0
            L5e:
                int r3 = r6.f7505k
                r4 = 1
                if (r3 != r4) goto L80
                java.lang.CharSequence r1 = r6.f7501c
                int r1 = r1.length()
                r6.f7504j = r2
            L6b:
                if (r1 <= r0) goto L83
                l2.c r2 = r6.f7502d
                java.lang.CharSequence r3 = r6.f7501c
                int r4 = r1 + (-1)
                char r3 = r3.charAt(r4)
                boolean r2 = r2.e(r3)
                if (r2 == 0) goto L83
                int r1 = r1 + (-1)
                goto L6b
            L80:
                int r3 = r3 - r4
                r6.f7505k = r3
            L83:
                java.lang.CharSequence r2 = r6.f7501c
                java.lang.CharSequence r0 = r2.subSequence(r0, r1)
                java.lang.String r0 = r0.toString()
                return r0
            L8e:
                java.lang.Object r0 = r6.b()
                java.lang.String r0 = (java.lang.String) r0
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: l2.n.b.a():java.lang.String");
        }

        abstract int e(int i6);

        abstract int f(int i6);
    }

    private interface c {
        Iterator<String> a(n nVar, CharSequence charSequence);
    }

    private n(c cVar) {
        this(cVar, false, l2.c.f(), Integer.MAX_VALUE);
    }

    private n(c cVar, boolean z5, l2.c cVar2, int i6) {
        this.f7497c = cVar;
        this.f7496b = z5;
        this.f7495a = cVar2;
        this.f7498d = i6;
    }

    public static n d(char c6) {
        return e(l2.c.d(c6));
    }

    public static n e(l2.c cVar) {
        k.i(cVar);
        return new n(new a(cVar));
    }

    private Iterator<String> g(CharSequence charSequence) {
        return this.f7497c.a(this, charSequence);
    }

    public List<String> f(CharSequence charSequence) {
        k.i(charSequence);
        Iterator<String> g6 = g(charSequence);
        ArrayList arrayList = new ArrayList();
        while (g6.hasNext()) {
            arrayList.add(g6.next());
        }
        return Collections.unmodifiableList(arrayList);
    }
}
