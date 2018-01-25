package com.xt.action;

import com.alibaba.fastjson.JSONObject;
import com.xt.bean.TreeNode;
import com.xt.service.PrivilegeService;

import java.io.IOException;
import java.util.List;

/**
 * Created by june on 2018/1/18.
 */
public class TreeAction extends BaseAction {
    private static final long serialVersionUID = 2505424153343618069L;
    private PrivilegeService privilegeService = new PrivilegeService();

    public TreeAction() {
    }

    public void showTree() {
        List<TreeNode> list = this.privilegeService.getTreeNode(Integer.valueOf(0));
        String jsonStr = JSONObject.toJSONString(list);

        try {
            this.printJson(jsonStr);
        } catch (IOException var4) {
            var4.printStackTrace();
        }

    }
}

