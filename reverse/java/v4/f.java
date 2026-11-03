package v4;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class f implements Serializable {

    /* renamed from: b, reason: collision with root package name */
    public static final a f9896b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final Pattern f9897a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public f(java.lang.String r2) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            kotlin.jvm.internal.k.e(r2, r0)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2)
            java.lang.String r0 = "compile(pattern)"
            kotlin.jvm.internal.k.d(r2, r0)
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: v4.f.<init>(java.lang.String):void");
    }

    public f(Pattern nativePattern) {
        kotlin.jvm.internal.k.e(nativePattern, "nativePattern");
        this.f9897a = nativePattern;
    }

    public final boolean a(CharSequence input) {
        kotlin.jvm.internal.k.e(input, "input");
        return this.f9897a.matcher(input).matches();
    }

    public final String b(CharSequence input, String replacement) {
        kotlin.jvm.internal.k.e(input, "input");
        kotlin.jvm.internal.k.e(replacement, "replacement");
        String replaceAll = this.f9897a.matcher(input).replaceAll(replacement);
        kotlin.jvm.internal.k.d(replaceAll, "nativePattern.matcher(in…).replaceAll(replacement)");
        return replaceAll;
    }

    public final List<String> c(CharSequence input, int i6) {
        kotlin.jvm.internal.k.e(input, "input");
        q.g0(i6);
        Matcher matcher = this.f9897a.matcher(input);
        if (i6 == 1 || !matcher.find()) {
            return f4.k.b(input.toString());
        }
        ArrayList arrayList = new ArrayList(i6 > 0 ? s4.f.d(i6, 10) : 10);
        int i7 = i6 - 1;
        int i8 = 0;
        do {
            arrayList.add(input.subSequence(i8, matcher.start()).toString());
            i8 = matcher.end();
            if (i7 >= 0 && arrayList.size() == i7) {
                break;
            }
        } while (matcher.find());
        arrayList.add(input.subSequence(i8, input.length()).toString());
        return arrayList;
    }

    public String toString() {
        String pattern = this.f9897a.toString();
        kotlin.jvm.internal.k.d(pattern, "nativePattern.toString()");
        return pattern;
    }
}
