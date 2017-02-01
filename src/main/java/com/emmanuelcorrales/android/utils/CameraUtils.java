package com.emmanuelcorrales.android.utils;


import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.Surface;
import android.view.WindowManager;

/**
 * Utility class for Android's old Camera API which is already deprecated.
 */
public class CameraUtils {
    public static final int REQUEST_PERMISSION_CAMERA = 1736;

    private static final String TAG = CameraUtils.class.getSimpleName();

    private CameraUtils() {

    }

    /**
     * Check if the device has a camera.
     *
     * @param context
     * @return True if device has a camera. False if not.
     */
    public static boolean checkCameraHardware(Context context) {
        return context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA);
    }

    /**
     * A safe way to get an instance of the Camera object.
     *
     * @return The instance of the Camera object if is successfully opened the camera else returns null.
     */
    public static Camera getCameraInstance() {
        Camera camera = null;
        try {
            camera = Camera.open();
        } catch (Exception e) {
            Log.e(TAG, "Camera not available.");
            e.printStackTrace();
        }
        return camera;
    }

    /**
     * Checks if permission to access the device's camera was granted.
     *
     * @param activity
     * @return true if the camera permission was already granted.
     */
    public static boolean hasCameraPermission(Activity activity) {
        if (activity == null) {
            throw new IllegalArgumentException("Argument 'activity' cannot be null.");
        }
        return ActivityCompat.checkSelfPermission(activity, Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_GRANTED;
    }

    /**
     * Requests permission to access the camera by showing a dialog that will ask for permission
     * to access the camera. This method uses the value of CameraUtils.REQUEST_PERMISSION_CAMERA as
     * the default request code. If you want to use a custom request code use
     * CameraUtils.requestCameraPermission(Activity activity, int requestCode).
     *
     * @param activity
     */
    public static void requestCameraPermission(Activity activity) {
        requestCameraPermission(activity, REQUEST_PERMISSION_CAMERA);
    }

    /**
     * Requests permission to access the camera by showing a dialog that will ask for permission
     * to access the camera.
     *
     * @param activity
     * @param requestCode The request code for the camera permission.
     */
    public static void requestCameraPermission(Activity activity, int requestCode) {
        if (activity == null) {
            throw new IllegalArgumentException("Argument 'activity' cannot be null.");
        }
        final String[] permissions = new String[]{android.Manifest.permission.CAMERA};
        ActivityCompat.requestPermissions(activity, permissions, requestCode);
    }

    public static void configureOrientation(Context context, Camera camera) {
        int degrees = 0;
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        int rotation = windowManager.getDefaultDisplay().getRotation();
        switch (rotation) {
            case Surface.ROTATION_0:
                degrees = 0;
                break;

            case Surface.ROTATION_90:
                degrees = 90;
                break;

            case Surface.ROTATION_180:
                degrees = 180;
                break;

            case Surface.ROTATION_270:
                degrees = 270;
                break;

            default:
                Log.e(TAG, "Bad rotation value: " + rotation);
                break;
        }

        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(0, cameraInfo);

        int angle;
        int displayAngle;
        if (cameraInfo.facing == Camera.CameraInfo.CAMERA_FACING_FRONT) {
            angle = (cameraInfo.orientation + degrees) % 360;
            displayAngle = (360 - angle) % 360; // compensate for it being mirrored
        } else {
            // back-facing
            angle = (cameraInfo.orientation - degrees + 360) % 360;
            displayAngle = angle;
        }

        camera.setDisplayOrientation(displayAngle);
        camera.getParameters().setRotation(angle);
    }
}
