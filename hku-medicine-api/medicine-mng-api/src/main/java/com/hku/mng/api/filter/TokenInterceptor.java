package com.hku.mng.api.filter;

import com.hku.common.core.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author pengzhengfa
 */
@Slf4j
@Component
public class TokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        try {
            String token = request.getHeader("token");
            String userName = JwtUtil.getUserName(token);
            boolean verify = JwtUtil.verify(token, userName);
            if (verify) {
                response.sendRedirect("/login");
                return false;
            }
        } catch (Exception e) {
            log.error("token校验异常:{}", e);
        }
        /**
         * token未过期,放行请求
         */
        return true;
    }
}
