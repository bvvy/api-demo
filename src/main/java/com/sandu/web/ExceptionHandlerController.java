package com.sandu.web;

import com.sandu.common.ReturnData;
import com.sandu.constant.ResponseEnum;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by bvvy
 * @date 2018/4/25
 */
@RestController
@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(RuntimeException.class)
    public ReturnData returnData(RuntimeException ex) {
        return ReturnData.builder().message(ex.getMessage()).code(ResponseEnum.ERROR);
    }
}
