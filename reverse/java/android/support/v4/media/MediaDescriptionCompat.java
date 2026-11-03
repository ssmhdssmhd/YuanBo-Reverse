package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private final String f168a;

    /* renamed from: b, reason: collision with root package name */
    private final CharSequence f169b;

    /* renamed from: c, reason: collision with root package name */
    private final CharSequence f170c;

    /* renamed from: d, reason: collision with root package name */
    private final CharSequence f171d;

    /* renamed from: e, reason: collision with root package name */
    private final Bitmap f172e;

    /* renamed from: j, reason: collision with root package name */
    private final Uri f173j;

    /* renamed from: k, reason: collision with root package name */
    private final Bundle f174k;

    /* renamed from: l, reason: collision with root package name */
    private final Uri f175l;

    /* renamed from: m, reason: collision with root package name */
    private MediaDescription f176m;

    class a implements Parcelable.Creator<MediaDescriptionCompat> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MediaDescriptionCompat createFromParcel(Parcel parcel) {
            return MediaDescriptionCompat.d(MediaDescription.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public MediaDescriptionCompat[] newArray(int i6) {
            return new MediaDescriptionCompat[i6];
        }
    }

    private static class b {
        static MediaDescription a(MediaDescription.Builder builder) {
            return builder.build();
        }

        static MediaDescription.Builder b() {
            return new MediaDescription.Builder();
        }

        static CharSequence c(MediaDescription mediaDescription) {
            return mediaDescription.getDescription();
        }

        static Bundle d(MediaDescription mediaDescription) {
            return mediaDescription.getExtras();
        }

        static Bitmap e(MediaDescription mediaDescription) {
            return mediaDescription.getIconBitmap();
        }

        static Uri f(MediaDescription mediaDescription) {
            return mediaDescription.getIconUri();
        }

        static String g(MediaDescription mediaDescription) {
            return mediaDescription.getMediaId();
        }

        static CharSequence h(MediaDescription mediaDescription) {
            return mediaDescription.getSubtitle();
        }

        static CharSequence i(MediaDescription mediaDescription) {
            return mediaDescription.getTitle();
        }

        static void j(MediaDescription.Builder builder, CharSequence charSequence) {
            builder.setDescription(charSequence);
        }

        static void k(MediaDescription.Builder builder, Bundle bundle) {
            builder.setExtras(bundle);
        }

        static void l(MediaDescription.Builder builder, Bitmap bitmap) {
            builder.setIconBitmap(bitmap);
        }

        static void m(MediaDescription.Builder builder, Uri uri) {
            builder.setIconUri(uri);
        }

        static void n(MediaDescription.Builder builder, String str) {
            builder.setMediaId(str);
        }

        static void o(MediaDescription.Builder builder, CharSequence charSequence) {
            builder.setSubtitle(charSequence);
        }

        static void p(MediaDescription.Builder builder, CharSequence charSequence) {
            builder.setTitle(charSequence);
        }
    }

    private static class c {
        static Uri a(MediaDescription mediaDescription) {
            Uri mediaUri;
            mediaUri = mediaDescription.getMediaUri();
            return mediaUri;
        }

        static void b(MediaDescription.Builder builder, Uri uri) {
            builder.setMediaUri(uri);
        }
    }

    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        private String f177a;

        /* renamed from: b, reason: collision with root package name */
        private CharSequence f178b;

        /* renamed from: c, reason: collision with root package name */
        private CharSequence f179c;

        /* renamed from: d, reason: collision with root package name */
        private CharSequence f180d;

        /* renamed from: e, reason: collision with root package name */
        private Bitmap f181e;

        /* renamed from: f, reason: collision with root package name */
        private Uri f182f;

        /* renamed from: g, reason: collision with root package name */
        private Bundle f183g;

        /* renamed from: h, reason: collision with root package name */
        private Uri f184h;

        public MediaDescriptionCompat a() {
            return new MediaDescriptionCompat(this.f177a, this.f178b, this.f179c, this.f180d, this.f181e, this.f182f, this.f183g, this.f184h);
        }

        public d b(CharSequence charSequence) {
            this.f180d = charSequence;
            return this;
        }

        public d c(Bundle bundle) {
            this.f183g = bundle;
            return this;
        }

        public d d(Bitmap bitmap) {
            this.f181e = bitmap;
            return this;
        }

        public d e(Uri uri) {
            this.f182f = uri;
            return this;
        }

        public d f(String str) {
            this.f177a = str;
            return this;
        }

        public d g(Uri uri) {
            this.f184h = uri;
            return this;
        }

        public d h(CharSequence charSequence) {
            this.f179c = charSequence;
            return this;
        }

        public d i(CharSequence charSequence) {
            this.f178b = charSequence;
            return this;
        }
    }

    MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f168a = str;
        this.f169b = charSequence;
        this.f170c = charSequence2;
        this.f171d = charSequence3;
        this.f172e = bitmap;
        this.f173j = uri;
        this.f174k = bundle;
        this.f175l = uri2;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.support.v4.media.MediaDescriptionCompat d(java.lang.Object r9) {
        /*
            r0 = 0
            if (r9 == 0) goto L7f
            int r1 = android.os.Build.VERSION.SDK_INT
            android.support.v4.media.MediaDescriptionCompat$d r2 = new android.support.v4.media.MediaDescriptionCompat$d
            r2.<init>()
            android.media.MediaDescription r9 = (android.media.MediaDescription) r9
            java.lang.String r3 = android.support.v4.media.MediaDescriptionCompat.b.g(r9)
            r2.f(r3)
            java.lang.CharSequence r3 = android.support.v4.media.MediaDescriptionCompat.b.i(r9)
            r2.i(r3)
            java.lang.CharSequence r3 = android.support.v4.media.MediaDescriptionCompat.b.h(r9)
            r2.h(r3)
            java.lang.CharSequence r3 = android.support.v4.media.MediaDescriptionCompat.b.c(r9)
            r2.b(r3)
            android.graphics.Bitmap r3 = android.support.v4.media.MediaDescriptionCompat.b.e(r9)
            r2.d(r3)
            android.net.Uri r3 = android.support.v4.media.MediaDescriptionCompat.b.f(r9)
            r2.e(r3)
            android.os.Bundle r3 = android.support.v4.media.MediaDescriptionCompat.b.d(r9)
            if (r3 == 0) goto L40
            android.os.Bundle r3 = android.support.v4.media.session.MediaSessionCompat.n(r3)
        L40:
            java.lang.String r4 = "android.support.v4.media.description.MEDIA_URI"
            if (r3 == 0) goto L4b
            android.os.Parcelable r5 = r3.getParcelable(r4)
            android.net.Uri r5 = (android.net.Uri) r5
            goto L4c
        L4b:
            r5 = r0
        L4c:
            if (r5 == 0) goto L64
            java.lang.String r6 = "android.support.v4.media.description.NULL_BUNDLE_FLAG"
            boolean r7 = r3.containsKey(r6)
            if (r7 == 0) goto L5e
            int r7 = r3.size()
            r8 = 2
            if (r7 != r8) goto L5e
            goto L65
        L5e:
            r3.remove(r4)
            r3.remove(r6)
        L64:
            r0 = r3
        L65:
            r2.c(r0)
            if (r5 == 0) goto L6e
            r2.g(r5)
            goto L79
        L6e:
            r0 = 23
            if (r1 < r0) goto L79
            android.net.Uri r0 = android.support.v4.media.MediaDescriptionCompat.c.a(r9)
            r2.g(r0)
        L79:
            android.support.v4.media.MediaDescriptionCompat r0 = r2.a()
            r0.f176m = r9
        L7f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaDescriptionCompat.d(java.lang.Object):android.support.v4.media.MediaDescriptionCompat");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public CharSequence e() {
        return this.f171d;
    }

    public Bundle f() {
        return this.f174k;
    }

    public Bitmap g() {
        return this.f172e;
    }

    public Uri h() {
        return this.f173j;
    }

    public Object i() {
        Bundle bundle;
        MediaDescription mediaDescription = this.f176m;
        if (mediaDescription != null) {
            return mediaDescription;
        }
        int i6 = Build.VERSION.SDK_INT;
        MediaDescription.Builder b6 = b.b();
        b.n(b6, this.f168a);
        b.p(b6, this.f169b);
        b.o(b6, this.f170c);
        b.j(b6, this.f171d);
        b.l(b6, this.f172e);
        b.m(b6, this.f173j);
        if (i6 >= 23 || this.f175l == null) {
            bundle = this.f174k;
        } else {
            if (this.f174k == null) {
                bundle = new Bundle();
                bundle.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
            } else {
                bundle = new Bundle(this.f174k);
            }
            bundle.putParcelable("android.support.v4.media.description.MEDIA_URI", this.f175l);
        }
        b.k(b6, bundle);
        if (i6 >= 23) {
            c.b(b6, this.f175l);
        }
        MediaDescription a6 = b.a(b6);
        this.f176m = a6;
        return a6;
    }

    public String j() {
        return this.f168a;
    }

    public Uri k() {
        return this.f175l;
    }

    public CharSequence l() {
        return this.f170c;
    }

    public CharSequence m() {
        return this.f169b;
    }

    public String toString() {
        return ((Object) this.f169b) + ", " + ((Object) this.f170c) + ", " + ((Object) this.f171d);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        ((MediaDescription) i()).writeToParcel(parcel, i6);
    }
}
