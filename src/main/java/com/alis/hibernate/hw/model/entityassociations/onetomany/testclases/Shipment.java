package com.alis.hibernate.hw.model.entityassociations.onetomany.testclases;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String shipName;

    public Shipment()
    {
    }

    public Shipment(String shipName)
    {
        this.shipName = shipName;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
}
