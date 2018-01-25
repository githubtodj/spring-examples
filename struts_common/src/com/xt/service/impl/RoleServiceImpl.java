package com.xt.service.impl;

import com.xt.bean.Role;
import com.xt.bean.ZtreeNode;
import com.xt.service.PrivilegeService;
import com.xt.service.RoleService;
import com.xt.util.HibernateSessionFactory;
import com.xt.vo.RoleVo;
import org.hibernate.Session;

import java.util.*;

/**
 * Created by june on 2018/1/18.
 */
public class RoleServiceImpl implements RoleService {
    private PrivilegeService privilegeService = new PrivilegeService();

    public RoleServiceImpl() {
    }

    public Map<String, Object> findRoleList(Integer pageNo, Integer pageSize) {
        Map<String, Object> roleMap = new HashMap();
        Session session = HibernateSessionFactory.getSession();
        List<Object[]> roleObjList = session.createQuery("select id,name,description from Role").setFirstResult((pageNo.intValue() - 1) * pageSize.intValue()).setMaxResults(pageSize.intValue()).list();
        if(roleObjList == null) {
            return roleMap;
        } else {
            List<RoleVo> roleList = new ArrayList();
            Iterator var8 = roleObjList.iterator();

            while(var8.hasNext()) {
                Object[] objs = (Object[])var8.next();
                RoleVo role = new RoleVo((Integer)objs[0], (String)objs[1], (String)objs[2]);
                roleList.add(role);
            }

            roleMap.put("rows", roleList);
            roleMap.put("total", this.getTotal());
            return roleMap;
        }
    }

    private Long getTotal() {
        Session session = HibernateSessionFactory.getSession();
        return (Long)session.createQuery("select count(*) from Role").uniqueResult();
    }

    public List<ZtreeNode> getAllPrivilegeTree() {
        return this.privilegeService.getFullTreeByPrivilege();
    }

    public boolean update(Role role) {
        return false;
    }

    public boolean save(Role role) {
        return false;
    }
}

