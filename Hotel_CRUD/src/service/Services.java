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
import javax.swing.JOptionPane;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Services {

    private DBQuery dataBase;
    private VSignSystem vSignSystem;
    private VSignIn vSignIn;
    private VReservation vReservation;
    private VPayment vPayment;
    private InitPanel initPanel;
    private MouseInputs inputs;
    private Client client;
    private Room room;
    private List<ServHotel> servicesSelected;
    private ArrayList<Room> rooms;
    private ArrayList<ServHotel> serviciosHotel;
    private Color required;
    private int label = 11, button = 6, font = 4, textField = 6;


    public Services() {

        dataBase = new DBQuery();
        required = new Color(235, 92, 97);
        vSignSystem = new VSignSystem(label, button, font, textField);
        vSignIn = new VSignIn(label, button, font, textField);
        vReservation = new VReservation(label, button, font, textField);
        vPayment = new VPayment(18, button, font, textField);

        initPanel = new InitPanel(vSignSystem, vSignIn, vReservation, vPayment);
        inputs = new MouseInputs(vSignSystem, vSignIn, vReservation, vPayment, this);
        servicesSelected = new ArrayList<>();

        vSignSystem.getButtonAccept().addMouseListener(inputs);
        vSignSystem.getButtonBack().addMouseListener(inputs);

        vSignIn.getButtonLog().addMouseListener(inputs);
        vSignIn.getButtonRecord().addMouseListener(inputs);
        vSignIn.getInputMail().addMouseListener(inputs);
        vSignIn.getInputPass().addMouseListener(inputs);

        vReservation.getButtonEnd().addMouseListener(inputs);
        vReservation.getSignOut().addMouseListener(inputs);

        vPayment.getButtonPay().addMouseListener(inputs);
        vPayment.getButtonBack().addMouseListener(inputs);

    }

    // Verificar si el usuario y la contraseña existe en la tabla clientes
    public void verifySuccess(){
        String mail = vSignIn.getTextInput()[0].getText();
        String pass = vSignIn.getTextInput()[1].getText();

        if(dataBase.verifyUser(mail, pass)){
            client = dataBase.saveClient(mail);
            rooms = dataBase.readRooms();
            vSignIn.setVisible(false);
            vReservation.setVisible(true);
            vReservation.getLabelWelcome().setText("Bienvenid@, " + client.getName() + " " + client.getLastName());
            vReservation.createModel(rooms, inputs);
        }else{
            vSignIn.getTextInput()[0].setBackground(required);
            vSignIn.getTextInput()[1].setBackground(required);
        }
    }

    // Verificar si el correo ya existe.
    public void verifyEmailSuccess(){
        String email = vSignSystem.getTextEmail().getText();

        if (dataBase.verifyEmail(email)){
            vSignSystem.getTextEmail().setBackground(required);
        }else{
            if(vSignSystem.getTextCC().getText().isBlank()){
                vSignSystem.getTextCC().setBackground(required);

            } else if (vSignSystem.getTextName().getText().isBlank()) {
                vSignSystem.getTextName().setBackground(required);

            } else if (vSignSystem.getTextPhone().getText().isBlank()) {
                vSignSystem.getTextPhone().setBackground(required);

            } else if (vSignSystem.getTextPassword().getText().isBlank()) {
                vSignSystem.getTextPassword().setBackground(required);

            }else{
                int id = Integer.parseInt(vSignSystem.getTextCC().getText());
                String name = vSignSystem.getTextName().getText();
                String lastName = vSignSystem.getTextLastName().getText();
                String mail = vSignSystem.getTextEmail().getText();
                String pass = vSignSystem.getTextPassword().getText();
                String phone = vSignSystem.getTextPhone().getText();

                dataBase.insertNewClient(id, name, lastName, mail, pass, phone);
                vSignSystem.setVisible(false);
                vSignIn.setVisible(true);
                for (int i = 0; i < 5; i++) {
                    vSignSystem.getText()[i].setText("");
                }
            }
        }
    }

    // Obtener la habitacion por el evento de click
    public Room getRoomsByIdClicked(int id){
        int idRow = rooms.get(id).getId();
        room = dataBase.getRoomById(idRow);
        if(room.isState()){
            vReservation.isAvailableRoom().setBackground(new Color(28, 151, 18));
        } else if (!room.isState()) {
            vReservation.isAvailableRoom().setBackground(required);
        }
        return room;
    }

    // Resetear los componentes al salir de sesión
    public void resetInterfaces(){
        vReservation.getTable().clearSelection();
        vReservation.getModel().getDataVector().removeAllElements();
        vSignIn.getInputMail().setText("");
        vSignIn.getInputPass().setText("");
        vReservation.getCheckSauna().setSelected(false);
        vReservation.getCheckSpa().setSelected(false);
        vReservation.getCheckRelocation().setSelected(false);
        vReservation.getCheckDinner().setSelected(false);
        vReservation.getCheckBreak().setSelected(false);
        vReservation.getCheckClub().setSelected(false);
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

        if(servicesSelected.size() > 0){
            String printServices = "";
            for(int i= 0; i < servicesSelected.size(); i++){
                printServices += servicesSelected.get(i).getName() + " $" + servicesSelected.get(i).getPrice() + "\n";
            }
            vPayment.getTextServices().setText(printServices);
        }
        vPayment.getButtonPay().setText("Pagar: " + room.getPrice());
    }

    // Formateo de fecha a formato que SQL admite
    public java.sql.Date formatDate(Date date){
        Date format = date;
        long d = format.getTime();
        java.sql.Date dateSql = new java.sql.Date(d);
        return dateSql;
    }

    // Obtener el total de la reserva
    public float getTotal(){
        serviciosHotel = dataBase.readServiceHotel();
        servicesSelected = new ArrayList<>();
        float total = 0;

        for (int i = 0; i < vReservation.getCheckBox().length; i++) {
            if(vReservation.getCheckBox()[i].isSelected()) {
                total += serviciosHotel.get(i).getPrice();
                servicesSelected.add(serviciosHotel.get(i));
            }
        }
        total += room.getPrice();
        return total;
    }

    public void endReservation(){
        String in = JOptionPane.showInputDialog("Numero de la factura: ");
        int reservation = (in != null ) ? Integer.parseInt(in) : -1;
        if (reservation > 0){
            int cl = client.getId();
            int hb = room.getId();
            java.sql.Date dtS = formatDate(vReservation.getStartDate().getDate());
            java.sql.Date dtE = formatDate(vReservation.getEndDate().getDate());
            String tS = vReservation.getStartTime().getText();
            String tE = vReservation.getEndTime().getText();

            dataBase.insertReservation(reservation, cl, hb, dtS, dtE, tS, tE);

            if(servicesSelected.size() > 0){
                for(int i = 0; i < servicesSelected.size(); i++){
                    dataBase.insertReservation(reservation, servicesSelected.get(i).getId());
                }
            }

        }else{
            JOptionPane.showMessageDialog(null, "Entrada incorrecta.");
        }
    }

}
