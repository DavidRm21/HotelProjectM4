package repository;

import model.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBQuery {

    private DBConection connect = new DBConection();
    private PreparedStatement preparedStatement = null;
    private Statement statement = null;
    private Connection conexion = null;
    private ResultSet resultSet = null;


    public boolean verifyUser(String email, String password){
        String query = "SELECT correo, contrasena FROM cliente WHERE correo = \"" + email + "\" AND contrasena = \"" + password + "\"";

        try{
            conexion = connect.getConnection();
            statement = conexion.createStatement();
            resultSet = statement.executeQuery(query);

            if(resultSet.next()){
                return true;
            }else {
                return false;
            }

        }catch (Exception e){
            System.out.println("[ERROR] "+ e);
            return false;
        }
    }

    public List<Client> saveClient(String emailClient){
        String query = "SELECT cliente_id, nombre, apellido, correo, contrasena, telefono FROM cliente WHERE correo = \"" + emailClient + "\"";

        List<Client> client = new ArrayList<>();

        int id;
        String name;
        String lastName;
        String email;
        String password;
        String phone;

        try{
            conexion = connect.getConnection();
            statement = conexion.createStatement();
            resultSet = statement.executeQuery(query);

            while(resultSet.next()) {
                id = resultSet.getInt(1);
                name = resultSet.getString(2);
                lastName = resultSet.getString(3);
                email = resultSet.getString(4);
                password = resultSet.getString(5);
                phone = resultSet.getString(6);

                client.add(new Client(
                        id,
                        name,
                        lastName,
                        email,
                        password,
                        phone           ));
            }

        }catch (Exception e){
            System.out.println("[ERROR] "+ e);
        }

        return client;
    }


}
