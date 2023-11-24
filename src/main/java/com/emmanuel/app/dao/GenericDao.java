package com.emmanuel.app.dao;

import com.emmanuel.database.MysqlDatabase;

import java.util.List;

/**
 * Created by emmanuel on 11/21/23
 *
 * @author: emmanuel
 * @date: 11/21/23
 * @project: IntelliJ IDEA
 */
public class GenericDao<T> implements GenericDaoI<T> {

    @SuppressWarnings({"unchecked"})
    @Override
    public List<T> list(Class<?> entity) {
        return (List<T>) MysqlDatabase.select(entity);

    }

    @Override
    public void addOrUpdate(T entity) {
        MysqlDatabase.saveOrUpdate(entity);

    }

    @Override
    public void delete(T entity) {

    }
}