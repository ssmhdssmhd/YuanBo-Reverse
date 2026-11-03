package androidx.media;

import androidx.versionedparcelable.a;

/* loaded from: classes.dex */
public class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(a aVar) {
        AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
        audioAttributesImplBase.f920a = aVar.p(audioAttributesImplBase.f920a, 1);
        audioAttributesImplBase.f921b = aVar.p(audioAttributesImplBase.f921b, 2);
        audioAttributesImplBase.f922c = aVar.p(audioAttributesImplBase.f922c, 3);
        audioAttributesImplBase.f923d = aVar.p(audioAttributesImplBase.f923d, 4);
        return audioAttributesImplBase;
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase, a aVar) {
        aVar.x(false, false);
        aVar.F(audioAttributesImplBase.f920a, 1);
        aVar.F(audioAttributesImplBase.f921b, 2);
        aVar.F(audioAttributesImplBase.f922c, 3);
        aVar.F(audioAttributesImplBase.f923d, 4);
    }
}
