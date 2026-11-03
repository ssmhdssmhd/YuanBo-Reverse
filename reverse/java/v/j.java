package v;

import android.util.Log;

/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    private static j f9711a = null;

    /* renamed from: b, reason: collision with root package name */
    private static final int f9712b = 20;

    public static class a extends j {

        /* renamed from: c, reason: collision with root package name */
        private int f9713c;

        public a(int i6) {
            super(i6);
            this.f9713c = i6;
        }

        @Override // v.j
        public void a(String str, String str2, Throwable... thArr) {
            if (this.f9713c <= 3) {
                if (thArr == null || thArr.length < 1) {
                    Log.d(str, str2);
                } else {
                    Log.d(str, str2, thArr[0]);
                }
            }
        }

        @Override // v.j
        public void b(String str, String str2, Throwable... thArr) {
            if (this.f9713c <= 6) {
                if (thArr == null || thArr.length < 1) {
                    Log.e(str, str2);
                } else {
                    Log.e(str, str2, thArr[0]);
                }
            }
        }

        @Override // v.j
        public void d(String str, String str2, Throwable... thArr) {
            if (this.f9713c <= 4) {
                if (thArr == null || thArr.length < 1) {
                    Log.i(str, str2);
                } else {
                    Log.i(str, str2, thArr[0]);
                }
            }
        }

        @Override // v.j
        public void g(String str, String str2, Throwable... thArr) {
            if (this.f9713c <= 2) {
                if (thArr == null || thArr.length < 1) {
                    Log.v(str, str2);
                } else {
                    Log.v(str, str2, thArr[0]);
                }
            }
        }

        @Override // v.j
        public void h(String str, String str2, Throwable... thArr) {
            if (this.f9713c <= 5) {
                if (thArr == null || thArr.length < 1) {
                    Log.w(str, str2);
                } else {
                    Log.w(str, str2, thArr[0]);
                }
            }
        }
    }

    public j(int i6) {
    }

    public static synchronized j c() {
        j jVar;
        synchronized (j.class) {
            if (f9711a == null) {
                f9711a = new a(3);
            }
            jVar = f9711a;
        }
        return jVar;
    }

    public static synchronized void e(j jVar) {
        synchronized (j.class) {
            f9711a = jVar;
        }
    }

    public static String f(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(23);
        sb.append("WM-");
        int i6 = f9712b;
        if (length >= i6) {
            str = str.substring(0, i6);
        }
        sb.append(str);
        return sb.toString();
    }

    public abstract void a(String str, String str2, Throwable... thArr);

    public abstract void b(String str, String str2, Throwable... thArr);

    public abstract void d(String str, String str2, Throwable... thArr);

    public abstract void g(String str, String str2, Throwable... thArr);

    public abstract void h(String str, String str2, Throwable... thArr);
}
