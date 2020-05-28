package edu.hut.library.interceptor;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Description: 登录拦截器，拦截需要登录的请求
 * @Author: guozongchao
 * @Date: 2020/5/28 0:01
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (!(handler instanceof HandlerMethod)) {  //不是请求接口方法的放行
            return true;
        }
        HttpSession session=request.getSession();
        if(session.getAttribute("admin")==null){
            response.sendRedirect("/login");
            return false;
        }
        return true;
    }
}
