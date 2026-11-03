package n0;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import i2.c1;
import java.util.Set;
import n0.a;

/* loaded from: classes.dex */
public final /* synthetic */ class b {
    public static boolean a(a.h hVar, MediaMetadataCompat mediaMetadataCompat, MediaMetadataCompat mediaMetadataCompat2) {
        if (mediaMetadataCompat == mediaMetadataCompat2) {
            return true;
        }
        if (mediaMetadataCompat.j() != mediaMetadataCompat2.j()) {
            return false;
        }
        Set<String> i6 = mediaMetadataCompat.i();
        Bundle f6 = mediaMetadataCompat.f();
        Bundle f7 = mediaMetadataCompat2.f();
        for (String str : i6) {
            Object obj = f6.get(str);
            Object obj2 = f7.get(str);
            if (obj != obj2) {
                if ((obj instanceof Bitmap) && (obj2 instanceof Bitmap)) {
                    if (!((Bitmap) obj).sameAs((Bitmap) obj2)) {
                        return false;
                    }
                } else if ((obj instanceof RatingCompat) && (obj2 instanceof RatingCompat)) {
                    RatingCompat ratingCompat = (RatingCompat) obj;
                    RatingCompat ratingCompat2 = (RatingCompat) obj2;
                    if (ratingCompat.i() != ratingCompat2.i() || ratingCompat.j() != ratingCompat2.j() || ratingCompat.k() != ratingCompat2.k() || ratingCompat.e() != ratingCompat2.e() || ratingCompat.h() != ratingCompat2.h() || ratingCompat.g() != ratingCompat2.g()) {
                        return false;
                    }
                } else if (!c1.c(obj, obj2)) {
                    return false;
                }
            }
        }
        return true;
    }
}
