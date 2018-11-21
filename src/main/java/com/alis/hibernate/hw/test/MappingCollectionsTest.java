package com.alis.hibernate.hw.test;

import com.alis.hibernate.hw.environment.TransactionManagerTest;
import com.alis.hibernate.hw.model.mappingcollections.Images;
import com.alis.hibernate.hw.model.mappingcollections.Item;
import com.alis.hibernate.hw.model.mappingcollections.ItemBag;
import com.alis.hibernate.hw.model.mappingcollections.ItemComponent;
import com.alis.hibernate.hw.model.mappingcollections.ItemList;
import org.testng.annotations.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.UserTransaction;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MappingCollectionsTest extends TransactionManagerTest {

    @Test
    public void testSets() throws Exception
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MappingCollectionsPU");
        try
        {
            UserTransaction tx = TM.getUserTransaction();
            tx.begin();
            EntityManager em = emf.createEntityManager();

            Set<String> imgs = new HashSet<>();
            imgs.add("name1");
            imgs.add("name2");
            imgs.add("name3");

            Item item = new Item("Item", imgs);

            em.persist(item);
            tx.commit();
            em.clear();

            item = em.find(Item.class, 1);

            item.getImages().toArray();
        }
        finally
        {
            //TM.rollback();
            emf.close();
        }
    }

    @Test
    public void testBags() throws Exception
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MappingCollectionsPU");
        try
        {
            UserTransaction tx = TM.getUserTransaction();
            tx.begin();
            EntityManager em = emf.createEntityManager();

            //Collection<String> images = new ArrayList<>();

            List<String> images = new ArrayList<>();
            Collections.addAll(images, "file1", "file2", "file3");

            ItemBag item = new ItemBag("Item1", images);

            em.persist(item);
            tx.commit();
            em.clear();

            item = em.find(ItemBag.class, 1);

            item.getImages().toArray();
        }
        finally
        {
            //TM.rollback();
            emf.close();
        }
    }

    @Test
    public void testList() throws Exception
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MappingCollectionsPU");
        try
        {
            UserTransaction tx = TM.getUserTransaction();
            tx.begin();
            EntityManager em = emf.createEntityManager();

            //Collection<String> images = new ArrayList<>();



            List<String> images = new ArrayList<>();
            Collections.addAll(images, "file1", "file2", "file3");

            ItemList item = new ItemList("Item1", images);

            em.persist(item);
            tx.commit();
            em.clear();

            item = em.find(ItemList.class, 1);

            item.getImages().toArray();
        }
        finally
        {
            //TM.rollback();
            emf.close();
        }
    }

    @Test
    public void testSetOfComponents() throws Exception
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MappingCollectionsPU");
        try
        {
            UserTransaction tx = TM.getUserTransaction();
            tx.begin();
            EntityManager em = emf.createEntityManager();

            Set<Images> images = new HashSet<>();
            Collections.addAll(images,
                    new Images("Foo", "foo.jpg", 640, 480),
                    new Images("Bar", "bar.jpg", 800, 600),
                    new Images("Baz", "baz.jpg", 1024, 768));

            ItemComponent item = new ItemComponent("Item1", images);

            em.persist(item);
            tx.commit();
            em.clear();

            item = em.find(ItemComponent.class, 1);

            item.getImages().toArray();
        }
        finally
        {
            //TM.rollback();
            emf.close();
        }
    }


    }
