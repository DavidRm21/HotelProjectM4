package interfaceWindow;

public class InitPanel {

    private FrameWindow frame;

    public InitPanel(VSignSystem vSignSystem, VSignIn vSignIn, VReservation vReservation, VPayment vPayment) {

        frame = new FrameWindow(vSignSystem, vSignIn, vReservation, vPayment);
        frame.getjFrame().requestFocus();
    }

}
