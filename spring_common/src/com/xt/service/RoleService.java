package com.xt.service;

/**
 * Created by june on 2018/1/25.
 */
import com.xt.bean.Role;
import java.util.Map;

public interface RoleService {
    Map<String, Object> findRoleList(Integer var1, Integer var2);

    boolean update(Role var1);

    boolean save(Role var1);
}
