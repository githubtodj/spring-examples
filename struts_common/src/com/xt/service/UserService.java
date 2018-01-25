package com.xt.service;

import com.xt.bean.User;

import java.util.Map;

/**
 * Created by june on 2018/1/18.
 */
public interface UserService {
    Map<String, Object> findUserList(Integer var1, Integer var2);

    boolean save(User var1);
}
