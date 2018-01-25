package com.xt.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xt.bean.*;
import com.xt.service.PrivilegeService;
import com.xt.service.RoleService;
import com.xt.service.impl.RoleServiceImpl;
import com.xt.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by june on 2018/1/18.
 */
public class PrivilegeTest {
    private Session session;
    private Transaction tx;
    private PrivilegeService privilegeService = new PrivilegeService();
    private RoleService roleService = new RoleServiceImpl();

    public PrivilegeTest() {
    }

    @Before
    public void init() {
        this.session = HibernateSessionFactory.getSession();
        this.tx = this.session.beginTransaction();
    }

    public void initParentMenu() {
    }

    @Test
    public void insertData() {
        User u1 = new User("admin", "admin", "男", "13700222", "zhangsan@qq.com");
        User u2 = new User("李梅", "lm123", "女", "13913113", "limei@qq.com");
        Role r1 = new Role("普通用户", "普通用户角色");
        Role r2 = new Role("部门用户", "部门负责人角色");
        Role r3 = new Role("超级管理员", "超级管理员角色");
        Privilege p1 = new Privilege("部门管理", "部门管理", "", Integer.valueOf(0), "images/add.png");
        Privilege p2 = new Privilege("员工管理", "员工管理", "", Integer.valueOf(0), "images/add.png");
        Privilege p3 = new Privilege("添加部门", "添加部门", "deptinfo.jsp", p1.getId(), "images/add.png");
        Privilege p4 = new Privilege("删除部门", "删除部门", "deptinfo.jsp", p1.getId(), "images/add.png");
        Privilege p5 = new Privilege("修改部门", "修改部门", "deptinfo.jsp", p1.getId(), "images/add.png");
        Privilege p6 = new Privilege("查看部门", "查看部门", "deptinfo.jsp", p1.getId(), "images/add.png");
        Privilege p31 = new Privilege("添加部门1", "添加部门1", "deptinfo.jsp", p1.getId(), "images/add.png");
        Privilege p41 = new Privilege("删除部门1", "删除部门1", "deptinfo.jsp", p1.getId(), "images/add.png");
        Privilege p51 = new Privilege("修改部门1", "修改部门1", "deptinfo.jsp", p1.getId(), "images/add.png");
        Privilege p61 = new Privilege("查看部门1", "查看部门1", "deptinfo.jsp", p1.getId(), "images/add.png");
        Privilege p32 = new Privilege("添加部门2", "添加部门2", "deptinfo.jsp", p1.getId(), "images/add.png");
        Privilege p42 = new Privilege("删除部门2", "删除部门2", "deptinfo.jsp", p1.getId(), "images/add.png");
        Privilege p52 = new Privilege("修改部门2", "修改部门2", "deptinfo.jsp", p1.getId(), "images/add.png");
        Privilege p62 = new Privilege("查看部门2", "查看部门", "deptinfo.jsp", p1.getId(), "images/add.png");
        Privilege p7 = new Privilege("添加员工", "添加员工", "emp.jsp", p2.getId(), "images/add.png");
        Privilege p8 = new Privilege("删除员工", "删除员工", "emp.jsp", p2.getId(), "images/add.png");
        Privilege p9 = new Privilege("修改员工", "修改员工", "emp.jsp", p2.getId(), "images/add.png");
        Privilege p10 = new Privilege("查看员工", "查看员工", "emp.jsp", p2.getId(), "images/add.png");
        Privilege p71 = new Privilege("添加员工1", "添加员工", "emp.jsp", p2.getId(), "images/add.png");
        Privilege p81 = new Privilege("删除员工1", "删除员工", "emp.jsp", p2.getId(), "images/add.png");
        Privilege p91 = new Privilege("修改员工1", "修改员工", "emp.jsp", p2.getId(), "images/add.png");
        Privilege p101 = new Privilege("查看员工1", "查看员工", "emp.jsp", p2.getId(), "images/add.png");
        Privilege p72 = new Privilege("添加员工2", "添加员工", "emp.jsp", p2.getId(), "images/add.png");
        Privilege p82 = new Privilege("删除员工2", "删除员工", "emp.jsp", p2.getId(), "images/add.png");
        Privilege p92 = new Privilege("修改员工2", "修改员工", "emp.jsp", p2.getId(), "images/add.png");
        Privilege p102 = new Privilege("查看员工2", "查看员工", "emp.jsp", p2.getId(), "images/add.png");
        Privilege p11 = new Privilege("系统管理", "系统管理", "", Integer.valueOf(0), "images/add.png");
        Privilege p12 = new Privilege("角色管理", "角色管理", "main/role.jsp", p11.getId(), "images/add.png");
        Privilege p13 = new Privilege("权限管理", "权限管理", "main/privilege.jsp", p11.getId(), "images/add.png");
        Privilege p14 = new Privilege("用户管理", "用户管理", "main/user.jsp", p11.getId(), "images/add.png");
        u1.getRoles().add(r1);
        u1.getRoles().add(r2);
        u1.getRoles().add(r3);
        u2.getRoles().add(r1);
        r1.getUsers().add(u1);
        r1.getUsers().add(u2);
        r2.getUsers().add(u1);
        r3.getUsers().add(u1);
        r1.getPrivileges().add(p1);
        r1.getPrivileges().add(p2);
        r1.getPrivileges().add(p6);
        r1.getPrivileges().add(p10);
        r2.getPrivileges().add(p1);
        r2.getPrivileges().add(p2);
        r2.getPrivileges().add(p3);
        r2.getPrivileges().add(p4);
        r2.getPrivileges().add(p5);
        r2.getPrivileges().add(p6);
        r2.getPrivileges().add(p31);
        r2.getPrivileges().add(p41);
        r2.getPrivileges().add(p51);
        r2.getPrivileges().add(p61);
        r2.getPrivileges().add(p71);
        r2.getPrivileges().add(p81);
        r2.getPrivileges().add(p91);
        r2.getPrivileges().add(p101);
        r2.getPrivileges().add(p32);
        r2.getPrivileges().add(p42);
        r2.getPrivileges().add(p52);
        r2.getPrivileges().add(p62);
        r2.getPrivileges().add(p72);
        r2.getPrivileges().add(p82);
        r2.getPrivileges().add(p92);
        r2.getPrivileges().add(p102);
        r2.getPrivileges().add(p7);
        r2.getPrivileges().add(p8);
        r2.getPrivileges().add(p9);
        r2.getPrivileges().add(p10);
        r3.getPrivileges().add(p11);
        r3.getPrivileges().add(p12);
        r3.getPrivileges().add(p13);
        r3.getPrivileges().add(p14);
        p1.getRoles().add(r2);
        p2.getRoles().add(r2);
        p3.getRoles().add(r2);
        p4.getRoles().add(r2);
        p5.getRoles().add(r2);
        p6.getRoles().add(r2);
        p31.getRoles().add(r2);
        p41.getRoles().add(r2);
        p51.getRoles().add(r2);
        p61.getRoles().add(r2);
        p32.getRoles().add(r2);
        p42.getRoles().add(r2);
        p52.getRoles().add(r2);
        p62.getRoles().add(r2);
        p7.getRoles().add(r2);
        p8.getRoles().add(r2);
        p9.getRoles().add(r2);
        p10.getRoles().add(r2);
        p71.getRoles().add(r2);
        p81.getRoles().add(r2);
        p91.getRoles().add(r2);
        p101.getRoles().add(r2);
        p72.getRoles().add(r2);
        p82.getRoles().add(r2);
        p92.getRoles().add(r2);
        p102.getRoles().add(r2);
        p11.getRoles().add(r2);
        p12.getRoles().add(r2);
        p13.getRoles().add(r2);
        p14.getRoles().add(r2);
        p1.getRoles().add(r1);
        p2.getRoles().add(r1);
        p6.getRoles().add(r1);
        p10.getRoles().add(r1);
        this.session.save(r1);
        this.session.save(r2);
        p3.setParentId(p1.getId());
        p4.setParentId(p1.getId());
        p5.setParentId(p1.getId());
        p6.setParentId(p1.getId());
        p31.setParentId(p1.getId());
        p41.setParentId(p1.getId());
        p51.setParentId(p1.getId());
        p61.setParentId(p1.getId());
        p32.setParentId(p1.getId());
        p42.setParentId(p1.getId());
        p52.setParentId(p1.getId());
        p62.setParentId(p1.getId());
        p7.setParentId(p2.getId());
        p8.setParentId(p2.getId());
        p9.setParentId(p2.getId());
        p10.setParentId(p2.getId());
        p71.setParentId(p2.getId());
        p81.setParentId(p2.getId());
        p91.setParentId(p2.getId());
        p101.setParentId(p2.getId());
        p72.setParentId(p2.getId());
        p82.setParentId(p2.getId());
        p92.setParentId(p2.getId());
        p102.setParentId(p2.getId());
        p12.setParentId(p11.getId());
        p13.setParentId(p11.getId());
        p14.setParentId(p11.getId());
        Privilege root = new Privilege("菜单管理", "菜单管理", "", (Integer)null, "images/add.png");
        this.session.save(root);
        this.tx.commit();
    }

    @Test
    public void findSingle() {
        User user = (User)this.session.get(User.class, Integer.valueOf(2));
        Collection<Privilege> pc = this.privilegeService.getFunctions(user.getRoles());
        Iterator var4 = pc.iterator();

        while(var4.hasNext()) {
            Privilege p = (Privilege)var4.next();
            System.out.println(p);
        }

    }

    @Test
    public void findMenus() {
        User user = (User)this.session.get(User.class, Integer.valueOf(1));
        Collection<Privilege> privilegeCol = this.privilegeService.getFunctions(user.getRoles());
        List<ZtreeNode> mainMenulistTree = this.privilegeService.getFuncsTreeByPrivilege(privilegeCol);
        Iterator var5 = mainMenulistTree.iterator();

        while(var5.hasNext()) {
            ZtreeNode ztreeNode = (ZtreeNode)var5.next();
            System.out.println(ztreeNode);
        }

    }

    @Test
    public void findAllPrivilegeTree() {
        List<ZtreeNode> privilegeTreeList = this.roleService.getAllPrivilegeTree();
        Iterator var3 = privilegeTreeList.iterator();

        while(var3.hasNext()) {
            ZtreeNode ztreeNode = (ZtreeNode)var3.next();
            System.out.println(ztreeNode);
        }

    }

    @Test
    public void findRolePage() {
        System.out.println(JSONObject.toJSONString(this.roleService.findRoleList(Integer.valueOf(1), Integer.valueOf(10))));
    }

    @Test
    public void loadTree() {
        List<TreeNode> tList = this.privilegeService.getTreeNode(Integer.valueOf(0));
        String jsonStr = JSONArray.toJSONString(tList);
        System.out.println(jsonStr);
    }
}
