package com.alis.hibernate.hw.model.mappinginherit;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class BankAccount extends BillingDetails {

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
}
