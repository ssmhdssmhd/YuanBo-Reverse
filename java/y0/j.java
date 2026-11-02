package y0;

import android.util.SparseArray;
import com.tendcloud.tenddata.ab;
import h0.y1;
import java.util.ArrayList;
import java.util.List;
import y0.i0;

/* loaded from: classes.dex */
public final class j implements i0.c {

    /* renamed from: a, reason: collision with root package name */
    private final int f10819a;

    /* renamed from: b, reason: collision with root package name */
    private final List<y1> f10820b;

    public j(int i6) {
        this(i6, m2.q.q());
    }

    public j(int i6, List<y1> list) {
        this.f10819a = i6;
        this.f10820b = list;
    }

    private d0 c(i0.b bVar) {
        return new d0(e(bVar));
    }

    private k0 d(i0.b bVar) {
        return new k0(e(bVar));
    }

    private List<y1> e(i0.b bVar) {
        String str;
        int i6;
        if (f(32)) {
            return this.f10820b;
        }
        i2.i0 i0Var = new i2.i0(bVar.f10813d);
        List<y1> list = this.f10820b;
        while (i0Var.a() > 0) {
            int F = i0Var.F();
            int f6 = i0Var.f() + i0Var.F();
            if (F == 134) {
                list = new ArrayList<>();
                int F2 = i0Var.F() & 31;
                for (int i7 = 0; i7 < F2; i7++) {
                    String C = i0Var.C(3);
                    int F3 = i0Var.F();
                    boolean z5 = (F3 & 128) != 0;
                    if (z5) {
                        i6 = F3 & 63;
                        str = "application/cea-708";
                    } else {
                        str = "application/cea-608";
                        i6 = 1;
                    }
                    byte F4 = (byte) i0Var.F();
                    i0Var.T(1);
                    list.add(new y1.b().g0(str).X(C).H(i6).V(z5 ? i2.f.b((F4 & 64) != 0) : null).G());
                }
            }
            i0Var.S(f6);
        }
        return list;
    }

    private boolean f(int i6) {
        return (i6 & this.f10819a) != 0;
    }

    @Override // y0.i0.c
    public SparseArray<i0> a() {
        return new SparseArray<>();
    }

    @Override // y0.i0.c
    public i0 b(int i6, i0.b bVar) {
        if (i6 != 2) {
            if (i6 == 3 || i6 == 4) {
                return new w(new t(bVar.f10811b));
            }
            if (i6 == 21) {
                return new w(new r());
            }
            if (i6 == 27) {
                if (f(4)) {
                    return null;
                }
                return new w(new p(c(bVar), f(1), f(8)));
            }
            if (i6 == 36) {
                return new w(new q(c(bVar)));
            }
            if (i6 == 89) {
                return new w(new l(bVar.f10812c));
            }
            if (i6 != 138) {
                if (i6 == 172) {
                    return new w(new f(bVar.f10811b));
                }
                if (i6 == 257) {
                    return new c0(new v("application/vnd.dvb.ait"));
                }
                if (i6 == 134) {
                    if (f(16)) {
                        return null;
                    }
                    return new c0(new v("application/x-scte35"));
                }
                if (i6 != 135) {
                    switch (i6) {
                        case 15:
                            if (!f(2)) {
                                break;
                            }
                            break;
                        case 16:
                            break;
                        case ab.b.API_TYPE_INDUSTRY /* 17 */:
                            if (!f(2)) {
                                break;
                            }
                            break;
                        default:
                            switch (i6) {
                                case 130:
                                    if (!f(64)) {
                                    }
                                    break;
                            }
                    }
                    return null;
                }
                return new w(new c(bVar.f10811b));
            }
            return new w(new k(bVar.f10811b));
        }
        return new w(new n(d(bVar)));
    }
}
