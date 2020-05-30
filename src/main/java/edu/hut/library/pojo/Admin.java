package edu.hut.library.pojo;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class Admin {
    private Integer adminId;

    @NotBlank(message = "用户名不能为空")
    @Pattern(regexp = "[0-9_A-Za-z]{1,10}",message = "用户名只能是字母、数字或下划线组成的1~10个字符")
    private String adminName;

    @NotBlank(message = "密码不能为空")
    @Length(min = 6,message = "密码至少6个字符")
    private String password;

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName == null ? null : adminName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}