package com.alis.hibernate.hw.model.entityassociations.onetoone;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class User {

    @Id
    protected int id;

    @OneToOne(fetch = FetchType.LAZY,
            optional = false)
    @PrimaryKeyJoinColumn
    protected Address address;

    protected String userName;

    protected User()
    {
    }

/*    public User(Address address, String userName)
    {
        this.address = address;
        this.userName = userName;
    }*/

    public User(int id, String userName)
    {
        this.id = id;
        this.userName = userName;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public Address getAddress()
    {
        return address;
    }

    public void setAddress(Address address)
    {
        this.address = address;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }
}
