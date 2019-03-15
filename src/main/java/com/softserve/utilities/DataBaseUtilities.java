package com.softserve.utilities;

import com.softserve.dao.Games;
import com.softserve.dao.Marks;
import com.softserve.dao.PlayLater;
import com.softserve.dao.Users;
import com.softserve.dao.daoImp.GamesImp;
import com.softserve.dao.daoImp.MarksImp;
import com.softserve.dao.daoImp.PlayLaterImp;
import com.softserve.dao.daoImp.UsersImp;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public final class DataBaseUtilities {
    private static String user;
    private static String password;
    private static String url;
    private static Connection connection;
    private static Users users = new UsersImp();
    private static Games games = new GamesImp();
    private static PlayLater playLater = new PlayLaterImp();
    private static Marks marks = new MarksImp();

    static {
        Properties properties = new Properties();
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(
                    "src/main/resources/dbconfig.properties");
            properties.load(inputStream);
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            url = properties.getProperty("url");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static {
        connection = null;
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            System.err.println(e.getErrorCode());
        }
    }

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

    private DataBaseUtilities() {

    }

    public static Connection getConnection() {
        return connection;
    }
}

