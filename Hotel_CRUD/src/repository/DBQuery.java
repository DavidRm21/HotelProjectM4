package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBQuery {

    private DBConection connect = new DBConection();
    private PreparedStatement preparedStatement = null;
    private Statement statement = null;
    private Connection conexion = null;
    private ResultSet resultSet = null;

}
