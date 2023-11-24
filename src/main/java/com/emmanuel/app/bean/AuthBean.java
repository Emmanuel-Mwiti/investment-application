package com.emmanuel.app.bean;

import com.emmanuel.app.model.entity.User;
import com.emmanuel.database.Database;
import com.emmanuel.database.MysqlDatabase;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by emmanuel on 11/8/23
 *
 * @author: emmanuel
 * @date: 11/8/23
 * @project: IntelliJ IDEA
 */
public class AuthBean implements AuthBeanI, Serializable {
    Database database = Database.getDbInstance();

    @Override
    public User athenticate(User loginUser) throws SQLException {
        PreparedStatement sqlStmt = MysqlDatabase.getInstance().getConnection()
                .prepareStatement("select user_name from users where user_name=? and user_password=? limit 1");
        sqlStmt.setString(1, loginUser.getName());
        sqlStmt.setString(2, loginUser.getPassword());

        ResultSet result = sqlStmt.executeQuery();

        User user = new User();

        while (result.next()) {
//            user.setId(result.getLong("id"));
            user.setName(result.getString("user_name"));
        }

        return user;
    }
}
