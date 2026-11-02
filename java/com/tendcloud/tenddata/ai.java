package com.tendcloud.tenddata;

import java.net.URL;
import java.util.LinkedList;
import java.util.Queue;

/* loaded from: classes.dex */
public class ai {

    /* renamed from: a, reason: collision with root package name */
    static final Queue<String> f2265a;

    static {
        LinkedList linkedList = new LinkedList();
        f2265a = linkedList;
        linkedList.add(aa.f2203c);
    }

    static String a() {
        return f2265a.poll();
    }

    public static URL a(URL url, String str) {
        return o.b() ? url : new URL(url.getProtocol(), str, url.getPort(), url.getFile());
    }

    static void a(String str) {
        Queue<String> queue = f2265a;
        if (queue.contains(str)) {
            h.eForInternal("host existed...");
        } else {
            queue.add(str);
        }
    }
}
