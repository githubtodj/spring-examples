package com.xt.service.impl;

import com.xt.bean.Privilege;
import com.xt.bean.Role;
import com.xt.bean.TreeNode;
import com.xt.bean.ZtreeNode;
import com.xt.service.PrivilegeService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by june on 2018/1/25.
 */
@Service("privilegeService")
public class PrivilegeServiceImpl implements PrivilegeService {
    @Autowired
    private SessionFactory sessionFactory;

    public PrivilegeServiceImpl() {
    }

    private Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    public Collection<Privilege> getFunctions(Set<Role> roles) {
        Collection<Privilege> pCol = new HashSet();
        Iterator var4 = roles.iterator();

        while(var4.hasNext()) {
            Role role = (Role)var4.next();
            pCol.addAll(role.getPrivileges());
        }

        return pCol;
    }

    public List<ZtreeNode> getFuncsTreeByPrivilege(Collection<Privilege> privilegeCol) {
        List<ZtreeNode> funcList = null;
        if(privilegeCol != null && privilegeCol.size() > 0) {
            funcList = new ArrayList();

            ZtreeNode ztreeNode;
            for(Iterator var4 = privilegeCol.iterator(); var4.hasNext(); funcList.add(ztreeNode)) {
                Privilege privilege = (Privilege)var4.next();
                ztreeNode = new ZtreeNode();
                ztreeNode.setId(privilege.getId().toString());
                ztreeNode.setName(privilege.getDescription());
                ztreeNode.setLocalUrl(privilege.getUrl());
                ztreeNode.setpId(privilege.getParentId());
                if(privilege.getParentId().intValue() == 0) {
                    ztreeNode.setIsParent(Boolean.valueOf(true));
                }
            }

            return funcList;
        } else {
            return null;
        }
    }

    public List<ZtreeNode> getFullTreeByPrivilege() {
        Session session = this.getCurrentSession();
        List<Privilege> pList = session.createQuery("from Privilege ").list();
        if(pList != null && pList.size() > 0) {
            List<ZtreeNode> funcList = new ArrayList();
            Iterator var5 = pList.iterator();

            while(var5.hasNext()) {
                Privilege privilege = (Privilege)var5.next();
                if(privilege != null) {
                    ZtreeNode ztreeNode = new ZtreeNode();
                    ztreeNode.setId(privilege.getId().toString());
                    ztreeNode.setName(privilege.getDescription());
                    ztreeNode.setLocalUrl(privilege.getUrl());
                    ztreeNode.setpId(privilege.getParentId());
                    if(privilege.getParentId() != null && privilege.getParentId().intValue() == 0) {
                        ztreeNode.setIsParent(Boolean.valueOf(true));
                    }

                    funcList.add(ztreeNode);
                }
            }

            return funcList;
        } else {
            return null;
        }
    }

    public List<Privilege> findByParentId(Integer parentPrivilegeId) {
        Session session = this.getCurrentSession();
        return session.createQuery("from Privilege where parentId=?").setInteger(0, parentPrivilegeId.intValue()).list();
    }

    public List<TreeNode> getTreeNode(List<TreeNode> tList, Integer id) {
        List<Privilege> pList = this.findByParentId(id);
        if(pList != null && pList.size() > 0) {
            Iterator var5 = pList.iterator();

            while(var5.hasNext()) {
                Privilege privilege = (Privilege)var5.next();
                TreeNode tn = new TreeNode(privilege.getId(), privilege.getDescription());
                System.out.println("name==" + privilege.getDescription());
                List<TreeNode> child = this.getTreeNode(tList, privilege.getId());
                tn.setChildren(child);
                tList.add(tn);
            }
        }

        return tList;
    }

    public List<TreeNode> getTreeNode(Integer id) {
        List<TreeNode> tList = null;
        List<Privilege> pList = this.findByParentId(id);
        if(pList != null && pList.size() > 0) {
            tList = new ArrayList();
            Iterator var5 = pList.iterator();

            while(var5.hasNext()) {
                Privilege privilege = (Privilege)var5.next();
                TreeNode tn = new TreeNode(privilege.getId(), privilege.getDescription());
                System.out.println("name==" + privilege.getDescription());
                List<TreeNode> child = this.getTreeNode(privilege.getId());
                tn.setChildren(child);
                tList.add(tn);
            }
        }

        return tList;
    }
}
