package d2;

import i2.c1;
import i2.i0;
import java.util.ArrayList;
import java.util.Collections;
import u1.b;

/* loaded from: classes.dex */
public final class a extends u1.g {

    /* renamed from: o, reason: collision with root package name */
    private final i0 f2924o;

    public a() {
        super("Mp4WebvttDecoder");
        this.f2924o = new i0();
    }

    private static u1.b C(i0 i0Var, int i6) {
        CharSequence charSequence = null;
        b.C0148b c0148b = null;
        while (i6 > 0) {
            if (i6 < 8) {
                throw new u1.j("Incomplete vtt cue box header found.");
            }
            int o6 = i0Var.o();
            int o7 = i0Var.o();
            int i7 = o6 - 8;
            String E = c1.E(i0Var.e(), i0Var.f(), i7);
            i0Var.T(i7);
            i6 = (i6 - 8) - i7;
            if (o7 == 1937011815) {
                c0148b = f.o(E);
            } else if (o7 == 1885436268) {
                charSequence = f.q(null, E.trim(), Collections.emptyList());
            }
        }
        if (charSequence == null) {
            charSequence = "";
        }
        return c0148b != null ? c0148b.o(charSequence).a() : f.l(charSequence);
    }

    @Override // u1.g
    protected u1.h A(byte[] bArr, int i6, boolean z5) {
        this.f2924o.Q(bArr, i6);
        ArrayList arrayList = new ArrayList();
        while (this.f2924o.a() > 0) {
            if (this.f2924o.a() < 8) {
                throw new u1.j("Incomplete Mp4Webvtt Top Level box header found.");
            }
            int o6 = this.f2924o.o();
            if (this.f2924o.o() == 1987343459) {
                arrayList.add(C(this.f2924o, o6 - 8));
            } else {
                this.f2924o.T(o6 - 8);
            }
        }
        return new b(arrayList);
    }
}
