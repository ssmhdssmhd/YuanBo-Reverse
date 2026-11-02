package q2;

import java.lang.reflect.Field;
import java.util.Locale;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public abstract class c implements q2.d {

    /* renamed from: a, reason: collision with root package name */
    public static final c f8852a = new a("IDENTITY", 0);

    /* renamed from: b, reason: collision with root package name */
    public static final c f8853b = new c("UPPER_CAMEL_CASE", 1) { // from class: q2.c.b
        {
            a aVar = null;
        }

        @Override // q2.d
        public String a(Field field) {
            return c.d(field.getName());
        }
    };

    /* renamed from: c, reason: collision with root package name */
    public static final c f8854c = new c("UPPER_CAMEL_CASE_WITH_SPACES", 2) { // from class: q2.c.c
        {
            a aVar = null;
        }

        @Override // q2.d
        public String a(Field field) {
            return c.d(c.c(field.getName(), ' '));
        }
    };

    /* renamed from: d, reason: collision with root package name */
    public static final c f8855d = new c("UPPER_CASE_WITH_UNDERSCORES", 3) { // from class: q2.c.d
        {
            a aVar = null;
        }

        @Override // q2.d
        public String a(Field field) {
            return c.c(field.getName(), '_').toUpperCase(Locale.ENGLISH);
        }
    };

    /* renamed from: e, reason: collision with root package name */
    public static final c f8856e = new c("LOWER_CASE_WITH_UNDERSCORES", 4) { // from class: q2.c.e
        {
            a aVar = null;
        }

        @Override // q2.d
        public String a(Field field) {
            return c.c(field.getName(), '_').toLowerCase(Locale.ENGLISH);
        }
    };

    /* renamed from: j, reason: collision with root package name */
    public static final c f8857j = new c("LOWER_CASE_WITH_DASHES", 5) { // from class: q2.c.f
        {
            a aVar = null;
        }

        @Override // q2.d
        public String a(Field field) {
            return c.c(field.getName(), '-').toLowerCase(Locale.ENGLISH);
        }
    };

    /* renamed from: k, reason: collision with root package name */
    public static final c f8858k = new c("LOWER_CASE_WITH_DOTS", 6) { // from class: q2.c.g
        {
            a aVar = null;
        }

        @Override // q2.d
        public String a(Field field) {
            return c.c(field.getName(), '.').toLowerCase(Locale.ENGLISH);
        }
    };

    /* renamed from: l, reason: collision with root package name */
    private static final /* synthetic */ c[] f8859l = b();

    enum a extends c {
        a(String str, int i6) {
            super(str, i6, null);
        }

        @Override // q2.d
        public String a(Field field) {
            return field.getName();
        }
    }

    private c(String str, int i6) {
    }

    /* synthetic */ c(String str, int i6, a aVar) {
        this(str, i6);
    }

    private static /* synthetic */ c[] b() {
        return new c[]{f8852a, f8853b, f8854c, f8855d, f8856e, f8857j, f8858k};
    }

    static String c(String str, char c6) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i6 = 0; i6 < length; i6++) {
            char charAt = str.charAt(i6);
            if (Character.isUpperCase(charAt) && sb.length() != 0) {
                sb.append(c6);
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    static String d(String str) {
        int length = str.length();
        for (int i6 = 0; i6 < length; i6++) {
            char charAt = str.charAt(i6);
            if (Character.isLetter(charAt)) {
                if (Character.isUpperCase(charAt)) {
                    return str;
                }
                char upperCase = Character.toUpperCase(charAt);
                if (i6 == 0) {
                    return upperCase + str.substring(1);
                }
                return str.substring(0, i6) + upperCase + str.substring(i6 + 1);
            }
        }
        return str;
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) f8859l.clone();
    }
}
