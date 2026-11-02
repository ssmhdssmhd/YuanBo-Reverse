package g2;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class d0 extends b0 {

    /* renamed from: d, reason: collision with root package name */
    public final int f4012d;

    /* renamed from: e, reason: collision with root package name */
    public final String f4013e;

    /* renamed from: j, reason: collision with root package name */
    public final Map<String, List<String>> f4014j;

    /* renamed from: k, reason: collision with root package name */
    public final byte[] f4015k;

    public d0(int i6, String str, IOException iOException, Map<String, List<String>> map, q qVar, byte[] bArr) {
        super("Response code: " + i6, iOException, qVar, 2004, 1);
        this.f4012d = i6;
        this.f4013e = str;
        this.f4014j = map;
        this.f4015k = bArr;
    }
}
