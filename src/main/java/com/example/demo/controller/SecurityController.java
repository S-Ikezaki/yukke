package com.example.demo.controller;
<<<<<<< HEAD
=======

import com.example.demo.model.user.User;
import com.example.demo.repository.SiteUserRepository;
import com.example.demo.repository.UserRepository;
>>>>>>> d6e6e5e81d0bfaf954c4b806517282ee3aba3604
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class SecurityController {

<<<<<<< HEAD
//    private final CertificationRepository userRepository;
=======
    private final SiteUserRepository siteUserRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
>>>>>>> d6e6e5e81d0bfaf954c4b806517282ee3aba3604

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String showMenu(Authentication loginUser, Model model) {
        System.out.println(loginUser.getName());
        model.addAttribute("username", loginUser.getName());
//        model.addAttribute("role", loginUser.getAuthorities());

        List<User> userList = userRepository.findByUserRole(1);

        System.out.println(userList.get(0).getUserId());
//
        System.out.println("ここまできたよ");
        return "teacher_main_menu";
    }
}


//    @GetMapping("/admin/list")
//    public String showAdminList(Model model) {
//        model.addAttribute("users", siteUserRepository.findAll());
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
//        siteUserRepository.save(user);
//
//        return "redirect:/login?register";
//    }

//    @GetMapping("/login")
//    public String LoginTest(@ModelAttribute("password") String password,
//                            @ModelAttribute("username") String username, Model model, BindingResult result) {
//
//        System.out.println("きたよ！！！！！" + "pass:" + password);
//        System.out.println("きたよ！！！！！" + "username:" + password);
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
