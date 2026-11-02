package v;

import android.os.Build;
import androidx.work.ListenableWorker;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/* loaded from: classes.dex */
public abstract class u {

    /* renamed from: a, reason: collision with root package name */
    private UUID f9741a;

    /* renamed from: b, reason: collision with root package name */
    private d0.p f9742b;

    /* renamed from: c, reason: collision with root package name */
    private Set<String> f9743c;

    public static abstract class a<B extends a<?, ?>, W extends u> {

        /* renamed from: c, reason: collision with root package name */
        d0.p f9746c;

        /* renamed from: e, reason: collision with root package name */
        Class<? extends ListenableWorker> f9748e;

        /* renamed from: a, reason: collision with root package name */
        boolean f9744a = false;

        /* renamed from: d, reason: collision with root package name */
        Set<String> f9747d = new HashSet();

        /* renamed from: b, reason: collision with root package name */
        UUID f9745b = UUID.randomUUID();

        a(Class<? extends ListenableWorker> cls) {
            this.f9748e = cls;
            this.f9746c = new d0.p(this.f9745b.toString(), cls.getName());
            a(cls.getName());
        }

        public final B a(String str) {
            this.f9747d.add(str);
            return d();
        }

        public final W b() {
            W c6 = c();
            b bVar = this.f9746c.f2867j;
            int i6 = Build.VERSION.SDK_INT;
            boolean z5 = (i6 >= 24 && bVar.e()) || bVar.f() || bVar.g() || (i6 >= 23 && bVar.h());
            d0.p pVar = this.f9746c;
            if (pVar.f2874q) {
                if (z5) {
                    throw new IllegalArgumentException("Expedited jobs only support network and storage constraints");
                }
                if (pVar.f2864g > 0) {
                    throw new IllegalArgumentException("Expedited jobs cannot be delayed");
                }
            }
            this.f9745b = UUID.randomUUID();
            d0.p pVar2 = new d0.p(this.f9746c);
            this.f9746c = pVar2;
            pVar2.f2858a = this.f9745b.toString();
            return c6;
        }

        abstract W c();

        abstract B d();

        public final B e(androidx.work.b bVar) {
            this.f9746c.f2862e = bVar;
            return d();
        }
    }

    protected u(UUID uuid, d0.p pVar, Set<String> set) {
        this.f9741a = uuid;
        this.f9742b = pVar;
        this.f9743c = set;
    }

    public UUID a() {
        return this.f9741a;
    }

    public String b() {
        return this.f9741a.toString();
    }

    public Set<String> c() {
        return this.f9743c;
    }

    public d0.p d() {
        return this.f9742b;
    }
}
