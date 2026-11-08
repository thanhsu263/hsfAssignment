package com.thanhsu.crud.config;
import com.thanhsu.crud.entity.Account;
import jakarta.servlet.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.support.RequestContextUtils;
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Account user = (Account) request.getSession().getAttribute("loggedInUser");
        if (user == null) { response.sendRedirect(request.getContextPath() + "/login"); return false; }
        String uri = request.getRequestURI().substring(request.getContextPath().length());
        boolean protectedAction = uri.equals("/products/new") || uri.equals("/products/save") || uri.startsWith("/products/edit/") || uri.startsWith("/products/delete/");
        if (protectedAction && !user.isAdmin()) {
            RequestContextUtils.getOutputFlashMap(request).put("error", "Only administrators can change products.");
            response.sendRedirect(request.getContextPath() + "/products"); return false;
        }
        return true;
    }
}
