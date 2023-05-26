package inputMouse;

import interfaceWindow.VPayment;
import interfaceWindow.VReservation;
import interfaceWindow.VSignIn;
import service.Services;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseInputs implements MouseListener, MouseMotionListener {

    private VSignIn vSignIn;
    private VReservation vReservation;
    private VPayment vPayment;
    private Services services;
    private int nPeople = 0, nRoom = 0;

    public MouseInputs(VSignIn vSignIn, VReservation vReservation, VPayment vPayment, Services services) {
        this.vSignIn = vSignIn;
        this.vReservation = vReservation;
        this.vPayment = vPayment;
        this.services = services;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == vSignIn.getButtonRecord()){
            System.out.println("Registrar");
        }

        if(e.getSource() == vSignIn.getButtonLog()){
            String email = vSignIn.getTextInput()[0].getText();
            String password = vSignIn.getTextInput()[1].getText();
            services.verifySuccess(email, password);
        }
        if(e.getSource() == vReservation.getButtonPeopleAdd()){
            ++nPeople;
            vReservation.getText()[5].setText(String.valueOf(nPeople));
        }
        if (e.getSource() == vReservation.getButtonRoomAdd()){
            ++nRoom;
            vReservation.getText()[6].setText(String.valueOf(nRoom));
        }
        if (e.getSource() == vReservation.getButtonPeopleSubtract()){
            --nPeople;
            vReservation.getText()[5].setText(String.valueOf(nPeople));
        }
        if(e.getSource() == vReservation.getButtonRoomSubtract()){
            --nRoom;
            vReservation.getText()[6].setText(String.valueOf(nRoom));
        }
        if(e.getSource() == vReservation.getTextEnd()){
            vReservation.getTextEnd().setText("");
        }
        if(e.getSource() == vReservation.getTextStart()){
            vReservation.getTextStart().setText("");
        }
        if(e.getSource() == vPayment.getButtonPay()){
            System.out.println("Pagar");
        }
        if(e.getSource() == vPayment.getButtonBack()){
            System.out.println("Atras");
        }
        if(e.getSource() == vSignIn.getTextInput()[0]){
            vSignIn.getTextInput()[0].setBackground(new Color(190, 190, 190));
        }
        if(e.getSource() == vSignIn.getTextInput()[1]){
            vSignIn.getTextInput()[1].setBackground(new Color(190, 190, 190));
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
        if(e.getSource() == vReservation.getButtonEnd()){
            vReservation.getButtonEnd().setBackground(new Color(21, 19, 181));
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
        if(e.getSource() == vReservation.getButtonEnd()){
            vReservation.getButtonEnd().setBackground(new Color(21, 19, 111));
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
