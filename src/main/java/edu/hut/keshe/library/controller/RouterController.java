package edu.hut.keshe.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description: 路由控制器
 * @Author: guozongchao
 * @Date: 2020/5/27 23:34
 */
@Controller
public class RouterController {

    @GetMapping("/reader_list")
    public String readerPage(){
        return "reader";
    }
    @GetMapping("/book_list")
    public String bookPage(){
        return "book";
    }
    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }
    @GetMapping({"/main","/"})
    public String mainPage(){
        return "main";
    }
}
