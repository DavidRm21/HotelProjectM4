package interfaceWindow;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;


public class VPayment extends AbstractPanel {
    private Font[] font;
    private JTextField[] textInput;

    public VPayment(int text, int button, int font, int textInput) {
        super(text, button, "assets/HotelFinalResize.jpg");
        this.font = new Font[font];
        this.textInput = new JTextField[textInput];

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

        getText()[0].add(drawInputText(0, font[2], 225, 120, 630, 40));
        getText()[0].add(drawInputText(1, font[2], 225, 200, 266, 40));
        getText()[0].add(drawInputText(2, font[2], 225, 280, 266, 40));
        getText()[0].add(drawInputText(3, font[2], 590, 200, 266, 40));
        getText()[0].add(drawInputText(4, font[2], 590, 280, 266, 40));
        getText()[0].add(drawInputText(5, font[2], 225, 360, 630, 40));

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

    public JLabel getButtonPay(){
        return getText()[1];
    }

    public JLabel getButtonBack(){
        return getText()[3];
    }

    public JTextField getCardNumber(){
        return textInput[0];
    }

    public JTextField getCardDate(){
        return textInput[1];
    }

    public JTextField getCardCCV(){
        return textInput[3];
    }

    public JTextField getNameCard(){
        return textInput[2];
    }

    public JTextField getLastNameCard(){
        return textInput[4];
    }




}
