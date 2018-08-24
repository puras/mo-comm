package me.puras.mo.common.error;

public class BusinessException extends RuntimeException {
    private int errCode;
    private String errDesc;

    public BusinessException() {}

    public BusinessException(int errCode, String errDesc) {
        super(errDesc);
        this.errCode = errCode;
        this.errDesc = errDesc;
    }

    public BusinessException(ErrCode errCode) {
        super(errCode.getDesc());
        this.errCode = errCode.getCode();
        this.errDesc = errCode.getDesc();
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public int getErrCode() {
        return errCode;
    }

    public String getErrDesc() {
        return errDesc;
    }
}
