package h0;

import android.content.Context;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Handler;
import h0.j;

/* loaded from: classes.dex */
final class j {

    /* renamed from: a, reason: collision with root package name */
    private final AudioManager f4529a;

    /* renamed from: b, reason: collision with root package name */
    private final a f4530b;

    /* renamed from: c, reason: collision with root package name */
    private b f4531c;

    /* renamed from: d, reason: collision with root package name */
    private j0.e f4532d;

    /* renamed from: f, reason: collision with root package name */
    private int f4534f;

    /* renamed from: h, reason: collision with root package name */
    private AudioFocusRequest f4536h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f4537i;

    /* renamed from: g, reason: collision with root package name */
    private float f4535g = 1.0f;

    /* renamed from: e, reason: collision with root package name */
    private int f4533e = 0;

    /* JADX INFO: Access modifiers changed from: private */
    class a implements AudioManager.OnAudioFocusChangeListener {

        /* renamed from: a, reason: collision with root package name */
        private final Handler f4538a;

        public a(Handler handler) {
            this.f4538a = handler;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(int i6) {
            j.this.h(i6);
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(final int i6) {
            this.f4538a.post(new Runnable() { // from class: h0.i
                @Override // java.lang.Runnable
                public final void run() {
                    j.a.this.b(i6);
                }
            });
        }
    }

    public interface b {
        void H(float f6);

        void a(int i6);
    }

    public j(Context context, Handler handler, b bVar) {
        this.f4529a = (AudioManager) i2.a.e((AudioManager) context.getApplicationContext().getSystemService("audio"));
        this.f4531c = bVar;
        this.f4530b = new a(handler);
    }

    private void a() {
        this.f4529a.abandonAudioFocus(this.f4530b);
    }

    private void b() {
        if (this.f4533e == 0) {
            return;
        }
        if (i2.c1.f5548a >= 26) {
            c();
        } else {
            a();
        }
        n(0);
    }

    private void c() {
        AudioFocusRequest audioFocusRequest = this.f4536h;
        if (audioFocusRequest != null) {
            this.f4529a.abandonAudioFocusRequest(audioFocusRequest);
        }
    }

    private static int e(j0.e eVar) {
        if (eVar == null) {
            return 0;
        }
        switch (eVar.f6410c) {
            case 0:
                i2.t.i("AudioFocusManager", "Specify a proper usage in the audio attributes for audio focus handling. Using AUDIOFOCUS_GAIN by default.");
                return 1;
            case 1:
            case 14:
                return 1;
            case 2:
            case 4:
                return 2;
            case 3:
                return 0;
            case 11:
                if (eVar.f6408a == 1) {
                    return 2;
                }
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 12:
            case 13:
                return 3;
            case 15:
            default:
                i2.t.i("AudioFocusManager", "Unidentified audio usage: " + eVar.f6410c);
                return 0;
            case 16:
                return i2.c1.f5548a >= 19 ? 4 : 2;
        }
    }

    private void f(int i6) {
        b bVar = this.f4531c;
        if (bVar != null) {
            bVar.a(i6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i6) {
        int i7;
        if (i6 == -3 || i6 == -2) {
            if (i6 == -2 || q()) {
                f(0);
                i7 = 2;
            } else {
                i7 = 3;
            }
            n(i7);
            return;
        }
        if (i6 == -1) {
            f(-1);
            b();
        } else if (i6 == 1) {
            n(1);
            f(1);
        } else {
            i2.t.i("AudioFocusManager", "Unknown focus change type: " + i6);
        }
    }

    private int j() {
        if (this.f4533e == 1) {
            return 1;
        }
        if ((i2.c1.f5548a >= 26 ? l() : k()) == 1) {
            n(1);
            return 1;
        }
        n(0);
        return -1;
    }

    private int k() {
        return this.f4529a.requestAudioFocus(this.f4530b, i2.c1.h0(((j0.e) i2.a.e(this.f4532d)).f6410c), this.f4534f);
    }

    private int l() {
        AudioFocusRequest.Builder audioAttributes;
        AudioFocusRequest.Builder willPauseWhenDucked;
        AudioFocusRequest.Builder onAudioFocusChangeListener;
        AudioFocusRequest build;
        int requestAudioFocus;
        AudioFocusRequest audioFocusRequest = this.f4536h;
        if (audioFocusRequest == null || this.f4537i) {
            AudioFocusRequest.Builder builder = audioFocusRequest == null ? new AudioFocusRequest.Builder(this.f4534f) : new AudioFocusRequest.Builder(this.f4536h);
            boolean q6 = q();
            audioAttributes = builder.setAudioAttributes(((j0.e) i2.a.e(this.f4532d)).b().f6414a);
            willPauseWhenDucked = audioAttributes.setWillPauseWhenDucked(q6);
            onAudioFocusChangeListener = willPauseWhenDucked.setOnAudioFocusChangeListener(this.f4530b);
            build = onAudioFocusChangeListener.build();
            this.f4536h = build;
            this.f4537i = false;
        }
        requestAudioFocus = this.f4529a.requestAudioFocus(this.f4536h);
        return requestAudioFocus;
    }

    private void n(int i6) {
        if (this.f4533e == i6) {
            return;
        }
        this.f4533e = i6;
        float f6 = i6 == 3 ? 0.2f : 1.0f;
        if (this.f4535g == f6) {
            return;
        }
        this.f4535g = f6;
        b bVar = this.f4531c;
        if (bVar != null) {
            bVar.H(f6);
        }
    }

    private boolean o(int i6) {
        return i6 == 1 || this.f4534f != 1;
    }

    private boolean q() {
        j0.e eVar = this.f4532d;
        return eVar != null && eVar.f6408a == 1;
    }

    public float g() {
        return this.f4535g;
    }

    public void i() {
        this.f4531c = null;
        b();
    }

    public void m(j0.e eVar) {
        if (i2.c1.c(this.f4532d, eVar)) {
            return;
        }
        this.f4532d = eVar;
        int e6 = e(eVar);
        this.f4534f = e6;
        boolean z5 = true;
        if (e6 != 1 && e6 != 0) {
            z5 = false;
        }
        i2.a.b(z5, "Automatic handling of audio focus is only available for USAGE_MEDIA and USAGE_GAME.");
    }

    public int p(boolean z5, int i6) {
        if (o(i6)) {
            b();
            return z5 ? 1 : -1;
        }
        if (z5) {
            return j();
        }
        return -1;
    }
}
