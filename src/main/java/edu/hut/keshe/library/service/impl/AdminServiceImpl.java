package edu.hut.keshe.library.service.impl;

import edu.hut.keshe.library.dao.AdminMapper;
import edu.hut.keshe.library.exception.CustomizeException;
import edu.hut.keshe.library.pojo.Admin;
import edu.hut.keshe.library.service.AdminService;
import edu.hut.keshe.library.util.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.servlet.http.HttpSession;

/**
 * @Description:
 * @Author: guozongchao
 * @Date: 2020/5/28 2:11
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminMapper adminMapper;

    /**
     * 用户登录业务
     * @param session
     * @return
     */
    @Override
    public boolean login(HttpSession session,String name,String password) {
        Admin admin = findAdminByName(name);
        if(admin==null){  //用户不存在
            throw new CustomizeException(ResultCode.USER_NOT_FOUND);
        }

        if(!admin.getPassword().equals(password)){  //密码错误
            throw new CustomizeException(ResultCode.PASSWORD_ERROR);
        }
        session.setAttribute("admin",admin);
        return true;
    }

    @Override
    public Admin findAdminByName(String adminName) {
        return adminMapper.selectByName(adminName);
    }

    @Override
    public int addAdmin(Admin record) {
        return adminMapper.insert(record);
    }

    @Override
    public int updateAdmin(Admin record) {
        return adminMapper.updateById(record);
    }

    @Override
    public int deleteAdminById(Integer adminId) {
        return adminMapper.deleteById(adminId);
    }
}
