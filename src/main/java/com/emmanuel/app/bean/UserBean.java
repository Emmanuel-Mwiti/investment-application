package com.emmanuel.app.bean;

import com.emmanuel.app.model.entity.User;

import java.io.Serializable;
import java.sql.SQLException;

/**
 * Created by emmanuel on 11/6/23
 *
 * @author: emmanuel
 * @date: 11/6/23
 * @project: IntelliJ IDEA
 */
public class UserBean extends GenericBean<User> implements UserBeanI{
    @Override
    public boolean register(User user) throws SQLException {
        // i will do
        //1. check if username already exist
        //2. hash password
        //3. initiate event to send email ...Observer design pattern

        getDao().addOrUpdate(user);

        return false;
    }
}
