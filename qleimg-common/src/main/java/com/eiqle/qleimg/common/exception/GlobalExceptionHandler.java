package com.eiqle.qleimg.common.exception;

import com.eiqle.qleimg.common.util.ResponseResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理类
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    /**
     * 自定义异常捕捉
     * @param e
     * @return
     */
    @ExceptionHandler(value = ApiException.class)
    public ResponseResultUtil handle(ApiException e){
        return ResponseResultUtil.failed(e.getMessage());
    }
}
