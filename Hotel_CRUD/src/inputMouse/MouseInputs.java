package inputMouse;

import vistas.VPayment;
import vistas.VReservation;
import vistas.VSignIn;
import vistas.VSignSystem;
import service.Services;

import javax.swing.*;
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
    private float total = 0;

    public MouseInputs(VSignSystem vSignSystem, VSignIn vSignIn, VReservation vReservation, VPayment vPayment, Services services) {
        this.vSignSystem = vSignSystem;
        this.vSignIn = vSignIn;
        this.vReservation = vReservation;
        this.vPayment = vPayment;
        this.services = services;

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if(e.getSource() == vSignSystem.getButtonAccept()){
            services.verifyEmailSuccess();
        }
        if(e.getSource() == vSignSystem.getButtonBack()){
            vSignSystem.setVisible(false);
            vSignIn.setVisible(true);
        }
        if(e.getSource() == vSignIn.getButtonRecord()){
            vSignIn.setVisible(false);
            vSignSystem.setVisible(true);
        }
        if(e.getSource() == vSignIn.getButtonLog()){
            services.verifySuccess();
            services.updateTableModel();
        }
        if(e.getSource() == vSignIn.getInputMail()){
            vSignIn.getTextInput()[0].setBackground(new Color(190, 190, 190));
        }
        if(e.getSource() == vSignIn.getInputPass()){
            vSignIn.getTextInput()[1].setBackground(new Color(190, 190, 190));
        }

        if(e.getSource() == vReservation.getButtonEnd()){
            int id= vReservation.getTable().getSelectedRow();
            if(services.verifyAvailable(services.getRoomsByIdClicked(id)) && vReservation.getTable().getSelectedRow() >= 0){

                vReservation.setVisible(false);
                vPayment.setVisible(true);
                total = services.getTotal();
                services.setSummary(services.getRoomsByIdClicked(id));
                vPayment.getButtonPay().setText("Pagar: " + total);
            }
        }
        if(e.getSource() == vReservation.getSignOut()){
            vReservation.setVisible(false);
            vSignIn.setVisible(true);
        }
        if(e.getSource() == vReservation.getTable()){
            int id = vReservation.getTable().getSelectedRow();
            services.getRoomsByIdClicked(id);
        }
        if(e.getSource() == vReservation.getSignOut()){
            services.resetInterfaces();
        }

        if(e.getSource() == vPayment.getButtonBack()){
            vPayment.setVisible(false);
            vReservation.setVisible(true);
        }
        if(e.getSource() == vPayment.getButtonPay()){
            services.endReservation();
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
        if(e.getSource() == vSignSystem.getButtonAccept()){
            vSignSystem.getButtonAccept().setBackground(new Color(109, 129, 130));
        }

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
        if(e.getSource() == vSignSystem.getButtonAccept()){
            vSignSystem.getButtonAccept().setBackground(new Color(75, 116, 121));
        }

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
