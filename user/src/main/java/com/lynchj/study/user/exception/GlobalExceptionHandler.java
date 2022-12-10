package com.lynchj.study.user.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

//@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 处理运行异常
     */
    @ExceptionHandler(RuntimeException.class)
    public String handleRuntimeException(HttpServletRequest request, RuntimeException ex) {
//        log.error("RuntimeException: {}", ExceptionUtils.getStackTrace(ex));
//        log.error("请求地址: {}", request.getRequestURL());
        return "全局错误处理器：RuntimeException";
    }

    /**
     * 用来捕获未知的错误
     *
     * @param ex
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    public String defaultErrorHandler(Exception ex) {
//        log.error("Exception: {}", ExceptionUtils.getStackTrace(ex));
        return "全局错误处理器：Exception";
    }

}
