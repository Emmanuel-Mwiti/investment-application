package com.emmanuel.database;

/**
 * Created by emmanuel on 11/21/23
 *
 * @author: emmanuel
 * @date: 11/21/23
 * @project: IntelliJ IDEA
 */

import com.emmanuel.app.model.entity.User;
import com.emmanuel.database.helper.DbTable;
import com.emmanuel.database.helper.DbTableColumn;
import com.emmanuel.database.helper.DbTableId;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MysqlDatabase implements Serializable {

    private static MysqlDatabase database;

    private Connection connection;

    private MysqlDatabase() throws SQLException, NamingException {
        Context ctx = new InitialContext();
        DataSource dataSource = (DataSource) ctx.lookup("java:/investment");
        connection = dataSource.getConnection();
    }

    public static MysqlDatabase getInstance(){
        if (database == null) {
            try {
                database = new MysqlDatabase();

            } catch (SQLException | NamingException e) {
                throw new RuntimeException(e);
            }
        }

        return database;

    }

    public static void updateSchema(){
        System.out.println("*************** updating schema database *************");

        try {
            Connection connection = MysqlDatabase.getInstance().getConnection();

            List<Class<?>> entities = new ArrayList<>();
            entities.add(User.class);

            for (Class<?> clazz : entities) {
                if (!clazz.isAnnotationPresent(DbTable.class))
                    continue;

                DbTable dbTable = clazz.getAnnotation(DbTable.class);

                StringBuilder sqlBuilder = new StringBuilder();

                sqlBuilder.append("create table if not exists ").append(dbTable.tableName()).append("(");

                List<Field> fields = new ArrayList<>(Arrays.asList(clazz.getSuperclass().getDeclaredFields()));
                fields.addAll(Arrays.asList(clazz.getDeclaredFields()));

                for (Field field : fields) {
                    if (!field.isAnnotationPresent(DbTableColumn.class))
                        continue;

                    DbTableColumn dbTableColumn = field.getAnnotation(DbTableColumn.class);

                    sqlBuilder.append(dbTableColumn.columnName()).append(" ")
                            .append(dbTableColumn.definition())
                            .append(field.isAnnotationPresent(DbTableId.class)?" NOT NULL AUTO_INCREMENT PRIMARY KEY" : "")
                            .append(",");
                }

                sqlBuilder.append(")");

                String tableCreationSql = sqlBuilder.toString().replace(",)", ")");
                System.out.println("Creating table: " + tableCreationSql);
                connection.prepareStatement(tableCreationSql).executeUpdate();

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }


    }

    public static void saveOrUpdate(Object entity) {
        try {
            Class<?> clazz = entity.getClass();
            if (!clazz.isAnnotationPresent(DbTable.class))
                return;

            DbTable dbTable = clazz.getAnnotation(DbTable.class);

            List<Field> fields = new ArrayList<>(Arrays.asList(clazz.getSuperclass().getDeclaredFields()));
            fields.addAll(Arrays.asList(clazz.getDeclaredFields()));

            StringBuilder columnBuilder = new StringBuilder();
            StringBuilder paramPlaceHolderBuilder = new StringBuilder();
            List<Object> parameters = new ArrayList<>();

            for (Field field : fields) {
                if (!field.isAnnotationPresent(DbTableColumn.class) || field.isAnnotationPresent(DbTableId.class))
                    continue;

                field.setAccessible(true);
                if (field.get(entity) == null)
                    continue;

                DbTableColumn dbTableColumn = field.getAnnotation(DbTableColumn.class);

                columnBuilder.append(dbTableColumn.columnName()).append(",");
                paramPlaceHolderBuilder.append("?").append(",");
                parameters.add(field.get(entity));
            }

            // Remove the last comma from columnBuilder and paramPlaceHolderBuilder
            if (columnBuilder.length() > 0) {
                columnBuilder.deleteCharAt(columnBuilder.length() - 1);
                paramPlaceHolderBuilder.deleteCharAt(paramPlaceHolderBuilder.length() - 1);
            }

            String queryBuilder = "insert into " +
                    dbTable.tableName() +
                    "(" +
                    columnBuilder +
                    ")" +
                    " values(" +
                    paramPlaceHolderBuilder +
                    ")";

            String query = queryBuilder.replace(",)", ")");
            System.out.println("Query: " + query);

            PreparedStatement sqlStmt = MysqlDatabase.getInstance().getConnection()
                    .prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            int paramIdx = 1;
            for (Object param : parameters) {
                if (param.getClass().isAssignableFrom(BigDecimal.class))
                    sqlStmt.setBigDecimal(paramIdx++, (BigDecimal) param);
                else if (param.getClass().isAssignableFrom(Long.class))
                    sqlStmt.setLong(paramIdx++, (long) param);
                else
                    sqlStmt.setString(paramIdx++, (String) param);
            }

            int affectedRows = sqlStmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }

            try (ResultSet generatedKeys = sqlStmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    Long generatedId = generatedKeys.getLong(1);
                    // Set the generated ID back to the entity
                    Field idField = clazz.getDeclaredField("id");
                    idField.setAccessible(true);
                    idField.set(entity, generatedId);
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static <T> List<T> select(T filter) {

        return new ArrayList<>();

    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}

