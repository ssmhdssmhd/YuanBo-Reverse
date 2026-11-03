package v;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    private UUID f9728a;

    /* renamed from: b, reason: collision with root package name */
    private a f9729b;

    /* renamed from: c, reason: collision with root package name */
    private androidx.work.b f9730c;

    /* renamed from: d, reason: collision with root package name */
    private Set<String> f9731d;

    /* renamed from: e, reason: collision with root package name */
    private androidx.work.b f9732e;

    /* renamed from: f, reason: collision with root package name */
    private int f9733f;

    public enum a {
        ENQUEUED,
        RUNNING,
        SUCCEEDED,
        FAILED,
        BLOCKED,
        CANCELLED;

        public boolean a() {
            return this == SUCCEEDED || this == FAILED || this == CANCELLED;
        }
    }

    public s(UUID uuid, a aVar, androidx.work.b bVar, List<String> list, androidx.work.b bVar2, int i6) {
        this.f9728a = uuid;
        this.f9729b = aVar;
        this.f9730c = bVar;
        this.f9731d = new HashSet(list);
        this.f9732e = bVar2;
        this.f9733f = i6;
    }

    public androidx.work.b a() {
        return this.f9730c;
    }

    public a b() {
        return this.f9729b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || s.class != obj.getClass()) {
            return false;
        }
        s sVar = (s) obj;
        if (this.f9733f == sVar.f9733f && this.f9728a.equals(sVar.f9728a) && this.f9729b == sVar.f9729b && this.f9730c.equals(sVar.f9730c) && this.f9731d.equals(sVar.f9731d)) {
            return this.f9732e.equals(sVar.f9732e);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.f9728a.hashCode() * 31) + this.f9729b.hashCode()) * 31) + this.f9730c.hashCode()) * 31) + this.f9731d.hashCode()) * 31) + this.f9732e.hashCode()) * 31) + this.f9733f;
    }

    public String toString() {
        return "WorkInfo{mId='" + this.f9728a + "', mState=" + this.f9729b + ", mOutputData=" + this.f9730c + ", mTags=" + this.f9731d + ", mProgress=" + this.f9732e + '}';
    }
}
