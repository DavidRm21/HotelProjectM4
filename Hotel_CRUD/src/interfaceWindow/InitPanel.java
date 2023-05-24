package interfaceWindow;

public class InitPanel {

    private FrameWindow frame;

    public InitPanel(VSignIn vSignIn, VReservation vReservation, VPayment vPayment) {

        frame = new FrameWindow(vSignIn, vReservation, vPayment);
        frame.getjFrame().requestFocus();
    }

}
