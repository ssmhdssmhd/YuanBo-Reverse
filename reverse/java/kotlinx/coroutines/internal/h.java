package kotlinx.coroutines.internal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f7044a = new h();

    private h() {
    }

    private final <S> S a(String str, ClassLoader classLoader, Class<S> cls) {
        Class<?> cls2 = Class.forName(str, false, classLoader);
        if (cls.isAssignableFrom(cls2)) {
            return cls.cast(cls2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        }
        throw new IllegalArgumentException(("Expected service of class " + cls + ", but found " + cls2).toString());
    }

    private final <S> List<S> b(Class<S> cls, ClassLoader classLoader) {
        try {
            return d(cls, classLoader);
        } catch (Throwable unused) {
            return f4.t.H(ServiceLoader.load(cls, classLoader));
        }
    }

    private final List<String> e(URL url) {
        BufferedReader bufferedReader;
        String s02;
        String x02;
        String s03;
        String url2 = url.toString();
        if (!v4.p.A(url2, "jar", false, 2, null)) {
            bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            try {
                List<String> f6 = f7044a.f(bufferedReader);
                m4.b.a(bufferedReader, null);
                return f6;
            } catch (Throwable th) {
                try {
                    throw th;
                } finally {
                }
            }
        }
        s02 = v4.q.s0(url2, "jar:file:", null, 2, null);
        x02 = v4.q.x0(s02, '!', null, 2, null);
        s03 = v4.q.s0(url2, "!/", null, 2, null);
        JarFile jarFile = new JarFile(x02, false);
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(jarFile.getInputStream(new ZipEntry(s03)), "UTF-8"));
            try {
                List<String> f7 = f7044a.f(bufferedReader);
                m4.b.a(bufferedReader, null);
                jarFile.close();
                return f7;
            } finally {
            }
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                try {
                    jarFile.close();
                    throw th3;
                } catch (Throwable th4) {
                    e4.b.a(th2, th4);
                    throw th2;
                }
            }
        }
    }

    private final List<String> f(BufferedReader bufferedReader) {
        String y02;
        CharSequence z02;
        boolean z5;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return f4.t.H(linkedHashSet);
            }
            y02 = v4.q.y0(readLine, "#", null, 2, null);
            z02 = v4.q.z0(y02);
            String obj = z02.toString();
            int i6 = 0;
            while (true) {
                if (i6 >= obj.length()) {
                    z5 = true;
                    break;
                }
                char charAt = obj.charAt(i6);
                i6++;
                if (!(charAt == '.' || Character.isJavaIdentifierPart(charAt))) {
                    z5 = false;
                    break;
                }
            }
            if (!z5) {
                throw new IllegalArgumentException(kotlin.jvm.internal.k.j("Illegal service provider class name: ", obj).toString());
            }
            if (obj.length() > 0) {
                linkedHashSet.add(obj);
            }
        }
    }

    public final List<r> c() {
        r rVar;
        if (!i.a()) {
            return b(r.class, r.class.getClassLoader());
        }
        try {
            ArrayList arrayList = new ArrayList(2);
            r rVar2 = null;
            try {
                rVar = (r) r.class.cast(Class.forName("kotlinx.coroutines.android.AndroidDispatcherFactory", true, r.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (ClassNotFoundException unused) {
                rVar = null;
            }
            if (rVar != null) {
                arrayList.add(rVar);
            }
            try {
                rVar2 = (r) r.class.cast(Class.forName("kotlinx.coroutines.test.internal.TestMainDispatcherFactory", true, r.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (ClassNotFoundException unused2) {
            }
            if (rVar2 == null) {
                return arrayList;
            }
            arrayList.add(rVar2);
            return arrayList;
        } catch (Throwable unused3) {
            return b(r.class, r.class.getClassLoader());
        }
    }

    public final <S> List<S> d(Class<S> cls, ClassLoader classLoader) {
        Set K;
        int n6;
        ArrayList list = Collections.list(classLoader.getResources(kotlin.jvm.internal.k.j("META-INF/services/", cls.getName())));
        kotlin.jvm.internal.k.d(list, "list(this)");
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            f4.q.p(arrayList, f7044a.e((URL) it.next()));
        }
        K = f4.t.K(arrayList);
        if (!(!K.isEmpty())) {
            throw new IllegalArgumentException("No providers were loaded with FastServiceLoader".toString());
        }
        n6 = f4.m.n(K, 10);
        ArrayList arrayList2 = new ArrayList(n6);
        Iterator it2 = K.iterator();
        while (it2.hasNext()) {
            arrayList2.add(f7044a.a((String) it2.next(), classLoader, cls));
        }
        return arrayList2;
    }
}
