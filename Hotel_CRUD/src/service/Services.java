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

    public Services() {
        vSignIn = new VSignIn(3, 2, 4, 2);
        vReservation = new VReservation(13, 6, 4, 2);
        vPayment = new VPayment();

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

    }
}
