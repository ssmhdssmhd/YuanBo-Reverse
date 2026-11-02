package com.tendcloud.tenddata;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class cc implements InvocationHandler {
    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        try {
            try {
                dh.a().setOAID((String) objArr[1].getClass().getMethod("getOAID", new Class[0]).invoke(objArr[1], new Object[0]));
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            dh.a().setOAID((String) objArr[0].getClass().getMethod("getOAID", new Class[0]).invoke(objArr[0], new Object[0]));
        }
        try {
            try {
                String str = (String) objArr[1].getClass().getMethod("getVAID", new Class[0]).invoke(objArr[1], new Object[0]);
                dh a6 = dh.a();
                if (y.b(str)) {
                    str = null;
                }
                a6.setVAID(str);
            } catch (Throwable unused3) {
                String str2 = (String) objArr[0].getClass().getMethod("getVAID", new Class[0]).invoke(objArr[0], new Object[0]);
                dh a7 = dh.a();
                if (y.b(str2)) {
                    str2 = null;
                }
                a7.setVAID(str2);
            }
        } catch (Throwable unused4) {
        }
        try {
            try {
                String str3 = (String) objArr[1].getClass().getMethod("getAAID", new Class[0]).invoke(objArr[1], new Object[0]);
                dh a8 = dh.a();
                if (y.b(str3)) {
                    str3 = null;
                }
                a8.setAAID(str3);
            } catch (Throwable unused5) {
                String str4 = (String) objArr[0].getClass().getMethod("getAAID", new Class[0]).invoke(objArr[0], new Object[0]);
                dh a9 = dh.a();
                if (y.b(str4)) {
                    str4 = null;
                }
                a9.setAAID(str4);
            }
        } catch (Throwable unused6) {
        }
        bk.f2419a.countDown();
        return null;
    }
}
