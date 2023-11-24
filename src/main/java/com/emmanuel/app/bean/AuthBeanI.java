package com.emmanuel.app.bean;

import com.emmanuel.app.model.entity.User;

import java.sql.SQLException;

public interface AuthBeanI {
    User athenticate(User user) throws SQLException;
}