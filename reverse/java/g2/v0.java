package g2;

import android.net.Uri;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.SocketTimeoutException;

/* loaded from: classes.dex */
public final class v0 extends g {

    /* renamed from: e, reason: collision with root package name */
    private final int f4211e;

    /* renamed from: f, reason: collision with root package name */
    private final byte[] f4212f;

    /* renamed from: g, reason: collision with root package name */
    private final DatagramPacket f4213g;

    /* renamed from: h, reason: collision with root package name */
    private Uri f4214h;

    /* renamed from: i, reason: collision with root package name */
    private DatagramSocket f4215i;

    /* renamed from: j, reason: collision with root package name */
    private MulticastSocket f4216j;

    /* renamed from: k, reason: collision with root package name */
    private InetAddress f4217k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f4218l;

    /* renamed from: m, reason: collision with root package name */
    private int f4219m;

    public static final class a extends n {
        public a(Throwable th, int i6) {
            super(th, i6);
        }
    }

    public v0() {
        this(2000);
    }

    public v0(int i6) {
        this(i6, 8000);
    }

    public v0(int i6, int i7) {
        super(true);
        this.f4211e = i7;
        byte[] bArr = new byte[i6];
        this.f4212f = bArr;
        this.f4213g = new DatagramPacket(bArr, 0, i6);
    }

    @Override // g2.m
    public long a(q qVar) {
        Uri uri = qVar.f4097a;
        this.f4214h = uri;
        String str = (String) i2.a.e(uri.getHost());
        int port = this.f4214h.getPort();
        q(qVar);
        try {
            this.f4217k = InetAddress.getByName(str);
            InetSocketAddress inetSocketAddress = new InetSocketAddress(this.f4217k, port);
            if (this.f4217k.isMulticastAddress()) {
                MulticastSocket multicastSocket = new MulticastSocket(inetSocketAddress);
                this.f4216j = multicastSocket;
                multicastSocket.joinGroup(this.f4217k);
                this.f4215i = this.f4216j;
            } else {
                this.f4215i = new DatagramSocket(inetSocketAddress);
            }
            this.f4215i.setSoTimeout(this.f4211e);
            this.f4218l = true;
            r(qVar);
            return -1L;
        } catch (IOException e6) {
            throw new a(e6, 2001);
        } catch (SecurityException e7) {
            throw new a(e7, 2006);
        }
    }

    @Override // g2.m
    public void close() {
        this.f4214h = null;
        MulticastSocket multicastSocket = this.f4216j;
        if (multicastSocket != null) {
            try {
                multicastSocket.leaveGroup((InetAddress) i2.a.e(this.f4217k));
            } catch (IOException unused) {
            }
            this.f4216j = null;
        }
        DatagramSocket datagramSocket = this.f4215i;
        if (datagramSocket != null) {
            datagramSocket.close();
            this.f4215i = null;
        }
        this.f4217k = null;
        this.f4219m = 0;
        if (this.f4218l) {
            this.f4218l = false;
            p();
        }
    }

    @Override // g2.m
    public Uri j() {
        return this.f4214h;
    }

    @Override // g2.i
    public int read(byte[] bArr, int i6, int i7) {
        if (i7 == 0) {
            return 0;
        }
        if (this.f4219m == 0) {
            try {
                ((DatagramSocket) i2.a.e(this.f4215i)).receive(this.f4213g);
                int length = this.f4213g.getLength();
                this.f4219m = length;
                o(length);
            } catch (SocketTimeoutException e6) {
                throw new a(e6, 2002);
            } catch (IOException e7) {
                throw new a(e7, 2001);
            }
        }
        int length2 = this.f4213g.getLength();
        int i8 = this.f4219m;
        int min = Math.min(i8, i7);
        System.arraycopy(this.f4212f, length2 - i8, bArr, i6, min);
        this.f4219m -= min;
        return min;
    }
}
