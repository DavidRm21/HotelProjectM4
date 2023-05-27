package vistas;

import interfaceWindow.AbstractPanel;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;

public class VSignIn extends AbstractPanel {

    private Font[] font;


    public VSignIn(int text, int button, int font, int textInput) {
        super(text, button, textInput, "assets/HotelmenuResize.jpg");
        this.font = new Font[font];

        this.drawComponents();
   }

    public void drawComponents(){

        font[0] =new Font("Arima Madurai", Font.BOLD, 96);
        font[1] =new Font("Arima Madurai", Font.BOLD, 48);
        font[2] =new Font("Arima Madurai", Font.BOLD, 24);
        font[3] =new Font("Arima Madurai", Font.BOLD, 18);

        drawLabel(3, font[2], "", 140, 79, 1000, 600, Color.WHITE, JLabel.LEFT);
        getText()[3].setBackground(new Color(0, 0, 0, 180));
        getText()[3].setOpaque(true);

        getText()[3].add(drawLabel(0, font[0], "Hotel Cristian", 0, 50, 1000, 170, Color.WHITE, JLabel.CENTER));
        getText()[3].add(drawLabel(1, font[2], "Correo electrónico", 290, 264, 400, 42, Color.WHITE, JLabel.LEFT));
        getText()[3].add(drawLabel(2, font[2], "Contraseña", 290, 372, 400, 42, Color.WHITE, JLabel.LEFT));


        getText()[3].add(drawInputText(0, font[2], "", 290, 306, 400, 50));
        getText()[3].add(drawInputText(1, font[2], "", 290, 404, 400, 50));

        getText()[3].add(drawButton(0, font[2], "Registrar", 290, 510, 147, 48, new Color(28, 151, 18), JLabel.CENTER));
        getText()[3].add(drawButton(1, font[2], "Entrar", 546, 510, 147, 48, new Color(21, 19, 111), JLabel.CENTER));

    }

    public JLabel getButtonRecord() {
        return getButton()[0];
    }

    public JLabel getButtonLog() {
        return getButton()[1];
    }

    public JTextField getInputMail(){
        return getTextInput()[0];
    }
    public JTextField getInputPass(){
        return getTextInput()[1];
    }



}
