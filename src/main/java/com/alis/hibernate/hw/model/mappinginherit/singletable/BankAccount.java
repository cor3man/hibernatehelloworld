package com.alis.hibernate.hw.model.mappinginherit.singletable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue("BA")
public class BankAccount extends BillingDetails{

    @NotNull
    protected String accaunt;
    @NotNull
    protected String bankname;
    @NotNull
    protected String swift;

    public BankAccount(String owner, String accaunt, String bankname, String swift)
    {
        super(owner);
        this.accaunt = accaunt;
        this.bankname = bankname;
        this.swift = swift;
    }

    @Override
    public String toString()
    {
        return "BankAccount{" +
                "accaunt='" + accaunt + '\'' +
                ", bankname='" + bankname + '\'' +
                ", swift='" + swift + '\'' +
                ", id=" + id +
                ", owner='" + owner + '\'' +
                '}';
    }
}
