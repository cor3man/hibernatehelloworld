package com.alis.hibernate.hw.model.entityassociations.onetomany.testclases;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Embeddable
public class Address {

    private String street;

    @OneToMany(cascade = CascadeType.PERSIST)
/*    @JoinColumn(
            nullable = false
    )*/
    private Set<Shipment> deliveries = new HashSet<>();

    public Address()
    {
    }

    public Address(String street)
    {
        this.street = street;
    }

    public String getStreet()
    {
        return street;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }

    public Set<Shipment> getDeliveries()
    {
        return deliveries;
    }

    public void setDeliveries(Set<Shipment> deliveries)
    {
        this.deliveries = deliveries;
    }
}
