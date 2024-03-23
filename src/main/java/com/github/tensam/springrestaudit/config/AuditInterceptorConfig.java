package com.github.tensam.springrestaudit.config;

import com.github.tensam.springrestaudit.annotation.Auditable;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
public class AuditInterceptorConfig implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("Before entering the request`");

        if (handler instanceof HandlerMethod) {
            Auditable auditable = ((HandlerMethod) handler).getMethodAnnotation(Auditable.class);
            if (auditable != null) {
                log.info("Audit");
            } else {
                log.info("No Audit Required");
            }
        }
        return true;
    }

}
