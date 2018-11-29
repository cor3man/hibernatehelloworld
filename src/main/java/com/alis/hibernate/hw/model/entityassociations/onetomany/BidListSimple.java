package com.alis.hibernate.hw.model.entityassociations.onetomany;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BidListSimple {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int amount;

    public BidListSimple()
    {
    }

    public BidListSimple(int amount)
    {
        this.amount = amount;
    }

}
