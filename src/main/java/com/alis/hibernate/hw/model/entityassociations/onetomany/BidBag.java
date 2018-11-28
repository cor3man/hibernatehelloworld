package com.alis.hibernate.hw.model.entityassociations.onetomany;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class BidBag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Item_id", nullable = false)
    private ItemBag item;

    private int amount;

    public BidBag()
    {
    }

    public BidBag(ItemBag item, int amount)
    {
        this.item = item;
        this.amount = amount;
    }

    public void setItem(ItemBag item)
    {
        this.item = item;
    }

    public ItemBag getItem()
    {
        return item;
    }
}
