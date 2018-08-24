package me.puras.mo.common.json;

/**
 * @author puras <he@puras.me>
 * @since 16/1/14  上午11:16
 */
public class ReturnCode {
    public static final int SUCCESS = 0;
    public static final int EXCEPTION = -1; // 服务端异常
    public static final int BUSINESS_ERROR = -2; // 业务逻辑错误
    public static final int BIND_ERROR = -3; // 数据绑定错误
    public static final int NOT_FOUND = -4; // 未找到指定数据
    public static final int PARAM_ERROR = -5; // 请求的参数错误
    public static final int REMOTE_CALL_ERROR = -6; // 远程调用失败
    public static final int NEVER_USED_CODE = -999999;// -999999：假定为永远也不会出现的returnCode
}
