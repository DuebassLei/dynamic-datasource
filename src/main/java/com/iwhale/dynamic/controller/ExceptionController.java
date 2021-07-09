package com.iwhale.dynamic.controller;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author DuebassLei
 * @version 1.0
 * @date 2021/6/10 17:07
 * 定义全局异常处理器可以进行全局异常处理，本样例主要是处理授权异常：
 */
@ControllerAdvice
public class ExceptionController {
    // 当用户访问未授权的资源时，跳转到 unauthorized 视图，并携带出错信息
    @ExceptionHandler(AuthorizationException.class)
    public ModelAndView error(AuthorizationException e) {
        ModelAndView mv = new ModelAndView("unauthorized");
        mv.addObject("error", e.getMessage());
        return mv;
    }
}
