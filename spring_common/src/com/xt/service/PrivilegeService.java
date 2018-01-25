package com.xt.service;

import com.xt.bean.Privilege;
import com.xt.bean.Role;
import com.xt.bean.TreeNode;
import com.xt.bean.ZtreeNode;
import java.util.Collection;
import java.util.List;
import java.util.Set;
/**
 * Created by june on 2018/1/25.
 */
public interface PrivilegeService {
    Collection<Privilege> getFunctions(Set<Role> var1);

    List<ZtreeNode> getFuncsTreeByPrivilege(Collection<Privilege> var1);

    List<ZtreeNode> getFullTreeByPrivilege();

    List<Privilege> findByParentId(Integer var1);

    List<TreeNode> getTreeNode(List<TreeNode> var1, Integer var2);

    List<TreeNode> getTreeNode(Integer var1);
}
