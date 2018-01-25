package com.xt.web;

import com.alibaba.fastjson.JSONObject;
import com.xt.bean.Privilege;
import com.xt.bean.ZtreeNode;
import com.xt.service.PrivilegeService;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * Created by june on 2018/1/25.
 */
@Controller
@RequestMapping({"/MenuController"})
public class MenuController {
    private static final Logger LOGGER = Logger.getLogger(MenuController.class);
    @Resource
    private PrivilegeService privilegeService;

    public MenuController() {
    }

    @RequestMapping(
            value = {"/loadMenuTree"},
            produces = {"text/json;charset=UTF-8"}
    )
    @ResponseBody
    public String testLoadMenuTree(HttpSession session) {
        LOGGER.debug("begin load MenuTree 开始读取菜单树 》》》》》》》》》》");
        Collection<Privilege> privileges = (HashSet)session.getAttribute("privileges");
        LOGGER.debug("privileges=" + privileges);
        LOGGER.debug("privilegeService=" + this.privilegeService);
        List<ZtreeNode> mainMenulistTree = this.privilegeService.getFuncsTreeByPrivilege(privileges);
        LOGGER.info("mainMenulistTree=" + mainMenulistTree);
        LOGGER.debug("end load MenuTree 介绍读取菜单树》 》》》》》》》》》");
        return JSONObject.toJSONString(mainMenulistTree);
    }

    @ResponseBody
    @RequestMapping({"/loadMenuTree"})
    public List<ZtreeNode> loadMenuTree(HttpSession session, ModelMap mm) {
        LOGGER.debug("begin load MenuTree 开始读取菜单树 》》》》》》》》》》");
        Collection<Privilege> privileges = (HashSet)session.getAttribute("privileges");
        LOGGER.debug("privileges=" + privileges);
        LOGGER.debug("privilegeService=" + this.privilegeService);
        List<ZtreeNode> mainMenulistTree = this.privilegeService.getFuncsTreeByPrivilege(privileges);
        LOGGER.info("mainMenulistTree=" + mainMenulistTree);
        LOGGER.debug("end load MenuTree 介绍读取菜单树》 》》》》》》》》》");
        return mainMenulistTree;
    }
}
