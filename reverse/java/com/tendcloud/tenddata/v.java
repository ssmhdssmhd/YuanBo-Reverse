package com.tendcloud.tenddata;

import java.lang.reflect.Method;

/* loaded from: classes.dex */
public interface v {
    void afterMethodInvoked(Object obj, Method method, Object[] objArr, Object obj2);

    void beforeMethodInvoke(Object obj, Method method, Object[] objArr);
}
