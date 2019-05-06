package com.mark.vote.common;

public enum ResponseCode {

    SUCCESS(0, "成功"),
    ERROR(1, "错误"),
    NEED_LOGIN(10, "未登录"),
    ILLEGAL_ARGUMENT(20, "参数错误");

    private final int code;
    private final String desc;

    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return this.code;
    }
    public String getDesc() {
        return this.desc;
    }
}
