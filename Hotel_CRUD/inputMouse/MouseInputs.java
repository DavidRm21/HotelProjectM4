package inputMouse;

import interfaceWindow.VPayment;
import interfaceWindow.VReservation;
import interfaceWindow.VSignIn;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseInputs implements MouseListener, MouseMotionListener {

    private VSignIn vSignIn;
    private VReservation vReservation;
    private VPayment vPayment;

    public MouseInputs(VSignIn vSignIn, VReservation vReservation, VPayment vPayment) {
        this.vSignIn = vSignIn;
        this.vReservation = vReservation;
        this.vPayment = vPayment;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
