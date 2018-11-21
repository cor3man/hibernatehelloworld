package com.alis.hibernate.hw.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Message {

    @Id
    @GeneratedValue(generator = Constants.ID_GENERATOR)
    private Long id=77L;
    //private java.lang.String id;

    private String msg;

    protected Message(){
        super();
    }

    public Message(String msg)
    {
        this.msg = msg;
    }

/*    public Long getId() {
        return id;
    }*/

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
