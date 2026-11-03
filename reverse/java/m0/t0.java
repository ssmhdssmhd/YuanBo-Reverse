package m0;

import android.net.Uri;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class t0 extends IOException {

    /* renamed from: a, reason: collision with root package name */
    public final g2.q f7879a;

    /* renamed from: b, reason: collision with root package name */
    public final Uri f7880b;

    /* renamed from: c, reason: collision with root package name */
    public final Map<String, List<String>> f7881c;

    /* renamed from: d, reason: collision with root package name */
    public final long f7882d;

    public t0(g2.q qVar, Uri uri, Map<String, List<String>> map, long j6, Throwable th) {
        super(th);
        this.f7879a = qVar;
        this.f7880b = uri;
        this.f7881c = map;
        this.f7882d = j6;
    }
}
