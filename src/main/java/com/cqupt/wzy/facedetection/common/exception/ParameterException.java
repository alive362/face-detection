package com.cqupt.wzy.facedetection.common.exception;

/**
 * 参数异常
 */
public class ParameterException extends RuntimeException {
    private String requestPath;

    public ParameterException() {
    }

    public ParameterException(String message) {
        super(message);
    }

    public ParameterException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParameterException(Throwable cause) {
        super(cause);
    }

    public ParameterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public String getRequestPath() {
        return requestPath;
    }

    public ParameterException setRequestPath(String requestPath) {
        this.requestPath = requestPath;
        return this;
    }
}
