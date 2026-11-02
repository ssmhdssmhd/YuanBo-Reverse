package p1;

import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final int f8535a;

    /* renamed from: b, reason: collision with root package name */
    public final int f8536b;

    /* renamed from: c, reason: collision with root package name */
    public final List<j> f8537c;

    /* renamed from: d, reason: collision with root package name */
    public final List<e> f8538d;

    /* renamed from: e, reason: collision with root package name */
    public final List<e> f8539e;

    /* renamed from: f, reason: collision with root package name */
    public final List<e> f8540f;

    public a(int i6, int i7, List<j> list, List<e> list2, List<e> list3, List<e> list4) {
        this.f8535a = i6;
        this.f8536b = i7;
        this.f8537c = Collections.unmodifiableList(list);
        this.f8538d = Collections.unmodifiableList(list2);
        this.f8539e = Collections.unmodifiableList(list3);
        this.f8540f = Collections.unmodifiableList(list4);
    }
}
