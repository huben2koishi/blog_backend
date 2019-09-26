package com.huben.blog.interceptor;

import com.huben.blog.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author koishi
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        System.out.println(uri);

        User user = (User) request.getSession().getAttribute("user");
        if (uri.contains("login")||!uri.contains("admin")) {
            return true;
        }else if (user!=null){
            return true;
        } else {
            response.sendRedirect("/admin/login");

            return false;
        }
    }
}
