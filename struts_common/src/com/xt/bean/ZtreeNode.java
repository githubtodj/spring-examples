package com.xt.bean;

/**
 * Created by june on 2018/1/18.
 */
public class ZtreeNode {
    private String id;
    private String name;
    private Integer state;
    private Integer pId;
    private String icon;
    private String iconClose;
    private String iconOpen;
    private Boolean open;
    private Boolean isParent;
    private String localUrl;
    private String url;
    private String file;

    public ZtreeNode() {
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{id:\"");
        sb.append(this.id);
        sb.append("\",pId:\"");
        sb.append(this.pId);
        sb.append("\",name:\"");
        sb.append(this.name);
        sb.append("\",state:");
        sb.append(this.state);
        sb.append(",icon:\"");
        sb.append(this.icon);
        sb.append("\",iconClose:\"");
        sb.append(this.iconClose);
        sb.append("\",iconOpen:\"");
        sb.append(this.iconOpen);
        sb.append("\",open:\"");
        sb.append(this.open);
        sb.append("\",isParent:\"");
        sb.append(this.isParent);
        sb.append("\"}");
        return sb.toString();
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getState() {
        return this.state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getpId() {
        return this.pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIconClose() {
        return this.iconClose;
    }

    public void setIconClose(String iconClose) {
        this.iconClose = iconClose;
    }

    public String getIconOpen() {
        return this.iconOpen;
    }

    public void setIconOpen(String iconOpen) {
        this.iconOpen = iconOpen;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getOpen() {
        return this.open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    public Boolean getIsParent() {
        return this.isParent;
    }

    public void setIsParent(Boolean isParent) {
        this.isParent = isParent;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFile() {
        return this.file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getLocalUrl() {
        return this.localUrl;
    }

    public void setLocalUrl(String localUrl) {
        this.localUrl = localUrl;
    }

    public static void main(String[] args) {
        ZtreeNode ztree1 = new ZtreeNode();
        ztree1.setId("1");
        ztree1.setpId(Integer.valueOf(0));
        ztree1.setName("顶层节点");
        System.out.println(ztree1);
    }
}