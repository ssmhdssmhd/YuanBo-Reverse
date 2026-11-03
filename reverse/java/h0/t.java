package h0;

import a1.p;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import j0.s0;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class t implements b4 {

    /* renamed from: a, reason: collision with root package name */
    private final Context f4885a;

    /* renamed from: e, reason: collision with root package name */
    private boolean f4889e;

    /* renamed from: g, reason: collision with root package name */
    private boolean f4891g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f4892h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f4893i;

    /* renamed from: b, reason: collision with root package name */
    private final a1.n f4886b = new a1.n();

    /* renamed from: c, reason: collision with root package name */
    private int f4887c = 0;

    /* renamed from: d, reason: collision with root package name */
    private long f4888d = 5000;

    /* renamed from: f, reason: collision with root package name */
    private a1.y f4890f = a1.y.f141a;

    public t(Context context) {
        this.f4885a = context;
    }

    @Override // h0.b4
    public x3[] a(Handler handler, j2.b0 b0Var, j0.v vVar, u1.n nVar, b1.f fVar) {
        ArrayList<x3> arrayList = new ArrayList<>();
        h(this.f4885a, this.f4887c, this.f4890f, this.f4889e, handler, b0Var, this.f4888d, arrayList);
        j0.x c6 = c(this.f4885a, this.f4891g, this.f4892h, this.f4893i);
        if (c6 != null) {
            b(this.f4885a, this.f4887c, this.f4890f, this.f4889e, c6, handler, vVar, arrayList);
        }
        g(this.f4885a, nVar, handler.getLooper(), this.f4887c, arrayList);
        e(this.f4885a, fVar, handler.getLooper(), this.f4887c, arrayList);
        d(this.f4885a, this.f4887c, arrayList);
        f(this.f4885a, handler, this.f4887c, arrayList);
        return (x3[]) arrayList.toArray(new x3[0]);
    }

    protected void b(Context context, int i6, a1.y yVar, boolean z5, j0.x xVar, Handler handler, j0.v vVar, ArrayList<x3> arrayList) {
        int i7;
        int i8;
        arrayList.add(new j0.j1(context, i(), yVar, z5, handler, vVar, xVar));
        if (i6 == 0) {
            return;
        }
        int size = arrayList.size();
        if (i6 == 2) {
            size--;
        }
        try {
            try {
                i7 = size + 1;
                try {
                    arrayList.add(size, (x3) Class.forName("com.google.android.exoplayer2.decoder.midi.MidiRenderer").getConstructor(new Class[0]).newInstance(new Object[0]));
                    i2.t.f("DefaultRenderersFactory", "Loaded MidiRenderer.");
                } catch (ClassNotFoundException unused) {
                    size = i7;
                    i7 = size;
                    try {
                        i8 = i7 + 1;
                        arrayList.add(i7, (x3) Class.forName("com.google.android.exoplayer2.ext.opus.LibopusAudioRenderer").getConstructor(Handler.class, j0.v.class, j0.x.class).newInstance(handler, vVar, xVar));
                        i2.t.f("DefaultRenderersFactory", "Loaded LibopusAudioRenderer.");
                        try {
                            int i9 = i8 + 1;
                            try {
                                arrayList.add(i8, (x3) Class.forName("com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer").getConstructor(Handler.class, j0.v.class, j0.x.class).newInstance(handler, vVar, xVar));
                                i2.t.f("DefaultRenderersFactory", "Loaded LibflacAudioRenderer.");
                            } catch (ClassNotFoundException unused2) {
                                i8 = i9;
                                i9 = i8;
                                arrayList.add(i9, (x3) Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(Handler.class, j0.v.class, j0.x.class).newInstance(handler, vVar, xVar));
                                i2.t.f("DefaultRenderersFactory", "Loaded FfmpegAudioRenderer.");
                            }
                            arrayList.add(i9, (x3) Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(Handler.class, j0.v.class, j0.x.class).newInstance(handler, vVar, xVar));
                            i2.t.f("DefaultRenderersFactory", "Loaded FfmpegAudioRenderer.");
                        } catch (Exception e6) {
                            throw new RuntimeException("Error instantiating FLAC extension", e6);
                        }
                    } catch (Exception e7) {
                        throw new RuntimeException("Error instantiating Opus extension", e7);
                    }
                }
            } catch (Exception e8) {
                throw new RuntimeException("Error instantiating MIDI extension", e8);
            }
        } catch (ClassNotFoundException unused3) {
        }
        try {
            i8 = i7 + 1;
        } catch (ClassNotFoundException unused4) {
        }
        try {
            arrayList.add(i7, (x3) Class.forName("com.google.android.exoplayer2.ext.opus.LibopusAudioRenderer").getConstructor(Handler.class, j0.v.class, j0.x.class).newInstance(handler, vVar, xVar));
            i2.t.f("DefaultRenderersFactory", "Loaded LibopusAudioRenderer.");
        } catch (ClassNotFoundException unused5) {
            i7 = i8;
            i8 = i7;
            int i92 = i8 + 1;
            arrayList.add(i8, (x3) Class.forName("com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer").getConstructor(Handler.class, j0.v.class, j0.x.class).newInstance(handler, vVar, xVar));
            i2.t.f("DefaultRenderersFactory", "Loaded LibflacAudioRenderer.");
            arrayList.add(i92, (x3) Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(Handler.class, j0.v.class, j0.x.class).newInstance(handler, vVar, xVar));
            i2.t.f("DefaultRenderersFactory", "Loaded FfmpegAudioRenderer.");
        }
        try {
            int i922 = i8 + 1;
            arrayList.add(i8, (x3) Class.forName("com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer").getConstructor(Handler.class, j0.v.class, j0.x.class).newInstance(handler, vVar, xVar));
            i2.t.f("DefaultRenderersFactory", "Loaded LibflacAudioRenderer.");
        } catch (ClassNotFoundException unused6) {
        }
        try {
            arrayList.add(i922, (x3) Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(Handler.class, j0.v.class, j0.x.class).newInstance(handler, vVar, xVar));
            i2.t.f("DefaultRenderersFactory", "Loaded FfmpegAudioRenderer.");
        } catch (ClassNotFoundException unused7) {
        } catch (Exception e9) {
            throw new RuntimeException("Error instantiating FFmpeg extension", e9);
        }
    }

    protected j0.x c(Context context, boolean z5, boolean z6, boolean z7) {
        return new s0.f().g(j0.h.c(context)).i(z5).h(z6).j(z7 ? 1 : 0).f();
    }

    protected void d(Context context, int i6, ArrayList<x3> arrayList) {
        arrayList.add(new k2.b());
    }

    protected void e(Context context, b1.f fVar, Looper looper, int i6, ArrayList<x3> arrayList) {
        arrayList.add(new b1.g(fVar, looper));
    }

    protected void f(Context context, Handler handler, int i6, ArrayList<x3> arrayList) {
    }

    protected void g(Context context, u1.n nVar, Looper looper, int i6, ArrayList<x3> arrayList) {
        arrayList.add(new u1.o(nVar, looper));
    }

    protected void h(Context context, int i6, a1.y yVar, boolean z5, Handler handler, j2.b0 b0Var, long j6, ArrayList<x3> arrayList) {
        int i7;
        arrayList.add(new j2.k(context, i(), yVar, j6, z5, handler, b0Var, 50));
        if (i6 == 0) {
            return;
        }
        int size = arrayList.size();
        if (i6 == 2) {
            size--;
        }
        try {
            try {
                i7 = size + 1;
                try {
                    arrayList.add(size, (x3) Class.forName("com.google.android.exoplayer2.ext.vp9.LibvpxVideoRenderer").getConstructor(Long.TYPE, Handler.class, j2.b0.class, Integer.TYPE).newInstance(Long.valueOf(j6), handler, b0Var, 50));
                    i2.t.f("DefaultRenderersFactory", "Loaded LibvpxVideoRenderer.");
                } catch (ClassNotFoundException unused) {
                    size = i7;
                    i7 = size;
                    arrayList.add(i7, (x3) Class.forName("com.google.android.exoplayer2.ext.av1.Libgav1VideoRenderer").getConstructor(Long.TYPE, Handler.class, j2.b0.class, Integer.TYPE).newInstance(Long.valueOf(j6), handler, b0Var, 50));
                    i2.t.f("DefaultRenderersFactory", "Loaded Libgav1VideoRenderer.");
                }
            } catch (Exception e6) {
                throw new RuntimeException("Error instantiating VP9 extension", e6);
            }
        } catch (ClassNotFoundException unused2) {
        }
        try {
            arrayList.add(i7, (x3) Class.forName("com.google.android.exoplayer2.ext.av1.Libgav1VideoRenderer").getConstructor(Long.TYPE, Handler.class, j2.b0.class, Integer.TYPE).newInstance(Long.valueOf(j6), handler, b0Var, 50));
            i2.t.f("DefaultRenderersFactory", "Loaded Libgav1VideoRenderer.");
        } catch (ClassNotFoundException unused3) {
        } catch (Exception e7) {
            throw new RuntimeException("Error instantiating AV1 extension", e7);
        }
    }

    protected p.b i() {
        return this.f4886b;
    }
}
