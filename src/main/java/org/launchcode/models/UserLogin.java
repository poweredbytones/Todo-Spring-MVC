package org.launchcode.models;


import org.hibernate.validator.constraints.Email;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity

public class UserLogin {


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() { return username; }

    public void setUsername(String username) {
        this.username = username;
    }

    @Id
    private int id;

    @Size(min=3, max=15)
    private String username;

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    @NotNull
    @Email
    private String email;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NotNull
    @Size(min=3,max=15)
    private String password;


}
