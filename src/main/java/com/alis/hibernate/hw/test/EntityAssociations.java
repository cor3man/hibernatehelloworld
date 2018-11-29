package com.alis.hibernate.hw.test;

import com.alis.hibernate.hw.environment.TransactionManagerTest;
import com.alis.hibernate.hw.model.entityassociations.onetomany.Bid;
import com.alis.hibernate.hw.model.entityassociations.onetomany.BidBag;
import com.alis.hibernate.hw.model.entityassociations.onetomany.BidListSimple;
import com.alis.hibernate.hw.model.entityassociations.onetomany.Item;
import com.alis.hibernate.hw.model.entityassociations.onetomany.ItemBag;
import com.alis.hibernate.hw.model.entityassociations.onetomany.ItemList;
import com.alis.hibernate.hw.model.entityassociations.onetoone.AddressBi;
import com.alis.hibernate.hw.model.entityassociations.onetoone.UserBi;
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
    public void testOneToManyJoinTable() throws Exception
    {
        try
        {
            prepareTestEnv("ManyToOnePU");

            com.alis.hibernate.hw.model.entityassociations.onetomany.jointable.Item item = new com.alis.hibernate.hw.model.entityassociations.onetomany.jointable.Item();
            item.setName("Item");
            em.persist(item);


            com.alis.hibernate.hw.model.entityassociations.onetomany.jointable.User user = new com.alis.hibernate.hw.model.entityassociations.onetomany.jointable.User();
            user.setName("User1");

            em.persist(user);



            //item.setBuyer(user);


            tx.commit();
            em.clear();
            tx.begin();


            item = (com.alis.hibernate.hw.model.entityassociations.onetomany.jointable.Item) em.find(com.alis.hibernate.hw.model.entityassociations.onetomany.jointable.Item.class, 1);

            System.out.println("********************************");
            System.out.println(item.getBuyer());

            /*
            user = (com.alis.hibernate.hw.model.entityassociations.onetomany.jointable.User)em.find(com.alis.hibernate.hw.model.entityassociations.onetomany.jointable.User.class, 2);

            System.out.println(user.getBoughtItems());
*/

            tx.commit();

        }
        finally
        {
            //TM.rollback();
            emf.close();
        }
    }


    @Test
    public void testOneToManyListUni() throws Exception
    {
        try
        {
            prepareTestEnv("ManyToOnePU");


            ItemList itemList = new ItemList("ItemList");
            em.persist(itemList);
/*
            tx.commit();
            em.clear();
            tx.begin();

            itemList = (ItemList)em.find(ItemList.class, 1);
*/

            BidListSimple bidListSimple = new BidListSimple(234);
            itemList.getBids().add(bidListSimple);

            em.persist(bidListSimple);
            tx.commit();

        }
        finally
        {
            //TM.rollback();
            emf.close();
        }
    }



    @Test
    public void testOneToManyBag() throws Exception
    {
        try
        {
            prepareTestEnv("ManyToOnePU");

            ItemBag item = new ItemBag("MyItem");
            em.persist(item);

            BidBag bid = new BidBag(item, 777);

            item.getBids().add(bid);
            item.getBids().add(bid);
            em.persist(bid);

            tx.commit();
            em.clear();
            tx.begin();

            ItemBag itemBag = (ItemBag)em.find(ItemBag.class, 1);

            BidBag bid1 = new BidBag(item, 123);
            itemBag.getBids().add(bid1);
            em.persist(bid1);
            tx.commit();
        }
        finally
        {
            //TM.rollback();
            emf.close();
        }
    }

    @Test
    public void testOneToOne() throws Exception
    {
        try
        {
            prepareTestEnv("OneToOnePU");

            //Sharing a primary key

/*
            System.out.println("---------------------Sharing a primary key-----------------------");
            Address address = new Address("MyStreet");
            em.persist(address);
            User user = new User(address.getId(), "MyName");
            user.setAddress(address);
            em.persist(user);

            tx.commit();

            em.clear();
            tx.begin();

            User user1 = em.find(User.class, 1);

            System.out.println(user1);
            System.out.println(user1.getAddress());
*/

            System.out.println("---------------------The foreign primary key generator-----------------------");
            UserBi userBi = new UserBi("UserBi");
            AddressBi addressBi = new AddressBi(userBi, "street123");
            userBi.setAddress(addressBi);
            em.persist(userBi);
            tx.commit();
            em.clear();
            tx.begin();

            //UserBi userBi1 = em.find(UserBi.class, 1);
            AddressBi addressBi1 = em.find(AddressBi.class, 1);

            System.out.println(addressBi1.getUser());

            tx.commit();

        }
        finally
        {
            //TM.rollback();
            emf.close();
        }
    }



    @Test//TODO: before running this test read comment on Item
    public void testManyToOneUnidirectional() throws Exception
    {
        try
        {
            prepareTestEnv("ManyToOnePU");
            Item item = new Item("MyItem");
            em.persist(item);
            Bid bid = new Bid(item, 777);
            bid.setItem(item);

            em.persist(bid);
            tx.commit();
        }
        finally
        {
            //TM.rollback();
            emf.close();
        }
    }

    @Test
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
            //System.out.println(item);

            Bid bid1 = new Bid(item, 777);
            item.getBids().add(bid1);
            em.persist(bid1);

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
