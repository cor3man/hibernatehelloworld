package com.alis.hibernate.hw.test;

import com.alis.hibernate.hw.environment.TransactionManagerTest;
import com.alis.hibernate.hw.model.mappinginherit.BankAccount;
import com.alis.hibernate.hw.model.mappinginherit.BillingDetails;
import com.alis.hibernate.hw.model.mappinginherit.CreditCard;
import org.testng.annotations.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import java.util.List;

public class MappingInheritTest extends TransactionManagerTest {


    @Test
    public void testManyToOne() throws Exception
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MappingInhertPUjoins");

        try
        {
            UserTransaction tx = TM.getUserTransaction();
            tx.begin();
            EntityManager em = emf.createEntityManager();

            com.alis.hibernate.hw.model.mappinginherit.joins.CreditCard creditCard = new com.alis.hibernate.hw.model.mappinginherit.joins.CreditCard("me", "July", "2020", "1234 1234");
            com.alis.hibernate.hw.model.mappinginherit.joins.User user = new com.alis.hibernate.hw.model.mappinginherit.joins.User("Alex");

            user.setDefBilling(creditCard);

            em.persist(creditCard);
            em.persist(user);
            tx.commit();
            em.clear();
            com.alis.hibernate.hw.model.mappinginherit.joins.User  userX = em.find(com.alis.hibernate.hw.model.mappinginherit.joins.User .class, 1001);

            com.alis.hibernate.hw.model.mappinginherit.joins.BillingDetails bd = userX.getDefBilling();

            com.alis.hibernate.hw.model.mappinginherit.joins.CreditCard cC = em.getReference(com.alis.hibernate.hw.model.mappinginherit.joins.CreditCard.class, bd.getId());

            cC.printDetales();

            //userX.getDefBilling().printDetales();

            //CreditCard cr = (CreditCard) em.find(BillingDetails.class, 11);
            //System.out.println((com.alis.hibernate.hw.model.mappinginherit.joins.CreditCard)billingDetails.get(0));
        }
        finally
        {
            //TM.rollback();
            emf.close();
        }
    }

    @Test
    public void tableWithJoins() throws Exception
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MappingInhertPUjoins");

        try
        {
            UserTransaction tx = TM.getUserTransaction();
            tx.begin();
            EntityManager em = emf.createEntityManager();

            com.alis.hibernate.hw.model.mappinginherit.joins.CreditCard creditCard = new com.alis.hibernate.hw.model.mappinginherit.joins.CreditCard("me", "July", "2020", "1234 1234");
            com.alis.hibernate.hw.model.mappinginherit.joins.BankAccount bankAccount = new com.alis.hibernate.hw.model.mappinginherit.joins.BankAccount("me", "myacc", "Belinvest", "HZ");

            em.persist(creditCard);
            em.persist(bankAccount);
            tx.commit();
            em.clear();
            List billingDetails = em.createQuery("select bd from BillingDetails bd").getResultList();

            //CreditCard cr = (CreditCard) em.find(BillingDetails.class, 11);
            System.out.println((com.alis.hibernate.hw.model.mappinginherit.joins.CreditCard)billingDetails.get(0));
        }
        finally
        {
            //TM.rollback();
            emf.close();
        }
    }


    @Test
    public void tablePerClassTest() throws Exception
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MappingInhertPU");

        try
        {
            UserTransaction tx = TM.getUserTransaction();
            tx.begin();
            EntityManager em = emf.createEntityManager();

            CreditCard creditCard = new CreditCard("me", "July", "2020", "1234 1234");
            BankAccount bankAccount = new BankAccount("me", "myacc", "Belinvest", "HZ");

            em.persist(creditCard);
            em.persist(bankAccount);
            tx.commit();

            List billingDetails = em.createQuery("select bd from BillingDetails bd").getResultList();

            //CreditCard cr = (CreditCard) em.find(BillingDetails.class, 11);
            System.out.println((CreditCard)billingDetails.get(0));
        }
        finally
        {
            //TM.rollback();
            emf.close();
        }

    }

    @Test
    public void singleTableTest() throws Exception
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MappingInhertPUsingle");

        try
        {
            UserTransaction tx = TM.getUserTransaction();
            tx.begin();
            EntityManager em = emf.createEntityManager();

            com.alis.hibernate.hw.model.mappinginherit.singletable.CreditCard creditCard = new com.alis.hibernate.hw.model.mappinginherit.singletable.CreditCard("me", "July", "2020", "1234 1234");
            com.alis.hibernate.hw.model.mappinginherit.singletable.BankAccount bankAccount = new com.alis.hibernate.hw.model.mappinginherit.singletable.BankAccount("me", "myacc", "Belinvest", "HZ");

            em.persist(creditCard);
            em.persist(bankAccount);
            tx.commit();

            List billingDetails = em.createQuery("select bd from BillingDetails bd").getResultList();

            //CreditCard cr = (CreditCard) em.find(BillingDetails.class, 11);
            System.out.println(billingDetails.get(1));
        }
        finally
        {
            //TM.rollback();
            emf.close();
        }

    }

}
