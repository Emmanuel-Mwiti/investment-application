package com.emmanuel.app.bean.impl;

import com.emmanuel.app.bean.UserBeanI;
import com.emmanuel.app.model.entity.User;
import com.emmanuel.database.Database;

import java.io.Serializable;

/**
 * Created by emmanuel on 11/6/23
 *
 * @author: emmanuel
 * @date: 11/6/23
 * @project: IntelliJ IDEA
 */
public class UserBeanImpl implements UserBeanI, Serializable {
    @Override
    public User addUser(User user) {
        Database database = Database.getDbInstance();
        database.getUsers().add(user);
        return user;
    }
}
