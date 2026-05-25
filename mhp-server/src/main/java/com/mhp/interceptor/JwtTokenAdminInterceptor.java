package com.mhp.interceptor;

import com.mhp.context.BaseContext;
import com.mhp.properties.JwtProperties;
import com.mhp.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
@Slf4j
public class JwtTokenAdminInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtProperties jwtProperties;

    @Override
    public boolean preHandle(HttpServletRequest request,
                            HttpServletResponse response,
                            Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        if (token == null || !token.startsWith("Bearer ")) {
            log.warn("请求缺少Authorization头：{}", request.getRequestURI());
            response.setStatus(401);
            return false;
        }
        token = token.substring(7);

        Long userId = JwtUtil.parseToken(token, jwtProperties.getSecret());
        if (userId == null) {
            log.warn("Token解析失败：{}", request.getRequestURI());
            response.setStatus(401);
            return false;
        }

        BaseContext.setCurrentId(userId);
        log.debug("用户{}访问{}", userId, request.getRequestURI());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                               HttpServletResponse response,
                               Object handler, Exception ex) {
        BaseContext.removeCurrentId();
    }
}
