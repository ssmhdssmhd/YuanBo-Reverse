package androidx.media;

import android.media.AudioAttributes;

/* loaded from: classes.dex */
public class AudioAttributesImplApi21 implements AudioAttributesImpl {

    /* renamed from: a, reason: collision with root package name */
    public AudioAttributes f918a;

    /* renamed from: b, reason: collision with root package name */
    public int f919b;

    public AudioAttributesImplApi21() {
        this.f919b = -1;
    }

    AudioAttributesImplApi21(AudioAttributes audioAttributes) {
        this(audioAttributes, -1);
    }

    AudioAttributesImplApi21(AudioAttributes audioAttributes, int i6) {
        this.f918a = audioAttributes;
        this.f919b = i6;
    }

    public boolean equals(Object obj) {
        if (obj instanceof AudioAttributesImplApi21) {
            return this.f918a.equals(((AudioAttributesImplApi21) obj).f918a);
        }
        return false;
    }

    public int hashCode() {
        return this.f918a.hashCode();
    }

    public String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.f918a;
    }
}
