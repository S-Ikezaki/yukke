package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@RestController
@Controller
@RequestMapping("ajax")
public class AjaxController {

    @GetMapping("/test")
    public String test(){
        return "ajax_test";
    }

    @ResponseBody
    @PostMapping("/data")
    public String Peer(@RequestBody String peerId){
        System.out.println(peerId);
        return peerId;
    }

}
