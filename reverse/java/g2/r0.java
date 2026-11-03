package g2;

import g2.r0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* loaded from: classes.dex */
public class r0 {

    /* renamed from: h, reason: collision with root package name */
    private static final Comparator<b> f4125h = new Comparator() { // from class: g2.p0
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int g6;
            g6 = r0.g((r0.b) obj, (r0.b) obj2);
            return g6;
        }
    };

    /* renamed from: i, reason: collision with root package name */
    private static final Comparator<b> f4126i = new Comparator() { // from class: g2.q0
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int h6;
            h6 = r0.h((r0.b) obj, (r0.b) obj2);
            return h6;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final int f4127a;

    /* renamed from: e, reason: collision with root package name */
    private int f4131e;

    /* renamed from: f, reason: collision with root package name */
    private int f4132f;

    /* renamed from: g, reason: collision with root package name */
    private int f4133g;

    /* renamed from: c, reason: collision with root package name */
    private final b[] f4129c = new b[5];

    /* renamed from: b, reason: collision with root package name */
    private final ArrayList<b> f4128b = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    private int f4130d = -1;

    /* JADX INFO: Access modifiers changed from: private */
    static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f4134a;

        /* renamed from: b, reason: collision with root package name */
        public int f4135b;

        /* renamed from: c, reason: collision with root package name */
        public float f4136c;

        private b() {
        }
    }

    public r0(int i6) {
        this.f4127a = i6;
    }

    private void d() {
        if (this.f4130d != 1) {
            Collections.sort(this.f4128b, f4125h);
            this.f4130d = 1;
        }
    }

    private void e() {
        if (this.f4130d != 0) {
            Collections.sort(this.f4128b, f4126i);
            this.f4130d = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int g(b bVar, b bVar2) {
        return bVar.f4134a - bVar2.f4134a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int h(b bVar, b bVar2) {
        return Float.compare(bVar.f4136c, bVar2.f4136c);
    }

    public void c(int i6, float f6) {
        b bVar;
        int i7;
        b bVar2;
        int i8;
        d();
        int i9 = this.f4133g;
        if (i9 > 0) {
            b[] bVarArr = this.f4129c;
            int i10 = i9 - 1;
            this.f4133g = i10;
            bVar = bVarArr[i10];
        } else {
            bVar = new b();
        }
        int i11 = this.f4131e;
        this.f4131e = i11 + 1;
        bVar.f4134a = i11;
        bVar.f4135b = i6;
        bVar.f4136c = f6;
        this.f4128b.add(bVar);
        int i12 = this.f4132f + i6;
        while (true) {
            this.f4132f = i12;
            while (true) {
                int i13 = this.f4132f;
                int i14 = this.f4127a;
                if (i13 <= i14) {
                    return;
                }
                i7 = i13 - i14;
                bVar2 = this.f4128b.get(0);
                i8 = bVar2.f4135b;
                if (i8 <= i7) {
                    this.f4132f -= i8;
                    this.f4128b.remove(0);
                    int i15 = this.f4133g;
                    if (i15 < 5) {
                        b[] bVarArr2 = this.f4129c;
                        this.f4133g = i15 + 1;
                        bVarArr2[i15] = bVar2;
                    }
                }
            }
            bVar2.f4135b = i8 - i7;
            i12 = this.f4132f - i7;
        }
    }

    public float f(float f6) {
        e();
        float f7 = f6 * this.f4132f;
        int i6 = 0;
        for (int i7 = 0; i7 < this.f4128b.size(); i7++) {
            b bVar = this.f4128b.get(i7);
            i6 += bVar.f4135b;
            if (i6 >= f7) {
                return bVar.f4136c;
            }
        }
        if (this.f4128b.isEmpty()) {
            return Float.NaN;
        }
        return this.f4128b.get(r5.size() - 1).f4136c;
    }

    public void i() {
        this.f4128b.clear();
        this.f4130d = -1;
        this.f4131e = 0;
        this.f4132f = 0;
    }
}
