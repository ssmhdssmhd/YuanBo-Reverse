package t2;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import q2.s;
import q2.x;
import q2.y;

/* loaded from: classes.dex */
public final class d<T extends Date> extends x<T> {

    /* renamed from: a, reason: collision with root package name */
    private final b<T> f9399a;

    /* renamed from: b, reason: collision with root package name */
    private final List<DateFormat> f9400b;

    public static abstract class b<T extends Date> {

        /* renamed from: b, reason: collision with root package name */
        public static final b<Date> f9401b = new a(Date.class);

        /* renamed from: a, reason: collision with root package name */
        private final Class<T> f9402a;

        class a extends b<Date> {
            a(Class cls) {
                super(cls);
            }

            @Override // t2.d.b
            protected Date d(Date date) {
                return date;
            }
        }

        protected b(Class<T> cls) {
            this.f9402a = cls;
        }

        private final y c(d<T> dVar) {
            return o.b(this.f9402a, dVar);
        }

        public final y a(int i6, int i7) {
            return c(new d<>(this, i6, i7));
        }

        public final y b(String str) {
            return c(new d<>(this, str));
        }

        protected abstract T d(Date date);
    }

    private d(b<T> bVar, int i6, int i7) {
        ArrayList arrayList = new ArrayList();
        this.f9400b = arrayList;
        Objects.requireNonNull(bVar);
        this.f9399a = bVar;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(i6, i7, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(i6, i7));
        }
        if (s2.e.d()) {
            arrayList.add(s2.j.c(i6, i7));
        }
    }

    private d(b<T> bVar, String str) {
        ArrayList arrayList = new ArrayList();
        this.f9400b = arrayList;
        Objects.requireNonNull(bVar);
        this.f9399a = bVar;
        Locale locale = Locale.US;
        arrayList.add(new SimpleDateFormat(str, locale));
        if (Locale.getDefault().equals(locale)) {
            return;
        }
        arrayList.add(new SimpleDateFormat(str));
    }

    private Date e(y2.a aVar) {
        String e02 = aVar.e0();
        synchronized (this.f9400b) {
            Iterator<DateFormat> it = this.f9400b.iterator();
            while (it.hasNext()) {
                try {
                    return it.next().parse(e02);
                } catch (ParseException unused) {
                }
            }
            try {
                return u2.a.c(e02, new ParsePosition(0));
            } catch (ParseException e6) {
                throw new s("Failed parsing '" + e02 + "' as Date; at path " + aVar.I(), e6);
            }
        }
    }

    @Override // q2.x
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public T b(y2.a aVar) {
        if (aVar.g0() == y2.b.NULL) {
            aVar.c0();
            return null;
        }
        return this.f9399a.d(e(aVar));
    }

    @Override // q2.x
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void d(y2.c cVar, Date date) {
        String format;
        if (date == null) {
            cVar.V();
            return;
        }
        DateFormat dateFormat = this.f9400b.get(0);
        synchronized (this.f9400b) {
            format = dateFormat.format(date);
        }
        cVar.j0(format);
    }

    public String toString() {
        StringBuilder sb;
        String simpleName;
        DateFormat dateFormat = this.f9400b.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            sb = new StringBuilder();
            sb.append("DefaultDateTypeAdapter(");
            simpleName = ((SimpleDateFormat) dateFormat).toPattern();
        } else {
            sb = new StringBuilder();
            sb.append("DefaultDateTypeAdapter(");
            simpleName = dateFormat.getClass().getSimpleName();
        }
        sb.append(simpleName);
        sb.append(')');
        return sb.toString();
    }
}
