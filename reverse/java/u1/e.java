package u1;

import android.os.Bundle;
import h0.o;
import i2.c1;
import java.util.ArrayList;
import java.util.List;
import m2.q;

/* loaded from: classes.dex */
public final class e implements h0.o {

    /* renamed from: c, reason: collision with root package name */
    public static final e f9638c = new e(q.q(), 0);

    /* renamed from: d, reason: collision with root package name */
    private static final String f9639d = c1.s0(0);

    /* renamed from: e, reason: collision with root package name */
    private static final String f9640e = c1.s0(1);

    /* renamed from: j, reason: collision with root package name */
    public static final o.a<e> f9641j = new o.a() { // from class: u1.d
        @Override // h0.o.a
        public final h0.o a(Bundle bundle) {
            e b6;
            b6 = e.b(bundle);
            return b6;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final q<b> f9642a;

    /* renamed from: b, reason: collision with root package name */
    public final long f9643b;

    public e(List<b> list, long j6) {
        this.f9642a = q.m(list);
        this.f9643b = j6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final e b(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(f9639d);
        return new e(parcelableArrayList == null ? q.q() : i2.d.b(b.N, parcelableArrayList), bundle.getLong(f9640e));
    }
}
