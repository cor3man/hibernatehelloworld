package com.alis.hibernate.hw.model.mappingcollections;

import com.alis.hibernate.hw.model.Constants;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.Type;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ItemBag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer Id;

    protected String name;

    @ElementCollection
    @CollectionTable(
            name = "IMAGE_BAG",
            joinColumns = @JoinColumn(name = "ID")
    )
    @Column(name = "filename")
    @CollectionId(
            columns = @Column(name = "Image_id"),
            type = @Type(type = "int"),
            generator = Constants.ID_GENERATOR//"identity"
    )
    protected Collection<String> images = new ArrayList<>();

    private ItemBag(){}

    public ItemBag(String name, Collection<String> images)
    {
        this.name = name;
        this.images = images;
    }

    public Collection<String> getImages()
    {
        return images;
    }
}
