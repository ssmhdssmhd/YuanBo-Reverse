package o0;

import android.net.Uri;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public interface r {

    /* renamed from: a, reason: collision with root package name */
    public static final r f8412a = new r() { // from class: o0.p
        @Override // o0.r
        public final l[] a() {
            return q.b();
        }

        @Override // o0.r
        public /* synthetic */ l[] b(Uri uri, Map map) {
            return q.a(this, uri, map);
        }
    };

    l[] a();

    l[] b(Uri uri, Map<String, List<String>> map);
}
