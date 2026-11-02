package w0;

import b1.a;
import h0.g3;
import h1.c;
import i2.i0;
import java.util.ArrayList;
import java.util.List;
import o0.a0;

/* loaded from: classes.dex */
final class m {

    /* renamed from: d, reason: collision with root package name */
    private static final l2.n f10105d = l2.n.d(':');

    /* renamed from: e, reason: collision with root package name */
    private static final l2.n f10106e = l2.n.d('*');

    /* renamed from: a, reason: collision with root package name */
    private final List<a> f10107a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private int f10108b = 0;

    /* renamed from: c, reason: collision with root package name */
    private int f10109c;

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f10110a;

        /* renamed from: b, reason: collision with root package name */
        public final long f10111b;

        /* renamed from: c, reason: collision with root package name */
        public final int f10112c;

        public a(int i6, long j6, int i7) {
            this.f10110a = i6;
            this.f10111b = j6;
            this.f10112c = i7;
        }
    }

    private void a(o0.m mVar, a0 a0Var) {
        i0 i0Var = new i0(8);
        mVar.readFully(i0Var.e(), 0, 8);
        this.f10109c = i0Var.s() + 8;
        if (i0Var.o() != 1397048916) {
            a0Var.f8326a = 0L;
        } else {
            a0Var.f8326a = mVar.getPosition() - (this.f10109c - 12);
            this.f10108b = 2;
        }
    }

    private static int b(String str) {
        str.hashCode();
        switch (str) {
            case "SlowMotion_Data":
                return 2192;
            case "Super_SlowMotion_Edit_Data":
                return 2819;
            case "Super_SlowMotion_Data":
                return 2816;
            case "Super_SlowMotion_Deflickering_On":
                return 2820;
            case "Super_SlowMotion_BGM":
                return 2817;
            default:
                throw g3.a("Invalid SEF name", null);
        }
    }

    private void d(o0.m mVar, a0 a0Var) {
        long j6;
        long length = mVar.getLength();
        int i6 = (this.f10109c - 12) - 8;
        i0 i0Var = new i0(i6);
        mVar.readFully(i0Var.e(), 0, i6);
        for (int i7 = 0; i7 < i6 / 12; i7++) {
            i0Var.T(2);
            short u5 = i0Var.u();
            if (u5 == 2192 || u5 == 2816 || u5 == 2817 || u5 == 2819 || u5 == 2820) {
                this.f10107a.add(new a(u5, (length - this.f10109c) - i0Var.s(), i0Var.s()));
            } else {
                i0Var.T(8);
            }
        }
        if (this.f10107a.isEmpty()) {
            j6 = 0;
        } else {
            this.f10108b = 3;
            j6 = this.f10107a.get(0).f10111b;
        }
        a0Var.f8326a = j6;
    }

    private void e(o0.m mVar, List<a.b> list) {
        long position = mVar.getPosition();
        int length = (int) ((mVar.getLength() - mVar.getPosition()) - this.f10109c);
        i0 i0Var = new i0(length);
        mVar.readFully(i0Var.e(), 0, length);
        for (int i6 = 0; i6 < this.f10107a.size(); i6++) {
            a aVar = this.f10107a.get(i6);
            i0Var.S((int) (aVar.f10111b - position));
            i0Var.T(4);
            int s5 = i0Var.s();
            int b6 = b(i0Var.C(s5));
            int i7 = aVar.f10112c - (s5 + 8);
            if (b6 == 2192) {
                list.add(f(i0Var, i7));
            } else if (b6 != 2816 && b6 != 2817 && b6 != 2819 && b6 != 2820) {
                throw new IllegalStateException();
            }
        }
    }

    private static h1.c f(i0 i0Var, int i6) {
        ArrayList arrayList = new ArrayList();
        List<String> f6 = f10106e.f(i0Var.C(i6));
        for (int i7 = 0; i7 < f6.size(); i7++) {
            List<String> f7 = f10105d.f(f6.get(i7));
            if (f7.size() != 3) {
                throw g3.a(null, null);
            }
            try {
                arrayList.add(new c.b(Long.parseLong(f7.get(0)), Long.parseLong(f7.get(1)), 1 << (Integer.parseInt(f7.get(2)) - 1)));
            } catch (NumberFormatException e6) {
                throw g3.a(null, e6);
            }
        }
        return new h1.c(arrayList);
    }

    public int c(o0.m mVar, a0 a0Var, List<a.b> list) {
        int i6 = this.f10108b;
        long j6 = 0;
        if (i6 == 0) {
            long length = mVar.getLength();
            if (length != -1 && length >= 8) {
                j6 = length - 8;
            }
            a0Var.f8326a = j6;
            this.f10108b = 1;
        } else if (i6 == 1) {
            a(mVar, a0Var);
        } else if (i6 == 2) {
            d(mVar, a0Var);
        } else {
            if (i6 != 3) {
                throw new IllegalStateException();
            }
            e(mVar, list);
            a0Var.f8326a = 0L;
        }
        return 1;
    }

    public void g() {
        this.f10107a.clear();
        this.f10108b = 0;
    }
}
