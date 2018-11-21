package com.alis.hibernate.hw.test;

import com.alis.hibernate.hw.environment.TransactionManagerTest;
import com.alis.hibernate.hw.model.entityassociations.Bid;
import com.alis.hibernate.hw.model.entityassociations.Item;
import com.alis.hibernate.hw.model.entityassociations.onetoone.Address;
import com.alis.hibernate.hw.model.entityassociations.onetoone.AddressBi;
import com.alis.hibernate.hw.model.entityassociations.onetoone.User;
import com.alis.hibernate.hw.model.entityassociations.onetoone.UserBi;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.testng.annotations.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;


public class EntityAssociations extends TransactionManagerTest {

    private EntityManagerFactory emf;
    private UserTransaction tx;
    private EntityManager em;

    private void prepareTestEnv(String pu) throws SystemException, NotSupportedException
    {
        emf = Persistence.createEntityManagerFactory(pu);
        tx = TM.getUserTransaction();
        tx.begin();
        em = emf.createEntityManager();
    }

    @Test
    public void testOneToOne() throws Exception
    {
        try
        {
            prepareTestEnv("OneToOnePU");

            //Sharing a primary key

            System.out.println("---------------------Sharing a primary key-----------------------");
            Address address = new Address("MyStreet");
            em.persist(address);
            User user = new User(address.getId(), "MyName");
            user.setAddress(address);
            em.persist(user);

            System.out.println("---------------------The foreign primary key generator-----------------------");
            UserBi userBi = new UserBi("UserBi");
            AddressBi addressBi = new AddressBi(userBi, "street123");
            userBi.setAddress(addressBi);
            em.persist(userBi);

            tx.commit();

        }
        finally
        {
            //TM.rollback();
            emf.close();
        }
    }

    @Test//before running this test remove/comment OneToMany annotation from Item
    public void testManyToOneUnidirectional() throws Exception
    {
        try
        {

            prepareTestEnv("ManyToOnePU");

            Item item = new Item("MyItem");
            Bid bid = new Bid(item, 777);
            //bid.setItem(item);

            em.persist(item);
            em.persist(bid);

            tx.commit();

        }
        finally
        {
            //TM.rollback();
            emf.close();
        }
    }

    @Test//before running this test add/uncomment OneToMany annotation to Item
    public void testManyToOneBidirectional() throws Exception
    {
        try
        {

            prepareTestEnv("ManyToOnePU");

            Item item = new Item("MyItem");
            em.persist(item);

            Bid bid = new Bid(item, 777);
            item.getBids().add(bid);
            //em.persist(bid); // Added Cascade

            Bid secondBid = new Bid(item, 98);
            item.getBids().add(secondBid);
            //em.persist(secondBid); // Added Cascade

            tx.commit();

            em.clear();
            tx.begin();

            item = em.find(Item.class, 1);
            System.out.println(item);

            Bid firstBid = item.getBids().iterator().next();
            item.getBids().remove(firstBid);

            //em.remove(item);

            tx.commit();
        }
        finally
        {
            //TM.rollback();
            emf.close();
        }
    }

}
