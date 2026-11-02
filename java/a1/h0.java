package a1;

import a1.h0;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.text.TextUtils;
import android.util.Pair;
import com.tendcloud.tenddata.ab;
import com.tendcloud.tenddata.ay;
import h0.y1;
import i2.c1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* loaded from: classes.dex */
public final class h0 {

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f37a = Pattern.compile("^\\D?(\\d+)$");

    /* renamed from: b, reason: collision with root package name */
    private static final HashMap<b, List<t>> f38b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private static int f39c = -1;

    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f40a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f41b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f42c;

        public b(String str, boolean z5, boolean z6) {
            this.f40a = str;
            this.f41b = z5;
            this.f42c = z6;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != b.class) {
                return false;
            }
            b bVar = (b) obj;
            return TextUtils.equals(this.f40a, bVar.f40a) && this.f41b == bVar.f41b && this.f42c == bVar.f42c;
        }

        public int hashCode() {
            return ((((this.f40a.hashCode() + 31) * 31) + (this.f41b ? 1231 : 1237)) * 31) + (this.f42c ? 1231 : 1237);
        }
    }

    public static class c extends Exception {
        private c(Throwable th) {
            super("Failed to query underlying media codecs", th);
        }
    }

    private interface d {
        MediaCodecInfo a(int i6);

        boolean b(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities);

        int c();

        boolean d(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities);

        boolean e();
    }

    private static final class e implements d {
        private e() {
        }

        @Override // a1.h0.d
        public MediaCodecInfo a(int i6) {
            return MediaCodecList.getCodecInfoAt(i6);
        }

        @Override // a1.h0.d
        public boolean b(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return false;
        }

        @Override // a1.h0.d
        public int c() {
            return MediaCodecList.getCodecCount();
        }

        @Override // a1.h0.d
        public boolean d(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return "secure-playback".equals(str) && "video/avc".equals(str2);
        }

        @Override // a1.h0.d
        public boolean e() {
            return false;
        }
    }

    private static final class f implements d {

        /* renamed from: a, reason: collision with root package name */
        private final int f43a;

        /* renamed from: b, reason: collision with root package name */
        private MediaCodecInfo[] f44b;

        public f(boolean z5, boolean z6) {
            this.f43a = (z5 || z6) ? 1 : 0;
        }

        @EnsuresNonNull({"mediaCodecInfos"})
        private void f() {
            if (this.f44b == null) {
                this.f44b = new MediaCodecList(this.f43a).getCodecInfos();
            }
        }

        @Override // a1.h0.d
        public MediaCodecInfo a(int i6) {
            f();
            return this.f44b[i6];
        }

        @Override // a1.h0.d
        public boolean b(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureRequired(str);
        }

        @Override // a1.h0.d
        public int c() {
            f();
            return this.f44b.length;
        }

        @Override // a1.h0.d
        public boolean d(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureSupported(str);
        }

        @Override // a1.h0.d
        public boolean e() {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    interface g<T> {
        int a(T t5);
    }

    private static boolean A(MediaCodecInfo mediaCodecInfo) {
        return c1.f5548a >= 29 && B(mediaCodecInfo);
    }

    private static boolean B(MediaCodecInfo mediaCodecInfo) {
        boolean isAlias;
        isAlias = mediaCodecInfo.isAlias();
        return isAlias;
    }

    private static boolean C(MediaCodecInfo mediaCodecInfo, String str, boolean z5, String str2) {
        if (mediaCodecInfo.isEncoder() || (!z5 && str.endsWith(".secure"))) {
            return false;
        }
        int i6 = c1.f5548a;
        if (i6 < 21 && ("CIPAACDecoder".equals(str) || "CIPMP3Decoder".equals(str) || "CIPVorbisDecoder".equals(str) || "CIPAMRNBDecoder".equals(str) || "AACDecoder".equals(str) || "MP3Decoder".equals(str))) {
            return false;
        }
        if (i6 < 18 && "OMX.MTK.AUDIO.DECODER.AAC".equals(str)) {
            String str3 = c1.f5549b;
            if ("a70".equals(str3) || ("Xiaomi".equals(c1.f5550c) && str3.startsWith("HM"))) {
                return false;
            }
        }
        if (i6 == 16 && "OMX.qcom.audio.decoder.mp3".equals(str)) {
            String str4 = c1.f5549b;
            if ("dlxu".equals(str4) || "protou".equals(str4) || "ville".equals(str4) || "villeplus".equals(str4) || "villec2".equals(str4) || str4.startsWith("gee") || "C6602".equals(str4) || "C6603".equals(str4) || "C6606".equals(str4) || "C6616".equals(str4) || "L36h".equals(str4) || "SO-02E".equals(str4)) {
                return false;
            }
        }
        if (i6 == 16 && "OMX.qcom.audio.decoder.aac".equals(str)) {
            String str5 = c1.f5549b;
            if ("C1504".equals(str5) || "C1505".equals(str5) || "C1604".equals(str5) || "C1605".equals(str5)) {
                return false;
            }
        }
        if (i6 < 24 && (("OMX.SEC.aac.dec".equals(str) || "OMX.Exynos.AAC.Decoder".equals(str)) && "samsung".equals(c1.f5550c))) {
            String str6 = c1.f5549b;
            if (str6.startsWith("zeroflte") || str6.startsWith("zerolte") || str6.startsWith("zenlte") || "SC-05G".equals(str6) || "marinelteatt".equals(str6) || "404SC".equals(str6) || "SC-04G".equals(str6) || "SCV31".equals(str6)) {
                return false;
            }
        }
        if (i6 <= 19 && "OMX.SEC.vp8.dec".equals(str) && "samsung".equals(c1.f5550c)) {
            String str7 = c1.f5549b;
            if (str7.startsWith("d2") || str7.startsWith("serrano") || str7.startsWith("jflte") || str7.startsWith("santos") || str7.startsWith("t0")) {
                return false;
            }
        }
        if (i6 <= 19 && c1.f5549b.startsWith("jflte") && "OMX.qcom.video.decoder.vp8".equals(str)) {
            return false;
        }
        return (i6 <= 23 && "audio/eac3-joc".equals(str2) && "OMX.MTK.AUDIO.DECODER.DSPAC3".equals(str)) ? false : true;
    }

    private static boolean D(MediaCodecInfo mediaCodecInfo, String str) {
        return c1.f5548a >= 29 ? E(mediaCodecInfo) : !F(mediaCodecInfo, str);
    }

    private static boolean E(MediaCodecInfo mediaCodecInfo) {
        boolean isHardwareAccelerated;
        isHardwareAccelerated = mediaCodecInfo.isHardwareAccelerated();
        return isHardwareAccelerated;
    }

    private static boolean F(MediaCodecInfo mediaCodecInfo, String str) {
        if (c1.f5548a >= 29) {
            return G(mediaCodecInfo);
        }
        if (i2.x.o(str)) {
            return true;
        }
        String e6 = l2.b.e(mediaCodecInfo.getName());
        if (e6.startsWith("arc.")) {
            return false;
        }
        if (e6.startsWith("omx.google.") || e6.startsWith("omx.ffmpeg.")) {
            return true;
        }
        if ((e6.startsWith("omx.sec.") && e6.contains(".sw.")) || e6.equals("omx.qcom.video.decoder.hevcswvdec") || e6.startsWith("c2.android.") || e6.startsWith("c2.google.")) {
            return true;
        }
        return (e6.startsWith("omx.") || e6.startsWith("c2.")) ? false : true;
    }

    private static boolean G(MediaCodecInfo mediaCodecInfo) {
        boolean isSoftwareOnly;
        isSoftwareOnly = mediaCodecInfo.isSoftwareOnly();
        return isSoftwareOnly;
    }

    private static boolean H(MediaCodecInfo mediaCodecInfo) {
        if (c1.f5548a >= 29) {
            return I(mediaCodecInfo);
        }
        String e6 = l2.b.e(mediaCodecInfo.getName());
        return (e6.startsWith("omx.google.") || e6.startsWith("c2.android.") || e6.startsWith("c2.google.")) ? false : true;
    }

    private static boolean I(MediaCodecInfo mediaCodecInfo) {
        boolean isVendor;
        isVendor = mediaCodecInfo.isVendor();
        return isVendor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int J(t tVar) {
        String str = tVar.f85a;
        if (str.startsWith("OMX.google") || str.startsWith("c2.android")) {
            return 1;
        }
        return (c1.f5548a >= 26 || !str.equals("OMX.MTK.AUDIO.DECODER.RAW")) ? 0 : -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int K(t tVar) {
        return tVar.f85a.startsWith("OMX.google") ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int L(y1 y1Var, t tVar) {
        return tVar.n(y1Var) ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int M(g gVar, Object obj, Object obj2) {
        return gVar.a(obj2) - gVar.a(obj);
    }

    public static int N() {
        if (f39c == -1) {
            int i6 = 0;
            t r6 = r("video/avc", false, false);
            if (r6 != null) {
                MediaCodecInfo.CodecProfileLevel[] h6 = r6.h();
                int length = h6.length;
                int i7 = 0;
                while (i6 < length) {
                    i7 = Math.max(h(h6[i6].level), i7);
                    i6++;
                }
                i6 = Math.max(i7, c1.f5548a >= 21 ? 345600 : 172800);
            }
            f39c = i6;
        }
        return f39c;
    }

    private static int O(int i6) {
        int i7 = 17;
        if (i6 != 17) {
            i7 = 20;
            if (i6 != 20) {
                i7 = 23;
                if (i6 != 23) {
                    i7 = 29;
                    if (i6 != 29) {
                        i7 = 39;
                        if (i6 != 39) {
                            i7 = 42;
                            if (i6 != 42) {
                                switch (i6) {
                                    case 1:
                                        return 1;
                                    case 2:
                                        return 2;
                                    case 3:
                                        return 3;
                                    case 4:
                                        return 4;
                                    case 5:
                                        return 5;
                                    case 6:
                                        return 6;
                                    default:
                                        return -1;
                                }
                            }
                        }
                    }
                }
            }
        }
        return i7;
    }

    private static <T> void P(List<T> list, final g<T> gVar) {
        Collections.sort(list, new Comparator() { // from class: a1.g0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int M;
                M = h0.M(h0.g.this, obj, obj2);
                return M;
            }
        });
    }

    private static int Q(int i6) {
        if (i6 == 10) {
            return 1;
        }
        if (i6 == 11) {
            return 2;
        }
        if (i6 == 20) {
            return 4;
        }
        if (i6 == 21) {
            return 8;
        }
        if (i6 == 30) {
            return 16;
        }
        if (i6 == 31) {
            return 32;
        }
        if (i6 == 40) {
            return 64;
        }
        if (i6 == 41) {
            return 128;
        }
        if (i6 == 50) {
            return 256;
        }
        if (i6 == 51) {
            return 512;
        }
        switch (i6) {
            case 60:
                return 2048;
            case 61:
                return 4096;
            case 62:
                return 8192;
            default:
                return -1;
        }
    }

    private static int R(int i6) {
        if (i6 == 0) {
            return 1;
        }
        if (i6 == 1) {
            return 2;
        }
        if (i6 != 2) {
            return i6 != 3 ? -1 : 8;
        }
        return 4;
    }

    private static void e(String str, List<t> list) {
        if ("audio/raw".equals(str)) {
            if (c1.f5548a < 26 && c1.f5549b.equals("R9") && list.size() == 1 && list.get(0).f85a.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                list.add(t.F("OMX.google.raw.decoder", "audio/raw", "audio/raw", null, false, true, false, false, false));
            }
            P(list, new g() { // from class: a1.d0
                @Override // a1.h0.g
                public final int a(Object obj) {
                    int J;
                    J = h0.J((t) obj);
                    return J;
                }
            });
        }
        int i6 = c1.f5548a;
        if (i6 < 21 && list.size() > 1) {
            String str2 = list.get(0).f85a;
            if ("OMX.SEC.mp3.dec".equals(str2) || "OMX.SEC.MP3.Decoder".equals(str2) || "OMX.brcm.audio.mp3.decoder".equals(str2)) {
                P(list, new g() { // from class: a1.e0
                    @Override // a1.h0.g
                    public final int a(Object obj) {
                        int K;
                        K = h0.K((t) obj);
                        return K;
                    }
                });
            }
        }
        if (i6 >= 32 || list.size() <= 1 || !"OMX.qti.audio.decoder.flac".equals(list.get(0).f85a)) {
            return;
        }
        list.add(list.remove(0));
    }

    private static int f(int i6) {
        switch (i6) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                return 16;
            case 5:
                return 32;
            case 6:
                return 64;
            case 7:
                return 128;
            case 8:
                return 256;
            case 9:
                return 512;
            case 10:
                return 1024;
            case 11:
                return 2048;
            case 12:
                return 4096;
            case 13:
                return 8192;
            case 14:
                return 16384;
            case 15:
                return 32768;
            case 16:
                return 65536;
            case ab.b.API_TYPE_INDUSTRY /* 17 */:
                return 131072;
            case 18:
                return 262144;
            case 19:
                return 524288;
            case 20:
                return 1048576;
            case 21:
                return 2097152;
            case 22:
                return 4194304;
            case 23:
                return 8388608;
            default:
                return -1;
        }
    }

    private static int g(int i6) {
        switch (i6) {
            case 10:
                return 1;
            case 11:
                return 4;
            case 12:
                return 8;
            case 13:
                return 16;
            default:
                switch (i6) {
                    case 20:
                        return 32;
                    case 21:
                        return 64;
                    case 22:
                        return 128;
                    default:
                        switch (i6) {
                            case 30:
                                return 256;
                            case 31:
                                return 512;
                            case 32:
                                return 1024;
                            default:
                                switch (i6) {
                                    case 40:
                                        return 2048;
                                    case 41:
                                        return 4096;
                                    case 42:
                                        return 8192;
                                    default:
                                        switch (i6) {
                                            case ay.f2330c /* 50 */:
                                                return 16384;
                                            case 51:
                                                return 32768;
                                            case 52:
                                                return 65536;
                                            default:
                                                return -1;
                                        }
                                }
                        }
                }
        }
    }

    private static int h(int i6) {
        if (i6 == 1 || i6 == 2) {
            return 25344;
        }
        switch (i6) {
            case 8:
            case 16:
            case 32:
                return 101376;
            case 64:
                return 202752;
            case 128:
            case 256:
                return 414720;
            case 512:
                return 921600;
            case 1024:
                return 1310720;
            case 2048:
            case 4096:
                return 2097152;
            case 8192:
                return 2228224;
            case 16384:
                return 5652480;
            case 32768:
            case 65536:
                return 9437184;
            case 131072:
            case 262144:
            case 524288:
                return 35651584;
            default:
                return -1;
        }
    }

    private static int i(int i6) {
        if (i6 == 66) {
            return 1;
        }
        if (i6 == 77) {
            return 2;
        }
        if (i6 == 88) {
            return 4;
        }
        if (i6 == 100) {
            return 8;
        }
        if (i6 == 110) {
            return 16;
        }
        if (i6 != 122) {
            return i6 != 244 ? -1 : 64;
        }
        return 32;
    }

    private static Integer j(String str) {
        int i6;
        if (str == null) {
            return null;
        }
        switch (str) {
            case "01":
                return 1;
            case "02":
                return 2;
            case "03":
                return 4;
            case "04":
                return 8;
            case "05":
                i6 = 16;
                break;
            case "06":
                i6 = 32;
                break;
            case "07":
                i6 = 64;
                break;
            case "08":
                i6 = 128;
                break;
            case "09":
                i6 = 256;
                break;
            case "10":
                i6 = 512;
                break;
            case "11":
                i6 = 1024;
                break;
            case "12":
                i6 = 2048;
                break;
            case "13":
                i6 = 4096;
                break;
            default:
                return null;
        }
        return Integer.valueOf(i6);
    }

    private static Integer k(String str) {
        int i6;
        if (str == null) {
            return null;
        }
        switch (str) {
            case "00":
                return 1;
            case "01":
                return 2;
            case "02":
                return 4;
            case "03":
                return 8;
            case "04":
                i6 = 16;
                break;
            case "05":
                i6 = 32;
                break;
            case "06":
                i6 = 64;
                break;
            case "07":
                i6 = 128;
                break;
            case "08":
                i6 = 256;
                break;
            case "09":
                i6 = 512;
                break;
            default:
                return null;
        }
        return Integer.valueOf(i6);
    }

    private static Pair<Integer, Integer> l(String str, String[] strArr) {
        int O;
        if (strArr.length != 3) {
            i2.t.i("MediaCodecUtil", "Ignoring malformed MP4A codec string: " + str);
            return null;
        }
        try {
            if ("audio/mp4a-latm".equals(i2.x.h(Integer.parseInt(strArr[1], 16))) && (O = O(Integer.parseInt(strArr[2]))) != -1) {
                return new Pair<>(Integer.valueOf(O), 0);
            }
        } catch (NumberFormatException unused) {
            i2.t.i("MediaCodecUtil", "Ignoring malformed MP4A codec string: " + str);
        }
        return null;
    }

    public static String m(y1 y1Var) {
        Pair<Integer, Integer> q6;
        if ("audio/eac3-joc".equals(y1Var.f5066p)) {
            return "audio/eac3";
        }
        if (!"video/dolby-vision".equals(y1Var.f5066p) || (q6 = q(y1Var)) == null) {
            return null;
        }
        int intValue = ((Integer) q6.first).intValue();
        if (intValue == 16 || intValue == 256) {
            return "video/hevc";
        }
        if (intValue == 512) {
            return "video/avc";
        }
        return null;
    }

    private static Pair<Integer, Integer> n(String str, String[] strArr, j2.c cVar) {
        StringBuilder sb;
        int parseInt;
        int parseInt2;
        int parseInt3;
        StringBuilder sb2;
        int i6;
        String sb3;
        if (strArr.length >= 4) {
            try {
                parseInt = Integer.parseInt(strArr[1]);
                parseInt2 = Integer.parseInt(strArr[2].substring(0, 2));
                parseInt3 = Integer.parseInt(strArr[3]);
            } catch (NumberFormatException unused) {
                sb = new StringBuilder();
            }
            if (parseInt != 0) {
                sb2 = new StringBuilder();
                sb2.append("Unknown AV1 profile: ");
                sb2.append(parseInt);
            } else {
                if (parseInt3 != 8 && parseInt3 != 10) {
                    sb = new StringBuilder();
                    sb.append("Unknown AV1 bit depth: ");
                    sb.append(parseInt3);
                    sb3 = sb.toString();
                    i2.t.i("MediaCodecUtil", sb3);
                    return null;
                }
                int i7 = parseInt3 != 8 ? (cVar == null || !(cVar.f6684d != null || (i6 = cVar.f6683c) == 7 || i6 == 6)) ? 2 : 4096 : 1;
                int f6 = f(parseInt2);
                if (f6 != -1) {
                    return new Pair<>(Integer.valueOf(i7), Integer.valueOf(f6));
                }
                sb2 = new StringBuilder();
                sb2.append("Unknown AV1 level: ");
                sb2.append(parseInt2);
            }
            sb3 = sb2.toString();
            i2.t.i("MediaCodecUtil", sb3);
            return null;
        }
        sb = new StringBuilder();
        sb.append("Ignoring malformed AV1 codec string: ");
        sb.append(str);
        sb3 = sb.toString();
        i2.t.i("MediaCodecUtil", sb3);
        return null;
    }

    private static Pair<Integer, Integer> o(String str, String[] strArr) {
        StringBuilder sb;
        int parseInt;
        int i6;
        int i7;
        String str2;
        if (strArr.length >= 2) {
            try {
                if (strArr[1].length() == 6) {
                    i6 = Integer.parseInt(strArr[1].substring(0, 2), 16);
                    parseInt = Integer.parseInt(strArr[1].substring(4), 16);
                } else {
                    if (strArr.length < 3) {
                        i2.t.i("MediaCodecUtil", "Ignoring malformed AVC codec string: " + str);
                        return null;
                    }
                    int parseInt2 = Integer.parseInt(strArr[1]);
                    parseInt = Integer.parseInt(strArr[2]);
                    i6 = parseInt2;
                }
                i7 = i(i6);
            } catch (NumberFormatException unused) {
                sb = new StringBuilder();
            }
            if (i7 == -1) {
                str2 = "Unknown AVC profile: " + i6;
                i2.t.i("MediaCodecUtil", str2);
                return null;
            }
            int g6 = g(parseInt);
            if (g6 != -1) {
                return new Pair<>(Integer.valueOf(i7), Integer.valueOf(g6));
            }
            sb = new StringBuilder();
            sb.append("Unknown AVC level: ");
            sb.append(parseInt);
            str2 = sb.toString();
            i2.t.i("MediaCodecUtil", str2);
            return null;
        }
        sb = new StringBuilder();
        sb.append("Ignoring malformed AVC codec string: ");
        sb.append(str);
        str2 = sb.toString();
        i2.t.i("MediaCodecUtil", str2);
        return null;
    }

    private static String p(MediaCodecInfo mediaCodecInfo, String str, String str2) {
        for (String str3 : mediaCodecInfo.getSupportedTypes()) {
            if (str3.equalsIgnoreCase(str2)) {
                return str3;
            }
        }
        if (str2.equals("video/dolby-vision")) {
            if ("OMX.MS.HEVCDV.Decoder".equals(str)) {
                return "video/hevcdv";
            }
            if ("OMX.RTK.video.decoder".equals(str) || "OMX.realtek.video.decoder.tunneled".equals(str)) {
                return "video/dv_hevc";
            }
            return null;
        }
        if (str2.equals("audio/alac") && "OMX.lge.alac.decoder".equals(str)) {
            return "audio/x-lg-alac";
        }
        if (str2.equals("audio/flac") && "OMX.lge.flac.decoder".equals(str)) {
            return "audio/x-lg-flac";
        }
        if (str2.equals("audio/ac3") && "OMX.lge.ac3.decoder".equals(str)) {
            return "audio/lg-ac3";
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0075, code lost:
    
        if (r3.equals("av01") == false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.util.Pair<java.lang.Integer, java.lang.Integer> q(h0.y1 r6) {
        /*
            java.lang.String r0 = r6.f5063m
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            java.lang.String r2 = "\\."
            java.lang.String[] r0 = r0.split(r2)
            java.lang.String r2 = "video/dolby-vision"
            java.lang.String r3 = r6.f5066p
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L1d
            java.lang.String r6 = r6.f5063m
            android.util.Pair r6 = w(r6, r0)
            return r6
        L1d:
            r2 = 0
            r3 = r0[r2]
            r3.hashCode()
            int r4 = r3.hashCode()
            r5 = -1
            switch(r4) {
                case 3004662: goto L6f;
                case 3006243: goto L64;
                case 3006244: goto L59;
                case 3199032: goto L4e;
                case 3214780: goto L43;
                case 3356560: goto L38;
                case 3624515: goto L2d;
                default: goto L2b;
            }
        L2b:
            r2 = -1
            goto L78
        L2d:
            java.lang.String r2 = "vp09"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L36
            goto L2b
        L36:
            r2 = 6
            goto L78
        L38:
            java.lang.String r2 = "mp4a"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L41
            goto L2b
        L41:
            r2 = 5
            goto L78
        L43:
            java.lang.String r2 = "hvc1"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L4c
            goto L2b
        L4c:
            r2 = 4
            goto L78
        L4e:
            java.lang.String r2 = "hev1"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L57
            goto L2b
        L57:
            r2 = 3
            goto L78
        L59:
            java.lang.String r2 = "avc2"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L62
            goto L2b
        L62:
            r2 = 2
            goto L78
        L64:
            java.lang.String r2 = "avc1"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L6d
            goto L2b
        L6d:
            r2 = 1
            goto L78
        L6f:
            java.lang.String r4 = "av01"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L78
            goto L2b
        L78:
            switch(r2) {
                case 0: goto L9a;
                case 1: goto L93;
                case 2: goto L93;
                case 3: goto L8a;
                case 4: goto L8a;
                case 5: goto L83;
                case 6: goto L7c;
                default: goto L7b;
            }
        L7b:
            return r1
        L7c:
            java.lang.String r6 = r6.f5063m
            android.util.Pair r6 = y(r6, r0)
            return r6
        L83:
            java.lang.String r6 = r6.f5063m
            android.util.Pair r6 = l(r6, r0)
            return r6
        L8a:
            java.lang.String r1 = r6.f5063m
            j2.c r6 = r6.B
            android.util.Pair r6 = x(r1, r0, r6)
            return r6
        L93:
            java.lang.String r6 = r6.f5063m
            android.util.Pair r6 = o(r6, r0)
            return r6
        L9a:
            java.lang.String r1 = r6.f5063m
            j2.c r6 = r6.B
            android.util.Pair r6 = n(r1, r0, r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: a1.h0.q(h0.y1):android.util.Pair");
    }

    public static t r(String str, boolean z5, boolean z6) {
        List<t> s5 = s(str, z5, z6);
        if (s5.isEmpty()) {
            return null;
        }
        return s5.get(0);
    }

    public static synchronized List<t> s(String str, boolean z5, boolean z6) {
        synchronized (h0.class) {
            b bVar = new b(str, z5, z6);
            HashMap<b, List<t>> hashMap = f38b;
            List<t> list = hashMap.get(bVar);
            if (list != null) {
                return list;
            }
            int i6 = c1.f5548a;
            ArrayList<t> t5 = t(bVar, i6 >= 21 ? new f(z5, z6) : new e());
            if (z5 && t5.isEmpty() && 21 <= i6 && i6 <= 23) {
                t5 = t(bVar, new e());
                if (!t5.isEmpty()) {
                    i2.t.i("MediaCodecUtil", "MediaCodecList API didn't list secure decoder for: " + str + ". Assuming: " + t5.get(0).f85a);
                }
            }
            e(str, t5);
            m2.q m6 = m2.q.m(t5);
            hashMap.put(bVar, m6);
            return m6;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:28|(4:(2:72|73)|53|(9:56|57|58|59|60|61|62|64|65)|9)|32|33|34|36|9) */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00a4, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00a5, code lost:
    
        r1 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x007f, code lost:
    
        if (r1.f41b == false) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0101 A[Catch: Exception -> 0x014f, TRY_ENTER, TryCatch #1 {Exception -> 0x014f, blocks: (B:3:0x0008, B:5:0x001b, B:9:0x0120, B:10:0x002d, B:13:0x0038, B:39:0x00f9, B:42:0x0101, B:44:0x0107, B:47:0x012a, B:48:0x014d), top: B:2:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x012a A[ADDED_TO_REGION, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.util.ArrayList<a1.t> t(a1.h0.b r24, a1.h0.d r25) {
        /*
            Method dump skipped, instructions count: 343
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a1.h0.t(a1.h0$b, a1.h0$d):java.util.ArrayList");
    }

    public static List<t> u(List<t> list, final y1 y1Var) {
        ArrayList arrayList = new ArrayList(list);
        P(arrayList, new g() { // from class: a1.f0
            @Override // a1.h0.g
            public final int a(Object obj) {
                int L;
                L = h0.L(y1.this, (t) obj);
                return L;
            }
        });
        return arrayList;
    }

    public static t v() {
        return r("audio/raw", false, false);
    }

    private static Pair<Integer, Integer> w(String str, String[] strArr) {
        StringBuilder sb;
        String str2;
        if (strArr.length < 3) {
            sb = new StringBuilder();
        } else {
            Matcher matcher = f37a.matcher(strArr[1]);
            if (matcher.matches()) {
                str = matcher.group(1);
                Integer k6 = k(str);
                if (k6 == null) {
                    sb = new StringBuilder();
                    str2 = "Unknown Dolby Vision profile string: ";
                } else {
                    str = strArr[2];
                    Integer j6 = j(str);
                    if (j6 != null) {
                        return new Pair<>(k6, j6);
                    }
                    sb = new StringBuilder();
                    str2 = "Unknown Dolby Vision level string: ";
                }
                sb.append(str2);
                sb.append(str);
                i2.t.i("MediaCodecUtil", sb.toString());
                return null;
            }
            sb = new StringBuilder();
        }
        sb.append("Ignoring malformed Dolby Vision codec string: ");
        sb.append(str);
        i2.t.i("MediaCodecUtil", sb.toString());
        return null;
    }

    private static Pair<Integer, Integer> x(String str, String[] strArr, j2.c cVar) {
        StringBuilder sb;
        String str2;
        if (strArr.length < 4) {
            sb = new StringBuilder();
        } else {
            int i6 = 1;
            Matcher matcher = f37a.matcher(strArr[1]);
            if (matcher.matches()) {
                str = matcher.group(1);
                if (!"1".equals(str)) {
                    if (!"2".equals(str)) {
                        sb = new StringBuilder();
                        str2 = "Unknown HEVC profile string: ";
                        sb.append(str2);
                        sb.append(str);
                        i2.t.i("MediaCodecUtil", sb.toString());
                        return null;
                    }
                    i6 = (cVar == null || cVar.f6683c != 6) ? 2 : 4096;
                }
                str = strArr[3];
                Integer z5 = z(str);
                if (z5 != null) {
                    return new Pair<>(Integer.valueOf(i6), z5);
                }
                sb = new StringBuilder();
                str2 = "Unknown HEVC level string: ";
                sb.append(str2);
                sb.append(str);
                i2.t.i("MediaCodecUtil", sb.toString());
                return null;
            }
            sb = new StringBuilder();
        }
        sb.append("Ignoring malformed HEVC codec string: ");
        sb.append(str);
        i2.t.i("MediaCodecUtil", sb.toString());
        return null;
    }

    private static Pair<Integer, Integer> y(String str, String[] strArr) {
        StringBuilder sb;
        int parseInt;
        int parseInt2;
        int R;
        String str2;
        if (strArr.length >= 3) {
            try {
                parseInt = Integer.parseInt(strArr[1]);
                parseInt2 = Integer.parseInt(strArr[2]);
                R = R(parseInt);
            } catch (NumberFormatException unused) {
                sb = new StringBuilder();
            }
            if (R == -1) {
                str2 = "Unknown VP9 profile: " + parseInt;
                i2.t.i("MediaCodecUtil", str2);
                return null;
            }
            int Q = Q(parseInt2);
            if (Q != -1) {
                return new Pair<>(Integer.valueOf(R), Integer.valueOf(Q));
            }
            sb = new StringBuilder();
            sb.append("Unknown VP9 level: ");
            sb.append(parseInt2);
            str2 = sb.toString();
            i2.t.i("MediaCodecUtil", str2);
            return null;
        }
        sb = new StringBuilder();
        sb.append("Ignoring malformed VP9 codec string: ");
        sb.append(str);
        str2 = sb.toString();
        i2.t.i("MediaCodecUtil", str2);
        return null;
    }

    private static Integer z(String str) {
        int i6;
        if (str == null) {
            return null;
        }
        switch (str) {
            case "H30":
                return 2;
            case "H60":
                return 8;
            case "H63":
                i6 = 32;
                break;
            case "H90":
                i6 = 128;
                break;
            case "H93":
                i6 = 512;
                break;
            case "L30":
                return 1;
            case "L60":
                return 4;
            case "L63":
                return 16;
            case "L90":
                i6 = 64;
                break;
            case "L93":
                i6 = 256;
                break;
            case "H120":
                i6 = 2048;
                break;
            case "H123":
                i6 = 8192;
                break;
            case "H150":
                i6 = 32768;
                break;
            case "H153":
                i6 = 131072;
                break;
            case "H156":
                i6 = 524288;
                break;
            case "H180":
                i6 = 2097152;
                break;
            case "H183":
                i6 = 8388608;
                break;
            case "H186":
                i6 = 33554432;
                break;
            case "L120":
                i6 = 1024;
                break;
            case "L123":
                i6 = 4096;
                break;
            case "L150":
                i6 = 16384;
                break;
            case "L153":
                i6 = 65536;
                break;
            case "L156":
                i6 = 262144;
                break;
            case "L180":
                i6 = 1048576;
                break;
            case "L183":
                i6 = 4194304;
                break;
            case "L186":
                i6 = 16777216;
                break;
            default:
                return null;
        }
        return Integer.valueOf(i6);
    }
}
