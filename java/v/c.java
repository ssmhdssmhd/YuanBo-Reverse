package v;

import android.net.Uri;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final Set<a> f9699a = new HashSet();

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final Uri f9700a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f9701b;

        a(Uri uri, boolean z5) {
            this.f9700a = uri;
            this.f9701b = z5;
        }

        public Uri a() {
            return this.f9700a;
        }

        public boolean b() {
            return this.f9701b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f9701b == aVar.f9701b && this.f9700a.equals(aVar.f9700a);
        }

        public int hashCode() {
            return (this.f9700a.hashCode() * 31) + (this.f9701b ? 1 : 0);
        }
    }

    public void a(Uri uri, boolean z5) {
        this.f9699a.add(new a(uri, z5));
    }

    public Set<a> b() {
        return this.f9699a;
    }

    public int c() {
        return this.f9699a.size();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        return this.f9699a.equals(((c) obj).f9699a);
    }

    public int hashCode() {
        return this.f9699a.hashCode();
    }
}
