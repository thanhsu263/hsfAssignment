package com.thanhsu.crud.config;
import com.thanhsu.crud.entity.Account;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
@ControllerAdvice
public class GlobalModelAdvice {
    @ModelAttribute("currentUser")
    public Account currentUser(HttpSession session) { return (Account) session.getAttribute("loggedInUser"); }
}
