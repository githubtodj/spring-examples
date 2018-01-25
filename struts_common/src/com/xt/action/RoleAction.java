package com.xt.action;

import com.xt.bean.ZtreeNode;
import com.xt.service.RoleService;
import com.xt.service.impl.RoleServiceImpl;
import com.xt.vo.RoleVo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by june on 2018/1/18.
 */
public class RoleAction {
    private RoleVo role;
    private Map<String, Object> rolePageJson = new HashMap();
    private List<ZtreeNode> privilegeTreeJson = new ArrayList();
    private RoleService roleService = new RoleServiceImpl();
    private Integer pageNo = Integer.valueOf(1);
    private Integer rows = Integer.valueOf(5);

    public RoleAction() {
    }

    public String findPage() {
        this.rolePageJson = this.roleService.findRoleList(this.pageNo, this.rows);
        return "rolelist";
    }

    public String findPrivilegeTree() {
        this.privilegeTreeJson = this.roleService.getAllPrivilegeTree();
        return "privilegeTreeJson";
    }

    public String deleteRole() {
        return "deleterole";
    }

    public RoleVo getRole() {
        return this.role;
    }

    public void setRole(RoleVo role) {
        this.role = role;
    }

    public Integer getPageNo() {
        return this.pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getRows() {
        return this.rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Map<String, Object> getRolePageJson() {
        return this.rolePageJson;
    }

    public void setRolePageJson(Map<String, Object> rolePageJson) {
        this.rolePageJson = rolePageJson;
    }

    public List<ZtreeNode> getPrivilegeTreeJson() {
        return this.privilegeTreeJson;
    }

    public void setPrivilegeTreeJson(List<ZtreeNode> privilegeTreeJson) {
        this.privilegeTreeJson = privilegeTreeJson;
    }
}
