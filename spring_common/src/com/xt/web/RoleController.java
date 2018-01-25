package com.xt.web;

import com.alibaba.fastjson.JSONObject;
import com.xt.bean.ZtreeNode;
import com.xt.service.PrivilegeService;
import com.xt.service.RoleService;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * Created by june on 2018/1/25.
 */
@Controller
@RequestMapping({"/RoleController"})
public class RoleController {
    @Resource(
            name = "roleService"
    )
    private RoleService roleService;
    @Resource(
            name = "privilegeService"
    )
    private PrivilegeService privilegeService;

    public RoleController() {
    }

    @RequestMapping(
            value = {"/findPage"},
            produces = {"text/json;charset=UTF-8"}
    )
    @ResponseBody
    public String findPage(Integer page, Integer rows) {
        Map<String, Object> rolePageJson = this.roleService.findRoleList(page, rows);
        return JSONObject.toJSONString(rolePageJson);
    }

    @RequestMapping(
            value = {"/findPrivilegeTree"},
            produces = {"text/json;charset=UTF-8"}
    )
    @ResponseBody
    public String findPrivilegeTree() {
        List<ZtreeNode> privilegeTreeJson = this.privilegeService.getFullTreeByPrivilege();
        return JSONObject.toJSONString(privilegeTreeJson);
    }

    @RequestMapping({"/deleteRole"})
    public String deleteRole() {
        return "deleterole";
    }
}
