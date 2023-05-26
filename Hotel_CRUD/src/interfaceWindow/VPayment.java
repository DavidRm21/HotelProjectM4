package interfaceWindow;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;


public class VPayment extends AbstractPanel {
    private Font[] font;

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

        getText()[0].add(drawInputText(0, font[2], "", 225, 120, 630, 40));
        getText()[0].add(drawInputText(1, font[2], "", 225, 200, 266, 40));
        getText()[0].add(drawInputText(2, font[2], "", 225, 280, 266, 40));
        getText()[0].add(drawInputText(3, font[2], "", 590, 200, 266, 40));
        getText()[0].add(drawInputText(4, font[2], "", 590, 280, 266, 40));
        getText()[0].add(drawInputText(5, font[2], "", 225, 360, 630, 40));

        drawLabel(1, font[1], "Pagar: $5000", 375, 460, 350, 70, Color.WHITE, JLabel.CENTER);
        getButtonPay().setBackground(new Color(144, 142, 249, 200));
        getButtonPay().setOpaque(true);
        getText()[0].add(getText()[1]);

        drawLabel(2, font[3], "Selecciona el método de pago", 60, 20, 350, 70, Color.WHITE, JLabel.CENTER);
        getText()[0].add(getText()[2]);

        drawLabel(3, font[3], "", 40, 30, 50, 50, Color.WHITE, JLabel.CENTER);
        ImageIcon icon = new ImageIcon("assets/atras1.png");
        getButtonBack().setIcon(icon);
        getText()[0].add(getButtonBack());


    }

    public JLabel getButtonPay(){
        return getText()[1];
    }

    public JLabel getButtonBack(){
        return getText()[3];
    }

    public JTextField getCardNumber(){
        return getTextInput()[0];
    }

    public JTextField getCardDate(){
        return getTextInput()[1];
    }

    public JTextField getCardCCV(){
        return getTextInput()[3];
    }

    public JTextField getNameCard(){
        return getTextInput()[2];
    }

    public JTextField getLastNameCard(){
        return getTextInput()[4];
    }




}
