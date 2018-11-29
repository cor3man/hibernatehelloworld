package com.alis.hibernate.hw.model.entityassociations.onetomany;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class BidList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Item_id", nullable = false)
    private Item item;

    private int amount;

    public BidList()
    {
    }

    public BidList(Item item, int amount)
    {
        this.item = item;
        this.amount = amount;
    }

    public void setItem(Item item)
    {
        this.item = item;
    }

    public Item getItem()
    {
        return item;
    }
}
