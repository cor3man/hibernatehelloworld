package com.alis.hibernate.hw.model.mappinginherit.joins;

import com.alis.hibernate.hw.model.Constants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(generator = Constants.ID_GENERATOR)
    protected Integer id;

    @NotNull
    @Column(name = "UsersName")
    protected String name;

    @ManyToOne(fetch = FetchType.LAZY)
    protected BillingDetails defBilling;

    private User()
    {
    }

    public User(String name)
    {
        this.name = name;
    }

    public BillingDetails getDefBilling()
    {
        return defBilling;
    }

    public void setDefBilling(BillingDetails defBilling)
    {
        this.defBilling = defBilling;
    }
}
