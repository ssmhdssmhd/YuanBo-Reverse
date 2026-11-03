package r1;

import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public abstract class i implements k1.a<i> {

    /* renamed from: a, reason: collision with root package name */
    public final String f9140a;

    /* renamed from: b, reason: collision with root package name */
    public final List<String> f9141b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f9142c;

    protected i(String str, List<String> list, boolean z5) {
        this.f9140a = str;
        this.f9141b = Collections.unmodifiableList(list);
        this.f9142c = z5;
    }
}
