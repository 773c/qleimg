package com.eiqle.qleimg.common.constant;

/**
 * 自定义操作常量
 */
public enum  StatusCodeConstant {
    SUCCESS(200,"操作成功"),
    FAILED(500,"操作失败");

    private long statusCode;
    private String message;

    StatusCodeConstant(long statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public long getStatusCode() {
        return statusCode;
    }


    public String getMessage() {
        return message;
    }

}
