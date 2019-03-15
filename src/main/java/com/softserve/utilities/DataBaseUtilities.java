package com.softserve.utilities;

import com.softserve.dao.GamesDao;
import com.softserve.dao.MarksDao;
import com.softserve.dao.PlayLaterDao;
import com.softserve.dao.UsersDao;
import com.softserve.dao.daoImp.GamesDaoImp;
import com.softserve.dao.daoImp.MarksDaoImp;
import com.softserve.dao.daoImp.PlayLaterDaoImp;
import com.softserve.dao.daoImp.UsersDaoImp;

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
    private static UsersDao usersDao = new UsersDaoImp();
    private static GamesDao gamesDao = new GamesDaoImp();
    private static PlayLaterDao playLaterDao = new PlayLaterDaoImp();
    private static MarksDao marksDao = new MarksDaoImp();

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

    public static MarksDao getMarksDao() {
        return marksDao;
    }

    public static PlayLaterDao getPlayLaterDao() {
        return playLaterDao;
    }

    public static GamesDao getGamesDao() {
        return gamesDao;
    }

    public static UsersDao getUsersDao() {
        return usersDao;
    }

    private DataBaseUtilities() {

    }

    public static Connection getConnection() {
        return connection;
    }
}

