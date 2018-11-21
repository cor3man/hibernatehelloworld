package com.alis.hibernate.hw.model.mappinginherit.joins;

import com.alis.hibernate.hw.model.Constants;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BillingDetails {

    @Id
    @GeneratedValue(generator = Constants.ID_GENERATOR)
    protected Integer id;

    @NotNull
    protected String owner;

    protected BillingDetails()
    {
    }

    public BillingDetails(String owner)
    {
        this.owner = owner;
    }

    public Integer getId()
    {
        return id;
    }

    public abstract void printDetales();

}
