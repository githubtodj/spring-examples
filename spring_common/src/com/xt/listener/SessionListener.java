package com.xt.listener;


import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import org.apache.log4j.Logger;

/**
 * Created by june on 2018/1/25.
 */
public class SessionListener implements HttpSessionListener {
    private static final Logger LOGGER = Logger.getLogger(SessionListener.class);

    public SessionListener() {
    }

    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        SessionContext.AddSession(httpSessionEvent.getSession());
        LOGGER.debug(">>>>>>>>--session create 创建了----" + httpSessionEvent.getSession().getId());
    }

    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        SessionContext.DelSession(session);
        LOGGER.debug("<<<<<<<<<<----session 销毁了----" + httpSessionEvent.getSession().getId());
    }
}
