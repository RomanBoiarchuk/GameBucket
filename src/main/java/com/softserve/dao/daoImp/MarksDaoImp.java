package com.softserve.dao.daoImp;

import com.softserve.dao.MarksDao;
import com.softserve.models.Game;
import com.softserve.models.Mark;
import com.softserve.utilities.DataBaseUtilities;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class MarksDaoImp implements MarksDao {
    static Mark resultSetRowToMark(ResultSet resultSet)
            throws SQLException {
        Mark mark = new Mark();
        mark.setUserId(resultSet.getLong("userId"));
        mark.setGameId(resultSet.getLong("gameId"));
        mark.setMark(resultSet.getInt("mark"));
        return mark;
    }

    static boolean exists(Mark mark) throws SQLException {
        Connection connection = DataBaseUtilities.getConnection();
        PreparedStatement select = connection
                .prepareStatement("SELECT * FROM marks WHERE "
                        + "userId=? AND gameId=?;");
        select.setLong(1, mark.getUserId());
        select.setLong(2, mark.getGameId());
        ResultSet resultSet = select.executeQuery();
        boolean exists = resultSet.next();
        select.close();
        return exists;
    }

    @Override
    public Mark getById(long userId, long gameId) {
        Mark mark = null;
        Connection connection = DataBaseUtilities.getConnection();
        PreparedStatement select = null;
        ResultSet resultSet = null;
        String selectString = "SELECT * FROM Marks "
                + "WHERE userId=? AND gameId=?;";
        try {
            select = connection.prepareStatement(selectString);
            select.setLong(1, userId);
            select.setLong(2, gameId);
            resultSet = select.executeQuery();
            if (resultSet.next()) {
                mark = resultSetRowToMark(resultSet);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            System.err.println(e.getErrorCode());
        }
        return mark;
    }

    @Override
    public boolean exists(long userId, long gameId) {
        return getById(userId, gameId) != null;
    }

    @Override
    public Set<Mark> getAll() {
        Set<Mark> marks = new HashSet<>();
        Mark mark = null;
        Connection connection = DataBaseUtilities.getConnection();
        Statement select = null;
        ResultSet resultSet = null;
        String selectString = "SELECT * FROM Marks;";
        try {
            select = connection.createStatement();
            resultSet = select.executeQuery(selectString);
            while (resultSet.next()) {
                mark = resultSetRowToMark(resultSet);
                marks.add(mark);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            System.err.println(e.getErrorCode());
        }
        return marks;
    }

    @Override
    public Set<Mark> getByuserId(long userId) {
        Set<Mark> marks = new HashSet<>();
        Mark mark = null;
        Connection connection = DataBaseUtilities.getConnection();
        PreparedStatement select = null;
        ResultSet resultSet = null;
        String selectString = "SELECT * FROM Marks "
                + "WHERE userId=?;";
        try {
            select = connection.prepareStatement(selectString);
            select.setLong(1, userId);
            resultSet = select.executeQuery();
            while (resultSet.next()) {
                mark = resultSetRowToMark(resultSet);
                marks.add(mark);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            System.err.println(e.getErrorCode());
        }
        return marks;
    }

    @Override
    public boolean add(Mark mark) {
        Connection connection = DataBaseUtilities.getConnection();
        PreparedStatement insert = null;
        String insertString = "INSERT INTO marks "
                + "VALUES(?,?,?);";
        try {
            insert = connection.prepareStatement(insertString);
            insert.setLong(1, mark.getUserId());
            insert.setLong(2, mark.getGameId());
            insert.setInt(3, mark.getMark());
            insert.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            System.err.println(e.getErrorCode());
            return false;
        }
    }

    @Override
    public boolean update(Mark mark) {
        Connection connection = DataBaseUtilities.getConnection();
        PreparedStatement update = null;
        String updateString = "UPDATE marks "
                + "SET mark=? "
                + "WHERE userId=? AND gameId=?;";
        try {
            if (!exists(mark)) {
                throw new IllegalArgumentException();
            }
            update = connection.prepareStatement(updateString);
            update.setInt(1, mark.getMark());
            update.setLong(2, mark.getUserId());
            update.setLong(3, mark.getGameId());
            update.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            System.err.println(e.getErrorCode());
            return false;
        }
    }

    @Override
    public void delete(Mark mark) {
        Connection connection = DataBaseUtilities.getConnection();
        PreparedStatement delete = null;
        String deleteString = "DELETE FROM marks "
                + "WHERE userId=? AND gameId=?;";
        try {
            delete = connection.prepareStatement(deleteString);
            delete.setLong(1, mark.getUserId());
            delete.setLong(2, mark.getGameId());
            delete.execute();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            System.err.println(e.getErrorCode());
        }
    }

    @Override
    public Set<Game> getGames(long userId, long offset, int limit,
                              String seek, int fromYear, int toYear) {
        Connection connection = DataBaseUtilities.getConnection();
        PreparedStatement select = null;
        ResultSet resultSet = null;
        Set<Game> games = new HashSet<>();
        String selectUserString = "SELECT * FROM games "
                + "JOIN marks ON games.id = marks.gameId "
                + "WHERE marks.userId=? AND UPPER(title) LIKE UPPER(?) "
                + "AND releaseYear BETWEEN ? and ? ORDER BY id DESC "
                + "LIMIT ? OFFSET ?;";
        try {
            select = connection.prepareStatement(selectUserString);
            select.setLong(1, userId);
            seek = seek
                    .replace("!", "!!")
                    .replace("%", "!%")
                    .replace("_", "!_")
                    .replace("[", "![");
            select.setString(2, '%' + seek + '%');
            select.setInt(3, fromYear);
            select.setInt(4, toYear);
            select.setInt(5, limit);
            select.setLong(6, offset);
            resultSet = select.executeQuery();
            while (resultSet.next()) {
                games.add(GamesDaoImp.resultSetRowToGame(resultSet));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            System.err.println(e.getErrorCode());
        }
        return games;
    }
}

