package android.support.v4.media.session;

import android.media.session.PlaybackState;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class PlaybackStateCompat implements Parcelable {
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    final int f254a;

    /* renamed from: b, reason: collision with root package name */
    final long f255b;

    /* renamed from: c, reason: collision with root package name */
    final long f256c;

    /* renamed from: d, reason: collision with root package name */
    final float f257d;

    /* renamed from: e, reason: collision with root package name */
    final long f258e;

    /* renamed from: j, reason: collision with root package name */
    final int f259j;

    /* renamed from: k, reason: collision with root package name */
    final CharSequence f260k;

    /* renamed from: l, reason: collision with root package name */
    final long f261l;

    /* renamed from: m, reason: collision with root package name */
    List<CustomAction> f262m;

    /* renamed from: n, reason: collision with root package name */
    final long f263n;

    /* renamed from: o, reason: collision with root package name */
    final Bundle f264o;

    /* renamed from: p, reason: collision with root package name */
    private PlaybackState f265p;

    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        private final String f266a;

        /* renamed from: b, reason: collision with root package name */
        private final CharSequence f267b;

        /* renamed from: c, reason: collision with root package name */
        private final int f268c;

        /* renamed from: d, reason: collision with root package name */
        private final Bundle f269d;

        /* renamed from: e, reason: collision with root package name */
        private PlaybackState.CustomAction f270e;

        class a implements Parcelable.Creator<CustomAction> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public CustomAction createFromParcel(Parcel parcel) {
                return new CustomAction(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public CustomAction[] newArray(int i6) {
                return new CustomAction[i6];
            }
        }

        CustomAction(Parcel parcel) {
            this.f266a = parcel.readString();
            this.f267b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f268c = parcel.readInt();
            this.f269d = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        }

        CustomAction(String str, CharSequence charSequence, int i6, Bundle bundle) {
            this.f266a = str;
            this.f267b = charSequence;
            this.f268c = i6;
            this.f269d = bundle;
        }

        public static CustomAction d(Object obj) {
            if (obj == null) {
                return null;
            }
            PlaybackState.CustomAction customAction = (PlaybackState.CustomAction) obj;
            Bundle l6 = b.l(customAction);
            MediaSessionCompat.a(l6);
            CustomAction customAction2 = new CustomAction(b.f(customAction), b.o(customAction), b.m(customAction), l6);
            customAction2.f270e = customAction;
            return customAction2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String e() {
            return this.f266a;
        }

        public Object f() {
            PlaybackState.CustomAction customAction = this.f270e;
            if (customAction != null) {
                return customAction;
            }
            PlaybackState.CustomAction.Builder e6 = b.e(this.f266a, this.f267b, this.f268c);
            b.w(e6, this.f269d);
            return b.b(e6);
        }

        public String toString() {
            return "Action:mName='" + ((Object) this.f267b) + ", mIcon=" + this.f268c + ", mExtras=" + this.f269d;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            parcel.writeString(this.f266a);
            TextUtils.writeToParcel(this.f267b, parcel, i6);
            parcel.writeInt(this.f268c);
            parcel.writeBundle(this.f269d);
        }
    }

    class a implements Parcelable.Creator<PlaybackStateCompat> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PlaybackStateCompat createFromParcel(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public PlaybackStateCompat[] newArray(int i6) {
            return new PlaybackStateCompat[i6];
        }
    }

    private static class b {
        static void a(PlaybackState.Builder builder, PlaybackState.CustomAction customAction) {
            builder.addCustomAction(customAction);
        }

        static PlaybackState.CustomAction b(PlaybackState.CustomAction.Builder builder) {
            return builder.build();
        }

        static PlaybackState c(PlaybackState.Builder builder) {
            return builder.build();
        }

        static PlaybackState.Builder d() {
            return new PlaybackState.Builder();
        }

        static PlaybackState.CustomAction.Builder e(String str, CharSequence charSequence, int i6) {
            return new PlaybackState.CustomAction.Builder(str, charSequence, i6);
        }

        static String f(PlaybackState.CustomAction customAction) {
            return customAction.getAction();
        }

        static long g(PlaybackState playbackState) {
            return playbackState.getActions();
        }

        static long h(PlaybackState playbackState) {
            return playbackState.getActiveQueueItemId();
        }

        static long i(PlaybackState playbackState) {
            return playbackState.getBufferedPosition();
        }

        static List<PlaybackState.CustomAction> j(PlaybackState playbackState) {
            return playbackState.getCustomActions();
        }

        static CharSequence k(PlaybackState playbackState) {
            return playbackState.getErrorMessage();
        }

        static Bundle l(PlaybackState.CustomAction customAction) {
            return customAction.getExtras();
        }

        static int m(PlaybackState.CustomAction customAction) {
            return customAction.getIcon();
        }

        static long n(PlaybackState playbackState) {
            return playbackState.getLastPositionUpdateTime();
        }

        static CharSequence o(PlaybackState.CustomAction customAction) {
            return customAction.getName();
        }

        static float p(PlaybackState playbackState) {
            return playbackState.getPlaybackSpeed();
        }

        static long q(PlaybackState playbackState) {
            return playbackState.getPosition();
        }

        static int r(PlaybackState playbackState) {
            return playbackState.getState();
        }

        static void s(PlaybackState.Builder builder, long j6) {
            builder.setActions(j6);
        }

        static void t(PlaybackState.Builder builder, long j6) {
            builder.setActiveQueueItemId(j6);
        }

        static void u(PlaybackState.Builder builder, long j6) {
            builder.setBufferedPosition(j6);
        }

        static void v(PlaybackState.Builder builder, CharSequence charSequence) {
            builder.setErrorMessage(charSequence);
        }

        static void w(PlaybackState.CustomAction.Builder builder, Bundle bundle) {
            builder.setExtras(bundle);
        }

        static void x(PlaybackState.Builder builder, int i6, long j6, float f6, long j7) {
            builder.setState(i6, j6, f6, j7);
        }
    }

    private static class c {
        static Bundle a(PlaybackState playbackState) {
            Bundle extras;
            extras = playbackState.getExtras();
            return extras;
        }

        static void b(PlaybackState.Builder builder, Bundle bundle) {
            builder.setExtras(bundle);
        }
    }

    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        private final List<CustomAction> f271a;

        /* renamed from: b, reason: collision with root package name */
        private int f272b;

        /* renamed from: c, reason: collision with root package name */
        private long f273c;

        /* renamed from: d, reason: collision with root package name */
        private long f274d;

        /* renamed from: e, reason: collision with root package name */
        private float f275e;

        /* renamed from: f, reason: collision with root package name */
        private long f276f;

        /* renamed from: g, reason: collision with root package name */
        private int f277g;

        /* renamed from: h, reason: collision with root package name */
        private CharSequence f278h;

        /* renamed from: i, reason: collision with root package name */
        private long f279i;

        /* renamed from: j, reason: collision with root package name */
        private long f280j;

        /* renamed from: k, reason: collision with root package name */
        private Bundle f281k;

        public d() {
            this.f271a = new ArrayList();
            this.f280j = -1L;
        }

        public d(PlaybackStateCompat playbackStateCompat) {
            ArrayList arrayList = new ArrayList();
            this.f271a = arrayList;
            this.f280j = -1L;
            this.f272b = playbackStateCompat.f254a;
            this.f273c = playbackStateCompat.f255b;
            this.f275e = playbackStateCompat.f257d;
            this.f279i = playbackStateCompat.f261l;
            this.f274d = playbackStateCompat.f256c;
            this.f276f = playbackStateCompat.f258e;
            this.f277g = playbackStateCompat.f259j;
            this.f278h = playbackStateCompat.f260k;
            List<CustomAction> list = playbackStateCompat.f262m;
            if (list != null) {
                arrayList.addAll(list);
            }
            this.f280j = playbackStateCompat.f263n;
            this.f281k = playbackStateCompat.f264o;
        }

        public d a(CustomAction customAction) {
            if (customAction == null) {
                throw new IllegalArgumentException("You may not add a null CustomAction to PlaybackStateCompat");
            }
            this.f271a.add(customAction);
            return this;
        }

        public PlaybackStateCompat b() {
            return new PlaybackStateCompat(this.f272b, this.f273c, this.f274d, this.f275e, this.f276f, this.f277g, this.f278h, this.f279i, this.f271a, this.f280j, this.f281k);
        }

        public d c(long j6) {
            this.f276f = j6;
            return this;
        }

        public d d(long j6) {
            this.f280j = j6;
            return this;
        }

        public d e(long j6) {
            this.f274d = j6;
            return this;
        }

        public d f(int i6, CharSequence charSequence) {
            this.f277g = i6;
            this.f278h = charSequence;
            return this;
        }

        public d g(Bundle bundle) {
            this.f281k = bundle;
            return this;
        }

        public d h(int i6, long j6, float f6) {
            return i(i6, j6, f6, SystemClock.elapsedRealtime());
        }

        public d i(int i6, long j6, float f6, long j7) {
            this.f272b = i6;
            this.f273c = j6;
            this.f279i = j7;
            this.f275e = f6;
            return this;
        }
    }

    PlaybackStateCompat(int i6, long j6, long j7, float f6, long j8, int i7, CharSequence charSequence, long j9, List<CustomAction> list, long j10, Bundle bundle) {
        this.f254a = i6;
        this.f255b = j6;
        this.f256c = j7;
        this.f257d = f6;
        this.f258e = j8;
        this.f259j = i7;
        this.f260k = charSequence;
        this.f261l = j9;
        this.f262m = new ArrayList(list);
        this.f263n = j10;
        this.f264o = bundle;
    }

    PlaybackStateCompat(Parcel parcel) {
        this.f254a = parcel.readInt();
        this.f255b = parcel.readLong();
        this.f257d = parcel.readFloat();
        this.f261l = parcel.readLong();
        this.f256c = parcel.readLong();
        this.f258e = parcel.readLong();
        this.f260k = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f262m = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.f263n = parcel.readLong();
        this.f264o = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        this.f259j = parcel.readInt();
    }

    public static PlaybackStateCompat d(Object obj) {
        ArrayList arrayList;
        Bundle bundle = null;
        if (obj == null) {
            return null;
        }
        PlaybackState playbackState = (PlaybackState) obj;
        List<PlaybackState.CustomAction> j6 = b.j(playbackState);
        if (j6 != null) {
            ArrayList arrayList2 = new ArrayList(j6.size());
            Iterator<PlaybackState.CustomAction> it = j6.iterator();
            while (it.hasNext()) {
                arrayList2.add(CustomAction.d(it.next()));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        if (Build.VERSION.SDK_INT >= 22) {
            bundle = c.a(playbackState);
            MediaSessionCompat.a(bundle);
        }
        PlaybackStateCompat playbackStateCompat = new PlaybackStateCompat(b.r(playbackState), b.q(playbackState), b.i(playbackState), b.p(playbackState), b.g(playbackState), 0, b.k(playbackState), b.n(playbackState), arrayList, b.h(playbackState), bundle);
        playbackStateCompat.f265p = playbackState;
        return playbackStateCompat;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long e() {
        return this.f258e;
    }

    public long f() {
        return this.f263n;
    }

    public long g() {
        return this.f261l;
    }

    public float h() {
        return this.f257d;
    }

    public Object i() {
        if (this.f265p == null) {
            PlaybackState.Builder d6 = b.d();
            b.x(d6, this.f254a, this.f255b, this.f257d, this.f261l);
            b.u(d6, this.f256c);
            b.s(d6, this.f258e);
            b.v(d6, this.f260k);
            Iterator<CustomAction> it = this.f262m.iterator();
            while (it.hasNext()) {
                b.a(d6, (PlaybackState.CustomAction) it.next().f());
            }
            b.t(d6, this.f263n);
            if (Build.VERSION.SDK_INT >= 22) {
                c.b(d6, this.f264o);
            }
            this.f265p = b.c(d6);
        }
        return this.f265p;
    }

    public long j() {
        return this.f255b;
    }

    public int k() {
        return this.f254a;
    }

    public String toString() {
        return "PlaybackState {state=" + this.f254a + ", position=" + this.f255b + ", buffered position=" + this.f256c + ", speed=" + this.f257d + ", updated=" + this.f261l + ", actions=" + this.f258e + ", error code=" + this.f259j + ", error message=" + this.f260k + ", custom actions=" + this.f262m + ", active item id=" + this.f263n + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeInt(this.f254a);
        parcel.writeLong(this.f255b);
        parcel.writeFloat(this.f257d);
        parcel.writeLong(this.f261l);
        parcel.writeLong(this.f256c);
        parcel.writeLong(this.f258e);
        TextUtils.writeToParcel(this.f260k, parcel, i6);
        parcel.writeTypedList(this.f262m);
        parcel.writeLong(this.f263n);
        parcel.writeBundle(this.f264o);
        parcel.writeInt(this.f259j);
    }
}
