package com.alis.hibernate.hw.model.mappinginherit;

import com.alis.hibernate.hw.model.Constants;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BillingDetails {

    @Id
    @GeneratedValue(generator = Constants.ID_GENERATOR)
    protected Integer id;

    @NotNull
    protected String owner;

    public BillingDetails()
    {
    }

    public BillingDetails(String owner)
    {
        this.owner = owner;
    }
}
