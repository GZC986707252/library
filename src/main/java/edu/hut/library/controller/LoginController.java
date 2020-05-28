package edu.hut.library.controller;

import edu.hut.library.service.AdminService;
import edu.hut.library.util.ResultCode;
import edu.hut.library.util.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @Description:
 * @Author: guozongchao
 * @Date: 2020/5/28 2:37
 */
@Controller
public class LoginController {

    @Autowired
    private AdminService adminService;

    /**
     * 登录处理
     * @param session
     * @param adminName
     * @param password
     * @return
     */
    @PostMapping("/login.do")
    @ResponseBody
    public ResultVO loginHandler(HttpSession session,String adminName,String password) {
        if(adminService.login(session,adminName,password)){
            return new ResultVO(ResultCode.SUCCESS,"/main");
        }else {
            return new ResultVO(ResultCode.FAILED,null);
        }
    }

    /**
     * 退出处理
     * @param session
     * @return
     */
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

}
