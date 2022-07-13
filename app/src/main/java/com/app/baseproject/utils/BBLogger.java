//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.app.baseproject.utils;

import android.util.Log;

import androidx.annotation.NonNull;

public final class BBLogger {
    public static final String EXCEPTION = " Exception: ";
    private static BBLogger.LogLevel logLevel;

    private BBLogger() {
    }

    public static void setLogLevel(@NonNull final BBLogger.LogLevel level) {
        logLevel = level;
    }

    @NonNull
    public static BBLogger.LogLevel getLogLevel() {
        return logLevel;
    }

    public static void debug(@NonNull final String tag, @NonNull final Exception exception) {
        debug(tag, getMessageFromException(exception));
    }

    public static void debug(@NonNull final String tag, @NonNull final String message) {
        if (logLevel.ordinal() >= BBLogger.LogLevel.DEBUG.ordinal()) {
            Log.d(tag, message);
        }

    }

    public static void debug(@NonNull final String tag, @NonNull final Exception exception, @NonNull final String extraMessage) {
        debug(tag, extraMessage + " Exception: " + getMessageFromException(exception));
    }

    public static void debug(@NonNull final String tag, @NonNull final Error error, @NonNull final String extraMessage) {
        debug(tag, extraMessage + " Error: " + error.getMessage());
    }

    public static void info(@NonNull final String tag, @NonNull final String message) {
        if (logLevel.ordinal() >= BBLogger.LogLevel.INFO.ordinal()) {
            Log.i(tag, message);
        }

    }

    public static void warning(@NonNull final String tag, @NonNull final String message) {
        if (logLevel.ordinal() >= BBLogger.LogLevel.WARN.ordinal()) {
            Log.w(tag, message);
        }

    }

    public static void warning(@NonNull final String tag, @NonNull final Exception exception, @NonNull final String extraMessage) {
        warning(tag, extraMessage + " Exception: " + getMessageFromException(exception));
    }

    public static void error(@NonNull final String tag, @NonNull final String message) {
        if (logLevel.ordinal() >= BBLogger.LogLevel.ERROR.ordinal()) {
            Log.e(tag, message);
        }

    }

    public static void error(@NonNull final String tag, @NonNull final Exception exception) {
        error(tag, getMessageFromException(exception));
    }

    public static void error(@NonNull final String tag, @NonNull final Exception exception, @NonNull final String extraMessage) {
        error(tag, extraMessage + " Exception: " + getMessageFromException(exception));
    }

    @NonNull
    public static String getMessageFromException(@NonNull final Exception e) {
        return e.getMessage() == null ? e.getClass().getName() : e.getMessage();
    }

    static {
        logLevel = BBLogger.LogLevel.WARN;
    }

    public static enum LogLevel {
        NONE,
        ERROR,
        WARN,
        INFO,
        DEBUG;

        private LogLevel() {
        }
    }
}
