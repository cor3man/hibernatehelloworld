package com.alis.hibernate.hw.test;

import com.alis.hibernate.hw.model.Message;
import com.alis.hibernate.hw.model.User;
import com.alis.hibernate.hw.shared.MapAsSer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataBuilder;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.hibernate.jpa.internal.EntityManagerFactoryImpl;
import org.hibernate.resource.transaction.backend.jta.internal.JtaTransactionCoordinatorBuilderImpl;
import org.hibernate.service.ServiceRegistry;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class MainTast {

    protected SessionFactory createSessionFactory() {
        StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
        serviceRegistryBuilder
                .applySetting("hibernate.connection.driver_class", "com.mysql.jdbc.Driver")
                .applySetting("hibernate.connection.url", "jdbc:mysql://localhost:3306/hwdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC")
                .applySetting("hibernate.connection.username", "root")
                .applySetting("hibernate.connection.password", "root")
                .applySetting("hibernate.use_sql_comments", "true")
                .applySetting("hibernate.hbm2ddl.auto", "create");


/*        serviceRegistryBuilder.applySetting(
                Environment.TRANSACTION_COORDINATOR_STRATEGY,
                JtaTransactionCoordinatorBuilderImpl.class
        );*/

        ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();

        MetadataSources metadataSources = new MetadataSources(serviceRegistry);

        metadataSources.addPackage("com.alis.hibernate.hw.model");
        metadataSources.addAnnotatedClass(com.alis.hibernate.hw.model.Message.class);
        metadataSources.addAnnotatedClass(com.alis.hibernate.hw.model.User.class);

        MetadataBuilder metadataBuilder = metadataSources.getMetadataBuilder();

        Metadata metadata = metadataBuilder.build();

        SessionFactory sessionFactory = metadata.buildSessionFactory();

        return sessionFactory;

    }


    public static void persistHibernate()
    {
        MainTast test = new MainTast();
        SessionFactory sessionFactory = test.createSessionFactory();

        Session session =
                sessionFactory.openSession();
        session.getTransaction().begin();


        Message message = new Message("Hello fucking world");
        Message message1 = new Message("Hello world");

        List<User> users = new ArrayList<User>();
        for(int i=0; i<10; i++)
        {
            users.add(new User("User N" + i));
            session.persist(users.get(i));
        }

        session.persist(message);
        session.persist(message1);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }

    public static void persistJPA()
    {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("HelloWorldPU");
        EntityManager em = emf.createEntityManager();

        try
        {
            em.getTransaction().begin();

            byte[] bytes = new byte[5];

            for (int i=0, j = 1; i<5; i++, j+=2)
            {
                bytes[i] = (byte)j;
            }

            User user = new User("bytes", bytes);
            em.persist(user);

/*            List<User> users = new ArrayList<User>();
            for (int i = 0; i < 10; i++)
            {
                users.add(new User("User N" + i));
                em.persist(users.get(i));
            }*/
            em.getTransaction().commit();
        }
        finally
        {

            emf.close();
        }
    }

    public static void main(String[] args)
    {

        persistJPA();


    }

}
