package utilitiesTests;

import com.softserve.utilities.DataBaseUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class DataBaseUtilitiesTest {
    @Test
    public void connectsToDB() throws SQLException {
        Connection connection = DataBaseUtilities.getConnection();
        connection.close();
        Assertions.assertNotEquals(null, connection);
    }
}

