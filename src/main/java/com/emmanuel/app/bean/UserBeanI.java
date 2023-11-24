package com.emmanuel.app.bean;

import com.emmanuel.app.model.entity.User;

import java.sql.SQLException;

public interface UserBeanI {
    boolean register(User user) throws SQLException;
}
