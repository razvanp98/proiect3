package com.razvan.papurica.proiect3.dao;

import com.razvan.papurica.proiect3.entity.User;
import com.razvan.papurica.proiect3.security.SecurityAuthorizer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("userDao")
public class UserDao {

    private Session session;

    private Session getSession() {
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(User.class)
                .buildSessionFactory();

        return sessionFactory.getCurrentSession();
    }

    private void refresh() {
        this.session = getSession();
    }

    // Check if user exist in database

    public List<User> getUser(String username, String password) {
        refresh();
        session.beginTransaction();
        Query<User> userQuery = session.createQuery("from User u where u.username=:username and u.password=:password");
        userQuery.setParameter("username", username);
        userQuery.setParameter("password", password);

        List<User> userList = userQuery.getResultList();

        return userList;
    }

    // Used for registering new user

    public void add(User user) {
        refresh();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }
}
