package service;


import inputMouse.MouseInputs;
import interfaceWindow.InitPanel;
import interfaceWindow.VPayment;
import interfaceWindow.VReservation;
import interfaceWindow.VSignIn;

public class Services {

    private VSignIn vSignIn;
    private VReservation vReservation;
    private VPayment vPayment;
    private InitPanel initPanel;
    private MouseInputs inputs;
    private int label = 15, button = 6, font = 4, textField = 6;

    public Services() {
        vSignIn = new VSignIn(label, button, font, textField);
        vReservation = new VReservation(label, button, font, textField);
        vPayment = new VPayment(label, button, font, textField);

        initPanel = new InitPanel(vSignIn, vReservation, vPayment);
        inputs = new MouseInputs(vSignIn, vReservation, vPayment);

        vSignIn.getButtonLog().addMouseListener(inputs);
        vSignIn.getButtonRecord().addMouseListener(inputs);
        vReservation.getButtonPeopleAdd().addMouseListener(inputs);
        vReservation.getButtonPeopleSubtract().addMouseListener(inputs);
        vReservation.getButtonRoomAdd().addMouseListener(inputs);
        vReservation.getButtonRoomSubtract().addMouseListener(inputs);
        vReservation.getButtonEnd().addMouseListener(inputs);
        vReservation.getTextStart().addMouseListener(inputs);
        vReservation.getTextEnd().addMouseListener(inputs);
        vPayment.getButtonPay().addMouseListener(inputs);
        vPayment.getButtonBack().addMouseListener(inputs);

    }
}
