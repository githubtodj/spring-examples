package com.xt.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by june on 2018/1/18.
 */
public class BaseAction extends ActionSupport {
    private static final long serialVersionUID = -5277810869240193817L;

    public BaseAction() {
    }

    public void printJson(String jsonStr) throws IOException {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write(jsonStr);
    }

    public HttpServletRequest getRequest() {
        return ServletActionContext.getRequest();
    }
}
