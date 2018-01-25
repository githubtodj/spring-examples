package com.xt.listener;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
/**
 * Created by june on 2018/1/25.
 */
public class SessionContext {
    private static Map<String, Object> mymap = new HashMap();

    public SessionContext() {

    }

    public static synchronized void AddSession(HttpSession session) {
        if(session != null) {
            mymap.put(session.getId(), session);
        }

    }

    public static synchronized void DelSession(HttpSession session) {
        if(session != null) {
            mymap.remove(session.getId());
        }

    }

    public static synchronized HttpSession getSession(String session_id) {
        return session_id == null?null:(HttpSession)mymap.get(session_id);
    }
}
