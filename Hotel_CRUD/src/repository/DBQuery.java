package repository;

import model.Client;
import model.Room;
import model.ServHotel;

import javax.swing.*;
import javax.xml.namespace.QName;
import java.sql.*;
import java.util.ArrayList;


public class DBQuery {

    private DBConection connect = new DBConection();
    private PreparedStatement preparedStatement = null;
    private Statement statement = null;
    private Connection conexion = null;
    private ResultSet resultSet = null;


    public boolean verifyUser(String email, String password){
        String query = "SELECT correo, contrasena FROM cliente WHERE correo = \"" + email + "\" AND contrasena = \'" + password + "\'";

        try{
            conexion = connect.getConnection();
            statement = conexion.createStatement();
            resultSet = statement.executeQuery(query);

            if(resultSet.next()){
                saveClient(email);
                return true;
            }else {
                return false;
            }

        }catch (Exception e){
            System.out.println("[ERROR] "+ e);
            return false;
        }
    }

    public Client saveClient(String emailClient){
        String query = "SELECT cliente_id, nombre, apellido, correo, contrasena, telefono FROM cliente WHERE correo = \"" + emailClient + "\"";

        Client client = null;

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

                client =(new Client(
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

    public ArrayList<Room> readRooms(){
        String query = "SELECT habitacion_id, tipo, precio, capacidad, estado FROM habitacion WHERE hotel_id = 1";

        ArrayList<Room> rooms = new ArrayList<>();

        int id;
        String type;
        float price;
        int capability;
        boolean state;

        try{
            conexion = connect.getConnection();
            statement = conexion.createStatement();
            resultSet = statement.executeQuery(query);

            while(resultSet.next()) {
                id = resultSet.getInt(1);
                type = resultSet.getString(2);
                price = resultSet.getFloat(3);
                capability = resultSet.getInt(4);
                state = resultSet.getBoolean(5);

                rooms.add(new Room(
                        id,
                        type,
                        price,
                        capability,
                        state     ));
            }
        }catch (Exception e){
            System.out.println("[ERROR] "+ e);
        }

        return rooms;
    }

    public boolean verifyEmail(String email){
        String query = "SELECT correo FROM cliente WHERE correo = \"" + email + "\"";
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

    public void insertNewClient(int id, String name, String lastName, String email, String password, String phone){
        String query = "INSERT INTO cliente (cliente_id, nombre, apellido, correo, contrasena, telefono) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        try{
            conexion = connect.getConnection();
            preparedStatement = conexion.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, lastName);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, password);
            preparedStatement.setString(6, phone);

            preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Registro exitoso");

        }catch (Exception e){
            System.out.println("[ERROR] " + e);
        }
    }

    public Room getRoomById(int id){
        String query = "SELECT habitacion_id, tipo, precio, capacidad, estado FROM habitacion WHERE habitacion_id = " + id;

        Room room = null;
        int h_id = 0;
        String type;
        float price;
        int capability;
        boolean state;

        try{
            conexion = connect.getConnection();
            statement = conexion.createStatement();
            resultSet = statement.executeQuery(query);

            while(resultSet.next()) {
                h_id = resultSet.getInt(1);
                type = resultSet.getString(2);
                price = resultSet.getFloat(3);
                capability = resultSet.getInt(4);
                state = resultSet.getBoolean(5);

                room = new Room(
                        h_id,
                        type,
                        price,
                        capability,
                        state     );
            }
        }catch (Exception e){
            System.out.println("[ERROR] "+ e);
        }
        return room;
    }

    public ArrayList<ServHotel> readServiceHotel(){
        String query = "SELECT servicio_id, nombre, precio FROM servicio";
        ArrayList<ServHotel> servHotel= new ArrayList<>();

        int s_id ;
        String name;
        float price;

        try{
            conexion = connect.getConnection();
            statement = conexion.createStatement();
            resultSet = statement.executeQuery(query);

            while(resultSet.next()) {
                s_id = resultSet.getInt(1);
                name = resultSet.getString(2);
                price = resultSet.getFloat(3);

                 servHotel.add(new ServHotel(
                        s_id,
                        name,
                        price        ));
            }
        }catch (Exception e){
            System.out.println("[ERROR] "+ e);
        }
        return servHotel;
    }

    public  void insertReservation(int rv, int cl, int hb, Date dtS, Date dtE, String tS, String tE){
        String query = "INSERT INTO reserva(reserva_id, cliente_id, habitacion_id, fecha_inicio, fecha_fin, hora_inicial, hora_final) VALUES \n" +
                "(?, ?, ?, ?, ?, ?, ?);";

        try{
            conexion = connect.getConnection();
            preparedStatement = conexion.prepareStatement(query);

            preparedStatement.setInt(1, rv);
            preparedStatement.setInt(2, cl);
            preparedStatement.setInt(3, hb);
            preparedStatement.setDate(4, dtS);
            preparedStatement.setDate(5, dtE);
            preparedStatement.setString(6, tS);
            preparedStatement.setString(7, tE);

            preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Registro exitoso");

        }catch (Exception e){
            System.out.println("[ERROR] " + e);
        }

    }
    public  void insertReservation(int rv, int srv){
        String query = "INSERT INTO reserva_servicio (reserva_id, servicio_id) VALUES \n" +
                "(?, ?);";

        try{
            conexion = connect.getConnection();
            preparedStatement = conexion.prepareStatement(query);

            preparedStatement.setInt(1, rv);
            preparedStatement.setInt(2, srv);

            preparedStatement.executeUpdate();

        }catch (Exception e){
            System.out.println("[ERROR] " + e);
        }
    }


}
