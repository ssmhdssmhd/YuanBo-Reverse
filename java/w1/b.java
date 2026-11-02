package w1;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.SparseArray;
import com.tendcloud.tenddata.ab;
import i2.c1;
import i2.h0;
import i2.t;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import u1.b;

/* loaded from: classes.dex */
final class b {

    /* renamed from: h, reason: collision with root package name */
    private static final byte[] f10157h = {0, 7, 8, 15};

    /* renamed from: i, reason: collision with root package name */
    private static final byte[] f10158i = {0, 119, -120, -1};

    /* renamed from: j, reason: collision with root package name */
    private static final byte[] f10159j = {0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};

    /* renamed from: a, reason: collision with root package name */
    private final Paint f10160a;

    /* renamed from: b, reason: collision with root package name */
    private final Paint f10161b;

    /* renamed from: c, reason: collision with root package name */
    private final Canvas f10162c;

    /* renamed from: d, reason: collision with root package name */
    private final C0156b f10163d;

    /* renamed from: e, reason: collision with root package name */
    private final a f10164e;

    /* renamed from: f, reason: collision with root package name */
    private final h f10165f;

    /* renamed from: g, reason: collision with root package name */
    private Bitmap f10166g;

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f10167a;

        /* renamed from: b, reason: collision with root package name */
        public final int[] f10168b;

        /* renamed from: c, reason: collision with root package name */
        public final int[] f10169c;

        /* renamed from: d, reason: collision with root package name */
        public final int[] f10170d;

        public a(int i6, int[] iArr, int[] iArr2, int[] iArr3) {
            this.f10167a = i6;
            this.f10168b = iArr;
            this.f10169c = iArr2;
            this.f10170d = iArr3;
        }
    }

    /* renamed from: w1.b$b, reason: collision with other inner class name */
    private static final class C0156b {

        /* renamed from: a, reason: collision with root package name */
        public final int f10171a;

        /* renamed from: b, reason: collision with root package name */
        public final int f10172b;

        /* renamed from: c, reason: collision with root package name */
        public final int f10173c;

        /* renamed from: d, reason: collision with root package name */
        public final int f10174d;

        /* renamed from: e, reason: collision with root package name */
        public final int f10175e;

        /* renamed from: f, reason: collision with root package name */
        public final int f10176f;

        public C0156b(int i6, int i7, int i8, int i9, int i10, int i11) {
            this.f10171a = i6;
            this.f10172b = i7;
            this.f10173c = i8;
            this.f10174d = i9;
            this.f10175e = i10;
            this.f10176f = i11;
        }
    }

    private static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final int f10177a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f10178b;

        /* renamed from: c, reason: collision with root package name */
        public final byte[] f10179c;

        /* renamed from: d, reason: collision with root package name */
        public final byte[] f10180d;

        public c(int i6, boolean z5, byte[] bArr, byte[] bArr2) {
            this.f10177a = i6;
            this.f10178b = z5;
            this.f10179c = bArr;
            this.f10180d = bArr2;
        }
    }

    private static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final int f10181a;

        /* renamed from: b, reason: collision with root package name */
        public final int f10182b;

        /* renamed from: c, reason: collision with root package name */
        public final int f10183c;

        /* renamed from: d, reason: collision with root package name */
        public final SparseArray<e> f10184d;

        public d(int i6, int i7, int i8, SparseArray<e> sparseArray) {
            this.f10181a = i6;
            this.f10182b = i7;
            this.f10183c = i8;
            this.f10184d = sparseArray;
        }
    }

    private static final class e {

        /* renamed from: a, reason: collision with root package name */
        public final int f10185a;

        /* renamed from: b, reason: collision with root package name */
        public final int f10186b;

        public e(int i6, int i7) {
            this.f10185a = i6;
            this.f10186b = i7;
        }
    }

    private static final class f {

        /* renamed from: a, reason: collision with root package name */
        public final int f10187a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f10188b;

        /* renamed from: c, reason: collision with root package name */
        public final int f10189c;

        /* renamed from: d, reason: collision with root package name */
        public final int f10190d;

        /* renamed from: e, reason: collision with root package name */
        public final int f10191e;

        /* renamed from: f, reason: collision with root package name */
        public final int f10192f;

        /* renamed from: g, reason: collision with root package name */
        public final int f10193g;

        /* renamed from: h, reason: collision with root package name */
        public final int f10194h;

        /* renamed from: i, reason: collision with root package name */
        public final int f10195i;

        /* renamed from: j, reason: collision with root package name */
        public final int f10196j;

        /* renamed from: k, reason: collision with root package name */
        public final SparseArray<g> f10197k;

        public f(int i6, boolean z5, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, SparseArray<g> sparseArray) {
            this.f10187a = i6;
            this.f10188b = z5;
            this.f10189c = i7;
            this.f10190d = i8;
            this.f10191e = i9;
            this.f10192f = i10;
            this.f10193g = i11;
            this.f10194h = i12;
            this.f10195i = i13;
            this.f10196j = i14;
            this.f10197k = sparseArray;
        }

        public void a(f fVar) {
            SparseArray<g> sparseArray = fVar.f10197k;
            for (int i6 = 0; i6 < sparseArray.size(); i6++) {
                this.f10197k.put(sparseArray.keyAt(i6), sparseArray.valueAt(i6));
            }
        }
    }

    private static final class g {

        /* renamed from: a, reason: collision with root package name */
        public final int f10198a;

        /* renamed from: b, reason: collision with root package name */
        public final int f10199b;

        /* renamed from: c, reason: collision with root package name */
        public final int f10200c;

        /* renamed from: d, reason: collision with root package name */
        public final int f10201d;

        /* renamed from: e, reason: collision with root package name */
        public final int f10202e;

        /* renamed from: f, reason: collision with root package name */
        public final int f10203f;

        public g(int i6, int i7, int i8, int i9, int i10, int i11) {
            this.f10198a = i6;
            this.f10199b = i7;
            this.f10200c = i8;
            this.f10201d = i9;
            this.f10202e = i10;
            this.f10203f = i11;
        }
    }

    private static final class h {

        /* renamed from: a, reason: collision with root package name */
        public final int f10204a;

        /* renamed from: b, reason: collision with root package name */
        public final int f10205b;

        /* renamed from: c, reason: collision with root package name */
        public final SparseArray<f> f10206c = new SparseArray<>();

        /* renamed from: d, reason: collision with root package name */
        public final SparseArray<a> f10207d = new SparseArray<>();

        /* renamed from: e, reason: collision with root package name */
        public final SparseArray<c> f10208e = new SparseArray<>();

        /* renamed from: f, reason: collision with root package name */
        public final SparseArray<a> f10209f = new SparseArray<>();

        /* renamed from: g, reason: collision with root package name */
        public final SparseArray<c> f10210g = new SparseArray<>();

        /* renamed from: h, reason: collision with root package name */
        public C0156b f10211h;

        /* renamed from: i, reason: collision with root package name */
        public d f10212i;

        public h(int i6, int i7) {
            this.f10204a = i6;
            this.f10205b = i7;
        }

        public void a() {
            this.f10206c.clear();
            this.f10207d.clear();
            this.f10208e.clear();
            this.f10209f.clear();
            this.f10210g.clear();
            this.f10211h = null;
            this.f10212i = null;
        }
    }

    public b(int i6, int i7) {
        Paint paint = new Paint();
        this.f10160a = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setPathEffect(null);
        Paint paint2 = new Paint();
        this.f10161b = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        paint2.setPathEffect(null);
        this.f10162c = new Canvas();
        this.f10163d = new C0156b(719, 575, 0, 719, 0, 575);
        this.f10164e = new a(0, c(), d(), e());
        this.f10165f = new h(i6, i7);
    }

    private static byte[] a(int i6, int i7, h0 h0Var) {
        byte[] bArr = new byte[i6];
        for (int i8 = 0; i8 < i6; i8++) {
            bArr[i8] = (byte) h0Var.h(i7);
        }
        return bArr;
    }

    private static int[] c() {
        return new int[]{0, -1, -16777216, -8421505};
    }

    private static int[] d() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i6 = 1; i6 < 16; i6++) {
            if (i6 < 8) {
                iArr[i6] = f(255, (i6 & 1) != 0 ? 255 : 0, (i6 & 2) != 0 ? 255 : 0, (i6 & 4) != 0 ? 255 : 0);
            } else {
                iArr[i6] = f(255, (i6 & 1) != 0 ? 127 : 0, (i6 & 2) != 0 ? 127 : 0, (i6 & 4) == 0 ? 0 : 127);
            }
        }
        return iArr;
    }

    private static int[] e() {
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i6 = 0; i6 < 256; i6++) {
            if (i6 < 8) {
                iArr[i6] = f(63, (i6 & 1) != 0 ? 255 : 0, (i6 & 2) != 0 ? 255 : 0, (i6 & 4) == 0 ? 0 : 255);
            } else {
                int i7 = i6 & 136;
                if (i7 == 0) {
                    iArr[i6] = f(255, ((i6 & 1) != 0 ? 85 : 0) + ((i6 & 16) != 0 ? 170 : 0), ((i6 & 2) != 0 ? 85 : 0) + ((i6 & 32) != 0 ? 170 : 0), ((i6 & 4) == 0 ? 0 : 85) + ((i6 & 64) == 0 ? 0 : 170));
                } else if (i7 == 8) {
                    iArr[i6] = f(127, ((i6 & 1) != 0 ? 85 : 0) + ((i6 & 16) != 0 ? 170 : 0), ((i6 & 2) != 0 ? 85 : 0) + ((i6 & 32) != 0 ? 170 : 0), ((i6 & 4) == 0 ? 0 : 85) + ((i6 & 64) == 0 ? 0 : 170));
                } else if (i7 == 128) {
                    iArr[i6] = f(255, ((i6 & 1) != 0 ? 43 : 0) + 127 + ((i6 & 16) != 0 ? 85 : 0), ((i6 & 2) != 0 ? 43 : 0) + 127 + ((i6 & 32) != 0 ? 85 : 0), ((i6 & 4) == 0 ? 0 : 43) + 127 + ((i6 & 64) == 0 ? 0 : 85));
                } else if (i7 == 136) {
                    iArr[i6] = f(255, ((i6 & 1) != 0 ? 43 : 0) + ((i6 & 16) != 0 ? 85 : 0), ((i6 & 2) != 0 ? 43 : 0) + ((i6 & 32) != 0 ? 85 : 0), ((i6 & 4) == 0 ? 0 : 43) + ((i6 & 64) == 0 ? 0 : 85));
                }
            }
        }
        return iArr;
    }

    private static int f(int i6, int i7, int i8, int i9) {
        return (i6 << 24) | (i7 << 16) | (i8 << 8) | i9;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x007b A[LOOP:0: B:2:0x0009->B:13:0x007b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x007a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x005b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int g(i2.h0 r13, int[] r14, byte[] r15, int r16, int r17, android.graphics.Paint r18, android.graphics.Canvas r19) {
        /*
            r0 = r13
            r1 = r17
            r8 = r18
            r9 = 0
            r10 = r16
            r2 = 0
        L9:
            r3 = 2
            int r4 = r13.h(r3)
            r5 = 1
            if (r4 == 0) goto L14
            r11 = r2
        L12:
            r12 = 1
            goto L59
        L14:
            boolean r4 = r13.g()
            r6 = 3
            if (r4 == 0) goto L28
            int r4 = r13.h(r6)
            int r4 = r4 + r6
        L20:
            int r3 = r13.h(r3)
            r11 = r2
            r12 = r4
            r4 = r3
            goto L59
        L28:
            boolean r4 = r13.g()
            if (r4 == 0) goto L31
            r11 = r2
            r4 = 0
            goto L12
        L31:
            int r4 = r13.h(r3)
            if (r4 == 0) goto L56
            if (r4 == r5) goto L52
            if (r4 == r3) goto L4a
            if (r4 == r6) goto L41
            r11 = r2
            r4 = 0
        L3f:
            r12 = 0
            goto L59
        L41:
            r4 = 8
            int r4 = r13.h(r4)
            int r4 = r4 + 29
            goto L20
        L4a:
            r4 = 4
            int r4 = r13.h(r4)
            int r4 = r4 + 12
            goto L20
        L52:
            r11 = r2
            r4 = 0
            r12 = 2
            goto L59
        L56:
            r4 = 0
            r11 = 1
            goto L3f
        L59:
            if (r12 == 0) goto L77
            if (r8 == 0) goto L77
            if (r15 == 0) goto L61
            r4 = r15[r4]
        L61:
            r2 = r14[r4]
            r8.setColor(r2)
            float r3 = (float) r10
            float r4 = (float) r1
            int r2 = r10 + r12
            float r6 = (float) r2
            int r2 = r1 + 1
            float r7 = (float) r2
            r2 = r19
            r5 = r6
            r6 = r7
            r7 = r18
            r2.drawRect(r3, r4, r5, r6, r7)
        L77:
            int r10 = r10 + r12
            if (r11 == 0) goto L7b
            return r10
        L7b:
            r2 = r11
            goto L9
        */
        throw new UnsupportedOperationException("Method not decompiled: w1.b.g(i2.h0, int[], byte[], int, int, android.graphics.Paint, android.graphics.Canvas):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0087 A[LOOP:0: B:2:0x0009->B:13:0x0087, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0086 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int h(i2.h0 r13, int[] r14, byte[] r15, int r16, int r17, android.graphics.Paint r18, android.graphics.Canvas r19) {
        /*
            r0 = r13
            r1 = r17
            r8 = r18
            r9 = 0
            r10 = r16
            r2 = 0
        L9:
            r3 = 4
            int r4 = r13.h(r3)
            r5 = 1
            if (r4 == 0) goto L14
            r11 = r2
        L12:
            r12 = 1
            goto L65
        L14:
            boolean r4 = r13.g()
            r6 = 3
            if (r4 != 0) goto L2a
            int r3 = r13.h(r6)
            if (r3 == 0) goto L27
            int r3 = r3 + 2
            r11 = r2
            r12 = r3
            r4 = 0
            goto L65
        L27:
            r4 = 0
            r11 = 1
            goto L4c
        L2a:
            boolean r4 = r13.g()
            r7 = 2
            if (r4 != 0) goto L3e
            int r4 = r13.h(r7)
            int r4 = r4 + r3
        L36:
            int r3 = r13.h(r3)
            r11 = r2
            r12 = r4
            r4 = r3
            goto L65
        L3e:
            int r4 = r13.h(r7)
            if (r4 == 0) goto L62
            if (r4 == r5) goto L5e
            if (r4 == r7) goto L57
            if (r4 == r6) goto L4e
            r11 = r2
            r4 = 0
        L4c:
            r12 = 0
            goto L65
        L4e:
            r4 = 8
            int r4 = r13.h(r4)
            int r4 = r4 + 25
            goto L36
        L57:
            int r4 = r13.h(r3)
            int r4 = r4 + 9
            goto L36
        L5e:
            r11 = r2
            r4 = 0
            r12 = 2
            goto L65
        L62:
            r11 = r2
            r4 = 0
            goto L12
        L65:
            if (r12 == 0) goto L83
            if (r8 == 0) goto L83
            if (r15 == 0) goto L6d
            r4 = r15[r4]
        L6d:
            r2 = r14[r4]
            r8.setColor(r2)
            float r3 = (float) r10
            float r4 = (float) r1
            int r2 = r10 + r12
            float r6 = (float) r2
            int r2 = r1 + 1
            float r7 = (float) r2
            r2 = r19
            r5 = r6
            r6 = r7
            r7 = r18
            r2.drawRect(r3, r4, r5, r6, r7)
        L83:
            int r10 = r10 + r12
            if (r11 == 0) goto L87
            return r10
        L87:
            r2 = r11
            goto L9
        */
        throw new UnsupportedOperationException("Method not decompiled: w1.b.h(i2.h0, int[], byte[], int, int, android.graphics.Paint, android.graphics.Canvas):int");
    }

    private static int i(h0 h0Var, int[] iArr, byte[] bArr, int i6, int i7, Paint paint, Canvas canvas) {
        boolean z5;
        int h6;
        int i8 = i6;
        boolean z6 = false;
        while (true) {
            int h7 = h0Var.h(8);
            if (h7 != 0) {
                z5 = z6;
                h6 = 1;
            } else if (h0Var.g()) {
                z5 = z6;
                h6 = h0Var.h(7);
                h7 = h0Var.h(8);
            } else {
                int h8 = h0Var.h(7);
                if (h8 != 0) {
                    z5 = z6;
                    h6 = h8;
                    h7 = 0;
                } else {
                    h7 = 0;
                    z5 = true;
                    h6 = 0;
                }
            }
            if (h6 != 0 && paint != null) {
                if (bArr != null) {
                    h7 = bArr[h7];
                }
                paint.setColor(iArr[h7]);
                canvas.drawRect(i8, i7, i8 + h6, i7 + 1, paint);
            }
            i8 += h6;
            if (z5) {
                return i8;
            }
            z6 = z5;
        }
    }

    private static void j(byte[] bArr, int[] iArr, int i6, int i7, int i8, Paint paint, Canvas canvas) {
        byte[] bArr2;
        byte[] bArr3;
        byte[] bArr4;
        h0 h0Var = new h0(bArr);
        int i9 = i7;
        int i10 = i8;
        byte[] bArr5 = null;
        byte[] bArr6 = null;
        byte[] bArr7 = null;
        while (h0Var.b() != 0) {
            int h6 = h0Var.h(8);
            if (h6 != 240) {
                switch (h6) {
                    case 16:
                        if (i6 != 3) {
                            if (i6 != 2) {
                                bArr2 = null;
                                i9 = g(h0Var, iArr, bArr2, i9, i10, paint, canvas);
                                break;
                            } else {
                                bArr3 = bArr7 == null ? f10157h : bArr7;
                            }
                        } else {
                            bArr3 = bArr5 == null ? f10158i : bArr5;
                        }
                        bArr2 = bArr3;
                        i9 = g(h0Var, iArr, bArr2, i9, i10, paint, canvas);
                    case ab.b.API_TYPE_INDUSTRY /* 17 */:
                        if (i6 == 3) {
                            bArr4 = bArr6 == null ? f10159j : bArr6;
                        } else {
                            bArr4 = null;
                        }
                        i9 = h(h0Var, iArr, bArr4, i9, i10, paint, canvas);
                        break;
                    case 18:
                        i9 = i(h0Var, iArr, null, i9, i10, paint, canvas);
                        continue;
                    default:
                        switch (h6) {
                            case 32:
                                bArr7 = a(4, 4, h0Var);
                                break;
                            case 33:
                                bArr5 = a(4, 8, h0Var);
                                break;
                            case 34:
                                bArr6 = a(16, 8, h0Var);
                                break;
                            default:
                                continue;
                        }
                }
                h0Var.c();
            } else {
                i10 += 2;
                i9 = i7;
            }
        }
    }

    private static void k(c cVar, a aVar, int i6, int i7, int i8, Paint paint, Canvas canvas) {
        int[] iArr = i6 == 3 ? aVar.f10170d : i6 == 2 ? aVar.f10169c : aVar.f10168b;
        j(cVar.f10179c, iArr, i6, i7, i8, paint, canvas);
        j(cVar.f10180d, iArr, i6, i7, i8 + 1, paint, canvas);
    }

    private static a l(h0 h0Var, int i6) {
        int h6;
        int i7;
        int h7;
        int i8;
        int i9;
        int i10 = 8;
        int h8 = h0Var.h(8);
        h0Var.r(8);
        int i11 = 2;
        int i12 = i6 - 2;
        int[] c6 = c();
        int[] d6 = d();
        int[] e6 = e();
        while (i12 > 0) {
            int h9 = h0Var.h(i10);
            int h10 = h0Var.h(i10);
            int i13 = i12 - 2;
            int[] iArr = (h10 & 128) != 0 ? c6 : (h10 & 64) != 0 ? d6 : e6;
            if ((h10 & 1) != 0) {
                i8 = h0Var.h(i10);
                i9 = h0Var.h(i10);
                h6 = h0Var.h(i10);
                h7 = h0Var.h(i10);
                i7 = i13 - 4;
            } else {
                int h11 = h0Var.h(6) << i11;
                int h12 = h0Var.h(4) << 4;
                h6 = h0Var.h(4) << 4;
                i7 = i13 - 2;
                h7 = h0Var.h(i11) << 6;
                i8 = h11;
                i9 = h12;
            }
            if (i8 == 0) {
                i9 = 0;
                h6 = 0;
                h7 = 255;
            }
            double d7 = i8;
            double d8 = i9 - 128;
            double d9 = h6 - 128;
            iArr[h9] = f((byte) (255 - (h7 & 255)), c1.q((int) (d7 + (1.402d * d8)), 0, 255), c1.q((int) ((d7 - (0.34414d * d9)) - (d8 * 0.71414d)), 0, 255), c1.q((int) (d7 + (d9 * 1.772d)), 0, 255));
            i12 = i7;
            h8 = h8;
            i10 = 8;
            i11 = 2;
        }
        return new a(h8, c6, d6, e6);
    }

    private static C0156b m(h0 h0Var) {
        int i6;
        int i7;
        int i8;
        int i9;
        h0Var.r(4);
        boolean g6 = h0Var.g();
        h0Var.r(3);
        int h6 = h0Var.h(16);
        int h7 = h0Var.h(16);
        if (g6) {
            int h8 = h0Var.h(16);
            int h9 = h0Var.h(16);
            int h10 = h0Var.h(16);
            i7 = h0Var.h(16);
            i6 = h9;
            i9 = h10;
            i8 = h8;
        } else {
            i6 = h6;
            i7 = h7;
            i8 = 0;
            i9 = 0;
        }
        return new C0156b(h6, h7, i8, i6, i9, i7);
    }

    private static c n(h0 h0Var) {
        byte[] bArr;
        int h6 = h0Var.h(16);
        h0Var.r(4);
        int h7 = h0Var.h(2);
        boolean g6 = h0Var.g();
        h0Var.r(1);
        byte[] bArr2 = c1.f5553f;
        if (h7 == 1) {
            h0Var.r(h0Var.h(8) * 16);
        } else if (h7 == 0) {
            int h8 = h0Var.h(16);
            int h9 = h0Var.h(16);
            if (h8 > 0) {
                bArr2 = new byte[h8];
                h0Var.k(bArr2, 0, h8);
            }
            if (h9 > 0) {
                bArr = new byte[h9];
                h0Var.k(bArr, 0, h9);
                return new c(h6, g6, bArr2, bArr);
            }
        }
        bArr = bArr2;
        return new c(h6, g6, bArr2, bArr);
    }

    private static d o(h0 h0Var, int i6) {
        int h6 = h0Var.h(8);
        int h7 = h0Var.h(4);
        int h8 = h0Var.h(2);
        h0Var.r(2);
        int i7 = i6 - 2;
        SparseArray sparseArray = new SparseArray();
        while (i7 > 0) {
            int h9 = h0Var.h(8);
            h0Var.r(8);
            i7 -= 6;
            sparseArray.put(h9, new e(h0Var.h(16), h0Var.h(16)));
        }
        return new d(h6, h7, h8, sparseArray);
    }

    private static f p(h0 h0Var, int i6) {
        int h6;
        int h7;
        int h8 = h0Var.h(8);
        h0Var.r(4);
        boolean g6 = h0Var.g();
        h0Var.r(3);
        int i7 = 16;
        int h9 = h0Var.h(16);
        int h10 = h0Var.h(16);
        int h11 = h0Var.h(3);
        int h12 = h0Var.h(3);
        int i8 = 2;
        h0Var.r(2);
        int h13 = h0Var.h(8);
        int h14 = h0Var.h(8);
        int h15 = h0Var.h(4);
        int h16 = h0Var.h(2);
        h0Var.r(2);
        int i9 = i6 - 10;
        SparseArray sparseArray = new SparseArray();
        while (i9 > 0) {
            int h17 = h0Var.h(i7);
            int h18 = h0Var.h(i8);
            int h19 = h0Var.h(i8);
            int h20 = h0Var.h(12);
            int i10 = h16;
            h0Var.r(4);
            int h21 = h0Var.h(12);
            i9 -= 6;
            if (h18 == 1 || h18 == 2) {
                i9 -= 2;
                h6 = h0Var.h(8);
                h7 = h0Var.h(8);
            } else {
                h6 = 0;
                h7 = 0;
            }
            sparseArray.put(h17, new g(h18, h19, h20, h21, h6, h7));
            h16 = i10;
            i8 = 2;
            i7 = 16;
        }
        return new f(h8, g6, h9, h10, h11, h12, h13, h14, h15, h16, sparseArray);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void q(h0 h0Var, h hVar) {
        f fVar;
        SparseArray sparseArray;
        a aVar;
        int i6;
        a aVar2;
        c cVar;
        int h6 = h0Var.h(8);
        int h7 = h0Var.h(16);
        int h8 = h0Var.h(16);
        int d6 = h0Var.d() + h8;
        if (h8 * 8 > h0Var.b()) {
            t.i("DvbParser", "Data field length exceeds limit");
            h0Var.r(h0Var.b());
            return;
        }
        switch (h6) {
            case 16:
                if (h7 == hVar.f10204a) {
                    d dVar = hVar.f10212i;
                    d o6 = o(h0Var, h8);
                    if (o6.f10183c == 0) {
                        if (dVar != null && dVar.f10182b != o6.f10182b) {
                            hVar.f10212i = o6;
                            break;
                        }
                    } else {
                        hVar.f10212i = o6;
                        hVar.f10206c.clear();
                        hVar.f10207d.clear();
                        hVar.f10208e.clear();
                        break;
                    }
                }
                break;
            case ab.b.API_TYPE_INDUSTRY /* 17 */:
                d dVar2 = hVar.f10212i;
                if (h7 == hVar.f10204a && dVar2 != null) {
                    f p6 = p(h0Var, h8);
                    if (dVar2.f10183c == 0 && (fVar = hVar.f10206c.get(p6.f10187a)) != null) {
                        p6.a(fVar);
                    }
                    hVar.f10206c.put(p6.f10187a, p6);
                    break;
                }
                break;
            case 18:
                if (h7 == hVar.f10204a) {
                    a l6 = l(h0Var, h8);
                    sparseArray = hVar.f10207d;
                    aVar = l6;
                } else if (h7 == hVar.f10205b) {
                    a l7 = l(h0Var, h8);
                    sparseArray = hVar.f10209f;
                    aVar = l7;
                }
                i6 = aVar.f10167a;
                aVar2 = aVar;
                sparseArray.put(i6, aVar2);
                break;
            case 19:
                if (h7 == hVar.f10204a) {
                    c n6 = n(h0Var);
                    sparseArray = hVar.f10208e;
                    cVar = n6;
                } else if (h7 == hVar.f10205b) {
                    c n7 = n(h0Var);
                    sparseArray = hVar.f10210g;
                    cVar = n7;
                }
                i6 = cVar.f10177a;
                aVar2 = cVar;
                sparseArray.put(i6, aVar2);
                break;
            case 20:
                if (h7 == hVar.f10204a) {
                    hVar.f10211h = m(h0Var);
                    break;
                }
                break;
        }
        h0Var.s(d6 - h0Var.d());
    }

    public List<u1.b> b(byte[] bArr, int i6) {
        int i7;
        SparseArray<g> sparseArray;
        h0 h0Var = new h0(bArr, i6);
        while (h0Var.b() >= 48 && h0Var.h(8) == 15) {
            q(h0Var, this.f10165f);
        }
        h hVar = this.f10165f;
        d dVar = hVar.f10212i;
        if (dVar == null) {
            return Collections.emptyList();
        }
        C0156b c0156b = hVar.f10211h;
        if (c0156b == null) {
            c0156b = this.f10163d;
        }
        Bitmap bitmap = this.f10166g;
        if (bitmap == null || c0156b.f10171a + 1 != bitmap.getWidth() || c0156b.f10172b + 1 != this.f10166g.getHeight()) {
            Bitmap createBitmap = Bitmap.createBitmap(c0156b.f10171a + 1, c0156b.f10172b + 1, Bitmap.Config.ARGB_8888);
            this.f10166g = createBitmap;
            this.f10162c.setBitmap(createBitmap);
        }
        ArrayList arrayList = new ArrayList();
        SparseArray<e> sparseArray2 = dVar.f10184d;
        for (int i8 = 0; i8 < sparseArray2.size(); i8++) {
            this.f10162c.save();
            e valueAt = sparseArray2.valueAt(i8);
            f fVar = this.f10165f.f10206c.get(sparseArray2.keyAt(i8));
            int i9 = valueAt.f10185a + c0156b.f10173c;
            int i10 = valueAt.f10186b + c0156b.f10175e;
            this.f10162c.clipRect(i9, i10, Math.min(fVar.f10189c + i9, c0156b.f10174d), Math.min(fVar.f10190d + i10, c0156b.f10176f));
            a aVar = this.f10165f.f10207d.get(fVar.f10193g);
            if (aVar == null && (aVar = this.f10165f.f10209f.get(fVar.f10193g)) == null) {
                aVar = this.f10164e;
            }
            SparseArray<g> sparseArray3 = fVar.f10197k;
            int i11 = 0;
            while (i11 < sparseArray3.size()) {
                int keyAt = sparseArray3.keyAt(i11);
                g valueAt2 = sparseArray3.valueAt(i11);
                c cVar = this.f10165f.f10208e.get(keyAt);
                c cVar2 = cVar == null ? this.f10165f.f10210g.get(keyAt) : cVar;
                if (cVar2 != null) {
                    i7 = i11;
                    sparseArray = sparseArray3;
                    k(cVar2, aVar, fVar.f10192f, valueAt2.f10200c + i9, i10 + valueAt2.f10201d, cVar2.f10178b ? null : this.f10160a, this.f10162c);
                } else {
                    i7 = i11;
                    sparseArray = sparseArray3;
                }
                i11 = i7 + 1;
                sparseArray3 = sparseArray;
            }
            if (fVar.f10188b) {
                int i12 = fVar.f10192f;
                this.f10161b.setColor(i12 == 3 ? aVar.f10170d[fVar.f10194h] : i12 == 2 ? aVar.f10169c[fVar.f10195i] : aVar.f10168b[fVar.f10196j]);
                this.f10162c.drawRect(i9, i10, fVar.f10189c + i9, fVar.f10190d + i10, this.f10161b);
            }
            arrayList.add(new b.C0148b().f(Bitmap.createBitmap(this.f10166g, i9, i10, fVar.f10189c, fVar.f10190d)).k(i9 / c0156b.f10171a).l(0).h(i10 / c0156b.f10172b, 0).i(0).n(fVar.f10189c / c0156b.f10171a).g(fVar.f10190d / c0156b.f10172b).a());
            this.f10162c.drawColor(0, PorterDuff.Mode.CLEAR);
            this.f10162c.restore();
        }
        return Collections.unmodifiableList(arrayList);
    }

    public void r() {
        this.f10165f.a();
    }
}
