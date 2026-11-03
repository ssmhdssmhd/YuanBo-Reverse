package d5;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, String> f3079a;

    /* renamed from: b, reason: collision with root package name */
    private final String f3080b;

    public g(String scheme, Map<String, String> authParams) {
        String str;
        kotlin.jvm.internal.k.e(scheme, "scheme");
        kotlin.jvm.internal.k.e(authParams, "authParams");
        this.f3080b = scheme;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, String> entry : authParams.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key != null) {
                Locale US = Locale.US;
                kotlin.jvm.internal.k.d(US, "US");
                str = key.toLowerCase(US);
                kotlin.jvm.internal.k.d(str, "(this as java.lang.String).toLowerCase(locale)");
            } else {
                str = null;
            }
            linkedHashMap.put(str, value);
        }
        Map<String, String> unmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        kotlin.jvm.internal.k.d(unmodifiableMap, "unmodifiableMap<String?, String>(newAuthParams)");
        this.f3079a = unmodifiableMap;
    }

    public final Charset a() {
        String str = this.f3079a.get("charset");
        if (str != null) {
            try {
                Charset forName = Charset.forName(str);
                kotlin.jvm.internal.k.d(forName, "Charset.forName(charset)");
                return forName;
            } catch (Exception unused) {
            }
        }
        Charset ISO_8859_1 = StandardCharsets.ISO_8859_1;
        kotlin.jvm.internal.k.d(ISO_8859_1, "ISO_8859_1");
        return ISO_8859_1;
    }

    public final String b() {
        return this.f3079a.get("realm");
    }

    public final String c() {
        return this.f3080b;
    }

    public boolean equals(Object obj) {
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (kotlin.jvm.internal.k.a(gVar.f3080b, this.f3080b) && kotlin.jvm.internal.k.a(gVar.f3079a, this.f3079a)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((899 + this.f3080b.hashCode()) * 31) + this.f3079a.hashCode();
    }

    public String toString() {
        return this.f3080b + " authParams=" + this.f3079a;
    }
}
