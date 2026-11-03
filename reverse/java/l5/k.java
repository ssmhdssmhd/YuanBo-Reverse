package l5;

import com.tendcloud.tenddata.zz;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f7719a;

    /* renamed from: b, reason: collision with root package name */
    private static final byte[] f7720b;

    /* renamed from: c, reason: collision with root package name */
    private static final a f7721c;

    /* renamed from: d, reason: collision with root package name */
    public static final k f7722d;

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final a[] f7723a;

        /* renamed from: b, reason: collision with root package name */
        private final int f7724b;

        /* renamed from: c, reason: collision with root package name */
        private final int f7725c;

        public a() {
            this.f7723a = new a[256];
            this.f7724b = 0;
            this.f7725c = 0;
        }

        public a(int i6, int i7) {
            this.f7723a = null;
            this.f7724b = i6;
            int i8 = i7 & 7;
            this.f7725c = i8 == 0 ? 8 : i8;
        }

        public final a[] a() {
            return this.f7723a;
        }

        public final int b() {
            return this.f7724b;
        }

        public final int c() {
            return this.f7725c;
        }
    }

    static {
        k kVar = new k();
        f7722d = kVar;
        f7719a = new int[]{8184, 8388568, 268435426, 268435427, 268435428, 268435429, 268435430, 268435431, 268435432, 16777194, 1073741820, 268435433, 268435434, 1073741821, 268435435, 268435436, 268435437, 268435438, 268435439, 268435440, 268435441, 268435442, 1073741822, 268435443, 268435444, 268435445, 268435446, 268435447, 268435448, 268435449, 268435450, 268435451, 20, 1016, 1017, 4090, 8185, 21, 248, 2042, 1018, 1019, 249, 2043, 250, 22, 23, 24, 0, 1, 2, 25, 26, 27, 28, 29, 30, 31, 92, 251, 32764, 32, 4091, 1020, 8186, 33, 93, 94, 95, 96, 97, 98, 99, 100, 101, zz.f2799f, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 252, 115, 253, 8187, 524272, 8188, 16380, 34, 32765, 3, 35, 4, 36, 5, 37, 38, 39, 6, 116, 117, 40, 41, 42, 7, 43, 118, 44, 8, 9, 45, 119, 120, 121, 122, 123, 32766, 2044, 16381, 8189, 268435452, 1048550, 4194258, 1048551, 1048552, 4194259, 4194260, 4194261, 8388569, 4194262, 8388570, 8388571, 8388572, 8388573, 8388574, 16777195, 8388575, 16777196, 16777197, 4194263, 8388576, 16777198, 8388577, 8388578, 8388579, 8388580, 2097116, 4194264, 8388581, 4194265, 8388582, 8388583, 16777199, 4194266, 2097117, 1048553, 4194267, 4194268, 8388584, 8388585, 2097118, 8388586, 4194269, 4194270, 16777200, 2097119, 4194271, 8388587, 8388588, 2097120, 2097121, 4194272, 2097122, 8388589, 4194273, 8388590, 8388591, 1048554, 4194274, 4194275, 4194276, 8388592, 4194277, 4194278, 8388593, 67108832, 67108833, 1048555, 524273, 4194279, 8388594, 4194280, 33554412, 67108834, 67108835, 67108836, 134217694, 134217695, 67108837, 16777201, 33554413, 524274, 2097123, 67108838, 134217696, 134217697, 67108839, 134217698, 16777202, 2097124, 2097125, 67108840, 67108841, 268435453, 134217699, 134217700, 134217701, 1048556, 16777203, 1048557, 2097126, 4194281, 2097127, 2097128, 8388595, 4194282, 4194283, 33554414, 33554415, 16777204, 16777205, 67108842, 8388596, 67108843, 134217702, 67108844, 67108845, 134217703, 134217704, 134217705, 134217706, 134217707, 268435454, 134217708, 134217709, 134217710, 134217711, 134217712, 67108846};
        byte[] bArr = {13, 23, 28, 28, 28, 28, 28, 28, 28, 24, 30, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 28, 6, 10, 10, 12, 13, 6, 8, 11, 10, 10, 8, 11, 8, 6, 6, 6, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 8, 15, 6, 12, 10, 13, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 7, 8, 13, 19, 13, 14, 6, 15, 5, 6, 5, 6, 5, 6, 6, 6, 5, 7, 7, 6, 6, 6, 5, 6, 7, 6, 5, 5, 6, 7, 7, 7, 7, 7, 15, 11, 14, 13, 28, 20, 22, 20, 20, 22, 22, 22, 23, 22, 23, 23, 23, 23, 23, 24, 23, 24, 24, 22, 23, 24, 23, 23, 23, 23, 21, 22, 23, 22, 23, 23, 24, 22, 21, 20, 22, 22, 23, 23, 21, 23, 22, 22, 24, 21, 22, 23, 23, 21, 21, 22, 21, 23, 22, 23, 23, 20, 22, 22, 22, 23, 22, 22, 23, 26, 26, 20, 19, 22, 23, 22, 25, 26, 26, 26, 27, 27, 26, 24, 25, 19, 21, 26, 27, 27, 26, 27, 24, 21, 21, 26, 26, 28, 27, 27, 27, 20, 24, 20, 21, 22, 21, 21, 23, 22, 22, 25, 25, 24, 24, 26, 23, 26, 27, 26, 26, 27, 27, 27, 27, 27, 28, 27, 27, 27, 27, 27, 26};
        f7720b = bArr;
        f7721c = new a();
        int length = bArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            kVar.a(i6, f7719a[i6], f7720b[i6]);
        }
    }

    private k() {
    }

    private final void a(int i6, int i7, int i8) {
        a aVar = new a(i6, i8);
        a aVar2 = f7721c;
        while (i8 > 8) {
            i8 -= 8;
            int i9 = (i7 >>> i8) & 255;
            a[] a6 = aVar2.a();
            kotlin.jvm.internal.k.b(a6);
            a aVar3 = a6[i9];
            if (aVar3 == null) {
                aVar3 = new a();
                a6[i9] = aVar3;
            }
            aVar2 = aVar3;
        }
        int i10 = 8 - i8;
        int i11 = (i7 << i10) & 255;
        a[] a7 = aVar2.a();
        kotlin.jvm.internal.k.b(a7);
        f4.g.h(a7, aVar, i11, (1 << i10) + i11);
    }

    public final void b(q5.g source, long j6, q5.f sink) {
        kotlin.jvm.internal.k.e(source, "source");
        kotlin.jvm.internal.k.e(sink, "sink");
        a aVar = f7721c;
        int i6 = 0;
        int i7 = 0;
        for (long j7 = 0; j7 < j6; j7++) {
            i6 = (i6 << 8) | e5.b.b(source.readByte(), 255);
            i7 += 8;
            while (i7 >= 8) {
                int i8 = i7 - 8;
                a[] a6 = aVar.a();
                kotlin.jvm.internal.k.b(a6);
                aVar = a6[(i6 >>> i8) & 255];
                kotlin.jvm.internal.k.b(aVar);
                if (aVar.a() == null) {
                    sink.writeByte(aVar.b());
                    i7 -= aVar.c();
                    aVar = f7721c;
                } else {
                    i7 = i8;
                }
            }
        }
        while (i7 > 0) {
            a[] a7 = aVar.a();
            kotlin.jvm.internal.k.b(a7);
            a aVar2 = a7[(i6 << (8 - i7)) & 255];
            kotlin.jvm.internal.k.b(aVar2);
            if (aVar2.a() != null || aVar2.c() > i7) {
                return;
            }
            sink.writeByte(aVar2.b());
            i7 -= aVar2.c();
            aVar = f7721c;
        }
    }

    public final void c(q5.h source, q5.f sink) {
        kotlin.jvm.internal.k.e(source, "source");
        kotlin.jvm.internal.k.e(sink, "sink");
        int r6 = source.r();
        long j6 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < r6; i7++) {
            int b6 = e5.b.b(source.d(i7), 255);
            int i8 = f7719a[b6];
            byte b7 = f7720b[b6];
            j6 = (j6 << b7) | i8;
            i6 += b7;
            while (i6 >= 8) {
                i6 -= 8;
                sink.writeByte((int) (j6 >> i6));
            }
        }
        if (i6 > 0) {
            sink.writeByte((int) ((j6 << (8 - i6)) | (255 >>> i6)));
        }
    }

    public final int d(q5.h bytes) {
        kotlin.jvm.internal.k.e(bytes, "bytes");
        long j6 = 0;
        for (int i6 = 0; i6 < bytes.r(); i6++) {
            j6 += f7720b[e5.b.b(bytes.d(i6), 255)];
        }
        return (int) ((j6 + 7) >> 3);
    }
}
