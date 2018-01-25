package com.xt.annocation.parser;

import com.xt.annocation.PrivilegeInfo;

import java.lang.reflect.Method;

/**
 * Created by june on 2018/1/18.
 */
public class PrivilegeInfoAnnotationParse {
    public PrivilegeInfoAnnotationParse() {
    }

    public static String parse(Class targetClass, String methodName) throws NoSuchMethodException, SecurityException {
        String privilegeName = "";
        Method method = targetClass.getMethod(methodName, new Class[0]);
        if(method.isAnnotationPresent(PrivilegeInfo.class)) {
            PrivilegeInfo privilegeInfo = (PrivilegeInfo)method.getAnnotation(PrivilegeInfo.class);
            privilegeName = privilegeInfo.name();
        }

        return privilegeName;
    }
}
