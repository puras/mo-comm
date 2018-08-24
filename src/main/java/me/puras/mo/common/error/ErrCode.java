package me.puras.mo.common.error;

public enum ErrCode {
    DATA_NOT_FOUND_ERR(404, "访问的数据不存在"),
    DATA_BIND_ERR(9101, "数据绑定失败"),
    DATA_ALREADY_EXIST(9102, "数据体中字段内容重复"),
    SYS_ERR(9999, "系统错误，请联系管理员");

    private int code;
    private String desc;

    ErrCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
