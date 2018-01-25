package com.xt.service.impl;

import com.xt.bean.User;
import com.xt.service.LoginService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * Created by june on 2018/1/25.
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {
    @Autowired
    private SessionFactory sessionFactory;

    public LoginServiceImpl() {
    }

    private Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    public User login(String userName, String passWd) {
        Session session = this.getCurrentSession();
        User user = (User)session.createQuery("from User where username=? and password=?").setString(0, userName).setString(1, passWd).setMaxResults(1).uniqueResult();
        return user;
    }
}
