package com.xt.bean;


import java.util.List;
/**
 * Created by june on 2018/1/25.
 */
public class TreeNode {
    private Integer id;
    private String text;
    private List<TreeNode> children;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<TreeNode> getChildren() {
        return this.children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    public TreeNode() {
    }

    public TreeNode(Integer id, String text) {
        this.id = id;
        this.text = text;
    }

    public String toString() {
        return "TreeNode [id=" + this.id + ", text=" + this.text + "]";
    }
}
