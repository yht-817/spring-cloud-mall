package com.uxtc.cloud.common.exception;


import com.uxtc.cloud.common.api.IErrorCode;

/**
 * 自定义API异常（不是系统的异常，是用户抛出的异常）
 *
 * @author 鱼仔
 */
public class ApiException extends RuntimeException {
    private IErrorCode errorCode;

    public ApiException(IErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ApiException(String message) {
        super(message);
    }

    public ApiException(Throwable cause) {
        super(cause);
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public IErrorCode getErrorCode() {
        return errorCode;
    }
}
