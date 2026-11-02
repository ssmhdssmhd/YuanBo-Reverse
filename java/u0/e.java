package u0;

import android.net.Uri;
import android.util.Pair;
import android.util.SparseArray;
import h0.g3;
import h0.p;
import i2.c1;
import i2.i0;
import i2.t;
import i2.u;
import i2.y;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import m0.m;
import o0.a0;
import o0.b0;
import o0.e0;
import o0.f0;
import o0.l;
import o0.m;
import o0.n;
import o0.q;
import o0.r;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* loaded from: classes.dex */
public class e implements l {

    /* renamed from: c0, reason: collision with root package name */
    public static final r f9531c0 = new r() { // from class: u0.d
        @Override // o0.r
        public final l[] a() {
            l[] B;
            B = e.B();
            return B;
        }

        @Override // o0.r
        public /* synthetic */ l[] b(Uri uri, Map map) {
            return q.a(this, uri, map);
        }
    };

    /* renamed from: d0, reason: collision with root package name */
    private static final byte[] f9532d0 = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};

    /* renamed from: e0, reason: collision with root package name */
    private static final byte[] f9533e0 = c1.n0("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");

    /* renamed from: f0, reason: collision with root package name */
    private static final byte[] f9534f0 = {68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};

    /* renamed from: g0, reason: collision with root package name */
    private static final byte[] f9535g0 = {87, 69, 66, 86, 84, 84, 10, 10, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 10};

    /* renamed from: h0, reason: collision with root package name */
    private static final UUID f9536h0 = new UUID(72057594037932032L, -9223371306706625679L);

    /* renamed from: i0, reason: collision with root package name */
    private static final Map<String, Integer> f9537i0;
    private long A;
    private long B;
    private u C;
    private u D;
    private boolean E;
    private boolean F;
    private int G;
    private long H;
    private long I;
    private int J;
    private int K;
    private int[] L;
    private int M;
    private int N;
    private int O;
    private int P;
    private boolean Q;
    private long R;
    private int S;
    private int T;
    private int U;
    private boolean V;
    private boolean W;
    private boolean X;
    private int Y;
    private byte Z;

    /* renamed from: a, reason: collision with root package name */
    private final u0.c f9538a;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f9539a0;

    /* renamed from: b, reason: collision with root package name */
    private final g f9540b;

    /* renamed from: b0, reason: collision with root package name */
    private n f9541b0;

    /* renamed from: c, reason: collision with root package name */
    private final SparseArray<c> f9542c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f9543d;

    /* renamed from: e, reason: collision with root package name */
    private final i0 f9544e;

    /* renamed from: f, reason: collision with root package name */
    private final i0 f9545f;

    /* renamed from: g, reason: collision with root package name */
    private final i0 f9546g;

    /* renamed from: h, reason: collision with root package name */
    private final i0 f9547h;

    /* renamed from: i, reason: collision with root package name */
    private final i0 f9548i;

    /* renamed from: j, reason: collision with root package name */
    private final i0 f9549j;

    /* renamed from: k, reason: collision with root package name */
    private final i0 f9550k;

    /* renamed from: l, reason: collision with root package name */
    private final i0 f9551l;

    /* renamed from: m, reason: collision with root package name */
    private final i0 f9552m;

    /* renamed from: n, reason: collision with root package name */
    private final i0 f9553n;

    /* renamed from: o, reason: collision with root package name */
    private ByteBuffer f9554o;

    /* renamed from: p, reason: collision with root package name */
    private long f9555p;

    /* renamed from: q, reason: collision with root package name */
    private long f9556q;

    /* renamed from: r, reason: collision with root package name */
    private long f9557r;

    /* renamed from: s, reason: collision with root package name */
    private long f9558s;

    /* renamed from: t, reason: collision with root package name */
    private long f9559t;

    /* renamed from: u, reason: collision with root package name */
    private c f9560u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f9561v;

    /* renamed from: w, reason: collision with root package name */
    private int f9562w;

    /* renamed from: x, reason: collision with root package name */
    private long f9563x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f9564y;

    /* renamed from: z, reason: collision with root package name */
    private long f9565z;

    private final class b implements u0.b {
        private b() {
        }

        @Override // u0.b
        public void a(int i6) {
            e.this.p(i6);
        }

        @Override // u0.b
        public int b(int i6) {
            return e.this.v(i6);
        }

        @Override // u0.b
        public void c(int i6, double d6) {
            e.this.s(i6, d6);
        }

        @Override // u0.b
        public void d(int i6, int i7, m mVar) {
            e.this.m(i6, i7, mVar);
        }

        @Override // u0.b
        public boolean e(int i6) {
            return e.this.A(i6);
        }

        @Override // u0.b
        public void f(int i6, String str) {
            e.this.I(i6, str);
        }

        @Override // u0.b
        public void g(int i6, long j6, long j7) {
            e.this.H(i6, j6, j7);
        }

        @Override // u0.b
        public void h(int i6, long j6) {
            e.this.y(i6, j6);
        }
    }

    protected static final class c {
        public byte[] N;
        public f0 T;
        public boolean U;
        public e0 X;
        public int Y;

        /* renamed from: a, reason: collision with root package name */
        public String f9567a;

        /* renamed from: b, reason: collision with root package name */
        public String f9568b;

        /* renamed from: c, reason: collision with root package name */
        public int f9569c;

        /* renamed from: d, reason: collision with root package name */
        public int f9570d;

        /* renamed from: e, reason: collision with root package name */
        public int f9571e;

        /* renamed from: f, reason: collision with root package name */
        public int f9572f;

        /* renamed from: g, reason: collision with root package name */
        private int f9573g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f9574h;

        /* renamed from: i, reason: collision with root package name */
        public byte[] f9575i;

        /* renamed from: j, reason: collision with root package name */
        public e0.a f9576j;

        /* renamed from: k, reason: collision with root package name */
        public byte[] f9577k;

        /* renamed from: l, reason: collision with root package name */
        public m0.m f9578l;

        /* renamed from: m, reason: collision with root package name */
        public int f9579m = -1;

        /* renamed from: n, reason: collision with root package name */
        public int f9580n = -1;

        /* renamed from: o, reason: collision with root package name */
        public int f9581o = -1;

        /* renamed from: p, reason: collision with root package name */
        public int f9582p = -1;

        /* renamed from: q, reason: collision with root package name */
        public int f9583q = 0;

        /* renamed from: r, reason: collision with root package name */
        public int f9584r = -1;

        /* renamed from: s, reason: collision with root package name */
        public float f9585s = 0.0f;

        /* renamed from: t, reason: collision with root package name */
        public float f9586t = 0.0f;

        /* renamed from: u, reason: collision with root package name */
        public float f9587u = 0.0f;

        /* renamed from: v, reason: collision with root package name */
        public byte[] f9588v = null;

        /* renamed from: w, reason: collision with root package name */
        public int f9589w = -1;

        /* renamed from: x, reason: collision with root package name */
        public boolean f9590x = false;

        /* renamed from: y, reason: collision with root package name */
        public int f9591y = -1;

        /* renamed from: z, reason: collision with root package name */
        public int f9592z = -1;
        public int A = -1;
        public int B = 1000;
        public int C = 200;
        public float D = -1.0f;
        public float E = -1.0f;
        public float F = -1.0f;
        public float G = -1.0f;
        public float H = -1.0f;
        public float I = -1.0f;
        public float J = -1.0f;
        public float K = -1.0f;
        public float L = -1.0f;
        public float M = -1.0f;
        public int O = 1;
        public int P = -1;
        public int Q = 8000;
        public long R = 0;
        public long S = 0;
        public boolean V = true;
        private String W = "eng";

        protected c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        @EnsuresNonNull({"output"})
        public void f() {
            i2.a.e(this.X);
        }

        @EnsuresNonNull({"codecPrivate"})
        private byte[] g(String str) {
            byte[] bArr = this.f9577k;
            if (bArr != null) {
                return bArr;
            }
            throw g3.a("Missing CodecPrivate for codec " + str, null);
        }

        private byte[] h() {
            if (this.D == -1.0f || this.E == -1.0f || this.F == -1.0f || this.G == -1.0f || this.H == -1.0f || this.I == -1.0f || this.J == -1.0f || this.K == -1.0f || this.L == -1.0f || this.M == -1.0f) {
                return null;
            }
            byte[] bArr = new byte[25];
            ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            order.put((byte) 0);
            order.putShort((short) ((this.D * 50000.0f) + 0.5f));
            order.putShort((short) ((this.E * 50000.0f) + 0.5f));
            order.putShort((short) ((this.F * 50000.0f) + 0.5f));
            order.putShort((short) ((this.G * 50000.0f) + 0.5f));
            order.putShort((short) ((this.H * 50000.0f) + 0.5f));
            order.putShort((short) ((this.I * 50000.0f) + 0.5f));
            order.putShort((short) ((this.J * 50000.0f) + 0.5f));
            order.putShort((short) ((this.K * 50000.0f) + 0.5f));
            order.putShort((short) (this.L + 0.5f));
            order.putShort((short) (this.M + 0.5f));
            order.putShort((short) this.B);
            order.putShort((short) this.C);
            return bArr;
        }

        private static Pair<String, List<byte[]>> k(i0 i0Var) {
            try {
                i0Var.T(16);
                long v5 = i0Var.v();
                if (v5 == 1482049860) {
                    return new Pair<>("video/divx", null);
                }
                if (v5 == 859189832) {
                    return new Pair<>("video/3gpp", null);
                }
                if (v5 != 826496599) {
                    t.i("MatroskaExtractor", "Unknown FourCC. Setting mimeType to video/x-unknown");
                    return new Pair<>("video/x-unknown", null);
                }
                byte[] e6 = i0Var.e();
                for (int f6 = i0Var.f() + 20; f6 < e6.length - 4; f6++) {
                    if (e6[f6] == 0 && e6[f6 + 1] == 0 && e6[f6 + 2] == 1 && e6[f6 + 3] == 15) {
                        return new Pair<>("video/wvc1", Collections.singletonList(Arrays.copyOfRange(e6, f6, e6.length)));
                    }
                }
                throw g3.a("Failed to find FourCC VC1 initialization data", null);
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw g3.a("Error parsing FourCC private data", null);
            }
        }

        private static boolean l(i0 i0Var) {
            try {
                int x5 = i0Var.x();
                if (x5 == 1) {
                    return true;
                }
                if (x5 != 65534) {
                    return false;
                }
                i0Var.S(24);
                if (i0Var.y() == e.f9536h0.getMostSignificantBits()) {
                    if (i0Var.y() == e.f9536h0.getLeastSignificantBits()) {
                        return true;
                    }
                }
                return false;
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw g3.a("Error parsing MS/ACM codec private", null);
            }
        }

        private static List<byte[]> m(byte[] bArr) {
            int i6;
            int i7;
            try {
                if (bArr[0] != 2) {
                    throw g3.a("Error parsing vorbis codec private", null);
                }
                int i8 = 1;
                int i9 = 0;
                while (true) {
                    i6 = bArr[i8];
                    if ((i6 & 255) != 255) {
                        break;
                    }
                    i9 += 255;
                    i8++;
                }
                int i10 = i8 + 1;
                int i11 = i9 + (i6 & 255);
                int i12 = 0;
                while (true) {
                    i7 = bArr[i10];
                    if ((i7 & 255) != 255) {
                        break;
                    }
                    i12 += 255;
                    i10++;
                }
                int i13 = i10 + 1;
                int i14 = i12 + (i7 & 255);
                if (bArr[i13] != 1) {
                    throw g3.a("Error parsing vorbis codec private", null);
                }
                byte[] bArr2 = new byte[i11];
                System.arraycopy(bArr, i13, bArr2, 0, i11);
                int i15 = i13 + i11;
                if (bArr[i15] != 3) {
                    throw g3.a("Error parsing vorbis codec private", null);
                }
                int i16 = i15 + i14;
                if (bArr[i16] != 5) {
                    throw g3.a("Error parsing vorbis codec private", null);
                }
                byte[] bArr3 = new byte[bArr.length - i16];
                System.arraycopy(bArr, i16, bArr3, 0, bArr.length - i16);
                ArrayList arrayList = new ArrayList(2);
                arrayList.add(bArr2);
                arrayList.add(bArr3);
                return arrayList;
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw g3.a("Error parsing vorbis codec private", null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean o(boolean z5) {
            return "A_OPUS".equals(this.f9568b) ? z5 : this.f9572f > 0;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:12:0x03da  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x03f5  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0404  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0522  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0416  */
        /* JADX WARN: Removed duplicated region for block: B:90:0x03f7  */
        @org.checkerframework.checker.nullness.qual.EnsuresNonNull({"this.output"})
        @org.checkerframework.checker.nullness.qual.RequiresNonNull({"codecId"})
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void i(o0.n r20, int r21) {
            /*
                Method dump skipped, instructions count: 1592
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: u0.e.c.i(o0.n, int):void");
        }

        @RequiresNonNull({"output"})
        public void j() {
            f0 f0Var = this.T;
            if (f0Var != null) {
                f0Var.a(this.X, this.f9576j);
            }
        }

        public void n() {
            f0 f0Var = this.T;
            if (f0Var != null) {
                f0Var.b();
            }
        }
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("htc_video_rotA-000", 0);
        hashMap.put("htc_video_rotA-090", 90);
        hashMap.put("htc_video_rotA-180", 180);
        hashMap.put("htc_video_rotA-270", 270);
        f9537i0 = Collections.unmodifiableMap(hashMap);
    }

    public e() {
        this(0);
    }

    public e(int i6) {
        this(new u0.a(), i6);
    }

    e(u0.c cVar, int i6) {
        this.f9556q = -1L;
        this.f9557r = -9223372036854775807L;
        this.f9558s = -9223372036854775807L;
        this.f9559t = -9223372036854775807L;
        this.f9565z = -1L;
        this.A = -1L;
        this.B = -9223372036854775807L;
        this.f9538a = cVar;
        cVar.a(new b());
        this.f9543d = (i6 & 1) == 0;
        this.f9540b = new g();
        this.f9542c = new SparseArray<>();
        this.f9546g = new i0(4);
        this.f9547h = new i0(ByteBuffer.allocate(4).putInt(-1).array());
        this.f9548i = new i0(4);
        this.f9544e = new i0(y.f5676a);
        this.f9545f = new i0(4);
        this.f9549j = new i0();
        this.f9550k = new i0();
        this.f9551l = new i0(8);
        this.f9552m = new i0();
        this.f9553n = new i0();
        this.L = new int[1];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ l[] B() {
        return new l[]{new e()};
    }

    private boolean C(a0 a0Var, long j6) {
        if (this.f9564y) {
            this.A = j6;
            a0Var.f8326a = this.f9565z;
            this.f9564y = false;
            return true;
        }
        if (this.f9561v) {
            long j7 = this.A;
            if (j7 != -1) {
                a0Var.f8326a = j7;
                this.A = -1L;
                return true;
            }
        }
        return false;
    }

    private void D(m mVar, int i6) {
        if (this.f9546g.g() >= i6) {
            return;
        }
        if (this.f9546g.b() < i6) {
            i0 i0Var = this.f9546g;
            i0Var.c(Math.max(i0Var.b() * 2, i6));
        }
        mVar.readFully(this.f9546g.e(), this.f9546g.g(), i6 - this.f9546g.g());
        this.f9546g.R(i6);
    }

    private void E() {
        this.S = 0;
        this.T = 0;
        this.U = 0;
        this.V = false;
        this.W = false;
        this.X = false;
        this.Y = 0;
        this.Z = (byte) 0;
        this.f9539a0 = false;
        this.f9549j.O(0);
    }

    private long F(long j6) {
        long j7 = this.f9557r;
        if (j7 != -9223372036854775807L) {
            return c1.P0(j6, j7, 1000L);
        }
        throw g3.a("Can't scale timecode prior to timecodeScale being set.", null);
    }

    private static void G(String str, long j6, byte[] bArr) {
        byte[] t5;
        int i6;
        str.hashCode();
        switch (str) {
            case "S_TEXT/ASS":
                t5 = t(j6, "%01d:%02d:%02d:%02d", 10000L);
                i6 = 21;
                break;
            case "S_TEXT/WEBVTT":
                t5 = t(j6, "%02d:%02d:%02d.%03d", 1000L);
                i6 = 25;
                break;
            case "S_TEXT/UTF8":
                t5 = t(j6, "%02d:%02d:%02d,%03d", 1000L);
                i6 = 19;
                break;
            default:
                throw new IllegalArgumentException();
        }
        System.arraycopy(t5, 0, bArr, i6, t5.length);
    }

    @RequiresNonNull({"#2.output"})
    private int J(m mVar, c cVar, int i6, boolean z5) {
        int i7;
        if ("S_TEXT/UTF8".equals(cVar.f9568b)) {
            K(mVar, f9532d0, i6);
        } else if ("S_TEXT/ASS".equals(cVar.f9568b)) {
            K(mVar, f9534f0, i6);
        } else {
            if (!"S_TEXT/WEBVTT".equals(cVar.f9568b)) {
                e0 e0Var = cVar.X;
                if (!this.V) {
                    if (cVar.f9574h) {
                        this.O &= -1073741825;
                        if (!this.W) {
                            mVar.readFully(this.f9546g.e(), 0, 1);
                            this.S++;
                            if ((this.f9546g.e()[0] & 128) == 128) {
                                throw g3.a("Extension bit is set in signal byte", null);
                            }
                            this.Z = this.f9546g.e()[0];
                            this.W = true;
                        }
                        byte b6 = this.Z;
                        if ((b6 & 1) == 1) {
                            boolean z6 = (b6 & 2) == 2;
                            this.O |= 1073741824;
                            if (!this.f9539a0) {
                                mVar.readFully(this.f9551l.e(), 0, 8);
                                this.S += 8;
                                this.f9539a0 = true;
                                this.f9546g.e()[0] = (byte) ((z6 ? 128 : 0) | 8);
                                this.f9546g.S(0);
                                e0Var.a(this.f9546g, 1, 1);
                                this.T++;
                                this.f9551l.S(0);
                                e0Var.a(this.f9551l, 8, 1);
                                this.T += 8;
                            }
                            if (z6) {
                                if (!this.X) {
                                    mVar.readFully(this.f9546g.e(), 0, 1);
                                    this.S++;
                                    this.f9546g.S(0);
                                    this.Y = this.f9546g.F();
                                    this.X = true;
                                }
                                int i8 = this.Y * 4;
                                this.f9546g.O(i8);
                                mVar.readFully(this.f9546g.e(), 0, i8);
                                this.S += i8;
                                short s5 = (short) ((this.Y / 2) + 1);
                                int i9 = (s5 * 6) + 2;
                                ByteBuffer byteBuffer = this.f9554o;
                                if (byteBuffer == null || byteBuffer.capacity() < i9) {
                                    this.f9554o = ByteBuffer.allocate(i9);
                                }
                                this.f9554o.position(0);
                                this.f9554o.putShort(s5);
                                int i10 = 0;
                                int i11 = 0;
                                while (true) {
                                    i7 = this.Y;
                                    if (i10 >= i7) {
                                        break;
                                    }
                                    int J = this.f9546g.J();
                                    if (i10 % 2 == 0) {
                                        this.f9554o.putShort((short) (J - i11));
                                    } else {
                                        this.f9554o.putInt(J - i11);
                                    }
                                    i10++;
                                    i11 = J;
                                }
                                int i12 = (i6 - this.S) - i11;
                                int i13 = i7 % 2;
                                ByteBuffer byteBuffer2 = this.f9554o;
                                if (i13 == 1) {
                                    byteBuffer2.putInt(i12);
                                } else {
                                    byteBuffer2.putShort((short) i12);
                                    this.f9554o.putInt(0);
                                }
                                this.f9552m.Q(this.f9554o.array(), i9);
                                e0Var.a(this.f9552m, i9, 1);
                                this.T += i9;
                            }
                        }
                    } else {
                        byte[] bArr = cVar.f9575i;
                        if (bArr != null) {
                            this.f9549j.Q(bArr, bArr.length);
                        }
                    }
                    if (cVar.o(z5)) {
                        this.O |= 268435456;
                        this.f9553n.O(0);
                        int g6 = (this.f9549j.g() + i6) - this.S;
                        this.f9546g.O(4);
                        this.f9546g.e()[0] = (byte) ((g6 >> 24) & 255);
                        this.f9546g.e()[1] = (byte) ((g6 >> 16) & 255);
                        this.f9546g.e()[2] = (byte) ((g6 >> 8) & 255);
                        this.f9546g.e()[3] = (byte) (g6 & 255);
                        e0Var.a(this.f9546g, 4, 2);
                        this.T += 4;
                    }
                    this.V = true;
                }
                int g7 = i6 + this.f9549j.g();
                if (!"V_MPEG4/ISO/AVC".equals(cVar.f9568b) && !"V_MPEGH/ISO/HEVC".equals(cVar.f9568b)) {
                    if (cVar.T != null) {
                        i2.a.g(this.f9549j.g() == 0);
                        cVar.T.d(mVar);
                    }
                    while (true) {
                        int i14 = this.S;
                        if (i14 >= g7) {
                            break;
                        }
                        int L = L(mVar, e0Var, g7 - i14);
                        this.S += L;
                        this.T += L;
                    }
                } else {
                    byte[] e6 = this.f9545f.e();
                    e6[0] = 0;
                    e6[1] = 0;
                    e6[2] = 0;
                    int i15 = cVar.Y;
                    int i16 = 4 - i15;
                    while (this.S < g7) {
                        int i17 = this.U;
                        if (i17 == 0) {
                            M(mVar, e6, i16, i15);
                            this.S += i15;
                            this.f9545f.S(0);
                            this.U = this.f9545f.J();
                            this.f9544e.S(0);
                            e0Var.d(this.f9544e, 4);
                            this.T += 4;
                        } else {
                            int L2 = L(mVar, e0Var, i17);
                            this.S += L2;
                            this.T += L2;
                            this.U -= L2;
                        }
                    }
                }
                if ("A_VORBIS".equals(cVar.f9568b)) {
                    this.f9547h.S(0);
                    e0Var.d(this.f9547h, 4);
                    this.T += 4;
                }
                return r();
            }
            K(mVar, f9535g0, i6);
        }
        return r();
    }

    private void K(m mVar, byte[] bArr, int i6) {
        int length = bArr.length + i6;
        if (this.f9550k.b() < length) {
            this.f9550k.P(Arrays.copyOf(bArr, length + i6));
        } else {
            System.arraycopy(bArr, 0, this.f9550k.e(), 0, bArr.length);
        }
        mVar.readFully(this.f9550k.e(), bArr.length, i6);
        this.f9550k.S(0);
        this.f9550k.R(length);
    }

    private int L(m mVar, e0 e0Var, int i6) {
        int a6 = this.f9549j.a();
        if (a6 <= 0) {
            return e0Var.b(mVar, i6, false);
        }
        int min = Math.min(i6, a6);
        e0Var.d(this.f9549j, min);
        return min;
    }

    private void M(m mVar, byte[] bArr, int i6, int i7) {
        int min = Math.min(i7, this.f9549j.a());
        mVar.readFully(bArr, i6 + min, i7 - min);
        if (min > 0) {
            this.f9549j.j(bArr, i6, min);
        }
    }

    @EnsuresNonNull({"cueTimesUs", "cueClusterPositions"})
    private void i(int i6) {
        if (this.C == null || this.D == null) {
            throw g3.a("Element " + i6 + " must be in a Cues", null);
        }
    }

    @EnsuresNonNull({"currentTrack"})
    private void k(int i6) {
        if (this.f9560u != null) {
            return;
        }
        throw g3.a("Element " + i6 + " must be in a TrackEntry", null);
    }

    @EnsuresNonNull({"extractorOutput"})
    private void l() {
        i2.a.i(this.f9541b0);
    }

    private b0 n(u uVar, u uVar2) {
        int i6;
        if (this.f9556q == -1 || this.f9559t == -9223372036854775807L || uVar == null || uVar.c() == 0 || uVar2 == null || uVar2.c() != uVar.c()) {
            return new b0.b(this.f9559t);
        }
        int c6 = uVar.c();
        int[] iArr = new int[c6];
        long[] jArr = new long[c6];
        long[] jArr2 = new long[c6];
        long[] jArr3 = new long[c6];
        int i7 = 0;
        for (int i8 = 0; i8 < c6; i8++) {
            jArr3[i8] = uVar.b(i8);
            jArr[i8] = this.f9556q + uVar2.b(i8);
        }
        while (true) {
            i6 = c6 - 1;
            if (i7 >= i6) {
                break;
            }
            int i9 = i7 + 1;
            iArr[i7] = (int) (jArr[i9] - jArr[i7]);
            jArr2[i7] = jArr3[i9] - jArr3[i7];
            i7 = i9;
        }
        iArr[i6] = (int) ((this.f9556q + this.f9555p) - jArr[i6]);
        long j6 = this.f9559t - jArr3[i6];
        jArr2[i6] = j6;
        if (j6 <= 0) {
            t.i("MatroskaExtractor", "Discarding last cue point with unexpected duration: " + j6);
            iArr = Arrays.copyOf(iArr, i6);
            jArr = Arrays.copyOf(jArr, i6);
            jArr2 = Arrays.copyOf(jArr2, i6);
            jArr3 = Arrays.copyOf(jArr3, i6);
        }
        return new o0.d(iArr, jArr, jArr2, jArr3);
    }

    @RequiresNonNull({"#1.output"})
    private void o(c cVar, long j6, int i6, int i7, int i8) {
        String str;
        f0 f0Var = cVar.T;
        if (f0Var != null) {
            f0Var.c(cVar.X, j6, i6, i7, i8, cVar.f9576j);
        } else {
            if ("S_TEXT/UTF8".equals(cVar.f9568b) || "S_TEXT/ASS".equals(cVar.f9568b) || "S_TEXT/WEBVTT".equals(cVar.f9568b)) {
                if (this.K > 1) {
                    str = "Skipping subtitle sample in laced block.";
                } else {
                    long j7 = this.I;
                    if (j7 == -9223372036854775807L) {
                        str = "Skipping subtitle sample with no duration.";
                    } else {
                        G(cVar.f9568b, j7, this.f9550k.e());
                        int f6 = this.f9550k.f();
                        while (true) {
                            if (f6 >= this.f9550k.g()) {
                                break;
                            }
                            if (this.f9550k.e()[f6] == 0) {
                                this.f9550k.R(f6);
                                break;
                            }
                            f6++;
                        }
                        e0 e0Var = cVar.X;
                        i0 i0Var = this.f9550k;
                        e0Var.d(i0Var, i0Var.g());
                        i7 += this.f9550k.g();
                    }
                }
                t.i("MatroskaExtractor", str);
            }
            if ((268435456 & i6) != 0) {
                if (this.K > 1) {
                    this.f9553n.O(0);
                } else {
                    int g6 = this.f9553n.g();
                    cVar.X.a(this.f9553n, g6, 2);
                    i7 += g6;
                }
            }
            cVar.X.e(j6, i6, i7, i8, cVar.f9576j);
        }
        this.F = true;
    }

    private static int[] q(int[] iArr, int i6) {
        return iArr == null ? new int[i6] : iArr.length >= i6 ? iArr : new int[Math.max(iArr.length * 2, i6)];
    }

    private int r() {
        int i6 = this.T;
        E();
        return i6;
    }

    private static byte[] t(long j6, String str, long j7) {
        i2.a.a(j6 != -9223372036854775807L);
        int i6 = (int) (j6 / 3600000000L);
        long j8 = j6 - ((i6 * 3600) * 1000000);
        int i7 = (int) (j8 / 60000000);
        long j9 = j8 - ((i7 * 60) * 1000000);
        int i8 = (int) (j9 / 1000000);
        return c1.n0(String.format(Locale.US, str, Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf((int) ((j9 - (i8 * 1000000)) / j7))));
    }

    private static boolean z(String str) {
        str.hashCode();
        switch (str) {
            case "V_MPEG4/ISO/AP":
            case "V_MPEG4/ISO/SP":
            case "A_MS/ACM":
            case "A_TRUEHD":
            case "A_VORBIS":
            case "A_MPEG/L2":
            case "A_MPEG/L3":
            case "V_MS/VFW/FOURCC":
            case "S_DVBSUB":
            case "V_MPEG4/ISO/ASP":
            case "V_MPEG4/ISO/AVC":
            case "S_VOBSUB":
            case "A_DTS/LOSSLESS":
            case "A_AAC":
            case "A_AC3":
            case "A_DTS":
            case "V_AV1":
            case "V_VP8":
            case "V_VP9":
            case "S_HDMV/PGS":
            case "V_THEORA":
            case "A_DTS/EXPRESS":
            case "A_PCM/FLOAT/IEEE":
            case "A_PCM/INT/BIG":
            case "A_PCM/INT/LIT":
            case "S_TEXT/ASS":
            case "V_MPEGH/ISO/HEVC":
            case "S_TEXT/WEBVTT":
            case "S_TEXT/UTF8":
            case "V_MPEG2":
            case "A_EAC3":
            case "A_FLAC":
            case "A_OPUS":
                return true;
            default:
                return false;
        }
    }

    protected boolean A(int i6) {
        return i6 == 357149030 || i6 == 524531317 || i6 == 475249515 || i6 == 374648427;
    }

    protected void H(int i6, long j6, long j7) {
        l();
        if (i6 == 160) {
            this.Q = false;
            this.R = 0L;
            return;
        }
        if (i6 == 174) {
            this.f9560u = new c();
            return;
        }
        if (i6 == 187) {
            this.E = false;
            return;
        }
        if (i6 == 19899) {
            this.f9562w = -1;
            this.f9563x = -1L;
            return;
        }
        if (i6 == 20533) {
            u(i6).f9574h = true;
            return;
        }
        if (i6 == 21968) {
            u(i6).f9590x = true;
            return;
        }
        if (i6 == 408125543) {
            long j8 = this.f9556q;
            if (j8 != -1 && j8 != j6) {
                throw g3.a("Multiple Segment elements not supported", null);
            }
            this.f9556q = j6;
            this.f9555p = j7;
            return;
        }
        if (i6 == 475249515) {
            this.C = new u();
            this.D = new u();
        } else if (i6 == 524531317 && !this.f9561v) {
            if (this.f9543d && this.f9565z != -1) {
                this.f9564y = true;
            } else {
                this.f9541b0.t(new b0.b(this.f9559t));
                this.f9561v = true;
            }
        }
    }

    protected void I(int i6, String str) {
        if (i6 == 134) {
            u(i6).f9568b = str;
            return;
        }
        if (i6 != 17026) {
            if (i6 == 21358) {
                u(i6).f9567a = str;
                return;
            } else {
                if (i6 != 2274716) {
                    return;
                }
                u(i6).W = str;
                return;
            }
        }
        if ("webm".equals(str) || "matroska".equals(str)) {
            return;
        }
        throw g3.a("DocType " + str + " not supported", null);
    }

    @Override // o0.l
    public final void a() {
    }

    @Override // o0.l
    public void b(long j6, long j7) {
        this.B = -9223372036854775807L;
        this.G = 0;
        this.f9538a.reset();
        this.f9540b.e();
        E();
        for (int i6 = 0; i6 < this.f9542c.size(); i6++) {
            this.f9542c.valueAt(i6).n();
        }
    }

    @Override // o0.l
    public final void c(n nVar) {
        this.f9541b0 = nVar;
    }

    @Override // o0.l
    public final boolean g(m mVar) {
        return new f().b(mVar);
    }

    @Override // o0.l
    public final int j(m mVar, a0 a0Var) {
        this.F = false;
        boolean z5 = true;
        while (z5 && !this.F) {
            z5 = this.f9538a.b(mVar);
            if (z5 && C(a0Var, mVar.getPosition())) {
                return 1;
            }
        }
        if (z5) {
            return 0;
        }
        for (int i6 = 0; i6 < this.f9542c.size(); i6++) {
            c valueAt = this.f9542c.valueAt(i6);
            valueAt.f();
            valueAt.j();
        }
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:121:0x0237, code lost:
    
        throw h0.g3.a("EBML lacing sample size out of range.", null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void m(int r23, int r24, o0.m r25) {
        /*
            Method dump skipped, instructions count: 756
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u0.e.m(int, int, o0.m):void");
    }

    protected void p(int i6) {
        l();
        if (i6 == 160) {
            if (this.G != 2) {
                return;
            }
            c cVar = this.f9542c.get(this.M);
            cVar.f();
            if (this.R > 0 && "A_OPUS".equals(cVar.f9568b)) {
                this.f9553n.P(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(this.R).array());
            }
            int i7 = 0;
            for (int i8 = 0; i8 < this.K; i8++) {
                i7 += this.L[i8];
            }
            int i9 = 0;
            while (i9 < this.K) {
                long j6 = this.H + ((cVar.f9571e * i9) / 1000);
                int i10 = this.O;
                if (i9 == 0 && !this.Q) {
                    i10 |= 1;
                }
                int i11 = this.L[i9];
                int i12 = i7 - i11;
                o(cVar, j6, i10, i11, i12);
                i9++;
                i7 = i12;
            }
            this.G = 0;
            return;
        }
        if (i6 == 174) {
            c cVar2 = (c) i2.a.i(this.f9560u);
            String str = cVar2.f9568b;
            if (str == null) {
                throw g3.a("CodecId is missing in TrackEntry element", null);
            }
            if (z(str)) {
                cVar2.i(this.f9541b0, cVar2.f9569c);
                this.f9542c.put(cVar2.f9569c, cVar2);
            }
            this.f9560u = null;
            return;
        }
        if (i6 == 19899) {
            int i13 = this.f9562w;
            if (i13 != -1) {
                long j7 = this.f9563x;
                if (j7 != -1) {
                    if (i13 == 475249515) {
                        this.f9565z = j7;
                        return;
                    }
                    return;
                }
            }
            throw g3.a("Mandatory element SeekID or SeekPosition not found", null);
        }
        if (i6 == 25152) {
            k(i6);
            c cVar3 = this.f9560u;
            if (cVar3.f9574h) {
                if (cVar3.f9576j == null) {
                    throw g3.a("Encrypted Track found but ContentEncKeyID was not found", null);
                }
                cVar3.f9578l = new m0.m(new m.b(p.f4771a, "video/webm", this.f9560u.f9576j.f8348b));
                return;
            }
            return;
        }
        if (i6 == 28032) {
            k(i6);
            c cVar4 = this.f9560u;
            if (cVar4.f9574h && cVar4.f9575i != null) {
                throw g3.a("Combining encryption and compression is not supported", null);
            }
            return;
        }
        if (i6 == 357149030) {
            if (this.f9557r == -9223372036854775807L) {
                this.f9557r = 1000000L;
            }
            long j8 = this.f9558s;
            if (j8 != -9223372036854775807L) {
                this.f9559t = F(j8);
                return;
            }
            return;
        }
        if (i6 == 374648427) {
            if (this.f9542c.size() == 0) {
                throw g3.a("No valid tracks were found", null);
            }
            this.f9541b0.j();
        } else {
            if (i6 != 475249515) {
                return;
            }
            if (!this.f9561v) {
                this.f9541b0.t(n(this.C, this.D));
                this.f9561v = true;
            }
            this.C = null;
            this.D = null;
        }
    }

    protected void s(int i6, double d6) {
        if (i6 == 181) {
            u(i6).Q = (int) d6;
        }
        if (i6 == 17545) {
            this.f9558s = (long) d6;
            return;
        }
        switch (i6) {
            case 21969:
                u(i6).D = (float) d6;
                break;
            case 21970:
                u(i6).E = (float) d6;
                break;
            case 21971:
                u(i6).F = (float) d6;
                break;
            case 21972:
                u(i6).G = (float) d6;
                break;
            case 21973:
                u(i6).H = (float) d6;
                break;
            case 21974:
                u(i6).I = (float) d6;
                break;
            case 21975:
                u(i6).J = (float) d6;
                break;
            case 21976:
                u(i6).K = (float) d6;
                break;
            case 21977:
                u(i6).L = (float) d6;
                break;
            case 21978:
                u(i6).M = (float) d6;
                break;
            default:
                switch (i6) {
                    case 30323:
                        u(i6).f9585s = (float) d6;
                        break;
                    case 30324:
                        u(i6).f9586t = (float) d6;
                        break;
                    case 30325:
                        u(i6).f9587u = (float) d6;
                        break;
                }
        }
    }

    protected c u(int i6) {
        k(i6);
        return this.f9560u;
    }

    protected int v(int i6) {
        switch (i6) {
            case 131:
            case 136:
            case 155:
            case 159:
            case 176:
            case 179:
            case 186:
            case 215:
            case 231:
            case 238:
            case 241:
            case 251:
            case 16871:
            case 16980:
            case 17029:
            case 17143:
            case 18401:
            case 18408:
            case 20529:
            case 20530:
            case 21420:
            case 21432:
            case 21680:
            case 21682:
            case 21690:
            case 21930:
            case 21945:
            case 21946:
            case 21947:
            case 21948:
            case 21949:
            case 21998:
            case 22186:
            case 22203:
            case 25188:
            case 30114:
            case 30321:
            case 2352003:
            case 2807729:
                return 2;
            case 134:
            case 17026:
            case 21358:
            case 2274716:
                return 3;
            case 160:
            case 166:
            case 174:
            case 183:
            case 187:
            case 224:
            case 225:
            case 16868:
            case 18407:
            case 19899:
            case 20532:
            case 20533:
            case 21936:
            case 21968:
            case 25152:
            case 28032:
            case 30113:
            case 30320:
            case 290298740:
            case 357149030:
            case 374648427:
            case 408125543:
            case 440786851:
            case 475249515:
            case 524531317:
                return 1;
            case 161:
            case 163:
            case 165:
            case 16877:
            case 16981:
            case 18402:
            case 21419:
            case 25506:
            case 30322:
                return 4;
            case 181:
            case 17545:
            case 21969:
            case 21970:
            case 21971:
            case 21972:
            case 21973:
            case 21974:
            case 21975:
            case 21976:
            case 21977:
            case 21978:
            case 30323:
            case 30324:
            case 30325:
                return 5;
            default:
                return 0;
        }
    }

    protected void w(c cVar, o0.m mVar, int i6) {
        if (cVar.f9573g != 1685485123 && cVar.f9573g != 1685480259) {
            mVar.h(i6);
            return;
        }
        byte[] bArr = new byte[i6];
        cVar.N = bArr;
        mVar.readFully(bArr, 0, i6);
    }

    protected void x(c cVar, int i6, o0.m mVar, int i7) {
        if (i6 != 4 || !"V_VP9".equals(cVar.f9568b)) {
            mVar.h(i7);
        } else {
            this.f9553n.O(i7);
            mVar.readFully(this.f9553n.e(), 0, i7);
        }
    }

    protected void y(int i6, long j6) {
        if (i6 == 20529) {
            if (j6 == 0) {
                return;
            }
            throw g3.a("ContentEncodingOrder " + j6 + " not supported", null);
        }
        if (i6 == 20530) {
            if (j6 == 1) {
                return;
            }
            throw g3.a("ContentEncodingScope " + j6 + " not supported", null);
        }
        switch (i6) {
            case 131:
                u(i6).f9570d = (int) j6;
                return;
            case 136:
                u(i6).V = j6 == 1;
                return;
            case 155:
                this.I = F(j6);
                return;
            case 159:
                u(i6).O = (int) j6;
                return;
            case 176:
                u(i6).f9579m = (int) j6;
                return;
            case 179:
                i(i6);
                this.C.a(F(j6));
                return;
            case 186:
                u(i6).f9580n = (int) j6;
                return;
            case 215:
                u(i6).f9569c = (int) j6;
                return;
            case 231:
                this.B = F(j6);
                return;
            case 238:
                this.P = (int) j6;
                return;
            case 241:
                if (this.E) {
                    return;
                }
                i(i6);
                this.D.a(j6);
                this.E = true;
                return;
            case 251:
                this.Q = true;
                return;
            case 16871:
                u(i6).f9573g = (int) j6;
                return;
            case 16980:
                if (j6 == 3) {
                    return;
                }
                throw g3.a("ContentCompAlgo " + j6 + " not supported", null);
            case 17029:
                if (j6 < 1 || j6 > 2) {
                    throw g3.a("DocTypeReadVersion " + j6 + " not supported", null);
                }
                return;
            case 17143:
                if (j6 == 1) {
                    return;
                }
                throw g3.a("EBMLReadVersion " + j6 + " not supported", null);
            case 18401:
                if (j6 == 5) {
                    return;
                }
                throw g3.a("ContentEncAlgo " + j6 + " not supported", null);
            case 18408:
                if (j6 == 1) {
                    return;
                }
                throw g3.a("AESSettingsCipherMode " + j6 + " not supported", null);
            case 21420:
                this.f9563x = j6 + this.f9556q;
                return;
            case 21432:
                int i7 = (int) j6;
                k(i6);
                if (i7 == 0) {
                    this.f9560u.f9589w = 0;
                    return;
                }
                if (i7 == 1) {
                    this.f9560u.f9589w = 2;
                    return;
                } else if (i7 == 3) {
                    this.f9560u.f9589w = 1;
                    return;
                } else {
                    if (i7 != 15) {
                        return;
                    }
                    this.f9560u.f9589w = 3;
                    return;
                }
            case 21680:
                u(i6).f9581o = (int) j6;
                return;
            case 21682:
                u(i6).f9583q = (int) j6;
                return;
            case 21690:
                u(i6).f9582p = (int) j6;
                return;
            case 21930:
                u(i6).U = j6 == 1;
                return;
            case 21998:
                u(i6).f9572f = (int) j6;
                return;
            case 22186:
                u(i6).R = j6;
                return;
            case 22203:
                u(i6).S = j6;
                return;
            case 25188:
                u(i6).P = (int) j6;
                return;
            case 30114:
                this.R = j6;
                return;
            case 30321:
                k(i6);
                int i8 = (int) j6;
                if (i8 == 0) {
                    this.f9560u.f9584r = 0;
                    return;
                }
                if (i8 == 1) {
                    this.f9560u.f9584r = 1;
                    return;
                } else if (i8 == 2) {
                    this.f9560u.f9584r = 2;
                    return;
                } else {
                    if (i8 != 3) {
                        return;
                    }
                    this.f9560u.f9584r = 3;
                    return;
                }
            case 2352003:
                u(i6).f9571e = (int) j6;
                return;
            case 2807729:
                this.f9557r = j6;
                return;
            default:
                switch (i6) {
                    case 21945:
                        k(i6);
                        int i9 = (int) j6;
                        if (i9 == 1) {
                            this.f9560u.A = 2;
                            return;
                        } else {
                            if (i9 != 2) {
                                return;
                            }
                            this.f9560u.A = 1;
                            return;
                        }
                    case 21946:
                        k(i6);
                        int c6 = j2.c.c((int) j6);
                        if (c6 != -1) {
                            this.f9560u.f9592z = c6;
                            return;
                        }
                        return;
                    case 21947:
                        k(i6);
                        this.f9560u.f9590x = true;
                        int b6 = j2.c.b((int) j6);
                        if (b6 != -1) {
                            this.f9560u.f9591y = b6;
                            return;
                        }
                        return;
                    case 21948:
                        u(i6).B = (int) j6;
                        return;
                    case 21949:
                        u(i6).C = (int) j6;
                        return;
                    default:
                        return;
                }
        }
    }
}
