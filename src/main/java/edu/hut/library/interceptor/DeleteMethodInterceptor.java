package edu.hut.library.interceptor;

import edu.hut.library.annotation.ViewMethod;
import edu.hut.library.exception.CustomizeException;
import edu.hut.library.pojo.Admin;
import edu.hut.library.util.ResultCode;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Description: 删除方法拦截器
 * @Author: guozongchao
 * @Date: 2020/5/30 1:31
 */
public class DeleteMethodInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session=request.getSession();
        HandlerMethod method= (HandlerMethod) handler;
        if (!method.hasMethodAnnotation(DeleteMapping.class)) {
            return true;
        }
        Admin admin= (Admin) session.getAttribute("admin");
        if (!"502胶".equals(admin.getAdminName())) {
            throw new CustomizeException(ResultCode.ACCESS_DENIED);
        }
        return true;
    }
}
