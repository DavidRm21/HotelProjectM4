package repository;


import java.sql.Connection;
import java.sql.DriverManager;

public class DBConection {

    private Connection connection;
    private String user = "root";
    private String password = "";

    public DBConection() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/establecimientos",
                    user,
                    password);

        }catch (Exception e){
            System.err.println("[ERROR] " + e);
        }
    }

    public  Connection getConnection(){
        return connection;
    }


}
