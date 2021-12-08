package com.example.demo.controller;

import com.example.demo.repository.SiteUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class SecurityController {

    private final SiteUserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String showMenu(Authentication loginUser, Model model) {
        model.addAttribute("username", loginUser.getName());
//        model.addAttribute("role", loginUser.getAuthorities());
        System.out.println("ここまできたよ");
        return "teacher_main_menu";
    }

//    @GetMapping("/admin/list")
//    public String showAdminList(Model model) {
//        model.addAttribute("users", userRepository.findAll());
//        return "list";
//    }
//
//    @GetMapping("/register")
//    public String register(@ModelAttribute("user") SiteUser user) {
//        return "register";
//    }
//
//    @PostMapping("/register")
//    public String process(@Validated @ModelAttribute("user") SiteUser user,
//            BindingResult result) {
//
//        if (result.hasErrors()) {
//            return "register";
//        }

//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        System.out.println("ここだよ" + user.getPassword());
//        if (user.isAdmin()) {
//            user.setRole(Role.ADMIN.name());
//        } else {
//            user.setRole(Role.USER.name());
//        }
//        userRepository.save(user);
//
//        return "redirect:/login?register";
//    }

//    @GetMapping("/login")
//    public String LoginTest(@ModelAttribute("password") String password, Model model, BindingResult result) {
//
//        System.out.println("きたよ！！！！！" + "pass:" + password);
//
//        if(passwordEncoder.matches(password, "$2a$10$5ncQDg2b6lYG1muj08f6l.lCaRbU3N2rfdzI/epwDnKBC8zikEguS")) {
//            System.out.println("一致したよ");
//        }
//
//        if(result.hasErrors()) {
//            System.out.println("ここだよ!!!!" + passwordEncoder.encode(password));
//            return "login";
//        }
//
//        System.out.println("ここだよ" + passwordEncoder.encode(password));
//        model.addAttribute("password", "password");
//        return "login";
//    }
}
