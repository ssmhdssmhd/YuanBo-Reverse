package p1;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import android.util.Xml;
import g2.k0;
import h0.g3;
import h0.p;
import h0.y1;
import i2.c1;
import i2.d1;
import i2.t;
import i2.t0;
import i2.x;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import m0.m;
import m2.q;
import m2.w;
import org.xml.sax.helpers.DefaultHandler;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;
import p1.k;

/* loaded from: classes.dex */
public class d extends DefaultHandler implements k0.a<c> {

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f8558b = Pattern.compile("(\\d+)(?:/(\\d+))?");

    /* renamed from: c, reason: collision with root package name */
    private static final Pattern f8559c = Pattern.compile("CC([1-4])=.*");

    /* renamed from: d, reason: collision with root package name */
    private static final Pattern f8560d = Pattern.compile("([1-9]|[1-5][0-9]|6[0-3])=.*");

    /* renamed from: e, reason: collision with root package name */
    private static final int[] f8561e = {-1, 1, 2, 3, 4, 5, 6, 8, 2, 3, 4, 7, 8, 24, 8, 12, 10, 12, 14, 12, 14};

    /* renamed from: a, reason: collision with root package name */
    private final XmlPullParserFactory f8562a;

    protected static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final y1 f8563a;

        /* renamed from: b, reason: collision with root package name */
        public final q<b> f8564b;

        /* renamed from: c, reason: collision with root package name */
        public final k f8565c;

        /* renamed from: d, reason: collision with root package name */
        public final String f8566d;

        /* renamed from: e, reason: collision with root package name */
        public final ArrayList<m.b> f8567e;

        /* renamed from: f, reason: collision with root package name */
        public final ArrayList<e> f8568f;

        /* renamed from: g, reason: collision with root package name */
        public final long f8569g;

        /* renamed from: h, reason: collision with root package name */
        public final List<e> f8570h;

        /* renamed from: i, reason: collision with root package name */
        public final List<e> f8571i;

        public a(y1 y1Var, List<b> list, k kVar, String str, ArrayList<m.b> arrayList, ArrayList<e> arrayList2, List<e> list2, List<e> list3, long j6) {
            this.f8563a = y1Var;
            this.f8564b = q.m(list);
            this.f8565c = kVar;
            this.f8566d = str;
            this.f8567e = arrayList;
            this.f8568f = arrayList2;
            this.f8570h = list2;
            this.f8571i = list3;
            this.f8569g = j6;
        }
    }

    public d() {
        try {
            this.f8562a = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e6) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e6);
        }
    }

    protected static int D(List<e> list) {
        String str;
        for (int i6 = 0; i6 < list.size(); i6++) {
            e eVar = list.get(i6);
            if ("urn:scte:dash:cc:cea-608:2015".equals(eVar.f8572a) && (str = eVar.f8573b) != null) {
                Matcher matcher = f8559c.matcher(str);
                if (matcher.matches()) {
                    return Integer.parseInt(matcher.group(1));
                }
                t.i("MpdParser", "Unable to parse CEA-608 channel number from: " + eVar.f8573b);
            }
        }
        return -1;
    }

    protected static int E(List<e> list) {
        String str;
        for (int i6 = 0; i6 < list.size(); i6++) {
            e eVar = list.get(i6);
            if ("urn:scte:dash:cc:cea-708:2015".equals(eVar.f8572a) && (str = eVar.f8573b) != null) {
                Matcher matcher = f8560d.matcher(str);
                if (matcher.matches()) {
                    return Integer.parseInt(matcher.group(1));
                }
                t.i("MpdParser", "Unable to parse CEA-708 service block number from: " + eVar.f8573b);
            }
        }
        return -1;
    }

    protected static long H(XmlPullParser xmlPullParser, String str, long j6) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? j6 : c1.K0(attributeValue);
    }

    protected static e I(XmlPullParser xmlPullParser, String str) {
        String r02 = r0(xmlPullParser, "schemeIdUri", "");
        String r03 = r0(xmlPullParser, "value", null);
        String r04 = r0(xmlPullParser, "id", null);
        do {
            xmlPullParser.next();
        } while (!d1.d(xmlPullParser, str));
        return new e(r02, r03, r04);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected static int J(XmlPullParser xmlPullParser) {
        char c6;
        String attributeValue = xmlPullParser.getAttributeValue(null, "value");
        if (attributeValue == null) {
            return -1;
        }
        String e6 = l2.b.e(attributeValue);
        e6.hashCode();
        switch (e6.hashCode()) {
            case 1596796:
                if (e6.equals("4000")) {
                    c6 = 0;
                    break;
                }
                c6 = 65535;
                break;
            case 2937391:
                if (e6.equals("a000")) {
                    c6 = 1;
                    break;
                }
                c6 = 65535;
                break;
            case 3094035:
                if (e6.equals("f801")) {
                    c6 = 2;
                    break;
                }
                c6 = 65535;
                break;
            case 3133436:
                if (e6.equals("fa01")) {
                    c6 = 3;
                    break;
                }
                c6 = 65535;
                break;
            default:
                c6 = 65535;
                break;
        }
        switch (c6) {
        }
        return -1;
    }

    protected static int K(XmlPullParser xmlPullParser) {
        int U = U(xmlPullParser, "value", -1);
        if (U <= 0 || U >= 33) {
            return -1;
        }
        return U;
    }

    protected static int L(XmlPullParser xmlPullParser) {
        int bitCount;
        String attributeValue = xmlPullParser.getAttributeValue(null, "value");
        if (attributeValue == null || (bitCount = Integer.bitCount(Integer.parseInt(attributeValue, 16))) == 0) {
            return -1;
        }
        return bitCount;
    }

    protected static long M(XmlPullParser xmlPullParser, String str, long j6) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? j6 : c1.L0(attributeValue);
    }

    protected static String N(List<e> list) {
        for (int i6 = 0; i6 < list.size(); i6++) {
            e eVar = list.get(i6);
            String str = eVar.f8572a;
            if ("tag:dolby.com,2018:dash:EC3_ExtensionType:2018".equals(str) && "JOC".equals(eVar.f8573b)) {
                return "audio/eac3-joc";
            }
            if ("tag:dolby.com,2014:dash:DolbyDigitalPlusExtensionType:2014".equals(str) && "ec+3".equals(eVar.f8573b)) {
                return "audio/eac3-joc";
            }
        }
        return "audio/eac3";
    }

    protected static float R(XmlPullParser xmlPullParser, String str, float f6) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? f6 : Float.parseFloat(attributeValue);
    }

    protected static float S(XmlPullParser xmlPullParser, float f6) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "frameRate");
        if (attributeValue == null) {
            return f6;
        }
        Matcher matcher = f8558b.matcher(attributeValue);
        if (!matcher.matches()) {
            return f6;
        }
        int parseInt = Integer.parseInt(matcher.group(1));
        float f7 = parseInt;
        return !TextUtils.isEmpty(matcher.group(2)) ? f7 / Integer.parseInt(r2) : f7;
    }

    protected static int U(XmlPullParser xmlPullParser, String str, int i6) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? i6 : Integer.parseInt(attributeValue);
    }

    protected static long W(List<e> list) {
        for (int i6 = 0; i6 < list.size(); i6++) {
            e eVar = list.get(i6);
            if (l2.b.a("http://dashif.org/guidelines/last-segment-number", eVar.f8572a)) {
                return Long.parseLong(eVar.f8573b);
            }
        }
        return -1L;
    }

    protected static long X(XmlPullParser xmlPullParser, String str, long j6) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? j6 : Long.parseLong(attributeValue);
    }

    protected static int Z(XmlPullParser xmlPullParser) {
        int U = U(xmlPullParser, "value", -1);
        if (U < 0) {
            return -1;
        }
        int[] iArr = f8561e;
        if (U < iArr.length) {
            return iArr[U];
        }
        return -1;
    }

    private long b(List<k.d> list, long j6, long j7, int i6, long j8) {
        int m6 = i6 >= 0 ? i6 + 1 : (int) c1.m(j8 - j6, j7);
        for (int i7 = 0; i7 < m6; i7++) {
            list.add(m(j6, j7));
            j6 += j7;
        }
        return j6;
    }

    private static int p(int i6, int i7) {
        if (i6 == -1) {
            return i7;
        }
        if (i7 == -1) {
            return i6;
        }
        i2.a.g(i6 == i7);
        return i6;
    }

    private static String q(String str, String str2) {
        if (str == null) {
            return str2;
        }
        if (str2 == null) {
            return str;
        }
        i2.a.g(str.equals(str2));
        return str;
    }

    private static void r(ArrayList<m.b> arrayList) {
        String str;
        int i6 = 0;
        while (true) {
            if (i6 >= arrayList.size()) {
                str = null;
                break;
            }
            m.b bVar = arrayList.get(i6);
            if (p.f4773c.equals(bVar.f7855b) && (str = bVar.f7856c) != null) {
                arrayList.remove(i6);
                break;
            }
            i6++;
        }
        if (str == null) {
            return;
        }
        for (int i7 = 0; i7 < arrayList.size(); i7++) {
            m.b bVar2 = arrayList.get(i7);
            if (p.f4772b.equals(bVar2.f7855b) && bVar2.f7856c == null) {
                arrayList.set(i7, new m.b(p.f4773c, str, bVar2.f7857d, bVar2.f7858e));
            }
        }
    }

    protected static String r0(XmlPullParser xmlPullParser, String str, String str2) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? str2 : attributeValue;
    }

    private static void s(ArrayList<m.b> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            m.b bVar = arrayList.get(size);
            if (!bVar.f()) {
                int i6 = 0;
                while (true) {
                    if (i6 >= arrayList.size()) {
                        break;
                    }
                    if (arrayList.get(i6).d(bVar)) {
                        arrayList.remove(size);
                        break;
                    }
                    i6++;
                }
            }
        }
    }

    protected static String s0(XmlPullParser xmlPullParser, String str) {
        String str2 = "";
        do {
            xmlPullParser.next();
            if (xmlPullParser.getEventType() == 4) {
                str2 = xmlPullParser.getText();
            } else {
                w(xmlPullParser);
            }
        } while (!d1.d(xmlPullParser, str));
        return str2;
    }

    private static long t(long j6, long j7) {
        if (j7 != -9223372036854775807L) {
            j6 = j7;
        }
        if (j6 == Long.MAX_VALUE) {
            return -9223372036854775807L;
        }
        return j6;
    }

    private static String u(String str, String str2) {
        if (x.o(str)) {
            return x.c(str2);
        }
        if (x.s(str)) {
            return x.n(str2);
        }
        if (x.r(str) || x.p(str)) {
            return str;
        }
        if (!"application/mp4".equals(str)) {
            return null;
        }
        String g6 = x.g(str2);
        return "text/vtt".equals(g6) ? "application/x-mp4-vtt" : g6;
    }

    private boolean v(String[] strArr) {
        for (String str : strArr) {
            if (str.startsWith("urn:dvb:dash:profile:dvb-dash:")) {
                return true;
            }
        }
        return false;
    }

    public static void w(XmlPullParser xmlPullParser) {
        if (d1.e(xmlPullParser)) {
            int i6 = 1;
            while (i6 != 0) {
                xmlPullParser.next();
                if (d1.e(xmlPullParser)) {
                    i6++;
                } else if (d1.c(xmlPullParser)) {
                    i6--;
                }
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected int A(XmlPullParser xmlPullParser) {
        char c6;
        String r02 = r0(xmlPullParser, "schemeIdUri", null);
        r02.hashCode();
        int i6 = -1;
        switch (r02.hashCode()) {
            case -2128649360:
                if (r02.equals("urn:dts:dash:audio_channel_configuration:2012")) {
                    c6 = 0;
                    break;
                }
                c6 = 65535;
                break;
            case -1352850286:
                if (r02.equals("urn:mpeg:dash:23003:3:audio_channel_configuration:2011")) {
                    c6 = 1;
                    break;
                }
                c6 = 65535;
                break;
            case -1138141449:
                if (r02.equals("tag:dolby.com,2014:dash:audio_channel_configuration:2011")) {
                    c6 = 2;
                    break;
                }
                c6 = 65535;
                break;
            case -986633423:
                if (r02.equals("urn:mpeg:mpegB:cicp:ChannelConfiguration")) {
                    c6 = 3;
                    break;
                }
                c6 = 65535;
                break;
            case -79006963:
                if (r02.equals("tag:dts.com,2014:dash:audio_channel_configuration:2012")) {
                    c6 = 4;
                    break;
                }
                c6 = 65535;
                break;
            case 312179081:
                if (r02.equals("tag:dts.com,2018:uhd:audio_channel_configuration")) {
                    c6 = 5;
                    break;
                }
                c6 = 65535;
                break;
            case 2036691300:
                if (r02.equals("urn:dolby:dash:audio_channel_configuration:2011")) {
                    c6 = 6;
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
            case 4:
                i6 = K(xmlPullParser);
                break;
            case 1:
                i6 = U(xmlPullParser, "value", -1);
                break;
            case 2:
            case 6:
                i6 = J(xmlPullParser);
                break;
            case 3:
                i6 = Z(xmlPullParser);
                break;
            case 5:
                i6 = L(xmlPullParser);
                break;
        }
        do {
            xmlPullParser.next();
        } while (!d1.d(xmlPullParser, "AudioChannelConfiguration"));
        return i6;
    }

    protected long B(XmlPullParser xmlPullParser, long j6) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "availabilityTimeOffset");
        if (attributeValue == null) {
            return j6;
        }
        if ("INF".equals(attributeValue)) {
            return Long.MAX_VALUE;
        }
        return (long) (Float.parseFloat(attributeValue) * 1000000.0f);
    }

    protected List<b> C(XmlPullParser xmlPullParser, List<b> list, boolean z5) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "dvb:priority");
        int parseInt = attributeValue != null ? Integer.parseInt(attributeValue) : z5 ? 1 : Integer.MIN_VALUE;
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "dvb:weight");
        int parseInt2 = attributeValue2 != null ? Integer.parseInt(attributeValue2) : 1;
        String attributeValue3 = xmlPullParser.getAttributeValue(null, "serviceLocation");
        String s02 = s0(xmlPullParser, "BaseURL");
        if (t0.b(s02)) {
            if (attributeValue3 == null) {
                attributeValue3 = s02;
            }
            return w.j(new b(s02, attributeValue3, parseInt, parseInt2));
        }
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < list.size(); i6++) {
            b bVar = list.get(i6);
            String d6 = t0.d(bVar.f8541a, s02);
            String str = attributeValue3 == null ? d6 : attributeValue3;
            if (z5) {
                parseInt = bVar.f8543c;
                parseInt2 = bVar.f8544d;
                str = bVar.f8542b;
            }
            arrayList.add(new b(d6, str, parseInt, parseInt2));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00bb  */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.util.UUID] */
    /* JADX WARN: Type inference failed for: r3v12, types: [java.util.UUID] */
    /* JADX WARN: Type inference failed for: r3v13, types: [java.util.UUID] */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15, types: [java.util.UUID] */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v20, types: [java.util.UUID] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r4v10, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v26 */
    /* JADX WARN: Type inference failed for: r4v27 */
    /* JADX WARN: Type inference failed for: r4v28 */
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v30 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.util.UUID] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected android.util.Pair<java.lang.String, m0.m.b> F(org.xmlpull.v1.XmlPullParser r11) {
        /*
            Method dump skipped, instructions count: 324
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p1.d.F(org.xmlpull.v1.XmlPullParser):android.util.Pair");
    }

    protected int G(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "contentType");
        if (TextUtils.isEmpty(attributeValue)) {
            return -1;
        }
        if ("audio".equals(attributeValue)) {
            return 1;
        }
        if ("video".equals(attributeValue)) {
            return 2;
        }
        if ("text".equals(attributeValue)) {
            return 3;
        }
        return "image".equals(attributeValue) ? 4 : -1;
    }

    protected Pair<Long, d1.a> O(XmlPullParser xmlPullParser, String str, String str2, long j6, long j7, ByteArrayOutputStream byteArrayOutputStream) {
        long X = X(xmlPullParser, "id", 0L);
        long X2 = X(xmlPullParser, "duration", -9223372036854775807L);
        long X3 = X(xmlPullParser, "presentationTime", 0L);
        long P0 = c1.P0(X2, 1000L, j6);
        long P02 = c1.P0(X3 - j7, 1000000L, j6);
        String r02 = r0(xmlPullParser, "messageData", null);
        byte[] P = P(xmlPullParser, byteArrayOutputStream);
        Long valueOf = Long.valueOf(P02);
        if (r02 != null) {
            P = c1.n0(r02);
        }
        return Pair.create(valueOf, d(str, str2, X, P0, P));
    }

    protected byte[] P(XmlPullParser xmlPullParser, ByteArrayOutputStream byteArrayOutputStream) {
        byteArrayOutputStream.reset();
        XmlSerializer newSerializer = Xml.newSerializer();
        newSerializer.setOutput(byteArrayOutputStream, l2.d.f7489c.name());
        while (true) {
            xmlPullParser.nextToken();
            if (d1.d(xmlPullParser, "Event")) {
                newSerializer.flush();
                return byteArrayOutputStream.toByteArray();
            }
            switch (xmlPullParser.getEventType()) {
                case 0:
                    newSerializer.startDocument(null, Boolean.FALSE);
                    break;
                case 1:
                    newSerializer.endDocument();
                    break;
                case 2:
                    newSerializer.startTag(xmlPullParser.getNamespace(), xmlPullParser.getName());
                    for (int i6 = 0; i6 < xmlPullParser.getAttributeCount(); i6++) {
                        newSerializer.attribute(xmlPullParser.getAttributeNamespace(i6), xmlPullParser.getAttributeName(i6), xmlPullParser.getAttributeValue(i6));
                    }
                    break;
                case 3:
                    newSerializer.endTag(xmlPullParser.getNamespace(), xmlPullParser.getName());
                    break;
                case 4:
                    newSerializer.text(xmlPullParser.getText());
                    break;
                case 5:
                    newSerializer.cdsect(xmlPullParser.getText());
                    break;
                case 6:
                    newSerializer.entityRef(xmlPullParser.getText());
                    break;
                case 7:
                    newSerializer.ignorableWhitespace(xmlPullParser.getText());
                    break;
                case 8:
                    newSerializer.processingInstruction(xmlPullParser.getText());
                    break;
                case 9:
                    newSerializer.comment(xmlPullParser.getText());
                    break;
                case 10:
                    newSerializer.docdecl(xmlPullParser.getText());
                    break;
            }
        }
    }

    protected f Q(XmlPullParser xmlPullParser) {
        ByteArrayOutputStream byteArrayOutputStream;
        long j6;
        ArrayList arrayList;
        String r02 = r0(xmlPullParser, "schemeIdUri", "");
        String r03 = r0(xmlPullParser, "value", "");
        long X = X(xmlPullParser, "timescale", 1L);
        long X2 = X(xmlPullParser, "presentationTimeOffset", 0L);
        ArrayList arrayList2 = new ArrayList();
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(512);
        while (true) {
            xmlPullParser.next();
            if (d1.f(xmlPullParser, "Event")) {
                byteArrayOutputStream = byteArrayOutputStream2;
                long j7 = X2;
                j6 = X2;
                arrayList = arrayList2;
                arrayList.add(O(xmlPullParser, r02, r03, X, j7, byteArrayOutputStream));
            } else {
                byteArrayOutputStream = byteArrayOutputStream2;
                j6 = X2;
                arrayList = arrayList2;
                w(xmlPullParser);
            }
            if (d1.d(xmlPullParser, "EventStream")) {
                break;
            }
            arrayList2 = arrayList;
            byteArrayOutputStream2 = byteArrayOutputStream;
            X2 = j6;
        }
        long[] jArr = new long[arrayList.size()];
        d1.a[] aVarArr = new d1.a[arrayList.size()];
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            Pair pair = (Pair) arrayList.get(i6);
            jArr[i6] = ((Long) pair.first).longValue();
            aVarArr[i6] = (d1.a) pair.second;
        }
        return e(r02, r03, X, jArr, aVarArr);
    }

    protected i T(XmlPullParser xmlPullParser) {
        return d0(xmlPullParser, "sourceURL", "range");
    }

    protected String V(XmlPullParser xmlPullParser) {
        return s0(xmlPullParser, "Label");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x01e6 A[LOOP:0: B:18:0x00a4->B:26:0x01e6, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x01a2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01df  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected p1.c Y(org.xmlpull.v1.XmlPullParser r47, android.net.Uri r48) {
        /*
            Method dump skipped, instructions count: 499
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p1.d.Y(org.xmlpull.v1.XmlPullParser, android.net.Uri):p1.c");
    }

    protected Pair<g, Long> a0(XmlPullParser xmlPullParser, List<b> list, long j6, long j7, long j8, long j9, boolean z5) {
        long j10;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        Object obj;
        long j11;
        k l02;
        d dVar = this;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        Object obj2 = null;
        String attributeValue = xmlPullParser2.getAttributeValue(null, "id");
        long M = M(xmlPullParser2, "start", j6);
        long j12 = -9223372036854775807L;
        long j13 = j8 != -9223372036854775807L ? j8 + M : -9223372036854775807L;
        long M2 = M(xmlPullParser2, "duration", -9223372036854775807L);
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        long j14 = j7;
        long j15 = -9223372036854775807L;
        k kVar = null;
        e eVar = null;
        boolean z6 = false;
        while (true) {
            xmlPullParser.next();
            if (d1.f(xmlPullParser2, "BaseURL")) {
                if (!z6) {
                    j14 = dVar.B(xmlPullParser2, j14);
                    z6 = true;
                }
                arrayList6.addAll(dVar.C(xmlPullParser2, list, z5));
                arrayList3 = arrayList5;
                arrayList = arrayList6;
                j11 = j12;
                obj = obj2;
                arrayList2 = arrayList4;
            } else {
                if (d1.f(xmlPullParser2, "AdaptationSet")) {
                    j10 = j14;
                    arrayList = arrayList6;
                    arrayList2 = arrayList4;
                    arrayList2.add(y(xmlPullParser, !arrayList6.isEmpty() ? arrayList6 : list, kVar, M2, j14, j15, j13, j9, z5));
                    xmlPullParser2 = xmlPullParser;
                    arrayList3 = arrayList5;
                } else {
                    j10 = j14;
                    ArrayList arrayList7 = arrayList5;
                    arrayList = arrayList6;
                    arrayList2 = arrayList4;
                    xmlPullParser2 = xmlPullParser;
                    if (d1.f(xmlPullParser2, "EventStream")) {
                        arrayList7.add(Q(xmlPullParser));
                        arrayList3 = arrayList7;
                    } else {
                        arrayList3 = arrayList7;
                        if (d1.f(xmlPullParser2, "SegmentBase")) {
                            kVar = j0(xmlPullParser2, null);
                            obj = null;
                            j14 = j10;
                            j11 = -9223372036854775807L;
                        } else {
                            if (d1.f(xmlPullParser2, "SegmentList")) {
                                long B = B(xmlPullParser2, -9223372036854775807L);
                                obj = null;
                                l02 = k0(xmlPullParser, null, j13, M2, j10, B, j9);
                                j15 = B;
                                j14 = j10;
                                j11 = -9223372036854775807L;
                            } else {
                                obj = null;
                                if (d1.f(xmlPullParser2, "SegmentTemplate")) {
                                    long B2 = B(xmlPullParser2, -9223372036854775807L);
                                    j11 = -9223372036854775807L;
                                    l02 = l0(xmlPullParser, null, q.q(), j13, M2, j10, B2, j9);
                                    j15 = B2;
                                    j14 = j10;
                                } else {
                                    j11 = -9223372036854775807L;
                                    if (d1.f(xmlPullParser2, "AssetIdentifier")) {
                                        eVar = I(xmlPullParser2, "AssetIdentifier");
                                    } else {
                                        w(xmlPullParser);
                                    }
                                    j14 = j10;
                                }
                            }
                            kVar = l02;
                        }
                    }
                }
                obj = null;
                j11 = -9223372036854775807L;
                j14 = j10;
            }
            if (d1.d(xmlPullParser2, "Period")) {
                return Pair.create(h(attributeValue, M, arrayList2, arrayList3, eVar), Long.valueOf(M2));
            }
            arrayList4 = arrayList2;
            arrayList6 = arrayList;
            obj2 = obj;
            arrayList5 = arrayList3;
            j12 = j11;
            dVar = this;
        }
    }

    protected String[] b0(XmlPullParser xmlPullParser, String str, String[] strArr) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? strArr : attributeValue.split(",");
    }

    protected p1.a c(int i6, int i7, List<j> list, List<e> list2, List<e> list3, List<e> list4) {
        return new p1.a(i6, i7, list, list2, list3, list4);
    }

    protected h c0(XmlPullParser xmlPullParser) {
        String str = null;
        String r02 = r0(xmlPullParser, "moreInformationURL", null);
        String r03 = r0(xmlPullParser, "lang", null);
        String str2 = null;
        String str3 = null;
        while (true) {
            xmlPullParser.next();
            if (d1.f(xmlPullParser, "Title")) {
                str = xmlPullParser.nextText();
            } else if (d1.f(xmlPullParser, "Source")) {
                str2 = xmlPullParser.nextText();
            } else if (d1.f(xmlPullParser, "Copyright")) {
                str3 = xmlPullParser.nextText();
            } else {
                w(xmlPullParser);
            }
            String str4 = str3;
            if (d1.d(xmlPullParser, "ProgramInformation")) {
                return new h(str, str2, str4, r02, r03);
            }
            str3 = str4;
        }
    }

    protected d1.a d(String str, String str2, long j6, long j7, byte[] bArr) {
        return new d1.a(str, str2, j7, j6, bArr);
    }

    protected i d0(XmlPullParser xmlPullParser, String str, String str2) {
        long j6;
        long j7;
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        String attributeValue2 = xmlPullParser.getAttributeValue(null, str2);
        if (attributeValue2 != null) {
            String[] split = attributeValue2.split("-");
            j6 = Long.parseLong(split[0]);
            if (split.length == 2) {
                j7 = (Long.parseLong(split[1]) - j6) + 1;
                return i(attributeValue, j6, j7);
            }
        } else {
            j6 = 0;
        }
        j7 = -1;
        return i(attributeValue, j6, j7);
    }

    protected f e(String str, String str2, long j6, long[] jArr, d1.a[] aVarArr) {
        return new f(str, str2, j6, jArr, aVarArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x01ee A[LOOP:0: B:2:0x006a->B:11:0x01ee, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0198 A[EDGE_INSN: B:12:0x0198->B:13:0x0198 BREAK  A[LOOP:0: B:2:0x006a->B:11:0x01ee], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected p1.d.a e0(org.xmlpull.v1.XmlPullParser r36, java.util.List<p1.b> r37, java.lang.String r38, java.lang.String r39, int r40, int r41, float r42, int r43, int r44, java.lang.String r45, java.util.List<p1.e> r46, java.util.List<p1.e> r47, java.util.List<p1.e> r48, java.util.List<p1.e> r49, p1.k r50, long r51, long r53, long r55, long r57, long r59, boolean r61) {
        /*
            Method dump skipped, instructions count: 509
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p1.d.e0(org.xmlpull.v1.XmlPullParser, java.util.List, java.lang.String, java.lang.String, int, int, float, int, int, java.lang.String, java.util.List, java.util.List, java.util.List, java.util.List, p1.k, long, long, long, long, long, boolean):p1.d$a");
    }

    protected y1 f(String str, String str2, int i6, int i7, float f6, int i8, int i9, int i10, String str3, List<e> list, List<e> list2, String str4, List<e> list3, List<e> list4) {
        String str5 = str4;
        String u5 = u(str2, str5);
        if ("audio/eac3".equals(u5)) {
            u5 = N(list4);
            if ("audio/eac3-joc".equals(u5)) {
                str5 = "ec+3";
            }
        }
        int p02 = p0(list);
        int i02 = i0(list) | f0(list2) | h0(list3) | h0(list4);
        Pair<Integer, Integer> t02 = t0(list3);
        y1.b X = new y1.b().U(str).M(str2).g0(u5).K(str5).b0(i10).i0(p02).e0(i02).X(str3);
        int i11 = -1;
        y1.b m02 = X.l0(t02 != null ? ((Integer) t02.first).intValue() : -1).m0(t02 != null ? ((Integer) t02.second).intValue() : -1);
        if (x.s(u5)) {
            m02.n0(i6).S(i7).R(f6);
        } else if (x.o(u5)) {
            m02.J(i8).h0(i9);
        } else if (x.r(u5)) {
            if ("application/cea-608".equals(u5)) {
                i11 = D(list2);
            } else if ("application/cea-708".equals(u5)) {
                i11 = E(list2);
            }
            m02.H(i11);
        } else if (x.p(u5)) {
            m02.n0(i6).S(i7);
        }
        return m02.G();
    }

    protected int f0(List<e> list) {
        int u02;
        int i6 = 0;
        for (int i7 = 0; i7 < list.size(); i7++) {
            e eVar = list.get(i7);
            if (l2.b.a("urn:mpeg:dash:role:2011", eVar.f8572a)) {
                u02 = g0(eVar.f8573b);
            } else if (l2.b.a("urn:tva:metadata:cs:AudioPurposeCS:2007", eVar.f8572a)) {
                u02 = u0(eVar.f8573b);
            }
            i6 |= u02;
        }
        return i6;
    }

    protected c g(long j6, long j7, long j8, boolean z5, long j9, long j10, long j11, long j12, h hVar, o oVar, l lVar, Uri uri, List<g> list) {
        return new c(j6, j7, j8, z5, j9, j10, j11, j12, hVar, oVar, lVar, uri, list);
    }

    protected int g0(String str) {
        if (str == null) {
            return 0;
        }
        switch (str) {
        }
        return 0;
    }

    protected g h(String str, long j6, List<p1.a> list, List<f> list2, e eVar) {
        return new g(str, j6, list, list2, eVar);
    }

    protected int h0(List<e> list) {
        int i6 = 0;
        for (int i7 = 0; i7 < list.size(); i7++) {
            if (l2.b.a("http://dashif.org/guidelines/trickmode", list.get(i7).f8572a)) {
                i6 |= 16384;
            }
        }
        return i6;
    }

    protected i i(String str, long j6, long j7) {
        return new i(str, j6, j7);
    }

    protected int i0(List<e> list) {
        int i6 = 0;
        for (int i7 = 0; i7 < list.size(); i7++) {
            e eVar = list.get(i7);
            if (l2.b.a("urn:mpeg:dash:role:2011", eVar.f8572a)) {
                i6 |= g0(eVar.f8573b);
            }
        }
        return i6;
    }

    protected j j(a aVar, String str, String str2, ArrayList<m.b> arrayList, ArrayList<e> arrayList2) {
        y1.b b6 = aVar.f8563a.b();
        if (str != null) {
            b6.W(str);
        }
        String str3 = aVar.f8566d;
        if (str3 != null) {
            str2 = str3;
        }
        ArrayList<m.b> arrayList3 = aVar.f8567e;
        arrayList3.addAll(arrayList);
        if (!arrayList3.isEmpty()) {
            r(arrayList3);
            s(arrayList3);
            b6.O(new m0.m(str2, arrayList3));
        }
        ArrayList<e> arrayList4 = aVar.f8568f;
        arrayList4.addAll(arrayList2);
        return j.o(aVar.f8569g, b6.G(), aVar.f8564b, aVar.f8565c, arrayList4, aVar.f8570h, aVar.f8571i, null);
    }

    protected k.e j0(XmlPullParser xmlPullParser, k.e eVar) {
        long j6;
        long j7;
        long X = X(xmlPullParser, "timescale", eVar != null ? eVar.f8609b : 1L);
        long X2 = X(xmlPullParser, "presentationTimeOffset", eVar != null ? eVar.f8610c : 0L);
        long j8 = eVar != null ? eVar.f8623d : 0L;
        long j9 = eVar != null ? eVar.f8624e : 0L;
        String attributeValue = xmlPullParser.getAttributeValue(null, "indexRange");
        if (attributeValue != null) {
            String[] split = attributeValue.split("-");
            j7 = Long.parseLong(split[0]);
            j6 = (Long.parseLong(split[1]) - j7) + 1;
        } else {
            j6 = j9;
            j7 = j8;
        }
        i iVar = eVar != null ? eVar.f8608a : null;
        do {
            xmlPullParser.next();
            if (d1.f(xmlPullParser, "Initialization")) {
                iVar = T(xmlPullParser);
            } else {
                w(xmlPullParser);
            }
        } while (!d1.d(xmlPullParser, "SegmentBase"));
        return n(iVar, X, X2, j7, j6);
    }

    protected k.b k(i iVar, long j6, long j7, long j8, long j9, List<k.d> list, long j10, List<i> list2, long j11, long j12) {
        return new k.b(iVar, j6, j7, j8, j9, list, j10, list2, c1.D0(j11), c1.D0(j12));
    }

    protected k.b k0(XmlPullParser xmlPullParser, k.b bVar, long j6, long j7, long j8, long j9, long j10) {
        long X = X(xmlPullParser, "timescale", bVar != null ? bVar.f8609b : 1L);
        long X2 = X(xmlPullParser, "presentationTimeOffset", bVar != null ? bVar.f8610c : 0L);
        long X3 = X(xmlPullParser, "duration", bVar != null ? bVar.f8612e : -9223372036854775807L);
        long X4 = X(xmlPullParser, "startNumber", bVar != null ? bVar.f8611d : 1L);
        long t5 = t(j8, j9);
        List<k.d> list = null;
        List<i> list2 = null;
        i iVar = null;
        do {
            xmlPullParser.next();
            if (d1.f(xmlPullParser, "Initialization")) {
                iVar = T(xmlPullParser);
            } else if (d1.f(xmlPullParser, "SegmentTimeline")) {
                list = m0(xmlPullParser, X, j7);
            } else if (d1.f(xmlPullParser, "SegmentURL")) {
                if (list2 == null) {
                    list2 = new ArrayList<>();
                }
                list2.add(n0(xmlPullParser));
            } else {
                w(xmlPullParser);
            }
        } while (!d1.d(xmlPullParser, "SegmentList"));
        if (bVar != null) {
            if (iVar == null) {
                iVar = bVar.f8608a;
            }
            if (list == null) {
                list = bVar.f8613f;
            }
            if (list2 == null) {
                list2 = bVar.f8617j;
            }
        }
        return k(iVar, X, X2, X4, X3, list, t5, list2, j10, j6);
    }

    protected k.c l(i iVar, long j6, long j7, long j8, long j9, long j10, List<k.d> list, long j11, n nVar, n nVar2, long j12, long j13) {
        return new k.c(iVar, j6, j7, j8, j9, j10, list, j11, nVar, nVar2, c1.D0(j12), c1.D0(j13));
    }

    protected k.c l0(XmlPullParser xmlPullParser, k.c cVar, List<e> list, long j6, long j7, long j8, long j9, long j10) {
        long X = X(xmlPullParser, "timescale", cVar != null ? cVar.f8609b : 1L);
        long X2 = X(xmlPullParser, "presentationTimeOffset", cVar != null ? cVar.f8610c : 0L);
        long X3 = X(xmlPullParser, "duration", cVar != null ? cVar.f8612e : -9223372036854775807L);
        long X4 = X(xmlPullParser, "startNumber", cVar != null ? cVar.f8611d : 1L);
        long W = W(list);
        long t5 = t(j8, j9);
        List<k.d> list2 = null;
        n v02 = v0(xmlPullParser, "media", cVar != null ? cVar.f8619k : null);
        n v03 = v0(xmlPullParser, "initialization", cVar != null ? cVar.f8618j : null);
        i iVar = null;
        do {
            xmlPullParser.next();
            if (d1.f(xmlPullParser, "Initialization")) {
                iVar = T(xmlPullParser);
            } else if (d1.f(xmlPullParser, "SegmentTimeline")) {
                list2 = m0(xmlPullParser, X, j7);
            } else {
                w(xmlPullParser);
            }
        } while (!d1.d(xmlPullParser, "SegmentTemplate"));
        if (cVar != null) {
            if (iVar == null) {
                iVar = cVar.f8608a;
            }
            if (list2 == null) {
                list2 = cVar.f8613f;
            }
        }
        return l(iVar, X, X2, X4, W, X3, list2, t5, v03, v02, j10, j6);
    }

    protected k.d m(long j6, long j7) {
        return new k.d(j6, j7);
    }

    protected List<k.d> m0(XmlPullParser xmlPullParser, long j6, long j7) {
        ArrayList arrayList = new ArrayList();
        long j8 = 0;
        long j9 = -9223372036854775807L;
        boolean z5 = false;
        int i6 = 0;
        do {
            xmlPullParser.next();
            if (d1.f(xmlPullParser, "S")) {
                long X = X(xmlPullParser, "t", -9223372036854775807L);
                if (z5) {
                    j8 = b(arrayList, j8, j9, i6, X);
                }
                if (X == -9223372036854775807L) {
                    X = j8;
                }
                j9 = X(xmlPullParser, "d", -9223372036854775807L);
                i6 = U(xmlPullParser, "r", 0);
                j8 = X;
                z5 = true;
            } else {
                w(xmlPullParser);
            }
        } while (!d1.d(xmlPullParser, "SegmentTimeline"));
        if (z5) {
            b(arrayList, j8, j9, i6, c1.P0(j7, j6, 1000L));
        }
        return arrayList;
    }

    protected k.e n(i iVar, long j6, long j7, long j8, long j9) {
        return new k.e(iVar, j6, j7, j8, j9);
    }

    protected i n0(XmlPullParser xmlPullParser) {
        return d0(xmlPullParser, "media", "mediaRange");
    }

    protected o o(String str, String str2) {
        return new o(str, str2);
    }

    protected int o0(String str) {
        if (str == null) {
            return 0;
        }
        return (str.equals("forced_subtitle") || str.equals("forced-subtitle")) ? 2 : 0;
    }

    protected int p0(List<e> list) {
        int i6 = 0;
        for (int i7 = 0; i7 < list.size(); i7++) {
            e eVar = list.get(i7);
            if (l2.b.a("urn:mpeg:dash:role:2011", eVar.f8572a)) {
                i6 |= o0(eVar.f8573b);
            }
        }
        return i6;
    }

    protected l q0(XmlPullParser xmlPullParser) {
        long j6 = -9223372036854775807L;
        long j7 = -9223372036854775807L;
        long j8 = -9223372036854775807L;
        float f6 = -3.4028235E38f;
        float f7 = -3.4028235E38f;
        while (true) {
            xmlPullParser.next();
            if (d1.f(xmlPullParser, "Latency")) {
                j6 = X(xmlPullParser, "target", -9223372036854775807L);
                j7 = X(xmlPullParser, "min", -9223372036854775807L);
                j8 = X(xmlPullParser, "max", -9223372036854775807L);
            } else if (d1.f(xmlPullParser, "PlaybackRate")) {
                f6 = R(xmlPullParser, "min", -3.4028235E38f);
                f7 = R(xmlPullParser, "max", -3.4028235E38f);
            }
            long j9 = j6;
            long j10 = j7;
            long j11 = j8;
            float f8 = f6;
            float f9 = f7;
            if (d1.d(xmlPullParser, "ServiceDescription")) {
                return new l(j9, j10, j11, f8, f9);
            }
            j6 = j9;
            j7 = j10;
            j8 = j11;
            f6 = f8;
            f7 = f9;
        }
    }

    protected Pair<Integer, Integer> t0(List<e> list) {
        String str;
        for (int i6 = 0; i6 < list.size(); i6++) {
            e eVar = list.get(i6);
            if ((l2.b.a("http://dashif.org/thumbnail_tile", eVar.f8572a) || l2.b.a("http://dashif.org/guidelines/thumbnail_tile", eVar.f8572a)) && (str = eVar.f8573b) != null) {
                String[] U0 = c1.U0(str, "x");
                if (U0.length != 2) {
                    continue;
                } else {
                    try {
                        return Pair.create(Integer.valueOf(Integer.parseInt(U0[0])), Integer.valueOf(Integer.parseInt(U0[1])));
                    } catch (NumberFormatException unused) {
                        continue;
                    }
                }
            }
        }
        return null;
    }

    protected int u0(String str) {
        if (str == null) {
            return 0;
        }
        switch (str) {
        }
        return 0;
    }

    protected n v0(XmlPullParser xmlPullParser, String str, n nVar) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue != null ? n.b(attributeValue) : nVar;
    }

    protected o w0(XmlPullParser xmlPullParser) {
        return o(xmlPullParser.getAttributeValue(null, "schemeIdUri"), xmlPullParser.getAttributeValue(null, "value"));
    }

    @Override // g2.k0.a
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public c a(Uri uri, InputStream inputStream) {
        try {
            XmlPullParser newPullParser = this.f8562a.newPullParser();
            newPullParser.setInput(inputStream, null);
            if (newPullParser.next() == 2 && "MPD".equals(newPullParser.getName())) {
                return Y(newPullParser, uri);
            }
            throw g3.c("inputStream does not contain a valid media presentation description", null);
        } catch (XmlPullParserException e6) {
            throw g3.c(null, e6);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x030d A[LOOP:0: B:2:0x007c->B:10:0x030d, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x02ce A[EDGE_INSN: B:11:0x02ce->B:12:0x02ce BREAK  A[LOOP:0: B:2:0x007c->B:10:0x030d], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected p1.a y(org.xmlpull.v1.XmlPullParser r55, java.util.List<p1.b> r56, p1.k r57, long r58, long r60, long r62, long r64, long r66, boolean r68) {
        /*
            Method dump skipped, instructions count: 809
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p1.d.y(org.xmlpull.v1.XmlPullParser, java.util.List, p1.k, long, long, long, long, long, boolean):p1.a");
    }

    protected void z(XmlPullParser xmlPullParser) {
        w(xmlPullParser);
    }
}
