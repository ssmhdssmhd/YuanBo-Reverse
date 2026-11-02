package z3;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;
import java.util.ArrayList;
import java.util.Locale;
import x3.f;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private final f f11336a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f11337b;

    /* renamed from: c, reason: collision with root package name */
    final f.b f11338c;

    class a implements f.b {
        a() {
        }

        @Override // x3.f.b
        public String a(String str, String str2) {
            Context context = d.this.f11337b;
            if (str2 != null) {
                Locale b6 = d.b(str2);
                Configuration configuration = new Configuration(d.this.f11337b.getResources().getConfiguration());
                configuration.setLocale(b6);
                context = d.this.f11337b.createConfigurationContext(configuration);
            }
            int identifier = context.getResources().getIdentifier(str, "string", d.this.f11337b.getPackageName());
            if (identifier != 0) {
                return context.getResources().getString(identifier);
            }
            return null;
        }
    }

    public d(Context context, f fVar) {
        a aVar = new a();
        this.f11338c = aVar;
        this.f11337b = context;
        this.f11336a = fVar;
        fVar.c(aVar);
    }

    public static Locale b(String str) {
        String str2;
        String[] split = str.replace('_', '-').split("-", -1);
        String str3 = split[0];
        String str4 = "";
        int i6 = 1;
        if (split.length <= 1 || split[1].length() != 4) {
            str2 = "";
        } else {
            str2 = split[1];
            i6 = 2;
        }
        if (split.length > i6 && split[i6].length() >= 2 && split[i6].length() <= 3) {
            str4 = split[i6];
        }
        return new Locale(str3, str4, str2);
    }

    /* JADX WARN: Incorrect condition in loop: B:28:0x00ce */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.Locale c(java.util.List<java.util.Locale> r10) {
        /*
            Method dump skipped, instructions count: 370
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z3.d.c(java.util.List):java.util.Locale");
    }

    public void d(Configuration configuration) {
        LocaleList locales;
        int size;
        Locale locale;
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 24) {
            locales = configuration.getLocales();
            size = locales.size();
            for (int i6 = 0; i6 < size; i6++) {
                locale = locales.get(i6);
                arrayList.add(locale);
            }
        } else {
            arrayList.add(configuration.locale);
        }
        this.f11336a.b(arrayList);
    }
}
