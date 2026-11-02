package s0;

import i2.i0;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import o0.k;

/* loaded from: classes.dex */
final class d extends e {

    /* renamed from: b, reason: collision with root package name */
    private long f9200b;

    /* renamed from: c, reason: collision with root package name */
    private long[] f9201c;

    /* renamed from: d, reason: collision with root package name */
    private long[] f9202d;

    public d() {
        super(new k());
        this.f9200b = -9223372036854775807L;
        this.f9201c = new long[0];
        this.f9202d = new long[0];
    }

    private static Boolean g(i0 i0Var) {
        return Boolean.valueOf(i0Var.F() == 1);
    }

    private static Object h(i0 i0Var, int i6) {
        if (i6 == 0) {
            return j(i0Var);
        }
        if (i6 == 1) {
            return g(i0Var);
        }
        if (i6 == 2) {
            return n(i0Var);
        }
        if (i6 == 3) {
            return l(i0Var);
        }
        if (i6 == 8) {
            return k(i0Var);
        }
        if (i6 == 10) {
            return m(i0Var);
        }
        if (i6 != 11) {
            return null;
        }
        return i(i0Var);
    }

    private static Date i(i0 i0Var) {
        Date date = new Date((long) j(i0Var).doubleValue());
        i0Var.T(2);
        return date;
    }

    private static Double j(i0 i0Var) {
        return Double.valueOf(Double.longBitsToDouble(i0Var.y()));
    }

    private static HashMap<String, Object> k(i0 i0Var) {
        int J = i0Var.J();
        HashMap<String, Object> hashMap = new HashMap<>(J);
        for (int i6 = 0; i6 < J; i6++) {
            String n6 = n(i0Var);
            Object h6 = h(i0Var, o(i0Var));
            if (h6 != null) {
                hashMap.put(n6, h6);
            }
        }
        return hashMap;
    }

    private static HashMap<String, Object> l(i0 i0Var) {
        HashMap<String, Object> hashMap = new HashMap<>();
        while (true) {
            String n6 = n(i0Var);
            int o6 = o(i0Var);
            if (o6 == 9) {
                return hashMap;
            }
            Object h6 = h(i0Var, o6);
            if (h6 != null) {
                hashMap.put(n6, h6);
            }
        }
    }

    private static ArrayList<Object> m(i0 i0Var) {
        int J = i0Var.J();
        ArrayList<Object> arrayList = new ArrayList<>(J);
        for (int i6 = 0; i6 < J; i6++) {
            Object h6 = h(i0Var, o(i0Var));
            if (h6 != null) {
                arrayList.add(h6);
            }
        }
        return arrayList;
    }

    private static String n(i0 i0Var) {
        int L = i0Var.L();
        int f6 = i0Var.f();
        i0Var.T(L);
        return new String(i0Var.e(), f6, L);
    }

    private static int o(i0 i0Var) {
        return i0Var.F();
    }

    @Override // s0.e
    protected boolean b(i0 i0Var) {
        return true;
    }

    @Override // s0.e
    protected boolean c(i0 i0Var, long j6) {
        if (o(i0Var) != 2 || !"onMetaData".equals(n(i0Var)) || i0Var.a() == 0 || o(i0Var) != 8) {
            return false;
        }
        HashMap<String, Object> k6 = k(i0Var);
        Object obj = k6.get("duration");
        if (obj instanceof Double) {
            double doubleValue = ((Double) obj).doubleValue();
            if (doubleValue > 0.0d) {
                this.f9200b = (long) (doubleValue * 1000000.0d);
            }
        }
        Object obj2 = k6.get("keyframes");
        if (obj2 instanceof Map) {
            Map map = (Map) obj2;
            Object obj3 = map.get("filepositions");
            Object obj4 = map.get("times");
            if ((obj3 instanceof List) && (obj4 instanceof List)) {
                List list = (List) obj3;
                List list2 = (List) obj4;
                int size = list2.size();
                this.f9201c = new long[size];
                this.f9202d = new long[size];
                for (int i6 = 0; i6 < size; i6++) {
                    Object obj5 = list.get(i6);
                    Object obj6 = list2.get(i6);
                    if (!(obj6 instanceof Double) || !(obj5 instanceof Double)) {
                        this.f9201c = new long[0];
                        this.f9202d = new long[0];
                        break;
                    }
                    this.f9201c[i6] = (long) (((Double) obj6).doubleValue() * 1000000.0d);
                    this.f9202d[i6] = ((Double) obj5).longValue();
                }
            }
        }
        return false;
    }

    public long d() {
        return this.f9200b;
    }

    public long[] e() {
        return this.f9202d;
    }

    public long[] f() {
        return this.f9201c;
    }
}
