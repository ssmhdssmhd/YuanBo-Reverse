package i1;

import b1.a;
import h0.m2;
import h0.y1;

/* loaded from: classes.dex */
public abstract class b implements a.b {
    @Override // b1.a.b
    public /* synthetic */ void a(m2.b bVar) {
        b1.b.c(this, bVar);
    }

    @Override // b1.a.b
    public /* synthetic */ y1 b() {
        return b1.b.b(this);
    }

    @Override // b1.a.b
    public /* synthetic */ byte[] c() {
        return b1.b.a(this);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "SCTE-35 splice command: type=" + getClass().getSimpleName();
    }
}
