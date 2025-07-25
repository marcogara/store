package com.example.demo_springboot_store.controller;

import com.example.demo_springboot_store.model.User;
import com.example.demo_springboot_store.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
public class HomeController {

    private UserRepository userRepository;

    public HomeController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Value("${spring.application.name}")
    private String appName;


    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user,
                        HttpSession session,
                        Model model) {

        User user1 = userRepository.findByUsername(user.getUsername());

        String password = user1.getPassword();
        if (password != null && password.equals(user.getPassword()))  {
            session.setAttribute("user", user.getUsername()); // Store user in session

            return "redirect:/dashboard"; // Redirect after successful login
        }

        model.addAttribute("error", "Invalid username or password");
        return "index"; // Stay on login page if failed
    }

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        Object loggedUser = session.getAttribute("user");

        if (loggedUser == null) {
            return "redirect:/";
        }
        model.addAttribute("username", loggedUser);
        return "dashboard";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // Destroys the session, logs the user out
        return "redirect:/";  // Redirect back to login page
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user, Model model) {
        if (userRepository.exists(user.getUsername())) {
            model.addAttribute("error", "Username already exists.");
            return "register";
        }

        userRepository.save(user);
        model.addAttribute("success", "Account created successfully. Please log in.");
        return "register";
    }
}
