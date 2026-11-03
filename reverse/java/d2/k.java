package d2;

import i2.c1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes.dex */
final class k implements u1.h {

    /* renamed from: a, reason: collision with root package name */
    private final List<e> f2977a;

    /* renamed from: b, reason: collision with root package name */
    private final long[] f2978b;

    /* renamed from: c, reason: collision with root package name */
    private final long[] f2979c;

    public k(List<e> list) {
        this.f2977a = Collections.unmodifiableList(new ArrayList(list));
        this.f2978b = new long[list.size() * 2];
        for (int i6 = 0; i6 < list.size(); i6++) {
            e eVar = list.get(i6);
            int i7 = i6 * 2;
            long[] jArr = this.f2978b;
            jArr[i7] = eVar.f2948b;
            jArr[i7 + 1] = eVar.f2949c;
        }
        long[] jArr2 = this.f2978b;
        long[] copyOf = Arrays.copyOf(jArr2, jArr2.length);
        this.f2979c = copyOf;
        Arrays.sort(copyOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int f(e eVar, e eVar2) {
        return Long.compare(eVar.f2948b, eVar2.f2948b);
    }

    @Override // u1.h
    public int a(long j6) {
        int e6 = c1.e(this.f2979c, j6, false, false);
        if (e6 < this.f2979c.length) {
            return e6;
        }
        return -1;
    }

    @Override // u1.h
    public long b(int i6) {
        i2.a.a(i6 >= 0);
        i2.a.a(i6 < this.f2979c.length);
        return this.f2979c[i6];
    }

    @Override // u1.h
    public List<u1.b> c(long j6) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i6 = 0; i6 < this.f2977a.size(); i6++) {
            long[] jArr = this.f2978b;
            int i7 = i6 * 2;
            if (jArr[i7] <= j6 && j6 < jArr[i7 + 1]) {
                e eVar = this.f2977a.get(i6);
                u1.b bVar = eVar.f2947a;
                if (bVar.f9608e == -3.4028235E38f) {
                    arrayList2.add(eVar);
                } else {
                    arrayList.add(bVar);
                }
            }
        }
        Collections.sort(arrayList2, new Comparator() { // from class: d2.j
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int f6;
                f6 = k.f((e) obj, (e) obj2);
                return f6;
            }
        });
        for (int i8 = 0; i8 < arrayList2.size(); i8++) {
            arrayList.add(((e) arrayList2.get(i8)).f2947a.b().h((-1) - i8, 1).a());
        }
        return arrayList;
    }

    @Override // u1.h
    public int d() {
        return this.f2979c.length;
    }
}
