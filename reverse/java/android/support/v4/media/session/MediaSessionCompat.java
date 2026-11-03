package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.MediaDescription;
import android.media.MediaMetadata;
import android.media.Rating;
import android.media.session.MediaSession;
import android.media.session.MediaSessionManager;
import android.media.session.PlaybackState;
import android.net.Uri;
import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v4.media.session.b;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import androidx.core.app.k;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class MediaSessionCompat {

    /* renamed from: d, reason: collision with root package name */
    static int f213d;

    /* renamed from: a, reason: collision with root package name */
    private final c f214a;

    /* renamed from: b, reason: collision with root package name */
    private final MediaControllerCompat f215b;

    /* renamed from: c, reason: collision with root package name */
    private final ArrayList<h> f216c;

    public static final class QueueItem implements Parcelable {
        public static final Parcelable.Creator<QueueItem> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        private final MediaDescriptionCompat f217a;

        /* renamed from: b, reason: collision with root package name */
        private final long f218b;

        /* renamed from: c, reason: collision with root package name */
        private MediaSession.QueueItem f219c;

        class a implements Parcelable.Creator<QueueItem> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public QueueItem createFromParcel(Parcel parcel) {
                return new QueueItem(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public QueueItem[] newArray(int i6) {
                return new QueueItem[i6];
            }
        }

        private static class b {
            static MediaSession.QueueItem a(MediaDescription mediaDescription, long j6) {
                return new MediaSession.QueueItem(mediaDescription, j6);
            }

            static MediaDescription b(MediaSession.QueueItem queueItem) {
                return queueItem.getDescription();
            }

            static long c(MediaSession.QueueItem queueItem) {
                return queueItem.getQueueId();
            }
        }

        private QueueItem(MediaSession.QueueItem queueItem, MediaDescriptionCompat mediaDescriptionCompat, long j6) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("Description cannot be null");
            }
            if (j6 == -1) {
                throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
            }
            this.f217a = mediaDescriptionCompat;
            this.f218b = j6;
            this.f219c = queueItem;
        }

        QueueItem(Parcel parcel) {
            this.f217a = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.f218b = parcel.readLong();
        }

        public static QueueItem d(Object obj) {
            if (obj == null) {
                return null;
            }
            MediaSession.QueueItem queueItem = (MediaSession.QueueItem) obj;
            return new QueueItem(queueItem, MediaDescriptionCompat.d(b.b(queueItem)), b.c(queueItem));
        }

        public static List<QueueItem> e(List<?> list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            Iterator<?> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(d(it.next()));
            }
            return arrayList;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public MediaDescriptionCompat f() {
            return this.f217a;
        }

        public long g() {
            return this.f218b;
        }

        public String toString() {
            return "MediaSession.QueueItem {Description=" + this.f217a + ", Id=" + this.f218b + " }";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            this.f217a.writeToParcel(parcel, i6);
            parcel.writeLong(this.f218b);
        }
    }

    static final class ResultReceiverWrapper implements Parcelable {
        public static final Parcelable.Creator<ResultReceiverWrapper> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        ResultReceiver f220a;

        class a implements Parcelable.Creator<ResultReceiverWrapper> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public ResultReceiverWrapper createFromParcel(Parcel parcel) {
                return new ResultReceiverWrapper(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public ResultReceiverWrapper[] newArray(int i6) {
                return new ResultReceiverWrapper[i6];
            }
        }

        ResultReceiverWrapper(Parcel parcel) {
            this.f220a = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            this.f220a.writeToParcel(parcel, i6);
        }
    }

    public static final class Token implements Parcelable {
        public static final Parcelable.Creator<Token> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        private final Object f221a;

        /* renamed from: b, reason: collision with root package name */
        private final Object f222b;

        /* renamed from: c, reason: collision with root package name */
        private android.support.v4.media.session.b f223c;

        /* renamed from: d, reason: collision with root package name */
        private u.b f224d;

        class a implements Parcelable.Creator<Token> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Token createFromParcel(Parcel parcel) {
                return new Token(parcel.readParcelable(null));
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Token[] newArray(int i6) {
                return new Token[i6];
            }
        }

        Token(Object obj) {
            this(obj, null, null);
        }

        Token(Object obj, android.support.v4.media.session.b bVar, u.b bVar2) {
            this.f221a = new Object();
            this.f222b = obj;
            this.f223c = bVar;
            this.f224d = bVar2;
        }

        public android.support.v4.media.session.b d() {
            android.support.v4.media.session.b bVar;
            synchronized (this.f221a) {
                bVar = this.f223c;
            }
            return bVar;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public u.b e() {
            u.b bVar;
            synchronized (this.f221a) {
                bVar = this.f224d;
            }
            return bVar;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Token)) {
                return false;
            }
            Object obj2 = this.f222b;
            Object obj3 = ((Token) obj).f222b;
            if (obj2 == null) {
                return obj3 == null;
            }
            if (obj3 == null) {
                return false;
            }
            return obj2.equals(obj3);
        }

        public Object f() {
            return this.f222b;
        }

        public void g(android.support.v4.media.session.b bVar) {
            synchronized (this.f221a) {
                this.f223c = bVar;
            }
        }

        public void h(u.b bVar) {
            synchronized (this.f221a) {
                this.f224d = bVar;
            }
        }

        public int hashCode() {
            Object obj = this.f222b;
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            parcel.writeParcelable((Parcelable) this.f222b, i6);
        }
    }

    class a extends b {
        a() {
        }
    }

    public static abstract class b {

        /* renamed from: c, reason: collision with root package name */
        private boolean f228c;

        /* renamed from: e, reason: collision with root package name */
        a f230e;

        /* renamed from: a, reason: collision with root package name */
        final Object f226a = new Object();

        /* renamed from: b, reason: collision with root package name */
        final MediaSession.Callback f227b = new C0004b();

        /* renamed from: d, reason: collision with root package name */
        WeakReference<c> f229d = new WeakReference<>(null);

        private class a extends Handler {
            a(Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                c cVar;
                b bVar;
                a aVar;
                if (message.what == 1) {
                    synchronized (b.this.f226a) {
                        cVar = b.this.f229d.get();
                        bVar = b.this;
                        aVar = bVar.f230e;
                    }
                    if (cVar == null || bVar != cVar.i() || aVar == null) {
                        return;
                    }
                    cVar.n((k.a) message.obj);
                    b.this.F(cVar, aVar);
                    cVar.n(null);
                }
            }
        }

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$b$b, reason: collision with other inner class name */
        private class C0004b extends MediaSession.Callback {
            C0004b() {
            }

            private void a(c cVar) {
                cVar.n(null);
            }

            private d b() {
                d dVar;
                synchronized (b.this.f226a) {
                    dVar = (d) b.this.f229d.get();
                }
                if (dVar == null || b.this != dVar.i()) {
                    return null;
                }
                return dVar;
            }

            private void c(c cVar) {
                if (Build.VERSION.SDK_INT >= 28) {
                    return;
                }
                String e6 = cVar.e();
                if (TextUtils.isEmpty(e6)) {
                    e6 = "android.media.session.MediaController";
                }
                cVar.n(new k.a(e6, -1, -1));
            }

            @Override // android.media.session.MediaSession.Callback
            public void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
                b bVar;
                MediaDescriptionCompat f6;
                d b6 = b();
                if (b6 == null) {
                    return;
                }
                MediaSessionCompat.a(bundle);
                c(b6);
                try {
                    QueueItem queueItem = null;
                    IBinder asBinder = null;
                    queueItem = null;
                    if (str.equals("android.support.v4.media.session.command.GET_EXTRA_BINDER")) {
                        Bundle bundle2 = new Bundle();
                        Token d6 = b6.d();
                        android.support.v4.media.session.b d7 = d6.d();
                        if (d7 != null) {
                            asBinder = d7.asBinder();
                        }
                        k.b(bundle2, "android.support.v4.media.session.EXTRA_BINDER", asBinder);
                        u.a.c(bundle2, "android.support.v4.media.session.SESSION_TOKEN2", d6.e());
                        resultReceiver.send(0, bundle2);
                    } else if (str.equals("android.support.v4.media.session.command.ADD_QUEUE_ITEM")) {
                        b.this.H((MediaDescriptionCompat) bundle.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION"));
                    } else if (str.equals("android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT")) {
                        b.this.N((MediaDescriptionCompat) bundle.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION"), bundle.getInt("android.support.v4.media.session.command.ARGUMENT_INDEX"));
                    } else {
                        if (str.equals("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM")) {
                            bVar = b.this;
                            f6 = (MediaDescriptionCompat) bundle.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION");
                        } else if (!str.equals("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM_AT")) {
                            b.this.P(str, bundle, resultReceiver);
                        } else if (b6.f240h != null) {
                            int i6 = bundle.getInt("android.support.v4.media.session.command.ARGUMENT_INDEX", -1);
                            if (i6 >= 0 && i6 < b6.f240h.size()) {
                                queueItem = b6.f240h.get(i6);
                            }
                            if (queueItem != null) {
                                bVar = b.this;
                                f6 = queueItem.f();
                            }
                        }
                        bVar.t0(f6);
                    }
                } catch (BadParcelableException unused) {
                    Log.e("MediaSessionCompat", "Could not unparcel the extra data.");
                }
                a(b6);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onCustomAction(String str, Bundle bundle) {
                d b6 = b();
                if (b6 == null) {
                    return;
                }
                MediaSessionCompat.a(bundle);
                c(b6);
                try {
                    if (str.equals("android.support.v4.media.session.action.PLAY_FROM_URI")) {
                        Uri uri = (Uri) bundle.getParcelable("android.support.v4.media.session.action.ARGUMENT_URI");
                        Bundle bundle2 = bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS");
                        MediaSessionCompat.a(bundle2);
                        b.this.h0(uri, bundle2);
                    } else if (str.equals("android.support.v4.media.session.action.PREPARE")) {
                        b.this.j0();
                    } else if (str.equals("android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID")) {
                        String string = bundle.getString("android.support.v4.media.session.action.ARGUMENT_MEDIA_ID");
                        Bundle bundle3 = bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS");
                        MediaSessionCompat.a(bundle3);
                        b.this.n0(string, bundle3);
                    } else if (str.equals("android.support.v4.media.session.action.PREPARE_FROM_SEARCH")) {
                        String string2 = bundle.getString("android.support.v4.media.session.action.ARGUMENT_QUERY");
                        Bundle bundle4 = bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS");
                        MediaSessionCompat.a(bundle4);
                        b.this.r0(string2, bundle4);
                    } else if (str.equals("android.support.v4.media.session.action.PREPARE_FROM_URI")) {
                        Uri uri2 = (Uri) bundle.getParcelable("android.support.v4.media.session.action.ARGUMENT_URI");
                        Bundle bundle5 = bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS");
                        MediaSessionCompat.a(bundle5);
                        b.this.s0(uri2, bundle5);
                    } else if (str.equals("android.support.v4.media.session.action.SET_CAPTIONING_ENABLED")) {
                        b.this.w0(bundle.getBoolean("android.support.v4.media.session.action.ARGUMENT_CAPTIONING_ENABLED"));
                    } else if (str.equals("android.support.v4.media.session.action.SET_REPEAT_MODE")) {
                        b.this.A0(bundle.getInt("android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE"));
                    } else if (str.equals("android.support.v4.media.session.action.SET_SHUFFLE_MODE")) {
                        b.this.B0(bundle.getInt("android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE"));
                    } else if (str.equals("android.support.v4.media.session.action.SET_RATING")) {
                        RatingCompat ratingCompat = (RatingCompat) bundle.getParcelable("android.support.v4.media.session.action.ARGUMENT_RATING");
                        Bundle bundle6 = bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS");
                        MediaSessionCompat.a(bundle6);
                        b.this.z0(ratingCompat, bundle6);
                    } else if (str.equals("android.support.v4.media.session.action.SET_PLAYBACK_SPEED")) {
                        b.this.x0(bundle.getFloat("android.support.v4.media.session.action.ARGUMENT_PLAYBACK_SPEED", 1.0f));
                    } else {
                        b.this.Q(str, bundle);
                    }
                } catch (BadParcelableException unused) {
                    Log.e("MediaSessionCompat", "Could not unparcel the data.");
                }
                a(b6);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onFastForward() {
                d b6 = b();
                if (b6 == null) {
                    return;
                }
                c(b6);
                b.this.X();
                a(b6);
            }

            @Override // android.media.session.MediaSession.Callback
            public boolean onMediaButtonEvent(Intent intent) {
                d b6 = b();
                if (b6 == null) {
                    return false;
                }
                c(b6);
                boolean Y = b.this.Y(intent);
                a(b6);
                return Y || super.onMediaButtonEvent(intent);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPause() {
                d b6 = b();
                if (b6 == null) {
                    return;
                }
                c(b6);
                b.this.Z();
                a(b6);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPlay() {
                d b6 = b();
                if (b6 == null) {
                    return;
                }
                c(b6);
                b.this.b0();
                a(b6);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPlayFromMediaId(String str, Bundle bundle) {
                d b6 = b();
                if (b6 == null) {
                    return;
                }
                MediaSessionCompat.a(bundle);
                c(b6);
                b.this.c0(str, bundle);
                a(b6);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPlayFromSearch(String str, Bundle bundle) {
                d b6 = b();
                if (b6 == null) {
                    return;
                }
                MediaSessionCompat.a(bundle);
                c(b6);
                b.this.g0(str, bundle);
                a(b6);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPlayFromUri(Uri uri, Bundle bundle) {
                d b6 = b();
                if (b6 == null) {
                    return;
                }
                MediaSessionCompat.a(bundle);
                c(b6);
                b.this.h0(uri, bundle);
                a(b6);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPrepare() {
                d b6 = b();
                if (b6 == null) {
                    return;
                }
                c(b6);
                b.this.j0();
                a(b6);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPrepareFromMediaId(String str, Bundle bundle) {
                d b6 = b();
                if (b6 == null) {
                    return;
                }
                MediaSessionCompat.a(bundle);
                c(b6);
                b.this.n0(str, bundle);
                a(b6);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPrepareFromSearch(String str, Bundle bundle) {
                d b6 = b();
                if (b6 == null) {
                    return;
                }
                MediaSessionCompat.a(bundle);
                c(b6);
                b.this.r0(str, bundle);
                a(b6);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPrepareFromUri(Uri uri, Bundle bundle) {
                d b6 = b();
                if (b6 == null) {
                    return;
                }
                MediaSessionCompat.a(bundle);
                c(b6);
                b.this.s0(uri, bundle);
                a(b6);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onRewind() {
                d b6 = b();
                if (b6 == null) {
                    return;
                }
                c(b6);
                b.this.u0();
                a(b6);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onSeekTo(long j6) {
                d b6 = b();
                if (b6 == null) {
                    return;
                }
                c(b6);
                b.this.v0(j6);
                a(b6);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onSetPlaybackSpeed(float f6) {
                d b6 = b();
                if (b6 == null) {
                    return;
                }
                c(b6);
                b.this.x0(f6);
                a(b6);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onSetRating(Rating rating) {
                d b6 = b();
                if (b6 == null) {
                    return;
                }
                c(b6);
                b.this.y0(RatingCompat.d(rating));
                a(b6);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onSkipToNext() {
                d b6 = b();
                if (b6 == null) {
                    return;
                }
                c(b6);
                b.this.C0();
                a(b6);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onSkipToPrevious() {
                d b6 = b();
                if (b6 == null) {
                    return;
                }
                c(b6);
                b.this.D0();
                a(b6);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onSkipToQueueItem(long j6) {
                d b6 = b();
                if (b6 == null) {
                    return;
                }
                c(b6);
                b.this.E0(j6);
                a(b6);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onStop() {
                d b6 = b();
                if (b6 == null) {
                    return;
                }
                c(b6);
                b.this.F0();
                a(b6);
            }
        }

        public void A0(int i6) {
        }

        public void B0(int i6) {
        }

        public void C0() {
        }

        public void D0() {
        }

        public void E0(long j6) {
        }

        void F(c cVar, Handler handler) {
            if (this.f228c) {
                this.f228c = false;
                handler.removeMessages(1);
                PlaybackStateCompat c6 = cVar.c();
                long e6 = c6 == null ? 0L : c6.e();
                boolean z5 = c6 != null && c6.k() == 3;
                boolean z6 = (516 & e6) != 0;
                boolean z7 = (e6 & 514) != 0;
                if (z5 && z7) {
                    Z();
                } else {
                    if (z5 || !z6) {
                        return;
                    }
                    b0();
                }
            }
        }

        public void F0() {
        }

        void G0(c cVar, Handler handler) {
            synchronized (this.f226a) {
                this.f229d = new WeakReference<>(cVar);
                a aVar = this.f230e;
                a aVar2 = null;
                if (aVar != null) {
                    aVar.removeCallbacksAndMessages(null);
                }
                if (cVar != null && handler != null) {
                    aVar2 = new a(handler.getLooper());
                }
                this.f230e = aVar2;
            }
        }

        public void H(MediaDescriptionCompat mediaDescriptionCompat) {
        }

        public void N(MediaDescriptionCompat mediaDescriptionCompat, int i6) {
        }

        public void P(String str, Bundle bundle, ResultReceiver resultReceiver) {
        }

        public void Q(String str, Bundle bundle) {
        }

        public void X() {
        }

        public boolean Y(Intent intent) {
            c cVar;
            a aVar;
            KeyEvent keyEvent;
            if (Build.VERSION.SDK_INT >= 27) {
                return false;
            }
            synchronized (this.f226a) {
                cVar = this.f229d.get();
                aVar = this.f230e;
            }
            if (cVar == null || aVar == null || (keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT")) == null || keyEvent.getAction() != 0) {
                return false;
            }
            k.a l6 = cVar.l();
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 79 && keyCode != 85) {
                F(cVar, aVar);
                return false;
            }
            if (keyEvent.getRepeatCount() != 0) {
                F(cVar, aVar);
            } else if (this.f228c) {
                aVar.removeMessages(1);
                this.f228c = false;
                PlaybackStateCompat c6 = cVar.c();
                if (((c6 == null ? 0L : c6.e()) & 32) != 0) {
                    C0();
                }
            } else {
                this.f228c = true;
                aVar.sendMessageDelayed(aVar.obtainMessage(1, l6), ViewConfiguration.getDoubleTapTimeout());
            }
            return true;
        }

        public void Z() {
        }

        public void b0() {
        }

        public void c0(String str, Bundle bundle) {
        }

        public void g0(String str, Bundle bundle) {
        }

        public void h0(Uri uri, Bundle bundle) {
        }

        public void j0() {
        }

        public void n0(String str, Bundle bundle) {
        }

        public void r0(String str, Bundle bundle) {
        }

        public void s0(Uri uri, Bundle bundle) {
        }

        public void t0(MediaDescriptionCompat mediaDescriptionCompat) {
        }

        public void u0() {
        }

        public void v0(long j6) {
        }

        public void w0(boolean z5) {
        }

        public void x0(float f6) {
        }

        public void y0(RatingCompat ratingCompat) {
        }

        public void z0(RatingCompat ratingCompat, Bundle bundle) {
        }
    }

    interface c {
        void a();

        void b(boolean z5);

        PlaybackStateCompat c();

        Token d();

        String e();

        void f(PlaybackStateCompat playbackStateCompat);

        void g(int i6);

        void h(b bVar, Handler handler);

        b i();

        void j(MediaMetadataCompat mediaMetadataCompat);

        void k(PendingIntent pendingIntent);

        k.a l();

        void m(int i6);

        void n(k.a aVar);

        void o(int i6);
    }

    static class d implements c {

        /* renamed from: a, reason: collision with root package name */
        final MediaSession f233a;

        /* renamed from: b, reason: collision with root package name */
        final Token f234b;

        /* renamed from: d, reason: collision with root package name */
        Bundle f236d;

        /* renamed from: g, reason: collision with root package name */
        PlaybackStateCompat f239g;

        /* renamed from: h, reason: collision with root package name */
        List<QueueItem> f240h;

        /* renamed from: i, reason: collision with root package name */
        MediaMetadataCompat f241i;

        /* renamed from: j, reason: collision with root package name */
        int f242j;

        /* renamed from: k, reason: collision with root package name */
        boolean f243k;

        /* renamed from: l, reason: collision with root package name */
        int f244l;

        /* renamed from: m, reason: collision with root package name */
        int f245m;

        /* renamed from: n, reason: collision with root package name */
        b f246n;

        /* renamed from: o, reason: collision with root package name */
        k.a f247o;

        /* renamed from: c, reason: collision with root package name */
        final Object f235c = new Object();

        /* renamed from: e, reason: collision with root package name */
        boolean f237e = false;

        /* renamed from: f, reason: collision with root package name */
        final RemoteCallbackList<android.support.v4.media.session.a> f238f = new RemoteCallbackList<>();

        class a extends b.a {
            a() {
            }

            @Override // android.support.v4.media.session.b
            public void A(int i6, int i7, String str) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void B(Uri uri, Bundle bundle) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void C(MediaDescriptionCompat mediaDescriptionCompat) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public boolean D() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void E(MediaDescriptionCompat mediaDescriptionCompat) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public PendingIntent F() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public int G() {
                return d.this.f245m;
            }

            @Override // android.support.v4.media.session.b
            public void H(int i6) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public int I() {
                return d.this.f242j;
            }

            @Override // android.support.v4.media.session.b
            public void J(String str, Bundle bundle) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public boolean K() {
                return d.this.f243k;
            }

            @Override // android.support.v4.media.session.b
            public void O(String str, Bundle bundle, ResultReceiverWrapper resultReceiverWrapper) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void R() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public CharSequence S() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void T(String str, Bundle bundle) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public Bundle U() {
                if (d.this.f236d == null) {
                    return null;
                }
                return new Bundle(d.this.f236d);
            }

            @Override // android.support.v4.media.session.b
            public void V(android.support.v4.media.session.a aVar) {
                d.this.f238f.unregister(aVar);
                Binder.getCallingPid();
                Binder.getCallingUid();
                synchronized (d.this.f235c) {
                    d.this.getClass();
                }
            }

            @Override // android.support.v4.media.session.b
            public void W(String str, Bundle bundle) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public long X() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void Y(long j6) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void Z(boolean z5) {
            }

            @Override // android.support.v4.media.session.b
            public void a0(String str, Bundle bundle) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void b() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public ParcelableVolumeInfo b0() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public PlaybackStateCompat c() {
                d dVar = d.this;
                return MediaSessionCompat.d(dVar.f239g, dVar.f241i);
            }

            @Override // android.support.v4.media.session.b
            public void c0() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void d() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void d0(Uri uri, Bundle bundle) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void e() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void f() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void g(int i6) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public Bundle getExtras() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public List<QueueItem> h() {
                return null;
            }

            @Override // android.support.v4.media.session.b
            public String h0() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public MediaMetadataCompat j() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public int k() {
                return d.this.f244l;
            }

            @Override // android.support.v4.media.session.b
            public void l(long j6) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void l0(float f6) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void m(int i6) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void next() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public boolean o0(KeyEvent keyEvent) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void p(String str, Bundle bundle) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void previous() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void q(int i6, int i7, String str) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void r(android.support.v4.media.session.a aVar) {
                if (d.this.f237e) {
                    return;
                }
                d.this.f238f.register(aVar, new k.a("android.media.session.MediaController", Binder.getCallingPid(), Binder.getCallingUid()));
                synchronized (d.this.f235c) {
                    d.this.getClass();
                }
            }

            @Override // android.support.v4.media.session.b
            public void s(RatingCompat ratingCompat, Bundle bundle) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void u(MediaDescriptionCompat mediaDescriptionCompat, int i6) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public String w() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public boolean x() {
                return false;
            }

            @Override // android.support.v4.media.session.b
            public void y(boolean z5) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void z(RatingCompat ratingCompat) {
                throw new AssertionError();
            }
        }

        d(Context context, String str, u.b bVar, Bundle bundle) {
            MediaSession p6 = p(context, str, bundle);
            this.f233a = p6;
            this.f234b = new Token(p6.getSessionToken(), new a(), bVar);
            this.f236d = bundle;
            o(3);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void a() {
            this.f237e = true;
            this.f238f.kill();
            if (Build.VERSION.SDK_INT == 27) {
                try {
                    Field declaredField = this.f233a.getClass().getDeclaredField("mCallback");
                    declaredField.setAccessible(true);
                    Handler handler = (Handler) declaredField.get(this.f233a);
                    if (handler != null) {
                        handler.removeCallbacksAndMessages(null);
                    }
                } catch (Exception e6) {
                    Log.w("MediaSessionCompat", "Exception happened while accessing MediaSession.mCallback.", e6);
                }
            }
            this.f233a.setCallback(null);
            this.f233a.release();
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void b(boolean z5) {
            this.f233a.setActive(z5);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public PlaybackStateCompat c() {
            return this.f239g;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public Token d() {
            return this.f234b;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public String e() {
            if (Build.VERSION.SDK_INT < 24) {
                return null;
            }
            try {
                return (String) this.f233a.getClass().getMethod("getCallingPackage", new Class[0]).invoke(this.f233a, new Object[0]);
            } catch (Exception e6) {
                Log.e("MediaSessionCompat", "Cannot execute MediaSession.getCallingPackage()", e6);
                return null;
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void f(PlaybackStateCompat playbackStateCompat) {
            this.f239g = playbackStateCompat;
            synchronized (this.f235c) {
                for (int beginBroadcast = this.f238f.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        this.f238f.getBroadcastItem(beginBroadcast).j0(playbackStateCompat);
                    } catch (RemoteException unused) {
                    }
                }
                this.f238f.finishBroadcast();
            }
            this.f233a.setPlaybackState(playbackStateCompat == null ? null : (PlaybackState) playbackStateCompat.i());
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void g(int i6) {
            if (this.f244l != i6) {
                this.f244l = i6;
                synchronized (this.f235c) {
                    for (int beginBroadcast = this.f238f.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                        try {
                            this.f238f.getBroadcastItem(beginBroadcast).i(i6);
                        } catch (RemoteException unused) {
                        }
                    }
                    this.f238f.finishBroadcast();
                }
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void h(b bVar, Handler handler) {
            synchronized (this.f235c) {
                this.f246n = bVar;
                this.f233a.setCallback(bVar == null ? null : bVar.f227b, handler);
                if (bVar != null) {
                    bVar.G0(this, handler);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public b i() {
            b bVar;
            synchronized (this.f235c) {
                bVar = this.f246n;
            }
            return bVar;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void j(MediaMetadataCompat mediaMetadataCompat) {
            this.f241i = mediaMetadataCompat;
            this.f233a.setMetadata(mediaMetadataCompat == null ? null : (MediaMetadata) mediaMetadataCompat.h());
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void k(PendingIntent pendingIntent) {
            this.f233a.setMediaButtonReceiver(pendingIntent);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public k.a l() {
            k.a aVar;
            synchronized (this.f235c) {
                aVar = this.f247o;
            }
            return aVar;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void m(int i6) {
            if (this.f245m != i6) {
                this.f245m = i6;
                synchronized (this.f235c) {
                    for (int beginBroadcast = this.f238f.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                        try {
                            this.f238f.getBroadcastItem(beginBroadcast).L(i6);
                        } catch (RemoteException unused) {
                        }
                    }
                    this.f238f.finishBroadcast();
                }
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void n(k.a aVar) {
            synchronized (this.f235c) {
                this.f247o = aVar;
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void o(int i6) {
            this.f233a.setFlags(i6 | 1 | 2);
        }

        public MediaSession p(Context context, String str, Bundle bundle) {
            return new MediaSession(context, str);
        }
    }

    static class e extends d {
        e(Context context, String str, u.b bVar, Bundle bundle) {
            super(context, str, bVar, bundle);
        }
    }

    static class f extends e {
        f(Context context, String str, u.b bVar, Bundle bundle) {
            super(context, str, bVar, bundle);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.d, android.support.v4.media.session.MediaSessionCompat.c
        public final k.a l() {
            MediaSessionManager.RemoteUserInfo currentControllerInfo;
            currentControllerInfo = this.f233a.getCurrentControllerInfo();
            return new k.a(currentControllerInfo);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.d, android.support.v4.media.session.MediaSessionCompat.c
        public void n(k.a aVar) {
        }
    }

    static class g extends f {
        g(Context context, String str, u.b bVar, Bundle bundle) {
            super(context, str, bVar, bundle);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.d
        public MediaSession p(Context context, String str, Bundle bundle) {
            return new MediaSession(context, str, bundle);
        }
    }

    public interface h {
        void a();
    }

    public MediaSessionCompat(Context context, String str, ComponentName componentName, PendingIntent pendingIntent) {
        this(context, str, componentName, pendingIntent, null);
    }

    public MediaSessionCompat(Context context, String str, ComponentName componentName, PendingIntent pendingIntent, Bundle bundle) {
        this(context, str, componentName, pendingIntent, bundle, null);
    }

    public MediaSessionCompat(Context context, String str, ComponentName componentName, PendingIntent pendingIntent, Bundle bundle, u.b bVar) {
        this.f216c = new ArrayList<>();
        if (context == null) {
            throw new IllegalArgumentException("context must not be null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("tag must not be null or empty");
        }
        if (componentName == null && (componentName = l.a.a(context)) == null) {
            Log.w("MediaSessionCompat", "Couldn't find a unique registered media button receiver in the given context.");
        }
        if (componentName != null && pendingIntent == null) {
            Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
            intent.setComponent(componentName);
            pendingIntent = PendingIntent.getBroadcast(context, 0, intent, Build.VERSION.SDK_INT >= 31 ? 33554432 : 0);
        }
        int i6 = Build.VERSION.SDK_INT;
        this.f214a = i6 >= 29 ? new g(context, str, bVar, bundle) : i6 >= 28 ? new f(context, str, bVar, bundle) : i6 >= 22 ? new e(context, str, bVar, bundle) : new d(context, str, bVar, bundle);
        h(new a(), new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper()));
        this.f214a.k(pendingIntent);
        this.f215b = new MediaControllerCompat(context, this);
        if (f213d == 0) {
            f213d = (int) (TypedValue.applyDimension(1, 320.0f, context.getResources().getDisplayMetrics()) + 0.5f);
        }
    }

    public static void a(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MediaSessionCompat.class.getClassLoader());
        }
    }

    static PlaybackStateCompat d(PlaybackStateCompat playbackStateCompat, MediaMetadataCompat mediaMetadataCompat) {
        if (playbackStateCompat == null) {
            return playbackStateCompat;
        }
        long j6 = -1;
        if (playbackStateCompat.j() == -1) {
            return playbackStateCompat;
        }
        if (playbackStateCompat.k() != 3 && playbackStateCompat.k() != 4 && playbackStateCompat.k() != 5) {
            return playbackStateCompat;
        }
        if (playbackStateCompat.g() <= 0) {
            return playbackStateCompat;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long h6 = ((long) (playbackStateCompat.h() * (elapsedRealtime - r0))) + playbackStateCompat.j();
        if (mediaMetadataCompat != null && mediaMetadataCompat.d("android.media.metadata.DURATION")) {
            j6 = mediaMetadataCompat.g("android.media.metadata.DURATION");
        }
        return new PlaybackStateCompat.d(playbackStateCompat).i(playbackStateCompat.k(), (j6 < 0 || h6 <= j6) ? h6 < 0 ? 0L : h6 : j6, playbackStateCompat.h(), elapsedRealtime).b();
    }

    public static Bundle n(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        a(bundle);
        try {
            bundle.isEmpty();
            return bundle;
        } catch (BadParcelableException unused) {
            Log.e("MediaSessionCompat", "Could not unparcel the data.");
            return null;
        }
    }

    public MediaControllerCompat b() {
        return this.f215b;
    }

    public Token c() {
        return this.f214a.d();
    }

    public void e() {
        this.f214a.a();
    }

    public void f(boolean z5) {
        this.f214a.b(z5);
        Iterator<h> it = this.f216c.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public void g(b bVar) {
        h(bVar, null);
    }

    public void h(b bVar, Handler handler) {
        if (bVar == null) {
            this.f214a.h(null, null);
            return;
        }
        c cVar = this.f214a;
        if (handler == null) {
            handler = new Handler();
        }
        cVar.h(bVar, handler);
    }

    public void i(int i6) {
        this.f214a.o(i6);
    }

    public void j(MediaMetadataCompat mediaMetadataCompat) {
        this.f214a.j(mediaMetadataCompat);
    }

    public void k(PlaybackStateCompat playbackStateCompat) {
        this.f214a.f(playbackStateCompat);
    }

    public void l(int i6) {
        this.f214a.g(i6);
    }

    public void m(int i6) {
        this.f214a.m(i6);
    }
}
