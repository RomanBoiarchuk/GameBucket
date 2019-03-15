package com.softserve.dao.daoImp;

import com.softserve.dao.GamesDao;
import com.softserve.models.Game;
import com.softserve.utilities.DataBaseUtilities;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class GamesDaoImp implements GamesDao {

    private boolean exists(Game game) throws SQLException {
        Connection connection = DataBaseUtilities.getConnection();
        PreparedStatement select = connection
                .prepareStatement("SELECT * FROM games WHERE "
                        + "id=?;");
        select.setLong(1, game.getId());
        ResultSet resultSet = select.executeQuery();
        boolean exists = resultSet.next();
        select.close();
        return exists;
    }

    private Game resultSetRowToGame(ResultSet resultSet) throws SQLException {
        Game game = new Game();
        game.setId(resultSet.getLong("id"));
        game.setTitle(resultSet.getString("title"));
        game.setReleaseYear(resultSet.getInt("releaseYear"));
        if (resultSet.getString("description") != null) {
            game.setDescription(resultSet.getString("description"));
        }
        if (resultSet.getString("image") != null) {
            game.setImg(resultSet.getString("img"));
        }
        return game;
    }

    @Override
    public Game getById(long id) {
        Connection connection = DataBaseUtilities.getConnection();
        PreparedStatement selectGame = null;
        ResultSet resultSet = null;
        Game game = null;
        String selectUserString = "SELECT * FROM games "
                + "WHERE id=?;";
        try {
            selectGame = connection.prepareStatement(selectUserString);
            selectGame.setLong(1, id);
            resultSet = selectGame.executeQuery();
            resultSet.beforeFirst();
            if (resultSet.next()) {
                game = resultSetRowToGame(resultSet);
            } else {
                throw new IllegalArgumentException();
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            System.err.println(e.getErrorCode());
        }
        return game;
    }

    @Override
    public Set<Game> getAll() {
        Set<Game> games = new HashSet<>();
        Connection conn = DataBaseUtilities.getConnection();
        Statement select = null;
        ResultSet resultSet = null;
        Game game = null;
        String selectString = "SELECT * FROM games;";
        try {
            select = conn.createStatement();
            resultSet = select.executeQuery(selectString);
            while (resultSet.next()) {
                game = resultSetRowToGame(resultSet);
                games.add(game);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            System.err.println(e.getErrorCode());
        }
        return games;
    }

    @Override
    public boolean add(Game game) {
        Connection connection = DataBaseUtilities.getConnection();
        PreparedStatement insert = null;
        String insertString =
                "INSERT INTO games(title, releaseYear, description, image) "
                + "VALUES(?,?,?,?);";
        try {
            if (exists(game)) {
                throw new IllegalArgumentException();
            }
            insert = connection.prepareStatement(insertString);
            insert.setString(1, game.getTitle());
            insert.setInt(2, game.getReleaseYear());
            if (!game.getDescription().trim().equals("")) {
                insert.setString(3,game.getDescription());
            } else {
                insert.setString(3,null);
            }
            if (!game.getImg().trim().equals("")) {
                insert.setString(4,game.getImg());
            } else {
                insert.setString(4, null);
            }
            insert.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            System.err.println(e.getErrorCode());
            return false;
        }

    }

    @Override
    public boolean update(Game game) {
        Connection connection = DataBaseUtilities.getConnection();
        PreparedStatement update = null;
        String updateString = "UPDATE games "
                + "SET title=?, "
                + "releaseYear=?, description=?,image=? "
                + "WHERE id=?";
        try {
            if (!exists(game)) {
                throw new IllegalArgumentException();
            }
            update = connection.prepareStatement(updateString);
            update.setString(1, game.getTitle());
            update.setInt(2, game.getReleaseYear());
            if (!game.getDescription().trim().equals("")) {
                update.setString(3,game.getDescription());
            } else {
                update.setString(3,null);
            }
            if (!game.getImg().trim().equals("")) {
                update.setString(4,game.getImg());
            } else {
                update.setString(4, null);
            }
            update.setLong(5, game.getId());
            update.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            System.err.println(e.getErrorCode());
            return false;
        }
    }

    @Override
    public void deleteById(long gameId) {
        Connection connection = DataBaseUtilities.getConnection();
        PreparedStatement delete = null;
        String deleteString = "DELETE FROM games WHERE id=?;";
        try {
            delete = connection.prepareStatement(deleteString);
            delete.setLong(1, gameId);
            delete.execute();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            System.err.println(e.getErrorCode());
        }
    }
}

