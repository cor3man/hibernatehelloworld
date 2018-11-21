package com.alis.hibernate.hw.model.mappingcollections;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class ItemList {

    @Id
    @GeneratedValue
    protected Integer Id;

    protected String name;

    @ElementCollection
    @CollectionTable(
            name = "IMAGE_LIST",
            joinColumns = @JoinColumn(name = "ITEM_ID")
    )
    @OrderColumn(name = "ORDER_ID")
    @Column(name = "filename")
    protected List<String> images = new ArrayList<>();

    private ItemList(){}

    public ItemList(String name, List<String> images)
    {
        this.name = name;
        this.images = images;
    }

    public List<String> getImages()
    {
        return images;
    }
}
