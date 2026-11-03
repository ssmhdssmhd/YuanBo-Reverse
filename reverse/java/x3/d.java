package x3;

import android.view.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import x3.d;
import y3.a;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public final y3.a<Object> f10485a;

    public interface a {
        void a(boolean z5);
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final KeyEvent f10486a;

        /* renamed from: b, reason: collision with root package name */
        public final Character f10487b;

        public b(KeyEvent keyEvent, Character ch) {
            this.f10486a = keyEvent;
            this.f10487b = ch;
        }
    }

    public d(y3.c cVar) {
        this.f10485a = new y3.a<>(cVar, "flutter/keyevent", y3.f.f11098a);
    }

    private static a.e<Object> b(final a aVar) {
        return new a.e() { // from class: x3.c
            @Override // y3.a.e
            public final void a(Object obj) {
                d.d(d.a.this, obj);
            }
        };
    }

    private Map<String, Object> c(b bVar, boolean z5) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", z5 ? "keyup" : "keydown");
        hashMap.put("keymap", "android");
        hashMap.put("flags", Integer.valueOf(bVar.f10486a.getFlags()));
        hashMap.put("plainCodePoint", Integer.valueOf(bVar.f10486a.getUnicodeChar(0)));
        hashMap.put("codePoint", Integer.valueOf(bVar.f10486a.getUnicodeChar()));
        hashMap.put("keyCode", Integer.valueOf(bVar.f10486a.getKeyCode()));
        hashMap.put("scanCode", Integer.valueOf(bVar.f10486a.getScanCode()));
        hashMap.put("metaState", Integer.valueOf(bVar.f10486a.getMetaState()));
        Character ch = bVar.f10487b;
        if (ch != null) {
            hashMap.put("character", ch.toString());
        }
        hashMap.put("source", Integer.valueOf(bVar.f10486a.getSource()));
        hashMap.put("deviceId", Integer.valueOf(bVar.f10486a.getDeviceId()));
        hashMap.put("repeatCount", Integer.valueOf(bVar.f10486a.getRepeatCount()));
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(a aVar, Object obj) {
        boolean z5 = false;
        if (obj != null) {
            try {
                z5 = ((JSONObject) obj).getBoolean("handled");
            } catch (JSONException e6) {
                k3.b.b("KeyEventChannel", "Unable to unpack JSON message: " + e6);
            }
        }
        aVar.a(z5);
    }

    public void e(b bVar, boolean z5, a aVar) {
        this.f10485a.d(c(bVar, z5), b(aVar));
    }
}
