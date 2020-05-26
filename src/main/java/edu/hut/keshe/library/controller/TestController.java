package edu.hut.keshe.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description:
 * @Author: guozongchao
 * @Date: 2020/5/26 0:34
 */
@Controller
public class TestController {
    
    @RequestMapping("/test")
    @ResponseBody
    public String helloWorld() {
        return "hello world!";
    }
}
