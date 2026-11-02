package p1;

import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public final String f8580a;

    /* renamed from: b, reason: collision with root package name */
    public final long f8581b;

    /* renamed from: c, reason: collision with root package name */
    public final List<a> f8582c;

    /* renamed from: d, reason: collision with root package name */
    public final List<f> f8583d;

    /* renamed from: e, reason: collision with root package name */
    public final e f8584e;

    public g(String str, long j6, List<a> list, List<f> list2) {
        this(str, j6, list, list2, null);
    }

    public g(String str, long j6, List<a> list, List<f> list2, e eVar) {
        this.f8580a = str;
        this.f8581b = j6;
        this.f8582c = Collections.unmodifiableList(list);
        this.f8583d = Collections.unmodifiableList(list2);
        this.f8584e = eVar;
    }

    public int a(int i6) {
        int size = this.f8582c.size();
        for (int i7 = 0; i7 < size; i7++) {
            if (this.f8582c.get(i7).f8536b == i6) {
                return i7;
            }
        }
        return -1;
    }
}
