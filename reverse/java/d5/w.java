package d5;

import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    private final String f3230a;

    /* renamed from: b, reason: collision with root package name */
    private final String f3231b;

    /* renamed from: c, reason: collision with root package name */
    private final String f3232c;

    /* renamed from: d, reason: collision with root package name */
    private final String[] f3233d;

    /* renamed from: g, reason: collision with root package name */
    public static final a f3229g = new a(null);

    /* renamed from: e, reason: collision with root package name */
    private static final Pattern f3227e = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* renamed from: f, reason: collision with root package name */
    private static final Pattern f3228f = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final w a(String toMediaType) {
            kotlin.jvm.internal.k.e(toMediaType, "$this$toMediaType");
            Matcher matcher = w.f3227e.matcher(toMediaType);
            if (!matcher.lookingAt()) {
                throw new IllegalArgumentException(("No subtype found for: \"" + toMediaType + '\"').toString());
            }
            String group = matcher.group(1);
            kotlin.jvm.internal.k.d(group, "typeSubtype.group(1)");
            Locale locale = Locale.US;
            kotlin.jvm.internal.k.d(locale, "Locale.US");
            if (group == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase = group.toLowerCase(locale);
            kotlin.jvm.internal.k.d(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            String group2 = matcher.group(2);
            kotlin.jvm.internal.k.d(group2, "typeSubtype.group(2)");
            kotlin.jvm.internal.k.d(locale, "Locale.US");
            if (group2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase2 = group2.toLowerCase(locale);
            kotlin.jvm.internal.k.d(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
            ArrayList arrayList = new ArrayList();
            Matcher matcher2 = w.f3228f.matcher(toMediaType);
            for (int end = matcher.end(); end < toMediaType.length(); end = matcher2.end()) {
                matcher2.region(end, toMediaType.length());
                if (!matcher2.lookingAt()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Parameter is not formatted correctly: \"");
                    String substring = toMediaType.substring(end);
                    kotlin.jvm.internal.k.d(substring, "(this as java.lang.String).substring(startIndex)");
                    sb.append(substring);
                    sb.append("\" for: \"");
                    sb.append(toMediaType);
                    sb.append('\"');
                    throw new IllegalArgumentException(sb.toString().toString());
                }
                String group3 = matcher2.group(1);
                if (group3 != null) {
                    String group4 = matcher2.group(2);
                    if (group4 == null) {
                        group4 = matcher2.group(3);
                    } else if (v4.p.A(group4, "'", false, 2, null) && v4.p.n(group4, "'", false, 2, null) && group4.length() > 2) {
                        group4 = group4.substring(1, group4.length() - 1);
                        kotlin.jvm.internal.k.d(group4, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    }
                    arrayList.add(group3);
                    arrayList.add(group4);
                }
            }
            Object[] array = arrayList.toArray(new String[0]);
            if (array != null) {
                return new w(toMediaType, lowerCase, lowerCase2, (String[]) array, null);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
    }

    private w(String str, String str2, String str3, String[] strArr) {
        this.f3230a = str;
        this.f3231b = str2;
        this.f3232c = str3;
        this.f3233d = strArr;
    }

    public /* synthetic */ w(String str, String str2, String str3, String[] strArr, kotlin.jvm.internal.g gVar) {
        this(str, str2, str3, strArr);
    }

    public boolean equals(Object obj) {
        return (obj instanceof w) && kotlin.jvm.internal.k.a(((w) obj).f3230a, this.f3230a);
    }

    public int hashCode() {
        return this.f3230a.hashCode();
    }

    public String toString() {
        return this.f3230a;
    }
}
