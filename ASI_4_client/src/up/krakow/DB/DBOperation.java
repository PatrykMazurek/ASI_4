package up.krakow.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBOperation {

    private Connection conn;

    public DBOperation(Connection c){
        conn = c;
    }

    public void insertPerson(String name, String lastName, int age){
        try {
            PreparedStatement preper = conn.prepareStatement(
                    "INSERT INTO Person" +
                    "(Name, LastName, Age) VALUES (?,?,?) ");
            preper.setString(1, name);
            preper.setString(2, lastName);
            preper.setInt(3, age);
            int result = preper.executeUpdate();
            System.out.println("Dodane rekordy " + result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
