package com.xt.service.impl;

import com.xt.bean.Role;
import com.xt.service.RoleService;
import com.xt.vo.RoleVo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * Created by june on 2018/1/25.
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Autowired
    private SessionFactory sessionFactory;

    public RoleServiceImpl() {
    }

    private Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    public Map<String, Object> findRoleList(Integer pageNo, Integer pageSize) {
        Map<String, Object> roleMap = new HashMap();
        Session session = this.getCurrentSession();
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
        Session session = this.getCurrentSession();
        return (Long)session.createQuery("select count(*) from Role").uniqueResult();
    }

    public boolean update(Role role) {
        return false;
    }

    public boolean save(Role role) {
        return false;
    }
}
