package com.alis.hibernate.hw.model.entityassociations.onetomany.jointable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(
            name = "ITEM_BUYER",
            joinColumns =
            @JoinColumn(name = "ITEM_ID"),
            inverseJoinColumns =
            @JoinColumn(nullable = true))
    protected User buyer;

    public Item()
    {
    }

    public Item(String name, User buyer)
    {
        this.name = name;
        this.buyer = buyer;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public User getBuyer()
    {
        return buyer;
    }

    public void setBuyer(User buyer)
    {
        this.buyer = buyer;
    }
}
