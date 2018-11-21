package com.alis.hibernate.hw.model.entityassociations.onetoone;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class AddressBi {

    @Id
    @GeneratedValue(generator = "addrKeygen")
    @GenericGenerator(
            name = "addrKeygen",
            strategy = "foreign",
            parameters = @Parameter(
                    name = "property",
                    value = "user"
            )
    )
    protected int id;

    @OneToOne(optional = false)
    @PrimaryKeyJoinColumn
    protected UserBi user;

    protected String street;

    protected AddressBi()
    {
    }

    public AddressBi(UserBi user)
    {
        this.user = user;
    }

    public AddressBi(UserBi user, String street)
    {
        this.user = user;
        this.street = street;
    }

    public UserBi getUser()
    {
        return user;
    }

    public void setUser(UserBi user)
    {
        this.user = user;
    }

    public String getStreet()
    {
        return street;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }
}
