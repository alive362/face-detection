package com.cqupt.wzy.facedetection.common.util;

public class ExceptionThreadLocalUtil {
    private static ThreadLocal<Exception> exceptionThreadLocal = new ThreadLocal<>();

    public static Exception getAndRemove() {
        Exception exception = exceptionThreadLocal.get();
        exceptionThreadLocal.remove();
        return exception;
    }

    public static Exception get() {
        Exception exception = exceptionThreadLocal.get();
        return exception;
    }

    public static void set(Exception e) {
        exceptionThreadLocal.set(e);
    }
}
