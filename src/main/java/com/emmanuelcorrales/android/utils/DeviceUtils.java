package com.emmanuelcorrales.android.utils;


import android.content.Context;
import android.os.Vibrator;

public class DeviceUtils {

    private static long DEFAULT_VIBRATION_DURATION = 50; // milliseconds

    private DeviceUtils() {
    }

    public static void vibrate(Context context) {
        vibrate(context, DEFAULT_VIBRATION_DURATION);
    }

    public static void vibrate(Context context, long millisec) {
        if (context == null) {
            throw new IllegalArgumentException("Argument 'millisec' cannot be null.");
        }
        millisec = millisec > DEFAULT_VIBRATION_DURATION ? millisec : DEFAULT_VIBRATION_DURATION;
        Vibrator v = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(millisec);
    }
}
