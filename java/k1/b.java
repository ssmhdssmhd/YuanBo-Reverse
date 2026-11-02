package k1;

import android.net.Uri;
import g2.k0;
import java.io.InputStream;
import java.util.List;
import k1.a;

/* loaded from: classes.dex */
public final class b<T extends a<T>> implements k0.a<T> {

    /* renamed from: a, reason: collision with root package name */
    private final k0.a<? extends T> f6857a;

    /* renamed from: b, reason: collision with root package name */
    private final List<c> f6858b;

    public b(k0.a<? extends T> aVar, List<c> list) {
        this.f6857a = aVar;
        this.f6858b = list;
    }

    @Override // g2.k0.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public T a(Uri uri, InputStream inputStream) {
        T a6 = this.f6857a.a(uri, inputStream);
        List<c> list = this.f6858b;
        return (list == null || list.isEmpty()) ? a6 : (T) a6.a(this.f6858b);
    }
}
