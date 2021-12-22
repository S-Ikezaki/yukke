package com.example.demo.controller;

import com.example.demo.model.user.Certification;
import com.example.demo.model.user.User;
import com.example.demo.repository.CertificationRepository;
import com.example.demo.repository.GroupRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.AsyncTest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Controller
@RequestMapping("users")
public class UserController {

    private final UserRepository userRepository;
    private final CertificationRepository certificationRepository;
    private final GroupRepository groupRepository;

    // コンストラクタ
    public UserController(
            UserRepository userRepository,
            CertificationRepository certificationRepository ,
            GroupRepository groupRepository
    ){
        this.userRepository = userRepository;
        this.certificationRepository = certificationRepository;
        this.groupRepository = groupRepository;
    }

    String userId;
//    long userId = repository.findById();

    @GetMapping("/akita")
    public String akitaDemo(Model model) {

        List<User> userList = userRepository.findAll();
        model.addAttribute("users", userList);

        return "jquery";
    }

    @ResponseBody
    @GetMapping("/sleep")
    public List<String> findUsers() throws Exception {
        long start = System.currentTimeMillis();
        long heavyProcessTime = 3000L;
        long lightProcessTime = 1000L;

        System.out.println("request started");
        CompletableFuture<String> heavyProcess = AsyncTest.findName("heavy", heavyProcessTime);
        CompletableFuture<String> lightProcess = AsyncTest.findName("light", lightProcessTime);

        // heavyProcessが終わったら実行される処理
        heavyProcess.thenAcceptAsync(heavyProcessResult -> {
            System.out.println("finished name=" + heavyProcessResult + ", sleep = " + heavyProcessTime);
        });

        // lightProcessが終わったら実行される処理
        lightProcess.thenAcceptAsync(lightProcessResult -> {
            System.out.println("finished name=" + lightProcessResult + ", sleep = " + lightProcessTime);
        });

        // 指定した処理が終わったらこれ以降の処理が実行される
        CompletableFuture.allOf(heavyProcess, lightProcess).join();

        // 返却値の作成
        List<String> names = new ArrayList<>();
        names.add(heavyProcess.get());
        names.add(lightProcess.get());

        Thread.sleep(10L);

        long end = System.currentTimeMillis();
        // 処理全体の時間を出力
        System.out.println("request finished. time: " + ((end - start))  + "ms");

        return names;
    }

    @ResponseBody
    @GetMapping("/getUser")
    public List<User> getUsers(@ModelAttribute("keyword") String keyword, BindingResult result) throws Exception {
        AsyncTest asyncTest = new AsyncTest(userRepository);


        CompletableFuture<List<User>> listCompletableFuture = asyncTest.getUser(keyword);
        List<User> userList = new ArrayList<User>();

        for(User user : listCompletableFuture.get()){
            userList.add(user);
        }

        long start = System.currentTimeMillis();
        long heavyProcessTime = 3000L;
        long lightProcessTime = 1000L;

        System.out.println("request started");
        CompletableFuture<String> heavyProcess = AsyncTest.findName("heavy", heavyProcessTime);
        CompletableFuture<String> lightProcess = AsyncTest.findName("light", lightProcessTime);

        // heavyProcessが終わったら実行される処理
        heavyProcess.thenAcceptAsync(heavyProcessResult -> {
            System.out.println("finished name=" + heavyProcessResult + ", sleep = " + heavyProcessTime);
        });

        // lightProcessが終わったら実行される処理
        lightProcess.thenAcceptAsync(lightProcessResult -> {
            System.out.println("finished name=" + lightProcessResult + ", sleep = " + lightProcessTime);
        });

        // 指定した処理が終わったらこれ以降の処理が実行される
        CompletableFuture.allOf(heavyProcess, lightProcess).join();

        // 返却値の作成
        List<String> names = new ArrayList<>();
        names.add(heavyProcess.get());
        names.add(lightProcess.get());

        Thread.sleep(10L);

        long end = System.currentTimeMillis();
        // 処理全体の時間を出力
        System.out.println("request finished. time: " + ((end - start))  + "ms");

        return userList;
    }

    @GetMapping("jquery")
    public String jquery() {
        return "jquery";
    }

    @GetMapping("/")
    public String ownInfo(Model model) {
        model.addAttribute("",userRepository.findById(userId));
        return "login";
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
            @PathVariable("id") String userId,
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

    @GetMapping("/admin/group_create")
    public String createGroup(){
        return "test1";
    }
}
