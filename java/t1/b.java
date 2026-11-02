package t1;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import g2.k0;
import h0.g3;
import h0.y1;
import i2.c1;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import m0.m;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import t1.a;
import w0.l;
import w0.p;

/* loaded from: classes.dex */
public class b implements k0.a<t1.a> {

    /* renamed from: a, reason: collision with root package name */
    private final XmlPullParserFactory f9359a;

    private static abstract class a {

        /* renamed from: a, reason: collision with root package name */
        private final String f9360a;

        /* renamed from: b, reason: collision with root package name */
        private final String f9361b;

        /* renamed from: c, reason: collision with root package name */
        private final a f9362c;

        /* renamed from: d, reason: collision with root package name */
        private final List<Pair<String, Object>> f9363d = new LinkedList();

        public a(a aVar, String str, String str2) {
            this.f9362c = aVar;
            this.f9360a = str;
            this.f9361b = str2;
        }

        private a e(a aVar, String str, String str2) {
            if ("QualityLevel".equals(str)) {
                return new d(aVar, str2);
            }
            if ("Protection".equals(str)) {
                return new c(aVar, str2);
            }
            if ("StreamIndex".equals(str)) {
                return new f(aVar, str2);
            }
            return null;
        }

        protected void a(Object obj) {
        }

        protected abstract Object b();

        protected final Object c(String str) {
            for (int i6 = 0; i6 < this.f9363d.size(); i6++) {
                Pair<String, Object> pair = this.f9363d.get(i6);
                if (((String) pair.first).equals(str)) {
                    return pair.second;
                }
            }
            a aVar = this.f9362c;
            if (aVar == null) {
                return null;
            }
            return aVar.c(str);
        }

        protected boolean d(String str) {
            return false;
        }

        public final Object f(XmlPullParser xmlPullParser) {
            boolean z5 = false;
            int i6 = 0;
            while (true) {
                int eventType = xmlPullParser.getEventType();
                if (eventType == 1) {
                    return null;
                }
                if (eventType == 2) {
                    String name = xmlPullParser.getName();
                    if (this.f9361b.equals(name)) {
                        n(xmlPullParser);
                        z5 = true;
                    } else if (z5) {
                        if (i6 > 0) {
                            i6++;
                        } else if (d(name)) {
                            n(xmlPullParser);
                        } else {
                            a e6 = e(this, name, this.f9360a);
                            if (e6 == null) {
                                i6 = 1;
                            } else {
                                a(e6.f(xmlPullParser));
                            }
                        }
                    }
                } else if (eventType != 3) {
                    if (eventType == 4 && z5 && i6 == 0) {
                        o(xmlPullParser);
                    }
                } else if (!z5) {
                    continue;
                } else if (i6 > 0) {
                    i6--;
                } else {
                    String name2 = xmlPullParser.getName();
                    h(xmlPullParser);
                    if (!d(name2)) {
                        return b();
                    }
                }
                xmlPullParser.next();
            }
        }

        protected final boolean g(XmlPullParser xmlPullParser, String str, boolean z5) {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            return attributeValue != null ? Boolean.parseBoolean(attributeValue) : z5;
        }

        protected void h(XmlPullParser xmlPullParser) {
        }

        protected final int i(XmlPullParser xmlPullParser, String str, int i6) {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue == null) {
                return i6;
            }
            try {
                return Integer.parseInt(attributeValue);
            } catch (NumberFormatException e6) {
                throw g3.c(null, e6);
            }
        }

        protected final long j(XmlPullParser xmlPullParser, String str, long j6) {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue == null) {
                return j6;
            }
            try {
                return Long.parseLong(attributeValue);
            } catch (NumberFormatException e6) {
                throw g3.c(null, e6);
            }
        }

        protected final int k(XmlPullParser xmlPullParser, String str) {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue == null) {
                throw new C0144b(str);
            }
            try {
                return Integer.parseInt(attributeValue);
            } catch (NumberFormatException e6) {
                throw g3.c(null, e6);
            }
        }

        protected final long l(XmlPullParser xmlPullParser, String str) {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue == null) {
                throw new C0144b(str);
            }
            try {
                return Long.parseLong(attributeValue);
            } catch (NumberFormatException e6) {
                throw g3.c(null, e6);
            }
        }

        protected final String m(XmlPullParser xmlPullParser, String str) {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue != null) {
                return attributeValue;
            }
            throw new C0144b(str);
        }

        protected abstract void n(XmlPullParser xmlPullParser);

        protected void o(XmlPullParser xmlPullParser) {
        }

        protected final void p(String str, Object obj) {
            this.f9363d.add(Pair.create(str, obj));
        }
    }

    /* renamed from: t1.b$b, reason: collision with other inner class name */
    public static class C0144b extends g3 {
        public C0144b(String str) {
            super("Missing required field: " + str, null, true, 4);
        }
    }

    private static class c extends a {

        /* renamed from: e, reason: collision with root package name */
        private boolean f9364e;

        /* renamed from: f, reason: collision with root package name */
        private UUID f9365f;

        /* renamed from: g, reason: collision with root package name */
        private byte[] f9366g;

        public c(a aVar, String str) {
            super(aVar, str, "Protection");
        }

        private static p[] q(byte[] bArr) {
            return new p[]{new p(true, null, 8, r(bArr), 0, 0, null)};
        }

        private static byte[] r(byte[] bArr) {
            StringBuilder sb = new StringBuilder();
            for (int i6 = 0; i6 < bArr.length; i6 += 2) {
                sb.append((char) bArr[i6]);
            }
            String sb2 = sb.toString();
            byte[] decode = Base64.decode(sb2.substring(sb2.indexOf("<KID>") + 5, sb2.indexOf("</KID>")), 0);
            t(decode, 0, 3);
            t(decode, 1, 2);
            t(decode, 4, 5);
            t(decode, 6, 7);
            return decode;
        }

        private static String s(String str) {
            return (str.charAt(0) == '{' && str.charAt(str.length() - 1) == '}') ? str.substring(1, str.length() - 1) : str;
        }

        private static void t(byte[] bArr, int i6, int i7) {
            byte b6 = bArr[i6];
            bArr[i6] = bArr[i7];
            bArr[i7] = b6;
        }

        @Override // t1.b.a
        public Object b() {
            UUID uuid = this.f9365f;
            return new a.C0143a(uuid, l.a(uuid, this.f9366g), q(this.f9366g));
        }

        @Override // t1.b.a
        public boolean d(String str) {
            return "ProtectionHeader".equals(str);
        }

        @Override // t1.b.a
        public void h(XmlPullParser xmlPullParser) {
            if ("ProtectionHeader".equals(xmlPullParser.getName())) {
                this.f9364e = false;
            }
        }

        @Override // t1.b.a
        public void n(XmlPullParser xmlPullParser) {
            if ("ProtectionHeader".equals(xmlPullParser.getName())) {
                this.f9364e = true;
                this.f9365f = UUID.fromString(s(xmlPullParser.getAttributeValue(null, "SystemID")));
            }
        }

        @Override // t1.b.a
        public void o(XmlPullParser xmlPullParser) {
            if (this.f9364e) {
                this.f9366g = Base64.decode(xmlPullParser.getText(), 0);
            }
        }
    }

    private static class d extends a {

        /* renamed from: e, reason: collision with root package name */
        private y1 f9367e;

        public d(a aVar, String str) {
            super(aVar, str, "QualityLevel");
        }

        private static List<byte[]> q(String str) {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(str)) {
                byte[] J = c1.J(str);
                byte[][] i6 = i2.f.i(J);
                if (i6 == null) {
                    arrayList.add(J);
                } else {
                    Collections.addAll(arrayList, i6);
                }
            }
            return arrayList;
        }

        private static String r(String str) {
            if (str.equalsIgnoreCase("H264") || str.equalsIgnoreCase("X264") || str.equalsIgnoreCase("AVC1") || str.equalsIgnoreCase("DAVC")) {
                return "video/avc";
            }
            if (str.equalsIgnoreCase("AAC") || str.equalsIgnoreCase("AACL") || str.equalsIgnoreCase("AACH") || str.equalsIgnoreCase("AACP")) {
                return "audio/mp4a-latm";
            }
            if (str.equalsIgnoreCase("TTML") || str.equalsIgnoreCase("DFXP")) {
                return "application/ttml+xml";
            }
            if (str.equalsIgnoreCase("ac-3") || str.equalsIgnoreCase("dac3")) {
                return "audio/ac3";
            }
            if (str.equalsIgnoreCase("ec-3") || str.equalsIgnoreCase("dec3")) {
                return "audio/eac3";
            }
            if (str.equalsIgnoreCase("dtsc")) {
                return "audio/vnd.dts";
            }
            if (str.equalsIgnoreCase("dtsh") || str.equalsIgnoreCase("dtsl")) {
                return "audio/vnd.dts.hd";
            }
            if (str.equalsIgnoreCase("dtse")) {
                return "audio/vnd.dts.hd;profile=lbr";
            }
            if (str.equalsIgnoreCase("opus")) {
                return "audio/opus";
            }
            return null;
        }

        @Override // t1.b.a
        public Object b() {
            return this.f9367e;
        }

        @Override // t1.b.a
        public void n(XmlPullParser xmlPullParser) {
            int i6;
            y1.b bVar = new y1.b();
            String r6 = r(m(xmlPullParser, "FourCC"));
            int intValue = ((Integer) c("Type")).intValue();
            if (intValue == 2) {
                bVar.M("video/mp4").n0(k(xmlPullParser, "MaxWidth")).S(k(xmlPullParser, "MaxHeight")).V(q(xmlPullParser.getAttributeValue(null, "CodecPrivateData")));
            } else if (intValue == 1) {
                if (r6 == null) {
                    r6 = "audio/mp4a-latm";
                }
                int k6 = k(xmlPullParser, "Channels");
                int k7 = k(xmlPullParser, "SamplingRate");
                List<byte[]> q6 = q(xmlPullParser.getAttributeValue(null, "CodecPrivateData"));
                if (q6.isEmpty() && "audio/mp4a-latm".equals(r6)) {
                    q6 = Collections.singletonList(j0.a.a(k7, k6));
                }
                bVar.M("audio/mp4").J(k6).h0(k7).V(q6);
            } else if (intValue == 3) {
                String str = (String) c("Subtype");
                if (str != null) {
                    if (str.equals("CAPT")) {
                        i6 = 64;
                    } else if (str.equals("DESC")) {
                        i6 = 1024;
                    }
                    bVar.M("application/mp4").e0(i6);
                }
                i6 = 0;
                bVar.M("application/mp4").e0(i6);
            } else {
                bVar.M("application/mp4");
            }
            this.f9367e = bVar.U(xmlPullParser.getAttributeValue(null, "Index")).W((String) c("Name")).g0(r6).I(k(xmlPullParser, "Bitrate")).X((String) c("Language")).G();
        }
    }

    private static class e extends a {

        /* renamed from: e, reason: collision with root package name */
        private final List<a.b> f9368e;

        /* renamed from: f, reason: collision with root package name */
        private int f9369f;

        /* renamed from: g, reason: collision with root package name */
        private int f9370g;

        /* renamed from: h, reason: collision with root package name */
        private long f9371h;

        /* renamed from: i, reason: collision with root package name */
        private long f9372i;

        /* renamed from: j, reason: collision with root package name */
        private long f9373j;

        /* renamed from: k, reason: collision with root package name */
        private int f9374k;

        /* renamed from: l, reason: collision with root package name */
        private boolean f9375l;

        /* renamed from: m, reason: collision with root package name */
        private a.C0143a f9376m;

        public e(a aVar, String str) {
            super(aVar, str, "SmoothStreamingMedia");
            this.f9374k = -1;
            this.f9376m = null;
            this.f9368e = new LinkedList();
        }

        @Override // t1.b.a
        public void a(Object obj) {
            if (obj instanceof a.b) {
                this.f9368e.add((a.b) obj);
            } else if (obj instanceof a.C0143a) {
                i2.a.g(this.f9376m == null);
                this.f9376m = (a.C0143a) obj;
            }
        }

        @Override // t1.b.a
        public Object b() {
            int size = this.f9368e.size();
            a.b[] bVarArr = new a.b[size];
            this.f9368e.toArray(bVarArr);
            if (this.f9376m != null) {
                a.C0143a c0143a = this.f9376m;
                m mVar = new m(new m.b(c0143a.f9340a, "video/mp4", c0143a.f9341b));
                for (int i6 = 0; i6 < size; i6++) {
                    a.b bVar = bVarArr[i6];
                    int i7 = bVar.f9343a;
                    if (i7 == 2 || i7 == 1) {
                        y1[] y1VarArr = bVar.f9352j;
                        for (int i8 = 0; i8 < y1VarArr.length; i8++) {
                            y1VarArr[i8] = y1VarArr[i8].b().O(mVar).G();
                        }
                    }
                }
            }
            return new t1.a(this.f9369f, this.f9370g, this.f9371h, this.f9372i, this.f9373j, this.f9374k, this.f9375l, this.f9376m, bVarArr);
        }

        @Override // t1.b.a
        public void n(XmlPullParser xmlPullParser) {
            this.f9369f = k(xmlPullParser, "MajorVersion");
            this.f9370g = k(xmlPullParser, "MinorVersion");
            this.f9371h = j(xmlPullParser, "TimeScale", 10000000L);
            this.f9372i = l(xmlPullParser, "Duration");
            this.f9373j = j(xmlPullParser, "DVRWindowLength", 0L);
            this.f9374k = i(xmlPullParser, "LookaheadCount", -1);
            this.f9375l = g(xmlPullParser, "IsLive", false);
            p("TimeScale", Long.valueOf(this.f9371h));
        }
    }

    private static class f extends a {

        /* renamed from: e, reason: collision with root package name */
        private final String f9377e;

        /* renamed from: f, reason: collision with root package name */
        private final List<y1> f9378f;

        /* renamed from: g, reason: collision with root package name */
        private int f9379g;

        /* renamed from: h, reason: collision with root package name */
        private String f9380h;

        /* renamed from: i, reason: collision with root package name */
        private long f9381i;

        /* renamed from: j, reason: collision with root package name */
        private String f9382j;

        /* renamed from: k, reason: collision with root package name */
        private String f9383k;

        /* renamed from: l, reason: collision with root package name */
        private int f9384l;

        /* renamed from: m, reason: collision with root package name */
        private int f9385m;

        /* renamed from: n, reason: collision with root package name */
        private int f9386n;

        /* renamed from: o, reason: collision with root package name */
        private int f9387o;

        /* renamed from: p, reason: collision with root package name */
        private String f9388p;

        /* renamed from: q, reason: collision with root package name */
        private ArrayList<Long> f9389q;

        /* renamed from: r, reason: collision with root package name */
        private long f9390r;

        public f(a aVar, String str) {
            super(aVar, str, "StreamIndex");
            this.f9377e = str;
            this.f9378f = new LinkedList();
        }

        private void q(XmlPullParser xmlPullParser) {
            int s5 = s(xmlPullParser);
            this.f9379g = s5;
            p("Type", Integer.valueOf(s5));
            this.f9380h = this.f9379g == 3 ? m(xmlPullParser, "Subtype") : xmlPullParser.getAttributeValue(null, "Subtype");
            p("Subtype", this.f9380h);
            String attributeValue = xmlPullParser.getAttributeValue(null, "Name");
            this.f9382j = attributeValue;
            p("Name", attributeValue);
            this.f9383k = m(xmlPullParser, "Url");
            this.f9384l = i(xmlPullParser, "MaxWidth", -1);
            this.f9385m = i(xmlPullParser, "MaxHeight", -1);
            this.f9386n = i(xmlPullParser, "DisplayWidth", -1);
            this.f9387o = i(xmlPullParser, "DisplayHeight", -1);
            String attributeValue2 = xmlPullParser.getAttributeValue(null, "Language");
            this.f9388p = attributeValue2;
            p("Language", attributeValue2);
            long i6 = i(xmlPullParser, "TimeScale", -1);
            this.f9381i = i6;
            if (i6 == -1) {
                this.f9381i = ((Long) c("TimeScale")).longValue();
            }
            this.f9389q = new ArrayList<>();
        }

        private void r(XmlPullParser xmlPullParser) {
            int size = this.f9389q.size();
            long j6 = j(xmlPullParser, "t", -9223372036854775807L);
            int i6 = 1;
            if (j6 == -9223372036854775807L) {
                if (size == 0) {
                    j6 = 0;
                } else {
                    if (this.f9390r == -1) {
                        throw g3.c("Unable to infer start time", null);
                    }
                    j6 = this.f9389q.get(size - 1).longValue() + this.f9390r;
                }
            }
            this.f9389q.add(Long.valueOf(j6));
            this.f9390r = j(xmlPullParser, "d", -9223372036854775807L);
            long j7 = j(xmlPullParser, "r", 1L);
            if (j7 > 1 && this.f9390r == -9223372036854775807L) {
                throw g3.c("Repeated chunk with unspecified duration", null);
            }
            while (true) {
                long j8 = i6;
                if (j8 >= j7) {
                    return;
                }
                this.f9389q.add(Long.valueOf((this.f9390r * j8) + j6));
                i6++;
            }
        }

        private int s(XmlPullParser xmlPullParser) {
            String attributeValue = xmlPullParser.getAttributeValue(null, "Type");
            if (attributeValue == null) {
                throw new C0144b("Type");
            }
            if ("audio".equalsIgnoreCase(attributeValue)) {
                return 1;
            }
            if ("video".equalsIgnoreCase(attributeValue)) {
                return 2;
            }
            if ("text".equalsIgnoreCase(attributeValue)) {
                return 3;
            }
            throw g3.c("Invalid key value[" + attributeValue + "]", null);
        }

        @Override // t1.b.a
        public void a(Object obj) {
            if (obj instanceof y1) {
                this.f9378f.add((y1) obj);
            }
        }

        @Override // t1.b.a
        public Object b() {
            y1[] y1VarArr = new y1[this.f9378f.size()];
            this.f9378f.toArray(y1VarArr);
            return new a.b(this.f9377e, this.f9383k, this.f9379g, this.f9380h, this.f9381i, this.f9382j, this.f9384l, this.f9385m, this.f9386n, this.f9387o, this.f9388p, y1VarArr, this.f9389q, this.f9390r);
        }

        @Override // t1.b.a
        public boolean d(String str) {
            return "c".equals(str);
        }

        @Override // t1.b.a
        public void n(XmlPullParser xmlPullParser) {
            if ("c".equals(xmlPullParser.getName())) {
                r(xmlPullParser);
            } else {
                q(xmlPullParser);
            }
        }
    }

    public b() {
        try {
            this.f9359a = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e6) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e6);
        }
    }

    @Override // g2.k0.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public t1.a a(Uri uri, InputStream inputStream) {
        try {
            XmlPullParser newPullParser = this.f9359a.newPullParser();
            newPullParser.setInput(inputStream, null);
            return (t1.a) new e(null, uri.toString()).f(newPullParser);
        } catch (XmlPullParserException e6) {
            throw g3.c(null, e6);
        }
    }
}
