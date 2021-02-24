package com.testboot.test1.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TestUser")
public class TestUser {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="UserLogin")
    private String login;

    @Column(name="Password")
    private String password;

    @Column(name="Name",columnDefinition = "NVARCHAR(50)")
    private String name;

    @Column(name="Surname",columnDefinition = "NVARCHAR(50)")
    private String surname;

    @Column(name="Email")
    private String email;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}