package com.alis.hibernate.hw.model.helloworld;

import com.alis.hibernate.hw.model.Constants;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Item {

    @Id
    @GeneratedValue(generator = Constants.ID_GENERATOR)
    protected int id;

    @org.hibernate.annotations.Type(type = "yes_no")
    protected boolean varified = false;


    public boolean isVarified()
    {
        return varified;
    }

    public void setVarified(boolean varified)
    {
        this.varified = varified;
    }
}
