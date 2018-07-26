package com.endava.springmvc.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="persistent_Logins")
public class PersistentLogin implements Serializable {

    @Id
    private String  series;

    @Column(name = "USERNAME",unique = true,nullable = false)
    private String username;

    @Column(name = "TOKEN",unique = true,nullable = false)
    private String token;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lest_used;

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getLast_used() {
        return lest_used;
    }

    public void setLast_used(Date last_used) {
        this.lest_used = last_used;
    }
}
