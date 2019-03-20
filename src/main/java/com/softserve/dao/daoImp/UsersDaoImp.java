package com.softserve.dao.daoImp;

import com.softserve.dao.UsersDao;
import com.softserve.models.User;
import com.softserve.models.UserRole;
import com.softserve.utilities.DataBaseUtilities;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class UsersDaoImp implements UsersDao {

    static User resultSetRowToUser(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getLong("id"));
        user.setNickname(resultSet.getString("nickname"));
        user.setEmail(resultSet.getString("email"));
        if (resultSet.getString("role").equals("user")) {
            user.setRole(UserRole.USER);
        } else {
            user.setRole(UserRole.ADMIN);
        }
        user.setPassword(resultSet.getString("password"));
        return user;
    }

    boolean exists(User user) throws SQLException {
        Connection connection = DataBaseUtilities.getConnection();
        PreparedStatement select = connection
                .prepareStatement("SELECT * FROM users WHERE "
                        + "id=?;");
        select.setLong(1, user.getId());
        ResultSet resultSet = select.executeQuery();
        boolean exists = resultSet.next();
        select.close();
        return exists;
    }

    private long getIdByEmail(String email) throws SQLException {
        Connection connection = DataBaseUtilities.getConnection();
        PreparedStatement select = connection
                .prepareStatement("SELECT id FROM users WHERE "
                + "email=?;");
        select.setString(1,email);
        ResultSet resultSet = select.executeQuery();
        resultSet.next();
        return resultSet.getLong("id");
    }

    @Override
    public User getById(long id) {
        Connection connection = DataBaseUtilities.getConnection();
        PreparedStatement selectUser = null;
        ResultSet resultSet = null;
        User user = null;
        String selectUserString = "SELECT * FROM users "
                + "WHERE id=?;";
        try {
            selectUser = connection.prepareStatement(selectUserString);
            selectUser.setLong(1, id);
            resultSet = selectUser.executeQuery();
            if (resultSet.next()) {
                user = resultSetRowToUser(resultSet);
            } else {
                throw new IllegalArgumentException();
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            System.err.println(e.getErrorCode());
        }
        return user;
    }

    @Override
    public User getByEmail(String email) {
        Connection connection = DataBaseUtilities.getConnection();
        PreparedStatement selectUser = null;
        ResultSet resultSet = null;
        User user = null;
        String selectUserString = "SELECT * FROM users "
                + "WHERE email=?;";
        try {
            selectUser = connection.prepareStatement(selectUserString);
            selectUser.setString(1, email);
            resultSet = selectUser.executeQuery();
            if (resultSet.next()) {
                user = resultSetRowToUser(resultSet);
            } else {
                throw new IllegalArgumentException();
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            System.err.println(e.getErrorCode());
        }
        return user;
    }

    @Override
    public Set<User> getAll() {
        Set<User> users = new HashSet<>();
        Connection conn = DataBaseUtilities.getConnection();
        Statement select = null;
        ResultSet resultSet = null;
        User user = null;
        String selectString = "SELECT * FROM users;";
        try {
            select = conn.createStatement();
            resultSet = select.executeQuery(selectString);
            while (resultSet.next()) {
                user = resultSetRowToUser(resultSet);
                users.add(user);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            System.err.println(e.getErrorCode());
        }
        return users;
    }

    @Override
    public boolean add(User user) {
        Connection connection = DataBaseUtilities.getConnection();
        PreparedStatement insert = null;
        String insertString = "INSERT INTO users(nickname,email,role,password) "
                + "VALUES(?,?,?,?);";
        try {
            if (exists(user)) {
                throw new IllegalArgumentException();
            }
            insert = connection.prepareStatement(insertString);
            insert.setString(1, user.getNickname());
            insert.setString(2, user.getEmail());
            if (user.getRole() == UserRole.USER) {
                insert.setString(3, "user");
            } else {
                insert.setString(3, "admin");
            }
            insert.setString(4, user.getPassword());
            insert.execute();
            user.setId(getIdByEmail(user.getEmail()));
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            System.err.println(e.getErrorCode());
            return false;
        }
    }

    @Override
    public boolean update(User user) {
        Connection connection = DataBaseUtilities.getConnection();
        PreparedStatement update = null;
        String updateString = "UPDATE users "
                + "SET nickname=?, "
                + "email=?, role=?,password=? "
                + "WHERE id=?";
        try {
            if (!exists(user)) {
                throw new IllegalArgumentException();
            }
            update = connection.prepareStatement(updateString);
            update.setString(1, user.getNickname());
            update.setString(2, user.getEmail());
            if (user.getRole() == UserRole.USER) {
                update.setString(3, "user");
            } else {
                update.setString(3, "admin");
            }
            update.setString(4, user.getPassword());
            update.setLong(5, user.getId());
            update.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            System.err.println(e.getErrorCode());
            return false;
        }
    }

    @Override
    public void deleteById(long userId) {
        Connection connection = DataBaseUtilities.getConnection();
        PreparedStatement delete = null;
        String deleteString = "DELETE FROM users WHERE id=?;";
        try {
            delete = connection.prepareStatement(deleteString);
            delete.setLong(1, userId);
            delete.execute();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            System.err.println(e.getErrorCode());
        }
    }

    @Override
    public int calculatePlayLaterCount(long userId) {
        Connection connection = DataBaseUtilities.getConnection();
        PreparedStatement select = null;
        ResultSet resultSet = null;
        int count = 0;
        String selectString = "SELECT COUNT(mark) AS plCount FROM "
                + "play_later WHERE userId=?;";
        try {
            select = connection.prepareStatement(selectString);
            select.setLong(1, userId);
            resultSet = select.executeQuery();
            if (resultSet.next()) {
                count = resultSet.getInt("plCount");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            System.err.println(e.getErrorCode());
        }
        return count;
    }

    @Override
    public int calculateMarksCount(long userId) {
        Connection connection = DataBaseUtilities.getConnection();
        PreparedStatement select = null;
        ResultSet resultSet = null;
        int count = 0;
        String selectString = "SELECT COUNT(mark) AS marksCount FROM "
                + "marks WHERE userId=?;";
        try {
            select = connection.prepareStatement(selectString);
            select.setLong(1, userId);
            resultSet = select.executeQuery();
            if (resultSet.next()) {
                count = resultSet.getInt("marksCount");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            System.err.println(e.getErrorCode());
        }
        return count;
    }

    @Override
    public float calculateAvgMark(long userId) {
        Connection connection = DataBaseUtilities.getConnection();
        PreparedStatement select = null;
        ResultSet resultSet = null;
        float avgMark = 0;
        String selectString = "SELECT AVG(mark) AS avgMark FROM "
                + "marks WHERE userId=?;";
        try {
            select = connection.prepareStatement(selectString);
            select.setLong(1,userId);
            resultSet = select.executeQuery();
            if (resultSet.next()) {
                avgMark = resultSet.getFloat("avgMark");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            System.err.println(e.getErrorCode());
        }
        return avgMark;
    }
}

