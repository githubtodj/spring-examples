package com.xt.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xt.bean.ZtreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by june on 2018/1/18.
 */
public class ZtreeTest {
    public ZtreeTest() {
    }

    @Test
    public void showTree() {
        String icon = "../img/add.png";
        String iconClose = "../img/iconClose.png";
        String iconOpen = "../img/iconOpen.png";
        List<ZtreeNode> listTree = new ArrayList();

        for(int i = -1; i < 100; ++i) {
            ZtreeNode ztree;
            if(i < 0) {
                ztree = new ZtreeNode();
                ztree.setId("0");
                ztree.setName("顶层节点 ");
                ztree.setIsParent(Boolean.valueOf(true));
                ztree.setIcon(icon);
                ztree.setIconClose(iconClose);
                ztree.setIconOpen(iconOpen);
                listTree.add(ztree);
            } else {
                ztree = new ZtreeNode();
                ztree.setId(String.valueOf(i + 1));
                ztree.setName("级节点");
                ztree.setpId(Integer.valueOf(i / 10));
                ztree.setIcon(icon);
                ztree.setIconClose(iconClose);
                ztree.setIconOpen(iconOpen);
                listTree.add(ztree);
            }
        }

        System.out.println(JSONArray.toJSON(listTree));
        System.out.println("====");
        System.out.println(JSONObject.toJSONString(listTree));
    }

    @Test
    public void randomTest() {
        for(int i = 0; i < 20; ++i) {
            System.out.println((int)Math.ceil(Math.random() * 4.0D));
        }

    }
}
