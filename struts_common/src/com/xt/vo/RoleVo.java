package com.xt.vo;

/**
 * Created by june on 2018/1/18.
 */
public class RoleVo {
    private Integer id;
    private String name;
    private String description;
    private String privilegeIds;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrivilegeIds() {
        return this.privilegeIds;
    }

    public void setPrivilegeIds(String privilegeIds) {
        this.privilegeIds = privilegeIds;
    }

    public RoleVo(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public RoleVo() {
    }
}
