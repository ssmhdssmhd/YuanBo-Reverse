package q1;

import android.net.Uri;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
final class e {

    /* renamed from: a, reason: collision with root package name */
    private final LinkedHashMap<Uri, byte[]> f8721a;

    class a extends LinkedHashMap<Uri, byte[]> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f8722a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(e eVar, int i6, float f6, boolean z5, int i7) {
            super(i6, f6, z5);
            this.f8722a = i7;
        }

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<Uri, byte[]> entry) {
            return size() > this.f8722a;
        }
    }

    public e(int i6) {
        this.f8721a = new a(this, i6 + 1, 1.0f, false, i6);
    }

    public byte[] a(Uri uri) {
        if (uri == null) {
            return null;
        }
        return this.f8721a.get(uri);
    }

    public byte[] b(Uri uri, byte[] bArr) {
        return this.f8721a.put((Uri) i2.a.e(uri), (byte[]) i2.a.e(bArr));
    }

    public byte[] c(Uri uri) {
        return this.f8721a.remove(i2.a.e(uri));
    }
}
