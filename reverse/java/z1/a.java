package z1;

import android.text.Layout;
import com.tendcloud.tenddata.ab;
import i2.c1;
import i2.i0;
import i2.t;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import u1.g;
import u1.h;
import z1.c;

/* loaded from: classes.dex */
public final class a extends g {

    /* renamed from: t, reason: collision with root package name */
    private static final Pattern f11208t = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)[:.](\\d+)");

    /* renamed from: o, reason: collision with root package name */
    private final boolean f11209o;

    /* renamed from: p, reason: collision with root package name */
    private final b f11210p;

    /* renamed from: q, reason: collision with root package name */
    private Map<String, c> f11211q;

    /* renamed from: r, reason: collision with root package name */
    private float f11212r;

    /* renamed from: s, reason: collision with root package name */
    private float f11213s;

    public a(List<byte[]> list) {
        super("SsaDecoder");
        this.f11212r = -3.4028235E38f;
        this.f11213s = -3.4028235E38f;
        if (list == null || list.isEmpty()) {
            this.f11209o = false;
            this.f11210p = null;
            return;
        }
        this.f11209o = true;
        String D = c1.D(list.get(0));
        i2.a.a(D.startsWith("Format:"));
        this.f11210p = (b) i2.a.e(b.a(D));
        H(new i0(list.get(1)));
    }

    private static int C(long j6, List<Long> list, List<List<u1.b>> list2) {
        int i6;
        int size = list.size() - 1;
        while (true) {
            if (size < 0) {
                i6 = 0;
                break;
            }
            if (list.get(size).longValue() == j6) {
                return size;
            }
            if (list.get(size).longValue() < j6) {
                i6 = size + 1;
                break;
            }
            size--;
        }
        list.add(i6, Long.valueOf(j6));
        list2.add(i6, i6 == 0 ? new ArrayList() : new ArrayList(list2.get(i6 - 1)));
        return i6;
    }

    private static float D(int i6) {
        if (i6 == 0) {
            return 0.05f;
        }
        if (i6 != 1) {
            return i6 != 2 ? -3.4028235E38f : 0.95f;
        }
        return 0.5f;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0092  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static u1.b E(java.lang.String r8, z1.c r9, z1.c.b r10, float r11, float r12) {
        /*
            Method dump skipped, instructions count: 244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z1.a.E(java.lang.String, z1.c, z1.c$b, float, float):u1.b");
    }

    private void F(String str, b bVar, List<List<u1.b>> list, List<Long> list2) {
        int i6;
        StringBuilder sb;
        i2.a.a(str.startsWith("Dialogue:"));
        String[] split = str.substring(9).split(",", bVar.f11218e);
        if (split.length != bVar.f11218e) {
            sb = new StringBuilder();
            sb.append("Skipping dialogue line with fewer columns than format: ");
        } else {
            long K = K(split[bVar.f11214a]);
            if (K == -9223372036854775807L) {
                sb = new StringBuilder();
            } else {
                long K2 = K(split[bVar.f11215b]);
                if (K2 != -9223372036854775807L) {
                    Map<String, c> map = this.f11211q;
                    c cVar = (map == null || (i6 = bVar.f11216c) == -1) ? null : map.get(split[i6].trim());
                    String str2 = split[bVar.f11217d];
                    u1.b E = E(c.b.d(str2).replace("\\N", "\n").replace("\\n", "\n").replace("\\h", " "), cVar, c.b.b(str2), this.f11212r, this.f11213s);
                    int C = C(K2, list2, list);
                    for (int C2 = C(K, list2, list); C2 < C; C2++) {
                        list.get(C2).add(E);
                    }
                    return;
                }
                sb = new StringBuilder();
            }
            sb.append("Skipping invalid timing: ");
        }
        sb.append(str);
        t.i("SsaDecoder", sb.toString());
    }

    private void G(i0 i0Var, List<List<u1.b>> list, List<Long> list2) {
        b bVar = this.f11209o ? this.f11210p : null;
        while (true) {
            String q6 = i0Var.q();
            if (q6 == null) {
                return;
            }
            if (q6.startsWith("Format:")) {
                bVar = b.a(q6);
            } else if (q6.startsWith("Dialogue:")) {
                if (bVar == null) {
                    t.i("SsaDecoder", "Skipping dialogue line before complete format: " + q6);
                } else {
                    F(q6, bVar, list, list2);
                }
            }
        }
    }

    private void H(i0 i0Var) {
        while (true) {
            String q6 = i0Var.q();
            if (q6 == null) {
                return;
            }
            if ("[Script Info]".equalsIgnoreCase(q6)) {
                I(i0Var);
            } else if ("[V4+ Styles]".equalsIgnoreCase(q6)) {
                this.f11211q = J(i0Var);
            } else if ("[V4 Styles]".equalsIgnoreCase(q6)) {
                t.f("SsaDecoder", "[V4 Styles] are not supported");
            } else if ("[Events]".equalsIgnoreCase(q6)) {
                return;
            }
        }
    }

    private void I(i0 i0Var) {
        while (true) {
            String q6 = i0Var.q();
            if (q6 == null) {
                return;
            }
            if (i0Var.a() != 0 && i0Var.h() == 91) {
                return;
            }
            String[] split = q6.split(":");
            if (split.length == 2) {
                String e6 = l2.b.e(split[0].trim());
                e6.hashCode();
                if (e6.equals("playresx")) {
                    this.f11212r = Float.parseFloat(split[1].trim());
                } else if (e6.equals("playresy")) {
                    try {
                        this.f11213s = Float.parseFloat(split[1].trim());
                    } catch (NumberFormatException unused) {
                    }
                }
            }
        }
    }

    private static Map<String, c> J(i0 i0Var) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        c.a aVar = null;
        while (true) {
            String q6 = i0Var.q();
            if (q6 == null || (i0Var.a() != 0 && i0Var.h() == 91)) {
                break;
            }
            if (q6.startsWith("Format:")) {
                aVar = c.a.a(q6);
            } else if (q6.startsWith("Style:")) {
                if (aVar == null) {
                    t.i("SsaDecoder", "Skipping 'Style:' line before 'Format:' line: " + q6);
                } else {
                    c b6 = c.b(q6, aVar);
                    if (b6 != null) {
                        linkedHashMap.put(b6.f11219a, b6);
                    }
                }
            }
        }
        return linkedHashMap;
    }

    private static long K(String str) {
        Matcher matcher = f11208t.matcher(str.trim());
        if (matcher.matches()) {
            return (Long.parseLong((String) c1.j(matcher.group(1))) * 60 * 60 * 1000000) + (Long.parseLong((String) c1.j(matcher.group(2))) * 60 * 1000000) + (Long.parseLong((String) c1.j(matcher.group(3))) * 1000000) + (Long.parseLong((String) c1.j(matcher.group(4))) * 10000);
        }
        return -9223372036854775807L;
    }

    private static int L(int i6) {
        switch (i6) {
            case ab.c.SDT_UNKNOWN /* -1 */:
                break;
            case 0:
            default:
                t.i("SsaDecoder", "Unknown alignment: " + i6);
                break;
            case 1:
            case 2:
            case 3:
                break;
            case 4:
            case 5:
            case 6:
                break;
            case 7:
            case 8:
            case 9:
                break;
        }
        return Integer.MIN_VALUE;
    }

    private static int M(int i6) {
        switch (i6) {
            case ab.c.SDT_UNKNOWN /* -1 */:
                break;
            case 0:
            default:
                t.i("SsaDecoder", "Unknown alignment: " + i6);
                break;
            case 1:
            case 4:
            case 7:
                break;
            case 2:
            case 5:
            case 8:
                break;
            case 3:
            case 6:
            case 9:
                break;
        }
        return Integer.MIN_VALUE;
    }

    private static Layout.Alignment N(int i6) {
        switch (i6) {
            case ab.c.SDT_UNKNOWN /* -1 */:
                return null;
            case 0:
            default:
                t.i("SsaDecoder", "Unknown alignment: " + i6);
                return null;
            case 1:
            case 4:
            case 7:
                return Layout.Alignment.ALIGN_NORMAL;
            case 2:
            case 5:
            case 8:
                return Layout.Alignment.ALIGN_CENTER;
            case 3:
            case 6:
            case 9:
                return Layout.Alignment.ALIGN_OPPOSITE;
        }
    }

    @Override // u1.g
    protected h A(byte[] bArr, int i6, boolean z5) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        i0 i0Var = new i0(bArr, i6);
        if (!this.f11209o) {
            H(i0Var);
        }
        G(i0Var, arrayList, arrayList2);
        return new d(arrayList, arrayList2);
    }
}
