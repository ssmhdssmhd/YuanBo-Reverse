package a1;

import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Pair;
import h0.y1;
import i2.c1;
import java.util.List;

/* loaded from: classes.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public final String f85a;

    /* renamed from: b, reason: collision with root package name */
    public final String f86b;

    /* renamed from: c, reason: collision with root package name */
    public final String f87c;

    /* renamed from: d, reason: collision with root package name */
    public final MediaCodecInfo.CodecCapabilities f88d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f89e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f90f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f91g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f92h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f93i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f94j;

    /* renamed from: k, reason: collision with root package name */
    private final boolean f95k;

    private static final class a {
        public static int a(MediaCodecInfo.VideoCapabilities videoCapabilities, int i6, int i7, double d6) {
            List supportedPerformancePoints;
            boolean covers;
            supportedPerformancePoints = videoCapabilities.getSupportedPerformancePoints();
            if (supportedPerformancePoints == null || supportedPerformancePoints.isEmpty() || t.C()) {
                return 0;
            }
            MediaCodecInfo.VideoCapabilities.PerformancePoint performancePoint = new MediaCodecInfo.VideoCapabilities.PerformancePoint(i6, i7, (int) d6);
            for (int i8 = 0; i8 < supportedPerformancePoints.size(); i8++) {
                covers = ((MediaCodecInfo.VideoCapabilities.PerformancePoint) supportedPerformancePoints.get(i8)).covers(performancePoint);
                if (covers) {
                    return 2;
                }
            }
            return 1;
        }
    }

    t(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10) {
        this.f85a = (String) i2.a.e(str);
        this.f86b = str2;
        this.f87c = str3;
        this.f88d = codecCapabilities;
        this.f92h = z5;
        this.f93i = z6;
        this.f94j = z7;
        this.f89e = z8;
        this.f90f = z9;
        this.f91g = z10;
        this.f95k = i2.x.s(str2);
    }

    private static boolean A(String str) {
        return c1.f5551d.startsWith("SM-T230") && "OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(str);
    }

    private static boolean B(String str) {
        if (c1.f5548a <= 22) {
            String str2 = c1.f5551d;
            if (("ODROID-XU3".equals(str2) || "Nexus 10".equals(str2)) && ("OMX.Exynos.AVC.Decoder".equals(str) || "OMX.Exynos.AVC.Decoder.secure".equals(str))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean C() {
        String str = c1.f5549b;
        if (!str.equals("sabrina") && !str.equals("boreal")) {
            String str2 = c1.f5551d;
            if (!str2.startsWith("Lenovo TB-X605") && !str2.startsWith("Lenovo TB-X606") && !str2.startsWith("Lenovo TB-X616")) {
                return false;
            }
        }
        return true;
    }

    private static boolean D(String str, int i6) {
        if ("video/hevc".equals(str) && 2 == i6) {
            String str2 = c1.f5549b;
            if ("sailfish".equals(str2) || "marlin".equals(str2)) {
                return true;
            }
        }
        return false;
    }

    private static boolean E(String str) {
        return ("OMX.MTK.VIDEO.DECODER.HEVC".equals(str) && "mcv5a".equals(c1.f5549b)) ? false : true;
    }

    public static t F(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9) {
        return new t(str, str2, str3, codecCapabilities, z5, z6, z7, (z8 || codecCapabilities == null || !i(codecCapabilities) || B(str)) ? false : true, codecCapabilities != null && u(codecCapabilities), z9 || (codecCapabilities != null && s(codecCapabilities)));
    }

    private static int b(String str, String str2, int i6) {
        if (i6 > 1 || ((c1.f5548a >= 26 && i6 > 0) || "audio/mpeg".equals(str2) || "audio/3gpp".equals(str2) || "audio/amr-wb".equals(str2) || "audio/mp4a-latm".equals(str2) || "audio/vorbis".equals(str2) || "audio/opus".equals(str2) || "audio/raw".equals(str2) || "audio/flac".equals(str2) || "audio/g711-alaw".equals(str2) || "audio/g711-mlaw".equals(str2) || "audio/gsm".equals(str2))) {
            return i6;
        }
        int i7 = "audio/ac3".equals(str2) ? 6 : "audio/eac3".equals(str2) ? 16 : 30;
        i2.t.i("MediaCodecInfo", "AssumedMaxChannelAdjustment: " + str + ", [" + i6 + " to " + i7 + "]");
        return i7;
    }

    private static Point d(MediaCodecInfo.VideoCapabilities videoCapabilities, int i6, int i7) {
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        return new Point(c1.l(i6, widthAlignment) * widthAlignment, c1.l(i7, heightAlignment) * heightAlignment);
    }

    private static boolean e(MediaCodecInfo.VideoCapabilities videoCapabilities, int i6, int i7, double d6) {
        Point d7 = d(videoCapabilities, i6, i7);
        int i8 = d7.x;
        int i9 = d7.y;
        return (d6 == -1.0d || d6 < 1.0d) ? videoCapabilities.isSizeSupported(i8, i9) : videoCapabilities.areSizeAndRateSupported(i8, i9, Math.floor(d6));
    }

    private static MediaCodecInfo.CodecProfileLevel[] g(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        int intValue = (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) ? 0 : videoCapabilities.getBitrateRange().getUpper().intValue();
        int i6 = intValue >= 180000000 ? 1024 : intValue >= 120000000 ? 512 : intValue >= 60000000 ? 256 : intValue >= 30000000 ? 128 : intValue >= 18000000 ? 64 : intValue >= 12000000 ? 32 : intValue >= 7200000 ? 16 : intValue >= 3600000 ? 8 : intValue >= 1800000 ? 4 : intValue >= 800000 ? 2 : 1;
        MediaCodecInfo.CodecProfileLevel codecProfileLevel = new MediaCodecInfo.CodecProfileLevel();
        codecProfileLevel.profile = 1;
        codecProfileLevel.level = i6;
        return new MediaCodecInfo.CodecProfileLevel[]{codecProfileLevel};
    }

    private static boolean i(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return c1.f5548a >= 19 && j(codecCapabilities);
    }

    private static boolean j(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("adaptive-playback");
    }

    private boolean m(y1 y1Var, boolean z5) {
        Pair<Integer, Integer> q6 = h0.q(y1Var);
        if (q6 == null) {
            return true;
        }
        int intValue = ((Integer) q6.first).intValue();
        int intValue2 = ((Integer) q6.second).intValue();
        if ("video/dolby-vision".equals(y1Var.f5066p)) {
            if (!"video/avc".equals(this.f86b)) {
                intValue = "video/hevc".equals(this.f86b) ? 2 : 8;
            }
            intValue2 = 0;
        }
        if (!this.f95k && intValue != 42) {
            return true;
        }
        MediaCodecInfo.CodecProfileLevel[] h6 = h();
        if (c1.f5548a <= 23 && "video/x-vnd.on2.vp9".equals(this.f86b) && h6.length == 0) {
            h6 = g(this.f88d);
        }
        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : h6) {
            if (codecProfileLevel.profile == intValue && ((codecProfileLevel.level >= intValue2 || !z5) && !D(this.f86b, intValue))) {
                return true;
            }
        }
        y("codec.profileLevel, " + y1Var.f5063m + ", " + this.f87c);
        return false;
    }

    private boolean q(y1 y1Var) {
        return this.f86b.equals(y1Var.f5066p) || this.f86b.equals(h0.m(y1Var));
    }

    private static boolean s(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return c1.f5548a >= 21 && t(codecCapabilities);
    }

    private static boolean t(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }

    private static boolean u(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return c1.f5548a >= 21 && v(codecCapabilities);
    }

    private static boolean v(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("tunneled-playback");
    }

    private void x(String str) {
        i2.t.b("MediaCodecInfo", "AssumedSupport [" + str + "] [" + this.f85a + ", " + this.f86b + "] [" + c1.f5552e + "]");
    }

    private void y(String str) {
        i2.t.b("MediaCodecInfo", "NoSupport [" + str + "] [" + this.f85a + ", " + this.f86b + "] [" + c1.f5552e + "]");
    }

    private static boolean z(String str) {
        return "audio/opus".equals(str);
    }

    public Point c(int i6, int i7) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f88d;
        if (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) {
            return null;
        }
        return d(videoCapabilities, i6, i7);
    }

    public l0.k f(y1 y1Var, y1 y1Var2) {
        int i6 = !c1.c(y1Var.f5066p, y1Var2.f5066p) ? 8 : 0;
        if (this.f95k) {
            if (y1Var.f5074x != y1Var2.f5074x) {
                i6 |= 1024;
            }
            if (!this.f89e && (y1Var.f5071u != y1Var2.f5071u || y1Var.f5072v != y1Var2.f5072v)) {
                i6 |= 512;
            }
            if (!c1.c(y1Var.B, y1Var2.B)) {
                i6 |= 2048;
            }
            if (A(this.f85a) && !y1Var.g(y1Var2)) {
                i6 |= 2;
            }
            if (i6 == 0) {
                return new l0.k(this.f85a, y1Var, y1Var2, y1Var.g(y1Var2) ? 3 : 2, 0);
            }
        } else {
            if (y1Var.C != y1Var2.C) {
                i6 |= 4096;
            }
            if (y1Var.D != y1Var2.D) {
                i6 |= 8192;
            }
            if (y1Var.E != y1Var2.E) {
                i6 |= 16384;
            }
            if (i6 == 0 && "audio/mp4a-latm".equals(this.f86b)) {
                Pair<Integer, Integer> q6 = h0.q(y1Var);
                Pair<Integer, Integer> q7 = h0.q(y1Var2);
                if (q6 != null && q7 != null) {
                    int intValue = ((Integer) q6.first).intValue();
                    int intValue2 = ((Integer) q7.first).intValue();
                    if (intValue == 42 && intValue2 == 42) {
                        return new l0.k(this.f85a, y1Var, y1Var2, 3, 0);
                    }
                }
            }
            if (!y1Var.g(y1Var2)) {
                i6 |= 32;
            }
            if (z(this.f86b)) {
                i6 |= 2;
            }
            if (i6 == 0) {
                return new l0.k(this.f85a, y1Var, y1Var2, 1, 0);
            }
        }
        return new l0.k(this.f85a, y1Var, y1Var2, 0, i6);
    }

    public MediaCodecInfo.CodecProfileLevel[] h() {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f88d;
        return (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) ? new MediaCodecInfo.CodecProfileLevel[0] : codecProfileLevelArr;
    }

    public boolean k(int i6) {
        String str;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f88d;
        if (codecCapabilities == null) {
            str = "channelCount.caps";
        } else {
            MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
            if (audioCapabilities == null) {
                str = "channelCount.aCaps";
            } else {
                if (b(this.f85a, this.f86b, audioCapabilities.getMaxInputChannelCount()) >= i6) {
                    return true;
                }
                str = "channelCount.support, " + i6;
            }
        }
        y(str);
        return false;
    }

    public boolean l(int i6) {
        String str;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f88d;
        if (codecCapabilities == null) {
            str = "sampleRate.caps";
        } else {
            MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
            if (audioCapabilities == null) {
                str = "sampleRate.aCaps";
            } else {
                if (audioCapabilities.isSampleRateSupported(i6)) {
                    return true;
                }
                str = "sampleRate.support, " + i6;
            }
        }
        y(str);
        return false;
    }

    public boolean n(y1 y1Var) {
        return q(y1Var) && m(y1Var, false);
    }

    public boolean o(y1 y1Var) {
        int i6;
        if (!q(y1Var) || !m(y1Var, true)) {
            return false;
        }
        if (!this.f95k) {
            if (c1.f5548a >= 21) {
                int i7 = y1Var.D;
                if (i7 != -1 && !l(i7)) {
                    return false;
                }
                int i8 = y1Var.C;
                if (i8 != -1 && !k(i8)) {
                    return false;
                }
            }
            return true;
        }
        int i9 = y1Var.f5071u;
        if (i9 <= 0 || (i6 = y1Var.f5072v) <= 0) {
            return true;
        }
        if (c1.f5548a >= 21) {
            return w(i9, i6, y1Var.f5073w);
        }
        boolean z5 = i9 * i6 <= h0.N();
        if (!z5) {
            y("legacyFrameSize, " + y1Var.f5071u + "x" + y1Var.f5072v);
        }
        return z5;
    }

    public boolean p() {
        if (c1.f5548a >= 29 && "video/x-vnd.on2.vp9".equals(this.f86b)) {
            for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : h()) {
                if (codecProfileLevel.profile == 16384) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean r(y1 y1Var) {
        if (this.f95k) {
            return this.f89e;
        }
        Pair<Integer, Integer> q6 = h0.q(y1Var);
        return q6 != null && ((Integer) q6.first).intValue() == 42;
    }

    public String toString() {
        return this.f85a;
    }

    public boolean w(int i6, int i7, double d6) {
        StringBuilder sb;
        String str;
        String sb2;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f88d;
        if (codecCapabilities == null) {
            sb2 = "sizeAndRate.caps";
        } else {
            MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
            if (videoCapabilities != null) {
                if (c1.f5548a >= 29) {
                    int a6 = a.a(videoCapabilities, i6, i7, d6);
                    if (a6 == 2) {
                        return true;
                    }
                    if (a6 == 1) {
                        sb = new StringBuilder();
                        str = "sizeAndRate.cover, ";
                        sb.append(str);
                        sb.append(i6);
                        sb.append("x");
                        sb.append(i7);
                        sb.append("@");
                        sb.append(d6);
                        sb2 = sb.toString();
                    }
                }
                if (!e(videoCapabilities, i6, i7, d6)) {
                    if (i6 < i7 && E(this.f85a) && e(videoCapabilities, i7, i6, d6)) {
                        x("sizeAndRate.rotated, " + i6 + "x" + i7 + "@" + d6);
                    } else {
                        sb = new StringBuilder();
                        str = "sizeAndRate.support, ";
                        sb.append(str);
                        sb.append(i6);
                        sb.append("x");
                        sb.append(i7);
                        sb.append("@");
                        sb.append(d6);
                        sb2 = sb.toString();
                    }
                }
                return true;
            }
            sb2 = "sizeAndRate.vCaps";
        }
        y(sb2);
        return false;
    }
}
