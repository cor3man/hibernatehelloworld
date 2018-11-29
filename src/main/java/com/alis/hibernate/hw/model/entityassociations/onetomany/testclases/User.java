package com.alis.hibernate.hw.model.entityassociations.onetomany.testclases;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private Address address;

    public User()
    {
    }



    public User(String name, Address address)
    {
        this.address = address;
        this.name = name;
    }



    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
