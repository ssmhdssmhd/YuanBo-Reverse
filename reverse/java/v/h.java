package v;

import java.util.List;

/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    private static final String f9710a = j.f("InputMerger");

    public static h a(String str) {
        try {
            return (h) Class.forName(str).newInstance();
        } catch (Exception e6) {
            j.c().b(f9710a, "Trouble instantiating + " + str, e6);
            return null;
        }
    }

    public abstract androidx.work.b b(List<androidx.work.b> list);
}
