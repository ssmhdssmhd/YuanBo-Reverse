package q1;

import android.text.TextUtils;
import h0.g3;
import h0.y1;
import i2.i0;
import i2.r0;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import o0.a0;
import o0.b0;
import o0.e0;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* loaded from: classes.dex */
public final class t implements o0.l {

    /* renamed from: g, reason: collision with root package name */
    private static final Pattern f8843g = Pattern.compile("LOCAL:([^,]+)");

    /* renamed from: h, reason: collision with root package name */
    private static final Pattern f8844h = Pattern.compile("MPEGTS:(-?\\d+)");

    /* renamed from: a, reason: collision with root package name */
    private final String f8845a;

    /* renamed from: b, reason: collision with root package name */
    private final r0 f8846b;

    /* renamed from: d, reason: collision with root package name */
    private o0.n f8848d;

    /* renamed from: f, reason: collision with root package name */
    private int f8850f;

    /* renamed from: c, reason: collision with root package name */
    private final i0 f8847c = new i0();

    /* renamed from: e, reason: collision with root package name */
    private byte[] f8849e = new byte[1024];

    public t(String str, r0 r0Var) {
        this.f8845a = str;
        this.f8846b = r0Var;
    }

    @RequiresNonNull({"output"})
    private e0 d(long j6) {
        e0 e6 = this.f8848d.e(0, 3);
        e6.c(new y1.b().g0("text/vtt").X(this.f8845a).k0(j6).G());
        this.f8848d.j();
        return e6;
    }

    @RequiresNonNull({"output"})
    private void e() {
        i0 i0Var = new i0(this.f8849e);
        d2.i.e(i0Var);
        long j6 = 0;
        long j7 = 0;
        for (String q6 = i0Var.q(); !TextUtils.isEmpty(q6); q6 = i0Var.q()) {
            if (q6.startsWith("X-TIMESTAMP-MAP")) {
                Matcher matcher = f8843g.matcher(q6);
                if (!matcher.find()) {
                    throw g3.a("X-TIMESTAMP-MAP doesn't contain local timestamp: " + q6, null);
                }
                Matcher matcher2 = f8844h.matcher(q6);
                if (!matcher2.find()) {
                    throw g3.a("X-TIMESTAMP-MAP doesn't contain media timestamp: " + q6, null);
                }
                j7 = d2.i.d((String) i2.a.e(matcher.group(1)));
                j6 = r0.f(Long.parseLong((String) i2.a.e(matcher2.group(1))));
            }
        }
        Matcher a6 = d2.i.a(i0Var);
        if (a6 == null) {
            d(0L);
            return;
        }
        long d6 = d2.i.d((String) i2.a.e(a6.group(1)));
        long b6 = this.f8846b.b(r0.j((j6 + d6) - j7));
        e0 d7 = d(b6 - d6);
        this.f8847c.Q(this.f8849e, this.f8850f);
        d7.d(this.f8847c, this.f8850f);
        d7.e(b6, 1, this.f8850f, 0, null);
    }

    @Override // o0.l
    public void a() {
    }

    @Override // o0.l
    public void b(long j6, long j7) {
        throw new IllegalStateException();
    }

    @Override // o0.l
    public void c(o0.n nVar) {
        this.f8848d = nVar;
        nVar.t(new b0.b(-9223372036854775807L));
    }

    @Override // o0.l
    public boolean g(o0.m mVar) {
        mVar.k(this.f8849e, 0, 6, false);
        this.f8847c.Q(this.f8849e, 6);
        if (d2.i.b(this.f8847c)) {
            return true;
        }
        mVar.k(this.f8849e, 6, 3, false);
        this.f8847c.Q(this.f8849e, 9);
        return d2.i.b(this.f8847c);
    }

    @Override // o0.l
    public int j(o0.m mVar, a0 a0Var) {
        i2.a.e(this.f8848d);
        int length = (int) mVar.getLength();
        int i6 = this.f8850f;
        byte[] bArr = this.f8849e;
        if (i6 == bArr.length) {
            this.f8849e = Arrays.copyOf(bArr, ((length != -1 ? length : bArr.length) * 3) / 2);
        }
        byte[] bArr2 = this.f8849e;
        int i7 = this.f8850f;
        int read = mVar.read(bArr2, i7, bArr2.length - i7);
        if (read != -1) {
            int i8 = this.f8850f + read;
            this.f8850f = i8;
            if (length == -1 || i8 != length) {
                return 0;
            }
        }
        e();
        return -1;
    }
}
