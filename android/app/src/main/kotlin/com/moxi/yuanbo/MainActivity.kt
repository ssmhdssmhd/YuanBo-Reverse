package com.moxi.yuanbo

import android.app.PictureInPictureParams
import android.content.Context
import android.media.AudioManager
import android.net.wifi.WifiManager
import android.os.Build
import android.provider.Settings
import android.util.Rational
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel
import kotlin.math.roundToInt

class MainActivity : FlutterActivity() {
    private val channelName = "com.moxi.yuanbo/system_level"
    private var pipEnabled = false
    private var playing = false
    private var multicastLock: WifiManager.MulticastLock? = null

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, channelName)
            .setMethodCallHandler { call, result ->
                when (call.method) {
                    "getBrightness" -> result.success(currentBrightness())
                    "setBrightness" -> {
                        val value = call.argument<Double>("value")
                        if (value == null) {
                            result.error("bad_args", "missing value", null)
                        } else {
                            setBrightness(value.toFloat())
                            result.success(null)
                        }
                    }
                    "resetBrightness" -> {
                        setBrightness(-1f)
                        result.success(null)
                    }
                    "getVolume" -> result.success(currentVolume())
                    "setVolume" -> {
                        val value = call.argument<Double>("value")
                        if (value == null) {
                            result.error("bad_args", "missing value", null)
                        } else {
                            setVolume(value.toFloat())
                            result.success(null)
                        }
                    }
                    "setPipEnabled" -> {
                        pipEnabled = call.argument<Boolean>("value") ?: false
                        result.success(null)
                    }
                    "setPlaying" -> {
                        playing = call.argument<Boolean>("value") ?: false
                        result.success(null)
                    }
                    "enterPip" -> result.success(enterPipMode())
                    "acquireMulticast" -> {
                        acquireMulticastLock()
                        result.success(null)
                    }
                    "releaseMulticast" -> {
                        releaseMulticastLock()
                        result.success(null)
                    }
                    else -> result.notImplemented()
                }
            }
    }

    override fun onUserLeaveHint() {
        if (pipEnabled && playing) {
            enterPipMode()
        }
        super.onUserLeaveHint()
    }

    private fun enterPipMode(): Boolean {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) return false
        return try {
            val params = PictureInPictureParams.Builder()
                .setAspectRatio(Rational(16, 9))
                .build()
            enterPictureInPictureMode(params)
        } catch (_: Exception) {
            false
        }
    }

    private fun acquireMulticastLock() {
        if (multicastLock != null) return
        try {
            val manager = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
            multicastLock = manager.createMulticastLock("yuanbo_cast").also {
                it.setReferenceCounted(false)
                it.acquire()
            }
        } catch (_: Exception) {
        }
    }

    private fun releaseMulticastLock() {
        try {
            multicastLock?.release()
        } catch (_: Exception) {
        }
        multicastLock = null
    }

    private fun currentBrightness(): Double {
        val windowBrightness = window?.attributes?.screenBrightness ?: -1f
        if (windowBrightness >= 0f) return windowBrightness.toDouble()
        val system = try {
            Settings.System.getInt(contentResolver, Settings.System.SCREEN_BRIGHTNESS)
        } catch (_: Exception) {
            128
        }
        return (system / 255.0).coerceIn(0.0, 1.0)
    }

    private fun setBrightness(value: Float) {
        runOnUiThread {
            val params = window.attributes
            params.screenBrightness = if (value < 0f) -1f else value.coerceIn(0.01f, 1f)
            window.attributes = params
        }
    }

    private fun currentVolume(): Double {
        val manager = getSystemService(Context.AUDIO_SERVICE) as AudioManager
        val max = manager.getStreamMaxVolume(AudioManager.STREAM_MUSIC)
        if (max <= 0) return 0.0
        return manager.getStreamVolume(AudioManager.STREAM_MUSIC).toDouble() / max
    }

    private fun setVolume(value: Float) {
        val manager = getSystemService(Context.AUDIO_SERVICE) as AudioManager
        val max = manager.getStreamMaxVolume(AudioManager.STREAM_MUSIC)
        if (max <= 0) return
        val target = (value.coerceIn(0f, 1f) * max).roundToInt()
        try {
            manager.setStreamVolume(AudioManager.STREAM_MUSIC, target, 0)
        } catch (_: Exception) {
        }
    }
}
