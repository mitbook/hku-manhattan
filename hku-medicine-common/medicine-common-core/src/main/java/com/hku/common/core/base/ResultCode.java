package com.hku.common.core.base;

/**
 * @author pengzhengfa
 */
public enum ResultCode implements IErrorCode {
    success(200, "操作成功"),

    failed(500, "操作失败"),

    validate_failed(405, "参数检验失败");
    private final Long code;
    private final String msg;

    ResultCode(long code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public Long getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
