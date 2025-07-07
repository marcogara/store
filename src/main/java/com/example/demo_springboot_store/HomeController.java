package com.example.demo_springboot_store;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class HomeController {
    @Value("${spring.application.name}")
    private String appName;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        Model model) {

        // Hardcoded user list for now
        Map<String, String> users = Map.of(
                "admin", "password123",
                "user", "userpass"
        );

        if (users.containsKey(username) && users.get(username).equals(password)) {
            session.setAttribute("user", username); // Store user in session
            return "redirect:/dashboard"; // Redirect after successful login
        }

        model.addAttribute("error", "Invalid username or password");
        return "index"; // Stay on login page if failed
    }

}
