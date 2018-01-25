package com.xt.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by june on 2018/1/18.
 */
@Entity
@Table(name = "t_privilege")
public class Privilege implements Serializable {
    private static final long serialVersionUID = 3857258868428330433L;
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Integer id;
    private String url;
    private Integer parentId;
    private String name;
    private String icon;
    private String description;
    @ManyToMany(
            cascade = {CascadeType.ALL},
            fetch = FetchType.LAZY,
            targetEntity = Role.class,
            mappedBy = "privileges"
    )
    private Set<Role> roles = new HashSet();

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Role> getRoles() {
        return this.roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getParentId() {
        return this.parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Privilege() {
    }

    public Privilege(String name, String description, String url, Integer parentId, String icon) {
        this.url = url;
        this.parentId = parentId;
        this.name = name;
        this.description = description;
        this.icon = icon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Privilege privilege = (Privilege) o;

        if (!id.equals(privilege.id)) return false;
        if (!name.equals(privilege.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }
}

