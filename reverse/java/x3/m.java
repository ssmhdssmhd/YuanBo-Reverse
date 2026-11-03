package x3;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    public final y3.a<Object> f10599a;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final y3.a<Object> f10600a;

        /* renamed from: b, reason: collision with root package name */
        private Map<String, Object> f10601b = new HashMap();

        a(y3.a<Object> aVar) {
            this.f10600a = aVar;
        }

        public void a() {
            k3.b.f("SettingsChannel", "Sending message: \ntextScaleFactor: " + this.f10601b.get("textScaleFactor") + "\nalwaysUse24HourFormat: " + this.f10601b.get("alwaysUse24HourFormat") + "\nplatformBrightness: " + this.f10601b.get("platformBrightness"));
            this.f10600a.c(this.f10601b);
        }

        public a b(boolean z5) {
            this.f10601b.put("brieflyShowPassword", Boolean.valueOf(z5));
            return this;
        }

        public a c(boolean z5) {
            this.f10601b.put("nativeSpellCheckServiceDefined", Boolean.valueOf(z5));
            return this;
        }

        public a d(b bVar) {
            this.f10601b.put("platformBrightness", bVar.f10605a);
            return this;
        }

        public a e(float f6) {
            this.f10601b.put("textScaleFactor", Float.valueOf(f6));
            return this;
        }

        public a f(boolean z5) {
            this.f10601b.put("alwaysUse24HourFormat", Boolean.valueOf(z5));
            return this;
        }
    }

    public enum b {
        light("light"),
        dark("dark");


        /* renamed from: a, reason: collision with root package name */
        public String f10605a;

        b(String str) {
            this.f10605a = str;
        }
    }

    public m(m3.a aVar) {
        this.f10599a = new y3.a<>(aVar, "flutter/settings", y3.f.f11098a);
    }

    public a a() {
        return new a(this.f10599a);
    }
}
