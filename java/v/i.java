package v;

/* loaded from: classes.dex */
public abstract class i {

    class a extends i {
        a() {
        }

        @Override // v.i
        public h a(String str) {
            return null;
        }
    }

    public static i c() {
        return new a();
    }

    public abstract h a(String str);

    public final h b(String str) {
        h a6 = a(str);
        return a6 == null ? h.a(str) : a6;
    }
}
