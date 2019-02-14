package com.cqupt.wzy.facedetection.common.exception;

/**
 * 配置加载异常
 */
public class LoadConfigException extends Exception {
    public LoadConfigException() {
    }

    public LoadConfigException(String message) {
        super(message);
    }

    public LoadConfigException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoadConfigException(Throwable cause) {
        super(cause);
    }

    protected LoadConfigException(String message, Throwable cause, boolean enableSuppression,
                                  boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
