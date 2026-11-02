package com.tendcloud.tenddata;

import java.lang.reflect.Method;

/* loaded from: classes.dex */
final class ae {

    /* renamed from: a, reason: collision with root package name */
    private final Object f2255a;

    /* renamed from: b, reason: collision with root package name */
    private final Method f2256b;

    /* renamed from: c, reason: collision with root package name */
    private final int f2257c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f2258d = true;

    ae(Object obj, Method method) {
        if (obj == null) {
            throw new NullPointerException("EventHandler target cannot be null.");
        }
        if (method == null) {
            throw new NullPointerException("EventHandler method cannot be null.");
        }
        this.f2255a = obj;
        this.f2256b = method;
        method.setAccessible(true);
        this.f2257c = ((method.hashCode() + 31) * 31) + obj.hashCode();
    }

    public boolean a() {
        return this.f2258d;
    }

    public void b() {
        this.f2258d = false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        try {
            if (ae.class != obj.getClass()) {
                return false;
            }
            ae aeVar = (ae) obj;
            if (this.f2256b.equals(aeVar.f2256b)) {
                if (this.f2255a == aeVar.f2255a) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            bq.postSDKError(th);
            return false;
        }
    }

    public void handleEvent(Object obj) {
        if (!this.f2258d) {
            h.eForInternal(toString() + " has been invalidated and can no longer handle events.");
        }
        try {
            this.f2256b.invoke(this.f2255a, obj);
        } catch (Throwable unused) {
        }
    }

    public int hashCode() {
        return this.f2257c;
    }

    public String toString() {
        return "[EventHandler " + this.f2256b + "]";
    }
}
