package up.krakow.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DBOperation {

    private Connection conn;

    public DBOperation(Connection c){
        conn = c;
    }

    public void insertPerson(String name, String lastName, int age){
        PreparedStatement preper = conn.prepareStatement();
    }
}
