package com.alis.hibernate.hw.shared;

import java.io.Serializable;

public class MapAsSer implements Serializable {

    private String s;
    private int i;

    public MapAsSer(String s, int i)
    {
        this.s = s;
        this.i = i;
    }
}
