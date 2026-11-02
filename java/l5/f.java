package l5;

import e4.q;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.r;
import l5.h;

/* loaded from: classes.dex */
public final class f implements Closeable {
    private static final m G;
    public static final c H = new c(null);
    private long A;
    private long B;
    private final Socket C;
    private final l5.j D;
    private final e E;
    private final Set<Integer> F;

    /* renamed from: a, reason: collision with root package name */
    private final boolean f7562a;

    /* renamed from: b, reason: collision with root package name */
    private final d f7563b;

    /* renamed from: c, reason: collision with root package name */
    private final Map<Integer, l5.i> f7564c;

    /* renamed from: d, reason: collision with root package name */
    private final String f7565d;

    /* renamed from: e, reason: collision with root package name */
    private int f7566e;

    /* renamed from: j, reason: collision with root package name */
    private int f7567j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f7568k;

    /* renamed from: l, reason: collision with root package name */
    private final h5.e f7569l;

    /* renamed from: m, reason: collision with root package name */
    private final h5.d f7570m;

    /* renamed from: n, reason: collision with root package name */
    private final h5.d f7571n;

    /* renamed from: o, reason: collision with root package name */
    private final h5.d f7572o;

    /* renamed from: p, reason: collision with root package name */
    private final l5.l f7573p;

    /* renamed from: q, reason: collision with root package name */
    private long f7574q;

    /* renamed from: r, reason: collision with root package name */
    private long f7575r;

    /* renamed from: s, reason: collision with root package name */
    private long f7576s;

    /* renamed from: t, reason: collision with root package name */
    private long f7577t;

    /* renamed from: u, reason: collision with root package name */
    private long f7578u;

    /* renamed from: v, reason: collision with root package name */
    private long f7579v;

    /* renamed from: w, reason: collision with root package name */
    private final m f7580w;

    /* renamed from: x, reason: collision with root package name */
    private m f7581x;

    /* renamed from: y, reason: collision with root package name */
    private long f7582y;

    /* renamed from: z, reason: collision with root package name */
    private long f7583z;

    public static final class a extends h5.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f7584e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ f f7585f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ long f7586g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, String str2, f fVar, long j6) {
            super(str2, false, 2, null);
            this.f7584e = str;
            this.f7585f = fVar;
            this.f7586g = j6;
        }

        @Override // h5.a
        public long f() {
            boolean z5;
            synchronized (this.f7585f) {
                if (this.f7585f.f7575r < this.f7585f.f7574q) {
                    z5 = true;
                } else {
                    this.f7585f.f7574q++;
                    z5 = false;
                }
            }
            f fVar = this.f7585f;
            if (z5) {
                fVar.b0(null);
                return -1L;
            }
            fVar.F0(false, 1, 0);
            return this.f7586g;
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public Socket f7587a;

        /* renamed from: b, reason: collision with root package name */
        public String f7588b;

        /* renamed from: c, reason: collision with root package name */
        public q5.g f7589c;

        /* renamed from: d, reason: collision with root package name */
        public q5.f f7590d;

        /* renamed from: e, reason: collision with root package name */
        private d f7591e;

        /* renamed from: f, reason: collision with root package name */
        private l5.l f7592f;

        /* renamed from: g, reason: collision with root package name */
        private int f7593g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f7594h;

        /* renamed from: i, reason: collision with root package name */
        private final h5.e f7595i;

        public b(boolean z5, h5.e taskRunner) {
            kotlin.jvm.internal.k.e(taskRunner, "taskRunner");
            this.f7594h = z5;
            this.f7595i = taskRunner;
            this.f7591e = d.f7596a;
            this.f7592f = l5.l.f7726a;
        }

        public final f a() {
            return new f(this);
        }

        public final boolean b() {
            return this.f7594h;
        }

        public final String c() {
            String str = this.f7588b;
            if (str == null) {
                kotlin.jvm.internal.k.o("connectionName");
            }
            return str;
        }

        public final d d() {
            return this.f7591e;
        }

        public final int e() {
            return this.f7593g;
        }

        public final l5.l f() {
            return this.f7592f;
        }

        public final q5.f g() {
            q5.f fVar = this.f7590d;
            if (fVar == null) {
                kotlin.jvm.internal.k.o("sink");
            }
            return fVar;
        }

        public final Socket h() {
            Socket socket = this.f7587a;
            if (socket == null) {
                kotlin.jvm.internal.k.o("socket");
            }
            return socket;
        }

        public final q5.g i() {
            q5.g gVar = this.f7589c;
            if (gVar == null) {
                kotlin.jvm.internal.k.o("source");
            }
            return gVar;
        }

        public final h5.e j() {
            return this.f7595i;
        }

        public final b k(d listener) {
            kotlin.jvm.internal.k.e(listener, "listener");
            this.f7591e = listener;
            return this;
        }

        public final b l(int i6) {
            this.f7593g = i6;
            return this;
        }

        public final b m(Socket socket, String peerName, q5.g source, q5.f sink) {
            StringBuilder sb;
            kotlin.jvm.internal.k.e(socket, "socket");
            kotlin.jvm.internal.k.e(peerName, "peerName");
            kotlin.jvm.internal.k.e(source, "source");
            kotlin.jvm.internal.k.e(sink, "sink");
            this.f7587a = socket;
            if (this.f7594h) {
                sb = new StringBuilder();
                sb.append(e5.b.f3719i);
                sb.append(' ');
            } else {
                sb = new StringBuilder();
                sb.append("MockWebServer ");
            }
            sb.append(peerName);
            this.f7588b = sb.toString();
            this.f7589c = source;
            this.f7590d = sink;
            return this;
        }
    }

    public static final class c {
        private c() {
        }

        public /* synthetic */ c(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final m a() {
            return f.G;
        }
    }

    public static abstract class d {

        /* renamed from: b, reason: collision with root package name */
        public static final b f7597b = new b(null);

        /* renamed from: a, reason: collision with root package name */
        public static final d f7596a = new a();

        public static final class a extends d {
            a() {
            }

            @Override // l5.f.d
            public void b(l5.i stream) {
                kotlin.jvm.internal.k.e(stream, "stream");
                stream.d(l5.b.REFUSED_STREAM, null);
            }
        }

        public static final class b {
            private b() {
            }

            public /* synthetic */ b(kotlin.jvm.internal.g gVar) {
                this();
            }
        }

        public void a(f connection, m settings) {
            kotlin.jvm.internal.k.e(connection, "connection");
            kotlin.jvm.internal.k.e(settings, "settings");
        }

        public abstract void b(l5.i iVar);
    }

    public final class e implements h.c, o4.a<q> {

        /* renamed from: a, reason: collision with root package name */
        private final l5.h f7598a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ f f7599b;

        public static final class a extends h5.a {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f7600e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ boolean f7601f;

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ e f7602g;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ r f7603h;

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ boolean f7604i;

            /* renamed from: j, reason: collision with root package name */
            final /* synthetic */ m f7605j;

            /* renamed from: k, reason: collision with root package name */
            final /* synthetic */ kotlin.jvm.internal.q f7606k;

            /* renamed from: l, reason: collision with root package name */
            final /* synthetic */ r f7607l;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str, boolean z5, String str2, boolean z6, e eVar, r rVar, boolean z7, m mVar, kotlin.jvm.internal.q qVar, r rVar2) {
                super(str2, z6);
                this.f7600e = str;
                this.f7601f = z5;
                this.f7602g = eVar;
                this.f7603h = rVar;
                this.f7604i = z7;
                this.f7605j = mVar;
                this.f7606k = qVar;
                this.f7607l = rVar2;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // h5.a
            public long f() {
                this.f7602g.f7599b.f0().a(this.f7602g.f7599b, (m) this.f7603h.f7013a);
                return -1L;
            }
        }

        public static final class b extends h5.a {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f7608e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ boolean f7609f;

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ l5.i f7610g;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ e f7611h;

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ l5.i f7612i;

            /* renamed from: j, reason: collision with root package name */
            final /* synthetic */ int f7613j;

            /* renamed from: k, reason: collision with root package name */
            final /* synthetic */ List f7614k;

            /* renamed from: l, reason: collision with root package name */
            final /* synthetic */ boolean f7615l;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(String str, boolean z5, String str2, boolean z6, l5.i iVar, e eVar, l5.i iVar2, int i6, List list, boolean z7) {
                super(str2, z6);
                this.f7608e = str;
                this.f7609f = z5;
                this.f7610g = iVar;
                this.f7611h = eVar;
                this.f7612i = iVar2;
                this.f7613j = i6;
                this.f7614k = list;
                this.f7615l = z7;
            }

            @Override // h5.a
            public long f() {
                try {
                    this.f7611h.f7599b.f0().b(this.f7610g);
                    return -1L;
                } catch (IOException e6) {
                    m5.m.f8137c.g().j("Http2Connection.Listener failure for " + this.f7611h.f7599b.d0(), 4, e6);
                    try {
                        this.f7610g.d(l5.b.PROTOCOL_ERROR, e6);
                        return -1L;
                    } catch (IOException unused) {
                        return -1L;
                    }
                }
            }
        }

        public static final class c extends h5.a {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f7616e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ boolean f7617f;

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ e f7618g;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ int f7619h;

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ int f7620i;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(String str, boolean z5, String str2, boolean z6, e eVar, int i6, int i7) {
                super(str2, z6);
                this.f7616e = str;
                this.f7617f = z5;
                this.f7618g = eVar;
                this.f7619h = i6;
                this.f7620i = i7;
            }

            @Override // h5.a
            public long f() {
                this.f7618g.f7599b.F0(true, this.f7619h, this.f7620i);
                return -1L;
            }
        }

        public static final class d extends h5.a {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f7621e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ boolean f7622f;

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ e f7623g;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ boolean f7624h;

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ m f7625i;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(String str, boolean z5, String str2, boolean z6, e eVar, boolean z7, m mVar) {
                super(str2, z6);
                this.f7621e = str;
                this.f7622f = z5;
                this.f7623g = eVar;
                this.f7624h = z7;
                this.f7625i = mVar;
            }

            @Override // h5.a
            public long f() {
                this.f7623g.l(this.f7624h, this.f7625i);
                return -1L;
            }
        }

        public e(f fVar, l5.h reader) {
            kotlin.jvm.internal.k.e(reader, "reader");
            this.f7599b = fVar;
            this.f7598a = reader;
        }

        @Override // l5.h.c
        public void a(boolean z5, int i6, q5.g source, int i7) {
            kotlin.jvm.internal.k.e(source, "source");
            if (this.f7599b.u0(i6)) {
                this.f7599b.q0(i6, source, i7, z5);
                return;
            }
            l5.i j02 = this.f7599b.j0(i6);
            if (j02 == null) {
                this.f7599b.H0(i6, l5.b.PROTOCOL_ERROR);
                long j6 = i7;
                this.f7599b.C0(j6);
                source.skip(j6);
                return;
            }
            j02.w(source, i7);
            if (z5) {
                j02.x(e5.b.f3712b, true);
            }
        }

        @Override // l5.h.c
        public void b() {
        }

        @Override // l5.h.c
        public void c(boolean z5, int i6, int i7) {
            if (!z5) {
                h5.d dVar = this.f7599b.f7570m;
                String str = this.f7599b.d0() + " ping";
                dVar.i(new c(str, true, str, true, this, i6, i7), 0L);
                return;
            }
            synchronized (this.f7599b) {
                if (i6 == 1) {
                    this.f7599b.f7575r++;
                } else if (i6 != 2) {
                    if (i6 == 3) {
                        this.f7599b.f7578u++;
                        f fVar = this.f7599b;
                        if (fVar == null) {
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                        }
                        fVar.notifyAll();
                    }
                    q qVar = q.f3710a;
                } else {
                    this.f7599b.f7577t++;
                }
            }
        }

        @Override // l5.h.c
        public void e(int i6, int i7, int i8, boolean z5) {
        }

        @Override // l5.h.c
        public void f(boolean z5, m settings) {
            kotlin.jvm.internal.k.e(settings, "settings");
            h5.d dVar = this.f7599b.f7570m;
            String str = this.f7599b.d0() + " applyAndAckSettings";
            dVar.i(new d(str, true, str, true, this, z5, settings), 0L);
        }

        @Override // l5.h.c
        public void g(boolean z5, int i6, int i7, List<l5.c> headerBlock) {
            kotlin.jvm.internal.k.e(headerBlock, "headerBlock");
            if (this.f7599b.u0(i6)) {
                this.f7599b.r0(i6, headerBlock, z5);
                return;
            }
            synchronized (this.f7599b) {
                l5.i j02 = this.f7599b.j0(i6);
                if (j02 != null) {
                    q qVar = q.f3710a;
                    j02.x(e5.b.I(headerBlock), z5);
                    return;
                }
                if (this.f7599b.f7568k) {
                    return;
                }
                if (i6 <= this.f7599b.e0()) {
                    return;
                }
                if (i6 % 2 == this.f7599b.g0() % 2) {
                    return;
                }
                l5.i iVar = new l5.i(i6, this.f7599b, false, z5, e5.b.I(headerBlock));
                this.f7599b.x0(i6);
                this.f7599b.k0().put(Integer.valueOf(i6), iVar);
                h5.d i8 = this.f7599b.f7569l.i();
                String str = this.f7599b.d0() + '[' + i6 + "] onStream";
                i8.i(new b(str, true, str, true, iVar, this, j02, i6, headerBlock, z5), 0L);
            }
        }

        @Override // l5.h.c
        public void h(int i6, l5.b errorCode, q5.h debugData) {
            int i7;
            l5.i[] iVarArr;
            kotlin.jvm.internal.k.e(errorCode, "errorCode");
            kotlin.jvm.internal.k.e(debugData, "debugData");
            debugData.r();
            synchronized (this.f7599b) {
                Object[] array = this.f7599b.k0().values().toArray(new l5.i[0]);
                if (array == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
                iVarArr = (l5.i[]) array;
                this.f7599b.f7568k = true;
                q qVar = q.f3710a;
            }
            for (l5.i iVar : iVarArr) {
                if (iVar.j() > i6 && iVar.t()) {
                    iVar.y(l5.b.REFUSED_STREAM);
                    this.f7599b.v0(iVar.j());
                }
            }
        }

        @Override // l5.h.c
        public void i(int i6, l5.b errorCode) {
            kotlin.jvm.internal.k.e(errorCode, "errorCode");
            if (this.f7599b.u0(i6)) {
                this.f7599b.t0(i6, errorCode);
                return;
            }
            l5.i v02 = this.f7599b.v0(i6);
            if (v02 != null) {
                v02.y(errorCode);
            }
        }

        @Override // o4.a
        public /* bridge */ /* synthetic */ q invoke() {
            m();
            return q.f3710a;
        }

        @Override // l5.h.c
        public void j(int i6, long j6) {
            Object obj;
            if (i6 == 0) {
                Object obj2 = this.f7599b;
                synchronized (obj2) {
                    f fVar = this.f7599b;
                    fVar.B = fVar.l0() + j6;
                    f fVar2 = this.f7599b;
                    if (fVar2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                    }
                    fVar2.notifyAll();
                    q qVar = q.f3710a;
                    obj = obj2;
                }
            } else {
                l5.i j02 = this.f7599b.j0(i6);
                if (j02 == null) {
                    return;
                }
                synchronized (j02) {
                    j02.a(j6);
                    q qVar2 = q.f3710a;
                    obj = j02;
                }
            }
        }

        @Override // l5.h.c
        public void k(int i6, int i7, List<l5.c> requestHeaders) {
            kotlin.jvm.internal.k.e(requestHeaders, "requestHeaders");
            this.f7599b.s0(i7, requestHeaders);
        }

        /* JADX WARN: Can't wrap try/catch for region: R(15:6|7|(1:9)(1:54)|10|(2:15|(10:17|18|19|20|21|22|23|24|25|26)(2:51|52))|53|18|19|20|21|22|23|24|25|26) */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x00d6, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x00d7, code lost:
        
            r21.f7599b.b0(r0);
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1, types: [T, l5.m] */
        /* JADX WARN: Type inference failed for: r2v14 */
        /* JADX WARN: Type inference failed for: r2v15 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void l(boolean r22, l5.m r23) {
            /*
                Method dump skipped, instructions count: 267
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: l5.f.e.l(boolean, l5.m):void");
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [l5.b] */
        /* JADX WARN: Type inference failed for: r0v3 */
        /* JADX WARN: Type inference failed for: r0v5, types: [java.io.Closeable, l5.h] */
        public void m() {
            l5.b bVar;
            l5.b bVar2 = l5.b.INTERNAL_ERROR;
            IOException e6 = null;
            try {
                try {
                    this.f7598a.k(this);
                    while (this.f7598a.j(false, this)) {
                    }
                    l5.b bVar3 = l5.b.NO_ERROR;
                    try {
                        this.f7599b.a0(bVar3, l5.b.CANCEL, null);
                        bVar = bVar3;
                    } catch (IOException e7) {
                        e6 = e7;
                        l5.b bVar4 = l5.b.PROTOCOL_ERROR;
                        f fVar = this.f7599b;
                        fVar.a0(bVar4, bVar4, e6);
                        bVar = fVar;
                        bVar2 = this.f7598a;
                        e5.b.i(bVar2);
                    }
                } catch (Throwable th) {
                    th = th;
                    this.f7599b.a0(bVar, bVar2, e6);
                    e5.b.i(this.f7598a);
                    throw th;
                }
            } catch (IOException e8) {
                e6 = e8;
            } catch (Throwable th2) {
                th = th2;
                bVar = bVar2;
                this.f7599b.a0(bVar, bVar2, e6);
                e5.b.i(this.f7598a);
                throw th;
            }
            bVar2 = this.f7598a;
            e5.b.i(bVar2);
        }
    }

    /* renamed from: l5.f$f, reason: collision with other inner class name */
    public static final class C0111f extends h5.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f7626e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f7627f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ f f7628g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f7629h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ q5.e f7630i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ int f7631j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ boolean f7632k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0111f(String str, boolean z5, String str2, boolean z6, f fVar, int i6, q5.e eVar, int i7, boolean z7) {
            super(str2, z6);
            this.f7626e = str;
            this.f7627f = z5;
            this.f7628g = fVar;
            this.f7629h = i6;
            this.f7630i = eVar;
            this.f7631j = i7;
            this.f7632k = z7;
        }

        @Override // h5.a
        public long f() {
            try {
                boolean c6 = this.f7628g.f7573p.c(this.f7629h, this.f7630i, this.f7631j, this.f7632k);
                if (c6) {
                    this.f7628g.m0().K(this.f7629h, l5.b.CANCEL);
                }
                if (!c6 && !this.f7632k) {
                    return -1L;
                }
                synchronized (this.f7628g) {
                    this.f7628g.F.remove(Integer.valueOf(this.f7629h));
                }
                return -1L;
            } catch (IOException unused) {
                return -1L;
            }
        }
    }

    public static final class g extends h5.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f7633e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f7634f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ f f7635g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f7636h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ List f7637i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ boolean f7638j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(String str, boolean z5, String str2, boolean z6, f fVar, int i6, List list, boolean z7) {
            super(str2, z6);
            this.f7633e = str;
            this.f7634f = z5;
            this.f7635g = fVar;
            this.f7636h = i6;
            this.f7637i = list;
            this.f7638j = z7;
        }

        @Override // h5.a
        public long f() {
            boolean b6 = this.f7635g.f7573p.b(this.f7636h, this.f7637i, this.f7638j);
            if (b6) {
                try {
                    this.f7635g.m0().K(this.f7636h, l5.b.CANCEL);
                } catch (IOException unused) {
                    return -1L;
                }
            }
            if (!b6 && !this.f7638j) {
                return -1L;
            }
            synchronized (this.f7635g) {
                this.f7635g.F.remove(Integer.valueOf(this.f7636h));
            }
            return -1L;
        }
    }

    public static final class h extends h5.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f7639e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f7640f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ f f7641g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f7642h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ List f7643i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(String str, boolean z5, String str2, boolean z6, f fVar, int i6, List list) {
            super(str2, z6);
            this.f7639e = str;
            this.f7640f = z5;
            this.f7641g = fVar;
            this.f7642h = i6;
            this.f7643i = list;
        }

        @Override // h5.a
        public long f() {
            if (!this.f7641g.f7573p.a(this.f7642h, this.f7643i)) {
                return -1L;
            }
            try {
                this.f7641g.m0().K(this.f7642h, l5.b.CANCEL);
                synchronized (this.f7641g) {
                    this.f7641g.F.remove(Integer.valueOf(this.f7642h));
                }
                return -1L;
            } catch (IOException unused) {
                return -1L;
            }
        }
    }

    public static final class i extends h5.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f7644e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f7645f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ f f7646g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f7647h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ l5.b f7648i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(String str, boolean z5, String str2, boolean z6, f fVar, int i6, l5.b bVar) {
            super(str2, z6);
            this.f7644e = str;
            this.f7645f = z5;
            this.f7646g = fVar;
            this.f7647h = i6;
            this.f7648i = bVar;
        }

        @Override // h5.a
        public long f() {
            this.f7646g.f7573p.d(this.f7647h, this.f7648i);
            synchronized (this.f7646g) {
                this.f7646g.F.remove(Integer.valueOf(this.f7647h));
                q qVar = q.f3710a;
            }
            return -1L;
        }
    }

    public static final class j extends h5.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f7649e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f7650f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ f f7651g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(String str, boolean z5, String str2, boolean z6, f fVar) {
            super(str2, z6);
            this.f7649e = str;
            this.f7650f = z5;
            this.f7651g = fVar;
        }

        @Override // h5.a
        public long f() {
            this.f7651g.F0(false, 2, 0);
            return -1L;
        }
    }

    public static final class k extends h5.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f7652e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f7653f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ f f7654g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f7655h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ l5.b f7656i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(String str, boolean z5, String str2, boolean z6, f fVar, int i6, l5.b bVar) {
            super(str2, z6);
            this.f7652e = str;
            this.f7653f = z5;
            this.f7654g = fVar;
            this.f7655h = i6;
            this.f7656i = bVar;
        }

        @Override // h5.a
        public long f() {
            try {
                this.f7654g.G0(this.f7655h, this.f7656i);
                return -1L;
            } catch (IOException e6) {
                this.f7654g.b0(e6);
                return -1L;
            }
        }
    }

    public static final class l extends h5.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f7657e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f7658f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ f f7659g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f7660h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ long f7661i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(String str, boolean z5, String str2, boolean z6, f fVar, int i6, long j6) {
            super(str2, z6);
            this.f7657e = str;
            this.f7658f = z5;
            this.f7659g = fVar;
            this.f7660h = i6;
            this.f7661i = j6;
        }

        @Override // h5.a
        public long f() {
            try {
                this.f7659g.m0().U(this.f7660h, this.f7661i);
                return -1L;
            } catch (IOException e6) {
                this.f7659g.b0(e6);
                return -1L;
            }
        }
    }

    static {
        m mVar = new m();
        mVar.h(7, 65535);
        mVar.h(5, 16384);
        G = mVar;
    }

    public f(b builder) {
        kotlin.jvm.internal.k.e(builder, "builder");
        boolean b6 = builder.b();
        this.f7562a = b6;
        this.f7563b = builder.d();
        this.f7564c = new LinkedHashMap();
        String c6 = builder.c();
        this.f7565d = c6;
        this.f7567j = builder.b() ? 3 : 2;
        h5.e j6 = builder.j();
        this.f7569l = j6;
        h5.d i6 = j6.i();
        this.f7570m = i6;
        this.f7571n = j6.i();
        this.f7572o = j6.i();
        this.f7573p = builder.f();
        m mVar = new m();
        if (builder.b()) {
            mVar.h(7, 16777216);
        }
        q qVar = q.f3710a;
        this.f7580w = mVar;
        this.f7581x = G;
        this.B = r2.c();
        this.C = builder.h();
        this.D = new l5.j(builder.g(), b6);
        this.E = new e(this, new l5.h(builder.i(), b6));
        this.F = new LinkedHashSet();
        if (builder.e() != 0) {
            long nanos = TimeUnit.MILLISECONDS.toNanos(builder.e());
            String str = c6 + " ping";
            i6.i(new a(str, str, this, nanos), nanos);
        }
    }

    public static /* synthetic */ void B0(f fVar, boolean z5, h5.e eVar, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            z5 = true;
        }
        if ((i6 & 2) != 0) {
            eVar = h5.e.f5261h;
        }
        fVar.A0(z5, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b0(IOException iOException) {
        l5.b bVar = l5.b.PROTOCOL_ERROR;
        a0(bVar, bVar, iOException);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0048 A[Catch: all -> 0x0081, TryCatch #0 {, blocks: (B:6:0x0007, B:8:0x000e, B:9:0x0013, B:11:0x0017, B:13:0x002a, B:15:0x0032, B:19:0x0042, B:21:0x0048, B:22:0x0051, B:37:0x007b, B:38:0x0080), top: B:5:0x0007, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final l5.i o0(int r11, java.util.List<l5.c> r12, boolean r13) {
        /*
            r10 = this;
            r6 = r13 ^ 1
            r4 = 0
            l5.j r7 = r10.D
            monitor-enter(r7)
            monitor-enter(r10)     // Catch: java.lang.Throwable -> L84
            int r0 = r10.f7567j     // Catch: java.lang.Throwable -> L81
            r1 = 1073741823(0x3fffffff, float:1.9999999)
            if (r0 <= r1) goto L13
            l5.b r0 = l5.b.REFUSED_STREAM     // Catch: java.lang.Throwable -> L81
            r10.z0(r0)     // Catch: java.lang.Throwable -> L81
        L13:
            boolean r0 = r10.f7568k     // Catch: java.lang.Throwable -> L81
            if (r0 != 0) goto L7b
            int r8 = r10.f7567j     // Catch: java.lang.Throwable -> L81
            int r0 = r8 + 2
            r10.f7567j = r0     // Catch: java.lang.Throwable -> L81
            l5.i r9 = new l5.i     // Catch: java.lang.Throwable -> L81
            r5 = 0
            r0 = r9
            r1 = r8
            r2 = r10
            r3 = r6
            r0.<init>(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L81
            r0 = 1
            if (r13 == 0) goto L41
            long r1 = r10.A     // Catch: java.lang.Throwable -> L81
            long r3 = r10.B     // Catch: java.lang.Throwable -> L81
            int r13 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r13 >= 0) goto L41
            long r1 = r9.r()     // Catch: java.lang.Throwable -> L81
            long r3 = r9.q()     // Catch: java.lang.Throwable -> L81
            int r13 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r13 < 0) goto L3f
            goto L41
        L3f:
            r13 = 0
            goto L42
        L41:
            r13 = 1
        L42:
            boolean r1 = r9.u()     // Catch: java.lang.Throwable -> L81
            if (r1 == 0) goto L51
            java.util.Map<java.lang.Integer, l5.i> r1 = r10.f7564c     // Catch: java.lang.Throwable -> L81
            java.lang.Integer r2 = java.lang.Integer.valueOf(r8)     // Catch: java.lang.Throwable -> L81
            r1.put(r2, r9)     // Catch: java.lang.Throwable -> L81
        L51:
            e4.q r1 = e4.q.f3710a     // Catch: java.lang.Throwable -> L81
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L84
            if (r11 != 0) goto L5c
            l5.j r11 = r10.D     // Catch: java.lang.Throwable -> L84
            r11.v(r6, r8, r12)     // Catch: java.lang.Throwable -> L84
            goto L66
        L5c:
            boolean r1 = r10.f7562a     // Catch: java.lang.Throwable -> L84
            r0 = r0 ^ r1
            if (r0 == 0) goto L6f
            l5.j r0 = r10.D     // Catch: java.lang.Throwable -> L84
            r0.I(r11, r8, r12)     // Catch: java.lang.Throwable -> L84
        L66:
            monitor-exit(r7)
            if (r13 == 0) goto L6e
            l5.j r11 = r10.D
            r11.flush()
        L6e:
            return r9
        L6f:
            java.lang.String r11 = "client streams shouldn't have associated stream IDs"
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> L84
            java.lang.String r11 = r11.toString()     // Catch: java.lang.Throwable -> L84
            r12.<init>(r11)     // Catch: java.lang.Throwable -> L84
            throw r12     // Catch: java.lang.Throwable -> L84
        L7b:
            l5.a r11 = new l5.a     // Catch: java.lang.Throwable -> L81
            r11.<init>()     // Catch: java.lang.Throwable -> L81
            throw r11     // Catch: java.lang.Throwable -> L81
        L81:
            r11 = move-exception
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L84
            throw r11     // Catch: java.lang.Throwable -> L84
        L84:
            r11 = move-exception
            monitor-exit(r7)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: l5.f.o0(int, java.util.List, boolean):l5.i");
    }

    public final void A0(boolean z5, h5.e taskRunner) {
        kotlin.jvm.internal.k.e(taskRunner, "taskRunner");
        if (z5) {
            this.D.j();
            this.D.M(this.f7580w);
            if (this.f7580w.c() != 65535) {
                this.D.U(0, r7 - 65535);
            }
        }
        h5.d i6 = taskRunner.i();
        String str = this.f7565d;
        i6.i(new h5.c(this.E, str, true, str, true), 0L);
    }

    public final synchronized void C0(long j6) {
        long j7 = this.f7582y + j6;
        this.f7582y = j7;
        long j8 = j7 - this.f7583z;
        if (j8 >= this.f7580w.c() / 2) {
            I0(0, j8);
            this.f7583z += j8;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0033, code lost:
    
        r3 = java.lang.Math.min((int) java.lang.Math.min(r12, r5 - r3), r8.D.D());
        r6 = r3;
        r8.A += r6;
        r4 = e4.q.f3710a;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void D0(int r9, boolean r10, q5.e r11, long r12) {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 != 0) goto Ld
            l5.j r12 = r8.D
            r12.k(r10, r9, r11, r0)
            return
        Ld:
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 <= 0) goto L6c
            monitor-enter(r8)
        L12:
            long r3 = r8.A     // Catch: java.lang.Throwable -> L5b java.lang.InterruptedException -> L5d
            long r5 = r8.B     // Catch: java.lang.Throwable -> L5b java.lang.InterruptedException -> L5d
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 < 0) goto L32
            java.util.Map<java.lang.Integer, l5.i> r3 = r8.f7564c     // Catch: java.lang.Throwable -> L5b java.lang.InterruptedException -> L5d
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L5b java.lang.InterruptedException -> L5d
            boolean r3 = r3.containsKey(r4)     // Catch: java.lang.Throwable -> L5b java.lang.InterruptedException -> L5d
            if (r3 == 0) goto L2a
            r8.wait()     // Catch: java.lang.Throwable -> L5b java.lang.InterruptedException -> L5d
            goto L12
        L2a:
            java.io.IOException r9 = new java.io.IOException     // Catch: java.lang.Throwable -> L5b java.lang.InterruptedException -> L5d
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L5b java.lang.InterruptedException -> L5d
            throw r9     // Catch: java.lang.Throwable -> L5b java.lang.InterruptedException -> L5d
        L32:
            long r5 = r5 - r3
            long r3 = java.lang.Math.min(r12, r5)     // Catch: java.lang.Throwable -> L5b
            int r4 = (int) r3     // Catch: java.lang.Throwable -> L5b
            l5.j r3 = r8.D     // Catch: java.lang.Throwable -> L5b
            int r3 = r3.D()     // Catch: java.lang.Throwable -> L5b
            int r3 = java.lang.Math.min(r4, r3)     // Catch: java.lang.Throwable -> L5b
            long r4 = r8.A     // Catch: java.lang.Throwable -> L5b
            long r6 = (long) r3     // Catch: java.lang.Throwable -> L5b
            long r4 = r4 + r6
            r8.A = r4     // Catch: java.lang.Throwable -> L5b
            e4.q r4 = e4.q.f3710a     // Catch: java.lang.Throwable -> L5b
            monitor-exit(r8)
            long r12 = r12 - r6
            l5.j r4 = r8.D
            if (r10 == 0) goto L56
            int r5 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r5 != 0) goto L56
            r5 = 1
            goto L57
        L56:
            r5 = 0
        L57:
            r4.k(r5, r9, r11, r3)
            goto Ld
        L5b:
            r9 = move-exception
            goto L6a
        L5d:
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L5b
            r9.interrupt()     // Catch: java.lang.Throwable -> L5b
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch: java.lang.Throwable -> L5b
            r9.<init>()     // Catch: java.lang.Throwable -> L5b
            throw r9     // Catch: java.lang.Throwable -> L5b
        L6a:
            monitor-exit(r8)
            throw r9
        L6c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: l5.f.D0(int, boolean, q5.e, long):void");
    }

    public final void E0(int i6, boolean z5, List<l5.c> alternating) {
        kotlin.jvm.internal.k.e(alternating, "alternating");
        this.D.v(z5, i6, alternating);
    }

    public final void F0(boolean z5, int i6, int i7) {
        try {
            this.D.F(z5, i6, i7);
        } catch (IOException e6) {
            b0(e6);
        }
    }

    public final void G0(int i6, l5.b statusCode) {
        kotlin.jvm.internal.k.e(statusCode, "statusCode");
        this.D.K(i6, statusCode);
    }

    public final void H0(int i6, l5.b errorCode) {
        kotlin.jvm.internal.k.e(errorCode, "errorCode");
        h5.d dVar = this.f7570m;
        String str = this.f7565d + '[' + i6 + "] writeSynReset";
        dVar.i(new k(str, true, str, true, this, i6, errorCode), 0L);
    }

    public final void I0(int i6, long j6) {
        h5.d dVar = this.f7570m;
        String str = this.f7565d + '[' + i6 + "] windowUpdate";
        dVar.i(new l(str, true, str, true, this, i6, j6), 0L);
    }

    public final void a0(l5.b connectionCode, l5.b streamCode, IOException iOException) {
        int i6;
        l5.i[] iVarArr;
        kotlin.jvm.internal.k.e(connectionCode, "connectionCode");
        kotlin.jvm.internal.k.e(streamCode, "streamCode");
        if (e5.b.f3718h && Thread.holdsLock(this)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread currentThread = Thread.currentThread();
            kotlin.jvm.internal.k.d(currentThread, "Thread.currentThread()");
            sb.append(currentThread.getName());
            sb.append(" MUST NOT hold lock on ");
            sb.append(this);
            throw new AssertionError(sb.toString());
        }
        try {
            z0(connectionCode);
        } catch (IOException unused) {
        }
        synchronized (this) {
            if (!this.f7564c.isEmpty()) {
                Object[] array = this.f7564c.values().toArray(new l5.i[0]);
                if (array == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
                iVarArr = (l5.i[]) array;
                this.f7564c.clear();
            } else {
                iVarArr = null;
            }
            q qVar = q.f3710a;
        }
        if (iVarArr != null) {
            for (l5.i iVar : iVarArr) {
                try {
                    iVar.d(streamCode, iOException);
                } catch (IOException unused2) {
                }
            }
        }
        try {
            this.D.close();
        } catch (IOException unused3) {
        }
        try {
            this.C.close();
        } catch (IOException unused4) {
        }
        this.f7570m.n();
        this.f7571n.n();
        this.f7572o.n();
    }

    public final boolean c0() {
        return this.f7562a;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a0(l5.b.NO_ERROR, l5.b.CANCEL, null);
    }

    public final String d0() {
        return this.f7565d;
    }

    public final int e0() {
        return this.f7566e;
    }

    public final d f0() {
        return this.f7563b;
    }

    public final void flush() {
        this.D.flush();
    }

    public final int g0() {
        return this.f7567j;
    }

    public final m h0() {
        return this.f7580w;
    }

    public final m i0() {
        return this.f7581x;
    }

    public final synchronized l5.i j0(int i6) {
        return this.f7564c.get(Integer.valueOf(i6));
    }

    public final Map<Integer, l5.i> k0() {
        return this.f7564c;
    }

    public final long l0() {
        return this.B;
    }

    public final l5.j m0() {
        return this.D;
    }

    public final synchronized boolean n0(long j6) {
        if (this.f7568k) {
            return false;
        }
        if (this.f7577t < this.f7576s) {
            if (j6 >= this.f7579v) {
                return false;
            }
        }
        return true;
    }

    public final l5.i p0(List<l5.c> requestHeaders, boolean z5) {
        kotlin.jvm.internal.k.e(requestHeaders, "requestHeaders");
        return o0(0, requestHeaders, z5);
    }

    public final void q0(int i6, q5.g source, int i7, boolean z5) {
        kotlin.jvm.internal.k.e(source, "source");
        q5.e eVar = new q5.e();
        long j6 = i7;
        source.P(j6);
        source.C(eVar, j6);
        h5.d dVar = this.f7571n;
        String str = this.f7565d + '[' + i6 + "] onData";
        dVar.i(new C0111f(str, true, str, true, this, i6, eVar, i7, z5), 0L);
    }

    public final void r0(int i6, List<l5.c> requestHeaders, boolean z5) {
        kotlin.jvm.internal.k.e(requestHeaders, "requestHeaders");
        h5.d dVar = this.f7571n;
        String str = this.f7565d + '[' + i6 + "] onHeaders";
        dVar.i(new g(str, true, str, true, this, i6, requestHeaders, z5), 0L);
    }

    public final void s0(int i6, List<l5.c> requestHeaders) {
        kotlin.jvm.internal.k.e(requestHeaders, "requestHeaders");
        synchronized (this) {
            if (this.F.contains(Integer.valueOf(i6))) {
                H0(i6, l5.b.PROTOCOL_ERROR);
                return;
            }
            this.F.add(Integer.valueOf(i6));
            h5.d dVar = this.f7571n;
            String str = this.f7565d + '[' + i6 + "] onRequest";
            dVar.i(new h(str, true, str, true, this, i6, requestHeaders), 0L);
        }
    }

    public final void t0(int i6, l5.b errorCode) {
        kotlin.jvm.internal.k.e(errorCode, "errorCode");
        h5.d dVar = this.f7571n;
        String str = this.f7565d + '[' + i6 + "] onReset";
        dVar.i(new i(str, true, str, true, this, i6, errorCode), 0L);
    }

    public final boolean u0(int i6) {
        return i6 != 0 && (i6 & 1) == 0;
    }

    public final synchronized l5.i v0(int i6) {
        l5.i remove;
        remove = this.f7564c.remove(Integer.valueOf(i6));
        notifyAll();
        return remove;
    }

    public final void w0() {
        synchronized (this) {
            long j6 = this.f7577t;
            long j7 = this.f7576s;
            if (j6 < j7) {
                return;
            }
            this.f7576s = j7 + 1;
            this.f7579v = System.nanoTime() + 1000000000;
            q qVar = q.f3710a;
            h5.d dVar = this.f7570m;
            String str = this.f7565d + " ping";
            dVar.i(new j(str, true, str, true, this), 0L);
        }
    }

    public final void x0(int i6) {
        this.f7566e = i6;
    }

    public final void y0(m mVar) {
        kotlin.jvm.internal.k.e(mVar, "<set-?>");
        this.f7581x = mVar;
    }

    public final void z0(l5.b statusCode) {
        kotlin.jvm.internal.k.e(statusCode, "statusCode");
        synchronized (this.D) {
            synchronized (this) {
                if (this.f7568k) {
                    return;
                }
                this.f7568k = true;
                int i6 = this.f7566e;
                q qVar = q.f3710a;
                this.D.t(i6, statusCode, e5.b.f3711a);
            }
        }
    }
}
