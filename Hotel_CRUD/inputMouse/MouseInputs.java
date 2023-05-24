package inputMouse;

import interfaceWindow.VPayment;
import interfaceWindow.VReservation;
import interfaceWindow.VSignIn;

import java.awt.*;
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
        if(e.getSource() == vSignIn.getButtonRecord()){
            System.out.println("Registrar");
        }
        if(e.getSource() == vSignIn.getButtonLog()){
            System.out.println("Ingresar");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource() == vSignIn.getButtonRecord()){
            vSignIn.getButtonRecord().setBackground(new Color(28, 200, 18));
        }
        if(e.getSource() == vSignIn.getButtonLog()){
            vSignIn.getButtonLog().setBackground(new Color(21, 19, 181));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == vSignIn.getButtonRecord()){
            vSignIn.getButtonRecord().setBackground(new Color(28, 151, 18));
        }
        if(e.getSource() == vSignIn.getButtonLog()){
            vSignIn.getButtonLog().setBackground(new Color(21, 19, 111));
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
