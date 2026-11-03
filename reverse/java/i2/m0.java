package i2;

import android.os.SystemClock;
import g2.i0;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.ConcurrentModificationException;

/* loaded from: classes.dex */
public final class m0 {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f5607a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static final Object f5608b = new Object();

    /* renamed from: c, reason: collision with root package name */
    private static boolean f5609c = false;

    /* renamed from: d, reason: collision with root package name */
    private static long f5610d = 0;

    /* renamed from: e, reason: collision with root package name */
    private static String f5611e = "time.android.com";

    public interface b {
        void a();

        void b(IOException iOException);
    }

    private static final class c implements i0.b<i0.e> {

        /* renamed from: a, reason: collision with root package name */
        private final b f5612a;

        public c(b bVar) {
            this.f5612a = bVar;
        }

        @Override // g2.i0.b
        public void i(i0.e eVar, long j6, long j7) {
            if (this.f5612a != null) {
                if (m0.k()) {
                    this.f5612a.a();
                } else {
                    this.f5612a.b(new IOException(new ConcurrentModificationException()));
                }
            }
        }

        @Override // g2.i0.b
        public i0.c m(i0.e eVar, long j6, long j7, IOException iOException, int i6) {
            b bVar = this.f5612a;
            if (bVar != null) {
                bVar.b(iOException);
            }
            return g2.i0.f4050f;
        }

        @Override // g2.i0.b
        public void u(i0.e eVar, long j6, long j7, boolean z5) {
        }
    }

    private static final class d implements i0.e {
        private d() {
        }

        @Override // g2.i0.e
        public void a() {
            synchronized (m0.f5607a) {
                synchronized (m0.f5608b) {
                    if (m0.f5609c) {
                        return;
                    }
                    long l6 = m0.l();
                    synchronized (m0.f5608b) {
                        long unused = m0.f5610d = l6;
                        boolean unused2 = m0.f5609c = true;
                    }
                }
            }
        }

        @Override // g2.i0.e
        public void c() {
        }
    }

    private static void g(byte b6, byte b7, int i6, long j6) {
        if (b6 == 3) {
            throw new IOException("SNTP: Unsynchronized server");
        }
        if (b7 != 4 && b7 != 5) {
            throw new IOException("SNTP: Untrusted mode: " + ((int) b7));
        }
        if (i6 != 0 && i6 <= 15) {
            if (j6 == 0) {
                throw new IOException("SNTP: Zero transmitTime");
            }
        } else {
            throw new IOException("SNTP: Untrusted stratum: " + i6);
        }
    }

    public static long h() {
        long j6;
        synchronized (f5608b) {
            j6 = f5609c ? f5610d : -9223372036854775807L;
        }
        return j6;
    }

    public static String i() {
        String str;
        synchronized (f5608b) {
            str = f5611e;
        }
        return str;
    }

    public static void j(g2.i0 i0Var, b bVar) {
        if (k()) {
            if (bVar != null) {
                bVar.a();
            }
        } else {
            if (i0Var == null) {
                i0Var = new g2.i0("SntpClient");
            }
            i0Var.n(new d(), new c(bVar), 1);
        }
    }

    public static boolean k() {
        boolean z5;
        synchronized (f5608b) {
            z5 = f5609c;
        }
        return z5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long l() {
        InetAddress byName = InetAddress.getByName(i());
        DatagramSocket datagramSocket = new DatagramSocket();
        try {
            datagramSocket.setSoTimeout(10000);
            byte[] bArr = new byte[48];
            DatagramPacket datagramPacket = new DatagramPacket(bArr, 48, byName, 123);
            bArr[0] = 27;
            long currentTimeMillis = System.currentTimeMillis();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            o(bArr, 40, currentTimeMillis);
            datagramSocket.send(datagramPacket);
            datagramSocket.receive(new DatagramPacket(bArr, 48));
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            long j6 = currentTimeMillis + (elapsedRealtime2 - elapsedRealtime);
            byte b6 = bArr[0];
            int i6 = bArr[1] & 255;
            long n6 = n(bArr, 24);
            long n7 = n(bArr, 32);
            long n8 = n(bArr, 40);
            g((byte) ((b6 >> 6) & 3), (byte) (b6 & 7), i6, n8);
            long j7 = (j6 + (((n7 - n6) + (n8 - j6)) / 2)) - elapsedRealtime2;
            datagramSocket.close();
            return j7;
        } catch (Throwable th) {
            try {
                datagramSocket.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static long m(byte[] bArr, int i6) {
        int i7 = bArr[i6];
        int i8 = bArr[i6 + 1];
        int i9 = bArr[i6 + 2];
        int i10 = bArr[i6 + 3];
        if ((i7 & 128) == 128) {
            i7 = (i7 & 127) + 128;
        }
        if ((i8 & 128) == 128) {
            i8 = (i8 & 127) + 128;
        }
        if ((i9 & 128) == 128) {
            i9 = (i9 & 127) + 128;
        }
        if ((i10 & 128) == 128) {
            i10 = (i10 & 127) + 128;
        }
        return (i7 << 24) + (i8 << 16) + (i9 << 8) + i10;
    }

    private static long n(byte[] bArr, int i6) {
        long m6 = m(bArr, i6);
        long m7 = m(bArr, i6 + 4);
        if (m6 == 0 && m7 == 0) {
            return 0L;
        }
        return ((m6 - 2208988800L) * 1000) + ((m7 * 1000) / 4294967296L);
    }

    private static void o(byte[] bArr, int i6, long j6) {
        if (j6 == 0) {
            Arrays.fill(bArr, i6, i6 + 8, (byte) 0);
            return;
        }
        long j7 = j6 / 1000;
        long j8 = j6 - (j7 * 1000);
        long j9 = j7 + 2208988800L;
        int i7 = i6 + 1;
        bArr[i6] = (byte) (j9 >> 24);
        int i8 = i7 + 1;
        bArr[i7] = (byte) (j9 >> 16);
        int i9 = i8 + 1;
        bArr[i8] = (byte) (j9 >> 8);
        int i10 = i9 + 1;
        bArr[i9] = (byte) (j9 >> 0);
        long j10 = (j8 * 4294967296L) / 1000;
        int i11 = i10 + 1;
        bArr[i10] = (byte) (j10 >> 24);
        int i12 = i11 + 1;
        bArr[i11] = (byte) (j10 >> 16);
        bArr[i12] = (byte) (j10 >> 8);
        bArr[i12 + 1] = (byte) (Math.random() * 255.0d);
    }
}
