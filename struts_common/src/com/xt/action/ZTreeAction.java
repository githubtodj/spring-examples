package com.xt.action;

import com.xt.bean.ZtreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by june on 2018/1/18.
 */
public class ZTreeAction extends BaseAction {
    private static final long serialVersionUID = 3390343673712644109L;
    private static final String url = "http://www.baidu.com";
    private List<ZtreeNode> listTree = new ArrayList();

    public ZTreeAction() {
    }

    public String showTree() {
        System.out.println("22222222>>>>>>>>ZTreeAction.showTree!!!!!!!");
        String icon = "../img/add.png";
        String iconClose = "../img/iconClose.png";
        String iconOpen = "../img/iconOpen.png";

        for(int i = -1; i < 10000; ++i) {
            ZtreeNode ztree;
            if(i < 0) {
                ztree = new ZtreeNode();
                ztree.setId("0");
                ztree.setName("顶层节点 ");
                ztree.setIsParent(Boolean.valueOf(true));
                ztree.setUrl("http://www.baidu.com");
                this.listTree.add(ztree);
            } else {
                ztree = new ZtreeNode();
                ztree.setId("" + (i + 1));
                ztree.setName(i / 10 + "级节点");
                ztree.setpId(Integer.valueOf(i / 10));
                ztree.setUrl("http://www.baidu.com");
                this.listTree.add(ztree);
            }
        }

        return "success";
    }

    public String asyncTree() {
        String pid = this.getRequest().getParameter("id");
        if(pid != null && !pid.equals("")) {
            for(int i = 0; i < 40; ++i) {
                ZtreeNode ztree = new ZtreeNode();
                ztree.setId(pid + i);
                ztree.setName(pid.length() + "级节点");
                ztree.setState(Integer.valueOf((int)Math.ceil(Math.random() * 4.0D)));
                ztree.setLocalUrl("http://www.baidu.com");
                this.listTree.add(ztree);
            }
        } else {
            pid = "0";
            ZtreeNode ztree = new ZtreeNode();
            ztree.setId("1");
            ztree.setName("顶级节点");
            ztree.setIsParent(Boolean.valueOf(true));
            ztree.setState(Integer.valueOf(1));
            ztree.setLocalUrl("http://www.baidu.com");
            this.listTree.add(ztree);
        }

        return "success";
    }

    public List<ZtreeNode> getListTree() {
        return this.listTree;
    }

    public void setListTree(List<ZtreeNode> listTree) {
        this.listTree = listTree;
    }
}

