package g2;

import android.content.Context;
import android.os.Handler;
import com.tendcloud.tenddata.ab;
import com.tendcloud.tenddata.ay;
import com.tendcloud.tenddata.zz;
import g2.f;
import i2.a0;
import i2.c1;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class t implements f, u0 {

    /* renamed from: p, reason: collision with root package name */
    public static final m2.q<Long> f4142p = m2.q.t(4400000L, 3200000L, 2300000L, 1600000L, 810000L);

    /* renamed from: q, reason: collision with root package name */
    public static final m2.q<Long> f4143q = m2.q.t(1400000L, 990000L, 730000L, 510000L, 230000L);

    /* renamed from: r, reason: collision with root package name */
    public static final m2.q<Long> f4144r = m2.q.t(2100000L, 1400000L, 1000000L, 890000L, 640000L);

    /* renamed from: s, reason: collision with root package name */
    public static final m2.q<Long> f4145s = m2.q.t(2600000L, 1700000L, 1300000L, 1000000L, 700000L);

    /* renamed from: t, reason: collision with root package name */
    public static final m2.q<Long> f4146t = m2.q.t(5700000L, 3700000L, 2300000L, 1700000L, 990000L);

    /* renamed from: u, reason: collision with root package name */
    public static final m2.q<Long> f4147u = m2.q.t(2800000L, 1800000L, 1400000L, 1100000L, 870000L);

    /* renamed from: v, reason: collision with root package name */
    private static t f4148v;

    /* renamed from: a, reason: collision with root package name */
    private final m2.r<Integer, Long> f4149a;

    /* renamed from: b, reason: collision with root package name */
    private final f.a.C0077a f4150b;

    /* renamed from: c, reason: collision with root package name */
    private final r0 f4151c;

    /* renamed from: d, reason: collision with root package name */
    private final i2.e f4152d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f4153e;

    /* renamed from: f, reason: collision with root package name */
    private int f4154f;

    /* renamed from: g, reason: collision with root package name */
    private long f4155g;

    /* renamed from: h, reason: collision with root package name */
    private long f4156h;

    /* renamed from: i, reason: collision with root package name */
    private int f4157i;

    /* renamed from: j, reason: collision with root package name */
    private long f4158j;

    /* renamed from: k, reason: collision with root package name */
    private long f4159k;

    /* renamed from: l, reason: collision with root package name */
    private long f4160l;

    /* renamed from: m, reason: collision with root package name */
    private long f4161m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f4162n;

    /* renamed from: o, reason: collision with root package name */
    private int f4163o;

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final Context f4164a;

        /* renamed from: b, reason: collision with root package name */
        private Map<Integer, Long> f4165b;

        /* renamed from: c, reason: collision with root package name */
        private int f4166c;

        /* renamed from: d, reason: collision with root package name */
        private i2.e f4167d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f4168e;

        public b(Context context) {
            this.f4164a = context == null ? null : context.getApplicationContext();
            this.f4165b = b(c1.N(context));
            this.f4166c = 2000;
            this.f4167d = i2.e.f5563a;
            this.f4168e = true;
        }

        private static Map<Integer, Long> b(String str) {
            int[] l6 = t.l(str);
            HashMap hashMap = new HashMap(8);
            hashMap.put(0, 1000000L);
            m2.q<Long> qVar = t.f4142p;
            hashMap.put(2, qVar.get(l6[0]));
            hashMap.put(3, t.f4143q.get(l6[1]));
            hashMap.put(4, t.f4144r.get(l6[2]));
            hashMap.put(5, t.f4145s.get(l6[3]));
            hashMap.put(10, t.f4146t.get(l6[4]));
            hashMap.put(9, t.f4147u.get(l6[5]));
            hashMap.put(7, qVar.get(l6[0]));
            return hashMap;
        }

        public t a() {
            return new t(this.f4164a, this.f4165b, this.f4166c, this.f4167d, this.f4168e);
        }
    }

    private t(Context context, Map<Integer, Long> map, int i6, i2.e eVar, boolean z5) {
        this.f4149a = m2.r.c(map);
        this.f4150b = new f.a.C0077a();
        this.f4151c = new r0(i6);
        this.f4152d = eVar;
        this.f4153e = z5;
        if (context == null) {
            this.f4157i = 0;
            this.f4160l = m(0);
            return;
        }
        i2.a0 d6 = i2.a0.d(context);
        int f6 = d6.f();
        this.f4157i = f6;
        this.f4160l = m(f6);
        d6.i(new a0.c() { // from class: g2.s
            @Override // i2.a0.c
            public final void a(int i7) {
                t.this.q(i7);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static int[] l(String str) {
        str.hashCode();
        char c6 = 65535;
        switch (str.hashCode()) {
            case 2083:
                if (str.equals("AD")) {
                    c6 = 0;
                    break;
                }
                break;
            case 2084:
                if (str.equals("AE")) {
                    c6 = 1;
                    break;
                }
                break;
            case 2085:
                if (str.equals("AF")) {
                    c6 = 2;
                    break;
                }
                break;
            case 2086:
                if (str.equals("AG")) {
                    c6 = 3;
                    break;
                }
                break;
            case 2088:
                if (str.equals("AI")) {
                    c6 = 4;
                    break;
                }
                break;
            case 2091:
                if (str.equals("AL")) {
                    c6 = 5;
                    break;
                }
                break;
            case 2092:
                if (str.equals("AM")) {
                    c6 = 6;
                    break;
                }
                break;
            case 2094:
                if (str.equals("AO")) {
                    c6 = 7;
                    break;
                }
                break;
            case 2096:
                if (str.equals("AQ")) {
                    c6 = '\b';
                    break;
                }
                break;
            case 2098:
                if (str.equals("AS")) {
                    c6 = '\t';
                    break;
                }
                break;
            case 2099:
                if (str.equals("AT")) {
                    c6 = '\n';
                    break;
                }
                break;
            case 2100:
                if (str.equals("AU")) {
                    c6 = 11;
                    break;
                }
                break;
            case 2102:
                if (str.equals("AW")) {
                    c6 = '\f';
                    break;
                }
                break;
            case 2103:
                if (str.equals("AX")) {
                    c6 = '\r';
                    break;
                }
                break;
            case 2105:
                if (str.equals("AZ")) {
                    c6 = 14;
                    break;
                }
                break;
            case 2111:
                if (str.equals("BA")) {
                    c6 = 15;
                    break;
                }
                break;
            case 2112:
                if (str.equals("BB")) {
                    c6 = 16;
                    break;
                }
                break;
            case 2114:
                if (str.equals("BD")) {
                    c6 = 17;
                    break;
                }
                break;
            case 2115:
                if (str.equals("BE")) {
                    c6 = 18;
                    break;
                }
                break;
            case 2116:
                if (str.equals("BF")) {
                    c6 = 19;
                    break;
                }
                break;
            case 2117:
                if (str.equals("BG")) {
                    c6 = 20;
                    break;
                }
                break;
            case 2118:
                if (str.equals("BH")) {
                    c6 = 21;
                    break;
                }
                break;
            case 2119:
                if (str.equals("BI")) {
                    c6 = 22;
                    break;
                }
                break;
            case 2120:
                if (str.equals("BJ")) {
                    c6 = 23;
                    break;
                }
                break;
            case 2122:
                if (str.equals("BL")) {
                    c6 = 24;
                    break;
                }
                break;
            case 2123:
                if (str.equals("BM")) {
                    c6 = 25;
                    break;
                }
                break;
            case 2124:
                if (str.equals("BN")) {
                    c6 = 26;
                    break;
                }
                break;
            case 2125:
                if (str.equals("BO")) {
                    c6 = 27;
                    break;
                }
                break;
            case 2127:
                if (str.equals("BQ")) {
                    c6 = 28;
                    break;
                }
                break;
            case 2128:
                if (str.equals("BR")) {
                    c6 = 29;
                    break;
                }
                break;
            case 2129:
                if (str.equals("BS")) {
                    c6 = 30;
                    break;
                }
                break;
            case 2130:
                if (str.equals("BT")) {
                    c6 = 31;
                    break;
                }
                break;
            case 2133:
                if (str.equals("BW")) {
                    c6 = ' ';
                    break;
                }
                break;
            case 2135:
                if (str.equals("BY")) {
                    c6 = '!';
                    break;
                }
                break;
            case 2136:
                if (str.equals("BZ")) {
                    c6 = '\"';
                    break;
                }
                break;
            case 2142:
                if (str.equals("CA")) {
                    c6 = '#';
                    break;
                }
                break;
            case 2145:
                if (str.equals("CD")) {
                    c6 = '$';
                    break;
                }
                break;
            case 2147:
                if (str.equals("CF")) {
                    c6 = '%';
                    break;
                }
                break;
            case 2148:
                if (str.equals("CG")) {
                    c6 = '&';
                    break;
                }
                break;
            case 2149:
                if (str.equals("CH")) {
                    c6 = '\'';
                    break;
                }
                break;
            case 2150:
                if (str.equals("CI")) {
                    c6 = '(';
                    break;
                }
                break;
            case 2152:
                if (str.equals("CK")) {
                    c6 = ')';
                    break;
                }
                break;
            case 2153:
                if (str.equals("CL")) {
                    c6 = '*';
                    break;
                }
                break;
            case 2154:
                if (str.equals("CM")) {
                    c6 = '+';
                    break;
                }
                break;
            case 2155:
                if (str.equals("CN")) {
                    c6 = ',';
                    break;
                }
                break;
            case 2156:
                if (str.equals("CO")) {
                    c6 = '-';
                    break;
                }
                break;
            case 2159:
                if (str.equals("CR")) {
                    c6 = '.';
                    break;
                }
                break;
            case 2162:
                if (str.equals("CU")) {
                    c6 = '/';
                    break;
                }
                break;
            case 2163:
                if (str.equals("CV")) {
                    c6 = '0';
                    break;
                }
                break;
            case 2164:
                if (str.equals("CW")) {
                    c6 = '1';
                    break;
                }
                break;
            case 2165:
                if (str.equals("CX")) {
                    c6 = '2';
                    break;
                }
                break;
            case 2166:
                if (str.equals("CY")) {
                    c6 = '3';
                    break;
                }
                break;
            case 2167:
                if (str.equals("CZ")) {
                    c6 = '4';
                    break;
                }
                break;
            case 2177:
                if (str.equals("DE")) {
                    c6 = '5';
                    break;
                }
                break;
            case 2182:
                if (str.equals("DJ")) {
                    c6 = '6';
                    break;
                }
                break;
            case 2183:
                if (str.equals("DK")) {
                    c6 = '7';
                    break;
                }
                break;
            case 2185:
                if (str.equals("DM")) {
                    c6 = '8';
                    break;
                }
                break;
            case 2187:
                if (str.equals("DO")) {
                    c6 = '9';
                    break;
                }
                break;
            case 2198:
                if (str.equals("DZ")) {
                    c6 = ':';
                    break;
                }
                break;
            case 2206:
                if (str.equals("EC")) {
                    c6 = ';';
                    break;
                }
                break;
            case 2208:
                if (str.equals("EE")) {
                    c6 = '<';
                    break;
                }
                break;
            case 2210:
                if (str.equals("EG")) {
                    c6 = '=';
                    break;
                }
                break;
            case 2221:
                if (str.equals("ER")) {
                    c6 = '>';
                    break;
                }
                break;
            case 2222:
                if (str.equals("ES")) {
                    c6 = '?';
                    break;
                }
                break;
            case 2223:
                if (str.equals("ET")) {
                    c6 = '@';
                    break;
                }
                break;
            case 2243:
                if (str.equals("FI")) {
                    c6 = 'A';
                    break;
                }
                break;
            case 2244:
                if (str.equals("FJ")) {
                    c6 = 'B';
                    break;
                }
                break;
            case 2247:
                if (str.equals("FM")) {
                    c6 = 'C';
                    break;
                }
                break;
            case 2249:
                if (str.equals("FO")) {
                    c6 = 'D';
                    break;
                }
                break;
            case 2252:
                if (str.equals("FR")) {
                    c6 = 'E';
                    break;
                }
                break;
            case 2266:
                if (str.equals("GA")) {
                    c6 = 'F';
                    break;
                }
                break;
            case 2267:
                if (str.equals("GB")) {
                    c6 = 'G';
                    break;
                }
                break;
            case 2269:
                if (str.equals("GD")) {
                    c6 = 'H';
                    break;
                }
                break;
            case 2270:
                if (str.equals("GE")) {
                    c6 = 'I';
                    break;
                }
                break;
            case 2271:
                if (str.equals("GF")) {
                    c6 = 'J';
                    break;
                }
                break;
            case 2272:
                if (str.equals("GG")) {
                    c6 = 'K';
                    break;
                }
                break;
            case 2273:
                if (str.equals("GH")) {
                    c6 = 'L';
                    break;
                }
                break;
            case 2274:
                if (str.equals("GI")) {
                    c6 = 'M';
                    break;
                }
                break;
            case 2277:
                if (str.equals("GL")) {
                    c6 = 'N';
                    break;
                }
                break;
            case 2278:
                if (str.equals("GM")) {
                    c6 = 'O';
                    break;
                }
                break;
            case 2279:
                if (str.equals("GN")) {
                    c6 = 'P';
                    break;
                }
                break;
            case 2281:
                if (str.equals("GP")) {
                    c6 = 'Q';
                    break;
                }
                break;
            case 2282:
                if (str.equals("GQ")) {
                    c6 = 'R';
                    break;
                }
                break;
            case 2283:
                if (str.equals("GR")) {
                    c6 = 'S';
                    break;
                }
                break;
            case 2285:
                if (str.equals("GT")) {
                    c6 = 'T';
                    break;
                }
                break;
            case 2286:
                if (str.equals("GU")) {
                    c6 = 'U';
                    break;
                }
                break;
            case 2288:
                if (str.equals("GW")) {
                    c6 = 'V';
                    break;
                }
                break;
            case 2290:
                if (str.equals("GY")) {
                    c6 = 'W';
                    break;
                }
                break;
            case 2307:
                if (str.equals("HK")) {
                    c6 = 'X';
                    break;
                }
                break;
            case 2310:
                if (str.equals("HN")) {
                    c6 = 'Y';
                    break;
                }
                break;
            case 2314:
                if (str.equals("HR")) {
                    c6 = 'Z';
                    break;
                }
                break;
            case 2316:
                if (str.equals("HT")) {
                    c6 = '[';
                    break;
                }
                break;
            case 2317:
                if (str.equals("HU")) {
                    c6 = '\\';
                    break;
                }
                break;
            case 2331:
                if (str.equals("ID")) {
                    c6 = ']';
                    break;
                }
                break;
            case 2332:
                if (str.equals("IE")) {
                    c6 = '^';
                    break;
                }
                break;
            case 2339:
                if (str.equals("IL")) {
                    c6 = '_';
                    break;
                }
                break;
            case 2340:
                if (str.equals("IM")) {
                    c6 = '`';
                    break;
                }
                break;
            case 2341:
                if (str.equals("IN")) {
                    c6 = 'a';
                    break;
                }
                break;
            case 2342:
                if (str.equals("IO")) {
                    c6 = 'b';
                    break;
                }
                break;
            case 2344:
                if (str.equals("IQ")) {
                    c6 = 'c';
                    break;
                }
                break;
            case 2345:
                if (str.equals("IR")) {
                    c6 = 'd';
                    break;
                }
                break;
            case 2346:
                if (str.equals("IS")) {
                    c6 = 'e';
                    break;
                }
                break;
            case 2347:
                if (str.equals("IT")) {
                    c6 = 'f';
                    break;
                }
                break;
            case 2363:
                if (str.equals("JE")) {
                    c6 = 'g';
                    break;
                }
                break;
            case 2371:
                if (str.equals("JM")) {
                    c6 = 'h';
                    break;
                }
                break;
            case 2373:
                if (str.equals("JO")) {
                    c6 = 'i';
                    break;
                }
                break;
            case 2374:
                if (str.equals("JP")) {
                    c6 = 'j';
                    break;
                }
                break;
            case 2394:
                if (str.equals("KE")) {
                    c6 = 'k';
                    break;
                }
                break;
            case 2396:
                if (str.equals("KG")) {
                    c6 = 'l';
                    break;
                }
                break;
            case 2397:
                if (str.equals("KH")) {
                    c6 = 'm';
                    break;
                }
                break;
            case 2398:
                if (str.equals("KI")) {
                    c6 = 'n';
                    break;
                }
                break;
            case 2402:
                if (str.equals("KM")) {
                    c6 = 'o';
                    break;
                }
                break;
            case 2403:
                if (str.equals("KN")) {
                    c6 = 'p';
                    break;
                }
                break;
            case 2407:
                if (str.equals("KR")) {
                    c6 = 'q';
                    break;
                }
                break;
            case 2412:
                if (str.equals("KW")) {
                    c6 = 'r';
                    break;
                }
                break;
            case 2414:
                if (str.equals("KY")) {
                    c6 = 's';
                    break;
                }
                break;
            case 2415:
                if (str.equals("KZ")) {
                    c6 = 't';
                    break;
                }
                break;
            case 2421:
                if (str.equals("LA")) {
                    c6 = 'u';
                    break;
                }
                break;
            case 2422:
                if (str.equals("LB")) {
                    c6 = 'v';
                    break;
                }
                break;
            case 2423:
                if (str.equals("LC")) {
                    c6 = 'w';
                    break;
                }
                break;
            case 2429:
                if (str.equals("LI")) {
                    c6 = 'x';
                    break;
                }
                break;
            case 2431:
                if (str.equals("LK")) {
                    c6 = 'y';
                    break;
                }
                break;
            case 2438:
                if (str.equals("LR")) {
                    c6 = 'z';
                    break;
                }
                break;
            case 2439:
                if (str.equals("LS")) {
                    c6 = '{';
                    break;
                }
                break;
            case 2440:
                if (str.equals("LT")) {
                    c6 = '|';
                    break;
                }
                break;
            case 2441:
                if (str.equals("LU")) {
                    c6 = '}';
                    break;
                }
                break;
            case 2442:
                if (str.equals("LV")) {
                    c6 = '~';
                    break;
                }
                break;
            case 2445:
                if (str.equals("LY")) {
                    c6 = 127;
                    break;
                }
                break;
            case 2452:
                if (str.equals("MA")) {
                    c6 = 128;
                    break;
                }
                break;
            case 2454:
                if (str.equals("MC")) {
                    c6 = 129;
                    break;
                }
                break;
            case 2455:
                if (str.equals("MD")) {
                    c6 = 130;
                    break;
                }
                break;
            case 2456:
                if (str.equals("ME")) {
                    c6 = 131;
                    break;
                }
                break;
            case 2457:
                if (str.equals("MF")) {
                    c6 = 132;
                    break;
                }
                break;
            case 2458:
                if (str.equals("MG")) {
                    c6 = 133;
                    break;
                }
                break;
            case 2459:
                if (str.equals("MH")) {
                    c6 = 134;
                    break;
                }
                break;
            case 2462:
                if (str.equals("MK")) {
                    c6 = 135;
                    break;
                }
                break;
            case 2463:
                if (str.equals("ML")) {
                    c6 = 136;
                    break;
                }
                break;
            case 2464:
                if (str.equals("MM")) {
                    c6 = 137;
                    break;
                }
                break;
            case 2465:
                if (str.equals("MN")) {
                    c6 = 138;
                    break;
                }
                break;
            case 2466:
                if (str.equals("MO")) {
                    c6 = 139;
                    break;
                }
                break;
            case 2467:
                if (str.equals("MP")) {
                    c6 = 140;
                    break;
                }
                break;
            case 2468:
                if (str.equals("MQ")) {
                    c6 = 141;
                    break;
                }
                break;
            case 2469:
                if (str.equals("MR")) {
                    c6 = 142;
                    break;
                }
                break;
            case 2470:
                if (str.equals("MS")) {
                    c6 = 143;
                    break;
                }
                break;
            case 2471:
                if (str.equals("MT")) {
                    c6 = 144;
                    break;
                }
                break;
            case 2472:
                if (str.equals("MU")) {
                    c6 = 145;
                    break;
                }
                break;
            case 2473:
                if (str.equals("MV")) {
                    c6 = 146;
                    break;
                }
                break;
            case 2474:
                if (str.equals("MW")) {
                    c6 = 147;
                    break;
                }
                break;
            case 2475:
                if (str.equals("MX")) {
                    c6 = 148;
                    break;
                }
                break;
            case 2476:
                if (str.equals("MY")) {
                    c6 = 149;
                    break;
                }
                break;
            case 2477:
                if (str.equals("MZ")) {
                    c6 = 150;
                    break;
                }
                break;
            case 2483:
                if (str.equals("NA")) {
                    c6 = 151;
                    break;
                }
                break;
            case 2485:
                if (str.equals("NC")) {
                    c6 = 152;
                    break;
                }
                break;
            case 2487:
                if (str.equals("NE")) {
                    c6 = 153;
                    break;
                }
                break;
            case 2489:
                if (str.equals("NG")) {
                    c6 = 154;
                    break;
                }
                break;
            case 2491:
                if (str.equals("NI")) {
                    c6 = 155;
                    break;
                }
                break;
            case 2494:
                if (str.equals("NL")) {
                    c6 = 156;
                    break;
                }
                break;
            case 2497:
                if (str.equals("NO")) {
                    c6 = 157;
                    break;
                }
                break;
            case 2498:
                if (str.equals("NP")) {
                    c6 = 158;
                    break;
                }
                break;
            case 2500:
                if (str.equals("NR")) {
                    c6 = 159;
                    break;
                }
                break;
            case 2503:
                if (str.equals("NU")) {
                    c6 = 160;
                    break;
                }
                break;
            case 2508:
                if (str.equals("NZ")) {
                    c6 = 161;
                    break;
                }
                break;
            case 2526:
                if (str.equals("OM")) {
                    c6 = 162;
                    break;
                }
                break;
            case 2545:
                if (str.equals("PA")) {
                    c6 = 163;
                    break;
                }
                break;
            case 2549:
                if (str.equals("PE")) {
                    c6 = 164;
                    break;
                }
                break;
            case 2550:
                if (str.equals("PF")) {
                    c6 = 165;
                    break;
                }
                break;
            case 2551:
                if (str.equals("PG")) {
                    c6 = 166;
                    break;
                }
                break;
            case 2552:
                if (str.equals("PH")) {
                    c6 = 167;
                    break;
                }
                break;
            case 2555:
                if (str.equals("PK")) {
                    c6 = 168;
                    break;
                }
                break;
            case 2556:
                if (str.equals("PL")) {
                    c6 = 169;
                    break;
                }
                break;
            case 2557:
                if (str.equals("PM")) {
                    c6 = 170;
                    break;
                }
                break;
            case 2562:
                if (str.equals("PR")) {
                    c6 = 171;
                    break;
                }
                break;
            case 2563:
                if (str.equals("PS")) {
                    c6 = 172;
                    break;
                }
                break;
            case 2564:
                if (str.equals("PT")) {
                    c6 = 173;
                    break;
                }
                break;
            case 2567:
                if (str.equals("PW")) {
                    c6 = 174;
                    break;
                }
                break;
            case 2569:
                if (str.equals("PY")) {
                    c6 = 175;
                    break;
                }
                break;
            case 2576:
                if (str.equals("QA")) {
                    c6 = 176;
                    break;
                }
                break;
            case 2611:
                if (str.equals("RE")) {
                    c6 = 177;
                    break;
                }
                break;
            case 2621:
                if (str.equals("RO")) {
                    c6 = 178;
                    break;
                }
                break;
            case 2625:
                if (str.equals("RS")) {
                    c6 = 179;
                    break;
                }
                break;
            case 2627:
                if (str.equals("RU")) {
                    c6 = 180;
                    break;
                }
                break;
            case 2629:
                if (str.equals("RW")) {
                    c6 = 181;
                    break;
                }
                break;
            case 2638:
                if (str.equals("SA")) {
                    c6 = 182;
                    break;
                }
                break;
            case 2639:
                if (str.equals("SB")) {
                    c6 = 183;
                    break;
                }
                break;
            case 2640:
                if (str.equals("SC")) {
                    c6 = 184;
                    break;
                }
                break;
            case 2641:
                if (str.equals("SD")) {
                    c6 = 185;
                    break;
                }
                break;
            case 2642:
                if (str.equals("SE")) {
                    c6 = 186;
                    break;
                }
                break;
            case 2644:
                if (str.equals("SG")) {
                    c6 = 187;
                    break;
                }
                break;
            case 2645:
                if (str.equals("SH")) {
                    c6 = 188;
                    break;
                }
                break;
            case 2646:
                if (str.equals("SI")) {
                    c6 = 189;
                    break;
                }
                break;
            case 2647:
                if (str.equals("SJ")) {
                    c6 = 190;
                    break;
                }
                break;
            case 2648:
                if (str.equals("SK")) {
                    c6 = 191;
                    break;
                }
                break;
            case 2649:
                if (str.equals("SL")) {
                    c6 = 192;
                    break;
                }
                break;
            case 2650:
                if (str.equals("SM")) {
                    c6 = 193;
                    break;
                }
                break;
            case 2651:
                if (str.equals("SN")) {
                    c6 = 194;
                    break;
                }
                break;
            case 2652:
                if (str.equals("SO")) {
                    c6 = 195;
                    break;
                }
                break;
            case 2655:
                if (str.equals("SR")) {
                    c6 = 196;
                    break;
                }
                break;
            case 2656:
                if (str.equals("SS")) {
                    c6 = 197;
                    break;
                }
                break;
            case 2657:
                if (str.equals("ST")) {
                    c6 = 198;
                    break;
                }
                break;
            case 2659:
                if (str.equals("SV")) {
                    c6 = 199;
                    break;
                }
                break;
            case 2661:
                if (str.equals("SX")) {
                    c6 = 200;
                    break;
                }
                break;
            case 2662:
                if (str.equals("SY")) {
                    c6 = 201;
                    break;
                }
                break;
            case 2663:
                if (str.equals("SZ")) {
                    c6 = 202;
                    break;
                }
                break;
            case 2671:
                if (str.equals("TC")) {
                    c6 = 203;
                    break;
                }
                break;
            case 2672:
                if (str.equals(ab.f2246t)) {
                    c6 = 204;
                    break;
                }
                break;
            case 2675:
                if (str.equals("TG")) {
                    c6 = 205;
                    break;
                }
                break;
            case 2676:
                if (str.equals("TH")) {
                    c6 = 206;
                    break;
                }
                break;
            case 2678:
                if (str.equals("TJ")) {
                    c6 = 207;
                    break;
                }
                break;
            case 2679:
                if (str.equals("TK")) {
                    c6 = 208;
                    break;
                }
                break;
            case 2680:
                if (str.equals("TL")) {
                    c6 = 209;
                    break;
                }
                break;
            case 2681:
                if (str.equals("TM")) {
                    c6 = 210;
                    break;
                }
                break;
            case 2682:
                if (str.equals("TN")) {
                    c6 = 211;
                    break;
                }
                break;
            case 2683:
                if (str.equals("TO")) {
                    c6 = 212;
                    break;
                }
                break;
            case 2686:
                if (str.equals("TR")) {
                    c6 = 213;
                    break;
                }
                break;
            case 2688:
                if (str.equals("TT")) {
                    c6 = 214;
                    break;
                }
                break;
            case 2690:
                if (str.equals("TV")) {
                    c6 = 215;
                    break;
                }
                break;
            case 2691:
                if (str.equals("TW")) {
                    c6 = 216;
                    break;
                }
                break;
            case 2694:
                if (str.equals("TZ")) {
                    c6 = 217;
                    break;
                }
                break;
            case 2700:
                if (str.equals("UA")) {
                    c6 = 218;
                    break;
                }
                break;
            case 2706:
                if (str.equals("UG")) {
                    c6 = 219;
                    break;
                }
                break;
            case 2718:
                if (str.equals("US")) {
                    c6 = 220;
                    break;
                }
                break;
            case 2724:
                if (str.equals("UY")) {
                    c6 = 221;
                    break;
                }
                break;
            case 2725:
                if (str.equals("UZ")) {
                    c6 = 222;
                    break;
                }
                break;
            case 2731:
                if (str.equals("VA")) {
                    c6 = 223;
                    break;
                }
                break;
            case 2733:
                if (str.equals("VC")) {
                    c6 = 224;
                    break;
                }
                break;
            case 2735:
                if (str.equals("VE")) {
                    c6 = 225;
                    break;
                }
                break;
            case 2737:
                if (str.equals("VG")) {
                    c6 = 226;
                    break;
                }
                break;
            case 2739:
                if (str.equals("VI")) {
                    c6 = 227;
                    break;
                }
                break;
            case 2744:
                if (str.equals("VN")) {
                    c6 = 228;
                    break;
                }
                break;
            case 2751:
                if (str.equals("VU")) {
                    c6 = 229;
                    break;
                }
                break;
            case 2767:
                if (str.equals("WF")) {
                    c6 = 230;
                    break;
                }
                break;
            case 2780:
                if (str.equals("WS")) {
                    c6 = 231;
                    break;
                }
                break;
            case 2803:
                if (str.equals("XK")) {
                    c6 = 232;
                    break;
                }
                break;
            case 2828:
                if (str.equals("YE")) {
                    c6 = 233;
                    break;
                }
                break;
            case 2843:
                if (str.equals("YT")) {
                    c6 = 234;
                    break;
                }
                break;
            case 2855:
                if (str.equals("ZA")) {
                    c6 = 235;
                    break;
                }
                break;
            case 2867:
                if (str.equals("ZM")) {
                    c6 = 236;
                    break;
                }
                break;
            case 2877:
                if (str.equals("ZW")) {
                    c6 = 237;
                    break;
                }
                break;
        }
        int[] iArr = {2, 2, 0, 0, 2, 2};
        switch (c6) {
            case 0:
            case '1':
                break;
            case 1:
                // fill-array-data instruction
                iArr[0] = 1;
                iArr[1] = 4;
                iArr[2] = 3;
                iArr[3] = 4;
                iArr[4] = 4;
                iArr[5] = 2;
                break;
            case 2:
            case 166:
                // fill-array-data instruction
                iArr[0] = 4;
                iArr[1] = 3;
                iArr[2] = 3;
                iArr[3] = 3;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 3:
                // fill-array-data instruction
                iArr[0] = 2;
                iArr[1] = 4;
                iArr[2] = 3;
                iArr[3] = 4;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 4:
            case 16:
            case 25:
            case 28:
            case '8':
            case 'D':
                // fill-array-data instruction
                iArr[0] = 0;
                iArr[1] = 2;
                iArr[2] = 0;
                iArr[3] = 0;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 5:
                // fill-array-data instruction
                iArr[0] = 1;
                iArr[1] = 1;
                iArr[2] = 1;
                iArr[3] = 3;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 6:
                // fill-array-data instruction
                iArr[0] = 2;
                iArr[1] = 3;
                iArr[2] = 2;
                iArr[3] = 3;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 7:
                // fill-array-data instruction
                iArr[0] = 4;
                iArr[1] = 4;
                iArr[2] = 4;
                iArr[3] = 3;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case '\b':
            case '>':
            case 188:
                // fill-array-data instruction
                iArr[0] = 4;
                iArr[1] = 2;
                iArr[2] = 2;
                iArr[3] = 2;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case '\t':
                // fill-array-data instruction
                iArr[0] = 2;
                iArr[1] = 2;
                iArr[2] = 3;
                iArr[3] = 3;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case '\n':
                // fill-array-data instruction
                iArr[0] = 1;
                iArr[1] = 2;
                iArr[2] = 1;
                iArr[3] = 4;
                iArr[4] = 1;
                iArr[5] = 4;
                break;
            case 11:
                // fill-array-data instruction
                iArr[0] = 0;
                iArr[1] = 2;
                iArr[2] = 1;
                iArr[3] = 1;
                iArr[4] = 3;
                iArr[5] = 0;
                break;
            case '\f':
            case 'U':
                // fill-array-data instruction
                iArr[0] = 1;
                iArr[1] = 2;
                iArr[2] = 4;
                iArr[3] = 4;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case '\r':
            case ay.f2330c /* 50 */:
            case 'x':
            case 140:
            case 143:
            case 170:
            case 193:
            case 223:
                // fill-array-data instruction
                iArr[0] = 0;
                iArr[1] = 2;
                iArr[2] = 2;
                iArr[3] = 2;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 14:
            case 19:
            case ':':
                // fill-array-data instruction
                iArr[0] = 3;
                iArr[1] = 3;
                iArr[2] = 4;
                iArr[3] = 4;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 15:
            case '^':
                // fill-array-data instruction
                iArr[0] = 1;
                iArr[1] = 1;
                iArr[2] = 1;
                iArr[3] = 1;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case ab.b.API_TYPE_INDUSTRY /* 17 */:
            case 't':
                // fill-array-data instruction
                iArr[0] = 2;
                iArr[1] = 1;
                iArr[2] = 2;
                iArr[3] = 2;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 18:
                // fill-array-data instruction
                iArr[0] = 0;
                iArr[1] = 1;
                iArr[2] = 4;
                iArr[3] = 4;
                iArr[4] = 3;
                iArr[5] = 2;
                break;
            case 20:
            case '?':
            case 'S':
            case 189:
                // fill-array-data instruction
                iArr[0] = 0;
                iArr[1] = 0;
                iArr[2] = 0;
                iArr[3] = 0;
                iArr[4] = 1;
                iArr[5] = 2;
                break;
            case 21:
                // fill-array-data instruction
                iArr[0] = 1;
                iArr[1] = 3;
                iArr[2] = 1;
                iArr[3] = 4;
                iArr[4] = 4;
                iArr[5] = 2;
                break;
            case 22:
            case ab.b.API_MYNA_START /* 91 */:
            case 133:
            case 153:
            case 204:
            case 225:
            case 233:
                // fill-array-data instruction
                iArr[0] = 4;
                iArr[1] = 4;
                iArr[2] = 4;
                iArr[3] = 4;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 23:
                // fill-array-data instruction
                iArr[0] = 4;
                iArr[1] = 4;
                iArr[2] = 2;
                iArr[3] = 3;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 24:
            case 132:
            case 175:
                // fill-array-data instruction
                iArr[0] = 1;
                iArr[1] = 2;
                iArr[2] = 2;
                iArr[3] = 2;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 26:
                // fill-array-data instruction
                iArr[0] = 3;
                iArr[1] = 2;
                iArr[2] = 0;
                iArr[3] = 1;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 27:
                // fill-array-data instruction
                iArr[0] = 1;
                iArr[1] = 2;
                iArr[2] = 3;
                iArr[3] = 2;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 29:
                // fill-array-data instruction
                iArr[0] = 1;
                iArr[1] = 1;
                iArr[2] = 2;
                iArr[3] = 1;
                iArr[4] = 1;
                iArr[5] = 0;
                break;
            case 30:
            case 'v':
                // fill-array-data instruction
                iArr[0] = 3;
                iArr[1] = 2;
                iArr[2] = 1;
                iArr[3] = 2;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 31:
            case 150:
            case 231:
                // fill-array-data instruction
                iArr[0] = 3;
                iArr[1] = 1;
                iArr[2] = 2;
                iArr[3] = 1;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case ' ':
                // fill-array-data instruction
                iArr[0] = 3;
                iArr[1] = 2;
                iArr[2] = 1;
                iArr[3] = 0;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case '!':
                // fill-array-data instruction
                iArr[0] = 1;
                iArr[1] = 1;
                iArr[2] = 2;
                iArr[3] = 3;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case '\"':
            case ')':
                // fill-array-data instruction
                iArr[0] = 2;
                iArr[1] = 2;
                iArr[2] = 2;
                iArr[3] = 1;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case '#':
                // fill-array-data instruction
                iArr[0] = 0;
                iArr[1] = 2;
                iArr[2] = 3;
                iArr[3] = 3;
                iArr[4] = 3;
                iArr[5] = 3;
                break;
            case '$':
            case 'o':
                // fill-array-data instruction
                iArr[0] = 4;
                iArr[1] = 3;
                iArr[2] = 3;
                iArr[3] = 2;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case '%':
            case 183:
                // fill-array-data instruction
                iArr[0] = 4;
                iArr[1] = 2;
                iArr[2] = 4;
                iArr[3] = 2;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case '&':
            case 'L':
                // fill-array-data instruction
                iArr[0] = 3;
                iArr[1] = 3;
                iArr[2] = 3;
                iArr[3] = 3;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case '\'':
                // fill-array-data instruction
                iArr[0] = 0;
                iArr[1] = 0;
                iArr[2] = 0;
                iArr[3] = 0;
                iArr[4] = 0;
                iArr[5] = 3;
                break;
            case '(':
            case '=':
                // fill-array-data instruction
                iArr[0] = 3;
                iArr[1] = 4;
                iArr[2] = 3;
                iArr[3] = 3;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case '*':
                // fill-array-data instruction
                iArr[0] = 1;
                iArr[1] = 1;
                iArr[2] = 2;
                iArr[3] = 1;
                iArr[4] = 3;
                iArr[5] = 2;
                break;
            case '+':
                // fill-array-data instruction
                iArr[0] = 4;
                iArr[1] = 3;
                iArr[2] = 3;
                iArr[3] = 4;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case ',':
                // fill-array-data instruction
                iArr[0] = 2;
                iArr[1] = 0;
                iArr[2] = 4;
                iArr[3] = 3;
                iArr[4] = 3;
                iArr[5] = 1;
                break;
            case '-':
                // fill-array-data instruction
                iArr[0] = 2;
                iArr[1] = 3;
                iArr[2] = 4;
                iArr[3] = 2;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case '.':
                // fill-array-data instruction
                iArr[0] = 2;
                iArr[1] = 4;
                iArr[2] = 4;
                iArr[3] = 4;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case '/':
            case 'n':
                // fill-array-data instruction
                iArr[0] = 4;
                iArr[1] = 2;
                iArr[2] = 4;
                iArr[3] = 3;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case '0':
                // fill-array-data instruction
                iArr[0] = 2;
                iArr[1] = 3;
                iArr[2] = 0;
                iArr[3] = 1;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case '3':
            case ab.b.API_MYNA_INIT /* 90 */:
            case '~':
                // fill-array-data instruction
                iArr[0] = 1;
                iArr[1] = 0;
                iArr[2] = 0;
                iArr[3] = 0;
                iArr[4] = 0;
                iArr[5] = 2;
                break;
            case '4':
                // fill-array-data instruction
                iArr[0] = 0;
                iArr[1] = 0;
                iArr[2] = 2;
                iArr[3] = 0;
                iArr[4] = 1;
                iArr[5] = 2;
                break;
            case '5':
                // fill-array-data instruction
                iArr[0] = 0;
                iArr[1] = 1;
                iArr[2] = 3;
                iArr[3] = 2;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case '6':
            case 201:
            case 207:
                // fill-array-data instruction
                iArr[0] = 4;
                iArr[1] = 3;
                iArr[2] = 4;
                iArr[3] = 4;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case '7':
            case '<':
            case ab.b.API_MYNA_STOP /* 92 */:
            case '|':
            case 144:
                // fill-array-data instruction
                iArr[0] = 0;
                iArr[1] = 0;
                iArr[2] = 0;
                iArr[3] = 0;
                iArr[4] = 0;
                iArr[5] = 2;
                break;
            case '9':
                // fill-array-data instruction
                iArr[0] = 3;
                iArr[1] = 4;
                iArr[2] = 4;
                iArr[3] = 4;
                iArr[4] = 4;
                iArr[5] = 2;
                break;
            case ';':
                // fill-array-data instruction
                iArr[0] = 1;
                iArr[1] = 3;
                iArr[2] = 2;
                iArr[3] = 1;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case '@':
            case 194:
                // fill-array-data instruction
                iArr[0] = 4;
                iArr[1] = 4;
                iArr[2] = 3;
                iArr[3] = 2;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 'A':
                // fill-array-data instruction
                iArr[0] = 0;
                iArr[1] = 0;
                iArr[2] = 0;
                iArr[3] = 2;
                iArr[4] = 0;
                iArr[5] = 2;
                break;
            case 'B':
                // fill-array-data instruction
                iArr[0] = 3;
                iArr[1] = 1;
                iArr[2] = 2;
                iArr[3] = 3;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 'C':
                // fill-array-data instruction
                iArr[0] = 4;
                iArr[1] = 2;
                iArr[2] = 3;
                iArr[3] = 0;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 'E':
                // fill-array-data instruction
                iArr[0] = 1;
                iArr[1] = 1;
                iArr[2] = 2;
                iArr[3] = 1;
                iArr[4] = 1;
                iArr[5] = 2;
                break;
            case 'F':
            case 205:
                // fill-array-data instruction
                iArr[0] = 3;
                iArr[1] = 4;
                iArr[2] = 1;
                iArr[3] = 0;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 'G':
                // fill-array-data instruction
                iArr[0] = 0;
                iArr[1] = 1;
                iArr[2] = 1;
                iArr[3] = 2;
                iArr[4] = 1;
                iArr[5] = 2;
                break;
            case 'H':
            case 'p':
            case 's':
            case 'w':
            case 200:
            case 224:
                // fill-array-data instruction
                iArr[0] = 1;
                iArr[1] = 2;
                iArr[2] = 0;
                iArr[3] = 0;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 'I':
                // fill-array-data instruction
                iArr[0] = 1;
                iArr[1] = 0;
                iArr[2] = 0;
                iArr[3] = 2;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 'J':
            case 168:
            case 192:
                // fill-array-data instruction
                iArr[0] = 3;
                iArr[1] = 2;
                iArr[2] = 3;
                iArr[3] = 3;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 'K':
                // fill-array-data instruction
                iArr[0] = 0;
                iArr[1] = 2;
                iArr[2] = 1;
                iArr[3] = 0;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 'M':
            case 'g':
                // fill-array-data instruction
                iArr[0] = 1;
                iArr[1] = 2;
                iArr[2] = 0;
                iArr[3] = 1;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 'N':
            case 208:
                // fill-array-data instruction
                iArr[0] = 2;
                iArr[1] = 2;
                iArr[2] = 2;
                iArr[3] = 4;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 'O':
                // fill-array-data instruction
                iArr[0] = 4;
                iArr[1] = 3;
                iArr[2] = 2;
                iArr[3] = 4;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 'P':
                // fill-array-data instruction
                iArr[0] = 4;
                iArr[1] = 4;
                iArr[2] = 4;
                iArr[3] = 2;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 'Q':
                // fill-array-data instruction
                iArr[0] = 3;
                iArr[1] = 1;
                iArr[2] = 1;
                iArr[3] = 3;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 'R':
                // fill-array-data instruction
                iArr[0] = 4;
                iArr[1] = 4;
                iArr[2] = 3;
                iArr[3] = 3;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 'T':
                // fill-array-data instruction
                iArr[0] = 2;
                iArr[1] = 2;
                iArr[2] = 2;
                iArr[3] = 1;
                iArr[4] = 1;
                iArr[5] = 2;
                break;
            case 'V':
                // fill-array-data instruction
                iArr[0] = 4;
                iArr[1] = 4;
                iArr[2] = 2;
                iArr[3] = 2;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 'W':
                // fill-array-data instruction
                iArr[0] = 3;
                iArr[1] = 0;
                iArr[2] = 1;
                iArr[3] = 1;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 'X':
                // fill-array-data instruction
                iArr[0] = 0;
                iArr[1] = 1;
                iArr[2] = 1;
                iArr[3] = 3;
                iArr[4] = 2;
                iArr[5] = 0;
                break;
            case 'Y':
                // fill-array-data instruction
                iArr[0] = 3;
                iArr[1] = 3;
                iArr[2] = 2;
                iArr[3] = 2;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case ']':
                // fill-array-data instruction
                iArr[0] = 3;
                iArr[1] = 1;
                iArr[2] = 1;
                iArr[3] = 2;
                iArr[4] = 3;
                iArr[5] = 2;
                break;
            case '_':
                // fill-array-data instruction
                iArr[0] = 1;
                iArr[1] = 2;
                iArr[2] = 2;
                iArr[3] = 3;
                iArr[4] = 4;
                iArr[5] = 2;
                break;
            case '`':
                // fill-array-data instruction
                iArr[0] = 0;
                iArr[1] = 2;
                iArr[2] = 0;
                iArr[3] = 1;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 'a':
                // fill-array-data instruction
                iArr[0] = 1;
                iArr[1] = 1;
                iArr[2] = 2;
                iArr[3] = 1;
                iArr[4] = 2;
                iArr[5] = 1;
                break;
            case 'b':
            case 215:
            case 230:
                // fill-array-data instruction
                iArr[0] = 4;
                iArr[1] = 2;
                iArr[2] = 2;
                iArr[3] = 4;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 'c':
            case 190:
                // fill-array-data instruction
                iArr[0] = 3;
                iArr[1] = 2;
                iArr[2] = 2;
                iArr[3] = 2;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case ab.ab /* 100 */:
                // fill-array-data instruction
                iArr[0] = 4;
                iArr[1] = 2;
                iArr[2] = 3;
                iArr[3] = 3;
                iArr[4] = 4;
                iArr[5] = 2;
                break;
            case 'e':
                // fill-array-data instruction
                iArr[0] = 0;
                iArr[1] = 0;
                iArr[2] = 1;
                iArr[3] = 0;
                iArr[4] = 0;
                iArr[5] = 2;
                break;
            case zz.f2799f /* 102 */:
                // fill-array-data instruction
                iArr[0] = 0;
                iArr[1] = 0;
                iArr[2] = 1;
                iArr[3] = 1;
                iArr[4] = 1;
                iArr[5] = 2;
                break;
            case 'h':
                // fill-array-data instruction
                iArr[0] = 2;
                iArr[1] = 4;
                iArr[2] = 2;
                iArr[3] = 1;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 'i':
                // fill-array-data instruction
                iArr[0] = 2;
                iArr[1] = 0;
                iArr[2] = 1;
                iArr[3] = 1;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 'j':
                // fill-array-data instruction
                iArr[0] = 0;
                iArr[1] = 3;
                iArr[2] = 3;
                iArr[3] = 3;
                iArr[4] = 4;
                iArr[5] = 4;
                break;
            case 'k':
                // fill-array-data instruction
                iArr[0] = 3;
                iArr[1] = 2;
                iArr[2] = 2;
                iArr[3] = 1;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 'l':
            case 141:
                // fill-array-data instruction
                iArr[0] = 2;
                iArr[1] = 1;
                iArr[2] = 1;
                iArr[3] = 2;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 'm':
                // fill-array-data instruction
                iArr[0] = 1;
                iArr[1] = 0;
                iArr[2] = 4;
                iArr[3] = 2;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 'q':
                // fill-array-data instruction
                iArr[0] = 0;
                iArr[1] = 2;
                iArr[2] = 2;
                iArr[3] = 4;
                iArr[4] = 4;
                iArr[5] = 4;
                break;
            case 'r':
                // fill-array-data instruction
                iArr[0] = 1;
                iArr[1] = 0;
                iArr[2] = 1;
                iArr[3] = 0;
                iArr[4] = 0;
                iArr[5] = 2;
                break;
            case 'u':
                // fill-array-data instruction
                iArr[0] = 1;
                iArr[1] = 2;
                iArr[2] = 1;
                iArr[3] = 3;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 'y':
                // fill-array-data instruction
                iArr[0] = 3;
                iArr[1] = 2;
                iArr[2] = 3;
                iArr[3] = 4;
                iArr[4] = 4;
                iArr[5] = 2;
                break;
            case 'z':
                // fill-array-data instruction
                iArr[0] = 3;
                iArr[1] = 4;
                iArr[2] = 3;
                iArr[3] = 4;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case '{':
            case 219:
                // fill-array-data instruction
                iArr[0] = 3;
                iArr[1] = 3;
                iArr[2] = 3;
                iArr[3] = 2;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case '}':
                // fill-array-data instruction
                iArr[0] = 1;
                iArr[1] = 1;
                iArr[2] = 4;
                iArr[3] = 2;
                iArr[4] = 0;
                iArr[5] = 2;
                break;
            case 127:
            case 212:
            case 237:
                // fill-array-data instruction
                iArr[0] = 3;
                iArr[1] = 2;
                iArr[2] = 4;
                iArr[3] = 3;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 128:
                // fill-array-data instruction
                iArr[0] = 3;
                iArr[1] = 3;
                iArr[2] = 2;
                iArr[3] = 1;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 129:
                // fill-array-data instruction
                iArr[0] = 0;
                iArr[1] = 2;
                iArr[2] = 2;
                iArr[3] = 0;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 130:
                // fill-array-data instruction
                iArr[0] = 1;
                iArr[1] = 0;
                iArr[2] = 0;
                iArr[3] = 0;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 131:
                // fill-array-data instruction
                iArr[0] = 2;
                iArr[1] = 0;
                iArr[2] = 0;
                iArr[3] = 1;
                iArr[4] = 1;
                iArr[5] = 2;
                break;
            case 134:
                // fill-array-data instruction
                iArr[0] = 4;
                iArr[1] = 2;
                iArr[2] = 1;
                iArr[3] = 3;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 135:
                // fill-array-data instruction
                iArr[0] = 2;
                iArr[1] = 0;
                iArr[2] = 0;
                iArr[3] = 1;
                iArr[4] = 3;
                iArr[5] = 2;
                break;
            case 136:
            case 217:
                // fill-array-data instruction
                iArr[0] = 3;
                iArr[1] = 4;
                iArr[2] = 2;
                iArr[3] = 2;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 137:
                // fill-array-data instruction
                iArr[0] = 2;
                iArr[1] = 2;
                iArr[2] = 2;
                iArr[3] = 3;
                iArr[4] = 4;
                iArr[5] = 2;
                break;
            case 138:
                // fill-array-data instruction
                iArr[0] = 2;
                iArr[1] = 0;
                iArr[2] = 1;
                iArr[3] = 2;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 139:
                // fill-array-data instruction
                iArr[0] = 0;
                iArr[1] = 2;
                iArr[2] = 4;
                iArr[3] = 4;
                iArr[4] = 4;
                iArr[5] = 2;
                break;
            case 142:
                // fill-array-data instruction
                iArr[0] = 4;
                iArr[1] = 2;
                iArr[2] = 3;
                iArr[3] = 4;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 145:
            case 182:
                // fill-array-data instruction
                iArr[0] = 3;
                iArr[1] = 1;
                iArr[2] = 1;
                iArr[3] = 2;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 146:
                // fill-array-data instruction
                iArr[0] = 3;
                iArr[1] = 4;
                iArr[2] = 1;
                iArr[3] = 3;
                iArr[4] = 3;
                iArr[5] = 2;
                break;
            case 147:
                // fill-array-data instruction
                iArr[0] = 4;
                iArr[1] = 2;
                iArr[2] = 3;
                iArr[3] = 3;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 148:
                // fill-array-data instruction
                iArr[0] = 3;
                iArr[1] = 4;
                iArr[2] = 4;
                iArr[3] = 4;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 149:
                // fill-array-data instruction
                iArr[0] = 1;
                iArr[1] = 0;
                iArr[2] = 4;
                iArr[3] = 1;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 151:
                // fill-array-data instruction
                iArr[0] = 3;
                iArr[1] = 4;
                iArr[2] = 3;
                iArr[3] = 2;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 152:
                // fill-array-data instruction
                iArr[0] = 3;
                iArr[1] = 2;
                iArr[2] = 3;
                iArr[3] = 4;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 154:
                // fill-array-data instruction
                iArr[0] = 3;
                iArr[1] = 4;
                iArr[2] = 2;
                iArr[3] = 1;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 155:
                // fill-array-data instruction
                iArr[0] = 2;
                iArr[1] = 3;
                iArr[2] = 4;
                iArr[3] = 3;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 156:
                // fill-array-data instruction
                iArr[0] = 0;
                iArr[1] = 2;
                iArr[2] = 3;
                iArr[3] = 3;
                iArr[4] = 0;
                iArr[5] = 4;
                break;
            case 157:
                // fill-array-data instruction
                iArr[0] = 0;
                iArr[1] = 1;
                iArr[2] = 2;
                iArr[3] = 1;
                iArr[4] = 1;
                iArr[5] = 2;
                break;
            case 158:
                // fill-array-data instruction
                iArr[0] = 2;
                iArr[1] = 1;
                iArr[2] = 4;
                iArr[3] = 3;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 159:
                // fill-array-data instruction
                iArr[0] = 4;
                iArr[1] = 0;
                iArr[2] = 3;
                iArr[3] = 2;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 160:
                // fill-array-data instruction
                iArr[0] = 4;
                iArr[1] = 2;
                iArr[2] = 2;
                iArr[3] = 1;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 161:
                // fill-array-data instruction
                iArr[0] = 1;
                iArr[1] = 0;
                iArr[2] = 2;
                iArr[3] = 2;
                iArr[4] = 4;
                iArr[5] = 2;
                break;
            case 162:
                // fill-array-data instruction
                iArr[0] = 2;
                iArr[1] = 3;
                iArr[2] = 1;
                iArr[3] = 3;
                iArr[4] = 4;
                iArr[5] = 2;
                break;
            case 163:
                // fill-array-data instruction
                iArr[0] = 2;
                iArr[1] = 3;
                iArr[2] = 3;
                iArr[3] = 3;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 164:
                // fill-array-data instruction
                iArr[0] = 1;
                iArr[1] = 2;
                iArr[2] = 4;
                iArr[3] = 4;
                iArr[4] = 3;
                iArr[5] = 2;
                break;
            case 165:
            case 199:
                // fill-array-data instruction
                iArr[0] = 2;
                iArr[1] = 3;
                iArr[2] = 3;
                iArr[3] = 1;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 167:
                // fill-array-data instruction
                iArr[0] = 2;
                iArr[1] = 1;
                iArr[2] = 3;
                iArr[3] = 2;
                iArr[4] = 2;
                iArr[5] = 0;
                break;
            case 169:
                // fill-array-data instruction
                iArr[0] = 2;
                iArr[1] = 1;
                iArr[2] = 2;
                iArr[3] = 2;
                iArr[4] = 4;
                iArr[5] = 2;
                break;
            case 171:
                // fill-array-data instruction
                iArr[0] = 2;
                iArr[1] = 0;
                iArr[2] = 2;
                iArr[3] = 0;
                iArr[4] = 2;
                iArr[5] = 1;
                break;
            case 172:
                // fill-array-data instruction
                iArr[0] = 3;
                iArr[1] = 4;
                iArr[2] = 1;
                iArr[3] = 4;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 173:
                // fill-array-data instruction
                iArr[0] = 1;
                iArr[1] = 0;
                iArr[2] = 0;
                iArr[3] = 0;
                iArr[4] = 1;
                iArr[5] = 2;
                break;
            case 174:
                // fill-array-data instruction
                iArr[0] = 2;
                iArr[1] = 2;
                iArr[2] = 4;
                iArr[3] = 2;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 176:
                // fill-array-data instruction
                iArr[0] = 1;
                iArr[1] = 4;
                iArr[2] = 4;
                iArr[3] = 4;
                iArr[4] = 4;
                iArr[5] = 2;
                break;
            case 177:
                // fill-array-data instruction
                iArr[0] = 1;
                iArr[1] = 2;
                iArr[2] = 2;
                iArr[3] = 3;
                iArr[4] = 1;
                iArr[5] = 2;
                break;
            case 178:
                // fill-array-data instruction
                iArr[0] = 0;
                iArr[1] = 0;
                iArr[2] = 1;
                iArr[3] = 2;
                iArr[4] = 1;
                iArr[5] = 2;
                break;
            case 179:
                // fill-array-data instruction
                iArr[0] = 2;
                iArr[1] = 0;
                iArr[2] = 0;
                iArr[3] = 0;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 180:
                // fill-array-data instruction
                iArr[0] = 1;
                iArr[1] = 0;
                iArr[2] = 0;
                iArr[3] = 0;
                iArr[4] = 3;
                iArr[5] = 3;
                break;
            case 181:
                // fill-array-data instruction
                iArr[0] = 3;
                iArr[1] = 3;
                iArr[2] = 1;
                iArr[3] = 0;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 184:
                // fill-array-data instruction
                iArr[0] = 4;
                iArr[1] = 3;
                iArr[2] = 1;
                iArr[3] = 1;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 185:
                // fill-array-data instruction
                iArr[0] = 4;
                iArr[1] = 3;
                iArr[2] = 4;
                iArr[3] = 2;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 186:
                // fill-array-data instruction
                iArr[0] = 0;
                iArr[1] = 1;
                iArr[2] = 1;
                iArr[3] = 1;
                iArr[4] = 0;
                iArr[5] = 2;
                break;
            case 187:
                // fill-array-data instruction
                iArr[0] = 2;
                iArr[1] = 3;
                iArr[2] = 3;
                iArr[3] = 3;
                iArr[4] = 3;
                iArr[5] = 3;
                break;
            case 191:
                // fill-array-data instruction
                iArr[0] = 1;
                iArr[1] = 1;
                iArr[2] = 1;
                iArr[3] = 1;
                iArr[4] = 3;
                iArr[5] = 2;
                break;
            case 195:
                // fill-array-data instruction
                iArr[0] = 3;
                iArr[1] = 2;
                iArr[2] = 2;
                iArr[3] = 4;
                iArr[4] = 4;
                iArr[5] = 2;
                break;
            case 196:
                // fill-array-data instruction
                iArr[0] = 2;
                iArr[1] = 4;
                iArr[2] = 3;
                iArr[3] = 0;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 197:
            case 210:
                // fill-array-data instruction
                iArr[0] = 4;
                iArr[1] = 2;
                iArr[2] = 2;
                iArr[3] = 3;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 198:
                // fill-array-data instruction
                iArr[0] = 2;
                iArr[1] = 2;
                iArr[2] = 1;
                iArr[3] = 2;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 202:
                // fill-array-data instruction
                iArr[0] = 4;
                iArr[1] = 4;
                iArr[2] = 3;
                iArr[3] = 4;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 203:
                // fill-array-data instruction
                iArr[0] = 2;
                iArr[1] = 2;
                iArr[2] = 1;
                iArr[3] = 3;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 206:
                // fill-array-data instruction
                iArr[0] = 0;
                iArr[1] = 1;
                iArr[2] = 2;
                iArr[3] = 1;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 209:
                // fill-array-data instruction
                iArr[0] = 4;
                iArr[1] = 2;
                iArr[2] = 4;
                iArr[3] = 4;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 211:
            case 221:
                // fill-array-data instruction
                iArr[0] = 2;
                iArr[1] = 1;
                iArr[2] = 1;
                iArr[3] = 1;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 213:
                // fill-array-data instruction
                iArr[0] = 1;
                iArr[1] = 0;
                iArr[2] = 0;
                iArr[3] = 1;
                iArr[4] = 3;
                iArr[5] = 2;
                break;
            case 214:
                // fill-array-data instruction
                iArr[0] = 1;
                iArr[1] = 4;
                iArr[2] = 0;
                iArr[3] = 0;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 216:
                // fill-array-data instruction
                iArr[0] = 0;
                iArr[1] = 2;
                iArr[2] = 0;
                iArr[3] = 0;
                iArr[4] = 0;
                iArr[5] = 0;
                break;
            case 218:
                // fill-array-data instruction
                iArr[0] = 0;
                iArr[1] = 1;
                iArr[2] = 1;
                iArr[3] = 2;
                iArr[4] = 4;
                iArr[5] = 2;
                break;
            case 220:
                // fill-array-data instruction
                iArr[0] = 1;
                iArr[1] = 1;
                iArr[2] = 4;
                iArr[3] = 1;
                iArr[4] = 3;
                iArr[5] = 1;
                break;
            case 222:
                // fill-array-data instruction
                iArr[0] = 2;
                iArr[1] = 2;
                iArr[2] = 3;
                iArr[3] = 4;
                iArr[4] = 3;
                iArr[5] = 2;
                break;
            case 226:
                // fill-array-data instruction
                iArr[0] = 2;
                iArr[1] = 2;
                iArr[2] = 0;
                iArr[3] = 1;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 227:
                // fill-array-data instruction
                iArr[0] = 0;
                iArr[1] = 2;
                iArr[2] = 1;
                iArr[3] = 2;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 228:
                // fill-array-data instruction
                iArr[0] = 0;
                iArr[1] = 0;
                iArr[2] = 1;
                iArr[3] = 2;
                iArr[4] = 2;
                iArr[5] = 1;
                break;
            case 229:
                // fill-array-data instruction
                iArr[0] = 4;
                iArr[1] = 3;
                iArr[2] = 3;
                iArr[3] = 1;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 232:
                // fill-array-data instruction
                iArr[0] = 1;
                iArr[1] = 2;
                iArr[2] = 1;
                iArr[3] = 1;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 234:
                // fill-array-data instruction
                iArr[0] = 2;
                iArr[1] = 3;
                iArr[2] = 3;
                iArr[3] = 4;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 235:
                // fill-array-data instruction
                iArr[0] = 2;
                iArr[1] = 3;
                iArr[2] = 2;
                iArr[3] = 1;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
            case 236:
                // fill-array-data instruction
                iArr[0] = 4;
                iArr[1] = 4;
                iArr[2] = 4;
                iArr[3] = 3;
                iArr[4] = 3;
                iArr[5] = 2;
                break;
            default:
                // fill-array-data instruction
                iArr[0] = 2;
                iArr[1] = 2;
                iArr[2] = 2;
                iArr[3] = 2;
                iArr[4] = 2;
                iArr[5] = 2;
                break;
        }
        return iArr;
    }

    private long m(int i6) {
        Long l6 = this.f4149a.get(Integer.valueOf(i6));
        if (l6 == null) {
            l6 = this.f4149a.get(0);
        }
        if (l6 == null) {
            l6 = 1000000L;
        }
        return l6.longValue();
    }

    public static synchronized t n(Context context) {
        t tVar;
        synchronized (t.class) {
            if (f4148v == null) {
                f4148v = new b(context).a();
            }
            tVar = f4148v;
        }
        return tVar;
    }

    private static boolean o(q qVar, boolean z5) {
        return z5 && !qVar.d(8);
    }

    private void p(int i6, long j6, long j7) {
        if (i6 == 0 && j6 == 0 && j7 == this.f4161m) {
            return;
        }
        this.f4161m = j7;
        this.f4150b.c(i6, j6, j7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void q(int i6) {
        int i7 = this.f4157i;
        if (i7 == 0 || this.f4153e) {
            if (this.f4162n) {
                i6 = this.f4163o;
            }
            if (i7 == i6) {
                return;
            }
            this.f4157i = i6;
            if (i6 != 1 && i6 != 0 && i6 != 8) {
                this.f4160l = m(i6);
                long d6 = this.f4152d.d();
                p(this.f4154f > 0 ? (int) (d6 - this.f4155g) : 0, this.f4156h, this.f4160l);
                this.f4155g = d6;
                this.f4156h = 0L;
                this.f4159k = 0L;
                this.f4158j = 0L;
                this.f4151c.i();
            }
        }
    }

    @Override // g2.f
    public u0 a() {
        return this;
    }

    @Override // g2.u0
    public synchronized void b(m mVar, q qVar, boolean z5) {
        if (o(qVar, z5)) {
            i2.a.g(this.f4154f > 0);
            long d6 = this.f4152d.d();
            int i6 = (int) (d6 - this.f4155g);
            this.f4158j += i6;
            long j6 = this.f4159k;
            long j7 = this.f4156h;
            this.f4159k = j6 + j7;
            if (i6 > 0) {
                this.f4151c.c((int) Math.sqrt(j7), (j7 * 8000.0f) / i6);
                if (this.f4158j >= 2000 || this.f4159k >= 524288) {
                    this.f4160l = (long) this.f4151c.f(0.5f);
                }
                p(i6, this.f4156h, this.f4160l);
                this.f4155g = d6;
                this.f4156h = 0L;
            }
            this.f4154f--;
        }
    }

    @Override // g2.f
    public /* synthetic */ long c() {
        return d.a(this);
    }

    @Override // g2.f
    public synchronized long d() {
        return this.f4160l;
    }

    @Override // g2.u0
    public synchronized void e(m mVar, q qVar, boolean z5, int i6) {
        if (o(qVar, z5)) {
            this.f4156h += i6;
        }
    }

    @Override // g2.u0
    public void f(m mVar, q qVar, boolean z5) {
    }

    @Override // g2.u0
    public synchronized void g(m mVar, q qVar, boolean z5) {
        if (o(qVar, z5)) {
            if (this.f4154f == 0) {
                this.f4155g = this.f4152d.d();
            }
            this.f4154f++;
        }
    }

    @Override // g2.f
    public void h(f.a aVar) {
        this.f4150b.e(aVar);
    }

    @Override // g2.f
    public void i(Handler handler, f.a aVar) {
        i2.a.e(handler);
        i2.a.e(aVar);
        this.f4150b.b(handler, aVar);
    }
}
