package k2;

/* loaded from: classes.dex */
final class e {

    /* renamed from: a, reason: collision with root package name */
    public final a f6879a;

    /* renamed from: b, reason: collision with root package name */
    public final a f6880b;

    /* renamed from: c, reason: collision with root package name */
    public final int f6881c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f6882d;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final b[] f6883a;

        public a(b... bVarArr) {
            this.f6883a = bVarArr;
        }

        public b a(int i6) {
            return this.f6883a[i6];
        }

        public int b() {
            return this.f6883a.length;
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f6884a;

        /* renamed from: b, reason: collision with root package name */
        public final int f6885b;

        /* renamed from: c, reason: collision with root package name */
        public final float[] f6886c;

        /* renamed from: d, reason: collision with root package name */
        public final float[] f6887d;

        public b(int i6, float[] fArr, float[] fArr2, int i7) {
            this.f6884a = i6;
            i2.a.a(((long) fArr.length) * 2 == ((long) fArr2.length) * 3);
            this.f6886c = fArr;
            this.f6887d = fArr2;
            this.f6885b = i7;
        }

        public int a() {
            return this.f6886c.length / 3;
        }
    }

    public e(a aVar, int i6) {
        this(aVar, aVar, i6);
    }

    public e(a aVar, a aVar2, int i6) {
        this.f6879a = aVar;
        this.f6880b = aVar2;
        this.f6881c = i6;
        this.f6882d = aVar == aVar2;
    }

    public static e a(float f6, int i6, int i7, float f7, float f8, int i8) {
        int i9;
        float f9;
        int i10;
        int i11;
        int i12;
        float[] fArr;
        int i13 = i6;
        int i14 = i7;
        i2.a.a(f6 > 0.0f);
        i2.a.a(i13 >= 1);
        i2.a.a(i14 >= 1);
        i2.a.a(f7 > 0.0f && f7 <= 180.0f);
        i2.a.a(f8 > 0.0f && f8 <= 360.0f);
        float radians = (float) Math.toRadians(f7);
        float radians2 = (float) Math.toRadians(f8);
        float f10 = radians / i13;
        float f11 = radians2 / i14;
        int i15 = i14 + 1;
        int i16 = ((i15 * 2) + 2) * i13;
        float[] fArr2 = new float[i16 * 3];
        float[] fArr3 = new float[i16 * 2];
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        while (i17 < i13) {
            float f12 = radians / 2.0f;
            float f13 = (i17 * f10) - f12;
            int i20 = i17 + 1;
            float f14 = (i20 * f10) - f12;
            int i21 = 0;
            while (i21 < i15) {
                float f15 = f13;
                int i22 = i20;
                int i23 = 0;
                int i24 = 2;
                while (i23 < i24) {
                    if (i23 == 0) {
                        f9 = f15;
                        i9 = i15;
                    } else {
                        i9 = i15;
                        f9 = f14;
                    }
                    float f16 = i21 * f11;
                    float f17 = f11;
                    int i25 = i18 + 1;
                    int i26 = i21;
                    double d6 = f6;
                    float f18 = f10;
                    double d7 = (f16 + 3.1415927f) - (radians2 / 2.0f);
                    int i27 = i23;
                    double d8 = f9;
                    float[] fArr4 = fArr3;
                    float f19 = f14;
                    fArr2[i18] = -((float) (Math.sin(d7) * d6 * Math.cos(d8)));
                    int i28 = i25 + 1;
                    int i29 = i17;
                    fArr2[i25] = (float) (d6 * Math.sin(d8));
                    int i30 = i28 + 1;
                    fArr2[i28] = (float) (d6 * Math.cos(d7) * Math.cos(d8));
                    int i31 = i19 + 1;
                    fArr4[i19] = f16 / radians2;
                    int i32 = i31 + 1;
                    fArr4[i31] = ((i29 + i27) * f18) / radians;
                    if (i26 == 0 && i27 == 0) {
                        i10 = i7;
                        i11 = i26;
                        i12 = i27;
                    } else {
                        i10 = i7;
                        i11 = i26;
                        i12 = i27;
                        if (i11 != i10 || i12 != 1) {
                            fArr = fArr4;
                            i19 = i32;
                            i18 = i30;
                            int i33 = i12 + 1;
                            fArr3 = fArr;
                            i17 = i29;
                            i15 = i9;
                            f11 = f17;
                            f10 = f18;
                            f14 = f19;
                            i24 = 2;
                            i14 = i10;
                            i21 = i11;
                            i23 = i33;
                        }
                    }
                    System.arraycopy(fArr2, i30 - 3, fArr2, i30, 3);
                    i30 += 3;
                    fArr = fArr4;
                    System.arraycopy(fArr, i32 - 2, fArr, i32, 2);
                    i32 += 2;
                    i19 = i32;
                    i18 = i30;
                    int i332 = i12 + 1;
                    fArr3 = fArr;
                    i17 = i29;
                    i15 = i9;
                    f11 = f17;
                    f10 = f18;
                    f14 = f19;
                    i24 = 2;
                    i14 = i10;
                    i21 = i11;
                    i23 = i332;
                }
                int i34 = i21;
                int i35 = i14;
                int i36 = i34 + 1;
                f13 = f15;
                i20 = i22;
                i15 = i15;
                f11 = f11;
                f14 = f14;
                i14 = i35;
                i21 = i36;
            }
            i13 = i6;
            i17 = i20;
        }
        return new e(new a(new b(0, fArr2, fArr3, 1)), i8);
    }

    public static e b(int i6) {
        return a(50.0f, 36, 72, 180.0f, 360.0f, i6);
    }
}
