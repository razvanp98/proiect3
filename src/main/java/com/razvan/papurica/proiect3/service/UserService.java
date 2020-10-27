package com.razvan.papurica.proiect3.service;

import com.razvan.papurica.proiect3.dao.UserDao;
import com.razvan.papurica.proiect3.entity.User;
import com.razvan.papurica.proiect3.security.SecurityAuthorizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("userService")
public class UserService {

    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;

    public void addUser(User user) {
        userDao.add(user);
    }

    public boolean checkLogin(String username, String password) {
        List<User> user = userDao.getUser(username, password);

        if(user.isEmpty()) {
            return false;
        } else {
            SecurityAuthorizer.setUser(user.get(0));
            return true;
        }

    }
}
