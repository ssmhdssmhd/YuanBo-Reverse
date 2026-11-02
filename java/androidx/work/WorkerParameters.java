package androidx.work;

import android.net.Network;
import android.net.Uri;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;
import v.f;
import v.o;
import v.v;

/* loaded from: classes.dex */
public final class WorkerParameters {

    /* renamed from: a, reason: collision with root package name */
    private UUID f1475a;

    /* renamed from: b, reason: collision with root package name */
    private b f1476b;

    /* renamed from: c, reason: collision with root package name */
    private Set<String> f1477c;

    /* renamed from: d, reason: collision with root package name */
    private a f1478d;

    /* renamed from: e, reason: collision with root package name */
    private int f1479e;

    /* renamed from: f, reason: collision with root package name */
    private Executor f1480f;

    /* renamed from: g, reason: collision with root package name */
    private f0.a f1481g;

    /* renamed from: h, reason: collision with root package name */
    private v f1482h;

    /* renamed from: i, reason: collision with root package name */
    private o f1483i;

    /* renamed from: j, reason: collision with root package name */
    private f f1484j;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public List<String> f1485a = Collections.emptyList();

        /* renamed from: b, reason: collision with root package name */
        public List<Uri> f1486b = Collections.emptyList();

        /* renamed from: c, reason: collision with root package name */
        public Network f1487c;
    }

    public WorkerParameters(UUID uuid, b bVar, Collection<String> collection, a aVar, int i6, Executor executor, f0.a aVar2, v vVar, o oVar, f fVar) {
        this.f1475a = uuid;
        this.f1476b = bVar;
        this.f1477c = new HashSet(collection);
        this.f1478d = aVar;
        this.f1479e = i6;
        this.f1480f = executor;
        this.f1481g = aVar2;
        this.f1482h = vVar;
        this.f1483i = oVar;
        this.f1484j = fVar;
    }

    public Executor a() {
        return this.f1480f;
    }

    public f b() {
        return this.f1484j;
    }

    public UUID c() {
        return this.f1475a;
    }

    public b d() {
        return this.f1476b;
    }

    public v e() {
        return this.f1482h;
    }
}
