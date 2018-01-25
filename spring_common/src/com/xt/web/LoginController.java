package com.xt.web;

import com.xt.annotation.PrivilegeInfo;
import com.xt.bean.Privilege;
import com.xt.bean.User;
import com.xt.service.LoginService;
import com.xt.service.PrivilegeService;
import java.util.Collection;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by june on 2018/1/25.
 */
@Controller
@RequestMapping({"/LoginController"})
public class LoginController {
    private static final Logger LOGGER = Logger.getLogger(LoginController.class);
    @Resource(
            name = "loginService"
    )
    private LoginService loginService;
    @Resource(
            name = "privilegeService"
    )
    private PrivilegeService privilegeService;

    public LoginController() {
    }

    @RequestMapping({"/login"})
    public String login(HttpSession session, String username, String passwd) {
        System.out.println("login!!!!!");
        LOGGER.debug("login!!!!!进入登录验证方法");
        LOGGER.info("login!!!!!进入登录验证方法");
        User user = this.loginService.login(username, passwd);
        LOGGER.debug("user===" + user);
        if(user == null) {
            return "login_error";
        } else {
            try {
                Collection<Privilege> privilegeCol = this.privilegeService.getFunctions(user.getRoles());
                session.setAttribute("privileges", privilegeCol);
                session.setAttribute("user", user);
            } catch (Exception var6) {
                LOGGER.error(var6.getMessage());
            }

            return "menu/main";
        }
    }

    @PrivilegeInfo(
            name = "添加部门"
    )
    @RequestMapping({"/addDept"})
    public String addDept() {
        System.out.println("添加部门：部门名称：销售部，部门人数：30人");
        return "addDept";
    }
}
