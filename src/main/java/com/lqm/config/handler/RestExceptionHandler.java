package com.lqm.config.handler;

import com.lqm.common.ServerResponse;
import org.springframework.web.bind.annotation.*;

/**
 * 全局异常统一处理
 */
@ControllerAdvice(annotations = RestController.class)
@ResponseBody
public class RestExceptionHandler
{
    /**
     * 默认统一异常处理方法
     * @param e 默认Exception异常对象
     * @return
     */
    @ExceptionHandler
    @ResponseStatus
    public ServerResponse runtimeExceptionHandler(Exception e) {
        return ServerResponse.createByErrorMessage(e.getMessage());
    }
}
