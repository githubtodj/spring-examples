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
        name = "t_user"
)
public class User implements Serializable {
    private static final long serialVersionUID = 5326047036022680157L;
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Integer id;
    private String username;
    private String password;
    private String sex;
    private String phone;
    private String email;
    @ManyToMany(
            cascade = {CascadeType.ALL},
            fetch = FetchType.LAZY,
            targetEntity = Role.class,
            mappedBy = "users"
    )
    private Set<Role> roles = new HashSet();

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Role> getRoles() {
        return this.roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public User(String username, String password, String sex, String phone, String email) {
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.phone = phone;
        this.email = email;
    }

    public User() {
    }
}
