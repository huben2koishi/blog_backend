package com.huben.blog.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.huben.blog.pojo.Result;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author koishi
 */
public class MyExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        String message = "系统繁忙, 请稍后重试";

        if (e instanceof MyException){
            message= ((MyException) e).getMessage();
        }

        HandlerMethod handlerMethod = (HandlerMethod) o;
        ResponseBody responseBody = handlerMethod.getMethod().getAnnotation(ResponseBody.class);
        if (responseBody!=null){
            Result result = new Result();
            result.setCode(0);
            result.setMessage(message);

            try {
                String data = new ObjectMapper().writeValueAsString(result);
                httpServletResponse.setContentType("application/json;charset=utf-8");
                httpServletResponse.getWriter().write(data);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return new ModelAndView();
        }

        ModelAndView mav = new ModelAndView("error");
        mav.addObject("message",message);
        return mav;
    }
}
