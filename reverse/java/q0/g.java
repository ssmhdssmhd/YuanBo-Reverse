package q0;

import h0.y1;
import i2.c1;
import i2.i0;
import i2.t;
import m2.q;

/* loaded from: classes.dex */
final class g implements a {

    /* renamed from: a, reason: collision with root package name */
    public final y1 f8707a;

    public g(y1 y1Var) {
        this.f8707a = y1Var;
    }

    private static String b(int i6) {
        switch (i6) {
            case 808802372:
            case 877677894:
            case 1145656883:
            case 1145656920:
            case 1482049860:
            case 1684633208:
            case 2021026148:
                return "video/mp4v-es";
            case 826496577:
            case 828601953:
            case 875967048:
                return "video/avc";
            case 842289229:
                return "video/mp42";
            case 859066445:
                return "video/mp43";
            case 1196444237:
            case 1735420525:
                return "video/mjpeg";
            default:
                return null;
        }
    }

    private static String c(int i6) {
        if (i6 == 1) {
            return "audio/raw";
        }
        if (i6 == 85) {
            return "audio/mpeg";
        }
        if (i6 == 255) {
            return "audio/mp4a-latm";
        }
        if (i6 == 8192) {
            return "audio/ac3";
        }
        if (i6 != 8193) {
            return null;
        }
        return "audio/vnd.dts";
    }

    private static a d(i0 i0Var) {
        i0Var.T(4);
        int s5 = i0Var.s();
        int s6 = i0Var.s();
        i0Var.T(4);
        int s7 = i0Var.s();
        String b6 = b(s7);
        if (b6 != null) {
            y1.b bVar = new y1.b();
            bVar.n0(s5).S(s6).g0(b6);
            return new g(bVar.G());
        }
        t.i("StreamFormatChunk", "Ignoring track with unsupported compression " + s7);
        return null;
    }

    public static a e(int i6, i0 i0Var) {
        if (i6 == 2) {
            return d(i0Var);
        }
        if (i6 == 1) {
            return f(i0Var);
        }
        t.i("StreamFormatChunk", "Ignoring strf box for unsupported track type: " + c1.m0(i6));
        return null;
    }

    private static a f(i0 i0Var) {
        int x5 = i0Var.x();
        String c6 = c(x5);
        if (c6 == null) {
            t.i("StreamFormatChunk", "Ignoring track with unsupported format tag " + x5);
            return null;
        }
        int x6 = i0Var.x();
        int s5 = i0Var.s();
        i0Var.T(6);
        int d02 = c1.d0(i0Var.L());
        int x7 = i0Var.x();
        byte[] bArr = new byte[x7];
        i0Var.j(bArr, 0, x7);
        y1.b bVar = new y1.b();
        bVar.g0(c6).J(x6).h0(s5);
        if ("audio/raw".equals(c6) && d02 != 0) {
            bVar.a0(d02);
        }
        if ("audio/mp4a-latm".equals(c6) && x7 > 0) {
            bVar.V(q.r(bArr));
        }
        return new g(bVar.G());
    }

    @Override // q0.a
    public int a() {
        return 1718776947;
    }
}
