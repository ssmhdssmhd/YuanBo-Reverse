package y3;

import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class q implements i<Object> {

    /* renamed from: a, reason: collision with root package name */
    public static final q f11112a = new q();

    /* renamed from: b, reason: collision with root package name */
    private static final boolean f11113b;

    /* renamed from: c, reason: collision with root package name */
    private static final Charset f11114c;

    static final class a extends ByteArrayOutputStream {
        a() {
        }

        byte[] a() {
            return ((ByteArrayOutputStream) this).buf;
        }
    }

    static {
        f11113b = ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN;
        f11114c = Charset.forName("UTF8");
    }

    protected static final void c(ByteBuffer byteBuffer, int i6) {
        int position = byteBuffer.position() % i6;
        if (position != 0) {
            byteBuffer.position((byteBuffer.position() + i6) - position);
        }
    }

    protected static final byte[] d(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[e(byteBuffer)];
        byteBuffer.get(bArr);
        return bArr;
    }

    protected static final int e(ByteBuffer byteBuffer) {
        if (!byteBuffer.hasRemaining()) {
            throw new IllegalArgumentException("Message corrupted");
        }
        int i6 = byteBuffer.get() & 255;
        return i6 < 254 ? i6 : i6 == 254 ? byteBuffer.getChar() : byteBuffer.getInt();
    }

    protected static final void h(ByteArrayOutputStream byteArrayOutputStream, int i6) {
        int size = byteArrayOutputStream.size() % i6;
        if (size != 0) {
            for (int i7 = 0; i7 < i6 - size; i7++) {
                byteArrayOutputStream.write(0);
            }
        }
    }

    protected static final void i(ByteArrayOutputStream byteArrayOutputStream, byte[] bArr) {
        o(byteArrayOutputStream, bArr.length);
        byteArrayOutputStream.write(bArr, 0, bArr.length);
    }

    protected static final void j(ByteArrayOutputStream byteArrayOutputStream, int i6) {
        if (f11113b) {
            byteArrayOutputStream.write(i6);
            i6 >>>= 8;
        } else {
            byteArrayOutputStream.write(i6 >>> 8);
        }
        byteArrayOutputStream.write(i6);
    }

    protected static final void k(ByteArrayOutputStream byteArrayOutputStream, double d6) {
        n(byteArrayOutputStream, Double.doubleToLongBits(d6));
    }

    protected static final void l(ByteArrayOutputStream byteArrayOutputStream, float f6) {
        m(byteArrayOutputStream, Float.floatToIntBits(f6));
    }

    protected static final void m(ByteArrayOutputStream byteArrayOutputStream, int i6) {
        if (f11113b) {
            byteArrayOutputStream.write(i6);
            byteArrayOutputStream.write(i6 >>> 8);
            byteArrayOutputStream.write(i6 >>> 16);
            i6 >>>= 24;
        } else {
            byteArrayOutputStream.write(i6 >>> 24);
            byteArrayOutputStream.write(i6 >>> 16);
            byteArrayOutputStream.write(i6 >>> 8);
        }
        byteArrayOutputStream.write(i6);
    }

    protected static final void n(ByteArrayOutputStream byteArrayOutputStream, long j6) {
        if (f11113b) {
            byteArrayOutputStream.write((byte) j6);
            byteArrayOutputStream.write((byte) (j6 >>> 8));
            byteArrayOutputStream.write((byte) (j6 >>> 16));
            byteArrayOutputStream.write((byte) (j6 >>> 24));
            byteArrayOutputStream.write((byte) (j6 >>> 32));
            byteArrayOutputStream.write((byte) (j6 >>> 40));
            byteArrayOutputStream.write((byte) (j6 >>> 48));
            j6 >>>= 56;
        } else {
            byteArrayOutputStream.write((byte) (j6 >>> 56));
            byteArrayOutputStream.write((byte) (j6 >>> 48));
            byteArrayOutputStream.write((byte) (j6 >>> 40));
            byteArrayOutputStream.write((byte) (j6 >>> 32));
            byteArrayOutputStream.write((byte) (j6 >>> 24));
            byteArrayOutputStream.write((byte) (j6 >>> 16));
            byteArrayOutputStream.write((byte) (j6 >>> 8));
        }
        byteArrayOutputStream.write((byte) j6);
    }

    protected static final void o(ByteArrayOutputStream byteArrayOutputStream, int i6) {
        if (i6 < 254) {
            byteArrayOutputStream.write(i6);
        } else if (i6 <= 65535) {
            byteArrayOutputStream.write(254);
            j(byteArrayOutputStream, i6);
        } else {
            byteArrayOutputStream.write(255);
            m(byteArrayOutputStream, i6);
        }
    }

    @Override // y3.i
    public ByteBuffer a(Object obj) {
        if (obj == null) {
            return null;
        }
        a aVar = new a();
        p(aVar, obj);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(aVar.size());
        allocateDirect.put(aVar.a(), 0, aVar.size());
        return allocateDirect;
    }

    @Override // y3.i
    public Object b(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return null;
        }
        byteBuffer.order(ByteOrder.nativeOrder());
        Object f6 = f(byteBuffer);
        if (byteBuffer.hasRemaining()) {
            throw new IllegalArgumentException("Message corrupted");
        }
        return f6;
    }

    protected final Object f(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            return g(byteBuffer.get(), byteBuffer);
        }
        throw new IllegalArgumentException("Message corrupted");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.util.ArrayList, java.util.List] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.util.HashMap, java.util.Map] */
    protected Object g(byte b6, ByteBuffer byteBuffer) {
        int e6;
        int e7;
        long[] jArr;
        Object arrayList;
        int[] iArr;
        int i6 = 0;
        switch (b6) {
            case 0:
                return null;
            case 1:
                return Boolean.TRUE;
            case 2:
                return Boolean.FALSE;
            case 3:
                return Integer.valueOf(byteBuffer.getInt());
            case 4:
                return Long.valueOf(byteBuffer.getLong());
            case 5:
                return new BigInteger(new String(d(byteBuffer), f11114c), 16);
            case 6:
                c(byteBuffer, 8);
                return Double.valueOf(byteBuffer.getDouble());
            case 7:
                return new String(d(byteBuffer), f11114c);
            case 8:
                return d(byteBuffer);
            case 9:
                e6 = e(byteBuffer);
                int[] iArr2 = new int[e6];
                c(byteBuffer, 4);
                byteBuffer.asIntBuffer().get(iArr2);
                iArr = iArr2;
                byteBuffer.position(byteBuffer.position() + (e6 * 4));
                return iArr;
            case 10:
                e7 = e(byteBuffer);
                long[] jArr2 = new long[e7];
                c(byteBuffer, 8);
                byteBuffer.asLongBuffer().get(jArr2);
                jArr = jArr2;
                byteBuffer.position(byteBuffer.position() + (e7 * 8));
                return jArr;
            case 11:
                e7 = e(byteBuffer);
                double[] dArr = new double[e7];
                c(byteBuffer, 8);
                byteBuffer.asDoubleBuffer().get(dArr);
                jArr = dArr;
                byteBuffer.position(byteBuffer.position() + (e7 * 8));
                return jArr;
            case 12:
                int e8 = e(byteBuffer);
                arrayList = new ArrayList(e8);
                while (i6 < e8) {
                    arrayList.add(f(byteBuffer));
                    i6++;
                }
                return arrayList;
            case 13:
                int e9 = e(byteBuffer);
                arrayList = new HashMap();
                while (i6 < e9) {
                    arrayList.put(f(byteBuffer), f(byteBuffer));
                    i6++;
                }
                return arrayList;
            case 14:
                e6 = e(byteBuffer);
                float[] fArr = new float[e6];
                c(byteBuffer, 4);
                byteBuffer.asFloatBuffer().get(fArr);
                iArr = fArr;
                byteBuffer.position(byteBuffer.position() + (e6 * 4));
                return iArr;
            default:
                throw new IllegalArgumentException("Message corrupted");
        }
    }

    protected void p(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
        int i6 = 0;
        if (obj == null || obj.equals(null)) {
            byteArrayOutputStream.write(0);
            return;
        }
        if (obj instanceof Boolean) {
            byteArrayOutputStream.write(((Boolean) obj).booleanValue() ? 1 : 2);
            return;
        }
        if (obj instanceof Number) {
            if ((obj instanceof Integer) || (obj instanceof Short) || (obj instanceof Byte)) {
                byteArrayOutputStream.write(3);
                m(byteArrayOutputStream, ((Number) obj).intValue());
                return;
            }
            if (obj instanceof Long) {
                byteArrayOutputStream.write(4);
                n(byteArrayOutputStream, ((Long) obj).longValue());
                return;
            }
            if ((obj instanceof Float) || (obj instanceof Double)) {
                byteArrayOutputStream.write(6);
                h(byteArrayOutputStream, 8);
                k(byteArrayOutputStream, ((Number) obj).doubleValue());
                return;
            } else {
                if (!(obj instanceof BigInteger)) {
                    throw new IllegalArgumentException("Unsupported Number type: " + obj.getClass());
                }
                byteArrayOutputStream.write(5);
                i(byteArrayOutputStream, ((BigInteger) obj).toString(16).getBytes(f11114c));
                return;
            }
        }
        if (obj instanceof CharSequence) {
            byteArrayOutputStream.write(7);
            i(byteArrayOutputStream, obj.toString().getBytes(f11114c));
            return;
        }
        if (obj instanceof byte[]) {
            byteArrayOutputStream.write(8);
            i(byteArrayOutputStream, (byte[]) obj);
            return;
        }
        if (obj instanceof int[]) {
            byteArrayOutputStream.write(9);
            int[] iArr = (int[]) obj;
            o(byteArrayOutputStream, iArr.length);
            h(byteArrayOutputStream, 4);
            int length = iArr.length;
            while (i6 < length) {
                m(byteArrayOutputStream, iArr[i6]);
                i6++;
            }
            return;
        }
        if (obj instanceof long[]) {
            byteArrayOutputStream.write(10);
            long[] jArr = (long[]) obj;
            o(byteArrayOutputStream, jArr.length);
            h(byteArrayOutputStream, 8);
            int length2 = jArr.length;
            while (i6 < length2) {
                n(byteArrayOutputStream, jArr[i6]);
                i6++;
            }
            return;
        }
        if (obj instanceof double[]) {
            byteArrayOutputStream.write(11);
            double[] dArr = (double[]) obj;
            o(byteArrayOutputStream, dArr.length);
            h(byteArrayOutputStream, 8);
            int length3 = dArr.length;
            while (i6 < length3) {
                k(byteArrayOutputStream, dArr[i6]);
                i6++;
            }
            return;
        }
        if (obj instanceof List) {
            byteArrayOutputStream.write(12);
            List list = (List) obj;
            o(byteArrayOutputStream, list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                p(byteArrayOutputStream, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            byteArrayOutputStream.write(13);
            Map map = (Map) obj;
            o(byteArrayOutputStream, map.size());
            for (Map.Entry entry : map.entrySet()) {
                p(byteArrayOutputStream, entry.getKey());
                p(byteArrayOutputStream, entry.getValue());
            }
            return;
        }
        if (!(obj instanceof float[])) {
            throw new IllegalArgumentException("Unsupported value: '" + obj + "' of type '" + obj.getClass() + "'");
        }
        byteArrayOutputStream.write(14);
        float[] fArr = (float[]) obj;
        o(byteArrayOutputStream, fArr.length);
        h(byteArrayOutputStream, 4);
        int length4 = fArr.length;
        while (i6 < length4) {
            l(byteArrayOutputStream, fArr[i6]);
            i6++;
        }
    }
}
