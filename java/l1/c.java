package l1;

/* loaded from: classes.dex */
public final class c implements d0 {

    /* renamed from: a, reason: collision with root package name */
    private final o0.r f7206a;

    /* renamed from: b, reason: collision with root package name */
    private o0.l f7207b;

    /* renamed from: c, reason: collision with root package name */
    private o0.m f7208c;

    public c(o0.r rVar) {
        this.f7206a = rVar;
    }

    @Override // l1.d0
    public void a() {
        o0.l lVar = this.f7207b;
        if (lVar != null) {
            lVar.a();
            this.f7207b = null;
        }
        this.f7208c = null;
    }

    @Override // l1.d0
    public void b(long j6, long j7) {
        ((o0.l) i2.a.e(this.f7207b)).b(j6, j7);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x003f, code lost:
    
        if (r6.getPosition() != r11) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0065, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0062, code lost:
    
        if (r6.getPosition() != r11) goto L33;
     */
    @Override // l1.d0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void c(g2.i r8, android.net.Uri r9, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r10, long r11, long r13, o0.n r15) {
        /*
            r7 = this;
            o0.f r6 = new o0.f
            r0 = r6
            r1 = r8
            r2 = r11
            r4 = r13
            r0.<init>(r1, r2, r4)
            r7.f7208c = r6
            o0.l r8 = r7.f7207b
            if (r8 == 0) goto L10
            return
        L10:
            o0.r r8 = r7.f7206a
            o0.l[] r8 = r8.b(r9, r10)
            int r10 = r8.length
            r13 = 0
            r14 = 1
            if (r10 != r14) goto L20
            r8 = r8[r13]
            r7.f7207b = r8
            goto L75
        L20:
            int r10 = r8.length
            r0 = 0
        L22:
            if (r0 >= r10) goto L71
            r1 = r8[r0]
            boolean r2 = r1.g(r6)     // Catch: java.lang.Throwable -> L42 java.io.EOFException -> L57
            if (r2 == 0) goto L35
            r7.f7207b = r1     // Catch: java.lang.Throwable -> L42 java.io.EOFException -> L57
            i2.a.g(r14)
            r6.g()
            goto L71
        L35:
            o0.l r1 = r7.f7207b
            if (r1 != 0) goto L67
            long r1 = r6.getPosition()
            int r3 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r3 != 0) goto L65
            goto L67
        L42:
            r8 = move-exception
            o0.l r9 = r7.f7207b
            if (r9 != 0) goto L4f
            long r9 = r6.getPosition()
            int r15 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r15 != 0) goto L50
        L4f:
            r13 = 1
        L50:
            i2.a.g(r13)
            r6.g()
            throw r8
        L57:
            o0.l r1 = r7.f7207b
            if (r1 != 0) goto L67
            long r1 = r6.getPosition()
            int r3 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r3 != 0) goto L65
            goto L67
        L65:
            r1 = 0
            goto L68
        L67:
            r1 = 1
        L68:
            i2.a.g(r1)
            r6.g()
            int r0 = r0 + 1
            goto L22
        L71:
            o0.l r10 = r7.f7207b
            if (r10 == 0) goto L7b
        L75:
            o0.l r8 = r7.f7207b
            r8.c(r15)
            return
        L7b:
            l1.x0 r10 = new l1.x0
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "None of the available extractors ("
            r11.append(r12)
            java.lang.String r8 = i2.c1.M(r8)
            r11.append(r8)
            java.lang.String r8 = ") could read the stream."
            r11.append(r8)
            java.lang.String r8 = r11.toString()
            java.lang.Object r9 = i2.a.e(r9)
            android.net.Uri r9 = (android.net.Uri) r9
            r10.<init>(r8, r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: l1.c.c(g2.i, android.net.Uri, java.util.Map, long, long, o0.n):void");
    }

    @Override // l1.d0
    public int d(o0.a0 a0Var) {
        return ((o0.l) i2.a.e(this.f7207b)).j((o0.m) i2.a.e(this.f7208c), a0Var);
    }

    @Override // l1.d0
    public long e() {
        o0.m mVar = this.f7208c;
        if (mVar != null) {
            return mVar.getPosition();
        }
        return -1L;
    }

    @Override // l1.d0
    public void f() {
        o0.l lVar = this.f7207b;
        if (lVar instanceof v0.f) {
            ((v0.f) lVar).k();
        }
    }
}
