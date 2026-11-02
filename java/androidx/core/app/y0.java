package androidx.core.app;

import android.app.Person;
import android.graphics.drawable.Icon;
import androidx.core.graphics.drawable.IconCompat;

/* loaded from: classes.dex */
public class y0 {

    /* renamed from: a, reason: collision with root package name */
    CharSequence f398a;

    /* renamed from: b, reason: collision with root package name */
    IconCompat f399b;

    /* renamed from: c, reason: collision with root package name */
    String f400c;

    /* renamed from: d, reason: collision with root package name */
    String f401d;

    /* renamed from: e, reason: collision with root package name */
    boolean f402e;

    /* renamed from: f, reason: collision with root package name */
    boolean f403f;

    static class a {
        static y0 a(Person person) {
            CharSequence name;
            Icon icon;
            IconCompat iconCompat;
            String uri;
            String key;
            boolean isBot;
            boolean isImportant;
            Icon icon2;
            b bVar = new b();
            name = person.getName();
            b f6 = bVar.f(name);
            icon = person.getIcon();
            if (icon != null) {
                icon2 = person.getIcon();
                iconCompat = IconCompat.a(icon2);
            } else {
                iconCompat = null;
            }
            b c6 = f6.c(iconCompat);
            uri = person.getUri();
            b g6 = c6.g(uri);
            key = person.getKey();
            b e6 = g6.e(key);
            isBot = person.isBot();
            b b6 = e6.b(isBot);
            isImportant = person.isImportant();
            return b6.d(isImportant).a();
        }

        static Person b(y0 y0Var) {
            Person.Builder name;
            Person.Builder icon;
            Person.Builder uri;
            Person.Builder key;
            Person.Builder bot;
            Person.Builder important;
            Person build;
            name = new Person.Builder().setName(y0Var.c());
            icon = name.setIcon(y0Var.a() != null ? y0Var.a().o() : null);
            uri = icon.setUri(y0Var.d());
            key = uri.setKey(y0Var.b());
            bot = key.setBot(y0Var.e());
            important = bot.setImportant(y0Var.f());
            build = important.build();
            return build;
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        CharSequence f404a;

        /* renamed from: b, reason: collision with root package name */
        IconCompat f405b;

        /* renamed from: c, reason: collision with root package name */
        String f406c;

        /* renamed from: d, reason: collision with root package name */
        String f407d;

        /* renamed from: e, reason: collision with root package name */
        boolean f408e;

        /* renamed from: f, reason: collision with root package name */
        boolean f409f;

        public y0 a() {
            return new y0(this);
        }

        public b b(boolean z5) {
            this.f408e = z5;
            return this;
        }

        public b c(IconCompat iconCompat) {
            this.f405b = iconCompat;
            return this;
        }

        public b d(boolean z5) {
            this.f409f = z5;
            return this;
        }

        public b e(String str) {
            this.f407d = str;
            return this;
        }

        public b f(CharSequence charSequence) {
            this.f404a = charSequence;
            return this;
        }

        public b g(String str) {
            this.f406c = str;
            return this;
        }
    }

    y0(b bVar) {
        this.f398a = bVar.f404a;
        this.f399b = bVar.f405b;
        this.f400c = bVar.f406c;
        this.f401d = bVar.f407d;
        this.f402e = bVar.f408e;
        this.f403f = bVar.f409f;
    }

    public IconCompat a() {
        return this.f399b;
    }

    public String b() {
        return this.f401d;
    }

    public CharSequence c() {
        return this.f398a;
    }

    public String d() {
        return this.f400c;
    }

    public boolean e() {
        return this.f402e;
    }

    public boolean f() {
        return this.f403f;
    }

    public String g() {
        String str = this.f400c;
        if (str != null) {
            return str;
        }
        if (this.f398a == null) {
            return "";
        }
        return "name:" + ((Object) this.f398a);
    }

    public Person h() {
        return a.b(this);
    }
}
