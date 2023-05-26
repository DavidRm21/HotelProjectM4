package interfaceWindow;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

public class VSignSystem extends AbstractPanel{

    private Font[] font;

    public VSignSystem(int text, int button, int font,  int inputText) {
        super(text, button, inputText, "assets/HotelmenuResize.jpg");
        this.setSize(731, 371);
        this.font = new Font[font];

        drawComponents();

    }

    public void drawComponents(){

        font[0] =new Font("Arima Madurai", Font.BOLD, 96);
        font[1] =new Font("Arima Madurai", Font.BOLD, 48);
        font[2] =new Font("Arima Madurai", Font.BOLD, 24);
        font[3] =new Font("Arima Madurai", Font.BOLD, 18);

        drawLabel(10, font[2], "", 140, 79, 1000, 600, Color.WHITE, JLabel.LEFT);
        getText()[10].setBackground(new Color(0, 0, 0, 180));
        getText()[10].setOpaque(true);

        getText()[10].add(drawLabel(0, font[0], "Registro", 0, 20, 1000, 170, Color.WHITE, JLabel.CENTER));
        getText()[10].add(drawLabel(1, font[3], "Nombre: ", 190, 160, 300, 40, Color.WHITE, JLabel.LEFT));
        getText()[10].add(drawLabel(2, font[3], "Apellido: ", 500, 160, 400, 40, Color.WHITE, JLabel.LEFT));
        getText()[10].add(drawLabel(3, font[3], "C.C: ", 190, 250, 400, 40, Color.WHITE, JLabel.LEFT));
        getText()[10].add(drawLabel(4, font[3], "Teléfono: ", 500, 250, 400, 40, Color.WHITE, JLabel.LEFT));
        getText()[10].add(drawLabel(5, font[3], "Correo electrónico: ", 290, 340, 400, 40, Color.WHITE, JLabel.LEFT));
        getText()[10].add(drawLabel(7, font[3], "Contraseña: ", 290, 430, 400, 40, Color.WHITE, JLabel.LEFT));
        getText()[10].add(drawLabel(8, font[3], "", 30, 20, 60, 60, Color.WHITE, JLabel.LEFT));
        getText()[10].add(drawLabel(9, font[2], "Aceptar", 800, 500, 150, 50, Color.WHITE, JLabel.CENTER));
        getButtonAccept().setBackground(new Color(75, 116, 121));
        getButtonAccept().setOpaque(true);
        ImageIcon icon = new ImageIcon("assets/atras1.png");
        getButtonBack().setIcon(icon);

        getText()[10].add(drawInputText(0, font[2], "", 190, 200, 300, 40));
        getText()[10].add(drawInputText(1, font[2], "", 500, 200, 300, 40));
        getText()[10].add(drawInputText(2, font[2], "", 190, 290, 300, 40));
        getText()[10].add(drawInputText(3, font[2], "", 500, 290, 300, 40));
        getText()[10].add(drawInputText(4, font[2], "", 290, 380, 400, 40));
        getText()[10].add(drawInputText(5, font[2], "", 290, 470, 400, 40));

    }

    public JTextField getTextName(){
        return getTextInput()[0];
    }
    public JTextField getTextLastName(){
        return getTextInput()[1];
    }
    public JTextField getTextCC(){
        return getTextInput()[2];
    }
    public JTextField getTextPhone(){
        return getTextInput()[3];
    }
    public JTextField getTextEmail(){
        return getTextInput()[4];
    }
    public JTextField getTextPassword(){
        return getTextInput()[5];
    }

    public JLabel getButtonAccept(){
        return getText()[9];
    }

    public JLabel getButtonBack(){
        return getText()[8];
    }



}
