package edu.hut.library.service;

import edu.hut.library.pojo.Admin;

import javax.servlet.http.HttpSession;

/**
 * @Author: guozongchao
 * @Date: 2020/5/28 2:07
 */
public interface AdminService {

    void login(HttpSession session,String name,String password);

    Admin findAdminByName(String adminName);

    int addAdmin(Admin record);

    int updateAdmin(Admin record);

    int deleteAdminById(Integer adminId);
}
