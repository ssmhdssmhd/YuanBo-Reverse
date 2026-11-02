package androidx.media;

import java.util.Arrays;

/* loaded from: classes.dex */
public class AudioAttributesImplBase implements AudioAttributesImpl {

    /* renamed from: a, reason: collision with root package name */
    public int f920a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f921b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f922c = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f923d = -1;

    public int a() {
        return this.f921b;
    }

    public int b() {
        int i6 = this.f922c;
        int c6 = c();
        if (c6 == 6) {
            i6 |= 4;
        } else if (c6 == 7) {
            i6 |= 1;
        }
        return i6 & 273;
    }

    public int c() {
        int i6 = this.f923d;
        return i6 != -1 ? i6 : AudioAttributesCompat.a(false, this.f922c, this.f920a);
    }

    public int d() {
        return this.f920a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesImplBase)) {
            return false;
        }
        AudioAttributesImplBase audioAttributesImplBase = (AudioAttributesImplBase) obj;
        return this.f921b == audioAttributesImplBase.a() && this.f922c == audioAttributesImplBase.b() && this.f920a == audioAttributesImplBase.d() && this.f923d == audioAttributesImplBase.f923d;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f921b), Integer.valueOf(this.f922c), Integer.valueOf(this.f920a), Integer.valueOf(this.f923d)});
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (this.f923d != -1) {
            sb.append(" stream=");
            sb.append(this.f923d);
            sb.append(" derived");
        }
        sb.append(" usage=");
        sb.append(AudioAttributesCompat.b(this.f920a));
        sb.append(" content=");
        sb.append(this.f921b);
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.f922c).toUpperCase());
        return sb.toString();
    }
}
