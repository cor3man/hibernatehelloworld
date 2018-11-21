package com.alis.hibernate.hw.model.mappingcollections;

import javax.persistence.AttributeOverride;
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
public class ItemComponent {

    @Id
    @GeneratedValue
    protected Integer Id;

    protected String name;

    @ElementCollection
    @CollectionTable(name = "Image")
    @AttributeOverride(
            name = "filename",
            column = @Column(name = "fname", nullable = false)
    )
    protected Set<Images> images = new HashSet<>();

    private ItemComponent(){}

    public ItemComponent(String name, Set<Images> images)
    {
        this.name = name;
        this.images = images;
    }

    public Set<Images> getImages()
    {
        return images;
    }
}
