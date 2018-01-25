package com.xt.action;

import com.xt.annocation.PrivilegeInfo;
import com.xt.bean.Privilege;
import com.xt.bean.User;
import com.xt.service.LoginService;
import com.xt.service.PrivilegeService;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;
import java.util.Collection;

/**
 * Created by june on 2018/1/18.
 */
public class LoginAction {
    private static final Logger LOGGER = Logger.getLogger(LoginAction.class);
    private String username;
    private String passwd;
    private LoginService loginService = new LoginService();
    private PrivilegeService privilegeService = new PrivilegeService();

    public LoginAction() {
    }

    public String login() {
        System.out.println("loginsss!!!!!");
        LOGGER.debug("login!!!!!进入登录验证方法");
        LOGGER.info("login!!!!!进入登录验证方法");
        User user = this.loginService.login(this.username, this.passwd);
        if(user == null) {
            return "loginError";
        } else {
            HttpSession session = ServletActionContext.getRequest().getSession();
            Collection<Privilege> privilegeCol = this.privilegeService.getFunctions(user.getRoles());
            session.setAttribute("privileges", privilegeCol);
            session.setAttribute("user", user);
            return "index";
        }
    }

    @PrivilegeInfo(
            name = "添加部门"
    )
    public String addDept() {
        System.out.println("添加部门：部门名称：销售部，部门人数：30人");
        return "addDept";
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return this.passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
