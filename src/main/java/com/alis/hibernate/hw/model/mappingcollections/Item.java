package com.alis.hibernate.hw.model.mappingcollections;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Item {

    @Id
    @GeneratedValue
    protected Integer Id;

    protected String name;

    @ElementCollection
    @CollectionTable(
            name = "IMAGE",
            joinColumns = @JoinColumn(name = "ITEM_ID")
    )
    @Column(name = "filename")
    protected Set<String> images = new HashSet<>();

    private Item(){}

    public Item(String name, Set<String> images)
    {
        this.name = name;
        this.images = images;
    }

    public Set<String> getImages()
    {
        return images;
    }
}
