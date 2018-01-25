package com.xt.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by june on 2018/1/18.
 */
@Entity
@Table(
        name = "t_role"
)
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Integer id;
    private String name;
    private String description;
    @ManyToMany(
            cascade = {CascadeType.ALL},
            fetch = FetchType.LAZY,
            targetEntity = User.class
    )
    @JoinTable(
            name = "t_role_user",
            joinColumns = {@JoinColumn(
                    name = "role_id"
            )},
            inverseJoinColumns = {@JoinColumn(
                    name = "user_id"
            )}
    )
    private Set<User> users = new HashSet();
    @ManyToMany(
            cascade = {CascadeType.ALL},
            fetch = FetchType.LAZY,
            targetEntity = Privilege.class
    )
    @JoinTable(
            name = "t_role_privilege",
            joinColumns = {@JoinColumn(
                    name = "role_id"
            )},
            inverseJoinColumns = {@JoinColumn(
                    name = "privilege_id"
            )}
    )
    private Set<Privilege> privileges = new HashSet();

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

    public Set<User> getUsers() {
        return this.users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Privilege> getPrivileges() {
        return this.privileges;
    }

    public void setPrivileges(Set<Privilege> privileges) {
        this.privileges = privileges;
    }

    public Role(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Role() {
    }
}

