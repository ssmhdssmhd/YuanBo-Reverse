package h2;

import h2.a;
import i2.c1;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public final class b implements g2.k {

    /* renamed from: a, reason: collision with root package name */
    private final h2.a f5129a;

    /* renamed from: b, reason: collision with root package name */
    private final long f5130b;

    /* renamed from: c, reason: collision with root package name */
    private final int f5131c;

    /* renamed from: d, reason: collision with root package name */
    private g2.q f5132d;

    /* renamed from: e, reason: collision with root package name */
    private long f5133e;

    /* renamed from: f, reason: collision with root package name */
    private File f5134f;

    /* renamed from: g, reason: collision with root package name */
    private OutputStream f5135g;

    /* renamed from: h, reason: collision with root package name */
    private long f5136h;

    /* renamed from: i, reason: collision with root package name */
    private long f5137i;

    /* renamed from: j, reason: collision with root package name */
    private t f5138j;

    public static final class a extends a.C0083a {
        public a(IOException iOException) {
            super(iOException);
        }
    }

    public b(h2.a aVar, long j6) {
        this(aVar, j6, 20480);
    }

    public b(h2.a aVar, long j6, int i6) {
        i2.a.h(j6 > 0 || j6 == -1, "fragmentSize must be positive or C.LENGTH_UNSET.");
        if (j6 != -1 && j6 < 2097152) {
            i2.t.i("CacheDataSink", "fragmentSize is below the minimum recommended value of 2097152. This may cause poor cache performance.");
        }
        this.f5129a = (h2.a) i2.a.e(aVar);
        this.f5130b = j6 == -1 ? Long.MAX_VALUE : j6;
        this.f5131c = i6;
    }

    private void b() {
        OutputStream outputStream = this.f5135g;
        if (outputStream == null) {
            return;
        }
        try {
            outputStream.flush();
            c1.n(this.f5135g);
            this.f5135g = null;
            File file = (File) c1.j(this.f5134f);
            this.f5134f = null;
            this.f5129a.c(file, this.f5136h);
        } catch (Throwable th) {
            c1.n(this.f5135g);
            this.f5135g = null;
            File file2 = (File) c1.j(this.f5134f);
            this.f5134f = null;
            file2.delete();
            throw th;
        }
    }

    private void c(g2.q qVar) {
        long j6 = qVar.f4104h;
        this.f5134f = this.f5129a.a((String) c1.j(qVar.f4105i), qVar.f4103g + this.f5137i, j6 != -1 ? Math.min(j6 - this.f5137i, this.f5133e) : -1L);
        OutputStream fileOutputStream = new FileOutputStream(this.f5134f);
        if (this.f5131c > 0) {
            t tVar = this.f5138j;
            if (tVar == null) {
                this.f5138j = new t(fileOutputStream, this.f5131c);
            } else {
                tVar.a(fileOutputStream);
            }
            fileOutputStream = this.f5138j;
        }
        this.f5135g = fileOutputStream;
        this.f5136h = 0L;
    }

    @Override // g2.k
    public void a(g2.q qVar) {
        i2.a.e(qVar.f4105i);
        if (qVar.f4104h == -1 && qVar.d(2)) {
            this.f5132d = null;
            return;
        }
        this.f5132d = qVar;
        this.f5133e = qVar.d(4) ? this.f5130b : Long.MAX_VALUE;
        this.f5137i = 0L;
        try {
            c(qVar);
        } catch (IOException e6) {
            throw new a(e6);
        }
    }

    @Override // g2.k
    public void close() {
        if (this.f5132d == null) {
            return;
        }
        try {
            b();
        } catch (IOException e6) {
            throw new a(e6);
        }
    }

    @Override // g2.k
    public void write(byte[] bArr, int i6, int i7) {
        g2.q qVar = this.f5132d;
        if (qVar == null) {
            return;
        }
        int i8 = 0;
        while (i8 < i7) {
            try {
                if (this.f5136h == this.f5133e) {
                    b();
                    c(qVar);
                }
                int min = (int) Math.min(i7 - i8, this.f5133e - this.f5136h);
                ((OutputStream) c1.j(this.f5135g)).write(bArr, i6 + i8, min);
                i8 += min;
                long j6 = min;
                this.f5136h += j6;
                this.f5137i += j6;
            } catch (IOException e6) {
                throw new a(e6);
            }
        }
    }
}
