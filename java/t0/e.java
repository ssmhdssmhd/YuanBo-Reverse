package t0;

import h0.g3;
import i2.d1;
import i2.t;
import java.io.StringReader;
import m2.q;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import t0.b;

/* loaded from: classes.dex */
final class e {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f9329a = {"Camera:MotionPhoto", "GCamera:MotionPhoto", "Camera:MicroVideo", "GCamera:MicroVideo"};

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f9330b = {"Camera:MotionPhotoPresentationTimestampUs", "GCamera:MotionPhotoPresentationTimestampUs", "Camera:MicroVideoPresentationTimestampUs", "GCamera:MicroVideoPresentationTimestampUs"};

    /* renamed from: c, reason: collision with root package name */
    private static final String[] f9331c = {"Camera:MicroVideoOffset", "GCamera:MicroVideoOffset"};

    public static b a(String str) {
        try {
            return b(str);
        } catch (g3 | NumberFormatException | XmlPullParserException unused) {
            t.i("MotionPhotoXmpParser", "Ignoring unexpected XMP metadata");
            return null;
        }
    }

    private static b b(String str) {
        String str2;
        String str3;
        XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
        newPullParser.setInput(new StringReader(str));
        newPullParser.next();
        if (!d1.f(newPullParser, "x:xmpmeta")) {
            throw g3.a("Couldn't find xmp metadata", null);
        }
        q<b.a> q6 = q.q();
        long j6 = -9223372036854775807L;
        do {
            newPullParser.next();
            if (!d1.f(newPullParser, "rdf:Description")) {
                if (d1.f(newPullParser, "Container:Directory")) {
                    str2 = "Container";
                    str3 = "Item";
                } else if (d1.f(newPullParser, "GContainer:Directory")) {
                    str2 = "GContainer";
                    str3 = "GContainerItem";
                }
                q6 = f(newPullParser, str2, str3);
            } else {
                if (!d(newPullParser)) {
                    return null;
                }
                j6 = e(newPullParser);
                q6 = c(newPullParser);
            }
        } while (!d1.d(newPullParser, "x:xmpmeta"));
        if (q6.isEmpty()) {
            return null;
        }
        return new b(j6, q6);
    }

    private static q<b.a> c(XmlPullParser xmlPullParser) {
        for (String str : f9331c) {
            String a6 = d1.a(xmlPullParser, str);
            if (a6 != null) {
                return q.s(new b.a("image/jpeg", "Primary", 0L, 0L), new b.a("video/mp4", "MotionPhoto", Long.parseLong(a6), 0L));
            }
        }
        return q.q();
    }

    private static boolean d(XmlPullParser xmlPullParser) {
        for (String str : f9329a) {
            String a6 = d1.a(xmlPullParser, str);
            if (a6 != null) {
                return Integer.parseInt(a6) == 1;
            }
        }
        return false;
    }

    private static long e(XmlPullParser xmlPullParser) {
        for (String str : f9330b) {
            String a6 = d1.a(xmlPullParser, str);
            if (a6 != null) {
                long parseLong = Long.parseLong(a6);
                if (parseLong == -1) {
                    return -9223372036854775807L;
                }
                return parseLong;
            }
        }
        return -9223372036854775807L;
    }

    private static q<b.a> f(XmlPullParser xmlPullParser, String str, String str2) {
        q.a k6 = q.k();
        String str3 = str + ":Item";
        String str4 = str + ":Directory";
        do {
            xmlPullParser.next();
            if (d1.f(xmlPullParser, str3)) {
                String a6 = d1.a(xmlPullParser, str2 + ":Mime");
                String a7 = d1.a(xmlPullParser, str2 + ":Semantic");
                String a8 = d1.a(xmlPullParser, str2 + ":Length");
                String a9 = d1.a(xmlPullParser, str2 + ":Padding");
                if (a6 == null || a7 == null) {
                    return q.q();
                }
                k6.a(new b.a(a6, a7, a8 != null ? Long.parseLong(a8) : 0L, a9 != null ? Long.parseLong(a9) : 0L));
            }
        } while (!d1.d(xmlPullParser, str4));
        return k6.h();
    }
}
