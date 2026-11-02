package d2;

import android.graphics.Color;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import d2.f;
import i2.c1;
import i2.i0;
import i2.t;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import u1.b;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f2950a = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f2951b = Pattern.compile("(\\S+?):(\\S+)");

    /* renamed from: c, reason: collision with root package name */
    private static final Map<String, Integer> f2952c;

    /* renamed from: d, reason: collision with root package name */
    private static final Map<String, Integer> f2953d;

    /* JADX INFO: Access modifiers changed from: private */
    static class b {

        /* renamed from: c, reason: collision with root package name */
        private static final Comparator<b> f2954c = new Comparator() { // from class: d2.g
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int e6;
                e6 = f.b.e((f.b) obj, (f.b) obj2);
                return e6;
            }
        };

        /* renamed from: a, reason: collision with root package name */
        private final c f2955a;

        /* renamed from: b, reason: collision with root package name */
        private final int f2956b;

        private b(c cVar, int i6) {
            this.f2955a = cVar;
            this.f2956b = i6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ int e(b bVar, b bVar2) {
            return Integer.compare(bVar.f2955a.f2958b, bVar2.f2955a.f2958b);
        }
    }

    private static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final String f2957a;

        /* renamed from: b, reason: collision with root package name */
        public final int f2958b;

        /* renamed from: c, reason: collision with root package name */
        public final String f2959c;

        /* renamed from: d, reason: collision with root package name */
        public final Set<String> f2960d;

        private c(String str, int i6, String str2, Set<String> set) {
            this.f2958b = i6;
            this.f2957a = str;
            this.f2959c = str2;
            this.f2960d = set;
        }

        public static c a(String str, int i6) {
            String str2;
            String trim = str.trim();
            i2.a.a(!trim.isEmpty());
            int indexOf = trim.indexOf(" ");
            if (indexOf == -1) {
                str2 = "";
            } else {
                String trim2 = trim.substring(indexOf).trim();
                trim = trim.substring(0, indexOf);
                str2 = trim2;
            }
            String[] U0 = c1.U0(trim, "\\.");
            String str3 = U0[0];
            HashSet hashSet = new HashSet();
            for (int i7 = 1; i7 < U0.length; i7++) {
                hashSet.add(U0[i7]);
            }
            return new c(str3, i6, str2, hashSet);
        }

        public static c b() {
            return new c("", 0, "", Collections.emptySet());
        }
    }

    private static final class d implements Comparable<d> {

        /* renamed from: a, reason: collision with root package name */
        public final int f2961a;

        /* renamed from: b, reason: collision with root package name */
        public final d2.d f2962b;

        public d(int i6, d2.d dVar) {
            this.f2961a = i6;
            this.f2962b = dVar;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(d dVar) {
            return Integer.compare(this.f2961a, dVar.f2961a);
        }
    }

    private static final class e {

        /* renamed from: c, reason: collision with root package name */
        public CharSequence f2965c;

        /* renamed from: a, reason: collision with root package name */
        public long f2963a = 0;

        /* renamed from: b, reason: collision with root package name */
        public long f2964b = 0;

        /* renamed from: d, reason: collision with root package name */
        public int f2966d = 2;

        /* renamed from: e, reason: collision with root package name */
        public float f2967e = -3.4028235E38f;

        /* renamed from: f, reason: collision with root package name */
        public int f2968f = 1;

        /* renamed from: g, reason: collision with root package name */
        public int f2969g = 0;

        /* renamed from: h, reason: collision with root package name */
        public float f2970h = -3.4028235E38f;

        /* renamed from: i, reason: collision with root package name */
        public int f2971i = Integer.MIN_VALUE;

        /* renamed from: j, reason: collision with root package name */
        public float f2972j = 1.0f;

        /* renamed from: k, reason: collision with root package name */
        public int f2973k = Integer.MIN_VALUE;

        private static float b(float f6, int i6) {
            if (f6 == -3.4028235E38f || i6 != 0 || (f6 >= 0.0f && f6 <= 1.0f)) {
                return f6 != -3.4028235E38f ? f6 : i6 == 0 ? 1.0f : -3.4028235E38f;
            }
            return 1.0f;
        }

        private static Layout.Alignment c(int i6) {
            if (i6 != 1) {
                if (i6 == 2) {
                    return Layout.Alignment.ALIGN_CENTER;
                }
                if (i6 != 3) {
                    if (i6 != 4) {
                        if (i6 != 5) {
                            t.i("WebvttCueParser", "Unknown textAlignment: " + i6);
                            return null;
                        }
                    }
                }
                return Layout.Alignment.ALIGN_OPPOSITE;
            }
            return Layout.Alignment.ALIGN_NORMAL;
        }

        private static float d(int i6, float f6) {
            if (i6 == 0) {
                return 1.0f - f6;
            }
            if (i6 == 1) {
                return f6 <= 0.5f ? f6 * 2.0f : (1.0f - f6) * 2.0f;
            }
            if (i6 == 2) {
                return f6;
            }
            throw new IllegalStateException(String.valueOf(i6));
        }

        private static float e(int i6) {
            if (i6 != 4) {
                return i6 != 5 ? 0.5f : 1.0f;
            }
            return 0.0f;
        }

        private static int f(int i6) {
            if (i6 == 1) {
                return 0;
            }
            if (i6 == 3) {
                return 2;
            }
            if (i6 != 4) {
                return i6 != 5 ? 1 : 2;
            }
            return 0;
        }

        public d2.e a() {
            return new d2.e(g().a(), this.f2963a, this.f2964b);
        }

        public b.C0148b g() {
            float f6 = this.f2970h;
            if (f6 == -3.4028235E38f) {
                f6 = e(this.f2966d);
            }
            int i6 = this.f2971i;
            if (i6 == Integer.MIN_VALUE) {
                i6 = f(this.f2966d);
            }
            b.C0148b r6 = new b.C0148b().p(c(this.f2966d)).h(b(this.f2967e, this.f2968f), this.f2968f).i(this.f2969g).k(f6).l(i6).n(Math.min(this.f2972j, d(i6, f6))).r(this.f2973k);
            CharSequence charSequence = this.f2965c;
            if (charSequence != null) {
                r6.o(charSequence);
            }
            return r6;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("white", Integer.valueOf(Color.rgb(255, 255, 255)));
        hashMap.put("lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        hashMap.put("cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        hashMap.put("red", Integer.valueOf(Color.rgb(255, 0, 0)));
        hashMap.put("yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        hashMap.put("magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        hashMap.put("blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        hashMap.put("black", Integer.valueOf(Color.rgb(0, 0, 0)));
        f2952c = Collections.unmodifiableMap(hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("bg_white", Integer.valueOf(Color.rgb(255, 255, 255)));
        hashMap2.put("bg_lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        hashMap2.put("bg_cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        hashMap2.put("bg_red", Integer.valueOf(Color.rgb(255, 0, 0)));
        hashMap2.put("bg_yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        hashMap2.put("bg_magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        hashMap2.put("bg_blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        hashMap2.put("bg_black", Integer.valueOf(Color.rgb(0, 0, 0)));
        f2953d = Collections.unmodifiableMap(hashMap2);
    }

    private static void a(SpannableStringBuilder spannableStringBuilder, Set<String> set, int i6, int i7) {
        Object foregroundColorSpan;
        for (String str : set) {
            Map<String, Integer> map = f2952c;
            if (map.containsKey(str)) {
                foregroundColorSpan = new ForegroundColorSpan(map.get(str).intValue());
            } else {
                Map<String, Integer> map2 = f2953d;
                if (map2.containsKey(str)) {
                    foregroundColorSpan = new BackgroundColorSpan(map2.get(str).intValue());
                }
            }
            spannableStringBuilder.setSpan(foregroundColorSpan, i6, i7, 33);
        }
    }

    private static void b(String str, SpannableStringBuilder spannableStringBuilder) {
        char c6;
        str.hashCode();
        switch (str) {
            case "gt":
                c6 = '>';
                break;
            case "lt":
                c6 = '<';
                break;
            case "amp":
                c6 = '&';
                break;
            case "nbsp":
                c6 = ' ';
                break;
            default:
                t.i("WebvttCueParser", "ignoring unsupported entity: '&" + str + ";'");
                return;
        }
        spannableStringBuilder.append(c6);
    }

    private static void c(SpannableStringBuilder spannableStringBuilder, String str, c cVar, List<b> list, List<d2.d> list2) {
        int i6 = i(list2, str, cVar);
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.addAll(list);
        Collections.sort(arrayList, b.f2954c);
        int i7 = cVar.f2958b;
        int i8 = 0;
        for (int i9 = 0; i9 < arrayList.size(); i9++) {
            if ("rt".equals(((b) arrayList.get(i9)).f2955a.f2957a)) {
                b bVar = (b) arrayList.get(i9);
                int g6 = g(i(list2, str, bVar.f2955a), i6, 1);
                int i10 = bVar.f2955a.f2958b - i8;
                int i11 = bVar.f2956b - i8;
                CharSequence subSequence = spannableStringBuilder.subSequence(i10, i11);
                spannableStringBuilder.delete(i10, i11);
                spannableStringBuilder.setSpan(new y1.c(subSequence.toString(), g6), i7, i10, 33);
                i8 += subSequence.length();
                i7 = i10;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:40:0x009d A[LOOP:0: B:38:0x0097->B:40:0x009d, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void d(java.lang.String r8, d2.f.c r9, java.util.List<d2.f.b> r10, android.text.SpannableStringBuilder r11, java.util.List<d2.d> r12) {
        /*
            int r0 = r9.f2958b
            int r1 = r11.length()
            java.lang.String r2 = r9.f2957a
            r2.hashCode()
            int r3 = r2.hashCode()
            r4 = 2
            r5 = 0
            r6 = 1
            r7 = -1
            switch(r3) {
                case 0: goto L65;
                case 98: goto L5a;
                case 99: goto L4f;
                case 105: goto L44;
                case 117: goto L39;
                case 118: goto L2e;
                case 3314158: goto L23;
                case 3511770: goto L18;
                default: goto L16;
            }
        L16:
            goto L6f
        L18:
            java.lang.String r3 = "ruby"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L21
            goto L6f
        L21:
            r7 = 7
            goto L6f
        L23:
            java.lang.String r3 = "lang"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L2c
            goto L6f
        L2c:
            r7 = 6
            goto L6f
        L2e:
            java.lang.String r3 = "v"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L37
            goto L6f
        L37:
            r7 = 5
            goto L6f
        L39:
            java.lang.String r3 = "u"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L42
            goto L6f
        L42:
            r7 = 4
            goto L6f
        L44:
            java.lang.String r3 = "i"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L4d
            goto L6f
        L4d:
            r7 = 3
            goto L6f
        L4f:
            java.lang.String r3 = "c"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L58
            goto L6f
        L58:
            r7 = 2
            goto L6f
        L5a:
            java.lang.String r3 = "b"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L63
            goto L6f
        L63:
            r7 = 1
            goto L6f
        L65:
            java.lang.String r3 = ""
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L6e
            goto L6f
        L6e:
            r7 = 0
        L6f:
            r2 = 33
            switch(r7) {
                case 0: goto L93;
                case 1: goto L8b;
                case 2: goto L85;
                case 3: goto L7f;
                case 4: goto L79;
                case 5: goto L93;
                case 6: goto L93;
                case 7: goto L75;
                default: goto L74;
            }
        L74:
            return
        L75:
            c(r11, r8, r9, r10, r12)
            goto L93
        L79:
            android.text.style.UnderlineSpan r10 = new android.text.style.UnderlineSpan
            r10.<init>()
            goto L90
        L7f:
            android.text.style.StyleSpan r10 = new android.text.style.StyleSpan
            r10.<init>(r4)
            goto L90
        L85:
            java.util.Set<java.lang.String> r10 = r9.f2960d
            a(r11, r10, r0, r1)
            goto L93
        L8b:
            android.text.style.StyleSpan r10 = new android.text.style.StyleSpan
            r10.<init>(r6)
        L90:
            r11.setSpan(r10, r0, r1, r2)
        L93:
            java.util.List r8 = h(r12, r8, r9)
        L97:
            int r9 = r8.size()
            if (r5 >= r9) goto Lab
            java.lang.Object r9 = r8.get(r5)
            d2.f$d r9 = (d2.f.d) r9
            d2.d r9 = r9.f2962b
            e(r11, r9, r0, r1)
            int r5 = r5 + 1
            goto L97
        Lab:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d2.f.d(java.lang.String, d2.f$c, java.util.List, android.text.SpannableStringBuilder, java.util.List):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void e(android.text.SpannableStringBuilder r4, d2.d r5, int r6, int r7) {
        /*
            if (r5 != 0) goto L3
            return
        L3:
            int r0 = r5.i()
            r1 = -1
            r2 = 33
            if (r0 == r1) goto L18
            android.text.style.StyleSpan r0 = new android.text.style.StyleSpan
            int r1 = r5.i()
            r0.<init>(r1)
            y1.d.a(r4, r0, r6, r7, r2)
        L18:
            boolean r0 = r5.l()
            if (r0 == 0) goto L26
            android.text.style.StrikethroughSpan r0 = new android.text.style.StrikethroughSpan
            r0.<init>()
            r4.setSpan(r0, r6, r7, r2)
        L26:
            boolean r0 = r5.m()
            if (r0 == 0) goto L34
            android.text.style.UnderlineSpan r0 = new android.text.style.UnderlineSpan
            r0.<init>()
            r4.setSpan(r0, r6, r7, r2)
        L34:
            boolean r0 = r5.k()
            if (r0 == 0) goto L46
            android.text.style.ForegroundColorSpan r0 = new android.text.style.ForegroundColorSpan
            int r1 = r5.c()
            r0.<init>(r1)
            y1.d.a(r4, r0, r6, r7, r2)
        L46:
            boolean r0 = r5.j()
            if (r0 == 0) goto L58
            android.text.style.BackgroundColorSpan r0 = new android.text.style.BackgroundColorSpan
            int r1 = r5.a()
            r0.<init>(r1)
            y1.d.a(r4, r0, r6, r7, r2)
        L58:
            java.lang.String r0 = r5.d()
            if (r0 == 0) goto L6a
            android.text.style.TypefaceSpan r0 = new android.text.style.TypefaceSpan
            java.lang.String r1 = r5.d()
            r0.<init>(r1)
            y1.d.a(r4, r0, r6, r7, r2)
        L6a:
            int r0 = r5.f()
            r1 = 1
            if (r0 == r1) goto L8f
            r1 = 2
            if (r0 == r1) goto L85
            r1 = 3
            if (r0 == r1) goto L78
            goto L9c
        L78:
            android.text.style.RelativeSizeSpan r0 = new android.text.style.RelativeSizeSpan
            float r1 = r5.e()
            r3 = 1120403456(0x42c80000, float:100.0)
            float r1 = r1 / r3
            r0.<init>(r1)
            goto L99
        L85:
            android.text.style.RelativeSizeSpan r0 = new android.text.style.RelativeSizeSpan
            float r1 = r5.e()
            r0.<init>(r1)
            goto L99
        L8f:
            android.text.style.AbsoluteSizeSpan r0 = new android.text.style.AbsoluteSizeSpan
            float r3 = r5.e()
            int r3 = (int) r3
            r0.<init>(r3, r1)
        L99:
            y1.d.a(r4, r0, r6, r7, r2)
        L9c:
            boolean r5 = r5.b()
            if (r5 == 0) goto Laa
            y1.a r5 = new y1.a
            r5.<init>()
            r4.setSpan(r5, r6, r7, r2)
        Laa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d2.f.e(android.text.SpannableStringBuilder, d2.d, int, int):void");
    }

    private static int f(String str, int i6) {
        int indexOf = str.indexOf(62, i6);
        return indexOf == -1 ? str.length() : indexOf + 1;
    }

    private static int g(int i6, int i7, int i8) {
        if (i6 != -1) {
            return i6;
        }
        if (i7 != -1) {
            return i7;
        }
        if (i8 != -1) {
            return i8;
        }
        throw new IllegalArgumentException();
    }

    private static List<d> h(List<d2.d> list, String str, c cVar) {
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < list.size(); i6++) {
            d2.d dVar = list.get(i6);
            int h6 = dVar.h(str, cVar.f2957a, cVar.f2960d, cVar.f2959c);
            if (h6 > 0) {
                arrayList.add(new d(h6, dVar));
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private static int i(List<d2.d> list, String str, c cVar) {
        List<d> h6 = h(list, str, cVar);
        for (int i6 = 0; i6 < h6.size(); i6++) {
            d2.d dVar = h6.get(i6).f2962b;
            if (dVar.g() != -1) {
                return dVar.g();
            }
        }
        return -1;
    }

    private static String j(String str) {
        String trim = str.trim();
        i2.a.a(!trim.isEmpty());
        return c1.V0(trim, "[ \\.]")[0];
    }

    private static boolean k(String str) {
        str.hashCode();
        switch (str) {
            case "b":
            case "c":
            case "i":
            case "u":
            case "v":
            case "rt":
            case "lang":
            case "ruby":
                return true;
            default:
                return false;
        }
    }

    static u1.b l(CharSequence charSequence) {
        e eVar = new e();
        eVar.f2965c = charSequence;
        return eVar.g().a();
    }

    public static d2.e m(i0 i0Var, List<d2.d> list) {
        String q6 = i0Var.q();
        if (q6 == null) {
            return null;
        }
        Pattern pattern = f2950a;
        Matcher matcher = pattern.matcher(q6);
        if (matcher.matches()) {
            return n(null, matcher, i0Var, list);
        }
        String q7 = i0Var.q();
        if (q7 == null) {
            return null;
        }
        Matcher matcher2 = pattern.matcher(q7);
        if (matcher2.matches()) {
            return n(q6.trim(), matcher2, i0Var, list);
        }
        return null;
    }

    private static d2.e n(String str, Matcher matcher, i0 i0Var, List<d2.d> list) {
        e eVar = new e();
        try {
            eVar.f2963a = i.d((String) i2.a.e(matcher.group(1)));
            eVar.f2964b = i.d((String) i2.a.e(matcher.group(2)));
            p((String) i2.a.e(matcher.group(3)), eVar);
            StringBuilder sb = new StringBuilder();
            while (true) {
                String q6 = i0Var.q();
                if (TextUtils.isEmpty(q6)) {
                    eVar.f2965c = q(str, sb.toString(), list);
                    return eVar.a();
                }
                if (sb.length() > 0) {
                    sb.append("\n");
                }
                sb.append(q6.trim());
            }
        } catch (NumberFormatException unused) {
            t.i("WebvttCueParser", "Skipping cue with bad header: " + matcher.group());
            return null;
        }
    }

    static b.C0148b o(String str) {
        e eVar = new e();
        p(str, eVar);
        return eVar.g();
    }

    private static void p(String str, e eVar) {
        Matcher matcher = f2951b.matcher(str);
        while (matcher.find()) {
            String str2 = (String) i2.a.e(matcher.group(1));
            String str3 = (String) i2.a.e(matcher.group(2));
            try {
                if ("line".equals(str2)) {
                    s(str3, eVar);
                } else if ("align".equals(str2)) {
                    eVar.f2966d = v(str3);
                } else if ("position".equals(str2)) {
                    u(str3, eVar);
                } else if ("size".equals(str2)) {
                    eVar.f2972j = i.c(str3);
                } else if ("vertical".equals(str2)) {
                    eVar.f2973k = w(str3);
                } else {
                    t.i("WebvttCueParser", "Unknown cue setting " + str2 + ":" + str3);
                }
            } catch (NumberFormatException unused) {
                t.i("WebvttCueParser", "Skipping bad cue setting: " + matcher.group());
            }
        }
    }

    static SpannedString q(String str, String str2, List<d2.d> list) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ArrayDeque arrayDeque = new ArrayDeque();
        ArrayList arrayList = new ArrayList();
        int i6 = 0;
        while (i6 < str2.length()) {
            char charAt = str2.charAt(i6);
            if (charAt == '&') {
                i6++;
                int indexOf = str2.indexOf(59, i6);
                int indexOf2 = str2.indexOf(32, i6);
                if (indexOf == -1) {
                    indexOf = indexOf2;
                } else if (indexOf2 != -1) {
                    indexOf = Math.min(indexOf, indexOf2);
                }
                if (indexOf != -1) {
                    b(str2.substring(i6, indexOf), spannableStringBuilder);
                    if (indexOf == indexOf2) {
                        spannableStringBuilder.append((CharSequence) " ");
                    }
                    i6 = indexOf + 1;
                } else {
                    spannableStringBuilder.append(charAt);
                }
            } else if (charAt != '<') {
                spannableStringBuilder.append(charAt);
                i6++;
            } else {
                int i7 = i6 + 1;
                if (i7 < str2.length()) {
                    boolean z5 = str2.charAt(i7) == '/';
                    i7 = f(str2, i7);
                    int i8 = i7 - 2;
                    boolean z6 = str2.charAt(i8) == '/';
                    int i9 = i6 + (z5 ? 2 : 1);
                    if (!z6) {
                        i8 = i7 - 1;
                    }
                    String substring = str2.substring(i9, i8);
                    if (!substring.trim().isEmpty()) {
                        String j6 = j(substring);
                        if (k(j6)) {
                            if (z5) {
                                while (!arrayDeque.isEmpty()) {
                                    c cVar = (c) arrayDeque.pop();
                                    d(str, cVar, arrayList, spannableStringBuilder, list);
                                    if (arrayDeque.isEmpty()) {
                                        arrayList.clear();
                                    } else {
                                        arrayList.add(new b(cVar, spannableStringBuilder.length()));
                                    }
                                    if (cVar.f2957a.equals(j6)) {
                                        break;
                                    }
                                }
                            } else if (!z6) {
                                arrayDeque.push(c.a(substring, spannableStringBuilder.length()));
                            }
                        }
                    }
                }
                i6 = i7;
            }
        }
        while (!arrayDeque.isEmpty()) {
            d(str, (c) arrayDeque.pop(), arrayList, spannableStringBuilder, list);
        }
        d(str, c.b(), Collections.emptyList(), spannableStringBuilder, list);
        return SpannedString.valueOf(spannableStringBuilder);
    }

    private static int r(String str) {
        str.hashCode();
        switch (str) {
            case "center":
            case "middle":
                return 1;
            case "end":
                return 2;
            case "start":
                return 0;
            default:
                t.i("WebvttCueParser", "Invalid anchor value: " + str);
                return Integer.MIN_VALUE;
        }
    }

    private static void s(String str, e eVar) {
        int indexOf = str.indexOf(44);
        if (indexOf != -1) {
            eVar.f2969g = r(str.substring(indexOf + 1));
            str = str.substring(0, indexOf);
        }
        if (str.endsWith("%")) {
            eVar.f2967e = i.c(str);
            eVar.f2968f = 0;
        } else {
            eVar.f2967e = Integer.parseInt(str);
            eVar.f2968f = 1;
        }
    }

    private static int t(String str) {
        str.hashCode();
        switch (str) {
            case "line-left":
            case "start":
                return 0;
            case "center":
            case "middle":
                return 1;
            case "line-right":
            case "end":
                return 2;
            default:
                t.i("WebvttCueParser", "Invalid anchor value: " + str);
                return Integer.MIN_VALUE;
        }
    }

    private static void u(String str, e eVar) {
        int indexOf = str.indexOf(44);
        if (indexOf != -1) {
            eVar.f2971i = t(str.substring(indexOf + 1));
            str = str.substring(0, indexOf);
        }
        eVar.f2970h = i.c(str);
    }

    private static int v(String str) {
        str.hashCode();
        switch (str) {
            case "center":
            case "middle":
                return 2;
            case "end":
                return 3;
            case "left":
                return 4;
            case "right":
                return 5;
            case "start":
                return 1;
            default:
                t.i("WebvttCueParser", "Invalid alignment value: " + str);
                return 2;
        }
    }

    private static int w(String str) {
        str.hashCode();
        if (str.equals("lr")) {
            return 2;
        }
        if (str.equals("rl")) {
            return 1;
        }
        t.i("WebvttCueParser", "Invalid 'vertical' value: " + str);
        return Integer.MIN_VALUE;
    }
}
