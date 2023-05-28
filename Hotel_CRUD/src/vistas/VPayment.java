package vistas;

import interfaceWindow.AbstractPanel;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;

public class VPayment extends AbstractPanel {
    private Font[] font;
    private JTextArea textServices;

    public VPayment(int text, int button, int font, int textInput) {
        super(text, button, textInput, "assets/HotelFinalResize.jpg");
        this.font = new Font[font];

        drawComponents();

    }

    public void drawComponents(){

        font[0] =new Font("Arima Madurai", Font.BOLD, 96);
        font[1] =new Font("Arima Madurai", Font.BOLD, 48);
        font[2] =new Font("Arima Madurai", Font.BOLD, 24);
        font[3] =new Font("Arima Madurai", Font.BOLD, 18);

        drawLabel(0, font[2], "", 88, 70, 1100, 579, Color.WHITE, JLabel.CENTER);
        getText()[0].setBackground(new Color(0, 0, 0, 180));
        getText()[0].setOpaque(true);

        getText()[0].add(drawLabel(1, font[2], "Habitación: ", 170, 150, 266, 40, Color.WHITE, JLabel.LEFT));
        getText()[0].add(drawLabel(2, font[2], "", 370, 150, 266, 40, Color.WHITE, JLabel.LEFT));
        getText()[0].add(drawLabel(3, font[2], "Tipo: ", 630, 150, 266, 40, Color.WHITE, JLabel.LEFT));
        getText()[0].add(drawLabel(4, font[2], "", 770, 150, 266, 40, Color.WHITE, JLabel.LEFT));
        getText()[0].add(drawLabel(5, font[2], "Precio: ", 170, 200, 266, 40, Color.WHITE, JLabel.LEFT));
        getText()[0].add(drawLabel(6, font[2], "", 370, 200, 266, 40, Color.WHITE, JLabel.LEFT));
        getText()[0].add(drawLabel(7, font[2], "Capacidad: ", 630, 200, 266, 40, Color.WHITE, JLabel.LEFT));
        getText()[0].add(drawLabel(8, font[2], "", 770, 200, 266, 40, Color.WHITE, JLabel.LEFT));
        getText()[0].add(drawLabel(9, font[2], "Fecha de inicio: ", 170, 250, 266, 40, Color.WHITE, JLabel.LEFT));
        getText()[0].add(drawLabel(10, font[2], "", 370, 250, 266, 40, Color.WHITE, JLabel.LEFT));
        getText()[0].add(drawLabel(11, font[2], "Fecha final: ", 170, 300, 266, 40, Color.WHITE, JLabel.LEFT));
        getText()[0].add(drawLabel(12, font[2], "", 370, 300, 266, 40, Color.WHITE, JLabel.LEFT));
        getText()[0].add(drawLabel(13, font[2], "Servicios: ", 630, 250, 266, 40, Color.WHITE, JLabel.LEFT));
        getText()[0].add(drawLabel(14, font[2], "", 630, 350, 300, 100, Color.WHITE, JLabel.LEFT));
        getText()[0].add(drawLabel(15, font[2], "", 50, 50, 50, 50, Color.WHITE, JLabel.LEFT));

        textServices = new JTextArea();
        textServices.setBounds(630, 300, 200, 100);
        textServices.setText("");
        textServices.setBackground(new Color(0,0,0,0));
        textServices.setForeground(Color.WHITE);
        textServices.setFont(new Font("Arima Madurai", Font.BOLD, 14));
        textServices.setEditable(false);
        getText()[0].add(textServices);

        drawLabel(16, font[2], "Pagar: $0.0", 375, 460, 350, 70, Color.WHITE, JLabel.CENTER);
        getButtonPay().setBackground(new Color(144, 142, 249, 200));
        getButtonPay().setOpaque(true);
        getText()[0].add(getText()[16]);

        drawLabel(17, font[1], "Resumen de la reserva", 0, 40, 1100, 70, Color.WHITE, JLabel.CENTER);
        getText()[0].add(getText()[17]);

        drawLabel(3, font[3], "", 40, 30, 50, 50, Color.WHITE, JLabel.CENTER);
        ImageIcon icon = new ImageIcon("assets/atras1.png");
        getButtonBack().setIcon(icon);
        getText()[0].add(getButtonBack());
    }

    public JLabel getButtonPay(){
        return getText()[16];
    }

    public JLabel getButtonBack(){
        return getText()[15];
    }
    public JLabel getLabelRoom(){
        return getText()[2];
    }
    public JLabel getLabelType(){
        return getText()[4];
    }
    public JLabel getLabelPrice(){
        return getText()[6];
    }

    public JLabel getLabelCapability(){
        return getText()[8];
    }
    public JLabel getLabelStartDate(){
        return getText()[10];
    }
    public JLabel getLabelEndDate(){
        return getText()[12];
    }
    public JTextArea getTextServices(){
        return textServices;
    }


}
