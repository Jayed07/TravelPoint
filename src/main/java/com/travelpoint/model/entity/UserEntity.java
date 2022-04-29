package com.travelpoint.model.entity;

import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

    private String username;
    private String email;
    private String password;
    private List<UserRoleEntity> userRoleEntity = new ArrayList<>();

    public UserEntity() {
    }

    @Column(name = "username", nullable = false, unique = true)
    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    @Column(name = "email", nullable = false, unique = true)
    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    public List<UserRoleEntity> getUserRoleEntity() {
        return userRoleEntity;
    }

    public void setUserRoleEntity(List<UserRoleEntity> userRoleEntity) {
        this.userRoleEntity = userRoleEntity;
    }

    public UserEntity addRole(UserRoleEntity userRoleEntity) {
        this.userRoleEntity.add(userRoleEntity);
        return this;
    }
}
