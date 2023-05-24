package interfaceWindow;

public class InitPanel {

    private VSignIn vSignIn;
    private VReservation vReservation;
    private VPayment vPayment;
    private FrameWindow frame;

    public InitPanel() {
        vSignIn = new VSignIn();
        vReservation = new VReservation();
        vPayment = new VPayment();
        frame = new FrameWindow(vSignIn, vReservation, vPayment);
        frame.getjFrame().requestFocus();
    }

}
