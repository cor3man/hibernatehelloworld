package com.alis.hibernate.hw.model.entityassociations.onetoone;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Address {

    @Id
    @GeneratedValue
    protected int id;

    protected String street;

    protected Address()
    {
    }

    public Address(String street)
    {
        this.street = street;
    }

    public int getId()
    {
        return id;
    }

    public String getStreet()
    {
        return street;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }
}
