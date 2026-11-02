package io.flutter.embedding.android;

import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import io.flutter.plugin.editing.i;
import java.util.HashSet;

/* loaded from: classes.dex */
public class e0 implements i.a {

    /* renamed from: a, reason: collision with root package name */
    protected final d[] f5879a;

    /* renamed from: b, reason: collision with root package name */
    private final HashSet<KeyEvent> f5880b = new HashSet<>();

    /* renamed from: c, reason: collision with root package name */
    private final e f5881c;

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private int f5882a = 0;

        Character a(int i6) {
            char c6 = (char) i6;
            if ((Integer.MIN_VALUE & i6) != 0) {
                int i7 = i6 & Integer.MAX_VALUE;
                int i8 = this.f5882a;
                if (i8 != 0) {
                    i7 = KeyCharacterMap.getDeadChar(i8, i7);
                }
                this.f5882a = i7;
            } else {
                int i9 = this.f5882a;
                if (i9 != 0) {
                    int deadChar = KeyCharacterMap.getDeadChar(i9, i6);
                    if (deadChar > 0) {
                        c6 = (char) deadChar;
                    }
                    this.f5882a = 0;
                }
            }
            return Character.valueOf(c6);
        }
    }

    private class c {

        /* renamed from: a, reason: collision with root package name */
        final KeyEvent f5883a;

        /* renamed from: b, reason: collision with root package name */
        int f5884b;

        /* renamed from: c, reason: collision with root package name */
        boolean f5885c = false;

        private class a implements d.a {

            /* renamed from: a, reason: collision with root package name */
            boolean f5887a;

            private a() {
                this.f5887a = false;
            }

            @Override // io.flutter.embedding.android.e0.d.a
            public void a(boolean z5) {
                if (this.f5887a) {
                    throw new IllegalStateException("The onKeyEventHandledCallback should be called exactly once.");
                }
                this.f5887a = true;
                c cVar = c.this;
                int i6 = cVar.f5884b - 1;
                cVar.f5884b = i6;
                boolean z6 = z5 | cVar.f5885c;
                cVar.f5885c = z6;
                if (i6 != 0 || z6) {
                    return;
                }
                e0.this.d(cVar.f5883a);
            }
        }

        c(KeyEvent keyEvent) {
            this.f5884b = e0.this.f5879a.length;
            this.f5883a = keyEvent;
        }

        public d.a a() {
            return new a();
        }
    }

    public interface d {

        public interface a {
            void a(boolean z5);
        }

        void a(KeyEvent keyEvent, a aVar);
    }

    public interface e {
        void a(KeyEvent keyEvent);

        boolean c(KeyEvent keyEvent);

        y3.c getBinaryMessenger();
    }

    public e0(e eVar) {
        this.f5881c = eVar;
        this.f5879a = new d[]{new d0(eVar.getBinaryMessenger()), new y(new x3.d(eVar.getBinaryMessenger()))};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(KeyEvent keyEvent) {
        e eVar = this.f5881c;
        if (eVar == null || eVar.c(keyEvent)) {
            return;
        }
        this.f5880b.add(keyEvent);
        this.f5881c.a(keyEvent);
        if (this.f5880b.remove(keyEvent)) {
            k3.b.g("KeyboardManager", "A redispatched key event was consumed before reaching KeyboardManager");
        }
    }

    @Override // io.flutter.plugin.editing.i.a
    public boolean a(KeyEvent keyEvent) {
        if (this.f5880b.remove(keyEvent)) {
            return false;
        }
        if (this.f5879a.length <= 0) {
            d(keyEvent);
            return true;
        }
        c cVar = new c(keyEvent);
        for (d dVar : this.f5879a) {
            dVar.a(keyEvent, cVar.a());
        }
        return true;
    }

    public void c() {
        int size = this.f5880b.size();
        if (size > 0) {
            k3.b.g("KeyboardManager", "A KeyboardManager was destroyed with " + String.valueOf(size) + " unhandled redispatch event(s).");
        }
    }
}
