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
        statement.execute("INSERT INTO persons (first_name, last_name, age, date_joined, date_updated) VALUES ('Unique', 'Name', 999, '9999-09-09', '" + modifiedDate + "')");
        ResultSet rs = statement.executeQuery("SELECT * FROM persons WHERE first_name = 'Unique'");
        rs.next();
        assertEquals(rs.getString("first_name"), "Unique");
        assertEquals(rs.getString("last_name"), "Name");
        assertEquals(rs.getLong("age"), 999);
        assertEquals(rs.getString("date_joined"), "9999-09-09");
        assertEquals(rs.getString("date_updated"), modifiedDate);
    }

    @Test
    public void testIfCrudUpdateWorks() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/back_end_technical?allowPublicKeyRetrieval=true&useSSL=false",
                "root",
                "codeup");
        Statement statement = connection.createStatement();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date todaysDate = Calendar.getInstance().getTime();
        String modifiedDate = (formatter.format(todaysDate));
        statement.execute("UPDATE persons SET first_name = 'VeryUnique' WHERE first_name = 'Unique'");
        statement.execute("UPDATE persons SET last_name = 'Namae' WHERE last_name = 'Name'");
        statement.execute("UPDATE persons SET age = 888 WHERE first_name = 'VeryUnique'");
        statement.execute("UPDATE persons SET date_joined = '1111-01-01' WHERE date_joined = '9999-09-09'");
        ResultSet rs = statement.executeQuery("SELECT * FROM persons WHERE first_name = 'VeryUnique'");
        rs.next();
        assertEquals(rs.getString("first_name"), "VeryUnique");
        assertEquals(rs.getString("last_name"), "Namae");
        assertEquals(rs.getLong("age"), 888);
        assertEquals(rs.getString("date_joined"), "1111-01-01");
        assertEquals(rs.getString("date_updated"), modifiedDate);
    }
}
