package com.df.xkxtbackend.exception;

import com.df.xkxtbackend.domain.response.ExceptionResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class _ExceptionHandle {

//    @ExceptionHandler(value = RuntimeException.class)
//    @ResponseBody
//    public ExceptionResponse handleRuntimeException(RuntimeException e) {
//        return new ExceptionResponse(e.getClass().getSimpleName(), e.getMessage());
//    }
}
