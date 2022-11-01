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
        assertEquals(rs.getString("first_name"), "John");
        assertEquals(rs.getString("last_name"), "Smith");
        assertEquals(rs.getLong("age"), 35);
        assertEquals(rs.getString("date_joined"), "2012-07-22");
    }

    @Test
    public void testIfCrudCreateWorks() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/back_end_technical?allowPublicKeyRetrieval=true&useSSL=false",
                "root",
                "codeup");
        Statement statement = connection.createStatement();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date todaysDate = Calendar.getInstance().getTime();
        String modifiedDate = (formatter.format(todaysDate));
        statement.execute("INSERT INTO persons (first_name, last_name, age, date_joined, date_updated) VALUES ('Bill', 'Brown', 18, '2022-10-20', '" + modifiedDate + "')");
        ResultSet rs = statement.executeQuery("SELECT * FROM persons WHERE first_name = 'Bill'");
        rs.next();
        assertEquals(rs.getString("first_name"), "Bill");
        assertEquals(rs.getString("last_name"), "Brown");
        assertEquals(rs.getLong("age"), 18);
        assertEquals(rs.getString("date_joined"), "2022-10-20");
        assertEquals(rs.getString("date_updated"), modifiedDate);
    }
}
