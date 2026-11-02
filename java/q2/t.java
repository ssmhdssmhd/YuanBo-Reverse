package q2;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public abstract class t {

    /* renamed from: a, reason: collision with root package name */
    public static final t f8915a = new a("DEFAULT", 0);

    /* renamed from: b, reason: collision with root package name */
    public static final t f8916b = new t("STRING", 1) { // from class: q2.t.b
        {
            a aVar = null;
        }
    };

    /* renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ t[] f8917c = a();

    enum a extends t {
        a(String str, int i6) {
            super(str, i6, null);
        }
    }

    private t(String str, int i6) {
    }

    /* synthetic */ t(String str, int i6, a aVar) {
        this(str, i6);
    }

    private static /* synthetic */ t[] a() {
        return new t[]{f8915a, f8916b};
    }

    public static t valueOf(String str) {
        return (t) Enum.valueOf(t.class, str);
    }

    public static t[] values() {
        return (t[]) f8917c.clone();
    }
}
