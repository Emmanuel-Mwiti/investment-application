package com.emmanuel.app.bean.impl;

import com.emmanuel.app.bean.AuthBeanI;
import com.emmanuel.app.model.entity.User;
import com.emmanuel.database.Database;

import java.io.Serializable;

/**
 * Created by emmanuel on 11/8/23
 *
 * @author: emmanuel
 * @date: 11/8/23
 * @project: IntelliJ IDEA
 */
public class AuthBeanImp implements AuthBeanI, Serializable {
    Database database = Database.getDbInstance();

    @Override
    public User athenticate(User loginUser) {
        User userDetails = null;

        for (User user : database.getUsers()) {
            if (loginUser.getName().equals(user.getName())
                    && loginUser.getPassword().equals(user.getPassword())) {
                userDetails = user;

                break;

            }
        }
        return userDetails;
    }
}
