package m2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes.dex */
public abstract class b0<K0, V0> {

    class a extends d<K0> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator f7942a;

        a(Comparator comparator) {
            this.f7942a = comparator;
        }

        @Override // m2.b0.d
        <K extends K0, V> Map<K, Collection<V>> c() {
            return new TreeMap(this.f7942a);
        }
    }

    private static final class b<V> implements l2.p<List<V>>, Serializable {

        /* renamed from: a, reason: collision with root package name */
        private final int f7943a;

        b(int i6) {
            this.f7943a = h.b(i6, "expectedValuesPerKey");
        }

        @Override // l2.p
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<V> get() {
            return new ArrayList(this.f7943a);
        }
    }

    public static abstract class c<K0, V0> extends b0<K0, V0> {
        c() {
            super(null);
        }

        public abstract <K extends K0, V extends V0> v<K, V> c();
    }

    public static abstract class d<K0> {

        class a extends c<K0, Object> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f7944a;

            a(int i6) {
                this.f7944a = i6;
            }

            @Override // m2.b0.c
            public <K extends K0, V> v<K, V> c() {
                return c0.b(d.this.c(), new b(this.f7944a));
            }
        }

        d() {
        }

        public c<K0, Object> a() {
            return b(2);
        }

        public c<K0, Object> b(int i6) {
            h.b(i6, "expectedValuesPerKey");
            return new a(i6);
        }

        abstract <K extends K0, V> Map<K, Collection<V>> c();
    }

    private b0() {
    }

    /* synthetic */ b0(a0 a0Var) {
        this();
    }

    public static d<Comparable> a() {
        return b(h0.b());
    }

    public static <K0> d<K0> b(Comparator<K0> comparator) {
        l2.k.i(comparator);
        return new a(comparator);
    }
}
