package com.lynchj.study.user.exception;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 处理运行异常
     */
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(HttpServletRequest request, RuntimeException ex) {
        log.error("RuntimeException: ", ExceptionUtils.getStackTrace(ex));
        log.error("请求地址：" + request.getRequestURL());
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    /**
     * 用来捕获404，400这种无法到达controller的错误
     *
     * @param ex
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    public String defaultErrorHandler(Exception ex) {
        log.error("Exception: ", ExceptionUtils.getStackTrace(ex));
        return "未知错误";
    }

}
