package j0;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.provider.Settings;
import android.util.Pair;
import h0.y1;
import java.util.Arrays;
import m2.q;
import m2.r;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: c, reason: collision with root package name */
    public static final h f6433c = new h(new int[]{2}, 8);

    /* renamed from: d, reason: collision with root package name */
    private static final h f6434d = new h(new int[]{2, 5, 6}, 8);

    /* renamed from: e, reason: collision with root package name */
    private static final m2.r<Integer, Integer> f6435e = new r.a().d(5, 6).d(17, 6).d(7, 6).d(18, 6).d(6, 8).d(8, 8).d(14, 8).b();

    /* renamed from: a, reason: collision with root package name */
    private final int[] f6436a;

    /* renamed from: b, reason: collision with root package name */
    private final int f6437b;

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private static final AudioAttributes f6438a = new AudioAttributes.Builder().setUsage(1).setContentType(3).setFlags(0).build();

        /* JADX WARN: Multi-variable type inference failed */
        public static int[] a() {
            boolean isDirectPlaybackSupported;
            q.a k6 = m2.q.k();
            m2.s0 it = h.f6435e.keySet().iterator();
            while (it.hasNext()) {
                int intValue = ((Integer) it.next()).intValue();
                isDirectPlaybackSupported = AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setChannelMask(12).setEncoding(intValue).setSampleRate(48000).build(), f6438a);
                if (isDirectPlaybackSupported) {
                    k6.a(Integer.valueOf(intValue));
                }
            }
            k6.a(2);
            return o2.e.k(k6.h());
        }

        public static int b(int i6, int i7) {
            boolean isDirectPlaybackSupported;
            for (int i8 = 8; i8 > 0; i8--) {
                isDirectPlaybackSupported = AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setEncoding(i6).setSampleRate(i7).setChannelMask(i2.c1.G(i8)).build(), f6438a);
                if (isDirectPlaybackSupported) {
                    return i8;
                }
            }
            return 0;
        }
    }

    public h(int[] iArr, int i6) {
        if (iArr != null) {
            int[] copyOf = Arrays.copyOf(iArr, iArr.length);
            this.f6436a = copyOf;
            Arrays.sort(copyOf);
        } else {
            this.f6436a = new int[0];
        }
        this.f6437b = i6;
    }

    private static boolean b() {
        if (i2.c1.f5548a >= 17) {
            String str = i2.c1.f5550c;
            if ("Amazon".equals(str) || "Xiaomi".equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static h c(Context context) {
        return d(context, context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")));
    }

    static h d(Context context, Intent intent) {
        return (b() && Settings.Global.getInt(context.getContentResolver(), "external_surround_sound_enabled", 0) == 1) ? f6434d : (i2.c1.f5548a < 29 || !(i2.c1.y0(context) || i2.c1.t0(context))) ? (intent == null || intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) == 0) ? f6433c : new h(intent.getIntArrayExtra("android.media.extra.ENCODINGS"), intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 8)) : new h(a.a(), 8);
    }

    private static int e(int i6) {
        int i7 = i2.c1.f5548a;
        if (i7 <= 28) {
            if (i6 == 7) {
                i6 = 8;
            } else if (i6 == 3 || i6 == 4 || i6 == 5) {
                i6 = 6;
            }
        }
        if (i7 <= 26 && "fugu".equals(i2.c1.f5549b) && i6 == 1) {
            i6 = 2;
        }
        return i2.c1.G(i6);
    }

    private static int g(int i6, int i7) {
        return i2.c1.f5548a >= 29 ? a.b(i6, i7) : ((Integer) i2.a.e(f6435e.getOrDefault(Integer.valueOf(i6), 0))).intValue();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return Arrays.equals(this.f6436a, hVar.f6436a) && this.f6437b == hVar.f6437b;
    }

    public Pair<Integer, Integer> f(y1 y1Var) {
        int f6 = i2.x.f((String) i2.a.e(y1Var.f5066p), y1Var.f5063m);
        if (!f6435e.containsKey(Integer.valueOf(f6))) {
            return null;
        }
        if (f6 == 18 && !i(18)) {
            f6 = 6;
        } else if (f6 == 8 && !i(8)) {
            f6 = 7;
        }
        if (!i(f6)) {
            return null;
        }
        int i6 = y1Var.C;
        if (i6 == -1 || f6 == 18) {
            int i7 = y1Var.D;
            if (i7 == -1) {
                i7 = 48000;
            }
            i6 = g(f6, i7);
        } else if (i6 > this.f6437b) {
            return null;
        }
        int e6 = e(i6);
        if (e6 == 0) {
            return null;
        }
        return Pair.create(Integer.valueOf(f6), Integer.valueOf(e6));
    }

    public boolean h(y1 y1Var) {
        return f(y1Var) != null;
    }

    public int hashCode() {
        return this.f6437b + (Arrays.hashCode(this.f6436a) * 31);
    }

    public boolean i(int i6) {
        return Arrays.binarySearch(this.f6436a, i6) >= 0;
    }

    public String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.f6437b + ", supportedEncodings=" + Arrays.toString(this.f6436a) + "]";
    }
}
