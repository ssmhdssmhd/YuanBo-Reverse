package d2;

import android.text.TextUtils;
import h0.g3;
import i2.i0;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class h extends u1.g {

    /* renamed from: o, reason: collision with root package name */
    private final i0 f2974o;

    /* renamed from: p, reason: collision with root package name */
    private final c f2975p;

    public h() {
        super("WebvttDecoder");
        this.f2974o = new i0();
        this.f2975p = new c();
    }

    private static int C(i0 i0Var) {
        int i6 = -1;
        int i7 = 0;
        while (i6 == -1) {
            i7 = i0Var.f();
            String q6 = i0Var.q();
            i6 = q6 == null ? 0 : "STYLE".equals(q6) ? 2 : q6.startsWith("NOTE") ? 1 : 3;
        }
        i0Var.S(i7);
        return i6;
    }

    private static void D(i0 i0Var) {
        while (!TextUtils.isEmpty(i0Var.q())) {
        }
    }

    @Override // u1.g
    protected u1.h A(byte[] bArr, int i6, boolean z5) {
        e m6;
        this.f2974o.Q(bArr, i6);
        ArrayList arrayList = new ArrayList();
        try {
            i.e(this.f2974o);
            while (!TextUtils.isEmpty(this.f2974o.q())) {
            }
            ArrayList arrayList2 = new ArrayList();
            while (true) {
                int C = C(this.f2974o);
                if (C == 0) {
                    return new k(arrayList2);
                }
                if (C == 1) {
                    D(this.f2974o);
                } else if (C == 2) {
                    if (!arrayList2.isEmpty()) {
                        throw new u1.j("A style block was found after the first cue.");
                    }
                    this.f2974o.q();
                    arrayList.addAll(this.f2975p.d(this.f2974o));
                } else if (C == 3 && (m6 = f.m(this.f2974o, arrayList)) != null) {
                    arrayList2.add(m6);
                }
            }
        } catch (g3 e6) {
            throw new u1.j(e6);
        }
    }
}
