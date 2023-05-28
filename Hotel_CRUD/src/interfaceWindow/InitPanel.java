package interfaceWindow;

import vistas.VPayment;
import vistas.VReservation;
import vistas.VSignIn;
import vistas.VSignSystem;

public class InitPanel {

    private FrameWindow frame;

    public InitPanel(VSignSystem vSignSystem, VSignIn vSignIn, VReservation vReservation, VPayment vPayment) {
        frame = new FrameWindow(vSignSystem, vSignIn, vReservation, vPayment);
        frame.getjFrame().requestFocus();
    }

}
