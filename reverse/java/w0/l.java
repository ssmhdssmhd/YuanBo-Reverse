package w0;

import i2.i0;
import i2.t;
import java.nio.ByteBuffer;
import java.util.UUID;

/* loaded from: classes.dex */
public final class l {

    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private final UUID f10102a;

        /* renamed from: b, reason: collision with root package name */
        private final int f10103b;

        /* renamed from: c, reason: collision with root package name */
        private final byte[] f10104c;

        public a(UUID uuid, int i6, byte[] bArr) {
            this.f10102a = uuid;
            this.f10103b = i6;
            this.f10104c = bArr;
        }
    }

    public static byte[] a(UUID uuid, byte[] bArr) {
        return b(uuid, null, bArr);
    }

    public static byte[] b(UUID uuid, UUID[] uuidArr, byte[] bArr) {
        int length = (bArr != null ? bArr.length : 0) + 32;
        if (uuidArr != null) {
            length += (uuidArr.length * 16) + 4;
        }
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.putInt(length);
        allocate.putInt(1886614376);
        allocate.putInt(uuidArr != null ? 16777216 : 0);
        allocate.putLong(uuid.getMostSignificantBits());
        allocate.putLong(uuid.getLeastSignificantBits());
        if (uuidArr != null) {
            allocate.putInt(uuidArr.length);
            for (UUID uuid2 : uuidArr) {
                allocate.putLong(uuid2.getMostSignificantBits());
                allocate.putLong(uuid2.getLeastSignificantBits());
            }
        }
        if (bArr != null && bArr.length != 0) {
            allocate.putInt(bArr.length);
            allocate.put(bArr);
        }
        return allocate.array();
    }

    public static boolean c(byte[] bArr) {
        return d(bArr) != null;
    }

    private static a d(byte[] bArr) {
        i0 i0Var = new i0(bArr);
        if (i0Var.g() < 32) {
            return null;
        }
        i0Var.S(0);
        if (i0Var.o() != i0Var.a() + 4 || i0Var.o() != 1886614376) {
            return null;
        }
        int c6 = w0.a.c(i0Var.o());
        if (c6 > 1) {
            t.i("PsshAtomUtil", "Unsupported pssh version: " + c6);
            return null;
        }
        UUID uuid = new UUID(i0Var.y(), i0Var.y());
        if (c6 == 1) {
            i0Var.T(i0Var.J() * 16);
        }
        int J = i0Var.J();
        if (J != i0Var.a()) {
            return null;
        }
        byte[] bArr2 = new byte[J];
        i0Var.j(bArr2, 0, J);
        return new a(uuid, c6, bArr2);
    }

    public static byte[] e(byte[] bArr, UUID uuid) {
        a d6 = d(bArr);
        if (d6 == null) {
            return null;
        }
        if (uuid.equals(d6.f10102a)) {
            return d6.f10104c;
        }
        t.i("PsshAtomUtil", "UUID mismatch. Expected: " + uuid + ", got: " + d6.f10102a + ".");
        return null;
    }

    public static UUID f(byte[] bArr) {
        a d6 = d(bArr);
        if (d6 == null) {
            return null;
        }
        return d6.f10102a;
    }

    public static int g(byte[] bArr) {
        a d6 = d(bArr);
        if (d6 == null) {
            return -1;
        }
        return d6.f10103b;
    }
}
