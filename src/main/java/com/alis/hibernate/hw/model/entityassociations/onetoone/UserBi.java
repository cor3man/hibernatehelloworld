package com.alis.hibernate.hw.model.entityassociations.onetoone;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class UserBi {

    @Id
    @GeneratedValue
    protected int id;

    @OneToOne(mappedBy = "user",
            cascade = CascadeType.PERSIST)
    protected AddressBi address;

    protected String userName;

    protected UserBi()
    {
    }

    public UserBi(String userName)
    {
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

    public AddressBi getAddress()
    {
        return address;
    }

    public void setAddress(AddressBi address)
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
