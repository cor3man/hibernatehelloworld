package com.alis.hibernate.hw.model.entityassociations.onetomany.jointable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;


    private String name;

    @OneToMany(mappedBy = "buyer")
    protected Set<Item> boughtItems = new HashSet<Item>();

    public User()
    {
    }

    public User(String name, Set<Item> boughtItems)
    {
        this.name = name;
        this.boughtItems = boughtItems;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Set<Item> getBoughtItems()
    {
        return boughtItems;
    }

    public void setBoughtItems(Set<Item> boughtItems)
    {
        this.boughtItems = boughtItems;
    }
}
