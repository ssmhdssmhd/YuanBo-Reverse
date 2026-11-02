package r1;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import androidx.window.embedding.EmbeddingCompat;
import g2.k0;
import h0.g3;
import h0.p;
import h0.y1;
import i2.c1;
import i2.t;
import i2.t0;
import i2.x;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import m0.m;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import q1.q;
import r1.g;
import r1.h;

/* loaded from: classes.dex */
public final class j implements k0.a<i> {

    /* renamed from: a, reason: collision with root package name */
    private final h f9169a;

    /* renamed from: b, reason: collision with root package name */
    private final g f9170b;

    /* renamed from: c, reason: collision with root package name */
    private static final Pattern f9145c = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");

    /* renamed from: d, reason: collision with root package name */
    private static final Pattern f9146d = Pattern.compile("VIDEO=\"(.+?)\"");

    /* renamed from: e, reason: collision with root package name */
    private static final Pattern f9147e = Pattern.compile("AUDIO=\"(.+?)\"");

    /* renamed from: f, reason: collision with root package name */
    private static final Pattern f9148f = Pattern.compile("SUBTITLES=\"(.+?)\"");

    /* renamed from: g, reason: collision with root package name */
    private static final Pattern f9149g = Pattern.compile("CLOSED-CAPTIONS=\"(.+?)\"");

    /* renamed from: h, reason: collision with root package name */
    private static final Pattern f9150h = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");

    /* renamed from: i, reason: collision with root package name */
    private static final Pattern f9151i = Pattern.compile("CHANNELS=\"(.+?)\"");

    /* renamed from: j, reason: collision with root package name */
    private static final Pattern f9152j = Pattern.compile("CODECS=\"(.+?)\"");

    /* renamed from: k, reason: collision with root package name */
    private static final Pattern f9153k = Pattern.compile("RESOLUTION=(\\d+x\\d+)");

    /* renamed from: l, reason: collision with root package name */
    private static final Pattern f9154l = Pattern.compile("FRAME-RATE=([\\d\\.]+)\\b");

    /* renamed from: m, reason: collision with root package name */
    private static final Pattern f9155m = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");

    /* renamed from: n, reason: collision with root package name */
    private static final Pattern f9156n = Pattern.compile("DURATION=([\\d\\.]+)\\b");

    /* renamed from: o, reason: collision with root package name */
    private static final Pattern f9157o = Pattern.compile("PART-TARGET=([\\d\\.]+)\\b");

    /* renamed from: p, reason: collision with root package name */
    private static final Pattern f9158p = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");

    /* renamed from: q, reason: collision with root package name */
    private static final Pattern f9159q = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");

    /* renamed from: r, reason: collision with root package name */
    private static final Pattern f9160r = Pattern.compile("CAN-SKIP-UNTIL=([\\d\\.]+)\\b");

    /* renamed from: s, reason: collision with root package name */
    private static final Pattern f9161s = c("CAN-SKIP-DATERANGES");

    /* renamed from: t, reason: collision with root package name */
    private static final Pattern f9162t = Pattern.compile("SKIPPED-SEGMENTS=(\\d+)\\b");

    /* renamed from: u, reason: collision with root package name */
    private static final Pattern f9163u = Pattern.compile("[:|,]HOLD-BACK=([\\d\\.]+)\\b");

    /* renamed from: v, reason: collision with root package name */
    private static final Pattern f9164v = Pattern.compile("PART-HOLD-BACK=([\\d\\.]+)\\b");

    /* renamed from: w, reason: collision with root package name */
    private static final Pattern f9165w = c("CAN-BLOCK-RELOAD");

    /* renamed from: x, reason: collision with root package name */
    private static final Pattern f9166x = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");

    /* renamed from: y, reason: collision with root package name */
    private static final Pattern f9167y = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");

    /* renamed from: z, reason: collision with root package name */
    private static final Pattern f9168z = Pattern.compile("#EXTINF:[\\d\\.]+\\b,(.+)");
    private static final Pattern A = Pattern.compile("LAST-MSN=(\\d+)\\b");
    private static final Pattern B = Pattern.compile("LAST-PART=(\\d+)\\b");
    private static final Pattern C = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");
    private static final Pattern D = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");
    private static final Pattern E = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");
    private static final Pattern F = Pattern.compile("BYTERANGE-START=(\\d+)\\b");
    private static final Pattern G = Pattern.compile("BYTERANGE-LENGTH=(\\d+)\\b");
    private static final Pattern H = Pattern.compile("METHOD=(NONE|AES-128|SAMPLE-AES|SAMPLE-AES-CENC|SAMPLE-AES-CTR)\\s*(?:,|$)");
    private static final Pattern I = Pattern.compile("KEYFORMAT=\"(.+?)\"");
    private static final Pattern J = Pattern.compile("KEYFORMATVERSIONS=\"(.+?)\"");
    private static final Pattern K = Pattern.compile("URI=\"(.+?)\"");
    private static final Pattern L = Pattern.compile("IV=([^,.*]+)");
    private static final Pattern M = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
    private static final Pattern N = Pattern.compile("TYPE=(PART|MAP)");
    private static final Pattern O = Pattern.compile("LANGUAGE=\"(.+?)\"");
    private static final Pattern P = Pattern.compile("NAME=\"(.+?)\"");
    private static final Pattern Q = Pattern.compile("GROUP-ID=\"(.+?)\"");
    private static final Pattern R = Pattern.compile("CHARACTERISTICS=\"(.+?)\"");
    private static final Pattern S = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");
    private static final Pattern T = c("AUTOSELECT");
    private static final Pattern U = c("DEFAULT");
    private static final Pattern V = c("FORCED");
    private static final Pattern W = c("INDEPENDENT");
    private static final Pattern X = c("GAP");
    private static final Pattern Y = c("PRECISE");
    private static final Pattern Z = Pattern.compile("VALUE=\"(.+?)\"");

    /* renamed from: a0, reason: collision with root package name */
    private static final Pattern f9143a0 = Pattern.compile("IMPORT=\"(.+?)\"");

    /* renamed from: b0, reason: collision with root package name */
    private static final Pattern f9144b0 = Pattern.compile("\\{\\$([a-zA-Z0-9\\-_]+)\\}");

    public static final class a extends IOException {
    }

    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private final BufferedReader f9171a;

        /* renamed from: b, reason: collision with root package name */
        private final Queue<String> f9172b;

        /* renamed from: c, reason: collision with root package name */
        private String f9173c;

        public b(Queue<String> queue, BufferedReader bufferedReader) {
            this.f9172b = queue;
            this.f9171a = bufferedReader;
        }

        @EnsuresNonNullIf(expression = {"next"}, result = EmbeddingCompat.DEBUG)
        public boolean a() {
            String trim;
            if (this.f9173c != null) {
                return true;
            }
            if (!this.f9172b.isEmpty()) {
                this.f9173c = (String) i2.a.e(this.f9172b.poll());
                return true;
            }
            do {
                String readLine = this.f9171a.readLine();
                this.f9173c = readLine;
                if (readLine == null) {
                    return false;
                }
                trim = readLine.trim();
                this.f9173c = trim;
            } while (trim.isEmpty());
            return true;
        }

        public String b() {
            if (!a()) {
                throw new NoSuchElementException();
            }
            String str = this.f9173c;
            this.f9173c = null;
            return str;
        }
    }

    public j() {
        this(h.f9119n, null);
    }

    public j(h hVar, g gVar) {
        this.f9169a = hVar;
        this.f9170b = gVar;
    }

    private static long A(String str, Pattern pattern) {
        return new BigDecimal(z(str, pattern, Collections.emptyMap())).multiply(new BigDecimal(1000000L)).longValue();
    }

    private static String B(String str, Map<String, String> map) {
        Matcher matcher = f9144b0.matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            String group = matcher.group(1);
            if (map.containsKey(group)) {
                matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement(map.get(group)));
            }
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    private static int C(BufferedReader bufferedReader, boolean z5, int i6) {
        while (i6 != -1 && Character.isWhitespace(i6) && (z5 || !c1.w0(i6))) {
            i6 = bufferedReader.read();
        }
        return i6;
    }

    private static boolean b(BufferedReader bufferedReader) {
        int read = bufferedReader.read();
        if (read == 239) {
            if (bufferedReader.read() != 187 || bufferedReader.read() != 191) {
                return false;
            }
            read = bufferedReader.read();
        }
        int C2 = C(bufferedReader, true, read);
        for (int i6 = 0; i6 < 7; i6++) {
            if (C2 != "#EXTM3U".charAt(i6)) {
                return false;
            }
            C2 = bufferedReader.read();
        }
        return c1.w0(C(bufferedReader, false, C2));
    }

    private static Pattern c(String str) {
        return Pattern.compile(str + "=(NO|YES)");
    }

    private static m d(String str, m.b[] bVarArr) {
        m.b[] bVarArr2 = new m.b[bVarArr.length];
        for (int i6 = 0; i6 < bVarArr.length; i6++) {
            bVarArr2[i6] = bVarArr[i6].e(null);
        }
        return new m(str, bVarArr2);
    }

    private static String e(long j6, String str, String str2) {
        if (str == null) {
            return null;
        }
        return str2 != null ? str2 : Long.toHexString(j6);
    }

    private static h.b f(ArrayList<h.b> arrayList, String str) {
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            h.b bVar = arrayList.get(i6);
            if (str.equals(bVar.f9137d)) {
                return bVar;
            }
        }
        return null;
    }

    private static h.b g(ArrayList<h.b> arrayList, String str) {
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            h.b bVar = arrayList.get(i6);
            if (str.equals(bVar.f9138e)) {
                return bVar;
            }
        }
        return null;
    }

    private static h.b h(ArrayList<h.b> arrayList, String str) {
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            h.b bVar = arrayList.get(i6);
            if (str.equals(bVar.f9136c)) {
                return bVar;
            }
        }
        return null;
    }

    private static double j(String str, Pattern pattern) {
        return Double.parseDouble(z(str, pattern, Collections.emptyMap()));
    }

    private static m.b k(String str, String str2, Map<String, String> map) {
        String u5 = u(str, J, "1", map);
        if ("urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed".equals(str2)) {
            String z5 = z(str, K, map);
            return new m.b(p.f4774d, "video/mp4", Base64.decode(z5.substring(z5.indexOf(44)), 0));
        }
        if ("com.widevine".equals(str2)) {
            return new m.b(p.f4774d, "hls", c1.n0(str));
        }
        if (!"com.microsoft.playready".equals(str2) || !"1".equals(u5)) {
            return null;
        }
        String z6 = z(str, K, map);
        byte[] decode = Base64.decode(z6.substring(z6.indexOf(44)), 0);
        UUID uuid = p.f4775e;
        return new m.b(uuid, "video/mp4", w0.l.a(uuid, decode));
    }

    private static String l(String str) {
        return ("SAMPLE-AES-CENC".equals(str) || "SAMPLE-AES-CTR".equals(str)) ? "cenc" : "cbcs";
    }

    private static int m(String str, Pattern pattern) {
        return Integer.parseInt(z(str, pattern, Collections.emptyMap()));
    }

    private static long n(String str, Pattern pattern) {
        return Long.parseLong(z(str, pattern, Collections.emptyMap()));
    }

    /* JADX WARN: Code restructure failed: missing block: B:230:0x01c6, code lost:
    
        if (r12 != null) goto L67;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static r1.g o(r1.h r92, r1.g r93, r1.j.b r94, java.lang.String r95) {
        /*
            Method dump skipped, instructions count: 1778
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: r1.j.o(r1.h, r1.g, r1.j$b, java.lang.String):r1.g");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.util.List] */
    private static h p(b bVar, String str) {
        char c6;
        y1 y1Var;
        ArrayList arrayList;
        ArrayList arrayList2;
        String str2;
        ArrayList arrayList3;
        int parseInt;
        String str3;
        String str4;
        boolean z5;
        int i6;
        ArrayList arrayList4;
        ArrayList arrayList5;
        ArrayList arrayList6;
        ArrayList arrayList7;
        ArrayList arrayList8;
        int i7;
        int i8;
        ArrayList arrayList9;
        ArrayList arrayList10;
        String B2;
        HashMap hashMap;
        int i9;
        String str5 = str;
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        ArrayList arrayList11 = new ArrayList();
        ArrayList arrayList12 = new ArrayList();
        ArrayList arrayList13 = new ArrayList();
        ArrayList arrayList14 = new ArrayList();
        ArrayList arrayList15 = new ArrayList();
        ArrayList arrayList16 = new ArrayList();
        ArrayList arrayList17 = new ArrayList();
        ArrayList arrayList18 = new ArrayList();
        boolean z6 = false;
        boolean z7 = false;
        while (true) {
            String str6 = "application/x-mpegURL";
            if (!bVar.a()) {
                HashMap hashMap4 = hashMap2;
                ArrayList arrayList19 = arrayList16;
                ArrayList arrayList20 = arrayList12;
                ArrayList arrayList21 = arrayList13;
                ArrayList arrayList22 = arrayList14;
                ArrayList arrayList23 = arrayList15;
                ArrayList arrayList24 = arrayList18;
                boolean z8 = z6;
                ArrayList arrayList25 = arrayList17;
                ArrayList arrayList26 = new ArrayList();
                HashSet hashSet = new HashSet();
                for (int i10 = 0; i10 < arrayList11.size(); i10++) {
                    h.b bVar2 = (h.b) arrayList11.get(i10);
                    if (hashSet.add(bVar2.f9134a)) {
                        i2.a.g(bVar2.f9135b.f5064n == null);
                        arrayList26.add(bVar2.a(bVar2.f9135b.b().Z(new b1.a(new q(null, null, (List) i2.a.e((ArrayList) hashMap4.get(bVar2.f9134a))))).G()));
                    }
                }
                Uri uri = null;
                ArrayList arrayList27 = null;
                y1 y1Var2 = null;
                int i11 = 0;
                while (i11 < arrayList19.size()) {
                    ArrayList arrayList28 = arrayList19;
                    String str7 = (String) arrayList28.get(i11);
                    String z9 = z(str7, Q, hashMap3);
                    String z10 = z(str7, P, hashMap3);
                    y1.b X2 = new y1.b().U(z9 + ":" + z10).W(z10).M(str6).i0(x(str7)).e0(w(str7, hashMap3)).X(v(str7, O, hashMap3));
                    String v5 = v(str7, K, hashMap3);
                    Uri e6 = v5 == null ? uri : t0.e(str, v5);
                    arrayList19 = arrayList28;
                    String str8 = str6;
                    b1.a aVar = new b1.a(new q(z9, z10, Collections.emptyList()));
                    String z11 = z(str7, M, hashMap3);
                    z11.hashCode();
                    switch (z11.hashCode()) {
                        case -959297733:
                            if (z11.equals("SUBTITLES")) {
                                c6 = 0;
                                break;
                            }
                            c6 = 65535;
                            break;
                        case -333210994:
                            if (z11.equals("CLOSED-CAPTIONS")) {
                                c6 = 1;
                                break;
                            }
                            c6 = 65535;
                            break;
                        case 62628790:
                            if (z11.equals("AUDIO")) {
                                c6 = 2;
                                break;
                            }
                            c6 = 65535;
                            break;
                        case 81665115:
                            if (z11.equals("VIDEO")) {
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
                        case 0:
                            y1Var = y1Var2;
                            arrayList = arrayList21;
                            arrayList2 = arrayList20;
                            h.b g6 = g(arrayList11, z9);
                            if (g6 != null) {
                                String L2 = c1.L(g6.f9135b.f5063m, 3);
                                X2.K(L2);
                                str2 = x.g(L2);
                            } else {
                                str2 = null;
                            }
                            if (str2 == null) {
                                str2 = "text/vtt";
                            }
                            X2.g0(str2).Z(aVar);
                            if (e6 != null) {
                                h.a aVar2 = new h.a(e6, X2.G(), z9, z10);
                                arrayList3 = arrayList22;
                                arrayList3.add(aVar2);
                                break;
                            } else {
                                arrayList3 = arrayList22;
                                t.i("HlsPlaylistParser", "EXT-X-MEDIA tag with missing mandatory URI attribute: skipping");
                                break;
                            }
                        case 1:
                            y1Var = y1Var2;
                            arrayList = arrayList21;
                            arrayList2 = arrayList20;
                            String z12 = z(str7, S, hashMap3);
                            if (z12.startsWith("CC")) {
                                parseInt = Integer.parseInt(z12.substring(2));
                                str3 = "application/cea-608";
                            } else {
                                parseInt = Integer.parseInt(z12.substring(7));
                                str3 = "application/cea-708";
                            }
                            if (arrayList27 == null) {
                                arrayList27 = new ArrayList();
                            }
                            X2.g0(str3).H(parseInt);
                            arrayList27.add(X2.G());
                            arrayList3 = arrayList22;
                            break;
                        case 2:
                            arrayList2 = arrayList20;
                            h.b f6 = f(arrayList11, z9);
                            if (f6 != null) {
                                y1Var = y1Var2;
                                String L3 = c1.L(f6.f9135b.f5063m, 1);
                                X2.K(L3);
                                str4 = x.g(L3);
                            } else {
                                y1Var = y1Var2;
                                str4 = null;
                            }
                            String v6 = v(str7, f9151i, hashMap3);
                            if (v6 != null) {
                                X2.J(Integer.parseInt(c1.V0(v6, "/")[0]));
                                if ("audio/eac3".equals(str4) && v6.endsWith("/JOC")) {
                                    X2.K("ec+3");
                                    str4 = "audio/eac3-joc";
                                }
                            }
                            X2.g0(str4);
                            if (e6 != null) {
                                X2.Z(aVar);
                                arrayList = arrayList21;
                                arrayList.add(new h.a(e6, X2.G(), z9, z10));
                            } else {
                                arrayList = arrayList21;
                                if (f6 != null) {
                                    y1Var = X2.G();
                                }
                            }
                            arrayList3 = arrayList22;
                            break;
                        case 3:
                            h.b h6 = h(arrayList11, z9);
                            if (h6 != null) {
                                y1 y1Var3 = h6.f9135b;
                                String L4 = c1.L(y1Var3.f5063m, 2);
                                X2.K(L4).g0(x.g(L4)).n0(y1Var3.f5071u).S(y1Var3.f5072v).R(y1Var3.f5073w);
                            }
                            if (e6 != null) {
                                X2.Z(aVar);
                                arrayList2 = arrayList20;
                                arrayList2.add(new h.a(e6, X2.G(), z9, z10));
                                y1Var = y1Var2;
                                arrayList3 = arrayList22;
                                arrayList = arrayList21;
                                break;
                            }
                        default:
                            y1Var = y1Var2;
                            arrayList3 = arrayList22;
                            arrayList = arrayList21;
                            arrayList2 = arrayList20;
                            break;
                    }
                    i11++;
                    arrayList22 = arrayList3;
                    arrayList21 = arrayList;
                    arrayList20 = arrayList2;
                    str6 = str8;
                    y1Var2 = y1Var;
                    uri = null;
                }
                return new h(str, arrayList24, arrayList26, arrayList20, arrayList21, arrayList22, arrayList23, y1Var2, z7 ? Collections.emptyList() : arrayList27, z8, hashMap3, arrayList25);
            }
            String b6 = bVar.b();
            if (b6.startsWith("#EXT")) {
                arrayList18.add(b6);
            }
            boolean startsWith = b6.startsWith("#EXT-X-I-FRAME-STREAM-INF");
            boolean z13 = z6;
            if (b6.startsWith("#EXT-X-DEFINE")) {
                hashMap3.put(z(b6, P, hashMap3), z(b6, Z, hashMap3));
            } else {
                if (b6.equals("#EXT-X-INDEPENDENT-SEGMENTS")) {
                    hashMap = hashMap2;
                    arrayList10 = arrayList16;
                    arrayList9 = arrayList12;
                    arrayList8 = arrayList13;
                    arrayList7 = arrayList14;
                    arrayList5 = arrayList15;
                    arrayList6 = arrayList18;
                    arrayList4 = arrayList17;
                    z6 = true;
                } else if (b6.startsWith("#EXT-X-MEDIA")) {
                    arrayList16.add(b6);
                } else if (b6.startsWith("#EXT-X-SESSION-KEY")) {
                    m.b k6 = k(b6, u(b6, I, "identity", hashMap3), hashMap3);
                    if (k6 != null) {
                        arrayList17.add(new m(l(z(b6, H, hashMap3)), k6));
                    }
                } else if (b6.startsWith("#EXT-X-STREAM-INF") || startsWith) {
                    boolean contains = z7 | b6.contains("CLOSED-CAPTIONS=NONE");
                    if (startsWith) {
                        i6 = 16384;
                        z5 = contains;
                    } else {
                        z5 = contains;
                        i6 = 0;
                    }
                    int m6 = m(b6, f9150h);
                    arrayList4 = arrayList17;
                    arrayList5 = arrayList15;
                    int s5 = s(b6, f9145c, -1);
                    String v7 = v(b6, f9152j, hashMap3);
                    arrayList6 = arrayList18;
                    String v8 = v(b6, f9153k, hashMap3);
                    arrayList7 = arrayList14;
                    if (v8 != null) {
                        String[] U0 = c1.U0(v8, "x");
                        int parseInt2 = Integer.parseInt(U0[0]);
                        int parseInt3 = Integer.parseInt(U0[1]);
                        if (parseInt2 <= 0 || parseInt3 <= 0) {
                            parseInt3 = -1;
                            i9 = -1;
                        } else {
                            i9 = parseInt2;
                        }
                        arrayList8 = arrayList13;
                        i8 = parseInt3;
                        i7 = i9;
                    } else {
                        arrayList8 = arrayList13;
                        i7 = -1;
                        i8 = -1;
                    }
                    String v9 = v(b6, f9154l, hashMap3);
                    float parseFloat = v9 != null ? Float.parseFloat(v9) : -1.0f;
                    arrayList9 = arrayList12;
                    String v10 = v(b6, f9146d, hashMap3);
                    arrayList10 = arrayList16;
                    String v11 = v(b6, f9147e, hashMap3);
                    HashMap hashMap5 = hashMap2;
                    String v12 = v(b6, f9148f, hashMap3);
                    String v13 = v(b6, f9149g, hashMap3);
                    if (startsWith) {
                        B2 = z(b6, K, hashMap3);
                    } else {
                        if (!bVar.a()) {
                            throw g3.c("#EXT-X-STREAM-INF must be followed by another line", null);
                        }
                        B2 = B(bVar.b(), hashMap3);
                    }
                    Uri e7 = t0.e(str5, B2);
                    arrayList11.add(new h.b(e7, new y1.b().T(arrayList11.size()).M("application/x-mpegURL").K(v7).I(s5).b0(m6).n0(i7).S(i8).R(parseFloat).e0(i6).G(), v10, v11, v12, v13));
                    hashMap = hashMap5;
                    ArrayList arrayList29 = (ArrayList) hashMap.get(e7);
                    if (arrayList29 == null) {
                        arrayList29 = new ArrayList();
                        hashMap.put(e7, arrayList29);
                    }
                    arrayList29.add(new q.b(s5, m6, v10, v11, v12, v13));
                    z6 = z13;
                    z7 = z5;
                }
                hashMap2 = hashMap;
                arrayList17 = arrayList4;
                arrayList15 = arrayList5;
                arrayList18 = arrayList6;
                arrayList14 = arrayList7;
                arrayList13 = arrayList8;
                arrayList12 = arrayList9;
                arrayList16 = arrayList10;
                str5 = str;
            }
            hashMap = hashMap2;
            arrayList10 = arrayList16;
            arrayList9 = arrayList12;
            arrayList8 = arrayList13;
            arrayList7 = arrayList14;
            arrayList5 = arrayList15;
            arrayList6 = arrayList18;
            arrayList4 = arrayList17;
            z6 = z13;
            hashMap2 = hashMap;
            arrayList17 = arrayList4;
            arrayList15 = arrayList5;
            arrayList18 = arrayList6;
            arrayList14 = arrayList7;
            arrayList13 = arrayList8;
            arrayList12 = arrayList9;
            arrayList16 = arrayList10;
            str5 = str;
        }
    }

    private static boolean q(String str, Pattern pattern, boolean z5) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? "YES".equals(matcher.group(1)) : z5;
    }

    private static double r(String str, Pattern pattern, double d6) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? Double.parseDouble((String) i2.a.e(matcher.group(1))) : d6;
    }

    private static int s(String str, Pattern pattern, int i6) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? Integer.parseInt((String) i2.a.e(matcher.group(1))) : i6;
    }

    private static long t(String str, Pattern pattern, long j6) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? Long.parseLong((String) i2.a.e(matcher.group(1))) : j6;
    }

    private static String u(String str, Pattern pattern, String str2, Map<String, String> map) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            str2 = (String) i2.a.e(matcher.group(1));
        }
        return (map.isEmpty() || str2 == null) ? str2 : B(str2, map);
    }

    private static String v(String str, Pattern pattern, Map<String, String> map) {
        return u(str, pattern, null, map);
    }

    private static int w(String str, Map<String, String> map) {
        String v5 = v(str, R, map);
        if (TextUtils.isEmpty(v5)) {
            return 0;
        }
        String[] U0 = c1.U0(v5, ",");
        int i6 = c1.s(U0, "public.accessibility.describes-video") ? 512 : 0;
        if (c1.s(U0, "public.accessibility.transcribes-spoken-dialog")) {
            i6 |= 4096;
        }
        if (c1.s(U0, "public.accessibility.describes-music-and-sound")) {
            i6 |= 1024;
        }
        return c1.s(U0, "public.easy-to-read") ? i6 | 8192 : i6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    private static int x(String str) {
        boolean q6 = q(str, U, false);
        ?? r02 = q6;
        if (q(str, V, false)) {
            r02 = (q6 ? 1 : 0) | 2;
        }
        return q(str, T, false) ? r02 | 4 : r02;
    }

    private static g.f y(String str) {
        double r6 = r(str, f9160r, -9.223372036854776E18d);
        long j6 = r6 == -9.223372036854776E18d ? -9223372036854775807L : (long) (r6 * 1000000.0d);
        boolean q6 = q(str, f9161s, false);
        double r7 = r(str, f9163u, -9.223372036854776E18d);
        long j7 = r7 == -9.223372036854776E18d ? -9223372036854775807L : (long) (r7 * 1000000.0d);
        double r8 = r(str, f9164v, -9.223372036854776E18d);
        return new g.f(j6, q6, j7, r8 != -9.223372036854776E18d ? (long) (r8 * 1000000.0d) : -9223372036854775807L, q(str, f9165w, false));
    }

    private static String z(String str, Pattern pattern, Map<String, String> map) {
        String v5 = v(str, pattern, map);
        if (v5 != null) {
            return v5;
        }
        throw g3.c("Couldn't match " + pattern.pattern() + " in " + str, null);
    }

    @Override // g2.k0.a
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public i a(Uri uri, InputStream inputStream) {
        String trim;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        ArrayDeque arrayDeque = new ArrayDeque();
        try {
            if (!b(bufferedReader)) {
                throw g3.c("Input does not start with the #EXTM3U header.", null);
            }
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    c1.n(bufferedReader);
                    throw g3.c("Failed to parse the playlist, could not identify any tags.", null);
                }
                trim = readLine.trim();
                if (!trim.isEmpty()) {
                    if (!trim.startsWith("#EXT-X-STREAM-INF")) {
                        if (trim.startsWith("#EXT-X-TARGETDURATION") || trim.startsWith("#EXT-X-MEDIA-SEQUENCE") || trim.startsWith("#EXTINF") || trim.startsWith("#EXT-X-KEY") || trim.startsWith("#EXT-X-BYTERANGE") || trim.equals("#EXT-X-DISCONTINUITY") || trim.equals("#EXT-X-DISCONTINUITY-SEQUENCE") || trim.equals("#EXT-X-ENDLIST")) {
                            break;
                        }
                        arrayDeque.add(trim);
                    } else {
                        arrayDeque.add(trim);
                        return p(new b(arrayDeque, bufferedReader), uri.toString());
                    }
                }
            }
            arrayDeque.add(trim);
            return o(this.f9169a, this.f9170b, new b(arrayDeque, bufferedReader), uri.toString());
        } finally {
            c1.n(bufferedReader);
        }
    }
}
