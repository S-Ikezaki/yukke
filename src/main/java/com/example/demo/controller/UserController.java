package com.example.demo.controller;

import com.example.demo.model.user.Certification;
import com.example.demo.model.user.User;
import com.example.demo.repository.CertificationRepository;
import com.example.demo.repository.GroupRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("users")
public class UserController {

    private final UserRepository userRepository;
    private final CertificationRepository certificationRepository;
    private final GroupRepository groupRepository;

    // コンストラクタ
    @Autowired
    public UserController(
            UserRepository userRepository,
            CertificationRepository certificationRepository ,
            GroupRepository groupRepository
    ){
        this.userRepository = userRepository;
        this.certificationRepository = certificationRepository;
        this.groupRepository = groupRepository;
    }

    long userId;
//    long userId = repository.findById();



    @GetMapping("/")
    public String ownInfo(Model model) {
        model.addAttribute("",userRepository.findById(userId));
        return "";
    }

    //ユーザ一覧表示
    @GetMapping("/showUserList")
    @ResponseBody
    public String showUserList(Model model) {
        model.addAttribute("", userRepository.findAll());
        return "";
    }

    // 学生一覧表示
    @GetMapping("/showUserList/{role}")
    @ResponseBody
    public String showStudentList(Model model, @PathVariable("role") String role) {
        model.addAttribute("", userRepository.findStudentByRole(role));
        return "";
    }

    // 教師一覧表示
//    @GetMapping("/showUserList/{role}")
//    @ResponseBody
//    public String showTeacherList(Model model, @PathVariable("role") String role) {
//        model.addAttribute("", userRepository.findTeacherByRole(role));
//        return "";
//    }

    // ユーザ一件追加
    @PostMapping("/add")
    public String addUser(
            @ModelAttribute() String userName,
            Model model
    ){
        User user = new User();
        user.setUserId("12");
        user.setUserName(userName);

//        user.setUserRole(userRole);
        userRepository.save(user);

        model.addAttribute("user", user);
        return "";
    }

    // ユーザ一件削除
    @GetMapping("/delete/{id}")
    public String deleteUser(
            @PathVariable("id") long userId,
            Model model
    ) {
        userRepository.deleteById(userId);
        return "";
    }

//    @RequestMapping()
    // ユーザ（卒業した学生）複数削除
//    public String deleteMultiUser(){
//        Date date = new Date();
//    }

    // パスワード更新
    @PostMapping("updatepass")
    public String updatePassword(
            @ModelAttribute() String userId,
            @ModelAttribute() String password,
            Model model
    ) {
        Certification certification = new Certification();
        certification.setUserId(userId);
        certification.setPassword(password);
        certificationRepository.save(certification);

        return "";
    }

    // ユーザが所属しているグループを取得
    @RequestMapping("/")
    public String usersGroup(User user, Model model) {

//        List<Group> groups = groupRepository.findByUser(user);

//        model.addAttribute(groups);
        return "";
    }

    // user_list 表示
    @GetMapping("/moveUserList")
    public String moveUserList(Model model) {

        List<User> userList = userRepository.findAll();
        model.addAttribute("users", userList);

        return "user_list";
    }

    // ユーザキーワード検索
    @GetMapping("/showByKeyword")
    public String showUserByKeyword(@ModelAttribute("demo") String keyword, @ModelAttribute("role") String rdo, BindingResult result, Model model) {

        System.out.println("キーワード" + keyword);
        System.out.println("検索タイプ" + rdo);

        List<User> users = userRepository.findStudentByRole(rdo);
        System.out.println(users.get(0).getUserId());

        model.addAttribute("users", users);

        return "user_list";
    }
}
