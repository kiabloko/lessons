package com.domain.lesson12;

import com.domain.lesson11.enums.Role;

public class User {
    private String login;
    private String pwd;
    private Role role;

    public User(String qwe, String pwd, com.domain.lesson11.enums.Role user) {
    }


    public String getLogin() {
        return login;
    }

    public String getPwd() {
        return pwd;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }


    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User(String login, String pwd, Role role) {
        this.login = login;
        this.pwd = pwd;
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", pwd='" + pwd + '\'' +
                ", role=" + role +
                '}';
    }

    enum Role {
        USER, ADMIN
    }
}
