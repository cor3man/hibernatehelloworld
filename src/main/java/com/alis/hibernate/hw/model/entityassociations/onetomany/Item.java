package com.alis.hibernate.hw.model.entityassociations.onetomany;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private String name;


    //TODO: comment it and getters and setters to test uniDirectional
    @OneToMany(mappedBy = "item",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST,
                    CascadeType.REMOVE
            },
            orphanRemoval = true)
    private Set<Bid> bids = new HashSet<>();


    public Item()
    {
    }

    public Item(String name)
    {
        this.name = name;
    }

    public Set<Bid> getBids()
    {
        return bids;
    }

    @Override
    public String toString()
    {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", bids=" + bids +
                '}';
    }
}
