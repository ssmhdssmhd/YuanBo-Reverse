package w2;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import q2.e;
import q2.s;
import q2.x;
import q2.y;

/* loaded from: classes.dex */
final class a extends x<Date> {

    /* renamed from: b, reason: collision with root package name */
    static final y f10214b = new C0157a();

    /* renamed from: a, reason: collision with root package name */
    private final DateFormat f10215a;

    /* renamed from: w2.a$a, reason: collision with other inner class name */
    class C0157a implements y {
        C0157a() {
        }

        @Override // q2.y
        public <T> x<T> a(e eVar, x2.a<T> aVar) {
            C0157a c0157a = null;
            if (aVar.c() == Date.class) {
                return new a(c0157a);
            }
            return null;
        }
    }

    private a() {
        this.f10215a = new SimpleDateFormat("MMM d, yyyy");
    }

    /* synthetic */ a(C0157a c0157a) {
        this();
    }

    @Override // q2.x
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public Date b(y2.a aVar) {
        java.util.Date parse;
        if (aVar.g0() == y2.b.NULL) {
            aVar.c0();
            return null;
        }
        String e02 = aVar.e0();
        try {
            synchronized (this) {
                parse = this.f10215a.parse(e02);
            }
            return new Date(parse.getTime());
        } catch (ParseException e6) {
            throw new s("Failed parsing '" + e02 + "' as SQL Date; at path " + aVar.I(), e6);
        }
    }

    @Override // q2.x
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void d(y2.c cVar, Date date) {
        String format;
        if (date == null) {
            cVar.V();
            return;
        }
        synchronized (this) {
            format = this.f10215a.format((java.util.Date) date);
        }
        cVar.j0(format);
    }
}
