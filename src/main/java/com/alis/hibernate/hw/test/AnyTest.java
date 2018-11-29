package com.alis.hibernate.hw.test;

import com.alis.hibernate.hw.environment.TransactionManagerTest;
import com.alis.hibernate.hw.model.entityassociations.onetomany.testclases.Address;
import com.alis.hibernate.hw.model.entityassociations.onetomany.testclases.Shipment;
import com.alis.hibernate.hw.model.entityassociations.onetomany.testclases.User;
import org.testng.annotations.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;


public class AnyTest extends TransactionManagerTest {

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
    public void test() throws Exception
    {
        try
        {
            prepareTestEnv("TestPU");

            Shipment shipment = new Shipment("shipment");
            Shipment shipment1 = new Shipment("shipment1");
            Address address = new Address("Kirova");
            address.getDeliveries().add(shipment);
            address.getDeliveries().add(shipment1);
            User user = new User("someName", address);

            em.persist(user);
            //em.persist(shipment);
            tx.commit();



        }
        finally
        {
            //TM.rollback();
            emf.close();
        }
    }

}
