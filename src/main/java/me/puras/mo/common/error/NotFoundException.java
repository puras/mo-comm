package me.puras.mo.common.error;

public class NotFoundException extends BusinessException{

    public NotFoundException() {
    }

    public NotFoundException(String message) {
//        super(message);
        super(ErrCode.DATA_NOT_FOUND_ERR.getCode(), message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundException(Throwable cause) {
        super(cause);
    }

    public NotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
