package interfaceWindow;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;

public class VSignIn extends AbstractPanel {


    private JTextField[] textInput;
    private Font[] font;


    public VSignIn(int text, int button, int font, int textInput) {
        super(text, button, "assets/HotelmenuResize.jpg");
        this.textInput = new JTextField[textInput];
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

        getText()[3].add(drawLabel(0, font[0], "Hotel Risdamel", 0, 59, 1000, 170, Color.WHITE, JLabel.CENTER));
        getText()[3].add(drawLabel(1, font[2], "Correo electrónico", 290, 264, 400, 42, Color.WHITE, JLabel.LEFT));
        getText()[3].add(drawLabel(2, font[2], "Contraseña", 290, 372, 400, 42, Color.WHITE, JLabel.LEFT));


        getText()[3].add(drawInputText(0, font[2], 290, 306, 400, 50));
        getText()[3].add(drawInputText(1, font[2], 290, 404, 400, 50));

        getText()[3].add(drawButton(0, font[2], "Registrar", 290, 510, 147, 48, new Color(28, 151, 18), JLabel.CENTER));
        getText()[3].add(drawButton(1, font[2], "Entrar", 546, 510, 147, 48, new Color(21, 19, 111), JLabel.CENTER));
    }

    public JTextField drawInputText(int pos, Font font, int x, int y, int width, int height){
        textInput[pos] = new JTextField();
        textInput[pos].setBounds(x, y, width, height);
        textInput[pos].setFont(font);
        textInput[pos].setBorder(new EmptyBorder(0, 20, 0, 0));
        textInput[pos].setBackground(new Color(190, 190, 190));
        textInput[pos].setOpaque(true);
        this.add(textInput[pos]);
        textInput[pos].setVisible(true);
        return textInput[pos];
    }

    public JTextField[] getTextInput() {
        return textInput;
    }

    public JLabel getButtonRecord() {
        return getButton()[0];
    }

    public JLabel getButtonLog() {
        return getButton()[1];
    }


}
