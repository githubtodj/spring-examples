package com.xt.service;

import com.xt.bean.Role;
import com.xt.bean.ZtreeNode;

import java.util.List;
import java.util.Map;

/**
 * Created by june on 2018/1/18.
 */
public interface RoleService {
    Map<String, Object> findRoleList(Integer var1, Integer var2);

    List<ZtreeNode> getAllPrivilegeTree();

    boolean update(Role var1);

    boolean save(Role var1);
}
