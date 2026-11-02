package w2;

import java.sql.Timestamp;
import java.util.Date;
import q2.y;
import t2.d;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f10220a;

    /* renamed from: b, reason: collision with root package name */
    public static final d.b<? extends Date> f10221b;

    /* renamed from: c, reason: collision with root package name */
    public static final d.b<? extends Date> f10222c;

    /* renamed from: d, reason: collision with root package name */
    public static final y f10223d;

    /* renamed from: e, reason: collision with root package name */
    public static final y f10224e;

    /* renamed from: f, reason: collision with root package name */
    public static final y f10225f;

    class a extends d.b<java.sql.Date> {
        a(Class cls) {
            super(cls);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // t2.d.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public java.sql.Date d(Date date) {
            return new java.sql.Date(date.getTime());
        }
    }

    class b extends d.b<Timestamp> {
        b(Class cls) {
            super(cls);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // t2.d.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Timestamp d(Date date) {
            return new Timestamp(date.getTime());
        }
    }

    static {
        boolean z5;
        y yVar;
        try {
            Class.forName("java.sql.Date");
            z5 = true;
        } catch (ClassNotFoundException unused) {
            z5 = false;
        }
        f10220a = z5;
        if (z5) {
            f10221b = new a(java.sql.Date.class);
            f10222c = new b(Timestamp.class);
            f10223d = w2.a.f10214b;
            f10224e = w2.b.f10216b;
            yVar = c.f10218b;
        } else {
            yVar = null;
            f10221b = null;
            f10222c = null;
            f10223d = null;
            f10224e = null;
        }
        f10225f = yVar;
    }
}
