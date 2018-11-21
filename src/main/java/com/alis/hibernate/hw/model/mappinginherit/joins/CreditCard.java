package com.alis.hibernate.hw.model.mappinginherit.joins;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotNull;

@Entity
@PrimaryKeyJoinColumn(name = "CREDITCARD_ID")
public class CreditCard extends BillingDetails{

    @NotNull
    protected String cardNumber;
    @NotNull
    protected String expMonth;
    @NotNull
    protected String expYear;

    public CreditCard()
    {
        super();
    }

    public CreditCard(String owner, String cardNumber, String expMonth, String expYear)
    {
        super(owner);
        this.cardNumber = cardNumber;
        this.expMonth = expMonth;
        this.expYear = expYear;
    }



    @Override
    public void printDetales()
    {
        System.out.println(this);
    }

    @Override
    public String toString()
    {
        return "CreditCard{" +
                "cardNumber='" + cardNumber + '\'' +
                ", expMonth='" + expMonth + '\'' +
                ", expYear='" + expYear + '\'' +
                ", id=" + id +
                ", owner='" + owner + '\'' +
                '}';
    }
}
