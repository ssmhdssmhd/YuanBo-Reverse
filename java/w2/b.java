package w2;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import q2.e;
import q2.s;
import q2.x;
import q2.y;

/* loaded from: classes.dex */
final class b extends x<Time> {

    /* renamed from: b, reason: collision with root package name */
    static final y f10216b = new a();

    /* renamed from: a, reason: collision with root package name */
    private final DateFormat f10217a;

    class a implements y {
        a() {
        }

        @Override // q2.y
        public <T> x<T> a(e eVar, x2.a<T> aVar) {
            a aVar2 = null;
            if (aVar.c() == Time.class) {
                return new b(aVar2);
            }
            return null;
        }
    }

    private b() {
        this.f10217a = new SimpleDateFormat("hh:mm:ss a");
    }

    /* synthetic */ b(a aVar) {
        this();
    }

    @Override // q2.x
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public Time b(y2.a aVar) {
        Time time;
        if (aVar.g0() == y2.b.NULL) {
            aVar.c0();
            return null;
        }
        String e02 = aVar.e0();
        try {
            synchronized (this) {
                time = new Time(this.f10217a.parse(e02).getTime());
            }
            return time;
        } catch (ParseException e6) {
            throw new s("Failed parsing '" + e02 + "' as SQL Time; at path " + aVar.I(), e6);
        }
    }

    @Override // q2.x
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void d(y2.c cVar, Time time) {
        String format;
        if (time == null) {
            cVar.V();
            return;
        }
        synchronized (this) {
            format = this.f10217a.format((Date) time);
        }
        cVar.j0(format);
    }
}
