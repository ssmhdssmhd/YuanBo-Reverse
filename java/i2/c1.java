package i2;

import android.app.UiModeManager;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.LocaleList;
import android.os.Looper;
import android.os.Parcel;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.tendcloud.tenddata.ab;
import com.tendcloud.tenddata.zz;
import h0.g3;
import h0.o3;
import h0.y1;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* loaded from: classes.dex */
public final class c1 {

    /* renamed from: a, reason: collision with root package name */
    public static final int f5548a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f5549b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f5550c;

    /* renamed from: d, reason: collision with root package name */
    public static final String f5551d;

    /* renamed from: e, reason: collision with root package name */
    public static final String f5552e;

    /* renamed from: f, reason: collision with root package name */
    public static final byte[] f5553f;

    /* renamed from: g, reason: collision with root package name */
    private static final Pattern f5554g;

    /* renamed from: h, reason: collision with root package name */
    private static final Pattern f5555h;

    /* renamed from: i, reason: collision with root package name */
    private static final Pattern f5556i;

    /* renamed from: j, reason: collision with root package name */
    private static final Pattern f5557j;

    /* renamed from: k, reason: collision with root package name */
    private static HashMap<String, String> f5558k;

    /* renamed from: l, reason: collision with root package name */
    private static final String[] f5559l;

    /* renamed from: m, reason: collision with root package name */
    private static final String[] f5560m;

    /* renamed from: n, reason: collision with root package name */
    private static final int[] f5561n;

    /* renamed from: o, reason: collision with root package name */
    private static final int[] f5562o;

    static {
        int i6 = Build.VERSION.SDK_INT;
        f5548a = i6;
        String str = Build.DEVICE;
        f5549b = str;
        String str2 = Build.MANUFACTURER;
        f5550c = str2;
        String str3 = Build.MODEL;
        f5551d = str3;
        f5552e = str + ", " + str3 + ", " + str2 + ", " + i6;
        f5553f = new byte[0];
        f5554g = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)))?");
        f5555h = Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
        f5556i = Pattern.compile("%([A-Fa-f0-9]{2})");
        f5557j = Pattern.compile("(?:.*\\.)?isml?(?:/(manifest(.*))?)?", 2);
        f5559l = new String[]{"alb", "sq", "arm", "hy", "baq", "eu", "bur", "my", "tib", "bo", "chi", "zh", "cze", "cs", "dut", "nl", "ger", "de", "gre", "el", "fre", "fr", "geo", "ka", "ice", "is", "mac", "mk", "mao", "mi", "may", "ms", "per", "fa", "rum", "ro", "scc", "hbs-srp", "slo", "sk", "wel", "cy", "id", "ms-ind", "iw", "he", "heb", "he", "ji", "yi", "arb", "ar-arb", "in", "ms-ind", "ind", "ms-ind", "nb", "no-nob", "nob", "no-nob", "nn", "no-nno", "nno", "no-nno", "tw", "ak-twi", "twi", "ak-twi", "bs", "hbs-bos", "bos", "hbs-bos", "hr", "hbs-hrv", "hrv", "hbs-hrv", "sr", "hbs-srp", "srp", "hbs-srp", "cmn", "zh-cmn", "hak", "zh-hak", "nan", "zh-nan", "hsn", "zh-hsn"};
        f5560m = new String[]{"i-lux", "lb", "i-hak", "zh-hak", "i-navajo", "nv", "no-bok", "no-nob", "no-nyn", "no-nno", "zh-guoyu", "zh-cmn", "zh-hakka", "zh-hak", "zh-min-nan", "zh-nan", "zh-xiang", "zh-hsn"};
        f5561n = new int[]{0, 79764919, 159529838, 222504665, 319059676, 398814059, 445009330, 507990021, 638119352, 583659535, 797628118, 726387553, 890018660, 835552979, 1015980042, 944750013, 1276238704, 1221641927, 1167319070, 1095957929, 1595256236, 1540665371, 1452775106, 1381403509, 1780037320, 1859660671, 1671105958, 1733955601, 2031960084, 2111593891, 1889500026, 1952343757, -1742489888, -1662866601, -1851683442, -1788833735, -1960329156, -1880695413, -2103051438, -2040207643, -1104454824, -1159051537, -1213636554, -1284997759, -1389417084, -1444007885, -1532160278, -1603531939, -734892656, -789352409, -575645954, -646886583, -952755380, -1007220997, -827056094, -898286187, -231047128, -151282273, -71779514, -8804623, -515967244, -436212925, -390279782, -327299027, 881225847, 809987520, 1023691545, 969234094, 662832811, 591600412, 771767749, 717299826, 311336399, 374308984, 453813921, 533576470, 25881363, 88864420, 134795389, 214552010, 2023205639, 2086057648, 1897238633, 1976864222, 1804852699, 1867694188, 1645340341, 1724971778, 1587496639, 1516133128, 1461550545, 1406951526, 1302016099, 1230646740, 1142491917, 1087903418, -1398421865, -1469785312, -1524105735, -1578704818, -1079922613, -1151291908, -1239184603, -1293773166, -1968362705, -1905510760, -2094067647, -2014441994, -1716953613, -1654112188, -1876203875, -1796572374, -525066777, -462094256, -382327159, -302564546, -206542021, -143559028, -97365931, -17609246, -960696225, -1031934488, -817968335, -872425850, -709327229, -780559564, -600130067, -654598054, 1762451694, 1842216281, 1619975040, 1682949687, 2047383090, 2127137669, 1938468188, 2001449195, 1325665622, 1271206113, 1183200824, 1111960463, 1543535498, 1489069629, 1434599652, 1363369299, 622672798, 568075817, 748617968, 677256519, 907627842, 853037301, 1067152940, 995781531, 51762726, 131386257, 177728840, 240578815, 269590778, 349224269, 429104020, 491947555, -248556018, -168932423, -122852000, -60002089, -500490030, -420856475, -341238852, -278395381, -685261898, -739858943, -559578920, -630940305, -1004286614, -1058877219, -845023740, -916395085, -1119974018, -1174433591, -1262701040, -1333941337, -1371866206, -1426332139, -1481064244, -1552294533, -1690935098, -1611170447, -1833673816, -1770699233, -2009983462, -1930228819, -2119160460, -2056179517, 1569362073, 1498123566, 1409854455, 1355396672, 1317987909, 1246755826, 1192025387, 1137557660, 2072149281, 2135122070, 1912620623, 1992383480, 1753615357, 1816598090, 1627664531, 1707420964, 295390185, 358241886, 404320391, 483945776, 43990325, 106832002, 186451547, 266083308, 932423249, 861060070, 1041341759, 986742920, 613929101, 542559546, 756411363, 701822548, -978770311, -1050133554, -869589737, -924188512, -693284699, -764654318, -550540341, -605129092, -475935807, -413084042, -366743377, -287118056, -257573603, -194731862, -114850189, -35218492, -1984365303, -1921392450, -2143631769, -2063868976, -1698919467, -1635936670, -1824608069, -1744851700, -1347415887, -1418654458, -1506661409, -1561119128, -1129027987, -1200260134, -1254728445, -1309196108};
        f5562o = new int[]{0, 7, 14, 9, 28, 27, 18, 21, 56, 63, 54, 49, 36, 35, 42, 45, 112, 119, 126, 121, 108, 107, 98, 101, 72, 79, 70, 65, 84, 83, 90, 93, 224, 231, 238, 233, 252, 251, 242, 245, 216, 223, 214, 209, 196, 195, 202, 205, 144, 151, 158, 153, 140, 139, 130, 133, 168, 175, 166, 161, 180, 179, 186, 189, 199, 192, 201, 206, 219, 220, 213, 210, 255, 248, 241, 246, 227, 228, 237, 234, 183, 176, 185, 190, 171, 172, 165, 162, 143, 136, 129, 134, 147, 148, 157, 154, 39, 32, 41, 46, 59, 60, 53, 50, 31, 24, 17, 22, 3, 4, 13, 10, 87, 80, 89, 94, 75, 76, 69, 66, 111, 104, 97, zz.f2799f, 115, 116, 125, 122, 137, 142, 135, 128, 149, 146, 155, 156, 177, 182, 191, 184, 173, 170, 163, 164, 249, 254, 247, 240, 229, 226, 235, 236, 193, 198, 207, 200, 221, 218, 211, 212, 105, 110, 103, 96, 117, 114, 123, 124, 81, 86, 95, 88, 77, 74, 67, 68, 25, 30, 23, 16, 5, 2, 11, 12, 33, 38, 47, 40, 61, 58, 51, 52, 78, 73, 64, 71, 82, 85, 92, 91, 118, 113, 120, 127, 106, 109, 100, 99, 62, 57, 48, 55, 34, 37, 44, 43, 6, 1, 8, 15, 26, 29, 20, 19, 174, 169, 160, 167, 178, 181, 188, 187, 150, 145, 152, 159, 138, 141, 132, 131, 222, 217, 208, 215, 194, 197, 204, 203, 230, 225, 232, 239, 250, 253, 244, 243};
    }

    private static HashMap<String, String> A() {
        String[] iSOLanguages = Locale.getISOLanguages();
        HashMap<String, String> hashMap = new HashMap<>(iSOLanguages.length + f5559l.length);
        int i6 = 0;
        for (String str : iSOLanguages) {
            try {
                String iSO3Language = new Locale(str).getISO3Language();
                if (!TextUtils.isEmpty(iSO3Language)) {
                    hashMap.put(iSO3Language, str);
                }
            } catch (MissingResourceException unused) {
            }
        }
        while (true) {
            String[] strArr = f5559l;
            if (i6 >= strArr.length) {
                return hashMap;
            }
            hashMap.put(strArr[i6], strArr[i6 + 1]);
            i6 += 2;
        }
    }

    public static int A0(int[] iArr, int i6) {
        for (int i7 = 0; i7 < iArr.length; i7++) {
            if (iArr[i7] == i6) {
                return i7;
            }
        }
        return -1;
    }

    public static Uri B(Uri uri) {
        String path = uri.getPath();
        if (path == null) {
            return uri;
        }
        Matcher matcher = f5557j.matcher(path);
        return (matcher.matches() && matcher.group(1) == null) ? Uri.withAppendedPath(uri, "Manifest") : uri;
    }

    private static String B0(String str) {
        int i6 = 0;
        while (true) {
            String[] strArr = f5560m;
            if (i6 >= strArr.length) {
                return str;
            }
            if (str.startsWith(strArr[i6])) {
                return strArr[i6 + 1] + str.substring(strArr[i6].length());
            }
            i6 += 2;
        }
    }

    public static String C(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static <T> void C0(List<T> list, int i6, int i7, int i8) {
        ArrayDeque arrayDeque = new ArrayDeque();
        for (int i9 = (i7 - i6) - 1; i9 >= 0; i9--) {
            arrayDeque.addFirst(list.remove(i6 + i9));
        }
        list.addAll(Math.min(i8, list.size()), arrayDeque);
    }

    public static String D(byte[] bArr) {
        return new String(bArr, l2.d.f7489c);
    }

    public static long D0(long j6) {
        return (j6 == -9223372036854775807L || j6 == Long.MIN_VALUE) ? j6 : j6 * 1000;
    }

    public static String E(byte[] bArr, int i6, int i7) {
        return new String(bArr, i6, i7, l2.d.f7489c);
    }

    public static ExecutorService E0(final String str) {
        return Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: i2.b1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread z02;
                z02 = c1.z0(str, runnable);
                return z02;
            }
        });
    }

    public static int F(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager == null) {
            return -1;
        }
        return audioManager.generateAudioSessionId();
    }

    public static String F0(String str) {
        if (str == null) {
            return null;
        }
        String replace = str.replace('_', '-');
        if (!replace.isEmpty() && !replace.equals("und")) {
            str = replace;
        }
        String e6 = l2.b.e(str);
        String str2 = V0(e6, "-")[0];
        if (f5558k == null) {
            f5558k = A();
        }
        String str3 = f5558k.get(str2);
        if (str3 != null) {
            e6 = str3 + e6.substring(str2.length());
            str2 = str3;
        }
        return ("no".equals(str2) || "i".equals(str2) || "zh".equals(str2)) ? B0(e6) : e6;
    }

    public static int G(int i6) {
        if (i6 == 12) {
            return 743676;
        }
        switch (i6) {
            case 1:
                return 4;
            case 2:
                return 12;
            case 3:
                return 28;
            case 4:
                return 204;
            case 5:
                return 220;
            case 6:
                return 252;
            case 7:
                return 1276;
            case 8:
                return 6396;
            default:
                return 0;
        }
    }

    public static <T> T[] G0(T[] tArr, T t5) {
        Object[] copyOf = Arrays.copyOf(tArr, tArr.length + 1);
        copyOf[tArr.length] = t5;
        return (T[]) k(copyOf);
    }

    public static o3.b H(o3 o3Var, o3.b bVar) {
        boolean q6 = o3Var.q();
        boolean z5 = o3Var.z();
        boolean O = o3Var.O();
        boolean H = o3Var.H();
        boolean g02 = o3Var.g0();
        boolean R = o3Var.R();
        boolean u5 = o3Var.T().u();
        boolean z6 = false;
        o3.b.a d6 = new o3.b.a().b(bVar).d(4, !q6).d(5, z5 && !q6).d(6, O && !q6).d(7, !u5 && (O || !g02 || z5) && !q6).d(8, H && !q6).d(9, !u5 && (H || (g02 && R)) && !q6).d(10, !q6).d(11, z5 && !q6);
        if (z5 && !q6) {
            z6 = true;
        }
        return d6.d(12, z6).e();
    }

    public static <T> T[] H0(T[] tArr, T[] tArr2) {
        T[] tArr3 = (T[]) Arrays.copyOf(tArr, tArr.length + tArr2.length);
        System.arraycopy(tArr2, 0, tArr3, tArr.length, tArr2.length);
        return tArr3;
    }

    public static int I(ByteBuffer byteBuffer, int i6) {
        int i7 = byteBuffer.getInt(i6);
        return byteBuffer.order() == ByteOrder.BIG_ENDIAN ? i7 : Integer.reverseBytes(i7);
    }

    public static <T> T[] I0(T[] tArr, int i6) {
        a.a(i6 <= tArr.length);
        return (T[]) Arrays.copyOf(tArr, i6);
    }

    public static byte[] J(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i6 = 0; i6 < length; i6++) {
            int i7 = i6 * 2;
            bArr[i6] = (byte) ((Character.digit(str.charAt(i7), 16) << 4) + Character.digit(str.charAt(i7 + 1), 16));
        }
        return bArr;
    }

    public static <T> T[] J0(T[] tArr, int i6, int i7) {
        a.a(i6 >= 0);
        a.a(i7 <= tArr.length);
        return (T[]) Arrays.copyOfRange(tArr, i6, i7);
    }

    public static int K(String str, int i6) {
        int i7 = 0;
        for (String str2 : W0(str)) {
            if (i6 == x.m(str2)) {
                i7++;
            }
        }
        return i7;
    }

    public static long K0(String str) {
        Matcher matcher = f5554g.matcher(str);
        if (!matcher.matches()) {
            throw g3.a("Invalid date/time format: " + str, null);
        }
        int i6 = 0;
        if (matcher.group(9) != null && !matcher.group(9).equalsIgnoreCase("Z")) {
            i6 = (Integer.parseInt(matcher.group(12)) * 60) + Integer.parseInt(matcher.group(13));
            if ("-".equals(matcher.group(11))) {
                i6 *= -1;
            }
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
        gregorianCalendar.clear();
        gregorianCalendar.set(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)) - 1, Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5)), Integer.parseInt(matcher.group(6)));
        if (!TextUtils.isEmpty(matcher.group(8))) {
            gregorianCalendar.set(14, new BigDecimal("0." + matcher.group(8)).movePointRight(3).intValue());
        }
        long timeInMillis = gregorianCalendar.getTimeInMillis();
        return i6 != 0 ? timeInMillis - (i6 * 60000) : timeInMillis;
    }

    public static String L(String str, int i6) {
        String[] W0 = W0(str);
        if (W0.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : W0) {
            if (i6 == x.m(str2)) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(str2);
            }
        }
        if (sb.length() > 0) {
            return sb.toString();
        }
        return null;
    }

    public static long L0(String str) {
        Matcher matcher = f5555h.matcher(str);
        if (!matcher.matches()) {
            return (long) (Double.parseDouble(str) * 3600.0d * 1000.0d);
        }
        boolean isEmpty = true ^ TextUtils.isEmpty(matcher.group(1));
        String group = matcher.group(3);
        double parseDouble = group != null ? Double.parseDouble(group) * 3.1556908E7d : 0.0d;
        String group2 = matcher.group(5);
        double parseDouble2 = parseDouble + (group2 != null ? Double.parseDouble(group2) * 2629739.0d : 0.0d);
        String group3 = matcher.group(7);
        double parseDouble3 = parseDouble2 + (group3 != null ? Double.parseDouble(group3) * 86400.0d : 0.0d);
        String group4 = matcher.group(10);
        double parseDouble4 = parseDouble3 + (group4 != null ? Double.parseDouble(group4) * 3600.0d : 0.0d);
        String group5 = matcher.group(12);
        double parseDouble5 = parseDouble4 + (group5 != null ? Double.parseDouble(group5) * 60.0d : 0.0d);
        String group6 = matcher.group(14);
        long parseDouble6 = (long) ((parseDouble5 + (group6 != null ? Double.parseDouble(group6) : 0.0d)) * 1000.0d);
        return isEmpty ? -parseDouble6 : parseDouble6;
    }

    public static String M(Object[] objArr) {
        StringBuilder sb = new StringBuilder();
        for (int i6 = 0; i6 < objArr.length; i6++) {
            sb.append(objArr[i6].getClass().getSimpleName());
            if (i6 < objArr.length - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public static boolean M0(Handler handler, Runnable runnable) {
        if (!handler.getLooper().getThread().isAlive()) {
            return false;
        }
        if (handler.getLooper() != Looper.myLooper()) {
            return handler.post(runnable);
        }
        runnable.run();
        return true;
    }

    public static String N(Context context) {
        TelephonyManager telephonyManager;
        if (context != null && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
            String networkCountryIso = telephonyManager.getNetworkCountryIso();
            if (!TextUtils.isEmpty(networkCountryIso)) {
                return l2.b.f(networkCountryIso);
            }
        }
        return l2.b.f(Locale.getDefault().getCountry());
    }

    public static boolean N0(Parcel parcel) {
        return parcel.readInt() != 0;
    }

    public static Point O(Context context) {
        DisplayManager displayManager;
        Display display = (f5548a < 17 || (displayManager = (DisplayManager) context.getSystemService("display")) == null) ? null : displayManager.getDisplay(0);
        if (display == null) {
            display = ((WindowManager) a.e((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
        }
        return P(context, display);
    }

    public static <T> void O0(List<T> list, int i6, int i7) {
        if (i6 < 0 || i7 > list.size() || i6 > i7) {
            throw new IllegalArgumentException();
        }
        if (i6 != i7) {
            list.subList(i6, i7).clear();
        }
    }

    public static Point P(Context context, Display display) {
        if (display.getDisplayId() == 0 && y0(context)) {
            String l02 = l0(f5548a < 28 ? "sys.display-size" : "vendor.display-size");
            if (!TextUtils.isEmpty(l02)) {
                try {
                    String[] U0 = U0(l02.trim(), "x");
                    if (U0.length == 2) {
                        int parseInt = Integer.parseInt(U0[0]);
                        int parseInt2 = Integer.parseInt(U0[1]);
                        if (parseInt > 0 && parseInt2 > 0) {
                            return new Point(parseInt, parseInt2);
                        }
                    }
                } catch (NumberFormatException unused) {
                }
                t.c("Util", "Invalid display size: " + l02);
            }
            if ("Sony".equals(f5550c) && f5551d.startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd")) {
                return new Point(3840, 2160);
            }
        }
        Point point = new Point();
        int i6 = f5548a;
        if (i6 >= 23) {
            U(display, point);
        } else if (i6 >= 17) {
            T(display, point);
        } else {
            S(display, point);
        }
        return point;
    }

    public static long P0(long j6, long j7, long j8) {
        if (j8 >= j7 && j8 % j7 == 0) {
            return j6 / (j8 / j7);
        }
        if (j8 < j7 && j7 % j8 == 0) {
            return j6 * (j7 / j8);
        }
        return (long) (j6 * (j7 / j8));
    }

    public static Looper Q() {
        Looper myLooper = Looper.myLooper();
        return myLooper != null ? myLooper : Looper.getMainLooper();
    }

    public static long[] Q0(List<Long> list, long j6, long j7) {
        int size = list.size();
        long[] jArr = new long[size];
        int i6 = 0;
        if (j7 >= j6 && j7 % j6 == 0) {
            long j8 = j7 / j6;
            while (i6 < size) {
                jArr[i6] = list.get(i6).longValue() / j8;
                i6++;
            }
        } else if (j7 >= j6 || j6 % j7 != 0) {
            double d6 = j6 / j7;
            while (i6 < size) {
                jArr[i6] = (long) (list.get(i6).longValue() * d6);
                i6++;
            }
        } else {
            long j9 = j6 / j7;
            while (i6 < size) {
                jArr[i6] = list.get(i6).longValue() * j9;
                i6++;
            }
        }
        return jArr;
    }

    public static Locale R() {
        Locale.Category category;
        Locale locale;
        if (f5548a < 24) {
            return Locale.getDefault();
        }
        category = Locale.Category.DISPLAY;
        locale = Locale.getDefault(category);
        return locale;
    }

    public static void R0(long[] jArr, long j6, long j7) {
        int i6 = 0;
        if (j7 >= j6 && j7 % j6 == 0) {
            long j8 = j7 / j6;
            while (i6 < jArr.length) {
                jArr[i6] = jArr[i6] / j8;
                i6++;
            }
            return;
        }
        if (j7 >= j6 || j6 % j7 != 0) {
            double d6 = j6 / j7;
            while (i6 < jArr.length) {
                jArr[i6] = (long) (jArr[i6] * d6);
                i6++;
            }
            return;
        }
        long j9 = j6 / j7;
        while (i6 < jArr.length) {
            jArr[i6] = jArr[i6] * j9;
            i6++;
        }
    }

    private static void S(Display display, Point point) {
        display.getSize(point);
    }

    public static void S0(Throwable th) {
        T0(th);
    }

    private static void T(Display display, Point point) {
        display.getRealSize(point);
    }

    private static <T extends Throwable> void T0(Throwable th) {
        throw th;
    }

    private static void U(Display display, Point point) {
        Display.Mode mode;
        int physicalWidth;
        int physicalHeight;
        mode = display.getMode();
        physicalWidth = mode.getPhysicalWidth();
        point.x = physicalWidth;
        physicalHeight = mode.getPhysicalHeight();
        point.y = physicalHeight;
    }

    public static String[] U0(String str, String str2) {
        return str.split(str2, -1);
    }

    public static UUID V(String str) {
        String e6 = l2.b.e(str);
        e6.hashCode();
        switch (e6) {
            case "playready":
                return h0.p.f4775e;
            case "widevine":
                return h0.p.f4774d;
            case "clearkey":
                return h0.p.f4773c;
            default:
                try {
                    return UUID.fromString(str);
                } catch (RuntimeException unused) {
                    return null;
                }
        }
    }

    public static String[] V0(String str, String str2) {
        return str.split(str2, 2);
    }

    public static int W(int i6) {
        if (i6 == 2 || i6 == 4) {
            return 6005;
        }
        if (i6 == 10) {
            return 6004;
        }
        if (i6 == 7) {
            return 6005;
        }
        if (i6 == 8) {
            return 6003;
        }
        switch (i6) {
            case 15:
                return 6003;
            case 16:
            case 18:
                return 6005;
            case ab.b.API_TYPE_INDUSTRY /* 17 */:
            case 19:
            case 20:
            case 21:
            case 22:
                return 6004;
            default:
                switch (i6) {
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                        return 6002;
                    default:
                        return 6006;
                }
        }
    }

    public static String[] W0(String str) {
        return TextUtils.isEmpty(str) ? new String[0] : U0(str.trim(), "(\\s*,\\s*)");
    }

    public static int X(String str) {
        String[] U0;
        int length;
        if (str == null || (length = (U0 = U0(str, "_")).length) < 2) {
            return 0;
        }
        String str2 = U0[length - 1];
        boolean z5 = length >= 3 && "neg".equals(U0[length - 2]);
        try {
            int parseInt = Integer.parseInt((String) a.e(str2));
            return z5 ? -parseInt : parseInt;
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public static long X0(long j6, long j7, long j8) {
        long j9 = j6 - j7;
        return ((j6 ^ j9) & (j7 ^ j6)) < 0 ? j8 : j9;
    }

    public static String Y(int i6) {
        if (i6 == 0) {
            return "NO";
        }
        if (i6 == 1) {
            return "NO_UNSUPPORTED_TYPE";
        }
        if (i6 == 2) {
            return "NO_UNSUPPORTED_DRM";
        }
        if (i6 == 3) {
            return "NO_EXCEEDS_CAPABILITIES";
        }
        if (i6 == 4) {
            return "YES";
        }
        throw new IllegalStateException();
    }

    public static boolean Y0(SQLiteDatabase sQLiteDatabase, String str) {
        return DatabaseUtils.queryNumEntries(sQLiteDatabase, "sqlite_master", "tbl_name = ?", new String[]{str}) > 0;
    }

    public static String Z(Locale locale) {
        return f5548a >= 21 ? a0(locale) : locale.toString();
    }

    public static byte[] Z0(InputStream inputStream) {
        byte[] bArr = new byte[4096];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    private static String a0(Locale locale) {
        return locale.toLanguageTag();
    }

    public static long a1(int i6, int i7) {
        return b1(i7) | (b1(i6) << 32);
    }

    public static long b(long j6, long j7, long j8) {
        long j9 = j6 + j7;
        return ((j6 ^ j9) & (j7 ^ j9)) < 0 ? j8 : j9;
    }

    public static long b0(long j6, float f6) {
        return f6 == 1.0f ? j6 : Math.round(j6 * f6);
    }

    public static long b1(int i6) {
        return i6 & 4294967295L;
    }

    public static boolean c(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static long c0(long j6) {
        return j6 == -9223372036854775807L ? System.currentTimeMillis() : j6 + SystemClock.elapsedRealtime();
    }

    public static CharSequence c1(CharSequence charSequence, int i6) {
        return charSequence.length() <= i6 ? charSequence : charSequence.subSequence(0, i6);
    }

    public static <T extends Comparable<? super T>> int d(List<? extends Comparable<? super T>> list, T t5, boolean z5, boolean z6) {
        int i6;
        int binarySearch = Collections.binarySearch(list, t5);
        if (binarySearch < 0) {
            i6 = ~binarySearch;
        } else {
            int size = list.size();
            do {
                binarySearch++;
                if (binarySearch >= size) {
                    break;
                }
            } while (list.get(binarySearch).compareTo(t5) == 0);
            i6 = z5 ? binarySearch - 1 : binarySearch;
        }
        return z6 ? Math.min(list.size() - 1, i6) : i6;
    }

    public static int d0(int i6) {
        if (i6 == 8) {
            return 3;
        }
        if (i6 == 16) {
            return 2;
        }
        if (i6 != 24) {
            return i6 != 32 ? 0 : 805306368;
        }
        return 536870912;
    }

    public static String d1(String str) {
        int length = str.length();
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < length; i8++) {
            if (str.charAt(i8) == '%') {
                i7++;
            }
        }
        if (i7 == 0) {
            return str;
        }
        int i9 = length - (i7 * 2);
        StringBuilder sb = new StringBuilder(i9);
        Matcher matcher = f5556i.matcher(str);
        while (i7 > 0 && matcher.find()) {
            char parseInt = (char) Integer.parseInt((String) a.e(matcher.group(1)), 16);
            sb.append((CharSequence) str, i6, matcher.start());
            sb.append(parseInt);
            i6 = matcher.end();
            i7--;
        }
        if (i6 < length) {
            sb.append((CharSequence) str, i6, length);
        }
        if (sb.length() != i9) {
            return null;
        }
        return sb.toString();
    }

    public static int e(long[] jArr, long j6, boolean z5, boolean z6) {
        int i6;
        int binarySearch = Arrays.binarySearch(jArr, j6);
        if (binarySearch < 0) {
            i6 = ~binarySearch;
        } else {
            do {
                binarySearch++;
                if (binarySearch >= jArr.length) {
                    break;
                }
            } while (jArr[binarySearch] == j6);
            i6 = z5 ? binarySearch - 1 : binarySearch;
        }
        return z6 ? Math.min(jArr.length - 1, i6) : i6;
    }

    public static y1 e0(int i6, int i7, int i8) {
        return new y1.b().g0("audio/raw").J(i7).h0(i8).a0(i6).G();
    }

    public static long e1(long j6) {
        return (j6 == -9223372036854775807L || j6 == Long.MIN_VALUE) ? j6 : j6 / 1000;
    }

    public static int f(u uVar, long j6, boolean z5, boolean z6) {
        int i6;
        int c6 = uVar.c() - 1;
        int i7 = 0;
        while (i7 <= c6) {
            int i8 = (i7 + c6) >>> 1;
            if (uVar.b(i8) < j6) {
                i7 = i8 + 1;
            } else {
                c6 = i8 - 1;
            }
        }
        if (z5 && (i6 = c6 + 1) < uVar.c() && uVar.b(i6) == j6) {
            return i6;
        }
        if (z6 && c6 == -1) {
            return 0;
        }
        return c6;
    }

    public static int f0(int i6, int i7) {
        if (i6 != 2) {
            if (i6 == 3) {
                return i7;
            }
            if (i6 != 4) {
                if (i6 != 268435456) {
                    if (i6 == 536870912) {
                        return i7 * 3;
                    }
                    if (i6 != 805306368) {
                        throw new IllegalArgumentException();
                    }
                }
            }
            return i7 * 4;
        }
        return i7 * 2;
    }

    public static void f1(Parcel parcel, boolean z5) {
        parcel.writeInt(z5 ? 1 : 0);
    }

    public static <T extends Comparable<? super T>> int g(List<? extends Comparable<? super T>> list, T t5, boolean z5, boolean z6) {
        int i6;
        int binarySearch = Collections.binarySearch(list, t5);
        if (binarySearch < 0) {
            i6 = -(binarySearch + 2);
        } else {
            do {
                binarySearch--;
                if (binarySearch < 0) {
                    break;
                }
            } while (list.get(binarySearch).compareTo(t5) == 0);
            i6 = z5 ? binarySearch + 1 : binarySearch;
        }
        return z6 ? Math.max(0, i6) : i6;
    }

    public static long g0(long j6, float f6) {
        return f6 == 1.0f ? j6 : Math.round(j6 / f6);
    }

    public static int h(int[] iArr, int i6, boolean z5, boolean z6) {
        int i7;
        int binarySearch = Arrays.binarySearch(iArr, i6);
        if (binarySearch < 0) {
            i7 = -(binarySearch + 2);
        } else {
            do {
                binarySearch--;
                if (binarySearch < 0) {
                    break;
                }
            } while (iArr[binarySearch] == i6);
            i7 = z5 ? binarySearch + 1 : binarySearch;
        }
        return z6 ? Math.max(0, i7) : i7;
    }

    public static int h0(int i6) {
        if (i6 == 13) {
            return 1;
        }
        switch (i6) {
            case 2:
                return 0;
            case 3:
                return 8;
            case 4:
                return 4;
            case 5:
            case 7:
            case 8:
            case 9:
            case 10:
                return 5;
            case 6:
                return 2;
            default:
                return 3;
        }
    }

    public static int i(long[] jArr, long j6, boolean z5, boolean z6) {
        int i6;
        int binarySearch = Arrays.binarySearch(jArr, j6);
        if (binarySearch < 0) {
            i6 = -(binarySearch + 2);
        } else {
            do {
                binarySearch--;
                if (binarySearch < 0) {
                    break;
                }
            } while (jArr[binarySearch] == j6);
            i6 = z5 ? binarySearch + 1 : binarySearch;
        }
        return z6 ? Math.max(0, i6) : i6;
    }

    public static String[] i0() {
        String[] j02 = j0();
        for (int i6 = 0; i6 < j02.length; i6++) {
            j02[i6] = F0(j02[i6]);
        }
        return j02;
    }

    @EnsuresNonNull({"#1"})
    public static <T> T j(T t5) {
        return t5;
    }

    private static String[] j0() {
        Configuration configuration = Resources.getSystem().getConfiguration();
        return f5548a >= 24 ? k0(configuration) : new String[]{Z(configuration.locale)};
    }

    @EnsuresNonNull({"#1"})
    public static <T> T[] k(T[] tArr) {
        return tArr;
    }

    private static String[] k0(Configuration configuration) {
        LocaleList locales;
        String languageTags;
        locales = configuration.getLocales();
        languageTags = locales.toLanguageTags();
        return U0(languageTags, ",");
    }

    public static int l(int i6, int i7) {
        return ((i6 + i7) - 1) / i7;
    }

    private static String l0(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class).invoke(cls, str);
        } catch (Exception e6) {
            t.d("Util", "Failed to read system property " + str, e6);
            return null;
        }
    }

    public static long m(long j6, long j7) {
        return ((j6 + j7) - 1) / j7;
    }

    public static String m0(int i6) {
        switch (i6) {
            case -2:
                return "none";
            case ab.c.SDT_UNKNOWN /* -1 */:
                return "unknown";
            case 0:
                return "default";
            case 1:
                return "audio";
            case 2:
                return "video";
            case 3:
                return "text";
            case 4:
                return "image";
            case 5:
                return "metadata";
            case 6:
                return "camera motion";
            default:
                if (i6 < 10000) {
                    return "?";
                }
                return "custom (" + i6 + ")";
        }
    }

    public static void n(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static byte[] n0(String str) {
        return str.getBytes(l2.d.f7489c);
    }

    public static int o(long j6, long j7) {
        if (j6 < j7) {
            return -1;
        }
        return j6 == j7 ? 0 : 1;
    }

    public static int o0(Uri uri) {
        int p02;
        String scheme = uri.getScheme();
        if (scheme != null && l2.b.a("rtsp", scheme)) {
            return 3;
        }
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            return 4;
        }
        int lastIndexOf = lastPathSegment.lastIndexOf(46);
        if (lastIndexOf >= 0 && (p02 = p0(lastPathSegment.substring(lastIndexOf + 1))) != 4) {
            return p02;
        }
        Matcher matcher = f5557j.matcher((CharSequence) a.e(uri.getPath()));
        if (!matcher.matches()) {
            return 4;
        }
        String group = matcher.group(2);
        if (group != null) {
            if (group.contains("format=mpd-time-csf")) {
                return 0;
            }
            if (group.contains("format=m3u8-aapl")) {
                return 2;
            }
        }
        return 1;
    }

    public static float p(float f6, float f7, float f8) {
        return Math.max(f7, Math.min(f6, f8));
    }

    public static int p0(String str) {
        String e6 = l2.b.e(str);
        e6.hashCode();
        switch (e6) {
            case "ism":
            case "isml":
                return 1;
            case "mpd":
                return 0;
            case "m3u8":
                return 2;
            default:
                return 4;
        }
    }

    public static int q(int i6, int i7, int i8) {
        return Math.max(i7, Math.min(i6, i8));
    }

    public static int q0(Uri uri, String str) {
        if (str == null) {
            return o0(uri);
        }
        switch (str) {
            case "application/x-mpegURL":
                return 2;
            case "application/vnd.ms-sstr+xml":
                return 1;
            case "application/dash+xml":
                return 0;
            case "application/x-rtsp":
                return 3;
            default:
                return 4;
        }
    }

    public static long r(long j6, long j7, long j8) {
        return Math.max(j7, Math.min(j6, j8));
    }

    public static boolean r0(i0 i0Var, i0 i0Var2, Inflater inflater) {
        if (i0Var.a() <= 0) {
            return false;
        }
        if (i0Var2.b() < i0Var.a()) {
            i0Var2.c(i0Var.a() * 2);
        }
        if (inflater == null) {
            inflater = new Inflater();
        }
        inflater.setInput(i0Var.e(), i0Var.f(), i0Var.a());
        int i6 = 0;
        while (true) {
            try {
                i6 += inflater.inflate(i0Var2.e(), i6, i0Var2.b() - i6);
                if (!inflater.finished()) {
                    if (inflater.needsDictionary() || inflater.needsInput()) {
                        break;
                    }
                    if (i6 == i0Var2.b()) {
                        i0Var2.c(i0Var2.b() * 2);
                    }
                } else {
                    i0Var2.R(i6);
                    inflater.reset();
                    return true;
                }
            } catch (DataFormatException unused) {
                return false;
            } finally {
                inflater.reset();
            }
        }
        return false;
    }

    public static boolean s(Object[] objArr, Object obj) {
        for (Object obj2 : objArr) {
            if (c(obj2, obj)) {
                return true;
            }
        }
        return false;
    }

    public static String s0(int i6) {
        return Integer.toString(i6, 36);
    }

    public static int t(byte[] bArr, int i6, int i7, int i8) {
        while (i6 < i7) {
            i8 = f5561n[((i8 >>> 24) ^ (bArr[i6] & 255)) & 255] ^ (i8 << 8);
            i6++;
        }
        return i8;
    }

    public static boolean t0(Context context) {
        return f5548a >= 23 && context.getPackageManager().hasSystemFeature("android.hardware.type.automotive");
    }

    public static int u(byte[] bArr, int i6, int i7, int i8) {
        while (i6 < i7) {
            i8 = f5562o[i8 ^ (bArr[i6] & 255)];
            i6++;
        }
        return i8;
    }

    public static boolean u0(int i6) {
        return i6 == 536870912 || i6 == 805306368 || i6 == 4;
    }

    public static Handler v(Looper looper, Handler.Callback callback) {
        return new Handler(looper, callback);
    }

    public static boolean v0(int i6) {
        return i6 == 3 || i6 == 2 || i6 == 268435456 || i6 == 536870912 || i6 == 805306368 || i6 == 4;
    }

    public static Handler w() {
        return x(null);
    }

    public static boolean w0(int i6) {
        return i6 == 10 || i6 == 13;
    }

    public static Handler x(Handler.Callback callback) {
        return v((Looper) a.i(Looper.myLooper()), callback);
    }

    public static boolean x0(Uri uri) {
        String scheme = uri.getScheme();
        return TextUtils.isEmpty(scheme) || "file".equals(scheme);
    }

    public static Handler y() {
        return z(null);
    }

    public static boolean y0(Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getApplicationContext().getSystemService("uimode");
        return uiModeManager != null && uiModeManager.getCurrentModeType() == 4;
    }

    public static Handler z(Handler.Callback callback) {
        return v(Q(), callback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Thread z0(String str, Runnable runnable) {
        return new Thread(runnable, str);
    }
}
