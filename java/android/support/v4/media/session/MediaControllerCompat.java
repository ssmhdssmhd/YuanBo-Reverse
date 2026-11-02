package android.support.v4.media.session;

import android.content.Context;
import android.media.MediaMetadata;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.a;
import android.support.v4.media.session.b;
import android.util.Log;
import androidx.core.app.k;
import androidx.media.AudioAttributesCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class MediaControllerCompat {

    /* renamed from: a, reason: collision with root package name */
    private final b f195a;

    /* renamed from: b, reason: collision with root package name */
    private final MediaSessionCompat.Token f196b;

    /* renamed from: c, reason: collision with root package name */
    private final ConcurrentHashMap<a, Boolean> f197c = new ConcurrentHashMap<>();

    static class MediaControllerImplApi21 implements b {

        /* renamed from: a, reason: collision with root package name */
        protected final MediaController f198a;

        /* renamed from: b, reason: collision with root package name */
        final Object f199b = new Object();

        /* renamed from: c, reason: collision with root package name */
        private final List<a> f200c = new ArrayList();

        /* renamed from: d, reason: collision with root package name */
        private HashMap<a, a> f201d = new HashMap<>();

        /* renamed from: e, reason: collision with root package name */
        final MediaSessionCompat.Token f202e;

        private static class ExtraBinderRequestResultReceiver extends ResultReceiver {

            /* renamed from: a, reason: collision with root package name */
            private WeakReference<MediaControllerImplApi21> f203a;

            ExtraBinderRequestResultReceiver(MediaControllerImplApi21 mediaControllerImplApi21) {
                super(null);
                this.f203a = new WeakReference<>(mediaControllerImplApi21);
            }

            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int i6, Bundle bundle) {
                MediaControllerImplApi21 mediaControllerImplApi21 = this.f203a.get();
                if (mediaControllerImplApi21 == null || bundle == null) {
                    return;
                }
                synchronized (mediaControllerImplApi21.f199b) {
                    mediaControllerImplApi21.f202e.g(b.a.p0(k.a(bundle, "android.support.v4.media.session.EXTRA_BINDER")));
                    mediaControllerImplApi21.f202e.h(u.a.b(bundle, "android.support.v4.media.session.SESSION_TOKEN2"));
                    mediaControllerImplApi21.a();
                }
            }
        }

        private static class a extends a.b {
            a(a aVar) {
                super(aVar);
            }

            @Override // android.support.v4.media.session.a
            public void N(Bundle bundle) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.a
            public void P(List<MediaSessionCompat.QueueItem> list) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.a
            public void n0(ParcelableVolumeInfo parcelableVolumeInfo) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.a
            public void o(CharSequence charSequence) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.a
            public void t() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.a
            public void v(MediaMetadataCompat mediaMetadataCompat) {
                throw new AssertionError();
            }
        }

        MediaControllerImplApi21(Context context, MediaSessionCompat.Token token) {
            this.f202e = token;
            this.f198a = new MediaController(context, (MediaSession.Token) token.f());
            if (token.d() == null) {
                b();
            }
        }

        private void b() {
            d("android.support.v4.media.session.command.GET_EXTRA_BINDER", null, new ExtraBinderRequestResultReceiver(this));
        }

        void a() {
            if (this.f202e.d() == null) {
                return;
            }
            for (a aVar : this.f200c) {
                a aVar2 = new a(aVar);
                this.f201d.put(aVar, aVar2);
                aVar.f205b = aVar2;
                try {
                    this.f202e.d().r(aVar2);
                    aVar.i(13, null, null);
                } catch (RemoteException e6) {
                    Log.e("MediaControllerCompat", "Dead object in registerCallback.", e6);
                }
            }
            this.f200c.clear();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public PlaybackStateCompat c() {
            if (this.f202e.d() != null) {
                try {
                    return this.f202e.d().c();
                } catch (RemoteException e6) {
                    Log.e("MediaControllerCompat", "Dead object in getPlaybackState.", e6);
                }
            }
            PlaybackState playbackState = this.f198a.getPlaybackState();
            if (playbackState != null) {
                return PlaybackStateCompat.d(playbackState);
            }
            return null;
        }

        public void d(String str, Bundle bundle, ResultReceiver resultReceiver) {
            this.f198a.sendCommand(str, bundle, resultReceiver);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public List<MediaSessionCompat.QueueItem> h() {
            List<MediaSession.QueueItem> queue = this.f198a.getQueue();
            if (queue != null) {
                return MediaSessionCompat.QueueItem.e(queue);
            }
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public MediaMetadataCompat j() {
            MediaMetadata metadata = this.f198a.getMetadata();
            if (metadata != null) {
                return MediaMetadataCompat.e(metadata);
            }
            return null;
        }
    }

    public static abstract class a implements IBinder.DeathRecipient {

        /* renamed from: a, reason: collision with root package name */
        final MediaController.Callback f204a = new C0003a(this);

        /* renamed from: b, reason: collision with root package name */
        android.support.v4.media.session.a f205b;

        /* renamed from: android.support.v4.media.session.MediaControllerCompat$a$a, reason: collision with other inner class name */
        private static class C0003a extends MediaController.Callback {

            /* renamed from: a, reason: collision with root package name */
            private final WeakReference<a> f206a;

            C0003a(a aVar) {
                this.f206a = new WeakReference<>(aVar);
            }

            @Override // android.media.session.MediaController.Callback
            public void onAudioInfoChanged(MediaController.PlaybackInfo playbackInfo) {
                a aVar = this.f206a.get();
                if (aVar != null) {
                    aVar.a(new d(playbackInfo.getPlaybackType(), AudioAttributesCompat.c(playbackInfo.getAudioAttributes()), playbackInfo.getVolumeControl(), playbackInfo.getMaxVolume(), playbackInfo.getCurrentVolume()));
                }
            }

            @Override // android.media.session.MediaController.Callback
            public void onExtrasChanged(Bundle bundle) {
                MediaSessionCompat.a(bundle);
                a aVar = this.f206a.get();
                if (aVar != null) {
                    aVar.b(bundle);
                }
            }

            @Override // android.media.session.MediaController.Callback
            public void onMetadataChanged(MediaMetadata mediaMetadata) {
                a aVar = this.f206a.get();
                if (aVar != null) {
                    aVar.c(MediaMetadataCompat.e(mediaMetadata));
                }
            }

            @Override // android.media.session.MediaController.Callback
            public void onPlaybackStateChanged(PlaybackState playbackState) {
                a aVar = this.f206a.get();
                if (aVar == null || aVar.f205b != null) {
                    return;
                }
                aVar.d(PlaybackStateCompat.d(playbackState));
            }

            @Override // android.media.session.MediaController.Callback
            public void onQueueChanged(List<MediaSession.QueueItem> list) {
                a aVar = this.f206a.get();
                if (aVar != null) {
                    aVar.e(MediaSessionCompat.QueueItem.e(list));
                }
            }

            @Override // android.media.session.MediaController.Callback
            public void onQueueTitleChanged(CharSequence charSequence) {
                a aVar = this.f206a.get();
                if (aVar != null) {
                    aVar.f(charSequence);
                }
            }

            @Override // android.media.session.MediaController.Callback
            public void onSessionDestroyed() {
                a aVar = this.f206a.get();
                if (aVar != null) {
                    aVar.g();
                }
            }

            @Override // android.media.session.MediaController.Callback
            public void onSessionEvent(String str, Bundle bundle) {
                MediaSessionCompat.a(bundle);
                a aVar = this.f206a.get();
                if (aVar != null) {
                    if (aVar.f205b == null || Build.VERSION.SDK_INT >= 23) {
                        aVar.h(str, bundle);
                    }
                }
            }
        }

        private static class b extends a.AbstractBinderC0005a {

            /* renamed from: a, reason: collision with root package name */
            private final WeakReference<a> f207a;

            b(a aVar) {
                this.f207a = new WeakReference<>(aVar);
            }

            @Override // android.support.v4.media.session.a
            public void L(int i6) {
                a aVar = this.f207a.get();
                if (aVar != null) {
                    aVar.i(12, Integer.valueOf(i6), null);
                }
            }

            @Override // android.support.v4.media.session.a
            public void M() {
                a aVar = this.f207a.get();
                if (aVar != null) {
                    aVar.i(13, null, null);
                }
            }

            @Override // android.support.v4.media.session.a
            public void f0(boolean z5) {
                a aVar = this.f207a.get();
                if (aVar != null) {
                    aVar.i(11, Boolean.valueOf(z5), null);
                }
            }

            @Override // android.support.v4.media.session.a
            public void i(int i6) {
                a aVar = this.f207a.get();
                if (aVar != null) {
                    aVar.i(9, Integer.valueOf(i6), null);
                }
            }

            @Override // android.support.v4.media.session.a
            public void j0(PlaybackStateCompat playbackStateCompat) {
                a aVar = this.f207a.get();
                if (aVar != null) {
                    aVar.i(2, playbackStateCompat, null);
                }
            }

            @Override // android.support.v4.media.session.a
            public void k0(String str, Bundle bundle) {
                a aVar = this.f207a.get();
                if (aVar != null) {
                    aVar.i(1, str, bundle);
                }
            }

            @Override // android.support.v4.media.session.a
            public void n(boolean z5) {
            }
        }

        public void a(d dVar) {
        }

        public void b(Bundle bundle) {
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            i(8, null, null);
        }

        public void c(MediaMetadataCompat mediaMetadataCompat) {
        }

        public void d(PlaybackStateCompat playbackStateCompat) {
        }

        public void e(List<MediaSessionCompat.QueueItem> list) {
        }

        public void f(CharSequence charSequence) {
        }

        public void g() {
        }

        public void h(String str, Bundle bundle) {
        }

        void i(int i6, Object obj, Bundle bundle) {
        }
    }

    interface b {
        PlaybackStateCompat c();

        List<MediaSessionCompat.QueueItem> h();

        MediaMetadataCompat j();
    }

    static class c extends MediaControllerImplApi21 {
        c(Context context, MediaSessionCompat.Token token) {
            super(context, token);
        }
    }

    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        private final int f208a;

        /* renamed from: b, reason: collision with root package name */
        private final AudioAttributesCompat f209b;

        /* renamed from: c, reason: collision with root package name */
        private final int f210c;

        /* renamed from: d, reason: collision with root package name */
        private final int f211d;

        /* renamed from: e, reason: collision with root package name */
        private final int f212e;

        d(int i6, AudioAttributesCompat audioAttributesCompat, int i7, int i8, int i9) {
            this.f208a = i6;
            this.f209b = audioAttributesCompat;
            this.f210c = i7;
            this.f211d = i8;
            this.f212e = i9;
        }
    }

    public MediaControllerCompat(Context context, MediaSessionCompat mediaSessionCompat) {
        if (mediaSessionCompat == null) {
            throw new IllegalArgumentException("session must not be null");
        }
        MediaSessionCompat.Token c6 = mediaSessionCompat.c();
        this.f196b = c6;
        this.f195a = Build.VERSION.SDK_INT >= 29 ? new c(context, c6) : new MediaControllerImplApi21(context, c6);
    }

    public MediaMetadataCompat a() {
        return this.f195a.j();
    }

    public PlaybackStateCompat b() {
        return this.f195a.c();
    }

    public List<MediaSessionCompat.QueueItem> c() {
        return this.f195a.h();
    }
}
