package j0;

import android.media.AudioDeviceInfo;
import h0.n3;
import h0.y1;
import i0.o3;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public interface x {

    public static final class a extends Exception {

        /* renamed from: a, reason: collision with root package name */
        public final y1 f6617a;

        public a(String str, y1 y1Var) {
            super(str);
            this.f6617a = y1Var;
        }

        public a(Throwable th, y1 y1Var) {
            super(th);
            this.f6617a = y1Var;
        }
    }

    public static final class b extends Exception {

        /* renamed from: a, reason: collision with root package name */
        public final int f6618a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f6619b;

        /* renamed from: c, reason: collision with root package name */
        public final y1 f6620c;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public b(int r3, int r4, int r5, int r6, h0.y1 r7, boolean r8, java.lang.Exception r9) {
            /*
                r2 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "AudioTrack init failed "
                r0.append(r1)
                r0.append(r3)
                java.lang.String r1 = " "
                r0.append(r1)
                java.lang.String r1 = "Config("
                r0.append(r1)
                r0.append(r4)
                java.lang.String r4 = ", "
                r0.append(r4)
                r0.append(r5)
                r0.append(r4)
                r0.append(r6)
                java.lang.String r4 = ")"
                r0.append(r4)
                if (r8 == 0) goto L32
                java.lang.String r4 = " (recoverable)"
                goto L34
            L32:
                java.lang.String r4 = ""
            L34:
                r0.append(r4)
                java.lang.String r4 = r0.toString()
                r2.<init>(r4, r9)
                r2.f6618a = r3
                r2.f6619b = r8
                r2.f6620c = r7
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: j0.x.b.<init>(int, int, int, int, h0.y1, boolean, java.lang.Exception):void");
        }
    }

    public interface c {
        void a(long j6);

        void b(boolean z5);

        void c(Exception exc);

        void d();

        void e();

        void f();

        void g(int i6, long j6, long j7);
    }

    public static final class d extends Exception {

        /* renamed from: a, reason: collision with root package name */
        public final long f6621a;

        /* renamed from: b, reason: collision with root package name */
        public final long f6622b;

        public d(long j6, long j7) {
            super("Unexpected audio track timestamp discontinuity: expected " + j7 + ", got " + j6);
            this.f6621a = j6;
            this.f6622b = j7;
        }
    }

    public static final class e extends Exception {

        /* renamed from: a, reason: collision with root package name */
        public final int f6623a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f6624b;

        /* renamed from: c, reason: collision with root package name */
        public final y1 f6625c;

        public e(int i6, y1 y1Var, boolean z5) {
            super("AudioTrack write failed: " + i6);
            this.f6624b = z5;
            this.f6623a = i6;
            this.f6625c = y1Var;
        }
    }

    boolean a(y1 y1Var);

    void b(j0.e eVar);

    boolean c();

    void d();

    void e();

    void f();

    void flush();

    void g();

    n3 h();

    void i(n3 n3Var);

    void j(o3 o3Var);

    boolean k();

    void l(c cVar);

    void m(float f6);

    int n(y1 y1Var);

    void o(int i6);

    void p(y1 y1Var, int i6, int[] iArr);

    boolean q(ByteBuffer byteBuffer, long j6, int i6);

    long r(boolean z5);

    void reset();

    void s();

    void setPreferredDevice(AudioDeviceInfo audioDeviceInfo);

    void t(a0 a0Var);

    void u(long j6);

    void v();

    void w(boolean z5);

    void x();
}
