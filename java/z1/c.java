package z1;

import android.graphics.Color;
import android.graphics.PointF;
import android.text.TextUtils;
import i2.c1;
import i2.t;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import o2.e;

/* loaded from: classes.dex */
final class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f11219a;

    /* renamed from: b, reason: collision with root package name */
    public final int f11220b;

    /* renamed from: c, reason: collision with root package name */
    public final Integer f11221c;

    /* renamed from: d, reason: collision with root package name */
    public final Integer f11222d;

    /* renamed from: e, reason: collision with root package name */
    public final float f11223e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f11224f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f11225g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f11226h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f11227i;

    /* renamed from: j, reason: collision with root package name */
    public final int f11228j;

    static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f11229a;

        /* renamed from: b, reason: collision with root package name */
        public final int f11230b;

        /* renamed from: c, reason: collision with root package name */
        public final int f11231c;

        /* renamed from: d, reason: collision with root package name */
        public final int f11232d;

        /* renamed from: e, reason: collision with root package name */
        public final int f11233e;

        /* renamed from: f, reason: collision with root package name */
        public final int f11234f;

        /* renamed from: g, reason: collision with root package name */
        public final int f11235g;

        /* renamed from: h, reason: collision with root package name */
        public final int f11236h;

        /* renamed from: i, reason: collision with root package name */
        public final int f11237i;

        /* renamed from: j, reason: collision with root package name */
        public final int f11238j;

        /* renamed from: k, reason: collision with root package name */
        public final int f11239k;

        private a(int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
            this.f11229a = i6;
            this.f11230b = i7;
            this.f11231c = i8;
            this.f11232d = i9;
            this.f11233e = i10;
            this.f11234f = i11;
            this.f11235g = i12;
            this.f11236h = i13;
            this.f11237i = i14;
            this.f11238j = i15;
            this.f11239k = i16;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        public static a a(String str) {
            char c6;
            String[] split = TextUtils.split(str.substring(7), ",");
            int i6 = -1;
            int i7 = -1;
            int i8 = -1;
            int i9 = -1;
            int i10 = -1;
            int i11 = -1;
            int i12 = -1;
            int i13 = -1;
            int i14 = -1;
            int i15 = -1;
            for (int i16 = 0; i16 < split.length; i16++) {
                String e6 = l2.b.e(split[i16].trim());
                e6.hashCode();
                switch (e6.hashCode()) {
                    case -1178781136:
                        if (e6.equals("italic")) {
                            c6 = 0;
                            break;
                        }
                        c6 = 65535;
                        break;
                    case -1026963764:
                        if (e6.equals("underline")) {
                            c6 = 1;
                            break;
                        }
                        c6 = 65535;
                        break;
                    case -192095652:
                        if (e6.equals("strikeout")) {
                            c6 = 2;
                            break;
                        }
                        c6 = 65535;
                        break;
                    case -70925746:
                        if (e6.equals("primarycolour")) {
                            c6 = 3;
                            break;
                        }
                        c6 = 65535;
                        break;
                    case 3029637:
                        if (e6.equals("bold")) {
                            c6 = 4;
                            break;
                        }
                        c6 = 65535;
                        break;
                    case 3373707:
                        if (e6.equals("name")) {
                            c6 = 5;
                            break;
                        }
                        c6 = 65535;
                        break;
                    case 366554320:
                        if (e6.equals("fontsize")) {
                            c6 = 6;
                            break;
                        }
                        c6 = 65535;
                        break;
                    case 767321349:
                        if (e6.equals("borderstyle")) {
                            c6 = 7;
                            break;
                        }
                        c6 = 65535;
                        break;
                    case 1767875043:
                        if (e6.equals("alignment")) {
                            c6 = '\b';
                            break;
                        }
                        c6 = 65535;
                        break;
                    case 1988365454:
                        if (e6.equals("outlinecolour")) {
                            c6 = '\t';
                            break;
                        }
                        c6 = 65535;
                        break;
                    default:
                        c6 = 65535;
                        break;
                }
                switch (c6) {
                    case 0:
                        i12 = i16;
                        break;
                    case 1:
                        i13 = i16;
                        break;
                    case 2:
                        i14 = i16;
                        break;
                    case 3:
                        i8 = i16;
                        break;
                    case 4:
                        i11 = i16;
                        break;
                    case 5:
                        i6 = i16;
                        break;
                    case 6:
                        i10 = i16;
                        break;
                    case 7:
                        i15 = i16;
                        break;
                    case '\b':
                        i7 = i16;
                        break;
                    case '\t':
                        i9 = i16;
                        break;
                }
            }
            if (i6 != -1) {
                return new a(i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, split.length);
            }
            return null;
        }
    }

    static final class b {

        /* renamed from: c, reason: collision with root package name */
        private static final Pattern f11240c = Pattern.compile("\\{([^}]*)\\}");

        /* renamed from: d, reason: collision with root package name */
        private static final Pattern f11241d = Pattern.compile(c1.C("\\\\pos\\((%1$s),(%1$s)\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));

        /* renamed from: e, reason: collision with root package name */
        private static final Pattern f11242e = Pattern.compile(c1.C("\\\\move\\(%1$s,%1$s,(%1$s),(%1$s)(?:,%1$s,%1$s)?\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));

        /* renamed from: f, reason: collision with root package name */
        private static final Pattern f11243f = Pattern.compile("\\\\an(\\d+)");

        /* renamed from: a, reason: collision with root package name */
        public final int f11244a;

        /* renamed from: b, reason: collision with root package name */
        public final PointF f11245b;

        private b(int i6, PointF pointF) {
            this.f11244a = i6;
            this.f11245b = pointF;
        }

        private static int a(String str) {
            Matcher matcher = f11243f.matcher(str);
            if (matcher.find()) {
                return c.e((String) i2.a.e(matcher.group(1)));
            }
            return -1;
        }

        public static b b(String str) {
            Matcher matcher = f11240c.matcher(str);
            PointF pointF = null;
            int i6 = -1;
            while (matcher.find()) {
                String str2 = (String) i2.a.e(matcher.group(1));
                try {
                    PointF c6 = c(str2);
                    if (c6 != null) {
                        pointF = c6;
                    }
                } catch (RuntimeException unused) {
                }
                try {
                    int a6 = a(str2);
                    if (a6 != -1) {
                        i6 = a6;
                    }
                } catch (RuntimeException unused2) {
                }
            }
            return new b(i6, pointF);
        }

        private static PointF c(String str) {
            String group;
            String group2;
            Matcher matcher = f11241d.matcher(str);
            Matcher matcher2 = f11242e.matcher(str);
            boolean find = matcher.find();
            boolean find2 = matcher2.find();
            if (find) {
                if (find2) {
                    t.f("SsaStyle.Overrides", "Override has both \\pos(x,y) and \\move(x1,y1,x2,y2); using \\pos values. override='" + str + "'");
                }
                group = matcher.group(1);
                group2 = matcher.group(2);
            } else {
                if (!find2) {
                    return null;
                }
                group = matcher2.group(1);
                group2 = matcher2.group(2);
            }
            return new PointF(Float.parseFloat(((String) i2.a.e(group)).trim()), Float.parseFloat(((String) i2.a.e(group2)).trim()));
        }

        public static String d(String str) {
            return f11240c.matcher(str).replaceAll("");
        }
    }

    private c(String str, int i6, Integer num, Integer num2, float f6, boolean z5, boolean z6, boolean z7, boolean z8, int i7) {
        this.f11219a = str;
        this.f11220b = i6;
        this.f11221c = num;
        this.f11222d = num2;
        this.f11223e = f6;
        this.f11224f = z5;
        this.f11225g = z6;
        this.f11226h = z7;
        this.f11227i = z8;
        this.f11228j = i7;
    }

    public static c b(String str, a aVar) {
        i2.a.a(str.startsWith("Style:"));
        String[] split = TextUtils.split(str.substring(6), ",");
        int length = split.length;
        int i6 = aVar.f11239k;
        if (length != i6) {
            t.i("SsaStyle", c1.C("Skipping malformed 'Style:' line (expected %s values, found %s): '%s'", Integer.valueOf(i6), Integer.valueOf(split.length), str));
            return null;
        }
        try {
            String trim = split[aVar.f11229a].trim();
            int i7 = aVar.f11230b;
            int e6 = i7 != -1 ? e(split[i7].trim()) : -1;
            int i8 = aVar.f11231c;
            Integer h6 = i8 != -1 ? h(split[i8].trim()) : null;
            int i9 = aVar.f11232d;
            Integer h7 = i9 != -1 ? h(split[i9].trim()) : null;
            int i10 = aVar.f11233e;
            float i11 = i10 != -1 ? i(split[i10].trim()) : -3.4028235E38f;
            int i12 = aVar.f11234f;
            boolean z5 = i12 != -1 && f(split[i12].trim());
            int i13 = aVar.f11235g;
            boolean z6 = i13 != -1 && f(split[i13].trim());
            int i14 = aVar.f11236h;
            boolean z7 = i14 != -1 && f(split[i14].trim());
            int i15 = aVar.f11237i;
            boolean z8 = i15 != -1 && f(split[i15].trim());
            int i16 = aVar.f11238j;
            return new c(trim, e6, h6, h7, i11, z5, z6, z7, z8, i16 != -1 ? g(split[i16].trim()) : -1);
        } catch (RuntimeException e7) {
            t.j("SsaStyle", "Skipping malformed 'Style:' line: '" + str + "'", e7);
            return null;
        }
    }

    private static boolean c(int i6) {
        switch (i6) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return true;
            default:
                return false;
        }
    }

    private static boolean d(int i6) {
        return i6 == 1 || i6 == 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int e(String str) {
        try {
            int parseInt = Integer.parseInt(str.trim());
            if (c(parseInt)) {
                return parseInt;
            }
        } catch (NumberFormatException unused) {
        }
        t.i("SsaStyle", "Ignoring unknown alignment: " + str);
        return -1;
    }

    private static boolean f(String str) {
        try {
            int parseInt = Integer.parseInt(str);
            return parseInt == 1 || parseInt == -1;
        } catch (NumberFormatException e6) {
            t.j("SsaStyle", "Failed to parse boolean value: '" + str + "'", e6);
            return false;
        }
    }

    private static int g(String str) {
        try {
            int parseInt = Integer.parseInt(str.trim());
            if (d(parseInt)) {
                return parseInt;
            }
        } catch (NumberFormatException unused) {
        }
        t.i("SsaStyle", "Ignoring unknown BorderStyle: " + str);
        return -1;
    }

    public static Integer h(String str) {
        try {
            long parseLong = str.startsWith("&H") ? Long.parseLong(str.substring(2), 16) : Long.parseLong(str);
            i2.a.a(parseLong <= 4294967295L);
            return Integer.valueOf(Color.argb(e.d(((parseLong >> 24) & 255) ^ 255), e.d(parseLong & 255), e.d((parseLong >> 8) & 255), e.d((parseLong >> 16) & 255)));
        } catch (IllegalArgumentException e6) {
            t.j("SsaStyle", "Failed to parse color expression: '" + str + "'", e6);
            return null;
        }
    }

    private static float i(String str) {
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException e6) {
            t.j("SsaStyle", "Failed to parse font size: '" + str + "'", e6);
            return -3.4028235E38f;
        }
    }
}
