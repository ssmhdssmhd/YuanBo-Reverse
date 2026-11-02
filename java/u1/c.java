package u1;

import android.os.Bundle;
import android.os.Parcel;
import java.util.ArrayList;
import m2.q;

/* loaded from: classes.dex */
public final class c {
    public q<b> a(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        Bundle readBundle = obtain.readBundle(Bundle.class.getClassLoader());
        obtain.recycle();
        return i2.d.b(b.N, (ArrayList) i2.a.e(readBundle.getParcelableArrayList("c")));
    }
}
