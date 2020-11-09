package com.jackeyj.erp_dev.interceptor;

import com.jackeyj.erp_dev.entity.Info;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 确认是否处于登录状态
 * 登录管理
 * @author jiyaofei
 */
public class LoginInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object user = session.getAttribute(Info.USER);

        if(!StringUtils.isEmpty(user)){
            return true;
        }
        response.sendRedirect("/login");

        return false;
    }
}
