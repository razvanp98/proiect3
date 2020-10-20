package com.razvan.papurica.proiect3.dao;

import com.razvan.papurica.proiect3.entity.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public interface DaoInterface {

    default Session getSession() {
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Medic.class)
                .addAnnotatedClass(Pacient.class)
                .addAnnotatedClass(Medicament.class)
                .buildSessionFactory();

        return sessionFactory.getCurrentSession();
    }

    // TO OVERRIDE BY DAO IMPLEMENTATIONS
    // DAO = Data Access Object
    // Implementations of DAO work as interface between Services and the Database
    // Methods with 'Get' at the end - return Hibernate instance to populate/update database
    // Methods with 'Do' at the end - execute the operation back-scene in Hibernate

    List read();
    Object createGet();
    Object updateGet(int id);
    void createDo(Object o);
    void updateDo(Object o);
    void delete(int id);
    void refresh(); // Used to get a new session every time an operation is done
}
