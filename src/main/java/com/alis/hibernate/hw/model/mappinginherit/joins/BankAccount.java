package com.alis.hibernate.hw.model.mappinginherit.joins;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class BankAccount extends BillingDetails {

    @NotNull
    protected String account;
    @NotNull
    protected String bankname;
    @NotNull
    protected String swift;

    public BankAccount()
    {
        super();
    }

    public BankAccount(String owner, String account, String bankname, String swift)
    {
        super(owner);
        this.account = account;
        this.bankname = bankname;
        this.swift = swift;
    }

    @Override
    public void printDetales()
    {
        System.out.println(this);
    }

    @Override
    public String toString()
    {
        return "BankAccount{" +
                "account='" + account + '\'' +
                ", bankname='" + bankname + '\'' +
                ", swift='" + swift + '\'' +
                ", id=" + id +
                ", owner='" + owner + '\'' +
                '}';
    }
}
