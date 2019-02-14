package com.cqupt.wzy.facedetection.common.exception;

/**
 * 没有权限
 */
public class NoPrivilegeException extends RuntimeException {
    public NoPrivilegeException() {
    }

    public NoPrivilegeException(String message) {
        super(message);
    }

    public NoPrivilegeException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoPrivilegeException(Throwable cause) {
        super(cause);
    }

    public NoPrivilegeException(String message, Throwable cause, boolean enableSuppression,
                                boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
