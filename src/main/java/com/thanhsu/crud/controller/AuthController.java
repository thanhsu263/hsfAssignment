package com.thanhsu.crud.controller;
import com.thanhsu.crud.entity.Account;
import com.thanhsu.crud.service.AccountService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller
public class AuthController {
    private final AccountService accountService;
    public AuthController(AccountService accountService) { this.accountService = accountService; }
    @GetMapping({"/", "/login"}) public String login(HttpSession session) { return session.getAttribute("loggedInUser") == null ? "login" : "redirect:/dashboard"; }
    @PostMapping("/auth") public String authenticate(@RequestParam String email, @RequestParam String password, HttpSession session, RedirectAttributes redirect) {
        Account account = accountService.authenticate(email, password).orElse(null);
        if (account == null || account.getRole() == 3) { redirect.addFlashAttribute("error", "Invalid credentials, or this account is blocked."); return "redirect:/login"; }
        session.setAttribute("loggedInUser", account); return "redirect:/dashboard";
    }
    @PostMapping("/logout") public String logout(HttpSession session) { session.invalidate(); return "redirect:/login"; }
}
