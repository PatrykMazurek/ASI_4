package up.krakow.DB;

import com.mysql.cj.MysqlType;

import java.sql.*;

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

    public void getCountPersonProc(){
        try {
            CallableStatement callStm = conn.prepareCall(
                    " { call GetCountPerson(?) }");
            callStm.registerOutParameter(1, MysqlType.INT);
            callStm.executeUpdate();
            int number = callStm.getInt(1);
            System.out.println("liczba rekordów w bazie " + number);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getAllPersonProc(){
        try {
            CallableStatement callStm = conn.prepareCall(
                    "{ call GetAllPersons() }"
            );
            ResultSet result = callStm.executeQuery();
            while (result.next()){
                System.out.println(String.format("%d) %s %s %d",
                        result.getInt(1),
                        result.getString("Name"),
                        result.getString("LastName"),
                        result.getInt(4)));
            }
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
