package com.xt.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.xt.annocation.parser.PrivilegeInfoAnnotationParse;
import com.xt.bean.Privilege;
import com.xt.bean.User;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by june on 2018/1/18.
 */
public class PrivilegeInterceptor  implements Interceptor {
    private static final long serialVersionUID = -7260780789878892670L;

    public PrivilegeInterceptor() {
    }

    public void destroy() {
    }

    public void init() {
    }

    public String intercept(ActionInvocation invocation) throws Exception {
        HttpSession session = ServletActionContext.getRequest().getSession();
        Collection<Privilege> privileges = (HashSet)session.getAttribute("privileges");
        User user = (User)session.getAttribute("user");
        if(user != null && privileges != null) {
            String methodName = invocation.getProxy().getMethod();
            Class targetClass = invocation.getAction().getClass();
            String privilegeName = PrivilegeInfoAnnotationParse.parse(targetClass, methodName);
            boolean flag = false;
            if(privilegeName != null && !privilegeName.equals("")) {
                if(user.getUsername().equals("admin")) {
                    flag = true;
                } else {
                    Iterator var10 = privileges.iterator();

                    while(var10.hasNext()) {
                        Privilege p = (Privilege)var10.next();
                        if(p.getName().equals(privilegeName)) {
                            flag = true;
                            break;
                        }
                    }
                }
            } else {
                flag = true;
            }

            if(flag) {
                return invocation.invoke();
            } else {
                ActionContext.getContext().getValueStack().push("权限不足");
                return "privilege_error";
            }
        } else {
            return invocation.invoke();
        }
    }
}
