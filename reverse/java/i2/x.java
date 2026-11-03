package i2;

import android.text.TextUtils;
import com.tendcloud.tenddata.ab;
import com.tendcloud.tenddata.zz;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    private static final ArrayList<a> f5669a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f5670b = Pattern.compile("^mp4a\\.([a-zA-Z0-9]{2})(?:\\.([0-9]{1,2}))?$");

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f5671a;

        /* renamed from: b, reason: collision with root package name */
        public final String f5672b;

        /* renamed from: c, reason: collision with root package name */
        public final int f5673c;
    }

    static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f5674a;

        /* renamed from: b, reason: collision with root package name */
        public final int f5675b;

        public b(int i6, int i7) {
            this.f5674a = i6;
            this.f5675b = i7;
        }

        public int a() {
            int i6 = this.f5675b;
            if (i6 == 2) {
                return 10;
            }
            if (i6 == 5) {
                return 11;
            }
            if (i6 == 29) {
                return 12;
            }
            if (i6 == 42) {
                return 16;
            }
            if (i6 != 22) {
                return i6 != 23 ? 0 : 15;
            }
            return 1073741824;
        }
    }

    public static boolean a(String str, String str2) {
        b i6;
        int a6;
        if (str == null) {
            return false;
        }
        switch (str) {
            case "audio/mp4a-latm":
                if (str2 != null && (i6 = i(str2)) != null && (a6 = i6.a()) != 0 && a6 != 16) {
                }
                break;
        }
        return false;
    }

    public static boolean b(String str, String str2) {
        return d(str, str2) != null;
    }

    public static String c(String str) {
        if (str == null) {
            return null;
        }
        for (String str2 : c1.W0(str)) {
            String g6 = g(str2);
            if (g6 != null && o(g6)) {
                return g6;
            }
        }
        return null;
    }

    public static String d(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        String[] W0 = c1.W0(str);
        StringBuilder sb = new StringBuilder();
        for (String str3 : W0) {
            if (str2.equals(g(str3))) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(str3);
            }
        }
        if (sb.length() > 0) {
            return sb.toString();
        }
        return null;
    }

    private static String e(String str) {
        int size = f5669a.size();
        for (int i6 = 0; i6 < size; i6++) {
            a aVar = f5669a.get(i6);
            if (str.startsWith(aVar.f5672b)) {
                return aVar.f5671a;
            }
        }
        return null;
    }

    public static int f(String str, String str2) {
        b i6;
        str.hashCode();
        switch (str) {
            case "audio/eac3-joc":
                return 18;
            case "audio/vnd.dts":
                return 7;
            case "audio/mp4a-latm":
                if (str2 == null || (i6 = i(str2)) == null) {
                    return 0;
                }
                return i6.a();
            case "audio/ac3":
                return 5;
            case "audio/ac4":
                return 17;
            case "audio/eac3":
                return 6;
            case "audio/mpeg":
                return 9;
            case "audio/opus":
                return 20;
            case "audio/vnd.dts.hd":
                return 8;
            case "audio/true-hd":
                return 14;
            default:
                return 0;
        }
    }

    public static String g(String str) {
        b i6;
        String str2 = null;
        if (str == null) {
            return null;
        }
        String e6 = l2.b.e(str.trim());
        if (e6.startsWith("avc1") || e6.startsWith("avc3")) {
            return "video/avc";
        }
        if (e6.startsWith("hev1") || e6.startsWith("hvc1")) {
            return "video/hevc";
        }
        if (e6.startsWith("dvav") || e6.startsWith("dva1") || e6.startsWith("dvhe") || e6.startsWith("dvh1")) {
            return "video/dolby-vision";
        }
        if (e6.startsWith("av01")) {
            return "video/av01";
        }
        if (e6.startsWith("vp9") || e6.startsWith("vp09")) {
            return "video/x-vnd.on2.vp9";
        }
        if (e6.startsWith("vp8") || e6.startsWith("vp08")) {
            return "video/x-vnd.on2.vp8";
        }
        if (!e6.startsWith("mp4a")) {
            return e6.startsWith("mha1") ? "audio/mha1" : e6.startsWith("mhm1") ? "audio/mhm1" : (e6.startsWith("ac-3") || e6.startsWith("dac3")) ? "audio/ac3" : (e6.startsWith("ec-3") || e6.startsWith("dec3")) ? "audio/eac3" : e6.startsWith("ec+3") ? "audio/eac3-joc" : (e6.startsWith("ac-4") || e6.startsWith("dac4")) ? "audio/ac4" : e6.startsWith("dtsc") ? "audio/vnd.dts" : e6.startsWith("dtse") ? "audio/vnd.dts.hd;profile=lbr" : (e6.startsWith("dtsh") || e6.startsWith("dtsl")) ? "audio/vnd.dts.hd" : e6.startsWith("dtsx") ? "audio/vnd.dts.uhd;profile=p2" : e6.startsWith("opus") ? "audio/opus" : e6.startsWith("vorbis") ? "audio/vorbis" : e6.startsWith("flac") ? "audio/flac" : e6.startsWith("stpp") ? "application/ttml+xml" : e6.startsWith("wvtt") ? "text/vtt" : e6.contains("cea708") ? "application/cea-708" : (e6.contains("eia608") || e6.contains("cea608")) ? "application/cea-608" : e(e6);
        }
        if (e6.startsWith("mp4a.") && (i6 = i(e6)) != null) {
            str2 = h(i6.f5674a);
        }
        return str2 == null ? "audio/mp4a-latm" : str2;
    }

    public static String h(int i6) {
        if (i6 == 32) {
            return "video/mp4v-es";
        }
        if (i6 == 33) {
            return "video/avc";
        }
        if (i6 == 35) {
            return "video/hevc";
        }
        if (i6 == 64) {
            return "audio/mp4a-latm";
        }
        if (i6 == 163) {
            return "video/wvc1";
        }
        if (i6 == 177) {
            return "video/x-vnd.on2.vp9";
        }
        if (i6 == 165) {
            return "audio/ac3";
        }
        if (i6 == 166) {
            return "audio/eac3";
        }
        switch (i6) {
            case 96:
            case 97:
            case 98:
            case 99:
            case ab.ab /* 100 */:
            case 101:
                return "video/mpeg2";
            case zz.f2799f /* 102 */:
            case 103:
            case 104:
                return "audio/mp4a-latm";
            case 105:
            case 107:
                return "audio/mpeg";
            case 106:
                return "video/mpeg";
            default:
                switch (i6) {
                    case 169:
                    case 172:
                        return "audio/vnd.dts";
                    case 170:
                    case 171:
                        return "audio/vnd.dts.hd";
                    case 173:
                        return "audio/opus";
                    case 174:
                        return "audio/ac4";
                    default:
                        return null;
                }
        }
    }

    static b i(String str) {
        Matcher matcher = f5670b.matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        String str2 = (String) i2.a.e(matcher.group(1));
        String group = matcher.group(2);
        try {
            return new b(Integer.parseInt(str2, 16), group != null ? Integer.parseInt(group) : 0);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private static String j(String str) {
        int indexOf;
        if (str == null || (indexOf = str.indexOf(47)) == -1) {
            return null;
        }
        return str.substring(0, indexOf);
    }

    public static int k(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (o(str)) {
            return 1;
        }
        if (s(str)) {
            return 2;
        }
        if (r(str)) {
            return 3;
        }
        if (p(str)) {
            return 4;
        }
        if ("application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str)) {
            return 5;
        }
        if ("application/x-camera-motion".equals(str)) {
            return 6;
        }
        return l(str);
    }

    private static int l(String str) {
        int size = f5669a.size();
        for (int i6 = 0; i6 < size; i6++) {
            a aVar = f5669a.get(i6);
            if (str.equals(aVar.f5671a)) {
                return aVar.f5673c;
            }
        }
        return -1;
    }

    public static int m(String str) {
        return k(g(str));
    }

    public static String n(String str) {
        if (str == null) {
            return null;
        }
        for (String str2 : c1.W0(str)) {
            String g6 = g(str2);
            if (g6 != null && s(g6)) {
                return g6;
            }
        }
        return null;
    }

    public static boolean o(String str) {
        return "audio".equals(j(str));
    }

    public static boolean p(String str) {
        return "image".equals(j(str));
    }

    public static boolean q(String str) {
        if (str == null) {
            return false;
        }
        return str.startsWith("video/webm") || str.startsWith("audio/webm") || str.startsWith("application/webm") || str.startsWith("video/x-matroska") || str.startsWith("audio/x-matroska") || str.startsWith("application/x-matroska");
    }

    public static boolean r(String str) {
        return "text".equals(j(str)) || "application/cea-608".equals(str) || "application/cea-708".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/x-subrip".equals(str) || "application/ttml+xml".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-rawcc".equals(str) || "application/vobsub".equals(str) || "application/pgs".equals(str) || "application/dvbsubs".equals(str);
    }

    public static boolean s(String str) {
        return "video".equals(j(str));
    }

    public static String t(String str) {
        str.hashCode();
        switch (str) {
            case "audio/x-flac":
                return "audio/flac";
            case "audio/x-wav":
                return "audio/wav";
            case "audio/mp3":
                return "audio/mpeg";
            default:
                return str;
        }
    }
}
