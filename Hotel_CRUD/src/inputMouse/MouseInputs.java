package inputMouse;

import interfaceWindow.VPayment;
import interfaceWindow.VReservation;
import interfaceWindow.VSignIn;
import interfaceWindow.VSignSystem;
import service.Services;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseInputs implements MouseListener, MouseMotionListener {

    private VSignSystem vSignSystem;
    private VSignIn vSignIn;
    private VReservation vReservation;
    private VPayment vPayment;
    private Services services;
    private int nPeople = 0, nRoom = 0;

    public MouseInputs(VSignSystem vSignSystem, VSignIn vSignIn, VReservation vReservation, VPayment vPayment, Services services) {
        this.vSignSystem = vSignSystem;
        this.vSignIn = vSignIn;
        this.vReservation = vReservation;
        this.vPayment = vPayment;
        this.services = services;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == vSignIn.getButtonRecord()){
            vSignIn.setVisible(false);
            vSignSystem.setVisible(true);
        }
        if(e.getSource() == vSignIn.getButtonLog()){
            services.verifySuccess();
        }
        if(e.getSource() == vReservation.getButtonPeopleAdd()){
            nPeople = (nPeople >= 0 && nPeople <= 10) ? ++nPeople : nPeople;
            nPeople = (nPeople > 10) ? 10 : nPeople;
            vReservation.getText()[5].setText(String.valueOf(nPeople));
        }
        if (e.getSource() == vReservation.getButtonRoomAdd()){
            ++nRoom;
            vReservation.getText()[6].setText(String.valueOf(nRoom));
        }
        if (e.getSource() == vReservation.getButtonPeopleSubtract()){
            nPeople = (nPeople >= 0 && nPeople <= 10) ? --nPeople : (nPeople);
            nPeople = (nPeople < 0) ? 0 : nPeople;
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
        if(e.getSource() == vReservation.getButtonFinish()){
            vReservation.setVisible(false);
            vPayment.setVisible(true);
        }
        if(e.getSource() == vPayment.getButtonBack()){
            vPayment.setVisible(false);
            vReservation.setVisible(true);
        }
        if(e.getSource() == vSignIn.getTextInput()[0]){
            vSignIn.getTextInput()[0].setBackground(new Color(190, 190, 190));
        }
        if(e.getSource() == vSignIn.getTextInput()[1]){
            vSignIn.getTextInput()[1].setBackground(new Color(190, 190, 190));
        }
        if(e.getSource() == vReservation.getSignOut()){
            vReservation.setVisible(false);
            vSignIn.setVisible(true);
        }
        if(e.getSource() == vSignSystem.getButtonAccept()){
            services.verifyEmailSuccess();
        }
        if(e.getSource() == vSignSystem.getButtonBack()){
            vSignSystem.setVisible(false);
            vSignIn.setVisible(true);
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
        if(e.getSource() == vSignSystem.getButtonAccept()){
            vSignSystem.getButtonAccept().setBackground(new Color(109, 129, 130));
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
        if(e.getSource() == vSignSystem.getButtonAccept()){
            vSignSystem.getButtonAccept().setBackground(new Color(75, 116, 121));
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
