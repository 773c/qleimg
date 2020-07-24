package com.eiqle.qleimg.common.util;

import com.eiqle.qleimg.common.constant.StatusCodeConstant;


/**
 * 统一返回结果
 */
public class ResponseResultUtil {
    private long statusCode;
    private String message;
    private Object data;

    public ResponseResultUtil() {}

    public ResponseResultUtil(long statusCode, String message, Object data) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }

    /**
     * 成功返回结果
     * @return
     */
    public static ResponseResultUtil success() {
        return new ResponseResultUtil(
                StatusCodeConstant.SUCCESS.getStatusCode(),
                StatusCodeConstant.SUCCESS.getMessage(),
                null
        );
    }

    /**
     * 成功返回结果
     * @param data
     * @return
     */
    public static ResponseResultUtil success(Object data){
        return new ResponseResultUtil(
                StatusCodeConstant.SUCCESS.getStatusCode(),
                StatusCodeConstant.SUCCESS.getMessage(),
                data
        );
    }

    /**
     * 成功返回结果
     * @param data
     * @param message
     * @return
     */
    public static ResponseResultUtil success(Object data,String message){
        return new ResponseResultUtil(
                StatusCodeConstant.SUCCESS.getStatusCode(),
                message,
                data
        );
    }

    /**
     * 失败返回结果
     * @return
     */
    public static ResponseResultUtil failed(){
        return new ResponseResultUtil(
                StatusCodeConstant.FAILED.getStatusCode(),
                StatusCodeConstant.FAILED.getMessage(),
                null
        );
    }

    /**
     * 失败返回结果
     * @param message
     * @return
     */
    public static ResponseResultUtil failed(String message){
        return new ResponseResultUtil(
                StatusCodeConstant.FAILED.getStatusCode(),
                message,
                null
        );
    }

    public long getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(long statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseResultUtil{" +
                "statusCode=" + statusCode +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
