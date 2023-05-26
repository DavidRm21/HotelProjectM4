package service;


import inputMouse.MouseInputs;
import interfaceWindow.InitPanel;
import interfaceWindow.VPayment;
import interfaceWindow.VReservation;
import interfaceWindow.VSignIn;
import model.Client;
import repository.DBQuery;
import java.awt.Color;

public class Services {

    private VSignIn vSignIn;
    private VReservation vReservation;
    private VPayment vPayment;
    private InitPanel initPanel;
    private MouseInputs inputs;
    private DBQuery dataBase;
    private Client client;
    private int label = 15, button = 6, font = 4, textField = 6;


    public Services() {

        dataBase = new DBQuery();
        vSignIn = new VSignIn(label, button, font, textField);
        vReservation = new VReservation(label, button, font, textField);
        vPayment = new VPayment(label, button, font, textField);

        initPanel = new InitPanel(vSignIn, vReservation, vPayment);
        inputs = new MouseInputs(vSignIn, vReservation, vPayment, this);

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

    public void verifySuccess(String email, String password){

        if(dataBase.verifyUser(email, password)){
            Client client = dataBase.saveClient(email);
            vReservation.getLabelWelcome().setText("Bienvenid@, " + client.getName() + " " + client.getLastName());
            vPayment.setVisible(false);
            vSignIn.setVisible(false);
            vReservation.setVisible(true);
        }else{
            vSignIn.getTextInput()[0].setBackground(new Color(227, 111, 111));
            vSignIn.getTextInput()[1].setBackground(new Color(227, 111, 111));
        }
    }

}
