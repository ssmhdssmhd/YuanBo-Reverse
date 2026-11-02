package x3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import y3.k;

/* loaded from: classes.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public final y3.k f10500a;

    /* renamed from: b, reason: collision with root package name */
    private h f10501b;

    /* renamed from: c, reason: collision with root package name */
    final k.c f10502c;

    class a implements k.c {
        a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x0120 A[Catch: JSONException -> 0x0213, TryCatch #7 {JSONException -> 0x0213, blocks: (B:7:0x002b, B:8:0x002f, B:13:0x00c4, B:15:0x00c9, B:16:0x00dd, B:18:0x00e2, B:19:0x00f1, B:21:0x00f6, B:28:0x00fa, B:24:0x0114, B:26:0x0120, B:30:0x00ff, B:31:0x0129, B:32:0x0155, B:33:0x015f, B:49:0x01df, B:35:0x01f9, B:65:0x014c, B:40:0x0150, B:59:0x0182, B:71:0x01a0, B:47:0x01bc, B:77:0x01d9, B:53:0x01f3, B:39:0x020d, B:78:0x0034, B:81:0x003f, B:84:0x004a, B:87:0x0056, B:90:0x0061, B:93:0x006b, B:96:0x0076, B:99:0x0080, B:102:0x008a, B:105:0x0094, B:108:0x009e, B:111:0x00a8, B:114:0x00b3, B:43:0x01a5), top: B:6:0x002b, inners: #2, #3, #5, #10 }] */
        @Override // y3.k.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void e(y3.j r6, y3.k.d r7) {
            /*
                Method dump skipped, instructions count: 642
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: x3.i.a.e(y3.j, y3.k$d):void");
        }
    }

    static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f10504a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f10505b;

        /* renamed from: c, reason: collision with root package name */
        static final /* synthetic */ int[] f10506c;

        static {
            int[] iArr = new int[k.values().length];
            f10506c = iArr;
            try {
                iArr[k.LEAN_BACK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10506c[k.IMMERSIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10506c[k.IMMERSIVE_STICKY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10506c[k.EDGE_TO_EDGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[l.values().length];
            f10505b = iArr2;
            try {
                iArr2[l.TOP_OVERLAYS.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f10505b[l.BOTTOM_OVERLAYS.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr3 = new int[f.values().length];
            f10504a = iArr3;
            try {
                iArr3[f.PORTRAIT_UP.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f10504a[f.PORTRAIT_DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f10504a[f.LANDSCAPE_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f10504a[f.LANDSCAPE_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final int f10507a;

        /* renamed from: b, reason: collision with root package name */
        public final String f10508b;

        public c(int i6, String str) {
            this.f10507a = i6;
            this.f10508b = str;
        }
    }

    public enum d {
        LIGHT("Brightness.light"),
        DARK("Brightness.dark");


        /* renamed from: a, reason: collision with root package name */
        private String f10512a;

        d(String str) {
            this.f10512a = str;
        }

        static d a(String str) {
            for (d dVar : values()) {
                if (dVar.f10512a.equals(str)) {
                    return dVar;
                }
            }
            throw new NoSuchFieldException("No such Brightness: " + str);
        }
    }

    public enum e {
        PLAIN_TEXT("text/plain");


        /* renamed from: a, reason: collision with root package name */
        private String f10515a;

        e(String str) {
            this.f10515a = str;
        }

        static e a(String str) {
            for (e eVar : values()) {
                if (eVar.f10515a.equals(str)) {
                    return eVar;
                }
            }
            throw new NoSuchFieldException("No such ClipboardContentFormat: " + str);
        }
    }

    public enum f {
        PORTRAIT_UP("DeviceOrientation.portraitUp"),
        PORTRAIT_DOWN("DeviceOrientation.portraitDown"),
        LANDSCAPE_LEFT("DeviceOrientation.landscapeLeft"),
        LANDSCAPE_RIGHT("DeviceOrientation.landscapeRight");


        /* renamed from: a, reason: collision with root package name */
        private String f10521a;

        f(String str) {
            this.f10521a = str;
        }

        static f a(String str) {
            for (f fVar : values()) {
                if (fVar.f10521a.equals(str)) {
                    return fVar;
                }
            }
            throw new NoSuchFieldException("No such DeviceOrientation: " + str);
        }
    }

    public enum g {
        STANDARD(null),
        LIGHT_IMPACT("HapticFeedbackType.lightImpact"),
        MEDIUM_IMPACT("HapticFeedbackType.mediumImpact"),
        HEAVY_IMPACT("HapticFeedbackType.heavyImpact"),
        SELECTION_CLICK("HapticFeedbackType.selectionClick");


        /* renamed from: a, reason: collision with root package name */
        private final String f10528a;

        g(String str) {
            this.f10528a = str;
        }

        static g a(String str) {
            for (g gVar : values()) {
                String str2 = gVar.f10528a;
                if ((str2 == null && str == null) || (str2 != null && str2.equals(str))) {
                    return gVar;
                }
            }
            throw new NoSuchFieldException("No such HapticFeedbackType: " + str);
        }
    }

    public interface h {
        void a(EnumC0166i enumC0166i);

        void b();

        CharSequence c(e eVar);

        void d(k kVar);

        void e(List<l> list);

        void f(j jVar);

        void g();

        void h();

        void i(String str);

        void j(g gVar);

        void k(c cVar);

        void l(int i6);

        boolean m();
    }

    /* renamed from: x3.i$i, reason: collision with other inner class name */
    public enum EnumC0166i {
        CLICK("SystemSoundType.click"),
        ALERT("SystemSoundType.alert");


        /* renamed from: a, reason: collision with root package name */
        private final String f10532a;

        EnumC0166i(String str) {
            this.f10532a = str;
        }

        static EnumC0166i a(String str) {
            for (EnumC0166i enumC0166i : values()) {
                if (enumC0166i.f10532a.equals(str)) {
                    return enumC0166i;
                }
            }
            throw new NoSuchFieldException("No such SoundType: " + str);
        }
    }

    public static class j {

        /* renamed from: a, reason: collision with root package name */
        public final Integer f10533a;

        /* renamed from: b, reason: collision with root package name */
        public final d f10534b;

        /* renamed from: c, reason: collision with root package name */
        public final Boolean f10535c;

        /* renamed from: d, reason: collision with root package name */
        public final Integer f10536d;

        /* renamed from: e, reason: collision with root package name */
        public final d f10537e;

        /* renamed from: f, reason: collision with root package name */
        public final Integer f10538f;

        /* renamed from: g, reason: collision with root package name */
        public final Boolean f10539g;

        public j(Integer num, d dVar, Boolean bool, Integer num2, d dVar2, Integer num3, Boolean bool2) {
            this.f10533a = num;
            this.f10534b = dVar;
            this.f10535c = bool;
            this.f10536d = num2;
            this.f10537e = dVar2;
            this.f10538f = num3;
            this.f10539g = bool2;
        }
    }

    public enum k {
        LEAN_BACK("SystemUiMode.leanBack"),
        IMMERSIVE("SystemUiMode.immersive"),
        IMMERSIVE_STICKY("SystemUiMode.immersiveSticky"),
        EDGE_TO_EDGE("SystemUiMode.edgeToEdge");


        /* renamed from: a, reason: collision with root package name */
        private String f10545a;

        k(String str) {
            this.f10545a = str;
        }

        static k a(String str) {
            for (k kVar : values()) {
                if (kVar.f10545a.equals(str)) {
                    return kVar;
                }
            }
            throw new NoSuchFieldException("No such SystemUiMode: " + str);
        }
    }

    public enum l {
        TOP_OVERLAYS("SystemUiOverlay.top"),
        BOTTOM_OVERLAYS("SystemUiOverlay.bottom");


        /* renamed from: a, reason: collision with root package name */
        private String f10549a;

        l(String str) {
            this.f10549a = str;
        }

        static l a(String str) {
            for (l lVar : values()) {
                if (lVar.f10549a.equals(str)) {
                    return lVar;
                }
            }
            throw new NoSuchFieldException("No such SystemUiOverlay: " + str);
        }
    }

    public i(m3.a aVar) {
        a aVar2 = new a();
        this.f10502c = aVar2;
        y3.k kVar = new y3.k(aVar, "flutter/platform", y3.g.f11099a);
        this.f10500a = kVar;
        kVar.e(aVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c g(JSONObject jSONObject) {
        int i6 = jSONObject.getInt("primaryColor");
        if (i6 != 0) {
            i6 |= -16777216;
        }
        return new c(i6, jSONObject.getString("label"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0053 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int h(org.json.JSONArray r10) {
        /*
            r9 = this;
            r0 = 0
            r1 = 0
            r2 = 0
            r3 = 0
        L4:
            int r4 = r10.length()
            r5 = 4
            r6 = 2
            r7 = 1
            if (r1 >= r4) goto L38
            java.lang.String r4 = r10.getString(r1)
            x3.i$f r4 = x3.i.f.a(r4)
            int[] r8 = x3.i.b.f10504a
            int r4 = r4.ordinal()
            r4 = r8[r4]
            if (r4 == r7) goto L30
            if (r4 == r6) goto L2d
            r6 = 3
            if (r4 == r6) goto L2a
            if (r4 == r5) goto L27
            goto L32
        L27:
            r2 = r2 | 8
            goto L32
        L2a:
            r2 = r2 | 2
            goto L32
        L2d:
            r2 = r2 | 4
            goto L32
        L30:
            r2 = r2 | 1
        L32:
            if (r3 != 0) goto L35
            r3 = r2
        L35:
            int r1 = r1 + 1
            goto L4
        L38:
            if (r2 == 0) goto L57
            r10 = 9
            r1 = 8
            switch(r2) {
                case 2: goto L56;
                case 3: goto L4d;
                case 4: goto L4c;
                case 5: goto L4a;
                case 6: goto L4d;
                case 7: goto L4d;
                case 8: goto L49;
                case 9: goto L4d;
                case 10: goto L46;
                case 11: goto L45;
                case 12: goto L4d;
                case 13: goto L4d;
                case 14: goto L4d;
                case 15: goto L42;
                default: goto L41;
            }
        L41:
            goto L53
        L42:
            r10 = 13
            return r10
        L45:
            return r6
        L46:
            r10 = 11
            return r10
        L49:
            return r1
        L4a:
            r10 = 12
        L4c:
            return r10
        L4d:
            if (r3 == r6) goto L56
            if (r3 == r5) goto L55
            if (r3 == r1) goto L54
        L53:
            return r7
        L54:
            return r1
        L55:
            return r10
        L56:
            return r0
        L57:
            r10 = -1
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: x3.i.h(org.json.JSONArray):int");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public j i(JSONObject jSONObject) {
        return new j(!jSONObject.isNull("statusBarColor") ? Integer.valueOf(jSONObject.getInt("statusBarColor")) : null, !jSONObject.isNull("statusBarIconBrightness") ? d.a(jSONObject.getString("statusBarIconBrightness")) : null, !jSONObject.isNull("systemStatusBarContrastEnforced") ? Boolean.valueOf(jSONObject.getBoolean("systemStatusBarContrastEnforced")) : null, !jSONObject.isNull("systemNavigationBarColor") ? Integer.valueOf(jSONObject.getInt("systemNavigationBarColor")) : null, !jSONObject.isNull("systemNavigationBarIconBrightness") ? d.a(jSONObject.getString("systemNavigationBarIconBrightness")) : null, !jSONObject.isNull("systemNavigationBarDividerColor") ? Integer.valueOf(jSONObject.getInt("systemNavigationBarDividerColor")) : null, jSONObject.isNull("systemNavigationBarContrastEnforced") ? null : Boolean.valueOf(jSONObject.getBoolean("systemNavigationBarContrastEnforced")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public k j(String str) {
        int i6 = b.f10506c[k.a(str).ordinal()];
        return i6 != 1 ? i6 != 2 ? i6 != 3 ? i6 != 4 ? k.EDGE_TO_EDGE : k.EDGE_TO_EDGE : k.IMMERSIVE_STICKY : k.IMMERSIVE : k.LEAN_BACK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<l> k(JSONArray jSONArray) {
        l lVar;
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < jSONArray.length(); i6++) {
            int i7 = b.f10505b[l.a(jSONArray.getString(i6)).ordinal()];
            if (i7 == 1) {
                lVar = l.TOP_OVERLAYS;
            } else if (i7 == 2) {
                lVar = l.BOTTOM_OVERLAYS;
            }
            arrayList.add(lVar);
        }
        return arrayList;
    }

    public void l(h hVar) {
        this.f10501b = hVar;
    }

    public void m(boolean z5) {
        k3.b.f("PlatformChannel", "Sending 'systemUIChange' message.");
        this.f10500a.c("SystemChrome.systemUIChange", Arrays.asList(Boolean.valueOf(z5)));
    }
}
