package com.xt.action;

import com.xt.bean.Privilege;
import com.xt.bean.ZtreeNode;
import com.xt.service.PrivilegeService;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * Created by june on 2018/1/18.
 */
public class MenuAction {
    private static final Logger LOGGER = Logger.getLogger(MenuAction.class);
    private List<ZtreeNode> mainMenulistTree = new ArrayList();
    private PrivilegeService privilegeService = new PrivilegeService();

    public MenuAction() {
    }

    public String loadMenuTree() {
        LOGGER.debug("begin load MenuTree 开始读取菜单树 》》》》》》》》》》");
        HttpSession session = ServletActionContext.getRequest().getSession();
        Collection<Privilege> privileges = (HashSet)session.getAttribute("privileges");
        LOGGER.debug("privileges=" + privileges);
        LOGGER.debug("privilegeService=" + this.privilegeService);
        this.mainMenulistTree = this.privilegeService.getFuncsTreeByPrivilege(privileges);
        LOGGER.debug("mainMenulistTree=" + this.mainMenulistTree);
        LOGGER.debug("end load MenuTree 介绍读取菜单树》 》》》》》》》》》");
        return "menus";
    }

    public List<ZtreeNode> getMainMenulistTree() {
        return this.mainMenulistTree;
    }

    public void setMainMenulistTree(List<ZtreeNode> mainMenulistTree) {
        this.mainMenulistTree = mainMenulistTree;
    }
}
