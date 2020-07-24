package com.eiqle.qleimg.common.exception;

/**
 * 自定义断言类（在程序某个位置插入抛出异常信息）
 */
public class Asserts {
    public static void fail(String message){
        throw new ApiException(message);
    }
}
