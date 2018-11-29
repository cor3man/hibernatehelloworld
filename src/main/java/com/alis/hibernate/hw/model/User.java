package com.alis.hibernate.hw.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(generator = Constants.ID_GENERATOR)
    private Long id;

    private String user;

    @Lob
    private byte[] bytes;

    protected User(){
        super();
    }

    public User(String user)
    {
        this.user = user;
    }

    public User(String user, byte[] bytes)
    {
        this.user = user;
        this.bytes = bytes;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getUser()
    {
        System.out.println("*******************************************************************************");
        return user;
    }

    public void setUser(String user)
    {
        this.user = user;
    }
}
