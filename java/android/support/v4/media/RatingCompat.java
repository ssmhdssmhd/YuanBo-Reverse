package android.support.v4.media;

import android.media.Rating;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

/* loaded from: classes.dex */
public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private final int f192a;

    /* renamed from: b, reason: collision with root package name */
    private final float f193b;

    /* renamed from: c, reason: collision with root package name */
    private Object f194c;

    class a implements Parcelable.Creator<RatingCompat> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RatingCompat createFromParcel(Parcel parcel) {
            return new RatingCompat(parcel.readInt(), parcel.readFloat());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public RatingCompat[] newArray(int i6) {
            return new RatingCompat[i6];
        }
    }

    private static class b {
        static float a(Rating rating) {
            return rating.getPercentRating();
        }

        static int b(Rating rating) {
            return rating.getRatingStyle();
        }

        static float c(Rating rating) {
            return rating.getStarRating();
        }

        static boolean d(Rating rating) {
            return rating.hasHeart();
        }

        static boolean e(Rating rating) {
            return rating.isRated();
        }

        static boolean f(Rating rating) {
            return rating.isThumbUp();
        }

        static Rating g(boolean z5) {
            return Rating.newHeartRating(z5);
        }

        static Rating h(float f6) {
            return Rating.newPercentageRating(f6);
        }

        static Rating i(int i6, float f6) {
            return Rating.newStarRating(i6, f6);
        }

        static Rating j(boolean z5) {
            return Rating.newThumbRating(z5);
        }

        static Rating k(int i6) {
            return Rating.newUnratedRating(i6);
        }
    }

    RatingCompat(int i6, float f6) {
        this.f192a = i6;
        this.f193b = f6;
    }

    public static RatingCompat d(Object obj) {
        RatingCompat ratingCompat = null;
        if (obj != null) {
            Rating rating = (Rating) obj;
            int b6 = b.b(rating);
            if (b.e(rating)) {
                switch (b6) {
                    case 1:
                        ratingCompat = l(b.d(rating));
                        break;
                    case 2:
                        ratingCompat = o(b.f(rating));
                        break;
                    case 3:
                    case 4:
                    case 5:
                        ratingCompat = n(b6, b.c(rating));
                        break;
                    case 6:
                        ratingCompat = m(b.a(rating));
                        break;
                    default:
                        return null;
                }
            } else {
                ratingCompat = p(b6);
            }
            ratingCompat.f194c = obj;
        }
        return ratingCompat;
    }

    public static RatingCompat l(boolean z5) {
        return new RatingCompat(1, z5 ? 1.0f : 0.0f);
    }

    public static RatingCompat m(float f6) {
        if (f6 >= 0.0f && f6 <= 100.0f) {
            return new RatingCompat(6, f6);
        }
        Log.e("Rating", "Invalid percentage-based rating value");
        return null;
    }

    public static RatingCompat n(int i6, float f6) {
        float f7;
        String str;
        if (i6 == 3) {
            f7 = 3.0f;
        } else if (i6 == 4) {
            f7 = 4.0f;
        } else {
            if (i6 != 5) {
                str = "Invalid rating style (" + i6 + ") for a star rating";
                Log.e("Rating", str);
                return null;
            }
            f7 = 5.0f;
        }
        if (f6 >= 0.0f && f6 <= f7) {
            return new RatingCompat(i6, f6);
        }
        str = "Trying to set out of range star-based rating";
        Log.e("Rating", str);
        return null;
    }

    public static RatingCompat o(boolean z5) {
        return new RatingCompat(2, z5 ? 1.0f : 0.0f);
    }

    public static RatingCompat p(int i6) {
        switch (i6) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return new RatingCompat(i6, -1.0f);
            default:
                return null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return this.f192a;
    }

    public float e() {
        if (this.f192a == 6 && j()) {
            return this.f193b;
        }
        return -1.0f;
    }

    public Object f() {
        Rating k6;
        if (this.f194c == null) {
            if (j()) {
                int i6 = this.f192a;
                switch (i6) {
                    case 1:
                        k6 = b.g(i());
                        break;
                    case 2:
                        k6 = b.j(k());
                        break;
                    case 3:
                    case 4:
                    case 5:
                        k6 = b.i(i6, h());
                        break;
                    case 6:
                        k6 = b.h(e());
                        break;
                    default:
                        return null;
                }
            } else {
                k6 = b.k(this.f192a);
            }
            this.f194c = k6;
        }
        return this.f194c;
    }

    public int g() {
        return this.f192a;
    }

    public float h() {
        int i6 = this.f192a;
        if ((i6 == 3 || i6 == 4 || i6 == 5) && j()) {
            return this.f193b;
        }
        return -1.0f;
    }

    public boolean i() {
        return this.f192a == 1 && this.f193b == 1.0f;
    }

    public boolean j() {
        return this.f193b >= 0.0f;
    }

    public boolean k() {
        return this.f192a == 2 && this.f193b == 1.0f;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Rating:style=");
        sb.append(this.f192a);
        sb.append(" rating=");
        float f6 = this.f193b;
        sb.append(f6 < 0.0f ? "unrated" : String.valueOf(f6));
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeInt(this.f192a);
        parcel.writeFloat(this.f193b);
    }
}
