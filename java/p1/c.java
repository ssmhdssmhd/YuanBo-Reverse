package p1;

import android.net.Uri;
import i2.c1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes.dex */
public class c implements k1.a<c> {

    /* renamed from: a, reason: collision with root package name */
    public final long f8545a;

    /* renamed from: b, reason: collision with root package name */
    public final long f8546b;

    /* renamed from: c, reason: collision with root package name */
    public final long f8547c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f8548d;

    /* renamed from: e, reason: collision with root package name */
    public final long f8549e;

    /* renamed from: f, reason: collision with root package name */
    public final long f8550f;

    /* renamed from: g, reason: collision with root package name */
    public final long f8551g;

    /* renamed from: h, reason: collision with root package name */
    public final long f8552h;

    /* renamed from: i, reason: collision with root package name */
    public final o f8553i;

    /* renamed from: j, reason: collision with root package name */
    public final l f8554j;

    /* renamed from: k, reason: collision with root package name */
    public final Uri f8555k;

    /* renamed from: l, reason: collision with root package name */
    public final h f8556l;

    /* renamed from: m, reason: collision with root package name */
    private final List<g> f8557m;

    public c(long j6, long j7, long j8, boolean z5, long j9, long j10, long j11, long j12, h hVar, o oVar, l lVar, Uri uri, List<g> list) {
        this.f8545a = j6;
        this.f8546b = j7;
        this.f8547c = j8;
        this.f8548d = z5;
        this.f8549e = j9;
        this.f8550f = j10;
        this.f8551g = j11;
        this.f8552h = j12;
        this.f8556l = hVar;
        this.f8553i = oVar;
        this.f8555k = uri;
        this.f8554j = lVar;
        this.f8557m = list == null ? Collections.emptyList() : list;
    }

    private static ArrayList<a> c(List<a> list, LinkedList<k1.c> linkedList) {
        k1.c poll = linkedList.poll();
        int i6 = poll.f6859a;
        ArrayList<a> arrayList = new ArrayList<>();
        do {
            int i7 = poll.f6860b;
            a aVar = list.get(i7);
            List<j> list2 = aVar.f8537c;
            ArrayList arrayList2 = new ArrayList();
            do {
                arrayList2.add(list2.get(poll.f6861c));
                poll = linkedList.poll();
                if (poll.f6859a != i6) {
                    break;
                }
            } while (poll.f6860b == i7);
            arrayList.add(new a(aVar.f8535a, aVar.f8536b, arrayList2, aVar.f8538d, aVar.f8539e, aVar.f8540f));
        } while (poll.f6859a == i6);
        linkedList.addFirst(poll);
        return arrayList;
    }

    @Override // k1.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final c a(List<k1.c> list) {
        LinkedList linkedList = new LinkedList(list);
        Collections.sort(linkedList);
        linkedList.add(new k1.c(-1, -1, -1));
        ArrayList arrayList = new ArrayList();
        long j6 = 0;
        int i6 = 0;
        while (true) {
            if (i6 >= e()) {
                break;
            }
            if (((k1.c) linkedList.peek()).f6859a != i6) {
                long f6 = f(i6);
                if (f6 != -9223372036854775807L) {
                    j6 += f6;
                }
            } else {
                g d6 = d(i6);
                arrayList.add(new g(d6.f8580a, d6.f8581b - j6, c(d6.f8582c, linkedList), d6.f8583d));
            }
            i6++;
        }
        long j7 = this.f8546b;
        return new c(this.f8545a, j7 != -9223372036854775807L ? j7 - j6 : -9223372036854775807L, this.f8547c, this.f8548d, this.f8549e, this.f8550f, this.f8551g, this.f8552h, this.f8556l, this.f8553i, this.f8554j, this.f8555k, arrayList);
    }

    public final g d(int i6) {
        return this.f8557m.get(i6);
    }

    public final int e() {
        return this.f8557m.size();
    }

    public final long f(int i6) {
        long j6;
        if (i6 == this.f8557m.size() - 1) {
            j6 = this.f8546b;
            if (j6 == -9223372036854775807L) {
                return -9223372036854775807L;
            }
        } else {
            j6 = this.f8557m.get(i6 + 1).f8581b;
        }
        return j6 - this.f8557m.get(i6).f8581b;
    }

    public final long g(int i6) {
        return c1.D0(f(i6));
    }
}
