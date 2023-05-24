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
        vSignIn = new VSignIn();
        vReservation = new VReservation();
        vPayment = new VPayment();

        initPanel = new InitPanel(vSignIn, vReservation, vPayment);
        inputs = new MouseInputs(vSignIn, vReservation, vPayment);
        vSignIn.getButtonLog().addMouseListener(inputs);
        vSignIn.getButtonRecord().addMouseListener(inputs);

    }
}
