package com.alis.hibernate.hw.model.entityassociations.onetomany;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ItemList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private String name;

    @OneToMany
    @JoinColumn(name = "Item_Id", nullable = false)
    @OrderColumn(name = "Bid_Pos", nullable = false)
    private List<BidListSimple> bids = new ArrayList<>();

    public ItemList()
    {
    }

    public ItemList(String name)
    {
        this.name = name;
    }



    public List<BidListSimple> getBids()
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
