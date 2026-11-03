package b2;

import android.text.Layout;
import com.tendcloud.tenddata.cs;
import i2.c1;
import i2.d1;
import i2.t;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import u1.j;

/* loaded from: classes.dex */
public final class c extends u1.g {

    /* renamed from: p, reason: collision with root package name */
    private static final Pattern f1715p = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");

    /* renamed from: q, reason: collision with root package name */
    private static final Pattern f1716q = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");

    /* renamed from: r, reason: collision with root package name */
    private static final Pattern f1717r = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");

    /* renamed from: s, reason: collision with root package name */
    static final Pattern f1718s = Pattern.compile("^([-+]?\\d+\\.?\\d*?)%$");

    /* renamed from: t, reason: collision with root package name */
    static final Pattern f1719t = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");

    /* renamed from: u, reason: collision with root package name */
    private static final Pattern f1720u = Pattern.compile("^(\\d+\\.?\\d*?)px (\\d+\\.?\\d*?)px$");

    /* renamed from: v, reason: collision with root package name */
    private static final Pattern f1721v = Pattern.compile("^(\\d+) (\\d+)$");

    /* renamed from: w, reason: collision with root package name */
    private static final b f1722w = new b(30.0f, 1, 1);

    /* renamed from: x, reason: collision with root package name */
    private static final a f1723x = new a(32, 15);

    /* renamed from: o, reason: collision with root package name */
    private final XmlPullParserFactory f1724o;

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        final int f1725a;

        /* renamed from: b, reason: collision with root package name */
        final int f1726b;

        a(int i6, int i7) {
            this.f1725a = i6;
            this.f1726b = i7;
        }
    }

    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        final float f1727a;

        /* renamed from: b, reason: collision with root package name */
        final int f1728b;

        /* renamed from: c, reason: collision with root package name */
        final int f1729c;

        b(float f6, int i6, int i7) {
            this.f1727a = f6;
            this.f1728b = i6;
            this.f1729c = i7;
        }
    }

    /* renamed from: b2.c$c, reason: collision with other inner class name */
    private static final class C0038c {

        /* renamed from: a, reason: collision with root package name */
        final int f1730a;

        /* renamed from: b, reason: collision with root package name */
        final int f1731b;

        C0038c(int i6, int i7) {
            this.f1730a = i6;
            this.f1731b = i7;
        }
    }

    public c() {
        super("TtmlDecoder");
        try {
            XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
            this.f1724o = newInstance;
            newInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e6) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e6);
        }
    }

    private static g C(g gVar) {
        return gVar == null ? new g() : gVar;
    }

    private static boolean D(String str) {
        return str.equals("tt") || str.equals("head") || str.equals("body") || str.equals("div") || str.equals("p") || str.equals("span") || str.equals("br") || str.equals("style") || str.equals("styling") || str.equals("layout") || str.equals("region") || str.equals("metadata") || str.equals("image") || str.equals(cs.a.DATA) || str.equals("information");
    }

    private static Layout.Alignment E(String str) {
        String e6 = l2.b.e(str);
        e6.hashCode();
        switch (e6) {
            case "center":
                return Layout.Alignment.ALIGN_CENTER;
            case "end":
            case "right":
                return Layout.Alignment.ALIGN_OPPOSITE;
            case "left":
            case "start":
                return Layout.Alignment.ALIGN_NORMAL;
            default:
                return null;
        }
    }

    private static a F(XmlPullParser xmlPullParser, a aVar) {
        StringBuilder sb;
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "cellResolution");
        if (attributeValue == null) {
            return aVar;
        }
        Matcher matcher = f1721v.matcher(attributeValue);
        if (matcher.matches()) {
            try {
                int parseInt = Integer.parseInt((String) i2.a.e(matcher.group(1)));
                int parseInt2 = Integer.parseInt((String) i2.a.e(matcher.group(2)));
                if (parseInt != 0 && parseInt2 != 0) {
                    return new a(parseInt, parseInt2);
                }
                throw new j("Invalid cell resolution " + parseInt + " " + parseInt2);
            } catch (NumberFormatException unused) {
                sb = new StringBuilder();
            }
        } else {
            sb = new StringBuilder();
        }
        sb.append("Ignoring malformed cell resolution: ");
        sb.append(attributeValue);
        t.i("TtmlDecoder", sb.toString());
        return aVar;
    }

    private static void G(String str, g gVar) {
        Matcher matcher;
        String str2;
        String[] U0 = c1.U0(str, "\\s+");
        if (U0.length == 1) {
            matcher = f1717r.matcher(str);
        } else {
            if (U0.length != 2) {
                throw new j("Invalid number of entries for fontSize: " + U0.length + ".");
            }
            matcher = f1717r.matcher(U0[1]);
            t.i("TtmlDecoder", "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
        }
        if (!matcher.matches()) {
            throw new j("Invalid expression for fontSize: '" + str + "'.");
        }
        str2 = (String) i2.a.e(matcher.group(3));
        str2.hashCode();
        switch (str2) {
            case "%":
                gVar.z(3);
                break;
            case "em":
                gVar.z(2);
                break;
            case "px":
                gVar.z(1);
                break;
            default:
                throw new j("Invalid unit for fontSize: '" + str2 + "'.");
        }
        gVar.y(Float.parseFloat((String) i2.a.e(matcher.group(1))));
    }

    private static b H(XmlPullParser xmlPullParser) {
        float f6;
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRate");
        int parseInt = attributeValue != null ? Integer.parseInt(attributeValue) : 30;
        String attributeValue2 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRateMultiplier");
        if (attributeValue2 != null) {
            if (c1.U0(attributeValue2, " ").length != 2) {
                throw new j("frameRateMultiplier doesn't have 2 parts");
            }
            f6 = Integer.parseInt(r2[0]) / Integer.parseInt(r2[1]);
        } else {
            f6 = 1.0f;
        }
        b bVar = f1722w;
        int i6 = bVar.f1728b;
        String attributeValue3 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "subFrameRate");
        if (attributeValue3 != null) {
            i6 = Integer.parseInt(attributeValue3);
        }
        int i7 = bVar.f1729c;
        String attributeValue4 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "tickRate");
        if (attributeValue4 != null) {
            i7 = Integer.parseInt(attributeValue4);
        }
        return new b(parseInt * f6, i6, i7);
    }

    private static Map<String, g> I(XmlPullParser xmlPullParser, Map<String, g> map, a aVar, C0038c c0038c, Map<String, e> map2, Map<String, String> map3) {
        do {
            xmlPullParser.next();
            if (d1.f(xmlPullParser, "style")) {
                String a6 = d1.a(xmlPullParser, "style");
                g N = N(xmlPullParser, new g());
                if (a6 != null) {
                    for (String str : O(a6)) {
                        N.a(map.get(str));
                    }
                }
                String g6 = N.g();
                if (g6 != null) {
                    map.put(g6, N);
                }
            } else if (d1.f(xmlPullParser, "region")) {
                e L = L(xmlPullParser, aVar, c0038c);
                if (L != null) {
                    map2.put(L.f1745a, L);
                }
            } else if (d1.f(xmlPullParser, "metadata")) {
                J(xmlPullParser, map3);
            }
        } while (!d1.d(xmlPullParser, "head"));
        return map;
    }

    private static void J(XmlPullParser xmlPullParser, Map<String, String> map) {
        String a6;
        do {
            xmlPullParser.next();
            if (d1.f(xmlPullParser, "image") && (a6 = d1.a(xmlPullParser, "id")) != null) {
                map.put(a6, xmlPullParser.nextText());
            }
        } while (!d1.d(xmlPullParser, "metadata"));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static d K(XmlPullParser xmlPullParser, d dVar, Map<String, e> map, b bVar) {
        long j6;
        long j7;
        char c6;
        int attributeCount = xmlPullParser.getAttributeCount();
        g N = N(xmlPullParser, null);
        String[] strArr = null;
        String str = null;
        String str2 = "";
        long j8 = -9223372036854775807L;
        long j9 = -9223372036854775807L;
        long j10 = -9223372036854775807L;
        for (int i6 = 0; i6 < attributeCount; i6++) {
            String attributeName = xmlPullParser.getAttributeName(i6);
            String attributeValue = xmlPullParser.getAttributeValue(i6);
            attributeName.hashCode();
            switch (attributeName.hashCode()) {
                case -934795532:
                    if (attributeName.equals("region")) {
                        c6 = 0;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 99841:
                    if (attributeName.equals("dur")) {
                        c6 = 1;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 100571:
                    if (attributeName.equals("end")) {
                        c6 = 2;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 93616297:
                    if (attributeName.equals("begin")) {
                        c6 = 3;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 109780401:
                    if (attributeName.equals("style")) {
                        c6 = 4;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 1292595405:
                    if (attributeName.equals("backgroundImage")) {
                        c6 = 5;
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
                    if (!map.containsKey(attributeValue)) {
                        break;
                    } else {
                        str2 = attributeValue;
                        continue;
                    }
                case 1:
                    j10 = P(attributeValue, bVar);
                    break;
                case 2:
                    j9 = P(attributeValue, bVar);
                    break;
                case 3:
                    j8 = P(attributeValue, bVar);
                    break;
                case 4:
                    String[] O = O(attributeValue);
                    if (O.length > 0) {
                        strArr = O;
                        break;
                    }
                    break;
                case 5:
                    if (attributeValue.startsWith("#")) {
                        str = attributeValue.substring(1);
                        break;
                    }
                    break;
            }
        }
        if (dVar != null) {
            long j11 = dVar.f1735d;
            j6 = -9223372036854775807L;
            if (j11 != -9223372036854775807L) {
                if (j8 != -9223372036854775807L) {
                    j8 += j11;
                }
                if (j9 != -9223372036854775807L) {
                    j9 += j11;
                }
            }
        } else {
            j6 = -9223372036854775807L;
        }
        long j12 = j8;
        if (j9 == j6) {
            if (j10 != j6) {
                j7 = j12 + j10;
            } else if (dVar != null) {
                long j13 = dVar.f1736e;
                if (j13 != j6) {
                    j7 = j13;
                }
            }
            return d.c(xmlPullParser.getName(), j12, j7, N, strArr, str2, str, dVar);
        }
        j7 = j9;
        return d.c(xmlPullParser.getName(), j12, j7, N, strArr, str2, str, dVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0186, code lost:
    
        if (r0.equals("tb") == false) goto L50;
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0159  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static b2.e L(org.xmlpull.v1.XmlPullParser r17, b2.c.a r18, b2.c.C0038c r19) {
        /*
            Method dump skipped, instructions count: 484
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b2.c.L(org.xmlpull.v1.XmlPullParser, b2.c$a, b2.c$c):b2.e");
    }

    private static float M(String str) {
        Matcher matcher = f1718s.matcher(str);
        if (!matcher.matches()) {
            t.i("TtmlDecoder", "Invalid value for shear: " + str);
            return Float.MAX_VALUE;
        }
        try {
            return Math.min(100.0f, Math.max(-100.0f, Float.parseFloat((String) i2.a.e(matcher.group(1)))));
        } catch (NumberFormatException e6) {
            t.j("TtmlDecoder", "Failed to parse shear: " + str, e6);
            return Float.MAX_VALUE;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x01c4, code lost:
    
        if (r3.equals("text") == false) goto L101;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static b2.g N(org.xmlpull.v1.XmlPullParser r12, b2.g r13) {
        /*
            Method dump skipped, instructions count: 900
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b2.c.N(org.xmlpull.v1.XmlPullParser, b2.g):b2.g");
    }

    private static String[] O(String str) {
        String trim = str.trim();
        return trim.isEmpty() ? new String[0] : c1.U0(trim, "\\s+");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00bf, code lost:
    
        if (r13.equals("ms") == false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static long P(java.lang.String r13, b2.c.b r14) {
        /*
            Method dump skipped, instructions count: 330
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b2.c.P(java.lang.String, b2.c$b):long");
    }

    private static C0038c Q(XmlPullParser xmlPullParser) {
        StringBuilder sb;
        String str;
        String a6 = d1.a(xmlPullParser, "extent");
        if (a6 == null) {
            return null;
        }
        Matcher matcher = f1720u.matcher(a6);
        if (matcher.matches()) {
            try {
                return new C0038c(Integer.parseInt((String) i2.a.e(matcher.group(1))), Integer.parseInt((String) i2.a.e(matcher.group(2))));
            } catch (NumberFormatException unused) {
                sb = new StringBuilder();
                str = "Ignoring malformed tts extent: ";
            }
        } else {
            sb = new StringBuilder();
            str = "Ignoring non-pixel tts extent: ";
        }
        sb.append(str);
        sb.append(a6);
        t.i("TtmlDecoder", sb.toString());
        return null;
    }

    @Override // u1.g
    protected u1.h A(byte[] bArr, int i6, boolean z5) {
        b bVar;
        try {
            XmlPullParser newPullParser = this.f1724o.newPullParser();
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            HashMap hashMap3 = new HashMap();
            hashMap2.put("", new e(""));
            C0038c c0038c = null;
            newPullParser.setInput(new ByteArrayInputStream(bArr, 0, i6), null);
            ArrayDeque arrayDeque = new ArrayDeque();
            b bVar2 = f1722w;
            a aVar = f1723x;
            h hVar = null;
            int i7 = 0;
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.getEventType()) {
                d dVar = (d) arrayDeque.peek();
                if (i7 == 0) {
                    String name = newPullParser.getName();
                    if (eventType == 2) {
                        if ("tt".equals(name)) {
                            bVar2 = H(newPullParser);
                            aVar = F(newPullParser, f1723x);
                            c0038c = Q(newPullParser);
                        }
                        C0038c c0038c2 = c0038c;
                        b bVar3 = bVar2;
                        a aVar2 = aVar;
                        if (D(name)) {
                            if ("head".equals(name)) {
                                bVar = bVar3;
                                I(newPullParser, hashMap, aVar2, c0038c2, hashMap2, hashMap3);
                            } else {
                                bVar = bVar3;
                                try {
                                    d K = K(newPullParser, dVar, hashMap2, bVar);
                                    arrayDeque.push(K);
                                    if (dVar != null) {
                                        dVar.a(K);
                                    }
                                } catch (j e6) {
                                    t.j("TtmlDecoder", "Suppressing parser error", e6);
                                    i7++;
                                }
                            }
                            bVar2 = bVar;
                        } else {
                            t.f("TtmlDecoder", "Ignoring unsupported tag: " + newPullParser.getName());
                            i7++;
                            bVar2 = bVar3;
                        }
                        c0038c = c0038c2;
                        aVar = aVar2;
                    } else if (eventType == 4) {
                        ((d) i2.a.e(dVar)).a(d.d(newPullParser.getText()));
                    } else if (eventType == 3) {
                        if (newPullParser.getName().equals("tt")) {
                            hVar = new h((d) i2.a.e((d) arrayDeque.peek()), hashMap, hashMap2, hashMap3);
                        }
                        arrayDeque.pop();
                    }
                } else if (eventType == 2) {
                    i7++;
                } else if (eventType == 3) {
                    i7--;
                }
                newPullParser.next();
            }
            if (hVar != null) {
                return hVar;
            }
            throw new j("No TTML subtitles found");
        } catch (IOException e7) {
            throw new IllegalStateException("Unexpected error when reading input.", e7);
        } catch (XmlPullParserException e8) {
            throw new j("Unable to decode source", e8);
        }
    }
}
