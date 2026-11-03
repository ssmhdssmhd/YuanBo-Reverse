package t2;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import q2.s;
import q2.x;
import q2.y;

/* loaded from: classes.dex */
public final class c extends x<Date> {

    /* renamed from: b, reason: collision with root package name */
    public static final y f9397b = new a();

    /* renamed from: a, reason: collision with root package name */
    private final List<DateFormat> f9398a;

    class a implements y {
        a() {
        }

        @Override // q2.y
        public <T> x<T> a(q2.e eVar, x2.a<T> aVar) {
            if (aVar.c() == Date.class) {
                return new c();
            }
            return null;
        }
    }

    public c() {
        ArrayList arrayList = new ArrayList();
        this.f9398a = arrayList;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(2, 2, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (s2.e.d()) {
            arrayList.add(s2.j.c(2, 2));
        }
    }

    private Date e(y2.a aVar) {
        String e02 = aVar.e0();
        synchronized (this.f9398a) {
            Iterator<DateFormat> it = this.f9398a.iterator();
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
    public Date b(y2.a aVar) {
        if (aVar.g0() != y2.b.NULL) {
            return e(aVar);
        }
        aVar.c0();
        return null;
    }

    @Override // q2.x
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void d(y2.c cVar, Date date) {
        String format;
        if (date == null) {
            cVar.V();
            return;
        }
        DateFormat dateFormat = this.f9398a.get(0);
        synchronized (this.f9398a) {
            format = dateFormat.format(date);
        }
        cVar.j0(format);
    }
}
