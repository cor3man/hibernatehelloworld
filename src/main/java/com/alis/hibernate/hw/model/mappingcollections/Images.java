package com.alis.hibernate.hw.model.mappingcollections;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class Images {

    @NotNull
    private String title;

    @NotNull
    private String filename;

    private int width;

    private int height;

    private Images()
    {
    }

    public Images(String title, String filename, int width, int height)
    {
        this.title = title;
        this.filename = filename;
        this.width = width;
        this.height = height;
    }
}
