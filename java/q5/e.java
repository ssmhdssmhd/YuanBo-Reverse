package q5;

import java.io.EOFException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final class e implements g, f, Cloneable, ByteChannel {

    /* renamed from: a, reason: collision with root package name */
    public v f8956a;

    /* renamed from: b, reason: collision with root package name */
    private long f8957b;

    @Override // q5.g
    public byte[] A(long j6) {
        if (!(j6 >= 0 && j6 <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(("byteCount: " + j6).toString());
        }
        if (size() < j6) {
            throw new EOFException();
        }
        byte[] bArr = new byte[(int) j6];
        M(bArr);
        return bArr;
    }

    @Override // q5.a0
    public long C(e sink, long j6) {
        kotlin.jvm.internal.k.e(sink, "sink");
        if (!(j6 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j6).toString());
        }
        if (size() == 0) {
            return -1L;
        }
        if (j6 > size()) {
            j6 = size();
        }
        sink.d(this, j6);
        return j6;
    }

    public long D(byte b6, long j6, long j7) {
        v vVar;
        int i6;
        long j8 = 0;
        if (!(0 <= j6 && j7 >= j6)) {
            throw new IllegalArgumentException(("size=" + size() + " fromIndex=" + j6 + " toIndex=" + j7).toString());
        }
        if (j7 > size()) {
            j7 = size();
        }
        if (j6 == j7 || (vVar = this.f8956a) == null) {
            return -1L;
        }
        if (size() - j6 < j6) {
            j8 = size();
            while (j8 > j6) {
                vVar = vVar.f8996g;
                kotlin.jvm.internal.k.b(vVar);
                j8 -= vVar.f8992c - vVar.f8991b;
            }
            while (j8 < j7) {
                byte[] bArr = vVar.f8990a;
                int min = (int) Math.min(vVar.f8992c, (vVar.f8991b + j7) - j8);
                i6 = (int) ((vVar.f8991b + j6) - j8);
                while (i6 < min) {
                    if (bArr[i6] != b6) {
                        i6++;
                    }
                }
                j8 += vVar.f8992c - vVar.f8991b;
                vVar = vVar.f8995f;
                kotlin.jvm.internal.k.b(vVar);
                j6 = j8;
            }
            return -1L;
        }
        while (true) {
            long j9 = (vVar.f8992c - vVar.f8991b) + j8;
            if (j9 > j6) {
                break;
            }
            vVar = vVar.f8995f;
            kotlin.jvm.internal.k.b(vVar);
            j8 = j9;
        }
        while (j8 < j7) {
            byte[] bArr2 = vVar.f8990a;
            int min2 = (int) Math.min(vVar.f8992c, (vVar.f8991b + j7) - j8);
            i6 = (int) ((vVar.f8991b + j6) - j8);
            while (i6 < min2) {
                if (bArr2[i6] != b6) {
                    i6++;
                }
            }
            j8 += vVar.f8992c - vVar.f8991b;
            vVar = vVar.f8995f;
            kotlin.jvm.internal.k.b(vVar);
            j6 = j8;
        }
        return -1L;
        return (i6 - vVar.f8991b) + j8;
    }

    public long F(h targetBytes) {
        kotlin.jvm.internal.k.e(targetBytes, "targetBytes");
        return I(targetBytes, 0L);
    }

    @Override // q5.g
    public String G(long j6) {
        if (!(j6 >= 0)) {
            throw new IllegalArgumentException(("limit < 0: " + j6).toString());
        }
        long j7 = j6 != Long.MAX_VALUE ? j6 + 1 : Long.MAX_VALUE;
        byte b6 = (byte) 10;
        long D = D(b6, 0L, j7);
        if (D != -1) {
            return r5.a.b(this, D);
        }
        if (j7 < size() && v(j7 - 1) == ((byte) 13) && v(j7) == b6) {
            return r5.a.b(this, j7);
        }
        e eVar = new e();
        t(eVar, 0L, Math.min(32, size()));
        throw new EOFException("\\n not found: limit=" + Math.min(size(), j6) + " content=" + eVar.K().i() + (char) 8230);
    }

    public long I(h targetBytes, long j6) {
        int i6;
        kotlin.jvm.internal.k.e(targetBytes, "targetBytes");
        long j7 = 0;
        if (!(j6 >= 0)) {
            throw new IllegalArgumentException(("fromIndex < 0: " + j6).toString());
        }
        v vVar = this.f8956a;
        if (vVar == null) {
            return -1L;
        }
        if (size() - j6 < j6) {
            j7 = size();
            while (j7 > j6) {
                vVar = vVar.f8996g;
                kotlin.jvm.internal.k.b(vVar);
                j7 -= vVar.f8992c - vVar.f8991b;
            }
            if (targetBytes.r() == 2) {
                byte d6 = targetBytes.d(0);
                byte d7 = targetBytes.d(1);
                while (j7 < size()) {
                    byte[] bArr = vVar.f8990a;
                    i6 = (int) ((vVar.f8991b + j6) - j7);
                    int i7 = vVar.f8992c;
                    while (i6 < i7) {
                        byte b6 = bArr[i6];
                        if (b6 != d6 && b6 != d7) {
                            i6++;
                        }
                    }
                    j7 += vVar.f8992c - vVar.f8991b;
                    vVar = vVar.f8995f;
                    kotlin.jvm.internal.k.b(vVar);
                    j6 = j7;
                }
                return -1L;
            }
            byte[] j8 = targetBytes.j();
            while (j7 < size()) {
                byte[] bArr2 = vVar.f8990a;
                i6 = (int) ((vVar.f8991b + j6) - j7);
                int i8 = vVar.f8992c;
                while (i6 < i8) {
                    byte b7 = bArr2[i6];
                    for (byte b8 : j8) {
                        if (b7 != b8) {
                        }
                    }
                    i6++;
                }
                j7 += vVar.f8992c - vVar.f8991b;
                vVar = vVar.f8995f;
                kotlin.jvm.internal.k.b(vVar);
                j6 = j7;
            }
            return -1L;
        }
        while (true) {
            long j9 = (vVar.f8992c - vVar.f8991b) + j7;
            if (j9 > j6) {
                break;
            }
            vVar = vVar.f8995f;
            kotlin.jvm.internal.k.b(vVar);
            j7 = j9;
        }
        if (targetBytes.r() == 2) {
            byte d8 = targetBytes.d(0);
            byte d9 = targetBytes.d(1);
            while (j7 < size()) {
                byte[] bArr3 = vVar.f8990a;
                i6 = (int) ((vVar.f8991b + j6) - j7);
                int i9 = vVar.f8992c;
                while (i6 < i9) {
                    byte b9 = bArr3[i6];
                    if (b9 != d8 && b9 != d9) {
                        i6++;
                    }
                }
                j7 += vVar.f8992c - vVar.f8991b;
                vVar = vVar.f8995f;
                kotlin.jvm.internal.k.b(vVar);
                j6 = j7;
            }
            return -1L;
        }
        byte[] j10 = targetBytes.j();
        while (j7 < size()) {
            byte[] bArr4 = vVar.f8990a;
            i6 = (int) ((vVar.f8991b + j6) - j7);
            int i10 = vVar.f8992c;
            while (i6 < i10) {
                byte b10 = bArr4[i6];
                for (byte b11 : j10) {
                    if (b10 != b11) {
                    }
                }
                i6++;
            }
            j7 += vVar.f8992c - vVar.f8991b;
            vVar = vVar.f8995f;
            kotlin.jvm.internal.k.b(vVar);
            j6 = j7;
        }
        return -1L;
        return (i6 - vVar.f8991b) + j7;
    }

    public h K() {
        return i(size());
    }

    public void M(byte[] sink) {
        kotlin.jvm.internal.k.e(sink, "sink");
        int i6 = 0;
        while (i6 < sink.length) {
            int read = read(sink, i6, sink.length - i6);
            if (read == -1) {
                throw new EOFException();
            }
            i6 += read;
        }
    }

    @Override // q5.g
    public void P(long j6) {
        if (this.f8957b < j6) {
            throw new EOFException();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ae A[EDGE_INSN: B:39:0x00ae->B:36:0x00ae BREAK  A[LOOP:0: B:4:0x000d->B:38:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a6  */
    @Override // q5.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long T() {
        /*
            r15 = this;
            long r0 = r15.size()
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto Lb8
            r0 = 0
            r4 = r2
            r1 = 0
        Ld:
            q5.v r6 = r15.f8956a
            kotlin.jvm.internal.k.b(r6)
            byte[] r7 = r6.f8990a
            int r8 = r6.f8991b
            int r9 = r6.f8992c
        L18:
            if (r8 >= r9) goto L9a
            r10 = r7[r8]
            r11 = 48
            byte r11 = (byte) r11
            if (r10 < r11) goto L29
            r12 = 57
            byte r12 = (byte) r12
            if (r10 > r12) goto L29
            int r11 = r10 - r11
            goto L43
        L29:
            r11 = 97
            byte r11 = (byte) r11
            if (r10 < r11) goto L38
            r12 = 102(0x66, float:1.43E-43)
            byte r12 = (byte) r12
            if (r10 > r12) goto L38
        L33:
            int r11 = r10 - r11
            int r11 = r11 + 10
            goto L43
        L38:
            r11 = 65
            byte r11 = (byte) r11
            if (r10 < r11) goto L7b
            r12 = 70
            byte r12 = (byte) r12
            if (r10 > r12) goto L7b
            goto L33
        L43:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L53
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L18
        L53:
            q5.e r0 = new q5.e
            r0.<init>()
            q5.e r0 = r0.g(r4)
            q5.e r0 = r0.writeByte(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Number too large: "
            r2.append(r3)
            java.lang.String r0 = r0.X()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L7b:
            if (r0 == 0) goto L7f
            r1 = 1
            goto L9a
        L7f:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.append(r2)
            java.lang.String r2 = q5.c.e(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L9a:
            if (r8 != r9) goto La6
            q5.v r7 = r6.b()
            r15.f8956a = r7
            q5.w.b(r6)
            goto La8
        La6:
            r6.f8991b = r8
        La8:
            if (r1 != 0) goto Lae
            q5.v r6 = r15.f8956a
            if (r6 != 0) goto Ld
        Lae:
            long r1 = r15.size()
            long r6 = (long) r0
            long r1 = r1 - r6
            r15.Z(r1)
            return r4
        Lb8:
            java.io.EOFException r0 = new java.io.EOFException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: q5.e.T():long");
    }

    public int U() {
        return c.c(readInt());
    }

    public short V() {
        return c.d(readShort());
    }

    public String W(long j6, Charset charset) {
        kotlin.jvm.internal.k.e(charset, "charset");
        if (!(j6 >= 0 && j6 <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(("byteCount: " + j6).toString());
        }
        if (this.f8957b < j6) {
            throw new EOFException();
        }
        if (j6 == 0) {
            return "";
        }
        v vVar = this.f8956a;
        kotlin.jvm.internal.k.b(vVar);
        int i6 = vVar.f8991b;
        if (i6 + j6 > vVar.f8992c) {
            return new String(A(j6), charset);
        }
        int i7 = (int) j6;
        String str = new String(vVar.f8990a, i6, i7, charset);
        int i8 = vVar.f8991b + i7;
        vVar.f8991b = i8;
        this.f8957b -= j6;
        if (i8 == vVar.f8992c) {
            this.f8956a = vVar.b();
            w.b(vVar);
        }
        return str;
    }

    public String X() {
        return W(this.f8957b, v4.d.f9880b);
    }

    public String Y(long j6) {
        return W(j6, v4.d.f9880b);
    }

    public final void Z(long j6) {
        this.f8957b = j6;
    }

    public final void a() {
        skip(size());
    }

    public final h a0() {
        if (size() <= ((long) Integer.MAX_VALUE)) {
            return b0((int) size());
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + size()).toString());
    }

    @Override // q5.g, q5.f
    public e b() {
        return this;
    }

    public final h b0(int i6) {
        if (i6 == 0) {
            return h.f8958d;
        }
        c.b(size(), 0L, i6);
        v vVar = this.f8956a;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i8 < i6) {
            kotlin.jvm.internal.k.b(vVar);
            int i10 = vVar.f8992c;
            int i11 = vVar.f8991b;
            if (i10 == i11) {
                throw new AssertionError("s.limit == s.pos");
            }
            i8 += i10 - i11;
            i9++;
            vVar = vVar.f8995f;
        }
        byte[][] bArr = new byte[i9][];
        int[] iArr = new int[i9 * 2];
        v vVar2 = this.f8956a;
        int i12 = 0;
        while (i7 < i6) {
            kotlin.jvm.internal.k.b(vVar2);
            bArr[i12] = vVar2.f8990a;
            i7 += vVar2.f8992c - vVar2.f8991b;
            iArr[i12] = Math.min(i7, i6);
            iArr[i12 + i9] = vVar2.f8991b;
            vVar2.f8993d = true;
            i12++;
            vVar2 = vVar2.f8995f;
        }
        return new x(bArr, iArr);
    }

    @Override // q5.a0
    public b0 c() {
        return b0.f8940d;
    }

    public final v c0(int i6) {
        if (!(i6 >= 1 && i6 <= 8192)) {
            throw new IllegalArgumentException("unexpected capacity".toString());
        }
        v vVar = this.f8956a;
        if (vVar != null) {
            kotlin.jvm.internal.k.b(vVar);
            v vVar2 = vVar.f8996g;
            kotlin.jvm.internal.k.b(vVar2);
            return (vVar2.f8992c + i6 > 8192 || !vVar2.f8994e) ? vVar2.c(w.c()) : vVar2;
        }
        v c6 = w.c();
        this.f8956a = c6;
        c6.f8996g = c6;
        c6.f8995f = c6;
        return c6;
    }

    @Override // q5.a0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // q5.y
    public void d(e source, long j6) {
        v vVar;
        kotlin.jvm.internal.k.e(source, "source");
        if (!(source != this)) {
            throw new IllegalArgumentException("source == this".toString());
        }
        c.b(source.size(), 0L, j6);
        while (j6 > 0) {
            v vVar2 = source.f8956a;
            kotlin.jvm.internal.k.b(vVar2);
            int i6 = vVar2.f8992c;
            kotlin.jvm.internal.k.b(source.f8956a);
            if (j6 < i6 - r2.f8991b) {
                v vVar3 = this.f8956a;
                if (vVar3 != null) {
                    kotlin.jvm.internal.k.b(vVar3);
                    vVar = vVar3.f8996g;
                } else {
                    vVar = null;
                }
                if (vVar != null && vVar.f8994e) {
                    if ((vVar.f8992c + j6) - (vVar.f8993d ? 0 : vVar.f8991b) <= 8192) {
                        v vVar4 = source.f8956a;
                        kotlin.jvm.internal.k.b(vVar4);
                        vVar4.f(vVar, (int) j6);
                        source.Z(source.size() - j6);
                        Z(size() + j6);
                        return;
                    }
                }
                v vVar5 = source.f8956a;
                kotlin.jvm.internal.k.b(vVar5);
                source.f8956a = vVar5.e((int) j6);
            }
            v vVar6 = source.f8956a;
            kotlin.jvm.internal.k.b(vVar6);
            long j7 = vVar6.f8992c - vVar6.f8991b;
            source.f8956a = vVar6.b();
            v vVar7 = this.f8956a;
            if (vVar7 == null) {
                this.f8956a = vVar6;
                vVar6.f8996g = vVar6;
                vVar6.f8995f = vVar6;
            } else {
                kotlin.jvm.internal.k.b(vVar7);
                v vVar8 = vVar7.f8996g;
                kotlin.jvm.internal.k.b(vVar8);
                vVar8.c(vVar6).a();
            }
            source.Z(source.size() - j7);
            Z(size() + j7);
            j6 -= j7;
        }
    }

    @Override // q5.f
    /* renamed from: d0, reason: merged with bridge method [inline-methods] */
    public e E(h byteString) {
        kotlin.jvm.internal.k.e(byteString, "byteString");
        byteString.v(this, 0, byteString.r());
        return this;
    }

    @Override // q5.f
    /* renamed from: e0, reason: merged with bridge method [inline-methods] */
    public e write(byte[] source) {
        kotlin.jvm.internal.k.e(source, "source");
        return write(source, 0, source.length);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (size() == eVar.size()) {
                if (size() == 0) {
                    return true;
                }
                v vVar = this.f8956a;
                kotlin.jvm.internal.k.b(vVar);
                v vVar2 = eVar.f8956a;
                kotlin.jvm.internal.k.b(vVar2);
                int i6 = vVar.f8991b;
                int i7 = vVar2.f8991b;
                long j6 = 0;
                while (j6 < size()) {
                    long min = Math.min(vVar.f8992c - i6, vVar2.f8992c - i7);
                    long j7 = 0;
                    while (j7 < min) {
                        int i8 = i6 + 1;
                        int i9 = i7 + 1;
                        if (vVar.f8990a[i6] == vVar2.f8990a[i7]) {
                            j7++;
                            i6 = i8;
                            i7 = i9;
                        }
                    }
                    if (i6 == vVar.f8992c) {
                        vVar = vVar.f8995f;
                        kotlin.jvm.internal.k.b(vVar);
                        i6 = vVar.f8991b;
                    }
                    if (i7 == vVar2.f8992c) {
                        vVar2 = vVar2.f8995f;
                        kotlin.jvm.internal.k.b(vVar2);
                        i7 = vVar2.f8991b;
                    }
                    j6 += min;
                }
                return true;
            }
        }
        return false;
    }

    @Override // q5.f
    /* renamed from: f0, reason: merged with bridge method [inline-methods] */
    public e write(byte[] source, int i6, int i7) {
        kotlin.jvm.internal.k.e(source, "source");
        long j6 = i7;
        c.b(source.length, i6, j6);
        int i8 = i7 + i6;
        while (i6 < i8) {
            v c02 = c0(1);
            int min = Math.min(i8 - i6, 8192 - c02.f8992c);
            int i9 = i6 + min;
            f4.g.c(source, c02.f8990a, c02.f8992c, i6, i9);
            c02.f8992c += min;
            i6 = i9;
        }
        Z(size() + j6);
        return this;
    }

    @Override // q5.f, q5.y, java.io.Flushable
    public void flush() {
    }

    public long g0(a0 source) {
        kotlin.jvm.internal.k.e(source, "source");
        long j6 = 0;
        while (true) {
            long C = source.C(this, 8192);
            if (C == -1) {
                return j6;
            }
            j6 += C;
        }
    }

    @Override // q5.f
    /* renamed from: h0, reason: merged with bridge method [inline-methods] */
    public e writeByte(int i6) {
        v c02 = c0(1);
        byte[] bArr = c02.f8990a;
        int i7 = c02.f8992c;
        c02.f8992c = i7 + 1;
        bArr[i7] = (byte) i6;
        Z(size() + 1);
        return this;
    }

    public int hashCode() {
        v vVar = this.f8956a;
        if (vVar == null) {
            return 0;
        }
        int i6 = 1;
        do {
            int i7 = vVar.f8992c;
            for (int i8 = vVar.f8991b; i8 < i7; i8++) {
                i6 = (i6 * 31) + vVar.f8990a[i8];
            }
            vVar = vVar.f8995f;
            kotlin.jvm.internal.k.b(vVar);
        } while (vVar != this.f8956a);
        return i6;
    }

    @Override // q5.g
    public h i(long j6) {
        if (!(j6 >= 0 && j6 <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(("byteCount: " + j6).toString());
        }
        if (size() < j6) {
            throw new EOFException();
        }
        if (j6 < 4096) {
            return new h(A(j6));
        }
        h b02 = b0((int) j6);
        skip(j6);
        return b02;
    }

    @Override // q5.f
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public e g(long j6) {
        if (j6 == 0) {
            return writeByte(48);
        }
        long j7 = (j6 >>> 1) | j6;
        long j8 = j7 | (j7 >>> 2);
        long j9 = j8 | (j8 >>> 4);
        long j10 = j9 | (j9 >>> 8);
        long j11 = j10 | (j10 >>> 16);
        long j12 = j11 | (j11 >>> 32);
        long j13 = j12 - ((j12 >>> 1) & 6148914691236517205L);
        long j14 = ((j13 >>> 2) & 3689348814741910323L) + (j13 & 3689348814741910323L);
        long j15 = ((j14 >>> 4) + j14) & 1085102592571150095L;
        long j16 = j15 + (j15 >>> 8);
        long j17 = j16 + (j16 >>> 16);
        int i6 = (int) ((((j17 & 63) + ((j17 >>> 32) & 63)) + 3) / 4);
        v c02 = c0(i6);
        byte[] bArr = c02.f8990a;
        int i7 = c02.f8992c;
        for (int i8 = (i7 + i6) - 1; i8 >= i7; i8--) {
            bArr[i8] = r5.a.a()[(int) (15 & j6)];
            j6 >>>= 4;
        }
        c02.f8992c += i6;
        Z(size() + i6);
        return this;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    @Override // q5.f
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public e writeInt(int i6) {
        v c02 = c0(4);
        byte[] bArr = c02.f8990a;
        int i7 = c02.f8992c;
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((i6 >>> 24) & 255);
        int i9 = i8 + 1;
        bArr[i8] = (byte) ((i6 >>> 16) & 255);
        int i10 = i9 + 1;
        bArr[i9] = (byte) ((i6 >>> 8) & 255);
        bArr[i10] = (byte) (i6 & 255);
        c02.f8992c = i10 + 1;
        Z(size() + 4);
        return this;
    }

    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public e clone() {
        return s();
    }

    @Override // q5.f
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public e writeShort(int i6) {
        v c02 = c0(2);
        byte[] bArr = c02.f8990a;
        int i7 = c02.f8992c;
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((i6 >>> 8) & 255);
        bArr[i8] = (byte) (i6 & 255);
        c02.f8992c = i8 + 1;
        Z(size() + 2);
        return this;
    }

    public e l0(String string, int i6, int i7, Charset charset) {
        kotlin.jvm.internal.k.e(string, "string");
        kotlin.jvm.internal.k.e(charset, "charset");
        if (!(i6 >= 0)) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i6).toString());
        }
        if (!(i7 >= i6)) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i7 + " < " + i6).toString());
        }
        if (!(i7 <= string.length())) {
            throw new IllegalArgumentException(("endIndex > string.length: " + i7 + " > " + string.length()).toString());
        }
        if (kotlin.jvm.internal.k.a(charset, v4.d.f9880b)) {
            return n0(string, i6, i7);
        }
        String substring = string.substring(i6, i7);
        kotlin.jvm.internal.k.d(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        if (substring == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes = substring.getBytes(charset);
        kotlin.jvm.internal.k.d(bytes, "(this as java.lang.String).getBytes(charset)");
        return write(bytes, 0, bytes.length);
    }

    @Override // q5.f
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public e Q(String string) {
        kotlin.jvm.internal.k.e(string, "string");
        return n0(string, 0, string.length());
    }

    public e n0(String string, int i6, int i7) {
        long size;
        long j6;
        kotlin.jvm.internal.k.e(string, "string");
        if (!(i6 >= 0)) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i6).toString());
        }
        if (!(i7 >= i6)) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i7 + " < " + i6).toString());
        }
        if (!(i7 <= string.length())) {
            throw new IllegalArgumentException(("endIndex > string.length: " + i7 + " > " + string.length()).toString());
        }
        while (i6 < i7) {
            char charAt = string.charAt(i6);
            if (charAt < 128) {
                v c02 = c0(1);
                byte[] bArr = c02.f8990a;
                int i8 = c02.f8992c - i6;
                int min = Math.min(i7, 8192 - i8);
                int i9 = i6 + 1;
                bArr[i6 + i8] = (byte) charAt;
                while (i9 < min) {
                    char charAt2 = string.charAt(i9);
                    if (charAt2 >= 128) {
                        break;
                    }
                    bArr[i9 + i8] = (byte) charAt2;
                    i9++;
                }
                int i10 = c02.f8992c;
                int i11 = (i8 + i9) - i10;
                c02.f8992c = i10 + i11;
                Z(size() + i11);
                i6 = i9;
            } else {
                if (charAt < 2048) {
                    v c03 = c0(2);
                    byte[] bArr2 = c03.f8990a;
                    int i12 = c03.f8992c;
                    bArr2[i12] = (byte) ((charAt >> 6) | 192);
                    bArr2[i12 + 1] = (byte) ((charAt & '?') | 128);
                    c03.f8992c = i12 + 2;
                    size = size();
                    j6 = 2;
                } else if (charAt < 55296 || charAt > 57343) {
                    v c04 = c0(3);
                    byte[] bArr3 = c04.f8990a;
                    int i13 = c04.f8992c;
                    bArr3[i13] = (byte) ((charAt >> '\f') | 224);
                    bArr3[i13 + 1] = (byte) ((63 & (charAt >> 6)) | 128);
                    bArr3[i13 + 2] = (byte) ((charAt & '?') | 128);
                    c04.f8992c = i13 + 3;
                    size = size();
                    j6 = 3;
                } else {
                    int i14 = i6 + 1;
                    char charAt3 = i14 < i7 ? string.charAt(i14) : (char) 0;
                    if (charAt > 56319 || 56320 > charAt3 || 57343 < charAt3) {
                        writeByte(63);
                        i6 = i14;
                    } else {
                        int i15 = (((charAt & 1023) << 10) | (charAt3 & 1023)) + 65536;
                        v c05 = c0(4);
                        byte[] bArr4 = c05.f8990a;
                        int i16 = c05.f8992c;
                        bArr4[i16] = (byte) ((i15 >> 18) | 240);
                        bArr4[i16 + 1] = (byte) (((i15 >> 12) & 63) | 128);
                        bArr4[i16 + 2] = (byte) (((i15 >> 6) & 63) | 128);
                        bArr4[i16 + 3] = (byte) ((i15 & 63) | 128);
                        c05.f8992c = i16 + 4;
                        Z(size() + 4);
                        i6 += 2;
                    }
                }
                Z(size + j6);
                i6++;
            }
        }
        return this;
    }

    public e o0(int i6) {
        long size;
        long j6;
        if (i6 < 128) {
            writeByte(i6);
        } else {
            if (i6 < 2048) {
                v c02 = c0(2);
                byte[] bArr = c02.f8990a;
                int i7 = c02.f8992c;
                bArr[i7] = (byte) ((i6 >> 6) | 192);
                bArr[i7 + 1] = (byte) ((i6 & 63) | 128);
                c02.f8992c = i7 + 2;
                size = size();
                j6 = 2;
            } else if (55296 <= i6 && 57343 >= i6) {
                writeByte(63);
            } else if (i6 < 65536) {
                v c03 = c0(3);
                byte[] bArr2 = c03.f8990a;
                int i8 = c03.f8992c;
                bArr2[i8] = (byte) ((i6 >> 12) | 224);
                bArr2[i8 + 1] = (byte) (((i6 >> 6) & 63) | 128);
                bArr2[i8 + 2] = (byte) ((i6 & 63) | 128);
                c03.f8992c = i8 + 3;
                size = size();
                j6 = 3;
            } else {
                if (i6 > 1114111) {
                    throw new IllegalArgumentException("Unexpected code point: 0x" + c.f(i6));
                }
                v c04 = c0(4);
                byte[] bArr3 = c04.f8990a;
                int i9 = c04.f8992c;
                bArr3[i9] = (byte) ((i6 >> 18) | 240);
                bArr3[i9 + 1] = (byte) (((i6 >> 12) & 63) | 128);
                bArr3[i9 + 2] = (byte) (((i6 >> 6) & 63) | 128);
                bArr3[i9 + 3] = (byte) ((i6 & 63) | 128);
                c04.f8992c = i9 + 4;
                size = size();
                j6 = 4;
            }
            Z(size + j6);
        }
        return this;
    }

    public final long q() {
        long size = size();
        if (size == 0) {
            return 0L;
        }
        v vVar = this.f8956a;
        kotlin.jvm.internal.k.b(vVar);
        v vVar2 = vVar.f8996g;
        kotlin.jvm.internal.k.b(vVar2);
        if (vVar2.f8992c < 8192 && vVar2.f8994e) {
            size -= r3 - vVar2.f8991b;
        }
        return size;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer sink) {
        kotlin.jvm.internal.k.e(sink, "sink");
        v vVar = this.f8956a;
        if (vVar == null) {
            return -1;
        }
        int min = Math.min(sink.remaining(), vVar.f8992c - vVar.f8991b);
        sink.put(vVar.f8990a, vVar.f8991b, min);
        int i6 = vVar.f8991b + min;
        vVar.f8991b = i6;
        this.f8957b -= min;
        if (i6 == vVar.f8992c) {
            this.f8956a = vVar.b();
            w.b(vVar);
        }
        return min;
    }

    public int read(byte[] sink, int i6, int i7) {
        kotlin.jvm.internal.k.e(sink, "sink");
        c.b(sink.length, i6, i7);
        v vVar = this.f8956a;
        if (vVar == null) {
            return -1;
        }
        int min = Math.min(i7, vVar.f8992c - vVar.f8991b);
        byte[] bArr = vVar.f8990a;
        int i8 = vVar.f8991b;
        f4.g.c(bArr, sink, i6, i8, i8 + min);
        vVar.f8991b += min;
        Z(size() - min);
        if (vVar.f8991b != vVar.f8992c) {
            return min;
        }
        this.f8956a = vVar.b();
        w.b(vVar);
        return min;
    }

    @Override // q5.g
    public byte readByte() {
        if (size() == 0) {
            throw new EOFException();
        }
        v vVar = this.f8956a;
        kotlin.jvm.internal.k.b(vVar);
        int i6 = vVar.f8991b;
        int i7 = vVar.f8992c;
        int i8 = i6 + 1;
        byte b6 = vVar.f8990a[i6];
        Z(size() - 1);
        if (i8 == i7) {
            this.f8956a = vVar.b();
            w.b(vVar);
        } else {
            vVar.f8991b = i8;
        }
        return b6;
    }

    @Override // q5.g
    public int readInt() {
        if (size() < 4) {
            throw new EOFException();
        }
        v vVar = this.f8956a;
        kotlin.jvm.internal.k.b(vVar);
        int i6 = vVar.f8991b;
        int i7 = vVar.f8992c;
        if (i7 - i6 < 4) {
            return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
        }
        byte[] bArr = vVar.f8990a;
        int i8 = i6 + 1;
        int i9 = i8 + 1;
        int i10 = ((bArr[i6] & 255) << 24) | ((bArr[i8] & 255) << 16);
        int i11 = i9 + 1;
        int i12 = i10 | ((bArr[i9] & 255) << 8);
        int i13 = i11 + 1;
        int i14 = i12 | (bArr[i11] & 255);
        Z(size() - 4);
        if (i13 == i7) {
            this.f8956a = vVar.b();
            w.b(vVar);
        } else {
            vVar.f8991b = i13;
        }
        return i14;
    }

    @Override // q5.g
    public short readShort() {
        if (size() < 2) {
            throw new EOFException();
        }
        v vVar = this.f8956a;
        kotlin.jvm.internal.k.b(vVar);
        int i6 = vVar.f8991b;
        int i7 = vVar.f8992c;
        if (i7 - i6 < 2) {
            return (short) (((readByte() & 255) << 8) | (readByte() & 255));
        }
        byte[] bArr = vVar.f8990a;
        int i8 = i6 + 1;
        int i9 = i8 + 1;
        int i10 = ((bArr[i6] & 255) << 8) | (bArr[i8] & 255);
        Z(size() - 2);
        if (i9 == i7) {
            this.f8956a = vVar.b();
            w.b(vVar);
        } else {
            vVar.f8991b = i9;
        }
        return (short) i10;
    }

    public final e s() {
        e eVar = new e();
        if (size() != 0) {
            v vVar = this.f8956a;
            kotlin.jvm.internal.k.b(vVar);
            v d6 = vVar.d();
            eVar.f8956a = d6;
            d6.f8996g = d6;
            d6.f8995f = d6;
            for (v vVar2 = vVar.f8995f; vVar2 != vVar; vVar2 = vVar2.f8995f) {
                v vVar3 = d6.f8996g;
                kotlin.jvm.internal.k.b(vVar3);
                kotlin.jvm.internal.k.b(vVar2);
                vVar3.c(vVar2.d());
            }
            eVar.Z(size());
        }
        return eVar;
    }

    public final long size() {
        return this.f8957b;
    }

    @Override // q5.g
    public void skip(long j6) {
        while (j6 > 0) {
            v vVar = this.f8956a;
            if (vVar == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j6, vVar.f8992c - vVar.f8991b);
            long j7 = min;
            Z(size() - j7);
            j6 -= j7;
            int i6 = vVar.f8991b + min;
            vVar.f8991b = i6;
            if (i6 == vVar.f8992c) {
                this.f8956a = vVar.b();
                w.b(vVar);
            }
        }
    }

    public final e t(e out, long j6, long j7) {
        kotlin.jvm.internal.k.e(out, "out");
        c.b(size(), j6, j7);
        if (j7 != 0) {
            out.Z(out.size() + j7);
            v vVar = this.f8956a;
            while (true) {
                kotlin.jvm.internal.k.b(vVar);
                int i6 = vVar.f8992c;
                int i7 = vVar.f8991b;
                if (j6 < i6 - i7) {
                    break;
                }
                j6 -= i6 - i7;
                vVar = vVar.f8995f;
            }
            while (j7 > 0) {
                kotlin.jvm.internal.k.b(vVar);
                v d6 = vVar.d();
                int i8 = d6.f8991b + ((int) j6);
                d6.f8991b = i8;
                d6.f8992c = Math.min(i8 + ((int) j7), d6.f8992c);
                v vVar2 = out.f8956a;
                if (vVar2 == null) {
                    d6.f8996g = d6;
                    d6.f8995f = d6;
                    out.f8956a = d6;
                } else {
                    kotlin.jvm.internal.k.b(vVar2);
                    v vVar3 = vVar2.f8996g;
                    kotlin.jvm.internal.k.b(vVar3);
                    vVar3.c(d6);
                }
                j7 -= d6.f8992c - d6.f8991b;
                vVar = vVar.f8995f;
                j6 = 0;
            }
        }
        return this;
    }

    public String toString() {
        return a0().toString();
    }

    @Override // q5.g
    public String u() {
        return G(Long.MAX_VALUE);
    }

    public final byte v(long j6) {
        c.b(size(), j6, 1L);
        v vVar = this.f8956a;
        if (vVar == null) {
            kotlin.jvm.internal.k.b(null);
            throw null;
        }
        if (size() - j6 < j6) {
            long size = size();
            while (size > j6) {
                vVar = vVar.f8996g;
                kotlin.jvm.internal.k.b(vVar);
                size -= vVar.f8992c - vVar.f8991b;
            }
            kotlin.jvm.internal.k.b(vVar);
            return vVar.f8990a[(int) ((vVar.f8991b + j6) - size)];
        }
        long j7 = 0;
        while (true) {
            long j8 = (vVar.f8992c - vVar.f8991b) + j7;
            if (j8 > j6) {
                kotlin.jvm.internal.k.b(vVar);
                return vVar.f8990a[(int) ((vVar.f8991b + j6) - j7)];
            }
            vVar = vVar.f8995f;
            kotlin.jvm.internal.k.b(vVar);
            j7 = j8;
        }
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer source) {
        kotlin.jvm.internal.k.e(source, "source");
        int remaining = source.remaining();
        int i6 = remaining;
        while (i6 > 0) {
            v c02 = c0(1);
            int min = Math.min(i6, 8192 - c02.f8992c);
            source.get(c02.f8990a, c02.f8992c, min);
            i6 -= min;
            c02.f8992c += min;
        }
        this.f8957b += remaining;
        return remaining;
    }

    @Override // q5.g
    public byte[] x() {
        return A(size());
    }

    @Override // q5.g
    public boolean y() {
        return this.f8957b == 0;
    }
}
