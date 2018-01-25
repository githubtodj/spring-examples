package com.xt.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/**
 * Created by june on 2018/1/18.
 */
public class HibernateSessionFactory {
    private static final ThreadLocal<Session> threadLocal = new ThreadLocal();
    private static SessionFactory sessionFactory;
    private static Configuration configuration = new AnnotationConfiguration();
    private static String CONFIG_FILE_LOCATION = "/hibernate.cfg.xml";
    private static String configFile;

    static {
        configFile = CONFIG_FILE_LOCATION;
        try {
            configuration.configure(configFile);
            sessionFactory = configuration.buildSessionFactory();
        } catch (Exception var1) {
            System.err.println("%%%% Error Creating SessionFactory %%%%");
            var1.printStackTrace();
        }

    }

    private HibernateSessionFactory() {
    }

    public static Session getSession() throws HibernateException {
        Session session = (Session)threadLocal.get();
        if(session == null || !((Session)session).isOpen()) {
            if(sessionFactory == null) {
                rebuildSessionFactory();
            }

            session = sessionFactory != null?sessionFactory.openSession():null;
            threadLocal.set(session);
        }

        return (Session)session;
    }

    public static void rebuildSessionFactory() {
        try {
            configuration.configure(configFile);
            sessionFactory = configuration.buildSessionFactory();
        } catch (Exception var1) {
            System.err.println("%%%% Error Creating SessionFactory %%%%");
            var1.printStackTrace();
        }

    }

    public static void closeSession() throws HibernateException {
        Session session = (Session)threadLocal.get();
        threadLocal.set(null);
        if(session != null) {
            session.close();
        }

    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void setConfigFile(String configFile) {
        configFile = configFile;
        sessionFactory = null;
    }

    public static Configuration getConfiguration() {
        return configuration;
    }
}
