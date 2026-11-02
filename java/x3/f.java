package x3;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
import y3.k;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public final y3.k f10489a;

    /* renamed from: b, reason: collision with root package name */
    private b f10490b;

    /* renamed from: c, reason: collision with root package name */
    public final k.c f10491c;

    class a implements k.c {
        a() {
        }

        @Override // y3.k.c
        public void e(y3.j jVar, k.d dVar) {
            if (f.this.f10490b == null) {
                return;
            }
            String str = jVar.f11100a;
            str.hashCode();
            if (!str.equals("Localization.getStringResource")) {
                dVar.c();
                return;
            }
            JSONObject jSONObject = (JSONObject) jVar.b();
            try {
                dVar.b(f.this.f10490b.a(jSONObject.getString("key"), jSONObject.has("locale") ? jSONObject.getString("locale") : null));
            } catch (JSONException e6) {
                dVar.a("error", e6.getMessage(), null);
            }
        }
    }

    public interface b {
        String a(String str, String str2);
    }

    public f(m3.a aVar) {
        a aVar2 = new a();
        this.f10491c = aVar2;
        y3.k kVar = new y3.k(aVar, "flutter/localization", y3.g.f11099a);
        this.f10489a = kVar;
        kVar.e(aVar2);
    }

    public void b(List<Locale> list) {
        k3.b.f("LocalizationChannel", "Sending Locales to Flutter.");
        ArrayList arrayList = new ArrayList();
        for (Locale locale : list) {
            k3.b.f("LocalizationChannel", "Locale (Language: " + locale.getLanguage() + ", Country: " + locale.getCountry() + ", Variant: " + locale.getVariant() + ")");
            arrayList.add(locale.getLanguage());
            arrayList.add(locale.getCountry());
            arrayList.add(locale.getScript());
            arrayList.add(locale.getVariant());
        }
        this.f10489a.c("setLocale", arrayList);
    }

    public void c(b bVar) {
        this.f10490b = bVar;
    }
}
