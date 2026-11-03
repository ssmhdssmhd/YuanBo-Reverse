package b4;

import android.content.Context;
import android.util.Log;
import b4.h;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import q3.a;

/* loaded from: classes.dex */
public class i implements q3.a, h.a {

    /* renamed from: a, reason: collision with root package name */
    private Context f1803a;

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f1804a;

        static {
            int[] iArr = new int[h.c.values().length];
            f1804a = iArr;
            try {
                iArr[h.c.root.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1804a[h.c.music.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1804a[h.c.podcasts.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1804a[h.c.ringtones.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1804a[h.c.alarms.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1804a[h.c.notifications.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1804a[h.c.pictures.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f1804a[h.c.movies.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f1804a[h.c.downloads.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f1804a[h.c.dcim.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f1804a[h.c.documents.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    private String h() {
        return d4.c.d(this.f1803a);
    }

    private String i() {
        return d4.c.c(this.f1803a);
    }

    private List<String> k() {
        ArrayList arrayList = new ArrayList();
        for (File file : this.f1803a.getExternalCacheDirs()) {
            if (file != null) {
                arrayList.add(file.getAbsolutePath());
            }
        }
        return arrayList;
    }

    private List<String> l(h.c cVar) {
        ArrayList arrayList = new ArrayList();
        for (File file : this.f1803a.getExternalFilesDirs(o(cVar))) {
            if (file != null) {
                arrayList.add(file.getAbsolutePath());
            }
        }
        return arrayList;
    }

    private String m() {
        File externalFilesDir = this.f1803a.getExternalFilesDir(null);
        if (externalFilesDir == null) {
            return null;
        }
        return externalFilesDir.getAbsolutePath();
    }

    private String n() {
        return this.f1803a.getCacheDir().getPath();
    }

    private String o(h.c cVar) {
        switch (a.f1804a[cVar.ordinal()]) {
            case 1:
                return null;
            case 2:
                return "music";
            case 3:
                return "podcasts";
            case 4:
                return "ringtones";
            case 5:
                return "alarms";
            case 6:
                return "notifications";
            case 7:
                return "pictures";
            case 8:
                return "movies";
            case 9:
                return "downloads";
            case 10:
                return "dcim";
            case 11:
                return "documents";
            default:
                throw new RuntimeException("Unrecognized directory: " + cVar);
        }
    }

    private void p(y3.c cVar, Context context) {
        cVar.d();
        try {
            g.h(cVar, this);
        } catch (Exception e6) {
            Log.e("PathProviderPlugin", "Received exception while setting up PathProviderPlugin", e6);
        }
        this.f1803a = context;
    }

    @Override // b4.h.a
    public String a() {
        return n();
    }

    @Override // q3.a
    public void b(a.b bVar) {
        p(bVar.b(), bVar.a());
    }

    @Override // b4.h.a
    public String c() {
        return i();
    }

    @Override // b4.h.a
    public List<String> d() {
        return k();
    }

    @Override // b4.h.a
    public String e() {
        return h();
    }

    @Override // b4.h.a
    public String f() {
        return m();
    }

    @Override // b4.h.a
    public List<String> g(h.c cVar) {
        return l(cVar);
    }

    @Override // q3.a
    public void j(a.b bVar) {
        g.h(bVar.b(), null);
    }
}
