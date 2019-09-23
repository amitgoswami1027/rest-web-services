package com.amitgoswami.rest.webservices.JPA;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class JPAUserDAOService {
    private static List<JPAUser> users = new ArrayList();
    private static int usersCount = 3;

    static {
        users.add(new JPAUser(1, "Amit", new Date()));
        users.add(new JPAUser(2, "Shally", new Date()));
        users.add(new JPAUser(3, "Aryan", new Date()));
    }

    public List<JPAUser> findall() {
        return users;
    }

    public JPAUser save(JPAUser user) {
        if (user.getId() == null) {
            user.setId(++usersCount);
        }
        users.add(user);
        return user;
    }

    public JPAUser findOne(int id) {
        for (JPAUser user : users) {
            if (user.getId() == id)
                return user;
        }

        return null;
    }

    public JPAUser deleteById(int id)
    {
        Iterator<JPAUser> iterator = users.iterator();

        while (iterator.hasNext())
        {
            JPAUser user = iterator.next();
            if (user.getId() == id)
            {
                iterator.remove();
                return user;
            }
        }
        return null;
    }
}
