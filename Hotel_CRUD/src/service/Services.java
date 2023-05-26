package service;


import inputMouse.MouseInputs;
import interfaceWindow.*;
import model.Client;
import repository.DBQuery;
import java.awt.Color;

public class Services {

    private VSignIn vSignIn;
    private VReservation vReservation;
    private VPayment vPayment;
    private VSignSystem vSignSystem;
    private InitPanel initPanel;
    private MouseInputs inputs;
    private DBQuery dataBase;
    private Client client;
    private int label = 15, button = 6, font = 4, textField = 6;


    public Services() {

        dataBase = new DBQuery();
        vSignSystem = new VSignSystem(label, button, font, textField);
        vSignIn = new VSignIn(label, button, font, textField);
        vReservation = new VReservation(label, button, font, textField);
        vPayment = new VPayment(label, button, font, textField);

        initPanel = new InitPanel(vSignSystem, vSignIn, vReservation, vPayment);
        inputs = new MouseInputs(vSignSystem, vSignIn, vReservation, vPayment, this);

        vSignSystem.getButtonAccept().addMouseListener(inputs);
        vSignSystem.getButtonBack().addMouseListener(inputs);

        vSignIn.getButtonLog().addMouseListener(inputs);
        vSignIn.getButtonRecord().addMouseListener(inputs);
        vSignIn.getTextInput()[0].addMouseListener(inputs);
        vSignIn.getTextInput()[1].addMouseListener(inputs);

        vReservation.getButtonPeopleAdd().addMouseListener(inputs);
        vReservation.getButtonPeopleSubtract().addMouseListener(inputs);
        vReservation.getButtonRoomAdd().addMouseListener(inputs);
        vReservation.getButtonRoomSubtract().addMouseListener(inputs);
        vReservation.getButtonEnd().addMouseListener(inputs);
        vReservation.getTextStart().addMouseListener(inputs);
        vReservation.getTextEnd().addMouseListener(inputs);
        vReservation.getSignOut().addMouseListener(inputs);

        vReservation.drawModel(dataBase.readRooms());


        vPayment.getButtonPay().addMouseListener(inputs);
        vPayment.getButtonBack().addMouseListener(inputs);

    }

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


}
