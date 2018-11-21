package com.alis.hibernate.hw.model.mappinginherit.singletable;

import com.alis.hibernate.hw.model.Constants;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "BD_TYPE")
public abstract class BillingDetails {

    @Id
    @GeneratedValue(generator = Constants.ID_GENERATOR)
    protected Integer id;
    @NotNull
    @Column(nullable = false)
    protected String owner;

    public BillingDetails()
    {
    }

    public BillingDetails(String owner)
    {
        this.owner = owner;
    }


}
