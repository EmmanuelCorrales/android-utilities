package com.emmanuelcorrales.android.utils;

import android.os.Environment;
import android.support.annotation.NonNull;

import java.io.File;


public class FileUtils {
    public static final String FILE_EXTENSION_DOC = ".doc";
    public static final String FILE_EXTENSION_DOCX = ".docx";
    public static final String FILE_EXTENSION_PPT = ".ppt";
    public static final String FILE_EXTENSION_PPTX = ".pptx";
    public static final String FILE_EXTENSION_XLS = ".xls";
    public static final String FILE_EXTENSION_XLSX = ".xlsx";
    public static final String FILE_EXTENSION_WAV = ".wav";
    public static final String FILE_EXTENSION_MP3 = ".mp3";
    public static final String FILE_EXTENSION_JPG = ".jpg";
    public static final String FILE_EXTENSION_JPEG = ".jpeg";
    public static final String FILE_EXTENSION_PNG = ".png";
    public static final String FILE_EXTENSION_APK = ".apk";
    public static final String FILE_EXTENSION_ICS = ".ics";
    public static final String FILE_EXTENSION_3GP = ".3gp";
    public static final String FILE_EXTENSION_MPG = ".mpg";
    public static final String FILE_EXTENSION_MPEG = ".mpeg";
    public static final String FILE_EXTENSION_MPE = ".mpe";
    public static final String FILE_EXTENSION_MP4 = ".mp4";
    public static final String FILE_EXTENSION_AVI = ".avi";


    private FileUtils() {
    }


    /**
     * Check if the external storage is readable.
     *
     * @return true if external storage is readable, false if not.
     */
    public static boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state) || Environment.MEDIA_MOUNTED_READ_ONLY.equals(state);
    }


    /**
     * Check if the external storage is writable.
     *
     * @return true if external storage is writable, false if not.
     */
    public static boolean isExternalStorageWritable() {
        return Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState());
    }


    /**
     * Check if file is a word document with extensions '.doc' or '.docx'.
     *
     * @param file File to check.
     * @return true if file is a word document, false if not.
     */
    public static boolean isDocument(@NonNull File file) {
        return file.toString().contains(FILE_EXTENSION_DOC)
                || file.toString().contains(FILE_EXTENSION_DOCX);
    }


    /**
     * Check if file is a powerpoint with extensions '.ppt' or '.pptx'.
     *
     * @param file File to check.
     * @return true if file is a powerpoint, false if not.
     */
    public static boolean isPowerPoint(@NonNull File file) {
        return file.toString().contains(FILE_EXTENSION_PPT)
                || file.toString().contains(FILE_EXTENSION_PPTX);
    }


    /**
     * Check if file is a spreadsheet with extensions '.xls' or '.xslx'.
     *
     * @param file File to check.
     * @return true if file is a spreadsheet, false if not.
     */
    public static boolean isSpreadsheet(@NonNull File file) {
        return file.toString().contains(FILE_EXTENSION_XLS)
                || file.toString().contains(FILE_EXTENSION_XLSX);
    }


    /**
     * Check if file is an audio file with extensions '.wav' or '.mp3'.
     *
     * @param file File to check.
     * @return true if file is an audio file, false if not.
     */
    public static boolean isAudio(@NonNull File file) {
        return file.toString().contains(FILE_EXTENSION_WAV)
                || file.toString().contains(FILE_EXTENSION_MP3);
    }


    /**
     * Check if file is an image with extensions '.jpg', '.jpeg' or '.png'.
     *
     * @param file File to check.
     * @return true if file is an image, false if not.
     */
    public static boolean isImage(@NonNull File file) {
        return file.toString().contains(FILE_EXTENSION_JPG)
                || file.toString().contains(FILE_EXTENSION_JPEG)
                || file.toString().contains(FILE_EXTENSION_PNG);
    }


    /**
     * Check if file is a video with extensions '.3gp', '.mpg', '.mpeg', '.mpe', '.mp4' or '.avi'.
     *
     * @param file File to check.
     * @return true if file is a video file, false if not.
     */
    public static boolean isVideo(@NonNull File file) {
        return file.toString().contains(FILE_EXTENSION_3GP)
                || file.toString().contains(FILE_EXTENSION_MPG)
                || file.toString().contains(FILE_EXTENSION_MPEG)
                || file.toString().contains(FILE_EXTENSION_MPE)
                || file.toString().contains(FILE_EXTENSION_MP4)
                || file.toString().contains(FILE_EXTENSION_AVI);
    }


    /**
     * Check if file is an APK with a '.apk' extension.
     *
     * @param file File to check.
     * @return true if file is an APK, false if not.
     */
    public static boolean isAPK(@NonNull File file) {
        return file.toString().contains(FILE_EXTENSION_APK);
    }


    /**
     * Check if file is a calendar file with a '.ics' extension.
     *
     * @param file File to check.
     * @return true if file is an calendar file, false if not.
     */
    public static boolean isCalendar(@NonNull File file) {
        return file.toString().contains(FILE_EXTENSION_ICS);
    }
}
