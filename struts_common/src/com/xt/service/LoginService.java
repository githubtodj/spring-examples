package com.xt.service;

import com.xt.bean.User;
import com.xt.util.HibernateSessionFactory;
import org.hibernate.Session;

/**
 * Created by june on 2018/1/18.
 */
public class LoginService {
    public LoginService() {
    }

    public User login(String userName, String passWd) {
        Session session = HibernateSessionFactory.getSession();
        User user = (User)session.createQuery("from User where username=? and password=?").setString(0, userName).setString(1, passWd).setMaxResults(1).uniqueResult();
        return user;
    }
}
