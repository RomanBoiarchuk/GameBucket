package com.softserve.dao.daoImp;

import com.softserve.dao.PlayLaterDao;
import com.softserve.models.Game;
import com.softserve.models.PlayLaterNote;
import com.softserve.utilities.DataBaseUtilities;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;


public class PlayLaterDaoImp implements PlayLaterDao {

    static PlayLaterNote resultSetRowToPlayLaterNote(ResultSet resultSet)
            throws SQLException {
        PlayLaterNote playLaterNote = new PlayLaterNote();
        playLaterNote.setUserId(resultSet.getLong("userId"));
        playLaterNote.setGameId(resultSet.getLong("gameId"));
        return playLaterNote;
    }

    @Override
    public Set<PlayLaterNote> getAll() {
        Connection connection = DataBaseUtilities.getConnection();
        Statement select = null;
        Set<PlayLaterNote> playLaterNotes = new HashSet<>();
        PlayLaterNote playLaterNote = null;
        String selectString = "SELECT * FROM play_later;";
        ResultSet resultSet = null;
        try {
            select = connection.createStatement();
            resultSet = select.executeQuery(selectString);
            while (resultSet.next()) {
                playLaterNote = resultSetRowToPlayLaterNote(resultSet);
                playLaterNotes.add(playLaterNote);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            System.err.println(e.getErrorCode());
        }
        return playLaterNotes;
    }

    @Override
    public Set<PlayLaterNote> getByUserId(long userId) {
        Connection connection = DataBaseUtilities.getConnection();
        PreparedStatement select = null;
        Set<PlayLaterNote> playLaterNotes = new HashSet<>();
        PlayLaterNote playLaterNote = null;
        String selectString = "SELECT * FROM play_later "
                + "WHERE userId=?;";
        ResultSet resultSet = null;
        try {
            select = connection.prepareStatement(selectString);
            select.setLong(1, userId);
            resultSet = select.executeQuery();
            while (resultSet.next()) {
                playLaterNote = resultSetRowToPlayLaterNote(resultSet);
                playLaterNotes.add(playLaterNote);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            System.err.println(e.getErrorCode());
        }
        return playLaterNotes;
    }

    @Override
    public boolean add(PlayLaterNote playLaterNote) {
        Connection connection = DataBaseUtilities.getConnection();
        PreparedStatement insert = null;
        String insertString = "INSERT INTO play_later "
                + "VALUES(?,?);";
        try {
            insert = connection.prepareStatement(insertString);
            insert.setLong(1, playLaterNote.getUserId());
            insert.setLong(2, playLaterNote.getGameId());
            insert.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            System.err.println(e.getErrorCode());
            return false;
        }
    }

    @Override
    public void delete(PlayLaterNote playLaterNote) {
        Connection connection = DataBaseUtilities.getConnection();
        PreparedStatement delete = null;
        String deleteString = "DELETE FROM play_later "
                + "WHERE userId=? AND gameId=?;";
        try {
            delete = connection.prepareStatement(deleteString);
            delete.setLong(1, playLaterNote.getUserId());
            delete.setLong(2, playLaterNote.getGameId());
            delete.execute();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            System.err.println(e.getErrorCode());
        }
    }

    @Override
    public boolean exists(PlayLaterNote playLaterNote) {
        Connection connection = DataBaseUtilities.getConnection();
        PreparedStatement select = null;
        String selectString = "SELECT * FROM play_later "
                + "WHERE userId=? AND gameId=?;";
        ResultSet resultSet = null;
        try {
            select = connection.prepareStatement(selectString);
            select.setLong(1, playLaterNote.getUserId());
            select.setLong(2, playLaterNote.getGameId());
            resultSet = select.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            System.err.println(e.getErrorCode());
            return false;
        }
    }

    @Override
    public Set<Game> getGames(long userId, long offset, int limit) {
        Connection connection = DataBaseUtilities.getConnection();
        PreparedStatement select = null;
        ResultSet resultSet = null;
        Set<Game> games = new HashSet<>();
        String selectUserString = "SELECT * FROM games "
                + "JOIN play_later ON games.id = play_later.gameId "
                + "WHERE play_later.userId=? "
                + "LIMIT ? OFFSET ?;";
        try {
            select = connection.prepareStatement(selectUserString);
            select.setLong(1, userId);
            select.setInt(2, limit);
            select.setLong(3, offset);
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
