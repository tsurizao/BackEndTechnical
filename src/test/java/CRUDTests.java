import org.junit.Test;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class CRUDTests {

    @Test
    public void testIfCrudReadWorks() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/back_end_technical?allowPublicKeyRetrieval=true&useSSL=false",
                "root",
                "codeup");
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM persons WHERE id = '" + 1 + "'");
        rs.next();
        assertEquals (rs.getString("first_name"), "John");
    }
}
