package q;

/* loaded from: classes.dex */
public final class a implements e {

    /* renamed from: a, reason: collision with root package name */
    private final String f8653a;

    /* renamed from: b, reason: collision with root package name */
    private final Object[] f8654b;

    public a(String str) {
        this(str, null);
    }

    public a(String str, Object[] objArr) {
        this.f8653a = str;
        this.f8654b = objArr;
    }

    private static void b(d dVar, int i6, Object obj) {
        long j6;
        int byteValue;
        double doubleValue;
        if (obj == null) {
            dVar.r(i6);
            return;
        }
        if (obj instanceof byte[]) {
            dVar.O(i6, (byte[]) obj);
            return;
        }
        if (obj instanceof Float) {
            doubleValue = ((Float) obj).floatValue();
        } else {
            if (!(obj instanceof Double)) {
                if (obj instanceof Long) {
                    j6 = ((Long) obj).longValue();
                } else {
                    if (obj instanceof Integer) {
                        byteValue = ((Integer) obj).intValue();
                    } else if (obj instanceof Short) {
                        byteValue = ((Short) obj).shortValue();
                    } else if (obj instanceof Byte) {
                        byteValue = ((Byte) obj).byteValue();
                    } else {
                        if (obj instanceof String) {
                            dVar.m(i6, (String) obj);
                            return;
                        }
                        if (!(obj instanceof Boolean)) {
                            throw new IllegalArgumentException("Cannot bind " + obj + " at index " + i6 + " Supported types: null, byte[], float, double, long, int, short, byte, string");
                        }
                        j6 = ((Boolean) obj).booleanValue() ? 1L : 0L;
                    }
                    j6 = byteValue;
                }
                dVar.H(i6, j6);
                return;
            }
            doubleValue = ((Double) obj).doubleValue();
        }
        dVar.w(i6, doubleValue);
    }

    public static void c(d dVar, Object[] objArr) {
        if (objArr == null) {
            return;
        }
        int length = objArr.length;
        int i6 = 0;
        while (i6 < length) {
            Object obj = objArr[i6];
            i6++;
            b(dVar, i6, obj);
        }
    }

    @Override // q.e
    public void a(d dVar) {
        c(dVar, this.f8654b);
    }

    @Override // q.e
    public String j() {
        return this.f8653a;
    }
}
