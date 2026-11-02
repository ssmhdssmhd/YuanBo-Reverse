package t2;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* loaded from: classes.dex */
public final class o {
    public static final q2.x<BigInteger> A;
    public static final q2.x<s2.g> B;
    public static final q2.y C;
    public static final q2.x<StringBuilder> D;
    public static final q2.y E;
    public static final q2.x<StringBuffer> F;
    public static final q2.y G;
    public static final q2.x<URL> H;
    public static final q2.y I;
    public static final q2.x<URI> J;
    public static final q2.y K;
    public static final q2.x<InetAddress> L;
    public static final q2.y M;
    public static final q2.x<UUID> N;
    public static final q2.y O;
    public static final q2.x<Currency> P;
    public static final q2.y Q;
    public static final q2.x<Calendar> R;
    public static final q2.y S;
    public static final q2.x<Locale> T;
    public static final q2.y U;
    public static final q2.x<q2.k> V;
    public static final q2.y W;
    public static final q2.y X;

    /* renamed from: a, reason: collision with root package name */
    public static final q2.x<Class> f9473a;

    /* renamed from: b, reason: collision with root package name */
    public static final q2.y f9474b;

    /* renamed from: c, reason: collision with root package name */
    public static final q2.x<BitSet> f9475c;

    /* renamed from: d, reason: collision with root package name */
    public static final q2.y f9476d;

    /* renamed from: e, reason: collision with root package name */
    public static final q2.x<Boolean> f9477e;

    /* renamed from: f, reason: collision with root package name */
    public static final q2.x<Boolean> f9478f;

    /* renamed from: g, reason: collision with root package name */
    public static final q2.y f9479g;

    /* renamed from: h, reason: collision with root package name */
    public static final q2.x<Number> f9480h;

    /* renamed from: i, reason: collision with root package name */
    public static final q2.y f9481i;

    /* renamed from: j, reason: collision with root package name */
    public static final q2.x<Number> f9482j;

    /* renamed from: k, reason: collision with root package name */
    public static final q2.y f9483k;

    /* renamed from: l, reason: collision with root package name */
    public static final q2.x<Number> f9484l;

    /* renamed from: m, reason: collision with root package name */
    public static final q2.y f9485m;

    /* renamed from: n, reason: collision with root package name */
    public static final q2.x<AtomicInteger> f9486n;

    /* renamed from: o, reason: collision with root package name */
    public static final q2.y f9487o;

    /* renamed from: p, reason: collision with root package name */
    public static final q2.x<AtomicBoolean> f9488p;

    /* renamed from: q, reason: collision with root package name */
    public static final q2.y f9489q;

    /* renamed from: r, reason: collision with root package name */
    public static final q2.x<AtomicIntegerArray> f9490r;

    /* renamed from: s, reason: collision with root package name */
    public static final q2.y f9491s;

    /* renamed from: t, reason: collision with root package name */
    public static final q2.x<Number> f9492t;

    /* renamed from: u, reason: collision with root package name */
    public static final q2.x<Number> f9493u;

    /* renamed from: v, reason: collision with root package name */
    public static final q2.x<Number> f9494v;

    /* renamed from: w, reason: collision with root package name */
    public static final q2.x<Character> f9495w;

    /* renamed from: x, reason: collision with root package name */
    public static final q2.y f9496x;

    /* renamed from: y, reason: collision with root package name */
    public static final q2.x<String> f9497y;

    /* renamed from: z, reason: collision with root package name */
    public static final q2.x<BigDecimal> f9498z;

    class a extends q2.x<AtomicIntegerArray> {
        a() {
        }

        @Override // q2.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public AtomicIntegerArray b(y2.a aVar) {
            ArrayList arrayList = new ArrayList();
            aVar.a();
            while (aVar.K()) {
                try {
                    arrayList.add(Integer.valueOf(aVar.Y()));
                } catch (NumberFormatException e6) {
                    throw new q2.s(e6);
                }
            }
            aVar.t();
            int size = arrayList.size();
            AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
            for (int i6 = 0; i6 < size; i6++) {
                atomicIntegerArray.set(i6, ((Integer) arrayList.get(i6)).intValue());
            }
            return atomicIntegerArray;
        }

        @Override // q2.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(y2.c cVar, AtomicIntegerArray atomicIntegerArray) {
            cVar.k();
            int length = atomicIntegerArray.length();
            for (int i6 = 0; i6 < length; i6++) {
                cVar.g0(atomicIntegerArray.get(i6));
            }
            cVar.t();
        }
    }

    static /* synthetic */ class a0 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f9499a;

        static {
            int[] iArr = new int[y2.b.values().length];
            f9499a = iArr;
            try {
                iArr[y2.b.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9499a[y2.b.STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9499a[y2.b.BOOLEAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9499a[y2.b.BEGIN_ARRAY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f9499a[y2.b.BEGIN_OBJECT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f9499a[y2.b.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    class b extends q2.x<Number> {
        b() {
        }

        @Override // q2.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Number b(y2.a aVar) {
            if (aVar.g0() == y2.b.NULL) {
                aVar.c0();
                return null;
            }
            try {
                return Long.valueOf(aVar.Z());
            } catch (NumberFormatException e6) {
                throw new q2.s(e6);
            }
        }

        @Override // q2.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(y2.c cVar, Number number) {
            if (number == null) {
                cVar.V();
            } else {
                cVar.g0(number.longValue());
            }
        }
    }

    class b0 extends q2.x<Boolean> {
        b0() {
        }

        @Override // q2.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Boolean b(y2.a aVar) {
            y2.b g02 = aVar.g0();
            if (g02 != y2.b.NULL) {
                return g02 == y2.b.STRING ? Boolean.valueOf(Boolean.parseBoolean(aVar.e0())) : Boolean.valueOf(aVar.W());
            }
            aVar.c0();
            return null;
        }

        @Override // q2.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(y2.c cVar, Boolean bool) {
            cVar.h0(bool);
        }
    }

    class c extends q2.x<Number> {
        c() {
        }

        @Override // q2.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Number b(y2.a aVar) {
            if (aVar.g0() != y2.b.NULL) {
                return Float.valueOf((float) aVar.X());
            }
            aVar.c0();
            return null;
        }

        @Override // q2.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(y2.c cVar, Number number) {
            if (number == null) {
                cVar.V();
                return;
            }
            if (!(number instanceof Float)) {
                number = Float.valueOf(number.floatValue());
            }
            cVar.i0(number);
        }
    }

    class c0 extends q2.x<Boolean> {
        c0() {
        }

        @Override // q2.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Boolean b(y2.a aVar) {
            if (aVar.g0() != y2.b.NULL) {
                return Boolean.valueOf(aVar.e0());
            }
            aVar.c0();
            return null;
        }

        @Override // q2.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(y2.c cVar, Boolean bool) {
            cVar.j0(bool == null ? "null" : bool.toString());
        }
    }

    class d extends q2.x<Number> {
        d() {
        }

        @Override // q2.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Number b(y2.a aVar) {
            if (aVar.g0() != y2.b.NULL) {
                return Double.valueOf(aVar.X());
            }
            aVar.c0();
            return null;
        }

        @Override // q2.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(y2.c cVar, Number number) {
            if (number == null) {
                cVar.V();
            } else {
                cVar.f0(number.doubleValue());
            }
        }
    }

    class d0 extends q2.x<Number> {
        d0() {
        }

        @Override // q2.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Number b(y2.a aVar) {
            if (aVar.g0() == y2.b.NULL) {
                aVar.c0();
                return null;
            }
            try {
                int Y = aVar.Y();
                if (Y <= 255 && Y >= -128) {
                    return Byte.valueOf((byte) Y);
                }
                throw new q2.s("Lossy conversion from " + Y + " to byte; at path " + aVar.I());
            } catch (NumberFormatException e6) {
                throw new q2.s(e6);
            }
        }

        @Override // q2.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(y2.c cVar, Number number) {
            if (number == null) {
                cVar.V();
            } else {
                cVar.g0(number.byteValue());
            }
        }
    }

    class e extends q2.x<Character> {
        e() {
        }

        @Override // q2.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Character b(y2.a aVar) {
            if (aVar.g0() == y2.b.NULL) {
                aVar.c0();
                return null;
            }
            String e02 = aVar.e0();
            if (e02.length() == 1) {
                return Character.valueOf(e02.charAt(0));
            }
            throw new q2.s("Expecting character, got: " + e02 + "; at " + aVar.I());
        }

        @Override // q2.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(y2.c cVar, Character ch) {
            cVar.j0(ch == null ? null : String.valueOf(ch));
        }
    }

    class e0 extends q2.x<Number> {
        e0() {
        }

        @Override // q2.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Number b(y2.a aVar) {
            if (aVar.g0() == y2.b.NULL) {
                aVar.c0();
                return null;
            }
            try {
                int Y = aVar.Y();
                if (Y <= 65535 && Y >= -32768) {
                    return Short.valueOf((short) Y);
                }
                throw new q2.s("Lossy conversion from " + Y + " to short; at path " + aVar.I());
            } catch (NumberFormatException e6) {
                throw new q2.s(e6);
            }
        }

        @Override // q2.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(y2.c cVar, Number number) {
            if (number == null) {
                cVar.V();
            } else {
                cVar.g0(number.shortValue());
            }
        }
    }

    class f extends q2.x<String> {
        f() {
        }

        @Override // q2.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public String b(y2.a aVar) {
            y2.b g02 = aVar.g0();
            if (g02 != y2.b.NULL) {
                return g02 == y2.b.BOOLEAN ? Boolean.toString(aVar.W()) : aVar.e0();
            }
            aVar.c0();
            return null;
        }

        @Override // q2.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(y2.c cVar, String str) {
            cVar.j0(str);
        }
    }

    class f0 extends q2.x<Number> {
        f0() {
        }

        @Override // q2.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Number b(y2.a aVar) {
            if (aVar.g0() == y2.b.NULL) {
                aVar.c0();
                return null;
            }
            try {
                return Integer.valueOf(aVar.Y());
            } catch (NumberFormatException e6) {
                throw new q2.s(e6);
            }
        }

        @Override // q2.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(y2.c cVar, Number number) {
            if (number == null) {
                cVar.V();
            } else {
                cVar.g0(number.intValue());
            }
        }
    }

    class g extends q2.x<BigDecimal> {
        g() {
        }

        @Override // q2.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public BigDecimal b(y2.a aVar) {
            if (aVar.g0() == y2.b.NULL) {
                aVar.c0();
                return null;
            }
            String e02 = aVar.e0();
            try {
                return new BigDecimal(e02);
            } catch (NumberFormatException e6) {
                throw new q2.s("Failed parsing '" + e02 + "' as BigDecimal; at path " + aVar.I(), e6);
            }
        }

        @Override // q2.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(y2.c cVar, BigDecimal bigDecimal) {
            cVar.i0(bigDecimal);
        }
    }

    class g0 extends q2.x<AtomicInteger> {
        g0() {
        }

        @Override // q2.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public AtomicInteger b(y2.a aVar) {
            try {
                return new AtomicInteger(aVar.Y());
            } catch (NumberFormatException e6) {
                throw new q2.s(e6);
            }
        }

        @Override // q2.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(y2.c cVar, AtomicInteger atomicInteger) {
            cVar.g0(atomicInteger.get());
        }
    }

    class h extends q2.x<BigInteger> {
        h() {
        }

        @Override // q2.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public BigInteger b(y2.a aVar) {
            if (aVar.g0() == y2.b.NULL) {
                aVar.c0();
                return null;
            }
            String e02 = aVar.e0();
            try {
                return new BigInteger(e02);
            } catch (NumberFormatException e6) {
                throw new q2.s("Failed parsing '" + e02 + "' as BigInteger; at path " + aVar.I(), e6);
            }
        }

        @Override // q2.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(y2.c cVar, BigInteger bigInteger) {
            cVar.i0(bigInteger);
        }
    }

    class h0 extends q2.x<AtomicBoolean> {
        h0() {
        }

        @Override // q2.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public AtomicBoolean b(y2.a aVar) {
            return new AtomicBoolean(aVar.W());
        }

        @Override // q2.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(y2.c cVar, AtomicBoolean atomicBoolean) {
            cVar.k0(atomicBoolean.get());
        }
    }

    class i extends q2.x<s2.g> {
        i() {
        }

        @Override // q2.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public s2.g b(y2.a aVar) {
            if (aVar.g0() != y2.b.NULL) {
                return new s2.g(aVar.e0());
            }
            aVar.c0();
            return null;
        }

        @Override // q2.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(y2.c cVar, s2.g gVar) {
            cVar.i0(gVar);
        }
    }

    private static final class i0<T extends Enum<T>> extends q2.x<T> {

        /* renamed from: a, reason: collision with root package name */
        private final Map<String, T> f9500a = new HashMap();

        /* renamed from: b, reason: collision with root package name */
        private final Map<String, T> f9501b = new HashMap();

        /* renamed from: c, reason: collision with root package name */
        private final Map<T, String> f9502c = new HashMap();

        class a implements PrivilegedAction<Field[]> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Class f9503a;

            a(Class cls) {
                this.f9503a = cls;
            }

            @Override // java.security.PrivilegedAction
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Field[] run() {
                Field[] declaredFields = this.f9503a.getDeclaredFields();
                ArrayList arrayList = new ArrayList(declaredFields.length);
                for (Field field : declaredFields) {
                    if (field.isEnumConstant()) {
                        arrayList.add(field);
                    }
                }
                Field[] fieldArr = (Field[]) arrayList.toArray(new Field[0]);
                AccessibleObject.setAccessible(fieldArr, true);
                return fieldArr;
            }
        }

        public i0(Class<T> cls) {
            try {
                for (Field field : (Field[]) AccessController.doPrivileged(new a(cls))) {
                    Enum r42 = (Enum) field.get(null);
                    String name = r42.name();
                    String str = r42.toString();
                    r2.c cVar = (r2.c) field.getAnnotation(r2.c.class);
                    if (cVar != null) {
                        name = cVar.value();
                        for (String str2 : cVar.alternate()) {
                            this.f9500a.put(str2, r42);
                        }
                    }
                    this.f9500a.put(name, r42);
                    this.f9501b.put(str, r42);
                    this.f9502c.put(r42, name);
                }
            } catch (IllegalAccessException e6) {
                throw new AssertionError(e6);
            }
        }

        @Override // q2.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public T b(y2.a aVar) {
            if (aVar.g0() == y2.b.NULL) {
                aVar.c0();
                return null;
            }
            String e02 = aVar.e0();
            T t5 = this.f9500a.get(e02);
            return t5 == null ? this.f9501b.get(e02) : t5;
        }

        @Override // q2.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(y2.c cVar, T t5) {
            cVar.j0(t5 == null ? null : this.f9502c.get(t5));
        }
    }

    class j extends q2.x<StringBuilder> {
        j() {
        }

        @Override // q2.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public StringBuilder b(y2.a aVar) {
            if (aVar.g0() != y2.b.NULL) {
                return new StringBuilder(aVar.e0());
            }
            aVar.c0();
            return null;
        }

        @Override // q2.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(y2.c cVar, StringBuilder sb) {
            cVar.j0(sb == null ? null : sb.toString());
        }
    }

    class k extends q2.x<Class> {
        k() {
        }

        @Override // q2.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Class b(y2.a aVar) {
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }

        @Override // q2.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(y2.c cVar, Class cls) {
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
        }
    }

    class l extends q2.x<StringBuffer> {
        l() {
        }

        @Override // q2.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public StringBuffer b(y2.a aVar) {
            if (aVar.g0() != y2.b.NULL) {
                return new StringBuffer(aVar.e0());
            }
            aVar.c0();
            return null;
        }

        @Override // q2.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(y2.c cVar, StringBuffer stringBuffer) {
            cVar.j0(stringBuffer == null ? null : stringBuffer.toString());
        }
    }

    class m extends q2.x<URL> {
        m() {
        }

        @Override // q2.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public URL b(y2.a aVar) {
            if (aVar.g0() == y2.b.NULL) {
                aVar.c0();
                return null;
            }
            String e02 = aVar.e0();
            if ("null".equals(e02)) {
                return null;
            }
            return new URL(e02);
        }

        @Override // q2.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(y2.c cVar, URL url) {
            cVar.j0(url == null ? null : url.toExternalForm());
        }
    }

    class n extends q2.x<URI> {
        n() {
        }

        @Override // q2.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public URI b(y2.a aVar) {
            if (aVar.g0() == y2.b.NULL) {
                aVar.c0();
                return null;
            }
            try {
                String e02 = aVar.e0();
                if ("null".equals(e02)) {
                    return null;
                }
                return new URI(e02);
            } catch (URISyntaxException e6) {
                throw new q2.l(e6);
            }
        }

        @Override // q2.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(y2.c cVar, URI uri) {
            cVar.j0(uri == null ? null : uri.toASCIIString());
        }
    }

    /* renamed from: t2.o$o, reason: collision with other inner class name */
    class C0146o extends q2.x<InetAddress> {
        C0146o() {
        }

        @Override // q2.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public InetAddress b(y2.a aVar) {
            if (aVar.g0() != y2.b.NULL) {
                return InetAddress.getByName(aVar.e0());
            }
            aVar.c0();
            return null;
        }

        @Override // q2.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(y2.c cVar, InetAddress inetAddress) {
            cVar.j0(inetAddress == null ? null : inetAddress.getHostAddress());
        }
    }

    class p extends q2.x<UUID> {
        p() {
        }

        @Override // q2.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public UUID b(y2.a aVar) {
            if (aVar.g0() == y2.b.NULL) {
                aVar.c0();
                return null;
            }
            String e02 = aVar.e0();
            try {
                return UUID.fromString(e02);
            } catch (IllegalArgumentException e6) {
                throw new q2.s("Failed parsing '" + e02 + "' as UUID; at path " + aVar.I(), e6);
            }
        }

        @Override // q2.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(y2.c cVar, UUID uuid) {
            cVar.j0(uuid == null ? null : uuid.toString());
        }
    }

    class q extends q2.x<Currency> {
        q() {
        }

        @Override // q2.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Currency b(y2.a aVar) {
            String e02 = aVar.e0();
            try {
                return Currency.getInstance(e02);
            } catch (IllegalArgumentException e6) {
                throw new q2.s("Failed parsing '" + e02 + "' as Currency; at path " + aVar.I(), e6);
            }
        }

        @Override // q2.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(y2.c cVar, Currency currency) {
            cVar.j0(currency.getCurrencyCode());
        }
    }

    class r extends q2.x<Calendar> {
        r() {
        }

        @Override // q2.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Calendar b(y2.a aVar) {
            if (aVar.g0() == y2.b.NULL) {
                aVar.c0();
                return null;
            }
            aVar.j();
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            int i10 = 0;
            int i11 = 0;
            while (aVar.g0() != y2.b.END_OBJECT) {
                String a02 = aVar.a0();
                int Y = aVar.Y();
                if ("year".equals(a02)) {
                    i6 = Y;
                } else if ("month".equals(a02)) {
                    i7 = Y;
                } else if ("dayOfMonth".equals(a02)) {
                    i8 = Y;
                } else if ("hourOfDay".equals(a02)) {
                    i9 = Y;
                } else if ("minute".equals(a02)) {
                    i10 = Y;
                } else if ("second".equals(a02)) {
                    i11 = Y;
                }
            }
            aVar.v();
            return new GregorianCalendar(i6, i7, i8, i9, i10, i11);
        }

        @Override // q2.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(y2.c cVar, Calendar calendar) {
            if (calendar == null) {
                cVar.V();
                return;
            }
            cVar.q();
            cVar.M("year");
            cVar.g0(calendar.get(1));
            cVar.M("month");
            cVar.g0(calendar.get(2));
            cVar.M("dayOfMonth");
            cVar.g0(calendar.get(5));
            cVar.M("hourOfDay");
            cVar.g0(calendar.get(11));
            cVar.M("minute");
            cVar.g0(calendar.get(12));
            cVar.M("second");
            cVar.g0(calendar.get(13));
            cVar.v();
        }
    }

    class s extends q2.x<Locale> {
        s() {
        }

        @Override // q2.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Locale b(y2.a aVar) {
            if (aVar.g0() == y2.b.NULL) {
                aVar.c0();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(aVar.e0(), "_");
            String nextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String nextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String nextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            return (nextToken2 == null && nextToken3 == null) ? new Locale(nextToken) : nextToken3 == null ? new Locale(nextToken, nextToken2) : new Locale(nextToken, nextToken2, nextToken3);
        }

        @Override // q2.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(y2.c cVar, Locale locale) {
            cVar.j0(locale == null ? null : locale.toString());
        }
    }

    class t extends q2.x<q2.k> {
        t() {
        }

        private q2.k f(y2.a aVar, y2.b bVar) {
            int i6 = a0.f9499a[bVar.ordinal()];
            if (i6 == 1) {
                return new q2.p(new s2.g(aVar.e0()));
            }
            if (i6 == 2) {
                return new q2.p(aVar.e0());
            }
            if (i6 == 3) {
                return new q2.p(Boolean.valueOf(aVar.W()));
            }
            if (i6 == 6) {
                aVar.c0();
                return q2.m.f8912a;
            }
            throw new IllegalStateException("Unexpected token: " + bVar);
        }

        private q2.k g(y2.a aVar, y2.b bVar) {
            int i6 = a0.f9499a[bVar.ordinal()];
            if (i6 == 4) {
                aVar.a();
                return new q2.h();
            }
            if (i6 != 5) {
                return null;
            }
            aVar.j();
            return new q2.n();
        }

        @Override // q2.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public q2.k b(y2.a aVar) {
            if (aVar instanceof t2.f) {
                return ((t2.f) aVar).t0();
            }
            y2.b g02 = aVar.g0();
            q2.k g6 = g(aVar, g02);
            if (g6 == null) {
                return f(aVar, g02);
            }
            ArrayDeque arrayDeque = new ArrayDeque();
            while (true) {
                if (aVar.K()) {
                    String a02 = g6 instanceof q2.n ? aVar.a0() : null;
                    y2.b g03 = aVar.g0();
                    q2.k g7 = g(aVar, g03);
                    boolean z5 = g7 != null;
                    if (g7 == null) {
                        g7 = f(aVar, g03);
                    }
                    if (g6 instanceof q2.h) {
                        ((q2.h) g6).j(g7);
                    } else {
                        ((q2.n) g6).j(a02, g7);
                    }
                    if (z5) {
                        arrayDeque.addLast(g6);
                        g6 = g7;
                    }
                } else {
                    if (g6 instanceof q2.h) {
                        aVar.t();
                    } else {
                        aVar.v();
                    }
                    if (arrayDeque.isEmpty()) {
                        return g6;
                    }
                    g6 = (q2.k) arrayDeque.removeLast();
                }
            }
        }

        @Override // q2.x
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void d(y2.c cVar, q2.k kVar) {
            if (kVar == null || kVar.g()) {
                cVar.V();
                return;
            }
            if (kVar.i()) {
                q2.p d6 = kVar.d();
                if (d6.q()) {
                    cVar.i0(d6.n());
                    return;
                } else if (d6.o()) {
                    cVar.k0(d6.j());
                    return;
                } else {
                    cVar.j0(d6.e());
                    return;
                }
            }
            if (kVar.f()) {
                cVar.k();
                Iterator<q2.k> it = kVar.b().iterator();
                while (it.hasNext()) {
                    d(cVar, it.next());
                }
                cVar.t();
                return;
            }
            if (!kVar.h()) {
                throw new IllegalArgumentException("Couldn't write " + kVar.getClass());
            }
            cVar.q();
            for (Map.Entry<String, q2.k> entry : kVar.c().k()) {
                cVar.M(entry.getKey());
                d(cVar, entry.getValue());
            }
            cVar.v();
        }
    }

    class u implements q2.y {
        u() {
        }

        @Override // q2.y
        public <T> q2.x<T> a(q2.e eVar, x2.a<T> aVar) {
            Class<? super T> c6 = aVar.c();
            if (!Enum.class.isAssignableFrom(c6) || c6 == Enum.class) {
                return null;
            }
            if (!c6.isEnum()) {
                c6 = c6.getSuperclass();
            }
            return new i0(c6);
        }
    }

    class v extends q2.x<BitSet> {
        v() {
        }

        @Override // q2.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public BitSet b(y2.a aVar) {
            BitSet bitSet = new BitSet();
            aVar.a();
            y2.b g02 = aVar.g0();
            int i6 = 0;
            while (g02 != y2.b.END_ARRAY) {
                int i7 = a0.f9499a[g02.ordinal()];
                boolean z5 = true;
                if (i7 == 1 || i7 == 2) {
                    int Y = aVar.Y();
                    if (Y == 0) {
                        z5 = false;
                    } else if (Y != 1) {
                        throw new q2.s("Invalid bitset value " + Y + ", expected 0 or 1; at path " + aVar.I());
                    }
                } else {
                    if (i7 != 3) {
                        throw new q2.s("Invalid bitset value type: " + g02 + "; at path " + aVar.z());
                    }
                    z5 = aVar.W();
                }
                if (z5) {
                    bitSet.set(i6);
                }
                i6++;
                g02 = aVar.g0();
            }
            aVar.t();
            return bitSet;
        }

        @Override // q2.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(y2.c cVar, BitSet bitSet) {
            cVar.k();
            int length = bitSet.length();
            for (int i6 = 0; i6 < length; i6++) {
                cVar.g0(bitSet.get(i6) ? 1L : 0L);
            }
            cVar.t();
        }
    }

    class w implements q2.y {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Class f9505a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ q2.x f9506b;

        w(Class cls, q2.x xVar) {
            this.f9505a = cls;
            this.f9506b = xVar;
        }

        @Override // q2.y
        public <T> q2.x<T> a(q2.e eVar, x2.a<T> aVar) {
            if (aVar.c() == this.f9505a) {
                return this.f9506b;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.f9505a.getName() + ",adapter=" + this.f9506b + "]";
        }
    }

    class x implements q2.y {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Class f9507a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Class f9508b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ q2.x f9509c;

        x(Class cls, Class cls2, q2.x xVar) {
            this.f9507a = cls;
            this.f9508b = cls2;
            this.f9509c = xVar;
        }

        @Override // q2.y
        public <T> q2.x<T> a(q2.e eVar, x2.a<T> aVar) {
            Class<? super T> c6 = aVar.c();
            if (c6 == this.f9507a || c6 == this.f9508b) {
                return this.f9509c;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.f9508b.getName() + "+" + this.f9507a.getName() + ",adapter=" + this.f9509c + "]";
        }
    }

    class y implements q2.y {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Class f9510a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Class f9511b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ q2.x f9512c;

        y(Class cls, Class cls2, q2.x xVar) {
            this.f9510a = cls;
            this.f9511b = cls2;
            this.f9512c = xVar;
        }

        @Override // q2.y
        public <T> q2.x<T> a(q2.e eVar, x2.a<T> aVar) {
            Class<? super T> c6 = aVar.c();
            if (c6 == this.f9510a || c6 == this.f9511b) {
                return this.f9512c;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.f9510a.getName() + "+" + this.f9511b.getName() + ",adapter=" + this.f9512c + "]";
        }
    }

    class z implements q2.y {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Class f9513a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ q2.x f9514b;

        /* JADX INFO: Add missing generic type declarations: [T1] */
        class a<T1> extends q2.x<T1> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Class f9515a;

            a(Class cls) {
                this.f9515a = cls;
            }

            @Override // q2.x
            public T1 b(y2.a aVar) {
                T1 t12 = (T1) z.this.f9514b.b(aVar);
                if (t12 == null || this.f9515a.isInstance(t12)) {
                    return t12;
                }
                throw new q2.s("Expected a " + this.f9515a.getName() + " but was " + t12.getClass().getName() + "; at path " + aVar.I());
            }

            @Override // q2.x
            public void d(y2.c cVar, T1 t12) {
                z.this.f9514b.d(cVar, t12);
            }
        }

        z(Class cls, q2.x xVar) {
            this.f9513a = cls;
            this.f9514b = xVar;
        }

        @Override // q2.y
        public <T2> q2.x<T2> a(q2.e eVar, x2.a<T2> aVar) {
            Class<? super T2> c6 = aVar.c();
            if (this.f9513a.isAssignableFrom(c6)) {
                return new a(c6);
            }
            return null;
        }

        public String toString() {
            return "Factory[typeHierarchy=" + this.f9513a.getName() + ",adapter=" + this.f9514b + "]";
        }
    }

    static {
        q2.x<Class> a6 = new k().a();
        f9473a = a6;
        f9474b = b(Class.class, a6);
        q2.x<BitSet> a7 = new v().a();
        f9475c = a7;
        f9476d = b(BitSet.class, a7);
        b0 b0Var = new b0();
        f9477e = b0Var;
        f9478f = new c0();
        f9479g = a(Boolean.TYPE, Boolean.class, b0Var);
        d0 d0Var = new d0();
        f9480h = d0Var;
        f9481i = a(Byte.TYPE, Byte.class, d0Var);
        e0 e0Var = new e0();
        f9482j = e0Var;
        f9483k = a(Short.TYPE, Short.class, e0Var);
        f0 f0Var = new f0();
        f9484l = f0Var;
        f9485m = a(Integer.TYPE, Integer.class, f0Var);
        q2.x<AtomicInteger> a8 = new g0().a();
        f9486n = a8;
        f9487o = b(AtomicInteger.class, a8);
        q2.x<AtomicBoolean> a9 = new h0().a();
        f9488p = a9;
        f9489q = b(AtomicBoolean.class, a9);
        q2.x<AtomicIntegerArray> a10 = new a().a();
        f9490r = a10;
        f9491s = b(AtomicIntegerArray.class, a10);
        f9492t = new b();
        f9493u = new c();
        f9494v = new d();
        e eVar = new e();
        f9495w = eVar;
        f9496x = a(Character.TYPE, Character.class, eVar);
        f fVar = new f();
        f9497y = fVar;
        f9498z = new g();
        A = new h();
        B = new i();
        C = b(String.class, fVar);
        j jVar = new j();
        D = jVar;
        E = b(StringBuilder.class, jVar);
        l lVar = new l();
        F = lVar;
        G = b(StringBuffer.class, lVar);
        m mVar = new m();
        H = mVar;
        I = b(URL.class, mVar);
        n nVar = new n();
        J = nVar;
        K = b(URI.class, nVar);
        C0146o c0146o = new C0146o();
        L = c0146o;
        M = d(InetAddress.class, c0146o);
        p pVar = new p();
        N = pVar;
        O = b(UUID.class, pVar);
        q2.x<Currency> a11 = new q().a();
        P = a11;
        Q = b(Currency.class, a11);
        r rVar = new r();
        R = rVar;
        S = c(Calendar.class, GregorianCalendar.class, rVar);
        s sVar = new s();
        T = sVar;
        U = b(Locale.class, sVar);
        t tVar = new t();
        V = tVar;
        W = d(q2.k.class, tVar);
        X = new u();
    }

    public static <TT> q2.y a(Class<TT> cls, Class<TT> cls2, q2.x<? super TT> xVar) {
        return new x(cls, cls2, xVar);
    }

    public static <TT> q2.y b(Class<TT> cls, q2.x<TT> xVar) {
        return new w(cls, xVar);
    }

    public static <TT> q2.y c(Class<TT> cls, Class<? extends TT> cls2, q2.x<? super TT> xVar) {
        return new y(cls, cls2, xVar);
    }

    public static <T1> q2.y d(Class<T1> cls, q2.x<T1> xVar) {
        return new z(cls, xVar);
    }
}
