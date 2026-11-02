package h2;

import i2.c1;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
final class v extends j {

    /* renamed from: k, reason: collision with root package name */
    private static final Pattern f5229k = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v1\\.exo$", 32);

    /* renamed from: l, reason: collision with root package name */
    private static final Pattern f5230l = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v2\\.exo$", 32);

    /* renamed from: m, reason: collision with root package name */
    private static final Pattern f5231m = Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)\\.v3\\.exo$", 32);

    private v(String str, long j6, long j7, long j8, File file) {
        super(str, j6, j7, j8, file);
    }

    public static v e(File file, long j6, long j7, m mVar) {
        File file2;
        String k6;
        String name = file.getName();
        if (name.endsWith(".v3.exo")) {
            file2 = file;
        } else {
            File j8 = j(file, mVar);
            if (j8 == null) {
                return null;
            }
            file2 = j8;
            name = j8.getName();
        }
        Matcher matcher = f5231m.matcher(name);
        if (!matcher.matches() || (k6 = mVar.k(Integer.parseInt((String) i2.a.e(matcher.group(1))))) == null) {
            return null;
        }
        long length = j6 == -1 ? file2.length() : j6;
        if (length == 0) {
            return null;
        }
        return new v(k6, Long.parseLong((String) i2.a.e(matcher.group(2))), length, j7 == -9223372036854775807L ? Long.parseLong((String) i2.a.e(matcher.group(3))) : j7, file2);
    }

    public static v f(File file, long j6, m mVar) {
        return e(file, j6, -9223372036854775807L, mVar);
    }

    public static v g(String str, long j6, long j7) {
        return new v(str, j6, j7, -9223372036854775807L, null);
    }

    public static v h(String str, long j6) {
        return new v(str, j6, -1L, -9223372036854775807L, null);
    }

    public static File i(File file, int i6, long j6, long j7) {
        return new File(file, i6 + "." + j6 + "." + j7 + ".v3.exo");
    }

    private static File j(File file, m mVar) {
        String str;
        String name = file.getName();
        Matcher matcher = f5230l.matcher(name);
        if (matcher.matches()) {
            str = c1.d1((String) i2.a.e(matcher.group(1)));
        } else {
            matcher = f5229k.matcher(name);
            str = matcher.matches() ? (String) i2.a.e(matcher.group(1)) : null;
        }
        if (str == null) {
            return null;
        }
        File i6 = i((File) i2.a.i(file.getParentFile()), mVar.f(str), Long.parseLong((String) i2.a.e(matcher.group(2))), Long.parseLong((String) i2.a.e(matcher.group(3))));
        if (file.renameTo(i6)) {
            return i6;
        }
        return null;
    }

    public v d(File file, long j6) {
        i2.a.g(this.f5168d);
        return new v(this.f5165a, this.f5166b, this.f5167c, j6, file);
    }
}
