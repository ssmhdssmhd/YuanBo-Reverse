package r1;

import android.net.Uri;
import h0.y1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import m0.m;

/* loaded from: classes.dex */
public class h extends i {

    /* renamed from: n, reason: collision with root package name */
    public static final h f9119n = new h("", Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), null, Collections.emptyList(), false, Collections.emptyMap(), Collections.emptyList());

    /* renamed from: d, reason: collision with root package name */
    public final List<Uri> f9120d;

    /* renamed from: e, reason: collision with root package name */
    public final List<b> f9121e;

    /* renamed from: f, reason: collision with root package name */
    public final List<a> f9122f;

    /* renamed from: g, reason: collision with root package name */
    public final List<a> f9123g;

    /* renamed from: h, reason: collision with root package name */
    public final List<a> f9124h;

    /* renamed from: i, reason: collision with root package name */
    public final List<a> f9125i;

    /* renamed from: j, reason: collision with root package name */
    public final y1 f9126j;

    /* renamed from: k, reason: collision with root package name */
    public final List<y1> f9127k;

    /* renamed from: l, reason: collision with root package name */
    public final Map<String, String> f9128l;

    /* renamed from: m, reason: collision with root package name */
    public final List<m> f9129m;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final Uri f9130a;

        /* renamed from: b, reason: collision with root package name */
        public final y1 f9131b;

        /* renamed from: c, reason: collision with root package name */
        public final String f9132c;

        /* renamed from: d, reason: collision with root package name */
        public final String f9133d;

        public a(Uri uri, y1 y1Var, String str, String str2) {
            this.f9130a = uri;
            this.f9131b = y1Var;
            this.f9132c = str;
            this.f9133d = str2;
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final Uri f9134a;

        /* renamed from: b, reason: collision with root package name */
        public final y1 f9135b;

        /* renamed from: c, reason: collision with root package name */
        public final String f9136c;

        /* renamed from: d, reason: collision with root package name */
        public final String f9137d;

        /* renamed from: e, reason: collision with root package name */
        public final String f9138e;

        /* renamed from: f, reason: collision with root package name */
        public final String f9139f;

        public b(Uri uri, y1 y1Var, String str, String str2, String str3, String str4) {
            this.f9134a = uri;
            this.f9135b = y1Var;
            this.f9136c = str;
            this.f9137d = str2;
            this.f9138e = str3;
            this.f9139f = str4;
        }

        public static b b(Uri uri) {
            return new b(uri, new y1.b().U("0").M("application/x-mpegURL").G(), null, null, null, null);
        }

        public b a(y1 y1Var) {
            return new b(this.f9134a, y1Var, this.f9136c, this.f9137d, this.f9138e, this.f9139f);
        }
    }

    public h(String str, List<String> list, List<b> list2, List<a> list3, List<a> list4, List<a> list5, List<a> list6, y1 y1Var, List<y1> list7, boolean z5, Map<String, String> map, List<m> list8) {
        super(str, list, z5);
        this.f9120d = Collections.unmodifiableList(f(list2, list3, list4, list5, list6));
        this.f9121e = Collections.unmodifiableList(list2);
        this.f9122f = Collections.unmodifiableList(list3);
        this.f9123g = Collections.unmodifiableList(list4);
        this.f9124h = Collections.unmodifiableList(list5);
        this.f9125i = Collections.unmodifiableList(list6);
        this.f9126j = y1Var;
        this.f9127k = list7 != null ? Collections.unmodifiableList(list7) : null;
        this.f9128l = Collections.unmodifiableMap(map);
        this.f9129m = Collections.unmodifiableList(list8);
    }

    private static void b(List<a> list, List<Uri> list2) {
        for (int i6 = 0; i6 < list.size(); i6++) {
            Uri uri = list.get(i6).f9130a;
            if (uri != null && !list2.contains(uri)) {
                list2.add(uri);
            }
        }
    }

    private static <T> List<T> d(List<T> list, int i6, List<k1.c> list2) {
        ArrayList arrayList = new ArrayList(list2.size());
        for (int i7 = 0; i7 < list.size(); i7++) {
            T t5 = list.get(i7);
            int i8 = 0;
            while (true) {
                if (i8 < list2.size()) {
                    k1.c cVar = list2.get(i8);
                    if (cVar.f6860b == i6 && cVar.f6861c == i7) {
                        arrayList.add(t5);
                        break;
                    }
                    i8++;
                }
            }
        }
        return arrayList;
    }

    public static h e(String str) {
        return new h("", Collections.emptyList(), Collections.singletonList(b.b(Uri.parse(str))), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), null, null, false, Collections.emptyMap(), Collections.emptyList());
    }

    private static List<Uri> f(List<b> list, List<a> list2, List<a> list3, List<a> list4, List<a> list5) {
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < list.size(); i6++) {
            Uri uri = list.get(i6).f9134a;
            if (!arrayList.contains(uri)) {
                arrayList.add(uri);
            }
        }
        b(list2, arrayList);
        b(list3, arrayList);
        b(list4, arrayList);
        b(list5, arrayList);
        return arrayList;
    }

    @Override // k1.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public h a(List<k1.c> list) {
        return new h(this.f9140a, this.f9141b, d(this.f9121e, 0, list), Collections.emptyList(), d(this.f9123g, 1, list), d(this.f9124h, 2, list), Collections.emptyList(), this.f9126j, this.f9127k, this.f9142c, this.f9128l, this.f9129m);
    }
}
