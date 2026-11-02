package h0;

import android.os.Bundle;
import h0.o;

/* loaded from: classes.dex */
public abstract class v3 implements o {

    /* renamed from: a, reason: collision with root package name */
    static final String f4979a = i2.c1.s0(0);

    /* renamed from: b, reason: collision with root package name */
    public static final o.a<v3> f4980b = new o.a() { // from class: h0.u3
        @Override // h0.o.a
        public final o a(Bundle bundle) {
            v3 b6;
            b6 = v3.b(bundle);
            return b6;
        }
    };

    v3() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static v3 b(Bundle bundle) {
        o.a aVar;
        int i6 = bundle.getInt(f4979a, -1);
        if (i6 == 0) {
            aVar = c2.f4284k;
        } else if (i6 == 1) {
            aVar = i3.f4526e;
        } else if (i6 == 2) {
            aVar = e4.f4313k;
        } else {
            if (i6 != 3) {
                throw new IllegalArgumentException("Unknown RatingType: " + i6);
            }
            aVar = k4.f4555k;
        }
        return (v3) aVar.a(bundle);
    }
}
