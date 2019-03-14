package com.softserve.utilities;

import com.softserve.dao.Games;
import com.softserve.dao.Marks;
import com.softserve.dao.PlayLater;
import com.softserve.dao.Users;
import com.softserve.dao.daoImp.GamesImp;
import com.softserve.dao.daoImp.MarksImp;
import com.softserve.dao.daoImp.PlayLaterImp;
import com.softserve.dao.daoImp.UsersImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DataBaseUtilities {
    private static final String USER = "root";
    private static final String PASSWORD = "password";
    private static final String URL = "jdbc:mysql://localhost:3306/gamebucketdb";
    private static Connection connection;
    private static Users users = new UsersImp();
    private static Games games = new GamesImp();
    private static PlayLater playLater = new PlayLaterImp();
    private static Marks marks = new MarksImp();

    public static Marks getMarks() {
        return marks;
    }

    public static PlayLater getPlayLater() {
        return playLater;
    }

    public static Games getGames() {
        return games;
    }

    public static Users getUsers() {
        return users;
    }

    static {
        connection = null;
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            System.err.println(e.getErrorCode());
        }
    }

    private DataBaseUtilities() {

    }

    public static Connection getConnection() {
        return connection;
    }
}

