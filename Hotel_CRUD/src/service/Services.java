package service;

import inputMouse.MouseInputs;
import model.ServHotel;
import vistas.VPayment;
import vistas.VReservation;
import vistas.VSignIn;
import vistas.VSignSystem;
import interfaceWindow.InitPanel;
import model.Client;
import model.Room;
import repository.DBQuery;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;

public class Services {

    private VSignIn vSignIn;
    private VReservation vReservation;
    private VPayment vPayment;
    private VSignSystem vSignSystem;
    private InitPanel initPanel;
    private MouseInputs inputs;
    private DBQuery dataBase;
    private Client client;
    private ArrayList<ServHotel> serviciosHotel;
    private ArrayList<Room> rooms;
    private int label = 11, button = 6, font = 4, textField = 6;


    public Services() {

        dataBase = new DBQuery();
        vSignSystem = new VSignSystem(label, button, font, textField);
        vSignIn = new VSignIn(label, button, font, textField);
        vReservation = new VReservation(label, button, font, textField);
        vPayment = new VPayment(18, button, font, textField);

        initPanel = new InitPanel(vSignSystem, vSignIn, vReservation, vPayment);
        inputs = new MouseInputs(vSignSystem, vSignIn, vReservation, vPayment, this);
        rooms = vReservation.drawModel(dataBase.readRooms());
        serviciosHotel = dataBase.readServiceHotel();

        vSignSystem.getButtonAccept().addMouseListener(inputs);
        vSignSystem.getButtonBack().addMouseListener(inputs);

        vSignIn.getButtonLog().addMouseListener(inputs);
        vSignIn.getButtonRecord().addMouseListener(inputs);
        vSignIn.getInputMail().addMouseListener(inputs);
        vSignIn.getInputPass().addMouseListener(inputs);

        vReservation.getButtonEnd().addMouseListener(inputs);
        vReservation.getSignOut().addMouseListener(inputs);
        vReservation.getTable().addMouseListener(inputs);

        vPayment.getButtonPay().addMouseListener(inputs);
        vPayment.getButtonBack().addMouseListener(inputs);

    }

    // Verificar si el usuario y la contraseña existe en la tabla clientes
    public void verifySuccess(){
        String mail = vSignIn.getTextInput()[0].getText();
        String pass = vSignIn.getTextInput()[1].getText();

        if(dataBase.verifyUser(mail, pass)){
            Client client = dataBase.saveClient(mail);
            vReservation.getLabelWelcome().setText("Bienvenid@, " + client.getName() + " " + client.getLastName());
            vPayment.setVisible(false);
            vSignIn.setVisible(false);
            vReservation.setVisible(true);
        }else{
            vSignIn.getTextInput()[0].setBackground(new Color(227, 111, 111));
            vSignIn.getTextInput()[1].setBackground(new Color(227, 111, 111));
        }
    }

    // Verificar si el correo ya existe.
    public void verifyEmailSuccess(){

        String email = vSignSystem.getTextEmail().getText();

        if (dataBase.verifyEmail(email)){

            vSignSystem.getTextEmail().setBackground(new Color(227, 111, 111));

        }else{

            if(vSignSystem.getTextCC().getText().isBlank()){
                vSignSystem.getTextCC().setBackground(new Color(227, 111, 111));

            } else if (vSignSystem.getTextName().getText().isBlank()) {
                vSignSystem.getTextName().setBackground(new Color(227, 111, 111));

            } else if (vSignSystem.getTextPhone().getText().isBlank()) {
                vSignSystem.getTextPhone().setBackground(new Color(227, 111, 111));

            } else if (vSignSystem.getTextPassword().getText().isBlank()) {
                vSignSystem.getTextPassword().setBackground(new Color(227, 111, 111));

            }else{

                int id = Integer.parseInt(vSignSystem.getTextCC().getText());
                String name = vSignSystem.getTextName().getText();
                String lastName = vSignSystem.getTextLastName().getText();
                String mail = vSignSystem.getTextEmail().getText();
                String pass = vSignSystem.getTextPassword().getText();
                String phone = vSignSystem.getTextPhone().getText();

                dataBase.insertNewClient(id, name, lastName, mail, pass, phone);
                vSignSystem.getButtonAccept().setBackground(new Color(28, 151, 18));
                for (int i = 0; i < 5; i++) {
                    vSignSystem.getText()[i].setText("");
                }
            }
        }
    }

    // Obtener la habitacion por el evento de click
    public Room getRoomsByIdClicked(int id){
        int habitacion_id = rooms.get(id).getId();
        Room room = dataBase.getRoomById(habitacion_id);
        System.out.println(room.getId() + " | " + room.getType() + " | " + room.getPrice());
        if(room.isState()){
            vReservation.isAvailableRoom().setBackground(new Color(28, 151, 18));
            vReservation.isAvailableRoom().setText("Disponible");
        } else if (!room.isState()) {
            vReservation.isAvailableRoom().setBackground(new Color(227, 111, 111));
            vReservation.isAvailableRoom().setText("Ocupado");
        } else{
            vReservation.isAvailableRoom().setBackground(new Color(100, 100, 100, 0));
            vReservation.isAvailableRoom().setText("");
        }
        return room;
    }

    // Actualizar la tabla
    public void updateTableModel(){
        vReservation.getModel().fireTableDataChanged();
        vReservation.getTable().repaint();
    }

    // Resetear los componentes al salir de sesión
    public void resetInterfaces(){
        vReservation.drawModel(dataBase.readRooms());
        vReservation.drawModel(rooms);
        vSignIn.getInputMail().setText("");
        vSignIn.getInputPass().setText("");
//        vPayment.drawComponents();
        for (int i = 0; i < vSignSystem.getTextInput().length; i++) {
            vSignSystem.getTextInput()[i].setText("");
        }
    }

    // Verificar la disponibilidad de la habitación
    public boolean verifyAvailable(Room room){
        if(room.isState()){
            return true;
        }else{
            return false;
        }
    }

    // Presentar el resumen de la reserva
    public void setSummary(Room room){
        vPayment.getLabelRoom().setText(String.valueOf(room.getId()));
        vPayment.getLabelType().setText(room.getType());
        vPayment.getLabelPrice().setText(String.valueOf(room.getPrice()));
        vPayment.getLabelCapability().setText(String.valueOf(room.getCapacity()));

        Date startDate = vReservation.getStartDate().getDate();
        Date endDate = vReservation.getEndDate().getDate();
        vPayment.getLabelStartDate().setText(formatDate(startDate) + "");
        vPayment.getLabelEndDate().setText(formatDate(endDate) + "");

        vPayment.getLabelServices().setText("Servicios");
        vPayment.getButtonPay().setText("Pagar: " + room.getPrice());
    }

    // Formateo de fecha a formato que SQL admite
    public Date formatDate(Date date){
        Date format = date;
        long d = format.getTime();
        java.sql.Date dateSql = new java.sql.Date(d);
        return dateSql;
    }



}
